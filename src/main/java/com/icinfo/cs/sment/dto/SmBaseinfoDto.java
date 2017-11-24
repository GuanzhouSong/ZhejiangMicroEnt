/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.sment.model.SmBaseinfo;

/**
 * 描述: cs_sm_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public class SmBaseinfoDto extends SmBaseinfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6789770466234302778L;

	/** 营业总收入 */
	private BigDecimal vendInc;

	/** 行业 */
	private String industryCoName;

	/** 企业类型 */
	private String entTypeName;

	/** 来源类型 */
	private String sourceType;

	private String industryName;// 产业名称
	private String cultivationTypeName;// 培育库名称
	private int helpNum;// 培育需求类别数量
	private int helpTypeNum;// 帮扶数量
	private String helpState;// 帮扶状态
	
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date ancheDate;// 公示日期
	private String year;// 年度
	
    
	/** 企业大类类型（小微企业大类） */
	private String entTypeCatgName;
	/** 三大产业 */
	private String industryCodeName;
	/**
     * 应年报数
     */
    private BigDecimal rptCount;

    /**
     * 已年报数
     */
    private BigDecimal isRptCount;
    /**
     *开业数
     */
    private BigDecimal busstatus;
    
    //资产总额
    private BigDecimal assGro;
    //固定资产总额
    private BigDecimal fixAssets;
    //负债总额
    private BigDecimal liaGro;
    //利润总额
    private BigDecimal proGro;
    //净利润
    private BigDecimal netInc;
    //盈利企业个数
    private BigDecimal  addProCount;
    //亏损企业数
    private BigDecimal  minuProCount;
    //纳税总额
    private BigDecimal ratGro;
    
    //年报率:已年报数/应年报数
    private BigDecimal yreportRay;

    //开业率：开业数/已年报数
    private BigDecimal busstatusRay;
    
    //资产负债率：负债总额/资产总额
    private BigDecimal assliaRay;


	
	

	public Date getAncheDate() {
		return ancheDate;
	}

	public void setAncheDate(Date ancheDate) {
		this.ancheDate = ancheDate;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	public String getCultivationTypeName() {
		return cultivationTypeName;
	}

	public void setCultivationTypeName(String cultivationTypeName) {
		this.cultivationTypeName = cultivationTypeName;
	}

	public int getHelpNum() {
		return helpNum;
	}

	public void setHelpNum(int helpNum) {
		this.helpNum = helpNum;
	}

	public int getHelpTypeNum() {
		return helpTypeNum;
	}

	public void setHelpTypeNum(int helpTypeNum) {
		this.helpTypeNum = helpTypeNum;
	}

	public BigDecimal getVendInc() {
		return vendInc;
	}

	public void setVendInc(BigDecimal vendInc) {
		this.vendInc = vendInc;
	}

	public String getIndustryCoName() {
		return industryCoName;
	}

	public void setIndustryCoName(String industryCoName) {
		this.industryCoName = industryCoName;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getHelpState() {
		return helpState;
	}

	public void setHelpState(String helpState) {
		this.helpState = helpState;
	}

	public void setRptCount(BigDecimal rptCount) {
		this.rptCount = rptCount;
	}
	public BigDecimal getRptCount() {
		return rptCount;
	}

	public BigDecimal getIsRptCount() {
		return isRptCount;
	}

	public void setIsRptCount(BigDecimal isRptCount) {
		this.isRptCount = isRptCount;
	}

	public BigDecimal getBusstatus() {
		return busstatus;
	}

	public void setBusstatus(BigDecimal busstatus) {
		this.busstatus = busstatus;
	}

	public BigDecimal getAssGro() {
		return assGro;
	}

	public void setAssGro(BigDecimal assGro) {
		this.assGro = assGro;
	}

	public BigDecimal getFixAssets() {
		return fixAssets;
	}

	public void setFixAssets(BigDecimal fixAssets) {
		this.fixAssets = fixAssets;
	}

	public BigDecimal getLiaGro() {
		return liaGro;
	}

	public void setLiaGro(BigDecimal liaGro) {
		this.liaGro = liaGro;
	}

	public BigDecimal getProGro() {
		return proGro;
	}

	public void setProGro(BigDecimal proGro) {
		this.proGro = proGro;
	}

	public BigDecimal getNetInc() {
		return netInc;
	}

	public void setNetInc(BigDecimal netInc) {
		this.netInc = netInc;
	}

	public BigDecimal getAddProCount() {
		return addProCount;
	}

	public void setAddProCount(BigDecimal addProCount) {
		this.addProCount = addProCount;
	}

	public BigDecimal getMinuProCount() {
		return minuProCount;
	}

	public void setMinuProCount(BigDecimal minuProCount) {
		this.minuProCount = minuProCount;
	}

	public BigDecimal getRatGro() {
		return ratGro;
	}

	public void setRatGro(BigDecimal ratGro) {
		this.ratGro = ratGro;
	}
	
	public void setBusstatusRay(BigDecimal busstatusRay) {
		this.busstatusRay = busstatusRay;
	}
	public BigDecimal getBusstatusRay() {
		return busstatusRay;
	}
	public void setAssliaRay(BigDecimal assliaRay) {
		this.assliaRay = assliaRay;
	}
	public BigDecimal getAssliaRay() {
		return assliaRay;
	}
	public void setYreportRay(BigDecimal yreportRay) {
		this.yreportRay = yreportRay;
	}
	public BigDecimal getYreportRay() {
		return yreportRay;
	}
	
	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}
	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}
	public void setIndustryCodeName(String industryCodeName) {
		this.industryCodeName = industryCodeName;
	} 
	public String getIndustryCodeName() {
		return industryCodeName;
	}
	
    
	
	
	
	
	
}