/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.es.dto.LimitwordDto;
import com.icinfo.cs.es.mapper.LimitwordMapper;
import com.icinfo.cs.es.service.ILimitwordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_pub_limitword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
@Service
public class LimitwordServiceImpl extends MyBatisServiceSupport implements ILimitwordService {
	
	@Autowired
	LimitwordMapper limitwordMapper;
 
	@Override
	public List<LimitwordDto> queryListResult(Map<String, Object> queryMap) {
		return limitwordMapper.queryListResult(queryMap);
	}
}