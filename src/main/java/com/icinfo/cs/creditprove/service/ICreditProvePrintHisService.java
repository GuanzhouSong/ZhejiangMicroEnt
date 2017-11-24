/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service;

import java.util.List;

import com.icinfo.cs.creditprove.model.CreditProvePrintHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_credit_prove_print_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
public interface ICreditProvePrintHisService extends BaseService {
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   根据查证单编号查询
	 * @author 赵祥江
	 * @date 2017年4月18日 下午2:00:36 
	 * @param 
	 * @return List<CreditProvePrintHis>
	 * @throws
	 */
	public List<CreditProvePrintHis>  selectCreditProvePrintHisJSON(PageRequest request) throws Exception;
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年4月5日 下午2:07:39 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertCreditProvePrintHis(CreditProvePrintHis creditProvePrintHis)throws Exception;

}