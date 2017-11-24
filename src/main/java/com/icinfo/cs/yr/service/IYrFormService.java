/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_yr_form 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月13日
 */
public interface IYrFormService extends BaseService {
	/** 
	 * 描述: 查询当年度表单填写情况
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	YrForm selectYrFormByPripidAndYear(String priPID, Integer year) throws Exception;
	
	/** 
	 * 描述: 初始化当年度表单填写情况
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	int insert(String priPID, Integer year, List<String> reportTypeList) throws Exception;


	/**
	 * 更新Form表单状态
	 * @autor: wangjin
	 * @param yrForm
	 * @return
	 */
	int updateForm(YrForm yrForm);





	
	/**
	 * 
	 * 描述             : 根据年度和主体代码更新表单填写情况
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 下午8:35:22 
	 * @param :
	 * @return: YrForm
	 * @throws
	 */
	public  int  updateYrFormByPripidAndYear(YrForm yrForm) throws Exception;
	
	/** 
	 * 描述: 判断报表是否都已填报
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param priPID
	 * @param year
	 * @param reportTypeList
	 * @return
	 * @throws Exception 
	 */
	boolean doCheckAllForm(String priPID, Integer year, List<String> reportTypeList) throws Exception;


}