/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;

import com.icinfo.cs.rpt.rptdto.RptSmEntInfoAllDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    rpt_sm_ent_info_all 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月09日
 */
public interface IRptSmEntInfoAllService extends BaseService {
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptSmNormalCount(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述:小微检测登记信息统计（普通统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmNormalTotal() throws Exception ;
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptImportCount(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述:小微检测登记信息统计（重点统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmImportTotal()
			throws Exception ;
	
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计省局账户（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptSmNormalsjCount(PageRequest request) throws Exception ;
	
	
	/**
	 * 
	 * 描述:小微检测登记信息统计省局账户（普通统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmNormalsjTotal() throws Exception;
	
	
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计省局账户（重点统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmEntInfoAllDto> selectRptImportsjCount(PageRequest request) throws Exception ;
	
	/**
	 * 
	 * 描述:小微检测登记信息统计省局账户（重点统计条数） 
	 * @auther gaojinling
	 * @date 2017年5月23日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectRptSmImportsjTotal() throws Exception;
}