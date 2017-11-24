/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.icinfo.cs.common.constant.ScTaskDeptStates;
import com.icinfo.cs.common.constant.ScTaskStates;
import com.icinfo.cs.drcheck.dto.PubSctaskDto;
import com.icinfo.cs.drcheck.mapper.PubDeptNumberMapper;
import com.icinfo.cs.drcheck.mapper.PubDeptScitemMapper;
import com.icinfo.cs.drcheck.mapper.PubDeptSctaskMapper;
import com.icinfo.cs.drcheck.mapper.PubSctaskMapper;
import com.icinfo.cs.drcheck.model.PubDeptNumber;
import com.icinfo.cs.drcheck.model.PubDeptScitem;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.cs.drcheck.service.IPubSctaskService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:  cs_pub_sctask 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubSctaskServiceImpl extends MyBatisServiceSupport implements IPubSctaskService {

    @Autowired
    private PubSctaskMapper pubSctaskMapper;
    @Autowired
    private PubDeptSctaskMapper pubDeptSctaskMapper;
    @Autowired
    private PubDeptScitemMapper pubDeptScitemMapper;
    @Autowired
    private IPubDeptSctaskService pubDeptSctaskService;
    @Autowired
    private PubDeptNumberMapper pubDeptNumberMapper;

	@Override
	public int insert(PubSctask pubSctask) {
		// TODO Auto-generated method stub
		return pubSctaskMapper.insert(pubSctask);
	}

	@Override
	public List<PubSctaskDto> selectByManyCationToListJson(PageRequest request,String deptId) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		
		// TODO Auto-generated method stub
		if(map!=null){
			map.put("deptId",deptId);
		if(map.get("leaderDeptCode")!=null&&!map.get("leaderDeptCode").equals("")){
			map.put("items",map.get("leaderDeptCode").toString().split(","));
		}
		if(map.get("inspectDept")!=null&&!map.get("inspectDept").equals("")){
			map.put("inspectDepts",map.get("inspectDept").toString().split(","));
		}
		}else{
			map=new HashMap<String,Object>();
			map.put("deptId",deptId);
		}
		return pubSctaskMapper.selectByManyCationToListJson(map);
	}
 

	@Override
	public int selectMaxId() {
		// TODO Auto-generated method stub
		return pubSctaskMapper.selectMaxId();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Map<String,Object> setStack(PubSctaskDto pubSctaskDto,SysUserDto sysUser) {
		 int result=0; 
		 Map<String,Object> map=new HashMap<String,Object>();
		 pubSctaskDto.setCreateTime(new Date()); 
		 pubSctaskDto.setSetName(sysUser.getUsername());
		 pubSctaskDto.setSetDeptCode(sysUser.getDeptCode());
		 pubSctaskDto.setSetDeptDesc(sysUser.getDeptName());
		 pubSctaskDto.setTaskState(ScTaskStates.WaitSetEnt.getCode());
		    if(pubSctaskMapper.insertSelective(pubSctaskDto)>0){
		    	PubDeptNumber pubDeptNumber=new PubDeptNumber();
		    	pubDeptNumber.setDeptCode(pubSctaskDto.getLeaderDeptCode());
		    	pubDeptNumber.setDeptNumber(pubSctaskDto.getDeptNumber());
		    	pubDeptNumber.setYear(Integer.parseInt(DateUtils.getYear()));
		       result= pubDeptNumberMapper.insert(pubDeptNumber); //保存部门任务编号
		    	if(result>0){
		    	for(PubDeptSctask dpc:pubSctaskDto.getImplList()){//循环保存到DeptScatsk
		    	  dpc.setTaskNO(pubSctaskDto.getUID());
		    	  dpc.setInspectState(ScTaskDeptStates.WaitChooseAgent.getCode());
		    	  dpc.setCreateTime(new Date());
		    	 result= pubDeptSctaskMapper.insert(dpc);
		    	 if(result>0){
		    		   String [] types=dpc.getInspectType().split(",");
		    		   String [] names=dpc.getInspectTypeDesc().split(",");
		    		 for(int i=0;i<types.length;i++){//循环保存到sitem
		    			 PubDeptScitem pubDeptScitem=new PubDeptScitem();
		    			 pubDeptScitem.setTaskNO(pubSctaskDto.getUID());
		    			 pubDeptScitem.setDeptCode(dpc.getInspectDept());
		    			 pubDeptScitem.setScType(types[i]);
		    			 pubDeptScitem.setScName(names[i]);
		    			 pubDeptScitem.setCreateTime(new Date());
		    			 result= pubDeptScitemMapper.insert(pubDeptScitem);
		    			 
		    		 }
		    	 }
		    	 
		    	 }
		      }
		    }
		 map.put("result",result);
		 map.put("taskUid", pubSctaskDto.getUID());   
		return map;
	}
 
	
	/**
	 * 描述：根据任务编号查询任务信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubSctask selectPubSctaskByTaskNO(String taskNO) {
		PubSctask pubSctask = new PubSctask();
		pubSctask.setUID(taskNO);
    	return  pubSctaskMapper.selectOne(pubSctask);
	}

	@Override
	public  Map<String,Object> selectCountByCation(PubSctaskDto pubSctaskDto) {
		// TODO Auto-generated method stub
		   Map<String,Object> map=new HashMap<String,Object>();
		   String taskState=pubSctaskDto.getTaskState();//状态
		   if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.WaitSetEnt.getCode());
		    } 
		  map.put("waitSetEnt", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		
		  if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.WaitSetPlan.getCode());
		    } 
		  map.put("waitSetPlan", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		
		  if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.WaitConfirmAgent.getCode());
		    } 
		  map.put("chooseAgent", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		
		  if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.ChooseAgent.getCode());
		    } 
		  map.put("waitConfirmAgent", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		  if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.Inspecting.getCode());
		    } 
		  map.put("inspecting", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		  if(StringUtils.isEmpty(taskState)){ 
			   pubSctaskDto.setTaskState(ScTaskStates.Finished.getCode());
		    } 
		  map.put("finished", pubSctaskMapper.selectCountByCation(benanTransMap(pubSctaskDto)));
		  
		return  map;
	}
 
	
	public Map<String,Object> benanTransMap(PubSctaskDto pubSctaskDto){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("taskCode",pubSctaskDto.getTaskCode());
		map.put("taskName", pubSctaskDto.getTaskName());
		map.put("leaderDeptCode",pubSctaskDto.getLeaderDeptCode());
		map.put("taskEntCatgCode", pubSctaskDto.getTaskEntCatgCode());
		if(StringUtil.isNotEmpty(pubSctaskDto.getLeaderDeptCode())){
			map.put("items",pubSctaskDto.getLeaderDeptCode().split(","));
			
		}
		if(StringUtil.isNotEmpty(pubSctaskDto.getInspectDept())){
			map.put("inspectDepts",pubSctaskDto.getInspectDept().split(","));
			
		}
		
		
		map.put("inspectDept", pubSctaskDto.getInspectDept());
		map.put("taskState", pubSctaskDto.getTaskState());
	    map.put("startDateStart",pubSctaskDto.getStartDateStart()); 
		map.put("startDateEnd", pubSctaskDto.getStartDateEnd()); 
        map.put("setTimeStart", pubSctaskDto.getSetTimeStart()); 	
        map.put("setTimeEnd", pubSctaskDto.getSetTimeEnd()); 
		return map;
		
	}
	
	/**
    * 描述:随机企业信息任务提交
    * @author chenxin
    * @date 2016-11-04
    * @param taskNO
    * @throws Exception
    */
	@Override
	public void setTaskRandomInfoOver(String taskNO,int totalEnt) throws Exception {
		Example example = new Example(PubSctask.class);
		example.createCriteria().andEqualTo("UID", taskNO);
		PubSctask pubSctask = new PubSctask();
		pubSctask.setTotalEnt(totalEnt);
		pubSctask.setTaskState(ScTaskStates.WaitSetPlan.getCode());
		pubSctaskMapper.updateByExampleSelective(pubSctask,example);
	}
	
	/**
	   * 描述:随机执法人员任务提交
	   * @author chenxin
	   * @date 2016-11-07
	   * @param taskNO
	   * @param deptTaskUid
	   * @throws Exception
	   */
	@Override
	public void setTaskAgentOver(String taskNO,String deptTaskUid) throws Exception {
		//实施部门任务状态
		pubDeptSctaskService.updateInspectState(deptTaskUid, ScTaskDeptStates.FinishChooseAgent.getCode());
		PubSctask pubSctaskParam = new PubSctask();
		pubSctaskParam.setUID(taskNO);
		PubSctask pubSctaskState = pubSctaskMapper.selectOne(pubSctaskParam);
		if(ScTaskStates.WaitSetPlan.getCode().equals(pubSctaskState.getTaskState())){
			Example example = new Example(PubSctask.class);
			example.createCriteria().andEqualTo("UID", taskNO);
			PubSctask pubSctask = new PubSctask();
			pubSctask.setTaskState(ScTaskStates.Inspecting.getCode());
			pubSctaskMapper.updateByExampleSelective(pubSctask,example);
		}
	}

	 /**
	   *  
	   * 描述:多条件查询本部门组织的任务
	   * @auther ljx
	   * @date 2016年11月11日 
	   * @param map
	   * @return
	   */
	@Override
	public List<PubSctaskDto> selectLeadStacktoListJson(PageRequest request,String deptId) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		if(map!=null){
			map.put("deptId",deptId);
		}else{
			map=new HashMap<String,Object>();
			map.put("deptId",deptId);
		}
		return  pubSctaskMapper.selectLeadStacktoListJson(map);
	}

	/**
	   * 
	   * 描述: 多条件查询本部门实施任务
	   * @auther ljx
	   * @date 2016年11月11日 
	   * @param map
	   * @return
	   */
	@Override
	public List<PubSctaskDto> selectDeptStacktoListJson(PageRequest request,String deptId) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> map = request.getParams();
		
		// TODO Auto-generated method stub
		if(map!=null){
			map.put("deptId",deptId);
		if(map.get("leaderDeptCode")!=null&&!map.get("leaderDeptCode").equals("")){
			map.put("items",map.get("leaderDeptCode").toString().split(","));
		}
		if(map.get("inspectDept")!=null&&!map.get("inspectDept").equals("")){
			map.put("inspectDepts",map.get("inspectDept").toString().split(","));
		}
		}else{
			map=new HashMap<String,Object>();
			map.put("deptId",deptId);
		} 
		
		return pubSctaskMapper.selectDeptStacktoListJson(map);
	}
	
	 /**
	   * 描述:任务结束
	   * @author chenxin
	   * @date 2016-11-07
	   * @param taskNO
	   * @param deptTaskUid
	   * @throws Exception
	   */
	@Override
	public boolean setSctaskOver(String taskNO) throws Exception {
		Example example = new Example(PubSctask.class);
		example.createCriteria().andEqualTo("UID", taskNO);
		PubSctask pubSctask = new PubSctask();
		pubSctask.setTaskState(ScTaskStates.Finished.getCode());
		int num = pubSctaskMapper.updateByExampleSelective(pubSctask,example);
		if(num > 0){
			return true;
		}else{
			return false;
		}
	}
}