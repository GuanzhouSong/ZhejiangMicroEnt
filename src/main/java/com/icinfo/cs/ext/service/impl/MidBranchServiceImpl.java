/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.ext.dto.MidBranchDto;
import com.icinfo.cs.ext.mapper.MidBranchMapper;
import com.icinfo.cs.ext.service.IMidBranchService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_branch 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class MidBranchServiceImpl extends MyBatisServiceSupport implements IMidBranchService {

	@Autowired
	MidBranchMapper midBranchMapper;
	
	@Override
	public List<MidBranchDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midBranchMapper.queryPageResultByPripid(request.getParams());
	}

	@Override
	public List<MidBranchDto> queryListResult(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		return midBranchMapper.queryListResultByPripid(queryMap);
	}
	
	/**
	 * 描述：查询分支机构信息list数据列表（全景）
	 * @author yujingwei
	 * @date 2017年3月17日
	 * @param request
	 * @return List<MidBranchDto>
	 */
	public List<MidBranchDto> queryListResult(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midBranchMapper.queryListResult(request.getParams());
	}

}