/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.mapper.MortAltitemInfoMapper;
import com.icinfo.cs.other.model.MortAltitemInfo;
import com.icinfo.cs.other.service.IMortAltitemInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_mort_altitem_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class MortAltitemInfoServiceImpl extends MyBatisServiceSupport implements IMortAltitemInfoService {
	
	@Autowired
	MortAltitemInfoMapper mortAltitemInfoMapper;

	/** 
	 * 描述: 根据原始抵押登记编号查询变更信息
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param oriFilingNO
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<MortAltitemInfo> doGetMortAltitemInfoList(String oriFilingNO)
			throws Exception {
		Example example = new Example(MortAltitemInfo.class);
        example.createCriteria().andEqualTo("oriFilingNO", oriFilingNO);
        example.setOrderByClause("CheckDate desc");
        return mortAltitemInfoMapper.selectByExample(example);
	}
	
	
}