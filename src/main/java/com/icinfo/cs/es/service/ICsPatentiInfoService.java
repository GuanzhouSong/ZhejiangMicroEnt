/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service;

import java.util.List;

import com.icinfo.cs.es.model.CsPatentiInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_patentinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
public interface ICsPatentiInfoService extends BaseService {

	/**
	 * 根据priPID获取企业专利信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	List<CsPatentiInfo> selectCsPatentiInfoListByPriPID(PageRequest request);
}