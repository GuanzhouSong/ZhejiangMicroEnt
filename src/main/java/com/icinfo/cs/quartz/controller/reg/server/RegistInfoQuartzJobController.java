package com.icinfo.cs.quartz.controller.reg.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.icinfo.cs.quartz.service.IRegistInfoQuartzJobService;
import com.icinfo.framework.core.web.BaseController;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: TODO
 * @author: 刘海强
 * @date: 2016年11月07日 上午10:08:55
 * @version: V1.0  
 */
@Controller
@RequestMapping("/quartz/registInfoPush")
public class RegistInfoQuartzJobController extends BaseController{
	@Autowired
	private IRegistInfoQuartzJobService registInfoQuartzJobService;
	
//	@Autowired
//	IPubPbopanomalyNoReportQuartzJobService pubPbopanomalyNoReportQuartzJobService;
//	
//	@Autowired
//	IPubPbopanomalyQuartzJobService pubPbopanomalyQuartzJobService;
//	
//	@Autowired
//	IPubOpanomalyDXAutoOutQuartzJobService pubOpanomalyDXAutoOutQuartzJobService;
	


	/**
	 * 
	 * 描述:主体户口定时任务：查找不在建档表里的MID数据,插入建档表，有管辖单位的
	 * 随机分配选择管辖人员。
	 * @auther gaojinling
	 * @date 2017年4月25日 
	 * @throws Exception
	 */
	public void registInfoSyn() throws Exception{
		registInfoQuartzJobService.registInfoSyn();
	}
	
	/**
	 * 描述：个体户未按时年报列异测试
	 * @author baifangfang
	 * @date 2017年7月19日
	 * @throws Exception
	 */
	@RequestMapping("test")
	public void test() throws Exception {
		//pubPbopanomalyNoReportQuartzJobService.pbopanomalyNoReportQuartzJob();
	}
	
	/**
	 * 描述：个体户已年报恢复异常测试
	 * @author baifangfang
	 * @date 2017年7月19日
	 * @throws Exception
	 */
	@RequestMapping("test1")
	public void test1() throws Exception {
//		pubPbopanomalyQuartzJobService.pubPbopanomalyOutQuartzJob();
	}
	
	/**
	 * 描述：个体户注销移除异常测试
	 * @author baifangfang
	 * @date 2017年7月19日
	 * @throws Exception
	 */
	@RequestMapping("test2")
	public void test2() throws Exception {
		//pubOpanomalyDXAutoOutQuartzJobService.pubOpanomalyDXAutoOutQuartzJob();
	}
	

}
