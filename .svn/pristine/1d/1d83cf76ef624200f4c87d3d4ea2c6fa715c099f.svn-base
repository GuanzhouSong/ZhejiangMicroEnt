/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service;

import java.util.List;

import com.icinfo.cs.es.model.CsMortEstateInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mort_estate_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
public interface ICsMortEstateInfoService extends BaseService {

	/**
	 * 根据priPID获取企业不动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	List<CsMortEstateInfo> selectCsMortEstateInfoListByPriPID(PageRequest request);

	/**
	 * 根据cerNO获取个人不动产抵押信息
	 * 
	 * @author chenyu
	 * @return
	 * @throws Exception 
	 */
	List<CsMortEstateInfo> selectCsMortEstateInfoListByCerNO(PageRequest request);
}