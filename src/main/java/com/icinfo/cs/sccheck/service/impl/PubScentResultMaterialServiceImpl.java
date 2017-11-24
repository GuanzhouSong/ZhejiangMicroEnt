/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.mapper.PubScentResultMapper;
import com.icinfo.cs.sccheck.mapper.PubScentResultMaterialMapper;
import com.icinfo.cs.sccheck.model.PubScentResultMaterial;
import com.icinfo.cs.sccheck.service.IPubScentResultMaterialService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;

import java.text.ParseException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: cs_pub_scent_result_material 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月13日
 */
@Service
public class PubScentResultMaterialServiceImpl extends MyBatisServiceSupport implements IPubScentResultMaterialService {

	@Autowired
	PubScentResultMaterialMapper pubScentResultMaterialMapper;

	@Autowired
	PubScentResultMapper pubScentResultMapper;

	@Autowired
	IPubScentResultService pubScentResultService;

	@Override
	@Transaction
	public int savePubScentResultMaterial(Map<String, Object> map, String name) throws ParseException {
		// 组装通知书信息
		PubScentResultMaterial pubScentResultMaterial = packPubScentResultMaterial(map);
		Object uidObj = map.get("uid");
		String resultUid = map.get("resultUid").toString();
		PubScentResultDto pubScentResultDto = pubScentResultService.queryPubScentResultDtoByUid(resultUid);
		pubScentResultMaterial.setMainTaskUid(pubScentResultDto.getMainTaskUid());
		pubScentResultMaterial.setTaskUid(pubScentResultDto.getTaskUid());
		if (uidObj != null && !StringUtil.isEmpty(uidObj.toString())) {
			// 修改
			pubScentResultMaterialMapper.updateByPrimaryKeySelective(pubScentResultMaterial);
		} else {
			// 修改通知书状态为已设置
			pubScentResultDto.setAdmissionFlag("1");
			pubScentResultDto.setAdmissionSetUser(name);// 设置通知书设置人
			pubScentResultDto.setAdmissionSetTime(DateUtil.getSysCurrentDate());// 设置通知书设置时间
			pubScentResultDto.setSetUserName(name);// 设置最近设置人
			pubScentResultDto.setSetTime(DateUtil.getSysCurrentDate());// 设置最近设置日期
			pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);
			// 保存
			pubScentResultMaterialMapper.insert(pubScentResultMaterial);
		}
		return 1;
	}

	/**
	 * 描述：组装通知书信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月14日
	 * @param map
	 * @return
	 * @throws ParseException
	 */
	private PubScentResultMaterial packPubScentResultMaterial(Map<String, Object> map) throws ParseException {
		Object idObj = map.get("id");
		Object uidObj = map.get("uid");
		String resultUid = map.get("resultUid").toString();
		String checkDateFrom = map.get("checkDateFrom").toString();
		String checkDateTo = map.get("checkDateTo").toString();
		String fillDate = map.get("fillDate").toString();
		String contactName = map.get("contactName").toString();
		String contactTel = map.get("contactTel").toString();
		String deptment = map.get("deptment").toString();
		String material = "";
		for (int i = 1; i < 1000; i++) {
			if (map.get("material" + i) != null && !StringUtil.isEmpty(map.get("material" + i).toString())) {
				material = material + map.get("material" + i).toString() + ",";
			}
		}
		if (!StringUtil.isEmpty(material)) {
			material.substring(0, material.length() - 1);
		}
		PubScentResultMaterial pubScentResultMaterial = new PubScentResultMaterial();
		if (idObj != null && !StringUtil.isEmpty(idObj.toString())) {
			pubScentResultMaterial.setId(Integer.parseInt(idObj.toString()));
		}
		if (uidObj != null) {
			pubScentResultMaterial.setUid(uidObj.toString());
		}
		pubScentResultMaterial.setCheckDateFrom(DateUtil.parseDate(checkDateFrom, "yyyy-MM-dd"));
		pubScentResultMaterial.setCheckDateTo(DateUtil.parseDate(checkDateTo, "yyyy-MM-dd"));
		pubScentResultMaterial.setFillDate(DateUtil.parseDate(fillDate, "yyyy-MM-dd"));
		pubScentResultMaterial.setContactName(contactName);
		pubScentResultMaterial.setContactTel(contactTel);
		pubScentResultMaterial.setDepartMent(deptment);
		pubScentResultMaterial.setResultUid(resultUid);
		pubScentResultMaterial.setMaterial(material);
		return pubScentResultMaterial;
	}

	@Override
	public PubScentResultMaterial findPubScentResultMaterialByResultUid(String uid) {
		PubScentResultMaterial pubScentResultMaterial = new PubScentResultMaterial();
		pubScentResultMaterial.setResultUid(uid);
		return pubScentResultMaterialMapper.selectOne(pubScentResultMaterial);
	}
}