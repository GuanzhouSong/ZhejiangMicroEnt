/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_yr_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IYrBaseInfoService extends BaseService {


	/**
	 * 根据主体代码和年度获取年报基本信息对象
	 * @wangjin
	 * @param year
	 * @param pripid
     * @return
     */
	YrBaseInfo selectByYearAndPriPID(Integer year,String pripid);

	/**
	 * 新增
	 * @autor:wangjin
	 * @param yrBaseInfo
	 * @return
     */
	int insert(YrBaseInfo yrBaseInfo);










	//TODO 以下代码暂未用到----------------------------------
	/**
	 * 
	 * 描述             : 根据主体代码和年度获取年报基本信息
	 * @author: 赵祥江
	 * @date  : 2016年8月29日 下午1:39:22 
	 * @param :
	 * @return: List<YrBaseInfo>
	 * @throws
	 */
	public List<YrBaseInfo> selectYrBaseInfoByYearAndPriPID(int year,String pripid);


}