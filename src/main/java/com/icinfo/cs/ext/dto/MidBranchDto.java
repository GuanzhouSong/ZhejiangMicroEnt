/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.dto;

import com.icinfo.cs.ext.model.MidBranch;

/**
 * 描述: cs_mid_branch 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public class MidBranchDto extends MidBranch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4739262640018790437L;
	
	// 统一社会信用代码
	private String uniCode;
	// 登记状态
	private String regState;
	// 登记机关名称
	private String regOrgName;
	// 注册号
	private String regNO;
	
	public String getUniCode() {
		return uniCode;
	}
	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getRegOrgName() {
		return regOrgName;
	}
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
	public String getRegNO() {
		return regNO;
	}
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}
	
	
}