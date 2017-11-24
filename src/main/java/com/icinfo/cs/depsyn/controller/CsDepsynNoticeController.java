/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.depsyn.model.CsDepsynNotice;
import com.icinfo.cs.depsyn.service.ICsDepsynNoticeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_notice 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Controller
@RequestMapping("/depsyn/notice")
public class CsDepsynNoticeController extends BaseController {

    @Autowired
    private ICsDepsynNoticeService csDepsynNoticeService;

    /**
     * 在线录入部门公告
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws Exception {
        return "depsyn/notice/notice_main";
    }

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param request 请求对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public PageResponse<CsDepsynNotice> query(HttpServletRequest request, HttpSession session) throws Exception {
        Map<String, Object> params = RequestUtil.getHttpRequestParams(request);
        params.put("deptCode", ((SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER)).getDepSynName());
        List<CsDepsynNotice> list = csDepsynNoticeService.queryNotice(params);
        return new PageResponse<>(list);
    }

    /**
     * 新增
     *
     * @param file
     * @param csDepsynNotice
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult add(@RequestParam(value = "file") MultipartFile file, CsDepsynNotice csDepsynNotice, HttpSession session) throws Exception {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

        csDepsynNotice.setInputDepCode(sysUser.getDepSynName());
        csDepsynNotice.setInputDate(new Date());

        Calendar c = Calendar.getInstance();
        c.setTime(csDepsynNotice.getInputDate());
        csDepsynNotice.setYear(String.valueOf(c.get(Calendar.YEAR)));
        csDepsynNotice.setAdcode(sysUser.getSysDepart().getAdcode());

        int result = csDepsynNoticeService.addNotice(csDepsynNotice);
        if (result > 0) {
            return AjaxResult.success("新增成功");
        } else {
            return AjaxResult.error("新增失败");
        }
    }
}