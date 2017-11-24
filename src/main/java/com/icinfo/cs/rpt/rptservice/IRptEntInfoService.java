/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptEntInfoDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_rpt_yr 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月02日
 */
public interface IRptEntInfoService extends BaseService {  
	/**
	 * 
	 * 描述   查询企业信息
	 * @author 赵祥江
	 * @date 2017年8月2日 下午4:41:09 
	 * @param 
	 * @return List<RptEntInfoDto>
	 * @throws
	 */
	public List<RptEntInfoDto> selectRptEntInfoDtoCount(Map<String,Object> queryMap)throws Exception; 
	
}