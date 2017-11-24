/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScPlanTaskDto;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScWorkPlan;
import com.icinfo.cs.sccheck.model.PubSccheckItem;
import com.icinfo.cs.sccheck.model.PubSccheckType;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScWorkPlanService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubSccheckTypeService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scplan_task 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Controller
@RequestMapping({ "/syn/sccheck/scplantask", "/reg/server/sccheck/scplantask" })
public class PubScPlanTaskController extends CSBaseController {
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService; 
	@Autowired
	private IPubSccheckTypeService pubSccheckTypeService;
	@Autowired
	private IPubSccheckItemService pubSccheckItemService;
	@Autowired
	private IPubScWorkPlanService pubScWorkPlanService;
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService; 
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private ISysDepartService sysDepartService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	/**
	 * 
	 * 描述   进入任务设置列表页面
	 * @author 赵祥江
	 * @date 2017年5月18日 上午10:15:40 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubScPlanTaskListPage")
	public ModelAndView pubScPlanTaskListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scplantask/scplantask_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl); 
		return view;
	} 
	
	/**
	 * 
	 * 描述   进入添加其他检查事项页面
	 * @author 赵祥江
	 * @date 2017年5月31日 下午3:18:49 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/addOtherSccheckType")
	public ModelAndView addOtherSccheckType(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scplantask/addotherscchecktype_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl); 
		return view;
	} 
	
	
	 
	
	/**
	 * 
	 * 描述    进入新增或修改 详情 页面
	 * @author 赵祥江
	 * @date 2017年5月18日 上午10:15:59 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/addOrEditView")
	public ModelAndView addOrEditView(HttpSession session,String uid,String flag) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scplantask/scplantask_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		String deptName="";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			deptName=sysUser.getSysDepart().getOrgName();
		}else{
			deptName=sysUser.getDepartMent().getDeptName();
		}
		view.addObject("deptName", deptName);
		view.addObject("sysUrl", sysUrl);
		//详情
		if("3".equals(flag)){
			view  = new ModelAndView("/syn/system/sccheck/scplantask/scplantask_detail");
		}
		if(StringUtil.isNotBlank(uid)){
			PubScPlanTask pubScPlanTask=pubScPlanTaskService.selectPubScPlanTaskByUid(uid);
			List<PubSccheckItem> pubSccheckItemList= this.pubSccheckItemService.selectPubSccheckItemByTaskUid(uid);
			view.addObject("pubSccheckItemList", pubSccheckItemList);
			view.addObject("pubScPlanTask", pubScPlanTask);
		}
		List<CodeDutydept> codeDutydepts = new ArrayList<CodeDutydept>();
		if("1".equals(sysUser.getUserType())){
			CodeDutydept codeDutydept = new CodeDutydept();
			codeDutydept.setDeptCode("A058");
			codeDutydept.setDeptName("工商部门");
			codeDutydepts.add(codeDutydept);
		}else{
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("deptCodeArr", sysUser.getDutyDeptCodes().split(","));
				codeDutydepts = codeDutydeptService.selectByParams(params);
			}else{
				CodeDutydept codeDutydept = new CodeDutydept();
				codeDutydept.setDeptCode("");
				codeDutydept.setDeptName("您的账号未设置职能部门");
				codeDutydepts.add(codeDutydept);
			}
		}
		view.addObject("codeDutydepts", codeDutydepts);
		view.addObject("flag", flag);
		view.addObject("sysUser", sysUser);
		List<String> yearList= DateUtil.getYearToNow();
		view.addObject("yearList", yearList);
		return view;
	}
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年5月18日 上午10:19:16 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String uid) throws Exception{
		if (StringUtil.isNotBlank(uid)) { 
			try {
				PubScPlanTask  pubScPlanTask =this.pubScPlanTaskService.selectPubScPlanTaskByUid(uid);
				if(pubScPlanTask!=null&&"2".equals(pubScPlanTask.getTaskResource())){
					return AjaxResult.error("该任务已经绑定年度抽查工作计划，请先取消绑定再删除!");
				}else{
					if(pubScPlanTaskService.deletePubScPlanTaskByUid(uid)>0){ 
						this.pubSccheckItemService.deletePubSccheckItemByTaskUid(uid);
						return AjaxResult.success("删除成功");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}   
		}
		return  AjaxResult.error("删除失败");
	}
	
	
	/**
	 * 
	 * 描述   保存和更新
	 * @author 赵祥江
	 * @date 2017年5月19日 上午9:13:56 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitPubScPlanTask", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitPubScPlanTask(PubScPlanTaskDto pubScPlanTaskDto,HttpSession session) throws Exception { 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		if("2".equals(sysUser.getUserType())){
			List<DeptDutycodeRef> deptDutycodeRefList= deptDutycodeRefService.getDeptDutycodeRefByAdCodeSubDutyDeptCode(sysUser.getSysDepart().getAdcode().substring(0, 9), "A058");
		    if(deptDutycodeRefList==null||deptDutycodeRefList.size()==0){
		    	return AjaxResult.error("其他部门设置任务功能还在开发中......");
		    }
		} 
		String taskName=pubScPlanTaskDto.getTaskName();
		//转换任务名称
		if(StringUtil.isNotBlank(taskName)){
//			taskName=StringEscapeUtils.unescapeHtml4(taskName);
		}
		PubScPlanTask pubScPlanTask=new PubScPlanTask();
		pubScPlanTask.setTaskCode(pubScPlanTaskDto.getTaskCode());
		pubScPlanTask.setTaskName(taskName);
		pubScPlanTask.setUid(pubScPlanTaskDto.getUid());
		pubScPlanTask.setSetUserUid(sysUser.getId());
		pubScPlanTask.setSetUserName(sysUser.getRealName());
		pubScPlanTask.setSetTime(DateUtil.getSysDate());
		pubScPlanTask.setTaskState("01");
		pubScPlanTask.setResourcePlanName(pubScPlanTaskDto.getResourcePlanName());
		pubScPlanTask.setResourcePlanUid(pubScPlanTaskDto.getResourcePlanUid());
		pubScPlanTask.setTaskContent(pubScPlanTaskDto.getTaskContent());
		pubScPlanTask.setTaskEndTime(pubScPlanTaskDto.getTaskEndTime());
		pubScPlanTask.setTaskStartTime(pubScPlanTaskDto.getTaskStartTime());
		pubScPlanTask.setTaskType(pubScPlanTaskDto.getTaskType());
		pubScPlanTask.setTaskInspectDeptCode(pubScPlanTaskDto.getTaskInspectDeptCode());
		pubScPlanTask.setTaskInspectDeptName(pubScPlanTaskDto.getTaskInspectDeptName());
		pubScPlanTask.setTaskResource(pubScPlanTaskDto.getTaskResource());
		pubScPlanTask.setDutyDeptCode(pubScPlanTaskDto.getDutyDeptCode());
		pubScPlanTask.setDutyDeptName(pubScPlanTaskDto.getDutyDeptName());
		pubScPlanTask.setCrossDepartFlag(pubScPlanTaskDto.getCrossDepartFlag());
		pubScPlanTask.setPublicFlag(pubScPlanTaskDto.getPublicFlag());;
//		if("1".equals(sysUser.getUserType())){
//			pubScPlanTask.setDutyDeptCode("A058");
//		}else{
//			if(StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
//				return AjaxResult.error("您的账号未设置相应的职能部门!");
//			}
//			pubScPlanTask.setDutyDeptCode(sysUser.getDutyDeptCodes());
//		}
		String deptCode="000000";
		if("2".equals(sysUser.getUserType())){
			pubScPlanTask.setSetDeptName(sysUser.getSysDepart().getOrgName());
			if("A058".equals(pubScPlanTaskDto.getDutyDeptCode())){
				deptCode=sysUser.getSysDepart().getAdcode().substring(0, 6);
				pubScPlanTask.setSetDeptCode(sysUser.getSysDepart().getAdcode().substring(0, 8));
			}else{
				deptCode=sysUser.getSysDepart().getAdcode();
				pubScPlanTask.setSetDeptCode(sysUser.getSysDepart().getAdcode());
			}
		}else{
			pubScPlanTask.setSetDeptName(sysUser.getDepartMent().getDeptName());
			pubScPlanTask.setSetDeptCode(sysUser.getDepartMent().getDeptCode());
			deptCode=sysUser.getDepartMent().getDeptCode().substring(0, 6);
		}
		pubScPlanTask.setTaskLeadDeptCode(pubScPlanTask.getSetDeptCode());
		pubScPlanTask.setTaskLeadDeptName(pubScPlanTask.getSetDeptName());
		//修改
		if(pubScPlanTask!=null&&StringUtil.isNotBlank(pubScPlanTask.getUid())){
			boolean flag=false;
			List<PubScPlanTask> pubScPlanTaskList= pubScPlanTaskService.selectPubScPlanTaskByTaskName(pubScPlanTask.getTaskName().trim());
			if(pubScPlanTaskList.size()>0){
				for(PubScPlanTask pubScPlanTaskTem:pubScPlanTaskList){
					 if(!pubScPlanTask.getUid().equals(pubScPlanTaskTem.getUid())){
						 flag=true;
						 break;
					 }
				}
			}
			if(flag){
				return AjaxResult.error("任务名称已存在");
			}
			//临时任务  如果修改之前是年度工作计划则释放工作计划 修改其状态为待执行状态
			if("1".equals(pubScPlanTask.getTaskResource())){
				pubScPlanTask.setResourcePlanName("");
				pubScPlanTask.setResourcePlanUid("");
				PubScPlanTask scPlanTask=this.pubScPlanTaskService.selectPubScPlanTaskByUid(pubScPlanTask.getUid());
				PubScWorkPlan	pubScWorkPlan=pubScWorkPlanService.selectPubScWorkPlanByUid(scPlanTask.getResourcePlanUid()==null?"0000":scPlanTask.getResourcePlanUid());
			    if(pubScWorkPlan!=null){
			    	//修改工作计划为待执行状态
			    	pubScWorkPlan.setPlanState("01");
			    	pubScWorkPlan.setPlanCode("");
			    	pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
			    }
			}else {//年度计划  当修改之前和修改之后不是同一个年度计划时释放之前的年度计划 绑定现在的年度计划
				PubScWorkPlan	pubScWorkPlan=null;
				PubScPlanTask scPlanTask=this.pubScPlanTaskService.selectPubScPlanTaskByUid(pubScPlanTask.getUid());
				if(scPlanTask!=null&&"2".equals(scPlanTask.getTaskResource())&&!pubScPlanTask.getResourcePlanUid().equals(scPlanTask.getResourcePlanUid())){
		    		pubScWorkPlan=pubScWorkPlanService.selectPubScWorkPlanByUid(scPlanTask.getResourcePlanUid());
		    		//修改工作计划为待执行状态
		    		pubScWorkPlan.setPlanState("01");
		    		pubScWorkPlan.setPlanCode("");
			    	pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
				}
				
				pubScWorkPlan=pubScWorkPlanService.selectPubScWorkPlanByUid(pubScPlanTask.getResourcePlanUid());
			    if(pubScWorkPlan!=null){
			    	//修改工作计划为执行中状态
			    	pubScWorkPlan.setPlanState("02");
			    	pubScWorkPlan.setPlanCode(pubScPlanTask.getTaskCode());
			    	pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
			    }
			}
			List<PubSccheckItem> pubSccheckItemList= pubScPlanTaskDto.getPubSccheckItemList();
			if(pubSccheckItemList != null && pubSccheckItemList.size()>0){
				int itemNum = 0;
				for(int i=0;i<pubSccheckItemList.size();i++){
					PubSccheckItem pubSccheckItem= pubSccheckItemList.get(i);
					if(pubSccheckItem!=null&&StringUtil.isNotBlank(pubSccheckItem.getCheckCode())&&StringUtil.isNotBlank(pubSccheckItem.getCheckType())){
						itemNum ++;
					}
				}
				pubScPlanTask.setItemNum(itemNum);
			}else{
				pubScPlanTask.setItemNum(0);
			}
			if(pubScPlanTaskService.updatePubScPlanTaskByUid(pubScPlanTask)> 0) { 
				//先删除再插入
				pubSccheckItemService.deletePubSccheckItemByTaskUid(pubScPlanTask.getUid());
				if(pubSccheckItemList.size()>0){
					for(int i=0;i<pubSccheckItemList.size();i++){
						PubSccheckItem pubSccheckItem= pubSccheckItemList.get(i);
						if(pubSccheckItem!=null&&StringUtil.isNotBlank(pubSccheckItem.getCheckCode())&&StringUtil.isNotBlank(pubSccheckItem.getCheckType())){
							pubSccheckItem.setTaskUid(pubScPlanTask.getUid());
							pubSccheckItemService.insertPubSccheckItem(pubSccheckItem);
						}
					}
				}
				return AjaxResult.success("修改成功!");
			} else {
				return AjaxResult.error("修改失败!");
			}
		}else{
			//新增 
			List<PubScPlanTask> pubScPlanTaskList= pubScPlanTaskService.selectPubScPlanTaskByTaskName(pubScPlanTask.getTaskName().trim());
			if(pubScPlanTaskList.size()>0){
				return AjaxResult.error("任务名称已存在");
			} 
			String shortName = "";
			if(!"A058".equals(pubScPlanTaskDto.getDutyDeptCode())){
				List<SysDepart> sysDepartList = sysDepartService.doGetSysDepartByAdcode(deptCode);
				if(sysDepartList == null || sysDepartList.size() > 1 || StringUtils.isEmpty(sysDepartList.get(0).getDocShortName())){
					return AjaxResult.error("生成任务编号失败!请联系管理员");
				}
				shortName = sysDepartList.get(0).getDocShortName();
			}else{
				DepartMent departMent=departMentService.selectDepartMentByDeptCode(deptCode); 
				if(departMent==null||StringUtil.isBlank(departMent.getDeptShortName())){
					return AjaxResult.error("生成任务编号失败!请联系管理员");
				}
				shortName = departMent.getDeptShortName();
			}
			if("A014".equals(pubScPlanTaskDto.getDutyDeptCode()) && StringUtils.isNotEmpty(pubScPlanTaskDto.getOtherDocName())){
				shortName = shortName + pubScPlanTaskDto.getOtherDocName();
			}
			Integer taskCode =pubScPlanTaskService.selectDocNumBydeptShortName(shortName, Integer.parseInt(DateUtil.getCurrentYear()));
			if(StringUtil.isBlank(taskCode+"")){
				taskCode=1;
			}
			pubScPlanTask.setTaskCode(shortName+"抽查〔"+DateUtil.getCurrentYear()+"〕"+taskCode+"号");
			pubScPlanTask.setSeqYear(Integer.parseInt(DateUtil.getCurrentYear()));
			//临时任务
			if("1".equals(pubScPlanTask.getTaskResource())){
				pubScPlanTask.setResourcePlanName("");
				pubScPlanTask.setResourcePlanUid(""); 
			}else {//年度计划
				PubScWorkPlan	pubScWorkPlan=pubScWorkPlanService.selectPubScWorkPlanByUid(pubScPlanTask.getResourcePlanUid());
			    if(pubScWorkPlan!=null){
			    	//修改工作计划为执行中状态
			    	pubScWorkPlan.setPlanState("02");
			    	pubScWorkPlan.setPlanCode(pubScPlanTask.getTaskCode());
			    	pubScWorkPlanService.updatePubScWorkPlanByUid(pubScWorkPlan);
			    }
			}
			String uid=StringUtil.uuid();
			pubScPlanTask.setUid(uid);
			List<PubSccheckItem> pubSccheckItemList= pubScPlanTaskDto.getPubSccheckItemList(); 
			if(pubSccheckItemList != null && pubSccheckItemList.size()>0){
				int itemNum = 0;
				for(int i=0;i<pubSccheckItemList.size();i++){
					PubSccheckItem pubSccheckItem= pubSccheckItemList.get(i);
					if(pubSccheckItem!=null&&StringUtil.isNotBlank(pubSccheckItem.getCheckCode())&&StringUtil.isNotBlank(pubSccheckItem.getCheckType())){
						itemNum ++;
					}
				}
				pubScPlanTask.setItemNum(itemNum);
			}else{
				pubScPlanTask.setItemNum(0);
			}
			if (pubScPlanTaskService.insertPubScPlanTask(pubScPlanTask)> 0) { 
				if(pubSccheckItemList.size()>0){
					for(int i=0;i<pubSccheckItemList.size();i++){
						PubSccheckItem pubSccheckItem= pubSccheckItemList.get(i);
						if(pubSccheckItem!=null&&StringUtil.isNotBlank(pubSccheckItem.getCheckCode())&&StringUtil.isNotBlank(pubSccheckItem.getCheckType())){
							pubSccheckItem.setTaskUid(uid);
							pubSccheckItemService.insertPubSccheckItem(pubSccheckItem);
						}
					}
				}
				return AjaxResult.success("新增成功!");
			} else {
				return AjaxResult.error("新增失败!");
			}
		}
	}
	
	
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年5月17日 上午11:20:50 
	 * @param 
	 * @return PageResponse<PubScWorkPlanDto>
	 * @throws
	 */
	@RequestMapping("/selectPubScPlanTaskJSON.json")
	@ResponseBody
	public PageResponse<PubScPlanTaskDto> selectPubScPlanTaskJSON(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		creatDefaultDBAuthEnv(request,"A.SetDeptCode","A.SetDeptCode");
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		if(queryMap.containsKey("taskObject")&&queryMap.get("taskObject")!=null&&!"".equals(queryMap.get("taskObject").toString())){
			String[] taskObjectArr=queryMap.get("taskObject").toString().split(",");
			for(int i=0;i<taskObjectArr.length;i++){
				  if("1".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectOne", taskObjectArr[i]);
				  }else if("2".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectTwo", taskObjectArr[i]);
				  }else if("3".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectThree", taskObjectArr[i]);
				  }else if("4".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectFour", taskObjectArr[i]);
				  }
			}
			queryMap.remove("taskObject");
		}
		if("2".equals(sysUser.getUserType())){
			queryMap.put("deptCode", sysUser.getSysDepart().getAdcode());
		}else{
			queryMap.put("deptCode", sysUser.getDepartMent().getDeptCode());
		}
		if("2".equals(sysUser.getUserType()) && StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
			return  new PageResponse<PubScPlanTaskDto>(null); 
		}
		setDefaultParams(sysUser, queryMap);
		String pubTaskState = (String) queryMap.get("pubTaskState");
		if (StringUtil.isNotEmpty(pubTaskState)) {
			queryMap.put("pubTaskStates", pubTaskState.split(","));
		}
		request.setParams(queryMap);
		List<PubScPlanTaskDto> pubScPlanTaskDtoList=pubScPlanTaskService.queryPubScPlanTaskListJSON(request);
		return  new PageResponse<PubScPlanTaskDto>(pubScPlanTaskDtoList); 
	}
	
	/**
	 * 
	 * 描述: 抽查查询结果统计
	 * 
	 * @auther baifangfang
	 * @date 2017年5月17日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "planCount", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchSccheckCount(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		creatDefaultDBAuthEnv(request,"A.SetDeptCode","A.SetDeptCode");
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		if(queryMap.containsKey("taskObject")&&queryMap.get("taskObject")!=null&&!"".equals(queryMap.get("taskObject").toString())){
			String[] taskObjectArr=queryMap.get("taskObject").toString().split(",");
			for(int i=0;i<taskObjectArr.length;i++){
				  if("1".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectOne", taskObjectArr[i]);
				  }else if("2".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectTwo", taskObjectArr[i]);
				  }else if("3".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectThree", taskObjectArr[i]);
				  }else if("4".equals(taskObjectArr[i])){
					  queryMap.put("taskObjectFour", taskObjectArr[i]);
				  }
			}
			queryMap.remove("taskObject");
		}
		if("2".equals(sysUser.getUserType())){
			queryMap.put("deptCode", sysUser.getSysDepart().getAdcode());
		}else{
			queryMap.put("deptCode", sysUser.getDepartMent().getDeptCode());
		}
		PubScPlanTaskDto pubScPlanTaskDto = new PubScPlanTaskDto();
		if("2".equals(sysUser.getUserType()) && StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
			return AjaxResult.success("统计数成功", pubScPlanTaskDto);
		}
		setDefaultParams(sysUser, queryMap);
		String pubTaskState = (String) queryMap.get("pubTaskState");
		if (StringUtil.isNotEmpty(pubTaskState)) {
			queryMap.put("pubTaskStates", pubTaskState.split(","));
		}
		pubScPlanTaskDto = pubScPlanTaskService.selectCountAll(queryMap);
		return AjaxResult.success("统计数成功", pubScPlanTaskDto);
	}
	
	/**
	 * 
	 * 描述: 根据年度查询任务名称列表
	 * 
	 * @auther chenxin
	 * @date 2017年11月21日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "searchByYear", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchTaskByYear(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String,Object>	queryMap=request.getParams();
		setDefaultParams(sysUser, queryMap);
		List<PubScPlanTask> taskNameList = pubScPlanTaskService.selectTaskNamesByParams(queryMap);
		return AjaxResult.success("统计数成功", taskNameList);
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
	 * 
	 * 描述   查询所有检查事项
	 * @author 赵祥江
	 * @date 2017年5月18日 下午4:44:35 
	 * @param 
	 * @return PageResponse<PubSccheckType>
	 * @throws
	 */
	@RequestMapping("/selectPubSccheckTypeJSON.json")
	@ResponseBody
	public PageResponse<PubSccheckType> selectPubSccheckTypeJSON(PageRequest request) throws Exception {
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		if(queryMap==null){
			queryMap=new HashMap<String,Object>();
		}
		queryMap.put("flag", "1");
		request.setParams(queryMap);
		List<PubSccheckType> pubSccheckTypeDtoList=pubScPlanTaskService.queryPubSccheckTypeListJSON(request);
		queryMap.remove("flag");
		if(pubSccheckTypeDtoList.size()>0){
			for(PubSccheckType pubSccheckType:pubSccheckTypeDtoList){
				pubSccheckType.setId(null);
				queryMap.put("code", pubSccheckType.getpCode());
				List<PubSccheckType> pubSccheckTypeListTem= pubSccheckTypeService.selectPubSccheckTypeList(queryMap);
			    if(pubSccheckTypeListTem.size()>0){
			    	pubSccheckType.setDeptCode(pubSccheckTypeListTem.get(0).getContent());
			    }
			}
		}
		
		return  new PageResponse<PubSccheckType>(pubSccheckTypeDtoList); 
	}
	
	/**
	 * 
	 * 描述: 随机抽取检查人员任务列表页
	 * @auther gaojinling
	 * @date 2017年5月19日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/pubScPlanTaskAndDeptList")
	public ModelAndView selectPubScPlanTaskAndDeptList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scplantask/scplantaskanddept_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = "2".equals(sysUser.getUserType()) ? sysUser.getSysDepart().getAdcode() : sysUser.getDepartMent().getDeptCode();
	    view.addObject("sysUser", sysUser);// 用户类型 1：监管；2：协同。
	    view.addObject("deptCode", deptCode.substring(0, 6));
		return view;
	}
    
    /**
     * 
     * 描述: 随机抽取检查人员任务列表查询
     * @auther gaojinling
     * @date 2017年5月19日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/pubScPlanTaskAndDeptListJSON.json")
	@ResponseBody
	public PageResponse<PubScPlanTaskDto> pubScPlanTaskAndDeptListJSON(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
				: sysUserDto.getDepartMent().getDeptCode();
		if(deptCode.length() > 8){
			deptCode = deptCode.substring(0, 8);
		}else if (deptCode.length() == 6){
			deptCode = deptCode+"00";
		}
		if("2".equals(sysUserDto.getUserType()) && "A058".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A027".indexOf(sysUserDto.getDutyDeptCodes()) == -1
				&& "A012".indexOf(sysUserDto.getDutyDeptCodes()) == -1){
			deptCode = sysUserDto.getSysDepart().getAdcode();
			queryMap.put("crossType", "Y");
		}else{
			queryMap.put("crossType", "N");
		}
		String unitDeptCodes = "";
		if(queryMap != null && queryMap.get("unitDeptCodes") != null){
			unitDeptCodes = (String)queryMap.get("unitDeptCodes");
		}
		if(StringUtils.isNotEmpty(unitDeptCodes)){
			queryMap.put("unitDeptCodeArr", unitDeptCodes.split(","));
		}else{
			queryMap.put("unitDeptCode", deptCode);
		}
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new PageResponse<PubScPlanTaskDto>(null); 
		}
		setDefaultParams(sysUserDto, queryMap);
		//处理主体类型
		if(queryMap.get("taskObject")!=null&&!queryMap.get("taskObject").equals("")){
			queryMap.put("taskObject",queryMap.get("taskObject").toString().split(","));
		}
		request.setParams(queryMap);
		List<PubScPlanTaskDto> pubScPlanTaskDtoList=pubScPlanTaskService.selectPubScPlanTaskAndDeptList(request);
		return  new PageResponse<PubScPlanTaskDto>(pubScPlanTaskDtoList); 
	}
	
	/**
	 * 
	 * 描述: 抽取人员页面
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param session
	 * @param taskNO(部门任务表uid)
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/randomagent", method = RequestMethod.GET)
	public ModelAndView doRandomAgent(HttpSession session, String taskNO) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scplantask/scrandmagent_main");
		if (StringUtils.isNotEmpty(taskNO)) {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String sessionDeptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
//			String deptCode = "2".equals(sysUser.getUserType()) ? sysUser.getSysDepart().getAdcode() : sysUser.getDepartMent().getDeptCode();
//			String userid = sysUser.getId();
			PubScPlanTaskDto pubScPlanTaskDto  = pubScPlanTaskService.selectPubScPlanTaskAndDeptListNotPage(taskNO, sysUser);
			if(pubScPlanTaskDto != null && pubScPlanTaskDto.getDeptState() != null && "1".equals(pubScPlanTaskDto.getDeptState())){//待抽取
//					//通过主任务表taskNO清除已选中执法人员
//					pubSctaskAgentService.cleanPubSctaskAgentByTaskNO(deptTaskNO);
//				}
			}
			view.addObject("pubScPlanTaskDto", pubScPlanTaskDto);
			view.addObject("taskNO", taskNO);
			view.addObject("sessionDeptCode", sessionDeptCode);
		    view.addObject("sysUser", sysUser);// 用户类型 1：监管；2：协同。
		}
		return view;
	}
    
	/**
	 * 
	 * 描述: 抽查任务情况统计
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/resultcount")
	public ModelAndView doCountView(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/sccheck/scplantask/scplantask_count");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String deptCode="";
		if(("1".equals(sysUser.getUserType()) && sysUser.getDepartMent()!=null) || ("2".equals(sysUser.getUserType()) && sysUser.getSysDepart() !=null)){
			if("1".equals(sysUser.getUserType())){
				deptCode=sysUser.getDepartMent().getDeptCode();
			}else{
				deptCode=sysUser.getSysDepart().getAdcode();
			}
			if(deptCode.length()>4){
				deptCode=deptCode.substring(0, 4);
			} 
		}		
		view.addObject("startCheckPushDate", DateUtil.getYear()+"-01-01");  //开始日期
		view.addObject("endCheckPushDate",DateUtil.getNdaylater2(DateUtil.getSysDate(), -1));    //结束日期
		view.addObject("deptCode", deptCode);
		view.addObject("sysUser", sysUser);
		view.addObject("uservest", sysUser.getUserVest(sysUser));       //层级
		view.addObject("year", DateUtil.getYear());       //当前年份
		view.addObject("month", DateUtil.getMonth());       //当前月份
		view.addObject("yearList", DateUtil.getYearToNow());
		return view;
	}
	
	/**
	 * 
	 * 描述: 抽查任务情况统计
	 * @auther chenxin
	 * @date 2017年6月27日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/countlist.json","list.xml"})
	@ResponseBody
	public PageResponse<PubScPlanTaskDto> countJSON(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if("2".equals(sysUserDto.getUserType()) && StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return  new PageResponse<PubScPlanTaskDto>(null); 
		}
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		setDefaultParams(sysUserDto, queryMap);
		List<PubScPlanTaskDto> data = pubScPlanTaskService.selectScPubScPlanTaskCount(request);
		return new PageResponse<PubScPlanTaskDto>(data);
	}
}