/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.PubScinfoAgentDto;
import com.icinfo.cs.drcheck.mapper.PubScinfoAgentMapper;
import com.icinfo.cs.drcheck.model.PubScinfoAgent;
import com.icinfo.cs.drcheck.service.IPubScinfoAgentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scinfo_agent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
@Service
public class PubScinfoAgentServiceImpl extends MyBatisServiceSupport implements IPubScinfoAgentService {
	
	@Autowired
	PubScinfoAgentMapper pubScinfoAgentMapper;
	
	/**
	 * 描述:查询执法人员调整页面list数据
	 * @author yujingwei
	 * @date 2016-11-06
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<PubScinfoAgentDto> selectScagentAdjustList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScinfoAgentMapper.selectScagentAdjustList(request.getParams());
	}
	
	/**
	 * 描述:执法人员调整
	 * @author yujingwei
	 * @date 2016-11-06
	 * @param adjustUid,agentUids
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doAdjustScagent(String adjustUid, String agentUids) throws Exception{
		if(StringUtil.isEmpty(agentUids) || StringUtil.isEmpty(adjustUid)){
			return false;
		}
		List<String> agentUidList = Arrays.asList(agentUids.split(","));
		if(CollectionUtils.isNotEmpty(agentUidList)){
			for(String agentUid : agentUidList){
				PubScinfoAgent pubScinfoAgent = new PubScinfoAgent();
				pubScinfoAgent.setAgentUid(adjustUid);
				Example example = new Example(PubScinfoAgent.class);
				example.createCriteria().andEqualTo("UID", agentUid);
				pubScinfoAgentMapper.updateByExampleSelective(pubScinfoAgent, example);
			}
		}
		return true;
	}
	
	/**
	 *描述：插入执法人员对应企业表
	 *@author chenxin
	 *@date 2016-11-23
	 * @param pubScinfoAgent
	 * @return
	 * @throws Exception
	 */
	@Override
	public int savePubScinfoAgent(PubScinfoAgent pubScinfoAgent)
			throws Exception {
		return pubScinfoAgentMapper.insertSelective(pubScinfoAgent);
	}
	
	/**
	 *描述：清空执法人员对应企业表
	 *@author chenxin
	 *@date 2016-11-23
	 * @param deptTaskNO
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	@Override
	public void cleanPubScinfoAgent(String deptTaskNO, String taskNO)throws Exception {
		Example example = new Example(PubScinfoAgent.class);
		example.createCriteria().andEqualTo("deptTaskNO", deptTaskNO).andEqualTo("taskNO", taskNO);
		pubScinfoAgentMapper.deleteByExample(example);
	}
	
	/**
	 *描述：查询企业对应的执法人员
	 *@author chenxin
	 *@date 2016-11-24
	 * @param deptTaskNO
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public String selectPubScinfoAgentDto(String deptTaskNO,String taskNO, String priPID) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("deptTaskNO", deptTaskNO);
		params.put("taskNO", taskNO);
		params.put("priPID", priPID);
		List<PubScinfoAgentDto> pubScinfoAgentDtoList = pubScinfoAgentMapper.selectPubScinfoAgentDto(params);
		String agentNames = "";
		if(pubScinfoAgentDtoList != null && pubScinfoAgentDtoList.size() > 0){
			for(int i = 0;i<pubScinfoAgentDtoList.size();i++){
				String agentName = pubScinfoAgentDtoList.get(i).getAgentName();
				if(i==0){
					agentNames = agentName;
				}else{
					agentNames += "，"+agentName;
				}
			}
		}
		return agentNames;
	}
}