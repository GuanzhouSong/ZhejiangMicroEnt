/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.system.mapper.SmsSendLogMapper;
import com.icinfo.cs.system.model.SmsSendLog;
import com.icinfo.cs.system.service.ISmsSendLogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_sms_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月31日
 */
@Service
public class SmsSendLogServiceImpl extends MyBatisServiceSupport implements ISmsSendLogService {
	
	@Autowired
	SmsSendLogMapper smsSendLogMapper;
	
	/** 
	 * 描述: 短信日志记录
	 * @auther yujingwei
	 * @date 2017年7月31日
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public void doInsertSmsSendLogInfo(SmsSendLog smsSendLog) throws Exception{
		smsSendLogMapper.insert(smsSendLog);
	}
}