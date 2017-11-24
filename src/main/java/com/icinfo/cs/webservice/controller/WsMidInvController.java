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
import com.icinfo.cs.webservice.model.WsMidInv;
import com.icinfo.cs.webservice.service.IWsMidInvService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_mid_inv 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月16日
 */
@Controller
@RequestMapping({ "/webservice/midinv"})
public class WsMidInvController extends CSBaseController {
	
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidInvController.class);

    @Autowired
    private IWsMidInvService wsMidInvService;

    /**
     * 法定代表人接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidinvList.json", "wsmidinvList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsInvList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsMidInv> invList = wsMidInvService.doGetWsMidInvListByContion(paramMap);
        return  AjaxResult.success("invList",invList);
    }
    
    /**
     * 统计法定代表人表数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidinvcount.json", "wsmidinvcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsInvCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer invCount = wsMidInvService.doGetWsMidInvCountByContion(paramMap);
        return AjaxResult.success("统计数量",invCount);
    }
    
    /**
     * 根据pripid获取法定代表人列表接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidinvListByPripid.json", "wsmidinvListByPripid.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsInvListByPripid(HttpServletRequest request) throws Exception{
        List<WsMidInv> invList = wsMidInvService.doGetWsMidInvListByPripid(request.getParameter("pripid"));
        return  AjaxResult.success("invList",invList);
    }
    
    /**
     * 法定代表人接口--获取时间段内最大id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidinvMaxId.json", "wsmidinvMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsInvMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsMidInvService.doGetWsMidInvMaxId(paramMap);
        return  AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 法定代表人接口--获取时间段内最小id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidinvMinId.json", "wsmidinvMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsInvMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsMidInvService.doGetWsMidInvMinId(paramMap);
        return  AjaxResult.success("minId",minId);
    }
}