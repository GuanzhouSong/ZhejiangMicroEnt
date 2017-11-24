/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.dto;

import com.icinfo.cs.system.model.EmailTaskInfo;

/**
 * 描述: cs_email_task_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
public class EmailTaskInfoDto extends EmailTaskInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7744709480974814286L;
	private String entTypeCatgName;

	public String getEntTypeCatgName() {
		return entTypeCatgName;
	}

	public void setEntTypeCatgName(String entTypeCatgName) {
		this.entTypeCatgName = entTypeCatgName;
	}
}