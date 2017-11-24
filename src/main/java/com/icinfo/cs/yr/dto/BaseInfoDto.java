/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.List;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.model.WebsiteInfo;

/**
 * 描述: cs_baseinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */

public class BaseInfoDto extends BaseInfo {

	private static final long serialVersionUID = 1L;

	/**
	 * 年度报告名称
	 */
	private String anCheName;
	private String repYearType;
	private List<WebsiteInfo> webList;// 网址信息
	private List<SubcapitalDto> subcapiList;// 股东及其出资信息
	private List<ForinvestMentDto> forInvesList;// 对外投资信息
	private List<ForGuaranteeInfoDto> forGuarantList;// 对外提供担保信息
	private List<AlterStockInfoDto> stockInfoList;// 股权变更信息

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

	private String estDate;
	private String regCap;
	private String currencyCN;
	private String isIndivid;
	private String regOrgName;
	private String localAdmName;
	private String sliceNOName;
	private String regState;
	
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

	/**
	 * 年报时间(字符串)
	 */
	private String ancheDateStr;

	/**
	 * 年报更新次数
	 */
	private String updateInfo;

	/**
	 * 企业从业人数
	 */
	private String empNumStr;

	/**
	 * 是否有网站或者网店
	 */
	private String ifWebSite;

	/**
	 * 是否有对外投资
	 */
	private String ifForInvest;

	/**
	 * 是否有股权转让
	 */
	private String ifAleErstock;

	/**
	 * 利润总额
	 */
	private String proGroStr;
	/**
	 * 资产总额
	 */
	private String assGroStr;

	/**
	 * 地址
	 */
	private String addr;

	/**
	 * email
	 */
	private String email;

	// 纳税总额
	private String ratGroStr;
	private String regNOSup;// 隶属企业注册号
	private String entNameSup;// 隶属企业名称
	private String femaleEmployeStr;// 女性从业人数
	private String entControlStr;// 企业控股情况
	private String ifForguarantee;// 是否担保信息
	private String dom;// 经营场所
	private String entMainBusActivity;// 企业主营业务活动

	private String paymentBaseStr;// 单位缴费基数
	private String actualPaymentStr;// 本期实际缴费金额
	private String cumulArrearsStr;// 单位累计欠缴金额

	public String getPaymentBaseStr() {
		return paymentBaseStr;
	}

	public void setPaymentBaseStr(String paymentBaseStr) {
		this.paymentBaseStr = paymentBaseStr;
	}

	public String getActualPaymentStr() {
		return actualPaymentStr;
	}

	public void setActualPaymentStr(String actualPaymentStr) {
		this.actualPaymentStr = actualPaymentStr;
	}

	public String getCumulArrearsStr() {
		return cumulArrearsStr;
	}

	public void setCumulArrearsStr(String cumulArrearsStr) {
		this.cumulArrearsStr = cumulArrearsStr;
	}

	public String getRegNOSup() {
		return regNOSup;
	}

	public void setRegNOSup(String regNOSup) {
		this.regNOSup = regNOSup;
	}

	public String getEntNameSup() {
		return entNameSup;
	}

	public void setEntNameSup(String entNameSup) {
		this.entNameSup = entNameSup;
	}

	public String getFemaleEmployeStr() {
		return femaleEmployeStr;
	}

	public void setFemaleEmployeStr(String femaleEmployeStr) {
		this.femaleEmployeStr = femaleEmployeStr;
	}

	public String getEntControlStr() {
		return entControlStr;
	}

	public void setEntControlStr(String entControlStr) {
		this.entControlStr = entControlStr;
	}

	public String getIfForguarantee() {
		return ifForguarantee;
	}

	public void setIfForguarantee(String ifForguarantee) {
		this.ifForguarantee = ifForguarantee;
	}

	public String getDom() {
		return dom;
	}

	public List<SubcapitalDto> getSubcapiList() {
		return subcapiList;
	}

	public void setSubcapiList(List<SubcapitalDto> subcapiList) {
		this.subcapiList = subcapiList;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getEntMainBusActivity() {
		return entMainBusActivity;
	}

	public void setEntMainBusActivity(String entMainBusActivity) {
		this.entMainBusActivity = entMainBusActivity;
	}

	public String getProGroStr() {
		return proGroStr;
	}

	public void setProGroStr(String proGroStr) {
		this.proGroStr = proGroStr;
	}

	public String getAssGroStr() {
		return assGroStr;
	}

	public void setAssGroStr(String assGroStr) {
		this.assGroStr = assGroStr;
	}

	public String getLiaGroStr() {
		return liaGroStr;
	}

	public void setLiaGroStr(String liaGroStr) {
		this.liaGroStr = liaGroStr;
	}

	public String getVendIncStr() {
		return vendIncStr;
	}

	public List<AlterStockInfoDto> getStockInfoList() {
		return stockInfoList;
	}

	public void setStockInfoList(List<AlterStockInfoDto> stockInfoList) {
		this.stockInfoList = stockInfoList;
	}

	public void setVendIncStr(String vendIncStr) {
		this.vendIncStr = vendIncStr;
	}

	public String getNetIncStr() {
		return netIncStr;
	}

	public void setNetIncStr(String netIncStr) {
		this.netIncStr = netIncStr;
	}

	public String getMaiBusIncStr() {
		return maiBusIncStr;
	}

	public void setMaiBusIncStr(String maiBusIncStr) {
		this.maiBusIncStr = maiBusIncStr;
	}

	public String getTotEquStr() {
		return totEquStr;
	}

	public void setTotEquStr(String totEquStr) {
		this.totEquStr = totEquStr;
	}

	/**
	 * 负债总额
	 */
	private String liaGroStr;
	/**
	 * 营业总收入
	 */
	private String vendIncStr;
	/**
	 * 净利润
	 */
	private String netIncStr;
	/**
	 * 营业总额
	 */
	private String maiBusIncStr;
	/**
	 * 所有者权益合计
	 */
	private String totEquStr;

	public String getIfWebSite() {
		return ifWebSite;
	}

	public void setIfWebSite(String ifWebSite) {
		this.ifWebSite = ifWebSite;
	}

	public String getIfForInvest() {
		return ifForInvest;
	}

	public void setIfForInvest(String ifForInvest) {
		this.ifForInvest = ifForInvest;
	}

	public String getIfAleErstock() {
		return ifAleErstock;
	}

	public void setIfAleErstock(String ifAleErstock) {
		this.ifAleErstock = ifAleErstock;
	}

	public String getEmpNumStr() {
		return empNumStr;
	}

	public void setEmpNumStr(String empNumStr) {
		this.empNumStr = empNumStr;
	}

	public String getAnCheName() {
		return anCheName;
	}

	public void setAnCheName(String anCheName) {
		this.anCheName = anCheName;
	}

	public String getAncheDateStr() {
		return ancheDateStr;
	}

	public void setAncheDateStr(String ancheDateStr) {
		this.ancheDateStr = ancheDateStr;
	}

	public String getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(String updateInfo) {
		this.updateInfo = updateInfo;
	}

	public String getAddr() {
		return addr;
	}

	public String getEmail() {
		return email;
	}

	public List<ForGuaranteeInfoDto> getForGuarantList() {
		return forGuarantList;
	}

	public void setForGuarantList(List<ForGuaranteeInfoDto> forGuarantList) {
		this.forGuarantList = forGuarantList;
	}

	public void setAddr(String addr) {
		this.addr = addr;

	}

	public void setEmail(String email) {
		this.email = email;
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

	// 敏感词过滤
	public void doFilterForbidword() {

		this.addr = KeywordFilter.getReplaceCon(addr);
		this.email = KeywordFilter.getReplaceCon(email);
		this.entMainBusActivity = KeywordFilter.getReplaceCon(entMainBusActivity);
	}

	// 修改报表记录 2016-11-06 chenyulong
	private String altTableItem;

	public String getAltTableItem() {
		return altTableItem;
	}

	public void setAltTableItem(String altTableItem) {
		this.altTableItem = altTableItem;
	}

	public String getRatGroStr() {
		return ratGroStr;
	}

	public List<WebsiteInfo> getWebList() {
		return webList;
	}

	public void setWebList(List<WebsiteInfo> webList) {
		this.webList = webList;
	}

	public void setRatGroStr(String ratGroStr) {
		this.ratGroStr = ratGroStr;
	}

	public String getRepYearType() {
		return repYearType;
	}

	public List<ForinvestMentDto> getForInvesList() {
		return forInvesList;
	}

	public void setForInvesList(List<ForinvestMentDto> forInvesList) {
		this.forInvesList = forInvesList;
	}

	public void setRepYearType(String repYearType) {
		this.repYearType = repYearType;
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

	public String getCurrencyCN() {
		return currencyCN;
	}

	public void setCurrencyCN(String currencyCN) {
		this.currencyCN = currencyCN;
	}

	public String getIsIndivid() {
		return isIndivid;
	}

	public void setIsIndivid(String isIndivid) {
		this.isIndivid = isIndivid;
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

}