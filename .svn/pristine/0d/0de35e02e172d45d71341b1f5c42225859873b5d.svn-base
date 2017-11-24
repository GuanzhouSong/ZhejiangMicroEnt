/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyDlhwjyzslfgsbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyDlhwjyzslfgsba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyDlhwjyzslfgsbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_DLHWJYZSLFGSBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyDlhwjyzslfgsbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyDlhwjyzslfgsbaService {
	@Autowired
	private HzDzhyDlhwjyzslfgsbaMapper hzDzhyDlhwjyzslfgsbaMapper;
	/**
	 * 
	 * 描述   根据主体代码查询
	 * @author  赵祥江
	 * @date 2017年6月15日 下午3:11:23 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyDlhwjyzslfgsba> selectHzDzhyDlhwjyzslfgsbaByPriPid(String priPid)
			throws Exception {
		HzDzhyDlhwjyzslfgsba hzDzhyDlhwjyzslfgsba=new HzDzhyDlhwjyzslfgsba();
		hzDzhyDlhwjyzslfgsba.setPriPid(priPid);
		return hzDzhyDlhwjyzslfgsbaMapper.select(hzDzhyDlhwjyzslfgsba);
	}
}