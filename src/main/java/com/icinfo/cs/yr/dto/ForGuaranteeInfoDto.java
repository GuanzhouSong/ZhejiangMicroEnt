/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;


import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.ForGuaranteeInfo;

/**
 * 描述: cs_forguaranteeinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class ForGuaranteeInfoDto extends ForGuaranteeInfo {

	//TODO
	private static final long serialVersionUID = 1L;

	/**
	 * 债权人
	 */
	private String more;

	/**
	 * 债务人
	 */
	private String mortgagor;

	public String getMore() {
		return more;
	}

	/**
	 * 
	 * 描述: 敏感词过滤（债权人）
	 * 
	 * @auther chenyl
	 * @date 2016年10月10日
	 * @param more
	 */
	public void setMore(String more) {
		this.more = more;
	}

	public String getMortgagor() {
		return mortgagor;
	}

	/**
	 * 
	 * 描述: 敏感词过滤（债务人）
	 * 
	 * @auther chenyl
	 * @date 2016年10月10日
	 * @param more
	 */
	public void setMortgagor(String mortgagor) {
		this.mortgagor = mortgagor;
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
		this.more = KeywordFilter.getReplaceCon(more);
		this.mortgagor = KeywordFilter.getReplaceCon(mortgagor);
	}

}