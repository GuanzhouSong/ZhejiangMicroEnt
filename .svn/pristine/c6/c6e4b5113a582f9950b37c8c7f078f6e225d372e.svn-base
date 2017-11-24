/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.MapRemoveNullUtil;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousCrimeListMapper;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_exp_serious_crime_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
@Service
public class ExpSeriousCrimeListServiceImpl extends MyBatisServiceSupport implements IExpSeriousCrimeListService {
	
	@Autowired
	ExpSeriousCrimeListMapper expSeriousCrimeListMapper;
	
	/**
     * 查询已列入严重违法名单列表（用于公告）
     * @author yujingwei
     * @date 2016-10-17
     * @return List<ExpSeriousCrimeList>
     * @throws Exception
     */
	public List<ExpSeriousCrimeList> selectSeriousCrimeInfoForBulletin(String updateDate) throws Exception{
		return expSeriousCrimeListMapper.selectSeriousCrimeInfoForBulletin(updateDate);
	} 
	
	/**
     * 描述:获取异常类严违名单列入申请列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(),request.getLength());
		Map<String, Object> qryMap = request.getParams();
		MapRemoveNullUtil.removeNullValue(handleParamsMap(qryMap));
		if(qryMap.containsKey("businessStatus") && "0".equals(qryMap.get("businessStatus")))
			return expSeriousCrimeListMapper.getExpSecOpaList(qryMap);
		//包含严违表唯一字段时走严违表查询
		if(qryMap.containsKey("applyDateStart") || qryMap.containsKey("applyDateEnd") || qryMap.containsKey("publicState") || 
				qryMap.containsKey("firstdateStart") || qryMap.containsKey("firstdateEnd") || qryMap.containsKey("addSecDateStart") || 
				qryMap.containsKey("addSecDateEnd") || qryMap.containsKey("auditDateStart") || qryMap.containsKey("auditDateEnd") || 
				qryMap.containsKey("addSecNo") || qryMap.containsKey("firstName") || qryMap.containsKey("applyMan") || 
				qryMap.containsKey("auditName") || qryMap.containsKey("claimState")||qryMap.containsKey("businessStatus")){
			return expSeriousCrimeListMapper.getExpSecInApplyList(qryMap);
		}
		return expSeriousCrimeListMapper.getExpSecInApplyListCommon(qryMap);
	}
	
	/**
     * 描述:获取异常类严违名单检索列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	public List<ExpSeriousCrimeListDto> doGetExpSecSearchList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(),request.getLength());
		Map<String, Object> qryMap = request.getParams();
		MapRemoveNullUtil.removeNullValue(handleParamsMap(qryMap));
		if(qryMap.containsKey("businessStatus") && "0".equals(qryMap.get("businessStatus")))
			return expSeriousCrimeListMapper.getExpSecOpaList(qryMap);
		if(qryMap.containsKey("addSecDate") ||
				qryMap.containsKey("secExpiredDate")||
					qryMap.containsKey("businessStatus") || 
						qryMap.containsKey("addSecDateStart") ||
							qryMap.containsKey("addSecDateEnd"))
			return expSeriousCrimeListMapper.getExpSecInApplyList(qryMap);
		return expSeriousCrimeListMapper.getExpSecSearchList(qryMap);
	}
	
	/**
     * 描述:异常类严违名单数据列入
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月29日
     */
	public Integer insertExpSeriousCrimeList(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		return expSeriousCrimeListMapper.insert(expSeriousCrimeListDto);
	}
	
	/**
     * 描述:根据sourceId获取异常类严违名单数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	public ExpSeriousCrimeList selectSeriousCrimeBySourceId(String sourceId) throws Exception{
		ExpSeriousCrimeList exp = new ExpSeriousCrimeList();
		exp.setSourceId(sourceId);
		return  expSeriousCrimeListMapper.selectOne(exp);
	}
	
	/**
     * 描述:根据UId获取异常类严违名单数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月9日
     */
	public ExpSeriousCrimeList selectSeriousCrimeByUID(String uid) throws Exception{
		ExpSeriousCrimeList exp = new ExpSeriousCrimeList();
		exp.setUid(uid);
		return  expSeriousCrimeListMapper.selectOne(exp);
	}
	
	/**
     * 描述:异常类严违名单数据修改
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	public Integer updateExpSeriousCrimeList(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		Example example = new Example(ExpSeriousCrimeList.class);
		example.createCriteria().andEqualTo("sourceId", expSeriousCrimeListDto.getSourceId());
		return  expSeriousCrimeListMapper.updateByExampleSelective(expSeriousCrimeListDto, example);
	}
	
	/**
     * 描述:异常类严违名单数据修改--完全修改包含所有字段
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月22日
     */
	public Integer updateExpSeriousCrimeListForAll(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception{
		Example example = new Example(ExpSeriousCrimeList.class);
		example.createCriteria().andEqualTo("sourceId", expSeriousCrimeListDto.getSourceId());
		return  expSeriousCrimeListMapper.updateByExampleSelective(expSeriousCrimeListDto, example);
	}
	
	/**
     * 描述:异常类严违名单数据删除
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	public Integer deleteExpSeriousCrimeList(String sourceId) throws Exception{
		ExpSeriousCrimeList exp = new ExpSeriousCrimeList();
		exp.setSourceId(sourceId);
		return expSeriousCrimeListMapper.delete(exp);
	}
	
	/**
     * 描述:获取异常类严违名单列入申请列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	public List<ExpSeriousCrimeListDto> doGetExpFirstReviewList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(),request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return expSeriousCrimeListMapper.getExpSecInApplyList(handleParamsMap(paramsMap));
	}

	/**
     * 描述:获取待初审的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	@Override
	public Integer getNumByBusinessStatus(Map<String, Object> qryMap) throws Exception {
		// TODO Auto-generated method stub
		return expSeriousCrimeListMapper.getNumByBusinessStatus(qryMap);
	}
	
	
	/**
     * 描述:获取列入严违最大文号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月4日
     */
	public Integer selectMaxAddSecCountNo(Map<String, Object> qryMap) throws Exception{
		Integer countNo = expSeriousCrimeListMapper.selectMaxAddSecCountNo(qryMap); 
		return countNo == null?0:countNo;
	}

	/**
     * 描述:获取待逾期列入的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	@Override
	public Integer getYQLRNum(Map<String, Object> qryMap) throws Exception {
		// TODO Auto-generated method stub
		return expSeriousCrimeListMapper.getYQLRNum(qryMap);
	}

	/**
     * 描述:获取待列入的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	@Override
	public Integer getDLRNum(Map<String, Object> qryMap) throws Exception {
		// TODO Auto-generated method stub
		return expSeriousCrimeListMapper.getDLRNum(qryMap);
	}
	
	/**
     * 查询已列入严重违法名单列表（用于公告）
     * @author yujingwei
     * @date 2016-10-17
     * @return List<ExpSeriousCrimeList>
     * @throws Exception
     */
	public List<ExpSeriousCrimeList> selectSeriousCrimeInfoByPriPID(String priPID) throws Exception{
		Example example = new Example(ExpSeriousCrimeList.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID)
		.andEqualTo("businessStatus", "4");
		return expSeriousCrimeListMapper.selectByExample(example);
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

	@Override
	public Integer UpdateSomeMsg(String sourceId) throws Exception {
		
		return expSeriousCrimeListMapper.UpdateSomeMsg(sourceId);
	}
}