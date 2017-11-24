/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.creditprove.model.CreditProveInfo;
import com.icinfo.cs.creditprove.service.ICreditProveInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_credit_prove_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Controller
@RequestMapping({ "/syn/creditproveinfo", "/reg/server/creditproveinfo" })
public class CreditProveInfoController extends CSBaseController { 
	
	@Autowired
	private ICreditProveInfoService creditProveInfoService;
	
	private Map<String,Object> parmMap;
	/**
	 * 
	 * 描述   进入出证查询页面
	 * @author 赵祥江
	 * @date 2017年4月5日 下午3:07:06 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/creditproveinfoListPage")
	public ModelAndView creditproveinfoListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditprovesearch_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	/**
	 * 
	 * 描述   进入自然人页面
	 * @author 赵祥江
	 * @date 2017年4月6日 上午10:25:37 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({"/addmyman"})
	public ModelAndView addMan(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveman_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	/**
	 * 
	 * 描述   进入企业页面
	 * @author 赵祥江
	 * @date 2017年4月6日 上午10:26:38 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping({"/addmyent"})
	public ModelAndView addEnt(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveent_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	 
	/**
	 * 
	 * 描述   入口选择
	 * @author 赵祥江
	 * @date 2017年4月5日 下午4:57:58 
	 * @param 
	 * @return String
	 * @throws
	 */
	@RequestMapping({"/entrance"})
	public ModelAndView entrance(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/entrance");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   分页查询查证单
	 * @author 赵祥江
	 * @date 2017年4月21日 下午5:55:19 
	 * @param 
	 * @return PageResponse<CreditProveInfo>
	 * @throws
	 */
	@RequestMapping("/selectCreditProveInfoJSON.json")
	@ResponseBody
	public PageResponse<CreditProveInfo> selectCreditProveInfoJSON(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object>	queryMap=	request.getParams();
		queryMap.put("proveType", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("proveType").toString(),","));
		if(queryMap!=null&&queryMap.containsKey("cidRegNO")&&!"".equals(queryMap.get("cidRegNO"))){
			if(queryMap.get("cidRegNO").toString().length()==4){
				queryMap.put("cidRegNO4", queryMap.get("cidRegNO").toString());
				queryMap.remove("cidRegNO");
			}
		}
		if("2".equals(sysUser.getUserType())){
			queryMap.put("deptCode", sysUser.getSysDepart().getAdcode());
		}else{
			queryMap.put("deptCode", sysUser.getDepartMent().getDeptCode());
		}
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap); 
		parmMap=queryMap;
		List<CreditProveInfo> creditProveInfoList=creditProveInfoService.selectCreditProveInfoJSON(request);
		return  new PageResponse<CreditProveInfo>(creditProveInfoList); 
	}
	
	/**
	 * 
	 * 描述   统计查询结果
	 * @author 赵祥江
	 * @date 2017年4月24日 下午5:41:50 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/getEntCount")
	@ResponseBody
	public AjaxResult getEntCount()throws Exception{
		Map<String,Object> dataMap= new HashMap<String,Object>(); 
			dataMap.put("proveInfoCount", creditProveInfoService.selectProveInfoCount(parmMap));
			dataMap.put("entCount", creditProveInfoService.selectEntCount(parmMap));
			dataMap.put("manCount", creditProveInfoService.selectManCount(parmMap));
		return AjaxResult.success("", dataMap);
	}
}