/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.inforece.sercive.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.inforece.mapper.SecNoCreditMapper;
import com.icinfo.cs.inforece.sercive.ISecNoCreditService;
import com.icinfo.cs.secnocreditsup.dto.SecNoCreditSearchDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

@Service
public class SecNoCreditServiceImpl extends MyBatisServiceSupport implements ISecNoCreditService {


	@Autowired
	private SecNoCreditMapper secNoCreditMapper; 
	
	/**
	 * 获取严违失信名单数据
	 * @author zjj
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SecNoCreditSearchDto> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return secNoCreditMapper.selectSecNoCreditListSearch(request.getParams());
	}

	/**
	 * 获取下载数据
	 * @author zjj
	 */
	@Override
	public List<SecNoCreditSearchDto> getDownList(SecNoCreditSearchDto secNoCreditSearchDto) {
		return secNoCreditMapper.selectDownList(secNoCreditSearchDto);
	}
	
	/**
	 * 查询已下载数据总数
	 * 
	 * @author zy
	 */
	public int getQueryTotal(Map<String,Object> qryMap) throws Exception{
		List<SecNoCreditSearchDto> list = secNoCreditMapper.selectSecNoCreditListSearch(qryMap);
		if(list == null){
			return 0;
		}
		return list.size();
	}
	
}