/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.Map;

import com.icinfo.cs.rpt.rptmapper.RptOptoInfoMapper;
import com.icinfo.cs.rpt.rptmodel.RptOptoInfo;
import com.icinfo.cs.rpt.rptservice.IRptOptoInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_opto_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月22日
 */
@Service
public class RptOptoInfoServiceImpl extends MyBatisServiceSupport implements IRptOptoInfoService {

	@Autowired
	private RptOptoInfoMapper rptOptoInfoMapper;
	/**
	 * 
	 * 描述: 经营期限统计（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月23日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public RptOptoInfo selectRptOptoCount(Map<String,Object> queryMap)throws Exception{
		return rptOptoInfoMapper.selectRptOptoCount(queryMap);
	};


}