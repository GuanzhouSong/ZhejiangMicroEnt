/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import com.icinfo.cs.other.mapper.PubJusticeInfoHisMapper;
import com.icinfo.cs.other.model.PubJusticeInfoHis;
import com.icinfo.cs.other.service.IPubJusticeInfoHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_justiceinfo_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class PubJusticeInfoHisServiceImpl extends MyBatisServiceSupport implements IPubJusticeInfoHisService {
	
	@Autowired
	PubJusticeInfoHisMapper pubJusticeInfoHisMapper;
	
	/**
	 * 描述: 获取司法协助历史记录信息
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param  pripid，modUID，hisNO
	 * @return PubJusticeInfoHis
	 * @throws Exception
	 */
	public PubJusticeInfoHis doGetPubJusticeInfoHis(String pripid, String modUID,
			String hisNO) throws Exception{
		PubJusticeInfoHis pubJusticeInfoHis = new PubJusticeInfoHis();
		pubJusticeInfoHis.setHisNO(hisNO);
		pubJusticeInfoHis.setPriPID(pripid);
		pubJusticeInfoHis.setUID(modUID);
		return pubJusticeInfoHisMapper.selectOne(pubJusticeInfoHis);
	}
}