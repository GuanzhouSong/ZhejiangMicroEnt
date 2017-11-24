/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.EmailTaskDto;
import com.icinfo.cs.system.model.EmailTask;
import com.icinfo.cs.system.model.EmailTaskInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_email_task 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
public interface IEmailTaskService extends BaseService {

	/**
	 * 描述：邮件发送任务列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @param request
	 * @return
	 */
	List<EmailTaskDto> queryPage(PageRequest request);

	/**
	 * 描述：添加发送邮件任务和企业信息
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @param infoMap
	 * @param emailTask
	 * @return
	 */
	int saveEmailTaskInfoAndEmailTask(Map<String, EmailTaskInfo> infoMap, EmailTask emailTask) throws Exception;

	/**
	 * 描述：根据uid查询邮件任务
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @param uid
	 * @return
	 */
	EmailTask findEmailTaskByUID(String uid);
}