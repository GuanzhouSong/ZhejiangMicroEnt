package com.icinfo.cs.depsyn.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysDepartService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.LoginDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.captcha.web.DefaultCaptchaServlet;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.exception.GenericException;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * depsyn登录控制器
 * @author caoxu
 *
 */
@Controller
@RequestMapping("/depsyn")
public class DepLoginController extends BaseController {

	@Autowired
	private ISysUserService sysUserService;

	@Autowired
	private ISysDepartService sysDepartService;
	
	/**
     * 进入入口页面
     *
     * @return
     */
    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main() throws Exception {
    	System.out.println("depsyn/");
        return "/depsyn/main";
    }
	
	/**
     * 进入登录页面
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String gologin(String dep, ModelMap map) throws Exception {
    	map.addAttribute("dep", dep);
        return "/depsyn/login";
    }
	
	/**
     * 用户登录验证
     *
     * @param session
     * @param loginDto
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult loginCheck(HttpSession session, HttpServletResponse response, @Valid LoginDto loginDto,
			BindingResult result, String dep) throws Exception {
		// 验证码校验
		// String checkCode =
		// session.getAttribute(DefaultCaptchaServlet.getSessionKey()) + "";
		// if (!loginDto.getCheckCode().equalsIgnoreCase(checkCode)) {
		// return AjaxResult.error("验证码输入错误");
		// }
		session.removeAttribute(DefaultCaptchaServlet.getSessionKey());
		SysUser tmpSysUser = sysUserService.selectByUserName(loginDto.getUsername());
		if (tmpSysUser == null || !"2".equals(tmpSysUser.getUserType())) {
			throw new GenericException("登录失败,用户名或密码错误!");
		}
		if (tmpSysUser != null && "0".equals(tmpSysUser.getStatus())) {
			throw new GenericException("登录失败,该用户已失效!");
		}
		LoginToken loginToken = new LoginToken(loginDto.getUsername(), loginDto.getPassword());
		Subject subject = SecurityUtils.getSubject();
		subject.login(loginToken);
		session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
		// ---将登陆用户SysUser放入Session
		UserProfile userProfile = (UserProfile) subject.getPrincipal();
		SysUserDto sysUser = sysUserService.selectSynUserByUId(userProfile.getUserId());
		sysUser.setDepSynName(dep);
		if (StringUtil.isNotBlank((sysUser.getDeptCode()))) {
			sysUser.setSysDepart(sysDepartService.doGetByCode(sysUser.getDeptCode()));
		}
		session.setAttribute(Constants.SESSION_SYS_USER, sysUser);
		session.setAttribute("dep", dep);
		session.setAttribute("today", new Date());
		sysUserService.modLastLoginTime(sysUser.getId());
		return AjaxResult.success("登录成功");
	}
    
    /**
     * 退出登录
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() throws Exception {
		Subject subject = SecurityUtils.getSubject();
		// shiro已授权用户退出
		if (subject.isAuthenticated()) {
			subject.logout();
		}
		return "redirect:/depsyn/main";
	}
    
	@RequestMapping(value = "index")
	public ModelAndView index(String dep, HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/depsyn/index");
		UserProfile userProfile = (UserProfile) session.getAttribute(Constants.SESSION_SYS_USER_KEY);
		if (userProfile != null) {
			view.addObject("userProfile", userProfile);
		}
		return view;
	}

	@RequestMapping(value = "dashboard")
	public String dashboard() throws Exception {
		return "depsyn/dashboard";
	}

}
