/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.party.mapper.PartyEntInfoMapper;
import com.icinfo.cs.party.mapper.PartyOrganizeInfoMapper;
import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyEntInfoService;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_party_ent_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月01日
 */
@Service
public class PartyEntInfoServiceImpl extends MyBatisServiceSupport implements IPartyEntInfoService {
	
	@Autowired
	PartyEntInfoMapper partyEntInfoMapper;
	@Autowired
	PartyOrganizeInfoMapper partyOrganizeInfoMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPartyOrganizeInfoService partyOrganizeInfoService;
	
	/**
	 * 描述: 通过主体代码获取企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param priPID
	 * @return PartyEntInfo
	 * @throws Exception
	 */
	public PartyEntInfo doGetPartyEntInfoByPriPID(String priPID) throws Exception{
		PartyEntInfo partyEntInfo = new PartyEntInfo();
		partyEntInfo.setPriPID(priPID);
		return partyEntInfoMapper.selectOne(partyEntInfo);
	}
	
	/**
	 * 描述: 更新企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param sysUser
	 * @return int
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public int doUpdatePartyEntInfoInfo(PartyEntInfo partyEntInfo,SysUserDto sysUser) throws Exception{
		if (StringUtils.isNotBlank(partyEntInfo.getUID())) {
			Example example = new Example(PartyEntInfo.class);
			example.createCriteria().andEqualTo("UID", partyEntInfo.getUID());
		    if (partyEntInfoMapper.updateByExample(partyEntInfo, example) > 0){
		    	PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
				organizeInfo.setPartyOrgType(partyEntInfo.getBuildOrgType());
				organizeInfo.setPartyOrgBuildWay(partyEntInfo.getBuildOrgWay());
				organizeInfo.setPartyOrgBuildDate(partyEntInfo.getCreateOrgTime());
				organizeInfo.setModifyTime(new Date());
				Example exampleOrg = new Example(PartyOrganizeInfo.class);
				exampleOrg.createCriteria().andEqualTo("createSelfEntID", partyEntInfo.getPriPID());
				if(partyOrganizeInfoMapper.updateByExampleSelective(organizeInfo, exampleOrg) < 0){
					return 0;
				};
		    }
		}
		return 1;
	}
	
	/**
	 * 描述: 保存企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param sysUser,partyEntInfo
	 * @return int
	 * @throws Exception
	 */
	public int doSavePartyEntInfo(PartyEntInfo partyEntInfo, SysUserDto sysUser) throws Exception{
		if (this.doGetPartyEntInfoByPriPID(partyEntInfo.getPriPID()) != null) {
			Example example = new Example(PartyEntInfo.class);
			example.createCriteria().andEqualTo("priPID", partyEntInfo.getPriPID());
		    if (partyEntInfoMapper.updateByExample(partyEntInfo, example) > 0){
		    	PartyOrganizeInfo organizeInfo = new PartyOrganizeInfo();
				organizeInfo.setPartyOrgType(partyEntInfo.getBuildOrgType());
				organizeInfo.setPartyOrgBuildWay(partyEntInfo.getBuildOrgWay());
				organizeInfo.setPartyOrgBuildDate(partyEntInfo.getCreateOrgTime());
				organizeInfo.setModifyTime(new Date());
				Example exampleOrg = new Example(PartyOrganizeInfo.class);
				exampleOrg.createCriteria().andEqualTo("createSelfEntID", partyEntInfo.getPriPID());
				if(partyOrganizeInfoMapper.updateByExampleSelective(organizeInfo, exampleOrg) < 0){
					return 0;
				};
		    }
		}else{
			 return partyEntInfoMapper.insert(partyEntInfo);
		}
		return 1;
	}
	
	/**
	 * 描述: 删除企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param priPID
	 * @return int
	 * @throws Exception
	 */
	public int doDelPartyInfoByPriPID(String priPID) throws Exception{
		if(StringUtils.isNotBlank(priPID)){
			PartyEntInfo record = new PartyEntInfo();
			record.setPriPID(priPID);
			return partyEntInfoMapper.delete(record);
		}else
			return -1;
	}
} 