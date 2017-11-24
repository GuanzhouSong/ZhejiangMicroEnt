/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.mapper.MortCancelInfoMapper;
import com.icinfo.cs.other.model.MortCancelInfo;
import com.icinfo.cs.other.service.IMortCancelInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_mort_cancel_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class MortCancelInfoServiceImpl extends MyBatisServiceSupport implements IMortCancelInfoService {
	
	@Autowired
	MortCancelInfoMapper mortCancelInfoMapper;

	/** 
	 * 描述: 根据原始抵押登记编号查询注销信息
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param oriFilingNO
	 * @return
	 * @throws Exception 
	 */
	@Override
	public MortCancelInfo doGetMortCancelInfo(String oriFilingNO)
			throws Exception {
		MortCancelInfo mortCancelInfo = new MortCancelInfo();
		mortCancelInfo.setOriFilingNO(oriFilingNO);
		return mortCancelInfoMapper.selectOne(mortCancelInfo);
	}
	
	
}