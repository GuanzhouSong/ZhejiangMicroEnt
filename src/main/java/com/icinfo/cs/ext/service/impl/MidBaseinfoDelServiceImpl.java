/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import com.icinfo.cs.ext.mapper.MidBaseinfoDelMapper;
import com.icinfo.cs.ext.model.MidBaseinfoDel;
import com.icinfo.cs.ext.service.IMidBaseinfoDelService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_mid_baseinfo_del 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月26日
 */
@Service
public class MidBaseinfoDelServiceImpl extends MyBatisServiceSupport implements IMidBaseinfoDelService {
	
	@Autowired
	MidBaseinfoDelMapper midBaseinfoDelMapper;

	@Override
	public List<MidBaseinfoDel> selectMidBaseinfoDelList() {
		return midBaseinfoDelMapper.selectMidBaseinfoDelList();
	}
}