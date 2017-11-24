/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.AlterStockInfo;

/**
 * 描述:    cs_alterstockinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class AlterStockInfoDto extends AlterStockInfo {
	
	 /**
     * 股东名称
     */
	private String inv;

	public String getInv() {
		return inv;
	}

	/**
	 * 
	 * 描述: 敏感词过滤(股东名称)
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param inv
	 */
	public void setInv(String inv) {
		this.inv =  inv;
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
	
	public void doFilterForbidword() {
		
		this.inv =  KeywordFilter.getReplaceCon(inv);
	}

    
}