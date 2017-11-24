/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.base.model.CsMidLerep;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_mid_lerep 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月11日
 */
public interface ICsMidLerepService extends BaseService {
	
	public List<CsMidLerep> selectMidLerepList(Map<String, Object> qryMap) throws Exception;
}