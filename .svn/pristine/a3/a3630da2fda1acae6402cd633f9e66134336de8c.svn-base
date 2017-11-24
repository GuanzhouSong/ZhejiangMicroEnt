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
import com.icinfo.cs.rpt.rptdto.OpanoMalyRptDto;
import com.icinfo.cs.rpt.rptservice.IOpanoMalyRptService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_rpt_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月13日
 */
@Controller
@RequestMapping("/reg/server/opanomalyrpt" )
public class OpanoMalyRptController extends CSBaseController {
	@Autowired
	private IOpanoMalyRptService rptOpanoMalyService;
	 
	/**
	 * 
	 * 描述   异常名录统计
	 * @author 赵祥江
	 * @date 2017年2月13日 上午9:26:05 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/opanomalyrpt")
	public ModelAndView opanomalyrpt(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/rpt/opanomalyrpt_list"); 
	    SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(sysUser.getDepartMent()!=null){
			deptCode=sysUser.getDepartMent().getDeptCode();
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}
		view.addObject("startCheckPushDate", DateUtils.getYear()+"-01-01");  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));              //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtils.getYear());       //层级
		view.addObject("month", DateUtil.getMonth()); 
		return view;
	}
	
	
	/**
	 * 
	 * 描述   异常名录统计
	 * @author 赵祥江
	 * @date 2017年2月13日 上午10:50:57 
	 * @param 
	 * @return PageResponse<RptOpanoMalyDto>
	 * @throws
	 */
	@RequestMapping({"/opanomalyrptJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<OpanoMalyRptDto> opanomalyrptJSON(PageRequest request)throws Exception{
	 creatDefaultDBAuthEnv(request,"A.regOrgCode","A.localAdmCode");
	 List<OpanoMalyRptDto> data= this.rptOpanoMalyService.selectOpanoMalyrpt(request);
	 return new PageResponse<OpanoMalyRptDto>(data);
 	}
}