/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.icinfo.cs.system.dto.SendSmsTaskInfoDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.dto.TaskInfoCount;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.cs.system.service.ISendSmsTaskInfoService;
import com.icinfo.cs.system.service.ISendSmsTaskService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_sendsms_task_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
@Controller
@RequestMapping("/reg/server/smstaskinfo")
public class SendSmsTaskInfoController extends BaseController {

	@Autowired
	ISendSmsTaskService sendSmsTaskService;

	@Autowired
	ISendSmsTaskInfoService sendSmsTaskInfoService;

	@Autowired
	ISysUserService sysUserService;

	/**
	 * 描述：进入短信任务详情页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("taskDetail")
	public ModelAndView taskDetail(@RequestParam String uid) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/smstask_detail");
		SendSmsTask sendSmsTask = sendSmsTaskService.findSendSmsTaskByUID(uid);
		mav.addObject("sendSmsTask", sendSmsTask);
		return mav;
	}

	/**
	 * 描述：根据任务id获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "list.json", "list.xml" })
	@ResponseBody
	public PageResponse<SendSmsTaskInfoDto> listJSON(PageRequest request) throws Exception {
		List<SendSmsTaskInfoDto> sendSmsTaskInfoDtos = sendSmsTaskInfoService.queryPageResult(request);
		return new PageResponse<SendSmsTaskInfoDto>(sendSmsTaskInfoDtos);
	}

	/**
	 * 
	 * 描述: 发送短信企业统计
	 * 
	 * @auther baifangfang
	 * @date 2017年2月24日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "searchCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchListCount(PageRequest request) throws Exception {
		List<Integer> countList = new ArrayList<Integer>();
		List<SendSmsTaskInfoDto> sendSmsTaskInfoDtos = sendSmsTaskInfoService.queryPageResultAll(request);
		// 统计信息
		List<String> sendObjLerepTel = new ArrayList<String>();
		List<String> sendObjLiaTel = new ArrayList<String>();
		Set<String> entSet = new HashSet<String>();
		for (int i = 0; i < sendSmsTaskInfoDtos.size(); i++) {
			String sendStatus = sendSmsTaskInfoDtos.get(i).getSendStatus();
			String sendObjType = sendSmsTaskInfoDtos.get(i).getSendObjType();
			String sendObjTel = sendSmsTaskInfoDtos.get(i).getSendObjTel();
			String entName = sendSmsTaskInfoDtos.get(i).getEntName();
			if ("负责人".equals(sendObjType) && "1".equals(sendStatus)) {// 负责人手机号发送成功
				sendObjLerepTel.add(sendObjTel);
				entSet.add(entName);
			}
			if ("联络员".equals(sendObjType) && "1".equals(sendStatus)) {// 联络员手机号发送成功
				sendObjLiaTel.add(sendObjTel);
				entSet.add(entName);
			}
		}
		countList.add(entSet.size());
		countList.add(sendObjLerepTel.size() + sendObjLiaTel.size());
		countList.add(sendObjLerepTel.size());
		countList.add(sendObjLiaTel.size());
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 
	 * 描述: 短信群发记录统计
	 * 
	 * @auther baifangfang
	 * @date 2017年3月7日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "searchCountSuccess", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchCountSuccess(PageRequest request, HttpSession session) throws Exception {
		List<Integer> countList = new ArrayList<Integer>();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptId = sysUser.getDepartMent().getDeptDID();
		Map<String, Object> params = request.getParams();
		params.put("dept", deptId);
		if (params.get("smsLerep") == null) {
			params.put("smsLerep", null);
		}
		if (params.get("smsLia") == null) {
			params.put("smsLia", null);
		}
		if (params.get("smsLerep") == null && params.get("smsLia") == null) {
			params.put("smsLerep", "1");
			params.put("smsLia", "1");
		}

		TaskInfoCount taskInfoCount = sendSmsTaskInfoService.queryTaskInfoCount(request);
		countList.add(taskInfoCount.getNum1());
		countList.add(taskInfoCount.getNum2());
		countList.add(taskInfoCount.getNum4());
		countList.add(taskInfoCount.getNum3());
		return AjaxResult.success("统计数成功", countList);
	}

	/**
	 * 描述：进入添加短信群发列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("addSmsList")
	public ModelAndView addSmsList() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/addsmsgroup");
		mav.addObject("year", Integer.parseInt(DateUtil.getCurrentYear())-2);
		return mav;
	}

	/**
	 * 描述：短信模板查看
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("smsTypeFind")
	public ModelAndView smsTypeFind() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/smstemplate");
		return mav;
	}

	/**
	 * 描述：进入短信群发预览页面
	 * 
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "smsShow", method = RequestMethod.POST)
	public ModelAndView smsShow(HttpSession session, @RequestParam String params) throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/smsshow");

		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		mav.addObject("setName", sysUser.getRealName());
		mav.addObject("deptId", sysUser.getDepartMent().getDeptDID());
		mav.addObject("deptName", sysUser.getDept());

		// 拼接短信任务详情放入map中，SendSmsTaskInfo
		Map<String, SendSmsTaskInfo> sendSmsTaskInfoMap = new HashMap<String, SendSmsTaskInfo>();

		// 任务原始名单
		List<String> lerepTelList = new ArrayList<String>();
		List<String> liaPhoneList = new ArrayList<String>();
		List<String> priPIDList = new ArrayList<String>();
		String[] taskInfoArr = params.split("。");
		for (int i = 0; i < taskInfoArr.length; i++) {
			SendSmsTaskInfo sendSmsTaskInfo = new SendSmsTaskInfo();
			sendSmsTaskInfo.setSmsid((i + 1) + "");
			String taskInfo = taskInfoArr[i];
			String[] taskMetaArr = taskInfo.split("_");
			if(taskMetaArr.length>12){
				String priPID = taskMetaArr[0];
				String uniSCID = taskMetaArr[1];
				String sliceNO = taskMetaArr[2];
				String entName = taskMetaArr[3];
				String estDate = taskMetaArr[4];
				String leRep = taskMetaArr[5];
				String tel = taskMetaArr[6];
				String liaName = taskMetaArr[7];
				String liaTel = taskMetaArr[8];
				String regOrg = taskMetaArr[9];
				String localAdm = taskMetaArr[10];
				String regNO = taskMetaArr[11];
				String entTypeCatg = taskMetaArr[12];
				sendSmsTaskInfo.setUniSCID(uniSCID);
				sendSmsTaskInfo.setRegNO(regNO);
				sendSmsTaskInfo.setEntName(entName);
				if (!StringUtil.isEmpty(estDate)) {
					sendSmsTaskInfo.setEstDate(DateUtil.stringToDate(estDate, "yyyy-MM-dd"));
				}
				sendSmsTaskInfo.setLeRep(leRep);
				sendSmsTaskInfo.setLiaName(liaName);
				sendSmsTaskInfo.setRegOrg(regOrg);
				sendSmsTaskInfo.setLocalAdm(localAdm);
				sendSmsTaskInfo.setLiaLeRepPhone(liaTel);
				sendSmsTaskInfo.setTel(tel);
				sendSmsTaskInfo.setSliceNo(sliceNO);
				sendSmsTaskInfo.setEntTypeCatg(entTypeCatg);
				sendSmsTaskInfoMap.put(priPID, sendSmsTaskInfo);
	
				if (!StringUtil.isEmpty(tel)) {
					lerepTelList.add(tel);
				}
				if (!StringUtil.isEmpty(liaTel)) {
					liaPhoneList.add(liaTel);
				}
				if (!StringUtil.isEmpty(priPID)) {
					priPIDList.add(priPID);
				}
			}
		}
		int liaPhoneCount = liaPhoneList.size();
		int lerepTelCount = lerepTelList.size();
		int totalTelCount = liaPhoneCount + lerepTelCount;
		int entTotalCount = priPIDList.size();
		String taskStart = "企业共" + entTotalCount + "户，手机号共" + totalTelCount + "条，其中负责人手机号" + lerepTelCount + "条，联络员手机号"
				+ liaPhoneCount + "条";
		mav.addObject("smsIntroduction", taskStart);

		// 联络员和法人都去重名单
		Set<String> lerepTelSet = new HashSet<String>(lerepTelList);
		List<String> lerepTelListQC = new ArrayList<String>();
		lerepTelListQC.addAll(lerepTelSet);
		Set<String> liaPhoneSet = new HashSet<String>(liaPhoneList);
		List<String> liaPhoneListQC = new ArrayList<String>();
		liaPhoneListQC.addAll(liaPhoneSet);
		int liaPhoneCountQC = liaPhoneListQC.size();
		int lerepTelCountQC = lerepTelListQC.size();
		int totalTelCountQC = liaPhoneCountQC + lerepTelCountQC;

		String taskEndAnd = "企业共" + entTotalCount + "户，手机号去重后共" + totalTelCountQC + "条，其中负责人手机号去重后" + lerepTelCountQC
				+ "条，联络员手机号去重后" + liaPhoneCountQC + "条";
		String taskEndLerep = "企业共" + entTotalCount + "户，手机号去重后共" + totalTelCountQC + "条，其中负责人手机号去重后" + lerepTelCountQC
				+ "条，联络员手机号" + liaPhoneCount + "条";
		String taskEndLia = "企业共" + entTotalCount + "户，手机号去重后共" + totalTelCountQC + "条，其中负责人手机号" + lerepTelCount
				+ "条，联络员手机号去重后" + liaPhoneCountQC + "条";

		mav.addObject("rsmsIntroductionAnd", taskEndAnd);
		mav.addObject("rsmsIntroductionLerep", taskEndLerep);
		mav.addObject("rsmsIntroductionLia", taskEndLia);

		session.setAttribute("sendSmsTaskInfoMap", sendSmsTaskInfoMap);
		return mav;
	}

	/**
	 * 描述：进入短信群发记录列表页面
	 * 
	 * @author baifangfang
	 * @date 2017年3月7日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("smsTaskTnfo")
	public ModelAndView smsTaskTnfo() throws Exception {
		ModelAndView mav = new ModelAndView("reg/server/smsgroupsend/smstaskinfo_list");
		return mav;
	}

	/**
	 * 描述：短信群发记录JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年3月7日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "smsTaskTnfoList.json", "smsTaskTnfoList.xml" })
	@ResponseBody
	public PageResponse<SendSmsTaskInfoDto> smsTaskTnfoJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptId = sysUser.getDepartMent().getDeptDID();
		Map<String, Object> params = request.getParams();
		params.put("dept", deptId);
		if (params.get("smsLerep") == null && params.get("smsLia") == null) {
			params.put("smsLerep", "1");
			params.put("smsLia", "1");
		}
		List<SendSmsTaskInfoDto> sendSmsTaskInfoDtos = sendSmsTaskInfoService.queryPageResults(request);
		return new PageResponse<SendSmsTaskInfoDto>(sendSmsTaskInfoDtos);
	}
}