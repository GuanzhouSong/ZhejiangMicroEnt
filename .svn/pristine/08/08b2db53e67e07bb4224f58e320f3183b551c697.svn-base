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

import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.PubOtherPunishAlter;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_otherpunish 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Controller("PubOtherPunish")
@RequestMapping("/pub/pubotherpunish")
public class PubOtherpunishController extends BaseController {
	
	@Autowired
	private IPubOtherpunishService pubOtherpunishService;
	
	@Autowired
	private IPubOtherPunishAlterService pubOtherPunishAlterService;
	
	/** 
	 * 描述: 获取行政处罚信息列表数据
	 * @auther ZhouYan
	 * @date 2016年11月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
	@ResponseBody
    public PageResponse<PubOtherpunishDto> listJSON(PageRequest request) throws Exception {
		List<PubOtherpunishDto> data = pubOtherpunishService.queryPageForPub(request);
		for(PubOtherpunishDto pubOtherpunishDto : data) {
			//变更信息
			List<PubOtherPunishAlter> pubOtherPunishAlterList = pubOtherPunishAlterService.doGetAlterInfoList(pubOtherpunishDto.getPriPID(), pubOtherpunishDto.getCaseNO());
			pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterList);
		}
        return new PageResponse<PubOtherpunishDto>(data);
    }
	
	/** 
	 * 描述: 获取行政处罚信息详情数据
	 * @auther ZhouYan
	 * @date 2016年11月1日 
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public ModelAndView doEnDetail(String caseNO, String priPID) throws Exception{
		ModelAndView view = new ModelAndView("pub/infopublic/infodetail/punishdetail");
		if(StringUtils.isNotBlank(caseNO) && StringUtils.isNotBlank(priPID)){
			PubOtherpunishDto pubOtherpunishDto = pubOtherpunishService.doGetPubOtherpunishByCaseNO(caseNO, priPID);
			view.addObject("pubOtherpunishDto", pubOtherpunishDto);
		}
		return view;
	}
	
}