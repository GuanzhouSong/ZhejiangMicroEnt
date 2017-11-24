/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;

/**
 * 描述: cs_sfc_websiteinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public class SfcWebsiteInfoDto extends SfcWebsiteInfo {
	// TODO
	private static final long serialVersionUID = 1L;

	/**
	 * 网站（网店）网址
	 */
	private String webSite;

	/**
	 * 网站（网店）名称
	 */
	private String webSitName;

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public String getWebSitName() {
		return webSitName;
	}

	public void setWebSitName(String webSitName) {
		this.webSitName = webSitName;
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
		this.webSite = KeywordFilter.getReplaceCon(webSite);
		this.webSitName = KeywordFilter.getReplaceCon(webSitName);
		
	}
}