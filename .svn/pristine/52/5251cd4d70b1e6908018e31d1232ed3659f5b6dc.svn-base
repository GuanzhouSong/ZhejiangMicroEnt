/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeChgTypeMapper;
import com.icinfo.cs.base.model.CodeChgType;
import com.icinfo.cs.base.service.ICodeChgTypeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_code_chgtype 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月09日
 */
@Service
public class CodeChgTypeServiceImpl extends MyBatisServiceSupport implements ICodeChgTypeService {

	@Autowired
	CodeChgTypeMapper codeChgTypeMapper;
	
	@Override
	public List<CodeChgType> selectCodeChgTypeListByAltItem(String altItem) {
		return codeChgTypeMapper.selectCodeChgTypeListByAltItem(altItem);
	}
}