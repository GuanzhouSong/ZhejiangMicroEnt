/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.CodePositionTypeDto;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_position_type 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface ICodePositionTypeService extends BaseService {
	
	/**
	 * 描述：根据职能部门查询人员岗位大类类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<CodePositionType> selectListByParams(Map<String,Object> params)throws Exception;

	/**
	 * 描述：根据人员岗位大类类别名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param specialName
	 * @param dutyDeptCodes
	 * @return
	 */
	public CodePositionType selectByName(String positionName, String dutyDeptCodes);

	/**
	 * 查询人员岗位大类类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	public List<CodePositionTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception;

	/**
	 * 描述：查询人员岗位大类类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	public CodePositionType selectByUid(String uid);

	/**
	 * 描述：保存人员岗位大类类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeSpecialType
	 * @return
	 */
	public AjaxResult saveCodePositionType(CodePositionType codePositionType)throws Exception; 
	
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