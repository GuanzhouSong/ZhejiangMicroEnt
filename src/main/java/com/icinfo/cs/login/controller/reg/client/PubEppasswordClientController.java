/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.controller.reg.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.cs.login.service.IPubEppasswordHisService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.impl.LoginServiceImpl;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;

/**
 * 描述: cs_pub_eppassword 对应的Controller类.<br>
 *      联络员信息
 * @author framework generator
 * @date 2016年08月28日
 */
@Controller
@RequestMapping("/reg/client/liaison")
public class PubEppasswordClientController extends BaseController {

    @Autowired
    private IPubEppasswordService pubEppasswordService;
    @Autowired
    private ISmsService smsService;
    @Autowired
    private IPubEppasswordHisService iPubEppasswordHisService;
    @Autowired
	private ISysLogService sysLogService;

    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


    /**
     * 描述: 添加 数字证书的 联络员信息 或 变更 联络员信息
     *
     * @param pubEppassword
     * @return
     * @throws Exception
     * @author: wangjin
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout = 30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult save(PubEppassword pubEppassword,HttpSession session) throws Exception {

        //先进行判断验证码是否有效
        if (StringUtil.isNotEmpty(pubEppassword.getUnicode()) || StringUtil.isNotEmpty(pubEppassword.getRegno())) {

            //获取session中创建验证码的创建时间
            Date codeCreateTime = (Date) session.getAttribute("CodeCreateTime");
            if(codeCreateTime == null) {
            	return AjaxResult.error("验证码已失效！请重新获取验证码。");
            }
            if (DateUtil.getBetweenDaysToMut(codeCreateTime, new Date()) > 10) {  //测试使用1分钟  正确的是10分钟
                return AjaxResult.error("验证码已失效！请重新获取验证码。");
            }
            //获取session中的验证码
            String liaMsgPassword = (String) session.getAttribute("liaMsgPassword");
            if (!StringUtil.equalsIgnoreCase(pubEppassword.getPassword(), liaMsgPassword)) { //判断验证码和数据中是否一致
                return AjaxResult.error("验证码错误！请输入正确的验证码。");
            }

            //对于外国人姓名中带有点的法人代表数据进行处理
            pubEppassword.setLerep(StringUtil.doHtm(pubEppassword.getLerep()));
            pubEppassword.setLianame(StringUtil.doHtm(pubEppassword.getLianame()));

            if (StringUtil.isNotEmpty(pubEppassword.getUid())) {
                //查询是为了保存历史数据
                List<PubEppassword> pwd = pubEppasswordService.selectPubEppasswordList(pubEppassword.getUnicode(),pubEppassword.getRegno());
                if (pubEppasswordService.update(pubEppassword) > 0) { //更新
                    //保存联络员历史记录
                    PubEppasswordHis pubEppasswordHis = new PubEppasswordHis();
                    if (pwd.get(0) != null) {
                        pwd.get(0).setId(null);
                        BeanUtil.getBeanUtilsBean().copyProperties(pubEppasswordHis, pwd.get(0));
                        iPubEppasswordHisService.doSavePubEppasswordInfo(pubEppasswordHis);
                    }
                    return AjaxResult.success("变更成功");
                } else {
                    return AjaxResult.error("变更失败");
                }
            } else {
                if (pubEppasswordService.inset(pubEppassword) > 0) {
                    return AjaxResult.success("提交成功");
                } else {
                    return AjaxResult.success("提交失败");
                }
            }
        }
        return AjaxResult.error("执行失败");
    }

    /**
     * 描述：根据条件查询联络员信息
     *
     * @param unicode 统一社会信用代码
     * @param regno   注册号
     * @return
     * @author: wangjin
     */
    public PubEppassword selectLiaison(String unicode, String regno) {
        PubEppassword pubEppassword = pubEppasswordService.select(unicode, regno);
        return pubEppassword;
    }


    /**
     * 获取手机验证码 发送短信
     *
     * @param session
     * @return
     * @throws Exception
     * @author: wangjin
     */
    @RequestMapping(value = "/acceptPwd")
    @ResponseBody
    public AjaxResult acceptPwd(HttpSession session, String phone, String lianame) throws Exception {
        // 1.从session 获取 企业信息
        MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
        if (midBaseInfoDto != null) {

            // 2.生成验证码，发送短信
            String password = String.valueOf(StringUtil.NextInt(100000, 999999));

            //3.添加验证码和创建时间存放于session中用于保存时进行比较
            session.setAttribute("liaMsgPassword", password);
            session.setAttribute("CodeCreateTime",DateUtil.getSysDate());

            String msgContent = "验证码" + password + "，10分钟内有效。您正在成为" + midBaseInfoDto.getEntName() + "的工商联络员，如有疑问请致电4008884636";

            //加日志
            String contentForSave = "验证码：【" + password + "】，十分钟内有效。联络员姓名：【"+lianame+"】，联络员手机号：【"+phone+"】";
            Map<String, String> logMap = new HashMap<String, String>();
            logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID,midBaseInfoDto.getPriPID());//企业内部序号
            logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME,midBaseInfoDto.getEntName());//企业名称
            logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,midBaseInfoDto.getRegNO());//企业注册号
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());//获取短信的年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGEENTYPE,midBaseInfoDto.getEntTypeCatg());//企业类型
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);//企业端
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, contentForSave);//日志内容
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.sendMsgAfterLoginLog.getCode());//操作类型
            sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());

            try{
                //发送短信
                smsService.doSendMsg(phone, msgContent, midBaseInfoDto.getRegOrg());//发短信
            }catch (Exception e){
                e.printStackTrace();
                return AjaxResult.error("fail");
            }

            return AjaxResult.success("");
        }
        return AjaxResult.error("");
    }



    /**
     * 描述: 联络员信息更新
     *
     * @param pubEppassword
     * @return
     * @throws Exception
     * @author: wangjin
     */
    @RequestMapping(value = "/liaisonUpdate", method = RequestMethod.POST)
    @ResponseBody
    @RepeatSubmit(timeout = 30000) //默认3秒后会重复提交    @RepeatSubmit(timeout=) 可以设置提交的时间间隔
    public AjaxResult liaisonUpdate(PubEppassword pubEppassword) throws Exception {
        if (StringUtil.isNotBlank(pubEppassword.getPripid())) {
            if (StringUtil.isNotEmpty(pubEppassword.getUid())) {
                // 查询是为了保存历史数据
                List<PubEppassword> liaisonpwd = pubEppasswordService.selectPubEppasswordList(pubEppassword.getUnicode(),pubEppassword.getRegno());
                if (pubEppasswordService.liaisonupdate(pubEppassword) > 0) { //更新
                    //保存联络员历史记录
                    PubEppasswordHis pubEppasswordHis = new PubEppasswordHis();
                    if (liaisonpwd.get(0) != null) {
                        liaisonpwd.get(0).setId(null);
                        BeanUtil.getBeanUtilsBean().copyProperties(pubEppasswordHis, liaisonpwd.get(0));
                        iPubEppasswordHisService.doSavePubEppasswordInfo(pubEppasswordHis);
                    }
                    return AjaxResult.success("修改成功");
                } else {
                    return AjaxResult.error("修改失败");
                }
            } else {
                if (pubEppasswordService.inset(pubEppassword) > 0) {
                    return AjaxResult.success("提交成功");
                } else {
                    return AjaxResult.success("提交失败");
                }
            }
        }
        return AjaxResult.error("执行失败");
    }


}