/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.dto;

import com.icinfo.cs.drcheck.model.PubScinfoAgent;

/**
 * 描述:    cs_pub_scinfo_agent 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
public class PubScinfoAgentDto extends PubScinfoAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6876412409966225565L;
	
	//执法人员姓名
	private String agentName;
	
	//企业名称
	private String entName;
	
	//任务编号
	private String taskCode;
	
	//任名称
	private String taskName;
	
	//审核状态
	private String auditState;

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}
	
	
}