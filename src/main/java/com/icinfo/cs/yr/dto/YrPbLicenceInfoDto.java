/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.yr.model.YrPbLicenceInfo;

/**
 * 描述:    cs_yr_pb_licenceinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public class YrPbLicenceInfoDto extends YrPbLicenceInfo {

	private static final long serialVersionUID = 1L;
	
	//状态标志 （添加，修改，删除）
	private String status;  //值只能为  insert,delete,update

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}