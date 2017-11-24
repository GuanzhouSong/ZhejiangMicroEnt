/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.util.List;

import com.icinfo.cs.sment.model.SmLog;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    sm_log 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public interface ISmLogService extends BaseService {
	/**
	 * 查询日志
	 * @author zjj
	 */
	public List<SmLog> queryPage(PageRequest request)throws Exception;
	/**
	 * 保存日志内容
	 * @author zjj
	 */
	public int save(String LogType,String LogRemark)throws Exception;
}