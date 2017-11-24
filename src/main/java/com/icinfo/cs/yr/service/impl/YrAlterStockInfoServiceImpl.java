/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.YrSubcapital;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.mapper.YrAlterStockInfoMapper;
import com.icinfo.cs.yr.mapper.YrBaseInfoMapper;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.service.IYrAlterStockInfoService;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_yr_alterstockinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
@Service
public class YrAlterStockInfoServiceImpl extends MyBatisServiceSupport implements IYrAlterStockInfoService {
	private static final Logger logger = LoggerFactory.getLogger(YrAlterStockInfoServiceImpl.class);

	@Autowired
	private YrAlterStockInfoMapper yrAlterStockInfoMapper;
	
	@Autowired
	private YrBaseInfoMapper YrBaseInfoMapper;
	
	@Autowired
	private IYrBaseInfoService yrBaseInfoService;
	
	//主键uuid 
	private final String CS_YR_ALTERSTOCKINFO_INVALTID="invAltID";

	/**
	 * 更新
	 * @autor: wangjin
	 * @param yrAlterStockInfo
	 * @return
	 */
	@Override
	public int update(YrAlterStockInfo yrAlterStockInfo) {
		Example example = new Example(YrAlterStockInfo.class);
		example.createCriteria().andEqualTo(CS_YR_ALTERSTOCKINFO_INVALTID, yrAlterStockInfo.getInvAltID()).andEqualTo("priPID",yrAlterStockInfo.getPriPID());
		//yrAlterStockInfo.setCreateTime(DateUtils.getSysDate());
		return yrAlterStockInfoMapper.updateByExampleSelective(yrAlterStockInfo,example);
	}


	/**
	 * 添加
	 * @autor: wangjin
	 * @param yrAlterStockInfo
	 * @return
	 */
	@Override
	public int insert(YrAlterStockInfo yrAlterStockInfo) {
		yrAlterStockInfo.setCreateTime(DateUtils.getSysDate());
		return yrAlterStockInfoMapper.insert(yrAlterStockInfo);
	}

	/**
	 * 列表查询
	 * @autor: wangjin
	 * @param request
	 * @return
	 */
	@Override
	public List<YrAlterStockInfo> select_queryPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Example example = new Example(YrAlterStockInfo.class);
		Map<String, Object> searchMap=  request.getParams();
		String priPID = searchMap.get(Constants.CS_PRIPID).toString();
		String year = searchMap.get(Constants.CS_YEAR).toString();
		if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year)){
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID).andEqualTo(Constants.CS_YEAR, year);

			String orderStr = (String)searchMap.get("orderStr");
			if(StringUtils.isNotEmpty(orderStr)){ ////判断排序参数是否为空
				example.setOrderByClause(searchMap.get("orderStr").toString());
			}else{
				example.setOrderByClause(" CreateTime desc ");
			}
			return yrAlterStockInfoMapper.selectByExample(example);
		}
		return null;

	}

	/**
	 * 根据 invAltID和priPID 查询对象
	 * @param invAltID
	 * @param priPID
	 * @return
	 */
	@Override
	public YrAlterStockInfo selectByInvIdAndPriPID(String invAltID, String priPID) {
		YrAlterStockInfo yrAlterStockInfo = new YrAlterStockInfo();
		yrAlterStockInfo.setInvAltID(invAltID);
		yrAlterStockInfo.setPriPID(priPID);
		return yrAlterStockInfoMapper.selectOne(yrAlterStockInfo);
	}

	/**
	 * 批量删除
	 * @autor:wangjin
	 * @param list_invAltID
	 * @param priPID
	 * @return
	 */
	@Override
	public int batch_delete(List<String> list_invAltID, String priPID) {
		YrAlterStockInfo yrAlterStockInfo = null;
		if(StringUtil.isNotEmpty(priPID)){
			int num = 0;
			for(String invAltID:list_invAltID){
				yrAlterStockInfo = new YrAlterStockInfo();
				yrAlterStockInfo.setInvAltID(invAltID);
				yrAlterStockInfo.setPriPID(priPID);
				yrAlterStockInfoMapper.delete(yrAlterStockInfo);
				num++;
			}
			return num;
		}
		return 0;
	}




	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}


	  /**
     * 
     * 描述 : 根据主体代码和年报查询
     * @author: 赵祥江
     * @date  : 2016年9月18日 下午5:06:24 
     * @param :
     * @return: List<YrAlterStockInfo>
     * @throws
     */
	@Override
	public List<YrAlterStockInfo> selectYrAlterStockInfoByPriPID(int year, String priPID) throws Exception {
		try {
			YrAlterStockInfo yrAlterStockInfo=new YrAlterStockInfo(); 
			yrAlterStockInfo.setPriPID(priPID);
			yrAlterStockInfo.setYear(year);
			return  yrAlterStockInfoMapper.select(yrAlterStockInfo); 
		 } catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}","初始化股权转让信息失败");
	        throw new BusinessException("初始化股权转让信息失败");
		} 
	}



	/** 
	 * 描述: 年报预览：股权变更信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return 
	 */
	@Override
	public List<YrAlterStockInfo> queryPagePreview(PageRequest request) {
		List<YrAlterStockInfo> yrAlterStockInfoList=new ArrayList<YrAlterStockInfo>();
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			Example example=this.getExample(YrAlterStockInfo.class);
			//验证是否主体代码和年报年度都传了
			if(searchMap.containsKey(Constants.CS_PRIPID)&&searchMap.containsKey(Constants.CS_YEAR)){
				example.createCriteria().andEqualTo(Constants.CS_PRIPID,searchMap.get(Constants.CS_PRIPID).toString())
				.andEqualTo(Constants.CS_YEAR, searchMap.get(Constants.CS_YEAR).toString());
				yrAlterStockInfoList = yrAlterStockInfoMapper.selectByExample(example); 
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("exception {}", "获取股权变更信息失败!");
            throw new BusinessException("获取股权变更信息失败!");
		}
		return yrAlterStockInfoList;
	}


	
}