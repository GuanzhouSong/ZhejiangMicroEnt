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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sccheck.dto.PubScGroupMemberDto;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.sccheck.service.IPubScGroupMemberService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_pub_scgroup_member 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
@Controller
@RequestMapping({ "/syn/sccheck/pubsgroupmember", "/reg/sccheck/pubsgroupmember" })
public class PubScGroupMemberController extends CSBaseController {
	
	@Autowired
	private IPubScGroupMemberService pubScGroupMemberService;
	@Autowired
	private ICodePositionTypeService codePositionTypeService;
	@Autowired
	private ICodeExpertTypeService codeExpertTypeService;
	
	
	/**
	 * 描述：进入执法人员分组页面
	 * 
	 * @author chenxin
	 * @date 2017年7月10日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("entermemberpage")
	public ModelAndView doEnterMemberPage(HttpSession session,String resultUids) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view = new ModelAndView("syn/system/sccheck/scgroupmember/scgroupmember_list");
		//处理默认数据
		pubScGroupMemberService.doInitGroupAndMemberData(sysUserDto,resultUids);
		view.addObject("codePositionTypeList", doGetCodePositionTypeList(sysUserDto));
		view.addObject("codeExpertTypeList", doGetCodeCodeExpertTypeList(sysUserDto));
		view.addObject("resultUids", resultUids);
		return view;
	}
	
	/**
	 * 描述: 岗位大类
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	private List<CodePositionType> doGetCodePositionTypeList(SysUserDto sysUser) throws Exception{
		List<CodePositionType> codePositionTypeList = null;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("idVlid", "1");
		if("1".equals(sysUser.getUserType()) || (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
				 || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
				 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1))){
			params.put("dutyDeptCode", "A058");
			codePositionTypeList = codePositionTypeService.selectListByParams(params);
		}else{
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
				codePositionTypeList = codePositionTypeService.selectListByParams(params);
			}
		}
		return codePositionTypeList;
	}
	
	/**
	 * 描述: 专家类型
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	private List<CodeExpertType> doGetCodeCodeExpertTypeList(SysUserDto sysUser) throws Exception{
		List<CodeExpertType> codeExperTypeList = null;
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("idVlid", "1");
		if("1".equals(sysUser.getUserType()) || (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) && ("A058".indexOf(sysUser.getDutyDeptCodes()) != -1
				|| "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
				|| "A027".indexOf(sysUser.getDutyDeptCodes()) != -1))){
			params.put("dutyDeptCode", "A058");
			codeExperTypeList = codeExpertTypeService.selectListByParams(params);
		}else{
			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
				codeExperTypeList = codeExpertTypeService.selectListByParams(params);
			}
		}
		return codeExperTypeList;
	}
	
	/**
	 * 描述：执法人员分组列表
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list.json")
	@ResponseBody
	public PageResponse<PubScGroupMemberDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<PubScGroupMemberDto> pubScGroupMemberDtoList = pubScGroupMemberService.queryPageMember(request, sysUserDto);
		return new PageResponse<PubScGroupMemberDto>(pubScGroupMemberDtoList);
	}
	
	/**
	 * 描述：执法人员分组列表（随机抽取执法人员过程使用）
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("randomlist.json")
	@ResponseBody
	public PageResponse<PubScGroupMemberDto> randomListJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<PubScGroupMemberDto> pubScGroupMemberDtoList = pubScGroupMemberService.queryPageRandomMember(request, sysUserDto);
		return new PageResponse<PubScGroupMemberDto>(pubScGroupMemberDtoList);
	}
	
	/**
	 * 描述：删除执法人员单条记录
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDelGroupmemberInfo(String uid) throws Exception{
		if(StringUtil.isNotBlank(uid)){
			if(pubScGroupMemberService.doDelGroupmemberInfoByUid(uid) > 0){
				return AjaxResult.success("删除成功！");
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	
	/**
	 * 描述：删除执法人员单条记录
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delmember", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDelGroupmember(String uid) throws Exception{
		if(StringUtil.isNotBlank(uid)){
			if(pubScGroupMemberService.doDelGroupmemberInfoByUid(uid) > 0){
				return AjaxResult.success("删除成功！");
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：删除执法人员单条记录
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param session
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "deleteAll", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doDelGroupmemberAll(HttpSession session) throws Exception{
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(sysUserDto != null){
			if(pubScGroupMemberService.doDelGroupmemberAll(sysUserDto)){
				return AjaxResult.success("删除成功！");
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：保存成员信息并返回分组页面
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "backMember", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doBackMemberPage(String uid ,HttpSession session) throws Exception{
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtil.isNotBlank(uid)){
			if(pubScGroupMemberService.doBackMemberPageOpt(uid,sysUserDto)){
				return AjaxResult.success("添加成功");
			}
		}
		return AjaxResult.error("添加失败");
	}
	
	/**
	 * 描述：保存成员信息并返回分组页面
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAdjustCheckPerson(String uid,String expertUid,String leaderUid,HttpSession session) throws Exception{
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtil.isNotBlank(uid)){
			if(pubScGroupMemberService.doAdjustScCheckPerson(uid,expertUid,leaderUid,sysUserDto)){
				return AjaxResult.success("调整成功！");
			}
		}
		return AjaxResult.error("调整失败！");
	}
	
	/**
	 * 描述：保存信息返回给随机抽取列表（检查小组）
	 * @author chenxin
	 * @date 2017年7月11日
	 * @param agentUids
	 * @param session
	 * @param groupUid
	 * @throws Exception
	 */
	@RequestMapping(value = "randomMember", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doRandomMember(String agentUids,String groupUid,String groupType,HttpSession session) throws Exception{
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtil.isNotBlank(groupUid) && StringUtil.isNotBlank(agentUids)){
			if(pubScGroupMemberService.doRandomMemberOpt(agentUids,groupUid,sysUserDto,groupType)){
				return AjaxResult.success("添加成功");
			}
		}
		return AjaxResult.error("添加失败");
	}

	/**
	 * 
	 * 描述: 批量导入待抽检库待抽检人员（随机抽取过程）
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param pubSctaskAgentBackDto
	 * @return
	 * @throws Exception
	 */
   	@RequestMapping(value = "/addmemberbatch", method = RequestMethod.POST)
   	@ResponseBody
   	public AjaxResult doAdd(@RequestBody PubScGroupMemberDto pubScGroupMemberDto,HttpSession session) throws Exception {
   		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
   		if(pubScGroupMemberService.savePubScGroupMemberBatch(sysUser,pubScGroupMemberDto.getGroupUid(), pubScGroupMemberDto.getPubScGroupMemberList())){
   			return AjaxResult.success("添加成功");
   		}
   		return AjaxResult.error("添加失败");
   	} 
   	
}