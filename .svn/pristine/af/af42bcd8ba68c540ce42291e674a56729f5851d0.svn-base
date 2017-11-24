/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice.impl;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.SmRptAddcountDto;
import com.icinfo.cs.rpt.rptmapper.SmCountMonthRouteMapper;
import com.icinfo.cs.rpt.rptmapper.SmRptAddcountMapper;
import com.icinfo.cs.rpt.rptservice.ISmRptAddcountService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    sm_rpt_addcount 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Service
public class SmRptAddcountServiceImpl extends MyBatisServiceSupport implements ISmRptAddcountService {
	
    @Autowired
    private SmRptAddcountMapper smRptAddcountMapper;
	
	/**
	 * 
	 * 描述: 登记主表、年报主表、列入异常表、移出异常表数据量
	 * @auther gaojinling
	 * @date 2017年8月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SmRptAddcountDto> tableAddCount(Map<String, Object> map) throws Exception{
		return smRptAddcountMapper.tableAddCount(map);
	}
}