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
 * 描述: cs_daily_inspect_result 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年11月01日
 */
@Table(name = "cs_daily_inspect_result")
public class DailyInspectResult implements Serializable {
	/**
	 * 主键
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * uuid
	 */
	@Column(name = "uid")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String uid;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 检查结果状态:未录入-1，已录入-5
	 */
	@Column(name = "AuditState")
	private String auditState;

	/**
	 * 后续处置状态：未完结-1，已完结-2
	 */
	@Column(name = "DisposeState")
	private String disposeState;

	/**
	 * 任务来源：1交办转办、2投诉举报、3日常巡查、4数据监测
	 */
	@Column(name = "TaskSource")
	private String taskSource;

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
	 * 检查人员
	 */
	@Column(name = "CheckDeptPerson")
	private String checkDeptPerson;

	/**
	 * 检查执行部门编码
	 */
	@Column(name = "CheckDeptCode")
	private String checkDeptCode;

	/**
	 * 检查执行部门名称
	 */
	@Column(name = "CheckDeptName")
	private String checkDeptName;

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
	 * 检查对象类型：1企业2无证无照户3非企业单位
	 */
	@Column(name = "CheckObjType")
	private String checkObjType;

	@Column(name = "State")
	private String state;

	@Column(name = "CidRegNO")
	private String cidRegNO;

	@Column(name = "Dom")
	private String dom;

	@Column(name = "Lerep")
	private String lerep;

	@Column(name = "Tel")
	private String tel;

	@Column(name = "LiaName")
	private String liaName;

	@Column(name = "LiaTel")
	private String liaTel;

	@Column(name = "Complainter")
	private String complainter;

	@Column(name = "ComplainterTel")
	private String complainterTel;

	@Column(name = "ComplaintType")
	private String complaintType;

	@Column(name = "ComplaintDate")
	private Date complaintDate;

	@Column(name = "ComplaintContent")
	private String complaintContent;

	@Column(name = "CheckObj")
	private String checkObj;

	@Column(name = "CheckType")
	private String checkType;

	@Column(name = "DisposeMss")
	private String disposeMss;

	@Column(name = "CheckOrgCode")
	private String checkOrgCode;

	@Column(name = "CheckOrgName")
	private String checkOrgName;

	@Column(name = "DisposeFinishDate")
	private Date disposeFinishDate;

	@Column(name = "AlterContent")
	private String alterContent;

	@Column(name = "AlterDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date alterDate;

	@Column(name = "AlterUserName")
	private String alterUserName;

	@Column(name = "DisposeFinishMss")
	private String disposeFinishMss;

	private static final long serialVersionUID = 1L;

	public Date getDisposeFinishDate() {
		return disposeFinishDate;
	}

	public void setDisposeFinishDate(Date disposeFinishDate) {
		this.disposeFinishDate = disposeFinishDate;
	}

	public String getAlterContent() {
		return alterContent;
	}

	public void setAlterContent(String alterContent) {
		this.alterContent = alterContent;
	}

	public Date getAlterDate() {
		return alterDate;
	}

	public void setAlterDate(Date alterDate) {
		this.alterDate = alterDate;
	}

	public String getAlterUserName() {
		return alterUserName;
	}

	public void setAlterUserName(String alterUserName) {
		this.alterUserName = alterUserName;
	}

	public String getDisposeFinishMss() {
		return disposeFinishMss;
	}

	public void setDisposeFinishMss(String disposeFinishMss) {
		this.disposeFinishMss = disposeFinishMss;
	}

	public String getCidRegNO() {
		return cidRegNO;
	}

	public void setCidRegNO(String cidRegNO) {
		this.cidRegNO = cidRegNO;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getLerep() {
		return lerep;
	}

	public void setLerep(String lerep) {
		this.lerep = lerep;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getLiaTel() {
		return liaTel;
	}

	public void setLiaTel(String liaTel) {
		this.liaTel = liaTel;
	}

	public String getComplainter() {
		return complainter;
	}

	public void setComplainter(String complainter) {
		this.complainter = complainter;
	}

	public String getComplainterTel() {
		return complainterTel;
	}

	public void setComplainterTel(String complainterTel) {
		this.complainterTel = complainterTel;
	}

	public String getComplaintType() {
		return complaintType;
	}

	public void setComplaintType(String complaintType) {
		this.complaintType = complaintType;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getComplaintContent() {
		return complaintContent;
	}

	public void setComplaintContent(String complaintContent) {
		this.complaintContent = complaintContent;
	}

	public String getCheckObj() {
		return checkObj;
	}

	public void setCheckObj(String checkObj) {
		this.checkObj = checkObj;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public String getDisposeMss() {
		return disposeMss;
	}

	public void setDisposeMss(String disposeMss) {
		this.disposeMss = disposeMss;
	}

	public String getCheckOrgCode() {
		return checkOrgCode;
	}

	public void setCheckOrgCode(String checkOrgCode) {
		this.checkOrgCode = checkOrgCode;
	}

	public String getCheckOrgName() {
		return checkOrgName;
	}

	public void setCheckOrgName(String checkOrgName) {
		this.checkOrgName = checkOrgName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 获取主键
	 *
	 * @return id - 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置主键
	 *
	 * @param id
	 *            主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取uuid
	 *
	 * @return uid - uuid
	 */
	public String getUid() {
		return uid;
	}

	public String getCheckObjType() {
		return checkObjType;
	}

	public void setCheckObjType(String checkObjType) {
		this.checkObjType = checkObjType;
	}

	/**
	 * 设置uuid
	 *
	 * @param uid
	 *            uuid
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * 获取后续处置状态：未完结-1，已完结-2
	 *
	 * @return DisposeState - 后续处置状态：未完结-1，已完结-2
	 */
	public String getDisposeState() {
		return disposeState;
	}

	/**
	 * 设置后续处置状态：未完结-1，已完结-2
	 *
	 * @param disposeState
	 *            后续处置状态：未完结-1，已完结-2
	 */
	public void setDisposeState(String disposeState) {
		this.disposeState = disposeState;
	}

	/**
	 * 获取任务来源：1交办转办、2投诉举报、3日常巡查、4数据监测
	 *
	 * @return TaskSource - 任务来源：1交办转办、2投诉举报、3日常巡查、4数据监测
	 */
	public String getTaskSource() {
		return taskSource;
	}

	/**
	 * 设置任务来源：1交办转办、2投诉举报、3日常巡查、4数据监测
	 *
	 * @param taskSource
	 *            任务来源：1交办转办、2投诉举报、3日常巡查、4数据监测
	 */
	public void setTaskSource(String taskSource) {
		this.taskSource = taskSource;
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
	 * 获取检查执行部门名称
	 *
	 * @return CheckDeptName - 检查执行部门名称
	 */
	public String getCheckDeptName() {
		return checkDeptName;
	}

	/**
	 * 设置检查执行部门名称
	 *
	 * @param checkDeptName
	 *            检查执行部门名称
	 */
	public void setCheckDeptName(String checkDeptName) {
		this.checkDeptName = checkDeptName;
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
}