/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service;

import org.apache.poi.hssf.record.formula.functions.T;

import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.framework.core.service.BaseService;
//import com.icinfo.zjaicsso.cas.client.authentication.AttributePrincipal;
import com.icinfo.zjaicsso.cas.client.authentication.AttributePrincipal;

/** 
 * 描述: 企业端登录service接口
 * @author ZhouYan
 * @date 2016年9月28日  
 */
public interface ILoginService extends BaseService {

	/** 
	 * 描述: 企业证书登录
	 * @auther ZhouYan
	 * @date 2016年9月28日 
	 * @param sundata
	 * @param expiredFlag
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doEntKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception;
	
	/** 
	 * 描述: 个体户证书登录
	 * @auther ZhouYan
	 * @date 2016年10月9日 
	 * @param desparam
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doPbKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception;
	
	/** 
	 * 描述: 农专证书登录
	 * @auther ZhouYan
	 * @date 2016年10月23日 
	 * @param desparam
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doSFCKeyLogin(AttributePrincipal principal,String expiredFlag) throws Exception;
	
	/** 
	 * 描述: 企业联络员登录
	 * @auther ZhouYan
	 * @date 2016年9月28日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doPwdLogin(PubEppasswordDto pubEppasswordDto, String systemType) throws Exception;
	
	/** 
	 * 描述: 个体户用户名密码登录
	 * @auther ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doPbPwdLogin(PubPbePassword pubPbePassword) throws Exception;
	
	/** 
	 * 描述: 国家局版本联络员登录
	 * @auther ZhouYan
	 * @date 2016年12月10日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doPwdAllLogin(PubEppasswordDto pubEppasswordDto) throws Exception;
	
	/** 
	 * 描述: 国家局版本证书登录
	 * @auther ZhouYan
	 * @date 2016年12月11日 
	 * @param principal
	 * @param expiredFlag
	 * @return
	 * @throws Exception 
	 */
	ResultRtn<T> doKeyLogin(AttributePrincipal principal, String expiredFlag) throws Exception;

	/**
	 * 
	 * 描述: 个体户app工商联络员登录校验
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception
	 */
	ResultRtn<T> doPbPwdAppLogin(PubEppasswordDto pubEppasswordDto)throws Exception;
	
}