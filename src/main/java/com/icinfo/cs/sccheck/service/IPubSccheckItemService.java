/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;

import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_sccheck_item 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubSccheckItemService extends BaseService {
	
	/**
	 * 
	 * 描述   根据任务uid删除
	 * @author 赵祥江
	 * @date 2017年5月19日 上午9:01:36 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deletePubSccheckItemByTaskUid(String taskUid)throws Exception;
	
	/**
	 * 
	 * 描述   根据任务uid查询
	 * @author 赵祥江
	 * @date 2017年5月19日 上午9:02:36 
	 * @param 
	 * @return List<PubSccheckItem>
	 * @throws
	 */
	public List<PubSccheckItem> selectPubSccheckItemByTaskUid(String taskUid)throws Exception;
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年5月19日 上午9:03:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertPubSccheckItem(PubSccheckItem pubSccheckItem)throws Exception;
	
	/**
	 * 
	 * 描述   查询企业相关的检查事项
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param deptTaskUid
	 * @param priPID
	 * @return List<PubSccheckItem>
	 * @throws
	 */
	public List<PubSccheckItem> selectEntRlate(String deptTaskUid,String priPID)throws Exception;

	/**
	 * 
	 * 描述   查询企业相关的检查事项
	 * @author chenxin
	 * @date 2017年6月1日 上午9:02:36 
	 * @param pubScdeptTask
	 * @param priPID
	 * @return List<PubSccheckItem>
	 * @throws
	 */
	public List<PubSccheckItem> selectRlateSpecial(PubScdeptTask pubScdeptTask, String priPID)throws Exception;
	
}