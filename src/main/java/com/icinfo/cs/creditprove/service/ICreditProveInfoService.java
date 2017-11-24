/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.creditprove.model.CreditProveInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_credit_prove_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public interface ICreditProveInfoService extends BaseService {
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年4月5日 下午2:09:59 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertCreditProveInfo(CreditProveInfo creditProveInfo)throws Exception;
	
	/**
	 * 
	 * 描述   根据查证单编号查询
	 * @author 赵祥江
	 * @date 2017年4月18日 上午10:45:11 
	 * @param 
	 * @return List<CreditProveInfo>
	 * @throws
	 */
	public List<CreditProveInfo> selectCreditProveInfoByProveNo(String  proveNo)throws Exception;
	
	
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年4月5日 下午3:40:56 
	 * @param 
	 * @return List<CreditProveInfo>
	 * @throws
	 */
	public List<CreditProveInfo>   selectCreditProveInfoJSON(PageRequest request)throws Exception;
	
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   生成出证单编号
	 * @author 赵祥江
	 * @date 2017年4月5日 下午2:13:52 
	 * @param 
	 * @return String
	 * @throws
	 */
	public String  getProveNo(String proveType) throws Exception;
	
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