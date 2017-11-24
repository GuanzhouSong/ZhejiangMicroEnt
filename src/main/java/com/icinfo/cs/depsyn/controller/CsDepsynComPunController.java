/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.depsyn.constant.DepSynConstant;
import com.icinfo.cs.depsyn.dto.CsDepsynComPunDto;
import com.icinfo.cs.depsyn.model.CsDepsynComPun;
import com.icinfo.cs.depsyn.service.ICsDepsynComPunService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_com_pun 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Controller
@RequestMapping("/depsyn/compun")
public class CsDepsynComPunController extends BaseController {

    @Autowired
    private ICsDepsynComPunService csDepsynComPunService;

    /**
     * 在线录入联合惩戒
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws Exception {
        return "depsyn/compun/compun_main";
    }

    /**
     * 根据证照号码/证件号码, 姓名查询
     *
     * @param request 请求对象
     * @return 查询结果
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public PageResponse<CsDepsynComPunDto> query(HttpServletRequest request, HttpSession session) throws Exception {
        Map<String, Object> params = RequestUtil.getHttpRequestParams(request);
        params.put("deptCode", ((SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER)).getDepSynName());
        List<CsDepsynComPunDto> list = csDepsynComPunService.queryComPun(params);
        return new PageResponse<>(list);
    }

    /**
     * 新增页面
     *
     * @return 页面
     * @throws Exception
     */
    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAdd() throws Exception {
        return "depsyn/compun/compun_add";
    }

    /**
     * 新增
     *
     * @param csDepsynComPun
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult add(@RequestBody CsDepsynComPun csDepsynComPun, HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

        csDepsynComPun.setInputDepCode(sysUser.getDepSynName());
        csDepsynComPun.setInputDate(new Date());
        csDepsynComPun.setProType(DepSynConstant.PRO_TYPE_ZXLR);

        Calendar c = Calendar.getInstance();
        c.setTime(csDepsynComPun.getInputDate());
        csDepsynComPun.setYear(String.valueOf(c.get(Calendar.YEAR)));
        csDepsynComPun.setAdcode(sysUser.getSysDepart().getAdcode());

        int result = csDepsynComPunService.addComPun(csDepsynComPun);
        if(result > 0) {
            return AjaxResult.success("新增成功");
        } else {
            return AjaxResult.error("新增失败");
        }
    }
}