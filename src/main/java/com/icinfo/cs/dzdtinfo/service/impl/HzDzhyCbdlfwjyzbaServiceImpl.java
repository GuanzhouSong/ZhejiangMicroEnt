/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyCbdlfwjyzbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyCbdlfwjyzba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyCbdlfwjyzbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_CBDLFWJYZBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyCbdlfwjyzbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyCbdlfwjyzbaService {

	@Autowired
	private HzDzhyCbdlfwjyzbaMapper hzDzhyCbdlfwjyzbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:01:14 
	 * @param 
	 * @return HzDzhyBagsslfgsba
	 * @throws
	 */
	@Override
	public List<HzDzhyCbdlfwjyzba> selectHzDzhyCbdlfwjyzbaByPriPid(String priPid)
			throws Exception {
		HzDzhyCbdlfwjyzba hzDzhyCbdlfwjyzba=new HzDzhyCbdlfwjyzba();
		hzDzhyCbdlfwjyzba.setPriPid(priPid);
		return hzDzhyCbdlfwjyzbaMapper.select(hzDzhyCbdlfwjyzba);
	}
}