/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.controller.reg.client;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.Bulletins;
import com.icinfo.cs.yr.service.IBulletinsService;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_bulletins 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
@Controller("ClientBulletinsController")
@RequestMapping("/reg/client/login/bulletins/")
public class BulletinsController extends BaseController {
	
	
	@Autowired 
	IBulletinsService bulletinsService;

	
	/**
	 * 
	 * 描述: 企业端公告列表数据查询
	 * @auther gaojinling
	 * @date 2016年12月5日 
	 * @param request
	 * @param session
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping({"list.json","list.xml"})
	@ResponseBody
	public PageResponse<Bulletins> listJSON(PageRequest request) throws SQLException{
		List<Bulletins> bulletinslist=  bulletinsService.selectBulletinsClientList(request);
		return new PageResponse<Bulletins>(bulletinslist);
	}
	
   /**
    * 
    * 描述:  企业端查看公告列表页面
    * @auther gaojinling
    * @date 2016年12月5日 
    * @return
    * @throws SQLException
    */
	@RequestMapping("list")
	public  ModelAndView toList() throws SQLException{
		ModelAndView mav= new ModelAndView("/reg/client/login/bulletins_clientlist");
		return mav;
	}
	
	/**
	 * 
	 * 描述: 企业端登录页查看公告详情页
	 * @auther gaojinling
	 * @date 2016年12月5日 
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	@RequestMapping("detail")
	public  ModelAndView toSee(String uid) throws SQLException{
		ModelAndView mav = new ModelAndView("/reg/client/login/bulletins_clientdetail");
		Bulletins bulletins = bulletinsService.selectByUID(uid);
		mav.addObject("Bulletins", bulletins);
		if(bulletins != null && StringUtil.isNotEmpty(bulletins.getUID())){//更新阅读量
			Bulletins Readbulletins = new Bulletins();
			Readbulletins.setUID(bulletins.getUID());
			Readbulletins.setReadCount(bulletins.getReadCount()+1);  //阅读量加1
			bulletinsService.updateBulletins(Readbulletins);
		}
		return mav;
	}
	
	
	
}