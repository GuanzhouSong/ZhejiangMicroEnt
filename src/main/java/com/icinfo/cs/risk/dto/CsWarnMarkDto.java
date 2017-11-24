/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.dto;

import com.icinfo.cs.risk.model.CsWarnMark;

/**
 * 描述:    cs_warn_mark 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public class CsWarnMarkDto extends CsWarnMark {
	/**
	 * 是否企业申请页面修改标识
	 */
	private String entapplyflag;
	/**
	 * markfunc中文名称
	 */
	private String markFuncName;
	/**
	 * 企业申请批次编码
	 * @return
	 */
	private String batchNo;
	/**
	 *用户类型
	 */
	private String userType;
	
	public String getEntapplyflag() {
		return entapplyflag;
	}

	public void setEntapplyflag(String entapplyflag) {
		this.entapplyflag = entapplyflag;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getMarkFuncName() {
		return markFuncName;
	}

	public void setMarkFuncName(String markFuncName) {
		this.markFuncName = markFuncName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}