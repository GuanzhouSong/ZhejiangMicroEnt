package com.icinfo.cs.upload.controller;

import com.icinfo.framework.core.web.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * excel 批量导入控制器
 *
 * Created by wangxiao on 2016/12/10.
 */
@Controller
@RequestMapping("/depsyn/excel")
public class ExcelUploadController extends BaseController {

    /**
     * 跳转至选择模板页面
     *
     * @return 页面
     */
    @RequestMapping(value = "/template", method = RequestMethod.GET)
    public String selectTemplate() {
        return "/depsyn/upload/excel_select";
    }

    /**
     * 跳转至下载模板页面
     *
     * @return 页面
     */
    @RequestMapping(value = "/download/{type}", method = RequestMethod.GET)
    public String downloadTemplate(@PathVariable("type") String type, HttpServletRequest request) {
        request.setAttribute("type", type);
        return "/depsyn/upload/excel_download";
    }

    /**
     * 跳转至模板确认页面
     *
     * @return 页面
     */
    @RequestMapping(value = "/confirm/{type}", method = RequestMethod.GET)
    public String confirmTemplate(@PathVariable("type") String type, HttpServletRequest request) {
        request.setAttribute("type", type);
        return "/depsyn/upload/excel_confirm";
    }
}
