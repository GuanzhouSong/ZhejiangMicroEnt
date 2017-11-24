/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.dzdtinfo.dto.HzDzhyLxsfsfwwdbaDto;
import com.icinfo.cs.dzdtinfo.mapper.HzDzhyLxsfsfwwdbaMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyLxsfsfwwdba;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyLxsfsfwwdbaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
@Service
public class HzDzhyLxsfsfwwdbaServiceImpl extends MyBatisServiceSupport implements IHzDzhyLxsfsfwwdbaService {

	@Autowired
	private HzDzhyLxsfsfwwdbaMapper hzDzhyLxsfsfwwdbaMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:08:54 
	 * @param 
	 * @return HzDzhyLxsfsfwwdba
	 * @throws
	 */
	@Override
	public List<HzDzhyLxsfsfwwdba> selectHzDzhyLxsfsfwwdbaByPriPid(String priPid)
			throws Exception {
		HzDzhyLxsfsfwwdba hzDzhyLxsfsfwwdba=new HzDzhyLxsfsfwwdba();
		hzDzhyLxsfsfwwdba.setPriPid(priPid);
		return hzDzhyLxsfsfwwdbaMapper.select(hzDzhyLxsfsfwwdba);
	}
	
	/**
	 * 
	 * 描述   根据主体身份代码查询Dto
	 * @author  赵祥江
	 * @date 2017年6月21日 下午2:37:40 
	 * @param  
	 * @throws
	 */
	@Override
	public List<HzDzhyLxsfsfwwdbaDto> selectHzDzhyLxsfsfwwdbaDtoByPriPid(
			String priPid) throws Exception {
		Map<String,Object> qMap=new HashMap<String,Object>();
		qMap.put("priPid", priPid);
		return hzDzhyLxsfsfwwdbaMapper.selectHzDzhyLxsfsfwwdbaDtoByPriPid(qMap);
	}
}