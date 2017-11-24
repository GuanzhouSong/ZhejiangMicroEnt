/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ai12315.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.ai12315.dto.Ai12315RegInfoDto;
import com.icinfo.cs.ai12315.mapper.Ai12315RegInfoMapper;
import com.icinfo.cs.ai12315.service.IAi12315RegInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_ai_12315_reg_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月06日
 */
@Service
public class Ai12315RegInfoServiceImpl extends MyBatisServiceSupport implements IAi12315RegInfoService {

	@Autowired
	private Ai12315RegInfoMapper ai12315RegInfoMapper;
	/**
	 * 
	 * 描述    根据企业主体代码查询登记信息
	 * @author  赵祥江
	 * @date 2017年11月7日 下午3:37:03 
	 * @param  
	 * @throws
	 */
	@Override
	public List<Ai12315RegInfoDto> selectAi12315RegInfoDtoListByPriPID(
			String priPID) throws Exception {
		Map<String,Object> qMap=new HashMap<String,Object>();
		qMap.put("priPID", priPID);
		return ai12315RegInfoMapper.selectAi12315RegInfoDtoListByPriPID(qMap);
	}
	
	/**
	 * 
	 * 描述   根据企业主体代码查询登记信息(分页)
	 * @author  赵祥江
	 * @date 2017年11月7日 下午4:07:57 
	 * @param  
	 * @throws
	 */
	@Override
	public List<Ai12315RegInfoDto> selectAi12315RegInfoDtoList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> queryMap= request.getParams();
		return ai12315RegInfoMapper.selectAi12315RegInfoDtoListByPriPID(queryMap);
	}
}