/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptQcdzZtQsDto;
import com.icinfo.cs.rpt.rptdto.RptQcdzZtcountDto;
import com.icinfo.cs.rpt.rptmodel.RptQcdzZtQs;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_rpt_qcdz_ztqs 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
public interface IRptQcdzZtQsService extends BaseService {
	
	/**
	 * 
	 * 描述: 大屏可视化--图一（当年新设消亡月趋势）
	 * @auther gaojinling
	 * @date 2017年9月25日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptQcdzZtQsDto> selectRptQcdzZtQsList(Map<String, Object> map)throws Exception;
	
	/**
	 * 
	 * 描述: 查询某月份数据是否存在
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param monthcode
	 * @return
	 * @throws Exception
	 */
	public int selectOne(String monthcode) throws Exception;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年10月10日 
	 * @param rptQcdzZtQs
	 * @return
	 * @throws Exception
	 */
	public int save(RptQcdzZtQs rptQcdzZtQs) throws Exception;
	
	public int delete(String monthcode) throws Exception;
	
	public int update(RptQcdzZtQs rptQcdzZtQs) throws Exception;
}