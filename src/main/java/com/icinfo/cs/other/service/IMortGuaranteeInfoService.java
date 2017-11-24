/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.List;

import com.icinfo.cs.other.model.MortGuaranteeInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_mort_guarantee_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IMortGuaranteeInfoService extends BaseService {
	
	/** 
	 * 描述: 根据订单号查询抵押物信息
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param orderNO
	 * @return
	 * @throws Exception 
	 */
	List<MortGuaranteeInfo> doGetMortGuaranteeInfoList(String orderNO) throws Exception;
}