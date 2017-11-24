/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service.impl;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.specialrec.dto.SpecialRecResultDto;
import com.icinfo.cs.specialrec.mapper.SpecialRecItemMapper;
import com.icinfo.cs.specialrec.mapper.SpecialRecResultMapper;
import com.icinfo.cs.specialrec.mapper.SpecialRecTaskMapper;
import com.icinfo.cs.specialrec.model.SpecialRecItem;
import com.icinfo.cs.specialrec.model.SpecialRecResult;
import com.icinfo.cs.specialrec.model.SpecialRecTask;
import com.icinfo.cs.specialrec.service.ISpecialRecResultService;
import com.icinfo.cs.specialrec.service.ISpecialRecTaskService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月02日
 */
@Service
public class SpecialRecResultServiceImpl extends MyBatisServiceSupport implements ISpecialRecResultService {
	
	@Autowired
	private SpecialRecResultMapper specialRecResultMapper;
	@Autowired
	private SpecialRecItemMapper specialRecItemMapper;
	@Autowired
	private SpecialRecTaskMapper specialRecTaskMapper;
	@Autowired
	private ISpecialRecTaskService specialRecTaskService;
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private ISysDepartService sysDepartService;
    
	/**
	 * 描述：查询专项整治结果列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@Override
	public List<SpecialRecResultDto> querySpecialrecResultList(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		// 检查结果
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtil.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		return specialRecResultMapper.selectSpecialRecResultInfo(request.getParams());
	}
	
	/**
	 * 描述：通过任务Id查询结果信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param recTaskUid
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecResult> selectSpecialRecResultInfoByTaskUid(String recTaskUid){
		Example example = new Example(SpecialRecResult.class); 
		example.createCriteria()
		.andEqualTo("taskUid", recTaskUid);
		return specialRecResultMapper.selectByExample(example);
	}
	
	/**
	 * 描述：通过uid查询结果信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param resultUid
	 * @return List
	 * @throws Exception
	 */
	public SpecialRecResultDto selectSpecialRecResultDtoInfo(String resultUid) throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("resultUid", resultUid);
		List<SpecialRecResultDto> recResultDtos = specialRecResultMapper.selectSpecialRecResultInfo(qryMap);
		if (recResultDtos.size() > 0) {
			return recResultDtos.get(0);
		}
		return new SpecialRecResultDto();
	}
	
	/**
	 * 描述：检查结果录入修改
	 * 
	 * @author yujingwei
	 * @date 2017年11月03日
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
	public int doEnterRecResultInfo(Map<String, Object> map, SysUserDto sysUser,String commitWay) throws Exception{
		// 检查结果
		SpecialRecResultDto recResultDto = packSpecialRecResultInfo(map);
		int m = specialRecResultMapper.updateByPrimaryKeySelective(recResultDto);
		if (m <= 0) {
			throw new Exception();
		}
		// 保存检查事项
		doSavaSpecialRecItemInfo(recResultDto.getUid(), map);
		// 检查任务
		if ("1".equals(commitWay)) {
			String taskUid = recResultDto.getTaskUid();
			List<SpecialRecResult> recResults = selectSpecialRecResultInfoByTaskUid(taskUid);
			if (recResults.size() > 0) {
				boolean isCheckFinish = true;
				for (SpecialRecResult specialRecResult : recResults) {
					if ("0".equals(specialRecResult.getCheckState())) {
						isCheckFinish = false;
						break;
					}
				}
				SpecialRecTask recTask = specialRecTaskService.selectSpecialRecTaskInfoByUid(taskUid);
				int completedTotal = Integer.parseInt(recTask.getCompletedTotal());
				SpecialRecTask record = new SpecialRecTask();
				record.setCompletedTotal(String.valueOf(completedTotal+1));
				record.setId(recTask.getId());
				if (!isCheckFinish) {
					record.setTaskState("02");
				}else{
					record.setTaskState("03");
				}
				specialRecTaskMapper.updateByPrimaryKeySelective(record);
			}
		}
		return 1;
	}

	/**
	 * 描述：组装需要保存的结果信息
	 * 
	 * @author Administrator
	 * @date 2017年5月18日
	 * @param map
	 * @throws ParseException
	 */
	private SpecialRecResultDto packSpecialRecResultInfo(Map<String, Object> map) throws Exception {
		String checkType = (String) map.get("checkType");// 核查方式
		String checkResult = (String) map.get("checkResult");// 检查结果
		String disposeMss = (String) map.get("disposeMss");// 后续处置措施
		String disposeState = (String) map.get("disposeState");// 后续处置措施是否完结1未完结2已完结
		String disposeFinishDateStr = (String) map.get("disposeFinishDate");// 完结日期
		String checkDeptName = (String) map.get("checkDeptName");// 检查执行部门
		String setDeptName = (String) map.get("setDeptName");// 检查执行部门
		String checkDeptPerson = (String) map.get("checkDeptPerson");// 检查人员
		String checkDateStr = (String) map.get("checkDate");// 检查日期
		String disposeFinishMss = (String) map.get("disposeFinishMss");// 后续处置完结信息
		String dataType = (String) map.get("dataType");// 1-提交 2-暂存 3-修改 4-续录
		String modifyName = (String)map.get("modifyName");//修改人姓名
		String modifyDateStr = (String)map.get("modifyDate");//修改时间
		String modifyContent = (String)map.get("modifyContent");//修改内容
		String enterUserName = (String)map.get("enterUserName");//录入人姓名
		String enterDateStr = (String)map.get("enterDate");//录入时间
		String uid = (String) map.get("uid");
		SpecialRecResultDto specialRecResultDto = selectSpecialRecResultDtoInfo(uid);
		if ("未发现问题或相关问题已规范、已改正，无需后续处置；".equals(disposeMss)) {
			specialRecResultDto.setDisposeState("2");
		} else {
			specialRecResultDto.setDisposeState(disposeState);
		}

		specialRecResultDto.setCheckType(checkType);
		specialRecResultDto.setCheckResult(checkResult);
		if ("2".equals(dataType)) {
			specialRecResultDto.setCheckState("0");
		}else{
			specialRecResultDto.setCheckState("1");
		}
		specialRecResultDto.setDisposeMss(disposeMss);
		specialRecResultDto.setDisposeFinishMss(disposeFinishMss);
		// 检查结果录入后设置检查表为已设置的状态
		if (!StringUtil.isEmpty(disposeFinishDateStr)) {
			Date disposeFinishDate = DateUtil.parseDate(disposeFinishDateStr, "yyyy-MM-dd");
			specialRecResultDto.setDisposeFinishDate(disposeFinishDate);
		}
		specialRecResultDto.setCheckDeptName(checkDeptName);
		specialRecResultDto.setCheckDeptPerson(checkDeptPerson);
		specialRecResultDto.setSetDeptName(setDeptName);
		specialRecResultDto.setModifyName(modifyName);
		specialRecResultDto.setModifyContent(modifyContent);
		specialRecResultDto.setEnterUserName(enterUserName);
		if (!StringUtil.isEmpty(enterDateStr)) {
			Date enterDate = DateUtil.parseDate(enterDateStr, "yyyy-MM-dd");
			specialRecResultDto.setEnterDate(enterDate);
		}
		if (!StringUtil.isEmpty(modifyDateStr)) {
			Date modifyDate = DateUtil.parseDate(modifyDateStr, "yyyy-MM-dd");
			specialRecResultDto.setModifyDate(modifyDate);
		}
		if (!StringUtil.isEmpty(checkDateStr)) {
			Date checkDate = DateUtil.parseDate(checkDateStr, "yyyy-MM-dd");
			specialRecResultDto.setCheckDate(checkDate);
		}
		return specialRecResultDto;
	}
	
	/**
	 * 描述：保存检查事项信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月13日
	 * @param map
	 * @throws Exception
	 */
	private void doSavaSpecialRecItemInfo(String uid, Map<String, Object> map) 
			throws Exception{
		if (StringUtil.isNotBlank(uid)) {
			SpecialRecItem specialRecItem = new SpecialRecItem();
			specialRecItem.setResultUid(uid);
			specialRecItemMapper.delete(specialRecItem);
			for (int i = 1; i <= 100; i++) {
				String checkContentStr = "checkContent_" + i;
				String chechProblemStr = "chechProblem_" + i;
				String disposalContentStr = "disposalContent_" + i;
				String checkContent = (String) map.get(checkContentStr);
				String chechProblem = (String) map.get(chechProblemStr);
				String disposalContent = (String) map.get(disposalContentStr);
				if (StringUtil.isBlank(checkContent)&&StringUtil.isBlank(chechProblem)
						&&StringUtil.isBlank(disposalContent)) {
					continue;
				}
				SpecialRecItem recItem = new SpecialRecItem();
				recItem.setCheckProblem(chechProblem);
				recItem.setCheckContent(checkContent);
				recItem.setDisposalContent(disposalContent);
				recItem.setResultUid(uid);
				specialRecItemMapper.insert(recItem);
			}
		}
	}
	
	/**
	 * 描述：名单指派
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uids
	 * @param appointLocalAdm
	 * @return pageResponse
	 * @throws Exception
	 */
	public boolean doAppointEnts(String uids, String appointLocalAdm,SysUserDto sysUserDto) 
			throws Exception{
		if (StringUtil.isNotBlank(uids)) {
			String[] resultUid = uids.split(",");
			for (int i = 0; i < resultUid.length; i++) {
				SpecialRecResult recResult = new SpecialRecResult();
				recResult.setSetDeptCode(appointLocalAdm);
				if ("1".equals(sysUserDto.getUserType())) {
					DepartMent departMent = departMentService.selectDepartMentByDeptCode(appointLocalAdm);
					if (departMent != null) {
						recResult.setCheckDeptName(departMent.getDeptName());
					}
				}else{
					SysDepart depart = sysDepartService.doGetByCode(appointLocalAdm);
					recResult.setCheckDeptName(depart.getOrgName());
				}
				recResult.setAssignName(sysUserDto.getRealName());
				recResult.setAssignDate(new Date());
				Example example = new Example(SpecialRecResult.class);
				example.createCriteria()
				.andEqualTo("uid", resultUid[i]);
				specialRecResultMapper.updateByExampleSelective(recResult, example);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：查询专项整治录入完结个数
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	public SpecialRecResultDto selectSpecialRecResultDtoForCount(PageRequest request) throws Exception{
		Map<String, Object> params = request.getParams();
		String checkResult = (String) params.get("checkResult");
		if (StringUtil.isEmpty(checkResult) || "1,2,3,4,5,6,7,8,9,10,11,12,A,B,C,D,E,F".equals(checkResult)) {
			params.put("checkResults", null);
		} else {
			params.put("checkResults", checkResult.split(","));
		}
		return specialRecResultMapper.selectSpecialRecResultDtoForCount(request.getParams());
	}
	
}