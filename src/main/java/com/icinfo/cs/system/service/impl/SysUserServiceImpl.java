/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.mapper.SysUserMapper;
import com.icinfo.cs.system.mapper.SysUserRoleMapper;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserCheckRecord;
import com.icinfo.cs.system.model.SysUserRole;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserCheckRecordService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:  系统用户业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service("sysUserService")
public class SysUserServiceImpl extends MyBatisServiceSupport implements ISysUserService {

    private final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Value("${spring.shiro.hash.iterations}")
    private int iterations;
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;
    
    @Autowired
    private ISysDepartService sysDepartService;
    
    @Autowired
    private IDepartMentService departMentService;
    
    @Autowired
    private ISysUserCheckRecordService sysUserCheckRecordService;
    /**
     * 参数转换
     *
     * @param userId
     * @param roles
     * @return
     * @throws Exception
     */
    private List<SysUserRole> parseConvert(String userId, String[] roles) throws Exception {
        List<SysUserRole> rolesList = new ArrayList<SysUserRole>();
        for (String roleId : roles) {
            SysUserRole userRole = new SysUserRole();
            userRole.setRoleId(roleId);
            userRole.setUserId(userId);
            rolesList.add(userRole);
        }
        return rolesList;
    }

    /**
     * 增加系统用户
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysUser sysUser, String[] roles) throws Exception {
    	sysUser.setId(StringUtil.uuid());
        sysUser.setCreateTime(DateUtils.getSysDate());
        sysUser.setSetDate(DateUtils.getSysDate());
        if (exists(sysUser.getUsername(),sysUser.getUserType())) {
            throw new BusinessException("用户名" + sysUser.getUsername() + "已经存在");
        }
        //密码MD5
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            //密码MD5
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
            sysUser.setPassword(hash.toHex());
            //sysUser.setPassword(Md5Utils.GetMD5Code(sysUser.getPassword()));
        }
        if (sysUserMapper.insert(sysUser) <= 0) {
            throw new BusinessException("创建系统用户失败!");
        }
        if (roles != null && roles.length > 0) {
            //保存用户角色
            sysUserRoleService.insert(parseConvert(sysUser.getId(), roles));
        }
        return 1;
    }

    /**
     * 验证用户名是否存在
     *
     * @param username
     * @param userType 用户类型（1：警示；2：协同）
     * @return
     * @throws Exception
     */
    private boolean exists(String username,String userType) throws Exception {
        return selectByLoginName(username,userType)!=null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(SysUser sysUser, String[] roles) throws Exception {
        if (sysUser == null || isEmpty(sysUser.getId())) {
            return 0;
        }
        sysUser.setUsername(null);
//        sysUser.setLastLoginTime(DateUtils.getSysDate());
        //删除旧角色
        sysUserRoleService.deleteByUserId(sysUser.getId());

        if (roles != null && roles.length > 0) {
            //保存用户角色
            sysUserRoleService.insert(parseConvert(sysUser.getId(), roles));
        }
        sysUser.setSetDate(DateUtils.getSysDate());
        //密码MD5(使用shiro默认MD5实现)
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
            sysUser.setPassword(hash.toHex());
        } else {
            sysUser.setPassword(null);
        }
        //更新用户信息
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 通过主键删除用户
     *
     * @param primaryKey
     * @return
     * @throws Exception
     */
    @Override
    public int deleteByPrimaryKey(String primaryKey) throws Exception {
        return sysUserMapper.deleteByPrimaryKey(primaryKey);
    }

    /**
     * 系统用户列表
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUserDto> queryPage(PageRequest request) throws Exception {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> maps = request.getParams();
        if(maps.containsKey("dutyDeptCodes")&&StringUtil.isNotEmpty(maps.get("dutyDeptCodes").toString())){
            String[] dutyDeptCodes=maps.get("dutyDeptCodes").toString().split(",");
            if(dutyDeptCodes.length>0)
            maps.put("dutyDeptCodes",dutyDeptCodes);
        }
        List<SysUserDto> sysUserList=null;
        if ("1".equals(maps.get("userType").toString())) {
            sysUserList=sysUserMapper.selectRegUser(maps);

        }
        if ("2".equals(maps.get("userType").toString())) {
            sysUserList=sysUserMapper.selectSynUser(maps);
        }
        
        if ("3".equals(maps.get("userType").toString())) {//小微监测
            sysUserList=sysUserMapper.selectSmentUser(maps);
        }
        selectUserSetPersonName(sysUserList);
        return sysUserList;
    }


    /**
     * 通过ID加载指定的用户信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysUser select(String id) throws Exception {
        if (isEmpty(id)) {
            return null;
        }
        return sysUserMapper.selectByPrimaryKey(id);
    }
    
    /**
     * 通过ID加载指定的用户信息
     *
     * @param id
     * @return
     */
    @Override
    public String selectOrgCode(String uid) throws Exception {
    	SysUser sysUserRelate = this.select(uid);
		if(sysUserRelate != null && StringUtils.isNotEmpty(sysUserRelate.getUserType()) && StringUtils.isNotEmpty(sysUserRelate.getDeptCode())){
			String deptCode = sysUserRelate.getDeptCode();
			if("2".equals(sysUserRelate.getUserType())){
				SysDepart sysDepart = sysDepartService.doGetByCode(deptCode);
				String adCode = sysDepart.getAdcode();
				return adCode.substring(0, 8);
			}else if("1".equals(sysUserRelate.getUserType())){
				DepartMent departMent = departMentService.selectOne(deptCode);
				String code = departMent.getDeptCode();
				return code;
			}
		}
    	return null;
    }

    /**
     * 加载指定用户名的用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public SysUser selectByUserName(String username) throws Exception {
        if (isEmpty(username)) {
            return null;
        }
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        SysUserDto sysUserDto=(SysUserDto)attrs.getRequest().getSession().getAttribute(Constants.SESSION_SYS_USER);
        SysUserDto sysUserDto4ck=(SysUserDto)attrs.getRequest().getSession().getAttribute(Constants.SESSION_SYS_USER_KEY_FOR_CK);
        Example example = new Example(SysUser.class);
        if(sysUserDto!=null||sysUserDto4ck!=null){
            example.createCriteria().andEqualTo("username", username).andEqualTo("userType", sysUserDto==null?sysUserDto4ck.getUserType():sysUserDto.getUserType());
        }else{
            example.createCriteria().andEqualTo("username", username);
        }
        List<SysUser> list = sysUserMapper.selectByExample(example);
        if (list.size() > 0 && StringUtils.isNotBlank(list.get(0).getId())) {
            return list.get(0);
        }
        return null;
    }
    


    /**
     * 描述：根据部门编码查询用户
     *
     * @param deptId
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-09-23
     */
    @Override
    public List<SysUser> selectUserByDeptId(String deptId) throws Exception {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("deptCode", deptId);
        List<SysUser> list = sysUserMapper.selectByExample(example);
        return list;
    }

    /**
     * 描述：根据管辖单位查询有效用户
     *
     * @param deptCode
     * @return
     * @throws Exception
     * @author liuhq
     * @date 2016-10-26
     */
    @Override
    public List<SysUser> getsliceManByDept(String deptCode) throws Exception {
        if (StringUtil.isEmpty(deptCode)) return null;
        SysUser sysUser = new SysUser();
        sysUser.setDeptCode(deptCode);
        sysUser.setStatus("1");
        List<SysUser> list = sysUserMapper.select(sysUser);
        return list;
    }

    /**
     * 描述：根据用户UID查询用户信息
     *
     * @param userUID
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-12
     */
    @Override
    public SysUserDto selectUserByUId(String userUID) throws Exception {
        return sysUserMapper.selectUserByUId(userUID);
    }


    /**
     * 描述：根据协同用户UID查询用户信息
     *
     * @param userUID
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-12
     */
    @Override
    public SysUserDto selectSynUserByUId(String userUID) throws Exception {
        SysUserDto sysUserDto=sysUserMapper.selectSynUserByUId(userUID);
        if(sysUserDto!=null){//如果是协同系统，取出当前用户所具有的职能部门代码，用逗号隔开
            String dutyDeptCodes=deptDutycodeRefService.doSelectDutyCodesByDeptCode(sysUserDto.getDeptCode());
            sysUserDto.setDutyDeptCodes(dutyDeptCodes);
        }
        return sysUserDto;
    }

    /**
     * 描述：启用OR禁用用户
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-13
     */
    @Override
    public int disOrEnAbleUser(String id, String status) throws Exception {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(id);
        sysUser.setStatus(status);
        return sysUserMapper.updateByPrimaryKey(sysUser);
    }


    /**
     * 将协同用户“是否验证”改成否，让用户可以在协同登录的时候重新验证用户信息
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-09
     */
    @Override
    public int revalidUser(String id) throws Exception {
        if(StringUtil.isBlank(id) )
        return 0; 
        SysUser sysUser=select(id);
        if(sysUser!=null){
        	String userName=sysUser.getUsername();
            SysUserCheckRecord sysUserCheckRecordTmp = sysUserCheckRecordService.selectByUserName(userName); 
            SysUserCheckRecord sysUserCheckRecord=new SysUserCheckRecord();
            sysUserCheckRecord.setIsBind("0");
            sysUserCheckRecord.setId(sysUserCheckRecordTmp==null||StringUtil.isBlank(sysUserCheckRecordTmp.getId())?"00000":sysUserCheckRecordTmp.getId() );
            sysUserCheckRecordService.saveRecord(sysUserCheckRecord, "mod"); 
        } 
        return sysUserMapper.revalidUser(id);
    }

    /**
     * 查询所有的用户
     *
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-31
     */
    @Override
    public List<SysUser> selectAll() throws Exception {
        return sysUserMapper.selectAll();
    }


    /**
     * 描述：根据部门Code查询查询用户列表
     *
     * @param deptCode
     * @return
     * @throws Exception
     */
    @Override
    public List<SysUser> doGetSysUserByDeptCode(String deptCode) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setDeptCode(deptCode);
        return sysUserMapper.select(sysUser);
    }

    /**
     * 描述：检查当前登陆用户的原始密码是否输入正确
     *
     * @param psw
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public boolean doCheckPsw(final String psw,final SysUserDto sysUserDto) throws Exception {
        String salt=sysUserDto.getPasswordSalt();
        SimpleHash hash = new SimpleHash("md5", psw, salt, iterations);
        String pswMd5=hash.toHex();
        return StringUtils.equalsIgnoreCase(pswMd5, sysUserDto.getPassword());
    }

    /**
     * 描述：修改密码
     * @author ZhuDefeng
     * @param psw
     * @return
     * @throws Exception
     */
    @Override
    public int doModLoginUserPwd(final String psw,final SysUserDto sysUserDto) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setId(sysUserDto.getId());
        //密码MD5(使用shiro默认MD5实现)
        if (StringUtils.isNotBlank(psw)) {
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", psw, salt, iterations);
            sysUser.setPassword(hash.toHex());
        } else {
            sysUser.setPassword(null);
        }
        //更新用户信息
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 描述：更新当前登陆用户的最后登陆时间
     * @param userId 登录用户ID
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-11-20
     */
    @Override
    public int modLastLoginTime(String userId) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setId(userId);
        sysUser.setLastLoginTime(new Date());
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    /**
     * 根据登录名来查询时候用户是否存在
     *
     * @param loginName
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-21
     */
    @Override
    public SysUser selectByLoginName(String loginName,String userType) throws Exception {
        Map<String,Object> qryMap=new HashMap<>();
        qryMap.put("loginName",loginName);
        qryMap.put("userType",userType);
        return sysUserMapper.selectByLoginNameAndUserType(qryMap);
    }

    /**
     * 根据登录名来查询时候用户是否存在
     *
     * @param telPhone
     * @param userType
     * @return 是否存在
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-23
     */
    @Override
    public boolean ckTelPhone(String telPhone,String userType) throws Exception {
        SysUser sysUser=new SysUser();
        sysUser.setTelPhone(telPhone);
        sysUser.setUserType(userType);
        sysUser.setStatus("1");
        if(StringUtil.equals(userType, DBAuthorConstants.USER_TYPE_SYN)){
            sysUser.setIsCheck("1");
        }
        List<SysUser> sysUserList=sysUserMapper.select(sysUser);
        if(sysUserList!=null&&sysUserList.size()>0){
            return true;
        }
        return false;
    }

    /**
     * 查询设置人的真实姓名
     * @author ZhuDefeng
     * @date 2017-01-14
     * @param sysUserList
     * @throws Exception
     */
    private void selectUserSetPersonName(List<SysUserDto> sysUserList) throws Exception{
        for (SysUserDto sysUserDto:sysUserList){
            SysUser sysUserSetPerson=select(sysUserDto.getUserSetPerson());
            sysUserDto.setUserSetPerson(sysUserSetPerson==null?"未知":sysUserSetPerson.getRealName());
        }
    }

    /**
     * 为勾选的用户批量设置岗位角色
     *
     * @param userIds
     * @param roleIds
     * @param setUser
     * @author ZhuDefeng
     * @date 2017-01-18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doBatchSetUsersRoles(String userIds, String roleIds, String type,SysUserDto setUser) throws Exception{
        String[] userIDArr=userIds.split(",");
        String[] roleIDArr=roleIds.split(",");
        for (String userId:userIDArr){
            addOrDelUserRole(userId,roleIDArr,type,setUser);
        }
    }

    /**
     * 添加或者删减用户的角色
     * @param userId
     * @param roleIDArr
     * @param type
     * @param setUser
     * @throws Exception
     */
    private void addOrDelUserRole(String userId, String[] roleIDArr, String type, SysUserDto setUser) throws Exception{
        for(String roleId:roleIDArr){
            SysUserRole sysUserRole=new SysUserRole();
            sysUserRole.setRoleId(roleId);
            sysUserRole.setUserId(userId);
            if("add".equals(type)){
                if(sysUserRoleMapper.select(sysUserRole)==null||sysUserRoleMapper.select(sysUserRole).size()==0){
                    sysUserRoleService.insert(sysUserRole);
                }
            }else{
                sysUserRoleService.deleteBySysUserRole(sysUserRole);
            }
        }
    }

    /**
     * 
     * 描述   根据主键uid 和系统类型 userType更新
     * @author  赵祥江
     * @date 2017年6月5日 下午2:27:29 
     * @param  
     * @throws
     */
	@Override
	public int updateSysUserByUidAndUserType(SysUser sysUser) throws Exception {
		if(StringUtil.isNotBlank(sysUser.getId())){
			Example example = new Example(SysUser.class);
			example.createCriteria().andEqualTo("id", sysUser.getId())
			.andEqualTo("userType", sysUser.getUserType());
			//密码MD5(使用shiro默认MD5实现)
	        if (StringUtils.isNotBlank(sysUser.getPassword())) {
	            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
	            sysUser.setPasswordSalt(salt);
	            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
	            sysUser.setPassword(hash.toHex());
	        } else {
	            sysUser.setPassword(null);
	        }
			return	sysUserMapper.updateByPrimaryKeySelective(sysUser);
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   统一用户保存
	 * @author  赵祥江
	 * @date 2017年6月13日 上午8:48:36 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertUnifiedUser(SysUser sysUser) throws Exception {
        sysUser.setCreateTime(DateUtils.getSysDate());
        sysUser.setSetDate(DateUtils.getSysDate());
       /* if (exists(sysUser.getUsername(),sysUser.getUserType())) {
           return 0;
        }*/
        //密码MD5
        if (StringUtils.isNotBlank(sysUser.getPassword())) {
            //密码MD5
            String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
            sysUser.setPasswordSalt(salt);
            SimpleHash hash = new SimpleHash("md5", sysUser.getPassword(), salt, iterations);
            sysUser.setPassword(hash.toHex());
        } 
		return sysUserMapper.insert(sysUser);
	}

	/**
	 * 
	 * 描述   根据不同参数查询用户信息
	 * @author  赵祥江
	 * @date 2017年9月5日 下午2:46:11 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SysUser> selectSysUser(Map<String, String> parmMap)
			throws Exception {
		Example example = new Example(SysUser.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (!parmMap.isEmpty()) {
			for (Map.Entry<String, String> entry : parmMap.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return sysUserMapper.selectByExample(example);
	}

	/**
     * 
     * 描述   根据用户名和系统类型查询
     * @author 赵祥江
     * @date 2017年9月7日 下午4:35:33 
     * @param 
     * @return List<SysUser>
     * @throws
     */
	@Override
	public List<SysUser> selectSysUserListByLoginNameAndUserType(
			String loginName,String userType) throws Exception {
		SysUser sysUser=new SysUser();
		sysUser.setUsername(loginName);
		sysUser.setUserType(userType); 
        return sysUserMapper.select(sysUser);
	} 
	
	
	/**
	 * 
	 * 描述: 根绝用户名可解密密码查询用户
	 * @auther gaojinling
	 * @date 2017年9月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SysUserDto> selectListByUserPasswordKey(String loginName,String userType,String status,String userPasswordKey) throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("loginName", loginName);
        map.put("userType", userType);
        map.put("status", status);
        map.put("userPasswordKey", userPasswordKey);
		return sysUserMapper.selectListByUserPasswordKey(map);
	}

	/**
	 * 
	 * 描述   根据用户名或手机号查询用户信息
	 * @author  赵祥江
	 * @date 2017年10月23日 下午5:27:51 
	 * @param  
	 * @throws
	 */
	@Override
	public List<SysUser> selectSysUserListByLoginNameOrTelPhoneAndUserType(
			String loginName,String userStatus,  String userType)
			throws Exception {
		    Map<String, Object> qryMap = new HashMap<String, Object>();
		    qryMap.put("loginName", loginName);
		    qryMap.put("userStatus", userStatus); 
		    qryMap.put("userType", userType);  
		return sysUserMapper.selectSysUserListByLoginNameOrTelPhoneAndUserType(qryMap);
	}
 }
