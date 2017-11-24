/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.ScTaskDeptStates;
import com.icinfo.cs.drcheck.dto.PubDeptSctaskDto;
import com.icinfo.cs.drcheck.mapper.PubDeptSctaskMapper;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_dept_sctask 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubDeptSctaskServiceImpl extends MyBatisServiceSupport implements IPubDeptSctaskService {
    @Autowired
    private PubDeptSctaskMapper pubDeptSctaskMapper;
    
    /**
     * 
     * 描述: 根据任务单号判断是否所有实施部门已选中执法人员
     * @auther chenxin
     * @date 2016-10-26
     * @param taskNO
     * @return boolean
     */
    @Override
    public boolean checkDeptSctaskStateAllFinished(String taskNO)throws Exception {
    	PubDeptSctask pubDeptSctask = new PubDeptSctask();
    	pubDeptSctask.setTaskNO(taskNO);
    	pubDeptSctask.setInspectState(ScTaskDeptStates.WaitChooseAgent.getCode());
    	int count = pubDeptSctaskMapper.selectCount(pubDeptSctask);
    	if(count > 0){
    		return false;
    	}
    	return true;
    }
    
    /**
	 * 
	 * 描述: 根据任务单号判断是否所有实施部门已经完成结果审核
	 * @auther chenxin
	 * @date 2016-11-15
	 * @param taskNO
	 * @return boolean
	 */
    @Override
    public boolean checkDeptSctaskAllFinished(String taskNO) throws Exception {
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("taskNO", taskNO);
    	int count = pubDeptSctaskMapper.selectCountDeptSctaskAllFinished(paramMap);
    	if(count > 0){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    /**
	 * 描述：根据taskNO查询部门信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
    @Override
    public List<PubDeptSctaskDto> selectPubDeptSctaskByTaskNO(String taskNO,String priPID,String inspectDept) {
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("taskNO", taskNO);
    	paramMap.put("priPID", priPID);
    	if(StringUtils.isNotEmpty(inspectDept)){
    		paramMap.put("inspectDept", inspectDept);
    	}
    	List<PubDeptSctaskDto> pubDeptSctaskDtoList = pubDeptSctaskMapper.selectPubDeptSctaskByTaskNO(paramMap);
    	if(pubDeptSctaskDtoList == null || pubDeptSctaskDtoList.size() <= 0){
    		Map<String,Object> paramMapNew = new HashMap<String,Object>();
    		paramMapNew.put("taskNO", taskNO);
    		pubDeptSctaskDtoList = pubDeptSctaskMapper.selectNewPubDeptSctaskByTaskNO(paramMapNew);
    	}
    	return pubDeptSctaskDtoList;
    }
    /**
     * 
     * 描述:根据组织部门uid查询其设施部门
     * @auther ljx
     * @date 2016年11月17日 
     * @param uid
     * @return
     */
    public List<PubDeptSctask> selectPubDeptSctackByUid(String uid){
    	Example example=new Example(PubDeptSctask.class);
    	example.createCriteria().andEqualTo("taskNO",uid);
    	return pubDeptSctaskMapper.selectByExample(example);
    }
    
    
    /**
	 * 描述：根据UID查询部门信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param UID
	 * @return PubDeptSctaskDto
	 * @throws Exception
	 */
    @Override
    public PubDeptSctask selectPubDeptSctaskByUID(String UID) {
    	PubDeptSctask pubDeptSctask = new PubDeptSctask();
    	pubDeptSctask.setUID(UID);
    	return pubDeptSctaskMapper.selectOne(pubDeptSctask);
    }
    
    /**
	 * 描述：查询当前用户是否有实施任务
	 * @author chenxin
	 * @date 2016-11-22
	 * @param taskNO
	 * @param deptCode
	 * @return PubDeptSctaskDto
	 * @throws Exception
	 */
    @Override
    public PubDeptSctask selectByTaskNOAndDeptCode(String taskNO, String deptCode) {
    	PubDeptSctask pubDeptSctask = new PubDeptSctask();
    	pubDeptSctask.setTaskNO(taskNO);
    	pubDeptSctask.setInspectDept(deptCode);
    	return pubDeptSctaskMapper.selectOne(pubDeptSctask);
    }
    
    /**
	 * 描述：保存基本实施部门结果录入信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubDeptSctaskList
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean savePubDeptSctaskList(List<PubDeptSctask> pubDeptSctaskList,SysUser sysUser)throws Exception {
    	if(pubDeptSctaskList != null && pubDeptSctaskList.size() > 0){
    		for(PubDeptSctask pubDeptSctask : pubDeptSctaskList){
    			pubDeptSctaskMapper.updateByPrimaryKeySelective(pubDeptSctask);
    		}
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 描述：判断是否已填写所有实施结果
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
    @Override
    public int countPubDeptSctaskByTaskNO(String taskNO, String priPID) {
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("taskNO", taskNO);
    	paramMap.put("priPID", priPID);
    	return  pubDeptSctaskMapper.countPubDeptSctaskByTaskNO(paramMap);
    }
    
    /**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubDeptSctaskDto> selectPubDeptSctypesList(String taskNO, String priPID)throws Exception {
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("taskNO", taskNO);
    	paramMap.put("priPID", priPID);
    	return pubDeptSctaskMapper.selectPubDeptSctypesList(paramMap);
    }
    
    /**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
    @Override
    public List<PubDeptSctaskDto> selectPubDeptSctypesListByTaskNO(String taskNO)throws Exception {
    	return pubDeptSctaskMapper.selectPubDeptSctypesListByTaskNO(taskNO);
    }
    
    /**
	 * 描述：执法人员录入后 修改任务状态
	 * @author chenxin
	 * @date 2016-11-07
	 * @param uid
	 * @param state
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean updateInspectState(String uid, String state)throws Exception {
    	if(StringUtils.isNotEmpty(uid) && StringUtils.isNotEmpty(state)){
    		PubDeptSctask pubDeptSctask = new PubDeptSctask();
    		pubDeptSctask.setInspectState(state);
    		Example Example = new Example(PubDeptSctask.class);
    		Example.createCriteria().andEqualTo("UID",uid);
    		pubDeptSctaskMapper.updateByExampleSelective(pubDeptSctask, Example);
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 描述：结果录入修改状态
	 * @author chenxin
	 * @date 2016-11-07
	 * @param uid
	 * @param state
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean updateInspectState(String taskNO, String deptTaskNO,Date inspectDate) throws Exception {
    	if(StringUtils.isNotEmpty(taskNO)  && StringUtils.isNotEmpty(deptTaskNO) && inspectDate != null){
    		PubDeptSctask pubDeptSctask = new PubDeptSctask();
    		pubDeptSctask.setInspectDate(inspectDate);
    		Example example = new Example(PubDeptSctask.class);
    		example.createCriteria().andEqualTo("UID",deptTaskNO).andEqualTo("taskNO",taskNO);
    		pubDeptSctaskMapper.updateByExampleSelective(pubDeptSctask, example);
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 描述：修改科目
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @param inspectType
	 * @param inspectTypeDesc
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean updateInspectTypes(String taskNO, String inspectType,String inspectTypeDesc) throws Exception {
    	PubDeptSctask pubDeptSctask = new PubDeptSctask();
		pubDeptSctask.setInspectType(inspectType);
		pubDeptSctask.setInspectTypeDesc(inspectTypeDesc);
    	Example example = new Example(PubDeptSctask.class);
    	example.createCriteria().andEqualTo("UID",taskNO);
    	pubDeptSctaskMapper.updateByExampleSelective(pubDeptSctask, example);
    	return false;
    }
}