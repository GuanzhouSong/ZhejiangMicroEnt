/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.common.constant;

import java.util.Map;
import java.util.TreeMap;

/**
 * 描述:日志操作类型<br>
 *
 * @author chenxin
 * @date 2016年09月19日
 */
public enum LogOperation {
	ModApplicationLog("1","年报修改申请审核日志"),
	FoodstorageBackLog("2","食品仓储退回日志"),
	
	
	/* 年报 */
	YrForinvestMentLog("3","对外投资报表填报日志"),
	YrAlterStockInfoLog("4","对外担保报表填报日志"),
	SaveFoodstorageLicenLog("5","保存许可证书日志"),
	DelFoodstorageLicenLog("6","删除许可证书日志"),
	DelBatchFoodstorageLicenLog("7","批量删除许可证书日志"),
	SaveFoodstorageBaseLog("8","保存食品仓储基本信息日志"),
	SaveFoodstorageInfoAndAuxLog("9","保存食品仓储仓库和详细信息日志"),
	RmoveFoodstorageInfoAndAuxLog("10","批量删除食品仓储仓库和详细信息日志"),
	loginTypeLog("00","登录方式日志"),
	sendMsgBeforeLoginLog("20","登录时企业联络员获取手机验证码日志"),
	sendMsgAfterLoginLog("21","登录后企业联络员信息填写获取验证码日志"),
	sendMsgLoginCheckLog("22","协同系统用户校验获取验证码日志"),
	commitYearReportLog("30","提交年报日志"),
	pubDtInfoLog("40","双告知操作日志"),
	pubDzDtInfoLog("41","多证合一操作日志"),
	codeDzLicenseLog("42","备案事项操作日志"),
	licDzDeptLog("43","多证合一审批对照维护操作日志"),
	codeLicenseLog("50","后置审批事项操作日志"),
	licDeptLog("60","审批对照维护操作日志"),
	synSimpleescLog("61","协同系统其他部门简易注销获取验证码日志"),
	unifiedLoginLog("62","统一用户登录日志"),
	addUnifiedLog("63","新增统一用户日志"),
	editUnifiedLog("64","修改统一用户日志"),
	delUnifiedLog("65","删除统一用户日志"),
	PBOPANOMALYNOREPORTLOG("66","个体户未按时年报列入异常日志"),
	MESSAGEIMINFOLOG("67","有限责任公司即时消息推送日志"),
	MESSAGESCCHECKLOG("68","抽查检查消息推送日志"),
	smentunifiedLoginLog("69","小微系统统一用户登录日志"),
	smentaddUnifiedLog("70","小微系统新增统一用户日志"),
	smenteditUnifiedLog("71","小微系统修改统一用户日志"),
	smentdelUnifiedLog("72","小微系统删除统一用户日志");
	
	
	
	
	
	private String code;//编码
	private String desc;//描述
	private LogOperation(String code, String desc){
		this.code= code;
		this.desc=desc;
	}
	public String getCode() {
		return code;
	}
	public String getDesc() {
		return desc;
	}
	public static LogOperation getValue(String code) {
		for (LogOperation logOperation : LogOperation.values()) {
			if (logOperation.code.equalsIgnoreCase(code)) {
				return logOperation;
			}
		}
		return null;
	}
    
    public static Map<String,LogOperation> getLogOperationMap(){
		Map<String,LogOperation> logOperationMap = new TreeMap<String,LogOperation>();
		for(LogOperation logOperation :LogOperation.values()){
			logOperationMap.put(logOperation.getCode(),logOperation);
		}
		return logOperationMap;
	}
}
