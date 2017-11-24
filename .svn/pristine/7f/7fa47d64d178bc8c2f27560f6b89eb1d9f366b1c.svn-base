/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;

import com.icinfo.cs.system.model.SysVersion;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_version 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月23日
 */
public interface ISysVersionService extends BaseService {
	/**
	 * 描述: 获取版本列表list数据
     * @auther chenxin
     * @date 2016年09月23日 
	 * @param request
	 * @return
	 */
	public List<SysVersion> queryPage(PageRequest request);
	
	/**
	 * 
	 * 描述: 查询系统版本详细信息
	 * @auther chenxin
	 * @date 2016年9月23日 
	 * @param id
	 * @return SysVersion
	 */
	public SysVersion selectSysVersionById(int id);
	
	/**
	 * 描述：修改版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	int update(SysVersion sysVersion);

	/**
	 * 描述：添加版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	int insert(SysVersion sysVersion);

	/**
	 * 描述：删除版本详细信息
	 * @author chenxin
	 * @date 2016年9月24日
	 * @param sysVersion
	 * @return
	 */
	int deleteById(Integer sysVersionId);
}