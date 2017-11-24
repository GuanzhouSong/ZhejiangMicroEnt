/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service;

import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.cs.party.model.PartyActivityJoinResult;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_party_activity_joinResult 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
public interface IPartyActivityJoinResultService extends BaseService {
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int insert(PartyActivityJoinResult partyActivityJoinResult) throws Exception;
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param ActivityUID
	 * @return
	 * @throws Exception
	 */
	public int delete(String activityUID)throws Exception;
}