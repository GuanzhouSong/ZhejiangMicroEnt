/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetDto;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.cs.yr.model.YrBaseInfo;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.*;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

 /**
  * 
  * 描述: 分支机构经营情况对应控制lei <br>
  * @author ljx
  * @date 2016年10月8日
  */
@Controller
@RequestMapping("/reg/client/yr/ent/yrassetbranch")
public class YrAssetBranchController extends BaseController {

     @Autowired
     private IYrAssetService yrAssetService;
     @Autowired
     private IYrFormService yrFormService;
     @Autowired
     private IYrBaseInfoService yrBaseInfoService;
     @Autowired
     private IYrRegCheckService yrRegCheckService;
     @Autowired
     private ISignatureService signatureService;
     //登录时企业放进session的key
     private final String SESSION_MIDBASEINFODTO = "midBaseInfoDto";


     /**
      * 描述: 显示分支机构经营情况
      *
      * @param year
      * @return
      * @throws Exception
      * @auther wangjin
      * @date 2016年10月8日
      */
     @RequestMapping("/show")
     public ModelAndView show(HttpSession session, String year) throws Exception {

         ModelAndView view = new ModelAndView("reg/client/yr/asset/assetbranch_edit");
         MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
         String priPID = midBaseInfoDto.getPriPID();// 获取主体身份代码

         if(StringUtil.checkYearAndPripid(year,priPID)) {

             String encodeYear = year;          //接收加密年份
             year = AESEUtil.decodeYear(year); //年份解密
             //经营情况表信息
             if (StringUtil.isNotEmpty(year) && StringUtil.isNotEmpty(priPID)) {
                 view.addObject("yrAsset", yrAssetService.selectByYearPridIdForBranch(Integer.parseInt(year), priPID));
             }
             //获取年报anCheID
             YrBaseInfo yrBaseInfo = yrBaseInfoService.selectByYearAndPriPID(Integer.valueOf(year), priPID);
             if (yrBaseInfo != null) {
                 if (StringUtil.isNotEmpty(yrBaseInfo.getAnCheID())) {
                     view.addObject("anCheID", yrBaseInfo.getAnCheID());
                 }
             }
             //查询年报主表信息
             YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
             //获取表单填写的状态
             YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(priPID, Integer.valueOf(year));

             //获取电子公章图片字符串路径
             Signature signature = signatureService.selectByYearAndPripid(year,priPID);
             if(signature!=null&& StringUtils.isNotBlank(signature.getTextCode())){
                 view.addObject("qzImgBase64", signature.getTextCode());
             }

             view.addObject("year", Integer.parseInt(year));
             view.addObject("encodeYear", encodeYear);  //年份进行加密
             view.addObject("priPID", priPID);
             view.addObject("tabName", RepTypeUtil.formAssetbranch);
             view.addObject("yrRegCheck", yrRegCheck);//年报主表信息
             view.addObject("yrForm", yrForm);
         }
         return view;
     }


     /**
      * 保存和更新操作
      *
      * @param yrAssetDto
      * @return
      * @throws Exception
      * @autor: wangjin
      */
     @RequestMapping(value = "/save", method = RequestMethod.POST)
     @ResponseBody
     @RepeatSubmit(timeout=30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
     public AjaxResult save(YrAssetDto yrAssetDto) throws Exception {

         if(StringUtil.checkYearAndPripid(yrAssetDto.getYear(),yrAssetDto.getPriPID())) {
             YrForm yrForm = yrFormService.selectYrFormByPripidAndYear(yrAssetDto.getPriPID(), yrAssetDto.getYear());
             String sign = yrAssetDto.getSign();   //获取当前是【暂存状态】还是保持状态 【保存】
             //更新
             if (StringUtil.isNotEmpty(yrAssetDto.getAssetID())) {
                 if (yrAssetService.updateForBranch(yrAssetDto) > 0) {
                     if ((StringUtil.equalsIgnoreCase("temporary", sign))) {
                         return AjaxResult.success("暂存成功");
                     } else {
                         if (yrForm != null) {
                             if (!"1".equals(yrForm.getAssetbranch())) {
                                 yrForm.setAssetbranch("1");//已填报
                                 yrFormService.updateForm(yrForm);//更新填报表单状态
                             }
                         }
                         return AjaxResult.success("保存成功!");
                     }
                 } else {
                     return AjaxResult.error("保存失败!");
                 }
             }
             //新增
             if (yrAssetService.insertForBranch(yrAssetDto) > 0) {
                 if (!(StringUtil.equalsIgnoreCase("temporary", sign))) {  //如果是【暂存】情况的时候不进行保存表单状态
                     //更新填报表单状态
                     if (yrForm != null) {
                         yrForm.setAssetbranch("1");//已填报
                         yrFormService.updateForm(yrForm);//更新填报表单状态
                     }
                 }
                 return AjaxResult.success("保存成功!", yrAssetDto.getAssetID());
             } else {
                 return AjaxResult.error("保存失败!");
             }
         }
         return AjaxResult.error("参数为空,执行失败!");
     }
 }