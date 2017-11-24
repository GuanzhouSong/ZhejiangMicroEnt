/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.logintoken.CSLoginToken;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.login.intercetor.csrf.RefreshCSRFToken;
import com.icinfo.cs.login.intercetor.csrf.VerifyCSRFToken;
import com.icinfo.cs.system.dto.LoginDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.captcha.web.DefaultCaptchaServlet;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:  协同系统用户登录控制.<br>
 *
 * @author ZhuDefeng
 * @date 2016年10月24日
 */

@Controller
@RequestMapping("/syn")
public class SynLoginController extends CSBaseController {
    private final static Logger logger = LoggerFactory.getLogger(SynLoginController.class);


    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysDepartService sysDepartService;

    @Autowired
    private ISysLogService sysLogService;
    
    /**
     * 进入登录页面
     *
     * @return
     */
    @RefreshCSRFToken
    @RequestMapping(value = "/governlogin", method = RequestMethod.GET)
    public String loginGovernSynPage(HttpSession session) throws Exception {
    	return "/syn/governlogin";
    }

    /**
     * 进入登录页面
     *
     * @return
     */
    @RefreshCSRFToken
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginSynPage(HttpSession session) throws Exception {
        return "/syn/login";
    }
    
   

    /**
     * 用户登录验证
     *
     * @param session
     * @param loginDto
     * @return
     */
    @VerifyCSRFToken
    @RequestMapping(value = "/loginsyn", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult loginCheck(HttpSession session, HttpServletResponse response, @Valid LoginDto loginDto, BindingResult result) throws Exception {
        logger.debug("系统用户登录");
       if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }
        //验证码校验
        String checkCode = session.getAttribute(DefaultCaptchaServlet.getSessionKey()) + "";
        if (!loginDto.getCheckCode().equalsIgnoreCase(checkCode)) {
            return AjaxResult.error("验证码输入错误");
        }
        session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
        SysUserDto sysUser=null;
        try {
            SysUser tmpSysUser=sysUserService.selectByLoginName(loginDto.getUsername(),DBAuthorConstants.USER_TYPE_SYN);
            if(tmpSysUser==null){
            	return AjaxResult.error("登录失败,系统中没有该用户信息,请检查用户名或密码是否正确!");
            }
            if(!"2".equals(tmpSysUser.getUserType())){
            	return AjaxResult.error("登录失败,该用户不属于协同系统范围,请联系管理员!");
            }
            if(tmpSysUser!=null&&"0".equals(tmpSysUser.getStatus())){
            	return AjaxResult.error("登录失败,该用户已失效!");
            }
            CSLoginToken loginToken = new CSLoginToken(loginDto.getUsername(), decodeBase64(loginDto.getPassword()));
            loginToken.setUserType(DBAuthorConstants.USER_TYPE_SYN);
            Subject subject = SecurityUtils.getSubject();
            subject.login(loginToken);
            //--暂时保留--
            session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
            //---将登陆用户SysUser放入Session
            UserProfile userProfile = (UserProfile)subject.getPrincipal();
            sysUser = sysUserService.selectSynUserByUId(userProfile.getUserId());
            sysUserService.modLastLoginTime(sysUser.getId());
        } catch (Exception e) {
        	//e.printStackTrace();
            logger.debug(e.getMessage(), e);
            return AjaxResult.error("登录失败,用户名或密码错误!");
        }
        if(sysUser!=null&&StringUtil.isNotBlank((sysUser.getDeptCode()))){
            SysDepart sysDepart=sysDepartService.doGetByCode(sysUser.getDeptCode());
            if(sysDepart==null){
            	return AjaxResult.error("errorDeptCode","登录失败，获取不到对应的部门信息!");
            }
            sysUser.setSysDepart(sysDepart);
        }else{
        	return AjaxResult.error("errorDeptCode","登录失败，该账号的所属部门为空!");
        }
        session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
        session.setAttribute(Constants.SESSION_SYS_USER_KEY_FOR_CK, sysUser);
        return loginResult(sysUser,session);
    }

    /**
     * 保存登录日志
     * @author ZhuDefeng
     * @date 2016-12-29
     */
    private void saveLog(SysUserDto sysUser){
        try{
            Map<String,String> logMap=new HashMap<String,String>();
            String msgContent="协同系统登录日志:登录用户名【"+sysUser.getUsername()+"】 姓名:【"+sysUser.getRealName()+"】  所属部门：【"+sysUser.getSysDepart().getOrgName()+"】";
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SYN);//协同系统
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.loginTypeLog.getCode());//操作类型-登录
            sysLogService.doAddSysLog(logMap,getRequest());
        }catch(Exception e){
            logger.error("记录协同系统登录日志时出现异常:"+e.getMessage());
        }
    }
    /**
    * 描述：解密
    * @author gqf
    * @param
    * @return
     *@date 2017/7/17
    */
    public String decodeBase64(String code) throws  Exception{
        if(code==null ||"".equals(code)) return "";
        byte[] userNameByte = Base64.decodeBase64(code.getBytes("UTF-8"));
        String decode = new String(userNameByte);
        return decode;
    }
    /**
     * 校验是否通过用户校验
     * @author ZhuDefeng
     * @date 2016-12-20
     * @param sysUserDto
     * @return
     * @throws Exception
     */
    private AjaxResult loginResult(SysUserDto sysUserDto,HttpSession session)throws  Exception{
        if("1".equals(sysUserDto.getIsAdmin())){
            saveLog(sysUserDto);
            return AjaxResult.success("登录成功!");
        }
        boolean isChecked="1".equals(sysUserDto.getIsCheck());
        if(!isChecked){
            session.removeAttribute(Constants.SESSION_SYS_USER_KEY);
            session.removeAttribute(Constants.SESSION_SYS_USER);
            return AjaxResult.error("checked","0");
        }
        saveLog(sysUserDto);
        return AjaxResult.success("登录成功!");
    }

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
    	return "redirect:/syn/login";
    }

    /**
     * 管理端首页
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView index(HttpSession session) throws Exception{
        ModelAndView view = new ModelAndView("/syn/index");
        UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
        if (userProfile != null) {
            //用户显示菜单
            view.addObject("menus", userProfile.getMenus());
            view.addObject("userProfile", userProfile);
        }
        return view;
    }



}
