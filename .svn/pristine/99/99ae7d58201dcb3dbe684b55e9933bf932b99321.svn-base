/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.dtinfo.mapper.QzDtinfoMapper;
import com.icinfo.cs.dtinfo.model.QzDtinfo;
import com.icinfo.cs.dtinfo.service.IQzDtinfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_qz_dtinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月29日
 */
@Service
public class QzDtinfoServiceImpl extends MyBatisServiceSupport implements IQzDtinfoService {

	@Autowired
	private QzDtinfoMapper qzDtinfoMapper;
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年3月29日 下午3:59:15 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertQzDtinfo(QzDtinfo qzDtinfo) {
		//时间戳
		qzDtinfo.setCreateTime(DateUtil.getSysDate());
		return qzDtinfoMapper.insertSelective(qzDtinfo);
	}
}