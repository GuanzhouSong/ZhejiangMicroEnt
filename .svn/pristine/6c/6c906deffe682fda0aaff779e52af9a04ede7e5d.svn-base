/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.creditprove.mapper.CreditProvePrintHisMapper;
import com.icinfo.cs.creditprove.model.CreditProvePrintHis;
import com.icinfo.cs.creditprove.service.ICreditProvePrintHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_credit_prove_print_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Service
public class CreditProvePrintHisServiceImpl extends MyBatisServiceSupport implements ICreditProvePrintHisService {

	@Autowired
	private CreditProvePrintHisMapper creditProvePrintHisMapper;
	
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年4月5日 下午2:08:53 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertCreditProvePrintHis(CreditProvePrintHis creditProvePrintHis)
			throws Exception {
		if(creditProvePrintHis!=null){
			//查证单编号
			String proveNo=creditProvePrintHis.getProveNo();
			Map<String,Object> queryMap=new HashMap<String,Object>();
			queryMap.put("proveNo", proveNo);
			//根据查证单编号查询
			Integer proveNoTem= creditProvePrintHisMapper.selectCreditProvePrintNoByProveNo(queryMap);
			if(proveNoTem==null){
				proveNoTem=1;
			}else{
				proveNoTem+=1;
			}
			String printNo="";
			String proveNoTemStr=proveNoTem.toString();
			if(proveNoTemStr.length()<4){
				 for(int i=0;i<4-proveNoTemStr.length();i++){
					 printNo+="0";
				 }
				 printNo=printNo+proveNoTemStr;
			}else{
				printNo=proveNoTemStr;
			}
			creditProvePrintHis.setPrintNo(proveNo+"-"+printNo);
			creditProvePrintHis.setCreateTime(DateUtil.getSysDate());
			return creditProvePrintHisMapper.insert(creditProvePrintHis);
		}
		return 0;
	}

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
	@Override
	public List<CreditProvePrintHis> selectCreditProvePrintHisJSON(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProvePrintHisMapper.selectCreditProvePrintHisJSON(request.getParams());
	}
}