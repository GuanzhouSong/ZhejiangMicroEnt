/*
 * Copyright? 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.ext.model.MidCaseInfo;
import com.icinfo.cs.ext.service.IMidCaseInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


/** 
 * 描述: 投资任职企业被行政处罚-Controller
 * @author 张文男
 * @date 2017年3月17日  
 */
@Controller
@RequestMapping({"/syn/ext/midCaseInfo"})
public class MidCaseInfoController extends BaseController {

	@Autowired
	private IMidCaseInfoService midCaseInfoService;

	/** 
	 * 描述: 根据身份证号获取列表
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping({ "/selectListByCerNO" })
	@ResponseBody
	public PageResponse<MidCaseInfo> selectListByCerNO(PageRequest request) throws Exception {
		List<MidCaseInfo> list = midCaseInfoService.selectListByCerNO(request);
		return new PageResponse<MidCaseInfo>(list);
	}

}