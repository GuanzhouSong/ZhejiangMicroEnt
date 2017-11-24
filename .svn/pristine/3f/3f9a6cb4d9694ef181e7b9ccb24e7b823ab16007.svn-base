/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月10日
 * @version 2.0
 */
package com.icinfo.cs.registmanage.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registmanage.dto.LimitManageRecordDto;
import com.icinfo.cs.registmanage.model.LimitManageRecord;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_limit_managerecord 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月10日
 */
public interface LimitManageRecordMapper extends Mapper<LimitManageRecord> {

	/**
	 * 描述：获取受限对象关联的企业列表
	 * @param params
	 * @return 
	 */
	List<LimitManageRecordDto> qryLimitObjManageRecordList(Map<String, Object> params);
	
	
	/**
	 * 
	 * 描述: 获取当前限制对象下的解除证明文号的最大值
	 * @auther gaojinling
	 * @date 2017年4月17日 
	 * @param queryMap
	 * @return
	 */
	public Integer selectLimitNo (Map<String,Object> queryMap);
}