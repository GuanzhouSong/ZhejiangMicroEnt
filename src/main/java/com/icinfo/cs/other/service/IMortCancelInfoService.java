/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import com.icinfo.cs.other.model.MortCancelInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_mort_cancel_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IMortCancelInfoService extends BaseService {
	
	/** 
	 * 描述: 根据原始抵押登记编号查询注销信息
	 * @auther ZhouYan
	 * @date 2016年10月27日 
	 * @param oriFilingNO
	 * @return
	 * @throws Exception 
	 */
	MortCancelInfo doGetMortCancelInfo(String oriFilingNO) throws Exception;
}