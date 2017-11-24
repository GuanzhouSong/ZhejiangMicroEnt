/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.opanomaly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 描述: cs_pub_pbopadetail 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月27日
 */
@Table(name = "cs_pub_pbopadetail")
public class PubPbOpadetail implements Serializable {
	/**
	 * 自增id
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
	 * 恢复类型：1.正常恢复2.更正恢复
	 */
	@Column(name = "RecoveryType")
	private String recoveryType;

	/**
	 * 是否恢复：0.已恢复1.已标记
	 */
	@Column(name = "IsRecovery")
	private String isRecovery;

	/**
	 * 恢复正常记载的原因
	 */
	@Column(name = "NorRea")
	private String norRea;

	/**
	 * 恢复正常记载的原因(中文名称)
	 */
	@Column(name = "NorReaCN")
	private String norReaCN;

	/**
	 * 恢复决定机关
	 */
	@Column(name = "NorDecOrg")
	private String norDecOrg;

	/**
	 * 恢复决定机关中文名称
	 */
	@Column(name = "NorDecOrgCN")
	private String norDecOrgCN;

	/**
	 * 恢复日期
	 */
	@Column(name = "NorDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date norDate;

	/**
	 * 年度
	 */
	@Column(name = "Year")
	private Integer year;

	/**
	 * 恢复事实和理由
	 */
	@Column(name = "RecoverRea")
	private String recoverRea;

	/**
	 * 恢复设置人
	 */
	@Column(name = "ResetName")
	private String resetName;

	/**
	 * 初审部门
	 */
	@Column(name = "FirstDept")
	private String firstDept;

	/**
	 * 初审人员
	 */
	@Column(name = "FirstName")
	private String firstName;

	/**
	 * 初审日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	@Column(name = "FirstDate")
	private Date firstDate;

	/**
	 * 初审意见
	 */
	@Column(name = "FirstOpin")
	private String firstOpin;

	/**
	 * 审核部门
	 */
	@Column(name = "AuditDept")
	private String auditDept;

	/**
	 * 审核人员
	 */
	@Column(name = "AuditName")
	private String auditName;

	/**
	 * 审核日期
	 */
	@Column(name = "AuditDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date auditDate;

	/**
	 * 审核意见
	 */
	@Column(name = "AuditOpin")
	private String auditOpin;

	/**
	 * 审核状态：0.待审核、1.予以恢复正常、2.不予恢复正常、3.予以更正恢复、4.不予更正恢复
	 */
	@Column(name = "AuditState")
	private String auditState;

	/**
	 * 主键UUID(对应列入表中的uuid)
	 */
	@Column(name = "BusExcList")
	private String busExcList;

	/**
	 * 时间戳
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

	private static final long serialVersionUID = 1L;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取自增id
	 *
	 * @return id - 自增id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增id
	 *
	 * @param id
	 *            自增id
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * 获取恢复类型：1.正常恢复2.更正恢复
	 *
	 * @return RecoveryType - 恢复类型：1.正常恢复2.更正恢复
	 */
	public String getRecoveryType() {
		return recoveryType;
	}

	/**
	 * 设置恢复类型：1.正常恢复2.更正恢复
	 *
	 * @param recoveryType
	 *            恢复类型：1.正常恢复2.更正恢复
	 */
	public void setRecoveryType(String recoveryType) {
		this.recoveryType = recoveryType;
	}

	/**
	 * 获取是否恢复：0.已恢复1.已标记
	 *
	 * @return IsRecovery - 是否恢复：0.已恢复1.已标记
	 */
	public String getIsRecovery() {
		return isRecovery;
	}

	/**
	 * 设置是否恢复：0.已恢复1.已标记
	 *
	 * @param isRecovery
	 *            是否恢复：0.已恢复1.已标记
	 */
	public void setIsRecovery(String isRecovery) {
		this.isRecovery = isRecovery;
	}

	/**
	 * 获取恢复正常记载的原因
	 *
	 * @return NorRea - 恢复正常记载的原因
	 */
	public String getNorRea() {
		return norRea;
	}

	/**
	 * 设置恢复正常记载的原因
	 *
	 * @param norRea
	 *            恢复正常记载的原因
	 */
	public void setNorRea(String norRea) {
		this.norRea = norRea;
	}

	/**
	 * 获取恢复正常记载的原因(中文名称)
	 *
	 * @return NorReaCN - 恢复正常记载的原因(中文名称)
	 */
	public String getNorReaCN() {
		return norReaCN;
	}

	/**
	 * 设置恢复正常记载的原因(中文名称)
	 *
	 * @param norReaCN
	 *            恢复正常记载的原因(中文名称)
	 */
	public void setNorReaCN(String norReaCN) {
		this.norReaCN = norReaCN;
	}

	/**
	 * 获取恢复决定机关
	 *
	 * @return NorDecOrg - 恢复决定机关
	 */
	public String getNorDecOrg() {
		return norDecOrg;
	}

	/**
	 * 设置恢复决定机关
	 *
	 * @param norDecOrg
	 *            恢复决定机关
	 */
	public void setNorDecOrg(String norDecOrg) {
		this.norDecOrg = norDecOrg;
	}

	/**
	 * 获取恢复决定机关中文名称
	 *
	 * @return NorDecOrgCN - 恢复决定机关中文名称
	 */
	public String getNorDecOrgCN() {
		return norDecOrgCN;
	}

	/**
	 * 设置恢复决定机关中文名称
	 *
	 * @param norDecOrgCN
	 *            恢复决定机关中文名称
	 */
	public void setNorDecOrgCN(String norDecOrgCN) {
		this.norDecOrgCN = norDecOrgCN;
	}

	/**
	 * 获取恢复日期
	 *
	 * @return NorDate - 恢复日期
	 */
	public Date getNorDate() {
		return norDate;
	}

	/**
	 * 设置恢复日期
	 *
	 * @param norDate
	 *            恢复日期
	 */
	public void setNorDate(Date norDate) {
		this.norDate = norDate;
	}

	/**
	 * 获取年度
	 *
	 * @return Year - 年度
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * 设置年度
	 *
	 * @param year
	 *            年度
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * 获取恢复事实和理由
	 *
	 * @return RecoverRea - 恢复事实和理由
	 */
	public String getRecoverRea() {
		return recoverRea;
	}

	/**
	 * 设置恢复事实和理由
	 *
	 * @param recoverRea
	 *            恢复事实和理由
	 */
	public void setRecoverRea(String recoverRea) {
		this.recoverRea = recoverRea;
	}

	/**
	 * 获取恢复设置人
	 *
	 * @return ResetName - 恢复设置人
	 */
	public String getResetName() {
		return resetName;
	}

	/**
	 * 设置恢复设置人
	 *
	 * @param resetName
	 *            恢复设置人
	 */
	public void setResetName(String resetName) {
		this.resetName = resetName;
	}

	/**
	 * 获取初审部门
	 *
	 * @return FirstDept - 初审部门
	 */
	public String getFirstDept() {
		return firstDept;
	}

	/**
	 * 设置初审部门
	 *
	 * @param firstDept
	 *            初审部门
	 */
	public void setFirstDept(String firstDept) {
		this.firstDept = firstDept;
	}

	/**
	 * 获取初审人员
	 *
	 * @return FirstName - 初审人员
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 设置初审人员
	 *
	 * @param firstName
	 *            初审人员
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 获取初审日期
	 *
	 * @return FirstDate - 初审日期
	 */
	public Date getFirstDate() {
		return firstDate;
	}

	/**
	 * 设置初审日期
	 *
	 * @param firstDate
	 *            初审日期
	 */
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}

	/**
	 * 获取初审意见
	 *
	 * @return FirstOpin - 初审意见
	 */
	public String getFirstOpin() {
		return firstOpin;
	}

	/**
	 * 设置初审意见
	 *
	 * @param firstOpin
	 *            初审意见
	 */
	public void setFirstOpin(String firstOpin) {
		this.firstOpin = firstOpin;
	}

	/**
	 * 获取审核部门
	 *
	 * @return AuditDept - 审核部门
	 */
	public String getAuditDept() {
		return auditDept;
	}

	/**
	 * 设置审核部门
	 *
	 * @param auditDept
	 *            审核部门
	 */
	public void setAuditDept(String auditDept) {
		this.auditDept = auditDept;
	}

	/**
	 * 获取审核人员
	 *
	 * @return AuditName - 审核人员
	 */
	public String getAuditName() {
		return auditName;
	}

	/**
	 * 设置审核人员
	 *
	 * @param auditName
	 *            审核人员
	 */
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}

	/**
	 * 获取审核日期
	 *
	 * @return AuditDate - 审核日期
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * 设置审核日期
	 *
	 * @param auditDate
	 *            审核日期
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * 获取审核意见
	 *
	 * @return AuditOpin - 审核意见
	 */
	public String getAuditOpin() {
		return auditOpin;
	}

	/**
	 * 设置审核意见
	 *
	 * @param auditOpin
	 *            审核意见
	 */
	public void setAuditOpin(String auditOpin) {
		this.auditOpin = auditOpin;
	}

	/**
	 * 获取审核状态：0.待审核、1.予以恢复正常、2.不予恢复正常、3.予以更正恢复、4.不予更正恢复
	 *
	 * @return AuditState - 审核状态：0.待审核、1.予以恢复正常、2.不予恢复正常、3.予以更正恢复、4.不予更正恢复
	 */
	public String getAuditState() {
		return auditState;
	}

	/**
	 * 设置审核状态：0.待审核、1.予以恢复正常、2.不予恢复正常、3.予以更正恢复、4.不予更正恢复
	 *
	 * @param auditState
	 *            审核状态：0.待审核、1.予以恢复正常、2.不予恢复正常、3.予以更正恢复、4.不予更正恢复
	 */
	public void setAuditState(String auditState) {
		this.auditState = auditState;
	}

	/**
	 * 获取主键UUID(对应列入表中的uuid)
	 *
	 * @return BusExcList - 主键UUID(对应列入表中的uuid)
	 */
	public String getBusExcList() {
		return busExcList;
	}

	/**
	 * 设置主键UUID(对应列入表中的uuid)
	 *
	 * @param busExcList
	 *            主键UUID(对应列入表中的uuid)
	 */
	public void setBusExcList(String busExcList) {
		this.busExcList = busExcList;
	}
}