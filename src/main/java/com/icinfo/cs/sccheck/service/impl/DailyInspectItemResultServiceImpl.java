/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import com.icinfo.cs.sccheck.mapper.DailyInspectItemResultMapper;
import com.icinfo.cs.sccheck.model.DailyInspectItemResult;
import com.icinfo.cs.sccheck.service.IDailyInspectItemResultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述: cs_daily_inspect_item_result 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月07日
 */
@Service
public class DailyInspectItemResultServiceImpl extends MyBatisServiceSupport implements IDailyInspectItemResultService {

	@Autowired
	DailyInspectItemResultMapper dailyInspectItemResultMapper;

	@Override
	public List<DailyInspectItemResult> queryDailyInspectItemResultListByResultUid(String resultUid) {
		DailyInspectItemResult dailyInspectItemResult = new DailyInspectItemResult();
		dailyInspectItemResult.setResultUid(resultUid);
		return dailyInspectItemResultMapper.select(dailyInspectItemResult);
	}
}