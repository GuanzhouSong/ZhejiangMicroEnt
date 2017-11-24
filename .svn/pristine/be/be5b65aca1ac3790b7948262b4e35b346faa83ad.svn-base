/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.creditprove.mapper.CreditProveInfoMapper;
import com.icinfo.cs.creditprove.model.CreditProveInfo;
import com.icinfo.cs.creditprove.service.ICreditProveInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_credit_prove_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Service
public class CreditProveInfoServiceImpl extends MyBatisServiceSupport implements ICreditProveInfoService {
	@Autowired
	private CreditProveInfoMapper creditProveInfoMapper;
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年4月5日 下午2:10:18 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertCreditProveInfo(CreditProveInfo creditProveInfo)
			throws Exception {
		if(creditProveInfo!=null){
			creditProveInfo.setCreateTime(DateUtil.getSysDate());
			return creditProveInfoMapper.insert(creditProveInfo);
		}
		return 0;
	}
	
	/**
	 * @throws Exception 
	 * 
	 * 描述    生成出证单编号
	 * @author  赵祥江
	 * @date 2017年4月5日 下午2:14:23 
	 * @param  
	 * @throws
	 */
	@Override
	public String getProveNo(String proveType) throws Exception {
		String proveNo="";
		if("1".equals(proveType)){
			proveNo="B";
		}else{
			proveNo="P";
		}
		proveNo+=DateUtil.getCurrentDate().replaceAll("-","");
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("proveType", proveType);
		queryMap.put("nowDateStr", proveNo);
		Integer proveNoTem= creditProveInfoMapper.selectProveNoByProveType(queryMap);
		if(proveNoTem==null){
			proveNoTem=1;
		}else{
			proveNoTem+=1;
		}
		String proveNoTemStr=proveNoTem.toString();
		if(proveNoTemStr.length()<4){
			 for(int i=0;i<4-proveNoTemStr.length();i++){
				 proveNo+="0";
			 }
		}
		proveNo+=proveNoTemStr;
		return proveNo;
	}

	/**
	 * 
	 * 描述   分页查询
	 * @author  赵祥江
	 * @date 2017年4月5日 下午3:41:19 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CreditProveInfo> selectCreditProveInfoJSON(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return creditProveInfoMapper.selectCreditProveInfoJSON(request.getParams());
	}

	/**
	 * 
	 * 描述   根据查证单查询
	 * @author  赵祥江
	 * @date 2017年4月18日 上午10:47:54 
	 * @param  
	 * @throws
	 */
	@Override
	public List<CreditProveInfo> selectCreditProveInfoByProveNo(String proveNo)
			throws Exception {
		CreditProveInfo creditProveInfo=new CreditProveInfo();
		creditProveInfo.setProveNo(proveNo);
		return creditProveInfoMapper.select(creditProveInfo);
	}

	/**
	 * 
	 * 描述   总共单数
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:48 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectProveInfoCount(Map<String, Object> queryMap) {
		Integer proveInfoCount=creditProveInfoMapper.selectProveInfoCount(queryMap);
		if(proveInfoCount==null){
			proveInfoCount=0;
		}
		return proveInfoCount;
	}

	/**
	 * 
	 * 描述   企业户数
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:53 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectEntCount(Map<String, Object> queryMap) {
		Integer entCount=creditProveInfoMapper.selectEntCount(queryMap);
		if(entCount==null){
			entCount=0;
		}
		return entCount;
	}

	/**
	 * 
	 * 描述   自然人
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:45:57 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectManCount(Map<String, Object> queryMap) {
		Integer manCount=creditProveInfoMapper.selectManCount(queryMap);
		if(manCount==null){
			manCount=0;
		}
		return manCount;
	}
}