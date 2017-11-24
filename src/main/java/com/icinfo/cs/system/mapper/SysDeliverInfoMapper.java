/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月30日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_deliverinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface SysDeliverInfoMapper extends Mapper<SysDeliverInfo> {
	
	/***
	 * 
	 * 描述: 查询确认送达书匹配地址
	 * @auther gaojinling
	 * @date 2016年8月30日 
	 * @param map
	 * @return
	 */
	public List<SysDeliverInfo> selectDeliverInfoList(Map<String, Object> map) ;

}