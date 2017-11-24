/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.dzdtinfo.dto.HzDzhyBagsslfgsbaDto;
import com.icinfo.cs.dzdtinfo.mapper.HzDzhyBagsslfgsbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyBagsslfgsba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyBagsslfgsbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    CS_HZ_DZHY_BAGSSLFGSBA 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyBagsslfgsbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyBagsslfgsbaService {

	@Autowired
	private  HzDzhyBagsslfgsbaMapper hzDzhyBagsslfgsbaMapper;
	
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author  赵祥江
	 * @date 2017年6月15日 下午3:02:51 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyBagsslfgsba> selectHzDzhyBagsslfgsbaByPriPid(String priPid)
			throws Exception {
		HzDzhyBagsslfgsba hzDzhyBagsslfgsba=new HzDzhyBagsslfgsba();
		hzDzhyBagsslfgsba.setPriPid(priPid);
		return hzDzhyBagsslfgsbaMapper.select(hzDzhyBagsslfgsba);
	}

	/**
	 * 
	 * 描述   根据主体身份代码查询Dto
	 * @author  赵祥江
	 * @date 2017年6月21日 下午3:40:35 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyBagsslfgsbaDto> selectHzDzhyBagsslfgsbaDtoByPriPid(
			String priPid) throws Exception {
		Map<String,Object> qMap=new HashMap<String,Object>();
		qMap.put("priPid", priPid);
		return hzDzhyBagsslfgsbaMapper.selectHzDzhyBagsslfgsbaDtoByPriPid(qMap);
	}
}