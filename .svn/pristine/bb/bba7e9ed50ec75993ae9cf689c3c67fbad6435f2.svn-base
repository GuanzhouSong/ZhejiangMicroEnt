/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;

/**
 * 描述:    cs_pub_opadetail 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
public class PubOpaDetailDto extends PubOpaDetail {
	
	//登记机关名称
	private String regOrgName;
	//管辖单位名称
	private String localAdmName;
	//成立日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
	private Date estDate; 
	//责任区
	private String sliceNOName;
	//抽检机关名称
	private String checkDepName;
	//操作标志 0 新增（/移出） 1 修改 （/审核）
	private String operate;
	
	public String getLocalAdmName() {
		return localAdmName;
	}
	public void setLocalAdmName(String localAdmName) {
		this.localAdmName = localAdmName;
	}
	public String getRegOrgName() {
		return regOrgName;
	}
	public void setRegOrgName(String regOrgName) {
		this.regOrgName = regOrgName;
	}
	public String getSliceNOName() {
		return sliceNOName;
	}
	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
	}
	
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
	}
	
	public Date getEstDate() {
		return estDate;
	}
	public String getCheckDepName() {
		return checkDepName;
	}
	public void setCheckDepName(String checkDepName) {
		this.checkDepName = checkDepName;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
	
	
}