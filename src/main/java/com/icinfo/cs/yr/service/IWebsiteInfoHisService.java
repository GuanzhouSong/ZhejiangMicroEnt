/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.WebsiteInfoHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_websiteinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IWebsiteInfoHisService extends BaseService {

	/**
	 * 
	 * 描述             : 根据年报ID分页查询 公示 网站网店历史信息
	 * @author: 赵祥江
	 * @date  : 2016年9月10日 上午9:18:11 
	 * @param : anCheID:年报ID
	 * @return: List<SubcapitalHis>
	 * @throws
	 */
	public List<WebsiteInfoHis> queryPage(PageRequest request) throws Exception;
	
	/** 
	 * 描述: 保存公示网站历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param websiteInfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(WebsiteInfoHis websiteInfoHis)throws Exception;
			
	/**	
	 * 
	 * 描述   根据年报ID和年报编码获取历史信息
	 * @author 赵祥江
	 * @date 2016年9月26日 下午7:26:52 
	 * @param 
	 * @return List<WebsiteInfoHis>
	 * @throws
	 */
	public List<WebsiteInfoHis> selectWebsiteInfoHisByAnCheIDAndReportNo(String anCheID,String reportNo) throws Exception;		
}