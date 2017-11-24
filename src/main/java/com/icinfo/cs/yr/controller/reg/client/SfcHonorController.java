/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.SfcHonor;
import com.icinfo.cs.yr.service.ISfcHonorService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * 描述:  cs_sfc_honor 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
@Controller
@RequestMapping("/reg/client/yr/sfc/honor")
public class SfcHonorController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SfcHonorController.class);

    @Autowired
    private ISfcHonorService sfcHonorService;


    /**
     * 获取荣誉数据列表
     * @author: wangjin
     * @return
     * @throws Exception
     */
    @RequestMapping({"/list_json"})
    @ResponseBody
    public PageResponse<SfcHonor> list_json(PageRequest request) throws Exception {
        List<SfcHonor> data = sfcHonorService.select_queryPage(request);//执行参数条件查询
        return new PageResponse<SfcHonor>(data);
    }



    /**
     * 保存和更新操作
     * @autor:  wangjin
     * @param sfcHonor
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save( SfcHonor sfcHonor) throws Exception {
        if(StringUtil.checkYearAndPripid(sfcHonor.getYear(),sfcHonor.getPriPID())) {
            if (StringUtil.isNotEmpty(sfcHonor.getUid())) {
                if (sfcHonorService.update(sfcHonor) > 0) {     //只更新改变的值,没有改变的值不进行更新操作
                    return AjaxResult.success("更新成功!");
                } else {
                    return AjaxResult.error("更新失败!");
                }
            }
            if (sfcHonorService.insert(sfcHonor) > 0) {
                return AjaxResult.success("保存成功!");
            } else {
                return AjaxResult.error("保存失败!");
            }
        }
        return  AjaxResult.error("参数为空,执行失败!");

    }

    /**
     * 保存和更新操作页面
     * @autor wangjin
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/edit_show", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult edit_show(String uid,HttpSession session) throws Exception {
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
        if(StringUtil.isNotEmpty(uid)&&StringUtil.isNotEmpty(priPID)){
            return AjaxResult.success("success",sfcHonorService.selectByUid(uid,priPID));
        }
        return AjaxResult.error("fail!");
    }


    /**
     * 删除 操作
     * @autor wangjin
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult batch_delete(String uid,HttpSession session) throws Exception {
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID = midBaseInfoDto.getPriPID(); //获取主体身份代码
        if(StringUtil.isNotEmpty(priPID)){
            String  uids[]=uid.split(",");
            List<String> list_uids= Arrays.asList(uids);
            if(StringUtil.isNotEmpty(uid)){
                if(sfcHonorService.batch_delete(list_uids,priPID)>0){
                    return AjaxResult.success("删除成功!");
                }
            }
        }
        return AjaxResult.error("删除失败!");
    }


}