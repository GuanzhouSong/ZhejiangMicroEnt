/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.mapper.PbBaseinfoMapper;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Service
public class PbBaseinfoServiceImpl extends MyBatisServiceSupport implements IPbBaseinfoService {

	@Autowired
	private PbBaseinfoMapper pbBaseInfoMapper;
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	@Override
	public List<PbBaseinfo> selectPbBaseInfoList(String priPID, int year)
			throws Exception {
		Example example = new Example(PbBaseinfo.class);
		example.createCriteria().andEqualTo("priPID",priPID);
		example.createCriteria().andEqualTo("year",year);
		return pbBaseInfoMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	@Override
	public PbBaseinfo selectPbBaseInfoByPriPIdAndYear(String priPID, String year)throws Exception {
		PbBaseinfo pbBaseinfo = new PbBaseinfo();
		pbBaseinfo.setPriPID(priPID);
		pbBaseinfo.setYear(Integer.valueOf(year));
		return pbBaseInfoMapper.selectOne(pbBaseinfo);
	}
	
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param pbBaseInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int savePbBaseInfo(PbBaseinfo pbBaseInfo) throws Exception {
		pbBaseInfo.setCreateTime(new Date());
		pbBaseInfo = doWapDividePbBaseInfo(pbBaseInfo);
		return pbBaseInfoMapper.insert(pbBaseInfo);
	}

	 /**
     * 
     * 描述: 更新（通过年份和主体代码更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param phoneApply
     * @return
     */
	@Override
	public int updatePbBaseInfoByPriPidAndYear(PbBaseinfo pbBaseInfo)
			throws Exception {
		Example example = new Example(PbBaseinfo.class);
		example.createCriteria().andEqualTo("priPID",pbBaseInfo.getPriPID().toString()).andEqualTo("year",Integer.valueOf(pbBaseInfo.getYear().toString()));
		pbBaseInfo.setCreateTime(new Date());
		pbBaseInfo = doWapDividePbBaseInfo(pbBaseInfo);
		return pbBaseInfoMapper.updateByExample(pbBaseInfo, example);
	}

    /**
     * 
     * 描述: 更新（通过主键）
     * @auther gaojinling
     * @date 2016年9月11日 
     * @param yrPbBaseInfo
     * @return
     */
	@Override
	public int updatePbBaseInfoByPriKey(PbBaseinfo pbBaseInfo) throws Exception {
		pbBaseInfo.setCreateTime(new Date());
		pbBaseInfo = doWapDividePbBaseInfo(pbBaseInfo);
		return pbBaseInfoMapper.updateByPrimaryKeySelective(pbBaseInfo);
	}
	
	/**
	 * 
	 * 描述: 删除（通过年份和主体代码）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public int deletePbBaseInfoByPriPidAndYear(String priPID,int year) throws Exception{
		Example example = new Example(PbBaseinfo.class);
		example.createCriteria().andEqualTo("priPID",priPID).andEqualTo("year",year);
		return pbBaseInfoMapper.deleteByExample(example);
	}
	
	
	
	/**
	 * 
	 * 描述: 元转化为万元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo doWapDividePbBaseInfo(PbBaseinfo pbBaseinfo) throws Exception {
		if(pbBaseinfo == null){
			return pbBaseinfo;
		}
		//资金数额
		pbBaseinfo.setFundAm(pbBaseinfo.getFundAm() == null ? null : pbBaseinfo.getFundAm().divide(new BigDecimal(10000)));
		//营业额或营业收入
		pbBaseinfo.setVendInc(pbBaseinfo.getVendInc() == null ? null : pbBaseinfo.getVendInc().divide(new BigDecimal(10000)));
		// 纳税总额
		pbBaseinfo.setRatGro(pbBaseinfo.getRatGro() == null ? null : pbBaseinfo.getRatGro().divide(new BigDecimal(10000)));
		return pbBaseinfo;
	}
	
	/**
	 * 
	 * 描述: 万元转化为元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo doWapMulitplyPbBaseInfo(PbBaseinfo pbBaseinfo) throws Exception {
		if(pbBaseinfo == null){
			return pbBaseinfo;
		}
		//资金数额
		pbBaseinfo.setFundAm(pbBaseinfo.getFundAm() == null ? null : pbBaseinfo.getFundAm().multiply(new BigDecimal(10000)));
		//营业额或营业收入
		pbBaseinfo.setVendInc(pbBaseinfo.getVendInc() == null ? null : pbBaseinfo.getVendInc().multiply(new BigDecimal(10000)));
		// 纳税总额
		pbBaseinfo.setRatGro(pbBaseinfo.getRatGro() == null ? null : pbBaseinfo.getRatGro().multiply(new BigDecimal(10000)));
		return pbBaseinfo;
	}

	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = new Example(PbBaseinfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return pbBaseInfoMapper.deleteByExample(example);
	}

	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbBaseinfo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(PbBaseinfo pbBaseinfo) throws Exception {
		return pbBaseInfoMapper.insert(pbBaseinfo);
	}
	
	@Override
	public List<PbBaseinfoDto> queryPbAncheIDList(String priPID) {
		List<PbBaseinfoDto> anCheIDs = new LinkedList<PbBaseinfoDto>();
		anCheIDs = pbBaseInfoMapper.selectPbBaseInfoList(priPID);
		return anCheIDs;
	}

	@Override
	public PbBaseinfoDto queryPbYrInfoByPriPIDAndYear(String priPID, String year) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		queryMap.put("year", year);
		PbBaseinfoDto pbBaseinfoDto = pbBaseInfoMapper.selectPbYrInfoByPriPIDAndYear(queryMap);
		return pbBaseinfoDto;
	}
	@Override
	public List<PbBaseinfoDto> queryPbYrInfoByPriPID(String priPID) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		List<PbBaseinfoDto> pbBaseinfoDto = pbBaseInfoMapper.selectPbYrInfoByPriPID(queryMap);
		return pbBaseinfoDto;
	}
	@Override
	public List<PbBaseinfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pbBaseInfoMapper.selectPbYrInfoListByPriPID(request.getParams());
	}

	@Override
	public String queryAnduitStateInfoByAncheID(String AncheID) {
		 String ifFilter = pbBaseInfoMapper.selectBaseInfoForbidwordInfoByAncheID(AncheID);
         if(StringUtil.isEmpty(ifFilter)){
        	 ifFilter = "0";
         }
         return ifFilter;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryAnduitStateInfoByAncheID(String priPID, Integer year) {
		@SuppressWarnings("rawtypes")
		HashMap queryMap = new HashMap();
		 queryMap.put("priPID", priPID);
		 queryMap.put("year", year);
		 String ifFilter = pbBaseInfoMapper.selectBaseInfoForbidwordInfoByPriPIDAndYear(queryMap);
        if(StringUtil.isEmpty(ifFilter)){
       	 ifFilter = "0";
        }
        return ifFilter;
	}

	@Override
	public List<PbBaseinfoDto> selectPbBaseinfoAssetList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(),",");
		params.put("regState", regState);
		String zeroAppItem = params.get("zeroAppItem3").toString();
		if(zeroAppItem.contains("1")){
			params.put("vendInc", "1");
		}
		if(zeroAppItem.contains("2")){
			params.put("ratGro", "3");
		}
		return pbBaseInfoMapper.selectPbBaseinfoAssetList(params);
	}

	@Override
	public YrAssetCount queryPbYrAssetCount(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(),",");
		params.put("regState", regState);
		params.put("pageNum", request.getStart());
		params.put("length", request.getLength());
		return pbBaseInfoMapper.queryPbYrAssetCount(params);
	}

}