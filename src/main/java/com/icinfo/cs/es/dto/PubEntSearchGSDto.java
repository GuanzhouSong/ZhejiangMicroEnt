/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.cs.es.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PubEntSearchGSDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5509039975023804173L;

	private String priPID;// 主体身份代码(CA14)
	private String entName;// 企业(机构)名称
	private String hisEntName;// 企业(机构)历史名称
	private String hisEntNamePPL;// 企业(机构)历史名称分词
	private String entNameNo;// 企业(机构)名称不分词
	private String regNO;// 注册号(CA15)
	private String dom;// 住所
	private String leRep;// 法定代表人
	private BigDecimal regCap;// 注册资本(金)
	private String entType;// 市场主体类型(CA16)
	private String entTypeName;// 市场主体类型名称
	private Date estDate;// 成立日期
	private String regOrg;// 登记机关(CA11)
	private String regOrgName;// 登记机关名称
	private String regState;// 登记状态(CA19)
	private BigDecimal regCapUSD;// 注册资本(金)折万美元
	private BigDecimal recCapUSD;// 实收资本折万美元
	private BigDecimal recCapRMB;// 实收资本
	private String UNICODE;// 统一社会信用代码(CA91)
	private String postalCode;// 邮政编码
	private Date opFrom;// 经营(驻在)期限自
	private Date opTo;// 经营(驻在)期限至
	private String currency;// 注册资本(金)币种(CA04)
	private Date apprDate;// 核准日期
	private Date altDate;// 变更注销日期
	private Date createTime;// 时间戳
	private String entTypeCatg;// 市场主体类型大类编码
	private String entTypeCatgName;// 市场主体类型大类名称
	private String opScope;// 经营范围
	private String compForm;// 个体户组成形式
	private String compFormName;// 个体户组成形式名称
	private String isOpanomaly;// 是否经营异常名录：1.是 0.否
	private String isSimpleCancle;// 简易注销标志

	public String getPriPID() {
		return priPID;
	}

	public void setPriPID(String priPID) {
		this.priPID = priPID;
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

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
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

	public Date getOpFrom() {
		return opFrom;
	}

	public void setOpFrom(Date opFrom) {
		this.opFrom = opFrom;
	}

	public Date getOpTo() {
		return opTo;
	}

	public void setOpTo(Date opTo) {
		this.opTo = opTo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getApprDate() {
		return apprDate;
	}

	public void setApprDate(Date apprDate) {
		this.apprDate = apprDate;
	}

	public Date getAltDate() {
		return altDate;
	}

	public void setAltDate(Date altDate) {
		this.altDate = altDate;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
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

	public String getEntNameNo() {
		return entNameNo;
	}

	public void setEntNameNo(String entNameNo) {
		this.entNameNo = entNameNo;
	}

	public String getIsSimpleCancle() {
		return isSimpleCancle;
	}

	public void setIsSimpleCancle(String isSimpleCancle) {
		this.isSimpleCancle = isSimpleCancle;
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