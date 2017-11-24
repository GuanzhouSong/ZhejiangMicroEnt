/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyDxscyqyrdbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyDxscyqyrdba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyDxscyqyrdbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_DXSCYQYRDBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyDxscyqyrdbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyDxscyqyrdbaService {

	@Autowired
	private HzDzhyDxscyqyrdbaMapper hzDzhyDxscyqyrdbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author  赵祥江
	 * @date 2017年6月15日 下午3:14:34 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyDxscyqyrdba> selectHzDzhyDxscyqyrdbaByPriPid(String priPid)
			throws Exception {
		HzDzhyDxscyqyrdba hzDzhyDxscyqyrdba=new HzDzhyDxscyqyrdba();
		hzDzhyDxscyqyrdba.setPriPid(priPid);
		return hzDzhyDxscyqyrdbaMapper.select(hzDzhyDxscyqyrdba);
	}
}