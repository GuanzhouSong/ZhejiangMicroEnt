/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptdto;

import java.math.BigDecimal;

import com.icinfo.cs.rpt.rptmodel.OpanoMalyRpt;

/**
 * 描述:    cs_rpt_opanomaly 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public class OpanoMalyRptDto extends OpanoMalyRpt {
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * 描述:  
	 */
	private static final long serialVersionUID = 1L;
	//地区名称
	private String areaName;
	//登记机关名称(部门名称) 
    private String regOrgName;
    //列入异常条数
    private  BigDecimal inReasonCoutNum; 
    
	public BigDecimal getInReasonCoutNum() {
		return inReasonCoutNum;
	}
	public void setInReasonCoutNum(BigDecimal inReasonCoutNum) {
		this.inReasonCoutNum = inReasonCoutNum;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getRegOrgName() {
		return regOrgName;
	}
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
}