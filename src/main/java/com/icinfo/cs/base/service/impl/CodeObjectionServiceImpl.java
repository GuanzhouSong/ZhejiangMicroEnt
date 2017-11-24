/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeObjectionMapper;
import com.icinfo.cs.base.model.CodeObjection;
import com.icinfo.cs.base.service.ICodeObjectionService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_code_objection 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Service
public class CodeObjectionServiceImpl extends MyBatisServiceSupport implements ICodeObjectionService {
	@Autowired
	CodeObjectionMapper codeObjectionMapper;

	@Override
	public List<CodeObjection> findListResultAll() {
		return codeObjectionMapper.selectListResultAll();
	}

	/**
	 * 
	 * 描述   根据编码获取异议内容
	 * @author  赵祥江
	 * @date 2017年3月7日 下午4:36:15 
	 * @param  
	 * @throws
	 */
	@Override
	public CodeObjection findCodeObjectionByCode(String code) { 
		CodeObjection codeObjection=new CodeObjection();
		codeObjection.setCode(code); 
		return codeObjectionMapper.selectOne(codeObjection);
	}
}