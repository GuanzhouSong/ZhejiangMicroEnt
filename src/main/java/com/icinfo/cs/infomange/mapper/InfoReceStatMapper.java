/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月28日
 * @version 2.0
 */
package com.icinfo.cs.infomange.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.infomange.dto.InfoReceStatDto;
import com.icinfo.cs.infomange.model.InfoReceStat;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    info_rece_stat 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月28日
 */
public interface InfoReceStatMapper extends Mapper<InfoReceStat> {
	
	List<InfoReceStatDto> selectDownDateCount(Map<String,Object> qryMap);
	
	List<InfoReceStatDto> selectSendDateCount(Map<String,Object> qryMap);
}