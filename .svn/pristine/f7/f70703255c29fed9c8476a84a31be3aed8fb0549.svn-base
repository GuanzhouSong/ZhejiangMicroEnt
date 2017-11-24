/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.SendEmailUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.EmailTaskDto;
import com.icinfo.cs.system.mapper.EmailTaskInfoMapper;
import com.icinfo.cs.system.mapper.EmailTaskMapper;
import com.icinfo.cs.system.model.EmailTask;
import com.icinfo.cs.system.model.EmailTaskInfo;
import com.icinfo.cs.system.service.IEmailTaskService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_email_task 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
@Service
public class EmailTaskServiceImpl extends MyBatisServiceSupport implements IEmailTaskService {
	@Autowired
	EmailTaskMapper emailTaskMapper;
	@Autowired
	EmailTaskInfoMapper emailTaskInfoMapper;

	@Override
	public List<EmailTaskDto> queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return emailTaskMapper.selectEmailTask(request.getParams());
	}

	@Override
	@Transaction
	public int saveEmailTaskInfoAndEmailTask(Map<String, EmailTaskInfo> infoMap, EmailTask emailTask) throws Exception {
		int i = emailTaskMapper.insert(emailTask);// 添加任务
		String uid = emailTask.getUid();
		for (String key : infoMap.keySet()) {
			EmailTaskInfo emailTaskInfo = infoMap.get(key);
			emailTaskInfo.setTaskUid(uid);
			emailTaskInfo.setCreateTime(new Date());
			emailTaskInfoMapper.insert(emailTaskInfo);// 添加任务详情

			// 添加任务后发送邮件
			String email = emailTaskInfo.getEmail();
			if (!StringUtil.isEmpty(email) && !"null".equals(email)) {
				SendEmailUtil.send(email, emailTask.getTaskContent());
			}
		}
		return i;
	}

	@Override
	public EmailTask findEmailTaskByUID(String uid) {
		EmailTask emailTask = new EmailTask();
		emailTask.setUid(uid);
		return emailTaskMapper.selectOne(emailTask);
	}
}