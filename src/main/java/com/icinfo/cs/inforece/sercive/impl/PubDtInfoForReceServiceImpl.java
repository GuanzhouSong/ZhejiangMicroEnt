/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.sercive.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import com.icinfo.cs.dtinfo.dto.PubDtInfoDto;
import com.icinfo.cs.inforece.mapper.PubDtInfoForReceMapper;
import com.icinfo.cs.inforece.sercive.IPubDtInfoForReceService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

@Service
public class PubDtInfoForReceServiceImpl extends MyBatisServiceSupport implements IPubDtInfoForReceService {


	@Autowired
	private PubDtInfoForReceMapper pubDtInfoMapper; 
	
	/**
	 * 获取双告知数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubDtInfoDto> queryPage(PageRequest request,SysUserDto sysUser) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubDtInfoMapper.selectPubDtinfoListSearch(request.getParams());
	}

	/**
	 * 获取下载数据
	 * @author zjj
	 */
	@Override
	public List<PubDtInfoDto> getDownList(PubDtInfoDto PubDtInfo) {
		return pubDtInfoMapper.selectDownList(PubDtInfo);
	}
	
	/**
	 * 获取部门数据条数
	 * 
	 * @author zjj
	 */
	@Override
	public int getDtInfoTotal(Map<String,Object> qryMap) throws Exception{
		List<PubDtInfoDto> list = pubDtInfoMapper.selectPubDtinfoListSearch(qryMap);
		if(list == null){
			return 0;
		}
		return list.size();
	}
	
}