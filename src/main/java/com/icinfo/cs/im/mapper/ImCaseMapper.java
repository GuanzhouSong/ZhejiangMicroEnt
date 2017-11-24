/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.im.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.im.dto.ImCaseDto;
import com.icinfo.cs.im.model.ImCase;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_im_case 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface ImCaseMapper extends Mapper<ImCase> {
	 
	List<ImCaseDto> findCaseByPriPID(Map<String,Object> map);
	
}