/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.controller.reg.server;

import com.icinfo.cs.registinfo.model.UlFind;
import com.icinfo.cs.registinfo.model.UlRecord;
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
 * 描述:    cs_ul_record 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Controller
@RequestMapping("/reg/server/registinfo/ulrecordinfo/")
public class UlRecordController extends BaseController {
    @Autowired
    UnlicensedInfoServiceImpl unlicensedInfoService;

    /**
     * 请求无证记录表格数据
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/recordList.json")
    @ResponseBody
    public PageResponse<UlRecord> recordList(PageRequest request) throws Exception {
        List<UlRecord> data = unlicensedInfoService.recodeInfoQueryPage(request);
        return new PageResponse<UlRecord>(data);
    }
}