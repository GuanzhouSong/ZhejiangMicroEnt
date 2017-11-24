/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.Date;

import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    pub_scdept_task 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
public interface IPubScdeptTaskService extends BaseService {

	/**
	 * 描述:创建执法人员任务
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	public void savePubScdeptTask(PubScdeptTask pubScdeptTask);
	
	/**
	 * 描述:更新执法人员任务
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param deptState
	 * @param userDto
	 * @param minNum
	 */
	public void updatePubScdeptTask(String deptTaskUid, String deptState,SysUserDto userDto);	
	/**
	 * 描述:更新执法人员任务(仅状态)
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	public void updatePubScdeptTask(String deptTaskUid, String deptState) ;
	/**
	 * 描述:更新执法人员任务
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param checkNum
	 * @param randomDate
	 */
	public void updatePubScdeptTask(String deptTaskUid, int checkNum,Date randomDate,String randomType,int minNum) ;
	/**
	 * 描述:更新任务状态
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 */
	public void updatePubScdeptTaskByEnt(String deptTaskUid)throws Exception;
	
	/**
	 * 描述:更新任务状态(跳过执法人员抽取)
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 */
	public void updateIgnoreAgent(String deptTaskUid)throws Exception;
	
	/**
	 * 描述:删除任务
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	public void delPubScdeptTask(String taskUid);

	/**
	 * 描述：根据uid查询执法人员任务
	 * @author baifangfang
	 * @date 2017年5月26日
	 * @param taskUid
	 * @return
	 */
	public PubScdeptTask selectPubScdeptTaskByUid(String uid);

	/**
	 * 描述:更新任务信息
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 * @throws Exception
	 */
	public void updatePubScdeptTask(PubScdeptTask pubScdeptTask)throws Exception;

	/**
	 * 描述:删除抽查任务
	 * @author chenxin
	 * @date 2017-05-22 
	 * @param uid
	 * @throws Exception
	 */
	public void deleteByUid(String uid)throws Exception;

	/**
	 * 描述:根据任务uid和部门编码查询任务是否存在
	 * @author chenxin
	 * @date 2017-05-22 
	 * @param taskUid
	 * @param appointLocalAdm
	 * @return
	 * @throws Exception
	 */
	public PubScdeptTask selectByTaskUidAndUnitDeptCode(String taskUid,String unitDeptCode)throws Exception;
}