/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.mapper.SfcBaseInfoMapper;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.cs.yr.service.ISfcBaseInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class SfcBaseInfoServiceImpl extends MyBatisServiceSupport implements ISfcBaseInfoService {
	private static final Logger logger = LoggerFactory.getLogger(SfcBaseInfoServiceImpl.class);
	@Autowired
	private SfcBaseInfoMapper sfcBaseInfoMapper;
	/**
	 * 
	 * 描述   根据年份和主体代码查询基本信息 农专
	 * @author 赵祥江
	 * @date 2016年10月8日 上午10:27:04 
	 * @param 
	 * @return SfcBaseInfo
	 * @throws
	 */
	@Override
	public SfcBaseInfo selectSfcBaseInfoByPriPIdAndYear(String priPID, int year)
			throws Exception {
		try {
			SfcBaseInfo sfcBaseInfo=new SfcBaseInfo();
			sfcBaseInfo.setPriPID(priPID);
			sfcBaseInfo.setYear(year);
			return sfcBaseInfoMapper.selectOne(sfcBaseInfo);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年份和主体代码查询基本信息 农专失败!");
            throw new BusinessException("根据年份和主体代码查询基本信息 农专失败!");
		}
	}
	
	/**
	 * 
	 * 描述: 根据年报id删除公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = new Example(SfcBaseInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return sfcBaseInfoMapper.deleteByExample(example);
	}

	/**
	 * 
	 * 描述: 保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param sfcBaseInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(SfcBaseInfo sfcBaseInfo) throws Exception {
		return sfcBaseInfoMapper.insert(sfcBaseInfo);
	}
	
	@Override
	public List<SfcBaseInfoDto> querySfcAncheIDList(String priPID) {
		List<SfcBaseInfoDto> anCheIDs = new LinkedList<SfcBaseInfoDto>();
		anCheIDs = sfcBaseInfoMapper.selectSfcBaseinfoList(priPID);
		return anCheIDs;
	}

	@Override
	public SfcBaseInfoDto querySfcYrInfoByPriPIDAndYear(String priPID, String year) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		queryMap.put("year", year);
		SfcBaseInfoDto sfcBaseInfoDto = sfcBaseInfoMapper.selectSfcYrInfoByPriPIDAndYear(queryMap);
		return sfcBaseInfoDto;
	}

	@Override
	public List<SfcBaseInfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sfcBaseInfoMapper.selectSfcYrInfoListByPriPID(request.getParams());
	}

	@Override
	public String queryAnduitStateInfoByAncheID(String AncheID) {
		 String ifFilter = sfcBaseInfoMapper.selectBaseInfoForbidwordInfoByAncheID(AncheID);
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
		 String ifFilter = sfcBaseInfoMapper.selectBaseInfoForbidwordInfoByPriPIDAndYear(queryMap);
        if(StringUtil.isEmpty(ifFilter)){
       	 ifFilter = "0";
        }
        return ifFilter;
	}

	@Override
	public List<SfcBaseInfoDto> selectSfcBaseinfoAssetList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(),",");
		params.put("regState", regState);
		String zeroAppItem = params.get("zeroAppItem2").toString();
		if(zeroAppItem.contains("1")){
			params.put("vendInc", "1");
		}
		if(zeroAppItem.contains("2")){
			params.put("priYeaProfit", "2");
		}
		if(zeroAppItem.contains("3")){
			params.put("ratGro", "3");
		}
		if(zeroAppItem.contains("4")){
			params.put("priYeaSub", "4");
		}
		if(zeroAppItem.contains("5")){
			params.put("priYeaLoan", "5");
		}
		return sfcBaseInfoMapper.selectSfcBaseinfoAssetList(params);
	}

	@Override
	public YrAssetCount querySfcYrAssetCount(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(),",");
		params.put("regState", regState);
		params.put("pageNum", request.getStart());
		params.put("length", request.getLength());
		return sfcBaseInfoMapper.querySfcYrAssetCount(params);
	}
}