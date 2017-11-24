package com.icinfo.cs.sment.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeRegunit;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.logintoken.CSLoginToken;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.sment._enum.LogTypeEnum;
import com.icinfo.cs.sment.service.ISmLogService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.LoginDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.captcha.web.DefaultCaptchaServlet;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述:小微检测-用户登录控制
 *
 * @author zhuyong
 * @date 2017-04-26
 */
@Controller
@RequestMapping("/sment/login")
public class SmentLoginController extends CSBaseController {
	private final static Logger logger = LoggerFactory.getLogger(SmentLoginController.class);

	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IDepartMentService departMentService;
	@Autowired
	private ISmLogService smLogService;
	@Autowired
	private ICodeRegunitService codeRegunitService;
	/**
	 * 进入登录页面
	 *
	 * @return
	 */
	@RequestMapping(value = "/doEnlogin",method=RequestMethod.GET)
	public ModelAndView doEnlogin() throws Exception {
		return new ModelAndView("/sment/sment_login");
	}

	/**
	 * 用户登录验证
	 *
	 * @param session
	 * @param loginDto
	 * @return
	 */
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult doLogin(HttpSession session, HttpServletResponse response, @Valid LoginDto loginDto, BindingResult result) throws Exception {
	    /** 验证码校验 */
		String checkCode = session.getAttribute(DefaultCaptchaServlet.getSessionKey()) + "";
		if (!loginDto.getCheckCode().equalsIgnoreCase(checkCode)) {
			return AjaxResult.error("验证码输入错误");
		}
		session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
		SysUser  tmpSysUser = null;
		//根据用户名或手机号查询登录
        List<SysUser> sysUserDtoList= sysUserService.selectSysUserListByLoginNameOrTelPhoneAndUserType(loginDto.getUsername(),"1",DBAuthorConstants.USER_TYPE_SMENT);
        if(sysUserDtoList!=null&&sysUserDtoList.size()>0){
        	if(sysUserDtoList.size()==1){
        		tmpSysUser=sysUserDtoList.get(0);
        	}else{//重名则提示选择登记机关
        		return AjaxResult.success("您输入的用户名重名", "2");
        	} 
        } 
		SysUserDto sysUser = null; 
		/** 用户登录 */
		try {
			CSLoginToken loginToken = new CSLoginToken(tmpSysUser.getUsername(), loginDto.getPassword());
			loginToken.setUserType(DBAuthorConstants.USER_TYPE_SMENT);
			loginToken.setSysUser(tmpSysUser); 
			Subject subject = SecurityUtils.getSubject();
			subject.login(loginToken);
			session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
			UserProfile userProfile = (UserProfile) subject.getPrincipal();
			sysUser = sysUserService.selectUserByUId(userProfile.getUserId());
		} catch (Exception e) {
			return AjaxResult.error("登录失败,用户名或密码错误!");
		}
		try {
            sysUserService.modLastLoginTime(sysUser.getId());      
            if(sysUser!=null&&StringUtil.isNotBlank((sysUser.getDeptCode()))){
                DepartMent departMent=(sysUser.getDepartMent()==null)?departMentService.selectOne(sysUser.getDeptCode()):departMentService.selectOne(sysUser.getDepartMent().getDeptCode());
                if(departMent==null){
                	return AjaxResult.error("errorDeptCode","获取不到对应的部门信息!");
                }	
                sysUser.setDepartMent(departMent);
                sysUser.setDeptCode(departMent.getDeptCode());
                session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
            }else {
            	return AjaxResult.error("查询用户数据为空!");
            }
        }catch (Exception e){
        	return AjaxResult.error("获取用户相关信息失败：");
        }
		smLogService.save(LogTypeEnum.LOGIN.toString(),"");
		return AjaxResult.success("登录成功!", "1");
	}
	
	/**
	 * 
	 * 描述   根据登记机关和用户名登录
	 * @author 赵祥江
	 * @date 2017年10月27日 上午10:54:13 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
    @RequestMapping(value = "/doLoginSmentOrg", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult doLoginSmentOrg(HttpSession session,String username,String password,String regOrgCode,String regOrgName) throws Exception {
        LoginDto loginDto=new LoginDto();
        loginDto.setUsername(username);
        loginDto.setPassword(password);
        SysUser tmpSysUser=null;
        String regOrgCodeStr=regOrgCode+"00";
        List<SysUser> sysUserDtoTmeList= new ArrayList<SysUser>();
        //根据用户名或手机号查询登录
        List<SysUser> sysUserDtoList= sysUserService.selectSysUserListByLoginNameOrTelPhoneAndUserType(loginDto.getUsername(),"1",DBAuthorConstants.USER_TYPE_SMENT);
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
    		return AjaxResult.success("经检测，在登记机关【"+regOrgName+"】下您的账户与别人重复，请在协同软件中修改用户名或联系联系信息办/信息中心修改。", "2");
    	}  
        if(tmpSysUser==null){
        	 return AjaxResult.error("登录失败,在登记机关【"+regOrgName+"】下没有找到该用户信息,请检查!");
        } 	
        SysUserDto sysUser =null;
		try {
            CSLoginToken loginToken = new CSLoginToken(tmpSysUser.getUsername(), loginDto.getPassword());
            loginToken.setUserType(DBAuthorConstants.USER_TYPE_SMENT);
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
                DepartMent departMent=(sysUser.getDepartMent()==null)?departMentService.selectOne(sysUser.getDeptCode()):departMentService.selectOne(sysUser.getDepartMent().getDeptCode());
                if(departMent==null){
                	return AjaxResult.error("errorDeptCode","获取不到对应的部门信息!");
                }	
                sysUser.setDepartMent(departMent);
                sysUser.setDeptCode(departMent.getDeptCode());
                session.setAttribute(Constants.SESSION_SYS_USER, sysUser); 
            }else 
            	return AjaxResult.error("查询用户数据为空!");
        }catch (Exception e){
        	return AjaxResult.error("获取用户相关信息失败：");
        } 
        smLogService.save(LogTypeEnum.LOGIN.toString(),"");
		return AjaxResult.success("登录成功!", "1");
    }
	
	
	/**
	 * 管理端首页
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "sment_index")
	public ModelAndView index(HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/sment/sment_index");
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		if (userProfile != null) {
			// 用户显示菜单
			view.addObject("menus", userProfile.getMenus());
			view.addObject("userProfile", userProfile);
		}
		return view;
	}
	
	/**
	 * 管理端首页
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "welcome")
	public ModelAndView welcome() throws Exception {
		ModelAndView view = new ModelAndView("/sment/sment_welcome");
	    SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
	    String deptCode = sysUser.getDepartMent().getDeptCode().length() > 4 ? sysUser.getDepartMent().getDeptCode().substring(0, 4) : "3300";
	    view.addObject("sysUser", sysUser);
	    view.addObject("deptCode", deptCode);
		return view;
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
        return "redirect:/sment";
    }
}
