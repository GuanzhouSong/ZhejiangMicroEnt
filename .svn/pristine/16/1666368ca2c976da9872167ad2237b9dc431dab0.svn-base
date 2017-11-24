/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service.impl;

import com.icinfo.cs.message.mapper.MessageScCheckMapper;
import com.icinfo.cs.message.model.MessageScCheck;
import com.icinfo.cs.message.service.IMessageScCheckService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_message_sccheck 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
@Service
public class MessageScCheckServiceImpl extends MyBatisServiceSupport implements IMessageScCheckService {

	@Autowired
	private  MessageScCheckMapper messageScCheckMapper;
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年8月10日 下午7:57:08 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertMessageScCheck(MessageScCheck messageScCheck)
			throws Exception {
		if(messageScCheck!=null){
			return	messageScCheckMapper.insert(messageScCheck);
		}
		return 0;
	}
}