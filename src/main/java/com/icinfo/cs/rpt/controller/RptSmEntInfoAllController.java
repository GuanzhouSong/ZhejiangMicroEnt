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
import com.icinfo.cs.rpt.rptdto.RptSmEntInfoAllDto;
import com.icinfo.cs.rpt.rptservice.IRptSmEntInfoAllService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    rpt_sm_ent_info_all 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月09日
 */
@Controller
@RequestMapping("/sment/server/rptsmentinfoall")
public class RptSmEntInfoAllController extends CSBaseController {
	
	@Autowired
	private IRptSmEntInfoAllService rptSmEntInfoAllService;
	
	 /**
     * 
     * 描述: 登记信息统计（普通统计）
     * @auther gaojinling
     * @date 2017年5月4日 
     * @param session
     * @return
     * @throws Exception
     */
	@RequestMapping("/rptSmNormalCount")
	public ModelAndView rptSmNormalCount(HttpSession session) throws Exception{
		ModelAndView view; 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}
		if("3300".equals(deptCode)){
			 view  = new ModelAndView("/sment/rpt/rptsmnormalsj_list");
		}else{
			 view  = new ModelAndView("/sment/rpt/rptsmnormal_list");
		}
		view.addObject("startCheckPushDate", DateUtil.stringToDate(DateUtil.getYear()+"-01-01", "YYYY-MM-dd"));  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylaterDate(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:  登记信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptSmNormalCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmEntInfoAllDto> rptYrCountJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
	 List<RptSmEntInfoAllDto> data= rptSmEntInfoAllService.selectRptSmNormalCount(request);
	 Integer total=rptSmEntInfoAllService.selectRptSmNormalTotal();
	 return new PageResponse<RptSmEntInfoAllDto>(data,total,request);
	}
	
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
		ModelAndView view; 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}
		if("3300".equals(deptCode)){
			 view  = new ModelAndView("/sment/rpt/rptsmimportsj_list");
		}else{
			 view  = new ModelAndView("/sment/rpt/rptsmimport_list");
		}
		view.addObject("startCheckPushDate", DateUtil.stringToDate(DateUtil.getYear()+"-01-01", "YYYY-MM-dd"));  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylaterDate(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:登记信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptSmImportCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmEntInfoAllDto> rptSmImportCountJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
	 List<RptSmEntInfoAllDto> data= rptSmEntInfoAllService.selectRptImportCount(request);
	 Integer total=rptSmEntInfoAllService.selectRptSmImportTotal();
	 return new PageResponse<RptSmEntInfoAllDto>(data,total,request);
	}
	
	
	 /**
     * 
     * 描述: 登记信息统计省局用户（普通统计）
     * @auther gaojinling
     * @date 2017年5月4日 
     * @param session
     * @return
     * @throws Exception
     */
	@RequestMapping("/rptSmNormalsjCount")
	public ModelAndView rptSmNormalsjCount(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/sment/rpt/rptsmnormalsj_list"); 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.stringToDate(DateUtil.getYear()+"-01-01", "YYYY-MM-dd"));  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylaterDate(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:  登记信息统计省局用户（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptSmNormalsjCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmEntInfoAllDto> rptYrCountsjJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
	 List<RptSmEntInfoAllDto> data= rptSmEntInfoAllService.selectRptSmNormalsjCount(request);
	 Integer total=rptSmEntInfoAllService.selectRptSmNormalsjTotal();
	 return new PageResponse<RptSmEntInfoAllDto>(data,total,request);
	}
	
	/**
	 * 
	 * 描述: 登记信息统计省局用户（重点统计）
	 * @auther gaojinling
	 * @date 2017年5月4日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptSmImportsjCount")
	public ModelAndView rptSmImportsjCount(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/sment/rpt/rptsmimportsj_list"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.stringToDate(DateUtil.getYear()+"-01-01", "YYYY-MM-dd"));  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylaterDate(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/**
	 * 
	 * 描述:  登记信息统计省局用户（重点统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptSmImportsjCount.json","list.xml"})
	@ResponseBody
	public PageResponse<RptSmEntInfoAllDto> rptSmImportsjCountJSON(PageRequest request)throws Exception{
		creatDefaultDBAuthEnv(request,"t.regOrg","t.localAdm");
		List<RptSmEntInfoAllDto> data= rptSmEntInfoAllService.selectRptImportsjCount(request);
		Integer total=rptSmEntInfoAllService.selectRptSmImportsjTotal();
		return new PageResponse<RptSmEntInfoAllDto>(data,total,request);
	}
	
	
}