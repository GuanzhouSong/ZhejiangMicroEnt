/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.dto;

import com.icinfo.cs.other.model.PubJusticeInfo;

/**
 * 描述:    cs_pub_justiceinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public class PubJusticeInfoDto extends PubJusticeInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//登记机关名称
	private String regOrgName;
	
	//管辖单位名称
	private String localAdmName;
	
	//责任区
	private String sliceNOName;
	
	//统一社会代码
	private String uniCode;
	
    //注册号
	private String regNO;
	
	//公示企业家数
	private int total;
	
	//公示企业条数
	private int amount;
	
	//其中股权冻结信息条数
	private int oneCount;
	
	//其中股东强制变更条数
	private int twoCount;
	
	//
	private String upJusticeNO;
	
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

	public String getUniCode() {
		return uniCode;
	}

	public void setUniCode(String uniCode) {
		this.uniCode = uniCode;
	}

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTwoCount() {
		return twoCount;
	}

	public void setTwoCount(int twoCount) {
		this.twoCount = twoCount;
	}

	public int getOneCount() {
		return oneCount;
	}

	public void setOneCount(int oneCount) {
		this.oneCount = oneCount;
	}

	public String getUpJusticeNO() {
		return upJusticeNO;
	}

	public void setUpJusticeNO(String upJusticeNO) {
		this.upJusticeNO = upJusticeNO;
	}
	
	public String getFrozStateName(){
		if("1".equals(this.getFrozState()))
			return "冻结";
		if("2".equals(this.getFrozState()))
			return "解除冻结";
		if("3".equals(this.getFrozState()))
			return "无效";
		return null;
	}
}