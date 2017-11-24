/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.framework.core.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 描述:    cs_code_dutydept 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
@Controller
@RequestMapping("/common/system/code_duty_dept")
public class CodeDutydeptController extends BaseController {

    @Autowired
    private ICodeDutydeptService codeDutydeptService;


    /**
     *
     * 描述:跳转到职能部门编码选择页面
     * @author ZhuDefeng
     * @date 2016年10月19日
     * @param
     * @return ModelAndView
     * @throws
     */
    @RequestMapping("/duty_dept_select")
    public ModelAndView allDeptCheckBoxTreePage(String treeType,String deptDutyCodes) throws Exception{
        ModelAndView view  = new ModelAndView("/common/select/duty_dept_select");
        view.addObject("treeType",treeType);
        view.addObject("deptDutyCodes",deptDutyCodes);
        return view;
    }

    /**
     * 获取职能部门编码树数据
     *
     * @author ZhuDefeng
     * @date 2016-11-21
     * @return
     * @throws Exception
     */
    @RequestMapping("/tree")
    @ResponseBody
    public List<CodeDutydept> deptTree(String selectedCodes)throws Exception{
        return codeDutydeptService.doSelectAllDutyCodes(selectedCodes);
    }

}