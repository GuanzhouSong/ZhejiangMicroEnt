/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserCheckRecord;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysUserCheckRecordService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.web.BaseController;


/**
 * 描述:   用户验证记录 SYS_USER_CHECK_RECORD 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年12月20日
 */	
@Controller
@RequestMapping("/syn/server/sysuserck")
public class SysUserCheckRecordController extends BaseController {
    private final static Logger logger = LoggerFactory.getLogger(SysUserCheckRecordController.class);
    @Autowired
    private ISysUserCheckRecordService sysUserCheckRecordService;

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysDepartService sysDepartService;

    @Autowired
    private ISmsService smsService;

    @Autowired
    private ISysLogService sysLogService;


    /**
     * 校验用户
     *
     * @param sysUserCheckRecord
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult save(@RequestBody SysUserCheckRecord sysUserCheckRecord, BindingResult result) throws Exception {
        Map<String,String> optRlt=sysUserCheckRecordService.checkUser(sysUserCheckRecord);
        if(optRlt.containsKey("status")&&"success".equals(optRlt.get("status"))){
            return AjaxResult.success("验证成功!");
        }else if(optRlt.containsKey("smsCodeError")){
            return AjaxResult.error(optRlt.get("smsCodeError"));
        }else if(optRlt.containsKey("isBind")){
            return AjaxResult.error(optRlt.get("isBind"));
        }
        return null;
    }

    /**
     * 跳转到用户校验页面
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView show(String userName) throws Exception {
        ModelAndView view = new ModelAndView("syn/system/sysuserck/sysuser_ck");
        SysUser sysUser=sysUserService.selectByLoginName(userName,"2");
        SysUserDto sysUserSession=(SysUserDto)getSession().getAttribute(Constants.SESSION_SYS_USER_KEY_FOR_CK);
        if(StringUtil.equals(sysUser.getIsCheck(),"1")){
            view.addObject("isChecked","1");
        }
        //如果未登陆或登录后验证其他人的帐号，都属于非法操作
        if(sysUserSession==null||!StringUtil.equals(sysUserSession.getUsername(),userName)){
            view.addObject("isLogin","0");
        } 
        SysDepart sysDepart=sysDepartService.doGetByCode(sysUser.getDeptCode()); 
        String tel=sysUser.getUsername();
        String hideTel="";
        if(StringUtil.isNotBlank(tel)&&tel.length()==11){
        	hideTel=tel.substring(0, 3)+"****"+tel.substring(tel.length()-4, tel.length());
        }else{
        	hideTel=tel;
        } 
        view.addObject("sysUser",sysUser);
        view.addObject("sysDepart",sysDepart);
        view.addObject("hideTel",hideTel);
        return view;
    }

    /**
     * 生成校验码
     *
     * @param sysUserCheckRecord
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/gen_sms_code", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult genSmsCode(@RequestBody SysUserCheckRecord sysUserCheckRecord) throws Exception {
        String optType = "add";
       // SysUser sysUser =sysUserService.selectByLoginName(sysUserCheckRecord.getUserUsername(),"2");
       // SysDepart sysDepart = sysDepartService.doGetByCode(sysUser.getDeptCode());
        String district = "330000";
        //district = (StringUtil.isNotBlank(district) && district.length() >= 6) ? StringUtil.substring(district, 0, 6) : "";
        boolean isExist = sysUserService.ckTelPhone(sysUserCheckRecord.getTelPhone(), DBAuthorConstants.USER_TYPE_SYN);
        if (isExist) {
            return AjaxResult.error("该手机帐号已被实名认证,请重新输入手机号!");
        }
        String checkCode = String.valueOf(StringUtil.NextInt(100000, 999999));
        SysUserCheckRecord sysUserCheckRecordTmp = sysUserCheckRecordService.selectByUserName(sysUserCheckRecord.getUserUsername());
        if (sysUserCheckRecordTmp == null) {
            sysUserCheckRecordTmp = sysUserCheckRecord;
            sysUserCheckRecordTmp.setUserUsername(sysUserCheckRecord.getUserUsername());
        } else {
            optType = "mod";
        }
        sysUserCheckRecordTmp.setCheckCode(checkCode);
        sysUserCheckRecordTmp.setUserCreateTime(DateUtil.getSysDate());
        try { 
            sysUserCheckRecordService.saveRecord(sysUserCheckRecordTmp, optType);
            sendMsg(sysUserCheckRecordTmp, sysUserCheckRecord.getTelPhone(), district); 
            return AjaxResult.success("短信验证码已发送,请注意查收!");
        } catch (Exception ex) {
            return AjaxResult.error("短信发送出现异常:" + ex.getMessage());
        }
    }

    /**
     * 发送短信验证码
     * @author ZhuDefeng
     * @date 2017-01-19
     * @param sysUserCheckRecordTmp
     * @param telphone
     * @param district
     */
    private void sendMsg(SysUserCheckRecord sysUserCheckRecordTmp,String telphone,String district){
        String msgContent = "用户名:"+sysUserCheckRecordTmp.getUserUsername()+ "在帐号验证时的本次验证码为" + sysUserCheckRecordTmp.getCheckCode() +"。验证码有效期为3分钟";
        try{
            smsService.doSendMsg(telphone, msgContent,district);//发短信
        }
        catch (Exception e){
            msgContent="用户名:"+sysUserCheckRecordTmp.getUserUsername()+ "在帐号验证时的短信验证码为【"+sysUserCheckRecordTmp.getCheckCode()+"】 但是短信发送失败！"+e.getMessage();
            saveSendMsgLog(msgContent);
            logger.error("发送短信时出现异常:"+e.getMessage());
            throw new BusinessException(e.getMessage());
        }
        saveSendMsgLog(msgContent);
    }

    /**
     * 保存短信校验码发送时的日志
     * @author ZhuDefeng
     * @date 2017-01-19
     * @param msgContent
     */
    private void saveSendMsgLog(String msgContent){
        Map<String, String> logMap = new HashMap<String, String>();
        logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());//获取短信的年份
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SYN);//协同
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
        logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.sendMsgLoginCheckLog.getCode());//操作类型
        try{
            sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        }catch (Exception e){
            logger.error("记录日志时出现异常:"+e.getMessage());
        }
    }

}