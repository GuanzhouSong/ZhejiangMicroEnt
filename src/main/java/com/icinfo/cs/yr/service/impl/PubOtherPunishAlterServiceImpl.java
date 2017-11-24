/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.List;

import com.icinfo.cs.yr.mapper.PubOtherPunishAlterMapper;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_otherpunish_alter 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class PubOtherPunishAlterServiceImpl extends MyBatisServiceSupport implements IPubOtherPunishAlterService {
	
	@Autowired
	PubOtherPunishAlterMapper pubOtherPunishAlterMapper;
	
	/**
	 * 描述: 获取行政处罚变更信息
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @param  pripid，hisNO，modUID
	 * @return PubOtherPunishAlter
	 * @throws Exception
	 */
	public PubOtherPunishAlter doGetPunishAlter(String pripid, String hisNO,
			String modUID) throws Exception{
		PubOtherPunishAlter pubOtherPunishAlter = new PubOtherPunishAlter();
		pubOtherPunishAlter.setPriPID(pripid);
		pubOtherPunishAlter.setHisNO(hisNO);
		pubOtherPunishAlter.setCaseNO(modUID);
		return pubOtherPunishAlterMapper.selectOne(pubOtherPunishAlter);
	}
	
	/**
	 * 描述: 获取行政处罚变更List
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @param  pripid,caseNO
	 * @return List<PubOtherPunishAlter>
	 * @throws Exception
	 */
	public List<PubOtherPunishAlter> doGetAlterInfoList(String pripid,
			String caseNO) throws Exception{
		Example example = new Example(PubOtherPunishAlter.class);
		example.createCriteria().andEqualTo("priPID", pripid).andEqualTo("caseNO", caseNO);
		return pubOtherPunishAlterMapper.selectByExample(example);
		
	}
}