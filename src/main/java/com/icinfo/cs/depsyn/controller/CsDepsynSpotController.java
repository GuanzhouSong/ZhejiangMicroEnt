/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.controller;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.depsyn.constant.DepSynConstant;
import com.icinfo.cs.depsyn.model.CsDepsynSpot;
import com.icinfo.cs.depsyn.service.ICsDepsynSpotService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
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
import java.util.Map;

/**
 * 描述:    cs_depsyn_spot 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
@Controller
@RequestMapping("/depsyn/spot")
public class CsDepsynSpotController extends BaseController {

    @Autowired
    private ICsDepsynSpotService csDepsynSpotService;

    /**
     * 在线录入抽查检查页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws Exception {
        return "depsyn/spot/spot_main";
    }

    /**
     * 根据企业名称或注册号或统一社会信用代码查询抽查检查数据
     *
     * @param request 请求对象
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, Object> query(HttpServletRequest request, HttpSession session) throws Exception {
        Map<String, Object> params = RequestUtil.getHttpRequestParams(request);
        params.put("deptCode", ((SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER)).getDepSynName());
        return csDepsynSpotService.querySpot(params);
    }

    /**
     * 新增页面
     *
     * @return 页面
     * @throws Exception
     */
    @RequestMapping(value = "/toadd", method = RequestMethod.GET)
    public String toAdd() throws Exception {
        return "depsyn/spot/spot_add";
    }

    /**
     * 新增
     *
     * @param csDepsynSpot 抽查检查
     * @return 结果
     * @throws Exception
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public AjaxResult add(@RequestBody CsDepsynSpot csDepsynSpot, HttpSession session) throws Exception {
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);

        csDepsynSpot.setInputDepCode(sysUser.getDepSynName());
        csDepsynSpot.setInputDate(new Date());
        csDepsynSpot.setProType(DepSynConstant.PRO_TYPE_ZXLR);

        Calendar c = Calendar.getInstance();
        c.setTime(csDepsynSpot.getInputDate());
        csDepsynSpot.setYear(String.valueOf(c.get(Calendar.YEAR)));
        csDepsynSpot.setAdcode(sysUser.getSysDepart().getAdcode());

        int result = csDepsynSpotService.addSpot(csDepsynSpot);
        if(result > 0) {
            return AjaxResult.success("新增成功");
        } else {
            return AjaxResult.error("新增失败");
        }
    }
}