/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.party.dto.PartyActivityInfoDto;
import com.icinfo.cs.party.mapper.PartyActivityInfoMapper;
import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.cs.party.model.PartyActivityJoinResult;
import com.icinfo.cs.party.service.IPartyActivityInfoService;
import com.icinfo.cs.party.service.IPartyActivityJoinResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_party_activity_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
@Service
public class PartyActivityInfoServiceImpl extends MyBatisServiceSupport implements IPartyActivityInfoService {
	
	@Autowired
	private PartyActivityInfoMapper partyActivityInfoMapper;
	@Autowired
	private IPartyActivityJoinResultService partyActivityJoinResultService ;
	
	
	public List<PartyActivityInfo> selectPartyActivityInfo() throws Exception {
		return partyActivityInfoMapper.selectAll();
	}
	
	
	/**
	 * 
	 * 描述: 党建活动信息录入查询
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @param map
	 * @return
	 */
	public List<PartyActivityInfoDto> selectPartyActivityInfoList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if(map !=null){
			//查询时条件处理
			if(map.get("claimLocalAdm") !=null){  //管辖单位
				map.put("claimLocalAdm", StringUtil.doSplitStringToSqlFormat(map.get("claimLocalAdm").toString(),","));
			}
			if(map.get("joinerIds") !=null){  //管辖单位
				map.put("joinerIds", StringUtil.doSplitStringToSqlFormat(map.get("joinerIds").toString(),","));
			}
		}else{
			map = new HashMap<String, Object>();
		}
		return partyActivityInfoMapper.selectPartyActivityInfoList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 增加
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int insert(PartyActivityInfo partyActivityInfo) throws Exception{
		if(partyActivityInfo != null){
			return partyActivityInfoMapper.insert(partyActivityInfo);
		}else{
			return 0;
		}
	}
	
	/**
	 * 
	 * 描述: 修改
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param partyActivityInfo
	 * @return
	 * @throws Exception
	 */
	public int update(PartyActivityInfo partyActivityInfo) throws Exception{
		if(StringUtil.isBlank(partyActivityInfo.getUID())){
			return 0;
		}
		int res = 0;
		Example example = new Example(PartyActivityInfo.class);
		example.createCriteria().andEqualTo("UID", partyActivityInfo.getUID());
		try {
			res = partyActivityInfoMapper.updateByExampleSelective(partyActivityInfo, example);
			//处理参与人
			String joinerIds = partyActivityInfo.getJoinerId();
			String joiners = partyActivityInfo.getJoiner();
			//删除当前活动下的参与人
			partyActivityJoinResultService.delete(partyActivityInfo.getUID());
			if(joinerIds!=null){
				 String[] joiner = joiners.split(",");
			     String[] joinerId = joinerIds.split(",");
			     for(int i=0;i<joiner.length;i++){
			    	 PartyActivityJoinResult partyActivityJoinResult = new PartyActivityJoinResult();
			    	 partyActivityJoinResult.setActivityUID(partyActivityInfo.getUID());
			    	 partyActivityJoinResult.setJoinerId(joinerId[i]);
			    	 partyActivityJoinResult.setJoiner(joiner[i]);
			    	 partyActivityJoinResultService.insert(partyActivityJoinResult);
			     }
			}
		} catch (Exception e) {
			return 0;
		}
		return res;
	}
	
	/**
	 * 
	 * 描述: 根据uid查询数据
	 * @auther gaojinling
	 * @date 2017年9月6日 
	 * @param uid
	 * @return
	 * @throws Exception		
	 */
	public PartyActivityInfo selectOneByUID(String uid) throws Exception{
		PartyActivityInfo partyActivityInfo = new PartyActivityInfo();
		partyActivityInfo.setUID(uid);
		return partyActivityInfoMapper.selectOne(partyActivityInfo);
	}
	
	/**
	 * 
	 * 描述: 查询活动总参与人数 （不同活动涉及的相同参与人数不要去重）
	 * @auther gaojinling
	 * @date 2017年9月12日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectActivityJoinerSum(Map<String, Object> map) throws Exception{
		return partyActivityInfoMapper.selectActivityJoinerSum(map);
	}
	
	
}