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
import com.icinfo.cs.sccheck.dto.CodeMarkTypeDto;
import com.icinfo.cs.sccheck.mapper.CodeMarkTypeMapper;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.cs.sccheck.service.ICodeMarkTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_mark_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
@Service
public class CodeMarkTypeServiceImpl extends MyBatisServiceSupport implements ICodeMarkTypeService {

	@Autowired
	private CodeMarkTypeMapper codeMarkTypeMapper;
	
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
	public List<CodeMarkType> selectListByParams(Map<String, Object> params) throws Exception {
		return codeMarkTypeMapper.selectListByParams(params);
	}
	
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
	@Override
	public CodeMarkType selectByName(String specialCode, String markName,String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isVlid", "1");
		params.put("specialCode", specialCode);
		params.put("markName", markName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<CodeMarkType> codeMarkTypeList = codeMarkTypeMapper.selectListByParams(params);
		if(CollectionUtils.isEmpty(codeMarkTypeList)){
			return null;
		}
		return codeMarkTypeList.get(0);
	}
	
	/**
	 * 描述：分页查询标签库列表
	 * 
	 * @author chenxin
	 * @date 2017-09-22
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public List<CodeMarkTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto)throws Exception {
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
		return codeMarkTypeMapper.selectByParams(params);
	}
	
	/**
	 * 描述：根据uid查询详情
	 * 
	 * @author chenxin
	 * @date 2017-09-22 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@Override
	public CodeMarkType selectByUid(String uid) throws Exception {
		CodeMarkType codeMarkType = new CodeMarkType();
		codeMarkType.setUid(uid);
		return codeMarkTypeMapper.selectOne(codeMarkType);
	}
	
	/**
	 * 描述：保存或更新
	 * 
	 * @author chenxin
	 * @date 2017-09-22 
	 * @param codeMarkType
	 * @return
	 * @throws Exception
	 */
	@Override
	public AjaxResult saveCodeMarkType(CodeMarkType codeMarkType)throws Exception {
		if(StringUtils.isEmpty(codeMarkType.getDutyDeptCode())){
			return AjaxResult.error("该账号未设置职能部门，请联系管理员");
		}
		if(checkRepeat(codeMarkType)){
			return AjaxResult.error("监管标签名称重复，请输入新的专项库名称");
		}
		String dutyDeptCode = codeMarkType.getDutyDeptCode();
		if(StringUtils.isEmpty(codeMarkType.getMarkCode())){
			String markCode = codeMarkTypeMapper.selectMaxMarkCode(dutyDeptCode);
			if(StringUtils.isEmpty(markCode)){
				markCode = dutyDeptCode+"-1";
			}else{
				String num = markCode.split("-")[1];
				markCode = dutyDeptCode+"-"+(Integer.parseInt(num)+1);
			}
			codeMarkType.setMarkCode(markCode);
		}
		if(StringUtils.isEmpty(codeMarkType.getUid())){
			if(codeMarkTypeMapper.insertSelective(codeMarkType) > 0){
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}else{
			Example example = new Example(CodeMarkType.class);
			example.createCriteria().andEqualTo("uid", codeMarkType.getUid()); 
			if(codeMarkTypeMapper.updateByExample(codeMarkType, example) > 0){
				return AjaxResult.success("修改成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}
	}

	/**
	 * 描述：查询是否重复
	 * 
	 * @author chenxin
	 * @date 2017-09-22 
	 * @param codeMarkType
	 * @return
	 */
	private boolean checkRepeat(CodeMarkType codeMarkType) {
		Example example = new Example(DrandomSpecialEnt.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("dutyDeptCode", codeMarkType.getDutyDeptCode())
				.andEqualTo("markName", codeMarkType.getMarkName());
		if(StringUtils.isNotEmpty(codeMarkType.getUid())){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", codeMarkType.getUid());
		}
		if(codeMarkTypeMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
}