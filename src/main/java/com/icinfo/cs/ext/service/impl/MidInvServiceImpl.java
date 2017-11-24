/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.mapper.MidInvMapper;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_mid_inv 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class MidInvServiceImpl extends MyBatisServiceSupport implements IMidInvService {

	@Autowired
	private MidInvMapper midInvMapper;

	/**
	 * 
	 * 描述: 根据内部序号查询投资信息
	 * 
	 * @auther gaojinling
	 * @date 2016年8月29日
	 * @param PriPID
	 * @return
	 */
	@Override
	public List<MidInv> selectInvListByPriPID(String priPID) {
		Example example = new Example(MidInv.class);
		example.createCriteria().andEqualTo("priPID", priPID).andEqualTo("exeAffSign", "1"); // 执行事务合伙标志1 是 2														// 否
		return midInvMapper.selectByExample(example);
	}

	@Override
	public List<MidInvDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return midInvMapper.queryPageResultByPripid(request.getParams());
	}

	@Override
	public MidInv findMidInvById(int midInvId) {
		return midInvMapper.selectByPrimaryKey(midInvId);
	}

	@Override
	public List<MidInvDto> queryPageResultByCerNO(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return midInvMapper.queryPageResultByCerNO(handleParamsMap(paramsMap));
	}
	
	/**
	 * 描述：根据cerNo查询投资信息
	 * 
	 * @author zhuyong
	 * @date 2016年11月11日
	 * @param request
	 * @return
	 */
	public List<MidInvDto> queryPageResultByCerNO(String cerNO){
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("cerNO", cerNO);
		return midInvMapper.queryPageResultByCerNO(qryMap);
	}

	@Override
	public List<MidInvDto> queryListResult(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		return midInvMapper.queryListResultByPripid(queryMap);
	}

	@Override
	public List<MidInv> findMidInvByExeAffSign() {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("exeAffSign", "1");
		return midInvMapper.queryListResultByExeAffSign(queryMap);
	}
	
	/**
	 * 描述：根据cerNo查询投资信息(企业唯一)
	 * @author yujingwei
	 * @date 2017年03月22日
	 * @param request
	 * @return List<MidInv>
	 */
	public List<MidInv> selectMidInvInfoByCerNO(String certNO) throws Exception{
		if(StringUtil.isEmpty(certNO)){
			return null;
		}
		return midInvMapper.selectMidInvInfoByCerNO(certNO);
	}

	@Override
	public int qryMidInvByCerNOAndName(String certNO, String name) {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("cerNO", certNO);
		qryMap.put("name", name);
		return midInvMapper.selectMidInvCountByCerNOAndName(qryMap);
	}
	
	/** 
	 * 描述: 处理参数
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception{
		if(paramsMap != null){
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
		}
		return paramsMap;
	}
	
}