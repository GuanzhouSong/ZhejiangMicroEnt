/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_mid_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */

@Controller
@RequestMapping({ "/syn/midbaseinfo", "/reg/server/midbaseinfo" })
public class MidBaseInfoController extends CSBaseController {
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述   进入企业数据查询页面
	 * @author 赵祥江
	 * @date 2017年3月1日 下午2:55:43 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/midbaseinfoList")
	public ModelAndView midbaseinfoList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view  = new ModelAndView("/reg/server/midbaseinfo/midbaseinfo_list"); 
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
	 * 
	 * 描述   分页查询企业数据
	 * @author 赵祥江
	 * @date 2017年3月1日 下午3:18:42 
	 * @param 
	 * @return PageResponse<MidBaseInfo>
	 * @throws
	 */
	@RequestMapping({"/midbaseinfoListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<MidBaseInfo> midbaseinfoListJSON(PageRequest request) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		request.setParams(queryMap); 
		List<MidBaseInfo> midBaseInfoList= midBaseInfoService.queryPage(request);
		return new PageResponse<MidBaseInfo>(midBaseInfoList);
	}
	
	/**
	 * 描述：经营期限将到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param session
	 */
	@RequestMapping("opDateSoonExpireNum")
	@ResponseBody
	public void opDateSoonExpireNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = midBaseInfoService.opDateSoonExpireNum(qryMap);
		System.out.println(count+"====================");
	}
	
	/**
	 * 描述：经营期已经到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param session
	 */
	@RequestMapping("opDateAlreadyExpireNum")
	@ResponseBody
	public void opDateAlreadyExpireNum() {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		creatDefaultDBAuthEnv(qryMap, "b.CheckDep", "b.LocalAdm");
		int count = midBaseInfoService.opDateAlreadyExpireNum(qryMap);
		System.out.println(count+"====================");
	}
	
}