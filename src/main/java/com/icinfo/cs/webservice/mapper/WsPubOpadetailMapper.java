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
import com.icinfo.cs.webservice.model.WsPubOpadetail;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_opadetail 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
public interface WsPubOpadetailMapper extends Mapper<WsPubOpadetail> {
	
	List<WsPubOpadetail> selectWsPubOpadetailListByContion(Map<String, Object> params);
	
	Integer selectWsPubOpadetailCountByContion(Map<String, Object> params);
	
	Integer selectWsPubOpadetailMaxId(Map<String, Object> params);
	
	Integer selectWsPubOpadetailMinId(Map<String, Object> params);
	
	
}