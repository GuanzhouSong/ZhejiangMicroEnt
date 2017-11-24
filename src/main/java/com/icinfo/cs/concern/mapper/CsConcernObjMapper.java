/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月01日
 * @version 2.0
 */
package com.icinfo.cs.concern.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.model.CsConcernObj;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_concern_obj 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface CsConcernObjMapper extends Mapper<CsConcernObj> {
	
	List<CsConcernObjDto> selectConObjList(Map<String,Object> qryMap);
	
	List<CsConcernObjDto> selectConObjListForView(Map<String,Object> qryMap);

	List<CsConcernObjDto> selectConObjListForAudit(Map<String,Object> qryMap);
	
	String doGetConcernInfoForIndex(Map<String,Object> qryMap);

	/**
	 * 描述：根据pripid获取有效的关注服务对象
	 * @author baifangfang
	 * @date 2017-04-19
	 * @param priPID
	 * @return
	 */
	List<CsConcernObjDto> selectCsConcernObjDtoByPriPID(Map<String, Object> map);
}