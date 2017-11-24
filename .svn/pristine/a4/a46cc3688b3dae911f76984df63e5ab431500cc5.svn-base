/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrWebsiteInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
public interface IYrWebsiteInfoService extends BaseService {




	/**
	 * 新增
	 * @param yrWebsiteInfo
	 * @return
	 */
	int insert(YrWebsiteInfo yrWebsiteInfo);

	/**
	 * 更新
	 * @param yrWebsiteInfo
	 * @return
	 */
	int update(YrWebsiteInfo yrWebsiteInfo);

	/**
	 * 根据webid 删除
	 * @param webid
	 * @return
	 */
	int deleteByWebidwebid(String webid,String priPID);


	/**
	 * 根据当前年份和主体身份代码查询网站网店列表
	 *@autor：wangjin
	 * @param integer
	 * @param pripid
	 * @return
	 */
	List<YrWebsiteInfo> selectByYearAndPriPID(Integer integer, String pripid);

	/**
	 * 描述：根据传入的参数 清空当前对象
	 */
	int deleteAll(YrWebsiteInfo yrWebsiteInfo);

	/**
	 *
	 * 描述: 根据webId查询
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午8:36:15
	 * @param :
	 * @return: int
	 * @throws
	 */
	public YrWebsiteInfo  selectYrWebsiteInfoByWebId(String  webId)throws Exception;


	
	
	/**
	 * 
	 * 描述             : 根据年度和主体代码分页查询网站网店信息    （年报预览，内部序号加密 by ZhouYan 2016-9-24 08:57:24）
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 上午10:26:49 
	 * @param :
	 * @return: List<YrWebsiteInfo>
	 * @throws
	 */
	public List<YrWebsiteInfo> queryPagePreview(PageRequest request) throws Exception;


	
	//TODO 以下代码暂未用到

	/**
	 * 
	 * 描述             : 根据年度和主体代码查询网站网店信息(不分页)
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 上午10:26:49 
	 * @param :
	 * @return: List<YrWebsiteInfo>
	 * @throws
	 */
	public List<YrWebsiteInfo>  selectYrWebsiteInfoByPriPIDAndYear(String priPID,int year) throws Exception;

	/**
	 * 
	 * 描述             : 新增
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午8:35:05 
	 * @param :
	 * @return: int
	 * @throws
	 */
	public int  insertYrWebsiteInfo(YrWebsiteInfo yrWebsiteInfo)throws Exception;
	
	/**
	 * 
	 * 描述             : 根据
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午8:36:15 
	 * @param :
	 * @return: int
	 * @throws
	 */
	public int  updateYrWebsiteInfoByWebId(YrWebsiteInfo yrWebsiteInfo)throws Exception;
	
	
	

	
	/**
	 * 
	 * 描述             : 根据webId删除
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 上午10:17:29 
	 * @param :
	 * @return: int
	 * @throws
	 */
	public int  deleteYrWebsiteInfoByWebId(String  webId)throws Exception;



}