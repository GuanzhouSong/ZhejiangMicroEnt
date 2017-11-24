/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.DailyInspectResultCount;
import com.icinfo.cs.sccheck.dto.DailyInspectResultDto;
import com.icinfo.cs.sccheck.model.DailyInspectResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_daily_inspect_result 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface IDailyInspectResultService extends BaseService {

	/**
	 * 
	 * 描述：查询日常检查结果列表数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param request
	 * @return
	 */
	List<DailyInspectResultDto> queryDailyInspectResult(PageRequest request);

	/**
	 * 
	 * 描述：日常检查结果统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月3日
	 * @param request
	 * @return
	 */
	DailyInspectResultCount queryDailyInspectResultCount(PageRequest request);

	/**
	 * 描述：暂存或录入检查结果
	 * 
	 * @author baifangfang
	 * @date 2017年11月7日
	 * @param map
	 * @param sysUserDto
	 * @return
	 */
	int saveDailyInspectResult(Map<String, Object> map) throws Exception;

	/**
	 * 描述：根据uid删除暂未提交的检查对象
	 * 
	 * @author baifnagfang
	 * @date 2017年11月8日
	 * @param uid
	 * @return
	 */
	int deleteByUid(String uid);

	/**
	 * 描述：根据uid查询检查对象
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @param uid
	 * @return
	 */
	DailyInspectResult queryDailyInspectResultByUid(String uid);

	/**
	 * 描述：日常检查续录
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @param map
	 * @return
	 */
	int supplyDailyInspectResult(Map<String, Object> map) throws Exception;

	/**
	 * 
	 * 描述：日常检查记录查询列表json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月8日
	 * @param request
	 * @return
	 */
	List<DailyInspectResultDto> queryDailyInspectResultList(PageRequest request);

	/**
	 * 
	 * 描述：日常检查记录查询统计
	 * 
	 * @author baifagnfang
	 * @date 2017年11月8日
	 * @param request
	 * @return
	 */
	DailyInspectResultCount queryDailyInspectResultQueryCount(PageRequest request);
}