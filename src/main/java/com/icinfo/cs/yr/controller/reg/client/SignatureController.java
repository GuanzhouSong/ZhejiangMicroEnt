/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import com.alibaba.fastjson.JSONObject;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.model.Signature;
import com.icinfo.cs.yr.service.ISfcBalanctsheetService;
import com.icinfo.cs.yr.service.ISignatureService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.tools.utils.WebUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:  cs_signature 签章 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年05月18日
 */
@Controller
@RequestMapping("/reg/client/yr/ent/signature")
public class SignatureController extends BaseController {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SignatureController.class);

    //签章地址
    @Value("${webSigntureServer}")
    private String webSigntureServer;

    @Autowired
    private  ISignatureService signatureService;


    /**
     * 描述：保存签章成功纪录
     * @param
     * @return
     * @throws Exception
     */
    @RequestMapping("/doSaveSignture")
    @ResponseBody
    @RepeatSubmit(timeout=3000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult doSaveSignture(String cert, String signedData, String signContent,String year,String pripid) {
        //构建 json参数
        JSONObject paramJsonObject = new JSONObject();
        //项目ID，由签章系统分配
        paramJsonObject.put("project", "ycproject");
        //证书公钥base64，由jsp页面获取传入
        paramJsonObject.put("cert", cert);
        //签名值，由jsp页面获取传入
        paramJsonObject.put("signedData", signedData);
        //签名原文，由jsp页面获取传入
        paramJsonObject.put("signContent", signContent);
        //该地址获取 entry/dev/spring.properties
        String url = webSigntureServer;
        //使用框架的postStream方法发送请求
        String result = WebUtils.postStream(url, paramJsonObject.toJSONString(), "utf-8");
        JSONObject rltJson = null;
        try {
            //判断接口获取的数据是否满足序列化条件
            rltJson = JSONObject.parseObject(result);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("签章失败");
        }
        String sealImgBase64 = "";
        if("0".equals(rltJson.getString("retcode"))){
            //获得签名ID
            String signId = rltJson.getString("signId");
            //获得印章图片base64
            sealImgBase64 = "data:image/page;base64,"+rltJson.getString("sealImgBase64");

           if(doSaveAndUpdate(year,pripid,sealImgBase64)){
               return  AjaxResult.success("签章成功",sealImgBase64);
           }
        }
        return AjaxResult.error("签章失败");
    }


    private boolean doSaveAndUpdate(String year,String pripid,String sealImgBase64){

        boolean falg = false;
        Signature signature = null;

        if(StringUtil.checkYearAndPripid(year,pripid)) {
             signature = signatureService.selectNotbySatuts(year, pripid);
        }

        //判断当前表中是否有纪录 有则更新  无则新增
        if(signature!=null){
            signature.setTextCode(sealImgBase64);
            falg = signatureService.modify(signature)>0?true:false;
        }else{
            falg = signatureService.save(year,pripid, sealImgBase64)>0?true:false;
        }
        return falg;
    }

    /**
     * 签章失败修改 签章状态
     * @param year
     * @param pripid
     */
    @RequestMapping("/doModifyStatus")
    @ResponseBody
    public void doModifyStatus(String year,String pripid){
        if(StringUtil.checkYearAndPripid(year,pripid)){
            signatureService.modifyStatus(signatureService.selectByYearAndPripid(year, pripid));
        }
    }

}