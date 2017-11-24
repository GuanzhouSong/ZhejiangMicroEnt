/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.LimitwordDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_limitword 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
public interface ILimitwordService extends BaseService {

	/**
	 * 描述：根据查询条件查询关键字是否存在于限制搜索表里面
	 * @author baifangfang
	 * @date 2016年11月4日
	 * @param queryMap
	 * @return
	 */
	List<LimitwordDto> queryListResult(Map<String, Object> queryMap);
}