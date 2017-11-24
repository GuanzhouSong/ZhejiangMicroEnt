/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.specialrec.dto.SpecialRecTaskDto;
import com.icinfo.cs.specialrec.mapper.SpecialRecEntMapper;
import com.icinfo.cs.specialrec.mapper.SpecialRecResultMapper;
import com.icinfo.cs.specialrec.mapper.SpecialRecTaskMapper;
import com.icinfo.cs.specialrec.model.SpecialRecEnt;
import com.icinfo.cs.specialrec.model.SpecialRecResult;
import com.icinfo.cs.specialrec.model.SpecialRecTask;
import com.icinfo.cs.specialrec.service.ISpecialRecEntService;
import com.icinfo.cs.specialrec.service.ISpecialRecTaskService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_task 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Service
public class SpecialRecTaskServiceImpl extends MyBatisServiceSupport implements ISpecialRecTaskService {
	
	@Autowired
	private SpecialRecTaskMapper specialRecTaskMapper;
	@Autowired
	private SpecialRecEntMapper specialRecEntMapper;
	@Autowired
	private ISpecialRecEntService specialRecEntService;
	@Autowired
	private SpecialRecResultMapper specialRecResultMapper;
	@Autowired
	private IDepartMentService departMentService;
	
	/**
	 * 描述：通过uid查询检查任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recTaskUid
	 * @return SpecialRecTask
	 * @throws Exception
	 */
	public SpecialRecTask selectSpecialRecTaskInfoByUid(String recTaskUid) throws Exception{
		SpecialRecTask specialRecTask = new SpecialRecTask();
		specialRecTask.setUid(recTaskUid);
		return specialRecTaskMapper.selectOne(specialRecTask);
	}
	
	/**
	 * 描述：通过uid删除检查任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recTaskUid
	 * @return int
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public int doDelSpecialRecTaskInfo(String recTaskUid) throws Exception{
		if (StringUtil.isNoneBlank(recTaskUid)) {
			SpecialRecTask specialRecTask = new SpecialRecTask();
			specialRecTask.setUid(recTaskUid);
			if(specialRecTaskMapper.delete(specialRecTask) > 0) {
				SpecialRecEnt specialRecEnt = new SpecialRecEnt();
				specialRecEnt.setTaskUid(recTaskUid);
				specialRecEntMapper.delete(specialRecEnt);
				SpecialRecResult recResult = new SpecialRecResult();
				recResult.setTaskUid(recTaskUid);
				return specialRecResultMapper.delete(recResult);
			}
		}
		return 0;
	}
    
	/**
	 * 描述：查询专项整治任务列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@Override
	public List<SpecialRecTaskDto> querySpecialrecTaskList(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return specialRecTaskMapper.selectSpecialrecTaskList(request.getParams());
	}
	
	/**
	 * 描述：任务个数统计
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param request
	 * @return SpecialRecTaskDto
	 * @throws Exception
	 */
	public SpecialRecTaskDto selectSpecialRecTaskInfoForCount(PageRequest request) throws Exception{
		return specialRecTaskMapper.selectSpecialRecTaskInfoForCount(request.getParams());
	}
    
	/**
	 * 描述：保存专项整治任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecTask
	 * @return AjaxResult
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doCommitSpecialRecTaskInfo(SpecialRecTask specialRecTask,
			SysUserDto sysUser) throws Exception {
		if (StringUtil.isNotEmpty(specialRecTask.getUid())) {
			// 初始化检查个数
			List<SpecialRecEnt> specialRecEnts = specialRecEntService.selectSpecialRecEntInfoList(specialRecTask.getUid());
			if (specialRecEnts!=null) {
				String checkEntTotal = String.valueOf(specialRecEnts.size());
				specialRecTask.setCompletedTotal("0");
				specialRecTask.setCheckEntTotal(checkEntTotal);
				//先删除
				SpecialRecResult recResult = new SpecialRecResult();
				recResult.setTaskUid(specialRecTask.getUid());
				specialRecResultMapper.delete(recResult);
				//保存检查结果信息
				doSaveSpecialRecResult(specialRecEnts, specialRecTask, sysUser);
			}
			SpecialRecTask recTask = selectSpecialRecTaskInfoByUid(specialRecTask.getUid());
			if (recTask==null) {
				specialRecTask.setSetUserName(sysUser.getRealName());
				specialRecTask.setSetTime(new Date());
				if (specialRecTaskMapper.insert(specialRecTask) > 0) {
					return true;
				}
			}else{
				Example example = new Example(SpecialRecTask.class);
				example.createCriteria()
				.andEqualTo("uid", specialRecTask.getUid());
				if (specialRecTaskMapper.updateByExampleSelective(specialRecTask, example) > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
    
	/**
	 * 描述：保存结果信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecEnts
	 */
	private void doSaveSpecialRecResult(List<SpecialRecEnt> specialRecEnts,
			SpecialRecTask specialRecTask, SysUserDto sysUser) {
		for (SpecialRecEnt specialRecEnt : specialRecEnts) {
			SpecialRecResult specialRecResult = new SpecialRecResult();
			specialRecResult.setTaskUid(specialRecEnt.getTaskUid());
			specialRecResult.setPriPID(specialRecEnt.getPriPID());
			specialRecResult.setEntName(specialRecEnt.getEntName());
			specialRecResult.setRegNO(specialRecEnt.getRegNO());
			specialRecResult.setUniCode(specialRecEnt.getUniCode());
			specialRecResult.setCheckState("0");
			// 默认检查部门编码,名称
			if ("1".equals(sysUser.getUserType())) {
				String localAdm = specialRecEnt.getLocalAdm();
				String assignCode = localAdm.substring(0, 6) + "00";
				specialRecResult.setSetDeptCode(assignCode);
				DepartMent departMent = departMentService.selectDepartMentByDeptCode(assignCode);
				if (departMent != null) {
					specialRecResult.setCheckDeptName(departMent.getDeptName());
				}
			}else {
				SysDepart depart = sysUser.getSysDepart();
				specialRecResult.setSetDeptCode(depart.getOrgCoding());
				specialRecResult.setCheckDeptName(depart.getOrgName());
			}
			//是否存在
			Example example = new Example(SpecialRecEnt.class);
			example.createCriteria()
			.andEqualTo("taskUid", specialRecEnt.getTaskUid())
			.andEqualTo("priPID", specialRecEnt.getPriPID());
			List<SpecialRecResult> recResults = specialRecResultMapper.selectByExample(example);
			if (recResults.size() > 0) {
				continue;
			}
			specialRecResultMapper.insert(specialRecResult);
		}
	}

	/**
	 * 描述：生成最大序号
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param docShortName
	 * @return int
	 * @throws Exception
	 */
	public Integer selectDocNumBydeptShortName(String docShortName, int parseInt) throws Exception{
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("deptShortName", docShortName);
		queryMap.put("seqYear", parseInt);
		return specialRecTaskMapper.selectDocNumBydeptShortName(queryMap);
	}
	
	/**
	 * 描述：通过任务名称查询
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskName
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecTask> selectSpecialRecTaskInfoByTaskName(String taskName) throws Exception{
		Example example = new Example(SpecialRecTask.class);
		example.createCriteria()
		.andEqualTo("taskName", taskName);
		return specialRecTaskMapper.selectByExample(example);
	}
}