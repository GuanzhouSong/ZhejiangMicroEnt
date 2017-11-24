/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.logintoken.CSLoginToken;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.pbapp.service.impl.TokenManager;
import com.icinfo.cs.system.dto.LoginDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.IRegIndexService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.captcha.web.DefaultCaptchaServlet;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:  用户登录控制.<br>
 *
 * @author xiajunwei
 * @date 2016年05月18日
 */
@Controller
@RequestMapping("/reg/server")
public class RegLoginController extends CSBaseController {
    private final static Logger logger = LoggerFactory.getLogger(RegLoginController.class);

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private IDepartMentService departMentService;
    @Autowired
    private ISysLogService sysLogService;
    @Autowired
    private IRegIndexService regIndexService;
    @Autowired
    private TokenManager tokenManager; 
    @Autowired
    private ICodeRegunitService codeRegunitService;

    /**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() throws Exception {
        return "redirect:/";
    } 
    
    
    /**
     * 用户登录验证
     *
     * @param session
     * @param loginDto
     * @return
     */
    @RequestMapping(value = "/loginreg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult loginCheck(HttpSession session, HttpServletResponse response, @Valid LoginDto loginDto, BindingResult result) throws Exception {
        logger.debug("系统用户登录");
     /* if (result.hasErrors()) {
            //参数验证错误
            AjaxResult error = AjaxResult.error("参数验证错误");
            error.addErrorInfo(result.getAllErrors());
            return error;
        }*/
        String checkCode = session.getAttribute(DefaultCaptchaServlet.getSessionKey()) + "";
        if (!loginDto.getCheckCode().equalsIgnoreCase(checkCode)) {
            return AjaxResult.error("验证码输入错误");
        }
        session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
        SysUser tmpSysUser=null;
        //根据用户名或手机号查询登录
        List<SysUser> sysUserDtoList= sysUserService.selectSysUserListByLoginNameOrTelPhoneAndUserType(loginDto.getUsername(),"1",DBAuthorConstants.USER_TYPE_REG);
        if(sysUserDtoList!=null&&sysUserDtoList.size()>0){
        	if(sysUserDtoList.size()==1){
        		tmpSysUser=sysUserDtoList.get(0);
        	}else{//重名则提示选择登记机关
        		return AjaxResult.success("您输入的用户名重名", "2");
        	} 
        }
        //tmpSysUser=sysUserService.selectByLoginName(loginDto.getUsername(), DBAuthorConstants.USER_TYPE_REG);
        SysUserDto sysUser=null;
        if(tmpSysUser==null){
        	 return AjaxResult.error("登录失败,系统中没有该用户信息,请检查用户名或密码是否正确!");
        }
        if(!"1".equals(tmpSysUser.getUserType())){
       	     return AjaxResult.error("登录失败,该用户不属于警示系统范围,请联系管理员!");
        }  
        if("0".equals(tmpSysUser.getStatus())){
        	return AjaxResult.error("登录失败,该用户已失效!");
        } 	
        try {
            CSLoginToken loginToken = new CSLoginToken(tmpSysUser.getUsername(), loginDto.getPassword());
            loginToken.setUserType(DBAuthorConstants.USER_TYPE_REG);
            loginToken.setSysUser(tmpSysUser);
            Subject subject = SecurityUtils.getSubject();
            subject.login(loginToken);
            session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
            UserProfile userProfile = (UserProfile)subject.getPrincipal();
            sysUser = sysUserService.selectUserByUId(userProfile.getUserId());
        } catch (Exception e) {
            logger.debug(e.getMessage(), e);
            return AjaxResult.error("登录失败,用户名或密码错误!");
        }
        try {
            sysUserService.modLastLoginTime(sysUser.getId());
            if(sysUser!=null&&StringUtil.isNotBlank((sysUser.getDeptCode()))){
                //sysUser.setDepartMent(departMentService.selectDepartMentByDeptCode(sysUser.getDeptCode()));//警示系统用户信息表中存的部门编码是1.00.1.13.这种形式所以这种形式查不到部门信息，改用下面的
                DepartMent departMent=(sysUser.getDepartMent()==null)?departMentService.selectOne(sysUser.getDeptCode()):departMentService.selectOne(sysUser.getDepartMent().getDeptCode());
                if(departMent==null){
                	return AjaxResult.error("errorDeptCode","获取不到对应的部门信息!");
                }	
                sysUser.setDepartMent(departMent);
                sysUser.setDeptCode(departMent.getDeptCode());//之前大家都是从sesession中取部门编码，大家需要的是行政编码,类似330102的编码，所以我设置进去放到session中去
                session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
		        //初始化缓存,为了初始数据准确
                //操作权限添加
//                operateRedis();  
            }else 
            	return AjaxResult.error("查询用户数据为空!");
        }catch (Exception e){
        	return AjaxResult.error("获取用户相关信息失败：");
        }
        saveLog(sysUser);
        return AjaxResult.success("登录成功!","1");
    }
    
    
    /**
     * 
     * 描述   登记机关和用户名登录
     * @author 赵祥江
     * @date 2017年10月24日 上午11:40:15 
     * @param 
     * @return AjaxResult
     * @throws
     */
    @RequestMapping(value = "/loginregOrg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult loginregOrg(HttpSession session,String username,String password,String regOrgCode,String regOrgName) throws Exception {
        logger.debug("系统用户登录");
        LoginDto loginDto=new LoginDto();
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
        SysUser tmpSysUser=null;
        String regOrgCodeStr=regOrgCode+"00";
        List<SysUser> sysUserDtoTmeList= new ArrayList<SysUser>();
        //根据用户名或手机号查询登录
        List<SysUser> sysUserDtoList= sysUserService.selectSysUserListByLoginNameOrTelPhoneAndUserType(loginDto.getUsername(),"1",DBAuthorConstants.USER_TYPE_REG);
        if(sysUserDtoList!=null&&sysUserDtoList.size()>0){
        	for(SysUser sysUser:sysUserDtoList){
        		if(sysUserDtoTmeList.size()>1){
        			break;
        		} 
        		//获取用户部门
        		DepartMent departMent=	departMentService.selectOne(sysUser.getDeptCode());  
        		if(departMent!=null){
        			CodeRegunit codeRegunit = codeRegunitService
							.selectCodeRegunitInfo(departMent.getDeptCode());
        			if (codeRegunit != null
							&& (regOrgCodeStr.equals(codeRegunit.getSupCode()))
							&& !sysUserDtoTmeList.contains(sysUserDtoList)) {
						sysUserDtoTmeList.add(sysUser);
					}else if(departMent.getDeptCode().length()>=6){
						String deptCode=departMent.getDeptCode();
	        			deptCode=deptCode.substring(deptCode.length()-2, deptCode.length());
	        			//如果是部门编码后两位都是0则取对应的登记机关 否则取管辖单位的superCode 即 登记机关
	        			if("00".equals(deptCode)){
							if ((regOrgCode.equals(departMent.getDeptCode().substring(0, 6)))
									&& (!sysUserDtoTmeList.contains(sysUserDtoList))) {
								sysUserDtoTmeList.add(sysUser);
							}
	        			}
					}  
        		} 
        	} 
        } 
        if(sysUserDtoTmeList.size()==1){
    		tmpSysUser=sysUserDtoTmeList.get(0);
    	}else if(sysUserDtoTmeList.size()>1){
    		return AjaxResult.success("登记机关【"+regOrgName+"】下存在多个同名的用户名,请检查!", "2");
    	} 
        SysUserDto sysUser=null;
        if(tmpSysUser==null){
        	 return AjaxResult.error("登录失败,在登记机关【"+regOrgName+"】下没有找到该用户信息,请检查!");
        }
        if(!"1".equals(tmpSysUser.getUserType())){
       	     return AjaxResult.error("登录失败,该用户不属于警示系统范围,请联系管理员!");
        }  
        if("0".equals(tmpSysUser.getStatus())){
        	return AjaxResult.error("登录失败,该用户已失效!");
        } 	
        try {
            CSLoginToken loginToken = new CSLoginToken(tmpSysUser.getUsername(), loginDto.getPassword());
            loginToken.setUserType(DBAuthorConstants.USER_TYPE_REG);
            loginToken.setSysUser(tmpSysUser);
            Subject subject = SecurityUtils.getSubject();
            subject.login(loginToken);
            session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
            UserProfile userProfile = (UserProfile)subject.getPrincipal();
            sysUser = sysUserService.selectUserByUId(userProfile.getUserId());
        } catch (Exception e) {
        	e.printStackTrace();
            logger.debug(e.getMessage(), e);
            return AjaxResult.error("登录失败,用户名或密码错误!");
        }
        try {
            sysUserService.modLastLoginTime(sysUser.getId());
            if(sysUser!=null&&StringUtil.isNotBlank((sysUser.getDeptCode()))){
                //sysUser.setDepartMent(departMentService.selectDepartMentByDeptCode(sysUser.getDeptCode()));//警示系统用户信息表中存的部门编码是1.00.1.13.这种形式所以这种形式查不到部门信息，改用下面的
                DepartMent departMent=(sysUser.getDepartMent()==null)?departMentService.selectOne(sysUser.getDeptCode()):departMentService.selectOne(sysUser.getDepartMent().getDeptCode());
                if(departMent==null){
                	return AjaxResult.error("errorDeptCode","获取不到对应的部门信息!");
                }	
                sysUser.setDepartMent(departMent);
                sysUser.setDeptCode(departMent.getDeptCode());//之前大家都是从sesession中取部门编码，大家需要的是行政编码,类似330102的编码，所以我设置进去放到session中去
                session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
		        //初始化缓存,为了初始数据准确
                //操作权限添加
//                operateRedis(); 
            }else 
            	return AjaxResult.error("查询用户数据为空!");
        }catch (Exception e){
        	return AjaxResult.error("获取用户相关信息失败：");
        }
        saveLog(sysUser);
        return AjaxResult.success("登录成功!","1");
    }

    /**
     * 保存登录日志
     * @author ZhuDefeng
     * @date 2016-12-29
     */
    private void saveLog(SysUserDto sysUser){
        try{
            Map<String,String> logMap=new HashMap<String,String>();
            String msgContent="警示系统登录日志:登录用户名【"+sysUser.getUsername()+"】 姓名:【"+sysUser.getRealName()+"】  所属部门：【"+sysUser.getDepartMent().getDeptName()+"】";
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SERVER);//警示系统
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.loginTypeLog.getCode());//操作类型-登录
            sysLogService.doAddSysLog(logMap,getRequest());
        }catch(Exception e){
            logger.error("记录警示系统登录日志时出现异常:"+e.getMessage());
        }
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
        return "redirect:/";
    }
    
    /**
     * 
     * 描述: 设置缓存
     * @auther gaojinling
     * @date 2017年10月23日
     */
	@RequestMapping("/operateRedis")
    public void operateRedis(){
        //初始化缓存,为了初始数据准确
        //操作权限添加
        try {
            SysUserDto sysUser= (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
			Map<String, Object> forBidmap = new HashMap<String, Object>();
			String regOrg = selectRegorgByDeptCode(sysUser);
	        forBidmap.put("regOrg", regOrg);
			creatOptDBAuthEnv(forBidmap,"t.CheckDep","t.LocalAdm");
			List<Integer> countList = regIndexService.getCount(forBidmap,sysUser);
			tokenManager.setRegCountToken(sysUser.getId(), countList);
		} catch (Exception e) {
            logger.info("缓存初始化失败！"+e.getMessage());
		} 
    }
}
