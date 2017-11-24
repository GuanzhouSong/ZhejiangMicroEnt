/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.PbWebsiteinfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pb_websiteinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月28日
 */
public interface IPbWebsiteinfoHisService extends BaseService {
	/**
	 * 
	 * 描述   根据年报ID和年报提交编号查询网站网店历史信息 个体户
	 * @author 赵祥江
	 * @date 2016年9月28日 下午8:48:42 
	 * @param 
	 * @return List<PbWebsiteinfoHis>
	 * @throws
	 */ 
	public List<PbWebsiteinfoHis> selectPbWebsiteinfoHisByAnCheIdAndReportNo(
			String anCheID, String reportNo) throws Exception;
	
	/** 
	 * 描述: 保存公示网站历史记录
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param pbWebsiteinfoHis
	 * @return
	 * @throws Exception 
	 */
	public int insert(PbWebsiteinfoHis pbWebsiteinfoHis)throws Exception;
}