/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.registmanage.model.InvManager;

/**
 * 描述: cs_inv_manager 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public class InvManagerDto extends InvManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3775712914878171644L;
	private String entName;
	private String uniCode;
	private String regNO;
	
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date estDate;
	private BigDecimal regCap;
	private String currencyCn;
	private String entTypeCatg;
	private String entTypeCatgName;
	private String regOrgName;
	private String localAdmName;
	private String tel;
	private String liaName;
	private String liaTel;
	private String dom;
	private String leRep;
	private String entTypeName;

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

	public String getRegNO() {
		return regNO;
	}

	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}

	public Date getEstDate() {
		return estDate;
	}

	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}

	public BigDecimal getRegCap() {
		return regCap;
	}

	public void setRegCap(BigDecimal regCap) {
		this.regCap = regCap;
	}

	public String getCurrencyCn() {
		return currencyCn;
	}

	public void setCurrencyCn(String currencyCn) {
		this.currencyCn = currencyCn;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLiaName() {
		return liaName;
	}

	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}

	public String getLiaTel() {
		return liaTel;
	}

	public void setLiaTel(String liaTel) {
		this.liaTel = liaTel;
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

	public String getEntTypeName() {
		return entTypeName;
	}

	public void setEntTypeName(String entTypeName) {
		this.entTypeName = entTypeName;
	}

}