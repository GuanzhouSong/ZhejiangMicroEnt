/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service.impl;


import com.icinfo.cs.party.mapper.PartyActivityInfoMapper;
import com.icinfo.cs.party.mapper.PartyActivityJoinResultMapper;
import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.cs.party.model.PartyActivityJoinResult;
import com.icinfo.cs.party.service.IPartyActivityJoinResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_party_activity_joinResult 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
@Service
public class PartyActivityJoinResultServiceImpl extends MyBatisServiceSupport implements IPartyActivityJoinResultService {
	
	@Autowired
	private PartyActivityJoinResultMapper partyActivityJoinResultMapper;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int insert(PartyActivityJoinResult partyActivityJoinResult) throws Exception{
		return partyActivityJoinResultMapper.insert(partyActivityJoinResult);
	}
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param ActivityUID
	 * @return
	 * @throws Exception
	 */
	public int delete(String activityUID)throws Exception{
		Example example = new Example(PartyActivityJoinResult.class);
		example.createCriteria().andEqualTo("activityUID", activityUID);
		return partyActivityJoinResultMapper.deleteByExample(example);
	}
	
}