/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzTodayDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzToday;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_rpt_qcdz_today 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface IRptQcdzTodayService extends BaseService {
	
	
	/**
	 * 
	 * 描述:大屏--图三 今日注销新设数量查询
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzTodayDto> selectRptQcdzTodayList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzToday rptQcdzToday) throws Exception;
	
	/**
	 * 
	 * 描述: 删除(根据type和name删除)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete(String name,String type) throws Exception;
	
	/**
	 * 
	 * 描述: 更新
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int update(RptQcdzToday rptQcdzToday) throws Exception;
}