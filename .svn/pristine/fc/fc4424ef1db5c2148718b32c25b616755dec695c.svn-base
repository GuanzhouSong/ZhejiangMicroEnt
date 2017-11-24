/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.rpt.rptdto.RptSmImportDto;
import com.icinfo.cs.rpt.rptservice.IRptSmImportService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_rpt_sm_import 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月05日
 */
@Controller
@RequestMapping("/sment/server/rptsmimport" )
public class RptSmImportController extends BaseController {
	
	@Autowired
	private IRptSmImportService rptSmImportService;
	



	/**
	 * 
	 * 描述: 登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月8日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptSmImportCount")
	public ModelAndView rptSmImportCount(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/sment/rpt/rptsmimport_list"); 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.getYear()+"-01-01");  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:   登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptSmImportCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmImportDto> rptYrCountJSON(PageRequest request)throws Exception{
//	 creatDefaultDBAuthEnv(request,"regOrgCode","localAdmCode");
	 List<RptSmImportDto> data= rptSmImportService.selectRptSmImportCount(request);
	 return new PageResponse<RptSmImportDto>(data);
	}
	
	
	
	
}