/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeCurrencyMapper;
import com.icinfo.cs.base.model.CodeCurrency;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_code_currency 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月24日
 */
@Service
public class CodeCurrencyServiceImpl extends MyBatisServiceSupport implements ICodeCurrencyService {
	@Autowired
	private CodeCurrencyMapper codeCurrencyMapper;
	/**
	 * 
	 * 描述   根据编码获取币种
	 * @author  赵祥江
	 * @date 2016年9月24日 下午3:12:18 
	 * @param  
	 * @throws
	 */
	@Override
	public CodeCurrency selectCodeCurrencyByCode(String code) {
		CodeCurrency codeCurrency=new CodeCurrency();
		if(StringUtil.isNotEmpty(code)){
			codeCurrency.setCode(code);
			return codeCurrencyMapper.selectOne(codeCurrency);
		}
		return null; 
	}
}