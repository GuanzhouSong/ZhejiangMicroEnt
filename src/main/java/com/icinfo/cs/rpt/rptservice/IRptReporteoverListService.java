/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import com.icinfo.cs.rpt.rptdto.RptReporteoverListDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_rpt_reporteover_list 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月15日
 */
public interface IRptReporteoverListService extends BaseService {
	
	/**
	 * 
	 * 描述: 首页统计（年报逾期未报详细列表）
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageResponse<RptReporteoverListDto> selectRptOptoExpiredList(PageRequest request)throws Exception;
}