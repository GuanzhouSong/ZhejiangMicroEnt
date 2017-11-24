/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.CodeExpertTypeDto;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_expert_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface ICodeExpertTypeService extends BaseService {
	
	/**
	 * 描述：根据职能部门查询专家组长类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CodeExpertType> selectListByParams(Map<String,Object> params)throws Exception;

	/**
	 * 描述：根据专家组长名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param expertName
	 * @param dutyDeptCodes
	 * @return
	 */
	public CodeExpertType selectByName(String expertName, String dutyDeptCodes);

	/**
	 * 查询专家组长类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	public List<CodeExpertTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception;

	/**
	 * 描述：查询专家组长类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	public CodeExpertType selectByUid(String uid);

	/**
	 * 描述：保存专家组长类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeExpertType
	 * @return
	 */
	public AjaxResult saveCodeExpertType(CodeExpertType codeExpertType)throws Exception; 
	
	 /**
     * 
     * 描述: 查询树状结构展示
     * @auther chenxin
     * @date 2017年10月18日 
     * @param param
     * @return
     */
	public List<Map<String,Object>> selectToTreeMap(Map<String,Object> param);
}