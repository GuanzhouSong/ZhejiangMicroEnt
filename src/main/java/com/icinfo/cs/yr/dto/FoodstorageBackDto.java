/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.FoodstorageBack;

/**
 * 描述:    cs_foodstorage_back 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public class FoodstorageBackDto extends FoodstorageBack {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7715211941788958025L;
	//企业名称
	private String entName;
	//注册号
	private String regNO;
	//统一代码
	private String uniSCID;
	//登记机关注释
	private String regORgDesc;
	//管辖单位注释
	private String localAdmDesc;
	//企业类型
	private String entTypeCatg;
	public String getRegNO() {
		return regNO;
	}
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}
	public String getUniSCID() {
		return uniSCID;
	}
	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}
	public String getRegORgDesc() {
		return regORgDesc;
	}
	public void setRegORgDesc(String regORgDesc) {
		this.regORgDesc = regORgDesc;
	}
	public String getLocalAdmDesc() {
		return localAdmDesc;
	}
	public void setLocalAdmDesc(String localAdmDesc) {
		this.localAdmDesc = localAdmDesc;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntTypeCatg() {
		return entTypeCatg;
	}
	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}
}