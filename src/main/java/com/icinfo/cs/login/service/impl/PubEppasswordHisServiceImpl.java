/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: PubEppasswordHisMapper <br/>
 *
 * @author framework generator
 * @date 2016年09月08日
 * @version 2.0
 */
package com.icinfo.cs.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.login.mapper.PubEppasswordHisMapper;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.cs.login.service.IPubEppasswordHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:cs_pub_eppassword_his 对应的Service实现.<br>
 *
 * @author framework generator
 * @date 2016年09月08日
 */
@Service
public class PubEppasswordHisServiceImpl extends MyBatisServiceSupport implements IPubEppasswordHisService {
	@Autowired
	PubEppasswordHisMapper pubEppasswordHisMapper;
	
	/** 
	 * 描述: 保存联络员备案历史信息
	 * @auther chenxin
	 * @date 2016年9月8日 
	 * @param pubEppasswordHis 联络员备案历史对象
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int doSavePubEppasswordInfo(PubEppasswordHis pubEppasswordHis)throws Exception {
		return pubEppasswordHisMapper.insert(pubEppasswordHis);
	}
}
