/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.WebsiteinfoSearchDto;
import com.icinfo.cs.yr.model.WebsiteinfoSearch;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月21日
 */
public interface IWebsiteinfoSearchService extends BaseService {
	
	/** 
	 * 描述: 获取网站信息列表
	 * @auther ZhouYan
	 * @date 2017年7月24日 
	 * @param request
	 * @return 
	 */
	List<WebsiteinfoSearchDto> selectWebsiteinfoSearchList(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 查询结果统计
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param pramsMap
	 * @return
	 * @throws Exception 
	 */
	List<WebsiteinfoSearchDto> selectWebsiteinfoTotal(Map<String, Object> paramsMap) throws Exception;
	
	/** 
	 * 描述: 查询网站列表
	 * @auther ZhouYan
	 * @date 2017年7月31日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	List<WebsiteinfoSearch> queryPage(PageRequest request) throws Exception;
}