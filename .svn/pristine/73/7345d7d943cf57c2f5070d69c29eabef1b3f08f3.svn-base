/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.casesource.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.casesource.dto.CaseSourceInfoDto;
import com.icinfo.cs.casesource.model.CaseSourceInfo;
import com.icinfo.cs.casesource.service.ICaseSourceInfoService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_case_source_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月23日
 */
@Controller
@RequestMapping({"/reg/server/casesource","/syn/server/casesource"})
public class CaseSourceInfoController extends CSBaseController {
	
	@Autowired
	private ICaseSourceInfoService caseSourceInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 描述: 进入案源信息管理页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月23日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView enterListpage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/casesource/casesource_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入案源信息查询页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月23日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/search")
	public ModelAndView searchListPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/casesource/casesource_search");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入案源主体添加页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月23日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addlist")
	public ModelAndView doEnAddView(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/casesource/casesource_add_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	/**
	 * 描述: 进入信息添加页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月23日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView doAddOrEditView(String priPID, String uid, String pageflag, HttpSession session) 
			throws Exception{
		ModelAndView mav  = new ModelAndView("/reg/server/casesource/casesource_edit");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		if (StringUtil.isNotEmpty(uid)) {
			CaseSourceInfo caseSourceInfo = caseSourceInfoService.doGetCaseSourceInfoByUid(uid); 
			mav.addObject("caseSourceInfo", caseSourceInfo);
		}
		MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(priPID);
		mav.addObject("baseInfo", baseInfo);
		mav.addObject("pageflag", pageflag);
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述：查询案源管理列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<CaseSourceInfoDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		if (request != null) {
			creatDefaultDBAuthEnv(request, "a.CheckDep", "a.LocalAdm");
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
		}
		List<CaseSourceInfoDto> sourceInfoDtos = caseSourceInfoService.queryCaseSourceInfoList(request);
		return new PageResponse<CaseSourceInfoDto>(sourceInfoDtos);
	}
	
	/**
	 * 描述：保存或修改案源信息
	 * 
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doSaveOrEditFavorableInfo(CaseSourceInfo caseSourceInfo,HttpSession session) 
			throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		try {
			if (caseSourceInfoService.doSaveCaseSourceInfo(caseSourceInfo,sysUser)) {
				return AjaxResult.success("保存成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}
	
	/**
	 * 描述：删除案源信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param caseSourceInfo
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteSpeciakrec(String caseUid) throws Exception{
		try {
			if (caseSourceInfoService.deleteCaseSourceInfoByUid(caseUid) > 0) {
				return AjaxResult.success("删除成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("删除失败！");
		}
		return AjaxResult.error("删除失败！");
	}
}