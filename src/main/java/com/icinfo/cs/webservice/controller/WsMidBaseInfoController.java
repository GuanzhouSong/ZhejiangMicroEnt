/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.controller;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.cs.webservice.service.IWsMidBaseInfoService;
import com.icinfo.framework.common.ajax.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_mid_baseinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年02月15日
 */
@Controller
@RequestMapping({ "/webservice/midbaseinfo"})
public class WsMidBaseInfoController  extends CSBaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidBaseInfoController.class);

    @Autowired
    private IWsMidBaseInfoService wsMidBaseInfoService;



    /**
     * 核准内容接口
     *startNum=0&pageSize=10&startdate=20161204120450&enddate=20161205120450
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/wsmidbaseinfoList.json", "wsmidbaseinfoList.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsBaseInfoList(HttpServletRequest req) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(req);
        List<WsMidBaseInfo> baseInfoList=wsMidBaseInfoService.doGetWsMidBaseInfoListByContion(paramMap);
        return  AjaxResult.success("baseInfoList",baseInfoList);
    }

    /**
     * 统计核准信息数量
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/wsmidbaseinfocount.json", "wsmidbaseinfocount.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsBaseInfoCount(HttpServletRequest req) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(req);
        Integer baseInfoCount = wsMidBaseInfoService.doGetWsMidBaseInfoCountByContion(paramMap);
        return AjaxResult.success("统计数量",baseInfoCount);
    }
    
    /**
     * 根据企业名称，内部序号返回数据
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/wsmidbaseinfoListByDatag.json", "wsmidbaseinfoListByDatag.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsBaseInfoListByDatag(HttpServletRequest req) throws Exception{
        List<WsMidBaseInfo> baseInfoList=wsMidBaseInfoService.doGetWsMidBaseInfoListByDatag(req.getParameter("priEnt"));
        return  AjaxResult.success("baseInfoList",baseInfoList);
    }
    
    /**
     * 核准内容接口--获取时间段内最大id
     *startdate=20161204120450&enddate=20161205120450
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/wsmidbaseinfoMaxId.json", "wsmidbaseinfoMaxId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsBaseInfoMaxId(HttpServletRequest req) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(req);
        Integer maxId = wsMidBaseInfoService.doGetWsMidBaseInfoMaxIdByContion(paramMap);
        return  AjaxResult.success("maxId",maxId);
    }
    
    /**
     * 核准内容接口--获取时间段内最小id
     *startdate=20161204120450&enddate=20161205120450
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping({ "/wsmidbaseinfoMinId.json", "wsmidbaseinfoMinId.xml" })
    @ResponseBody
    public AjaxResult doGetAjaxWsBaseInfoMinId(HttpServletRequest req) throws Exception{
        Map<String, Object> paramMap = doWrapperMapParam(req);
        Integer minId = wsMidBaseInfoService.doGetWsMidBaseInfoMinIdByContion(paramMap);
        return  AjaxResult.success("minId",minId);
    }
    

}