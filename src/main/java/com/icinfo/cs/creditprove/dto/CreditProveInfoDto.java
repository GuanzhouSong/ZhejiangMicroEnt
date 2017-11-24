/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.dto;

import com.icinfo.cs.creditprove.model.CreditProveInfo;

/**
 * 描述:    cs_credit_prove_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@SuppressWarnings("serial")
public class CreditProveInfoDto extends CreditProveInfo {
	//打印次数
	private Integer printCount;

	public Integer getPrintCount() {
		return printCount;
	}

	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	
	
}