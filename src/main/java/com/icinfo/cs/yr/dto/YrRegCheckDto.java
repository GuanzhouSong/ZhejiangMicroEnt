/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.yr.model.YrRegCheck;

/**
 * 描述:    cs_yr_reg_check 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class YrRegCheckDto extends YrRegCheck {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//登记机关描述
	private String regOrgName;
	
    //管辖单位描述
	private String localAdmName;
	
	//企业类型描述
	private String entTypeCatgDesc;
	
	//抽查机关描述
	private String checkDepDesc;
	
	//片区名称
	private String sliceNOName;
	
	private String auditUser;//审核人
	
	//黄色图标截止日期（4个工作日内）
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private String yellowDate;
	//红色图标截止日期（超过5 个工作日）
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    
	private String redDate;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	private Date auditDate;//审核时间

	public String getYellowDate() {
		return yellowDate;
	}

	public void setYellowDate(String yellowDate) {
		this.yellowDate = yellowDate;
	}

	public String getRedDate() {
		return redDate;
	}

	public void setRedDate(String redDate) {
		this.redDate = redDate;
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

	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}

	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}

	public String getCheckDepDesc() {
		return checkDepDesc;
	}

	public void setCheckDepDesc(String checkDepDesc) {
		this.checkDepDesc = checkDepDesc;
	}

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}
	
	
	
}