/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月22日
 * @version 2.0
 */
package com.icinfo.cs.registmanage.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.registmanage.dto.InvManagerCount;
import com.icinfo.cs.registmanage.dto.InvManagerDto;
import com.icinfo.cs.registmanage.model.InvManager;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_inv_manager 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
public interface InvManagerMapper extends Mapper<InvManager> {

	/**
	 * 描述：公示出资到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @param params
	 * @return
	 */
	List<InvManagerDto> selectLicenceInvalidMgrJSON(Map<String, Object> params);

	/**
	 * 
	 * 描述：公示出资到期管理统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月22日
	 * @param params
	 * @return
	 */
	InvManagerCount selectInvManagerCount(Map<String, Object> params);
}