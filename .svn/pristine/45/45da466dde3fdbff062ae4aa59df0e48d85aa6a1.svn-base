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

import com.icinfo.cs.rpt.rptmapper.RptAnnounceMentInfoMapper;
import com.icinfo.cs.rpt.rptmodel.RptAnnounceMentInfo;
import com.icinfo.cs.rpt.rptservice.IRptAnnounceMentInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:    cs_rpt_announcement_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
@Service
public class RptAnnounceMentInfoServiceImpl extends MyBatisServiceSupport implements IRptAnnounceMentInfoService {
	private static final Logger logger = LoggerFactory.getLogger(RptAnnounceMentInfoServiceImpl.class);

	@Autowired
	private  RptAnnounceMentInfoMapper rptAnnounceMentInfoMapper;

	/**
	 * 
	 * 描述   根据不同类型查询公告
	 * @author  赵祥江
	 * @date 2017年8月22日 下午4:39:47 
	 * @param  
	 * @throws
	 */
	@Override
	public List<RptAnnounceMentInfo> selectRptAnnounceMentInfo(
			Map<String, Object> parmMap) throws Exception {
		try {
			return rptAnnounceMentInfoMapper.selectRptAnnounceMentInfo(parmMap);
		} catch (Exception e) {
			logger.error("可视化查询公告发生", e);
		}
		return null;
	}
	 
}