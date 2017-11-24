/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.system.model.SendSmsTaskInfo;

/**
 * 描述: cs_sendsms_task_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
public class SendSmsTaskInfoDto extends SendSmsTaskInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6252562941972428015L;

	private String regOrgName;// 登记机关
	private String localAdmName;// 管辖单位
	private String sendObjType;// 发送对象类型
	private String sendObjName;// 发送对象姓名
	private String sendObjTel;// 发送对象号码
	private String sendTime;//短信发送时间
	private String sendStatus;//短信发送状态
	private String taskName;//任务名称
	private String smsType;//短信类别
	
	private String phone;

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getSendObjType() {
		return sendObjType;
	}

	public void setSendObjType(String sendObjType) {
		this.sendObjType = sendObjType;
	}

	public String getSendObjName() {
		return sendObjName;
	}

	public void setSendObjName(String sendObjName) {
		this.sendObjName = sendObjName;
	}

	public String getSendObjTel() {
		return sendObjTel;
	}

	public void setSendObjTel(String sendObjTel) {
		this.sendObjTel = sendObjTel;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
}