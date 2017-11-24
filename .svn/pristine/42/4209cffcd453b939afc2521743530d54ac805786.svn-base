/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import com.icinfo.cs.registinfo.model.UlManage;
import com.icinfo.cs.registinfo.service.impl.UnlicensedInfoServiceImpl;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:    cs_ul_manage 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/registinfo/ulmanageinfo/")
public class UlManageController extends BaseController {
    @Autowired
    UnlicensedInfoServiceImpl unlicensedInfoService;
    /**
     * 请求无证处理记录表格数据
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/manageList.json")
    @ResponseBody
    public PageResponse<UlManage> manageList(PageRequest request) throws Exception {
        List<UlManage> data = unlicensedInfoService.manageInfoQueryPage(request);
        return new PageResponse<UlManage>(data);
    }
}