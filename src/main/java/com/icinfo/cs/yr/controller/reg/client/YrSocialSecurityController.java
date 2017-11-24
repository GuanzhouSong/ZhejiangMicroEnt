/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.*;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.tools.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * 描述:  cs_yr_social_security 对应的Controller类.<br>
 * 表：社保信息表 (cs_yr_social_security)
 * @author framework generator
 * @date 2016年11月21日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/yrsocialsecurity")
public class YrSocialSecurityController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(YrSocialSecurityController.class);

    @Autowired
    private IYrSocialSecurityService yrSocialSecurityService;
    @Autowired
    private IYrBaseInfoService yrBaseInfoService;
    @Autowired
    private IYrRegCheckService yrRegCheckService;
    @Autowired
    private IYrFormService yrFormService;
    @Autowired
    IYrAssetService yrAssetService;
    @Autowired
    private ISignatureService signatureService;

    /**
     *  页面显示
      * @param year
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/show")
    public ModelAndView show(String year, HttpSession session) throws Exception{

        ModelAndView view = new ModelAndView("reg/client/yr/socialsecurity/socialsecurity_edit");
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
        String priPID =midBaseInfoDto.getPriPID();// 获取主体身份代码
        //判断传递的参数是否为空
        if(StringUtil.checkYearAndPripid(year,priPID)) {

            String encodeYear = year;          //接收加密年份
            year = AESEUtil.decodeYear(year);   //年份进行解密

            //社保信息
            if (StringUtils.isNotEmpty(year)) {
                view.addObject("yrSocialSecurity", yrSocialSecurityService.selectByYearAndPripid(Integer.valueOf(year), priPID));
            }

            //获取年报anCheID
            YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
            if (yrBaseInfo != null) {
                if (StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())) {
                    view.addObject("anCheID", yrBaseInfo.getAnCheID());
                }
            }

            //查询企业从业人数
            YrAsset yrAsset = yrAssetService.selectByYearAndPripid(Integer.valueOf(year), priPID);
            if (yrAsset != null) {
                view.addObject("empNum", yrAsset.getEmpNum()); //获取从业人数
            }
            //查询年报主表信息
            YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
            //获取表单填写的状态
            YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

            //获取电子公章图片字符串路径
            Signature signature = signatureService.selectByYearAndPripid(year,priPID);
            if(signature!=null&&StringUtils.isNotBlank(signature.getTextCode())){
                view.addObject("qzImgBase64", signature.getTextCode());
            }

            view.addObject("year", year);
            view.addObject("encodeYear", encodeYear);  //年份进行加密
            view.addObject("priPID", priPID);
            view.addObject("tabName", RepTypeUtil.formSocialSecurity);// 年报 社保信息
            view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
            view.addObject("yrForm", yrForm);
        }

        return view;
    }


    /**
     * 保存和更新操作
     * @autor: wangjin
     * @param yrSocialSecurity
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save(YrSocialSecurity yrSocialSecurity) throws Exception {
        if(StringUtil.checkYearAndPripid(yrSocialSecurity.getYear(),yrSocialSecurity.getPriPID())) {

            YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(yrSocialSecurity.getPriPID(), yrSocialSecurity.getYear());

            //更新
            if (StringUtils.isNotEmpty(yrSocialSecurity.getSocialID())) {
                if (yrSocialSecurityService.update(yrSocialSecurity) > 0) {

                    if(yrForm!=null&&!"1".equals(yrForm.getSocialSecurity())){
                        yrForm.setSocialSecurity("1");//已填报
                        yrFormService.updateForm(yrForm);//更新填报表单状态
                    }
                    return AjaxResult.success("保存成功!");
                } else {
                    return AjaxResult.error("保存失败!");
                }
            }
            //新增
            if (yrSocialSecurityService.insert(yrSocialSecurity) > 0) {
                if (yrForm != null) {
                    yrForm.setSocialSecurity("1");//已填报
                    yrFormService.updateForm(yrForm);//更新填报表单状态
                }
                return AjaxResult.success("保存成功!", yrSocialSecurity.getSocialID());
            } else {
                return AjaxResult.error("保存失败!");
            }
        }
        return AjaxResult.error("参数为空,执行失败!");
    }


}