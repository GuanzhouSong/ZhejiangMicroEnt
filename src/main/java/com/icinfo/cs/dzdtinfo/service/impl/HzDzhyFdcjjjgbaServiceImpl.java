/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyFdcjjjgbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyFdcjjjgba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyFdcjjjgbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    CS_HZ_DZHY_FDCJJJGBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyFdcjjjgbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyFdcjjjgbaService {

	@Autowired
	private HzDzhyFdcjjjgbaMapper hzDzhyFdcjjjgbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author  赵祥江
	 * @date 2017年6月15日 下午3:16:24 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyFdcjjjgba> selectHzDzhyFdcjjjgbaByPriPid(String priPid)
			throws Exception {
		HzDzhyFdcjjjgba hzDzhyFdcjjjgba=new HzDzhyFdcjjjgba();
		hzDzhyFdcjjjgba.setPriPid(priPid);
		return hzDzhyFdcjjjgbaMapper.select(hzDzhyFdcjjjgba);
	}
}