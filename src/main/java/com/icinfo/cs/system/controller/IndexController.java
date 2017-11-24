/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;

import java.util.*;

import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.sccheck.dto.SccheckCount;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.system.dto.BulletinsReadRecordDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.yr.service.IModApplicationService;
import com.icinfo.cs.yr.service.IYrRegCheckService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 描述: 系统管理首页控制器 .<br>
 *
 * @author xiajunwei
 * @date 2016年3月15日
 */
@Controller
@RequestMapping("/reg")
public class IndexController extends CSBaseController {
    private static Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    @Autowired
    private IModApplicationService modApplicationService;
    @Autowired
    private IPubOpaDetailService pubOpaDetailService;
    @Autowired
    private TokenManager tokenManager;
    @Autowired
    private IRegIndexService regIndexService;
    @Autowired
    private IPubScPlanTaskService pubScPlanTaskService;
    @Autowired
    private IPubScentResultService pubScentResultService;
    @Autowired
    private ICodeDutydeptService codeDutydeptService;
   
    

    /**
     * 管理端首页
     *
     * @param session
     * @return
     */
    @RequestMapping
    public ModelAndView index(HttpSession session) {
        ModelAndView view = new ModelAndView("index");
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        if (userProfile != null) {
            //用户显示菜单
            view.addObject("menus", userProfile.getMenus());
            view.addObject("userProfile", userProfile);
        }
        return view;
    }

    /**
     * 管理中心首页
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/dashboard")
    public String dashboard(HttpServletRequest request, HttpServletResponse response) {
        return "/dashboard/dashboard";
    }
    
    /**
     * 
     * 描述: 警示端内置首页
     * @auther gaojinling
     * @date 2017年3月17日 
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/ifrindex")
    public ModelAndView ifrindex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView view = new ModelAndView("/reg/server/index");
        SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
        view.addObject("userVest",sysUser.getUserVest(sysUser));
        view.addObject("rptzqDate", DateUtil.getCurrentTime());
        view.addObject("rptDate", DateUtil.getNdaylater2(DateUtil.getSysDate(), -1)); 
    	return view;
     } 
    
    
    /**
    * 
    * 描述: 获取统计数据
    * @auther gaojinling
    * @date 2017年3月17日 
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping({"/countlist.json", "list.xml"})
    @ResponseBody
    public AjaxResult doReadBulletins(PageRequest request)throws Exception{
		//session中获取当前登录用户
        SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
		String regOrg = selectRegorgByDeptCode(sysUser);
		List<Integer> countList = new ArrayList<Integer>();	
    	//统计map
        Map<String, Object> forBidmap = new HashMap<String, Object>();
        forBidmap.put("regOrg", regOrg);
        //操作权限添加
        creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
//        countList = regIndexService.getRegCountList(sysUser.getId(), forBidmap);

//        String refreshFlag = request.getParams().get("refreshFlag").toString();
//        if("0".equals(refreshFlag)){//首次加载，重新设置
//        	countList = regIndexService.getCount(forBidmap, sysUser);
//			tokenManager.setRegCountToken(sysUser.getId(), countList);
//        }else{
            countList = regIndexService.getRegCountList(sysUser.getId(), forBidmap,sysUser);
//        }
        //检查人员待抽取 17
       int toExtractCount  =pubScPlanTaskService.selectPubScPlanTaskToExtractCount(sysUser);
       //检查结果待录入,检查结果待审核（不包含检查）18
       SccheckCount sccheckCount = pubScentResultService.selectSccheckCount(sysUser);
      //检查（补报核查项）19
//      int noInput = reportCheckInfoService.selectNeedToInputCountForCheck(forBidmap); //待录入
//      int auditCount = reportCheckInfoService.selectNeedToAuditCountForCheck(forBidmap); //待审核
        countList.add(toExtractCount);
        countList.add(sccheckCount == null ? 0 : sccheckCount.getNotInputNum());
        countList.add(sccheckCount == null ? 0 : sccheckCount.getToCheckNum());
        
        return  AjaxResult.success("countList",countList);
    }

    /**
     *@描述： 可视化图形页面
     *@author: wangjin
     *@date 2017-07-27 14:51
     *@return
     * @throws Exception 
     */
    @RequestMapping("/charts")
    public ModelAndView charts(String tabId) throws Exception {
        ModelAndView view = new ModelAndView("/reg/server/charts/charts_view");
        view.addObject("serverDate",DateUtil.formatDate(new Date()));//系统年月日
        view.addObject("yearAndMonth",DateUtil.getCurrentYearAndMonth());//系统年份和月份
        view.addObject("month",DateUtil.getCurrentMonth());         //系统月份
        view.addObject("reportYear",DateUtil.getCurrentYear());      //当前系统年份
        view.addObject("serverPreDate",DateUtil.getPreDate());      //当前系统前一天日期
        view.addObject("yearList",DateUtil.getYearDescList());      //获取倒序的年份列表
        view.addObject("curyearList",DateUtil.getcurYearDescList());    //获取倒序的13-当前的年份列表
        view.addObject("tabId",tabId);                              //获取选中的tab标签
        view.addObject("dutyCodeList", codeDutydeptService.doSelectAllDutyCodes(null));
        return view;
    }



}
