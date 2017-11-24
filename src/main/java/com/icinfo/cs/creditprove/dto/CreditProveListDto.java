/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.dto;

import com.icinfo.cs.creditprove.model.CreditProveList;

/**
 * 描述:    cs_credit_prove_list 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public class CreditProveListDto extends CreditProveList {
	
	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * 描述:  
	 */
	private static final long serialVersionUID = 1032809816673492675L;
	private String regOrgName;
	private String localAdmName;
	private String regState;
	private String leRep;
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
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getLeRep() {
		return leRep;
	}
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}
}