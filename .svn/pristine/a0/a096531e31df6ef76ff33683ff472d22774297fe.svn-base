/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubSctaskDto;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_sctask 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubSctaskService extends BaseService {
	/**
     * 
     * 描述: 保存信息
     * @auther ljx
     * @date 2016年10月25日 
     * @param pubSctask
     * @return
     */
	int insert(PubSctask pubSctask);
	/**
	   * 	
	   * 描述: 查询for json 多条件
	   * @auther ljx
	   * @date 2016年10月25日 
	   * @param map
	   * @return
	   */
	  List<PubSctaskDto> selectByManyCationToListJson(PageRequest request,String deptId);
	  
	  /**
	   *  
	   * 描述:多条件查询本部门组织的任务
	   * @auther ljx
	   * @date 2016年11月11日 
	   * @param map
	   * @return
	   */
	  List<PubSctaskDto> selectLeadStacktoListJson(PageRequest request,String deptId);
	  /**
	   * 
	   * 描述: 多条件查询本部门实施任务
	   * @auther ljx
	   * @date 2016年11月11日 
	   * @param map
	   * @return
	   */
	  List<PubSctaskDto> selectDeptStacktoListJson(PageRequest request,String deptId);
	  
	 /**
	 * 描述：根据任务编号查询任务信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public PubSctask selectPubSctaskByTaskNO(String taskNO);
	
	  /**
	   * 
	   * 描述:查询最大id
	   * @auther ljx
	   * @date 2016年10月26日 
	   * @return
	   */
	  int selectMaxId();
	  /**
	   * 
	   * 描述: 设置任务
	   * @auther ljx
	   * @date 2016年10月27日 
	   * @param pubSctaskDto
	   * @return
	   */
	Map<String,Object> setStack(PubSctaskDto pubSctaskDto,SysUserDto sysUser);
	  
	 /**
	   * 
	   * 描述: 条件统计
	   * @auther ljx
	   * @date 2016年10月27日 
	   * @param map
	   * @return
	   */
   Map<String,Object> selectCountByCation(PubSctaskDto pubSctaskDto);
	 
	 
   /**
    * 描述:随机企业信息任务提交
    * @author chenxin
    * @date 2016-11-04
    * @param taskNO
    * @param totalEnt
    * @throws Exception
    */
	  public void setTaskRandomInfoOver(String taskNO,int totalEnt)throws Exception;
	  
	  /**
	   * 描述:随机执法人员任务提交
	   * @author chenxin
	   * @date 2016-11-07
	   * @param taskNO
	   * @param deptTaskUid
	   * @throws Exception
	   */
	  public void setTaskAgentOver(String taskNO,String deptTaskUid)throws Exception;
	  
	  /**
	   * 描述:任务结束
	   * @author chenxin
	   * @date 2016-11-07
	   * @param taskNO
	   * @param deptTaskUid
	   * @throws Exception
	   */
	  public boolean setSctaskOver(String taskNO)throws Exception;
	  
}