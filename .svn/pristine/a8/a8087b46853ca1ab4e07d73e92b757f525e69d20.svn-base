/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
/**
 * 描述:    cs_yr_pb_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface IYrPbWebsiteInfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据年报id查询个体户网站信息（无分页） 
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param
	 * @param
	 * @return
	 */
	public List<YrPbWebsiteInfo> selectPbWebsiteListByanCheID(String anCheID) throws Exception;
	
	/**
	 * 
	 * 描述: 根据年份和主体代码分页查询个体户网站信息（年报id）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrPbWebsiteInfo> queryPageByAnCheID(PageRequest request) throws Exception;
	

	
		
	/**
	 * 
	 * 描述: 添加（单个）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	public int saveYrPbWebsiteInfo(YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 更新（单个）
	 * @auther gaojinling
	 * @date 2016年9月24日 
	 * @param yrPbWebsiteInfo
	 * @return
	 * @throws Exception
	 */
	public int updateYrPbWebsiteInfo(YrPbWebsiteInfo yrPbWebsiteInfo) throws Exception ;
	
	/**
	 * 
	 * 描述: 批量删除（通过主键）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param webIds
	 * @throws Exception
	 */
	public int deleteYrPbWebsiteInfoRtn(String webIds) throws Exception ;
	
	/**
	 * 
	 * 描述: 删除
	 * @auther chenxin
	 * @date 2017年02月14日 
	 * @param webId
	 * @throws Exception
	 */
	public int deleteByWebID(String webId) throws Exception ;
	
	/**
	 * 
	 * 描述: 删除所有
	 * @auther chenxin
	 * @date 2017年02月27日 
	 * @param anCheID
	 * @throws Exception
	 */
	public int deleteByAnCheID(String anCheID) throws Exception ;


	// -----------------------------------------网站网店 修改第三版本   start-------------------------------------------

	/**
	 *
	 * 描述: 单个网站信息（主键查询）
	 * @auther gaojinling
	 * @date 2016年9月24日
	 * @param webID
	 * @return
	 */
	public YrPbWebsiteInfo selectOneByWebId(String webID);

	/**
	 * 描述：插入一条网站网店信息
	 * @param yrPbWebsiteInfo
	 * @return
     */
	int insert(YrPbWebsiteInfo yrPbWebsiteInfo);

	/**
	 * 描述：获取网站网店类列表
	 * @param anCheID
	 * @return
     */
	List<YrPbWebsiteInfo> selectByAnCheID(String anCheID);

	/**
	 * 描述：清空当前网站网店的所有数据
	 * @param yrWebsiteInfo
	 * @return
     */
	int deleteAll(YrPbWebsiteInfo yrWebsiteInfo);

	// -----------------------------------------网站网店 修改第三版本   end-------------------------------------------

}