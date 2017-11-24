/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.service;

import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_party_ent_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月01日
 */
public interface IPartyEntInfoService extends BaseService {
    
	/**
	 * 描述: 通过主体代码获取企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param priPID
	 * @return PartyEntInfo
	 * @throws Exception
	 */
	public PartyEntInfo doGetPartyEntInfoByPriPID(String priPID) throws Exception;
    
	/**
	 * 描述: 更新企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param sysUser,partyEntInfo
	 * @return int
	 * @throws Exception
	 */
	public int doUpdatePartyEntInfoInfo(PartyEntInfo partyEntInfo,SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述: 保存企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param sysUser,partyEntInfo
	 * @return int
	 * @throws Exception
	 */
	public int doSavePartyEntInfo(PartyEntInfo partyEntInfo, SysUserDto sysUser) throws Exception;
    
	/**
	 * 描述: 删除企业党建信息
	 * @auther yujingwei
	 * @date 2017年9月4日
	 * @param priPID
	 * @return int
	 * @throws Exception
	 */
	public int doDelPartyInfoByPriPID(String priPID) throws Exception;
}