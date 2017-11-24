/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.Subcapital;

/**
 * 描述:    cs_subcapital 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class SubcapitalDto extends Subcapital {

	//TODO
	private static final long serialVersionUID = 1L;
	/**
	 * 股东/发起人名称
	 */
	private String inv;
	/**
	 * 统一代码、注册号/身份证件号码
	 */
	private String invRegNO;
	public String getInv() {
		return inv;
	}
	public void setInv(String inv) {
		this.inv =  inv;
	}
	public String getInvRegNO() {
		return invRegNO;
	}
	public void setInvRegNO(String invRegNO) {
		this.invRegNO = invRegNO;
	}
	
	 /**
     * 修改记录表名
     */
    private String altTable;
    /**
     * 修改记录列名
     */
    private String altItem;
	public String getAltTable() {
		return altTable;
	}

	public void setAltTable(String altTable) {
		this.altTable = altTable;
	}

	public String getAltItem() {
		return altItem;
	}

	public void setAltItem(String altItem) {
		this.altItem = altItem;
	}
	
	// 增加敏感词过滤方法 2016-11-04 重新修改 chenyulong
	public void doFilterForbidword() {
		this.inv =  KeywordFilter.getReplaceCon(inv);
		this.invRegNO = KeywordFilter.getReplaceCon(invRegNO);
	}
	
}