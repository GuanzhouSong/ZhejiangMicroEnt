/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.dto;

import com.icinfo.cs.copysend.model.CopySendFeedback;

/**
 * 描述:    cs_copy_send_feedback 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月24日
 */
public class CopySendFeedbackDto extends CopySendFeedback {
	//部门名称
	private String acceptDepartName;

	public String getAcceptDepartName() {
		return acceptDepartName;
	}

	public void setAcceptDepartName(String acceptDepartName) {
		this.acceptDepartName = acceptDepartName;
	}
	
	
	
	
}