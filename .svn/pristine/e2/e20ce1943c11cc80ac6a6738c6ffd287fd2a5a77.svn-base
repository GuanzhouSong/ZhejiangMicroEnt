/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.controller.pub;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_favorable_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年03月02日
 */
@Controller("PubFavorAbleInfoController")
@RequestMapping({"/pub/favorableinfo"})
public class FavorAbleInfoController extends CSBaseController {
	
	@Autowired
	private IFavorAbleInfoService favorAbleInfoService;
	
	/** 
	 * 描述: 分页查询良好荣誉信息
	 * @auther ZhouYan
	 * @date 2017年10月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/list.json")
	@ResponseBody
	public PageResponse<FavorAbleInfo> listJSON(PageRequest request) throws Exception {
		List<FavorAbleInfo> data= favorAbleInfoService.queryFavorAbleInfoForPub(request);
		return new PageResponse<FavorAbleInfo>(data);
	}
	
	/** 
	 * 描述: 查看详情
	 * @auther ZhouYan
	 * @date 2017年10月17日 
	 * @param session
	 * @param uid
	 * @param type
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/detail")
	public ModelAndView favorAbleInfoDetail(String uid) throws Exception{
		ModelAndView view  = null;
		view  = new ModelAndView("/pub/infopublic/infodetail/favorableinfodetail");
		FavorAbleInfo favorAbleInfo=favorAbleInfoService.selectFavorAbleInfoByUid(uid);
		view.addObject("favorAbleInfo", favorAbleInfo); 
		return view;
	}
}