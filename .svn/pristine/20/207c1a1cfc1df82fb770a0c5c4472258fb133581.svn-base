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
import com.icinfo.cs.sccheck.dto.CodePositionTypeDto;
import com.icinfo.cs.sccheck.mapper.CodePositionTypeMapper;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_position_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class CodePositionTypeServiceImpl extends MyBatisServiceSupport implements ICodePositionTypeService {
	
	@Autowired
	private CodePositionTypeMapper codePositionTypeMapper;
	
	/**
	 * 查询人员岗位大类类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public List<CodePositionTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto) throws Exception {
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
		return codePositionTypeMapper.selectByParams(params);
	}
	
	/**
	 * 描述：保存人员岗位大类类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeSpecialType
	 * @return
	 */
	@Override
	public AjaxResult saveCodePositionType(CodePositionType codePositionType) throws Exception {
		if(StringUtils.isEmpty(codePositionType.getDutyDeptCode())){
			return AjaxResult.error("该账号未设置职能部门，请联系管理员");
		}
		if(checkRepeat(codePositionType)){
			return AjaxResult.error("人员岗位大类名称重复");
		}
		String dutyDeptCode = codePositionType.getDutyDeptCode();
		if(StringUtils.isEmpty(codePositionType.getPositionCode())){
			String positionCode = codePositionTypeMapper.selectMaxCode(dutyDeptCode);
			if(StringUtils.isEmpty(positionCode)){
				positionCode = dutyDeptCode+"-001";
			}else{
				String num = positionCode.split("-")[1];
				positionCode = dutyDeptCode+"-"+StringUtil.addZero((Integer.parseInt(num)+1),3);
			}
			codePositionType.setPositionCode(positionCode);
		}
		if(StringUtils.isEmpty(codePositionType.getUid())){
			if(codePositionTypeMapper.insertSelective(codePositionType) > 0){
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}else{
			Example example = new Example(CodePositionType.class);
			example.createCriteria().andEqualTo("uid", codePositionType.getUid()); 
			if(codePositionTypeMapper.updateByExample(codePositionType, example) > 0){
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
	private boolean checkRepeat(CodePositionType codePositionType){
		Example example = new Example(CodePositionType.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("dutyDeptCode", codePositionType.getDutyDeptCode())
				.andEqualTo("positionName", codePositionType.getPositionName());
		if(StringUtils.isNotEmpty(codePositionType.getUid())){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", codePositionType.getUid());
		}
		if(codePositionTypeMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：根据人员岗位大类类别名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param specialName
	 * @param dutyDeptCodes
	 * @return
	 */
	@Override
	public CodePositionType selectByName(String positionName,String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isVlid", "1");
		params.put("positionName", positionName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<CodePositionType> codePositionTypeList = codePositionTypeMapper.selectListByParams(params);
		if(CollectionUtils.isEmpty(codePositionTypeList)){
			return null;
		}
		return codePositionTypeList.get(0);
	}
	
	/**
	 * 描述：查询人员岗位大类类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	@Override
	public CodePositionType selectByUid(String uid) {
		CodePositionType codePositionType = new CodePositionType();
		codePositionType.setUid(uid);
		return codePositionTypeMapper.selectOne(codePositionType);
	}
	
	/**
	 * 描述：根据职能部门查询人员岗位大类类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CodePositionType> selectListByParams(Map<String, Object> params)throws Exception {
		return codePositionTypeMapper.selectListByParams(params);
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
		return codePositionTypeMapper.selectTreeMap(param);
	}
}