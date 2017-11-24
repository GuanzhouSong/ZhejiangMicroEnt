/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeRegStateMapper;
import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_code_regstate 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年07月26日
 */
@Service
public class CodeRegStateServiceImpl extends MyBatisServiceSupport implements ICodeRegStateService {
	@Autowired
	private CodeRegStateMapper codeRegStateMapper;
	
	/**
	 * 描述：查询所有状态
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CodeRegState> selectCodeRegStateList(String csState) throws Exception {
		if(StringUtils.isEmpty(csState)){
			return codeRegStateMapper.selectAll();
		}
		Example example = new Example(CodeRegState.class);
		example.createCriteria().andEqualTo("csState", csState);
		return codeRegStateMapper.selectByExample(example);
	}
	
	/**
	 * 描述:查询存续登记状态
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	@Override
	public String selectCxRegstates(String csState) throws Exception {
		List<CodeRegState> CodeRegStateList = this.selectCodeRegStateList(csState);
		String regStates = "";
		for(CodeRegState codeRegState : CodeRegStateList){
			String regState = codeRegState.getRegState();
			if(StringUtils.isEmpty(regStates)){
				regStates = regState;
			}else{
				regStates += ","+regState;
			}
		}
		return regStates;
	}

	/** 
	 * 描述: 查询登记状态查询条件列表
	 * @auther ZhouYan
	 * @date 2017年8月15日 
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CodeRegState> selectRegStateParamList() throws Exception {
		return codeRegStateMapper.selectRegStateParamList();
	}
	
	/**
	 * 描述:查询存续登记状态名称
	 * @author chenxin
	 * @date 2017-07-26
	 * @param csState
	 * @return
	 * @throws Exception
	 */
	@Override
	public CodeRegState selectCsStateDesc(String regState) throws Exception {
		CodeRegState codeRegState = new CodeRegState();
		codeRegState.setRegState(regState);
		return codeRegStateMapper.selectOne(codeRegState);
	}
}