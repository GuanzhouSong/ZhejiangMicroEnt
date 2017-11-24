/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.mapper.PubSccheckItemResultMapper;
import com.icinfo.cs.sccheck.mapper.PubScentResultMapper;
import com.icinfo.cs.sccheck.model.PubSccheckItemResult;
import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.cs.sccheck.service.IPubSccheckItemResultService;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述: cs_pub_sccheck_item_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubSccheckItemResultServiceImpl extends MyBatisServiceSupport implements IPubSccheckItemResultService {

	@Autowired
	PubSccheckItemResultMapper pubSccheckItemResultMapper;

	@Autowired
	IPubSccheckTypeService pubSccheckTypeService;

	@Autowired
	IPubScentResultService pubScentResultService;

	@Autowired
	PubScentResultMapper pubScentResultMapper;

	@Override
	public List<PubSccheckItemResult> queryPubSccheckItemResultByTaskUidAndPriPID(String taskUid, String priPID) {
		PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
		pubSccheckItemResult.setTaskUid(taskUid);
		pubSccheckItemResult.setPriPID(priPID);
		return pubSccheckItemResultMapper.select(pubSccheckItemResult);
	}

	@Override
	@Transaction
	public int savePubSccheckItemResult(Map<String, Object> map, String name) {
		String taskUid = map.get("taskUid").toString();
		String priPID = map.get("priPID").toString();
		String uid = map.get("uid").toString();
		// 修改检查书状态为已设置
		PubScentResultDto pubScentResultDto = pubScentResultService.queryPubScentResultDtoByUid(uid);
		pubScentResultDto.setCheckTableFlag("1");
		pubScentResultDto.setCheckTableSetUser(name);// 设置检查结果表设置人
		pubScentResultDto.setCheckTableSetTime(DateUtil.getSysCurrentDate());// 设置检查结果表设置时间
		pubScentResultDto.setSetUserName(name);// 设置最近设置人
		pubScentResultDto.setSetTime(DateUtil.getSysCurrentDate());// 设置最近设置日期
		pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);

		// 删除旧的检查事项结果
		pubSccheckItemResultMapper.deletePubSccheckItemResultByTaskUidAndPriPID(map);
		// 添加新的检查事项结果
		// 36项检查情况
		for (int i = 1; i <= 12; i++) {
			DecimalFormat df = new DecimalFormat("00");
			String chkKey = "chk_A" + df.format(i);
			String chkValue = (String) map.get(chkKey);
			if (!StringUtil.isEmpty(chkValue)) {
				PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
				PubSccheckType pubSccheckType = pubSccheckTypeService.queryPubSccheckTypeByCode("A" + df.format(i));
				pubSccheckItemResult.setCheckCode(pubSccheckType.getCode());
				pubSccheckItemResult.setCheckName(pubSccheckType.getContent());
				pubSccheckItemResult.setPriPID(priPID);
				pubSccheckItemResult.setTaskUid(taskUid);
				pubSccheckItemResultMapper.insert(pubSccheckItemResult);
			}
		}
		for (int i = 13; i <= 22; i++) {
			DecimalFormat df = new DecimalFormat("00");
			String chkKey = "chk_B" + df.format(i - 12);
			String chkValue = (String) map.get(chkKey);
			if (!StringUtil.isEmpty(chkValue)) {
				PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
				PubSccheckType pubSccheckType = pubSccheckTypeService
						.queryPubSccheckTypeByCode("B" + df.format(i - 12));
				pubSccheckItemResult.setCheckCode(pubSccheckType.getCode());
				pubSccheckItemResult.setCheckName(pubSccheckType.getContent());
				pubSccheckItemResult.setPriPID(priPID);
				pubSccheckItemResult.setTaskUid(taskUid);
				pubSccheckItemResultMapper.insert(pubSccheckItemResult);
			}
		}
		for (int i = 23; i <= 36; i++) {
			DecimalFormat df = new DecimalFormat("00");
			String chkKey = "chk_C" + df.format(i - 22);
			String chkValue = (String) map.get(chkKey);
			if (!StringUtil.isEmpty(chkValue)) {
				PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
				PubSccheckType pubSccheckType = pubSccheckTypeService
						.queryPubSccheckTypeByCode("C" + df.format(i - 22));
				pubSccheckItemResult.setCheckCode(pubSccheckType.getCode());
				pubSccheckItemResult.setCheckName(pubSccheckType.getContent());
				pubSccheckItemResult.setPriPID(priPID);
				pubSccheckItemResult.setTaskUid(taskUid);
				pubSccheckItemResultMapper.insert(pubSccheckItemResult);
			}
		}
		// 其他检查情况
		for (int i = 1; i <= 1000; i++) {
			String checkName = "checkName_OTHER" + i;
			String checkNameValue = (String) map.get(checkName);
			if (!StringUtil.isEmpty(checkNameValue)) {
				PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
				String checkCode = "OTHER" + i;
				pubSccheckItemResult.setCheckCode(checkCode);
				pubSccheckItemResult.setCheckName(checkNameValue);
				pubSccheckItemResult.setPriPID(priPID);
				pubSccheckItemResult.setTaskUid(taskUid);
				pubSccheckItemResultMapper.insert(pubSccheckItemResult);
			}
		}
		return 1;
	}
	
	/**
	  * 描述：删除检查事项结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月13日
	 * @param oldDeptTaskUid
	 * @param priPID
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUidAndPriPID(String deptTaskUid, String priPID)throws Exception {
		Example example = new Example(PubSccheckItemResult.class);
		example.createCriteria().andEqualTo("taskUid", deptTaskUid).andEqualTo("priPID", priPID);
		pubSccheckItemResultMapper.deleteByExample(example);
	}
}