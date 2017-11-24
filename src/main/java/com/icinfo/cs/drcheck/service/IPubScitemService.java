/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.model.PubScitem;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_scitem 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubScitemService extends BaseService {
	/**
	  * 
	  * 描述:查询for树状结构
	  * @auther ljx
	  * @date 2016年10月26日 
	  * @return
	  */
	  List<Map<String,Object>>	selectToTreeMap();

	  /**
		 * 描述：根据科目大类查询配置项信息(公用)
		 * @author chenxin
		 * @date 2016-10-27
		 * @param scType
		 * @return List<PubScitemResult>
		 * @throws Exception
		 */
		public List<PubScitem> selectPubScitemByScType(String scType);
}