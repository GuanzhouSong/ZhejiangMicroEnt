/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.specialrec.dto.SpecialRecResultDto;
import com.icinfo.cs.specialrec.model.SpecialRecItem;
import com.icinfo.cs.specialrec.service.ISpecialRecItemService;
import com.icinfo.cs.specialrec.service.ISpecialRecResultService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_special_rec_result 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月02日
 */
@Controller
@RequestMapping({"/reg/server/specialrec/result","/syn/server/specialrec/result"})
public class SpecialRecResultController extends CSBaseController {
	
	@Autowired
	private ISpecialRecResultService specialRecResultService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ISpecialRecItemService specialRecItemService;
	
	/**
	 * 描述: 进入专项整治录入列表页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView enterListpage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_input_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入专项整治查询列表页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/searchlist")
	public ModelAndView enterSearchlistPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_search_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入专项整治查询列表页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/editlist")
	public ModelAndView enterEditlistPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_alter_list");
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述: 进入专项整治名单指派列表页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/assignlist")
	public ModelAndView enterAssignlistPage(HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_assign_list");
		mav.addObject("yearList", DateUtil.getYearToNow());
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 描述：查询专项整治录入列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<SpecialRecResultDto> listJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (request != null) {
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			if ("1".equals(sysUser.getUserType())) {
				String deptCode = sysUser.getDepartMent().getDeptCode();
				if (deptCode.length()== 6) {
					deptCode = deptCode+"00";
				}
				qryMap.put("deptCode", deptCode);
			}else{
				String deptCode = sysUser.getSysDepart().getOrgCoding();
				qryMap.put("deptCode", deptCode);
			}
		}
		List<SpecialRecResultDto> specialRecResultList = specialRecResultService.querySpecialrecResultList(request);
		return new PageResponse<SpecialRecResultDto>(specialRecResultList);
	}
	
	/**
	 * 描述：查询专项整治名单指派列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping("/assign.json")
	@ResponseBody
	public PageResponse<SpecialRecResultDto> assignListJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (request != null) {
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			String deptCode = null;
			if ("1".equals(sysUser.getUserType())) {
				deptCode = sysUser.getDepartMent().getDeptCode();
			}else{
				deptCode = sysUser.getSysDepart().getAdcode();
			}
			qryMap.put("orgDeptCode", deptCode);
			qryMap.put("checkState", "0");
			String unitDeptCodes = qryMap.get("unitDeptCodes").toString();
			if (StringUtil.isNotBlank(unitDeptCodes)) {
				qryMap.put("checkDeptCodes",StringUtil.doSplitStringToSqlFormat(unitDeptCodes, ","));
			}
		}
		List<SpecialRecResultDto> specialRecResultList = specialRecResultService.querySpecialrecResultList(request);
		return new PageResponse<SpecialRecResultDto>(specialRecResultList);
	}
	
	/**
	 * 描述: 进入专项整治录入页面
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/addResultPage")
	public ModelAndView enterInfoPage(@RequestParam String taskUid,@RequestParam String resultUid, @RequestParam String priPID, 
			@RequestParam String flag,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		SpecialRecResultDto recResultDto = specialRecResultService.selectSpecialRecResultDtoInfo(resultUid);
		List<SpecialRecItem> specialRecItems = specialRecItemService.selectSpecialRecItemListByUid(resultUid);
		ModelAndView mav = new ModelAndView("/reg/server/specialrec/specialrec_input_edit");
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		List<MidBaseInfoDto> midBaseInfoDtos = midBaseInfoService.doGetListByPriPID(priPID);
		if (pubEppassword != null) {
			if (StringUtil.isEmpty(pubEppassword.getLerep())) {
				if (midBaseInfoDtos.size() > 0) {
					MidBaseInfoDto midBaseInfoDto = midBaseInfoDtos.get(0);
					pubEppassword.setLerep(midBaseInfoDto.getLeRep());
					pubEppassword.setLerepphone(midBaseInfoDto.getTel());
				}
			}
		} else {
			pubEppassword = new PubEppassword();
			if (midBaseInfoDtos.size() > 0) {
				MidBaseInfoDto midBaseInfoDto = midBaseInfoDtos.get(0);
				pubEppassword.setLerep(midBaseInfoDto.getLeRep());
				pubEppassword.setLerepphone(midBaseInfoDto.getTel());
			}
		}
		mav.addObject("specialRecItems", specialRecItems);
		mav.addObject("maxNum", specialRecItems.size());
		mav.addObject("specialRecResult", recResultDto);
		mav.addObject("pubEppassword", pubEppassword);
		mav.addObject("sysUser", sysUser);
		mav.addObject("flag", flag);
		return mav;
	}
	
	/**
	 * 描述：检查结果录入修改
	 * 
	 * @author yujingwei
	 * @date 2017年11月03日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "enterResult", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult enterResultInfo(@RequestBody Map<String, Object> map, HttpSession session) throws Exception {
		String commitWay = (String) map.get("dataType");
		String msg = ("2".equals(commitWay)?"暂存":"提交");
		try {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			int i = specialRecResultService.doEnterRecResultInfo(map, sysUser, commitWay);
			if (i > 0) {
				return AjaxResult.success(msg+"成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error(msg+"失败");
		}
		return AjaxResult.error(msg+"失败");
	}
	
	/**
	 * 描述：查询专项整治录入完结个数
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@RequestMapping(value = "count.json", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult countJSON(PageRequest request, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if (request != null) {
			Map<String, Object> qryMap = request.getParams();
			//去掉查询参数的左右空格
			StringUtil.paramTrim(qryMap);
			if ("1".equals(sysUser.getUserType())) {
				String deptCode = sysUser.getDepartMent().getDeptCode();
				if (deptCode.length()== 6) {
					deptCode = deptCode+"00";
				}
				qryMap.put("deptCode", deptCode);
			}else{
				String deptCode = sysUser.getSysDepart().getOrgCoding();
				qryMap.put("deptCode", deptCode);
			}
		}
		SpecialRecResultDto recResultDto = specialRecResultService.selectSpecialRecResultDtoForCount(request);
		return AjaxResult.success("", recResultDto);
	}
	
	/**
	 * 描述: 进入任务指派页面
	 * @auther yujingwei
	 * @date 2017年11月07日
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("appointpage")
	public ModelAndView appointpage(HttpSession session,String uids) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/specialrec/specialrec_assign_choose");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		view.addObject("uids", uids);
		return view;
	}
	
	/**
	 * 描述：名单指派
	 * 
	 * @author yujingwei
	 * @date 2017-05-17
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "/appoint", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doAppointEnt(@RequestParam String uids,String appointLocalAdm,HttpSession session) throws Exception {
		try {
			SysUserDto sysUserDto = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			if(specialRecResultService.doAppointEnts(uids,appointLocalAdm,sysUserDto)){
				return AjaxResult.success("指派成功");
			}
		} catch (Exception e) {
			return AjaxResult.error("指派失败");
		}
		return AjaxResult.error("指派失败");
	}

}