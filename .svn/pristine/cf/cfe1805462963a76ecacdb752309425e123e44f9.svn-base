/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sccheck.mapper.PubSccheckTypeMapper;
import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述: cs_pub_sccheck_type 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubSccheckTypeServiceImpl extends MyBatisServiceSupport implements IPubSccheckTypeService {

	@Autowired
	PubSccheckTypeMapper pubSccheckTypeMapper;

	@Override
	public List<PubSccheckType> queryPubSccheckTypeList() {
		return pubSccheckTypeMapper.qryPubSccheckTypeList();
	}

	@Override
	public PubSccheckType queryPubSccheckTypeByCode(String code) {
		PubSccheckType pubSccheckType = new PubSccheckType();
		pubSccheckType.setCode(code);
		return pubSccheckTypeMapper.selectOne(pubSccheckType);
	}
	
	/**
	 * 
	 * 描述   获取所有检查事项
	 * @author  赵祥江
	 * @date 2017年5月18日 下午4:29:49 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubSccheckType> selectAllPubSccheckType() { 
		return pubSccheckTypeMapper.selectAll();
	}
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   根据编码查询
	 * @author  赵祥江
	 * @date 2017年5月18日 下午5:31:53 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubSccheckType> selectPubSccheckTypeList(
			Map<String, Object> queryMap) throws Exception {
		return pubSccheckTypeMapper.selectPubSccheckTypeList(queryMap);
	}
	


	/**
	 * 
	 * 描述: 执法事项树
	 * @auther gaojinling
	 * @date 2017年5月25日 
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectScPtypeMap(String sccheckCodeIn) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sccheckCodeIn", sccheckCodeIn);
		return pubSccheckTypeMapper.selectScPtypeTreeMap(params);
	}
	
	
	
}