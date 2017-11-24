/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.SmsUtil;
import com.icinfo.cs.system.model.SmsSendLog;
import com.icinfo.cs.system.service.ISmsSendLogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.sgs.sms.SmsClient;

/**
 * 描述:    短信机 对应的Service接口实现类.<br>
 * 出资方式
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class SmsServiceImpl extends MyBatisServiceSupport implements ISmsService {
	
	private static final Logger logger = LoggerFactory.getLogger(SmsServiceImpl.class);
	//短信服务器IP
	@Value("${sms.baseUrl}")
	private  String baseUrl;
	
	//短信签名
	@Value("${sms.sign}")
	public  String sign;
	
	//应用标识
	@Value("${sms.appCode}")
	public  String appCode;
	
	//用户名
	@Value("${sms.username}")
	public  String username;
	
	//密码
	@Value("${sms.password}")
	public  String password;
	
	@Autowired
	private ISmsSendLogService smsSendLogService;
		
	/** 
	 * 描述: 发送短信
	 * @auther ZhouYan
	 * @date 2016年9月11日 
	 * @param phone
	 * @param message
	 * @throws Exception 
	 */
	@Override
	public void doSendMsg(String phone, String message, String district) throws Exception {
		if (SmsUtil.validateIsPhone(phone)) {
			sendMsg(phone, message, district);
		}else{
			// 记录发送日志
			SmsSendLog smsSendLog = new SmsSendLog();
			smsSendLog.setPhoneNum(phone);
			smsSendLog.setSendContent(message);
			smsSendLog.setRegOrg(district);
			smsSendLog.setCreateTime(new Date());
			smsSendLog.setSendState("2");
			smsSendLog.setReturnMsg("手机号码校验不通过");
			smsSendLogService.doInsertSmsSendLogInfo(smsSendLog);
		}
	}
	
	/** 
	 * 描述: 短信发送处理结果查询
	 * @auther yuujingwei
	 * @date 2016年9月11日 
	 * @param district
	 * @throws Exception 
	 */
	public String reportStatus(String district) throws Exception {
		SmsClient client = new SmsClient(baseUrl, appCode, username, password, sign);
		if(StringUtils.isNotBlank(district) && StringUtils.length(district) >= 4) {
			district = district.substring(0, 4);
			if(district.equals("3325")){
				district = "3311";//丽水行政区划是3311
			}
			district = district + "00";
		}else{
			district = "330000";
		}
		String result = client.reportStatus(district);
		return result;
	}
	
	/** 
	 * 描述: 短信接口
	 * @auther ZhouYan
	 * @date 2016年9月11日
	 * @param message
	 * @return
	 * @throws Exception 
	 */
	public String sendMsg(String phone, String message, String district) throws Exception {
		SmsClient client = new SmsClient(baseUrl, appCode, username, password, sign);
		if(StringUtils.isBlank(district)) {
			district = "330000";
		}
		String result = client.sendMsg(phone, message, district);
		JSONObject object = (JSONObject) JSONObject.fromObject(result).get("result");
		logger.info("发送短信返回信息{提示:" + object.get("message") + ", 短信余额:"
				+ object.get("remainpoint") + ", 返回状态:"
				+ object.get("returnstatus") + ", 当成功后返回提交成功短信数:"
				+ object.get("successCounts") + ", 本次任务的序列 ID:"
				+ object.get("taskID") + "}");
		
		// 记录短信发送日志
		SmsSendLog smsSendLog = new SmsSendLog();
		smsSendLog.setPhoneNum(phone);
		smsSendLog.setSendContent(message);
		smsSendLog.setRegOrg(district);
		smsSendLog.setCreateTime(new Date());
		if(object.get("returnstatus").toString().equalsIgnoreCase("Success")){
			smsSendLog.setSendState("1");
		}else{
			smsSendLog.setSendState("0");
		}
		smsSendLog.setReturnMsg(result);
		smsSendLogService.doInsertSmsSendLogInfo(smsSendLog);
		
		return (String) object.get("successCounts");
	}
	
	/** 
	 * 描述: 发送短信（用于短信群发）
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @param district，phone，smsMsg
	 * @param string 
	 * @throws Exception 
	 */
	public String doSendMsgForSmsTask(String phone, String smsMsg, String district) throws Exception{
		if (!SmsUtil.validateIsPhone(phone)) {
			return "error";
		}
		SmsClient client = new SmsClient(baseUrl, appCode, username, password, sign);
		if(StringUtils.isBlank(district)) {
			district = "330000";
		}
		String result = client.sendMsg(phone, smsMsg, district);
		return result;
	}

}