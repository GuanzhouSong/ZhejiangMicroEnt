/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.sccheck.dto.PubScGroupDto;
import com.icinfo.cs.sccheck.mapper.PubScGroupMapper;
import com.icinfo.cs.sccheck.model.PubScGroup;
import com.icinfo.cs.sccheck.service.IPubScGroupMemberService;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scgroup 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
@Service
public class PubScGroupServiceImpl extends MyBatisServiceSupport implements IPubScGroupService {
	
	@Autowired
	private PubScGroupMapper pubScGroupMapper;
	
	@Autowired
	private IPubScGroupMemberService pubScGroupMemberService;
	
	/**
     * 
     * 描述: 执法人员随机抽取页面-分组列表
     * @auther chenxin
     * @date 2017年7月11日 
     * @param request
     * @return
     * @throws Exception
     */
	@Override
	public List<PubScGroupDto> queryGroupPage(PageRequest request)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScGroupMapper.selectGroupList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 清空当前部门待选库的检查小组
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param userUid
	 * @param groupUids
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean deleteByUserUid(String userUid) throws Exception {
		if(StringUtils.isNotEmpty(userUid)){
			Example example=new Example(PubScGroup.class);
			example.createCriteria().andEqualTo("setUserUid",userUid).andEqualTo("groupType","1");
			List<PubScGroup> pubScGroupList = pubScGroupMapper.selectByExample(example);
			if(pubScGroupList != null && pubScGroupList.size() > 0){
				for(PubScGroup pubScGroup : pubScGroupList){
					String groupUid = pubScGroup.getUid();
					pubScGroupMemberService.deleteByGroupUid(groupUid);
				}
			}
			pubScGroupMapper.deleteByExample(example);
			return true;
		}
		return false;
	}
	
	/**
   	 * 
   	 * 描述: 批量删除待选库的检查小组
   	 * @auther chenxin
   	 * @date 2017年7月11日 
   	 * @param userUid
   	 * @return
   	 * @throws Exception
   	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean deleteByUserUidAndGroupUids(String userUid, String groupUids)throws Exception {
		if(StringUtils.isNotEmpty(userUid) && StringUtils.isNotEmpty(groupUids)){
			String[] groupUidArr = groupUids.split(",");
			for(String groupUid : groupUidArr){
				Example example=new Example(PubScGroup.class);
				example.createCriteria().andEqualTo("uid",groupUid);
				pubScGroupMapper.deleteByExample(example);
				pubScGroupMemberService.deleteByGroupUid(groupUid);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 添加检查小组
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param pubScGroup
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean savePubScGroup(PubScGroup pubScGroup) throws Exception {
		if(pubScGroup != null && pubScGroupMapper.insertSelective(pubScGroup) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述: 查询信息并且清除成员信息
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param userUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubScGroup selectUnVlidAndCleanMember(String userUid)throws Exception {
		PubScGroup pubScGroup = new PubScGroup();
		pubScGroup.setSetUserUid(userUid);
		pubScGroup.setGroupType("1");//随机抽取过程分组
		pubScGroup.setIsVlid("0");//还没有被使用的临时分组
		return pubScGroupMapper.selectOne(pubScGroup);
	}
	
	/**
	 * 描述: 更新小组成员
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param pubScGroup
	 * @throws Exception
	 */
	@Override
	public boolean updateByUid(PubScGroup pubScGroup) throws Exception {
		if(pubScGroup != null && StringUtils.isNotEmpty(pubScGroup.getUid())){
			Example example=new Example(PubScGroup.class);
			example.createCriteria().andEqualTo("uid",pubScGroup.getUid());
			pubScGroupMapper.updateByExampleSelective(pubScGroup, example);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述: 查询数量
	 * @auther chenxin
	 * @date 2017年7月12日 
	 * @param params
	 * @throws Exception
	 */
	@Override
	public int selectGroupCount(Map<String, Object> params) throws Exception {
		return pubScGroupMapper.selectGroupCount(params);
	}
	
	/**
	 * 描述: 查询检查小组
	 * @auther chenxin
	 * @date 2017年7月12日 
	 * @param params
	 * @throws Exception
	 */
	@Override
	public List<PubScGroupDto> selectListBySysUser(SysUserDto sysUser)throws Exception {
		Map<String,Object>	queryMap= new HashMap<String,Object>();
		queryMap.put("setUserUid", sysUser.getId());
		queryMap.put("groupType", "1");
		queryMap.put("isVlid", "1");
		return pubScGroupMapper.selectGroupList(queryMap);
	}
}