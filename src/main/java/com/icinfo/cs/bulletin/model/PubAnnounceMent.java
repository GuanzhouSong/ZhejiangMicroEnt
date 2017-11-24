/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.bulletin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.apache.commons.lang.StringUtils;

/**
 * 描述: cs_pub_announcement 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2016年10月26日
 */
@Table(name = "cs_pub_announcement")
public class PubAnnounceMent implements Serializable {
	/**
	 * 自增序号
	 */
	@Id
	@Column(name = "id")
	private Integer id;

	/**
	 * 序号：UUID
	 */
	@Column(name = "UID")
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	private String UID;

	/**
	 * 关联公告表UID
	 */
	@Column(name = "LinkUID")
	private String linkUID;

	/**
	 * 主体身份代码
	 */
	@Column(name = "PriPID")
	private String priPID;

	/**
	 * 企业名称
	 */
	@Column(name = "EntName")
	private String entName;

	/**
	 * 审核时间
	 */
	@Column(name = "AuditDate")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date auditDate;

	/**
	 * 区域
	 */
	@Column(name = "AuditArea")
	private String auditArea;

	/**
	 * 区域
	 */
	@Column(name = "AuditDeptName")
	private String auditDeptName;

	/**
	 * 公告类型
	 */
	@Column(name = "PubType")
	private String pubType;

	/**
	 * 公告标题
	 */
	@Column(name = "PubTitle")
	private String pubTitle;

	/**
	 * 时间戳
	 */
	@Column(name = "CreateTime")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date createTime;

	@Column(name = "Year")
	private String year;

	@Column(name = "LicZone")
	private String licZone;

	/**
	 * 加密的企业名称
	 */
	@Transient
	private String entNameDesc;

	/**
	 * 加密的pubType
	 */
	@Transient
	private String pubTypeDesc;

	private static final long serialVersionUID = 1L;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLicZone() {
		return licZone;
	}

	public void setLicZone(String licZone) {
		this.licZone = licZone;
	}

	/**
	 * 获取自增序号
	 *
	 * @return id - 自增序号
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置自增序号
	 *
	 * @param id
	 *            自增序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取序号：UUID
	 *
	 * @return UID - 序号：UUID
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * 设置序号：UUID
	 *
	 * @param UID
	 *            序号：UUID
	 */
	public void setUID(String UID) {
		this.UID = UID;
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
	 * 获取企业名称
	 *
	 * @return EntName - 企业名称
	 */
	public String getEntName() {
		return entName;
	}

	/**
	 * 设置企业名称
	 *
	 * @param entName
	 *            企业名称
	 */
	public void setEntName(String entName) {
		this.entName = entName;
	}

	/**
	 * 获取审核时间
	 *
	 * @return auditDate - 审核时间
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

	/**
	 * 获取检查区域
	 *
	 * @return AuditArea - 检查区域
	 */
	public String getAuditArea() {
		return auditArea;
	}

	/**
	 * 设置检查区域
	 *
	 * @param auditArea
	 *            检查区域
	 */
	public void setAuditArea(String auditArea) {
		this.auditArea = auditArea;
	}

	/**
	 * 获取业务类型
	 *
	 * @return PubType - 业务类型
	 */
	public String getPubType() {
		return pubType;
	}

	/**
	 * 设置业务类型
	 *
	 * @param pubType
	 *            业务类型
	 */
	public void setPubType(String pubType) {
		this.pubType = pubType;
	}

	/**
	 * 获取时间戳
	 *
	 * @return CreateTime - 时间戳
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置时间戳
	 *
	 * @param createTime
	 *            时间戳
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLinkUID() {
		return linkUID;
	}

	public void setLinkUID(String linkUID) {
		this.linkUID = linkUID;
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

	public String getEntNameDesc() {
		if (StringUtils.isNotBlank(entName))
			return AESEUtil.encodeCorpid(entName);
		return null;
	}

	public void setEntNameDesc(String entNameDesc) {
		this.entNameDesc = entNameDesc;
	}

	public String getPubTypeDesc() {
		if (StringUtils.isNotBlank(pubType))
			return AESEUtil.encodeCorpid(pubType);
		return null;
	}

	public void setPubTypeDesc(String pubTypeDesc) {
		this.pubTypeDesc = pubTypeDesc;
	}

}