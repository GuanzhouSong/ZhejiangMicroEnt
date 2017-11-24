/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年08月09日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptEntIminfoDto;
import com.icinfo.cs.rpt.rptmodel.RptEntIminfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_rpt_ent_iminfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年08月09日
 */
public interface RptEntIminfoMapper extends Mapper<RptEntIminfo> {

	/**
	 * 描述：公示信息统计
	 * 
	 * @author baifangfang
	 * @date 2017年8月9日
	 * @param searchMap
	 * @return
	 */
	List<RptEntIminfoDto> selectRptEntIminfoCount(Map<String, Object> searchMap);
}