/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeInDusTryMapper;
import com.icinfo.cs.base.model.CodeInDusTry;
import com.icinfo.cs.base.service.ICodeInDusTryService;
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
public class CodeInDusTryServiceImpl extends MyBatisServiceSupport implements ICodeInDusTryService {

	@Autowired
	private CodeInDusTryMapper  codeInDusTryMapper;
	/**
	 * 
	 * 描述   根据行业编码查询
	 * @author 赵祥江
	 * @date 2016年10月17日 下午7:22:34 
	 * @param 
	 * @return CodeInDusTry
	 * @throws
	 */
	@Override
	public CodeInDusTry selectCodeInDusTryByCode(String code) throws Exception {
		CodeInDusTry codeInDusTry=new CodeInDusTry();
		codeInDusTry.setCode(code);
		return codeInDusTryMapper.selectOne(codeInDusTry);
	}

	/**
	 * 获取行业树json
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectToTreeMap(Map<String, Object> map) {
		return codeInDusTryMapper.selectToTreeMap(map);
	}
	/**
	 * 获取小微企业行业树json
	 * @return
	 */
	@Override
	public List<Map<String, Object>> selectToSmTreeMap(Map<String,Object> map) {
		return codeInDusTryMapper.selectToSmTreeMap(map);
	}
}