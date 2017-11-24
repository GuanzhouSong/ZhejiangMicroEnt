package com.icinfo.cs.yr.service;

import org.springframework.web.servlet.ModelAndView;
/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */


import com.icinfo.cs.ext.dto.MidBaseInfoDto;

/**
 * 
 * 描述:    年报打印 Service接口
 * @author: 赵祥江
 * @date: 2016年9月19日 上午9:48:48
 */
public interface IYrPrintService {
	/**
	 * 
	 * 描述             : 打印年度报告证明
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 上午11:08:27 
	 * @param :
	 * @return: ModelAndView
	 * @throws
	 */
	public ModelAndView printerEnAnnualReportProve(String priPID,int year,MidBaseInfoDto midBaseInfoDto) throws Exception;


	/**
	 * 
	 * 描述             : 打印当年年度报告
	 * @author: 赵祥江
	 * @date  : 2016年9月19日 下午1:49:58 
	 * @param :
	 * @return: ModelAndView
	 * @throws
	 */
	public ModelAndView printReportCurrentReport(String priPID,int year) throws Exception;
}