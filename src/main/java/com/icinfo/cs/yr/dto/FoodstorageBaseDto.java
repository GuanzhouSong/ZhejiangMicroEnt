/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.yr.model.FoodstorageBase;

/**
 * 描述:    cs_foodstorage_base 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月26日
 */
public class FoodstorageBaseDto extends FoodstorageBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9022118957364036662L;
	//注册号
	private String regNO;
	//企业名称
	private String entName;
	//企业小类
	private String entType;
	//经营范围
	private String opScope;
	
	private String proLoc;
	//法定代表人
	private String leRep;
	//统一社会信用代码
	private String uniSCID;
	//成立日期
	 @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date estDate;
	//登记机关描述
	private String regOrgDesc;
	//管辖单位描述
	private String localAdmDesc;
	//行业类型描述
	private String industryCoDesc;
	//企业小类描述
	private String entTypeDesc;
	//片区描述
	private String sliceNoDesc;
	//电话
	private String tel;
	//企业类型
	private String entTypeCatg;
	//抽查机关
	private String checkDepDesc;
	
	public String getRegNO() {
		return regNO;
	}
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntType() {
		return entType;
	}
	public void setEntType(String entType) {
		this.entType = entType;
	}
	public String getOpScope() {
		return opScope;
	}
	public void setOpScope(String opScope) {
		this.opScope = opScope;
	}
	public String getProLoc() {
		return proLoc;
	}
	public void setProLoc(String proLoc) {
		this.proLoc = proLoc;
	}
	public String getLeRep() {
		return leRep;
	}
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}
	public String getUniSCID() {
		return uniSCID;
	}
	public void setUniSCID(String uniSCID) {
		this.uniSCID = uniSCID;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public String getRegOrgDesc() {
		return regOrgDesc;
	}
	public void setRegOrgDesc(String regOrgDesc) {
		this.regOrgDesc = regOrgDesc;
	}
	public String getLocalAdmDesc() {
		return localAdmDesc;
	}
	public void setLocalAdmDesc(String localAdmDesc) {
		this.localAdmDesc = localAdmDesc;
	}
	public String getIndustryCoDesc() {
		return industryCoDesc;
	}
	public void setIndustryCoDesc(String industryCoDesc) {
		this.industryCoDesc = industryCoDesc;
	}
	public String getEntTypeDesc() {
		return entTypeDesc;
	}
	public void setEntTypeDesc(String entTypeDesc) {
		this.entTypeDesc = entTypeDesc;
	}
	public String getSliceNoDesc() {
		return sliceNoDesc;
	}
	public void setSliceNoDesc(String sliceNoDesc) {
		this.sliceNoDesc = sliceNoDesc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEntTypeCatg() {
		return entTypeCatg;
	}
	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}
	public String getCheckDepDesc() {
		return checkDepDesc;
	}
	public void setCheckDepDesc(String checkDepDesc) {
		this.checkDepDesc = checkDepDesc;
	}
	
}