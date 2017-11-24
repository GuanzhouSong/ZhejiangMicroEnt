/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.dtinfo.service.ILicDeptService;
import com.icinfo.cs.system.dto.SysDepartDto;
import com.icinfo.cs.system.mapper.SysUserCheckRecordMapper;
import com.icinfo.cs.system.mapper.SysUserMapper;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserCheckRecord;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserCheckRecordService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:   用户验证记录 SYS_USER_CHECK_RECORD 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月20日
 */
@Service
public class SysUserCheckRecordServiceImpl extends MyBatisServiceSupport implements ISysUserCheckRecordService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserCheckRecordServiceImpl.class);
    @Autowired
    private SysUserCheckRecordMapper sysUserCheckRecordMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;

    @Autowired
    private ISysDepartService sysDepartService;

    @Autowired
    private ILicDeptService licDeptService;

    @Value("${spring.shiro.hash.iterations}")
    private int iterations;

    /**
     * 检查当前用户是否经过验证
     *
     * @param userName
     * @return
     * @author ZhuDefeng
     * @date 2016-12-20
     */
    @Override
    public boolean isChecked(String userName) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setUsername(userName);
        List<SysUser> sysUserList=sysUserMapper.select(sysUser);
        if(sysUserList!=null&&sysUserList.size()>0){
            SysUser rltSysUser=sysUserList.get(0);
            if(StringUtil.isBlank(rltSysUser.getIsCheck())||"0".equals(rltSysUser.getIsCheck())){
                return false;
            }else if("1".equals(rltSysUser.getIsCheck())){
                return true;
            }
        }
        return false;
    }

    /**
     * 验证用户
     *
     * @param sysUserCheckRecord
     * @return
     * @author ZhuDefeng
     * @date 2016-12-20
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String,String> checkUser(SysUserCheckRecord sysUserCheckRecord) throws Exception {
        Map<String,String> optRlt=new HashMap<>();
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        SimpleHash hash = new SimpleHash("md5", sysUserCheckRecord.getUserPassword(), salt, iterations);
        sysUserCheckRecord.setUserPassword(hash.toHex());

        SysUserCheckRecord condition=new SysUserCheckRecord();
        condition.setUserUsername(sysUserCheckRecord.getUserUsername());
        condition.setCheckCode(sysUserCheckRecord.getCheckCode());
        SysUserCheckRecord sysUserCheckRecordTmp=sysUserCheckRecordMapper.selectOne(condition);
        if(sysUserCheckRecordTmp!=null){
            if("1".equals(sysUserCheckRecordTmp.getIsBind())){
                optRlt.put("isBind","抱歉，该用户已经成功验证，不能重复验证！");
                return optRlt;
            }
            if(DateUtil.getBetweenDaysToMut(sysUserCheckRecordTmp.getUserCreateTime(), new Date()) > 3){
                optRlt.put("smsCodeError","您输入的手机验证码已过期，请重新获取！(有效期为3分钟)");
                return optRlt;
            }
            sysUserCheckRecord.setId(sysUserCheckRecordTmp.getId());
            sysUserCheckRecord.setIsBind("1");
            sysUserCheckRecordMapper.updateByPrimaryKeySelective(sysUserCheckRecord);
        }else{
            optRlt.put("smsCodeError", "您输入的验证码有误，请重新输入！");
            return optRlt;
        }
        SysUser sysUser=new SysUser();
        sysUser.setPasswordSalt(salt);
        sysUser.setTelPhone(sysUserCheckRecord.getTelPhone());
        sysUser.setPassword(hash.toHex());
        sysUser.setIsCheck("1");
        sysUser.setDeptName(sysUserCheckRecord.getDeptName());
        Example example=new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", sysUserCheckRecord.getUserUsername())
        .andEqualTo("userType", DBAuthorConstants.USER_TYPE_SYN); 
        sysUserMapper.updateByExampleSelective(sysUser,example);
        optRlt.put("status","success");
        return optRlt;
    }

    /**
     * 校验短信验证码
     *
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public boolean ckSMSCode() throws Exception {
        return false;
    }

    /**
     * 根据用户名来查询验证记录
     *
     * @param username
     * @return
     * @author ZhuDefeng
     */
    @Override
    public SysUserCheckRecord selectByUserName(String username) {
        SysUserCheckRecord sysUserCheckRecord=new SysUserCheckRecord();
        sysUserCheckRecord.setUserUsername(username);
        return sysUserCheckRecordMapper.selectOne(sysUserCheckRecord);
    }


    /**
     * 保存校验记录
     *
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public int saveRecord(SysUserCheckRecord sysUserCheckRecord,String optType) throws Exception {
        int rlt=0;
        if("add".equals(optType)){
            SysUser sysUser=sysUserService.selectByLoginName(sysUserCheckRecord.getUserUsername(), DBAuthorConstants.USER_TYPE_SYN);
            SysDepart sysDepart=sysDepartService.doGetByCode(sysUser.getDeptCode());
            sysDepart.setOrgCoding(sysUser.getDeptCode());
            SysDepartDto sysDepartDto=deptDutycodeRefService.getDutyCodesBySysDept(sysDepart);
            if(sysDepartDto!=null){
                sysUserCheckRecord.setDutyCodeNamesOld(sysDepartDto.getDutyNames()); 
                sysUserCheckRecord.setLicItemNamesOld(doGetLicItemNames(StringUtil.doSplitStringToSqlFormat(sysDepart.getAdcode(),",")));
            }
            rlt=sysUserCheckRecordMapper.insert(sysUserCheckRecord);
        }
        if("mod".equals(optType)){
            rlt=sysUserCheckRecordMapper.updateByPrimaryKeySelective(sysUserCheckRecord);
        }
        return rlt;
    }

    /**
     *根据AdCode来查询审批事项（多个审批事项用逗号隔开）
     * @author ZhuDefeng
     * @date 2016-12-28
     * @param adCode
     * @return
     * @throws Exception
     */
    private String doGetLicItemNames(String adCode)throws Exception{
        String rlt="";
        try{
            List<LicDeptDto> licDeptDtos=licDeptService.queryLicDeptByAdCode(adCode);
            StringBuilder stringBuilder=new StringBuilder();
            for(LicDeptDto licDeptDto:licDeptDtos){
                stringBuilder.append(licDeptDto.getExaName()).append(",");
            }
            if (StringUtil.isNotBlank(stringBuilder) ) {
                rlt = stringBuilder.substring(0, stringBuilder.length() - 1);
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("根据adcode查询审批事项信息出现错误:"+e.getMessage());
        }
        return rlt;
    }

    /**
     * 判断手机号码是否已经被注册
     *
     * @param telPhone
     * @param userType
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public boolean isExistTelPhone(String telPhone, String userType) throws Exception {
        Example example=new Example(SysUserCheckRecord.class);
        example.createCriteria().andEqualTo("telPhone",telPhone).andEqualTo("userType",userType);
        List<SysUserCheckRecord> sysUserCheckRecords = sysUserCheckRecordMapper.selectByExample(example);
        if(sysUserCheckRecords!=null&&sysUserCheckRecords.size()>0){
            return true;
        }
        return false;
    }

    /**
     * 
     * 描述   获取所有数据
     * @author 赵祥江
     * @date 2016年12月22日 下午7:51:27 
     * @param 
     * @return List<SysUserCheckRecord>
     * @throws
     */
	@Override
	public List<SysUserCheckRecord> selectAllSysUserCheckRecord()
			throws Exception { 
		return sysUserCheckRecordMapper.selectAll();
	}
}