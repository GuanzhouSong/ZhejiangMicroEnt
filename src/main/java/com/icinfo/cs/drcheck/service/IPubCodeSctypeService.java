/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_code_sctype 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月08日
 */
public interface IPubCodeSctypeService extends BaseService {

	 /**
	  * 
	  * 描述: 描述:查询for树状结构
	  * @auther ljx
	  * @date 2016年11月9日 
	  * @param map
	  * @return
	  */
	  List<Map<String,Object>>	selectToTreeMap(Map<String,Object> map);


}