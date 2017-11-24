/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptdto;

import java.math.BigDecimal;

import com.icinfo.cs.rpt.rptmodel.YrRpt;

/**
 * 描述:    cs_rpt_yr 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@SuppressWarnings("serial")
public class YrRptDto extends YrRpt {
	
	//地区名称
	private String areaName;
	//登记机关名称(部门名称) 
    private String regOrgName;
    //实际应年报数
    private Long yrAmountSure;
    //年初应年报数
    private Long yrAmountIniSure;
    //未年报数
    private BigDecimal notreported;
    //部门编码
    private  String deptcode;
    //报送年月
    private  String monthCode; 
    
    public String getMonthCode() {
		return monthCode;
	}
	public void setMonthCode(String monthCode) {
		this.monthCode = monthCode;
	}

	//自然年报率
    private BigDecimal usualreportRay;
    
    //工作年报率
    private BigDecimal workreportRay;
	
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
	public Long getYrAmountSure() {
		return yrAmountSure;
	}
	public void setYrAmountSure(Long yrAmountSure) {
		this.yrAmountSure = yrAmountSure;
	}
	public Long getYrAmountIniSure() {
		return yrAmountIniSure;
	}
	public void setYrAmountIniSure(Long yrAmountIniSure) {
		this.yrAmountIniSure = yrAmountIniSure;
	}
	
	
	public void setNotreported(BigDecimal notreported) {
		this.notreported = notreported;
	}
	
	public BigDecimal getNotreported() {
		return notreported;
	}
    
	
	public void setUsualreportRay(BigDecimal usualreportRay) {
		this.usualreportRay = usualreportRay;
	}
	
	public BigDecimal getUsualreportRay() {
		return usualreportRay;
	}
	
	public void setWorkreportRay(BigDecimal workreportRay) {
		this.workreportRay = workreportRay;
	}
	public BigDecimal getWorkreportRay() {
		return workreportRay;
	}
    
	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}
	
	public String getDeptcode() {
		return deptcode;
	}

	
}