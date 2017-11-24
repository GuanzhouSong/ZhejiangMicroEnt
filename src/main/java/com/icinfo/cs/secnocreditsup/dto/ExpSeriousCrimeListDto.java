/*

 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;

/**
 * 描述:    cs_exp_serious_crime_list 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
public class ExpSeriousCrimeListDto extends ExpSeriousCrimeList {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1331680191077896692L;

	//处罚案件Id-唯一标识-案件号有重复
	private String caseID;
	//处罚案件号
	private String caseNo;
	
	//列入机关（源）
	private String srcOrg;
	
	//end审核页面的标记
	private String endreview;
	private String penType;
	
	
	//处罚决定日期（源）
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date decDate;

	private String secBasedStr;

	public String getSecBasedStr() {
		return secBasedStr;
	}

	public void setSecBasedStr(String secBasedStr) {
		this.secBasedStr = secBasedStr;
	}
	
	public String getCaseNo() {
		return caseNo;
	}

	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public String getSrcOrg() {
		return srcOrg;
	}

	public void setSrcOrg(String srcOrg) {
		this.srcOrg = srcOrg;
	}

	public Date getDecDate() {
		return decDate;
	}

	public void setDecDate(Date decDate) {
		this.decDate = decDate;
	}

	public String getEndreview() {
		return endreview;
	}

	public void setEndreview(String endreview) {
		this.endreview = endreview;
	}

	public String getCaseID() {
		return caseID;
	}

	public void setCaseID(String caseID) {
		this.caseID = caseID;
	}

	public String getBusinessStatusName() {
		if("0".equals(getBusinessStatus()))
			return "待列入";
		if("1".equals(getBusinessStatus()))
			return "待初审";
		if("2".equals(getBusinessStatus()))
			return "初审不通过";
		if("3".equals(getBusinessStatus()))
			return "待审核";
		if("4".equals(getBusinessStatus()))
			return "审核通过";
		if("5".equals(getBusinessStatus()))
			return "审核不通过";
		return "";
	}

	public String getPenType() {
		return penType;
	}

	public void setPenType(String penType) {
		this.penType = penType;
	}

	
}