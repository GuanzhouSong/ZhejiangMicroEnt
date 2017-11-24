/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SendSmsTaskDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.cs.system.service.ISendSmsTaskInfoService;
import com.icinfo.cs.system.service.ISendSmsTaskService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sendsms_task 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
@Controller
@RequestMapping("/reg/server/smstask")
public class SendSmsTaskController extends BaseController {

	@Autowired
	private ISendSmsTaskService sendSmsTaskService;

	@Autowired
	private ISendSmsTaskInfoService sendSmsTaskInfoService;

	@Autowired
	IDepartMentService departMentService;

	/**
	 * 描述：进入添加短信群发任务管理页面
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView addSmsList(HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/smstask_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		// 查询当前用户所在部门有没有没有结束的短信任务
		List<SendSmsTask> sendSmsTaskList = sendSmsTaskService.findNotOverTask(sysUser.getDepartMent().getDeptDID());
		if (sendSmsTaskList.size() > 0) {
			mav.addObject("flag", 1);
		}
		return mav;
	}

	/**
	 * 描述：查询短信任务列表
	 * 
	 * @author yujingwei
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SendSmsTaskDto> listJSON(PageRequest request, HttpSession session) throws Exception {
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
			if(request != null){
				request.setParams(params);
			}
		}
		List<SendSmsTaskDto> sendSmsTaskList = sendSmsTaskService.queryPage(request);
		return new PageResponse<SendSmsTaskDto>(sendSmsTaskList);
	}

	/**
	 * 描述：查询短信任务列表
	 * 
	 * @author yujingwei
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult deleteSmsTaskInfo(@RequestParam String taskid) throws Exception {
		if (StringUtil.isEmpty(taskid)) {
			return AjaxResult.error("删除失败！");
		}
		if (sendSmsTaskService.deletSmsTaskInfoByTaskid(taskid) < 1
				|| sendSmsTaskInfoService.deleteTaskDetails(taskid) < 1) {
			return AjaxResult.error("删除失败！");
		}
		return AjaxResult.success("删除成功！");
	}

	/**
	 * 描述：添加或修改短信群发任务
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
	public AjaxResult save(@RequestBody SendSmsTaskDto sendSmsTask, HttpSession session) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, SendSmsTaskInfo> infoMap = (Map<String, SendSmsTaskInfo>) session
				.getAttribute("sendSmsTaskInfoMap");

		// 发送对象
		String smsLerep = sendSmsTask.getSmsLerep();
		String smsLia = sendSmsTask.getSmsLia();
		// 去重
		String repeatLerep = sendSmsTask.getRepeatLerep();
		String repeatLia = sendSmsTask.getRepeatLia();
		if (!StringUtil.isEmpty(smsLerep)) {
			sendSmsTask.setSmsLerep("1");
		}
		if (!StringUtil.isEmpty(smsLia)) {
			sendSmsTask.setSmsLia("1");
		}
		if (!StringUtil.isEmpty(repeatLerep)) {
			sendSmsTask.setRepeatLerep("1");
		}
		if (!StringUtil.isEmpty(repeatLia)) {
			sendSmsTask.setRepeatLia("1");
		}

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		// 查询当前登录部门用户的短信任务
		List<SendSmsTask> sendSmsTaskList = sendSmsTaskService
				.findSmsTaskByDeptId(sysUser.getDepartMent().getDeptDID());
		List<Integer> listNo = new ArrayList<Integer>();
		if (sendSmsTaskList.size() > 0) {
			for (SendSmsTask sendST : sendSmsTaskList) {
				String taskid = sendST.getTaskid();
				String[] taskidArr = taskid.split("-");
				int no = Integer.parseInt(taskidArr[1]);
				listNo.add(no);
			}
		} else {
			listNo.add(0);
		}
		int next = Collections.max(listNo) + 1;// 下一个短信任务编号
		String deptCode = sysUser.getDepartMent().getDeptCode();
		if (deptCode.length() > 4) {
			deptCode = deptCode.substring(0, 4);
		}
		DepartMent departMent = departMentService.selectDepartMentByDeptCode(deptCode);
		// 拼装taskid
		String deptSortName = departMent.getDeptShortName();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		// int maxId = sendSmsTaskService.getMaxId();
		String taskid = deptSortName + "短信 " + currentYear + "-" + next;

		// 保存任务及详情信息
		sendSmsTask.setTaskType("1");// 待发送
		sendSmsTask.setTaskid(taskid);
		sendSmsTask.setCreateTime(new Date());

		int i = sendSmsTaskService.saveSendSmsTaskInfoAndSendSmsTask(infoMap, sendSmsTask);
		if (i > 0) {
			return AjaxResult.success("添加短信群发任务成功!");
		}
		return AjaxResult.error("添加短信群发任务失败!");
	}
    
	/**
	 * 描述：省局短信任务
	 */
	public void sjSmsTask() throws Exception {
		sendSmsTaskService.sjSmsTask();
	}
	/**
	 * 描述：杭州短信任务
	 */
	public void hzSmsTask() throws Exception {
		sendSmsTaskService.hzSmsTask();
	}
	/**
	 * 描述：宁波短信任务
	 */
	public void nbSmsTask() throws Exception{
		sendSmsTaskService.nbSmsTask();
	}
	/**
	 * 描述：温州短信任务
	 */ 
	public void wzSmsTask() throws Exception{
		sendSmsTaskService.wzSmsTask();
	}
	/**
	 * 描述：嘉兴短信任务
	 */
	public void jxSmsTask() throws Exception{
		sendSmsTaskService.jxSmsTask();
	}
	/**
	 * 描述：湖州短信任务
	 */
	public void huzSmsTask() throws Exception{
		sendSmsTaskService.huzSmsTask();
	}
	/**
	 * 描述：绍兴短信任务
	 */
	public void sxSmsTask() throws Exception{
		sendSmsTaskService.sxSmsTask();
	}
	/**
	 * 描述：金华短信任务
	 */
	public void jhSmsTask() throws Exception{
		sendSmsTaskService.jhSmsTask();
	}
	/**
	 * 描述：衢州短信任务
	 */
	public void qzSmsTask() throws Exception{
		sendSmsTaskService.qzSmsTask();
	}
	/**
	 * 描述：舟山短信任务
	 */
	public void zsSmsTask() throws Exception{
		sendSmsTaskService.zsSmsTask();
	}
	/**
	 * 描述：台州短信任务
	 */
	public void tzSmsTask() throws Exception{
		sendSmsTaskService.tzSmsTask();
	}
	/**
	 * 描述：丽水短信任务
	 */
	public void lsSmsTask() throws Exception{
		sendSmsTaskService.lsSmsTask();
	}


}