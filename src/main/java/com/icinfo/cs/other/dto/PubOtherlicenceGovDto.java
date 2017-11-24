/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.dto;

import com.icinfo.cs.other.model.PubOtherlicenceGov;

/**
 * 描述:    cs_pub_otherlicence_gov 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
public class PubOtherlicenceGovDto extends PubOtherlicenceGov {

	//TODO
	private static final long serialVersionUID = 1L;
	// 行政许可机关
	private String anthTotal;
	// 总条数
	private String allTotal;
	// 记于名下机关
	private String regAnthTotal;
	// 记于名下条数
	private String regTotal;
	
	public String getAnthTotal() {
		return anthTotal;
	}
	public void setAnthTotal(String anthTotal) {
		this.anthTotal = anthTotal;
	}
	public String getAllTotal() {
		return allTotal;
	}
	public void setAllTotal(String allTotal) {
		this.allTotal = allTotal;
	}
	public String getRegAnthTotal() {
		return regAnthTotal;
	}
	public void setRegAnthTotal(String regAnthTotal) {
		this.regAnthTotal = regAnthTotal;
	}
	public String getRegTotal() {
		return regTotal;
	}
	public void setRegTotal(String regTotal) {
		this.regTotal = regTotal;
	}
	
	
}