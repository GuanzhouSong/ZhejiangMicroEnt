/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.controller;

import java.util.Date;
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

import com.icinfo.cs.base.model.CodeAddress;
import com.icinfo.cs.base.service.ICodeAddressService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.party.dto.PartyOrganizeInfoDto;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.cs.party.service.IPartyOrganizeInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述: cs_party_organize_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
@Controller("ServerPartyOrgInfo")
@RequestMapping({ "/syn/server/party/organize", "/reg/server/party/organize" })
public class PartyOrganizeInfoController extends CSBaseController {

	@Autowired
	private IPartyOrganizeInfoService partyOrganizeInfoService;
	@Autowired
	private ICodeAddressService codeAddressService;

	/**
	 * 描述: 进入党组织录入页面
	 * 
	 * @auther yujingwei
	 * @date 2017年8月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("list")
	public ModelAndView list() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_org_list");
		return view;
	}

	/**
	 * 描述: 分页查询党组织信息
	 * 
	 * @auther yujingwei
	 * @date 2016年9月20日
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping({ "/partyorg.json", "list.xml" })
	@ResponseBody
	public PageResponse<PartyOrganizeInfo> queryPartyOrgInfo(PageRequest request) throws Exception {
		request.getParams().put("queryAll", getLimitReg());
		return (new PageResponse<PartyOrganizeInfo>(partyOrganizeInfoService.queryPage(request)));
	}

	/**
	 * 描述: 选择党组织（公用选择页）
	 * 
	 * @auther yujingwei
	 * @date 2017年8月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("chooseOrg")
	public ModelAndView chooseOrg() throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_org_choose");
		return view;
	}

	/**
	 * 描述: 分页查询党组织信息（公用选择页）
	 * 
	 * @auther yujingwei
	 * @date 2016年9月20日
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	@RequestMapping({ "/list.json", "list.xml" })
	@ResponseBody
	public PageResponse<PartyOrganizeInfo> queryPageDeliverInfo(PageRequest request) throws Exception {
		// 默认：根据用户级别查询所有
		if (request.getParams().containsKey("queryAll")) {
			String whereValBySysuser = getLimitReg();
			request.getParams().put("queryAll", whereValBySysuser);
		}
		if (request.getParams().containsKey("localAdm")) {
			String localAdm = (String) request.getParams().get("localAdm");
			if (StringUtils.length(localAdm) <= 6) {
				request.getParams().remove("localAdm");
				request.getParams().put("queryAll", localAdm);
			}
		}
		request.getParams().put("defalutState", "1");
		return (new PageResponse<PartyOrganizeInfo>(partyOrganizeInfoService.queryPage(request)));
	}

	/**
	 * 描述: 进入党组织新增和修改页面
	 * 
	 * @auther yujingwei
	 * @date 2017年8月18日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("addOrModifyView")
	public ModelAndView addOrModifyView(String uid, String viewFlag) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/party_org_edit");
		if (StringUtils.isNotBlank(uid)) {
			PartyOrganizeInfo organizeInfo = partyOrganizeInfoService.doGetOrganizeInfoByUid(uid);
			List<CodeAddress> codeAddresses = codeAddressService.selectCountyListByCityCode(organizeInfo.getLocCity());
			List<CodeAddress> addressStreet = codeAddressService.selectCountyListByCountyCode(organizeInfo.getLocCounty());
		    view.addObject("codeAddresses", codeAddresses);
		    view.addObject("addressStreet", addressStreet);
			view.addObject("organizeInfo", organizeInfo);
		}
		view.addObject("viewFlag", viewFlag);
		return view;
	}

	/**
	 * 描述：保存或修改党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param organizeInfo
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout = 1000)
	public AjaxResult doSaveOrEditFavorableInfo(PartyOrganizeInfo organizeInfo, HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Date creatDate = organizeInfo.getCreateTime();
		if (StringUtils.isNotBlank(organizeInfo.getUID())) {
			if (partyOrganizeInfoService.doUpdatePartyOrganizeInfo(organizeInfo, sysUser) > 0) {
				if ("1".equals(organizeInfo.getInputState()) && creatDate == null) {
					return AjaxResult.success("入库成功！");
				}
				return AjaxResult.success("更新成功！");
			} else {
				return AjaxResult.error("已存在相同名称的党组织，请重新录入！");
			}
		} else {
			if (partyOrganizeInfoService.doSavePartyOrganizeInfo(organizeInfo, sysUser) > 0) {
				return AjaxResult.success("保存成功！");
			} else {
				return AjaxResult.error("已存在相同名称的党组织，请重新录入！");
			}
		}
	}

	/**
	 * 描述：删除党组织信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param UID
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult delete(String UID) throws Exception {
		if (StringUtil.isNotEmpty(UID)) {
			if (partyOrganizeInfoService.deletePartyOrganizeInfo(UID) > 0) {
				return AjaxResult.success("删除成功");
			}
		}
		return AjaxResult.success("删除失败！");
	}

	/**
	 * 描述：查询党组织相似信息
	 * 
	 * @author yujingwei
	 * @date 2017年8月18日
	 * @param partyOrgName,inputState
	 * @throws Exception
	 */
	@RequestMapping(value = "/similarinfo", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult doGetSimilarinfo(String keyWords, String inputState) throws Exception {
		if (StringUtil.isNotEmpty(keyWords) && StringUtil.isNotEmpty(inputState)) {
			List<PartyOrganizeInfo> data = partyOrganizeInfoService.doGetOrgSimilarinfo(keyWords, inputState);
			if (data.size() >= 10) {
				return AjaxResult.success("", data.subList(0, 10));
			}
			return AjaxResult.success("", data);
		}
		return AjaxResult.error("");
	}

	/**
	 * 描述: 党建信息统计报表页面
	 * 
	 * @auther baifangfang
	 * @date 2017年9月4日
	 * @return view
	 * @throws Exception
	 */
	@RequestMapping("partybuildinfocountview")
	public ModelAndView partyBuildInfoCountView(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/reg/server/partycreate/partybuildinfocount_view");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("sysUser", sysUser);
		String deptCode = "";
		if (sysUser.getDepartMent() != null) {
			deptCode = sysUser.getDepartMent().getDeptCode();
			if (deptCode.length() > 4) {
				deptCode = deptCode.substring(0, 4);
			}
		}
		view.addObject("deptCode", deptCode);
		String preDate = DateUtil.getNdaylater(new Date(), -1).substring(0, 10);
		view.addObject("preDate", preDate);
		return view;
	}

	/**
	 * 
	 * 描述: 党建信息统计报表
	 * 
	 * @auther baifangfang
	 * @date 2017年9月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("partybuildinfocount.json")
	@ResponseBody
	public PageResponse<PartyOrganizeInfoDto> partyBuildInfoCount(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request, "A.regOrg", "A.localAdm");
		Map<String, Object> params = request.getParams();
		Object partyOrgDistributedObj = params.get("partyOrgDistributed");
		if (partyOrgDistributedObj != null) {
			if("1,4,2,3".equals(partyOrgDistributedObj.toString())){
				params.put("partyOrgDistributed", null);
			}
		}
		List<PartyOrganizeInfoDto> data = partyOrganizeInfoService.selectPartyOrganizeInfoCount(request);
		return new PageResponse<PartyOrganizeInfoDto>(data);
	}

}