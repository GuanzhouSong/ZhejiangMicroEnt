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
import com.icinfo.cs.sccheck.dto.CodePositionTypeDto;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_code_position_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Controller
@RequestMapping("/syn/server/sccheck/positiontype")
public class CodePositionTypeController extends CSBaseController {
	
	@Autowired
	private ICodePositionTypeService codePositionTypeService;
	
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
		ModelAndView view = new ModelAndView("syn/system/sccheck/positiontype/positiontype_list");
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
	public PageResponse<CodePositionTypeDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<CodePositionTypeDto> dsedList = codePositionTypeService.queryPage(request, sysUserDto);
		return new PageResponse<CodePositionTypeDto>(dsedList);
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
		ModelAndView view = new ModelAndView("syn/system/sccheck/positiontype/positiontype_edit");
		CodePositionType codePositionType = null;
		Map<String,Object> params = new HashMap<String,Object>();
		List<CodeDutydept>  codeDutydeptList = codeDutydeptService.selectByParams(params);
		if(StringUtils.isEmpty(uid)){
			codePositionType = new CodePositionType();
			codePositionType.setCreatTime(new Date());
			codePositionType.setSetUserUid(sysUserDto.getId());
			codePositionType.setSetUserName(sysUserDto.getRealName());
			codePositionType.setSetDeptCode(sysUserDto.getSysDepart().getAdcode());
			codePositionType.setDutyDeptCode(sysUserDto.getDutyDeptCodes());
		}else{
			codePositionType = codePositionTypeService.selectByUid(uid);
		}
	    view.addObject("viewFlag", viewFlag);
	    view.addObject("codePositionType", codePositionType);
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
	public AjaxResult doSave(CodePositionType codePositionType) throws Exception {
		return codePositionTypeService.saveCodePositionType(codePositionType);
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
		param.put("positionName", content);
		List<Map<String, Object>> data = codePositionTypeService.selectToTreeMap(param);
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
		ModelAndView view = new ModelAndView("syn/system/sccheck/positiontype/positiontype_tree");
		return view;
	}
}