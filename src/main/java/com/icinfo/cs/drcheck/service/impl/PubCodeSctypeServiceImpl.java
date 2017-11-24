/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.mapper.PubCodeSctypeMapper;
import com.icinfo.cs.drcheck.service.IPubCodeSctypeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:  cs_pub_code_sctype 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
@Service
public class PubCodeSctypeServiceImpl extends MyBatisServiceSupport implements IPubCodeSctypeService {

    @Autowired
    private PubCodeSctypeMapper pubCodeSctypeMapper;

	@Override
	public List<Map<String, Object>> selectToTreeMap(Map<String,Object> map) {
		return pubCodeSctypeMapper.selectToTreeMap(map);
	}
}