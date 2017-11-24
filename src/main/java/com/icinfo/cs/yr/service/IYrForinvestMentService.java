/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_forinvestment 对应的Service接口.<br>
 *  对外投资 
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IYrForinvestMentService extends BaseService {

	/**
	 * 更新
	 * @autor: wangjin
	 * @param yrForinvestMent
	 * @return
	 */
	int update(YrForinvestMent yrForinvestMent );

	/**
	 * 新增
	 * @autor: wangjin
	 * @param yrForinvestMent
	 * @return
	 */
	int insert(YrForinvestMent yrForinvestMent);

	/**
	 * 列表查询
	 * @autor: wangjin
	 * @param request
	 * @return
	 */
	List<YrForinvestMent> select_queryPage(PageRequest request);

	/**
	 * 根据年份和主体身份代码获取 对象集合数据
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	List<YrForinvestMent> selectByYearAndPripidList(Integer year, String priPID);

	/**
	 * 插入当前年份上一年份的数据集合
	 * @autor:wangjin
	 * @param list
	 * @param anCheID 年报ID
	 * @return
	 */
	void insertyrForinvestMentlList(List<YrForinvestMent> list, String anCheID);

	/**
	 * 批量删除
	 * @autor: wangjin
	 * @param list_outinvIDs
	 * @param priPID
	 * @return
	 */
	int batch_delete(List<String> list_outinvIDs, String priPID);

	/**
	 * 根据 invID和priPID 查询对象
	 * @param outinvid
	 * @param priPID
	 * @return
	 */
	YrForinvestMent selectByInvIdAndPriPID(String outinvid, String priPID);


	/**
	 * 描述: 年报预览：对外投资
	 * @auther ZhouYan
	 * @date 2016年9月24日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrForinvestMent> queryPagePreview(PageRequest request) throws Exception;


	/**
	 * 
	 * 描述  : 根据年报年度和企业主体代码查询对外投资实缴总额
	 * @author: 赵祥江
	 * @date  : 2016年9月8日 下午6:58:37 
	 * @param :
	 * @return: BigDecimal
	 * @throws
	 */
	public  BigDecimal selectInvestSumByYearAndPriPid(Map<String,Object> queryMap);
	
	/**
	 * 
	 * 描述   根据年报年度和企业主体代码查询对外投资认缴总额
	 * @author 赵祥江
	 * @date 2016年11月15日 下午5:42:39 
	 * @param 
	 * @return BigDecimal
	 * @throws
	 */
	public  BigDecimal selectInvestSubConAmSumByYearAndPriPid(Map<String,Object> queryMap);


}