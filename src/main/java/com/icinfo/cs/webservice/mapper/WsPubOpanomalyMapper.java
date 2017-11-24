/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月22日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;

import java.util.List;
import java.util.Map;
import com.icinfo.cs.webservice.model.WsPubOpanomaly;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_opanomaly 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
public interface WsPubOpanomalyMapper extends Mapper<WsPubOpanomaly> {
	
	List<WsPubOpanomaly> selectWsPubOpanomalyListByContion(Map<String, Object> params);
	
	Integer selectWsPubOpanomalyCountByContion(Map<String, Object> params);
	
	Integer selectWsPubOpanomalyMaxId(Map<String, Object> params);
	
	Integer selectWsPubOpanomalyMinId(Map<String, Object> params);
	
	
}