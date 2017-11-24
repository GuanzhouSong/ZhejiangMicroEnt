/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月20日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidAltitemDto;
import com.icinfo.cs.ext.model.MidAltitem;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_altitem 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface MidAltitemMapper extends Mapper<MidAltitem> {

	/**
	 * 描述：查询变更信息列表
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param params
	 * @return
	 */
	List<MidAltitemDto> queryPageResultByPripid(Map<String, Object> params);
	
	/**
	 * 
	 * 描述   根据主体身份代码获取变更信息
	 * @author 赵祥江
	 * @date 2017年7月12日 下午4:15:47 
	 * @param 
	 * @return List<MidAltitemDto>
	 * @throws
	 */
	List<MidAltitemDto> selectMidAltitemByPripid(Map<String, Object> params);
	
	
}