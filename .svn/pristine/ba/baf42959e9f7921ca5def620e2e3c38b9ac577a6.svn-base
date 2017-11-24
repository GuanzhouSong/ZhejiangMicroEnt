/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_warn_mark 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface ICsWarnMarkService extends BaseService {
	/**
	 * 获取预警标识查询
	 * 
	 * @author zjj 20161018
	 */
	public List<CsWarnMark> queryPage(PageRequest request) throws Exception;

	public int update(CsWarnMark csWarnMark) throws Exception;

	public int insert(CsWarnMark csWarnMark) throws Exception;

	/**
	 * 失效处理
	 * 
	 * @author zjj
	 * @param csWarnMark
	 * @return
	 * @throws Exception
	 */
	public int disableUpdate(CsWarnMark csWarnMark) throws Exception;

	/**
	 * 获取设置年份
	 * 
	 * @return
	 * @throws Excetion
	 */
	public List<CsWarnMark> selectCsWarnMarkSetYear() throws Exception;

	/**
	 * 获取指定标记
	 * 
	 * @author zjj 20161025
	 */
	public List<CsWarnMark> selectCsWarnMarkList(Map<String, Object> qryMap) throws Exception;

}