/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service;

import java.util.List;

import com.icinfo.cs.party.dto.PartyOrganizeInfoDto;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_party_organize_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
public interface IPartyOrganizeInfoService extends BaseService {

	/**
	 * 描述：修改党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param organizeInfo，session
	 * @throws Exception
	 */
	public int doUpdatePartyOrganizeInfo(PartyOrganizeInfo organizeInfo, SysUserDto sysUser) throws Exception;

	/**
	 * 描述：保存党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param organizeInfo，session
	 * @throws Exception
	 */
	public int doSavePartyOrganizeInfo(PartyOrganizeInfo organizeInfo, SysUserDto sysUser) throws Exception;

	/**
	 * 描述：分页查询党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param request
	 * @throws Exception
	 */
	public List<PartyOrganizeInfo> queryPage(PageRequest request) throws Exception;

	/**
	 * 描述：删除党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param uID
	 * @throws Exception
	 */
	public int deletePartyOrganizeInfo(String uID) throws Exception;

	/**
	 * 描述：通过uid查询单条党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param uID
	 * @throws Exception
	 */
	public PartyOrganizeInfo doGetOrganizeInfoByUid(String uid) throws Exception;

	/**
	 * 描述：通过输入党组织名称匹配相似信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param partyOrgName
	 * @param inputState
	 * @throws Exception
	 */
	public List<PartyOrganizeInfo> doGetOrgSimilarinfo(String partyOrgName, String inputState) throws Exception;

	/**
	 * 描述：党建信息统计报表
	 * 
	 * @author baifangfang
	 * @date 2017年9月5日
	 * @param request
	 * @return
	 */
	public List<PartyOrganizeInfoDto> selectPartyOrganizeInfoCount(PageRequest request);
    
	/**
	 * 描述：通过主体代码查询企业自建党组织
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param priPID
	 * @throws Exception
	 */
	public PartyOrganizeInfo doGetPartyOrgInfoByPriPID(String priPID) throws Exception;
    
	/**
	 * 描述：通过主体代码删除党组织
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param priPID
	 * @throws Exception
	 */
	public int doDelPartyOrgByPriPID(String priPID) throws Exception;
    
	/**
	 * 描述：通过组织名称，组织id查询
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param partyOrgID，
	 * @param partyOrgName
	 * @throws Exception
	 */
	public boolean doGetOrgInfoByNameAndOrgId(String partyOrgName,String partyOrgID, String inputState) throws Exception;
}