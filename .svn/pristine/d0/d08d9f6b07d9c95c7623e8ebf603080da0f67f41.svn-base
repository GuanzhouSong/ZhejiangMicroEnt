/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.WorkDay;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_sys_holiday 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public interface IWorkDayService extends BaseService {
	/**
	 * 
	 * 描述: 通过年度获取节假日list数据
	 * @auther yujingwei
	 * @param year
	 * @date 2016年9月11日 
	 * @return List<WorkDay>
	 * @throws Exception
	 */
	public List<WorkDay> selectDayInfoList(Map<String, Object> map) throws Exception;
    
	/**
	 * 
	 * 描述: 更新节假日信息
	 * @auther yujingwei
	 * @param year
	 * @date 2016年9月11日 
	 * @return dateStr
	 * @throws Exception
	 */
	public void updateWorkDays(List<WorkDay> holidayList) throws Exception;
	
	/**
	 * 
	 * 描述: 计算过了N个工作日之后的日期
	 * @auther gaojinling
	 * @date 2016年10月20日 
	 * @param workday
	 * @param days
	 * @return
	 * @throws Exception
	 */
	public Date getNWorkDaylaterWorkDay(final String workday, final int days) throws Exception;
}