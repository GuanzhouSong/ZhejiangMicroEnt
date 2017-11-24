/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.service.impl;

import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.cs.secnocreditsup.mapper.SecCreditSearchMapper;
import com.icinfo.cs.secnocreditsup.service.ISecNoCreditSearchService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 2016年11月25日
 */
@Service
public class SecCreditSearchServiceImpl extends MyBatisServiceSupport implements ISecNoCreditSearchService {

	@Autowired
	SecCreditSearchMapper secCreditSearchMapper;
    /**
     * 获取查询数据
     * @author zjj
     */
	@Override
	public List<SecNoCreditSearchDto> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return secCreditSearchMapper.selectSecCreditSearchList(handleParamsMap(paramsMap));
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
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
		}
		return paramsMap;
	}
}