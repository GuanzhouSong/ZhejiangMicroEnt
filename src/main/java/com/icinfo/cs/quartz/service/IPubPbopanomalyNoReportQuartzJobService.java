package com.icinfo.cs.quartz.service;

import com.icinfo.framework.core.service.BaseService;

/**
 * 
 * 描述:  个体户未按时年报列入异常
 * @author: 赵祥江
 * @date: 2017年6月28日 下午2:46:17
 */
public interface IPubPbopanomalyNoReportQuartzJobService extends BaseService{
	

	/**
	 * 
	 * 描述   个体户未按时年报列入异常
	 * @author 赵祥江
	 * @date 2017年6月28日 下午2:46:41 
	 * @param 
	 * @return String
	 * @throws
	 */
    public String pbopanomalyNoReportQuartzJob() throws Exception;
}
