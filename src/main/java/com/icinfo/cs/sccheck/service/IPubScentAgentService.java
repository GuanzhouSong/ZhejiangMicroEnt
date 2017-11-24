/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentAgentDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_agent 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
public interface IPubScentAgentService extends BaseService {

	/**
	 * 描述：企业随机配对执法人员
	 * @author chenxin
	 * @date 2017-05-22
	 * @param sysUser
	 * @param deptTaskUid
	 * @param randomType
	 * @return
	 * @throws Exception
	 */
	public boolean doRandomEntAgent(SysUserDto sysUser, String deptTaskUid,int groupNum,String randomType)throws Exception;
	
	/**
	 * 描述：查看企业匹配的执法人员
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public String doSelectEntAgent(String deptTaskUid,String priPID)throws Exception;
	
	/**
	 * 描述：查看企业匹配的执法人员
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param priPID
	 * @param scentUid
	 * @return
	 * @throws Exception
	 */
	public String doSelectEntAgent(String deptTaskUid,String priPID,String scentUid)throws Exception;

	/**
	 * 描述：查看企业匹配的部门
	 * @author baifangfang
	 * @date 2017-6-2
	 * @param deptTaskUid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public String doSelectDeptName(String deptTaskUid, String priPID);
	
	/**
	 * 描述：查看企业匹配的部门
	 * @author baifangfang
	 * @date 2017-6-2
	 * @param deptTaskUid
	 * @param priPID
	 * @param scentUid
	 * @return
	 * @throws Exception
	 */
	public String doSelectDeptName(String deptTaskUid, String priPID,String scentUid);

	/**
	 * 描述：查看企业匹配执法人员列表
	 * @author chenxin
	 * @date 2017-6-13
	 * @param request
	 * @return
	 */
	public List<PubScentAgentDto> selectPubScentAgentDtoList(PageRequest request)throws Exception;
	
	/**
	 * 描述:调整执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param sysUser
	 * @param scentAgentUids
	 * @param agentUid
	 * @return
	 * @throws Exception
	 */
	public boolean doSignEntAgent(SysUserDto sysUser, String scentAgentUids,String agentUid)throws Exception;

	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	public void deleteByTaskUidAndPriPID(String taskUid, String priPID)throws Exception;
	
	
	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param scentUid
	 * @throws Exception
	 */
	public void deleteByTaskUidAndScentUid(String taskUid, String scentUid)throws Exception;
	
	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	public void deleteByTaskUid(String taskUid)throws Exception;

	/**
	 * 描述：企业随机配对检查小组
	 * @author chenxin
	 * @date 2017-7-12
	 * @param sysUser
	 * @param deptTaskUid
	 * @param groupNum
	 * @return
	 * @throws Exception
	 */
	public boolean doRandomByGroup(SysUserDto sysUser, String deptTaskUid,int groupNum)throws Exception;
	
	/**
	 * 
	 * 描述: 可视化检察人员统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScentAgentDto> selectPubScentAgentChartsCount(Map<String, Object> map) throws Exception;

	/**
	 * 描述：检查名单与人员查询
	 * 
	 * @author chenxin
	 * @date 2017-11-20
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScentAgentDto> selectSearchList(PageRequest request)throws Exception;
}