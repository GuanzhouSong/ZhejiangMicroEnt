/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.CodeMarkTypeDto;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_mark_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
public interface ICodeMarkTypeService extends BaseService {
	/**
	 * 描述：根据职能部门查询专项库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param DutyDeptCode
	 * @return
	 * @throws Exception
	 */
	public List<CodeMarkType> selectListByParams(Map<String,Object> params)throws Exception;

	/**
	 * 描述：根据监管标签查询相应的标签信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param specialCode
	 * @param markName
	 * @param dutyDeptCodes
	 * @return
	 */
	public CodeMarkType selectByName(String specialCode, String markName,String dutyDeptCodes);

	/**
	 * 描述：分页查询标签库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	public List<CodeMarkTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception;

	/**
	 * 描述：根据uid查询详情
	 * 
	 * @author chenxin
	 * @date 2017-09-22 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public CodeMarkType selectByUid(String uid)throws Exception;

	/**
	 * 描述：保存或更新
	 * 
	 * @author chenxin
	 * @date 2017-09-22 
	 * @param codeMarkType
	 * @return
	 * @throws Exception
	 */
	public AjaxResult saveCodeMarkType(CodeMarkType codeMarkType)throws Exception; 
}