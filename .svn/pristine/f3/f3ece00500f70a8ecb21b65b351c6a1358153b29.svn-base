/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.rpt.rptdto.YrRptDto;
import com.icinfo.cs.rpt.rptmapper.YrRptMapper;
import com.icinfo.cs.rpt.rptservice.IYrRptService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_yr 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年01月18日
 */
@Service
public class YrRptServiceImpl extends MyBatisServiceSupport implements IYrRptService {
	
	private static final Logger logger = LoggerFactory.getLogger(YrRptServiceImpl.class);
	//年报进度信息统计表
	@Autowired
	private  YrRptMapper yrRptMapper;
	

	/**
	 * 
	 * 描述: 年报进度统计
	 * @auther gaojinling
	 * @date 2017年1月18日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<YrRptDto> selectRptYrCount(PageRequest request) throws Exception {
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
			return yrRptMapper.selectRptYrCount(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "年报进度统计失败!");
            throw new BusinessException("年报进度统计失败!");
		}
	}

	/**
	 * 
	 * 描述   根据年报年度和企业类型获取企业年度报告情况
	 * @author 赵祥江
	 * @date 2017年7月24日 上午10:58:54 
	 * @param 
	 * @return List<YrRptDto>
	 * @throws
	 */
	@Override
	public List<YrRptDto> selectEntReportDataCount(Map<String,Object> queryMap)
			throws Exception {
		 try { 
			 return	 yrRptMapper.selectEntReportDataCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "年报进度统计失败!");
		}
		return null;
	}
	
	
	
}