/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.controller;

import com.icinfo.cs.base.dto.SelectCodeAddress;
import com.icinfo.cs.base.service.ICodeAddressService;
import com.icinfo.cs.common.utils.AddressUtil;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述:  cs_code_address 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年01月20日
 */
@Controller
@RequestMapping({"/reg/client/yr/SelectCodeAddress","/reg/server/yr/SelectCodeAddress"})
public class CodeAddressController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeAddressController.class);

    @Autowired
    private ICodeAddressService codeAddressService;

    @RequestMapping("/show")
    public ModelAndView show() throws Exception{
        ModelAndView view = new ModelAndView("reg/client/yr/tools/codeAddress");
        return view;
    }

    /**
     * 保存和更新操作
     * @autor:wangjin
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getJson", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult getJson(String code) throws Exception {

        SelectCodeAddress selectCodeAddress = null;

        //SelectCodeAddress selectCodeAddress = codeAddressService.selectBycodeAddress();
        //获取对象中的值
        selectCodeAddress = (SelectCodeAddress) AddressUtil.getAddressMapValue().get("address");

        //JSON.toJSONString(select,true);//
        //3.另一个重载方法是JSON.toJsonString(list，true)，增加true参数，表示格式化漂亮的输出json字符串，期间会有/t/n等转义字符

        return AjaxResult.success("执行成功！",selectCodeAddress);
    }

    /**
     * 描述：清空初始化中的map的值,并赋予最新值
     * @return
     */
    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult  Refresh(){
        try {
            AddressUtil.changAddresMap();
            return AjaxResult.success("刷新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
            return AjaxResult.error("执行失败");
    }

}