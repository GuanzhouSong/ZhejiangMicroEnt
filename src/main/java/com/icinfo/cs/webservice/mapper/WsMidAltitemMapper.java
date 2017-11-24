/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月17日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;
import java.util.List;
import java.util.Map;
import com.icinfo.cs.webservice.model.WsMidAltitem;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_altitem 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
public interface WsMidAltitemMapper extends Mapper<WsMidAltitem> {
	
	List<WsMidAltitem> selectWsMidAltitemListByContion(Map<String, Object> params);
	
	Integer selectWsMidAltitemCountByContion(Map<String, Object> params);
	
	Integer selectWsMidAltitemMaxId(Map<String, Object> params);
	
	Integer selectWsMidAltitemMinId(Map<String, Object> params);
}