/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月25日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzZtQsDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzZtcountDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtQs;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_rpt_qcdz_ztqs 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface RptQcdzZtQsMapper extends Mapper<RptQcdzZtQs> {
	
	/**
	 * 
	 * 描述: 大屏可视化--图一（当年新设消亡月趋势）
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzZtQsDto> selectRptQcdzZtQsList(Map<String, Object> map)throws Exception;
}