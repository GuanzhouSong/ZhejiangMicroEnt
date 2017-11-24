/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.model.MidBaseinfoDel;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_mid_baseinfo_del 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月26日
 */
public interface IMidBaseinfoDelService extends BaseService {

	/**
	 * 描述：查询列表
	 * @author baifangfang
	 * @date 2017年9月26日
	 * @return
	 */
	List<MidBaseinfoDel> selectMidBaseinfoDelList();
}