/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.dto;

import com.icinfo.cs.sment.model.SmBusEntarchivesArea;

/**
 * 描述:   小微企业-区域code sm_bus_entarchives_area 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public class SmBusEntarchivesAreaDto extends SmBusEntarchivesArea {
	
	private String parentid;
	
	private String Nocheck;
	
	private String IsParent;

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getNocheck() {
		return Nocheck;
	}

	public void setNocheck(String nocheck) {
		Nocheck = nocheck;
	}

	public String getIsParent() {
		return IsParent;
	}

	public void setIsParent(String isParent) {
		IsParent = isParent;
	}
	
	
}