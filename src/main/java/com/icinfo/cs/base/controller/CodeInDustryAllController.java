/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.base.service.ICodeInDustryAllService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_industry 对应的Controller类.<br>
 *
 * @author liuhq
 * @date 2016年10月17日
 */
@Controller
@RequestMapping("/commom/server/industryall/")
public class CodeInDustryAllController extends BaseController {
    @Autowired
    private ICodeInDustryAllService codeInDustryAllService;
    /**
     *
     * 描述: to行业树页面
     * @auther liuhq
     * @date 2016年11月2日
     * @return
     * @throws Exception
     */
    @RequestMapping("toIndustryAllTree")
    public ModelAndView toIndustryPhyNoCheck(String smFlag,String indType)throws Exception{
        ModelAndView view=new ModelAndView("/common/select/industryallselectnocheck");
        view.addObject("smFlag", smFlag);
        view.addObject("indType", indType);
        return view;
    }

    /**
     *
     * 描述: 行业树不级联选择json
     * @auther liuhq
     * @date 2016年11月2日
     * @return
     * @throws Exception
     */
    @RequestMapping("/list.json")
    @ResponseBody
    public AjaxResult list(String smFlag,String indType)throws Exception{
    	List<Map<String,Object>> data =  codeInDustryAllService.selectToTreeMap();
        return AjaxResult.success("查询成功",data);
    }
}