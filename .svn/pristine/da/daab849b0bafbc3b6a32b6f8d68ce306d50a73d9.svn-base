/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.DeptPubInfoRptDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_rpt_public_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
public interface IDeptPubInfoRptService extends BaseService {
	
	/** 
	 * 描述: 查询部门公示信息统计
	 * @auther ZhouYan
	 * @date 2017年8月10日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<DeptPubInfoRptDto> selectDeptPubInfoRpt(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述   可视化企业信用信息公示统计
	 * @author 赵祥江
	 * @date 2017年8月17日 上午9:11:05 
	 * @param 
	 * @return List<DeptPubInfoRptDto>
	 * @throws
	 */
	public List<DeptPubInfoRptDto> selectDeptPubInfoSituationRpt(Map<String,Object> parmMap) throws Exception;
	
	/**
	 * 
	 * 描述:大屏可视化 图6监管动态 
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<DeptPubInfoRptDto> selectRptPublicInfoList(Map<String,Object> map) throws Exception;
	
}