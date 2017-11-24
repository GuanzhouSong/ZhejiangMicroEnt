/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.DailyInspectResultCount;
import com.icinfo.cs.sccheck.dto.DailyInspectResultDto;
import com.icinfo.cs.sccheck.mapper.DailyInspectItemResultMapper;
import com.icinfo.cs.sccheck.mapper.DailyInspectResultMapper;
import com.icinfo.cs.sccheck.model.DailyInspectItemResult;
import com.icinfo.cs.sccheck.model.DailyInspectResult;
import com.icinfo.cs.sccheck.service.IDailyInspectResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_daily_inspect_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Service
public class DailyInspectResultServiceImpl extends MyBatisServiceSupport implements IDailyInspectResultService {

	@Autowired
	DailyInspectResultMapper dailyInspectResultMapper;

	@Autowired
	DailyInspectItemResultMapper dailyInspectItemResultMapper;

	@Override
	public List<DailyInspectResultDto> queryDailyInspectResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		String taskSource = (String) params.get("taskSource");
		if (StringUtils.isEmpty(taskSource) || "1,2,3,4".equals(taskSource)) {
			params.put("taskSource", null);
		}
		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}
		return dailyInspectResultMapper.selectDailyInspectResult(params);
	}

	@Override
	public DailyInspectResultCount queryDailyInspectResultCount(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		String taskSource = (String) params.get("taskSource");
		if (StringUtils.isEmpty(taskSource) || "1,2,3,4".equals(taskSource)) {
			params.put("taskSource", null);
		}
		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}
		return dailyInspectResultMapper.selectDailyInspectResultCount(params);
	}

	@Override
	@Transaction
	public int saveDailyInspectResult(Map<String, Object> map) throws Exception {
		DailyInspectResult dailyInspectResult = packDailyInspectResult(map);
		int m = 0;
		if (!StringUtil.isEmpty(dailyInspectResult.getUid())) {
			m = dailyInspectResultMapper.updateByPrimaryKeySelective(dailyInspectResult);
		} else {
			m = dailyInspectResultMapper.insert(dailyInspectResult);
		}
		if (m <= 0) {
			throw new Exception();
		}
		// 删除旧的检查事项信息
		deleteDailyInspectItemResultByResultUid(dailyInspectResult.getUid());
		// 保存日常检查事项信息
		saveDailyInspectItemResult(map, dailyInspectResult);
		return 1;
	}

	/**
	 * 描述：根据结果表uid删除检查事项信息
	 * 
	 * @author baifangfang
	 * @date 2017年11月9日
	 * @param uid
	 */
	private void deleteDailyInspectItemResultByResultUid(String resultUid) {
		DailyInspectItemResult dailyInspectItemResult = new DailyInspectItemResult();
		dailyInspectItemResult.setResultUid(resultUid);
		dailyInspectItemResultMapper.delete(dailyInspectItemResult);
	}

	/**
	 * 描述：保存日常检查事项信息
	 * 
	 * @author baifangfang
	 * @date 2017年11月7日
	 * @param map
	 * @param dailyInspectResultDto
	 */
	private void saveDailyInspectItemResult(Map<String, Object> map, DailyInspectResult dailyInspectResult) {
		for (int i = 1; i <= 1000; i++) {
			String problemKey = "problem" + i;
			String disposeKey = "dispose" + i;
			String checkName = "checkName" + i;
			String problemValue = (String) map.get(problemKey);
			String disposeValue = (String) map.get(disposeKey);
			String checkNameValue = (String) map.get(checkName);

			if (!StringUtil.isEmpty(checkNameValue)) {
				DailyInspectItemResult dailyInspectItemResult = new DailyInspectItemResult();
				dailyInspectItemResult.setCheckName(checkNameValue);
				dailyInspectItemResult.setDispose(disposeValue);
				dailyInspectItemResult.setProblem(problemValue);
				dailyInspectItemResult.setResultUid(dailyInspectResult.getUid());
				dailyInspectItemResultMapper.insert(dailyInspectItemResult);
			}
		}
	}

	/**
	 * 描述：组装需要保存的日常检查结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年11月7日
	 * @param map
	 * @throws ParseException
	 */
	private DailyInspectResult packDailyInspectResult(Map<String, Object> map) throws Exception {
		String state = (String) map.get("state");// 检查对象类型
		String checkObjType = (String) map.get("checkObjType");// 检查对象类型
		String checkObj = (String) map.get("checkObj");// 被检查对象
		String cidRegNO = (String) map.get("cidRegNO");// 统一代码/注册号
		String dom = (String) map.get("dom");// 住所地址
		String lerep = (String) map.get("lerep");// 负责人
		String tel = (String) map.get("tel");// 负责人电话
		String liaName = (String) map.get("liaName");// 联系人
		String liaTel = (String) map.get("liaTel");// 联系人电话
		String taskSource = (String) map.get("taskSource");// 任务来源
		String complainter = (String) map.get("complainter");// 投诉人
		String complainterTel = (String) map.get("complainterTel");// 投诉人联系电话
		String complaintType = (String) map.get("complaintType");// 投诉方式
		String complaintDateStr = (String) map.get("complaintDate");// 投诉日期
		String complaintContent = (String) map.get("complaintContent");// 投诉内容
		String checkType = (String) map.get("checkType");// 核查方式
		String checkResult = (String) map.get("checkResult");// 检查结果
		String disposeMss = (String) map.get("disposeMss");// 后续处置措施
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String checkDeptCode = (String) map.get("checkDeptCode");// 检查执行部门编码
		String checkDeptName = (String) map.get("checkDeptName");// 检查执行部门
		String checkOrgCode = (String) map.get("checkDeptCode");// 检查机关编码
		String checkOrgName = (String) map.get("checkDeptName");// 检查机关
		String checkDeptPerson = (String) map.get("checkDeptPerson");// 检查人员
		String checkDateStr = (String) map.get("checkDate");// 检查日期
		String enterUserName = (String) map.get("enterUserName");// 录入人员
		String enterDateStr = (String) map.get("enterDate");// 录入日期
		String priPID = (String) map.get("priPID");// 企业主体代码

		String alterContent = (String) map.get("alterContent");
		String alterUserName = (String) map.get("alterUserName");
		String alterDateStr = (String) map.get("alterDate");

		String uid = (String) map.get("uid");// 录入日期
		DailyInspectResult dailyInspectResult = new DailyInspectResult();
		if (!StringUtil.isEmpty(uid)) {
			dailyInspectResult.setUid(uid);
			dailyInspectResult = dailyInspectResultMapper.selectOne(dailyInspectResult);
		}

		if ("1".equals(state)) {
			dailyInspectResult.setAuditState("1");
		} else {
			dailyInspectResult.setAuditState("2");
		}
		dailyInspectResult.setState(state);
		dailyInspectResult.setPriPID(priPID);
		dailyInspectResult.setCheckObjType(checkObjType);
		dailyInspectResult.setCheckObj(checkObj);
		dailyInspectResult.setCidRegNO(cidRegNO);
		dailyInspectResult.setDom(dom);
		dailyInspectResult.setLerep(lerep);
		dailyInspectResult.setTel(tel);
		dailyInspectResult.setLiaName(liaName);
		dailyInspectResult.setLiaTel(liaTel);
		dailyInspectResult.setTaskSource(taskSource);
		dailyInspectResult.setComplainter(complainter);
		dailyInspectResult.setComplainterTel(complainterTel);
		dailyInspectResult.setComplaintType(complaintType);
		if (!StringUtil.isEmpty(complaintDateStr)) {
			Date complaintDate = DateUtil.parseDate(complaintDateStr, "yyyy-MM-dd");
			dailyInspectResult.setComplaintDate(complaintDate);
		}
		dailyInspectResult.setComplaintContent(complaintContent);
		dailyInspectResult.setCheckType(checkType);
		dailyInspectResult.setCheckResult(checkResult);
		dailyInspectResult.setDisposeMss(disposeMss);
		if ("未发现问题或相关问题已规范、已改正，无需后续处置；".equals(disposeMss)) {
			dailyInspectResult.setDisposeState("2");
			dailyInspectResult.setDisposeFinishDate(new Date());
		} else {
			dailyInspectResult.setDisposeState(disposeState);
			if (!StringUtil.isEmpty(disposeFinishDateStr)) {
				Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
				dailyInspectResult.setDisposeFinishDate(disposeFinishDate);
			}
		}
		dailyInspectResult.setCheckDeptCode(checkDeptCode);
		dailyInspectResult.setCheckDeptName(checkDeptName);
		dailyInspectResult.setCheckOrgCode(checkOrgCode);
		dailyInspectResult.setCheckOrgName(checkOrgName);
		dailyInspectResult.setCheckDeptPerson(checkDeptPerson);
		if (!StringUtil.isEmpty(checkDateStr)) {
			Date checkDate = DateUtil.parseDate(checkDateStr, "yyyy-MM-dd");
			dailyInspectResult.setCheckDate(checkDate);
		}
		dailyInspectResult.setEnterUserName(enterUserName);
		if (!StringUtil.isEmpty(enterDateStr)) {
			Date enterDate = DateUtil.parseDate(enterDateStr, "yyyy-MM-dd");
			dailyInspectResult.setEnterDate(enterDate);
		}

		dailyInspectResult.setAlterContent(alterContent);
		dailyInspectResult.setAlterUserName(alterUserName);
		if (!StringUtil.isEmpty(alterDateStr)) {
			Date alterDate = DateUtil.parseDate(alterDateStr, "yyyy-MM-dd");
			dailyInspectResult.setAlterDate(alterDate);
		}
		return dailyInspectResult;
	}

	@Override
	public int deleteByUid(String uid) {
		DailyInspectResult dailyInspectResult = new DailyInspectResult();
		dailyInspectResult.setUid(uid);
		return dailyInspectResultMapper.delete(dailyInspectResult);
	}

	@Override
	public DailyInspectResult queryDailyInspectResultByUid(String uid) {
		DailyInspectResult dailyInspectResult = new DailyInspectResult();
		dailyInspectResult.setUid(uid);
		return dailyInspectResultMapper.selectOne(dailyInspectResult);
	}

	@Override
	public int supplyDailyInspectResult(Map<String, Object> map) throws Exception {
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String uid = (String) map.get("uid");
		DailyInspectResult dailyInspectResult = queryDailyInspectResultByUid(uid);
		dailyInspectResult.setDisposeState(disposeState);
		if (!StringUtil.isEmpty(disposeFinishDateStr)) {
			Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
			dailyInspectResult.setDisposeFinishDate(disposeFinishDate);
		}
		int m = dailyInspectResultMapper.updateByPrimaryKeySelective(dailyInspectResult);
		return m;
	}

	@Override
	public List<DailyInspectResultDto> queryDailyInspectResultList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		String taskSource = (String) params.get("taskSource");
		if (StringUtils.isEmpty(taskSource) || "1,2,3,4".equals(taskSource)) {
			params.put("taskSource", null);
		}
		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}
		return dailyInspectResultMapper.selectDailyInspectResultList(params);
	}

	@Override
	public DailyInspectResultCount queryDailyInspectResultQueryCount(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		String taskSource = (String) params.get("taskSource");
		if (StringUtils.isEmpty(taskSource) || "1,2,3,4".equals(taskSource)) {
			params.put("taskSource", null);
		}
		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}
		return dailyInspectResultMapper.selectDailyInspectResultQueryCount(params);
	}
}