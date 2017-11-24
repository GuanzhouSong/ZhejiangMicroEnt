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
import com.icinfo.cs.sccheck.dto.CodeRightTypeDto;
import com.icinfo.cs.sccheck.mapper.CodeRightTypeMapper;
import com.icinfo.cs.sccheck.model.CodeRightType;
import com.icinfo.cs.sccheck.service.ICodeRightTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_code_right_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Service
public class CodeRightTypeServiceImpl extends MyBatisServiceSupport implements ICodeRightTypeService {
	
	@Autowired
	private CodeRightTypeMapper codeRightTypeMapper;
	
	/**
	 * 查询专业资格资质类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public List<CodeRightTypeDto> queryPage(PageRequest request,SysUserDto sysUserDto) throws Exception {
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
		return codeRightTypeMapper.selectByParams(params);
	}
	
	/**
	 * 描述：保存人员专业资格资质类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param codeRightType
	 * @return
	 */
	@Override
	public AjaxResult saveCodeRightType(CodeRightType codeRightType) throws Exception {
		if(StringUtils.isEmpty(codeRightType.getDutyDeptCode())){
			return AjaxResult.error("该账号未设置职能部门，请联系管理员");
		}
		if(checkRepeat(codeRightType)){
			return AjaxResult.error("人员专业资格资质名称重复");
		}
		String dutyDeptCode = codeRightType.getDutyDeptCode();
		if(StringUtils.isEmpty(codeRightType.getRightCode())){
			String rightCode = codeRightTypeMapper.selectMaxCode(dutyDeptCode);
			if(StringUtils.isEmpty(rightCode)){
				rightCode = dutyDeptCode+"-001";
			}else{
				String num = rightCode.split("-")[1];
				rightCode = dutyDeptCode+"-"+StringUtil.addZero((Integer.parseInt(num)+1),3);
			}
			codeRightType.setRightCode(rightCode);
		}
		if(StringUtils.isEmpty(codeRightType.getUid())){
			if(codeRightTypeMapper.insertSelective(codeRightType) > 0){
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("数据库异常请联系管理员");
			}
		}else{
			Example example = new Example(CodeRightType.class);
			example.createCriteria().andEqualTo("uid", codeRightType.getUid()); 
			if(codeRightTypeMapper.updateByExample(codeRightType, example) > 0){
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
	private boolean checkRepeat(CodeRightType codeRightType){
		Example example = new Example(CodeRightType.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("dutyDeptCode", codeRightType.getDutyDeptCode())
				.andEqualTo("rightName", codeRightType.getRightName());
		if(StringUtils.isNotEmpty(codeRightType.getUid())){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", codeRightType.getUid());
		}
		if(codeRightTypeMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：根据专业资格资质类别名称查找相应的专项库信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param rightName
	 * @param dutyDeptCodes
	 * @return
	 */
	@Override
	public CodeRightType selectByName(String rightName, String dutyDeptCodes) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("isVlid", "1");
		params.put("rightName", rightName);
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
		List<CodeRightType> codeRightTypeList = codeRightTypeMapper.selectListByParams(params);
		if(CollectionUtils.isEmpty(codeRightTypeList)){
			return null;
		}
		return codeRightTypeList.get(0);
	}
	
	/**
	 * 描述：查询专业资格资质类别信息
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param uid
	 * @return
	 */
	@Override
	public CodeRightType selectByUid(String uid) {
		CodeRightType codeRightType = new CodeRightType();
		codeRightType.setUid(uid);
		return codeRightTypeMapper.selectOne(codeRightType);
	}
	
	/**
	 * 描述：根据职能部门查询专业资格资质类别列表
	 * 
	 * @author chenxin
	 * @date 2017-09-15
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CodeRightType> selectListByParams(Map<String, Object> params)throws Exception {
		return codeRightTypeMapper.selectListByParams(params);
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
		return codeRightTypeMapper.selectTreeMap(param);
	}
}