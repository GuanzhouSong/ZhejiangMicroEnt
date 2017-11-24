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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.CodeMarkTypeDto;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.sccheck.service.ICodeMarkTypeService;
import com.icinfo.cs.sccheck.service.ICodeSpecialTypeService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_code_mark_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月15日
 */
@Controller
@RequestMapping("/syn/server/sccheck/codemarktype")
public class CodeMarkTypeController extends CSBaseController {
	
	@Autowired
	private ICodeMarkTypeService codeMarkTypeService;
	
	@Autowired
	private ICodeSpecialTypeService codeSpecialTypeService;
	
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	
	/**
	 * 描述：添加或修改(只用作协同除工商部门以外)
	 * 
	 * @author chenxin
	 * @date 2017-09-13
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "search", method = RequestMethod.POST)
	@ResponseBody
	public List<CodeMarkType> doSearchTypes(@RequestBody Map<String, Object> params,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		StringUtil.paramTrim(params);
		List<CodeMarkType> codeMarkTypeList = null;
		if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
			String dutyDeptCodes = sysUser.getDutyDeptCodes();
			params.put("dutyDeptCodes", dutyDeptCodes);
			params.put("isVlid", "1");
			codeMarkTypeList = codeMarkTypeService.selectListByParams(params);
		}
		return codeMarkTypeList;
	}
	

	/**
	 * 描述: 进入标签列表
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView enterSpecialEntListpage(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/marktype/marktype_list");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("dutyDeptCodeArr", sysUserDto.getDutyDeptCodes().split(","));
		params.put("isVlid", "1");
		List<CodeSpecialType> codeSpecialTypeList = codeSpecialTypeService.selectListByParams(params);
		view.addObject("codeSpecialTypeList", codeSpecialTypeList);
		return view;
	}
	
	/**
	 * 描述：标签列表查询
	 *
	 * @author chenxin
	 * @date 2017年9月22日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<CodeMarkTypeDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeMarkTypeDto> dsedList = codeMarkTypeService.queryPage(request, sysUserDto);
		return new PageResponse<CodeMarkTypeDto>(dsedList);
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
		ModelAndView view = new ModelAndView("syn/system/sccheck/marktype/marktype_edit");
		CodeMarkType codeMarkType = null;
		Map<String,Object> params = new HashMap<String,Object>();
		List<CodeDutydept>  codeDutydeptList = codeDutydeptService.selectByParams(params);
		if(StringUtils.isEmpty(uid)){
			codeMarkType = new CodeMarkType();
			codeMarkType.setCreatTime(new Date());
			codeMarkType.setSetUserUid(sysUserDto.getId());
			codeMarkType.setSetUserName(sysUserDto.getRealName());
			codeMarkType.setSetDeptCode(sysUserDto.getSysDepart().getAdcode());
			codeMarkType.setDutyDeptCode(sysUserDto.getDutyDeptCodes());
		}else{
			codeMarkType = codeMarkTypeService.selectByUid(uid);
		}
		params.put("dutyDeptCodeArr", sysUserDto.getDutyDeptCodes().split(","));
		params.put("isVlid", "1");
		List<CodeSpecialType> codeSpecialTypeList = codeSpecialTypeService.selectListByParams(params);
	    view.addObject("viewFlag", viewFlag);
	    view.addObject("codeMarkType", codeMarkType);
	    view.addObject("codeDutydeptList", codeDutydeptList);
	    view.addObject("codeSpecialTypeList", codeSpecialTypeList);
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
	public AjaxResult doSave(CodeMarkType codeMarkType) throws Exception {
		return codeMarkTypeService.saveCodeMarkType(codeMarkType);
	}
	
}