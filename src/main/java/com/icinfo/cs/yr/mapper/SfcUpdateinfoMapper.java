/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月10日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.SfcUpdateinfoDto;
import com.icinfo.cs.yr.model.SfcUpdateinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sfc_updateinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月10日
 */
public interface SfcUpdateinfoMapper extends Mapper<SfcUpdateinfo> {

	/**
	 * 描述：查询农专年报修改信息
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param params
	 * @return
	 */
	List<SfcUpdateinfoDto> queryPageResult(Map<String, Object> params);

	List<SfcUpdateinfoDto> selectInfoForbidWord(Map<String, Object> params);
}