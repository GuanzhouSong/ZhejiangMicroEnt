/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.dto;

import org.springframework.data.annotation.Transient;

import com.icinfo.cs.common.utils.KeywordFilter;
import com.icinfo.cs.yr.model.WebsiteInfo;

/**
 * 描述: cs_websiteinfo 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public class WebsiteInfoDto extends WebsiteInfo {

	// TODO
	private static final long serialVersionUID = 1L;

	private String webSitName;

	public String getWebSitName() {
		return webSitName;
	}

	public String getWebSite() {
		return webSite;
	}

	private String webSite;

	// 敏感词过滤标记（0：过滤，1：不用过滤）
	@Transient
	private String ifFilter;

	public String getIfFilter() {
		return ifFilter;
	}

	public void setIfFilter(String ifFilter) {
		this.ifFilter = ifFilter;
	}

	// 敏感词过滤
	/**
	 * 设置网站（网店）名称
	 *
	 * @param webSitName
	 *            网站（网店）名称
	 */
	public void setWebSitName(String webSitName) {
		this.webSitName = webSitName;
	}

	/**
	 * 设置网站（网店）网址
	 *
	 * @param webSite
	 *            网站（网店）网址
	 */
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	/**
	 * 修改记录表名
	 */
	@Transient
	private String altTable;
	/**
	 * 修改记录列名
	 */
	@Transient
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

		this.webSitName = KeywordFilter.getReplaceCon(webSitName);
		this.webSite = KeywordFilter.getReplaceCon(webSite);
	}

}