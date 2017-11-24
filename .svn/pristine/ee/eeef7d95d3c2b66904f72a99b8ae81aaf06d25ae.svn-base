/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.dto;

import com.icinfo.cs.ext.model.MidInv;

/**
 * 描述: cs_mid_inv 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public class MidInvDto extends MidInv {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4859937227782808279L;
	// 企业名称
	private String entName;
	// 统一信用代码
	private String uniCode;
	// 注册号
	private String regNO;
	// 企业类型
	private String entType;
	// 成立日期
	private String estDate;
	// 登记状态
	private String regState;
	private String cerTypeName;
	// 法定代表人
	private String leRep;
	// 登记机关名称
	private String regOrgName;
	// 管辖单位名称
	private String localAdmName;
	
	private String regCap;
	
	private String dom;

	public String getLeRep() {
		return leRep;
	}

	public void setLeRep(String leRep) {
		this.leRep = leRep;
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

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getEntType() {
		return entType;
	}

	public void setEntType(String entType) {
		this.entType = entType;
	}

	public String getEstDate() {
		return estDate;
	}

	public void setEstDate(String estDate) {
		this.estDate = estDate;
	}

	public String getRegState() {
		return regState;
	}

	public void setRegState(String regState) {
		this.regState = regState;
	}

	public String getRegCapUSD() {
		return regCapUSD;
	}

	public void setRegCapUSD(String regCapUSD) {
		this.regCapUSD = regCapUSD;
	}

	public String getIndustryPhy() {
		return industryPhy;
	}

	public void setIndustryPhy(String industryPhy) {
		this.industryPhy = industryPhy;
	}

	public String getRegStateName() {
		if ("K".equals(this.getRegState()) || "B".equals(this.getRegState()) || "A".equals(this.getRegState()) || "DA".equals(this.getRegState()) || "X".equals(this.getRegState())) {
			return "存续";
		} else if ("D".equals(this.getRegState())) {
			return "吊销";
		} else if ("C".equals(this.getRegState())) {
			return "撤销";
		} else if ("XX".equals(this.getRegState())) {
			return "注销";
		} else {
			return "-";
		}
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public String getCerTypeName() {
		return cerTypeName;
	}

	public void setCerTypeName(String cerTypeName) {
		this.cerTypeName = cerTypeName;
	}
	
	public String getRegCap() {
		return regCap;
	}

	public void setRegCap(String regCap) {
		this.regCap = regCap;
	}

	public String getDom() {
		return dom;
	}

	public void setDom(String dom) {
		this.dom = dom;
	}




	private String industryPhy;
	private String regCapUSD;
}