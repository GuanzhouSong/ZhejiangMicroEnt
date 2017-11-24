/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.EmailTaskInfoDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.EmailTask;
import com.icinfo.cs.system.model.EmailTaskInfo;
import com.icinfo.cs.system.service.IEmailTaskInfoService;
import com.icinfo.cs.system.service.IEmailTaskService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_email_task_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
@Controller
@RequestMapping("/reg/server/emailtaskinfo")
public class EmailTaskInfoController extends BaseController {
	@Autowired
	IEmailTaskInfoService emailTaskInfoService;
	@Autowired
	IEmailTaskService emailTaskService;

	/**
	 * 描述：进入邮件群发列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addemaillist")
	public ModelAndView addEmailList() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/emailsend/addent_list");
		return mav;
	}

	/**
	 * 描述：根据任务id获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<EmailTaskInfoDto> listJSON(PageRequest request) throws Exception {
		List<EmailTaskInfoDto> emailTaskInfoDtos = emailTaskInfoService.queryPageResult(request);
		return new PageResponse<EmailTaskInfoDto>(emailTaskInfoDtos);
	}

	/**
	 * 描述：进入邮件发送任务添加页面
	 * 
	 * @author baifangfang
	 * @date 2017年11月14日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "emailshow", method = RequestMethod.POST)
	public ModelAndView emailShow(HttpSession session, @RequestParam String params) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/emailsend/emailshow");

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("setName", sysUser.getRealName());
		mav.addObject("deptId", sysUser.getDepartMent().getDeptDID());
		mav.addObject("deptName", sysUser.getDept());

		// 拼接短信任务详情放入map中
		Map<String, EmailTaskInfo> emailTaskInfoMap = new HashMap<String, EmailTaskInfo>();

		// 任务原始名单
		List<String> priPIDList = new ArrayList<String>();
		String[] taskInfoArr = params.split("。");
		for (int i = 0; i < taskInfoArr.length; i++) {
			EmailTaskInfo emailTaskInfo = new EmailTaskInfo();
			String taskInfo = taskInfoArr[i];
			String[] taskMetaArr = taskInfo.split("_");
			if (taskMetaArr.length > 9) {
				String priPID = taskMetaArr[0];
				String uniSCID = taskMetaArr[1];
				String sliceNOName = taskMetaArr[2];
				String entName = taskMetaArr[3];
				String estDate = taskMetaArr[4];
				String regOrgName = taskMetaArr[5];
				String localAdmName = taskMetaArr[6];
				String regNO = taskMetaArr[7];
				String entTypeCatg = taskMetaArr[8];
				String email = taskMetaArr[9];
				emailTaskInfo.setUniSCID(uniSCID);
				emailTaskInfo.setRegNO(regNO);
				emailTaskInfo.setEntName(entName);
				if (!StringUtil.isEmpty(estDate)) {
					emailTaskInfo.setEstDate(DateUtil.stringToDate(estDate, "yyyy-MM-dd"));
				}
				emailTaskInfo.setRegOrgName(regOrgName);
				emailTaskInfo.setEntTypeCatg(entTypeCatg);
				emailTaskInfo.setLocalAdmName(localAdmName);
				emailTaskInfo.setSliceNoName(sliceNOName);
				emailTaskInfo.setEmail(email);
				emailTaskInfoMap.put(priPID, emailTaskInfo);

				if (!StringUtil.isEmpty(priPID)) {
					priPIDList.add(priPID);
				}
			}
		}
		int entTotalCount = priPIDList.size();
		mav.addObject("entTotalCount", entTotalCount);

		session.setAttribute("emailTaskInfoMap", emailTaskInfoMap);
		return mav;
	}

	/**
	 * 描述：进入邮件任务详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("taskDetail")
	public ModelAndView taskDetail(@RequestParam String uid) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/emailsend/emailtask_detail");
		EmailTask emailTask = emailTaskService.findEmailTaskByUID(uid);
		mav.addObject("emailTask", emailTask);
		return mav;
	}
}