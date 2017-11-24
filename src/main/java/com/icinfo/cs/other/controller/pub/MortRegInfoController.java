/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.controller.pub;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.other.model.MortAltitemInfo;
import com.icinfo.cs.other.model.MortCancelInfo;
import com.icinfo.cs.other.model.MortGuaranteeInfo;
import com.icinfo.cs.other.model.MortRegInfo;
import com.icinfo.cs.other.service.IMortAltitemInfoService;
import com.icinfo.cs.other.service.IMortCancelInfoService;
import com.icinfo.cs.other.service.IMortGuaranteeInfoService;
import com.icinfo.cs.other.service.IMortRegInfoService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_mort_reg_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Controller("MortRegInfo")
@RequestMapping("/pub/mortreginfo")
public class MortRegInfoController extends BaseController {
	
	@Autowired
	private IMortRegInfoService mortRegInfoService;
	
	@Autowired
	private IMortGuaranteeInfoService mortGuaranteeInfoService;
	
	@Autowired
	private IMortAltitemInfoService mortAltitemInfoService;
	
	@Autowired
	private IMortCancelInfoService mortCancelInfoService;
	/** 
	 * 描述: 获取动产抵押信息录入列表数据
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<MortRegInfo> listJSON(PageRequest request) throws Exception {
		List<MortRegInfo> data = mortRegInfoService.queryPage(request);
        return new PageResponse<MortRegInfo>(data);
    }
	
	/** 
	 * 描述: 动产抵押信息录入详情
	 * @auther ZhouYan
	 * @date 2016年10月26日 
	 * @param pripid
	 * @param UID
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public ModelAndView doEnDetail(String id) throws Exception{
		ModelAndView view = new ModelAndView("pub/infopublic/infodetail/pledgedetail");
		if(StringUtils.isNotBlank(id)){
			//根据id查详情
			MortRegInfo mortRegInfo = mortRegInfoService.doGetMortRegInfoById(id);
			view.addObject("mortRegInfo", mortRegInfo);
			if(mortRegInfo != null) {
				//抵押物
				if(StringUtils.isNotBlank(mortRegInfo.getOrderNO())) {
					List<MortGuaranteeInfo> mortGuaranteeInfoList = mortGuaranteeInfoService.doGetMortGuaranteeInfoList(mortRegInfo.getOrderNO());
					view.addObject("mortGuaranteeInfoList", mortGuaranteeInfoList);
				}
				//变更信息
				if("1".equals(mortRegInfo.getChangeStatus()) && StringUtils.isNotBlank(mortRegInfo.getFilingNO())) {
					List<MortAltitemInfo> mortAltitemInfoList = mortAltitemInfoService.doGetMortAltitemInfoList(mortRegInfo.getFilingNO());
					view.addObject("mortAltitemInfoList", mortAltitemInfoList);
				}
				//注销信息
				if("1".equals(mortRegInfo.getCancelStatus()) && StringUtils.isNotBlank(mortRegInfo.getFilingNO())) {
					MortCancelInfo mortCancelInfo = mortCancelInfoService.doGetMortCancelInfo(mortRegInfo.getFilingNO());
					view.addObject("mortCancelInfo", mortCancelInfo);
				}
			}
		}
		return view;
	}
}