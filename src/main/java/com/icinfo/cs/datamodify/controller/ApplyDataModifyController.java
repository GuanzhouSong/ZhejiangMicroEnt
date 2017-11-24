/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.datamodify.controller;

import com.icinfo.cs.common.utils.CsStringUtil;
import com.icinfo.cs.datamodify.model.ApplyDataModify;
import com.icinfo.cs.datamodify.service.IApplyDataModifyService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 描述:  cs_apply_data_modify 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年11月22日
 */
@Controller
@RequestMapping("/reg/server/datamodify")
public class ApplyDataModifyController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplyDataModifyController.class);

    @Autowired
    private IApplyDataModifyService applyDataModifyService;


    /**
     *@描述：显示数据列表
     *@author: wangjin
     *@date 2017-11-22 10:10
     *@return
     */
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView view = new ModelAndView("reg/server/datamodify/datamodify_server_list");
        return  view;
    }


    /**
     *@描述：获取数据
     *@author: wangjin
     *@date 2017-11-22 10:09
     *@return
     */
    @RequestMapping({"/list_json"})
    @ResponseBody
    public PageResponse<ApplyDataModify> list_json(PageRequest request)throws  Exception{
        List<ApplyDataModify> data = applyDataModifyService.search_result(request);
        return  new PageResponse<ApplyDataModify>(data);
    }



    /**
     *@描述：进入或数据列表页面
     *@author: wangjin
     *@date 2017-11-22 15:59
     *@return
     */
    @RequestMapping("/mid_data_list")
    public ModelAndView mid_data_list() throws Exception {
        ModelAndView mav = new ModelAndView("reg/server/datamodify/mid_data_list");
        return mav;
    }


    /**
     *@描述：提请数据修正页面
     *@author: wangjin
     *@date 2017-11-23 9:04
     *@return
     */
    @RequestMapping("/mid_data_edit")
    public ModelAndView mid_data_edit(String pripid ,String uniCode,String entName) throws Exception {
        ModelAndView view = new ModelAndView("reg/server/datamodify/mid_data_edit");
        view.addObject("uniCode",uniCode);
        view.addObject("pripid",pripid);
        view.addObject("entName",entName);
        return view;
    }

    /**
     *@描述：提请数据修正页面
     *@author: wangjin
     *@date 2017-11-23 9:04
     *@return
     */
    @RequestMapping("/mid_data_save")
    @ResponseBody
    public AjaxResult mid_data_save(ApplyDataModify applyDataModify) throws Exception {
        if(applyDataModifyService.save(applyDataModify)>0){
            return AjaxResult.success("保存成功!");
        }
        return AjaxResult.error("保存失败!");
    }


    /**
     *@描述：查看信息
     *@author: wangjin
     *@date 2017-11-23 9:04
     *@return
     */
    @RequestMapping("/mid_data_view")
    public ModelAndView mid_data_view(String uid) throws Exception {
        ModelAndView view = new ModelAndView("reg/server/datamodify/mid_data_view");
        if(CsStringUtil.isNotBlank(uid)){
            ApplyDataModify applyDataModify = applyDataModifyService.selectByUid(uid);
            view.addObject("applyDataModify",applyDataModify);
        }
        return view;
    }






}