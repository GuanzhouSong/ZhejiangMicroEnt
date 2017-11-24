/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeEntTypeMapper;
import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;

/**
 * 描述:    cs_code_enttype 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
@Service
public class CodeEntTypeServiceImpl extends MyBatisServiceSupport implements ICodeEntTypeService {
	private static final Logger logger = LoggerFactory.getLogger(CodeEntTypeServiceImpl.class);

	@Autowired
	private CodeEntTypeMapper codeEntTypeMapper;
	/**
	 * 
	 * 描述             : 根据企业小类编码获取企业小类对象
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午4:14:42 
	 * @param :
	 * @return: CodeEntType
	 * @throws
	 */
	public CodeEntType selectCodeEntTypeByCode(String code)
			throws Exception {
		try { 
			Example example=this.getExample(CodeEntType.class);
			//年报ID
			if(StringUtil.isNotEmpty(code)){
				example.createCriteria()
				.andEqualTo("code", code);
				List<CodeEntType>  codeEntTypeList= codeEntTypeMapper.selectByExample(example);
				if(codeEntTypeList.size()>0){
					return codeEntTypeList.get(0);
				}
			} 
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据企业小类编码获取企业小类对象失败!");
            throw new BusinessException("根据企业小类编码获取企业小类对象失败!");
		}
	}
	
	
	
	private Example getExample(Class<?> classObj){
		Example example=new Example(classObj); 
		return example;
	}
}