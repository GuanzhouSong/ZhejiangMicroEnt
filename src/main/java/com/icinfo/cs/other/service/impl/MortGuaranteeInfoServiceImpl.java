/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.mapper.MortGuaranteeInfoMapper;
import com.icinfo.cs.other.model.MortGuaranteeInfo;
import com.icinfo.cs.other.service.IMortGuaranteeInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_mort_guarantee_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class MortGuaranteeInfoServiceImpl extends MyBatisServiceSupport implements IMortGuaranteeInfoService {
	
	@Autowired
	MortGuaranteeInfoMapper mortGuaranteeInfoMapper;

	/** 
	 * 描述: 根据订单号查询抵押物信息
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param orderNO
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<MortGuaranteeInfo> doGetMortGuaranteeInfoList(String orderNO)
			throws Exception {
		Example example = new Example(MortGuaranteeInfo.class);
        example.createCriteria().andEqualTo("orderNO", orderNO);
        return mortGuaranteeInfoMapper.selectByExample(example);
	}
	
	
}