/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.sccheck.dto.CodeSpecialTypeDto;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.cs.sccheck.service.ICodeSpecialTypeService;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_code_special_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
@Controller
@RequestMapping("/syn/server/sccheck/specialtype")
public class CodeSpecialTypeController extends CSBaseController {
	
	@Autowired
	private ICodeSpecialTypeService codeSpecialTypeService; 
	
	@Autowired
	private ICodeDutydeptService codeDutydeptService; 
	
	@Autowired
	private IPubSccheckTypeService pubSccheckTypeService; 
	
	/**
	 * 描述: 进入跨部门专项库列表
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView enterSpecialEntListpage(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/specialtype/specialtype_list");
		return view;
	}
	
	/**
	 * 描述：跨部门专项库列表查询
	 *
	 * @author chenxin
	 * @date 2017年7月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<CodeSpecialTypeDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeSpecialTypeDto> dsedList = codeSpecialTypeService.queryPage(request, sysUserDto);
		return new PageResponse<CodeSpecialTypeDto>(dsedList);
	}
	
	/**
	 * 描述: 进入详情页
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("edit")
	public ModelAndView doShowDetail(HttpSession session,String uid,String viewFlag) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("syn/system/sccheck/specialtype/specialtype_edit");
		CodeSpecialType codeSpecialType = null;
		Map<String,Object> params = new HashMap<String,Object>();
		List<CodeDutydept>  codeDutydeptList = codeDutydeptService.selectByParams(params);
		if(StringUtils.isEmpty(uid)){
			codeSpecialType = new CodeSpecialType();
			codeSpecialType.setCreatTime(new Date());
			codeSpecialType.setSetUserUid(sysUserDto.getId());
			codeSpecialType.setSetUserName(sysUserDto.getRealName());
			codeSpecialType.setSetDeptCode(sysUserDto.getSysDepart().getAdcode());
			codeSpecialType.setDutyDeptCode(sysUserDto.getDutyDeptCodes());
		}else{
			codeSpecialType = codeSpecialTypeService.selectByUid(uid);
		}
		if(StringUtils.isNotEmpty(sysUserDto.getDutyDeptCodes())){
			params.put("deptCodeArr", sysUserDto.getDutyDeptCodes().split(","));
		}
		List<PubSccheckType> pubSccheckTypeList = pubSccheckTypeService.selectPubSccheckTypeList(params);
	    view.addObject("viewFlag", viewFlag);
	    view.addObject("codeSpecialType", codeSpecialType);
	    view.addObject("codeDutydeptList", codeDutydeptList);
	    view.addObject("pubSccheckTypeList", pubSccheckTypeList);
		return view;
	}
	
	/**
	 * 描述：添加或修改
	 * 
	 * @author chenxin
	 * @date 2017-09-13
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "saveorupdate", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSave(CodeSpecialType codeSpecialType) throws Exception {
		return codeSpecialTypeService.saveCodeSpecialType(codeSpecialType);
	}
}