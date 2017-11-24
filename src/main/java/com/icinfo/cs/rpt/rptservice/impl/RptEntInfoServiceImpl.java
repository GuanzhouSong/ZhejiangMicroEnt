/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.rpt.rptdto.RptEntInfoDto;
import com.icinfo.cs.rpt.rptmapper.RptEntInfoMapper;
import com.icinfo.cs.rpt.rptservice.IRptEntInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_rpt_yr 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Service
public class RptEntInfoServiceImpl extends MyBatisServiceSupport implements IRptEntInfoService {
	
	private static final Logger logger = LoggerFactory.getLogger(RptEntInfoServiceImpl.class);
	 
	@Autowired
	private  RptEntInfoMapper rptEntInfoMapper;
	
  
	/**
	 * 
	 * 描述   查询企业信息
	 * @author  赵祥江
	 * @date 2017年8月2日 下午4:45:59 
	 * @param  
	 * @throws
	 */
	@Override
	public List<RptEntInfoDto> selectRptEntInfoDtoCount(Map<String,Object> queryMap)
			throws Exception {
		 try { 
			 return	 rptEntInfoMapper.selectRptEntInfoDtoCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询异常",e);
		}
		return null;
	} 
}