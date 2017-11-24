/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.controller.reg.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.record.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.InfoDataClient;
import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.cs.login.service.ILoginService;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPbpasswordService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.dataservice.CertInfo;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
//import com.icinfo.zjaicsso.cas.client.authentication.AttributePrincipal;
import com.icinfo.zjaicsso.cas.client.authentication.AttributePrincipal;

/** 
 * 描述: 企业端登录
 * @author ZhouYan
 * @date 2016年8月28日  
 */
@Controller("ClientLoginController")
@RequestMapping("reg/client/login")
public class LoginController extends BaseController {
	private final static Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ISmsService smsService;
	@Autowired
	private ISysLogService sysLogService;
	@Autowired
	private IPubPbpasswordService pubPbpasswordService;
	
	
	@Value("${webServer}")
	private String webServer;
	@Value("${casServer}")
	private String casServer;
	//汇信数据服务接口
  	private InfoDataClient infoDataClient = new InfoDataClient();
  	
	/** 
	 * 描述: 进入企业年报登录页面
	 * @auther ZhouYan
	 * @date 2016年8月28日 
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/ent", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpSession session) throws Exception {
		if(!session.isNew()) {
			session.invalidate();
		}
        ModelAndView view = new ModelAndView("reg/client/login/login");
		view.addObject("webServer", webServer);
		view.addObject("casServer", casServer);
		return view;
    }*/
	
	/** 
	 * 描述: 进入农专年报登录页面
	 * @auther ZhouYan
	 * @date 2016年8月28日 
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/sfc", method = RequestMethod.GET)
    public ModelAndView sfcLoginPage(HttpSession session) throws Exception {
		if(!session.isNew()) {
			session.invalidate();
		}
		ModelAndView view = new ModelAndView("reg/client/login/sfclogin");
		view.addObject("webServer", webServer);
		view.addObject("casServer", casServer);
        return view;
    }*/
	
	/** 
	 * 描述: 进入个体户年报登录页面
	 * @auther ZhouYan
	 * @date 2016年8月28日 
	 * @return
	 * @throws Exception 
	 */
	/*@RequestMapping(value = "/pb", method = RequestMethod.GET)
    public ModelAndView pbLoginPage(HttpSession session) throws Exception {
		if(!session.isNew()) {
			session.invalidate();
		}
		ModelAndView view = new ModelAndView("reg/client/login/pblogin");
		view.addObject("webServer", webServer);
		view.addObject("casServer", casServer);
        return view;
    }*/
	
	/** 
	 * 描述: 登录返回提示
	 * @auther ZhouYan
	 * @date 2016年9月28日 
	 * @param rtn
	 * @return 
	 */
	public ModelAndView loginRtn(ResultRtn<T> rtn, String systemType, String path) {
		// 跳转到登陆页面展示业务提示
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("code", rtn.getErrorCode());
		model.put("error", rtn.getError());
		if(systemType.equals(Constants.SYSTEM_TYPE_PB)) {
			return new ModelAndView("/reg/client/login/pblogin", model);
		}else if(systemType.equals(Constants.SYSTEM_TYPE_SFC)){
			return new ModelAndView("/reg/client/login/sfclogin", model);
		}else{
			return new ModelAndView("reg/client/login/login", model);
		}
	}
	
	/** 
	 * 描述: 单点登录
	 * @auther ZhouYan
	 * @date 2016年8月28日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/cas/{type}", method = RequestMethod.GET)
	public ModelAndView certLogin(HttpServletRequest request, @PathVariable("type") String type, @CookieValue(value="CAKeyInfoExpiredFlag", defaultValue="0") String expiredFlag) throws Exception {
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		ResultRtn<T> rtn = null;
		if(type.equals(Constants.SYSTEM_TYPE_PB)) {//个体户
			rtn = loginService.doPbKeyLogin(principal, expiredFlag);
			
			return new ModelAndView("redirect:/reg/client/yr/yrregcheck/pb/index_list");
		}else if(type.equals(Constants.SYSTEM_TYPE_SFC)){//农专
			rtn = loginService.doSFCKeyLogin(principal, expiredFlag);
			if(!rtn.isSucess()){
				return loginRtn(rtn, Constants.SYSTEM_TYPE_SFC, "");
	    	}
			return new ModelAndView("redirect:/reg/client/yr/yrregcheck/sfc/index_list");
		}else{
			rtn = loginService.doEntKeyLogin(principal, expiredFlag);//企业
			if(!rtn.isSucess()){
				return loginRtn(rtn, Constants.SYSTEM_TYPE_ENT, "");
	    	}
			return new ModelAndView("redirect:/reg/client/yr/yrregcheck/ent/index_list");
		}
	}
	
	
	/** 
	 * 描述: 企业联络员登录
	 * @auther ZhouYan
	 * @date 2016年8月30日
	 * @param pubEppasswordDto
	 * @param systemType
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pwd", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pwdLogin(@Valid PubEppasswordDto pubEppasswordDto, @RequestParam String systemType) throws Exception {
        ResultRtn<T> rtn = loginService.doPwdLogin(pubEppasswordDto, systemType);
		if(!rtn.isSucess()){
			return AjaxResult.error(rtn.getErrorCode(), rtn.getError());
    	}
        return AjaxResult.success("");
	}
	
	
	
	/** 
	 * 描述: 根据统一代码/注册号校验登录信息
	 * @auther ZhouYan
	 * @date 2016年8月31日 
	 * @param regno
	 * @param type
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/getinfo")
    @ResponseBody
	public AjaxResult getPwdInfo(String regno, String type, HttpSession session) throws Exception{
		if(StringUtils.isNotEmpty(regno)){
			// 1.判断用户范围，根据注册号判断
			MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(regno, null, type);
			String entname = null;
			if(midBaseInfoDto == null) {
				return AjaxResult.error("用户不在本系统范围内，请确认输入信息是否正确！");
			}else{
				entname = midBaseInfoDto.getEntName();
				String unicode = midBaseInfoDto.getUniCode();
				if (StringUtils.isNotBlank(unicode) && !unicode.equals(regno)) {
					return AjaxResult.error("请输入统一社会信用代码登录！");
				}
			}
			// 2.判断企业是否已有证书
			Map<String, Object> rltMap = new HashMap<String, Object>();
			List<CertInfo> certInfoList = infoDataClient.getCertInfoByCorpid(midBaseInfoDto.getPriPID());
			if(!certInfoList.isEmpty()) {
				rltMap.put("cert", "true");
            }else{
            	rltMap.put("cert", "false");
            }
			// 3.判断联络员确认信息
			List<PubEppassword> pubEppasswordList = pubEppasswordService.selectByRegnoOrUnicode(regno,midBaseInfoDto.getRegNO());
			if (!pubEppasswordList.isEmpty()) {
				PubEppassword pubEppasswordTemp = pubEppasswordList.get(0);
				rltMap.put("lia", "true");
				rltMap.put("lianame", pubEppasswordTemp.getLianame());
				rltMap.put("entname", pubEppasswordTemp.getEntname());
				pubEppasswordTemp.setPassword(null);
				session.setAttribute("pubEppasswordTemp", pubEppasswordTemp);
				//判断联络员信息是否变更
				if ((regno.length() < 18 && !StringUtil.doReplaceBlank(regno).equals(pubEppasswordTemp.getRegno()))
						|| !StringUtil.doReplaceBlank(entname).equals(StringUtil.doReplaceBlank(pubEppasswordTemp.getEntname()))
						|| (Constants.entCatgPartner.indexOf(midBaseInfoDto.getEntTypeCatg()) == -1
								&& midBaseInfoDto.getLeRep() != null && !StringUtil.doReplaceBlank(midBaseInfoDto.getLeRep())
								.equals(StringUtil.doReplaceBlank(pubEppasswordTemp.getLerep())))) {
					return AjaxResult.error("输入的联络员信息与确认信息不一致。");
				}
			}else{
				rltMap.put("lia", "false");
			}
			return AjaxResult.success("", rltMap);
		}
		return AjaxResult.error("");
	}
	
	/** 
	 * 描述: 校验联络员信息
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param liaidnum
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/liainfo")
    @ResponseBody
    public AjaxResult checkLiaInfo(String liaidnum, HttpSession session) throws Exception {
		if(StringUtils.isNotEmpty(liaidnum)){
	        // 1.从session取联络员信息
			PubEppassword pubEppasswordTemp = (PubEppassword) session.getAttribute("pubEppasswordTemp");
	        // 2.校验身份证件号码是否与信息一致
		    if(liaidnum.equals(pubEppasswordTemp.getLiaidnum())){
		    	String tel = pubEppasswordTemp.getTel();
		    	// 手机号码不为空
		    	if(tel != null && tel.length() == 11){
		    		tel = tel.substring(0,3) + "*****" + tel.substring(8, tel.length());
		    		return AjaxResult.success("", tel);
		    	}else{
		    		return AjaxResult.error("手机号数据异常，请联系系统管理员。");
		    	}
		    }else{
		    	return AjaxResult.error("联络员证件号错误!");
		    }
		}
	    return AjaxResult.error("请输入联络员证件号!");
    }
	
    /** 
     * 描述: 获取手机验证码, 发送短信
     * @auther ZhouYan
     * @date 2016年9月8日 
     * @param session
     * @return
     * @throws Exception 
     */
	@RequestMapping(value = "/getnewpwd")
    @ResponseBody
    public AjaxResult getNewPwd(HttpSession session) throws Exception {
    	// 1.从session取确认的信息
    	PubEppassword pubEppassword = (PubEppassword) session.getAttribute("pubEppasswordTemp");
    	
        
    	// 2.生成验证码
    	String password = String.valueOf(StringUtil.NextInt(100000,999999));
    	
    	// 3.保存验证码,发送短信
	    pubEppassword.setPassword(password);
        try {
        	pubEppasswordService.updatePwd(pubEppassword);
	    	PubPbpassword pubPbpassword = new PubPbpassword();
	        pubPbpassword.setTel(pubEppassword.getTel());
	    	pubPbpassword.setPassword(password);
	    	pubPbpassword.setOperation("2");
	    	//先删除验证码列表中当前联络员获取的验证码，再保存新验证码
	    	pubPbpasswordService.deletePwd(pubPbpassword);
	    	pubPbpasswordService.save(pubPbpassword);
        	
	    	String msgContent = pubEppassword.getEntname() + "本次登录企业信用信息公示系统的验证码为" + password +"，24小时内有效";
        	String sendMsgDistrict = (String) session.getAttribute("sendMsgDistrict");//从session获取行政区划
        	smsService.doSendMsg(pubEppassword.getTel(), msgContent, sendMsgDistrict);//发短信
        	//加日志
            Map<String, String> logMap = new HashMap<String, String>();
            logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID,pubEppassword.getPripid());//企业内部序号
            logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME,pubEppassword.getEntname());//企业名称
            logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,pubEppassword.getRegno());//企业注册号
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());//获取短信的年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);//企业端
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
    		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.sendMsgBeforeLoginLog.getCode());//操作类型
    		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
        	return AjaxResult.success("");
        } catch (Exception ex) {
        	return AjaxResult.error("");
        }
    }   
	
	/** 
	 * 描述: 个体户用户名密码登录
	 * @auther ZhouYan
	 * @date 2016年8月30日 
	 * @param
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pb/pwd", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pwdLogin(@Valid PubPbePassword pubEppassword) throws Exception {
        ResultRtn<T> rtn = loginService.doPbPwdLogin(pubEppassword);
		if(!rtn.isSucess()){
			return AjaxResult.error(rtn.getErrorCode(), rtn.getError());
    	}
        return AjaxResult.success("");
	}
	
	

	/**
	 * 退出当前登录
	 * author:wnagjin
	 * @param session
	 * @return
     */
	@RequestMapping(value = "/loginOut", method = RequestMethod.GET)
	public ModelAndView loginOut(HttpSession session,String logoutUrl) {
//		ModelAndView view = null;
//		MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");//获取企业基本信息数据
//		if(midBaseInfoDto==null){
//			if(StringUtil.isNotEmpty(logoutUrl)){
//				if(logoutUrl.indexOf("ent")!=-1)view = new ModelAndView("redirect:/reg/client/login/ent");   //企业
//				if(logoutUrl.indexOf("sfc")!=-1)view = new ModelAndView("redirect:/reg/client/login/sfc"); //农专
//				if(logoutUrl.indexOf("pb")!=-1) view = new ModelAndView("redirect:/reg/client/login/pb"); //个体户
//			}
//		}else{
//			String entTypeCatg = midBaseInfoDto.getEntTypeCatg();//获取企业类型
//			session.invalidate();//清除session
//
//			if(StringUtils.equalsIgnoreCase(entTypeCatg,"16")||StringUtils.equalsIgnoreCase(entTypeCatg,"17")){
//				view = new ModelAndView("redirect:/reg/client/login/sfc"); //农专
//			}else if(StringUtils.equalsIgnoreCase(entTypeCatg,"50")){
//				view = new ModelAndView("redirect:/reg/client/login/pb"); //个体户
//			}else{
//				view = new ModelAndView("redirect:/reg/client/login/ent");   //企业
//			}
//		}
		
		//国家局统一登录页面退出
		ModelAndView view = new ModelAndView("redirect:/reg/client/login/all");
		session.invalidate();//清除session

		return view;
	}


	/** 
	 * 描述: 跳转到填报帮助页面
	 * @auther ZhouYan
	 * @date 2016年11月25日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="help")
	public ModelAndView help() throws Exception{
		ModelAndView view = new ModelAndView("reg/client/login/help");
		return view;
	}
	
	/** 
	 * 描述: 跳转到常见问题页面
	 * @auther ZhouYan
	 * @date 2016年11月25日 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value="ques")
	public ModelAndView ques() throws Exception{
		ModelAndView view = new ModelAndView("reg/client/login/ques");
		return view;
	}
	
	/*****************************************************2016-12-10 国家局版本登录 start**********************************************/
	/** 
	 * 描述: 国家局版本登录页面
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView loginAllPage(HttpSession session) throws Exception {
		if(!session.isNew()) {
			session.invalidate();
		}
        ModelAndView view = new ModelAndView("pub/infobulletin/fillpublicinformation");
		view.addObject("webServer", webServer);
		view.addObject("casServer", casServer);
		return view;
    }
	
	/** 
	 * 描述: 国家局版本联络员登录
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/pwdall", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult pwdAllLogin(@Valid PubEppasswordDto pubEppasswordDto) throws Exception {
        ResultRtn<T> rtn = loginService.doPwdAllLogin(pubEppasswordDto);
		if(!rtn.isSucess()){
			return AjaxResult.error(rtn.getErrorCode(), rtn.getError());
    	}
        return AjaxResult.success("");
	}
	
	/** 
	 * 描述: 根据统一代码/注册号校验登录信息
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param regno
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/getinfoall")
    @ResponseBody
	public AjaxResult getPwdInfoAll(String regno, HttpSession session) throws Exception{
		if(StringUtils.isNotEmpty(regno)){
			// 1.判断用户范围，根据注册号判断
			MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(regno, null, null);
			String entname = null;
			String entTypeCatg = null;
			boolean isNingBo = false;
			if(midBaseInfoDto == null) {
				return AjaxResult.error("用户不在本系统范围内，请确认输入信息是否正确！");
			}else{
				entname = midBaseInfoDto.getEntName();
				entTypeCatg = midBaseInfoDto.getEntTypeCatg();
				isNingBo = StringUtils.startsWith(midBaseInfoDto.getRegOrg(), "3302");//是否宁波地区
				String unicode = midBaseInfoDto.getUniCode();
				if (StringUtils.isNotBlank(unicode) && !unicode.equals(regno)) {
					return AjaxResult.error("请输入统一社会信用代码登录！");
				}
				if(StringUtil.isNotBlank(entTypeCatg) && "23".equals(entTypeCatg)){//外资常驻代表机构不属于本系统备案范围内
					return AjaxResult.error("外资常驻代表机构不属于本系统范围内！");
				}
				//非个体户判断新成立企业
				if(!entTypeCatg.equals(Constants.entTypeCatgPB) && !isNingBo) {
					//成立日期为2016年1月1日及以后的用户必须用数字证书登录
					Date endDate = DateUtil.stringToDate( "2016-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"); 
		        	if(midBaseInfoDto.getEstDate() != null && midBaseInfoDto.getEstDate().after(endDate)){
		        		return AjaxResult.error("0", "必须证书登录！");
		        	}
				}
			}
			// 2.判断企业是否已有证书
			Map<String, Object> rltMap = new HashMap<String, Object>();
			if(StringUtils.isNotBlank(midBaseInfoDto.getRegNO())||StringUtils.isNotBlank(midBaseInfoDto.getUniCode())) {
				List<CertInfo> certInfoList = infoDataClient.getCertInfoByCorpid(midBaseInfoDto.getPriPID());
				if(!certInfoList.isEmpty() && !entTypeCatg.equals(Constants.entTypeCatgPB) && !isNingBo) {//个体户不管是否证书返回false
					rltMap.put("cert", "true");
	            }else{
	            	rltMap.put("cert", "false");
	            }
			}else{
				return AjaxResult.error("登记数据中注册号为空！请联系工商人员。");
			}
			// 3.判断联络员确认信息
			List<PubEppassword> pubEppasswordList = pubEppasswordService.selectByRegnoOrUnicode(regno,midBaseInfoDto.getRegNO());
			if (!pubEppasswordList.isEmpty()) {
				PubEppassword pubEppasswordTemp = pubEppasswordList.get(0);
				rltMap.put("lia", "true");
				pubEppasswordTemp.setPassword(null);
				session.setAttribute("pubEppasswordTemp", pubEppasswordTemp);
				session.setAttribute("sendMsgDistrict", midBaseInfoDto.getRegOrg());//发送短信行政区划
				//判断联络员信息是否变更
				if ((regno.length() < 18 && !StringUtil.doReplaceBlank(regno).equals(pubEppasswordTemp.getRegno()))
						|| !StringUtil.doReplaceBlank(entname).equals(StringUtil.doReplaceBlank(pubEppasswordTemp.getEntname()))
						|| (Constants.entCatgPartner.indexOf(midBaseInfoDto.getEntTypeCatg()) == -1
								&& midBaseInfoDto.getLeRep() != null && !StringUtil.doReplaceBlank(midBaseInfoDto.getLeRep())
								.equals(StringUtil.doReplaceBlank(pubEppasswordTemp.getLerep())))) {
					return AjaxResult.error("企业信息已变更，原联络员信息已无效。");
				}
			}else{
				rltMap.put("lia", "false");
			}
			rltMap.put("isNingBo", isNingBo);
			return AjaxResult.success("", rltMap);
		}
		return AjaxResult.error("");
	}
	
	/** 
	 * 描述: 校验联络员信息
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param liaidnum
	 * @param session
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/liainfoall")
    @ResponseBody
    public AjaxResult checkLiaInfoAll(String liaidnum, HttpSession session) throws Exception {
		if(StringUtils.isNotEmpty(liaidnum)){
	        // 1.从session取联络员信息
			PubEppassword pubEppasswordTemp = (PubEppassword) session.getAttribute("pubEppasswordTemp");
	        // 2.校验身份证件号码是否与信息一致
		    if(liaidnum.equals(pubEppasswordTemp.getLiaidnum())){
		    	String tel = pubEppasswordTemp.getTel();
		    	// 手机号码不为空
		    	if(tel != null && tel.length() == 11){
		    		tel = tel.substring(0,3) + "*****" + tel.substring(8, tel.length());
//		    		StringBuilder sb = new StringBuilder(pubEppasswordTemp.getLianame());
//		    		sb.replace(1, 2, "*");
		    		Map<String, Object> rltMap = new HashMap<String, Object>();
		    		rltMap.put("lianame", pubEppasswordTemp.getLianame());
					rltMap.put("entname", pubEppasswordTemp.getEntname());
		    		rltMap.put("tel", tel);
		    		return AjaxResult.success("", rltMap);
		    	}else{
		    		return AjaxResult.error("手机号数据异常，请联系系统管理员。");
		    	}
		    }else{
		    	return AjaxResult.error("联络员证件号错误!");
		    }
		}
	    return AjaxResult.error("请输入联络员证件号!");
    }
	
	/** 
	 * 描述: 国家局版本单点登录
	 * @auther ZhouYan
	 * @date 2016年12月11日 
	 * @param request
	 * @param type
	 * @param expiredFlag
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/casall/{type}", method = RequestMethod.GET)
	public ModelAndView certAllLogin(HttpServletRequest request, @PathVariable("type") String type, @CookieValue(value="CAKeyInfoExpiredFlag", defaultValue="0") String expiredFlag) throws Exception {
		AttributePrincipal principal = (AttributePrincipal)request.getUserPrincipal();
		ResultRtn<T> rtn =  loginService.doKeyLogin(principal, expiredFlag);
		if(!rtn.isSucess()){
			ModelAndView view = new ModelAndView("pub/infobulletin/fillpublicinformation");
			view.addObject("code", rtn.getErrorCode());
			view.addObject("error", rtn.getError());
			view.addObject("webServer", webServer);
			view.addObject("casServer", casServer);
			return view;
    	}
		return new ModelAndView("redirect:/reg/client/yr/yrregcheck/index_list");
		
	}
	
	
	
    /**
     * 
     * 描述: 获取手机验证码, 发送短信(个体户注册后直接登录)
     * @auther gaojinling
     * @date 2017年3月7日 
     * @param
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/getnewzcpwd")
    @ResponseBody
    public AjaxResult getNewZcPwd(String regCode,String regNo) throws Exception {
    	
		//查询
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectByRegnoAndEntname(regCode, null, null);
		
		// 1.获取联络员信息（注册号或者统一代码）
		List<PubEppassword> pubEppasswordList = pubEppasswordService.selectByRegnoOrUnicode(regCode,regNo);
		PubEppassword pubEppassword = pubEppasswordList.get(0);

        
    	// 2.生成验证码
    	String password = String.valueOf(StringUtil.NextInt(100000,999999));
    	
    	// 3.保存验证码,发送短信
	    pubEppassword.setPassword(password);
        try {
        	pubEppasswordService.updatePwd(pubEppassword);
	    	PubPbpassword pubPbpassword = new PubPbpassword();
	        pubPbpassword.setTel(pubEppassword.getTel());
	    	pubPbpassword.setPassword(password);
	    	pubPbpassword.setOperation("2");
	    	//先删除验证码列表中当前联络员获取的验证码，再保存新验证码
	    	pubPbpasswordService.deletePwd(pubPbpassword);
	    	pubPbpasswordService.save(pubPbpassword);
        	
	    	String msgContent = pubEppassword.getEntname() + "本次登录企业信用信息公示系统的验证码为" + password +"，24小时内有效";
        	smsService.doSendMsg(pubEppassword.getTel(), msgContent, midBaseInfoDto.getRegOrg());//发短信
        	//加日志
            Map<String, String> logMap = new HashMap<String, String>();
            logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID,pubEppassword.getPripid());//企业内部序号
            logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME,pubEppassword.getEntname());//企业名称
            logMap.put(ISysLogService.LOG_MAP_KEY_REGNO,pubEppassword.getRegno());//企业注册号
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR,DateUtil.getYear());//获取短信的年份
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_CLIENT);//企业端
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, msgContent);//日志内容
    		logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION,LogOperation.sendMsgBeforeLoginLog.getCode());//操作类型
    		sysLogService.doAddSysLog(logMap, ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest());
        	return AjaxResult.success("");
        } catch (Exception ex) {
        	return AjaxResult.error("");
        }
    } 
}