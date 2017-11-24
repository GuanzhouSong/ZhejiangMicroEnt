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
import com.icinfo.cs.webservice.model.WsPubOpanomaly;
import com.icinfo.cs.webservice.service.IWsPubOpanomalyService;
import com.icinfo.framework.common.ajax.AjaxResult;

/**
 * 描述:    cs_pub_opanomaly 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月22日
 */
@Controller
@RequestMapping({"/webservice/pubopanomaly"})
public class WsPubOpanomalyController extends CSBaseController {
	/**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsPubOpanomalyController.class);

    @Autowired
    private IWsPubOpanomalyService wsPubOpanomalyService;
    /**
     * 列入经营异常名录接口
     * @param request
     * @author ylr
     * @throws Exception
     */
    @RequestMapping({ "/wspubopanomalyList.json", "wspubopanomalyList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWssupList(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        List<WsPubOpanomaly> nomList = wsPubOpanomalyService.doGetWsPubOpanomalyListByContion(paramMap);
        return  AjaxResult.success("nomList",nomList);
    }
    
    /**
     * 列入经营异常名录数量
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopanomalycount.json", "wspubopanomalycount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupCount(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer nomCount = wsPubOpanomalyService.doGetWsPubOpanomalyCountByContion(paramMap);
        return AjaxResult.success("统计数量",nomCount);
    }
    
    /**
     * 列入经营异常名录--获取时间段内最大id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopanomalyMaxId.json", "wspubopanomalyMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMaxId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer maxId = wsPubOpanomalyService.doGetWsPubOpanomalyMaxId(paramMap);
        return AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 列入经营异常名录--获取时间段内最小id
     * @author ylr
     * @param req
     * @throws Exception
     */
    @RequestMapping({ "/wspubopanomalyMinId.json", "wspubopanomalyMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsSupMinId(HttpServletRequest request) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(request);
        Integer minId = wsPubOpanomalyService.doGetWsPubOpanomalyMinId(paramMap);
        return AjaxResult.success("minId",minId);
    }
}