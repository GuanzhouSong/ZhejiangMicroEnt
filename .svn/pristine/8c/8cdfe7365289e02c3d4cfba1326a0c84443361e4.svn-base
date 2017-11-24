/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.system.model.SysLog;

/**
 * 描述:    cs_sys_log 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public class SysLogDto extends SysLog {
	//日志企业大类描述
	private String logEntTypeDesc;
	//日志操作编码
	private String logOperationCode;
	//日志操作描述
	private String logOperationDesc;
	
	public String getLogEntTypeDesc() {
		return logEntTypeDesc;
	}
	public void setLogEntTypeDesc(String logEntTypeDesc) {
		this.logEntTypeDesc = logEntTypeDesc;
	}
	public String getLogOperationDesc() {
		return logOperationDesc;
	}
	public void setLogOperationDesc(String logOperationDesc) {
		this.logOperationDesc = logOperationDesc;
	}
	public String getLogOperationCode() {
		return logOperationCode;
	}
	public void setLogOperationCode(String logOperationCode) {
		this.logOperationCode = logOperationCode;
		try{
			setLogOperationDesc(LogOperation.getValue(this.logOperationCode).getDesc());
		}catch(Exception e){
			
		}
	}
	
}