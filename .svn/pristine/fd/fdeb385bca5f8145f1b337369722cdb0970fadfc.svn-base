/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.service.IPubScagentService;
import com.icinfo.cs.sccheck.dto.PubScGroupDto;
import com.icinfo.cs.sccheck.dto.PubScentAgentBackDto;
import com.icinfo.cs.sccheck.dto.PubScentAgentDto;
import com.icinfo.cs.sccheck.mapper.PubScentAgentMapper;
import com.icinfo.cs.sccheck.model.PubScGroupMember;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentAgent;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.cs.sccheck.service.IPubScGroupMemberService;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentAgentBackService;
import com.icinfo.cs.sccheck.service.IPubScentAgentService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_scent_agent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
@Service
public class PubScentAgentServiceImpl extends MyBatisServiceSupport implements IPubScentAgentService {
	@Autowired
	private PubScentAgentMapper pubScentAgentMapper;
	@Autowired
	private IPubScdeptTaskService pubScdeptTaskService;
	@Autowired
	private IPubScentAgentBackService pubScentAgentBackService;
	@Autowired
	private IPubScentService pubScentService;
	@Autowired
	private IPubScentResultService pubScentResultService;
	@Autowired
	private IPubScagentService pubScagentService;
	@Autowired
	private IPubScGroupService pubScGroupService;
	@Autowired
	private IPubScGroupMemberService pubScGroupMemberService;

	/**
	 * 描述：企业随机配对执法人员
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param sysUser
	 * @param deptTaskUid
	 * @param groupNum
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean doRandomEntAgent(SysUserDto sysUser, String deptTaskUid, int groupNum,String randomType)
			throws Exception {
		this.deleteByTaskUid(deptTaskUid);
		pubScentResultService.deleteByTaskUid(deptTaskUid);
		// 1.查询执法人员信息
		List<PubScentAgentBackDto> pubScentAgentBackList = pubScentAgentBackService.selectPubScentAgentBackList(deptTaskUid);
		// 2.随机分组
		List<PubScent> pubScentList = pubScentService.selectPubSentByDeptTaskUId(deptTaskUid);
		if(CollectionUtils.isEmpty(pubScentAgentBackList) || CollectionUtils.isEmpty(pubScentList)){
			return false;
		}
		// 3.随机配对
		assignEntToAgent(pubScentAgentBackList, pubScentList, groupNum, deptTaskUid);
		pubScdeptTaskService.updatePubScdeptTask(deptTaskUid, pubScentAgentBackList.size(), new Date(),randomType,groupNum);
		return true;
	}
	
	/**
	 * 描述:随机配对
	 * @param pubScentAgentBackList
	 * @param pubScentList
	 * @param groupNum
	 * @param deptTaskUid
	 */
	private void assignEntToAgent(List<PubScentAgentBackDto> pubScentAgentBackList,List<PubScent> pubScentList,int groupNum,String deptTaskUid){
		int size = pubScentAgentBackList.size();
		int step = new Random().nextInt(size);//随机抽取第一个
		PubScentResult pubScentResult = new PubScentResult();
		for (PubScent pubScent : pubScentList) {
			String agentNames = "";
			String checkDeptNames = "";
			if (size > 0 && size >= groupNum) {
				for (int i = 0; i < groupNum; i++) {
					if (step > size - 1) {
						step = 0;
					}
					PubScentAgentBackDto pubScentAgentBackDto = pubScentAgentBackList.get(step);
					PubScentAgent pubScentAgent = new PubScentAgent();
					pubScentAgent.setTaskUid(deptTaskUid);
					pubScentAgent.setAgentUid(pubScentAgentBackDto.getAgentUid());
					pubScentAgent.setPriPID(pubScent.getPriPID());
					pubScentAgent.setScentUid(pubScent.getUid());
					pubScentAgentMapper.insertSelective(pubScentAgent);
					if(StringUtils.isEmpty(agentNames)){
						agentNames += pubScentAgentBackDto.getAgentName();
						checkDeptNames += pubScentAgentBackDto.getSlicenNOName();
					}else{
						agentNames += "，"+pubScentAgentBackDto.getAgentName();
						if(StringUtils.isNotEmpty(pubScentAgentBackDto.getSlicenNOName()) && checkDeptNames.indexOf(pubScentAgentBackDto.getSlicenNOName()) <= -1){
							checkDeptNames += "，"+pubScentAgentBackDto.getSlicenNOName();
						}
					}
					step++;
				}
			}
			pubScentResult.setMainTaskUid(pubScent.getTaskUid());
			pubScentResult.setTaskUid(deptTaskUid);
			pubScentResult.setPriPID(pubScent.getPriPID());
			pubScentResult.setAuditState("1");
			pubScentResult.setCheckDeptPerson(StringUtils.isEmpty(agentNames)?"":agentNames);
			pubScentResult.setCheckDeptName(StringUtils.isEmpty(checkDeptNames)?"":checkDeptNames);
			pubScentResult.setScentUid(pubScent.getUid());
			pubScentResultService.savePubScentResult(pubScentResult);
		}
	}

	/**
	 * 描述：查看企业匹配的执法人员
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doSelectEntAgent(String deptTaskUid, String priPID) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskUid", deptTaskUid);
		params.put("priPID", priPID);
		List<String> agentNameList = pubScentAgentMapper.selectEntAgents(params);
		String agentNames = "";
		for (String agentName : agentNameList) {
			if (StringUtils.isEmpty(agentNames)) {
				agentNames = agentName;
			} else {
				agentNames += "，" + agentName;
			}
		}
		return agentNames;
	}
	
	/**
	 * 描述：查看企业匹配的执法人员
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param priPID
	 * @param scentUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doSelectEntAgent(String deptTaskUid, String priPID,String scentUid) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskUid", deptTaskUid);
		params.put("priPID", priPID);
		params.put("scentUid", scentUid);
		List<String> agentNameList = pubScentAgentMapper.selectEntAgents(params);
		String agentNames = "";
		for (String agentName : agentNameList) {
			if (StringUtils.isEmpty(agentNames)) {
				agentNames = agentName;
			} else {
				agentNames += "，" + agentName;
			}
		}
		return agentNames;
	}

	/**
	 * 描述：查看企业匹配的部门
	 * @author baifangfang
	 * @date 2017-6-2
	 * @param deptTaskUid
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doSelectDeptName(String deptTaskUid, String priPID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskUid", deptTaskUid);
		params.put("priPID", priPID);
		List<String> deptNameList = pubScentAgentMapper.selectDeptNames(params);
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		set.addAll(deptNameList);
		newList.addAll(set);
		String deptNames = "";
		for (String deptName : newList) {
			if (StringUtils.isEmpty(deptNames)) {
				deptNames = deptName;
			} else {
				deptNames += "，" + deptName;
			}
		}
		return deptNames;
	}
	
	/**
	 * 描述：查看企业匹配的部门
	 * @author baifangfang
	 * @date 2017-6-2
	 * @param deptTaskUid
	 * @param priPID
	 * @param scentUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doSelectDeptName(String deptTaskUid, String priPID,String scentUid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskUid", deptTaskUid);
		params.put("priPID", priPID);
		params.put("scentUid", scentUid);
		List<String> deptNameList = pubScentAgentMapper.selectDeptNames(params);
		Set<String> set = new HashSet<String>();
		List<String> newList = new ArrayList<String>();
		set.addAll(deptNameList);
		newList.addAll(set);
		String deptNames = "";
		for (String deptName : newList) {
			if (StringUtils.isEmpty(deptNames)) {
				deptNames = deptName;
			} else {
				deptNames += "，" + deptName;
			}
		}
		return deptNames;
	}
	
	/**
	 * 描述：查看企业匹配执法人员列表
	 * @author chenxin
	 * @date 2017-6-13
	 * @param request
	 * @return
	 */
	@Override
	public List<PubScentAgentDto> selectPubScentAgentDtoList(PageRequest request)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentAgentMapper.selectPubScentAgentDtoList(request.getParams());
	}
	
	/**
	 * 描述：检查名单与人员查询
	 * @author chenxin
	 * @date 2017-6-13
	 * @param request
	 * @return
	 */
	@Override
	public List<PubScentAgentDto> selectSearchList(PageRequest request)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentAgentMapper.selectSearchList(request.getParams());
	}
	
	/**
	 * 描述:调整执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param sysUser
	 * @param scentAgentUids
	 * @param agentUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean doSignEntAgent(SysUserDto sysUser, String scentAgentUids,String agentUid) throws Exception {
		if(StringUtils.isNotEmpty(scentAgentUids) && StringUtils.isNotEmpty(agentUid)){
			String[] uids = scentAgentUids.split(",");
			for(String uid : uids){
				Example example = new Example(PubScentAgent.class);
				example.createCriteria().andEqualTo("uid", uid);
				PubScentAgent pubScentAgent = new PubScentAgent();
				pubScentAgent.setAgentUid(agentUid);
				pubScentAgent.setAdjustUserUid(sysUser.getId());
				pubScentAgent.setAdjustUserName(sysUser.getRealName());
				pubScentAgent.setAdjustDate(new Date());
				pubScentAgentMapper.updateByExampleSelective(pubScentAgent, example);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUidAndPriPID(String taskUid, String priPID)throws Exception {
		Example example = new Example(PubScentAgent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("priPID", priPID);
		pubScentAgentMapper.deleteByExample(example);
	}
	
	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param scentUid
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUidAndScentUid(String taskUid, String scentUid)throws Exception {
		Example example = new Example(PubScentAgent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("scentUid", scentUid);
		pubScentAgentMapper.deleteByExample(example);
	}
	
	/**
	 * 描述:删除企业对应执法人员
	 * @author chenxin
	 * @date 2017-06-14
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUid(String taskUid) throws Exception {
		Example example = new Example(PubScentAgent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid);
		pubScentAgentMapper.deleteByExample(example);
	}
	
	/**
	 * 描述：企业随机配对检查小组
	 * @author chenxin
	 * @date 2017-7-12
	 * @param sysUser
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean doRandomByGroup(SysUserDto sysUser, String deptTaskUid,int groupNum)throws Exception {
		if(StringUtils.isNotEmpty(deptTaskUid)){
			//1.先清空抽取库数据
			this.deleteByTaskUid(deptTaskUid);
			pubScentResultService.deleteByTaskUid(deptTaskUid);
			//2.查询检查小组
			List<PubScGroupDto> pubScGroupList = pubScGroupService.selectListBySysUser(sysUser);
			if(pubScGroupList ==null || pubScGroupList.size() == 0 || groupNum > pubScGroupList.size()){
				return false;
			}
			//随机抽取一定个数的检查小组
			List<PubScGroupDto> randomPubScGroupList = getRandomPubScGroupList(pubScGroupList,groupNum);
			int totalGroup = randomPubScGroupList.size();
			//3.随机分组
			List<PubScent> pubScentList = pubScentService.selectPubSentByDeptTaskUId(deptTaskUid);
			int step = new Random().nextInt(totalGroup);//随机抽取第一个
			for(PubScent pubScent : pubScentList){
				if(step > totalGroup-1){
					step = 0 ;
				}
				this.matchEntToGroup(pubScent,randomPubScGroupList.get(step));
				step++;
			}
			pubScdeptTaskService.updatePubScdeptTask(deptTaskUid, pubScGroupList.size(), new Date(),"1",groupNum);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：随机抽取检查小组
	 * @author chenxin
	 * @date 2017-7-12
	 * @param sysUser
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	private List<PubScGroupDto> getRandomPubScGroupList(List<PubScGroupDto> pubScGroupList,int groupNum) {
		int total = pubScGroupList.size();
		if(groupNum == total){
			return pubScGroupList;
		}
		List<PubScGroupDto> randomPubScGroupList = new ArrayList<PubScGroupDto>();
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i<groupNum;i++){
			boolean flag = true;
			while(flag){
				int randomNum = new Random().nextInt(total);//随机抽取一个
				if(!set.contains(randomNum)){
					set.add(randomNum);
					randomPubScGroupList.add(pubScGroupList.get(randomNum));
					flag = false;
				}
			}
		}
		return randomPubScGroupList;
	}

	/**
	 * 描述：企业随机配对检查小组
	 * @author chenxin
	 * @date 2017-7-12
	 * @param pubScent
	 * @param pubScGroupDto
	 * @throws Exception
	 */
	public void matchEntToGroup(PubScent pubScent,PubScGroupDto pubScGroupDto)throws Exception{
		String deptTaskUid = pubScent.getDeptTaskUid();
		String scentUid = pubScent.getUid();
		String agentNames = "";
		String checkDeptNames = "";
		String teamLeader = "";
		String expertNames = "";
		List<PubScGroupMember> pubScGroupMemberList = pubScGroupMemberService.selectByGroupUid(pubScGroupDto.getUid());
		if(pubScGroupMemberList != null && pubScGroupMemberList.size() > 0){
			for(PubScGroupMember pubScGroupMember : pubScGroupMemberList){
				PubScentAgent pubScentAgent = new PubScentAgent();
				String agentName = pubScGroupMember.getAgentName();//检查人员姓名
				String checkDeptName = pubScGroupMember.getAgentDeptName();//检查部门
				if(StringUtils.isEmpty(agentNames)){
					agentNames = agentName;
				}else{
					agentNames += "，"+agentName;
				}
				if(StringUtils.isEmpty(checkDeptNames)){
					checkDeptNames = checkDeptName;
				}else{
					if(checkDeptNames.indexOf(checkDeptName) <= -1){
						checkDeptNames += "，"+checkDeptName;
					}
				}
				if("1".equals(pubScGroupMember.getExpertFlag())){
					pubScentAgent.setExpertFlag("1");
					if(StringUtils.isEmpty(expertNames)){
						expertNames = agentName;
					}else{
						expertNames += "，"+agentName;
					}
				}
				if("1".equals(pubScGroupMember.getLeaderFlag())){
					teamLeader = agentName;
					pubScentAgent.setLeaderFlag("1");
				}
				pubScentAgent.setTaskUid(deptTaskUid);
				pubScentAgent.setAgentUid(pubScGroupMember.getAgentUid());
				pubScentAgent.setPriPID(pubScent.getPriPID());
				pubScentAgent.setScentUid(scentUid);
				pubScentAgentMapper.insertSelective(pubScentAgent);
			}
		}
		PubScentResult pubScentResult = new PubScentResult();
		pubScentResult.setMainTaskUid(pubScent.getTaskUid());
		pubScentResult.setTaskUid(deptTaskUid);
		pubScentResult.setPriPID(pubScent.getPriPID());
		pubScentResult.setAuditState("1");
		pubScentResult.setCheckDeptPerson(agentNames);
		pubScentResult.setCheckDeptName(checkDeptNames);
		pubScentResult.setExpertNames(expertNames);
		pubScentResult.setTeamLeader(teamLeader);
		pubScentResult.setScentUid(scentUid);
		pubScentResultService.savePubScentResult(pubScentResult);
	}
	
	/**
	 * 
	 * 描述: 可视化检察人员统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScentAgentDto> selectPubScentAgentChartsCount(Map<String, Object> map) throws Exception{
		return pubScentAgentMapper.selectPubScentAgentChartsCount(map);
	}
	
	
}