/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyCsyspjydwbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyCsyspjydwba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyCsyspjydwbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_CSYSPJYDWBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyCsyspjydwbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyCsyspjydwbaService {

	@Autowired
	private HzDzhyCsyspjydwbaMapper hzDzhyCsyspjydwbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author  赵祥江
	 * @date 2017年6月15日 下午3:06:37 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyCsyspjydwba> selectHzDzhyCsyspjydwbaByPriPid(String priPid)
			throws Exception {
		HzDzhyCsyspjydwba hzDzhyCsyspjydwba=new HzDzhyCsyspjydwba();
		hzDzhyCsyspjydwba.setPriPid(priPid);
		return hzDzhyCsyspjydwbaMapper.select(hzDzhyCsyspjydwba);
	}
}