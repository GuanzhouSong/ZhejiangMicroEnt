/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.registinfo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: cs_regist_mark 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年09月09日
 */
@Table(name = "cs_regist_mark")
public class RegistMark implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "MarkUuid")
	@Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String markUuid;
	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	public String getMarkUuid() {
		return markUuid;
	}

	public void setMarkUuid(String markUuid) {
		this.markUuid = markUuid;
	}

	public String getIDDesc() {
		return IDDesc;
	}

	public void setIDDesc(String iDDesc) {
		IDDesc = iDDesc;
	}

	public String getIDStateCode() {
		return IDStateCode;
	}

	public void setIDStateCode(String iDStateCode) {
		IDStateCode = iDStateCode;
	}

	public String getAuditorId() {
		return auditorId;
	}

	public void setAuditorId(String auditorId) {
		this.auditorId = auditorId;
	}

	public String getAuditorName() {
		return auditorName;
	}

	public void setAuditorName(String auditorName) {
		this.auditorName = auditorName;
	}

	public String getAuditorDesc() {
		return auditorDesc;
	}

	public void setAuditorDesc(String auditorDesc) {
		this.auditorDesc = auditorDesc;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public Date getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}

	public String getApplicationScopeCode() {
		return applicationScopeCode;
	}

	public void setApplicationScopeCode(String applicationScopeCode) {
		this.applicationScopeCode = applicationScopeCode;
	}

	public String getApplicationScopeName() {
		return applicationScopeName;
	}

	public void setApplicationScopeName(String applicationScopeName) {
		this.applicationScopeName = applicationScopeName;
	}

	public String getAuditDeptId() {
		return auditDeptId;
	}

	public void setAuditDeptId(String auditDeptId) {
		this.auditDeptId = auditDeptId;
	}

	public String getAuditDeptName() {
		return auditDeptName;
	}

	public void setAuditDeptName(String auditDeptName) {
		this.auditDeptName = auditDeptName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 设置部门编号
	 */
	@Column(name = "SetDeptCode")
	private String setDeptCode;

	/**
	 * 标签名称
	 */
	@Column(name = "IDName")
	private String IDName;
	/**
	 * 标签类型
	 */
	@Column(name = "IDType")
	private String IDType;
	/**
	 * 标签编号
	 */
	@Column(name = "IDCode")
	private String IDCode;

	/**
	 * 创建时间
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 设置时间
	 */
	@Column(name = "SetTime")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date setTime;

	/**
	 * 设置人名称
	 */
	@Column(name = "SetName")
	private String setName;

	/**
	 * 设置人ID
	 */
	@Column(name = "SetId")
	private String setId;

	/**
	 * 设置部门名称
	 */
	@Column(name = "SetDeptname")
	private String setDeptname;

	@Column(name = "IDDesc")
	private String IDDesc;

	@Column(name = "IDStateCode")
	private String IDStateCode;

	@Column(name = "AuditorId")
	private String auditorId;

	@Column(name = "AuditorName")
	private String auditorName;

	@Column(name = "AuditorDesc")
	private String auditorDesc;

	@Column(name = "AuditState")
	private String auditState;

	@Column(name = "AuditTime")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date auditTime;

	@Column(name = "ApplicationScopeCode")
	private String applicationScopeCode;

	@Column(name = "ApplicationScopeName")
	private String applicationScopeName;

	@Column(name = "AuditDeptId")
	private String auditDeptId;

	@Column(name = "AuditDeptName")
	private String auditDeptName;

	@Column(name = "UpdateTime")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private String updateTime;

	@Column(name = "ValidDate")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date validDate;

	@Column(name = "DoublyStoState")
	private String doublyStoState;

	@Column(name = "DoublyStoFirCode")
	private String doublyStoFirCode;

	@Column(name = "DoublyStoFirName")
	private String doublyStoFirName;

	@Column(name = "DoublyStoSecCode")
	private String doublyStoSecCode;

	@Column(name = "DoublyStoSecName")
	private String doublyStoSecName;

	@Column(name = "DoublyStoThiCode")
	private String doublyStoThiCode;

	@Column(name = "DoublyStoThiName")
	private String doublyStoThiName;

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(Date validDate) {
		this.validDate = validDate;
	}

	public String getDoublyStoState() {
		return doublyStoState;
	}

	public void setDoublyStoState(String doublyStoState) {
		this.doublyStoState = doublyStoState;
	}

	public String getDoublyStoFirCode() {
		return doublyStoFirCode;
	}

	public void setDoublyStoFirCode(String doublyStoFirCode) {
		this.doublyStoFirCode = doublyStoFirCode;
	}

	public String getDoublyStoFirName() {
		return doublyStoFirName;
	}

	public void setDoublyStoFirName(String doublyStoFirName) {
		this.doublyStoFirName = doublyStoFirName;
	}

	public String getDoublyStoSecCode() {
		return doublyStoSecCode;
	}

	public void setDoublyStoSecCode(String doublyStoSecCode) {
		this.doublyStoSecCode = doublyStoSecCode;
	}

	public String getDoublyStoSecName() {
		return doublyStoSecName;
	}

	public void setDoublyStoSecName(String doublyStoSecName) {
		this.doublyStoSecName = doublyStoSecName;
	}

	public String getDoublyStoThiCode() {
		return doublyStoThiCode;
	}

	public void setDoublyStoThiCode(String doublyStoThiCode) {
		this.doublyStoThiCode = doublyStoThiCode;
	}

	public String getDoublyStoThiName() {
		return doublyStoThiName;
	}

	public void setDoublyStoThiName(String doublyStoThiName) {
		this.doublyStoThiName = doublyStoThiName;
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
	 * 获取设置部门编号
	 *
	 * @return SetDeptCode - 设置部门编号
	 */
	public String getSetDeptCode() {
		return setDeptCode;
	}

	/**
	 * 设置设置部门编号
	 *
	 * @param setDeptCode
	 *            设置部门编号
	 */
	public void setSetDeptCode(String setDeptCode) {
		this.setDeptCode = setDeptCode;
	}

	/**
	 * 获取标签名称
	 *
	 * @return IDName - 标签名称
	 */
	public String getIDName() {
		return IDName;
	}

	/**
	 * 设置标签名称
	 *
	 * @param IDName
	 *            标签名称
	 */
	public void setIDName(String IDName) {
		this.IDName = IDName;
	}

	/**
	 * 获取标签编号
	 *
	 * @return IDCode - 标签编号
	 */
	public String getIDCode() {
		return IDCode;
	}

	/**
	 * 设置标签编号
	 *
	 * @param IDCode
	 *            标签编号
	 */
	public void setIDCode(String IDCode) {
		this.IDCode = IDCode;
	}

	/**
	 * 获取创建时间
	 *
	 * @return CreateTime - 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 *
	 * @param createTime
	 *            创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取设置时间
	 *
	 * @return SetTime - 设置时间
	 */
	public Date getSetTime() {
		return setTime;
	}

	/**
	 * 设置设置时间
	 *
	 * @param setTime
	 *            设置时间
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}

	/**
	 * 获取设置人名称
	 *
	 * @return SetName - 设置人名称
	 */
	public String getSetName() {
		return setName;
	}

	/**
	 * 设置设置人名称
	 *
	 * @param setName
	 *            设置人名称
	 */
	public void setSetName(String setName) {
		this.setName = setName;
	}

	/**
	 * 获取设置人ID
	 *
	 * @return SetId - 设置人ID
	 */
	public String getSetId() {
		return setId;
	}

	/**
	 * 设置设置人ID
	 *
	 * @param setId
	 *            设置人ID
	 */
	public void setSetId(String setId) {
		this.setId = setId;
	}

	/**
	 * 获取设置部门名称
	 *
	 * @return SetDeptname - 设置部门名称
	 */
	public String getSetDeptname() {
		return setDeptname;
	}

	/**
	 * 设置设置部门名称
	 *
	 * @param setDeptname
	 *            设置部门名称
	 */
	public void setSetDeptname(String setDeptname) {
		this.setDeptname = setDeptname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIDType() {
		return IDType;
	}

	public void setIDType(String IDType) {
		this.IDType = IDType;
	}
}