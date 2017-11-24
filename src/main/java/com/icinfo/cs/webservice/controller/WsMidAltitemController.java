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
import com.icinfo.cs.webservice.model.WsMidAltitem;
import com.icinfo.cs.webservice.service.IWsMidAltitemService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_mid_altitem 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
@Controller
@RequestMapping({"/webservice/midaltitem"})
public class WsMidAltitemController extends CSBaseController {
	
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidAltitemController.class);

    @Autowired
    private IWsMidAltitemService wsMidAltitemService;
    /**
     * 董事经理人员接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidaltitemList.json", "wsmidaltitemList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsaltitemList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsMidAltitem> altitemList = wsMidAltitemService.doGetWsMidAltitemListByContion(paramMap);
        return  AjaxResult.success("altitemList",altitemList);
    }
    
    /**
     * 统计董事经理人员表数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wsmidaltitemcount.json", "wsmidaltitemcount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsAltitemCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer altitemCount = wsMidAltitemService.doGetWsMidAltitemCountByContion(paramMap);
        return AjaxResult.success("统计数量",altitemCount);
    }
    
    /**
     * 董事经理人员接口--获取时间段内最大id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidaltitemMaxId.json", "wsmidaltitemMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsaltitemMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsMidAltitemService.doGetWsMidAltitemMaxId(paramMap);
        return  AjaxResult.success("maxId",maxId);
    }
    /**
     * 董事经理人员接口--获取时间段内最小id
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wsmidaltitemMinId.json", "wsmidaltitemMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsaltitemMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsMidAltitemService.doGetWsMidAltitemMinId(paramMap);
        return  AjaxResult.success("minId",minId);
    }
}