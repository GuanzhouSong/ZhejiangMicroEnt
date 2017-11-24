/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.sccheck.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: cs_pub_scent_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年05月17日
 */
@Table(name = "cs_pub_scent_result")
public class PubScentResult implements Serializable {
	/**
	 * 自增长序号
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 序号：UUID
	 */
	@Column(name = "Uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 主任务表序号
	 */
	@Column(name = "MainTaskUid")
	private String mainTaskUid;

	/**
	 * 任务表序号
	 */
	@Column(name = "TaskUid")
	private String taskUid;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 检查结果状态:未录入-1，待审核-2，审核退回-3，不通过-4，已公示-5
	 */
	@Column(name = "AuditState")
	private String auditState;

	/**
	 * 核查方式
	 */
	@Column(name = "CheckType")
	private String checkType;

	/**
	 * 检查执行部门编码
	 */
	@Column(name = "CheckDeptCode")
	private String checkDeptCode;

	/**
	 * 检查执行部门描述
	 */
	@Column(name = "CheckDeptName")
	private String checkDeptName;

	/**
	 * 检查人员
	 */
	@Column(name = "CheckDeptPerson")
	private String checkDeptPerson;

	/**
	 * 检查日期
	 */
	@Column(name = "CheckDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkDate;

	/**
	 * 检查结果
	 */
	@Column(name = "CheckResult")
	private String checkResult;

	/**
	 * 后续处置措施
	 */
	@Column(name = "DisposeMss")
	private String disposeMss;

	/**
	 * 执行情况：未完结-1，已完结-2
	 */
	@Column(name = "DisposeState")
	private String disposeState;

	/**
	 * 后续处置完结日期
	 */
	@Column(name = "DisposeFinishDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date disposeFinishDate;

	/**
	 * 后续处置完结信息
	 */
	@Column(name = "DisposeFinishMss")
	private String disposeFinishMss;

	/**
	 * 录入员
	 */
	@Column(name = "EnterUserName")
	private String enterUserName;

	/**
	 * 录入日期
	 */
	@Column(name = "EnterDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date enterDate;

	/**
	 * 审核员
	 */
	@Column(name = "AuditUserName")
	private String auditUserName;

	/**
	 * 审核意见
	 */
	@Column(name = "AuditOpinion")
	private String auditOpinion;

	/**
	 * 审核时间
	 */
	@Column(name = "AuditDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date auditDate;

	/**
	 * 检查表是否设置
	 */
	@Column(name = "CheckTableFlag")
	private String checkTableFlag;

	/**
	 * 通知书阅读方式
	 */
	@Column(name = "ReadType")
	private String readType;

	/**
	 * 检查结果表设置人姓名
	 */
	@Column(name = "CheckTableSetUser")
	private String checkTableSetUser;

	/**
	 * 检查结果表设置时间
	 */
	@Column(name = "CheckTableSetTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date checkTableSetTime;

	/**
	 * 通知书是否设置
	 */
	@Column(name = "AdmissionFlag")
	private String admissionFlag;

	/**
	 * 通知书设置人姓名
	 */
	@Column(name = "AdmissionSetUser")
	private String admissionSetUser;

	/**
	 * 通知书设置时间
	 */
	@Column(name = "AdmissionSetTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date admissionSetTime;

	/**
	 * 最近设置人(预查比对，通知书，检查表)
	 */
	@Column(name = "SetUserName")
	private String setUserName;

	/**
	 * 最近设置时间(预查比对，通知书，检查表)
	 */
	@Column(name = "SetTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date setTime;

	/**
	 * 组长
	 */
	@Column(name = "TeamLeader")
	private String teamLeader;

	/**
	 * 专家（多个已都好隔开）
	 */
	@Column(name = "ExpertNames")
	private String expertNames;

	/**
	 * 调整用户uid
	 */
	@Column(name = "AdjustUserUid")
	private String adjustUserUid;

	/**
	 * 调整人姓名
	 */
	@Column(name = "AdjustUserName")
	private String adjustUserName;

	/**
	 * 调整时间
	 */
	@Column(name = "AdjustTime")
	private String adjustTime;
	
	/**
	 * 已已抽取企业UID
	 */
	@Column(name = "ScentUid")
	private String scentUid;
	
	/**
	 * 需要准备材料
	 */
	@Column(name = "Materials")
	private String materials;

	public String getCheckTableSetUser() {
		return checkTableSetUser;
	}

	public void setCheckTableSetUser(String checkTableSetUser) {
		this.checkTableSetUser = checkTableSetUser;
	}

	public Date getCheckTableSetTime() {
		return checkTableSetTime;
	}

	public void setCheckTableSetTime(Date checkTableSetTime) {
		this.checkTableSetTime = checkTableSetTime;
	}

	public String getAdmissionSetUser() {
		return admissionSetUser;
	}

	public void setAdmissionSetUser(String admissionSetUser) {
		this.admissionSetUser = admissionSetUser;
	}

	public Date getAdmissionSetTime() {
		return admissionSetTime;
	}

	public void setAdmissionSetTime(Date admissionSetTime) {
		this.admissionSetTime = admissionSetTime;
	}

	public String getDisposeFinishMss() {
		return disposeFinishMss;
	}

	public void setDisposeFinishMss(String disposeFinishMss) {
		this.disposeFinishMss = disposeFinishMss;
	}

	private static final long serialVersionUID = 1L;

	/**
	 * 获取自增长序号
	 *
	 * @return id - 自增长序号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增长序号
	 *
	 * @param id
	 *            自增长序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取序号：UUID
	 *
	 * @return Uid - 序号：UUID
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * 设置序号：UUID
	 *
	 * @param uid
	 *            序号：UUID
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * 获取任务表序号
	 *
	 * @return TaskUid - 任务表序号
	 */
	public String getTaskUid() {
		return taskUid;
	}

	/**
	 * 设置任务表序号
	 *
	 * @param taskUid
	 *            任务表序号
	 */
	public void setTaskUid(String taskUid) {
		this.taskUid = taskUid;
	}

	/**
	 * 获取主体身份代码
	 *
	 * @return PriPID - 主体身份代码
	 */
	public String getPriPID() {
		return priPID;
	}

	/**
	 * 设置主体身份代码
	 *
	 * @param priPID
	 *            主体身份代码
	 */
	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	/**
	 * 获取检查结果状态:未录入-1，待审核-2，审核退回-3，不通过-4，已公示-5
	 *
	 * @return AuditState - 检查结果状态:未录入-1，待审核-2，审核退回-3，不通过-4，已公示-5
	 */
	public String getAuditState() {
		return auditState;
	}

	/**
	 * 设置检查结果状态:未录入-1，待审核-2，审核退回-3，不通过-4，已公示-5
	 *
	 * @param auditState
	 *            检查结果状态:未录入-1，待审核-2，审核退回-3，不通过-4，已公示-5
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	/**
	 * 获取核查方式
	 *
	 * @return CheckType - 核查方式
	 */
	public String getCheckType() {
		return checkType;
	}

	/**
	 * 设置核查方式
	 *
	 * @param checkType
	 *            核查方式
	 */
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	/**
	 * 获取检查执行部门编码
	 *
	 * @return CheckDeptCode - 检查执行部门编码
	 */
	public String getCheckDeptCode() {
		return checkDeptCode;
	}

	/**
	 * 设置检查执行部门编码
	 *
	 * @param checkDeptCode
	 *            检查执行部门编码
	 */
	public void setCheckDeptCode(String checkDeptCode) {
		this.checkDeptCode = checkDeptCode;
	}

	/**
	 * 获取检查执行部门描述
	 *
	 * @return CheckDeptName - 检查执行部门描述
	 */
	public String getCheckDeptName() {
		return checkDeptName;
	}

	/**
	 * 设置检查执行部门描述
	 *
	 * @param checkDeptName
	 *            检查执行部门描述
	 */
	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
	}

	/**
	 * 获取检查人员
	 *
	 * @return CheckDeptPerson - 检查人员
	 */
	public String getCheckDeptPerson() {
		return checkDeptPerson;
	}

	/**
	 * 设置检查人员
	 *
	 * @param checkDeptPerson
	 *            检查人员
	 */
	public void setCheckDeptPerson(String checkDeptPerson) {
		this.checkDeptPerson = checkDeptPerson;
	}

	/**
	 * 获取检查日期
	 *
	 * @return CheckDate - 检查日期
	 */
	public Date getCheckDate() {
		return checkDate;
	}

	/**
	 * 设置检查日期
	 *
	 * @param checkDate
	 *            检查日期
	 */
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	/**
	 * 获取检查结果
	 *
	 * @return CheckResult - 检查结果
	 */
	public String getCheckResult() {
		return checkResult;
	}

	/**
	 * 设置检查结果
	 *
	 * @param checkResult
	 *            检查结果
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	/**
	 * 获取后续处置措施
	 *
	 * @return DisposeMss - 后续处置措施
	 */
	public String getDisposeMss() {
		return disposeMss;
	}

	/**
	 * 设置后续处置措施
	 *
	 * @param disposeMss
	 *            后续处置措施
	 */
	public void setDisposeMss(String disposeMss) {
		this.disposeMss = disposeMss;
	}

	/**
	 * 获取执行情况：未完结-1，已完结-2
	 *
	 * @return DisposeState - 执行情况：未完结-1，已完结-2
	 */
	public String getDisposeState() {
		return disposeState;
	}

	/**
	 * 设置执行情况：未完结-1，已完结-2
	 *
	 * @param disposeState
	 *            执行情况：未完结-1，已完结-2
	 */
	public void setDisposeState(String disposeState) {
		this.disposeState = disposeState;
	}

	/**
	 * 获取后续处置完结日期
	 *
	 * @return DisposeFinishDate - 后续处置完结日期
	 */
	public Date getDisposeFinishDate() {
		return disposeFinishDate;
	}

	/**
	 * 设置后续处置完结日期
	 *
	 * @param disposeFinishDate
	 *            后续处置完结日期
	 */
	public void setDisposeFinishDate(Date disposeFinishDate) {
		this.disposeFinishDate = disposeFinishDate;
	}

	/**
	 * 获取录入员
	 *
	 * @return EnterUserName - 录入员
	 */
	public String getEnterUserName() {
		return enterUserName;
	}

	/**
	 * 设置录入员
	 *
	 * @param enterUserName
	 *            录入员
	 */
	public void setEnterUserName(String enterUserName) {
		this.enterUserName = enterUserName;
	}

	/**
	 * 获取录入日期
	 *
	 * @return EnterDate - 录入日期
	 */
	public Date getEnterDate() {
		return enterDate;
	}

	/**
	 * 设置录入日期
	 *
	 * @param enterDate
	 *            录入日期
	 */
	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	/**
	 * 获取审核员
	 *
	 * @return AuditUserName - 审核员
	 */
	public String getAuditUserName() {
		return auditUserName;
	}

	/**
	 * 设置审核员
	 *
	 * @param auditUserName
	 *            审核员
	 */
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	/**
	 * 获取审核意见
	 *
	 * @return AuditOpinion - 审核意见
	 */
	public String getAuditOpinion() {
		return auditOpinion;
	}

	/**
	 * 设置审核意见
	 *
	 * @param auditOpinion
	 *            审核意见
	 */
	public void setAuditOpinion(String auditOpinion) {
		this.auditOpinion = auditOpinion;
	}

	/**
	 * 获取审核时间
	 *
	 * @return AuditDate - 审核时间
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * 设置审核时间
	 *
	 * @param auditDate
	 *            审核时间
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getCheckTableFlag() {
		return checkTableFlag;
	}

	public void setCheckTableFlag(String checkTableFlag) {
		this.checkTableFlag = checkTableFlag;
	}

	public String getAdmissionFlag() {
		return admissionFlag;
	}

	public void setAdmissionFlag(String admissionFlag) {
		this.admissionFlag = admissionFlag;
	}

	public String getSetUserName() {
		return setUserName;
	}

	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName;
	}

	public Date getSetTime() {
		return setTime;
	}

	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	public String getReadType() {
		return readType;
	}

	public void setReadType(String readType) {
		this.readType = readType;
	}

	public String getMainTaskUid() {
		return mainTaskUid;
	}

	public void setMainTaskUid(String mainTaskUid) {
		this.mainTaskUid = mainTaskUid;
	}

	public String getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}

	public String getAdjustUserUid() {
		return adjustUserUid;
	}

	public void setAdjustUserUid(String adjustUserUid) {
		this.adjustUserUid = adjustUserUid;
	}

	public String getAdjustUserName() {
		return adjustUserName;
	}

	public void setAdjustUserName(String adjustUserName) {
		this.adjustUserName = adjustUserName;
	}

	public String getAdjustTime() {
		return adjustTime;
	}

	public void setAdjustTime(String adjustTime) {
		this.adjustTime = adjustTime;
	}

	public String getExpertNames() {
		return expertNames;
	}

	public void setExpertNames(String expertNames) {
		this.expertNames = expertNames;
	}

	public String getScentUid() {
		return scentUid;
	}

	public void setScentUid(String scentUid) {
		this.scentUid = scentUid;
	}

	public String getMaterials() {
		return materials;
	}

	public void setMaterials(String materials) {
		this.materials = materials;
	}
}