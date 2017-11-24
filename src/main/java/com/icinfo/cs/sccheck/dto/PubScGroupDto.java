/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import com.icinfo.cs.sccheck.model.PubScGroup;

/**
 * 描述:    cs_pub_scgroup 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
public class PubScGroupDto extends PubScGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String showFiled;

	public String getShowFiled() {
		return showFiled;
	}

	public void setShowFiled(String showFiled) {
		this.showFiled = showFiled;
	}
	
	
}