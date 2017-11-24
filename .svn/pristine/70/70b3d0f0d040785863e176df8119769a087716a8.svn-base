/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyHyxgfwjyzbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyHyxgfwjyzba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyHyxgfwjyzbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_HYXGFWJYZBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyHyxgfwjyzbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyHyxgfwjyzbaService {

	@Autowired
	private HzDzhyHyxgfwjyzbaMapper hzDzhyHyxgfwjyzbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:08:54 
	 * @param 
	 * @return HzDzhyHyxgfwjyzba
	 * @throws
	 */
	@Override
	public List<HzDzhyHyxgfwjyzba> selectHzDzhyHyxgfwjyzbaByPriPid(String priPid)
			throws Exception {
		HzDzhyHyxgfwjyzba hzDzhyHyxgfwjyzba=new HzDzhyHyxgfwjyzba();
		hzDzhyHyxgfwjyzba.setPriPid(priPid);
		return hzDzhyHyxgfwjyzbaMapper.select(hzDzhyHyxgfwjyzba);
	}
}