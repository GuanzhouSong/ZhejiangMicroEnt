/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sment.mapper.SmBaseinfoHisMapper;
import com.icinfo.cs.sment.model.SmBaseinfoHis;
import com.icinfo.cs.sment.service.ISmBaseinfoHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:   小微历史记录表 sm_baseinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月12日
 */
@Service("smBaseinfoHisService")
public class SmBaseinfoHisServiceImpl extends MyBatisServiceSupport implements ISmBaseinfoHisService {

	@Autowired
	public SmBaseinfoHisMapper smBaseinfoHisMapper;
	
	/**
	 * 插入数据
	 * @author fanzhen
	 * @date 20170512
	 */
	@Override
	public int insertSmBaseinfoHis(SmBaseinfoHis smBaseinfoHis) throws Exception {
		return smBaseinfoHisMapper.insert(smBaseinfoHis);
	}
}