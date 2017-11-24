/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.ext.model.MidLeRep;

/**
 * 描述:    cs_mid_lerep 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public class MidLeRepDto extends MidLeRep {
	
	private String entName;
	
	private String regNo;
	
	private String linkType;
	// 限制原因类别
	private String blackType;
	//统一社会信用代码
	private String uniCode;
	//限制原因
	private String limitReason;
	//执行文号
	private String limitCaseCode;
	//执行部门
	private String limitDepartName;
	//惩罚日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8") 
	private Date publishDate;
	

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getBlackType() {
		return blackType;
	}

	public void setBlackType(String blackType) {
		this.blackType = blackType;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getLimitReason() {
		return limitReason;
	}

	public void setLimitReason(String limitReason) {
		this.limitReason = limitReason;
	}

	public String getLimitCaseCode() {
		return limitCaseCode;
	}

	public void setLimitCaseCode(String limitCaseCode) {
		this.limitCaseCode = limitCaseCode;
	}

	public String getLimitDepartName() {
		return limitDepartName;
	}

	public void setLimitDepartName(String limitDepartName) {
		this.limitDepartName = limitDepartName;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
}