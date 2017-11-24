/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.cs.drcheck.model.PubScitemResult;

/**
 * 描述:  cs_pub_scitem_result 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public class PubScitemResultDto extends PubScitemResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6869533511567174536L;
	
	//检查机关
	private String inspectDept;
	//检查机关名字
	private String inspectDesc;
	
	public String getInspectDesc() {
		return inspectDesc;
	}

	public void setInspectDesc(String inspectDesc) {
		this.inspectDesc = inspectDesc;
	}

	//检查日期
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date inspectDate;
	
	//科目大类描述
	private String scName;

	public String getInspectDept() {
		return inspectDept;
	}

	public void setInspectDept(String inspectDept) {
		this.inspectDept = inspectDept;
	}

	public Date getInspectDate() {
		return inspectDate;
	}

	public void setInspectDate(Date inspectDate) {
		this.inspectDate = inspectDate;
	}

	public String getScName() {
		return scName;
	}

	public void setScName(String scName) {
		this.scName = scName;
	}
}