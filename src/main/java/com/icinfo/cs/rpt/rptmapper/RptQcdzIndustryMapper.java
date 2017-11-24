/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月27日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzIndustryDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzIndustry;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_rpt_qcdz_industry 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月27日
 */
public interface RptQcdzIndustryMapper extends Mapper<RptQcdzIndustry> {
	
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
}