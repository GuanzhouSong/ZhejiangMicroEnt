package com.icinfo.cs.sccheck.controller;

import java.util.Date;
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
import com.icinfo.cs.sccheck.dto.PubScGroupDto;
import com.icinfo.cs.sccheck.dto.PubScGroupMemberDto;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.model.PubScGroup;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.sccheck.service.IPubScGroupMemberService;
import com.icinfo.cs.sccheck.service.IPubScGroupService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;


/**
 * 描述:    cs_code_expert_type 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月25日
 */
@Controller
@RequestMapping({ "/syn/server/sccheck/checkgroup", "/reg/server/sccheck/checkgroup" })
public class SccheckGroupMaintainController extends CSBaseController{
    
	@Autowired
	private IPubScGroupService pubScGroupService; 
	@Autowired
	private IPubScGroupMemberService pubScGroupMemberService;
	@Autowired
	private ICodePositionTypeService codePositionTypeService;
	@Autowired
	private ICodeExpertTypeService codeExpertTypeService;
	
	/**
	 * 描述: 进入检查小组维护查询页面
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView enterListpage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("syn/system/sccheck/checkgroup/checkgroup_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入检查小组维护选择页面
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/checkgroupPage")
	public ModelAndView checkgroupPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("syn/system/sccheck/checkgroup/checkgroup_choise");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述：查询检查小组列表数据
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<PubScGroupDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (request != null) {
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			qryMap.put("setUserUid", sysUserDto.getId());
			qryMap.put("groupType", "3");
		}
		List<PubScGroupDto> pubScGroupDtoList = pubScGroupService.queryGroupPage(request);
		return new PageResponse<PubScGroupDto>(pubScGroupDtoList);
	}
	
	/**
	 * 描述: 进入添加检查小组页面
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value="/groupadd")
	public ModelAndView viewGroupAdd(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/sccheck/checkgroup/checkgroup_add");
		String userUid = sysUser.getId();
		PubScGroup pubScGroup = new PubScGroup();
		// 删除临时表数据
		if (pubScGroupService.deleteByUserUid(userUid)) {
			// 新增临时数据
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
			pubScGroup.setSetUserName(sysUser.getRealName());
			pubScGroupService.savePubScGroup(pubScGroup);
		}
		mav.addObject("codePositionTypeList", doGetCodePositionTypeList(sysUser));
		mav.addObject("codeExpertTypeList", doGetCodeCodeExpertTypeList(sysUser));
		mav.addObject("sysUser", sysUser);
		mav.addObject("groupType", pubScGroup.getGroupType());
		mav.addObject("groupUid", pubScGroup.getUid());
		return mav;
	}
	
	/**
	 * 描述: 进入添加检查小组页面(修改)
	 * 
	 * @auther yujingwei
	 * @date 2017年10月27日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping(value="/groupedit")
	public ModelAndView viewGroupAdd(HttpSession session, String groupUid, String viewFlag) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/syn/system/sccheck/checkgroup/checkgroup_add");
		//初始化临时操作标志
		pubScGroupMemberService.initCheckGroupMaintainPage(groupUid);
		mav.addObject("codePositionTypeList", doGetCodePositionTypeList(sysUser));
		mav.addObject("codeExpertTypeList", doGetCodeCodeExpertTypeList(sysUser));
		mav.addObject("groupUid", groupUid);
		mav.addObject("groupType", "3");
		mav.addObject("sysUser", sysUser);
		mav.addObject("viewFlag", viewFlag);
		return mav;
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
	 * 描述：添加页检查小组查询
	 *
	 * @author yujingwei
	 * @date 2017年7月27日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/randomlist.json")
	@ResponseBody
	public PageResponse<PubScGroupMemberDto> randomListJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		List<PubScGroupMemberDto> pubScGroupMemberDtoList = pubScGroupMemberService.queryGroupMaintainPage(request, sysUserDto);
		return new PageResponse<PubScGroupMemberDto>(pubScGroupMemberDtoList);
	}
	
	/**
	 * 描述: 批量提交检查小组数据
	 * 
	 * @auther yujingwei
	 * @date 2017年7月11日 
	 * @param pubScGroupMemberDto
	 * @return AjaxResult
	 * @throws Exception
	 */
   	@RequestMapping(value = "/addmemberbatch", method = RequestMethod.POST)
   	@ResponseBody
   	public AjaxResult doAdd(@RequestBody PubScGroupMemberDto pubScGroupMemberDto,HttpSession session) throws Exception {
   		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
   		if(pubScGroupMemberService.commitPubScGroupMemberBatch(sysUser,pubScGroupMemberDto.getGroupUid(), pubScGroupMemberDto.getPubScGroupMemberList())){
   			return AjaxResult.success("添加成功");
   		}
   		return AjaxResult.error("添加失败");
   	} 
   	
	/**
   	 * 
   	 * 描述: 批量删除检查小组
   	 * @auther yujingwei
   	 * @date 2017年7月11日 
   	 * @param deptTaskUid
   	 * @param AgentIds
   	 * @return
   	 * @throws Exception
   	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
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
	 * 描述：删除执法人员单条记录
	 * 
	 * @author yujingwei
	 * @date 2017年7月10日
	 * @param uid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "delmember", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doDelGroupmember(String uid, String groupType) throws Exception{
		if(StringUtil.isNotBlank(uid)){
			if("1".equals(groupType)){
				if(pubScGroupMemberService.doDelGroupmemberInfoByUid(uid) > 0){
					return AjaxResult.success("删除成功！");
				}
			}else{
				if(pubScGroupMemberService.doDelGroupmemberInfoByLogic(uid) > 0){
					return AjaxResult.success("删除成功！");
				}
			}
		}
		return AjaxResult.error("删除失败！");
	}
	
	/**
	 * 描述：选择检查小组（用于执法人员调整）
	 * 
	 * @author yujingwei
	 * @date 2017年10月30日
	 * @param uid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "choiceData", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult choiceDataForAdjust(String groupUids, HttpSession session) throws Exception{
		SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtil.isNotBlank(groupUids)){
			if (pubScGroupMemberService.doChoiceCheckGroupForBackPage(groupUids,sysUserDto)) {
				return AjaxResult.success("提交成功！");
			}else{
				return AjaxResult.error("提交失败！");
			}
		}
		return AjaxResult.error("提交失败！");
	}
}
