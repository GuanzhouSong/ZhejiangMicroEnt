/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.deptpubinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.deptpubinfo.dto.DeptPubInfoDto;
import com.icinfo.cs.deptpubinfo.service.IDeptPubInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_mid_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年08月01日
 */
@Controller
@RequestMapping("/reg/server/deptpubinfo")
public class DeptPubInfoController extends CSBaseController {
	
	@Autowired
	private IDeptPubInfoService deptPubInfoService;
	
	@Autowired
	private ICodeRegStateService codeRegStateService;
	
	/** 
	 * 描述: 进入部门公示信息列表页面
	 * @auther ZhouYan
	 * @date 2017年8月1日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list")
	public ModelAndView list() throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/deptpubinfo/deptpubinfo_list");
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/** 
	 * 描述: 获取部门公示信息列表
	 * @auther ZhouYan
	 * @date 2017年8月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<DeptPubInfoDto> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"t1.CheckDep","t1.LocalAdm");
		List<DeptPubInfoDto> data = deptPubInfoService.selectDeptPubInfoList(request);
		return new PageResponse<DeptPubInfoDto>(data);
    }
}