/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.model.UnifiedUserRecord;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_unified_user_record 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月07日
 */
public interface IUnifiedUserRecordService extends BaseService {
	 /**
	  * 
	  * 描述   保存
	  * @author 赵祥江
	  * @date 2017年6月7日 上午10:15:23 
	  * @param 
	  * @return int
	  * @throws
	  */
	 public int insertUnifiedUserRecord(UnifiedUserRecord unifiedUserRecord)throws Exception;
}