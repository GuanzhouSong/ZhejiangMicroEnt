/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.YrRptDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_yr 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
public interface IYrRptService extends BaseService {
	
	/**
	 * 
	 * 描述: 年报进度统计
	 * @auther gaojinling
	 * @date 2017年1月18日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<YrRptDto> selectRptYrCount(PageRequest request) throws Exception ;
	
	
	/**
	 * 
	 * 描述   根据年报年度和企业类型获取企业年度报告情况
	 * @author 赵祥江
	 * @date 2017年7月24日 上午10:58:54 
	 * @param 
	 * @return List<YrRptDto>
	 * @throws
	 */
	public List<YrRptDto> selectEntReportDataCount(Map<String,Object> queryMap)throws Exception; 
	
}