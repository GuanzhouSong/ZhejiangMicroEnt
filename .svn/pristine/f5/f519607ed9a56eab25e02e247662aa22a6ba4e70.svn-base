/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.AlterStockInfoDto;
import com.icinfo.cs.yr.model.AlterStockInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_alterstockinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IAlterStockInfoService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股权转让信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<AlterStockInfo>
	 * @throws
	 */
	public List<AlterStockInfo> queryPage(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述             : 根据年报ID查询 公示 股权转让信息 不分页
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午3:51:59 
	 * @param :
	 * @return: List<AlterStockInfo>
	 * @throws
	 */
	public List<AlterStockInfo> selectAlterStockInfoByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int insertByAnCheID(String anCheID) throws Exception;

	/**
	 * 
	 * 描述: 公示侧查询股权转让信息（需要过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	public List<AlterStockInfoDto> queryPageForPub(PageRequest request);
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param flterStockInfo
	 * @return
	 * @throws Exception 
	 */
	public int insert(AlterStockInfo flterStockInfo)throws Exception;
}