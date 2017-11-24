/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.SfcWebsiteInfoDto;
import com.icinfo.cs.yr.model.SfcWebsiteInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sfc_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface ISfcWebsiteInfoService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID获取网站网店信息  不分页
	 * @author 赵祥江
	 * @date 2016年10月8日 下午3:32:27 
	 * @param 
	 * @return List<SfcWebsiteInfo>
	 * @throws
	 */
	public List<SfcWebsiteInfo> selectSfcWebsiteInfoByAnCheID(String anCheID) throws Exception;

	/**
	 * 描述：查询农专年报网站或网店列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param request
	 * @return
	 */
	public List<SfcWebsiteInfoDto> queryPage(PageRequest request);
	
	
	/**
	 * 
	 * 描述:根据年报id删除公示信息
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
	 * 描述：根据年报id查询农专网站或网店信息
	 * @author
	 * @date 2016年10月26日
	 * @param anCheID
	 * @return
	 */
	public List<SfcWebsiteInfoDto> queryListResult(String anCheID);
    
	/**
	 * 描述：查询农专年报网站或网店列表(用于敏感词审核)
	 * @author yujingwei
	 * @date 2016年10月10日
	 * @param request
	 * @return List<SfcWebsiteInfo>
	 */
	public List<SfcWebsiteInfo> querySfcWebsitePage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param sfcWebsiteInfo
	 * @return
	 * @throws Exception 
	 */
	int insert(SfcWebsiteInfo sfcWebsiteInfo) throws Exception;
}