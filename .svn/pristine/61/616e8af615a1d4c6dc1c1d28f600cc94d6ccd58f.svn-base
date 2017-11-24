/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentResultDto;
import com.icinfo.cs.sccheck.dto.SccheckCount;
import com.icinfo.cs.sccheck.mapper.PubSccheckItemResultMapper;
import com.icinfo.cs.sccheck.mapper.PubScentResultMapper;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubSccheckItemResult;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.sccheck.service.ISccheckKeyService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_scent_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubScentResultServiceImpl extends MyBatisServiceSupport implements IPubScentResultService {

	private static final String TOKEN_KEY = "3b679f7cf55011e5bb520171018T839ae8";
	private static final String HZ_TOKEN_KEY = "3b679f7cf55011e5hz520171018T839ae8";
	private static final String RESULT_FAIL_TYPE = "fail";
	private static final String RESULT_SUCCESS_TYPE = "success";
	@Autowired
	PubScentResultMapper pubScentResultMapper;

	@Autowired
	IPubSccheckTypeService pubSccheckTypeService;

	@Autowired
	PubSccheckItemResultMapper pubSccheckItemResultMapper;
	
	@Autowired
	IPubSccheckItemService pubSccheckItemService;

	@Autowired
	IPubScdeptTaskService pubScdeptTaskService;
	
	@Autowired
	IPubScPlanTaskService pubScPlanTaskService;
	
	@Autowired
	IPubScentService pubScentService;
	
	@Autowired
	ISccheckKeyService sccheckKeyService;
	

	@Override
	public List<PubScentResultDto> queryPageResult(PageRequest request, SysUserDto sysUserDto) {
		Map<String, Object> params = request.getParams();
		// String deptCode = "2".equals(sysUserDto.getUserType()) ?
		// sysUserDto.getSysDepart().getAdcode()
		// : sysUserDto.getDepartMent().getDeptCode();
		// if(deptCode.length() > 8){
		// deptCode = deptCode.substring(0, 8);
		// }else if (deptCode.length() == 6){
		// deptCode = deptCode+"00";
		// }
		// params.put("unitDeptCode", deptCode);

		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			String deptCode = sysUserDto.getSysDepart().getAdcode();
			params.put("unitDeptCode", deptCode);
		}else{
			String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
					: sysUserDto.getDepartMent().getDeptCode();
			String userid = sysUserDto.getId();
			deptCode = deptCode.substring(0, 6);
			params.put("userId", userid);
			params.put("deptCode", deptCode);
		}
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}

		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}

		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.queryPageResult(params);
	}

	/**
	 * 描述：抽查检查数据列表
	 * 
	 * @author chenxin
	 * @date 2017年6月28日
	 * @param request
	 * @return
	 */
	@Override
	public List<PubScentResultDto> queryPageSearchResult(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.queryPageSearchResult(params);
	}

	@Override
	public SccheckCount querySccheckCount(PageRequest request, SysUserDto sysUserDto) {
		Map<String, Object> params = request.getParams();
		// String deptCode = "2".equals(sysUserDto.getUserType()) ?
		// sysUserDto.getSysDepart().getAdcode()
		// : sysUserDto.getDepartMent().getDeptCode();
		// if(deptCode.length() > 8){
		// deptCode = deptCode.substring(0, 8);
		// }else if (deptCode.length() == 6){
		// deptCode = deptCode+"00";
		// }
		// params.put("unitDeptCode", deptCode);

		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			String deptCode = sysUserDto.getSysDepart().getAdcode();
			params.put("unitDeptCode", deptCode);
		}else{
			String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
					: sysUserDto.getDepartMent().getDeptCode();
			String userid = sysUserDto.getId();
			deptCode = deptCode.substring(0, 6);
			params.put("userId", userid);
			params.put("deptCode", deptCode);
		}
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResult", Arrays.asList(checkResult.split(",")));
		}
		return pubScentResultMapper.querySccheckCount(params);
	}
	
	/**
	 * 描述：抽查查询结果统计
	 * 
	 * @author yujingwei
	 * @date 2017年10月12日
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	public SccheckCount selectSccheckCount(SysUserDto sysUserDto) throws Exception{
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new SccheckCount(); 
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		String userid = sysUserDto.getId();
		deptCode = deptCode.substring(0, 6);
		qryMap.put("userId", userid);
		qryMap.put("deptCode", deptCode);
		qryMap.put("auditState", "1,2,4,5");
		setDefaultParams(sysUserDto, qryMap);
		return pubScentResultMapper.querySccheckCount(qryMap);
	}
	
	/**
	 * 描述：设置默认职能部门参数
	 * @author chenxin
	 * @date 2017-10-12
	 * @param sysUser
	 * @param queryMap
	 */
	private void setDefaultParams(SysUserDto sysUser,Map<String,Object>	queryMap){
		//职能部门编码
		if("1".equals(sysUser.getUserType())){
			queryMap.put("dutyDeptCodes","A058,A012,A027");
		}else if("2".equals(sysUser.getUserType())){
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
				queryMap.put("dutyDeptCodes","A058,A012,A027");
			}else{
				queryMap.put("dutyDeptCodes",sysUser.getDutyDeptCodes());
			}
		}
		if(queryMap.get("dutyDeptCodes")!=null&&StringUtils.isNotBlank(queryMap.get("dutyDeptCodes").toString())){
			queryMap.put("dutyDeptCodeArr",queryMap.get("dutyDeptCodes").toString().split(","));
		}
	}

	/**
	 * 描述：抽查查询结果统计
	 * 
	 * @author baifangfang
	 * @date 2017年5月17日
	 * @param request
	 * @param sysUserDto
	 * @return
	 */
	@Override
	public SccheckCount querySccheckSearchCount(PageRequest request) {
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtils.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		return pubScentResultMapper.querySccheckSearchCount(params);
	}

	@Override
	@Transaction
	public int savePubScentResult(Map<String, Object> map, SysUserDto sysUser) throws Exception {
		// 检查结果
		PubScentResultDto pubScentResultDto = packPubScResultDto(map);
		pubScentResultDto.setEnterUserName(sysUser.getRealName());
		pubScentResultDto.setEnterDate(new Date());
		pubScentResultDto.setSetUserName(sysUser.getRealName());
		pubScentResultDto.setSetTime(new Date());
		int m = pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);
		if (m <= 0) {
			throw new Exception();
		}
		// 删除旧的检查事项结果
		pubSccheckItemResultMapper.deletePubSccheckItemResultByTaskUidAndPriPID(map);
		// 检查事项结果
		savePubSccheckItemResult(map, pubScentResultDto);
		return 1;
	}

	/**
	 * 描述：保存检查事项结果
	 * 
	 * @author baifangfang
	 * @date 2017年5月20日
	 * @param map
	 * @param pubScentResultDto
	 */
	private void savePubSccheckItemResult(Map<String, Object> map, PubScentResultDto pubScentResultDto) {
		// 36项检查情况
		for (int i = 1; i <= 12; i++) {
			DecimalFormat df = new DecimalFormat("00");
			saveItemResults("A", df.format(i), map, pubScentResultDto);
		}
		for (int i = 13; i <= 22; i++) {
			DecimalFormat df = new DecimalFormat("00");
			saveItemResults("B", df.format(i - 12), map, pubScentResultDto);
		}
		for (int i = 23; i <= 36; i++) {
			DecimalFormat df = new DecimalFormat("00");
			saveItemResults("C", df.format(i - 22), map, pubScentResultDto);
		}
		// 其他检查情况
		for (int i = 1; i <= 1000; i++) {
			saveItemResults("OTHER", i+"", map, pubScentResultDto);
		}
	}
	
	/**
	 * 保存检查事项
	 * @param word
	 * @param num
	 * @param map
	 * @param pubScentResultDto
	 * @throws Exception
	 */
	private void saveItemResults(String word,String num,Map<String, Object> map, PubScentResultDto pubScentResultDto){
		String problemKey = "problem_"+word + num;
		String disposeKey = "dispose_"+word + num;
		String checkName = "checkName_"+word + num;
		String chkKey = "chk_"+word + num;
		String problemValue = (String) map.get(problemKey);
		String disposeValue = (String) map.get(disposeKey);
		String checkNameValue = (String) map.get(checkName);
		String chkValue = (String) map.get(chkKey);
		if (StringUtil.isEmpty(chkValue)) {
			problemValue = null;
			disposeValue = null;
		}

		if (!StringUtil.isEmpty(checkNameValue)) {
			PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
			String checkCode = word + num;
			pubSccheckItemResult.setCheckCode(checkCode);
			pubSccheckItemResult.setCheckName(checkNameValue);
			pubSccheckItemResult.setCheckType(pubScentResultDto.getCheckType());
			pubSccheckItemResult.setDispose(disposeValue);
			pubSccheckItemResult.setPriPID(pubScentResultDto.getPriPID());
			pubSccheckItemResult.setProblem(problemValue);
			pubSccheckItemResult.setTaskUid(pubScentResultDto.getTaskUid());
			pubSccheckItemResultMapper.insert(pubSccheckItemResult);
		}
	}

	/**
	 * 描述：组装需要保存的结果信息
	 * 
	 * @author Administrator
	 * @date 2017年5月18日
	 * @param map
	 * @throws ParseException
	 */
	private PubScentResultDto packPubScResultDto(Map<String, Object> map) throws ParseException {
		String checkType = (String) map.get("checkType");// 核查方式
		String checkResult = (String) map.get("checkResult");// 检查结果
		String disposeMss = (String) map.get("disposeMss");// 后续处置措施
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String checkDeptName = (String) map.get("checkDeptName");// 检查执行部门
		String checkDeptPerson = (String) map.get("checkDeptPerson");// 检查人员
		String checkDateStr = (String) map.get("checkDate");// 检查日期
		String disposeFinishMss = (String) map.get("disposeFinishMss");// 后续处置完结信息
		// String taskUid = (String) map.get("taskUid");// 任务序号
		// String priPID = (String) map.get("priPID");// 企业内部序号
		String uid = (String) map.get("uid");
		PubScentResultDto pubScentResultDto = queryPubScentResultDtoByUid(uid);
		if ("未发现问题或相关问题已规范、已改正，无需后续处置；".equals(disposeMss)) {
			pubScentResultDto.setDisposeState("2");
		} else {
			pubScentResultDto.setDisposeState(disposeState);
		}

		pubScentResultDto.setCheckType(checkType);
		pubScentResultDto.setCheckResult(checkResult);
		pubScentResultDto.setDisposeMss(disposeMss);
		pubScentResultDto.setAuditState("2");
		pubScentResultDto.setDisposeFinishMss(disposeFinishMss);
		// 检查结果录入后设置检查表为已设置的状态
		pubScentResultDto.setCheckTableFlag("1");
		if (!StringUtil.isEmpty(disposeFinishDateStr)) {
			Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
			pubScentResultDto.setDisposeFinishDate(disposeFinishDate);
		}
		pubScentResultDto.setCheckDeptName(checkDeptName);
		pubScentResultDto.setCheckDeptPerson(checkDeptPerson);
		if (!StringUtil.isEmpty(checkDateStr)) {
			Date checkDate = DateUtil.parseDate(checkDateStr, "yyyy-MM-dd");
			pubScentResultDto.setCheckDate(checkDate);
		}
		return pubScentResultDto;
	}

	@Override
	@Transaction
	public int alterPubScentResult(Map<String, Object> map) throws Exception {
		// 检查结果
		PubScentResultDto pubScentResultDto = packPubScResultDto(map);
		int m = pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);
		if (m <= 0) {
			throw new Exception();
		}

		// 删除旧的检查事项结果
		pubSccheckItemResultMapper.deletePubSccheckItemResultByTaskUidAndPriPID(map);
		// 添加新的检查事项结果
		savePubSccheckItemResult(map, pubScentResultDto);
		return 1;
	}

	@Override
	@Transaction
	public int auditPubScentResult(Map<String, Object> map) throws Exception {
		// 检查结果
		PubScentResultDto pubScentResultDto = packPubScResultDtoToAudit(map);
		String auditState = (String) map.get("auditState");
		int m = pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);

		if ("5".equals(auditState)) {// 审核通过
			pubScdeptTaskService.updatePubScdeptTaskByEnt(pubScentResultDto.getTaskUid());
		}
		if (m <= 0) {
			throw new Exception();
		}

		// 删除旧的检查事项结果
		pubSccheckItemResultMapper.deletePubSccheckItemResultByTaskUidAndPriPID(map);
		// 添加新的检查事项结果
		savePubSccheckItemResult(map, pubScentResultDto);
		return 1;
	}

	/**
	 * 描述：组装需要保存的结果信息(审核功能使用)
	 * 
	 * @author baifangfang
	 * @date 2017年5月18日
	 * @param map
	 * @throws ParseException
	 */
	private PubScentResultDto packPubScResultDtoToAudit(Map<String, Object> map) throws ParseException {
		String checkType = (String) map.get("checkType");// 核查方式
		String checkResult = (String) map.get("checkResult");// 检查结果
		String disposeMss = (String) map.get("disposeMss");// 后续处置措施
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String checkDeptName = (String) map.get("checkDeptName");// 检查执行部门
		String checkDeptPerson = (String) map.get("checkDeptPerson");// 检查人员
		String checkDateStr = (String) map.get("checkDate");// 检查日期
		// String taskUid = (String) map.get("taskUid");// 任务序号
		String auditState = (String) map.get("auditState");// 审核结果
		String auditUserName = (String) map.get("auditUserName");// 审核员
		String auditOpinion = (String) map.get("auditOpinion");// 审核意见
		String auditDateStr = (String) map.get("auditDate");// 审核日期
		String disposeFinishMss = (String) map.get("disposeFinishMss");// 后续处置完结信息
		// String priPID = (String) map.get("priPID");// 企业内部序号
		if ("未发现问题或相关问题已规范、已改正，无需后续处置；".equals(disposeMss)) {
			map.put("disposeState", 2);
		}
		String uid = (String) map.get("uid");
		PubScentResultDto pubScentResultDto = queryPubScentResultDtoByUid(uid);
		pubScentResultDto.setCheckType(checkType);
		pubScentResultDto.setCheckResult(checkResult);
		pubScentResultDto.setDisposeMss(disposeMss);
		pubScentResultDto.setDisposeState(disposeState);
		pubScentResultDto.setAuditState(auditState);
		if (!StringUtil.isEmpty(disposeFinishDateStr)) {
			Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
			pubScentResultDto.setDisposeFinishDate(disposeFinishDate);
		}
		pubScentResultDto.setCheckDeptName(checkDeptName);
		pubScentResultDto.setCheckDeptPerson(checkDeptPerson);
		pubScentResultDto.setDisposeFinishMss(disposeFinishMss);

		if (!StringUtil.isEmpty(checkDateStr)) {
			Date checkDate = DateUtil.parseDate(checkDateStr, "yyyy-MM-dd");
			pubScentResultDto.setCheckDate(checkDate);
		}
		if (!StringUtil.isEmpty(auditDateStr)) {
			Date auditDate = DateUtil.parseDate(auditDateStr, "yyyy-MM-dd");
			pubScentResultDto.setAuditDate(auditDate);
		}
		pubScentResultDto.setAuditOpinion(auditOpinion);
		pubScentResultDto.setAuditUserName(auditUserName);
		return pubScentResultDto;
	}

	/**
	 * 描述：插入结果表记录
	 * 
	 * @author chenxin
	 * @date 2017年5月20日
	 * @param pubScentResult
	 * @return
	 */
	@Override
	public void savePubScentResult(PubScentResult pubScentResult) {
		if (pubScentResult != null) {
			pubScentResultMapper.insertSelective(pubScentResult);
		}
	}

	/**
	 * 描述：查看是否本次任务涉及的所有企业都已经录入结果并且公示
	 * 
	 * @author chenxin
	 * @date 2017年5月27日
	 * @param deptTaskUid
	 * @return
	 */
	@Override
	public int seleteUnfinishedEnt(String deptTaskUid) {
		Example example = new Example(PubScentResult.class);
		example.createCriteria().andEqualTo("taskUid", deptTaskUid).andNotEqualTo("auditState", "5");
		return pubScentResultMapper.selectCountByExample(example);
	}
	
	/**
	 * 描述：查看是否本次任务涉及的所有企业都已经录入结果并且公示(跳过执法人员抽取抽取步骤)
	 * 
	 * @author chenxin
	 * @date 2017年5月27日
	 * @param deptTaskUid
	 * @return
	 */
	@Override
	public int seleteUnfinishedEntNoRandom(String deptTaskUid) {
		return pubScentResultMapper.selectCountNotFinishNum(deptTaskUid);
	}

	@Override
	public List<PubScentResultDto> queryPageResultPub(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.queryPageResultByPriPID(request.getParams());
	}

	@Override
	public PubScentResultDto queryPubScentResultDtoByUid(String uid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("uid", uid);
		return pubScentResultMapper.selectPubScentResultDtoByUid(params);
	}

	@Override
	public List<PubScentResultDto> queryPreParePageResult(PageRequest request, SysUserDto sysUserDto) {
		Map<String, Object> params = request.getParams();
		// String deptCode = "2".equals(sysUserDto.getUserType()) ?
		// sysUserDto.getSysDepart().getAdcode()
		// : sysUserDto.getDepartMent().getDeptCode();
		// if(deptCode.length() > 8){
		// deptCode = deptCode.substring(0, 8);
		// }else if (deptCode.length() == 6){
		// deptCode = deptCode+"00";
		// }
		// params.put("unitDeptCode", deptCode);

		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		String userid = sysUserDto.getId();
		deptCode = deptCode.substring(0, 6);
		params.put("userId", userid);
		params.put("deptCode", deptCode);
		String checkDeptPerson = (String) params.get("checkDeptPerson");
		if (!StringUtil.isEmpty(checkDeptPerson)) {
			params.put("checkDeptPersons", checkDeptPerson.split(","));
		}
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.queryPreParePageResult(params);
	}

	@Override
	public int supplyPubScentResult(Map<String, Object> map) throws ParseException {
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String disposeFinishMss = (String) map.get("disposeFinishMss");// 后续处置完结信息
		String uid = (String) map.get("uid");
		PubScentResultDto pubScentResultDto = queryPubScentResultDtoByUid(uid);
		pubScentResultDto.setDisposeState(disposeState);
		pubScentResultDto.setDisposeFinishMss(disposeFinishMss);
		if (!StringUtil.isEmpty(disposeFinishDateStr)) {
			Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
			pubScentResultDto.setDisposeFinishDate(disposeFinishDate);
		}
		int m = pubScentResultMapper.updateByPrimaryKeySelective(pubScentResultDto);
		return m;
	}

	/**
	 * 
	 * 描述: 综合抽查结果统计
	 * 
	 * @auther chenxin
	 * @date 2017年6月26日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentResultDto> selectScentResultCount(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), 10000);
		return pubScentResultMapper.selectScentResultCount(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 抽查工作情况统计
	 * @auther chenxin
	 * @date 2017年6月26日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentResultDto> selectCheckWorkCount(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), 10000);
		return pubScentResultMapper.selectCheckWorkCount(request.getParams());
	}

	/**
	 * 描述: 更新
	 * 
	 * @auther chenxin
	 * @date 2017年6月26日
	 * @param pubScentResult
	 */
	@Override
	public void updatePubScentResultByUid(PubScentResult pubScentResult) {
		Example example = new Example(PubScentResult.class);
		example.createCriteria().andEqualTo("uid", pubScentResult.getUid());
		pubScentResultMapper.updateByExampleSelective(pubScentResult, example);
	}

	/**
	 * 描述: 指派检查机关
	 * 
	 * @auther chenxin
	 * @date 2017年6月26日
	 * @param oldDeptTaskUid
	 * @param priPID
	 * @param newDeptTaskUid
	 * @param deptState
	 */
	@Override
	public void appointEntResult(String oldDeptTaskUid, String priPID, String newDeptTaskUid,String scentUid) throws Exception {
		Example example = new Example(PubScentResult.class);
		example.createCriteria().andEqualTo("taskUid", oldDeptTaskUid).andEqualTo("priPID", priPID).andEqualTo("scentUid", scentUid);
		PubScentResult pubScentResult = new PubScentResult();
		pubScentResult.setTaskUid(newDeptTaskUid);
		pubScentResultMapper.updateByExampleSelective(pubScentResult, example);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("taskUid", newDeptTaskUid);
		params.put("priPID", priPID);
		params.put("scentUid", scentUid);
		pubScentResultMapper.doUpdateDefaultNull(params);
	}

	/**
	 * 描述: 删除
	 * 
	 * @auther chenxin
	 * @date 2017年6月26日
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUidAndPriPID(String taskUid, String priPID,String scentUid) throws Exception {
		Example example = new Example(PubScentResult.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("priPID", priPID).andEqualTo("scentUid", scentUid);
		pubScentResultMapper.deleteByExample(example);
	}
	
	/**
	 * 描述: 删除
	 * @auther chenxin
	 * @date 2017年6月26日
	 * @param taskUid
	 * @param priPID
	 * @throws Exception
	 */
	@Override
	public void deleteByTaskUid(String deptTaskUid) throws Exception {
		Example example = new Example(PubScentResult.class);
		example.createCriteria().andEqualTo("taskUid", deptTaskUid);
		pubScentResultMapper.deleteByExample(example);
	}
	
	/**
	 * 描述：双随机结果数据导入
	 * @author chenxin
	 * @date 2017年06月20日 
	 * @param token，args
	 * @return JSONObject
	 * @throws Exception
	 */
	@Override
	public JSONObject saveBathResults(String token, String args)throws Exception {
		JSONObject jsonObject = new JSONObject();
		// 开始前的参数校验
		if(HZ_TOKEN_KEY.equals(token)){
			return saveHzResult(args);
		}
		if(!TOKEN_KEY.equals(token)){
			returnMsgInfo(RESULT_FAIL_TYPE,"token会话口令验证不通过","0",jsonObject);
			return jsonObject;  
		}
		if(StringUtil.isBlank(args)){
			returnMsgInfo(RESULT_FAIL_TYPE,"参数不能为空","0",jsonObject);
			return jsonObject;  
		}
		JSONArray array = JSONArray.fromObject(StringEscapeUtils.unescapeHtml4(args));
		String message = "";
		int failCount = 0;
		int successCount = 0;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<array.size();i++){
			try{
				JSONObject object = array.getJSONObject(i);
				String taskCode = object.getString("taskCode");
				String priPID = object.getString("priPID");
				if(StringUtils.isEmpty(taskCode)){
					message += "第["+(i+1)+"]条记录,任务编号为空；";
					failCount ++;
					continue;
				}
				if(StringUtils.isEmpty(priPID)){
					message += "第["+(i+1)+"]条记录,企业内部序号为空；";
					failCount ++;
					continue;
				}
				//1.判断是否该任务编号有对应的任务信息
				List<PubScPlanTask> pubScPlanTaskList = pubScPlanTaskService.selectPubScPlanTaskByTaskCode(taskCode);
				if(pubScPlanTaskList == null || pubScPlanTaskList.size() > 1 || pubScPlanTaskList.size() == 0){
					message += "第["+(i+1)+"]条记录,任务编号异常请先确认任务编号是否正确；";
					failCount ++;
					continue;
				}
				PubScPlanTask pubScPlanTask = pubScPlanTaskList.get(0);
				if("01".equals(pubScPlanTask.getTaskState())){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"]的任务还未抽取企业；";
					failCount ++;
					continue;
				}
				String taskUid = pubScPlanTask.getUid();
				//2.查询该企业是否本次任务被抽中
				PubScent pubScent = pubScentService.selectEntByPriPIDTaskUid(taskUid, priPID);
				if(pubScent == null){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"]的任务未抽中该企业,内部序号["+priPID+"]；";
					failCount ++;
					continue;
				}
				//3.查询该企业是否已经被抽取过执法人员
				PubScdeptTask pubScdeptTask = pubScdeptTaskService.selectPubScdeptTaskByUid(pubScent.getDeptTaskUid());
				if("1".equals(pubScdeptTask.getDeptState())){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"],企业内部序号["+priPID+"]对应的检查部门还未抽取执法人员，不允许导入数据；";
					failCount ++;
					continue;
				}
				PubScentResult pubScentResult = selectByScentUid(pubScent.getUid());
				if(!"1".equals(pubScentResult.getAuditState())){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"],企业内部序号["+priPID+"]已有检查结果，不允许重复导入；";
					failCount ++;
					continue;
				}
				if(pubScentResult != null){
					//4.保存结果信息和检查事项
					saveJsonObject(object,pubScentResult,"update","数据导入默认审核通过。");
					if(StringUtils.isNotEmpty(pubScentResult.getTaskUid())){
						if(!set.contains(pubScentResult.getTaskUid())){
							set.add(pubScentResult.getTaskUid());
						}
					}
					successCount ++;
					continue;
				}
			}catch(Exception e){
				message += "第["+(i+1)+"]条记录解析失败请确认数据是否正确；";
				failCount ++;
				continue;
			}
		}
		if(!set.isEmpty()){
			//5.更新任务状态
			for(String taskuid : set){
				pubScdeptTaskService.updatePubScdeptTaskByEnt(taskuid);
			}
		}
		String resultMss = "本次导入成功"+successCount+"条记录；"+"导入失败"+failCount+"条记录；";
		if(StringUtils.isNotEmpty(message)){
			resultMss = resultMss+"失败原因如下："+message;
		}
		if(successCount == 0){
			returnMsgInfo(RESULT_FAIL_TYPE,resultMss,"0",jsonObject);
		}else{
			returnMsgInfo(RESULT_SUCCESS_TYPE,resultMss,"1",jsonObject);
		}
		return jsonObject;
	}

	/**
	 * 保存杭州结果数据（跳过执法人员抽取阶段）
	 * @param args
	 * @return
	 * @throws Exception
	 */
	private JSONObject saveHzResult(String args)throws Exception {
		JSONObject jsonObject = new JSONObject();
		JSONArray array = JSONArray.fromObject(StringEscapeUtils.unescapeHtml4(args));
		String message = "";
		int failCount = 0;
		int successCount = 0;
		Set<String> set = new HashSet<String>();
		for(int i=0;i<array.size();i++){
			try{
				JSONObject object = array.getJSONObject(i);
				String taskCode = object.getString("taskCode");
				String priPID = object.getString("priPID");
				if(StringUtils.isEmpty(taskCode)){
					message += "第["+(i+1)+"]条记录,任务编号为空；";
					failCount ++;
					continue;
				}
				if(StringUtils.isEmpty(priPID)){
					message += "第["+(i+1)+"]条记录,企业内部序号为空；";
					failCount ++;
					continue;
				}
				//1.判断是否该任务编号有对应的任务信息
				List<PubScPlanTask> pubScPlanTaskList = pubScPlanTaskService.selectPubScPlanTaskByTaskCode(taskCode);
				if(pubScPlanTaskList == null || pubScPlanTaskList.size() > 1 || pubScPlanTaskList.size() == 0){
					message += "第["+(i+1)+"]条记录,任务编号异常请先确认任务编号是否正确；";
					failCount ++;
					continue;
				}
				PubScPlanTask pubScPlanTask = pubScPlanTaskList.get(0);
				if("01".equals(pubScPlanTask.getTaskState())){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"]的任务还未抽取企业；";
					failCount ++;
					continue;
				}
				String taskUid = pubScPlanTask.getUid();
				//2.查询该企业是否本次任务被抽中
				PubScent pubScent = pubScentService.selectEntByPriPIDTaskUid(taskUid, priPID);
				if(pubScent == null){
					message += "第["+(i+1)+"]条记录,任务编号为["+taskCode+"]的任务未抽中该企业,内部序号["+priPID+"]；";
					failCount ++;
					continue;
				}
				String operateType="update";
				PubScentResult pubScentResult = selectByScentUid(pubScent.getUid());//跳过执法人员抽取过程
				if(pubScentResult == null){
					pubScentResult = createPubScentResult(pubScent);
					operateType="insert";
				}
				if(pubScentResult != null){
					//4.保存结果信息和检查事项
					saveJsonObject(object,pubScentResult,operateType,"杭州数据导入默认审核通过。");
					if(StringUtils.isNotEmpty(pubScentResult.getTaskUid())){
						if(!set.contains(pubScentResult.getTaskUid())){
							set.add(pubScentResult.getTaskUid());
						}
					}
					successCount ++;
					continue;
				}
			}catch(Exception e){
				message += "第["+(i+1)+"]条记录解析失败请确认数据是否正确；";
				failCount ++;
				continue;
			}
		}
		if(!set.isEmpty()){
			//5.更新任务状态
			for(String taskuid : set){
				pubScdeptTaskService.updateIgnoreAgent(taskuid);
			}
		}
		String resultMss = "本次导入成功"+successCount+"条记录；"+"导入失败"+failCount+"条记录；";
		if(StringUtils.isNotEmpty(message)){
			resultMss = resultMss+"失败原因如下："+message;
		}
		if(successCount == 0){
			returnMsgInfo(RESULT_FAIL_TYPE,resultMss,"0",jsonObject);
		}else{
			returnMsgInfo(RESULT_SUCCESS_TYPE,resultMss,"1",jsonObject);
		}
		return jsonObject;
	}

	/**
	 * 描述：获取检查结果
	 * 
	 * @author chenxin
	 * @date 2017-11-14
	 * @param pubScent
	 * @return
	 */
	private PubScentResult createPubScentResult(PubScent pubScent) {
		PubScentResult pubScentResult = new PubScentResult();
		pubScentResult.setTaskUid(pubScent.getDeptTaskUid());
		pubScentResult.setMainTaskUid(pubScent.getTaskUid());
		pubScentResult.setPriPID(pubScent.getPriPID());
		pubScentResult.setScentUid(pubScent.getUid());
		return pubScentResult;
	}

	/**
	 * 描述：转化JSON字符串并保存基本信息
	 * 
	 * @author chenxin
	 * @达特2017-10-18
	 * @param object
	 * @param pubScentResult
	 * @throws Exception
	 */
	private void saveJsonObject(JSONObject object, PubScentResult pubScentResult,String operateType,String auditOpion)throws Exception {
		transformJSON(object,pubScentResult,auditOpion);//解析json
		if("update".equals(operateType)){
			updatePubScentResultByUid(pubScentResult);//导入数据
		}else{
			pubScentResultMapper.insertSelective(pubScentResult);
		}
		String checkItemsJSON = object.getString("checkItems");//检查事项
		if(StringUtils.isNotEmpty(checkItemsJSON)){
			PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
			pubSccheckItemResult.setPriPID(pubScentResult.getPriPID());
			pubSccheckItemResult.setTaskUid(pubScentResult.getTaskUid());
			JSONArray checkItemJSONArray = JSONArray.fromObject(StringEscapeUtils.unescapeHtml4(checkItemsJSON));
			for(int j=0;j<checkItemJSONArray.size();j++){
				JSONObject checkItemObject = checkItemJSONArray.getJSONObject(j);
				String checkName = checkItemObject.getString("checkName");
				String problem = checkItemObject.getString("problem");
				String dispose = checkItemObject.getString("dispose");
				String isCheck = checkItemObject.getString("isCheck");
				if(StringUtils.isNotEmpty(checkName)){
					pubSccheckItemResult.setCheckName(checkName);
					pubSccheckItemResult.setProblem(StringUtils.isEmpty(problem)?"":problem);
					pubSccheckItemResult.setDispose(StringUtils.isEmpty(dispose)?"":dispose);
					pubSccheckItemResult.setIsCheck(StringUtils.isEmpty(isCheck)?"1":isCheck);
					pubSccheckItemResultMapper.insertSelective(pubSccheckItemResult);
				}
			}
		}
	}

	/**
	 * 描述：转化JSON
	 * 
	 * @author chenxin
	 * @date 2017-10-18
	 * @param object
	 * @param pubScentResult
	 */
	private void transformJSON(JSONObject object, PubScentResult pubScentResult,String auditOpion)throws Exception{
		pubScentResult.setAuditState("5");
		pubScentResult.setAuditOpinion(auditOpion);
		pubScentResult.setAuditUserName("超级管理员");
		pubScentResult.setAuditDate(new Date());
		if(object.getString("checkDate") != null){
			pubScentResult.setCheckDate(DateUtil.stringToDate(object.getString("checkDate"), "yyyy-MM-dd"));//检查日期
		}
		pubScentResult.setCheckDeptName(object.getString("checkDeptName"));//检查执行部门
		pubScentResult.setCheckDeptPerson(object.getString("checkDeptPerson"));//检查人员
		pubScentResult.setCheckType(object.getString("checkType"));//核查方式
		pubScentResult.setCheckResult(object.getString("checkResult"));//检查结果
		pubScentResult.setEnterUserName(object.getString("enterUserName"));//录入人员
		if(object.getString("enterDate") != null){
			pubScentResult.setEnterDate(DateUtil.stringToDate(object.getString("enterDate"), "yyyy-MM-dd"));//录入日期
		}
		pubScentResult.setDisposeState(object.getString("disposeState"));//后续处置状态
		pubScentResult.setDisposeMss(object.getString("disposeMss"));//后续处置措施
		pubScentResult.setDisposeFinishMss(object.getString("disposeFinishMss"));//后续处置完结信息
		if(object.getString("disposeFinishDate") != null){
			pubScentResult.setDisposeFinishDate(DateUtil.stringToDate(object.getString("disposeFinishDate"), "yyyy-MM-dd"));//后续处置完结日期
		}
	}

	/**
	 * 
	 * @param uid
	 * @return
	 */
	public PubScentResult selectByScentUid(String scentUid) {
		PubScentResult pubScentResult = new PubScentResult();
		pubScentResult.setScentUid(scentUid);
		return pubScentResultMapper.selectOne(pubScentResult);
	}
	
	/**
	 * 描述：通过主任务uid查询检查结果
	 * 
	 * @author yujingwei
	 * @date 2017年10月12日
	 * @param request
	 * @return List
	 */
	public List<PubScentResultDto> selectPubScentResultDtoByUid(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.selectPubScentResultDtoByMainUid(request.getParams());
	}
	
	/**
	 * 描述：通过主任务uid查询结果个数
	 * 
	 * @author yujingwei
	 * @date 2017年10月12日
	 * @param request
	 * @return Integer
	 */
	public Integer selectPubScentResultTotalByUid(PageRequest request) throws Exception{
		return pubScentResultMapper.selectPubScentResultTotalByUid(request.getParams());
	}

	/**
     * 返回信息
     * @param resultInfo，jsonObj，msg
     * @return void
     */
	private void returnMsgInfo(String resultInfo, String msg,String errorCode,JSONObject jsonObj) throws Exception {
		jsonObj.put("result", resultInfo);
		jsonObj.put("msg", msg);
		jsonObj.put("returnCode", errorCode);
	}
	
	/**
	 * 描述：保存跨部门检查结果
	 * 
	 * @author chenxin
	 * @date 2017-11-08
	 * @param pubScentResultDto
	 * @param sysUser
	 * @return
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean commitPubScentResultDto(PubScentResultDto pubScentResultDto,SysUserDto sysUser)throws Exception {
		PubScentResult pubScentResult = pubScentResultDto.getPubScentResult();
		if(pubScentResult != null && StringUtils.isNotEmpty(pubScentResult.getUid())){
			Example example = new Example(PubScentResult.class);
			example.createCriteria().andEqualTo("uid", pubScentResult.getUid());
			if("1".equals(pubScentResult.getAuditState())){
				pubScentResult.setEnterUserName(sysUser.getRealName());
				pubScentResult.setEnterDate(new Date());
			}
			if(!"audit".equals(pubScentResultDto.getOperationType()) && ("1".equals(pubScentResult.getAuditState()) || "4".equals(pubScentResult.getAuditState()))){
				pubScentResult.setAuditState("2");
			}
			pubScentResultMapper.updateByExampleSelective(pubScentResult, example);
			sccheckKeyService.saveList(pubScentResultDto.getSccheckKeyList(),pubScentResult.getUid());//保存专项检查表数据
			// 删除旧的检查事项结果
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("priPID", pubScentResult.getPriPID());
			map.put("taskUid", pubScentResult.getTaskUid());
			pubSccheckItemResultMapper.deletePubSccheckItemResultByTaskUidAndPriPID(map);
			// 检查事项结果
			List<PubSccheckItem> pubSccheckItemList = pubSccheckItemService.selectPubSccheckItemByTaskUid(pubScentResultDto.getMainTaskUid());
			if(pubSccheckItemList != null && pubSccheckItemList.size() > 0){
				String problem = pubScentResultDto.getProblem();
				for(PubSccheckItem pubSccheckItem : pubSccheckItemList){
					PubSccheckItemResult pubSccheckItemResult = new PubSccheckItemResult();
					pubSccheckItemResult.setCheckCode(pubSccheckItem.getCheckCode());
					pubSccheckItemResult.setCheckName(pubSccheckItem.getCheckName());
					pubSccheckItemResult.setPriPID(pubScentResult.getPriPID());
					pubSccheckItemResult.setProblem(problem);
					pubSccheckItemResult.setTaskUid(pubScentResult.getTaskUid());
					pubSccheckItemResultMapper.insert(pubSccheckItemResult);
				}
			}
			if ("5".equals(pubScentResult.getAuditState())) {// 审核通过
				pubScdeptTaskService.updatePubScdeptTaskByEnt(pubScentResultDto.getTaskUid());
			}
			return true;
		}
		return false;
	}

	/**
	 * 
	 * 描述   获取企业检查结果包括查无下落的最大检查日期
	 * @author 赵祥江
	 * @date 2017年11月6日 下午4:13:55 
	 * @param 
	 * @return List<PubScentResultDto>
	 * @throws
	 */
	@Override
	public PubScentResultDto selectMaxCheckDateScentResultByPriPID(
			String priPID) throws Exception { 
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("priPID", priPID);
		return pubScentResultMapper.selectMaxCheckDateScentResultByPriPID(params);
	}
	

	/**
	 * 
	 * 描述: “双随机”抽检结果统计
	 * @auther gaojinling
	 * @date 2017年11月8日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<PubScentResultDto> selectScentResultChartCount(
			Map<String, Object> map) throws Exception {
		return pubScentResultMapper.selectScentResultChartCount(map);
	}
	
	/**
	 * 描述：保存跨部门后续处置
	 * 
	 * @author chenxin
	 * @date 2017-11-08
	 * @param pubScentResultDto
	 * @param sysUser
	 * @return
	 */
	@Override
	public boolean savePubScentResultDto(PubScentResultDto pubScentResultDto)
			throws Exception {
		PubScentResult pubScentResult = pubScentResultDto.getPubScentResult();
		if(pubScentResult != null && StringUtils.isNotEmpty(pubScentResult.getUid())){
			Example example = new Example(PubScentResult.class);
			example.createCriteria().andEqualTo("uid", pubScentResult.getUid());
			pubScentResultMapper.updateByExampleSelective(pubScentResult, example);
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 描述   年报端获取企业的抽查通知书
	 * @author  赵祥江
	 * @date 2017年11月14日 下午2:32:19 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubScentResultDto> queryYearReportPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentResultMapper.queryPreParePageResult(request.getParams());
	}
}