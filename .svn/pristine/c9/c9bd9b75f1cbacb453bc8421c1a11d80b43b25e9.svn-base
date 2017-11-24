/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPubPbePasswordService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述:    cs_pub_pbeppassword 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Controller
@RequestMapping("/reg/server/yr/pubpbepassword/")
public class PubPbePasswordController extends BaseController {
	@Autowired IPubPbePasswordService pubPbePasswordService;
	
	@Autowired IMidBaseInfoService midBaseInfoService;
	
	/** 
	 * 描述: 进入密码管理主页
	 * @author ZhouJun
	 * @date 2016年10月14日 
	 * @return String
	 * @return 
	 */
	@RequestMapping("list")
	public String  list() {
		return "reg/server/yr/pubpbepassword/list_main";
		
	}
	

	/** 
	 * 描述: 从企业基本信息表和密码表中查询
	 * @author ZhouJun
	 * @date 2016年9月19日 
	 * @param regNO
	 * @param uniCode
	 * @param entName
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="search.json",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> search(String regNO,String uniCode,String entName,HttpSession session) throws Exception{
		Map<String,Object> maps= new HashMap<>();
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		maps.put("searchregNO",regNO);
		maps.put("searchuniCode",uniCode);
		maps.put("searchentName",entName);
		maps.put("entTypeCatg", "3");
		List<MidBaseInfoDto> midList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(maps);
		MidBaseInfo mi = new MidBaseInfo();
		if(midList != null && midList.size()>0){
			mi = midList.get(0);
			maps.put("midBaseInfo", mi);
		}
		PubPbePassword ppp  =pubPbePasswordService.selectServerPubPbePassword(maps);
		if(ppp!=null ){
			maps.put("PubPbePassword", ppp);
		}
		maps.put("sysUser", sysUser);
		return maps;
	}
	
	
	/** 
	 * 描述: 新增
	 * @author ZhouJun
	 * @date 2016年9月18日 
	 * @param pb
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="insert",method=RequestMethod.POST)
    @ResponseBody
	public AjaxResult insert(PubPbePassword pubPbePassword) throws Exception{
		if(StringUtil.isNotBlank(pubPbePassword.getUID())){//修改
			if(pubPbePasswordService.save(pubPbePassword)){
				return AjaxResult.success("修改成功");
			}
		}else{
			if(pubPbePasswordService.insert(pubPbePassword)){
				return AjaxResult.success("保存成功");
			}
		}
		return AjaxResult.success("操作失败");
	}
}