/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.controller.syn.server;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.drcheck.model.PubDeptNumber;
import com.icinfo.cs.drcheck.service.IPubDeptNumberService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/**
 * 描述: cs_pub_dept_number 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月13日
 */
@Controller
@RequestMapping("/syn/server/drcheck/pubdeptnumber")
public class PubDeptNumberController extends BaseController {

	@Autowired
	private IPubDeptNumberService pubDeptNumberService;
	@RequestMapping("/selectDeptNumber")
    @ResponseBody
	public AjaxResult selectDeptNumber(String deptCode) throws Exception {
		 Integer deptNumber=null;
		if (StringUtils.isNotEmpty(deptCode)) {
			PubDeptNumber pubDeptNumber=pubDeptNumberService.selectByDeptCode(deptCode);
			if(pubDeptNumber!=null&&pubDeptNumber.getDeptNumber()!=null&&!pubDeptNumber.equals("")){
				deptNumber=pubDeptNumber.getDeptNumber()+1;//编号加1
				return AjaxResult.success("查询成功1", deptNumber);
			}else{
				deptNumber=1;
				return AjaxResult.success("查询成功",deptNumber);
			}
			

		}else{
			return AjaxResult.error("查询失败");
		}

	}

}