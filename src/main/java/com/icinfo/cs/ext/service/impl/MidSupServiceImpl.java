/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.ext.mapper.MidSupMapper;
import com.icinfo.cs.ext.model.MidSup;
import com.icinfo.cs.ext.service.IMidSupService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_mid_sup 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
@Service
public class MidSupServiceImpl extends MyBatisServiceSupport implements IMidSupService {

	@Autowired
	private MidSupMapper midSupMapper;
	/**
	 * 
	 * 描述             : 根据主体代码获取隶属企业信息
	 * @author: 赵祥江
	 * @date  : 2016年9月14日 上午11:55:24 
	 * @param :
	 * @return: MidSup
	 * @throws
	 */
	@Override
	public List<MidSup> selectMidSupBypriPID(String priPid) {
		Example example = new Example(MidSup.class);
		example.createCriteria().andEqualTo(Constants.CS_PRIPID,priPid); 
		return midSupMapper.selectByExample(example);
		 
	}
}