/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.system.model.WorkDay;
import com.icinfo.cs.system.service.IWorkDayService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_sys_holiday 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Controller
@RequestMapping("/admin/system/workday")
public class WorkDayController extends BaseController {
	
	@Autowired
	private IWorkDayService workDayService;
	
	/**
	 * 
	 * 描述: 进入节假日管理页面
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(String year) throws Exception{
		ModelAndView view = new ModelAndView("reg/server/yr/sysmanage/workday/workday");
		Date curDate = new Date();
		Map<String, Object> map = new HashMap<String, Object>();
		if(StringUtils.isEmpty(year)){
			Calendar a=Calendar.getInstance();
			int intYear = a.get(Calendar.YEAR);//得到年
			year = String.valueOf(intYear);
		}
		map.put("year", year);
		view.addObject("year",year);
		view.addObject("curDate", curDate);
		List<WorkDay> workdayList = workDayService.selectDayInfoList(map);
		if(CollectionUtils.isNotEmpty(workdayList)){
			view.addObject("workdayList", workdayList);
		}
        return view;
	}
	
	/**
	 * 
	 * 描述: 节假日提交
	 * @auther yujingwei
	 * @date 2016年9月11日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/commit",method ={RequestMethod.POST})
	@ResponseBody
	public AjaxResult commit(@RequestBody List<WorkDay> holidayList) throws Exception{
		if(CollectionUtils.isNotEmpty(holidayList)){
			try {
				workDayService.updateWorkDays(holidayList);
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.error("保存失败");
			}
		}
		return AjaxResult.success("保存成功");
	}
}