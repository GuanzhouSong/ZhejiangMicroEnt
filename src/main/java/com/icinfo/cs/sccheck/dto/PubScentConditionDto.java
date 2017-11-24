/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.dto;

import java.util.List;

import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScentCondition;

/**
 * 描述:    cs_pub_scent_condition 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public class PubScentConditionDto extends PubScentCondition {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//参数：保存设置条件
	private List<PubScentCondition> PubScentConditionList;
	
	//参数：用于保存设置条件
	private PubScPlanTask pubScPlanTask;

	public List<PubScentCondition> getPubScentConditionList() {
		return PubScentConditionList;
	}

	public void setPubScentConditionList(
			List<PubScentCondition> pubScentConditionList) {
		PubScentConditionList = pubScentConditionList;
	}

	public PubScPlanTask getPubScPlanTask() {
		return pubScPlanTask;
	}

	public void setPubScPlanTask(PubScPlanTask pubScPlanTask) {
		this.pubScPlanTask = pubScPlanTask;
	}
}