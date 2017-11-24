/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.model.PubSccheckItemResult;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述: cs_pub_sccheck_item_result 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface IPubSccheckItemResultService extends BaseService {

	/**
	 * 描述：根据taskuid查询检查事项结果表
	 * 
	 * @author baifangfang
	 * @date 2017年5月19日
	 * @param taskUid
	 * @param priPID
	 * @return
	 */
	List<PubSccheckItemResult> queryPubSccheckItemResultByTaskUidAndPriPID(String taskUid, String priPID);

	/**
	 * 描述：保存检查事项结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月13日
	 * @param map
	 * @param name
	 * @return
	 */
	int savePubSccheckItemResult(Map<String, Object> map, String name);

	/**
	  * 描述：删除检查事项结果信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月13日
	 * @param oldDeptTaskUid
	 * @param priPID
	 * @throws Exception
	 */
	void deleteByTaskUidAndPriPID(String deptTaskUid, String priPID)throws Exception;

}