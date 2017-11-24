/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import com.icinfo.cs.base.model.CsQuartzJob;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_quartz_job 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月20日
 */
public interface ICsQuartzJobService extends BaseService {
	/**
	 * 插入定时任务对象
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public int insert(String jobName) throws Exception;
	
	
	/**
	 * 检查定时任务当天是否已经执行
	 * 
	 * @author zhuyong
	 * @date 2016-12-20
	 */
	public boolean checkJobIsExecute(String jobName) throws Exception;
}