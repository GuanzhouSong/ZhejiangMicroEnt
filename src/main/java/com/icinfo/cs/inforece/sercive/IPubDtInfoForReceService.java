/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.sercive;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

public interface IPubDtInfoForReceService extends BaseService {
	
	/**
	 * 获取双告知数据
	 * @author zjj
	 * @return
	 * @throws Exception
	 */
	public List<PubDtInfoDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception;
	/**
	 * 查询已下载数据
	 * @author zjj
	 */
	public List<PubDtInfoDto> getDownList(PubDtInfoDto PubDtInfo);
	
	public int getDtInfoTotal(Map<String,Object> qryMap) throws Exception;
	
	
}