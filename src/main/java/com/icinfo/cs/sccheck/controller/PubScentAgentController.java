/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScentAgentDto;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.model.CodeRightType;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.sccheck.service.ICodeRightTypeService;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentAgentBackService;
import com.icinfo.cs.sccheck.service.IPubScentAgentService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_pub_scent_agent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月19日
 */
@Controller
@RequestMapping({"/reg/pub/server/sccheck/entagent","/syn/pub/server/sccheck/entagent"})
public class PubScentAgentController extends BaseController {
	
	@Autowired
	private IPubScentAgentService pubScentAgentService; 
	@Autowired
	private IPubScentService pubScentService; 
	@Autowired
	private IPubScdeptTaskService pubScdeptTaskService; 
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService; 
	@Autowired
	private IPubScentAgentBackService pubScentAgentBackService; 
	@Autowired
	private IPubScGroupService pubScGroupService; 
	@Autowired
	private ICodePositionTypeService codePositionTypeService;
	@Autowired
	private ICodeExpertTypeService codeExpertTypeService;
	@Autowired
	private ICodeRightTypeService codeRightTypeService;

	/**
	 * 描述：随机抽取
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/random",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult doRandomEntAgent(HttpSession session,String deptTaskUid,String randomType,int groupNum) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if("1".equals(randomType)){
			if(pubScentAgentService.doRandomByGroup(sysUser,deptTaskUid,groupNum)){
				return AjaxResult.success("随机匹配成功");
			}
		}else if("2".equals(randomType)){
			if(pubScentAgentService.doRandomEntAgent(sysUser,deptTaskUid,groupNum,randomType)){
				return AjaxResult.success("随机匹配成功");
			}
		}
		return AjaxResult.error("随机匹配失败");
	}
	
	/**
	 * 描述:随机滚动页面
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/randomPage")
	public ModelAndView doRandomEntAgentPage(HttpSession session,String deptTaskUid,String randomType,int groupNum) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scentagent_move");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if("1".equals(randomType)){
			pubScentAgentService.doRandomByGroup(sysUser,deptTaskUid,groupNum);
		}else if("2".equals(randomType)){
			pubScentAgentService.doRandomEntAgent(sysUser,deptTaskUid,groupNum,randomType);
		}
		List<PubScentDto> pubScentDtoList = pubScentService.selectPubScentPageList(deptTaskUid);
		PubScdeptTask pubScdeptTask = pubScdeptTaskService.selectPubScdeptTaskByUid(deptTaskUid);
		PubScPlanTask pubScPlanTask = pubScPlanTaskService.selectPubScPlanTaskByUid(pubScdeptTask.getTaskUid());
		view.addObject("pubScdeptTask", pubScdeptTask);
		view.addObject("pubScPlanTask", pubScPlanTask);
		view.addObject("sysUser", sysUser);
		view.addObject("pubScentDtoList", pubScentDtoList);
		return view;
	}
	
	/**
	 * 描述：锁定企业和执法人员匹配结果
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/lockagent",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult doLockEntAgent(HttpSession session,String deptTaskUid) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		pubScdeptTaskService.updatePubScdeptTask(deptTaskUid, "2", sysUser);
		return AjaxResult.success("锁定成功");
	}
	
	/**
	 * 描述:查看企业和执法人员配对结果
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView viewList(HttpSession session,String deptTaskUid) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scentagent_view");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("deptTaskUid", deptTaskUid);
		return view;
	}
	
	/**
	 * 描述:查看企业和执法人员配对结果
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/viewall")
	public ModelAndView viewAllList(HttpSession session,String deptTaskUid) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scentagentall_view");
		List<PubScentDto> pubScentDtoList = pubScentService.selectPubScentAllList(deptTaskUid);
		PubScdeptTask pubScdeptTask = pubScdeptTaskService.selectPubScdeptTaskByUid(deptTaskUid);
		PubScPlanTask pubScPlanTask = pubScPlanTaskService.selectPubScPlanTaskByUid(pubScdeptTask.getTaskUid());
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("pubScentDtoList", pubScentDtoList);
		view.addObject("pubScdeptTask", pubScdeptTask);
		view.addObject("pubScPlanTask", pubScPlanTask);
		return view;
	}

	/**
	 * 描述: 查询企业和执法人员配对列表
	 * @auther ljx
	 * @date 2016年10月31日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listJSON")
	@ResponseBody
	public PageResponse<PubScentDto> listJSON(PageRequest request) throws Exception {
		List<PubScentDto> pubScentDtoList = pubScentService.selectPubScentDtoList(request);
		if(pubScentDtoList != null && pubScentDtoList.size() > 0){
			for(PubScentDto pubScentDto : pubScentDtoList){
				String deptTaskUid = pubScentDto.getDeptTaskUid();
				String priPID = pubScentDto.getPriPID();
				String agentNames = pubScentAgentService.doSelectEntAgent(deptTaskUid, priPID,pubScentDto.getUid());
				pubScentDto.setAgentNames(agentNames);
			}
		}
		return new PageResponse<PubScentDto>(pubScentDtoList);
	}
	
	/**
	 * 描述:进入执法人员调整页面
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/adjust")
	public ModelAndView viewAdjustList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scentagent_adjust");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		return view;
	}
	
	
	/**
	 * 描述:进入抽查名单与人员查询
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/engagentsearch")
	public ModelAndView viewSearchList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scentagent_search");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object> params = new HashMap<String,Object>();
		setDefaultParams(sysUser, params);
		params.put("year", DateUtil.getCurrentYear());
		List<PubScPlanTask> taskNameList = pubScPlanTaskService.selectTaskNamesByParams(params);
		view.addObject("taskNameList", taskNameList);
		view.addObject("sysUser", sysUser);
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 描述: 查询企业和执法人员配对列表
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adjustListJSON")
	@ResponseBody
	public PageResponse<PubScentAgentDto> listPubScentAgentDtoJSON(HttpSession session,PageRequest request) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> params = request.getParams();
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		if(deptCode.length() > 8){
			deptCode = deptCode.substring(0, 8);
		}else if (deptCode.length() == 6){
			deptCode = deptCode+"00";
		}
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new PageResponse<PubScentAgentDto>(null); 
		}
		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			deptCode = sysUserDto.getSysDepart().getAdcode();
			params.put("crossType", "Y");
		}else{
			params.put("crossType", "N");
		}
		params.put("unitDeptCode", deptCode);
		if(params != null){
			StringUtil.paramTrim(params);
		}
		setDefaultParams(sysUserDto, params);
		List<PubScentAgentDto> pubScentDtoList = pubScentAgentService.selectPubScentAgentDtoList(request);
		return new PageResponse<PubScentAgentDto>(pubScentDtoList);
	}
	
	/**
	 * 描述: 检查名单与人员查询
	 * @auther chenxin
	 * @date 2017年06月13日
	 * @param session
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/searchListJSON")
	@ResponseBody
	public PageResponse<PubScentAgentDto> searchListJSON(HttpSession session,PageRequest request) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> params = request.getParams();
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		if(deptCode.length() > 8){
			deptCode = deptCode.substring(0, 8);
		}else if (deptCode.length() == 6){
			deptCode = deptCode+"00";
		}
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new PageResponse<PubScentAgentDto>(null); 
		}
		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			deptCode = sysUserDto.getSysDepart().getAdcode();
			params.put("crossType", "Y");
		}else{
			params.put("crossType", "N");
		}
		if(params.get("unitDeptCodes") == null || StringUtils.isEmpty(params.get("unitDeptCodes").toString())){
			params.put("unitDeptCode", deptCode);
		}
		if(params != null){
			StringUtil.paramTrim(params);
		}
		setDefaultParams(sysUserDto, params);
		if(params.get("deptStates") != null && StringUtils.isNotEmpty(params.get("deptStates").toString())){
			params.put("deptStateArr", params.get("deptStates").toString().split(","));
		}
		if(params.get("auditStates") != null && StringUtils.isNotEmpty(params.get("auditStates").toString())){
			params.put("auditStateArr", params.get("auditStates").toString().split(","));
		}
		List<PubScentAgentDto> pubScentDtoList = pubScentAgentService.selectSearchList(request);
		return new PageResponse<PubScentAgentDto>(pubScentDtoList);
	}
	
	/**
	 * 描述：设置默认职能部门参数
	 * @author chenxin
	 * @date 2017-10-12
	 * @param sysUser
	 * @param queryMap
	 */
	private void setDefaultParams(SysUserDto sysUser,Map<String,Object>	queryMap){
		//职能部门编码
		if("1".equals(sysUser.getUserType())){
			queryMap.put("dutyDeptCodes","A058,A012,A027");
		}else if("2".equals(sysUser.getUserType())){
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
					 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
				queryMap.put("dutyDeptCodes","A058,A012,A027");
			}else{
				queryMap.put("dutyDeptCodes",sysUser.getDutyDeptCodes());
			}
		}
		if(queryMap.get("dutyDeptCodes")!=null&&StringUtils.isNotBlank(queryMap.get("dutyDeptCodes").toString())){
			queryMap.put("dutyDeptCodeArr",queryMap.get("dutyDeptCodes").toString().split(","));
		}
	}
	
	/**
	 * 描述:进入 当前部门下的所有执法人员 页面
	 * 
	 * @author chenxin
	 * @date 2016-11-06
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/adjustPage")
	public ModelAndView doAdjustAgentPage(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scagentadjust_list");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		setSynDefaultObjects(view, sysUserDto);
		return view;
	}
	
	
	/**
	 * 描述:进入 当前部门下的所有执法人员 页面
	 * 
	 * @author chenxin
	 * @date 2016-11-06
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/randomaagent")
	public ModelAndView doRandomAgentPage(HttpSession session,String groupUid,String groupType) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scentagent/scagentrandom_list");
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		setSynDefaultObjects(view, sysUserDto);
		view.addObject("groupUid", groupUid);
		view.addObject("groupType", groupType);
		return view;
	}
	
	/**
	 * 描述: 设置默认值
	 * @auther chenxin
	 * @date 2016年10月31日
	 * @param view
	 * @param sysUser
	 */
	private void setSynDefaultObjects(ModelAndView view,SysUserDto sysUser)throws Exception{
		List<CodePositionType> codePositionTypeList = null;
		List<CodeExpertType> codeExperTypeList = null;
		List<CodeRightType> codeRightTypeList = null;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("idVlid", "1");
		if("1".equals(sysUser.getUserType())){
			params.put("dutyDeptCode", "A058");
			codePositionTypeList = codePositionTypeService.selectListByParams(params);
			codeExperTypeList = codeExpertTypeService.selectListByParams(params);
			codeRightTypeList = codeRightTypeService.selectListByParams(params);
		}else{
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
				codePositionTypeList = codePositionTypeService.selectListByParams(params);
				codeExperTypeList = codeExpertTypeService.selectListByParams(params);
				codeRightTypeList = codeRightTypeService.selectListByParams(params);
			}
		}
		view.addObject("codePositionTypeList", codePositionTypeList);
		view.addObject("codeExpertTypeList", codeExperTypeList);
		view.addObject("codeRightTypeList", codeRightTypeList);
	}
	
	/**
	 * 描述：指定执法人员
	 * @author chenxin
	 * @date 2017-05-17
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/sign",method= RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSignEntAgent(HttpSession session,String scentAgentUids,String agentUid) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(pubScentAgentService.doSignEntAgent(sysUser,scentAgentUids,agentUid)){
			return AjaxResult.success("调整成功");
		}
		return AjaxResult.error("调整失败");
	}
}