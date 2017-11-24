/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.party.dto.PartyMemberInfoDto;
import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.party.model.PartyMemberInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_party_member_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
public interface IPartyMemberInfoService extends BaseService {

	/**
	 * 描述：修改非公党建党员信息
	 * 
	 * @author yujingwei
	 * @param entInfo 
	 * @date 2017年8月18日
	 * @param organizeInfo
	 * @param session
	 * @throws Exception
	 */
	public int doUpdatePartyMemberInfoInfo(PartyMemberInfo memberInfo, SysUserDto sysUser, PartyEntInfo entInfo) throws Exception;

	/**
	 * 描述：保存非公党建党员信息
	 * 
	 * @author yujingwei
	 * @param entInfo 
	 * @date 2017年8月18日
	 * @param organizeInfo
	 * @param session
	 * @throws Exception
	 */
	public int doSavePartyMemberInfoInfo(PartyMemberInfo memberInfo, SysUserDto sysUser, PartyEntInfo entInfo) throws Exception;

	/**
	 * 描述：党员信息统计报表
	 * 
	 * @author baifangfang
	 * @date 2017年9月5日
	 * @param request
	 * @return
	 */
	public List<PartyMemberInfoDto> selectPartyMemberInfoCount(PageRequest request);
    
	/**
	 * 描述：查询党员新增列表
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param request
	 * @return List<PartyMemberInfo>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> queryPartyMemberAddInfo(PageRequest request) throws Exception;
    
	/**
	 * 描述: 删除党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param uID
	 * @return int
	 * @throws Exception
	 */
	public int deletePartyMemberInfo(String uID) throws Exception;
    
	/**
	 * 描述：查询党员维护列表
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param request
	 * @return List<PartyMemberInfo>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> queryPartyMemberMaintainInfo(PageRequest request) throws Exception;
    
	/**
	 * 描述：通过uid查询党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param uid
	 * @return PartyMemberInfo
	 * @throws Exception
	 */
	public PartyMemberInfo selectPartyMemberInfoByUid(String uid) throws Exception;
    
	/**
	 * 描述：获取近三年党建年报数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> doGetParty3YearInfo(PageRequest request) throws Exception;
    
	/**
	 * 描述：获取最新一年党建年报数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> doGetPartyLastYearInfo(String priPID,String entType) throws Exception;
    
	/**
	 * 描述：提交所有企业新增数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public boolean doCommitPartyMemberInfo(String priPID) throws Exception;
	
	
	/**
	 * 
	 * 描述: 根据党组织id查询组织人员
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> selectMembersByPartyOrgID(PageRequest request) throws Exception;
	
	/***
	 * 
	 * 描述: 党员树
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectMemberTreeMap(Map<String, Object> map) throws Exception;
    
	/**
	 * 描述：通过uid更新党员党组织名称
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param uid
	 * @param orgName 
	 * @param session
	 * @throws Exception
	 */
	public int updatePartyMemberOrgByUid(String uid, String orgName) throws Exception;
    
	
	/**
	 * 描述：党建信息查询统计
	 * @author yujingwei
	 * @date 2017年9月29日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public PartyMemberInfoDto doGetPartyMemberSearchTotal(Map<String, Object> dataParmMap) throws Exception;
}