/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.yr.model.PubExcludeEnt;

/**
 * 描述: cs_pub_excludeent 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public class PubExcludeEntDto extends PubExcludeEnt {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4944313670676412125L;
	// 统一代码/注册号
	private String uniCode;
	// 企业名称
	private String entName;
	// 法定代表人
	private String leRep;
	// 成立日期
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date estDate;
	// 登记状态
	private String regState;
	// 登记机关编号
	private String regOrg;
	// 登记机关名称
	private String regOrgName;
	// 管辖单位编号
	private String localAdm;
	// 管辖单位名称
	private String localAdmName;

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
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

}