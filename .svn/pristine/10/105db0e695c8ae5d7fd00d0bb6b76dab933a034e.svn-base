/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.PubScagentDto;
import com.icinfo.cs.drcheck.model.PubScagent;
import com.icinfo.cs.drcheck.service.IPubScagentService;
import com.icinfo.cs.sccheck.dto.PubScGroupMemberDto;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.mapper.PubScGroupMapper;
import com.icinfo.cs.sccheck.mapper.PubScGroupMemberMapper;
import com.icinfo.cs.sccheck.mapper.PubScentAgentMapper;
import com.icinfo.cs.sccheck.mapper.PubScentResultMapper;
import com.icinfo.cs.sccheck.model.PubScGroup;
import com.icinfo.cs.sccheck.model.PubScGroupMember;
import com.icinfo.cs.sccheck.model.PubScentAgent;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.cs.sccheck.service.IPubScGroupMemberService;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.sccheck.service.IPubScentAgentService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scgroup_member 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
@Service
public class PubScGroupMemberServiceImpl extends MyBatisServiceSupport implements IPubScGroupMemberService {
	
	@Autowired
	private PubScGroupMemberMapper pubScGroupMemberMapper;
	
	@Autowired
	private IPubScGroupService pubScGroupService;
	
	@Autowired
	private PubScGroupMapper pubScGroupMapper;
	
	@Autowired
	private PubScentResultMapper pubScentResultMapper;
	
	@Autowired
	private IPubScagentService pubScagentService;
	
	@Autowired
	private ISysDepartService sysDepartService;
	
	@Autowired
	private IPubScentResultService pubScentResultService;
	
	@Autowired
	private IPubScentAgentService pubScentAgentService; 
	@Autowired
	private PubScentAgentMapper pubScentAgentMapper; 
			
	
	/**
	 * 描述：执法人员调整初始化组员数据
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @return 
	 * @throws Exception
	 */
	public void doInitGroupAndMemberData(SysUserDto sysUserDto,String resultUids) throws Exception{
		if(sysUserDto == null || StringUtil.isEmpty(resultUids)){
			return;
		}
		// 1.删除成员表
		PubScGroup group = new PubScGroup();
		group.setSetUserUid(sysUserDto.getId());
		group.setGroupType("2");
		PubScGroup record = pubScGroupMapper.selectOne(group);
		if(record != null){
			Example mbexample = new Example(PubScGroupMember.class);
			mbexample.createCriteria()
			.andEqualTo("groupUid", record.getUid());
			pubScGroupMemberMapper.deleteByExample(mbexample);
		}
	    // 2.删除分组表
		Example example = new Example(PubScGroup.class);
		example.createCriteria()
		.andEqualTo("setUserUid", sysUserDto.getId())
		.andEqualTo("groupType", "2");
		pubScGroupMapper.deleteByExample(example);
		// 3.插入分组
		PubScGroup pubScGroup = new PubScGroup();
		pubScGroup.setGroupType("2");
		pubScGroup.setSetDeptCode(sysUserDto.getUserType().equals("1")
				?sysUserDto.getDepartMent().getDeptCode()
						:sysUserDto.getSysDepart().getAdcode().substring(0, 8));
		pubScGroup.setSetUserName(sysUserDto.getRealName());
		pubScGroup.setSetUserUid(sysUserDto.getId());
		pubScGroup.setSetTime(new Date());
		if(pubScGroupMapper.insert(pubScGroup) > 0 && !resultUids.contains(",")){
			// 4.插入成员表
			List<PubScentResultDto> agents = pubScentResultMapper.doGetAgentIdByResultuid(resultUids);
			if(agents !=null && agents.size() > 0){
				for(PubScentResultDto dto : agents){
					PubScGroupMember groupMember = new PubScGroupMember();
					PubScGroup insertInfo = pubScGroupMapper.selectOne(group);
					if(insertInfo != null){
						groupMember.setGroupUid(insertInfo.getUid());
						groupMember.setAgentName(dto.getCheckDeptPerson());
						groupMember.setAgentUid(dto.getUid());
						groupMember.setExpertFlag(dto.getExpertNames());
						groupMember.setLeaderFlag(dto.getTeamLeader());
						groupMember.setAgentDeptName(dto.getCheckDeptName());
						pubScGroupMemberMapper.insert(groupMember);
					}
				}
			}
		}
	}
	
	/**
	 * 描述：保存成员信息并返回分组页面
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doBackMemberPageOpt(String agentUids,SysUserDto sysUserDto) throws Exception{
		if(StringUtil.isEmpty(agentUids) || sysUserDto == null){
			return false;
		}
		String[] agentArry = agentUids.split(",");
		for(int i=0; i<agentArry.length; i++){
			PubScagent pubScagent =  pubScagentService.selectById(agentArry[i]);
			PubScGroupMember groupMember = new PubScGroupMember();
			
			Example example = new Example(PubScGroup.class);
			example.createCriteria()
			.andEqualTo("setUserUid", sysUserDto.getId())
			.andEqualTo("groupType", "2");
			List<PubScGroup> pubScGroups =  pubScGroupMapper.selectByExample(example);
			if(pubScGroups !=null && pubScGroups.size() > 0){
				groupMember.setGroupUid(pubScGroups.get(0).getUid());
				// 已存在执法人员则不再导入
				if(!CollectionUtils.isEmpty(
						doGetGroupmemberInfoByuidAndGroupUid(pubScGroups.get(0).getUid(),pubScagent.getUID()))){
					continue;
				}
			}
			groupMember.setAgentName(pubScagent.getAgentName());
			groupMember.setAgentUid(pubScagent.getUID());
			groupMember.setExpertFlag("N".equals(pubScagent.getExpertFlag())?"0":"1");
			SysDepart sysDepart =  sysDepartService.doGetByCode(pubScagent.getDeptCode());
			if(sysDepart != null){
				groupMember.setAgentDeptName(sysDepart.getOrgName());
			}
			pubScGroupMemberMapper.insert(groupMember);
		}
		return true;
	}
	
	/**
	 * 描述：执法人员调整 提交
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid,sysUserDto
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	public boolean doAdjustScCheckPerson(String resultUids,String expertUid, String leaderUid, SysUserDto sysUserDto) throws Exception{
		if(StringUtil.isEmpty(resultUids) || sysUserDto == null){
			return false;
		}
		String expertName = "";
		String leaderName = "";
		// 专家，组长信息处理
		doOptInitUpdateExpertAndLeaderInfo(sysUserDto);
		if(StringUtil.isNotEmpty(expertUid)){
			String[] expertArry = expertUid.split(",");
			for(int i=0; i< expertArry.length; i++){
				PubScGroupMember groupMember = doGetScgroupMemberByuid(expertArry[i]);
				if(groupMember !=null){
					groupMember.setExpertFlag("1");
					doUpdateGroupMember(groupMember,expertArry[i]);
					if(StringUtil.isBlank(expertName)){
						expertName = groupMember.getAgentName();
					}else{
						expertName += ',' + groupMember.getAgentName();
					}
				}
			}
		}
		if(StringUtil.isNotEmpty(leaderUid)){
			PubScGroupMember scGroupMember = doGetScgroupMemberByuid(leaderUid);
			if(scGroupMember !=null){
				scGroupMember.setLeaderFlag("1");
				doUpdateGroupMember(scGroupMember,leaderUid);
				leaderName = scGroupMember.getAgentName();
			}
		}
		String[] agentArry = resultUids.split(",");
		for(int i=0; i< agentArry.length; i++){
			PubScentResult pubScentResult = getScentResultByUid(agentArry[i]);
			if(pubScentResult != null){
				// 更新结果表信息
				pubScentResult.setTeamLeader(leaderName);
				pubScentResult.setExpertNames(expertName);
				pubScentResult.setCheckDeptPerson(getScGroupmembers(sysUserDto));
				pubScentResult.setAdjustTime(DateUtil.getCurrentDate());
				pubScentResult.setAdjustUserName(sysUserDto.getRealName());
				pubScentResult.setAdjustUserUid(sysUserDto.getId());
				pubScentResultService.updatePubScentResultByUid(pubScentResult);
				if(StringUtil.isNotBlank(pubScentResult.getTaskUid()) && StringUtil.isNotBlank(pubScentResult.getPriPID())){
					// 删除ScentAgent
					pubScentAgentService.deleteByTaskUidAndScentUid(pubScentResult.getTaskUid(), pubScentResult.getScentUid());
					Map<String, Object> params = new HashMap<String, Object>();
					params.put("setUserUid", sysUserDto.getId());
					params.put("groupType", "2");
					List<PubScGroupMemberDto> pubScGroupMemberDtos = pubScGroupMemberMapper.selectPubScGroupMemberDtoList(params);
					if(pubScGroupMemberDtos !=null && pubScGroupMemberDtos.size() > 0){
						for(PubScGroupMemberDto dto : pubScGroupMemberDtos){
							 // 插入ScentAgent
							 PubScentAgent scenAgent = new PubScentAgent();
							 scenAgent.setTaskUid(pubScentResult.getTaskUid());
							 scenAgent.setPriPID(pubScentResult.getPriPID());
							 scenAgent.setAgentUid(dto.getAgentUid());
							 scenAgent.setExpertFlag(dto.getExpertFlag());
							 scenAgent.setLeaderFlag(dto.getLeaderFlag());
							 scenAgent.setAdjustDate(new Date());
							 scenAgent.setAdjustUserUid(sysUserDto.getId());
							 scenAgent.setAdjustUserName(sysUserDto.getRealName());
							 scenAgent.setScentUid(pubScentResult.getScentUid());
							 pubScentAgentMapper.insert(scenAgent);
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * 描述：获取检查人员，以逗号隔开
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param sysUserDto
	 * @return String
	 */
	private String getScGroupmembers(SysUserDto sysUserDto) throws Exception {
		String checkPerson = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("setUserUid", sysUserDto.getId());
		params.put("groupType", "2");
		List<PubScGroupMemberDto> pubScGroupMemberDtos = pubScGroupMemberMapper.selectPubScGroupMemberDtoList(params);
		if(pubScGroupMemberDtos !=null && pubScGroupMemberDtos.size() > 0){
			for(PubScGroupMemberDto memberDto : pubScGroupMemberDtos){
				if(StringUtil.isEmpty(checkPerson)){
					checkPerson = memberDto.getAgentName();
				}else{
					checkPerson += "，" + memberDto.getAgentName();
				}
			}
			return checkPerson;
		}
		return null;
	}

	/**
	 * 描述：初始化更新 专家组长信息
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param sysUserDto
	 * @return void
	 */
	private void doOptInitUpdateExpertAndLeaderInfo(SysUserDto sysUserDto) {
		Example example = new Example(PubScGroup.class);
		example.createCriteria()
		.andEqualTo("setUserUid", sysUserDto.getId())
		.andEqualTo("groupType", "2");
		List<PubScGroup> pubScGroups =  pubScGroupMapper.selectByExample(example);
		if(pubScGroups !=null && pubScGroups.size() > 0){
			PubScGroupMember groupMember = new PubScGroupMember();
			groupMember.setExpertFlag("0");
			groupMember.setLeaderFlag("0");
			Example upExample = new Example(PubScGroupMember.class);
			upExample.createCriteria().andEqualTo("groupUid", pubScGroups.get(0).getUid());
			pubScGroupMemberMapper.updateByExampleSelective(groupMember, upExample);
		}
	}

	/**
	 * 描述：通过uid更新成员信息
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param groupMember，uid
	 * @return int
	 */
	private int doUpdateGroupMember(PubScGroupMember groupMember,String uid){
		Example example = new Example(PubScGroupMember.class);
		example.createCriteria().andEqualTo("uid", uid);
		return pubScGroupMemberMapper.updateByExampleSelective(groupMember, example);
	}
	
	/**
	 * 描述：查询成员信息
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param groupuid，agentUid
	 * @return List<PubScGroupMember>
	 */
	private List<PubScGroupMember> doGetGroupmemberInfoByuidAndGroupUid(String groupuid,String agentUid) {
		Example example = new Example(PubScGroupMember.class);
		example.createCriteria()
		.andEqualTo("agentUid", agentUid)
		.andEqualTo("groupUid", groupuid);
		return pubScGroupMemberMapper.selectByExample(example);
	}
	
	/**
	 * 描述：获取单条成员信息
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @return PubScGroupMember
	 */
	private PubScGroupMember doGetScgroupMemberByuid(String uid) {
		PubScGroupMember groupMember = new PubScGroupMember();
		groupMember.setUid(uid);
		return pubScGroupMemberMapper.selectOne(groupMember);
	}

	/**
	 * 描述：获取单条检查记录
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param resultUid
	 * @return PubScentResult
	 */
	private PubScentResult getScentResultByUid(String resultUid){
		PubScentResult pubScentResult = new PubScentResult();
		pubScentResult.setUid(resultUid);
		return pubScentResultMapper.selectOne(pubScentResult);
	}

	/**
	 * 描述：保存信息返回给随机抽取列表（检查小组）
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param agentUids
	 * @param session
	 * @param groupUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doRandomMemberOpt(String agentUids, String groupUid,SysUserDto sysUserDto,String groupType)
			throws Exception {
		if(StringUtils.isNotEmpty(agentUids)){
			String[] uids = agentUids.split(",");
			for(String uid : uids){
				Example example = new Example(PubScGroupMember.class);
				example.createCriteria().andEqualTo("groupUid", groupUid).andEqualTo("agentUid", uid);
				if(pubScGroupMemberMapper.selectCountByExample(example) >0){
					continue;
				}
				PubScagentDto pubScagent = pubScagentService.selectPubScagentDtoByUid(uid);
				PubScGroupMember pubScGroupMember = new PubScGroupMember();
				pubScGroupMember.setGroupUid(groupUid);
				pubScGroupMember.setAgentUid(uid);
				pubScGroupMember.setAgentName(pubScagent.getAgentName());
				pubScGroupMember.setExpertFlag("0");
				pubScGroupMember.setLeaderFlag("0");
				pubScGroupMember.setAgentDeptName(pubScagent.getOrgName());
				if ("3".equals(groupType)) {
					pubScGroupMember.setOptDataType("2");
				}
				pubScGroupMemberMapper.insert(pubScGroupMember);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：执法人员分组列表
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScGroupMemberDto> queryPageMember(PageRequest request,SysUserDto sysUserDto)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if(params == null){
			params = new HashMap<String, Object>();
		}
		StringUtil.paramTrim(params);
		String userUid = sysUserDto.getId();
		params.put("setUserUid", userUid);
		params.put("groupType", "2");
		return pubScGroupMemberMapper.selectPubScGroupMemberDtoList(params);
	}
	
	/**
	 * 描述：执法人员分组列表(随机抽取执法人员过程使用)
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScGroupMemberDto> queryPageRandomMember(PageRequest request,SysUserDto sysUserDto) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if(params == null){
			params = new HashMap<String, Object>();
		}
		StringUtil.paramTrim(params);
		String userUid = sysUserDto.getId();
		params.put("setUserUid", userUid);
		params.put("isVlid", "0");
		params.put("groupType", "1");
		return pubScGroupMemberMapper.selectPubScGroupMemberDtoList(params);
	}
	
	/**
	 * 描述：删除小组成员
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean deleteByGroupUid(String groupUid) throws Exception {
		Example example=new Example(PubScGroupMember.class);
		example.createCriteria().andEqualTo("groupUid",groupUid);
		pubScGroupMemberMapper.deleteByExample(example);
		return false;
	}
	
	/**
	 * 描述：批量小组成员
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param sysUser
	 * @param pubScGroupMemberList
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean savePubScGroupMemberBatch(SysUserDto sysUser,String groupUid,List<PubScGroupMember> pubScGroupMemberList) throws Exception {
		if(sysUser != null && pubScGroupMemberList != null && pubScGroupMemberList.size() > 0){
			int memberNum = pubScGroupMemberList.size();
			String agentNames = "";
			String expertNames = "";	
			String teamLeader = "";
			for(PubScGroupMember pubScGroupMember : pubScGroupMemberList){
				String agentName = pubScGroupMember.getAgentName();
				if(StringUtils.isEmpty(agentNames)){
					agentNames = agentName;
				}else{
					agentNames += "，"+agentName;
				}
				if("1".equals(pubScGroupMember.getExpertFlag())){
					if(StringUtils.isEmpty(expertNames)){
						expertNames = agentName;
					}else{
						expertNames += "，"+agentName;
					}
				}
				if("1".equals(pubScGroupMember.getLeaderFlag())){
					teamLeader = agentName;
				}
				Example example=new Example(PubScGroupMember.class);
				example.createCriteria().andEqualTo("uid",pubScGroupMember.getUid());
				pubScGroupMemberMapper.updateByExampleSelective(pubScGroupMember, example);
			}
			//处理成员组数据
			PubScGroup pubScGroup = new PubScGroup();
			pubScGroup.setUid(groupUid);
			pubScGroup.setMemberNum(memberNum);
			pubScGroup.setAgentNames(agentNames);
			pubScGroup.setExpertNames(expertNames);
			pubScGroup.setTeamLeader(teamLeader);
			pubScGroup.setGroupType("1");
			pubScGroup.setIsVlid("1");
			pubScGroup.setSetTime(new Date());
			pubScGroupService.updateByUid(pubScGroup);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：删除执法人员单条记录
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	public int doDelGroupmemberInfoByUid(String uid) throws Exception{
		if(StringUtil.isEmpty(uid)) 
			return 0;
		PubScGroupMember groupMember = new PubScGroupMember();
		groupMember.setUid(uid);
		return pubScGroupMemberMapper.delete(groupMember);
	}
	
	/**
	 * 描述：查询检查成员列表
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param groupUid
	 * @throws Exception
	 */
	@Override
	public List<PubScGroupMember> selectByGroupUid(String groupUid)throws Exception {
		Example example = new Example(PubScGroupMember.class);
		example.createCriteria()
		.andEqualTo("groupUid", groupUid)
		.andIsNull("optDataType");
		return pubScGroupMemberMapper.selectByExample(example);
	}
	
	/**
	 * 描述：批量提交检查小组数据
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param groupUid
	 * @param pubScGroupMemberList
	 * @throws Exception
	 */
	public boolean commitPubScGroupMemberBatch(SysUserDto sysUser,String groupUid, 
			List<PubScGroupMember> pubScGroupMemberList) throws Exception{
		if(sysUser != null && pubScGroupMemberList != null && pubScGroupMemberList.size() > 0){
			int memberNum = pubScGroupMemberList.size();
			String agentNames = "";
			String expertNames = "";	
			String teamLeader = "";
			for(PubScGroupMember pubScGroupMember : pubScGroupMemberList){
				String agentName = pubScGroupMember.getAgentName();
				if(StringUtils.isEmpty(agentNames)){
					agentNames = agentName;
				}else{
					agentNames += "，"+agentName;
				}
				if("1".equals(pubScGroupMember.getExpertFlag())){
					if(StringUtils.isEmpty(expertNames)){
						expertNames = agentName;
					}else{
						expertNames += "，"+agentName;
					}
				}
				if("1".equals(pubScGroupMember.getLeaderFlag())){
					teamLeader = agentName;
				}
				Example example=new Example(PubScGroupMember.class);
				example.createCriteria().andEqualTo("uid",pubScGroupMember.getUid());
				pubScGroupMemberMapper.updateByExampleSelective(pubScGroupMember, example);
				//处理有新增标志的数据
				pubScGroupMemberMapper.updateOptDataTypeByUid(pubScGroupMember.getUid());
			}
			//处理有删除标志的数据
			Example delexample = new Example(PubScGroupMember.class);
			delexample.createCriteria()
			.andEqualTo("groupUid", groupUid)
			.andEqualTo("optDataType", "1");
			pubScGroupMemberMapper.deleteByExample(delexample);
			//处理成员组数据
			PubScGroup pubScGroup = new PubScGroup();
			pubScGroup.setUid(groupUid);
			pubScGroup.setMemberNum(memberNum);
			pubScGroup.setAgentNames(agentNames);
			pubScGroup.setExpertNames(expertNames);
			pubScGroup.setTeamLeader(teamLeader);
			pubScGroup.setGroupType("3");
			pubScGroup.setIsVlid("1");
			pubScGroup.setSetTime(new Date());
			pubScGroupService.updateByUid(pubScGroup);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：检查小组维护页面列表查询
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @throws Exception
	 */
	public List<PubScGroupMemberDto> queryGroupMaintainPage(PageRequest request, SysUserDto sysUserDto) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if(params == null){
			params = new HashMap<String, Object>();
		}
		StringUtil.paramTrim(params);
		String userUid = sysUserDto.getId();
		params.put("setUserUid", userUid);
		return pubScGroupMemberMapper.selectPubScGroupMemberDtoList(params);
	}
	
	/**
	 * 描述：逻辑删除临时数据
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public int doDelGroupmemberInfoByLogic(String uid) throws Exception{
		PubScGroupMember record = new PubScGroupMember();
		PubScGroupMember groupMember = this.doGetScgroupMemberByuid(uid);
		if ("2".equals(groupMember.getOptDataType())) {
			// 先新增后删除
			record.setOptDataType("3");
		}else{
			record.setOptDataType("1");
		}
		Example example = new Example(PubScGroupMember.class);
		example.createCriteria().andEqualTo("uid", uid);
		return pubScGroupMemberMapper.updateByExampleSelective(record, example);
	}
	
	/**
	 * 描述：初始化临时操作标志
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param groupUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void initCheckGroupMaintainPage(String groupUid) throws Exception{
		pubScGroupMemberMapper.deleteOptDataTypeByGroupUid(groupUid);
		pubScGroupMemberMapper.updateOptDataTypeByGroupUid(groupUid);
	}
	
	/**
	 * 描述：删除所有
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public boolean doDelGroupmemberAll(SysUserDto sysUserDto) throws Exception{
		if (sysUserDto.getId() != null) {
			PubScGroup group = new PubScGroup();
			group.setSetUserUid(sysUserDto.getId());
			group.setGroupType("2");
			PubScGroup record = pubScGroupMapper.selectOne(group);
			if (record != null) {
				Example mbexample = new Example(PubScGroupMember.class);
				mbexample.createCriteria()
				.andEqualTo("groupUid", record.getUid());
				int del = pubScGroupMemberMapper.deleteByExample(mbexample);
				if (del == 0 || del > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 描述：选择检查小组
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public boolean doChoiceCheckGroupForBackPage(String groupUid,SysUserDto sysUserDto) throws Exception{
		PubScGroup group = new PubScGroup();
		group.setSetUserUid(sysUserDto.getId());
		group.setGroupType("2");
		PubScGroup record = pubScGroupMapper.selectOne(group);
		if (record != null) {
			List<PubScGroupMember> groupMembers = this.selectByGroupUid(groupUid);
			if (groupMembers.size() > 0) {
				for (PubScGroupMember pubScGroupMember : groupMembers) {
					Example example = new Example(PubScGroupMember.class);
					example.createCriteria()
					.andEqualTo("groupUid", record.getUid())
					.andEqualTo("agentUid", pubScGroupMember.getAgentUid());
					List<PubScGroupMember> scGroupMembers = pubScGroupMemberMapper.selectByExample(example);
					if (scGroupMembers.size() > 0) {
						break;
					}
					PubScGroupMember member = new PubScGroupMember();
					member.setAgentDeptName(pubScGroupMember.getAgentDeptName());
					member.setAgentName(pubScGroupMember.getAgentName());
					member.setAgentUid(pubScGroupMember.getAgentUid());
					member.setExpertFlag(pubScGroupMember.getExpertFlag());
					member.setGroupUid(record.getUid());
					member.setLeaderFlag(pubScGroupMember.getLeaderFlag());
					pubScGroupMemberMapper.insert(member);
				}
			}
			return true;
		}
		return false;
	}
}