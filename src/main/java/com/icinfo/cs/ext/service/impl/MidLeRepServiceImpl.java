/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.dto.MidLeRepDto;
import com.icinfo.cs.ext.mapper.MidLeRepMapper;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_lerep 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
@Service
public class MidLeRepServiceImpl extends MyBatisServiceSupport implements IMidLeRepService {
	
	@Autowired
	private MidLeRepMapper midLeRepMapper;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;

	/**
	 * 
	 * 描述: 根据内部序号查询midLerep(法定代表人)
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param priPid
	 * @return
	 */
	@Override
	public List<MidLeRep> selectMidLeRepListByPriPID(String key,String priPID) {
		Example example = new Example(MidLeRep.class);
		example.createCriteria().andEqualTo(key,priPID);
		return midLeRepMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * 描述: 根据身份证件号码查询midLerep(法定代表人)
	 * @auther ylr
	 * @date 2016年12月6日 
	 * @return
	 */
	public List<MidLeRepDto> selectMidLeRepList(PageRequest request){
		Map<String, Object> qryMap = request.getParams();
		String peoplelist = (String) qryMap.get("peoplelist");
		String priPIDs =  (String) qryMap.get("priPIDs");
		List<String> certList = new ArrayList<String>();
		List<String> priPIDList = new ArrayList<String>();
		if(StringUtils.isNotBlank(peoplelist)){
			String[] str = peoplelist.split(",");
			certList = new ArrayList<String>(Arrays.asList(str));
		}
		if(StringUtils.isNotBlank(priPIDs)){
			String[] priPID = priPIDs.split(",");
			priPIDList = Arrays.asList(priPID);
			Map<String, Object> map = new HashMap<>();
			map.put("priPIDList", priPIDList);
			List<MidBaseInfoDto> dtolist = midBaseInfoService.selectMidBaseInfoListByPriPIDS(map);
			for(MidBaseInfoDto midBaseInfo:dtolist){
				if(StringUtils.isNotBlank(midBaseInfo.getCerNO()))
					certList.add(midBaseInfo.getCerNO());
			}
//			qryMap.put("priPIDList", priPIDList);
		}
		qryMap.put("certList", certList);
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midLeRepMapper.selectMidLeRepList(qryMap);
	}
	
	/**
	 * 描述：任职资格黑名单查询列表
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<MidLeRepDto> selectMidLeRepBackList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.DIAOXIAO.getParam());
		return midLeRepMapper.selectMidLeRepBackList(paramsMap);
	}
	
	/**
	 * 描述：受限对象受限原因
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<MidLeRepDto> selectMidLeRepBackReasonList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(request.getParams() != null){
			paramsMap = request.getParams();
		}
		paramsMap.put("regState", RegStateEnum.DIAOXIAO.getParam());
		return midLeRepMapper.selectMidLeRepBackList(paramsMap);
	}
	
	/**
	 * 描述：通过证件号查询法定代表人信息
	 * @author yujingwei
	 * @date 2017-03-21
	 * @param certNO
	 * @return List<MidLeRep>
	 */
	public List<MidLeRep> selectMidLeRepListByCerNO(String certNO) throws Exception{
		if(StringUtils.isEmpty(certNO)){
			return null;
		}
		return midLeRepMapper.selectMidLeRepListByCerNO(certNO);
	}

	@Override
	public int qryMidLeRepByCerNOAndName(String certNO, String name) {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("cerNO", certNO);
		qryMap.put("name", name);
		return midLeRepMapper.selectMidLeRepCountByCerNOAndName(qryMap);
	}

	@Override
	public List<MidLeRep> findMidLerepByPriPIDList(List<String> priPidList) {
		if(priPidList == null || priPidList.size() == 0) return null;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("priPidList", priPidList);
		return midLeRepMapper.findMidLerepByPriPIDList(params);
	}

}