package com.icinfo.cs.nocreditPunish.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishBackDto;
import com.icinfo.cs.nocreditPunish.service.NoCreditPunishBackService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 失信联合惩戒反馈控制器
 * @author caoxu
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/syn/noCreditPunish/back", "/reg/server/noCreditPunish/back" })
public class NoCreditPunishBackController extends BaseController {
	
	@Autowired
	private NoCreditPunishBackService noCreditPunishBackService;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult save(String backContent, String batchNo) throws Exception {
		if (backContent == null || StringUtils.isBlank(backContent)) {
			return AjaxResult.error("请填写反馈意见！");
		}
		// 获取当前用户
		SysUserDto user = this.noCreditPunishBackService.getCurrUser();
		NoCreditPunishBackDto noCreditPunishBack = new NoCreditPunishBackDto();
		SysUserDto sysUserDto = (SysUserDto) super.getSession().getAttribute(Constants.SESSION_SYS_USER);
		if (sysUserDto.getUserType().equals("1")) {
			noCreditPunishBack.setBackDeptCode(user.getDeptCode());
		} else
			noCreditPunishBack.setBackDeptCode(user.getSysDepart().getAdcode());
		noCreditPunishBack.setBackContent(backContent);
		noCreditPunishBack.setOpName(user.getRealName());
		noCreditPunishBack.setBatchNo(batchNo);
		if (this.noCreditPunishBackService.update(noCreditPunishBack)) {
			return AjaxResult.success("提交反馈成功");
		}
		return AjaxResult.error("提交反馈失败！");
	}

}
