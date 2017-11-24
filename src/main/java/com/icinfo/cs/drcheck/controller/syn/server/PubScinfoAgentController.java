/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.drcheck.dto.PubScinfoAgentDto;
import com.icinfo.cs.drcheck.service.IPubScinfoAgentService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scinfo_agent 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
@Controller
@RequestMapping("/syn/server/drcheck/pubscinfoagent")
public class PubScinfoAgentController extends BaseController {
	
	@Autowired
	private IPubScinfoAgentService pubScinfoAgentService;
	
	@Autowired
	private IDeptDutycodeRefService deptDutycodeRefService;
	
	/**
	 * 描述:进入执法人员调整页面
	 * @auther yujingwei
	 * @date 2016年11月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("adjustlist")
	public ModelAndView viewAdjustList(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scagent/scagent_adjust");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
	    view.addObject("deptCode", deptCode);
		return view;
	}
	
	/**
	 * 描述:进入执法人员抽查名单列表页面
	 * @auther yujingwei
	 * @date 2016年11月28日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("agenttasksearch")
	public ModelAndView viewAgentTask(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scagent/agenttask_search");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		view.addObject("deptCode", deptCode);
		return view;
	}
	
	/**
	 * 描述:查询执法人员调整页面list数据
	 * @author yujingwei
	 * @date 2016-11-06
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping("/adjust.json")
	@ResponseBody
	public PageResponse<PubScinfoAgentDto> doGetAdjustJSON(PageRequest request) throws Exception {
		List<PubScinfoAgentDto> data = pubScinfoAgentService.selectScagentAdjustList(request);
		return new PageResponse<PubScinfoAgentDto>(data);
	}
	
	/**
	 * 描述:进入选择执法人员页面
	 * @auther yujingwei
	 * @date 2016年11月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("chooseagent")
	public ModelAndView doChoosePage(String deptCode,String agentUids) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/drcheck/scagent/adjust_choose");
		view.addObject("deptCode", deptCode);
		view.addObject("agentUids", agentUids);
		return view;
	}
	
	/**
	 * 描述：指定执法人员
	 * @author yujingwei
	 * @param adjustUid
	 * @param agentUids
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAdjust(String adjustUid,String agentUids) throws Exception{
		try {
			if(pubScinfoAgentService.doAdjustScagent(adjustUid,agentUids)){
				return AjaxResult.success("指定成功！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.success("指定失败！");
		}
		return AjaxResult.success("指定失败！");
	}
}