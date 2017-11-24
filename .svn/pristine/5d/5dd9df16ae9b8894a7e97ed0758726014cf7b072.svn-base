/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.opanomaly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述: cs_pub_pbopanomaly 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年10月08日
 */
@Table(name = "cs_pub_pbopanomaly")
public class PubPbopanomaly implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6020423306695659105L;

	/**
	 * 自增序号
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 名称
	 */
	@Column(name = "EntName")
	private String entName;

	/**
	 * 注册号
	 */
	@Column(name = "RegNO")
	private String regNO;

	/**
	 * 统一社会信用代码
	 */
	@Column(name = "UniSCID")
	private String uniSCID;

	/**
	 * 经营者
	 */
	@Column(name = "LeRep")
	private String leRep;

	/**
	 * 证件类型
	 */
	@Column(name = "CerType")
	private String cerType;

	/**
	 * 证件号码
	 */
	@Column(name = "CerNO")
	private String cerNO;

	/**
	 * 登记机关
	 */
	@Column(name = "RegOrg")
	private String regOrg;

	/**
	 * 属地监管工商所
	 */
	@Column(name = "LocalAdm")
	private String localAdm;

	/**
	 * 标记决定机关
	 */
	@Column(name = "DecOrg")
	private String decOrg;

	/**
	 * 标记决定机关（中文名称）
	 */
	@Column(name = "DecorgCN")
	private String decorgCN;

	/**
	 * 年度
	 */
	@Column(name = "Year")
	private Integer year;

	/**
	 * 标记事实和事由
	 */
	@Column(name = "SignRea")
	private String signRea;

	/**
	 * 设置人
	 */
	@Column(name = "SetName")
	private String setName;

	/**
	 * 系统录入上报情况 1-已补报，0-未上报
	 */
	@Column(name = "PBState")
	private String PBState;

	/**
	 * 信息来源 1-工商录入，0-系统录入
	 */
	@Column(name = "PBSource")
	private String PBSource;

	/**
	 * 时间戳
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	/**
	 * 标记日期
	 */
	@Column(name = "CogDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date cogDate;

	/**
	 * 标记经营异常状态原因
	 */
	@Column(name = "ExcpStaRes")
	private String excpStaRes;

	/**
	 * 标记经营异常状态原因（中文名称）
	 */
	@Column(name = "ExcpStaResCN")
	private String excpStaResCN;

	/**
	 * 序号：UUID
	 */
	@Column(name = "BusExcList")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String busExcList;

	@Column(name = "FirstName")
	private String firstName;// 初审人

	@Column(name = "FirstDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date firstDate;// 初审日期

	@Column(name = "FirstDept")
	private String firstDept;// 初审部门

	@Column(name = "AuditDept")
	private String auditDept;// 审核部门

	@Column(name = "FirstOpin")
	private String firstOpin;// 初审意见

	@Column(name = "AuditOpin")
	private String auditOpin;// 审核意见

	@Column(name = "AuditName")
	private String auditName;// 审核人

	@Column(name = "AuditDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date auditDate;// 审核日期

	@Column(name = "AuditState")
	private String auditState;// 审核状态：0.待审核1.予以标记异常2.不予标记异常

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
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

	public String getUniSCID() {
		return uniSCID;
	}

	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public String getCerType() {
		return cerType;
	}

	public void setCerType(String cerType) {
		this.cerType = cerType;
	}

	public String getCerNO() {
		return cerNO;
	}

	public void setCerNO(String cerNO) {
		this.cerNO = cerNO;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getDecOrg() {
		return decOrg;
	}

	public void setDecOrg(String decOrg) {
		this.decOrg = decOrg;
	}

	public String getDecorgCN() {
		return decorgCN;
	}

	public void setDecorgCN(String decorgCN) {
		this.decorgCN = decorgCN;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getSignRea() {
		return signRea;
	}

	public void setSignRea(String signRea) {
		this.signRea = signRea;
	}

	public String getSetName() {
		return setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	public String getPBState() {
		return PBState;
	}

	public void setPBState(String pBState) {
		PBState = pBState;
	}

	public String getPBSource() {
		return PBSource;
	}

	public void setPBSource(String pBSource) {
		PBSource = pBSource;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCogDate() {
		return cogDate;
	}

	public void setCogDate(Date cogDate) {
		this.cogDate = cogDate;
	}

	public String getExcpStaRes() {
		return excpStaRes;
	}

	public void setExcpStaRes(String excpStaRes) {
		this.excpStaRes = excpStaRes;
	}

	public String getExcpStaResCN() {
		return excpStaResCN;
	}

	public void setExcpStaResCN(String excpStaResCN) {
		this.excpStaResCN = excpStaResCN;
	}

	public String getBusExcList() {
		return busExcList;
	}

	public void setBusExcList(String busExcList) {
		this.busExcList = busExcList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	public String getFirstDept() {
		return firstDept;
	}

	public void setFirstDept(String firstDept) {
		this.firstDept = firstDept;
	}

	public String getFirstOpin() {
		return firstOpin;
	}

	public void setFirstOpin(String firstOpin) {
		this.firstOpin = firstOpin;
	}

	public String getAuditOpin() {
		return auditOpin;
	}

	public void setAuditOpin(String auditOpin) {
		this.auditOpin = auditOpin;
	}

	public String getAuditName() {
		return auditName;
	}

	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditState() {
		return auditState;
	}

	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	public String getAuditDept() {
		return auditDept;
	}

	public void setAuditDept(String auditDept) {
		this.auditDept = auditDept;
	}

}