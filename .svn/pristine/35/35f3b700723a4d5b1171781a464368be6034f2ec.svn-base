/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public interface IPbBaseinfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	public List<PbBaseinfo> selectPbBaseInfoList(String priPID,int year) throws Exception;
	
	/**
	 * 
	 * 描述: 根据主体代码和年份查询单个基本信息
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param PriPID
	 * @param year
	 * @return
	 */
	public PbBaseinfo selectPbBaseInfoByPriPIdAndYear(String priPID, String year) throws Exception ;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
    public int savePbBaseInfo(PbBaseinfo pbBaseInfo) throws Exception;
    
    /**
     * 
     * 描述: 更新（通过年份和主体代码更新）
     * @auther gaojinling
     * @date 2016年8月31日 
     * @param phoneApply
     * @return
     */
    public int updatePbBaseInfoByPriPidAndYear(PbBaseinfo pbBaseInfo) throws Exception;
    
    /**
     * 
     * 描述: 更新（主键）
     * @auther gaojinling
     * @date 2016年9月11日 
     * @param yrPbBaseInfo
     * @return
     */
    public int updatePbBaseInfoByPriKey(PbBaseinfo pbBaseInfo) throws Exception;
    
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
	public int deletePbBaseInfoByPriPidAndYear(String priPID,int year) throws Exception;
    
    
	/**
	 * 
	 * 描述: 元转化为万元（公示基本信息(公示主表)）
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo doWapDividePbBaseInfo(PbBaseinfo pbBaseinfo) throws Exception;
    
    
    /**
	 * 
	 * 描述: 元转化为万元
	 * @auther gaojinling
	 * @date 2016年9月11日 
	 * @param indBaseInfo
	 * @return
	 * @throws Exception
	 */
	public PbBaseinfo doWapMulitplyPbBaseInfo(PbBaseinfo pbBaseinfo) throws Exception;
	
	/** 
	 * 描述: 根据年报id删除公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param anCheID
	 * @return
	 * @throws Exception 
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;
	
	/** 
	 * 描述: 保存公示信息
	 * @auther ZhouYan
	 * @date 2016年10月10日 
	 * @param baseInfo
	 * @return
	 * @throws Exception 
	 */
	public int insert(PbBaseinfo pbBaseinfo)throws Exception;
	/**
	 * 描述：根据PripID查询个体户年报ID列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param priPID
	 * @return
	 */
	public List<PbBaseinfoDto> queryPbAncheIDList(String priPID);

	/**
	 * 描述：根据PripID和year查询个体户年报信息
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param priPID
	 * @param year
	 * @return
	 */
	public PbBaseinfoDto  queryPbYrInfoByPriPIDAndYear(String priPID, String year);

	/**
	 * 描述：根据PripID查询个体户年报信息
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param priPID
	 * @return
	 */
	List<PbBaseinfoDto>queryPbYrInfoByPriPID(String priPID);

	/**
	 * 描述：个体户年报信息查看详情列表页
	 * @author baifangfang
	 * @date 2016年10月31日
	 * @param request
	 * @return
	 */
	public List<PbBaseinfoDto> queryPageResult(PageRequest request);
	/**
	 * 
	 * 描述: 根据年报ID查询敏感词审核情况
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param AncheID
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String AncheID);
	
	/**
	 * 描述: 根据priPID和year查询敏感词审核情况
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param priPID
	 * @param year
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String priPID, Integer year);

	/**
	 * 描述：个体户资产状况信息查询
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param request
	 * @return
	 */
	public List<PbBaseinfoDto> selectPbBaseinfoAssetList(PageRequest request);

	/**
	 * 描述：个体户资产状况统计
	 * @author baifangfagn
	 * @date 2017年6月8日
	 * @param request
	 * @return
	 */
	public YrAssetCount queryPbYrAssetCount(PageRequest request);

}