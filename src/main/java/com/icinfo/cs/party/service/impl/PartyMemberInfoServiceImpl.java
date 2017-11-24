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
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.party.dto.PartyMemberInfoDto;
import com.icinfo.cs.party.mapper.PartyMemberInfoMapper;
import com.icinfo.cs.party.mapper.PartyOrganizeInfoMapper;
import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.party.model.PartyMemberInfo;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyEntInfoService;
import com.icinfo.cs.party.service.IPartyMemberInfoService;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_party_member_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Service
public class PartyMemberInfoServiceImpl extends MyBatisServiceSupport implements IPartyMemberInfoService {
	
	@Autowired
	PartyMemberInfoMapper partyMemberInfoMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPartyEntInfoService partyEntInfoService;
	@Autowired
	private PartyOrganizeInfoMapper partyOrganizeInfoMapper;
	@Autowired
	private IPartyOrganizeInfoService partyOrganizeInfoService;
	@Autowired
	private ICodeRegorgService codeRegorgService;
	
    private final static String PB_ENT_TYPE = "9500";
	
	private final static String NO_PUBLIC_ENT_TYPE = "1122,1130,1151,1152,1212,1222,2122,2130,2151,2152,2212,2222,4500,4510,4550,4530,4570,4560,4580";
	
	/**
	 * 描述：保存非公党建党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo
	 * @param  session
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public int doSavePartyMemberInfoInfo(PartyMemberInfo memberInfo, SysUserDto sysUser, PartyEntInfo entInfo) throws Exception{
		// 判断是否有唯一业主，唯一身份证号
		Map<String, Object> qrMap = new HashMap<String, Object>(); 
		qrMap.put("quryAll", "1");
		qrMap.put("judgeIsExist", "1");
		if ("1".equals(memberInfo.getMemberType())) {
			qrMap.put("memberType", memberInfo.getMemberType());
			qrMap.put("priPID", memberInfo.getPriPID());
		}
		qrMap.put("identityInfo", memberInfo.getIdentityInfo());
		List<PartyMemberInfoDto> infoDtos = partyMemberInfoMapper.selectPartyMemberInfoForMaintain(qrMap);
		if (CollectionUtils.isNotEmpty(infoDtos)) {
			if (memberInfo.getIdentityInfo().equals(infoDtos.get(0).getIdentityInfo())){
				return 0;
			}else
				return -1;
		}
		boolean isExistOrgNameSelfCreate = doOptPartyMemberRelationToOrganize(memberInfo, entInfo, sysUser);
		if (!isExistOrgNameSelfCreate){
			return -2;
		}
		MidBaseInfo midBaseInfo = midBaseInfoService.selectInfoByPriPID(memberInfo.getPriPID());
		memberInfo.setEntName(midBaseInfo.getEntName());
		memberInfo.setRegNO(midBaseInfo.getRegNO());
		memberInfo.setUniCode(midBaseInfo.getUniCode());
		memberInfo.setLeRep(midBaseInfo.getLeRep());
		memberInfo.setEntType("9500".equals(midBaseInfo.getEntType())?"2":"1");
		memberInfo.setModifyTime(new Date());
		if ("1".equals(memberInfo.getInputType())) {
			memberInfo.setAuditState("1");
			memberInfo.setAuditName(sysUser.getRealName());
			memberInfo.setAuditDept(sysUser.getDeptCode());
			memberInfo.setAuditTime(new Date());
		}else if ("2".equals(memberInfo.getInputType())) {
			memberInfo.setAuditState("3");
		}
		return partyMemberInfoMapper.insert(memberInfo);
	}
	
	/**
	 * 描述：修改非公党建党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo
	 * @param  session
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public int doUpdatePartyMemberInfoInfo(PartyMemberInfo memberInfo, SysUserDto sysUser, PartyEntInfo entInfo) throws Exception{
		if (StringUtils.isNotEmpty(memberInfo.getMemberType()) && StringUtils.isNotEmpty(memberInfo.getIdentityInfo())){
			// 判断是否有唯一业主，唯一身份证号
			Map<String, Object> qrMap = new HashMap<String, Object>(); 
			qrMap.put("quryAll", "1");
			qrMap.put("judgeIsExist", "1");
			if ("1".equals(memberInfo.getMemberType())) {
				qrMap.put("memberType", memberInfo.getMemberType());
				qrMap.put("priPID", memberInfo.getPriPID());
			}
			qrMap.put("identityInfo", memberInfo.getIdentityInfo());
			List<PartyMemberInfoDto> infoDtos = partyMemberInfoMapper.selectPartyMemberInfoForMaintain(qrMap);
			if (CollectionUtils.isNotEmpty(infoDtos)) {
				for(PartyMemberInfoDto infoDto :infoDtos){
					if(!memberInfo.getUID().equals(infoDto.getUID())){
						if (memberInfo.getIdentityInfo().equals(infoDto.getIdentityInfo())){
							return 0;
						}else
							return -1;
					}
				}
			}
			boolean isExistOrgNameSelfCreate = doOptPartyMemberRelationToOrganize(memberInfo, entInfo, sysUser);
			if (!isExistOrgNameSelfCreate){
				return -2;
			}
		}
		if(StringUtils.isNotBlank(memberInfo.getUID())){
			Example example = new Example(PartyMemberInfo.class);
			example.createCriteria().andEqualTo("UID", memberInfo.getUID());
			memberInfo.setModifyTime(new Date());
			return partyMemberInfoMapper.updateByExampleSelective(memberInfo, example);
		}else{
			return 0;
		}
	}
	
	/**
	 * 描述: 操作党员，党组织关系
	 * @param memberInfo,entInfo
	 * @throws Exception
	 */
	private boolean doOptPartyMemberRelationToOrganize(PartyMemberInfo memberInfo, PartyEntInfo entInfo, SysUserDto sysUser) throws Exception{
		if (partyEntInfoService.doDelPartyInfoByPriPID(memberInfo.getPriPID()) != -1){
			 entInfo.setEntName(memberInfo.getEntName());
			 if (partyEntInfoService.doSavePartyEntInfo(entInfo, sysUser) > 0){
				  if ("1".equals(entInfo.getIsBuildPartyOrg()) && StringUtils.isEmpty(memberInfo.getPartyOrgID())) {
					    if (partyOrganizeInfoService.doGetOrgInfoByNameAndOrgId(memberInfo.getPartyOrgName(),null, "1")){
					    	return false;
					    }
					    if (partyOrganizeInfoService.doGetPartyOrgInfoByPriPID(memberInfo.getPriPID()) == null){
					    	PartyOrganizeInfo organizeInfo = doGetInsertOrganizeInfo(entInfo, sysUser);
							organizeInfo.setPartyOrgName(memberInfo.getPartyOrgName());
							partyOrganizeInfoMapper.insert(organizeInfo);
					    }else{
					    	doUpdatePartyOrgInfo(memberInfo,entInfo,true);
					    }
					    // 党组织ID存到党员表中
					    PartyOrganizeInfo orgInfo = partyOrganizeInfoService.doGetPartyOrgInfoByPriPID(memberInfo.getPriPID());
						memberInfo.setPartyOrgID(orgInfo.getUID());	
				   }else{
					   if (!partyOrganizeInfoService.doGetOrgInfoByNameAndOrgId(memberInfo.getPartyOrgName(),memberInfo.getPartyOrgID(),"1")){
						   if (partyOrganizeInfoService.doGetOrgInfoByNameAndOrgId(memberInfo.getPartyOrgName(), null, "1")){
						    	return false;
						    }else{
						    	doUpdatePartyOrgInfo(memberInfo,entInfo,true);
						    }
					   }else{
							doUpdatePartyOrgInfo(memberInfo,entInfo,false);
					   }
				   }
			  }
		}
		return true;
	}
	
	/**
	 * 描述: 获取需要插入的党组织信息
	 * @param sysUser,partyEntInfo
	 * @throws Exception
	 */
	private PartyOrganizeInfo doGetInsertOrganizeInfo(PartyEntInfo partyEntInfo , SysUserDto sysUser) throws Exception{
		PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
		organizeInfo.setCreateSelfEntID(partyEntInfo.getPriPID());
		organizeInfo.setPartyOrgType(partyEntInfo.getBuildOrgType());
		organizeInfo.setPartyOrgBuildWay(partyEntInfo.getBuildOrgWay());
		organizeInfo.setPartyOrgBuildDate(partyEntInfo.getCreateOrgTime());
		MidBaseInfo midBaseInfo = midBaseInfoService.selectInfoByPriPID(partyEntInfo.getPriPID());
		if (midBaseInfo != null) {
			String localAdm = midBaseInfo.getLocalAdm();
			organizeInfo.setLocalAdm(localAdm);
			organizeInfo.setLocalAdmName(midBaseInfo.getLocalAdmName());
			organizeInfo.setAreacode(localAdm.substring(0, 4));
			if (localAdm.startsWith("3300")) {
				organizeInfo.setRegOrg("330000");
			}else{
				organizeInfo.setRegOrg(localAdm.substring(0, 6));
			}
			CodeRegorg codeRegorg = codeRegorgService.selectRegOrgByCode(localAdm.substring(0, 6));
			if(codeRegorg != null){
				organizeInfo.setRegOrgName(codeRegorg.getContent());
			}
		}
		organizeInfo.setInputState("1");
		organizeInfo.setInputName(sysUser.getRealName());
		organizeInfo.setInputDeptCode(sysUser.getDeptCode());
		organizeInfo.setInputDate(new Date());
		organizeInfo.setCreateTime(new Date());
		return organizeInfo;
	}
	
	/**
	 * 描述: 更新党组织信息
	 * @param memberInfo,entInfo
	 * @throws Exception
	 */
	private void doUpdatePartyOrgInfo(PartyMemberInfo memberInfo, PartyEntInfo entInfo, Boolean isUpDateOrgName) throws Exception{
		PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
		if(isUpDateOrgName){
			organizeInfo.setPartyOrgName(memberInfo.getPartyOrgName());
		}
		organizeInfo.setPartyOrgType(entInfo.getBuildOrgType());
		organizeInfo.setPartyOrgBuildWay(entInfo.getBuildOrgWay());
		organizeInfo.setPartyOrgBuildDate(entInfo.getCreateOrgTime());
		organizeInfo.setModifyTime(new Date());
		Example exampleOrg = new Example(PartyOrganizeInfo.class);
		exampleOrg.createCriteria().andEqualTo("createSelfEntID", entInfo.getPriPID());
		partyOrganizeInfoMapper.updateByExampleSelective(organizeInfo, exampleOrg);
	}
	
	/**
	 * 描述：提交所有企业新增数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param request
	 * @return boolean
	 * @throws Exception
	 */
	public boolean doCommitPartyMemberInfo(String priPID) throws Exception{
		PartyMemberInfo memberInfo = new PartyMemberInfo(); 
		memberInfo.setAuditState("0");
		Example example = new Example(PartyMemberInfo.class);
		example.createCriteria()
		.andEqualTo("priPID", priPID)
		.andEqualTo("auditState", "3");
		if (!(partyMemberInfoMapper.updateByExampleSelective(memberInfo, example) < 0)){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：获取近三年党建年报数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> doGetParty3YearInfo(PageRequest request) throws Exception{
		Map<String, Object> searchMap = request.getParams();
		searchMap.put("numStart", 0);
		searchMap.put("pageSize", 3);
		return partyMemberInfoMapper.selectParty3YearInfo(request.getParams());
	}
	
	/**
	 * 描述：获取最新一年党建年报数据
	 * @author yujingwei
	 * @date 2017年9月9日 
	 * @param priPID，entType
	 * @return List<PartyMemberInfoDto>
	 */
	public List<PartyMemberInfoDto> doGetPartyLastYearInfo(String priPID,String entType) throws Exception{
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("priPID", priPID);
		searchMap.put("entType", entType);
		searchMap.put("numStart", 0);
		searchMap.put("pageSize", 1);
		return partyMemberInfoMapper.selectParty3YearInfo(searchMap);
	}
	
	/**
	 * 描述：查询党员新增列表
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param request
	 * @return List<PartyMemberInfo>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> queryPartyMemberAddInfo(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return partyMemberInfoMapper.selectPartyMemberInfo(doOptRequstQryMapData(request.getParams()));
	}
	
	/**
	 * 描述：查询党员维护列表
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param request
	 * @return List<PartyMemberInfo>
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> queryPartyMemberMaintainInfo(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return partyMemberInfoMapper.selectPartyMemberInfoForMaintain(doOptRequstQryMapData(request.getParams()));
	}
	
	/**
	 * 描述：党建信息查询统计
	 * @author yujingwei
	 * @date 2017年9月29日 
	 * @param request
	 * @return List<PartyMemberInfoDto>
	 * @throws Exception
	 */
	public PartyMemberInfoDto doGetPartyMemberSearchTotal(Map<String, Object> dataParmMap) throws Exception{
		return partyMemberInfoMapper.selectPartyMemberSearchTotal(doOptRequstQryMapData(dataParmMap));
	}
	
	/**
	 * 描述: 参数处理
	 * @date 2017年8月18日 
	 * @throws
	 */
	private Map<String, Object> doOptRequstQryMapData(Map<String, Object> searchMap) throws Exception{
		if(searchMap.get("regState") != null && !searchMap.get("regState").equals("")){
			searchMap.put("regStates", searchMap.get("regState").toString().split(","));
		}
		if (searchMap.get("regOrg") != null && !searchMap.get("regOrg").equals("")) {
			searchMap.put ("regOrg",
					StringUtil.doSplitStringToSqlFormat (searchMap.get ("regOrg").toString (), ","));
        }
        if (searchMap.get("localAdm") != null && !searchMap.get("localAdm").equals("")) {
        	searchMap.put ("localAdm",
        			StringUtil.doSplitStringToSqlFormat (searchMap.get ("localAdm").toString (), ","));
        }
        if (searchMap.get("entCatg") != null && !searchMap.get("entCatg").equals("")) {
        	if("1".equals(searchMap.get("entCatg"))){
        		searchMap.put ("entCatg",PB_ENT_TYPE);
        	}else if("2".equals(searchMap.get("entCatg"))){
        		searchMap.put ("entCatg",StringUtil.doSplitStringToSqlFormat (NO_PUBLIC_ENT_TYPE, ","));
        	}else{
        		searchMap.put ("entCatg",StringUtil.doSplitStringToSqlFormat (NO_PUBLIC_ENT_TYPE + "," +PB_ENT_TYPE, ","));
        	}
        }
        return searchMap;
	}
	
	/**
	 * 描述: 删除党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param deleteUid
	 * @return int
	 * @throws Exception
	 */
	public int deletePartyMemberInfo(String deleteUid) throws Exception{
		if(StringUtils.isBlank(deleteUid)) return -1;
		PartyMemberInfo deleteInfo = new PartyMemberInfo();
		deleteInfo.setUID(deleteUid);
		return partyMemberInfoMapper.delete(deleteInfo);
	}
	
	/**
	 * 描述：通过uid查询党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param uid
	 * @throws Exception
	 */
	public PartyMemberInfo selectPartyMemberInfoByUid(String uid) throws Exception{
		PartyMemberInfo info = new PartyMemberInfo();
		info.setUID(uid);
		return partyMemberInfoMapper.selectOne(info);
	}
	
	/**
	 * 描述：通过uid更新党员党组织名称
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param uid
	 * @param session
	 * @throws Exception
	 */
	public int updatePartyMemberOrgByUid(String uid, String orgName) throws Exception{
		if(StringUtil.isNotBlank(uid) && StringUtil.isNotBlank(orgName)){
			PartyMemberInfo memberInfo = new PartyMemberInfo();
			memberInfo.setPartyOrgName(orgName);
			Example example = new Example(PartyMemberInfo.class);
			example.createCriteria()
			.andEqualTo("partyOrgID", uid);
			return partyMemberInfoMapper.updateByExampleSelective(memberInfo, example);
		}
		return 0;
	}
	

	@Override
	public List<PartyMemberInfoDto> selectPartyMemberInfoCount(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), 10000);
		return partyMemberInfoMapper.selectMemberInfoCount(request.getParams());
	}
	
	
	/**
	 * 
	 * 描述: 根据党组织id查询组织人员
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PartyMemberInfoDto> selectMembersByPartyOrgID(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return partyMemberInfoMapper.selectMembersByPartyOrgID(request.getParams());
	}
	
	
	/***
	 * 
	 * 描述: 党员树
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> selectMemberTreeMap(Map<String, Object> map) throws Exception{
		return partyMemberInfoMapper.selectMemberTreeMap(map);
	}
	
	
	
}