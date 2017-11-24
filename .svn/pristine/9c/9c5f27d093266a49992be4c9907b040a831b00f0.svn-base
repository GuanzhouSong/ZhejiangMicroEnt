/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_yr_pb_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月10日
 */
public interface IYrPbBaseInfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	public List<YrPbBaseInfo> selectYrPbBaseInfoList(String priPID,int year) throws Exception;
	
	/**
	 * 根据年份和主体身份代码进行查询
	 * @param year
	 * @param pripid
	 * @param flag(是否将万元转化为元，1转化，0不转化)
     * @return
     */
	public YrPbBaseInfo selectYrPbBaseInfoByYearAndPripid(String year, String priPID ,String flag) throws Exception;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
    public int saveYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo) throws Exception;
    
    /**
     * 
     * 描述: 更新（通过年份和主体代码更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param phoneApply
     * @return
     */
    public int updateYrPbBaseInfoByPriPidAndYear(YrPbBaseInfo yrPbBaseInfo) throws Exception;
    
    
	/**
	 * 
	 * 描述: 删除（通过年份和主体代码）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	public int deleteyYrPbBaseInfoByPriPidAndYear(String priPID,int year) throws Exception;
    
	
	
	/**
	 * 
	 * 描述: 个体户接收  （由主表数据对象封装得到基本信息表数据对象）
	 * @auther gaojinling
	 * @date 2016年9月19日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo getYrPbBaseinfoByYrRegCheck(YrRegCheck yrRegCheck) throws Exception ;
	
	/**
	 * 
	 * 描述: 个体户接收  （由年报主表数据对象封装得到公示主表数据对象）
	 * @auther gaojinling
	 * @date 2016年9月19日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo getPbBaseinfoByYrRegCheck(YrRegCheck yrRegCheck) throws Exception ;
	
	
	/**
	 * 
	 * 描述: 元转化为万元(基本信息表)
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo doWapDivideYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo) throws Exception;
	
	
	
	/**
	 * 
	 * 描述: 万元转化元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param yrPbBaseInfo
	 * @return
	 * @throws Exception
	 */
	public YrPbBaseInfo doWapMulitplyYrPbBaseInfo(YrPbBaseInfo yrPbBaseInfo)throws Exception;
    
}