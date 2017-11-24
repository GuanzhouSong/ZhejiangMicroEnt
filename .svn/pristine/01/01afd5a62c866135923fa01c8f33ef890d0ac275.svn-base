/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.Date;
import java.util.List;

import com.icinfo.cs.drcheck.dto.PubDeptSctaskDto;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_dept_sctask 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubDeptSctaskService extends BaseService {
	/**
     * 
     * 描述: 根据任务单号判断是否所有实施部门已选中执法人员
     * @auther chenxin
     * @date 2016-10-26
     * @param taskNO
     * @return boolean
     */
	public boolean checkDeptSctaskStateAllFinished(String taskNO)throws Exception;
	
	/**
	 * 
	 * 描述: 根据任务单号判断是否所有实施部门已经完成结果审核
	 * @auther chenxin
	 * @date 2016-11-15
	 * @param taskNO
	 * @return boolean
	 */
	public boolean checkDeptSctaskAllFinished(String taskNO)throws Exception;
	
	/**
	 * 描述：根据taskNO查询部门信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctaskByTaskNO(String taskNO,String priPID,String inspectDept);
	
	/**
	 * 描述：根据UID查询部门信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param UID
	 * @return PubDeptSctaskDto
	 * @throws Exception
	 */
	public PubDeptSctask selectPubDeptSctaskByUID(String UID);
	
	/**
	 * 描述：查询当前用户是否有实施任务
	 * @author chenxin
	 * @date 2016-11-22
	 * @param taskNO
	 * @param deptCode
	 * @return PubDeptSctaskDto
	 * @throws Exception
	 */
	public PubDeptSctask selectByTaskNOAndDeptCode(String taskNO,String deptCode);
	
	/**
	 * 描述：判断是否已填写所有实施结果
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return List<PubDeptSctaskDto>
	 * @throws Exception
	 */
	public int countPubDeptSctaskByTaskNO(String taskNO,String priPID);
	
	/**
	 * 描述：保存基本实施部门结果录入信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubDeptSctaskList
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public boolean savePubDeptSctaskList(List<PubDeptSctask> pubDeptSctaskList,SysUser sysUser)throws Exception;
	
	/**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctypesList(String taskNO, String priPID)throws Exception;
	
	/**
	 * 描述：根据任务id查询本次抽查检查--科目类型
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<PubDeptSctaskDto> selectPubDeptSctypesListByTaskNO(String taskNO)throws Exception;
	
	 /**
     * 
     * 描述:根据组织部门uid查询其设施部门
     * @auther ljx
     * @date 2016年11月17日 
     * @param uid
     * @return
     */
	
	List<PubDeptSctask> selectPubDeptSctackByUid(String uid)throws Exception;
	/**
	 * 描述：执法人员录入后 修改任务状态
	 * @author chenxin
	 * @date 2016-11-07
	 * @param uid
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public boolean updateInspectState(String uid,String state)throws Exception;
	
	/**
	 * 描述：结果录入修改状态
	 * @author chenxin
	 * @date 2016-11-07
	 * @param uid
	 * @param state
	 * @return
	 * @throws Exception
	 */
	public boolean updateInspectState(String taskNO,String deptTaskNO,Date inspectDate)throws Exception;
	
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
	public boolean updateInspectTypes(String taskNO,String inspectType,String inspectTypeDesc)throws Exception;
	
	
}