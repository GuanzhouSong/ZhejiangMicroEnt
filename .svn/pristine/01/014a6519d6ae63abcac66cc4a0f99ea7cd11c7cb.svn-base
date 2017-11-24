/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrSfcWebsiteInfo;
import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_sfc_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
public interface IYrSfcWebsiteInfoService extends BaseService {


	/**
	 * 新增
	 * @param yrSfcWebsiteInfo
	 * @return
	 */
	int insert(YrSfcWebsiteInfo yrSfcWebsiteInfo);

	/**
	 *
	 * 描述: 单个网站信息（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日
	 * @param webID
	 * @return
	 */
	public YrSfcWebsiteInfo selectOneByWebId(String webID);

	/**
	 * 根据当前年份和主体身份代码查询网站网店列表
	 *@autor：wangjin
	 * @param
	 * @param
	 * @return
	 */
	List<YrSfcWebsiteInfo> selectByYearAndPriPID(Integer year, String priPID);

	/**
	 * 根据webid 删除
	 * @param webid
	 * @return
	 */
	int deleteByWebidwebid(String webid, String priPID);

	/**
	 * 描述：根据传入的参数 清空当前对象
	 */
	int deleteAll(YrSfcWebsiteInfo yrSfcWebsiteInfo);

	/**
	 *
	 * 描述: 根据年报id查农专网站信息（无分页）
	 * @auther gaojinling
	 * @date 2016年9月11日
	 * @param
	 * @param
	 * @return
	 */
	public List<YrSfcWebsiteInfo> selectSfcWebsiteListByanCheID(String anCheID) throws Exception;

	//TODO ---------------------------- 分割线-----------------------------





	
	/**
	 * 
	 * 描述: 根据年份和主体代码分页查询农专社网站信息（年报id）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrSfcWebsiteInfo> queryPageByAnCheID(PageRequest request) throws Exception;
	

	
		
	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public int saveYrSfcWebsiteInfo(YrSfcWebsiteInfo yrSfcWebsiteInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public int updateYrSfcWebsiteInfo(YrSfcWebsiteInfo yrSfcWebsiteInfo) throws Exception ;
	
	/**
	 * 
	 * 描述: 批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param webIds
	 * @throws Exception
	 */
	public int deleteYrSfcWebsiteInfoRtn(String webIds) throws Exception ;
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2017年02月15日 
	 * @param webId
	 * @throws Exception
	 */
	public int deleteByWebID(String webId) throws Exception ;



}