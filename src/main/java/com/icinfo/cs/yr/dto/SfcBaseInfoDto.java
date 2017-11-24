/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.List;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.SfcBaseInfo;

/**
 * 描述: cs_sfc_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public class SfcBaseInfoDto extends SfcBaseInfo {
	// TODO
	private static final long serialVersionUID = 1L;

	/**
	 * 年报更新次数
	 */
	private String updateInfo;
	private String repYearType;

	/**
	 * 年报时间(字符串)
	 */
	private String ancheDateStr;

	/**
	 * 合作社名称
	 */
	private String farSpeArtName;

	/**
	 * 是否有网站、网店信息
	 */
	private String ifWebSite;
	/**
	 * 销售额或营业收入
	 */
	private String vendIncStr;

	/**
	 * 盈余总额
	 */
	private String priYeaProfitStr;

	/**
	 * 获得政府扶持资金、补助
	 */
	private String priYeaSubStr;

	/**
	 * 纳税金额
	 */
	private String ratGroStr;

	/**
	 * 金融贷款
	 */
	private String priYeaLoanStr;

	/**
	 * 年报名称
	 */
	private String anCheName;
	private List<SfcWebsiteInfoDto> sfcWebList;// 网站信息
	private List<SfcBranchInfoDto> branchList;// 分支机构信息
	private List<SfcLicenceInfoDto> licenceList;// 行政许可信息

	private String paymentEndowmentStr;
	private String paymentEmpInjuryStr;
	private String paymentUnemploymentStr;
	private String paymentMedicalStr;
	private String paymentMaternityStr;

	private String actualPayEndowmentStr;
	private String actualPayUnemploymentStr;
	private String actualPayMedicalStr;
	private String actualPayEmpInjuryStr;
	private String actualPayMaternityStr;

	private String cumuEndowmentStr;
	private String cumuUnemploymentStr;
	private String cumuMedicalStr;
	private String cumuEmpInjuryStr;
	private String cumuMaternityStr;

	private String femaleEmployeStr;
	private String empNumStr;
	private String dom;
	private String email;

	private String entMainBusActivity; // 主营业务活动

	private String entName;
	private String leRep;
	private String estDate;
	private String regCap;
	private String regOrgName;
	private String localAdmName;
	private String sliceNOName;
	private String regState;

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

	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getEntMainBusActivity() {
		return entMainBusActivity;
	}

	public void setEntMainBusActivity(String entMainBusActivity) {
		this.entMainBusActivity = entMainBusActivity;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getPaymentEndowmentStr() {
		return paymentEndowmentStr;
	}

	public void setPaymentEndowmentStr(String paymentEndowmentStr) {
		this.paymentEndowmentStr = paymentEndowmentStr;
	}

	public String getPaymentEmpInjuryStr() {
		return paymentEmpInjuryStr;
	}

	public void setPaymentEmpInjuryStr(String paymentEmpInjuryStr) {
		this.paymentEmpInjuryStr = paymentEmpInjuryStr;
	}

	public String getPaymentUnemploymentStr() {
		return paymentUnemploymentStr;
	}

	public void setPaymentUnemploymentStr(String paymentUnemploymentStr) {
		this.paymentUnemploymentStr = paymentUnemploymentStr;
	}

	public String getPaymentMedicalStr() {
		return paymentMedicalStr;
	}

	public void setPaymentMedicalStr(String paymentMedicalStr) {
		this.paymentMedicalStr = paymentMedicalStr;
	}

	public String getPaymentMaternityStr() {
		return paymentMaternityStr;
	}

	public void setPaymentMaternityStr(String paymentMaternityStr) {
		this.paymentMaternityStr = paymentMaternityStr;
	}

	public String getActualPayEndowmentStr() {
		return actualPayEndowmentStr;
	}

	public void setActualPayEndowmentStr(String actualPayEndowmentStr) {
		this.actualPayEndowmentStr = actualPayEndowmentStr;
	}

	public String getActualPayUnemploymentStr() {
		return actualPayUnemploymentStr;
	}

	public void setActualPayUnemploymentStr(String actualPayUnemploymentStr) {
		this.actualPayUnemploymentStr = actualPayUnemploymentStr;
	}

	public String getActualPayMedicalStr() {
		return actualPayMedicalStr;
	}

	public void setActualPayMedicalStr(String actualPayMedicalStr) {
		this.actualPayMedicalStr = actualPayMedicalStr;
	}

	public String getActualPayEmpInjuryStr() {
		return actualPayEmpInjuryStr;
	}

	public void setActualPayEmpInjuryStr(String actualPayEmpInjuryStr) {
		this.actualPayEmpInjuryStr = actualPayEmpInjuryStr;
	}

	public String getActualPayMaternityStr() {
		return actualPayMaternityStr;
	}

	public void setActualPayMaternityStr(String actualPayMaternityStr) {
		this.actualPayMaternityStr = actualPayMaternityStr;
	}

	public String getCumuEndowmentStr() {
		return cumuEndowmentStr;
	}

	public void setCumuEndowmentStr(String cumuEndowmentStr) {
		this.cumuEndowmentStr = cumuEndowmentStr;
	}

	public String getCumuUnemploymentStr() {
		return cumuUnemploymentStr;
	}

	public void setCumuUnemploymentStr(String cumuUnemploymentStr) {
		this.cumuUnemploymentStr = cumuUnemploymentStr;
	}

	public String getCumuMedicalStr() {
		return cumuMedicalStr;
	}

	public void setCumuMedicalStr(String cumuMedicalStr) {
		this.cumuMedicalStr = cumuMedicalStr;
	}

	public String getCumuEmpInjuryStr() {
		return cumuEmpInjuryStr;
	}

	public void setCumuEmpInjuryStr(String cumuEmpInjuryStr) {
		this.cumuEmpInjuryStr = cumuEmpInjuryStr;
	}

	public String getCumuMaternityStr() {
		return cumuMaternityStr;
	}

	public void setCumuMaternityStr(String cumuMaternityStr) {
		this.cumuMaternityStr = cumuMaternityStr;
	}

	public String getFarSpeArtName() {
		return farSpeArtName;
	}

	public void setFarSpeArtName(String farSpeArtName) {
		this.farSpeArtName = farSpeArtName;
	}

	public String getIfWebSite() {
		return ifWebSite;
	}

	public void setIfWebSite(String ifWebSite) {
		this.ifWebSite = ifWebSite;
	}

	public String getVendIncStr() {
		return vendIncStr;
	}

	public void setVendIncStr(String vendIncStr) {
		this.vendIncStr = vendIncStr;
	}

	public String getPriYeaProfitStr() {
		return priYeaProfitStr;
	}

	public List<SfcBranchInfoDto> getBranchList() {
		return branchList;
	}

	public List<SfcLicenceInfoDto> getLicenceList() {
		return licenceList;
	}

	public void setLicenceList(List<SfcLicenceInfoDto> licenceList) {
		this.licenceList = licenceList;
	}

	public void setBranchList(List<SfcBranchInfoDto> branchList) {
		this.branchList = branchList;
	}

	public void setPriYeaProfitStr(String priYeaProfitStr) {
		this.priYeaProfitStr = priYeaProfitStr;
	}

	public String getPriYeaSubStr() {
		return priYeaSubStr;
	}

	public void setPriYeaSubStr(String priYeaSubStr) {
		this.priYeaSubStr = priYeaSubStr;
	}

	public String getRatGroStr() {
		return ratGroStr;
	}

	public void setRatGroStr(String ratGroStr) {
		this.ratGroStr = ratGroStr;
	}

	public String getPriYeaLoanStr() {
		return priYeaLoanStr;
	}

	public List<SfcWebsiteInfoDto> getSfcWebList() {
		return sfcWebList;
	}

	public void setSfcWebList(List<SfcWebsiteInfoDto> sfcWebList) {
		this.sfcWebList = sfcWebList;
	}

	public void setPriYeaLoanStr(String priYeaLoanStr) {
		this.priYeaLoanStr = priYeaLoanStr;
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

	public String getAnCheName() {
		return anCheName;
	}

	public void setAnCheName(String anCheName) {
		this.anCheName = anCheName;
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

	// 敏感词过滤方法 2016-11-06 chenyulong
	public void doFilterForbidword() {
		this.dom = KeywordFilter.getReplaceCon(dom);
		this.email = KeywordFilter.getReplaceCon(email);
		// 主营业务活动
		this.entMainBusActivity = KeywordFilter.getReplaceCon(entMainBusActivity);
	}

	// 年报修改报表 记录 2016-11-06 chenyulong
	private String altTableItem;

	public String getAltTableItem() {
		return altTableItem;
	}

	public void setAltTableItem(String altTableItem) {
		this.altTableItem = altTableItem;
	}

	public String getRepYearType() {
		return repYearType;
	}

	public void setRepYearType(String repYearType) {
		this.repYearType = repYearType;
	}

	public String getFemaleEmployeStr() {
		return femaleEmployeStr;
	}

	public void setFemaleEmployeStr(String femaleEmployeStr) {
		this.femaleEmployeStr = femaleEmployeStr;
	}

	public String getEmpNumStr() {
		return empNumStr;
	}

	public void setEmpNumStr(String empNumStr) {
		this.empNumStr = empNumStr;
	}
}