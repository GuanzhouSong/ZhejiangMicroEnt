/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.AlterStockInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_alterstockinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IAlterStockInfoHisService extends BaseService {
 
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股权转让历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午6:11:06 
	 * @param : anCheID:年报ID
	 * @return: List<AlterStockInfoHis>
	 * @throws
	 */
	public List<AlterStockInfoHis> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述   根据年报ID和年报编码查询历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午6:06:53 
	 * @param 
	 * @return List<AlterStockInfoHis>
	 * @throws
	 */
	public List<AlterStockInfoHis> selectAlterStockInfoHisByAnCheIDAndreportNo(String anCheID,String reportNo ) throws Exception;

	
	/** 
	 * 描述: 保存公示股权转让历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param flterStockInfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(AlterStockInfoHis flterStockInfoHis)throws Exception;
	
	
	
	

}