/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import java.math.BigDecimal;
import java.util.List;

import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubSccheckItem;

/**
 * 描述:    cs_pub_scplan_task 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@SuppressWarnings("serial")
public class PubScPlanTaskDto extends PubScPlanTask {
	//检查事项
	private List<PubSccheckItem> pubSccheckItemList;
	
	private List<PubScentResultDto> PubScentResultList;
	
	 /**
     * 任务状态
     */
    private String deptState;

    /**
     * 检查人员数
     */
    private Integer checkNum;

    /**
     * 专家人员数
     */
    private Integer specialNum;

    /**
     * 检查对象数量
     */
    private Integer entNum;
    
    /**
     * 本部门数量
     */
    private Integer ownNum;
    
    /**
     * 跨部门数量
     */
    private Integer crossNum;
    
    
    /**
     * 检查对象数量
     */
    private Integer minNum;
    
    private String taskUid;
    //地区编码
    private String areaCode;
    //部门编码
    private String deptCode;
    //部门名称
    private String deptName;
    //待执行任务数量
    private Integer taskState01;
    //执行中任务数量
    private Integer taskState02;
    //已完成数量
    private Integer taskState03;
    //临时任务数量
    private Integer taskResource1;
    //任务计划数量
    private Integer taskResource2;
    //总任务数量
    private Integer totalTask;
    
    /**  任务计划维度 */
    //待执行计划数量
    private Integer planState01;
    //执行中计划数量
    private Integer planState02;
    //已完成计划数量
    private Integer planState03;
    //总任务数量
    private Integer totalWork;
    
    /** 检查企业维度 */
    //已检查企业数量
    private Integer finishedNum;
    //后续处置已完结企业数量
	private Integer disposeNum;
	//企业总量
	private Integer totalNum;
	
	// 企业名称
	private String entName;
	// 注册号
	private String regNO;
	// 统一代码
	private String unicode;
	// 主体代码
	private String priPID;
	// 抽查部门姓名
	private String checkDeptName;
	// 检查人员
	private String checkDeptPerson;
	// 唯一标识
	private String resultUid;
	// 待办返回距离任务到期天数
	private String toEndDays;
	
	// 抽查计划编号
	private String resourcePlanCode;
	// 检查事项
	private String checkItemName;
	// 工作计划部门
	private String planLeadDeptName;
	
	//公告标题
	private String pubTitle;
	//公告部门
	private String auditDeptName;
	//公告时间
	private String auditDate;
	//任务Id
	private String linkUID;
	//本部门计划数量
	private Integer planOwnNum;
	//跨部门计划数量
	private Integer planCrossNum;
	//检查完成率
	private BigDecimal checkRoate;
	//其他文号名称
	private String otherDocName;

	public List<PubSccheckItem> getPubSccheckItemList() {
		return pubSccheckItemList;
	}

	public void setPubSccheckItemList(List<PubSccheckItem> pubSccheckItemList) {
		this.pubSccheckItemList = pubSccheckItemList;
	}

	public String getDeptState() {
		return deptState;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}

	public Integer getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}

	public Integer getSpecialNum() {
		return specialNum;
	}

	public void setSpecialNum(Integer specialNum) {
		this.specialNum = specialNum;
	}

	public Integer getEntNum() {
		return entNum;
	}

	public void setEntNum(Integer entNum) {
		this.entNum = entNum;
	}
	
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}
	public String getTaskUid() {
		return taskUid;
	}

	public Integer getMinNum() {
		return minNum;
	}

	public void setMinNum(Integer minNum) {
		this.minNum = minNum;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getTaskState01() {
		return taskState01;
	}

	public void setTaskState01(Integer taskState01) {
		this.taskState01 = taskState01;
	}

	public Integer getTaskState02() {
		return taskState02;
	}

	public void setTaskState02(Integer taskState02) {
		this.taskState02 = taskState02;
	}

	public Integer getTaskState03() {
		return taskState03;
	}

	public void setTaskState03(Integer taskState03) {
		this.taskState03 = taskState03;
	}

	public Integer getTotalTask() {
		return totalTask;
	}

	public void setTotalTask(Integer totalTask) {
		this.totalTask = totalTask;
	}

	public Integer getPlanState01() {
		return planState01;
	}

	public void setPlanState01(Integer planState01) {
		this.planState01 = planState01;
	}

	public Integer getPlanState02() {
		return planState02;
	}

	public void setPlanState02(Integer planState02) {
		this.planState02 = planState02;
	}

	public Integer getPlanState03() {
		return planState03;
	}

	public void setPlanState03(Integer planState03) {
		this.planState03 = planState03;
	}

	public Integer getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(Integer totalWork) {
		this.totalWork = totalWork;
	}

	public Integer getFinishedNum() {
		return finishedNum;
	}

	public void setFinishedNum(Integer finishedNum) {
		this.finishedNum = finishedNum;
	}

	public Integer getDisposeNum() {
		return disposeNum;
	}

	public void setDisposeNum(Integer disposeNum) {
		this.disposeNum = disposeNum;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTaskResource1() {
		return taskResource1;
	}

	public void setTaskResource1(Integer taskResource1) {
		this.taskResource1 = taskResource1;
	}

	public Integer getTaskResource2() {
		return taskResource2;
	}

	public void setTaskResource2(Integer taskResource2) {
		this.taskResource2 = taskResource2;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getUnicode() {
		return unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getCheckDeptName() {
		return checkDeptName;
	}

	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}

	public String getCheckDeptPerson() {
		return checkDeptPerson;
	}

	public void setCheckDeptPerson(String checkDeptPerson) {
		this.checkDeptPerson = checkDeptPerson;
	}
    
	
	public String getResultUid() {
		return resultUid;
	}

	public void setResultUid(String resultUid) {
		this.resultUid = resultUid;
	}

	public String getToEndDays() {
		return toEndDays;
	}

	public void setToEndDays(String toEndDays) {
		this.toEndDays = toEndDays;
	}

	public String getResourcePlanCode() {
		return resourcePlanCode;
	}

	public void setResourcePlanCode(String resourcePlanCode) {
		this.resourcePlanCode = resourcePlanCode;
	}

	public String getCheckItemName() {
		return checkItemName;
	}

	public void setCheckItemName(String checkItemName) {
		this.checkItemName = checkItemName;
	}

	public String getPubTitle() {
		return pubTitle;
	}

	public void setPubTitle(String pubTitle) {
		this.pubTitle = pubTitle;
	}

	public String getAuditDeptName() {
		return auditDeptName;
	}

	public void setAuditDeptName(String auditDeptName) {
		this.auditDeptName = auditDeptName;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getLinkUID() {
		return linkUID;
	}

	public void setLinkUID(String linkUID) {
		this.linkUID = linkUID;
	}

	public String getPlanLeadDeptName() {
		return planLeadDeptName;
	}

	public void setPlanLeadDeptName(String planLeadDeptName) {
		this.planLeadDeptName = planLeadDeptName;
	}

	public Integer getOwnNum() {
		return ownNum;
	}

	public void setOwnNum(Integer ownNum) {
		this.ownNum = ownNum;
	}

	public Integer getCrossNum() {
		return crossNum;
	}

	public void setCrossNum(Integer crossNum) {
		this.crossNum = crossNum;
	}

	public List<PubScentResultDto> getPubScentResultList() {
		return PubScentResultList;
	}

	public void setPubScentResultList(List<PubScentResultDto> pubScentResultList) {
		PubScentResultList = pubScentResultList;
	}
	
	public Integer getPlanCrossNum() {
		return planCrossNum;
	}

	public void setPlanCrossNum(Integer planCrossNum) {
		this.planCrossNum = planCrossNum;
	}

	public Integer getPlanOwnNum() {
		return planOwnNum;
	}

	public void setPlanOwnNum(Integer planOwnNum) {
		this.planOwnNum = planOwnNum;
	}
	
	public void setCheckRoate(BigDecimal checkRoate) {
		this.checkRoate = checkRoate;
	}
	public BigDecimal getCheckRoate() {
		return checkRoate;
	}

	public String getOtherDocName() {
		return otherDocName;
	}

	public void setOtherDocName(String otherDocName) {
		this.otherDocName = otherDocName;
	}
}