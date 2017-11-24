/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.sccheck.mapper.PubScdeptTaskMapper;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScWorkPlan;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScWorkPlanService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述: pub_scdept_task 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
@Service
public class PubScdeptTaskServiceImpl extends MyBatisServiceSupport implements IPubScdeptTaskService {
	@Autowired
	private PubScdeptTaskMapper pubScdeptTaskMapper; 
	@Autowired
	private IPubScentResultService pubScentResultService;
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService;
	@Autowired
	private IPubScWorkPlanService pubScWorkPlanService;
	
	/**
	 * 描述:创建执法人员任务
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	@Override
	public void savePubScdeptTask(PubScdeptTask pubScdeptTask) {
		if (pubScdeptTask != null) {
			pubScdeptTaskMapper.insertSelective(pubScdeptTask);
		}
	}

	/**
	 * 描述:更新执法人员任务（抽取完成后，更细状态及抽取人员和时间）
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	@Override
	public void updatePubScdeptTask(String deptTaskUid, String deptState,SysUserDto sysUser) {
		Example example = new Example(PubScdeptTask.class);
		example.createCriteria().andEqualTo("uid", deptTaskUid);
		PubScdeptTask pubScdeptTask = new PubScdeptTask();
		pubScdeptTask.setDeptState(deptState);
		pubScdeptTask.setSetUserName(sysUser.getRealName());
		pubScdeptTask.setSetTime(new Date());
		pubScdeptTaskMapper.updateByExampleSelective(pubScdeptTask, example);
	}
	/**
	 * 描述:更新执法人员任务(仅状态)
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	public void updatePubScdeptTask(String deptTaskUid, String deptState) {
		Example example = new Example(PubScdeptTask.class);
		example.createCriteria().andEqualTo("uid", deptTaskUid);
		PubScdeptTask pubScdeptTask = new PubScdeptTask();
		pubScdeptTask.setDeptState(deptState);
		pubScdeptTaskMapper.updateByExampleSelective(pubScdeptTask, example);
	}
	
	/**
	 * 描述:更新执法人员任务
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 * @param checkNum
	 * @param randomDate
	 * @param randomType
	 */
	@Override
	public void updatePubScdeptTask(String deptTaskUid, int checkNum,Date randomDate,String randomType,int minNum) {
		Example example = new Example(PubScdeptTask.class);
		example.createCriteria().andEqualTo("uid", deptTaskUid);
		PubScdeptTask pubScdeptTask = new PubScdeptTask();
		pubScdeptTask.setCheckNum(checkNum);
		pubScdeptTask.setRandomDate(randomDate);
		pubScdeptTask.setRandomType(randomType);
		pubScdeptTask.setMinNum(minNum);
		pubScdeptTaskMapper.updateByExampleSelective(pubScdeptTask, example);
	}

	/**
	 * 描述:更新任务状态
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public void updatePubScdeptTaskByEnt(String deptTaskUid)throws Exception {
		//1.找到当前任务是否所有的企业都已经录入完毕（已完毕则修改状态）
		int count = pubScentResultService.seleteUnfinishedEnt(deptTaskUid);
		if(count == 0){
			updatePubScdeptTask(deptTaskUid, "3");
			//2.检查同级别的部门任务是否已经完成（已完成这跟新主任务状态和涉及到的任务计划状态）
			PubScdeptTask param = new PubScdeptTask();
			param.setUid(deptTaskUid);
			PubScdeptTask pubScdeptTask = pubScdeptTaskMapper.selectOne(param);
			if(pubScdeptTask != null){
				//检查同级别的部门任务是否已经完成
				String taskUid = pubScdeptTask.getTaskUid();
				Example example = new Example(PubScdeptTask.class);
				example.createCriteria().andEqualTo("taskUid", taskUid).andNotEqualTo("deptState", "3"); 
				int deptUnNum = pubScdeptTaskMapper.selectCountByExample(example);
				if(deptUnNum == 0){
					//更新主任务状态
					PubScPlanTask pubScPlanTask = new PubScPlanTask();
					pubScPlanTask.setUid(taskUid);
					pubScPlanTask.setTaskState("03");
					pubScPlanTaskService.updatePubScPlanTaskByUid(pubScPlanTask);
					PubScPlanTask pubScPlanTaskN = pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
					//更新关联的工作计划状态
					if(StringUtils.isNotEmpty(pubScPlanTaskN.getResourcePlanUid())){
						PubScWorkPlan pubScWorkPlan = new PubScWorkPlan();
						pubScWorkPlan.setUid(pubScPlanTaskN.getResourcePlanUid());
						pubScWorkPlan.setPlanState("03");
						pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
					}
				}
			}
		}
	}
	
	/**
	 * 描述:更新任务状态(跳过执法人员抽取)
	 * @author chenxin
	 * @date 2017-05-22
	 * @param deptTaskUid
	 */
	@Override
	public void updateIgnoreAgent(String deptTaskUid) throws Exception {
		//1.找到当前任务是否所有的企业都已经录入完毕（已完毕则修改状态）
		int count = pubScentResultService.seleteUnfinishedEntNoRandom(deptTaskUid);
		if(count == 0){
			updatePubScdeptTask(deptTaskUid, "3");
			//2.检查同级别的部门任务是否已经完成（已完成这跟新主任务状态和涉及到的任务计划状态）
			PubScdeptTask param = new PubScdeptTask();
			param.setUid(deptTaskUid);
			PubScdeptTask pubScdeptTask = pubScdeptTaskMapper.selectOne(param);
			if(pubScdeptTask != null){
				//检查同级别的部门任务是否已经完成
				String taskUid = pubScdeptTask.getTaskUid();
				Example example = new Example(PubScdeptTask.class);
				example.createCriteria().andEqualTo("taskUid", taskUid).andNotEqualTo("deptState", "3"); 
				int deptUnNum = pubScdeptTaskMapper.selectCountByExample(example);
				if(deptUnNum == 0){
					//更新主任务状态
					PubScPlanTask pubScPlanTask = new PubScPlanTask();
					pubScPlanTask.setUid(taskUid);
					pubScPlanTask.setTaskState("03");
					pubScPlanTaskService.updatePubScPlanTaskByUid(pubScPlanTask);
					PubScPlanTask pubScPlanTaskN = pubScPlanTaskService.selectPubScPlanTaskByUid(taskUid);
					//更新关联的工作计划状态
					if(StringUtils.isNotEmpty(pubScPlanTaskN.getResourcePlanUid())){
						PubScWorkPlan pubScWorkPlan = new PubScWorkPlan();
						pubScWorkPlan.setUid(pubScPlanTaskN.getResourcePlanUid());
						pubScWorkPlan.setPlanState("03");
						pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
					}
				}
			}
		}else{
			updatePubScdeptTask(deptTaskUid, "2");
		}
	}
	
	/**
	 * 描述:删除任务
	 * 
	 * @author chenxin
	 * @date 2017-05-22
	 * @param pubScdeptTask
	 */
	@Override
	public void delPubScdeptTask(String taskUid) {
		Example example = new Example(PubScent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid);
		pubScdeptTaskMapper.deleteByExample(example);
	}

	/**
	 * 描述：根据uid查询执法人员任务
	 * @author baifangfang
	 * @date 2017年5月26日
	 * @param taskUid
	 * @return
	 */
	@Override
	public PubScdeptTask selectPubScdeptTaskByUid(String uid) {
		PubScdeptTask pubScdeptTask = new PubScdeptTask();
		pubScdeptTask.setUid(uid);
		return pubScdeptTaskMapper.selectOne(pubScdeptTask);
	}
	
	/**
	 * 描述:更新任务信息
	 * @author chenxin
	 * @date 2017-05-22
	 * @param oldPst
	 * @throws Exception
	 */
	@Override
	public void updatePubScdeptTask(PubScdeptTask pubScdeptTask) throws Exception {
		Example example = new Example(PubScdeptTask.class);
		example.createCriteria().andEqualTo("uid", pubScdeptTask.getUid());
		pubScdeptTaskMapper.updateByExampleSelective(pubScdeptTask, example);
	}
	
	/**
	 * 描述:删除抽查任务
	 * @author chenxin
	 * @date 2017-05-22 
	 * @param oldDeptTaskUid
	 * @throws Exception
	 */
	@Override
	public void deleteByUid(String uid) throws Exception {
		Example example = new Example(PubScdeptTask.class);
		example.createCriteria().andEqualTo("uid", uid);
		pubScdeptTaskMapper.deleteByExample(example);
	}
	
	/**
	 * 描述:根据任务uid和部门编码查询任务是否存在
	 * @author chenxin
	 * @date 2017-05-22 
	 * @param taskUid
	 * @param unitDeptCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubScdeptTask selectByTaskUidAndUnitDeptCode(String taskUid,String unitDeptCode) throws Exception {
		PubScdeptTask pubScdeptTask = new PubScdeptTask();
		pubScdeptTask.setTaskUid(taskUid);
		pubScdeptTask.setUnitDeptCode(unitDeptCode);
		return pubScdeptTaskMapper.selectOne(pubScdeptTask);
	}
}