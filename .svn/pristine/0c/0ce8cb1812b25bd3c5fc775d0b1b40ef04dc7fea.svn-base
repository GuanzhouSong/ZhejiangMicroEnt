/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.mapper.BaseInfoMapper;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.cs.yr.service.IBaseInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class BaseInfoServiceImpl extends MyBatisServiceSupport implements IBaseInfoService {

	private static final Logger logger = LoggerFactory.getLogger(BaseInfoServiceImpl.class);

	@Autowired
	private BaseInfoMapper baseInfoMapper;

	/**
	 * 
	 * 描述 : 根据年报ID分页查询 公示 年报基本信息 @author: 赵祥江 @date : 2016年9月9日 下午3:55:12 @param
	 * : anCheID:年报ID @return: List<BaseInfo> @throws
	 */
	@Override
	public List<BaseInfo> queryPage(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap = request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example = this.getExample(BaseInfo.class);
			// 年报ID
			if (searchMap.containsKey(Constants.CS_ANCHEID)) {
				example.createCriteria().andEqualTo(Constants.CS_ANCHEID,
						searchMap.get(Constants.CS_ANCHEID).toString());
				List<BaseInfo> baseInfoList = baseInfoMapper.selectByExample(example);
				if (baseInfoList.size() > 0) {
					return baseInfoList;
				}
			}
			return new ArrayList<BaseInfo>();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据年报ID查询公示  年报基本信息失败!");
			throw new BusinessException("根据年报ID查询公示  年报基本信息失败!");
		}
	}

	private Example getExample(Class<?> classObj) {
		Example example = new Example(classObj);
		return example;
	}

	/**
	 * 
	 * 描述 : 根据pripID,year 查企业年报基本信息
	 * 
	 * @author: yujingwei
	 * @date : 2016年9月13日
	 * @param :
	 *            priPID，year
	 * @return: BaseInfo
	 */
	@Override
	public BaseInfo selectInfoByPripidAndYear(String priPID, Integer year) throws Exception {
		BaseInfo baseInfo = new BaseInfo();
		baseInfo.setPriPID(priPID);
		baseInfo.setYear(year);
		return baseInfoMapper.selectOne(baseInfo);
	}

	/**
	 * 描述: 根据年报id删除公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	@Override
	public int deleteByAnCheID(String anCheID) throws Exception {
		Example example = this.getExample(BaseInfo.class);
		example.createCriteria().andEqualTo(Constants.CS_ANCHEID, anCheID);
		return baseInfoMapper.deleteByExample(example);
	}

	/**
	 * 描述: 保存公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param baseInfo
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(BaseInfo baseInfo) throws Exception {
		return baseInfoMapper.insert(baseInfo);
	}

	/**
	 * 
	 * 描述: 根据priPID查询年报ID
	 * 
	 * @auther chenyl
	 * @date 2016年9月26日
	 * @param priPID
	 * @return
	 */
	@Override
	public List<BaseInfoDto> queryAncheIDList(String priPID) {
		List<BaseInfoDto> anCheIDs = new LinkedList<BaseInfoDto>();
		anCheIDs = baseInfoMapper.selectBaseInfoList(priPID);
		return anCheIDs;
	}

	@Override
	public List<BaseInfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return baseInfoMapper.selectYrInfoListByPriPID(request.getParams());
	}

	@Override
	public BaseInfoDto queryYrInfoByPriPIDAndYear(String priPID, String year) {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("priPID", priPID);
		queryMap.put("year", year);
		BaseInfoDto baseInfoDto = baseInfoMapper.selectBaseInfoByPriPIDAndYear(queryMap);
		return baseInfoDto;
	}

	@Override
	public String queryAnduitStateInfoByAncheID(String AncheID) {
		String ifFilter = baseInfoMapper.selectBaseInfoForbidwordInfoByAncheID(AncheID);
		if (StringUtil.isEmpty(ifFilter)) {
			ifFilter = "0";
		}
		return ifFilter;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String queryAnduitStateInfoByAncheID(String priPID, Integer year) {
		HashMap queryMap = new HashMap();
		queryMap.put("priPID", priPID);
		queryMap.put("year", year);
		String ifFilter = baseInfoMapper.selectBaseInfoForbidwordInfoByPriPIDAndYear(queryMap);
		if (StringUtil.isEmpty(ifFilter)) {
			ifFilter = "0";
		}
		return ifFilter;
	}

	@Override
	public List<BaseInfoDto> selectEntBaseinfoAssetList(PageRequest request) throws ParseException {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(), ",");
		String industryCo = StringUtil.doSplitStringToSqlFormat(params.get("industryCo").toString(), ",");
		String ancheDateEnd = StringUtil.doSplitStringToSqlFormat(params.get("ancheDateEnd").toString(), ",");

		if (!StringUtil.isEmpty(ancheDateEnd)) {
			ancheDateEnd = ancheDateEnd.substring(1, ancheDateEnd.length()-1);
			Calendar c = Calendar.getInstance();
			Date date = DateUtil.parseDate(ancheDateEnd, "yyyy-MM-dd");
			c.setTime(date);
			int day = c.get(Calendar.DATE);
			c.set(Calendar.DATE, day + 1);
			ancheDateEnd = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
			params.put("ancheDateEnd", ancheDateEnd);
		}
		params.put("regState", regState);
		params.put("industryCo", industryCo);
		String zeroAppItem = params.get("zeroAppItem1").toString();
		if (zeroAppItem.contains("1")) {
			params.put("assGro", "1");
		}
		if (zeroAppItem.contains("2")) {
			params.put("liaGro", "2");
		}
		if (zeroAppItem.contains("3")) {
			params.put("totEqu", "3");
		}
		if (zeroAppItem.contains("4")) {
			params.put("vendInc", "4");
		}
		if (zeroAppItem.contains("5")) {
			params.put("maiBusInc", "5");
		}
		if (zeroAppItem.contains("6")) {
			params.put("proGro", "6");
		}
		if (zeroAppItem.contains("7")) {
			params.put("netInc", "7");
		}
		if (zeroAppItem.contains("8")) {
			params.put("ratGro", "8");
		}
		return baseInfoMapper.selectEntBaseinfoAssetList(params);
	}

	@Override
	public YrAssetCount queryEntYrAssetCount(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String regState = StringUtil.doSplitStringToSqlFormat(params.get("regState").toString(), ",");
		params.put("regState", regState);
		params.put("pageNum", request.getStart());
		params.put("length", request.getLength());
		return baseInfoMapper.queryEntYrAssetCount(params);
	}

}