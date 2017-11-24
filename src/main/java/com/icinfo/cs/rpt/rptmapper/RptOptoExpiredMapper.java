/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月14日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptdto.RptOptoExpiredDto;
import com.icinfo.cs.rpt.rptmodel.RptOptoExpired;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_rpt_opto_expired 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
public interface RptOptoExpiredMapper extends Mapper<RptOptoExpired> {
	
	/**
	 * 
	 * 描述: 首页统计（经营期限到期列表）
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<RptOptoExpiredDto> selectRptOptoExpiredList(Map<String, Object> map)throws Exception;
	
	/**
	 * 
	 * 描述: 首页统计（经营期限到期列表条数）
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectRptOptoExpiredCount(Map<String, Object> map)throws Exception;
	
}