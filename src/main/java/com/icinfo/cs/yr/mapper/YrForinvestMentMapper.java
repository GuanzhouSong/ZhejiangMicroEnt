/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.math.BigDecimal;
import java.util.Map;

import com.icinfo.cs.yr.model.YrForinvestMent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_yr_forinvestment 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface YrForinvestMentMapper extends Mapper<YrForinvestMent> {


	/**
	 * 
	 * 描述             : 根据年报年度和企业主体代码查询对外投资实缴总额
	 * @author: 赵祥江
	 * @date  : 2016年9月8日 下午6:58:37 
	 * @param :
	 * @return: BigDecimal
	 * @throws
	 */
	public BigDecimal selectInvestSumByYearAndPriPid(Map<String, Object> queryMap);
	
	/**
	 * 
	 * 描述   根据年报年度和企业主体代码查询对外投资认缴总额
	 * @author 赵祥江
	 * @date 2016年11月15日 下午5:39:12 
	 * @param 
	 * @return BigDecimal
	 * @throws
	 */
	public BigDecimal selectInvestSubConAmSumByYearAndPriPid(Map<String, Object> queryMap);



}