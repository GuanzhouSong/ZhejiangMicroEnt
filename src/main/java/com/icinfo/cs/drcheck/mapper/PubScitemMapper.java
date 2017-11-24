/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.model.PubScitem;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_scitem 对应的Mapper接口.<br>
 * 
 * @author framework generator
 * @date 2016年10月25日
 */
public interface PubScitemMapper extends Mapper<PubScitem> {
	/**
	 * 
	 * 描述:查询for树状结构
	 * 
	 * @auther ljx
	 * @date 2016年10月26日
	 * @return
	 */
	List<Map<String, Object>> selectToTreeMap();
}