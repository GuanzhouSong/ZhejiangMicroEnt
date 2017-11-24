/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.controller;

import java.util.Date;
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
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScGroupDto;
import com.icinfo.cs.sccheck.model.PubScGroup;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_scgroup 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
@Controller
@RequestMapping({ "/syn/server/sccheck/scgroup", "/reg/server/sccheck/scgroup" })
public class PubScGroupController extends CSBaseController {
	
	@Autowired
	private IPubScGroupService pubScGroupService;
	
	/**
     * 
     * 描述: 执法人员随机抽取页面-分组列表
     * @auther chenxin
     * @date 2017年7月11日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/grouplist.json")
	@ResponseBody
	public PageResponse<PubScGroupDto> pubScGroupListJSON(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=request.getParams();
		//去掉查询参数的左右空格
		StringUtil.paramTrim(queryMap);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		queryMap.put("setUserUid", sysUserDto.getId());
		queryMap.put("groupType", "1");
		queryMap.put("isVlid", "1");
		request.setParams(queryMap);
		List<PubScGroupDto> pubScGroupDtoList=pubScGroupService.queryGroupPage(request);
		return  new PageResponse<PubScGroupDto>(pubScGroupDtoList); 
	}
	
	/**
	 * 
	 * 描述:查询数量
	 * @auther chenxin
	 * @date 2017年7月12日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/groupcount")
	@ResponseBody
	public AjaxResult DataCountList(PageRequest request,HttpSession session) throws Exception {
		Map<String, Object> params = request.getParams();
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		StringUtil.paramTrim(params);
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		params.put("setUserUid", sysUserDto.getId());
		params.put("groupType", "1");
		params.put("isVlid", "1");
		int groupcount = pubScGroupService.selectGroupCount(params);
		return AjaxResult.success("groupcount", groupcount);
	}
	
	/**
   	 * 
   	 * 描述: 批量删除待选库的检查小组
   	 * @auther chenxin
   	 * @date 2017年7月11日 
   	 * @param deptTaskUid
   	 * @param AgentIds
   	 * @return
   	 * @throws Exception
   	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteRtn(HttpSession session,String groupUids) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userUid = sysUserDto.getId();
		if(pubScGroupService.deleteByUserUidAndGroupUids(userUid, groupUids)){
			return AjaxResult.success("批量删除成功");
		}
		return AjaxResult.error("批量删除失败");
	}
   	
	/**
	 * 
	 * 描述: 清空当前部门待选库的检查小组
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param deptTaskUid
	 * @param AgentIds
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/clean", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult deleteGourpAll(HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userUid = sysUserDto.getId();
		if(pubScGroupService.deleteByUserUid(userUid)){
			return AjaxResult.success("清空成功");
		}
		return AjaxResult.error("清空失败");
	}
	
	/**
	 * 
	 * 描述: 进入添加检查小组页面
	 * @auther chenxin
	 * @date 2017-07-11
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/randomadd",method= RequestMethod.GET)
	public ModelAndView doAddEntBack(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userUid = sysUser.getId();
		//查询是否有临时数据
		PubScGroup pubScGroup = pubScGroupService.selectUnVlidAndCleanMember(userUid);
		String groupUid = "";
		if(pubScGroup != null){
			//如果有临时数据，则取临时数据
			groupUid = pubScGroup.getUid();
		}else{
			//否则新建临时数据
			pubScGroup = new PubScGroup();
			pubScGroup.setSetUserUid(userUid);
			pubScGroup.setSetTime(new Date());
			String deptCode = "2".equals(sysUser.getUserType()) ? sysUser.getSysDepart().getAdcode() : sysUser.getDepartMent().getDeptCode();
			if(deptCode.length() > 8){
				deptCode = deptCode.substring(0, 8);
			}else if (deptCode.length() == 6){
				deptCode = deptCode+"00";
			}
			pubScGroup.setSetDeptCode(deptCode);
			pubScGroup.setGroupType("1");
			pubScGroup.setIsVlid("0");
			pubScGroupService.savePubScGroup(pubScGroup);
			groupUid = pubScGroup.getUid();
		}
		
		ModelAndView view = new ModelAndView("/syn/system/sccheck/scgroup/randomscgroup_add");
		view.addObject("groupUid", groupUid);
		return view;
	}
}