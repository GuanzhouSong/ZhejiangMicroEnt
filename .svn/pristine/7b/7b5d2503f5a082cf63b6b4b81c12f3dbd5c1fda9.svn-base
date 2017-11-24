/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.message.service.IMessageIminfoService;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.system.controller.CSBaseController;

/**
 * 描述:    cs_message_iminfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
@Controller
@RequestMapping("/message/messageiminfo")
public class MessageImInfoController extends CSBaseController {
	@Autowired
    private IPubEppasswordService  pubEppasswordService; 
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService; 
	@Autowired
	private IMessageIminfoService messageIminfoService;
	@Autowired
	private ICreditProveListService creditProveListService;
	
	
	
	/**
	 * 
	 * 描述   即时信息查看详情
	 * @author 赵祥江
	 * @date 2017年7月18日 下午2:19:41 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/toMessageImInfoView")
	public ModelAndView pubOpanoMalyListPage(String msgReadTel,String sendDate) throws Exception{
		List<PubEppasswordDto> pList=new ArrayList<PubEppasswordDto>(); 
		ModelAndView view  = new ModelAndView("/message/message_iminfo_view");
		if(StringUtil.isNotBlank(msgReadTel)){
			List<PubEppasswordDto> pubEppasswordList= pubEppasswordService.queryPubEppasswordImInfoBytelList(msgReadTel);
			if(pubEppasswordList.size()>0){ 
				for(PubEppasswordDto pubEppassword:pubEppasswordList){
					 if(!pList.contains(pubEppassword)){
						 pList.add(pubEppassword);
					 }
				}
			}
		} 
		view.addObject("pList", pList); 
		return view;
	}
	
	/**
	 * 
	 * 描述   定时推送消息
	 * @author 赵祥江
	 * @date 2017年7月12日 上午11:19:02 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void quartzJob () throws Exception{
		messageIminfoService.quartzJob(); 
	}
	
	
}