/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.dto;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.sment.model.EntarchivesHis;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives_his 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public class EntarchivesHisDto extends EntarchivesHis {
	
	
    private String regNO;
	
	private String entName;
	
	private String industryCoName;
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date estDate;
	
	private String entTypeName;
	
	private String regCap;
	
	private String regOrgName;
	
	private String localAdmName;
	
	private String empNum;
	
	private String vendInc;

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
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

	public String getEmpNum() {
		return empNum;
	}

	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	public String getVendInc() {
		return vendInc;
	}

	public void setVendInc(String vendInc) {
		this.vendInc = vendInc;
	}
	
	
}