/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptOptoExpiredDto;
import com.icinfo.cs.rpt.rptdto.RptSmBaseinfoDto;
import com.icinfo.cs.rpt.rptmapper.RptOptoExpiredMapper;
import com.icinfo.cs.rpt.rptservice.IRptOptoExpiredService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_opto_expired 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
@Service
public class RptOptoExpiredServiceImpl extends MyBatisServiceSupport implements IRptOptoExpiredService {
 
	@Autowired
	private RptOptoExpiredMapper rptOptoExpiredMapper;
	
	/**
	 * 
	 * 描述: 首页统计（经营期限到期列表）
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageResponse<RptOptoExpiredDto> selectRptOptoExpiredList(PageRequest request)throws Exception{
		 // PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> queryMap = request.getParams();
        int pageSize = request.getLength ();
        queryMap.put ("numStart", (request.getPageNum () - 1) * pageSize);
        queryMap.put ("pageSize", pageSize);
        
        int total = rptOptoExpiredMapper.selectRptOptoExpiredCount(queryMap);
        List<RptOptoExpiredDto> list = rptOptoExpiredMapper.selectRptOptoExpiredList(queryMap);
        
        return new PageResponse<RptOptoExpiredDto> (list,total,request);
	}

}