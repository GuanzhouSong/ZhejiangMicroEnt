/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.CodeSpecialTypeDto;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_special_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
public interface ICodeSpecialTypeService extends BaseService {
	/**
	 * 描述：根据职能部门查询专项库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CodeSpecialType> selectListByParams(Map<String,Object> params)throws Exception;

	/**
	 * 描述：根据专项库名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param specialName
	 * @param dutyDeptCodes
	 * @return
	 */
	public CodeSpecialType selectByName(String specialName, String dutyDeptCodes);

	/**
	 * 查询列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	public List<CodeSpecialTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception;

	/**
	 * 描述：查询专项库类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	public CodeSpecialType selectByUid(String uid);

	/**
	 * 描述：保存专项库类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeSpecialType
	 * @return
	 */
	public AjaxResult saveCodeSpecialType(CodeSpecialType codeSpecialType)throws Exception; 
	
	
}