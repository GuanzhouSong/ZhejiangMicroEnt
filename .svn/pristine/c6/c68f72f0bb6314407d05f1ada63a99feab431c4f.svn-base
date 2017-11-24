/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzIndustryDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzIndustry;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_rpt_qcdz_industry 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月27日
 */
public interface IRptQcdzIndustryService extends BaseService {
	
	/**
	 * 
	 * 描述: 大屏可视化 -- 图5投资分布   法人自然人股东行业占比
	 * @auther gaojinling
	 * @date 2017年9月27日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzIndustryDto> selectRptQcdzIndustryList(Map<String, Object> map) throws Exception;
	
	public int save(RptQcdzIndustry rptQcdzIndustry) throws Exception;
	
	/**
	 * 
	 * 描述: 删除(根据type和name删除)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete(String invtype) throws Exception;
}