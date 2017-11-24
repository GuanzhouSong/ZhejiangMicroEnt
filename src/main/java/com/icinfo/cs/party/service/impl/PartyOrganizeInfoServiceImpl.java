/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.party.dto.PartyOrganizeInfoDto;
import com.icinfo.cs.party.mapper.PartyOrganizeInfoMapper;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyMemberInfoService;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_party_organize_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Service
public class PartyOrganizeInfoServiceImpl extends MyBatisServiceSupport implements IPartyOrganizeInfoService {
	
	@Autowired
	PartyOrganizeInfoMapper partyOrganizeInfoMapper;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	@Autowired
	private IPartyMemberInfoService partyMemberInfoService;
	
	/**
	 * 描述：保存党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo，session
	 * @throws Exception
	 */
	public int doSavePartyOrganizeInfo(PartyOrganizeInfo organizeInfo,SysUserDto sysUser) throws Exception{
		List<PartyOrganizeInfo> organizeInfos = doGetOrgSimilarinfo(organizeInfo.getPartyOrgName(),"1");
		if (organizeInfos != null && organizeInfos.size() > 0){
			return -1;
		}
		organizeInfo.setInputState("2");  
		organizeInfo.setInputDeptCode(sysUser.getDeptCode());
		if(StringUtils.isNotEmpty(organizeInfo.getLocalAdm())){
			organizeInfo.setAreacode(organizeInfo.getLocalAdm().substring(0, 4));
			if (organizeInfo.getLocalAdm().startsWith("3300")) {
				organizeInfo.setRegOrg("330000");
			}else{
				organizeInfo.setRegOrg(organizeInfo.getLocalAdm().substring(0, 6));
			}
			CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(organizeInfo.getLocalAdm().substring(0, 6));
			if(codeRegorg != null){
				organizeInfo.setRegOrgName(codeRegorg.getContent());
			}
		}
		return partyOrganizeInfoMapper.insert(organizeInfo);
	}
	
	/**
	 * 描述：修改党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo，session
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public int doUpdatePartyOrganizeInfo(PartyOrganizeInfo organizeInfo,SysUserDto sysUser) throws Exception{
		if (StringUtils.isNotEmpty(organizeInfo.getUID())){
			if ("1".equals(organizeInfo.getInputState()) 
					&& organizeInfo.getCreateTime() == null){
				organizeInfo.setCreateTime(new Date());
				PartyOrganizeInfo info = this.doGetOrganizeInfoByUid(organizeInfo.getUID());
				organizeInfo.setPartyOrgName(info.getPartyOrgName());
			}else{
				organizeInfo.setModifyTime(new Date());
				organizeInfo.setInputDeptCode(sysUser.getDeptCode());
			}
			//是否已存在
			List<PartyOrganizeInfo> organizeInfos = doGetOrgSimilarinfo(organizeInfo.getPartyOrgName(),"1");
			if (organizeInfos != null && organizeInfos.size() > 0) {
				if (!organizeInfos.get(0).getUID().equals(organizeInfo.getUID())) {
					return -1;
				}
			}
			if ("1".equals(organizeInfo.getInputState())){
				partyMemberInfoService.updatePartyMemberOrgByUid(organizeInfo.getUID(),organizeInfo.getPartyOrgName());
			}
			
			Example example = new Example(PartyOrganizeInfo.class);
			example.createCriteria().andEqualTo("UID", organizeInfo.getUID());
			return partyOrganizeInfoMapper.updateByExampleSelective(organizeInfo, example);
		}else{
			return 0;
		}
	}
	
	/**
	 * 描述：分页查询党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param request
	 * @throws Exception
	 */
	public List<PartyOrganizeInfo> queryPage(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return partyOrganizeInfoMapper.selectPartyOrgInfo(request.getParams());
	}
	
	/**
	 * 描述：删除党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param uID
	 * @throws Exception
	 */
	public int deletePartyOrganizeInfo(String uid) throws Exception{
		Example example = new Example(PartyOrganizeInfo.class);
		example.createCriteria().andEqualTo("UID", uid);
		return partyOrganizeInfoMapper.deleteByExample(example);
	}
	
	/**
	 * 描述：通过uid查询单条党组织信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param uID
	 * @throws Exception
	 */
	public PartyOrganizeInfo doGetOrganizeInfoByUid(String uid) throws Exception{
		PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
		organizeInfo.setUID(uid);
		return partyOrganizeInfoMapper.selectOne(organizeInfo);
	}
	
	/**
	 * 描述：通过主体代码查询企业自建党组织
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param priPID
	 * @throws Exception
	 */
	public PartyOrganizeInfo doGetPartyOrgInfoByPriPID(String priPID) throws Exception{
		PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
		organizeInfo.setCreateSelfEntID(priPID);
		return partyOrganizeInfoMapper.selectOne(organizeInfo);
	}
	
	/**
	 * 描述：通过输入党组织名称匹配相似信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param partyOrgName
	 * @param inputState
	 * @throws Exception
	 */
	public List<PartyOrganizeInfo> doGetOrgSimilarinfo(String partyOrgName,String inputState) throws Exception{
		Map<String, Object> qrMap = new HashMap<String, Object>();
		qrMap.put("keyWords", partyOrgName);
		qrMap.put("inputState", inputState);
		return partyOrganizeInfoMapper.selectPartyOrgInfo(qrMap);
	}
	
	/**
	 * 描述：通过主体代码删除党组织
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param priPID
	 * @throws Exception
	 */
	public int doDelPartyOrgByPriPID(String priPID) throws Exception{
		if (StringUtils.isNotBlank(priPID)){
			PartyOrganizeInfoDto infoDto = new PartyOrganizeInfoDto();
			infoDto.setCreateSelfEntID(priPID);
			return partyOrganizeInfoMapper.delete(infoDto);
		}else
			return -1;
	}
	
	public boolean doGetOrgInfoByNameAndOrgId(String partyOrgName,String partyOrgID, String inputState) throws Exception{
		Map<String, Object> qrMap = new HashMap<String, Object>();
		qrMap.put("exactName", partyOrgName);
		qrMap.put("uid", partyOrgID);
		qrMap.put("inputState", inputState);
		if(CollectionUtils.isEmpty(partyOrganizeInfoMapper.selectPartyOrgInfo(qrMap))){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public List<PartyOrganizeInfoDto> selectPartyOrganizeInfoCount(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), 10000);
		return partyOrganizeInfoMapper.selectPartyOrganizeInfoCount(request.getParams());
	}
}