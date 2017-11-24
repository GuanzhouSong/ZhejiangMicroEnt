/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.EmailTaskDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.EmailTask;
import com.icinfo.cs.system.model.EmailTaskInfo;
import com.icinfo.cs.system.service.IEmailTaskService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_email_task 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
@Controller
@RequestMapping("/reg/server/emailtask")
public class EmailTaskController extends BaseController {
	@Autowired
	IEmailTaskService emailTaskService;

	/**
	 * 描述：邮件发送任务列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emailtasklist")
	public ModelAndView emailTaskList() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/emailsend/emailtask_list");
		return mav;
	}

	/**
	 * 描述：邮件发送任务列表JSON数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("emailtasklist.json")
	@ResponseBody
	public PageResponse<EmailTaskDto> emailTaskListJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (request != null && request.getParams() != null) {
			Map<String, Object> params = request.getParams();
			String deptID = (String) params.get("deptId");
			if (StringUtil.isEmpty(deptID)) {
				params.put("deptId", sysUser.getDepartMent().getDeptDID());
			}
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("deptId", sysUser.getDepartMent().getDeptDID());
			if (request != null) {
				request.setParams(params);
			}
		}
		List<EmailTaskDto> emailTaskDtoList = emailTaskService.queryPage(request);
		return new PageResponse<EmailTaskDto>(emailTaskDtoList);
	}

	/**
	 * 描述：添加或修改邮件任务
	 * 
	 * @author baifangfang
	 * @date 2016年8月30日
	 * @param sysForbidword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	@Transactional(rollbackFor = Exception.class)
	public AjaxResult save(@RequestBody EmailTask emailTask, HttpSession session) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, EmailTaskInfo> infoMap = (Map<String, EmailTaskInfo>) session.getAttribute("emailTaskInfoMap");

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = sysUser.getDepartMent().getDeptCode();
		if (deptCode.length() > 4) {
			deptCode = deptCode.substring(0, 4);
		}

		// 保存任务及详情信息
		emailTask.setTaskType("3");// 待发送
		emailTask.setCreateTime(new Date());

		int i = emailTaskService.saveEmailTaskInfoAndEmailTask(infoMap, emailTask);
		if (i > 0) {
			return AjaxResult.success("添加邮件任务成功!");
		}
		return AjaxResult.error("添加邮件任务失败!");
	}
}