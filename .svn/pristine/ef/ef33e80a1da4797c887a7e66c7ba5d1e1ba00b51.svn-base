/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.service.impl;

import com.icinfo.cs.favorable.mapper.FavorAbleInfoHisMapper;
import com.icinfo.cs.favorable.model.FavorAbleInfoHis;
import com.icinfo.cs.favorable.service.IFavorAbleInfoHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_favorable_info_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月09日
 */
@Service
public class FavorAbleInfoHisServiceImpl extends MyBatisServiceSupport implements IFavorAbleInfoHisService {
	
	@Autowired
	FavorAbleInfoHisMapper favorAbleInfoHisMapper;
	
	/**
	 * 描述   通过hisNO 获取企业良好信息历史记录
	 * @author yujingwei
	 * @date 2017年3月9日 
	 * @param hisNO
	 * @return FavorAbleInfoHis
	 */
	public FavorAbleInfoHis doGetAbleInfoHisInfoBy(String hisNO) throws Exception{
		FavorAbleInfoHis ableInfoHis = new FavorAbleInfoHis();
		ableInfoHis.setHisNO(hisNO);
		return favorAbleInfoHisMapper.selectOne(ableInfoHis); 
	}
}