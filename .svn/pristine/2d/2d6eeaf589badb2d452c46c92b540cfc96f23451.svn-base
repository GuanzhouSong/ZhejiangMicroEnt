/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.mapper.EntAssignRecordMapper;
import com.icinfo.cs.system.mapper.EntAssignLogMapper;
import com.icinfo.cs.system.model.EntAssignLog;
import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.cs.system.service.IEntAssignRecordService;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.model.EntBaseInfo;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.security.shiro.UserProfile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_ent_assign 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月22日
 */
@Service
public class EntAssignRecordServiceImpl extends MyBatisServiceSupport implements IEntAssignRecordService {


    @Autowired
    private EntAssignRecordMapper entAssignMapper;

    @Autowired
    private EntAssignLogMapper entAssignLogMapper;

    @Autowired
    private IMidBaseInfoService midBaseInfoService;

    @Autowired
    private ISysUserService sysUserService;

    /**
     * 描述：插入一条企业权限分配信息
     *
     * @param entAssign
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-09-22
     */
    @Override
    public int insert(EntAssignRecord entAssign) throws Exception {
        return entAssignMapper.insert(entAssign);
    }

    /**
     * 描述：查询企业权限分配记录信息
     *
     * @param pageRequest
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-09-22
     */
    @Override
    public List<EntAssignRecord> query(PageRequest pageRequest) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example ex = new Example(EntAssignRecord.class);
        Example.Criteria criteria=ex.createCriteria();
        Map<String, Object> maps = pageRequest.getParams();
        if (maps != null) {
            if (!"".equals(maps.get("entName")) && maps.get("entName") != null) {
                criteria.andEqualTo("entName", maps.get("entName"));
            }
            if (!"".equals(maps.get("regNO")) && maps.get("regNO") != null) {
                criteria.andEqualTo("regNO", maps.get("regNO"));
            }
            if (!"".equals(maps.get("uniCode")) && maps.get("uniCode") != null) {
                criteria.andEqualTo("uniCode", maps.get("uniCode"));
            }
            if (!"".equals(maps.get("assignUserName")) && maps.get("assignUserName") != null) {
                criteria.andEqualTo("assignUserName", maps.get("assignUserName"));
            }
            if (!"".equals(maps.get("assignDeptId")) && maps.get("assignDeptId") != null) {
                criteria.andEqualTo("assignDeptId", maps.get("assignDeptId"));
            }
            if (!"".equals(maps.get("userType")) && maps.get("userType") != null) {
                criteria.andEqualTo("userType", maps.get("userType"));
            }
            if (!"".equals(maps.get("userSetPerson")) && maps.get("userSetPerson") != null) {
                criteria.andEqualTo("userSetPerson", maps.get("userSetPerson"));
            }
            if (!"".equals(maps.get("startSetDate")) && maps.get("startSetDate") != null) {
                criteria.andGreaterThanOrEqualTo("setTime", maps.get("startSetDate"));
            }
            if (!"".equals(maps.get("endSetDate")) && maps.get("endSetDate") != null) {
                criteria.andLessThanOrEqualTo("setTime", maps.get("endSetDate"));
            }
//
        }
        ex.orderBy("setTime").desc();
        List<EntAssignRecord> entAssigns=entAssignMapper.selectByExample(ex);
        return entAssigns;
    }


    /**
     * 描述：指定分配
     *
     * @param priPIDs     主体身份ID
     * @param userIds     指定分配用户ID
     * @param sysUserDto 当前登陆用户
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-11
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doAssign(String priPIDs, String userIds, SysUserDto sysUserDto) throws Exception{
        String[] priPIDArr=priPIDs.split(",");
        String[] userIDArr=userIds.split(",");
        EntAssignRecord entAssignRecord=null;
        MidBaseInfo entBaseInfo=null;
        SysUser sysUser=sysUserService.selectByUserName(sysUserDto.getUsername());
        for(int i=0;i<priPIDArr.length;i++){
            entBaseInfo=midBaseInfoService.selectByPripid(priPIDArr[i]);
            for(int j=0;j<userIDArr.length;j++){
                entAssignRecord=new EntAssignRecord();
                EntAssignLog entAssignLog= new EntAssignLog();

                if(StringUtils.isBlank(userIDArr[j]))continue;
                entAssignRecord.setSetTime(new Date());
                entAssignRecord.setAssignUserId(userIDArr[j]);
                entAssignRecord.setAssignUserName(sysUser.getRealName());
                entAssignRecord.setAssignDeptId(sysUser.getDeptCode());
                entAssignRecord.setAssignDeptName(sysUser.getDept());
                entAssignRecord.setPriPID(priPIDArr[i]);
                entAssignRecord.setRegNO(entBaseInfo.getRegNO());
                entAssignRecord.setUniCode(entBaseInfo.getUniCode());
                entAssignRecord.setEntName(entBaseInfo.getEntName());
                entAssignRecord.setSetName(sysUserDto.getRealName());
                entAssignMapper.insert(entAssignRecord);

                entAssignLog.setSetTime(new Date());
                entAssignLog.setAssignUserId(userIDArr[j]);
                entAssignLog.setAssignUserName(sysUser.getRealName());
                entAssignLog.setAssignDeptId(sysUser.getDeptCode());
                entAssignLog.setAssignDeptName(sysUser.getDept());
                entAssignLog.setPriPID(priPIDArr[i]);
                entAssignLog.setRegNO(entBaseInfo.getRegNO());
                entAssignLog.setUniCode(entBaseInfo.getUniCode());
                entAssignLog.setEntName(entBaseInfo.getEntName());
                entAssignLog.setSetName(sysUserDto.getRealName());
                entAssignLog.setIsCancleAssign("0");
                entAssignLogMapper.insert(entAssignLog);
            }
        }
    }


    /**
     * 描述：取消指定分配信息
     * @param assignUID
     * @param priPID
     * @param userId
     * @param userProfile
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doCancleAssign(String assignUID,String priPID, String userId, UserProfile userProfile) throws Exception {
        EntBaseInfo entBaseInfo=midBaseInfoService.selectBaseInfoByPriPIDAndEs(priPID);
        SysUser sysUser=sysUserService.selectByUserName(userProfile.getUsername());

        EntAssignLog entAssignLog= new EntAssignLog();
        entAssignLog.setSetTime(new Date());
        entAssignLog.setAssignUserId(userId);
        entAssignLog.setAssignUserName(sysUser.getRealName());
        entAssignLog.setAssignDeptId(sysUser.getDeptCode());
        entAssignLog.setAssignDeptName(sysUser.getDeptName());
        entAssignLog.setPriPID(priPID);
        entAssignLog.setRegNO(entBaseInfo.getRegNO());
        entAssignLog.setUniCode(entBaseInfo.getUNICODE());
        entAssignLog.setEntName(entBaseInfo.getEntName());
        entAssignLog.setSetName(userProfile.getRealName());
        entAssignLog.setIsCancleAssign("1");
        entAssignLogMapper.insert(entAssignLog);
        doDelByAssignUId(assignUID);
    }


    /**
     * 描述：删除指定分配信息
     *
     * @param assignUID
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public void doDelByAssignUId(String assignUID) throws Exception {
        EntAssignRecord entAssignRecord=new EntAssignRecord();
        entAssignRecord.setUID(assignUID);
        entAssignMapper.delete(entAssignRecord);
    }
}