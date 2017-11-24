/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;

import com.icinfo.cs.rpt.rptdto.RptSmImportDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_sm_import 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月05日
 */
public interface IRptSmImportService extends BaseService {
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmImportDto> selectRptSmImportCount(PageRequest request) throws Exception ;
}