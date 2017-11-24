/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service;

import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_warn_dept 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月21日
 */
public interface ICsWarnDeptService extends BaseService {
	/**
	 * 指定部门插入关联表
	 * @author zjj
	 * 20161021
	 */
	public void insertDept(CsWarnMark csWarnMark,String type) throws Exception;
}