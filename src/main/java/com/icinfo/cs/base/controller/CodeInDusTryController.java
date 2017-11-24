/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.base.service.ICodeInDusTryService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_code_industry 对应的Controller类.<br>
 *
 * @author liuhq
 * @date 2016年10月17日
 */
@Controller
@RequestMapping("/commom/server/industry/")
public class CodeInDusTryController extends BaseController {
    @Autowired
    private ICodeInDusTryService codeInDusTryService;
    /**
     *
     * 描述: to行业树页面
     * @auther liuhq
     * @date 2016年11月2日
     * @return
     * @throws Exception
     */
    @RequestMapping("toIndustryPhyTree")
    public ModelAndView toIndustryPhyNoCheck(String smFlag,String indType)throws Exception{
        ModelAndView view=new ModelAndView("/common/select/industryphyselectnocheck");
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
    @RequestMapping("/treeIndustryListJSON")
    @ResponseBody
    public AjaxResult treeIndustryListNoCheckJSON(String smFlag,String indType,String content)throws Exception{
    	List<Map<String,Object>> data = new ArrayList<Map<String,Object>>();
    	if(StringUtil.isNotBlank(smFlag)){
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("indType",indType);
    		data = codeInDusTryService.selectToSmTreeMap(map);
    	}else{
    		Map<String,Object> map = new HashMap<String,Object>();
    		map.put("content",content);
            data=codeInDusTryService.selectToTreeMap(map);
    	}
        return AjaxResult.success("查询成功",data);
    }
}