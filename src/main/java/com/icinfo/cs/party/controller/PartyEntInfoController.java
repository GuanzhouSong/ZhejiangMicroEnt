/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.party.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.party.model.PartyEntInfo;
import com.icinfo.cs.party.service.IPartyEntInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;

/**
 * 描述:    cs_party_ent_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年09月01日
 */
@Controller("ServerPartyEntInfo")
@RequestMapping({"/syn/server/party/ent","/reg/server/party/ent"})
public class PartyEntInfoController extends BaseController {
	
	@Autowired
	private IPartyEntInfoService partyEntInfoService;
	
	/**
	 * 描述：保存或修改党员信息
	 * @author yujingwei
	 * @date 2017年8月18日 
	 * @param organizeInfo
	 * @param  session
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveOrEdit", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit(timeout=2000)
	public AjaxResult doSaveOrEditFavorableInfo(PartyEntInfo partyEntInfo, HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		if(StringUtils.isNotBlank(partyEntInfo.getUID())){
			if(partyEntInfoService.doUpdatePartyEntInfoInfo(partyEntInfo, sysUser) >0){
				return AjaxResult.success("更新成功！");
			}
		}else{
			if(partyEntInfoService.doSavePartyEntInfo(partyEntInfo, sysUser) >0){
				return AjaxResult.success("保存成功！");
			}
		}
		return AjaxResult.error("保存失败！");
	}
}