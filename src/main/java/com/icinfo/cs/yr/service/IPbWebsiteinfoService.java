/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.PbWebsiteinfoDto;
import com.icinfo.cs.yr.model.PbWebsiteinfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_websiteinfo 对应的Service接口.个体户公示网站信息<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public interface IPbWebsiteinfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（相当于查询整个年份）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	public List<PbWebsiteinfo> selectPbWebsiteListByPriPidAndYear(
			String anCheID);
	
	/**
	 * 
	 * 描述: 通过年报id查询个体户公示网站信息（分页）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 */
	public List<PbWebsiteinfo> queryPbWebsitePage(PageRequest request);
	
	/***
	 * 
	 * 描述: 添加（null字段保存，且不使用默认值）
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
	public int savePbWebsiteinfo(PbWebsiteinfo pbWebsiteinfo);
	
	/**
	 * 
	 * 描述: 更新（通过年报id更新）
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param phoneApply
	 * @return
	 */
	public int updatePbWebsiteinfo(PbWebsiteinfo pbWebsiteinfo);
	
	/**
	 * 
	 * 描述: 删除(根据年报id删除，相当于删除整个年份)
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbWebsiteinfoByAnCheID(PbWebsiteinfo pbWebsiteinfo);
	
	/**
	 * 
	 * 描述: 删除(根据主键id删除 单个删除)
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param pbWebsiteinfo
	 * @return
	 */
	public int deletePbWebsiteinfoBy(PbWebsiteinfo pbWebsiteinfo);

	/**
	 * 描述：个体户年报网站或网店信息列表
	 * @author baifangfang
	 * @date 2016年10月9日
	 * @param request
	 * @return
	 */
	public List<PbWebsiteinfoDto> queryPage(PageRequest request);
	
	/** 
	 * 描述: 根据年报ID 获取网店网站
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public List<PbWebsiteinfo> selectPbWebsiteInfoByAnCheID(String anCheID) throws Exception;
	
	
	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int insertByAnCheID(String anCheID) throws Exception;

	/**
	 * 描述：根据年报id查询个体户网站或网店信息列表
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param anCheID
	 * @return
	 */
	public List<PbWebsiteinfoDto> queryListResult(String anCheID);
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param pbWebsiteinfo
	 * @return
	 * @throws Exception 
	 */
	public int insert(PbWebsiteinfo pbWebsiteinfo)throws Exception;
	
}