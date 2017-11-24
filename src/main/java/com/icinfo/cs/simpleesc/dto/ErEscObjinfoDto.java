/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.dto;

import com.icinfo.cs.simpleesc.model.ErEscObjinfo;

/**
 * 描述:    er_esc_objinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
public class ErEscObjinfoDto extends ErEscObjinfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1894083779706988921L;
	
	private String validateCode;
	//其他
	private String otherContent;

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getOtherContent() {
		return otherContent;
	}

	public void setOtherContent(String otherContent) {
		this.otherContent = otherContent;
	}
}