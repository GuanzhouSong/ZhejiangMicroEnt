/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.controller;

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
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.specialrec.dto.SpecialRecTaskDto;
import com.icinfo.cs.specialrec.model.SpecialRecEnt;
import com.icinfo.cs.specialrec.model.SpecialRecResult;
import com.icinfo.cs.specialrec.model.SpecialRecTask;
import com.icinfo.cs.specialrec.service.ISpecialRecEntService;
import com.icinfo.cs.specialrec.service.ISpecialRecResultService;
import com.icinfo.cs.specialrec.service.ISpecialRecTaskService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_special_rec_task 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Controller
@RequestMapping({"/reg/server/specialrec/task","/syn/server/specialrec/task"})
public class SpecialRecTaskController extends CSBaseController {
	
	@Autowired
	private ISpecialRecTaskService specialRecTaskService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private ISpecialRecEntService specialRecEntService;
	@Autowired
	private ISpecialRecResultService specialRecResultService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;  
	@Autowired
	private ISysDepartService sysDepartService;
	
	/**
	 * 描述: 进入专项整治列表查询页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView enterListpage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_task_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 
	 * 描述: 进入批量导入页面
	 * @auther yujingwei
	 * @date 2017-11-08
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/exportpage",method= RequestMethod.GET)
	public ModelAndView doExportPage(HttpSession session, String taskUid) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/specialrec/specialrec_task_excel");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid",taskUid);
		return view;
	}
	
	/**
	 * 描述：查询专项整治任务列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SpecialRecTaskDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		if (request != null) {
			creatDefaultDBAuthEnv(request,"OrgDeptCode","OrgDeptCode");
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			setDefaultParams(sysUser, qryMap);
		}
		List<SpecialRecTaskDto> specialRecTaskList = specialRecTaskService.querySpecialrecTaskList(request);
		return new PageResponse<SpecialRecTaskDto>(specialRecTaskList);
	}
	
	/**
	 * 描述：查询专项整治任务个数
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/count.json")
	@ResponseBody
	public AjaxResult countJson(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		if (request != null) {
			creatDefaultDBAuthEnv(request,"OrgDeptCode","OrgDeptCode");
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			setDefaultParams(sysUser, qryMap);
		}
		SpecialRecTaskDto recTaskDto = specialRecTaskService.selectSpecialRecTaskInfoForCount(request);
		return AjaxResult.success("",recTaskDto);
	}
	
	/**
	 * 
	 * 描述: 进入添加检查对象页面
	 * @auther yujingwei
	 * @date 2017-05-17
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value="/addpage",method= RequestMethod.GET)
	public ModelAndView doAddEntBack(HttpSession session,String taskUid) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/specialrec/specialrec_ent_add");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("yearList", DateUtil.getYearToNowForReport());
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		view.addObject("sysUser", sysUser);
		view.addObject("taskUid", taskUid);
		return view;
	}
	
	/**
	 * 描述 :进入专项整治任务添加修改页面
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param recTaskUid
	 * @param flag
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("/addOrmodify")
	public ModelAndView addOrEditView(HttpSession session, String recTaskUid, String flag) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView mav  = new ModelAndView("/reg/server/specialrec/specialrec_task_edit");
		List<CodeDutydept> codeDutydepts = new ArrayList<CodeDutydept>();
		if ("1".equals(sysUser.getUserType())) {
			CodeDutydept codeDutydept = new CodeDutydept();
			codeDutydept.setDeptCode("A058");
			codeDutydept.setDeptName("工商部门");
			codeDutydepts.add(codeDutydept);
		}else {
			if (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())) {
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("deptCodeArr", sysUser.getDutyDeptCodes().split(","));
				codeDutydepts = codeDutydeptService.selectByParams(params);
			}else {
				CodeDutydept codeDutydept = new CodeDutydept();
				codeDutydept.setDeptCode("");
				codeDutydept.setDeptName("您的账号未设置职能部门");
				codeDutydepts.add(codeDutydept);
			}
		}
		if (StringUtil.isNotEmpty(recTaskUid)) {
			SpecialRecTask recTask = specialRecTaskService.selectSpecialRecTaskInfoByUid(recTaskUid);
			mav.addObject("SpecialRecTask", recTask);
			//初始化检查名单
			initSpecialRecEntInfo(recTaskUid);
		}
		mav.addObject("codeDutydepts", codeDutydepts);
		mav.addObject("flag", flag);
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述：初始化检查名单
	 * 
	 * @date 2017年11月01日
	 * @param recTaskUid
	 * @throws Exception 
	 */
	private void initSpecialRecEntInfo(String recTaskUid) throws Exception {
		// 删除检查表
		specialRecEntService.doCleanSpecialRecEntInfo(recTaskUid);
		// 插入检查表
		List<SpecialRecResult> specialRecResults = specialRecResultService.selectSpecialRecResultInfoByTaskUid(recTaskUid);
		if (specialRecResults.size() > 0) {
			for (SpecialRecResult specialRecResult : specialRecResults) {
				MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(specialRecResult.getPriPID());
				SpecialRecEnt recEnt = new SpecialRecEnt();
				recEnt.setDom(baseInfo.getDom());
				recEnt.setEntName(baseInfo.getEntName());
				recEnt.setEntTypeCatg(baseInfo.getEntTypeCatg());
				recEnt.setLocalAdm(baseInfo.getLocalAdm());
				recEnt.setLocalAdmName(baseInfo.getLocalAdmName());
				recEnt.setPriPID(baseInfo.getPriPID());
				recEnt.setRegNO(baseInfo.getRegNO());
				recEnt.setRegOrg(baseInfo.getRegOrg());
				recEnt.setRegOrgName(baseInfo.getRegOrgName());
				recEnt.setRegState(baseInfo.getRegState());
				recEnt.setSliceNO(baseInfo.getSliceNO());
				recEnt.setSliceNOName(baseInfo.getSliceNOName());
				recEnt.setTaskUid(recTaskUid);
				recEnt.setUniCode(baseInfo.getUniCode());
				specialRecEntService.saveSpecialRecEnt(recEnt);
			}
		}
	}

	/**
	 * 描述：保存专项整治任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecTask
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "commitSpeciakrec", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitSpeciakrec(SpecialRecTask specialRecTask ,HttpSession session) throws Exception{
		try {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
			String deptCode= ("2".equals(sysUser.getUserType()))
						?sysUser.getSysDepart().getAdcode():sysUser.getDepartMent().getDeptCode().substring(0, 6);
			SpecialRecTask recTask = specialRecTaskService.selectSpecialRecTaskInfoByUid(specialRecTask.getUid());
			if (recTask==null) {
				// 新增
				List<SpecialRecTask> recTasks =specialRecTaskService.selectSpecialRecTaskInfoByTaskName(specialRecTask.getTaskName());
				if (recTasks.size() > 0) {
					return AjaxResult.error("任务名称已存在，请重新输入");
				}
				// 生成任务编号
				String shortName = "";
				if(!"A058".equals(specialRecTask.getDutyDeptCode())){
					List<SysDepart> sysDepartList = sysDepartService.doGetSysDepartByAdcode(deptCode);
					if(sysDepartList == null || sysDepartList.size() > 1 
							|| StringUtils.isEmpty(sysDepartList.get(0).getDocShortName())){
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
				Integer taskCode = specialRecTaskService.selectDocNumBydeptShortName(shortName, Integer.parseInt(DateUtil.getCurrentYear()));
				if (StringUtil.isBlank(taskCode+"")) {
					taskCode=1;
				}
				specialRecTask.setTaskCode(shortName+"专查〔"+DateUtil.getCurrentYear()+"〕"+taskCode+"号");
				specialRecTask.setSeqYear(Integer.parseInt(DateUtil.getCurrentYear()));
			}else {
				// 修改
				List<SpecialRecTask> recTasks =specialRecTaskService
						.selectSpecialRecTaskInfoByTaskName(specialRecTask.getTaskName());
				if (recTasks.size() > 0) {
					for (SpecialRecTask taskObj : recTasks) {
						if (!recTask.getUid().equals(taskObj.getUid())) {
							return AjaxResult.error("任务名称已存在，请重新输入");
						}
					}
				}
			}
			// 提交
			if (specialRecTaskService.doCommitSpecialRecTaskInfo(specialRecTask, sysUser)) {
					return AjaxResult.success("提交成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("提交失败！");
		}
		return AjaxResult.error("提交失败！");
	}
	
	/**
	 * 描述：删除检查任务信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param specialRecTask
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteSpeciakrec(String recTaskUid) throws Exception{
		try {
			if (specialRecTaskService.doDelSpecialRecTaskInfo(recTaskUid) > 0) {
				return AjaxResult.success("删除成功！");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("删除失败！");
		}
		return AjaxResult.error("删除失败！");
	}
	
	
	/**
	 * 描述：设置默认职能部门参数
	 * @author yujingwei
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
}