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
import com.icinfo.cs.sccheck.dto.CodeExpertTypeDto;
import com.icinfo.cs.sccheck.mapper.CodeExpertTypeMapper;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_expert_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class CodeExpertTypeServiceImpl extends MyBatisServiceSupport implements ICodeExpertTypeService {
	
	@Autowired
	private CodeExpertTypeMapper codeExpertTypeMapper;
	
	/**
	 * 查询专家组长类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public List<CodeExpertTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto) throws Exception {
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
		return codeExpertTypeMapper.selectByParams(params);
	}
	
	/**
	 * 描述：保存专家组长类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeExpertType
	 * @return
	 */
	@Override
	public AjaxResult saveCodeExpertType(CodeExpertType codeExpertType)throws Exception {
		if(StringUtils.isEmpty(codeExpertType.getDutyDeptCode())){
			return AjaxResult.error("该账号未设置职能部门，请联系管理员");
		}
		if(checkRepeat(codeExpertType)){
			return AjaxResult.error("专家组长类别名称重复");
		}
		String dutyDeptCode = codeExpertType.getDutyDeptCode();
		if(StringUtils.isEmpty(codeExpertType.getExpertCode())){
			String expertCode = codeExpertTypeMapper.selectMaxCode(dutyDeptCode);
			if(StringUtils.isEmpty(expertCode)){
				expertCode = dutyDeptCode+"-001";
			}else{
				String num = expertCode.split("-")[1];
				expertCode = dutyDeptCode+"-"+StringUtil.addZero((Integer.parseInt(num)+1),3);
			}
			codeExpertType.setExpertCode(expertCode);
		}
		if(StringUtils.isEmpty(codeExpertType.getUid())){
			if(codeExpertTypeMapper.insertSelective(codeExpertType) > 0){
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}else{
			Example example = new Example(CodePositionType.class);
			example.createCriteria().andEqualTo("uid", codeExpertType.getUid()); 
			if(codeExpertTypeMapper.updateByExample(codeExpertType, example) > 0){
				return AjaxResult.success("修改成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}
	}
	
	/**
	 * 描述：查询名称是否重复
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codePositionType
	 * @return
	 */
	private boolean checkRepeat(CodeExpertType codeExpertType){
		Example example = new Example(CodeExpertType.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("dutyDeptCode", codeExpertType.getDutyDeptCode())
				.andEqualTo("expertName", codeExpertType.getExpertName());
		if(StringUtils.isNotEmpty(codeExpertType.getUid())){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", codeExpertType.getUid());
		}
		if(codeExpertTypeMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：根据专家组长名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param expertName
	 * @param dutyDeptCodes
	 * @return
	 */
	@Override
	public CodeExpertType selectByName(String expertName, String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isVlid", "1");
		params.put("expertName", expertName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<CodeExpertType> codeExpertTypeList = codeExpertTypeMapper.selectListByParams(params);
		if(CollectionUtils.isEmpty(codeExpertTypeList)){
			return null;
		}
		return codeExpertTypeList.get(0);
	}
	
	/**
	 * 描述：查询专家组长类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	@Override
	public CodeExpertType selectByUid(String uid) {
		CodeExpertType codeExpertType = new CodeExpertType();
		codeExpertType.setUid(uid);
		return codeExpertTypeMapper.selectOne(codeExpertType);
	}
	
	/**
	 * 描述：根据职能部门查询专家组长类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CodeExpertType> selectListByParams(Map<String, Object> params)throws Exception {
		return codeExpertTypeMapper.selectListByParams(params);
	}
	
	 /**
     * 
     * 描述: 查询树状结构展示
     * @auther chenxin
     * @date 2017年10月18日 
     * @param param
     * @return
     */
	@Override
	public List<Map<String, Object>> selectToTreeMap(Map<String, Object> param) {
		return codeExpertTypeMapper.selectTreeMap(param);
	}
}