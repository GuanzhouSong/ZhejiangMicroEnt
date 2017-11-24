/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.mapper.PubPbOpadetailMapper;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_pbopadetail 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
@Service
public class PubPbOpadetailServiceImpl extends MyBatisServiceSupport implements IPubPbOpadetailService {

	@Autowired
	PubPbOpadetailMapper pubPbOpadetailMapper;

	@Override
	public List<PubPbOpadetailDto> queryPubPbOpadetailDtoList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String norRea = (String) params.get("norRea");
		params.put("norReas", norRea.split(","));
		return pubPbOpadetailMapper.selectPubPbOpadetailDtoList(params);
	}

	@Override
	public int savePbOpadetail(PubPbOpadetail pubPbOpadetail) {
		return pubPbOpadetailMapper.insert(pubPbOpadetail);
	}

	@Override
	public PubPbOpadetailDto selectPubPbOpadetailDtoByBusExcList(String busExcList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("busExcList", busExcList);
		return pubPbOpadetailMapper.selectPubPbOpadetailByBusExcList(params);
	}
	
	/**
	 * 
	 * 描述   根据主体身份代码查询移出信息
	 * @author 赵祥江
	 * @date 2017年10月11日 上午11:49:32 
	 * @param 
	 * @return PubPbOpadetailDto
	 * @throws
	 */
	@Override
	public List<PubPbOpadetailDto> selectPubPbOpadetailByPriPID(String priPID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("priPID", priPID);
		return pubPbOpadetailMapper.selectPubPbOpadetailByPriPID(params);
	}
	
	
	

	@Override
	public int saveEditPbOpadetail(PubPbOpadetail pubPbOpadetail) {
		PubPbOpadetail ppo = new PubPbOpadetail();
		ppo.setBusExcList(pubPbOpadetail.getBusExcList());
		ppo = pubPbOpadetailMapper.selectOne(ppo);
		ppo.setNorRea(pubPbOpadetail.getNorRea());
		ppo.setNorReaCN(pubPbOpadetail.getNorReaCN());
		ppo.setRecoveryType(pubPbOpadetail.getRecoveryType());
		ppo.setRecoverRea(pubPbOpadetail.getRecoverRea());
		ppo.setFirstOpin(pubPbOpadetail.getFirstOpin());
		return pubPbOpadetailMapper.updateByPrimaryKeySelective(ppo);
	}

	@Override
	public int deletePbOpadetailByBusExcList(String busExcList) {
		PubPbOpadetail pubPbOpadetail = new PubPbOpadetail();
		pubPbOpadetail.setBusExcList(busExcList);
		return pubPbOpadetailMapper.delete(pubPbOpadetail);
	}

	@Override
	public int savePubPbOpadetailCheck(PubPbOpadetailDto ppod) {
		return pubPbOpadetailMapper.updateByPrimaryKeySelective(ppod);
	}
}