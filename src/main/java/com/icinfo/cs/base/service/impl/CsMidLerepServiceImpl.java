/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.dto.CsMidLerepDto;
import com.icinfo.cs.base.mapper.CsMidLerepMapper;
import com.icinfo.cs.base.model.CsMidLerep;
import com.icinfo.cs.base.service.ICsMidLerepService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_lerep 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月11日
 */
@Service
public class CsMidLerepServiceImpl extends MyBatisServiceSupport implements ICsMidLerepService {
    
	@Autowired
	CsMidLerepMapper csMidLerepMapper;
	@Override
	public List<CsMidLerep> selectMidLerepList(Map<String, Object> qryMap) throws Exception {
		Example example = new Example(CsMidLerep.class);
		// 构建条件表达式
		Criteria criteria = example.createCriteria();
		if (qryMap != null) {
			for (Map.Entry<String, Object> entry : qryMap.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		return csMidLerepMapper.selectByExample(example);
	}
}