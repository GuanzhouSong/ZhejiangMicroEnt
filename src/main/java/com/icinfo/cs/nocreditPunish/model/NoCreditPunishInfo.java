package com.icinfo.cs.nocreditPunish.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * cs_nocredit_punishinfo 对应实体类
 * @author caoxu
 * @date 2016年10月18日
 */
@Table(name = "cs_nocredit_punishinfo")
public class NoCreditPunishInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 66071268361291780L;
	
	@Id
	@Column(name = "id")
	private Integer id;
	
	/**
     * 创建时间
     */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "CreateTime")
	private Date createTime;
	
	/**
     * 类型
     */
	@Column(name = "PunType")
	private String punType;
	
	
	/**
     * 提请人
     */
	@Column(name = "PunReqUser")
	private String punReqUser;
	
	/**
	 * 提请人id
	 */
	@Column(name = "PunReqUserCode")
	private String punReqUserCode;
	
	
	
	
	/**
     * 批次号
     */
	@Column(name = "BatchNo")
	private String batchNo;
	
	/**
     * 惩戒领域
     */
	@NotBlank
	@Column(name = "PunField")
	private String punField;
	
	/**
     * 惩戒事由
     */
	@NotBlank
	@Column(name = "PunCause")
	private String punCause;
	
	/**
     * 惩戒依据
     */
	@Column(name = "LegBasis")
	private String legBasis;
	
	/**
     * 惩戒规则
     */
	@Column(name = "PunRule")
	private String punRule;
	
	/**
     * 惩戒措施
     */
	@Column(name = "PunMea")
	private String punMea;
	
	/**
     * 法律文书号
     */
	@Column(name = "LegNo")
	private String legNo;
	
	/**
     * 文书日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "LegDate")
	private Date legDate;
	
	/**
     * 惩戒执行部门编号
     */
	@NotBlank
	@Column(name = "PunExeDeptCode")
	private String punExeDeptCode;
	
	/**
     * 惩戒执行部门
     */
	@NotBlank
	@Column(name = "PunExeDept")
	private String punExeDept;
	
	/**
     * 惩戒提请部门编号
     */
	@NotBlank
	@Column(name = "PunReqDeptCode")
	private String punReqDeptCode;
	
	/**
     * 惩戒提请部门
     */
	@NotBlank
	@Column(name = "PunReqDept")
	private String punReqDept;
	
	/**
     * 创建部门编号
     */
	@Column(name = "OperDept")
	private String operDept;
	
	/**
     * 创建部门
     */
	@Column(name = "OperDeptCode")
	private String operDeptCode;
	
	/**
     * 执行有效期起
     */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "ExeBegin")
	private Date exeBegin;
	
	/**
     * 执行有效期止
     */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "ExeEnd")
	private Date exeEnd;
	
	/**
	 * 是否终身有效
	 */
	@Column(name = "IsLife")
	private String isLife;
	
	/**
     * 附件文件名
     */
	@Column(name = "Files")
	private String files;
	
	/**
     * 是否需要反馈
     */
	@NotBlank
	@Column(name = "FeedBack")
	private String feedBack;
	
	/**
     * 联系人
     */
	@NotBlank
	@Column(name = "Contact")
	private String contact;
	
	/**
     * 联系电话
     */
	@NotBlank
	@Column(name = "Phone")
	private String phone;
	
	/**
     * 传真
     */
	@Column(name = "Fax")
	private String fax;
	
	/**
     * 邮箱
     */
	@Column(name = "Email")
	private String email;
	
	/**
     * 状态(1 有效  0 无效 2 终身有效   --审核通过之后 即变为有效)
     */
	@Column(name = "State")
	private Integer state;
	
	/**
     * 审核结果(-1 待审核 2 审核退回 0 审核通过)
     */
	@Column(name = "AuditRes")
	private String auditRes;
	
	/**
     * 审核员
     */
	@Column(name = "Auditor")
	private String auditor;
	
	/**
     * 违法性质
     */
	@Column(name = "IllegalProperty")
	private String illegalProperty;
	
	/**
     * 处理结果
     */
	@Column(name = "PunHandleRes")
	private String punHandleRes;
	
	/**
     * 违法事实
     */
	@Column(name = "IllegalFact")
	private String illegalFact;
	
	
	
	
	/**
     * 审核日期
     */
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	@Column(name = "AuditTime")
	private Date auditTime;
	
	/**
     * 审核意见
     */
	@Column(name = "AuditView")
	private String auditView;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getPunType() {
		return punType;
	}

	public void setPunType(String punType) {
		this.punType = punType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPunField() {
		return punField;
	}

	public void setPunField(String punField) {
		this.punField = punField;
	}

	public String getPunCause() {
		return punCause;
	}

	public void setPunCause(String punCause) {
		this.punCause = punCause;
	}

	public String getLegBasis() {
		return legBasis;
	}

	public void setLegBasis(String legBasis) {
		this.legBasis = legBasis;
	}

	public String getPunRule() {
		return punRule;
	}

	public void setPunRule(String punRule) {
		this.punRule = punRule;
	}

	public String getPunMea() {
		return punMea;
	}

	public void setPunMea(String punMea) {
		this.punMea = punMea;
	}

	public String getLegNo() {
		return legNo;
	}

	public void setLegNo(String legNo) {
		this.legNo = legNo;
	}

	public Date getLegDate() {
		return legDate;
	}

	public void setLegDate(Date legDate) {
		this.legDate = legDate;
	}

	public String getPunExeDeptCode() {
		return punExeDeptCode;
	}

	public void setPunExeDeptCode(String punExeDeptCode) {
		this.punExeDeptCode = punExeDeptCode;
	}

	public String getPunExeDept() {
		return punExeDept;
	}

	public void setPunExeDept(String punExeDept) {
		this.punExeDept = punExeDept;
	}

	public String getPunReqDeptCode() {
		return punReqDeptCode;
	}

	public void setPunReqDeptCode(String punReqDeptCode) {
		this.punReqDeptCode = punReqDeptCode;
	}

	public String getPunReqDept() {
		return punReqDept;
	}

	public void setPunReqDept(String punReqDept) {
		this.punReqDept = punReqDept;
	}

	public String getOperDept() {
		return operDept;
	}

	public void setOperDept(String operDept) {
		this.operDept = operDept;
	}

	public String getOperDeptCode() {
		return operDeptCode;
	}

	public void setOperDeptCode(String operDeptCode) {
		this.operDeptCode = operDeptCode;
	}

	public Date getExeBegin() {
		return exeBegin;
	}

	public void setExeBegin(Date exeBegin) {
		this.exeBegin = exeBegin;
	}

	public Date getExeEnd() {
		return exeEnd;
	}

	public void setExeEnd(Date exeEnd) {
		this.exeEnd = exeEnd;
	}

	public String getIsLife() {
		return isLife;
	}

	public void setIsLife(String isLife) {
		this.isLife = isLife;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public String getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(String feedBack) {
		this.feedBack = feedBack;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getAuditRes() {
		return auditRes;
	}

	public void setAuditRes(String auditRes) {
		this.auditRes = auditRes;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getAuditView() {
		return auditView;
	}

	public void setAuditView(String auditView) {
		this.auditView = auditView;
	}

	public String getIllegalProperty() {
		return illegalProperty;
	}

	public void setIllegalProperty(String illegalProperty) {
		this.illegalProperty = illegalProperty;
	}

	public String getPunHandleRes() {
		return punHandleRes;
	}

	public void setPunHandleRes(String punHandleRes) {
		this.punHandleRes = punHandleRes;
	}

	public String getIllegalFact() {
		return illegalFact;
	}

	public void setIllegalFact(String illegalFact) {
		this.illegalFact = illegalFact;
	}

	public String getPunReqUser() {
		return punReqUser;
	}

	public void setPunReqUser(String punReqUser) {
		this.punReqUser = punReqUser;
	}

	public String getPunReqUserCode() {
		return punReqUserCode;
	}

	public void setPunReqUserCode(String punReqUserCode) {
		this.punReqUserCode = punReqUserCode;
	} 
}
