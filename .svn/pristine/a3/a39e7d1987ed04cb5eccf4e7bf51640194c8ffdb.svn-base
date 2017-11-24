/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.CodeSpecialTypeDto;
import com.icinfo.cs.sccheck.mapper.CodeSpecialTypeMapper;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.sccheck.service.ICodeSpecialTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_special_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
@Service
public class CodeSpecialTypeServiceImpl extends MyBatisServiceSupport implements ICodeSpecialTypeService {
	
	@Autowired
	private CodeSpecialTypeMapper codeSpecialTypeMapper;
	
	/**
	 * 描述：根据职能部门查询专项库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CodeSpecialType> selectListByParams(Map<String,Object> params)throws Exception {
		return codeSpecialTypeMapper.selectListByParams(params);
	}
	
	/**
	 * 描述：根据专项库名称查找相应的专项库信息
	 * @param trim
	 * @param dutyDeptCodes
	 * @return
	 */
	@Override
	public CodeSpecialType selectByName(String specialName, String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isVlid", "1");
		params.put("specialName", specialName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<CodeSpecialType> codeSpecialTypeList = codeSpecialTypeMapper.selectListByParams(params);
		if(CollectionUtils.isEmpty(codeSpecialTypeList)){
			return null;
		}
		return codeSpecialTypeList.get(0);
	}
	
	/**
	 * 查询列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public List<CodeSpecialTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception {
		String dutyDeptCodes = sysUserDto.getDutyDeptCodes();
		if(StringUtils.isEmpty(dutyDeptCodes)){
			return null;
		}
		Map<String,Object> params = request.getParams();
		if(params == null){
			params = new HashMap<String,Object>();
		}
		StringUtil.paramTrim(params);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return codeSpecialTypeMapper.selectByParams(params);
	}
	
	/**
	 * 描述：查询专项库类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	@Override
	public CodeSpecialType selectByUid(String uid) {
		CodeSpecialType codeSpecialType = new CodeSpecialType();
		codeSpecialType.setUid(uid);
		return codeSpecialTypeMapper.selectOne(codeSpecialType);
	}
	
	/**
	 * 描述：保存专项库类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeSpecialType
	 * @return
	 */
	@Override
	public AjaxResult saveCodeSpecialType(CodeSpecialType codeSpecialType)throws Exception {
		if(StringUtils.isEmpty(codeSpecialType.getDutyDeptCode())){
			return AjaxResult.error("该账号未设置职能部门，请联系管理员");
		}
		if(checkRepeat(codeSpecialType)){
			return AjaxResult.error("专项库名称重复，请输入新的专项库名称");
		}
		String dutyDeptCode = codeSpecialType.getDutyDeptCode();
		if(StringUtils.isEmpty(codeSpecialType.getSpecialCode())){
			String specialCode = codeSpecialTypeMapper.selectMaxSpecialCode(dutyDeptCode);
			if(StringUtils.isEmpty(specialCode)){
				specialCode = dutyDeptCode+"-1";
			}else{
				String num = specialCode.split("-")[1];
				specialCode = dutyDeptCode+"-"+(Integer.parseInt(num)+1);
			}
			codeSpecialType.setSpecialCode(specialCode);
		}
		if(StringUtils.isEmpty(codeSpecialType.getUid())){
			if(codeSpecialTypeMapper.insertSelective(codeSpecialType) > 0){
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}else{
			Example example = new Example(CodeSpecialType.class);
			example.createCriteria().andEqualTo("uid", codeSpecialType.getUid()); 
			if(codeSpecialTypeMapper.updateByExample(codeSpecialType, example) > 0){
				return AjaxResult.success("修改成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}
	}
	
	/**
	 * 描述：保存专项库名称是否重复
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param dutyDeptCode
	 * @param specialName
	 * @param flag
	 * @return
	 */
	private boolean checkRepeat(CodeSpecialType codeSpecialType){
		Example example = new Example(CodeSpecialType.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("dutyDeptCode", codeSpecialType.getDutyDeptCode())
				.andEqualTo("specialName", codeSpecialType.getSpecialName());
		if(StringUtils.isNotEmpty(codeSpecialType.getUid())){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", codeSpecialType.getUid());
		}
		if(codeSpecialTypeMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
}