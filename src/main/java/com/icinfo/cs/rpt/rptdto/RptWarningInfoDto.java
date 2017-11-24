/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptdto;

import com.icinfo.cs.rpt.rptmodel.RptWarningInfo;

/**
 * 描述:    cs_rpt_warning_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年10月18日
 */
public class RptWarningInfoDto extends RptWarningInfo {
	
	
	private String deptCode;
	
	private String setUserUid;
	
	private Long num;

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getSetUserUid() {
		return setUserUid;
	}

	public void setSetUserUid(String setUserUid) {
		this.setUserUid = setUserUid;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
	
	
	
 
}