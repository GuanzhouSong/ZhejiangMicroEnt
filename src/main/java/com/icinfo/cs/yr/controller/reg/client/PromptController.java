package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.framework.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述 提示页面、
 * @author：wangjin
 */
@Controller
@RequestMapping("/prompt")
public class PromptController extends BaseController {
    /**
     * 描述：友好提示页面
     * @author:wanjgin
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show() throws Exception {
        ModelAndView view = new ModelAndView("prompt");
        return view;
    }

}
