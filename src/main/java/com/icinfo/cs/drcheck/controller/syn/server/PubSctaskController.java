/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeEntcatg;
import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.ScTaskStates;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.PubDeptSctaskDto;
import com.icinfo.cs.drcheck.dto.PubSctaskDto;
import com.icinfo.cs.drcheck.model.PubDeptNumber;
import com.icinfo.cs.drcheck.model.PubDeptSctask;
import com.icinfo.cs.drcheck.model.PubSctask;
import com.icinfo.cs.drcheck.service.IPubDeptNumberService;
import com.icinfo.cs.drcheck.service.IPubDeptSctaskService;
import com.icinfo.cs.drcheck.service.IPubScinfoAgentService;
import com.icinfo.cs.drcheck.service.IPubScinfoBackService;
import com.icinfo.cs.drcheck.service.IPubScinfoHisService;
import com.icinfo.cs.drcheck.service.IPubScinfoService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentBackService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentHisService;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentService;
import com.icinfo.cs.drcheck.service.IPubSctaskService;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: cs_pub_sctask 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Controller   
@RequestMapping("/syn/server/drcheck/scstack")
public class PubSctaskController extends CSBaseController {

	@Autowired
	private IPubSctaskService pubSctaskService;
	@Autowired
	private IPubDeptSctaskService pubDeptSctaskService;
	@Autowired
	private ICodeEntcatgService codeEntcatgService;
	@Autowired
	private IPubScinfoService pubScinfoService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IPubSctaskAgentService pubSctaskAgentService; 
    @Autowired
    private ISysDepartService sysDepartService;
    @Autowired
	private IPubDeptNumberService pubDeptNumberService;
    @Autowired
    private IPubScinfoBackService pubScinfoBackService;
    @Autowired
    private IPubScinfoHisService pubScinfoHisService;
    @Autowired
    private IPubSctaskAgentBackService pubSctaskAgentBackService;
    @Autowired
    private IPubSctaskAgentHisService pubSctaskAgentHisService;
    @Autowired
    private IPubScinfoAgentService pubScinfoAgentService;
    
    @Autowired
    private IPanoramaSearchService panoramaSearchService;
    
    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;
    
    private static final String comEntType = "13,34,26,14,33,23,11,12,32,21,25,24,15,22,31,27,28";
    private static final String pbEntType = "50";
    private static final String sfcEntType = "16,17";
	/**
	 * 
	 * 描述: 去任务设置列表页面
	 * 
	 * @auther ljx
	 * @date 2016年10月25日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/setStack_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	    view.addObject("sysUser", sysUser);// 用户类型 1：监管；2：协同。
		return view;
	}
	
     /**
      * 
      * 描述: 本部门组织任务列表
      * @auther ljx
      * @date 2016年11月11日 
      * @return
      * @throws Exception
      */
	@RequestMapping("/leadsctacklist")
	public ModelAndView leadSctackList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/leadstack_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	    view.addObject("sysUser", sysUser);// 用户类型 1：监管；2：协同。
		return view;
	}
	
	 /**
     * 
     * 描述: 本部门组织任务列表
     * @auther ljx
     * @date 2016年11月11日 
     * @return
     * @throws Exception
     */
	@RequestMapping("/showScatck")
	public ModelAndView showScatck(String uid)throws Exception{
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/showsctack");
		if(StringUtils.isNotEmpty(uid)){
			view.addObject("scatck",pubSctaskService.selectPubSctaskByTaskNO(uid));
			view.addObject("deptSctackList",pubDeptSctaskService.selectPubDeptSctackByUid(uid));
		}
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 本部门实施任务
	 * @auther ljx
	 * @date 2016年11月11日 
	 * @return
	 * @throws Exception
	 */
    @RequestMapping("/deptscatcklist")
	public ModelAndView deptScatckList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/deptstack_list");
		List<CodeEntcatg> listEntcatg = codeEntcatgService.selectAll();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	    view.addObject("sysUser", sysUser);// 用户类型 1：监管；2：协同。
		view.addObject("listEntcatg", listEntcatg);// 企业类型大类
		return view;
	}

	/**
	 * 
	 * 描述: 多条件查询json数据
	 * 
	 * @auther ljx
	 * @date 2016年10月26日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/listJSON")
	@ResponseBody
	public PageResponse<PubSctaskDto> listJSNO(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);// -->sysUser)
		String deptId = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		List<PubSctaskDto> data = pubSctaskService.selectByManyCationToListJson(request, deptId);
		return new PageResponse<PubSctaskDto>(data);
	}
    /**
     * 
     * 描述: 查询本部门组织的任务
     * @auther ljx
     * @date 2016年11月11日 
     * @param request
     * @param session
     * @return
     * @throws Exception
     */
	@RequestMapping("/leadscatcklistJSON")
	@ResponseBody
	public PageResponse<PubSctaskDto> leadscatcklistJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);// -->sysUser)
		String deptId = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		List<PubSctaskDto> data = pubSctaskService.selectLeadStacktoListJson(request, deptId);
		return new PageResponse<PubSctaskDto>(data);
	}
     /**
      * 
      * 描述:查询本本部门实施任务列表
      * @auther ljx
      * @date 2016年11月11日 
      * @param request
      * @param session
      * @return
      * @throws Exception
      */
	
	@RequestMapping("/deptscatcklistJSON")
	@ResponseBody
	public PageResponse<PubSctaskDto> deptscatcklistJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);// -->sysUser)
		String deptId = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		List<PubSctaskDto> data = pubSctaskService.selectDeptStacktoListJson(request, deptId);
		return new PageResponse<PubSctaskDto>(data);
	}
	
	
	
	
	
	/**
	 * 
	 * 描述: to 任务设置页面
	 * 
	 * @auther ljx
	 * @date 2016年10月26日
	 * @param session
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/show")
	public ModelAndView show(HttpSession session, String uid) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/setStack_set"); 
		List<CodeEntcatg> listEntcatg = codeEntcatgService.selectAll();
		view.addObject("listEntcatg", listEntcatg);// 企业类型大类 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
	     view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
	     String deptId = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
	     PubDeptNumber pubDeptNumber=pubDeptNumberService.selectByDeptCode(deptId);
	     Integer deptNumber=1;
	     if(pubDeptNumber!=null&&pubDeptNumber.getDeptNumber()!=null&&!pubDeptNumber.getDeptNumber().equals("")){
	    	 deptNumber=pubDeptNumber.getDeptNumber()+1;
	     }
	     view.addObject("deptNumber",deptNumber);
	     String deptName = sysUser.getDept();
    	 view.addObject("deptName",deptName);
    	 view.addObject("taskNumber",deptName+"抽查["+DateUtils.getYear()+"]"+deptNumber+"号");
	     view.addObject("deptCode",deptId);
		return view;
	}

	/**
	 * 
	 * 描述: 设置任务
	 * 
	 * @auther ljx
	 * @date 2016年10月27日
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toSet")
	@ResponseBody
	public AjaxResult toSet(@RequestBody PubSctaskDto dto, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);// -->sysUser)
		Map<String, Object> map = pubSctaskService.setStack(dto, sysUser);
		int result = (int) map.get("result");
		if (result > 0) {
			return AjaxResult.success("任务设置成功", map);
		} else {
			return AjaxResult.error("任务设置失败");
		}
	}

	/**
	 * 
	 * 描述: to抽取页面或者取消页面
	 * 
	 * @auther ljx
	 * @date 2016年10月27日
	 * @param uid
	 * @return
	 */
	@RequestMapping("/toExtract")
	public ModelAndView toExtract(String uid) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/toExtract");
		view.addObject("uid", uid);
		return view;

	}

	/**
	 * 
	 * 描述: 查询统计
	 * 
	 * @auther ljx
	 * @date 2016年10月31日
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectCount")
	@ResponseBody
	public AjaxResult selectCount(PubSctaskDto dto) throws Exception {
		return AjaxResult.success("查询成功", pubSctaskService.selectCountByCation(dto));
	}

	// =================================以下为随机抽取企业===============================
	/**
	 * 
	 * 描述: 进入随机抽取企业页面
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/randomentinfo", method = RequestMethod.GET)
	public ModelAndView doRandomEntInfo(String taskNO) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/randomentinfo_main");
		if (StringUtils.isNotEmpty(taskNO)) {
			PubSctask pubSctask = pubSctaskService.selectPubSctaskByTaskNO(taskNO);// 主体任务
			if(ScTaskStates.WaitSetEnt.getCode().equals(pubSctask.getTaskState())){
				//清楚缓存数据
				pubScinfoBackService.cleanScinfoBackByTaskNO(taskNO);
				pubScinfoService.cleanPubScinfoByTaskNO(taskNO);
				pubScinfoHisService.cleanScinfoHisByTaskNO(taskNO);
			}
			view.addObject("pubSctask", pubSctask);
			view.addObject("yearList", DateUtil.getYearToNowForReport());
			view.addObject("taskNO", taskNO);
		}
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 查询筛选结果列表
	 * @auther yujingwei
	 * @date 2016年12月01日
	 * @param request
	 * @return PageResponse<PanoramaResultDto>
	 * @throws Exception
	 */
	@RequestMapping({"/panoQueryPage"})
	@ResponseBody
	public PageResponse<PanoramaResultDto> panoQueryPage(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		return new PageResponse<PanoramaResultDto>(data);
	}
	
	/**
	 * 
	 * 描述: 进入随机抽取企业页面
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewinfo", method = RequestMethod.GET)
	public ModelAndView doViewInfo(String taskNO) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/sctack_view");
		if (StringUtils.isNotEmpty(taskNO)) {
			PubSctask pubSctask = pubSctaskService.selectPubSctaskByTaskNO(taskNO);// 主体任务
			view.addObject("pubSctask", pubSctask);
			view.addObject("yearList", DateUtil.getYearToNow());
			view.addObject("taskNO", taskNO);
		}
		return view;
	}
	
	/**
	 * 
	 * 描述: 抽取对象查看
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/viewagent", method = RequestMethod.GET)
	public ModelAndView doViewAgent(HttpSession session, String taskNO) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/agent_view");
		if (StringUtils.isNotEmpty(taskNO)) {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			PubSctask pubSctask = pubSctaskService.selectPubSctaskByTaskNO(taskNO);// 主体任务
			List<PubDeptSctaskDto> pubDeptSctaskDtoList = pubDeptSctaskService.selectPubDeptSctypesListByTaskNO(taskNO);// 实施部门任务
			pubDeptSctaskDtoList = sortPubDeptSctaskDtoList(pubDeptSctaskDtoList, sysUser);
			PubDeptSctaskDto pubDeptSctaskDto = getLoginPubDeptSctaskDto(pubDeptSctaskDtoList, sysUser);
			view.addObject("pubSctask", pubSctask);
			view.addObject("pubDeptSctaskDtoList", pubDeptSctaskDtoList);
			view.addObject("pubDeptSctaskDto", pubDeptSctaskDto);
			view.addObject("taskNO", taskNO);
		}
		return view;
	}

	/**
	 * 
	 * 描述: 进入随机抽取执法人员页面
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/randomagent", method = RequestMethod.GET)
	public ModelAndView doRandomAgent(HttpSession session, String taskNO) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/sctack/randomagent_main");
		if (StringUtils.isNotEmpty(taskNO)) {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
			PubSctask pubSctask = pubSctaskService.selectPubSctaskByTaskNO(taskNO);// 主体任务
			List<PubDeptSctaskDto> pubDeptSctaskDtoList = pubDeptSctaskService.selectPubDeptSctypesListByTaskNO(taskNO);// 实施部门任务
			pubDeptSctaskDtoList = sortPubDeptSctaskDtoList(pubDeptSctaskDtoList, sysUser);
			PubDeptSctaskDto pubDeptSctaskDto = getLoginPubDeptSctaskDto(pubDeptSctaskDtoList, sysUser);
			if(ScTaskStates.WaitSetPlan.getCode().equals(pubSctask.getTaskState()) ||
					ScTaskStates.WaitConfirmAgent.getCode().equals(pubSctask.getTaskState()) ||
					   ScTaskStates.Inspecting.getCode().equals(pubSctask.getTaskState())){
				String deptTaskNO = pubDeptSctaskDto.getUID();
				if(StringUtils.isNotEmpty(deptTaskNO)){
					//删除备份表（执法人员备份表）
					pubSctaskAgentBackService.delSctaskAgentBackByTaskNO(deptTaskNO);
					//实施部门数据删除
					pubSctaskAgentHisService.deleteByTaskNO(deptTaskNO);
					//通过主任务表taskNO清除已选中执法人员
					pubSctaskAgentService.cleanPubSctaskAgentByTaskNO(deptTaskNO);
					//清空执法人员对应企业表
					pubScinfoAgentService.cleanPubScinfoAgent(deptTaskNO, taskNO);
				}
			}
			view.addObject("pubSctask", pubSctask);
			view.addObject("pubDeptSctaskDtoList", pubDeptSctaskDtoList);
			view.addObject("pubDeptSctaskDto", pubDeptSctaskDto);
			view.addObject("taskNO", taskNO);
			view.addObject("sessionDeptCode", deptCode);
		}
		return view;
	}

	/**
	 * 描述: 获取当前登录用户实施任务
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @param oldPubDeptSctaskDtoList
	 * @param sysUser
	 * @return
	 */
	private PubDeptSctaskDto getLoginPubDeptSctaskDto(List<PubDeptSctaskDto> oldPubDeptSctaskDtoList,
			SysUserDto sysUser)throws Exception {
		PubDeptSctaskDto pubDeptSctaskDto = new PubDeptSctaskDto();
		if (oldPubDeptSctaskDtoList != null) {
			String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
			for (PubDeptSctaskDto old : oldPubDeptSctaskDtoList) {
				if (old != null && StringUtils.isNotEmpty(old.getInspectDept())
						&& deptCode.equals(old.getInspectDept())) {
					pubDeptSctaskDto = old;
					break;
				}
			}
		}
		return pubDeptSctaskDto;
	}

	/**
	 * 描述: 排序
	 * 
	 * @auther chenxin
	 * @date 2016-10-26
	 * @param oldPubDeptSctaskDtoList
	 * @param sysUser
	 * @return
	 */
	private List<PubDeptSctaskDto> sortPubDeptSctaskDtoList(List<PubDeptSctaskDto> oldPubDeptSctaskDtoList,
			SysUserDto sysUser)throws Exception {
		List<PubDeptSctaskDto> newPubDeptSctaskDtoList = new ArrayList<PubDeptSctaskDto>();
		if (oldPubDeptSctaskDtoList != null) {
			String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
			for (PubDeptSctaskDto old : oldPubDeptSctaskDtoList) {
				if (old != null && StringUtils.isNotEmpty(old.getInspectDept())
						&& deptCode.equals(old.getInspectDept())) {
					newPubDeptSctaskDtoList.add(old);
				}
			}
			for (PubDeptSctaskDto old : oldPubDeptSctaskDtoList) {
				if (old != null && StringUtils.isNotEmpty(old.getInspectDept())
						&& !deptCode.equals(old.getInspectDept())) {
					newPubDeptSctaskDtoList.add(old);
				}
			}
		}
		return newPubDeptSctaskDtoList;
	}

	/**
	 * 
	 * 描述: 随机生成对象提交
	 * 
	 * @auther chenxin
	 * @date 2016年11月04日
	 * @param pubSctask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommit(HttpSession session, String taskNO) throws Exception {
		if (StringUtils.isNotEmpty(taskNO)) {
			int totalEnt = pubScinfoService.selectCountByTaskNO(taskNO);
			if (totalEnt <= 0) {
				return AjaxResult.error("请先抽取企业");
			}
			pubSctaskService.setTaskRandomInfoOver(taskNO, totalEnt);
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
			PubDeptSctask pubDeptSctask = pubDeptSctaskService.selectByTaskNOAndDeptCode(taskNO, deptCode);
			boolean flag = false;
			if(pubDeptSctask != null && StringUtils.isNotEmpty(pubDeptSctask.getTaskNO())){
				flag = true;
			}
			return AjaxResult.success("生效成功",flag);
		}
		return AjaxResult.error("生效失败");
	}

	/**
	 * 
	 * 描述: 保存设置（设置对象）
	 * 
	 * @auther chenxin
	 * @date 2016年11月04日
	 * @param pubSctask
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doSave(String deptTaskNO, String taskNO, String deptTaskUid) throws Exception {
		if (StringUtils.isNotEmpty(taskNO) && StringUtils.isNotEmpty(deptTaskUid)) {
			int count = pubSctaskAgentService.countPubSctaskAgentByTaskNO(deptTaskNO);
			if (count <= 0) {
				return AjaxResult.error("请先抽取执法人员");
			}
			pubSctaskService.setTaskAgentOver(taskNO, deptTaskUid);
			return AjaxResult.success("设置成功");
		}
		return AjaxResult.error("设置失败");
	}

}