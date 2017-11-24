/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.dto.WebsiteinfoSearchDto;
import com.icinfo.cs.yr.mapper.WebsiteinfoSearchMapper;
import com.icinfo.cs.yr.model.WebsiteinfoSearch;
import com.icinfo.cs.yr.service.IWebsiteinfoSearchService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_websiteinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月21日
 */
@Service
public class WebsiteinfoSearchServiceImpl extends MyBatisServiceSupport implements IWebsiteinfoSearchService {
	
	@Autowired
	private WebsiteinfoSearchMapper websiteinfoSearchMapper;

	/** 
	 * 描述: 查询网站信息列表
	 * @auther ZhouYan
	 * @date 2017年7月24日 
	 * @param request
	 * @return 
	 */
	@Override
	public List<WebsiteinfoSearchDto> selectWebsiteinfoSearchList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return websiteinfoSearchMapper.selectWebsiteinfoSearchList(handleParamsMap(paramsMap));
	}

	/** 
	 * 描述: 查询结果统计
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param pramsMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<WebsiteinfoSearchDto> selectWebsiteinfoTotal(
			Map<String, Object> paramsMap) throws Exception {
		return websiteinfoSearchMapper.selectWebsiteinfoTotal(handleParamsMap(paramsMap));
	}
	
	/** 
	 * 描述: 处理参数
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception{
		if(paramsMap != null){
			if(paramsMap.containsKey("entTypeCatg")){
				String entTypeCatg = (String) paramsMap.get("entTypeCatg");
				if(StringUtil.isNotEmpty(entTypeCatg)){
					String[] entTypeCatgList = entTypeCatg.split(",");
					paramsMap.put("entTypeCatg", entTypeCatgList);
				}			
			}
			if(paramsMap.containsKey("webType")){
				String webType = (String) paramsMap.get("webType");
				if(StringUtil.isNotEmpty(webType)){
					String[] webTypeList = webType.split(",");
					paramsMap.put("webType", webTypeList);
				}
			}
			
			if(paramsMap.containsKey("regOrg")){
				String regOrg = (String) paramsMap.get("regOrg");
				if(StringUtil.isNotEmpty(regOrg)){
					String[] regOrgList = regOrg.split(",");
					paramsMap.put("regOrg", regOrgList);
				}			
			}
			
			if(paramsMap.containsKey("regUnit")){
			
				String regUnit = (String) paramsMap.get("regUnit");
				if(StringUtil.isNotEmpty(regUnit)){
					String[] regUnitList = regUnit.split(",");
					paramsMap.put("regUnit", regUnitList);
				}
			}
			
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
			
			if(paramsMap.containsKey("industryCo")){
				String industryCo = (String) paramsMap.get("industryCo");
				if(StringUtil.isNotEmpty(industryCo)){
					String[] industryCoList = industryCo.split(",");
					paramsMap.put("industryCo", industryCoList);
				}
			}
			
			if(paramsMap.containsKey("entType")){
				String entType = (String) paramsMap.get("entType");
				if(StringUtil.isNotEmpty(entType)){
					String[] entTypeList = entType.split(",");
					paramsMap.put("entType", entTypeList);
				}
			}
		}
		return paramsMap;
	}

	/** 
	 * 描述: 查询网站列表
	 * @auther ZhouYan
	 * @date 2017年7月31日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<WebsiteinfoSearch> queryPage(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return websiteinfoSearchMapper.selectWebsiteinfoList(paramsMap);
	}
	
	
}