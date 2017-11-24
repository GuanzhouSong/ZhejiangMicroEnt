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
import com.icinfo.cs.rpt.rptdto.DeptPubInfoRptDto;
import com.icinfo.cs.rpt.rptservice.IDeptPubInfoRptService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_rpt_public_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
@Controller
@RequestMapping("/reg/server/deptpubinforpt" )
public class DeptPubInfoRptController extends CSBaseController {
	
	@Autowired
	private IDeptPubInfoRptService deptPubInfoRptService;
	
	/** 
	 * 描述: 进入部门公示信息统计页面
	 * @auther ZhouYan
	 * @date 2017年8月10日 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/rpt/deptpubinforpt_list"); 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		return view;
	}
	
	/** 
	 * 描述: 查询部门公示信息统计
	 * @auther ZhouYan
	 * @date 2017年8月10日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping({"/list.json","list.xml"})
	@ResponseBody
	public PageResponse<DeptPubInfoRptDto> rptYrCountJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"regOrgCode","localAdmCode");
	 List<DeptPubInfoRptDto> data= deptPubInfoRptService.selectDeptPubInfoRpt(request);
	 return new PageResponse<DeptPubInfoRptDto>(data);
	}
}