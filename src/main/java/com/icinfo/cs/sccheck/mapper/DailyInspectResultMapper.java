/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月01日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.DailyInspectResultCount;
import com.icinfo.cs.sccheck.dto.DailyInspectResultDto;
import com.icinfo.cs.sccheck.model.DailyInspectResult;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_daily_inspect_result 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface DailyInspectResultMapper extends Mapper<DailyInspectResult> {

	/**
	 * 
	 * 描述：查询日常检查结果录入列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param params
	 * @return
	 */
	List<DailyInspectResultDto> selectDailyInspectResult(Map<String, Object> params);

	/**
	 * 
	 * 描述：日常检查结果统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param params
	 * @return
	 */
	DailyInspectResultCount selectDailyInspectResultCount(Map<String, Object> params);

	/**
	 * 
	 * 描述：查询日常检查记录查询列表
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param params
	 * @return
	 */
	List<DailyInspectResultDto> selectDailyInspectResultList(Map<String, Object> params);

	/**
	 * 描述：日常检查记录查询统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @param params
	 * @return
	 */
	DailyInspectResultCount selectDailyInspectResultQueryCount(Map<String, Object> params);
}