/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyZszyhsjyzbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyZszyhsjyzba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyZszyhsjyzbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    CS_HZ_DZHY_ZSZYHSJYZBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyZszyhsjyzbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyZszyhsjyzbaService {

	@Autowired
	private HzDzhyZszyhsjyzbaMapper hzDzhyZszyhsjyzbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:08:54 
	 * @param 
	 * @return HzDzhyZszyhsjyzba
	 * @throws
	 */
	@Override
	public List<HzDzhyZszyhsjyzba> selectHzDzhyZszyhsjyzbaByPriPid(String priPid)
			throws Exception {
		HzDzhyZszyhsjyzba hzDzhyZszyhsjyzba=new HzDzhyZszyhsjyzba();
		hzDzhyZszyhsjyzba.setPriPid(priPid);
		return hzDzhyZszyhsjyzbaMapper.select(hzDzhyZszyhsjyzba);
	}
}