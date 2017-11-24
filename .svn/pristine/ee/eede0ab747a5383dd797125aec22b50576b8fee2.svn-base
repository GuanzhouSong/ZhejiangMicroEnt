/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzYearCountDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzYearCount;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtcount;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_rpt_qcdz_yearcount 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface IRptQcdzYearCountService extends BaseService {
	
	/**
	 * 
	 * 描述: 大屏可视化--图四 近6年主体增长数量及增长率
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzYearCountDto> selectRptQcdzYearCountList(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzYearCount rptQcdzYearCount) throws Exception;
	
	/**
	 * 
	 * 描述: 删除(根据type和name删除)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @return
	 * @throws Exception
	 */
	public int delete(int year) throws Exception;
	
	/**
	 * 
	 * 描述: 更新(通过年份)
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param rptQcdzZtcount
	 * @return
	 * @throws Exception
	 */
	public int update(RptQcdzYearCount rptQcdzYearCount) throws Exception;
}