/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrSfcBranchInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_sfc_branchinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
public interface IYrSfcBranchInfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据主体代码和年份（无分页）
	 * @auther gaojinling
	 * @date 2016年9月12日 
	 * @param anCheID
	 * @return
	 */
	public List<YrSfcBranchInfo> selectSfcBranchListByAnCheID(String anCheID);
	
	/**
	 * 
	 * 描述: 根据年报id查询(分页查询)
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrSfcBranchInfo> queryPageByAnCheID(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述: 单个（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param LicId
	 * @return
	 */
	public YrSfcBranchInfo selectOneByBrID(String brID);
	
		
	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param YrSfcLicenceInfo
	 * @return
	 * @throws Exception
	 */
	public int saveYrSfcBranchInfo(YrSfcBranchInfo yrSfcBranchInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param YrSfcLicenceInfo
	 * @return
	 * @throws Exception
	 */
	public int updateYrSfcBranchInfo(YrSfcBranchInfo yrSfcBranchInfo) throws Exception ;
	
	/**
	 * 
	 * 描述: 批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param YrPbLicenceList
	 * @throws Exception
	 */
	public int deleteYrSfcBranchInfoRtn(String brIDs) throws Exception ;
}