/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;

import com.icinfo.cs.sccheck.dto.PubScGroupMemberDto;
import com.icinfo.cs.sccheck.model.PubScGroupMember;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scgroup_member 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
public interface IPubScGroupMemberService extends BaseService {

	/**
	 * 描述：执法人员分组列表
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<PubScGroupMemberDto> queryPageMember(PageRequest request,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：执法人员分组列表(随机抽取执法人员过程使用)
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<PubScGroupMemberDto> queryPageRandomMember(PageRequest request,SysUserDto sysUserDto)throws Exception;
	
	/**
	 * 描述：删除小组成员
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public boolean deleteByGroupUid(String groupUid)throws Exception;
	
	/**
	 * 描述：批量小组成员
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param sysUser
	 * @param pubScGroupMemberList
	 * @param groupUid
	 * @return
	 * @throws Exception
	 */
	public boolean savePubScGroupMemberBatch(SysUserDto sysUser,String groupUid,List<PubScGroupMember> pubScGroupMemberList)throws Exception;
	
	/**
	 * 描述：执法人员调整初始化组员数据
	 * @author yujingwei
	 * @param resultUids 
	 * @date 2017年7月10日
	 * @return 
	 * @throws Exception
	 */
	public void doInitGroupAndMemberData(SysUserDto sysUserDto, String resultUids) throws Exception;
    
	/**
	 * 描述：删除执法人员单条记录
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	public int doDelGroupmemberInfoByUid(String uid) throws Exception;
    
	/**
	 * 描述：保存成员信息并返回分组页面
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @param sysUserDto 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doBackMemberPageOpt(String uid, SysUserDto sysUserDto) throws Exception;

	/**
	 * 描述：保存信息返回给随机抽取列表（检查小组）
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param agentUids
	 * @param session
	 * @param groupUid
	 * @param groupType 
	 * @throws Exception
	 */
	public boolean doRandomMemberOpt(String agentUids, String groupUid,SysUserDto sysUserDto, String groupType)throws Exception;
    
	/**
	 * 描述：执法人员调整 提交
	 * @author yujingwei
	 * @param leaderUid 
	 * @param expertUid 
	 * @date 2017年7月10日
	 * @param uid,sysUserDto
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doAdjustScCheckPerson(String uid, String expertUid, String leaderUid, SysUserDto sysUserDto) throws Exception;

	/**
	 * 描述：查询
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param groupUid
	 * @throws Exception
	 */
	public List<PubScGroupMember> selectByGroupUid(String groupUid)throws Exception;
    
	/**
	 * 描述：批量提交检查小组数据
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param groupUid
	 * @throws Exception
	 */
	public boolean commitPubScGroupMemberBatch(SysUserDto sysUser,String groupUid, List<PubScGroupMember> pubScGroupMemberList) throws Exception;
	
	/**
	 * 描述：检查小组维护页面列表查询
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @throws Exception
	 */
	public List<PubScGroupMemberDto> queryGroupMaintainPage(PageRequest request, SysUserDto sysUserDto) throws Exception;
    
	/**
	 * 描述：逻辑删除临时数据
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public int doDelGroupmemberInfoByLogic(String uid) throws Exception;
    
	/**
	 * 描述：初始化临时操作标志
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public void initCheckGroupMaintainPage(String groupUid) throws Exception;
    
	/**
	 * 描述：选择检查小组
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public boolean doChoiceCheckGroupForBackPage(String groupUid,SysUserDto sysUserDto) throws Exception;
    
	/**
	 * 描述：删除所有
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public boolean doDelGroupmemberAll(SysUserDto sysUserDto) throws Exception;
}