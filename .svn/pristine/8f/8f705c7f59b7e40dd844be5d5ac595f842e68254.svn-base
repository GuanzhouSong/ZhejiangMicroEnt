/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.webservice.model.WsMidMember;
import com.icinfo.cs.webservice.service.IWsMidMemberService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_mid_member 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Controller
@RequestMapping({"/webservice/midmember"})
public class WsMidMemberController extends CSBaseController {
	
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidMemberController.class);

    @Autowired
    private IWsMidMemberService wsMidMemberService;
    /**
     * 董事经理人员接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidmemberList.json", "wsmidmemberList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsmemberList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsMidMember> memberList = wsMidMemberService.doGetWsMidMemberListByContion(paramMap);
        return  AjaxResult.success("memberList",memberList);
    }
    
    /**
     * 统计董事经理人员表数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidmembercount.json", "wsmidmembercount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsMemberCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer memberCount = wsMidMemberService.doGetWsMidMemberCountByContion(paramMap);
        return AjaxResult.success("统计数量",memberCount);
    }
    
    /**
     * 董事经理人员接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidmemberListByPripid.json", "wsmidmemberListByPripid.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsmemberListByPripid(HttpServletRequest request) throws Exception{
        List<WsMidMember> memberList = wsMidMemberService.doGetWsMidMemberListByPripid(request.getParameter("pripid"));
        return  AjaxResult.success("memberList",memberList);
    }
    
    /**
     * 统计董事经理人员表--获取时间段内最大id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidmemberMaxId.json", "wsmidmemberMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsMemberMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsMidMemberService.doGetWsMidMemberMaxId(paramMap);
        return AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 统计董事经理人员表--获取时间段内最小id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidmemberMinId.json", "wsmidmemberMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsMemberMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsMidMemberService.doGetWsMidMemberMinId(paramMap);
        return AjaxResult.success("minId",minId);
    }
}