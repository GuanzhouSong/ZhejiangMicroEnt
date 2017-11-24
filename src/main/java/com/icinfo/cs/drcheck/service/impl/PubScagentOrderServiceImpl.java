/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import com.icinfo.cs.drcheck.mapper.PubScagentOrderMapper;
import com.icinfo.cs.drcheck.model.PubScagentOrder;
import com.icinfo.cs.drcheck.service.IPubScagentOrderService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_scagent_order 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Service
public class PubScagentOrderServiceImpl extends MyBatisServiceSupport implements IPubScagentOrderService {
	
	@Autowired
	private PubScagentOrderMapper pubScagentOrderMapper;
	
	/**
	 * 描述: 通过agentInnerId查询当前排序信息
	 * @auther yujingwei
	 * @date 2016年11月21日
	 * @param agentInnerId
	 * @return PubScagentOrder
	 * @throws Exception
	 */	
	public PubScagentOrder selectOrderByInnerId(String agentInnerId) throws Exception{
		PubScagentOrder pubScagentOrder = new PubScagentOrder();
		pubScagentOrder.setAgentInnerId(agentInnerId);
		return pubScagentOrderMapper.selectOne(pubScagentOrder);
	}
}