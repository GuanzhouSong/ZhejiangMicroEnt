/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.system.mapper.WorkDayMapper;
import com.icinfo.cs.system.model.WorkDay;
import com.icinfo.cs.system.service.IWorkDayService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:    cs_sys_holiday 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Service
public class WorkDayServiceImpl extends MyBatisServiceSupport implements IWorkDayService {
	@Autowired
	private WorkDayMapper workDayMapper;
	
	/**
	 * 
	 * 描述: 通过年度获取节假日list数据
	 * @auther yujingwei
	 * @param map
	 * @date 2016年9月11日 
	 * @return List<WorkDay>
	 */
	@Override
	public List<WorkDay> selectDayInfoList(Map<String, Object> map) throws Exception{
		List<WorkDay> workDayList = workDayMapper.selectWorkDayListInfo(map);
		return workDayList;
	}
	
	/**
	 * 
	 * 描述: 更新节假日信息
	 * @auther yujingwei
	 * @param year
	 * @date 2016年9月11日 
	 * @return dateStr
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public void updateWorkDays(List<WorkDay> holidayList) throws Exception{
		if(CollectionUtils.isNotEmpty(holidayList)){
			for(WorkDay workDay : holidayList){
				workDayMapper.updateWorkDays(workDay);
			}
		}
	 }

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
	public Date getNWorkDaylaterWorkDay(String workday, int days)
			throws Exception {
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("workday", workday);
			qryMap.put("days",  Math.abs(days));
			WorkDay resultWorkDay = null;
			if(days>0){
				resultWorkDay = this.workDayMapper.getNWorkDaylaterWorkDay(qryMap);
			}else if(days<0){
				resultWorkDay = this.workDayMapper.getNWorkDaypriorWorkDay(qryMap);
			}else{
				return DateUtil.stringToDate(workday, "yyyy-MM-dd");
			}
			return resultWorkDay.getCalendar();
	}
}