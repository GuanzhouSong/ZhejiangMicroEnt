/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptOptoExpiredDto;
import com.icinfo.cs.rpt.rptdto.RptReporteoverListDto;
import com.icinfo.cs.rpt.rptmapper.RptReporteoverListMapper;
import com.icinfo.cs.rpt.rptservice.IRptReporteoverListService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_rpt_reporteover_list 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月15日
 */
@Service
public class RptReporteoverListServiceImpl extends MyBatisServiceSupport implements IRptReporteoverListService {
  
	@Autowired
	private RptReporteoverListMapper rptReporteoverListMapper;
	
	/**
	 * 
	 * 描述: 首页统计（年报逾期未报详细列表）
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public PageResponse<RptReporteoverListDto> selectRptOptoExpiredList(PageRequest request)throws Exception{
		 // PageHelper.startPage(request.getPageNum(), request.getLength());
        Map<String, Object> queryMap = request.getParams();
        int pageSize = request.getLength ();
        queryMap.put ("numStart", (request.getPageNum () - 1) * pageSize);
        queryMap.put ("pageSize", pageSize);
        
        int total = rptReporteoverListMapper.selectRptReporteoverCount(queryMap);
        List<RptReporteoverListDto> list = rptReporteoverListMapper.selectRptReporteoverList(queryMap);
        
        return new PageResponse<RptReporteoverListDto> (list,total,request);
	}



}