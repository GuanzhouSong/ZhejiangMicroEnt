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
import com.icinfo.cs.rpt.rptdto.RptEntIminfoDto;
import com.icinfo.cs.rpt.rptservice.IRptEntIminfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: 企业公示信息统计
 *
 * @author framework generator
 * @date 2017年08月07日
 */
@Controller
@RequestMapping("/reg/server/pubinfo")
public class PubInfoController extends CSBaseController {

	@Autowired
	IRptEntIminfoService rptEntIminfoService;

	/**
	 * 
	 * 描述: 企业公示信息统计页面
	 * 
	 * @auther baifangfang
	 * @date 2017年08月07日
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pubInfoCount")
	public ModelAndView pubInfoCount(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/rpt/pubinfo/pubinfocount_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		// 警示协同的地址 默认警示
		String deptCode = "";
		if (sysUser.getDepartMent() != null) {
			deptCode = sysUser.getDepartMent().getDeptCode();
			if (deptCode.length() > 4) {
				deptCode = deptCode.substring(0, 4);
			}
		}
		view.addObject("startCheckPushDate", DateUtil.getYear() + "-01-01"); // 开始日期
		view.addObject("endCheckPushDate", DateUtil.getNdaylater2(DateUtil.getSysDate(), -1)); // 结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser)); // 层级
		view.addObject("year", DateUtil.getYear()); // 当前年份
		view.addObject("month", DateUtil.getMonth()); // 当前月份
		return view;
	}

	/**
	 * 
	 * 描述: 企业公示信息统计
	 * 
	 * @auther baifangfang
	 * @date 2017年07月08日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("pubInfoCount.json")
	@ResponseBody
	public PageResponse<RptEntIminfoDto> rptYrCountJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "regOrgCode", "localAdmCode");
		List<RptEntIminfoDto> data = rptEntIminfoService.selectRptEntIminfoCount(request);
		return new PageResponse<RptEntIminfoDto>(data);
	}
}