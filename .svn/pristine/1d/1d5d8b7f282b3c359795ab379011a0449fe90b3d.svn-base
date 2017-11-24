/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyBafzrgzqkMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyBafzrgzqk;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyBafzrgzqkService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    CS_HZ_DZHY_BAFZRGZQK 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyBafzrgzqkServiceImpl extends MyBatisServiceSupport implements IHzDzhyBafzrgzqkService {

	/**
	 * 根据主体身份代码查询
	 */
	@Autowired
	private HzDzhyBafzrgzqkMapper hzDzhyBafzrgzqkMapper;
	@Override
	public List<HzDzhyBafzrgzqk> selectHzDzhyBafzrgzqkByPriPid(String priPid)
			throws Exception {
		HzDzhyBafzrgzqk hzDzhyBafzrgzqk=new HzDzhyBafzrgzqk();
		hzDzhyBafzrgzqk.setPriPid(priPid);
		return hzDzhyBafzrgzqkMapper.select(hzDzhyBafzrgzqk);
	}
}