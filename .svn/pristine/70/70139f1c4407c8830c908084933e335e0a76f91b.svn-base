/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_yr_subcapital 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IYrSubcapitalService extends BaseService {

	/**
	 * 更新
	 * 
	 * @autor: wangjin
	 * @param yrSubcapital
	 * @return
	 */
	int update(YrSubcapital yrSubcapital);

	/**
	 * 新增
	 * 
	 * @autor: wangjin
	 * @param yrSubcapital
	 * @return
	 */
	int insert(YrSubcapital yrSubcapital);

	/**
	 * 根据年份和主体身份代码进行查询
	 * 
	 * @return
	 */
	YrSubcapital selectByYearAndPripid(Integer year, String pripid);

	/**
	 * 列表查询
	 * 
	 * @autor: wangjin
	 * @param request
	 * @return
	 */
	List<YrSubcapital> select_queryPage(PageRequest request);

	/**
	 * 根据 invID和priPID 查询对象
	 * 
	 * @param invID
	 * @param priPID
	 * @return
	 */
	YrSubcapital selectByInvIdAndPriPID(String invID, String priPID);

	/**
	 * 根据 invID 进行删除
	 * 
	 * @autor: wangjin
	 * @param invID
	 * @return
	 */
	int delete(String invID);

	/**
	 * 批量删除
	 * 
	 * @autor: wangjin
	 * @param list_invID
	 * @param priPID
	 * @return
	 */
	int batch_delete(List<String> list_invID, String priPID);

	/**
	 *
	 * 描述 : 根据内部序号和年报年度获取出资信息（年报预览，内部序号加密 by ZhouYan 2016-9-24
	 * 08:57:24） @author: 赵祥江 @date : 2016年8月28日 下午1:32:50 @param : @return:
	 * List<YrSubcapital> @throws
	 */
	public List<YrSubcapital> queryPagePreview(PageRequest request) throws Exception;

	/**
	 * 根据年份和主体身份代码获取 对象集合数据
	 * 
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	List<YrSubcapital> selectByYearAndPripidList(Integer year, String priPID);

	/**
	 * 插入当前年份上一年份的数据集合
	 * 
	 * @autor:wangjin
	 * @param list
	 * @param anCheID
	 *            年报ID
	 * @return
	 */
	void insertYrSubcapitalList(List<YrSubcapital> list, String anCheID);

	/**
	 * 获取认缴出资 总和
	 * 
	 * @author:wangjin
	 * @param queryMap
	 * @return
	 */
	BigDecimal rj_sumMoney(Map<String, Object> queryMap);

	/**
	 * 获取实缴出资 总和
	 * 
	 * @author:wangjin
	 * @param queryMap
	 * @return
	 */
	BigDecimal sj_sumMoney(Map<String, Object> queryMap);

	/**
	 * 
	 * 描述：根据priPID查询企业年报股东及出资信息JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月23日
	 * @param request
	 * @return
	 */
	List<Subcapital> queryPageResult(PageRequest request);
}