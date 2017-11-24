/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 描述: cs_yr_subcapital 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface YrSubcapitalMapper extends Mapper<YrSubcapital> {

	BigDecimal rj_sumMoeny(Map<String, Object> queryMap);

	BigDecimal sj_sumMoeny(Map<String, Object> queryMap);

	/**
	 * 查询列表
	 * 
	 * @author:wangjin
	 * @param params
	 * @return
	 */
	List<YrSubcapital> doGetYrSubcapitalList(Map<String, Object> params);

	/**
	 * 单独更新字段值
	 * 
	 * @param map
	 * @return
	 */
	int updateByLiacconam(Map<String, String> map);

	/**
	 * 
	 * 描述：根据priPID查询企业年报股东及出资信息JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月23日
	 * @param params
	 * @return
	 */
	List<Subcapital> queryPageResultByPripid(Map<String, Object> params);

	/*  *//**
			 * 列表查询
			 * 
			 * @author: wangjin
			 * @param params
			 * @return
			 *//*
			 * List<YrSubcapital> search_queryPage(Map<String, Object> params);
			 */
}