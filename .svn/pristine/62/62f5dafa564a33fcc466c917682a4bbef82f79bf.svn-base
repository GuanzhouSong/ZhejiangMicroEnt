/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service.impl;

import com.icinfo.cs.es.mapper.PubSearchLogMapper;
import com.icinfo.cs.es.model.PubSearchLog;
import com.icinfo.cs.es.service.IPubSearchLogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: cs_pub_search_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
@Service
public class PubSearchLogServiceImpl extends MyBatisServiceSupport implements IPubSearchLogService {

	@Autowired
	PubSearchLogMapper pubSearchLogMapper;

	@Override
	public void savePubSearchLog(PubSearchLog pubSearchLog) {
		pubSearchLogMapper.insert(pubSearchLog);
	}
}