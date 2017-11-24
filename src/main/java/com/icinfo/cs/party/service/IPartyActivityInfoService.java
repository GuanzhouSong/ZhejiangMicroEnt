/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.party.dto.PartyActivityInfoDto;
import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_party_activity_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
public interface IPartyActivityInfoService extends BaseService {
	
	public List<PartyActivityInfo> selectPartyActivityInfo() throws Exception;
	
	/**
	 * 
	 * 描述: 党建活动信息录入查询
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @param map
	 * @return
	 */
	public List<PartyActivityInfoDto> selectPartyActivityInfoList(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述: 增加
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int insert(PartyActivityInfo partyActivityInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 修改
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int update(PartyActivityInfo partyActivityInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 根据uid查询数据
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public PartyActivityInfo selectOneByUID(String uid) throws Exception;
	
	/**
	 * 
	 * 描述: 查询活动总参与人数 （不同活动涉及的相同参与人数不要去重）
	 * @auther gaojinling
	 * @date 2017年9月12日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectActivityJoinerSum(Map<String, Object> map) throws Exception;
	
}