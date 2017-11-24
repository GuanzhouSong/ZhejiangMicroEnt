/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_yr_sfc_social_security 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年12月21日
 */
public interface IYrSfcSocialSecurityService extends BaseService {
	
	
	/**
	 * 根据年报id查询
	 * @param anCheID
	 * @param flag(是否将万元转化为元，1转化，0不转化)
     * @return
     */
	public YrSfcSocialSecurity selectYrSfcSocialSecurityByAnCheID(String anCheID ,String flag) throws Exception;
	

	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2017年12月21日 
	 * @param yrSfcSocialSecurity
	 * @return
	 * @throws Exception
	 */
    public int saveYrSfcSocialSecurity(YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception;

    /**
     * 
     * 描述: 更新（）
     * @auther gaojinling
     * @date 2017年12月21日 
     * @param yrSfcSocialSecurity
     * @return
     * @throws Exception
     */
    public int updateYrSfcSocialSecurityByID(YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception;
}