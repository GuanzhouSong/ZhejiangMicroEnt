/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月18日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SysLogDto;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_log 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public interface SysLogMapper extends Mapper<SysLog> {
	/**
	 * 
	 * 描述: 获取系统日志列表list
	 * @auther chenxin
	 * @date 2016-09-19
	 * @param map 
	 * @return List<SysLogDto>
	 */
	public List<SysLogDto> selectSysLogList(Map<String, Object> map);
	
	/**
	 * 描述：根据内部序号查询日志详情
	 * @author chenxin
	 * @date 2016-09-120
	 * @param map
	 * @return SysLogDto
	 */
	public SysLogDto selectSysLogDtoById(Map<String, Object> map);
	
}