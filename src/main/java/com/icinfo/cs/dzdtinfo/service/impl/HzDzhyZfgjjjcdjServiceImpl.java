/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.service.impl;

import java.util.List;

import com.icinfo.cs.dzdtinfo.mapper.HzDzhyZfgjjjcdjMapper;
import com.icinfo.cs.dzdtinfo.model.HzDzhyZfgjjjcdj;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyZfgjjjcdjService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    CS_HZ_DZHY_ZFGJJJCDJ 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class HzDzhyZfgjjjcdjServiceImpl extends MyBatisServiceSupport implements IHzDzhyZfgjjjcdjService {

	@Autowired
	private HzDzhyZfgjjjcdjMapper hzDzhyZfgjjjcdjMapper;
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年6月15日 下午3:08:54 
	 * @param 
	 * @return HzDzhyZfgjjjcdj
	 * @throws
	 */
	@Override
	public List<HzDzhyZfgjjjcdj> selectHzDzhyZfgjjjcdjByPriPid(String priPid)
			throws Exception {
		HzDzhyZfgjjjcdj hzDzhyZfgjjjcdj=new HzDzhyZfgjjjcdj();
		hzDzhyZfgjjjcdj.setPriPid(priPid);
		return hzDzhyZfgjjjcdjMapper.select(hzDzhyZfgjjjcdj);
	}
}