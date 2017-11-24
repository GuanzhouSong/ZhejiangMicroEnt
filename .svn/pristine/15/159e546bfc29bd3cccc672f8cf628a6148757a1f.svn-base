/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.base.service.ICodeStreetService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_code_street 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月28日
 */
@Controller
@RequestMapping("/commom/server/codestreet/")
public class CodeStreetController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeStreetController.class);

    @Autowired
    private ICodeStreetService codeStreetService;

    /**
     *
     * 描述: to街道树状选择页面
     * @auther liuhq
     * @date 2016年10月27日
     * @return
     * @throws Exception
     */
    @RequestMapping("/streetselect")
    public ModelAndView toStreetTreeView()throws Exception{
        ModelAndView view=new ModelAndView("/common/select/streetmutiselect");
        return view;
    }
    /**
     *
     * 描述: to只选择街道页面
     * @auther ljx
     * @date 2016年11月2日
     * @return
     * @throws Exception
     */
    @RequestMapping("/streetmutiselectnocheck")
    public ModelAndView toStreetTreeNoCheckView()throws Exception{
        ModelAndView view=new ModelAndView("/common/select/streetmutiselectnocheck");
        return view;
    }
    /**
     *
     * 描述: 街道json
     * @auther liuhq
     * @date 2016年10月19日
     * @return
     * @throws Exception
     */
    @RequestMapping("/treeStreetListJSON")
    @ResponseBody
    public AjaxResult treeStreetListJSON()throws Exception{
        List<Map<String,Object>> data=codeStreetService.selectToTreeMap();
        return AjaxResult.success("查询成功",data);
    }
    /**
     *
     * 描述: 只选择街道
     * @auther ljx
     * @date 2016年11月2日
     * @return
     * @throws Exception
     */
    @RequestMapping("/treeStreetListNoCheckJSON")
    @ResponseBody
    public AjaxResult treeStreetListNoCheckJSON()throws Exception{
        List<Map<String,Object>> data=codeStreetService.selectToTreeNoCheckMap();
        return AjaxResult.success("查询成功",data);
    }
}