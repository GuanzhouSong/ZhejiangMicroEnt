/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.bulletin.dto;

import com.icinfo.cs.bulletin.model.PubAnnounceMent;

/**
 * 描述:    cs_pub_announcement 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public class PubAnnounceMentDto extends PubAnnounceMent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	// 统一社会信用代码
	private String uniCode;
	// 注册号
	private String regNO;
	// 登记机关名称
	private String regOrgName;
	// 企业类型大类
	private String entTypeCatg;
	// 登记状态
	private String regState;
	// 发布人
	private String setName;
	// 发布方式
	private String bulletinWay;
	// 公示状态
	private String pubState;
	
	
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
	public String getRegOrgName() {
		return regOrgName;
	}
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
	public String getEntTypeCatg() {
		return entTypeCatg;
	}
	public void setEntTypeCatg(String entTypeCatg) {
		this.entTypeCatg = entTypeCatg;
	}
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getBulletinWay() {
		return bulletinWay;
	}
	public void setBulletinWay(String bulletinWay) {
		this.bulletinWay = bulletinWay;
	}
	public String getPubState() {
		return pubState;
	}
	public void setPubState(String pubState) {
		this.pubState = pubState;
	}
    	
}