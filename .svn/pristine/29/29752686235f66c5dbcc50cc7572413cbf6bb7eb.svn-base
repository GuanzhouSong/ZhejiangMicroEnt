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

import com.icinfo.cs.system.model.WorkDay;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_holiday 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public interface WorkDayMapper extends Mapper<WorkDay> {

	
	public List<WorkDay> selectWorkDayListInfo(Map<String, Object> map);

	
	
	public int updateWorkDays(WorkDay workDay);
	
	/**
	 * 
	 * 描述: 查询N个工作日之后的日期
	 * @auther gaojinling
	 * @date 2016年10月20日 
	 * @param qryMap
	 * @return
	 */
    public WorkDay getNWorkDaylaterWorkDay(Map<String,Object> qryMap);
    
	/**
	 * 
	 * 描述: 查询N个工作日之前的日期
	 * @auther gaojinling
	 * @date 2016年10月20日 
	 * @param qryMap
	 * @return
	 */
	public WorkDay getNWorkDaypriorWorkDay(Map<String,Object> qryMap); 
}