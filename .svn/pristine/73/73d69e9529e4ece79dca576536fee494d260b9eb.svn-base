/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.service.IYrSocialSecurityService;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 描述:  cs_yr_social_security 对应的Controller类.<br>
 * 表：社保信息表 (cs_yr_social_security)
 * @author framework generator
 * @date 2016年11月21日
 */
@Controller
@RequestMapping("/reg/server/yr/yrsocialsecurity_server")
public class YrSocialSecurityServerController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(YrSocialSecurityServerController.class);

    @Autowired
    private IYrSocialSecurityService yrSocialSecurityService;


    @RequestMapping("/view")
    public ModelAndView show(String year,String priPID) throws Exception{
        ModelAndView view = new ModelAndView("reg/server/search/entreportsearch/yrreport/socialsecurity_view");
        if(StringUtil.checkYearAndPripid(year,priPID)){
            view.addObject("yrSocialSecurity",yrSocialSecurityService.selectByYearAndPripid(Integer.valueOf(year),priPID));
        }
        return view;
    }




}