/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 描述: es查询出数据对应接收的类<br>
 * 
 * @author baifangfang
 * @date 2016年09月20日
 */
public class PubEntSearchDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -999131023761178972L;

	private String priPID;// 主体身份代码(CA14)
	private String encryPriPID;// 加密后的主体身份代码(CA14)
	private String entName;// 企业(机构)名称
	private String hisEntName;// 企业(机构)名称
	private String hisEntNamePPL;// 企业(机构)名称
	private String regNO;// 注册号(CA15)
	private String dom;// 住所
	private String leRep;// 法定代表人
	private BigDecimal regCap;// 注册资本(金)
	private String entType;// 市场主体类型(CA16)
	private String entTypeName;// 市场主体类型名称
	private String estDate;// 成立日期
	private Long estDateLong;// 成立日期
	private String estDateStr;// 格式化后成立日期(年月日)
	private String regOrg;// 登记机关(CA11)
	private String regOrgName;// 登记机关名称
	private String regState;// 登记状态(CA19)
	private BigDecimal regCapUSD;// 注册资本(金)折万美元
	private BigDecimal recCapUSD;// 实收资本折万美元
	private BigDecimal recCapRMB;// 实收资本
	private String UNICODE;// 统一社会信用代码(CA91)
	private String postalCode;// 邮政编码
	private String opFrom;// 经营(驻在)期限自
	private String opFromStr;// 格式化后经营(驻在)期限自(年月日)
	private String opTo;// 经营(驻在)期限至
	private String opToStr;// 格式化后经营(驻在)期限至(年月日)
	private String currency;// 注册资本(金)币种(CA04)
	private String currencyCn;
	private String apprDate;// 核准日期
	private String apprDateStr;// 格式化后核准日期(年月日)
	private String altDate;// 变更注销日期
	private String altDateStr;// 格式化后变更注销日期(年月日)
	private String createTime;// 时间戳
	private String entTypeCatg;// 市场主体类型大类编码
	private String entTypeCatgName;// 市场主体类型大类名称
	private String opScope;// 经营范围
	private String compForm;// 个体户组成形式
	private String compFormName;// 个体户组成形式名称
	private String isOpanomaly;// 是否经营异常名录：1.是 0.否
	private String punishDateStr;// 吊销企业的吊销日期
	private String isSimpleCancle;// 简易注销标志
	private String exeAffSign;// 执行事务合伙人标记
	private String inv;// 执行事务合伙人名称
	private String basx;//多证合一编码
	private String basxCN;//多证合一名称
	

	public String getExeAffSign() {
		return exeAffSign;
	}

	public void setExeAffSign(String exeAffSign) {
		this.exeAffSign = exeAffSign;
	}

	public String getInv() {
		return inv;
	}

	public void setInv(String inv) {
		this.inv = inv;
	}

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
	}

	public String getEncryPriPID() {
		return encryPriPID;
	}

	public void setEncryPriPID(String encryPriPID) {
		this.encryPriPID = encryPriPID;
	}

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}

	public BigDecimal getRegCap() {
		return regCap;
	}

	public void setRegCap(BigDecimal regCap) {
		this.regCap = regCap;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public String getEstDateStr() {
		return estDateStr;
	}

	public void setEstDateStr(String estDateStr) {
		this.estDateStr = estDateStr;
	}

	public String getRegOrg() {
		return regOrg;
	}

	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}

	public String getRegOrgName() {
		return regOrgName;
	}

	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public BigDecimal getRegCapUSD() {
		return regCapUSD;
	}

	public void setRegCapUSD(BigDecimal regCapUSD) {
		this.regCapUSD = regCapUSD;
	}

	public BigDecimal getRecCapUSD() {
		return recCapUSD;
	}

	public void setRecCapUSD(BigDecimal recCapUSD) {
		this.recCapUSD = recCapUSD;
	}

	public BigDecimal getRecCapRMB() {
		return recCapRMB;
	}

	public void setRecCapRMB(BigDecimal recCapRMB) {
		this.recCapRMB = recCapRMB;
	}

	public String getUNICODE() {
		return UNICODE;
	}

	public void setUNICODE(String uNICODE) {
		UNICODE = uNICODE;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getOpFrom() {
		return opFrom;
	}

	public void setOpFrom(String opFrom) {
		this.opFrom = opFrom;
	}

	public String getOpFromStr() {
		return opFromStr;
	}

	public void setOpFromStr(String opFromStr) {
		this.opFromStr = opFromStr;
	}

	public String getOpTo() {
		return opTo;
	}

	public void setOpTo(String opTo) {
		this.opTo = opTo;
	}

	public String getOpToStr() {
		return opToStr;
	}

	public void setOpToStr(String opToStr) {
		this.opToStr = opToStr;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getApprDate() {
		return apprDate;
	}

	public void setApprDate(String apprDate) {
		this.apprDate = apprDate;
	}

	public String getApprDateStr() {
		return apprDateStr;
	}

	public void setApprDateStr(String apprDateStr) {
		this.apprDateStr = apprDateStr;
	}

	public String getAltDate() {
		return altDate;
	}

	public void setAltDate(String altDate) {
		this.altDate = altDate;
	}

	public String getAltDateStr() {
		return altDateStr;
	}

	public void setAltDateStr(String altDateStr) {
		this.altDateStr = altDateStr;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getEntTypeCatg() {
		return entTypeCatg;
	}

	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}

	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}

	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}

	public String getOpScope() {
		return opScope;
	}

	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}

	public String getCompForm() {
		return compForm;
	}

	public void setCompForm(String compForm) {
		this.compForm = compForm;
	}

	public String getCompFormName() {
		return compFormName;
	}

	public void setCompFormName(String compFormName) {
		this.compFormName = compFormName;
	}

	public String getIsOpanomaly() {
		return isOpanomaly;
	}

	public void setIsOpanomaly(String isOpanomaly) {
		this.isOpanomaly = isOpanomaly;
	}

	public String getCurrencyCn() {
		return currencyCn;
	}

	public void setCurrencyCn(String currencyCn) {
		this.currencyCn = currencyCn;
	}

	public String getPunishDateStr() {
		return punishDateStr;
	}

	public void setPunishDateStr(String punishDateStr) {
		this.punishDateStr = punishDateStr;
	}

	public String getIsSimpleCancle() {
		return isSimpleCancle;
	}

	public void setIsSimpleCancle(String isSimpleCancle) {
		this.isSimpleCancle = isSimpleCancle;
	}

	public Long getEstDateLong() {
		return estDateLong;
	}

	public void setEstDateLong(Long estDateLong) {
		this.estDateLong = estDateLong;
	}

	public String getBasx() {
		return basx;
	}

	public void setBasx(String basx) {
		this.basx = basx;
	}

	public String getBasxCN() {
		return basxCN;
	}

	public void setBasxCN(String basxCN) {
		this.basxCN = basxCN;
	}

	public String getHisEntName() {
		return hisEntName;
	}

	public void setHisEntName(String hisEntName) {
		this.hisEntName = hisEntName;
	}

	public String getHisEntNamePPL() {
		return hisEntNamePPL;
	}

	public void setHisEntNamePPL(String hisEntNamePPL) {
		this.hisEntNamePPL = hisEntNamePPL;
	}
}