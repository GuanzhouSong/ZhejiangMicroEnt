/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.es.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.es.dto.CsMidPersonDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_person 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月06日
 */
public interface ICsMidPersonService extends BaseService {
	
	/**
	 * 获取人员信息列表
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsMidPersonDto> queryList(Map<String,Object> map) throws Exception;
	
	/**
	 * 根据条件获取人员信息列表
	 * @param keyword
	 * @param sex
	 * @param dictCode
	 * @return
	 */
	public List<CsMidPersonDto> queryList(String keyword,String sex,String dictCode)throws Exception;
	
	/**
	 * 获取人员信息列表-总数
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Long selectPersonListCount(String keyword,String sex,String dictCode) throws Exception;
	
	/** 
	 * 描述: 根据类型、人员身份证获取人员企业列表
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param type
	 * @param cerNo
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	public List<CsMidPersonDto>  selectPersonEntPageList(String type,String cerNo,PageRequest request) throws Exception;
	

	
}