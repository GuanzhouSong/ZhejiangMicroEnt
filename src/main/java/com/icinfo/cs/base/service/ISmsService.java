/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    短信机 对应的Service接口.<br>
 * 出资方式
 * @author framework generator   
 * @date 2016年08月30日
 */
public interface ISmsService extends BaseService {
	
	/** 
	 * 描述: 发送短信
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param phone
	 * @param message
	 * @throws Exception 
	 */
	public void doSendMsg(final String phone, final String message, final String district) throws Exception;
	
	/** 
	 * 描述: 短信发送处理结果查询
	 * @auther yuujingwei
	 * @date 2016年9月11日 
	 * @param district
	 * @param string 
	 * @throws Exception 
	 */
	public String reportStatus(String district) throws Exception;
    
	/** 
	 * 描述: 发送短信（用于短信群发）
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @param district，phone，regOrg
	 * @param string 
	 * @throws Exception 
	 */
	public String doSendMsgForSmsTask(String phone, String smsMsg, String regOrg) throws Exception;
}