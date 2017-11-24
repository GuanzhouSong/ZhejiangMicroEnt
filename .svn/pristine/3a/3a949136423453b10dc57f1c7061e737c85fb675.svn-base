/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.system.mapper.UnifiedUserRecordMapper;
import com.icinfo.cs.system.model.UnifiedUserRecord;
import com.icinfo.cs.system.service.IUnifiedUserRecordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_unified_user_record 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月07日
 */
@Service
public class UnifiedUserRecordServiceImpl extends MyBatisServiceSupport implements IUnifiedUserRecordService {

	@Autowired
	private UnifiedUserRecordMapper unifiedUserRecordMapper;
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年6月7日 上午10:17:25 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertUnifiedUserRecord(UnifiedUserRecord unifiedUserRecord)
			throws Exception {
		if(unifiedUserRecord!=null){
			unifiedUserRecord.setCreateTime(DateUtil.getSysDate());
			return unifiedUserRecordMapper.insert(unifiedUserRecord);
		}
		return 0;
	}
}