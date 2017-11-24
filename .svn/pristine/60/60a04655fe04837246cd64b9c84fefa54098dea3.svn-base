/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.PbBaseinfo;

/**
 * 描述: cs_pb_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public class PbBaseinfoDto extends PbBaseinfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5686106779142934989L;
	/**
	 * 个体户名称
	 */
	private String traName;
	
	/**
	 * 年报更新次数
	 */
	private String updateInfo;
	
	/**
	 * 年报时间(字符串)
	 */
	private String ancheDateStr;


	private String repYearType;

	
	private Integer year;//年报主表年度
	
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date ancheDate;//年报主表首次报送时间
	
	private String reportType;//年报主表报告方式
	
	private String estDate;
	private String regOrgName;
	private String localAdmName;
	private String sliceNOName;
	private String regState;
	private String entName;
	private String leRep;
	
	private List<PbWebsiteinfoDto> pbWebsiteList;//个体户网站信息
	private List<PbLicenceinfoDto> pbLicenceList;//行政许可信息
	
	
	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
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

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

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

	public Integer getYear() {
		return year;
	}

	public List<PbWebsiteinfoDto> getPbWebsiteList() {
		return pbWebsiteList;
	}

	public void setPbWebsiteList(List<PbWebsiteinfoDto> pbWebsiteList) {
		this.pbWebsiteList = pbWebsiteList;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getAncheDate() {
		return ancheDate;
	}
  
	public void setAncheDate(Date ancheDate) {
		this.ancheDate = ancheDate;
	}
    
	public List<PbLicenceinfoDto> getPbLicenceList() {
		return pbLicenceList;
	}

	public void setPbLicenceList(List<PbLicenceinfoDto> pbLicenceList) {
		this.pbLicenceList = pbLicenceList;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	/**
	 * 资金数额(字符串)
	 */
	private String fundAmStr;

	public String getTraName() {
		return traName;
	}

	public void setTraName(String traName) {
		this.traName = KeywordFilter.getReplaceCon(traName);
	}

	/**
	 * 营业额是否公示
	 */
	private String vendIncStr;
	/**
	 * 纳税额是否公示
	 */
	private String ratGroStr;
	/**
	 * 年报名称
	 */
	private String anCheName;
	/**
	 * 是否有网站、网店信息
	 */
	private String ifWebSite;

	public String getVendIncStr() {
		return vendIncStr;
	}

	public void setVendIncStr(String vendIncStr) {
		this.vendIncStr = vendIncStr;
	}

	public String getRatGroStr() {
		return ratGroStr;
	}

	public void setRatGroStr(String ratGroStr) {
		this.ratGroStr = ratGroStr;
	}

	public String getIfWebSite() {
		return ifWebSite;
	}

	public void setIfWebSite(String ifWebSite) {
		this.ifWebSite = ifWebSite;
	}

	public String getAnCheName() {
		return anCheName;
	}

	public void setAnCheName(String anCheName) {
		this.anCheName = anCheName;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	public String getAncheDateStr() {
		return ancheDateStr;
	}

	public void setAncheDateStr(String ancheDateStr) {
		this.ancheDateStr = ancheDateStr;
	}
	
	 /**
     * 修改记录表名
     */
    private String altTable;
    /**
     * 修改记录列名
     */
    private String altItem;
	public String getAltTable() {
		return altTable;
	}

	public void setAltTable(String altTable) {
		this.altTable = altTable;
	}

	public String getAltItem() {
		return altItem;
	}

	public void setAltItem(String altItem) {
		this.altItem = altItem;
	}

	public void doFilterForbidword() {
		// TODO Auto-generated method stub
		
	}
	
	//年报修改报表记录 2016-11-06 chenyulong
	private String altTableItem;

	public String getAltTableItem() {
		return altTableItem;
	}

	public void setAltTableItem(String altTableItem) {
		this.altTableItem = altTableItem;
	}

	public String getFundAmStr() {
		return fundAmStr;
	}

	public void setFundAmStr(String fundAmStr) {
		this.fundAmStr = fundAmStr;
	}

	public String getRepYearType() {
		return repYearType;
	}

	public void setRepYearType(String repYearType) {
		this.repYearType = repYearType;
	}
}