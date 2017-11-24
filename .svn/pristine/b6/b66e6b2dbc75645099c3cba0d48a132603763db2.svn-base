/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.mapper.CodeContriFormMapper;
import com.icinfo.cs.base.model.CodeContriForm;
import com.icinfo.cs.base.service.ICodeContriFormService;
import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_code_contriform 对应的Service接口实现类.<br>
 * 出资方式
 * @author framework generator
 * @date 2016年08月30日
 */
@Service
public class CodeContriFormServiceImpl extends MyBatisServiceSupport implements ICodeContriFormService {

	@Autowired
	private CodeContriFormMapper codeContriFormMapper;
	/**
	 * 
	 * 描述             : 根据编码获取出资方式对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午12:30:26 
	 * @param :
	 * @return: CodeContriForm
	 * @throws
	 */
	@Override
	public CodeContriForm selectCodeContriFormByCode(String code) {
		Example example=new Example(YrAlterStockInfo.class);
		example.createCriteria().andEqualTo("code", code);
		List<CodeContriForm> codeContriFormList= codeContriFormMapper.selectByExample(example);
		if(codeContriFormList.size()>0){
			return codeContriFormList.get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * 描述: 获取所有出资方式
	 * @author: 赵祥江
	 * @Modify_author:wangjin
	 * @date  : 2016年8月30日 下午12:49:17 
	 * @param : 
	 * @throws
	 */
	@Override
	public List<CodeContriForm> selectAllCodeContriForm() {
		Example example = new Example(CodeContriForm.class);
		example.orderBy("code").asc(); //升序
		return  codeContriFormMapper.selectByExample(example);
		//return  codeContriFormMapper.selectAll();
	}
}