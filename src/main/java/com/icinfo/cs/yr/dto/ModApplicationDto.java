/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.ModApplication;

/**
 * 描述:    cs_mod_application 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月11日
 */
public class ModApplicationDto extends ModApplication {

	//登记机关
	private String regOrg;
	//登记机关描述
	private String regOrgName;
	//管辖单位
	private String localAdm;
	//管辖单位描述
	private String localAdmName;
	//抽检机关
	private String checkDep;
	//抽检机关描述
	private String checkDepName;
	//注册号
	private String regNo;
	//年报状态
	private String reportState;
	//当前审核时间
	private String currentDate;
	//企业小类
	private String entType;
	//企业大类
	private String entTypeCatg;
	

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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getReportState() {
		return reportState;
	}

	public void setReportState(String reportState) {
		this.reportState = reportState;
	}

	public String getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}
}