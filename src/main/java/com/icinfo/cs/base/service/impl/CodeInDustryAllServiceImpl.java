/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeInDustryAllMapper;
import com.icinfo.cs.base.service.ICodeInDusTryService;
import com.icinfo.cs.base.service.ICodeInDustryAllService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_industry 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Service
public class CodeInDustryAllServiceImpl extends MyBatisServiceSupport implements ICodeInDustryAllService {

	@Autowired
	private CodeInDustryAllMapper codeInDustryAllMapper;

	/**
	 * 获取行业树json
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectToTreeMap() {
		return codeInDustryAllMapper.selectToTreeMap();
	}
}