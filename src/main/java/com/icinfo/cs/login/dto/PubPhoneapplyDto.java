/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.dto;

import com.icinfo.cs.login.model.PubPhoneapply;

/**
 * 描述:    cs_pub_phoneapply 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class PubPhoneapplyDto extends PubPhoneapply {
	
	//TODO
	private static final long serialVersionUID = 1L;

	//登记机关
	private String regOrg;
	
	private String regOrgName;
	//管辖单位
	private String localAdm;
	
	private String localAdmName;
	//抽检机关
	private String checkDep;
	
	private String checkDepName;

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getLocalAdm() {
		return localAdm;
	}

	public void setLocalAdm(String localAdm) {
		this.localAdm = localAdm;
	}

	public String getLocalAdmName() {
		return localAdmName;
	}

	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}

	public String getCheckDep() {
		return checkDep;
	}

	public void setCheckDep(String checkDep) {
		this.checkDep = checkDep;
	}

	public String getCheckDepName() {
		return checkDepName;
	}

	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}
	
	
}