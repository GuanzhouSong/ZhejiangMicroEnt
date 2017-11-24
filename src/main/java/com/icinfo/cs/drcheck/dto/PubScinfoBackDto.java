/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.drcheck.model.PubScinfoBack;

/**
 * 描述:  cs_pub_scinfo_back 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public class PubScinfoBackDto extends PubScinfoBack {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8933268615827641225L;
	
	//参数主体身份代码
	private List<String> pripIdList;
	
	  /**
     * 企业名称
     */
    private String entName;

    /**
     * 统一社会信用代码
     */
    private String uniCode;

    /**
     * 注册号
     */
    private String regNO;

    /**
     * 法定代表人
     */
    private String leRep;

    /**
     * 成立日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date estDate;

    /**
     * 联络人电话
     */
    private String tel;

	//联络人姓名
	private String liaName;
	//联络人电话
	private String leRepPhone;
	//企业大类
	private String entTypeCatgDesc;
	//行业类型
	private String industryDesc;
	
	private String regOrg;
	
	private Integer entCount;
	
	public List<String> getPripIdList() {
		return pripIdList;
	}
	public void setPripIdList(List<String> pripIdList) {
		this.pripIdList = pripIdList;
	}
	public String getLiaName() {
		return liaName;
	}
	public void setLiaName(String liaName) {
		this.liaName = liaName;
	}
	public String getLeRepPhone() {
		return leRepPhone;
	}
	public void setLeRepPhone(String leRepPhone) {
		this.leRepPhone = leRepPhone;
	}
	public String getEntTypeCatgDesc() {
		return entTypeCatgDesc;
	}
	public void setEntTypeCatgDesc(String entTypeCatgDesc) {
		this.entTypeCatgDesc = entTypeCatgDesc;
	}
	public String getIndustryDesc() {
		return industryDesc;
	}
	public void setIndustryDesc(String industryDesc) {
		this.industryDesc = industryDesc;
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
	public String getRegNO() {
		return regNO;
	}
	public void setRegNO(String regNO) {
		this.regNO = regNO;
	}
	public String getLeRep() {
		return leRep;
	}
	public void setLeRep(String leRep) {
		this.leRep = leRep;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRegOrg() {
		return regOrg;
	}
	public void setRegOrg(String regOrg) {
		this.regOrg = regOrg;
	}
	public Integer getEntCount() {
		return entCount;
	}
	public void setEntCount(Integer entCount) {
		this.entCount = entCount;
	}
	
}