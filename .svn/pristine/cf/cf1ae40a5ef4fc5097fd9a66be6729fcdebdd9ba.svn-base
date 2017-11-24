/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.reg.server;

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
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.cs.yr.model.PubOtherpunishHis;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.cs.yr.service.IPubOtherpunishHisService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_pub_otherpunish 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Controller("ServerPubOtherPunish")
@RequestMapping({ "/pub/server/pubotherpunish", "/syn/server/pubotherpunish" })
public class OtherpunishAuditController extends CSBaseController {

	@Autowired
	private IPubOtherpunishService pubOtherpunishService;

	@Autowired
	private IPubServerHisModService pubServerHisModService;

	@Autowired
	private IPubOtherpunishHisService pubOtherpunishHisService;

	@Autowired
	private IPubOtherPunishAlterService pubOtherPunishAlterService;

	/**
	 * 
	 * 描述: 进入行政处罚录入审核列表页
	 * 
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunish_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		if (sysUser.getUserType().equals("1")) {
			view.addObject("urlType", "/pub");
		} else { 
			view.addObject("deptCode", sysUser.getDeptCode());// 部门id
			view.addObject("urlType", "/syn");
		}
		return view;
	}

	/**
	 * 描述：获取行政处罚录入审核列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubOtherpunish>(data)
	 * @throws Exception
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<PubOtherpunish> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "b.CheckDep", "b.LocalAdm");
		Map<String,Object> parmMap=request.getParams();
		if(parmMap==null){
			parmMap=new HashMap<String,Object>();
		}
		com.icinfo.cs.common.utils.StringUtil.paramTrim(parmMap);
		request.setParams(parmMap);
		List<PubOtherpunish> data = pubOtherpunishService.queryPage(request);
		return new PageResponse<PubOtherpunish>(data);
	}

	/**
	 * 描述：获取行政处罚详情页修改记录列表数据
	 * 
	 * @author yujingwei
	 * @data 2016-10-17
	 * @param request
	 * @return PageResponse<PubServerHisMod>(data)
	 * @throws Exception
	 */
	@RequestMapping("/modlist.json")
	@ResponseBody
	public PageResponse<PubServerHisMod> modlistJSON(PageRequest request) throws Exception {
		List<PubServerHisMod> data = pubServerHisModService.queryPage(request);
		return new PageResponse<PubServerHisMod>(data);
	}

	/**
	 * 
	 * 描述: 进入行政处罚录入审核详细页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/doEnt")
	public ModelAndView doEnAudit(String pripid, String caseNO, String entType, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView();
		if (entType.equals("audit")) {
			view = new ModelAndView("reg/server/other/pubotherpunish/otherpunish_audit");
		} else if (entType.equals("view")) {
			view = new ModelAndView("reg/server/other/pubotherpunish/otherpunish_view");
		}
		PubOtherpunish pubOtherpunish = pubOtherpunishService.doGetPubOtherPunishInfo(pripid, caseNO);
		view.addObject("pubOtherpunish", pubOtherpunish);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 
	 * 描述: 进入行政修改记录详细页面
	 * 
	 * @auther yujingwei
	 * @date 2016年9月11日
	 * @param session
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("/doDetails")
	public ModelAndView doDetails(String pripid, String hisNO, String auditState, String modUID, HttpSession session)
			throws Exception {
		ModelAndView view = new ModelAndView("reg/server/other/pubotherpunish/otherpunish_details");
		if (StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(hisNO) && StringUtil.isNotBlank(modUID)) {
			if (StringUtil.isNotBlank(auditState) && (auditState.equals("1") || auditState.equals("2"))) {
				// 行政处罚历史信息
				PubOtherpunishHis pubOtherpunishHis = pubOtherpunishHisService.doGetPunishHisInfo(pripid, hisNO,
						modUID);
				view.addObject("pubOtherpunishHis", pubOtherpunishHis);
				view.addObject("viewType", "audit");
			} else {
				// 行政处罚变更信息
				PubOtherPunishAlter pubOtherPunishAlter = pubOtherPunishAlterService.doGetPunishAlter(pripid, hisNO,
						modUID);
				view.addObject("pubOtherPunishAlter", pubOtherPunishAlter);
				view.addObject("viewType", "alter");
			}
		}
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser.getUserType());// 用户类型 1：监管；2：协同。
		return view;
	}

	/**
	 * 行政处罚审核
	 * 
	 * @author yujingwei
	 * @date 2016-10-17
	 * @param pubOtherpunish
	 * @return AjaxResult
	 * @throws Exception
	 */
	@RequestMapping(value = "commit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doCommit(PubOtherpunish pubOtherpunish) throws Exception {
		try {
			if (pubOtherpunish != null) {
				boolean commitFlag = pubOtherpunishService.doCommitPubOtherpunish(pubOtherpunish);
				if (commitFlag) {
					return AjaxResult.success("保存成功");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("保存失败！");
		}
		return AjaxResult.error("保存失败！");
	}
}