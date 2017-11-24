/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import com.icinfo.cs.ext.dto.MidLiquidationDto;
import com.icinfo.cs.ext.mapper.MidLiquidationMapper;
import com.icinfo.cs.ext.service.IMidLiquidationService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_liquidation 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
@Service
public class MidLiquidationServiceImpl extends MyBatisServiceSupport implements IMidLiquidationService {
	
	@Autowired
	MidLiquidationMapper midLiquidationMapper;

	@Override
	public MidLiquidationDto queryResult(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		return midLiquidationMapper.queryResultByPripid(queryMap);
	}
}