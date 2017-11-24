/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.rpt.rptdto.RptOptoExpiredDto;
import com.icinfo.cs.rpt.rptdto.RptReporteoverListDto;
import com.icinfo.cs.rpt.rptdto.YrRptDto;
import com.icinfo.cs.rpt.rptmodel.RptOptoInfo;
import com.icinfo.cs.rpt.rptservice.IRptOptoExpiredService;
import com.icinfo.cs.rpt.rptservice.IRptOptoInfoService;
import com.icinfo.cs.rpt.rptservice.IRptReporteoverListService;
import com.icinfo.cs.rpt.rptservice.IYrRptService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_rpt_opto_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年03月22日
 */
@Controller
@RequestMapping("/reg/server/rptOptoInfo" )
public class RptOptoInfoController extends CSBaseController {
	
	@Autowired
	private IRptOptoInfoService rptOptoInfoService;
	@Autowired
	private IRptOptoExpiredService rptOptoExpiredService;
	@Autowired
	private IRptReporteoverListService rptReporteoverListService;
	
	
	

	/**
	 * 
	 * 描述: 经营期限统计（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月23日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/rptOptoInfoCount.json","list.xml"})
	@ResponseBody
	public AjaxResult rptOptoInfoCountJSON(String selectCode)throws Exception{
	 Map<String, Object> map = new HashMap<String, Object>();
	 map.put("selectCode", selectCode);
	 creatOptDBAuthEnv(map,"regorg","localadm");
     SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
     if("1".equals(sysUser.getUserType())){
    	 map.put("deptCode",sysUser.getDeptCode() != null ? StringUtil.substring(sysUser.getDeptCode(), 0, 8) : "000000");
     }
	 RptOptoInfo rptOptoInfo = rptOptoInfoService.selectRptOptoCount(map);
	 return AjaxResult.success("rptOptoInfo",rptOptoInfo);
	}
	
	/**
	 * 
	 * 描述: 进入经营异常即将到期的详情列表
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptOptoWillExpiredview")
	public ModelAndView rptOptoWillExpiredDetailView(String selectCode) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/riskwarningdetail/rptoptowillexpired_list");
		view.addObject("expiredFlag", "0");
		view.addObject("selectCode", selectCode);
		return view;
	}
	/**
	 * 
	 * 描述: 进入经营异常已到期的详情列表
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptOptoExpiredview")
	public ModelAndView rptOptoExpiredDetailView(String selectCode) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/riskwarningdetail/rptoptowillexpired_list");
		view.addObject("expiredFlag", "1");
		view.addObject("selectCode", selectCode);
		return view;
	}
	
	/**
	 * 
	 * 描述: 经营异常即将到期的详情列表
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptOptoWillExpiredlist.json")
	@ResponseBody
	public PageResponse<RptOptoExpiredDto> listJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "a.RegOrg", "a.LocalAdm");
	     SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
	     if("1".equals(sysUser.getUserType())){
	    	 request.getParams().put("deptCode",sysUser.getDeptCode() != null ? StringUtil.substring(sysUser.getDeptCode(), 0, 8) : "000000");
	     }
		PageResponse<RptOptoExpiredDto> data = rptOptoExpiredService.selectRptOptoExpiredList(request);
		return data;
	}
	
	
	/**
	 * 
	 * 描述: 进入年报逾期未报的详情列表
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptReporteoverview")
	public ModelAndView rptReporteoverview(String selectCode) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/riskwarningdetail/rptreporteover_list");
		view.addObject("selectCode", selectCode);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 年报逾期未报的详情列表
	 * @auther gaojinling
	 * @date 2017年11月15日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/rptReporteoverlist.json")
	@ResponseBody
	public PageResponse<RptReporteoverListDto> ReporteoverlistJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request, "a.RegOrg", "a.LocalAdm");
	     SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
	     if("1".equals(sysUser.getUserType())){
	    	 request.getParams().put("deptCode",sysUser.getDeptCode() != null ? StringUtil.substring(sysUser.getDeptCode(), 0, 8) : "000000");
	     }
		PageResponse<RptReporteoverListDto> data = rptReporteoverListService.selectRptOptoExpiredList(request);
		return data;
	}
	
	
		
	
	
}