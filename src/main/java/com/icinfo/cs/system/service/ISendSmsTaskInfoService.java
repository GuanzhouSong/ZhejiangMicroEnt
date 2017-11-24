/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;

import com.icinfo.cs.system.dto.SendSmsTaskInfoDto;
import com.icinfo.cs.system.dto.TaskInfoCount;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sendsms_task_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
public interface ISendSmsTaskInfoService extends BaseService {

	/**
	 * 描述：根据任务id获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param request
	 * @return List<SendSmsTaskInfoDto>
	 * @throws 
	 */
	List<SendSmsTaskInfoDto> queryPageResult(PageRequest request);
	
	/**
	 * 描述：根据任务编号获取企业信息
	 *
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @param request
	 * @return List<SendSmsTaskInfoDto>
	 * @throws 
	 */
	public List<SendSmsTaskInfoDto> doGetSmsTaskInfoList(String taskNO) throws Exception;

	/**
	 * @return 
	 * @param sendSmsTask 
	 * 描述：短信发送结束后更新信息
	 *
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @param request
	 * @return List<SendSmsTaskInfoDto>
	 * @throws 
	 */
	public boolean updateTaskInfoForSendAfter(SendSmsTask sendSmsTask, SendSmsTaskInfoDto sendSmsTaskInfo, String result) throws Exception;
    
	/**
	 * 描述：根据任务编号删除企业信息
	 *
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @param taskid
	 * @return int
	 */
	public int deleteTaskDetails(String taskid) throws Exception;

	/**
	 * 描述：根据查询条件获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年3月7日
	 * @param request
	 * @return List<SendSmsTaskInfoDto>
	 * @throws 
	 */
	List<SendSmsTaskInfoDto> queryPageResults(PageRequest request);
	
	/**
	 * 描述：根据任务id获取任务详情JSON数据列表(一次查询全部不分页)
	 *
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param request
	 * @return List<SendSmsTaskInfoDto>
	 * @throws 
	 */
	List<SendSmsTaskInfoDto> queryPageResultAll(PageRequest request);

	/**
	 * 描述：统计发送成功数
	 *
	 * @author baifangfang
	 * @date 2017年3月17日
	 * @param request
	 * @return int
	 * @throws 
	 */
	TaskInfoCount queryTaskInfoCount(PageRequest request);
}