/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.sment.dto.EntarchivesHisDto;
import com.icinfo.cs.sment.service.IEntarchivesHisService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives_his 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Controller
@RequestMapping("/sment/entarchives")
public class EntarchivesHisController extends CSBaseController {

    @Autowired
    IEntarchivesHisService entarchivesHisService;

    /**
     * 进入培育库历史档案
     * @author zjj
     * 20170508
     */
    @RequestMapping("enEntarchivesHisList")
    public String enEntarchivesHisList() throws Exception{
        return "sment/entarchives/entarchives_his_list";
    }

    /**
     * 获取历史数据
     * #@author zjj
     * 20170508
     */
//    @RequestMapping({ "/doGetEntarchivesHisList.json", "list.xml" })
//    @ResponseBody
//    public PageResponse<EntarchivesHisDto> doGetEntarchivesHisList(PageRequest request) throws Exception{
//        creatDefaultDBAuthEnv (request, "sb.RegOrg", "sb.LocalAdm");
//        List<EntarchivesHisDto> entarchivesHis = entarchivesHisService.queryPage (request);
//        return new PageResponse<EntarchivesHisDto> (entarchivesHis);
//    }
    
    
    /** 
     * 描述: 根据部门code获取已注销企业数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param session
     * @param cultivationTypeCode
     * @return 
     */
    
    @RequestMapping(value = "countZx.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult countZx(HttpSession session,String cultivationTypeCode){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            return AjaxResult.success ("操作成功！",entarchivesHisService.count (sysUser));
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

    /**
     * 描述: 根据部门code获取已注销企业列表
     * @author 张文男
     * @date 2017年6月23日
     * @param session
     * @param cultivationTypeCode
     * @return
     */

    @RequestMapping(value = "select.json",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult select(HttpSession session,String cultivationTypeCode){
        try {
            SysUserDto sysUser = (SysUserDto) session.getAttribute (Constants.SESSION_SYS_USER);
            return AjaxResult.success ("操作成功！",entarchivesHisService.count (sysUser));
        } catch (Exception e) {
            e.printStackTrace ();
        }
        return AjaxResult.error ("操作失败！");
    }

}