package com.icinfo.cs.quartz.service;

import com.icinfo.framework.core.service.BaseService;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 个体户经营异常定时
 * @author: 赵祥江 
 * @date: 2016年12月20日 下午3:29:47
 * @version: V1.0  
 */
public interface IPubPbopanomalyIsIndividQuartzJobService extends BaseService{
	

	/**
	 * 
	 * 描述: 个体户转为企业之前涉及有经营异常信息的，在转为企业后，原有的经营异常信息不再归集于该企业名下进行展示与警示。
     *    所有个体户的经营异常状态在转企后由系统自动处理为“个转企，自动移出”
	 * @auther gaojinling
	 * @date 2017年1月16日 
	 * @return
	 * @throws Exception
	 */
    public String pbopanomalyIsIndividQuartzJob() throws Exception;
}
