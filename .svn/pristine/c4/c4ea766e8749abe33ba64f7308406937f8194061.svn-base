/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月05日
 * @version 2.0
 */
package com.icinfo.cs.creditprove.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.creditprove.model.CreditProveInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_credit_prove_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public interface CreditProveInfoMapper extends Mapper<CreditProveInfo> {
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年4月5日 下午3:43:41 
	 * @param 
	 * @return List<CreditProveInfo>
	 * @throws
	 */
	public  List<CreditProveInfo>  selectCreditProveInfoJSON(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   根据类型获取单号
	 * @author 赵祥江
	 * @date 2017年4月10日 下午4:00:24 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer selectProveNoByProveType (Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述   总共单数
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:48 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectProveInfoCount(Map<String,Object> queryMap);
	
	/**
	 * 
	 * 描述   企业户数
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:53 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectEntCount(Map<String,Object> queryMap);
	
	/**
	 * 
	 * 描述   自然人
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:57 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectManCount(Map<String,Object> queryMap);
	
}