/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.RptSmNormalDto;
import com.icinfo.cs.rpt.rptmapper.RptSmNormalMapper;
import com.icinfo.cs.rpt.rptservice.IRptSmNormalService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_sm_normal 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Service
public class RptSmNormalServiceImpl extends MyBatisServiceSupport implements IRptSmNormalService {
	
	private static final Logger logger = LoggerFactory.getLogger(RptSmNormalServiceImpl.class);
	@Autowired
	private  RptSmNormalMapper rptSmNormalMapper;
	
	/**
	 * 
	 * 描述: 小微检测登记信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<RptSmNormalDto> selectRptSmNormalCount(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			if(searchMap != null && searchMap.containsKey("startCheckPushDate") && searchMap.containsKey("endCheckPushDate")){
				if(searchMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(searchMap.get("startCheckPushDate").toString())){
					searchMap.put("startCheckPushDate", StringUtil.replace(searchMap.get("startCheckPushDate").toString(), "-", ""));
					searchMap.put("endCheckPushDate", StringUtil.replace(searchMap.get("endCheckPushDate").toString(), "-", ""));
				}else{
					searchMap.put("startCheckPushDate", searchMap.get("rptyear").toString()+searchMap.get("rptbeginmouth").toString());
				}
			}
			PageHelper.startPage(request.getPageNum(), 10000);
			return rptSmNormalMapper.selectRptSmNormalCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "小微检测登记信息统计（普通统计）失败!");
            throw new BusinessException("小微检测登记信息统计（普通统计）失败!");
		}
	}
	
}