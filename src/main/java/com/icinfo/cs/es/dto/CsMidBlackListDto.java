/*
 * Copyright? 2003-2016 �㽭���ſƼ����޹�˾, All Rights Reserved. 
 */
package com.icinfo.cs.es.dto;

import com.icinfo.cs.es.model.CsMidBlackList;

/**
 * ����:    cs_mid_blacklist ��Ӧ��DTO��.<br>
 *
 * @author framework generator
 * @date 2016��11��03��
 */
public class CsMidBlackListDto extends CsMidBlackList {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7080027567935615106L;
	//所属单位名称
	private String entName;
	//所属单位注册号
	private String uniCode;
	//企业关系
	private String positionName;
	
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
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
}