package com.icinfo.cs.sment.service.impl;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.logintoken.CSLoginToken;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.common.utils.SysUnifiedServiceUtil;
import com.icinfo.cs.sment._enum.LogTypeEnum;
import com.icinfo.cs.sment.model.SmLog;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysLog;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.framework.common.exception.GenericException;
import com.icinfo.framework.security.shiro.UserProfile;
import com.insigma.odin.framework.ucenter.FunctionDTO;
import com.insigma.odin.framework.ucenter.interf.DpInterface;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: TODO
 * @author: 赵祥江 
 * @date: 2017年6月8日 下午4:30:14
 * @version: V1.0  
 */
public class SmentDpInterfaceUnifiedUserImpl extends CSBaseController  implements DpInterface {
 	private final static Logger logger = LoggerFactory.getLogger(SmentDpInterfaceUnifiedUserImpl.class);

	@Override
	public Object doOther(HttpServletRequest arg0, ServletResponse arg1,
			ServletContext arg2) throws Exception {
		 
		return null;
	}

	@Override
	public List<FunctionDTO> getTreeNode(HttpServletRequest arg0,
			ServletResponse arg1, ServletContext arg2) throws Exception {
		 
		return null;
	}

	/**
	 * 
	 * 描述   登录
	 * @author  赵祥江
	 * @date 2017年6月8日 下午4:35:09 
	 * @param  
	 * @throws
	 */
	@Override
	public void loginApp(String loginname,HttpServletRequest request,
			ServletResponse servletresponse,ServletContext servCtx) throws Exception {
		SysUnifiedServiceUtil sysUnifiedServiceUtil=new SysUnifiedServiceUtil(); 
		String msgContent="";
		//校验用户名
		if(StringUtil.isBlank(loginname)){
			msgContent="小微系统统一用户登录日志:用户名不能为空";
			logger.error(msgContent);
			//保存日志
			this.saveUnifiedLog(request, msgContent, null, loginname);
			throw new GenericException(msgContent);
		}
		//截取用户名因为登录平台传过来的格式是xxxx.300000
		String[] loginnameArr= loginname.split("\\.");
		loginname=loginnameArr[0].trim();  
		//根据用户名获取用户
		List<SysUser>  sysUserList= sysUnifiedServiceUtil.getSysUserService().selectSysUserListByLoginNameAndUserType(loginname, DBAuthorConstants.USER_TYPE_SMENT);
		SysUser sysUserTem=null;
		//SysUser sysUserTem=sysUnifiedServiceUtil.getSysUserService().selectByLoginName(loginname, DBAuthorConstants.USER_TYPE_SMENT); 
		if(sysUserList!=null&&sysUserList.size()>0){
			sysUserTem=sysUserList.get(0);
		}
		SysUserDto sysUser=null;
		UserProfile userProfile=null;
		HttpSession  session =request.getSession();
		if(sysUserTem!=null){ 
			if(!DBAuthorConstants.USER_TYPE_SMENT.equals(sysUserTem.getUserType())){
				    msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】不属于小微系统范围";
					logger.error(msgContent);
					//保存日志
					this.saveUnifiedLog(request, msgContent, null, loginname);
					throw new GenericException(msgContent);
		    } 
			if("0".equals(sysUserTem.getStatus())){
				    msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】已失效";
					logger.error(msgContent);
					//保存日志
					this.saveUnifiedLog(request, msgContent, null, loginname);
					throw new GenericException(msgContent);
		    }  
			
			//密码解密
			String decodePas="";
			try {
				decodePas=AESEUtil.decodeCorpid(sysUserTem.getUserPasswordKey());
			} catch (Exception e) {
				msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】密码解密错误";
				logger.error(msgContent);
				//保存日志
				this.saveUnifiedLog(request, msgContent, null, loginname);
				throw new GenericException(msgContent);
			} 
			
			try {
				  CSLoginToken loginToken = new CSLoginToken(sysUserTem.getUsername(), decodePas);
	              loginToken.setUserType(DBAuthorConstants.USER_TYPE_SMENT);
	              loginToken.setSysUser(sysUserTem);
	              Subject subject = SecurityUtils.getSubject();
	              subject.login(loginToken);
	              session.setAttribute(Constants.SESSION_SYS_USER_KEY, subject.getPrincipal());
	              userProfile = (UserProfile)subject.getPrincipal();
	              sysUser = sysUnifiedServiceUtil.getSysUserService().selectUserByUId(userProfile.getUserId());
	              request.setAttribute("menus",userProfile==null?"":userProfile.getMenus());
	              request.setAttribute("userProfile", userProfile);
			   } catch (Exception e) {
					 msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】用户名或密码错误";
					 logger.error("小微系统统一用户登录日志:用户名【"+loginname+"】用户名或密码错误",e);
					 //保存日志
					 this.saveUnifiedLog(request, msgContent, sysUserTem, loginname);
					 throw new GenericException(msgContent);
			  } 
        	 try { 
                 DepartMent departMent=(sysUser.getDepartMent()==null)?sysUnifiedServiceUtil.getDepartMentService().selectOne(sysUser.getDeptCode()):sysUnifiedServiceUtil.getDepartMentService().selectOne(sysUser.getDepartMent().getDeptCode());
    			 if(departMent==null){
    				 msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】没有找到对应部门的信息";
					 logger.error("小微系统统一用户登录日志:用户名【"+loginname+"】没有找到对应部门的信息");
					 //保存日志
					 this.saveUnifiedLog(request, msgContent, sysUserTem, loginname);
					 throw new GenericException(msgContent);
    			 }  
                 sysUser.setDepartMent(departMent);
                 sysUser.setDeptCode(departMent.getDeptCode());
                 session.setAttribute(Constants.SESSION_SYS_USER, sysUser); 
                 session.setAttribute(Constants.SESSION_SYS_USER_KEY, userProfile);
                 //修改最近登录时间
    		     sysUnifiedServiceUtil.getSysUserService().modLastLoginTime(sysUserTem.getId()); 
    		     msgContent="小微系统统一用户登录日志:登录用户名【"+sysUser.getUsername()+"】 姓名:【"+sysUser.getRealName()+"】  所属部门：【"+sysUser.getDepartMent().getDeptName()+"】登录成功";
    		     logger.info(msgContent);
    		     this.saveUnifiedLog(request, msgContent, sysUserTem, loginname);
    		     
    		     //保存小微登录日志
    		     this.saveSmLog(request, loginname);
             } catch (Exception e) {
                e.printStackTrace();
                msgContent="小微系统统一用户登录日志:用户名【"+loginname+"】获取用户部门信息错误";
                logger.error("小微系统统一用户登录日志:用户名【"+loginname+"】获取用户部门信息错误",e);
                this.saveUnifiedLog(request, msgContent, sysUserTem, loginname); 
            	throw new GenericException(msgContent);
             } 
		}else{
			msgContent="小微系统统一用户登录日志:根据用户名【"+loginname+"】没有找到对应的用户信息";
			logger.error(msgContent);
			//保存日志
			this.saveUnifiedLog(request, msgContent, sysUserTem, loginname); 
			throw new GenericException(msgContent);
		}
	}

	@Override
	public void logoutApp(HttpServletRequest arg0, ServletResponse arg1,
			ServletContext arg2) throws Exception {
		 
		
	}
	
	
	 /**
     * 
     * 描述   保存统一用户登录日志
     * @author 赵祥江
     * @date 2017年6月6日 上午10:02:14 
     * @param 
     * @return void
     * @throws
     */
     private void saveUnifiedLog(HttpServletRequest req,String msgContent,SysUser sysUser,String loginname){
         try{
        	SysUnifiedServiceUtil sysUnifiedServiceUtil=new SysUnifiedServiceUtil();
        	SysLog sysLog=new SysLog();
 			sysLog.setYear(Integer.parseInt(DateUtil.getYear()) );
 			sysLog.setLogMsg(msgContent);
 			sysLog.setLogOperation(LogOperation.smentunifiedLoginLog.getCode()); 
 			sysLog.setSetTime(DateUtil.getSysDate());
 			sysLog.setSetName(sysUser==null?null:sysUser.getRealName());
 			sysLog.setRemark(loginname);
 			String callIp = RequestUtil.getIpAddress(req);
         	if("0:0:0:0:0:0:0:1".equals(RequestUtil.getIpAddress(req))){
         		callIp = "127.0.0.1";
         	}
 			sysLog.setCallIp(callIp);
 			sysUnifiedServiceUtil.getSysLogMapper().insert(sysLog);
         }catch(Exception e){
             logger.error("记录小微系统登录日志时出现异常:"+e.getMessage(),e);
         }
     } 
     
     /**
      * 
      * 描述   保存小微日志
      * @author 赵祥江
      * @date 2017年9月8日 下午2:40:43 
      * @param 
      * @return void
      * @throws
      */
     private void saveSmLog(HttpServletRequest req,String loginname){
         try{
        	SysUnifiedServiceUtil sysUnifiedServiceUtil=new SysUnifiedServiceUtil();
        	SmLog smLog=new SmLog();
 			String callIp = RequestUtil.getIpAddress(req);
         	if("0:0:0:0:0:0:0:1".equals(RequestUtil.getIpAddress(req))){
         		callIp = "127.0.0.1";
         	}
         	smLog.setLogIp(callIp);
         	smLog.setLogRemark("");
         	smLog.setLogStatue("SUCCESS");
         	smLog.setLogTime(DateUtil.getSysDate());
         	smLog.setLogType(LogTypeEnum.LOGIN.toString());
         	smLog.setLogUser(loginname);
         	sysUnifiedServiceUtil.getSmLogMapper().insert(smLog);
         }catch(Exception e){
             logger.error("记录小微系统登录日志时出现异常:"+e.getMessage(),e);
         }
     } 
     
     
     
}
