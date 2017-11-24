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

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.PubSearchLogRptDto;
import com.icinfo.cs.rpt.rptmapper.PubSearchLogRptMapper;
import com.icinfo.cs.rpt.rptservice.IPubSearchLogRptService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_search_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月09日
 */
@Service
public class PubSearchLogRptServiceImpl extends MyBatisServiceSupport implements IPubSearchLogRptService {
	private static final Logger logger = LoggerFactory.getLogger(PubSearchLogRptServiceImpl.class);
	
	@Autowired
	private  PubSearchLogRptMapper pubSearchLogRptMapper;

	/** 
	 * 描述: 公示系统访问情况统计
	 * @auther ZhouYan
	 * @date 2017年10月9日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubSearchLogRptDto> selectPubSearchLogRpt(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), 10000);
			return pubSearchLogRptMapper.selectPubSearchLogRpt(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "公示系统访问情况统计失败!");
            throw new BusinessException("公示系统访问情况统计失败!");
		}
	}
	
	
}