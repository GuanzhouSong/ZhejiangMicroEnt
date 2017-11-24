/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.yr.mapper.YrBaseInfoMapper;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.service.IYrBaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_yr_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class YrBaseInfoServiceImpl extends MyBatisServiceSupport implements IYrBaseInfoService {

	@Autowired
	private YrBaseInfoMapper yrBaseInfoMapper;

	/**
	 * 根据主体代码和年度获取年报基本信息对象
	 * @autor:wangjin
	 * @param year
	 * @param pripid
	 * @return
	 */
	@Override
	public YrBaseInfo selectByYearAndPriPID(Integer year, String pripid) {
		if(year!=null&& StringUtil.isNotEmpty(pripid)){
			YrBaseInfo yrBaseInfo=new YrBaseInfo();
			yrBaseInfo.setYear(year);
			yrBaseInfo.setPriPID(pripid);
			return yrBaseInfoMapper.selectOne(yrBaseInfo);
		}
		return null;
	}

	/**
	 * 新增
	 * @autor:wangjin
	 * @param yrBaseInfo
	 * @return
	 */
	@Override
	public int insert(YrBaseInfo yrBaseInfo) {
		//时间戳
		yrBaseInfo.setCreateTime(DateUtil.getSysDate());
		return yrBaseInfoMapper.insert(yrBaseInfo);
	}

	/**
	 * 
	 * 描述: 根据主体代码和年度获取年报基本信息
	 * @author: 赵祥江
	 * @date  : 2016年8月29日 下午1:39:22 
	 * @param :
	 * @return: List<YrBaseInfo>
	 * @throws
	 */
	@Override
	public List<YrBaseInfo> selectYrBaseInfoByYearAndPriPID(int year, String pripid) {
		YrBaseInfo yrBaseInfo=new YrBaseInfo();
		yrBaseInfo.setYear(year);
		yrBaseInfo.setPriPID(pripid); 
		return yrBaseInfoMapper.select(yrBaseInfo);
	}
}