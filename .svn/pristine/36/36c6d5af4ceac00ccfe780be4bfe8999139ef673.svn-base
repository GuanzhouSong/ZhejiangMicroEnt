/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_branchinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcBranchInfoService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID获取分支机构信息  不分页
	 * @author 赵祥江
	 * @date 2016年10月8日 下午3:32:27 
	 * @param 
	 * @return List<SfcBranchInfo>
	 * @throws
	 */
	public List<SfcBranchInfo> selectSfcBranchInfoByAnCheID(String anCheID) throws Exception;

	/**
	 * 描述：查询农专分支机构列表
	 * 
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 */
	public List<SfcBranchInfoDto> queryPage(PageRequest request);
	
	
	/**
	 * 
	 * 描述: 根据年报id删除公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/**
	 * 
	 * 描述: 根据年报id保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int insertByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcBranchInfo
	 * @return
	 * @throws Exception 
	 */
	int insert(SfcBranchInfo sfcBranchInfo) throws Exception;

}