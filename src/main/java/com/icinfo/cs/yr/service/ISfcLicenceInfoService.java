/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.SfcLicenceInfoDto;
import com.icinfo.cs.yr.model.SfcLicenceInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_licenceinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcLicenceInfoService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID获取许可证信息  不分页
	 * @author 赵祥江
	 * @date 2016年10月8日 下午3:32:27 
	 * @param 
	 * @return List<SfcLicenceInfo>
	 * @throws
	 */
	public List<SfcLicenceInfo> selectSfcLicenceInfoByAnCheID(String anCheID) throws Exception;

	/**
	 * 描述：查询农专年报行政许可信息列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 */
	public List<SfcLicenceInfoDto> queryPage(PageRequest request);
	
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
	 * 描述：查询农专年报行政许可信息列表
	 * @author yujingwei
	 * @date 2016年10月10日
	 * @param request
	 * @return List<SfcLicenceInfo>
	 */
	public List<SfcLicenceInfo> queryPageInfo(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcLicenceInfo
	 * @return
	 * @throws Exception 
	 */
	int insert(SfcLicenceInfo sfcLicenceInfo) throws Exception;
}