/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.WebsiteInfoDto;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_websiteinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IWebsiteInfoService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 网站网店信息
	 * @author: 赵祥江
	 * @date  : 2016年9月9日 下午3:55:12 
	 * @param : anCheID:年报ID
	 * @return: List<WebsiteInfo>
	 * @throws
	 */
	public List<WebsiteInfo> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述             : 根据年报ID 获取网店网站
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午2:02:00 
	 * @param :
	 * @return: List<WebsiteInfo>
	 * @throws
	 */
	public List<WebsiteInfo> selectWebsiteInfoByAnCheID(String anCheID) throws Exception;
	
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
	 * 描述: 公示侧网站展示（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<WebsiteInfoDto> queryPageForPub(PageRequest request) throws Exception;

	/**
	 * 描述：根据年报id查询网站列表
	 * @author
	 * @date 2016年10月26日
	 * @param anCheID
	 * @return
	 */
	public List<WebsiteInfoDto> queryListResult(String anCheID);
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年11月11日 
	 * @param websiteInfo
	 * @return
	 * @throws Exception 
	 */
	public int insert(WebsiteInfo websiteInfo)throws Exception;
}