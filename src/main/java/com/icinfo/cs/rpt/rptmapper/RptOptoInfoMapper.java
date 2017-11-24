/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年03月22日
 * @version 2.0
 */
package com.icinfo.cs.rpt.rptmapper;


import java.util.Map;

import com.icinfo.cs.rpt.rptmodel.RptOptoInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_rpt_opto_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年03月22日
 */
public interface RptOptoInfoMapper extends Mapper<RptOptoInfo> {
	
	


	/**
	 * 
	 * 描述: 经营期限统计（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月23日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public RptOptoInfo selectRptOptoCount(Map<String,Object> queryMap)throws Exception;
	
	
}