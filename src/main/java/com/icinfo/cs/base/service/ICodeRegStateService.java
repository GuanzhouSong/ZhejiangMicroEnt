/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service;

import java.util.List;

import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_code_regstate 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月26日
 */
public interface ICodeRegStateService extends BaseService {
	
	/**
	 * 描述:查询存续登记状态
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	public String selectCxRegstates(String csState)throws Exception; 
	
	/**
	 * 描述:查询存续登记状态名称
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	public CodeRegState selectCsStateDesc(String regState)throws Exception; 
	
	/**
	 * 描述：查询所有状态
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	public List<CodeRegState> selectCodeRegStateList(String csState)throws Exception;
	
	/** 
	 * 描述: 查询登记状态查询条件列表
	 * @auther ZhouYan
	 * @date 2017年8月15日 
	 * @return
	 * @throws Exception 
	 */
	public List<CodeRegState> selectRegStateParamList()throws Exception;
}