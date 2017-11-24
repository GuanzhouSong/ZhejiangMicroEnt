/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.SfcLicenceInfo;

/**
 * 描述: cs_sfc_licenceinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public class SfcLicenceInfoDto extends SfcLicenceInfo {

	// TODO
	private static final long serialVersionUID = 1L;
	/**
	 * 许可文件名称
	 */
	private String licName;
	
	/**
	 * 许可文件中文名称
	 */
    private String licNameCN;

	public String getLicNameCN() {
		return licNameCN;
	}

	public void setLicNameCN(String licNameCN) {
		this.licNameCN = licNameCN;
	}

	public String getLicName() {
		return licName;
	}

	public void setLicName(String licName) {
		this.licName = licName;
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
		this.licName = KeywordFilter.getReplaceCon(licName);
		this.licNameCN = KeywordFilter.getReplaceCon(licNameCN);
	}
}