/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import com.icinfo.cs.yr.mapper.PubOtherpunishHisMapper;
import com.icinfo.cs.yr.model.PubOtherpunishHis;
import com.icinfo.cs.yr.service.IPubOtherpunishHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_otherpunish_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Service
public class PubOtherpunishHisServiceImpl extends MyBatisServiceSupport implements IPubOtherpunishHisService {
	
	@Autowired
	PubOtherpunishHisMapper pubOtherpunishHisMapper;
	
	/**
	 * 描述: 获取行政处罚历史记录信息
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @param  pripid，hisNO，modUID
	 * @return PubOtherpunishHis
	 * @throws Exception
	 */
	public PubOtherpunishHis doGetPunishHisInfo(String pripid, String hisNO,
			String modUID) throws Exception{
		PubOtherpunishHis pubOtherpunishHis = new PubOtherpunishHis();
		pubOtherpunishHis.setPriPID(pripid);
		pubOtherpunishHis.setHisNO(hisNO);
		pubOtherpunishHis.setCaseNO(modUID);
		return pubOtherpunishHisMapper.selectOne(pubOtherpunishHis);
	}
}