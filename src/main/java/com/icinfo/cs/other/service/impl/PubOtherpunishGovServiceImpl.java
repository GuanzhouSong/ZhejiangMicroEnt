/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.dto.PubOtherpunishGovDto;
import com.icinfo.cs.other.mapper.PubOtherpunishGovMapper;
import com.icinfo.cs.other.model.PubOtherpunishGov;
import com.icinfo.cs.other.service.IPubOtherpunishGovService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_otherpunish_gov 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Service
public class PubOtherpunishGovServiceImpl extends MyBatisServiceSupport implements IPubOtherpunishGovService {
	
	@Autowired
	private PubOtherpunishGovMapper pubOtherpunishGovMapper;

	/** 
	 * 描述: 行政处罚归集查询
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubOtherpunishGovDto> selectPubOtherpunishGovList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return pubOtherpunishGovMapper.selectPubOtherpunishGovList(paramsMap);
	}

	/** 
	 * 描述: 在册企业行政处罚数
	 * @auther ZhouYan
	 * @date 2017年11月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Integer selectPubOtherpunishGovRegTotal(Map<String, Object> paramsMap)
			throws Exception {
		return pubOtherpunishGovMapper.selectPubOtherpunishGovRegTotal(paramsMap);
	}

	/**
	 * 
	 * 描述   根据设置部门查询
	 * @author  赵祥江
	 * @date 2017年11月21日 下午3:04:23 
	 * @param  
	 * @throws
	 */ 
	@Override
	public List<PubOtherpunishGov> selectPubOtherpunishGovByDeptnameList(
			String setDeptname) throws Exception {
		 Map<String,Object> qMap=new HashMap<String,Object>();
		 qMap.put("setDeptname", setDeptname);
		return pubOtherpunishGovMapper.selectPubOtherpunishGovByDeptnameList(qMap);
	}

	/**
	 * 
	 * 描述   根据主键id更新
	 * @author  赵祥江
	 * @date 2017年11月21日 下午3:08:46 
	 * @param  
	 * @throws
	 */
	@Override
	public int updatePubOtherpunishGov(PubOtherpunishGov pubOtherpunishGov)
			throws Exception {
		if(pubOtherpunishGov!=null&&pubOtherpunishGov.getId()!=null){
			return pubOtherpunishGovMapper.updateByPrimaryKeySelective(pubOtherpunishGov);
		}
		return 0;
	}

	@Override
	public int selectDeptTotal(Map<String, Object> paramsMap) {
		return pubOtherpunishGovMapper.selectDeptTotal(paramsMap);
	}

	@Override
	public int selectEntDeptTotal(Map<String, Object> paramsMap) {
		return pubOtherpunishGovMapper.selectEntDeptTotal(paramsMap);
	} 
	
	@Override
	public PubOtherpunishGovDto selectPunishGovCount(Map<String, Object> paramsMap) throws Exception{
		PubOtherpunishGovDto dto = new PubOtherpunishGovDto();
		Integer anthTotal = pubOtherpunishGovMapper.selectPunishGovAnthTotal(paramsMap);
		Integer regTotal = pubOtherpunishGovMapper.selectPunishGovRegTotal(paramsMap);
		Integer regAnthTotal = pubOtherpunishGovMapper.selectPunishGovRegAnthTotal(paramsMap);
		dto.setAnthTotal(String.valueOf(anthTotal));
		dto.setRegTotal(String.valueOf(regTotal));
		dto.setRegAnthTotal(String.valueOf(regAnthTotal));
		return dto;
	}
}