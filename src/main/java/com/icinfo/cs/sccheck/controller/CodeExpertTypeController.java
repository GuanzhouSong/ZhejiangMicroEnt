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
import com.icinfo.cs.sccheck.dto.CodeExpertTypeDto;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_code_expert_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Controller
@RequestMapping("/syn/server/sccheck/experttype")
public class CodeExpertTypeController extends CSBaseController {
	

	@Autowired
	private ICodeExpertTypeService codeExpertTypeService;
	
	@Autowired
	private ICodeDutydeptService codeDutydeptService; 
	
	/**
	 * 描述: 进入列表
	 * @auther chenxin
	 * @date 2017年9月3日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView enterListpage(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/experttype/experttype_list");
		return view;
	}
	
	/**
	 * 描述：列表查询
	 *
	 * @author chenxin
	 * @date 2017年7月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<CodeExpertTypeDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodeExpertTypeDto> dsedList = codeExpertTypeService.queryPage(request, sysUserDto);
		return new PageResponse<CodeExpertTypeDto>(dsedList);
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
		ModelAndView view = new ModelAndView("syn/system/sccheck/experttype/experttype_edit");
		CodeExpertType codeExpertType = null;
		Map<String,Object> params = new HashMap<String,Object>();
		List<CodeDutydept>  codeDutydeptList = codeDutydeptService.selectByParams(params);
		if(StringUtils.isEmpty(uid)){
			codeExpertType = new CodeExpertType();
			codeExpertType.setCreatTime(new Date());
			codeExpertType.setSetUserUid(sysUserDto.getId());
			codeExpertType.setSetUserName(sysUserDto.getRealName());
			codeExpertType.setSetDeptCode(sysUserDto.getSysDepart().getAdcode());
			codeExpertType.setDutyDeptCode(sysUserDto.getDutyDeptCodes());
		}else{
			codeExpertType = codeExpertTypeService.selectByUid(uid);
		}
	    view.addObject("viewFlag", viewFlag);
	    view.addObject("codeExpertType", codeExpertType);
	    view.addObject("codeDutydeptList", codeDutydeptList);
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
	public AjaxResult doSave(CodeExpertType codeExpertType) throws Exception {
		return codeExpertTypeService.saveCodeExpertType(codeExpertType);
	}
	
	/**
	 * 描述：查询树结构
	 * 
	 * @author chenxin
	 * @date 2017-09-13 
	 * @param session
	 * @param content
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/treeListJSON")
	@ResponseBody
	public AjaxResult treeListJSON(HttpSession session,String content) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return AjaxResult.error("当前用户未设置职能部门");
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("dutyDeptCodeArr", sysUserDto.getDutyDeptCodes().split(","));
		param.put("expertName", content);
		List<Map<String, Object>> data = codeExpertTypeService.selectToTreeMap(param);
		return AjaxResult.success("查询成功", data);
	}
	
	/**
	 *
	 * 描述：查询树结构
	 * 
	 * @author chenxin
	 * @date 2017-09-13 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("tree")
	public ModelAndView toOrgTreeView() throws Exception {
		ModelAndView view = new ModelAndView("syn/system/sccheck/experttype/experttype_tree");
		return view;
	}
}