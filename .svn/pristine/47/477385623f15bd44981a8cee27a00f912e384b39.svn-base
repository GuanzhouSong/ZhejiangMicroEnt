/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.simpleesc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.es.service.IEntSearchService;
import com.icinfo.cs.simpleesc.dto.ErEscScrinfoDto;
import com.icinfo.cs.simpleesc.mapper.ErEscScrinfoMapper;
import com.icinfo.cs.simpleesc.model.ErEscScrinfo;
import com.icinfo.cs.simpleesc.service.IErEscScrinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: er_esc_scrinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Service
public class ErEscScrinfoServiceImpl extends MyBatisServiceSupport implements IErEscScrinfoService {

	@Autowired
	ErEscScrinfoMapper erEscScrinfoMapper;
	
	@Autowired
	IEntSearchService entSearchService;

	@Override
	public List<ErEscScrinfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return erEscScrinfoMapper.queryPageResultByPriPID(request.getParams());
	}

	@Override
	public void simpleEscUpdate() {
		List<ErEscScrinfo> erEscScrinfoList = erEscScrinfoMapper.selectAll();
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		for (ErEscScrinfo erEscScrinfo : erEscScrinfoList) {
			String simplecanRea = erEscScrinfo.getSimplecanRea();
			String priPID = erEscScrinfo.getPriPID();
			if("4".equals(simplecanRea)){//正在进行简易注销
				jsonMap.put("priPID", priPID);
				jsonMap.put("isSimpleCancle", "1");
			}else{
				jsonMap.put("priPID", priPID);
				jsonMap.put("isSimpleCancle", "0");
			}
			entSearchService.updatePubIndex(jsonMap);
		}
	}

	/**
	 * 
	 * 描述   分页查询简易注销结果
	 * @author  赵祥江
	 * @date 2017年2月21日 下午3:35:04 
	 * @param  
	 * @throws
	 */
	@Override
	public List<ErEscScrinfoDto> queryErEscScrinfoPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		return erEscScrinfoMapper.selectErEscScrinfoPageResult(paramsMap);
	}

	@Override
	public ErEscScrinfoDto getErEscScByPriPID(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put(Constants.CS_PRIPID, priPID);
		return erEscScrinfoMapper.queryResultByPriPID(queryMap);
	}
}