/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SendSmsTaskDto;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_sendsms_task 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
public interface ISendSmsTaskService extends BaseService {
	/**
	 * 描述：通过任务编号查询任务
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param taskId
	 * @return
	 */
	SendSmsTask findSendSmsTaskByTaskId(String taskId);

	/**
	 * 描述：获取任务列表数据
	 * 
	 * @author yujingwei
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<SendSmsTaskDto> queryPage(PageRequest request) throws Exception;

	/**
	 * 描述：通过taskid删除任务信息
	 * 
	 * @author yujingwei
	 * @param taskid
	 * @return int
	 * @throws Exception
	 */
	public int deletSmsTaskInfoByTaskid(String taskid) throws Exception;

	/**
	 * 描述：通过任务编号查询任务信息
	 * 
	 * @author yujingwei
	 * @param taskid
	 * @return SendSmsTask
	 * @throws Exception
	 */
	public SendSmsTask selectSmsTaskInfoByTaskid(String taskid) throws Exception;

	/**
	 * 描述：修改短信群发任务
	 * 
	 * @author baifangfang
	 * @param sendSmsTask
	 * @return int
	 */
	int update(SendSmsTaskDto sendSmsTask);

	/**
	 * 描述：添加短信群发任务
	 * 
	 * @author baifangfang
	 * @param sendSmsTask
	 * @return int
	 */
	int insert(SendSmsTaskDto sendSmsTask);
   
	/**
	 * 描述：添加短信群发任务和发送企业的信息
	 * 
	 * @author baifangfang
	 * @param sendSmsTask
	 * @return int
	 */
	int saveSendSmsTaskInfoAndSendSmsTask(Map<String, SendSmsTaskInfo> infoMap, SendSmsTaskDto sendSmsTask);

	/**
	 * 描述：获取任务表中最大的id
	 * 
	 * @author baifangfang
	 * @param sendSmsTask
	 * @return int
	 */
	int getMaxId();
    
	/**
	 * 描述：查询当前登录部门的短信任务
	 * 
	 * @author baifangfang
	 * @param deptCode
	 * @return List<SendSmsTask>
	 */
	List<SendSmsTask> findSmsTaskByDeptId(String deptCode);

	/**
	 * 描述：查询有没有结束的短信任务
	 * 
	 * @author baifangfang
	 * @return List<SendSmsTask>
	 */
	List<SendSmsTask> findNotOverTask(String deptId);

	/**
	 * 描述：通过任务编号查询任务
	 * 
	 * @author baifangfang
	 * @date 2017年3月3日
	 * @param taskId
	 * @return
	 */
	SendSmsTask findSendSmsTaskByUID(String uid);
    
	/**
	 * 描述：杭州短信任务
	 */
	void hzSmsTask() throws Exception;
    
	/**
	 * 描述：宁波短信任务
	 */
	void nbSmsTask() throws Exception;
    
	/**
	 * 描述：温州短信任务
	 */
	void wzSmsTask() throws Exception;
    
	/**
	 * 描述：嘉兴短信任务
	 */
	void jxSmsTask() throws Exception;
    
	/**
	 * 描述：湖州短信任务
	 */
	void huzSmsTask() throws Exception;
    
	/**
	 * 描述：绍兴短信任务
	 */
	void sxSmsTask() throws Exception;
	
	/**
	 * 描述：金华短信任务
	 */
	void jhSmsTask() throws Exception;
	
	/**
	 * 描述：衢州短信任务
	 */
	void qzSmsTask() throws Exception;
	
	/**
	 * 描述：舟山短信任务
	 */
	void zsSmsTask() throws Exception;
	
	/**
	 * 描述：台州短信任务
	 */
	void tzSmsTask() throws Exception;
	
	/**
	 * 描述：丽水短信任务
	 */
	void lsSmsTask() throws Exception;
	
	/**
	 * 描述：省局短信任务
	 */
	void sjSmsTask() throws Exception;

}