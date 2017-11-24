/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrSfcBaseinfo;
import com.icinfo.cs.yr.model.YrSfcSocialSecurity;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_yr_sfc_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月27日
 */
public interface IYrSfcBaseinfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	public List<YrSfcBaseinfo> selectYrSfcBaseInfoList(String priPID,int year) throws Exception;
	
	/**
	 * 根据年份和主体身份代码进行查询
	 * @param year
	 * @param pripid
	 * @param flag(是否将万元转化为元，1转化，0不转化)
     * @return
     */
	public YrSfcBaseinfo selectYrSfcBaseInfoByYearAndPripid(String year, String priPID ,String flag) throws Exception;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param yrSfcBaseInfo
	 * @return
	 */
    public int saveYrSfcBaseInfo(YrSfcBaseinfo yrSfcBaseInfo) throws Exception;
    
    /**
     * 
     * 描述: 更新（通过年份和主体代码更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param yrSfcBaseinfo
     * @return
     */
    public int updateYrSfcBaseinfoByPriPidAndYear(YrSfcBaseinfo yrSfcBaseinfo) throws Exception;
    
    
    /**
     * 
     * 描述: 由yrSfcBaseinfo得到YrSfcSocialSecurity
     * @auther gaojinling
     * @date 2016年12月22日 
     * @return
     * @throws Exception
     */
    public YrSfcSocialSecurity baseinfotransformSocialSecurity(YrSfcBaseinfo yrSfcBaseinfo,YrSfcSocialSecurity yrSfcSocialSecurity) throws Exception;
    
    
}