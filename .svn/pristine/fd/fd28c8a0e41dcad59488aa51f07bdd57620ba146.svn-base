/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.SubcapitalDto;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_subcapital 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface ISubcapitalService extends BaseService {
	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 股东及出资信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<Subcapital>
	 * @throws
	 */
	public List<Subcapital> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述             : 根据年报ID获取出资（不分页）  公示
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午2:11:06 
	 * @param :
	 * @return: List<Subcapital>
	 * @throws
	 */
	public List<Subcapital> selectSubcapitalByAnCheID(String anCheID) throws Exception;
	
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
	 * 描述: 公示侧获取股东及出资信息（增加敏感词过滤）
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 */
	public List<SubcapitalDto> queryPageForPub(PageRequest request);
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param subcapital
	 * @return
	 * @throws Exception 
	 */
	public int insert(Subcapital subcapital)throws Exception;
}