/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.sccheck.model.PubScentAgent;

/**
 * 描述:    cs_pub_scent_agent 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
public class PubScentAgentDto extends PubScentAgent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9177902780725730668L;
	
	//注册号
	private String regNO;
	
	//统一社会信用代码
	private String uniCode;
	
	//企业名称
	private String entName;
	
	//执法人员姓名
	private String agentNames;
	
	//任务编号
	private String taskCode;
	
	//任务名称
	private String taskName;
	
	//任务状态
	private String taskState;
	
	//执法人员姓名 
	private String agentName;
	
	//实施部门审核状态
	private String auditState;
	
	//登记机关名称
	private String regOrgName;
	
	//管辖单位名称
	private String localAdmName;
	
	//组长
	private String teamLeader;
	
	//专家
	private String expertNames;
	
	//调整人姓名
	private String adjustUserName;
	
	//调整人时间
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date adjustTime;
	
	//检查人员姓名
	private String checkDeptPerson;
	
	
	
	
	//“双随机”可视化检查人员统计
	//区域编码
	private String areaCode;
	//参与检查人员数量
	private Integer checkPersonNum;
	//随机抽取日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date randomDate;
	//部门状态
	private String deptState;
	//检查机关
	private String deptOrgName;
	//检查部门
	private String checkDeptName;
	//成立日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date estDate;
	//企业大类
	private String entTypeCatg;
	//企业大类描述
	private String entTypeCatgDesc;
	//行业描述
	private String industryCoDesc;
	//经营范围
	private String opScope;
	//住所
	private String dom;
	//片区
	private String sliceNOName;
	//法人
	private String lerep;
	//法人电话
	private String mobTel;
	//联络员
	private String liaName;
	//联络员电话
	private String tel;

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getAgentNames() {
		return agentNames;
	}

	public void setAgentNames(String agentNames) {
		this.agentNames = agentNames;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
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

	public String getTaskState() {
		return taskState;
	}

	public void setTaskState(String taskState) {
		this.taskState = taskState;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getAdjustUserName() {
		return adjustUserName;
	}

	public void setAdjustUserName(String adjustUserName) {
		this.adjustUserName = adjustUserName;
	}

	public Date getAdjustTime() {
		return adjustTime;
	}

	public void setAdjustTime(Date adjustTime) {
		this.adjustTime = adjustTime;
	}

	public String getCheckDeptPerson() {
		return checkDeptPerson;
	}

	public void setCheckDeptPerson(String checkDeptPerson) {
		this.checkDeptPerson = checkDeptPerson;
	}

	public String getExpertNames() {
		return expertNames;
	}

	public void setExpertNames(String expertNames) {
		this.expertNames = expertNames;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public Integer getCheckPersonNum() {
		return checkPersonNum;
	}

	public void setCheckPersonNum(Integer checkPersonNum) {
		this.checkPersonNum = checkPersonNum;
	}

	public Date getRandomDate() {
		return randomDate;
	}

	public void setRandomDate(Date randomDate) {
		this.randomDate = randomDate;
	}

	public String getDeptState() {
		return deptState;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}

	public String getDeptOrgName() {
		return deptOrgName;
	}

	public void setDeptOrgName(String deptOrgName) {
		this.deptOrgName = deptOrgName;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getOpScope() {
		return opScope;
	}

	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public String getLerep() {
		return lerep;
	}

	public void setLerep(String lerep) {
		this.lerep = lerep;
	}

	public String getMobTel() {
		return mobTel;
	}

	public void setMobTel(String mobTel) {
		this.mobTel = mobTel;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}

	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}

	public String getIndustryCoDesc() {
		return industryCoDesc;
	}

	public void setIndustryCoDesc(String industryCoDesc) {
		this.industryCoDesc = industryCoDesc;
	}
	
}