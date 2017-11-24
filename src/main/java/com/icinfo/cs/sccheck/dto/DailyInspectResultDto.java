/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import com.icinfo.cs.sccheck.model.DailyInspectResult;

/**
 * 描述: cs_daily_inspect_result 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public class DailyInspectResultDto extends DailyInspectResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1261501399956543308L;
	private String sliceNOName;
	private String regOrgName;
	private String localAdmName;

	public String getSliceNOName() {
		return sliceNOName;
	}

	public void setSliceNOName(String sliceNOName) {
		this.sliceNOName = sliceNOName;
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

}