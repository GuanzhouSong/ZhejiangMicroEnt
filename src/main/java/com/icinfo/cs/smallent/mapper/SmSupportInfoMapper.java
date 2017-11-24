/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月31日
 * @version 2.0
 */
package com.icinfo.cs.smallent.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.smallent.model.SmSupportInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sm_support 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
public interface SmSupportInfoMapper extends Mapper<SmSupportInfo> {

	List<SmSupportInfo> selectSupportInfoList(Map<String, Object> params);
}