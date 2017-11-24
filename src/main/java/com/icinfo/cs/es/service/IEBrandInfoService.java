/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.es.service;

import java.util.List;

import com.icinfo.cs.es.model.CsBrandInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    e_brand_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月06日
 */
public interface IEBrandInfoService extends BaseService {

	/**
	 * 描述：通过priPID查询企业商标信息
	 * @author chenyu
	 * @data 2016-10-31
	 * @param request
	 * @return PubJusticeInfo
	 * @throws Exception
	 */
	public List<CsBrandInfo> selectCsBrandInfoListByPriPID(PageRequest request) throws Exception;

	
}