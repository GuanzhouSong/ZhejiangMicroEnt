/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.text.ParseException;
import java.util.List;

import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface IBaseInfoService extends BaseService {

	/**
	 * 
	 * 描述 : 根据年报ID分页查询 公示 年报基本信息 @author: 赵祥江 @date : 2016年9月9日 下午3:55:12 @param
	 * : anCheID:年报ID @return: List<BaseInfo> @throws
	 */
	public List<BaseInfo> queryPage(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述 : 根据pripID,year 查企业年报基本信息 @author: yujingwei @date : 2016年9月13日 @param
	 * : priPID，year @return: BaseInfo @throws
	 */
	public BaseInfo selectInfoByPripidAndYear(String priPID, Integer year) throws Exception;

	/**
	 * 描述: 根据年报id删除公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */
	public int deleteByAnCheID(String anCheID) throws Exception;

	/**
	 * 描述: 保存公示信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年9月19日
	 * @param baseInfo
	 * @return
	 * @throws Exception
	 */
	public int insert(BaseInfo baseInfo) throws Exception;

	/**
	 * 
	 * 描述: 根据PripID查询年报ID列表
	 * 
	 * @auther chenyl
	 * @date 2016年9月26日
	 * @param priPID
	 * @return
	 */
	public List<BaseInfoDto> queryAncheIDList(String priPID);

	/**
	 * 描述：企业年报信息查看详情列表页
	 * 
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param request
	 * @return
	 */
	public List<BaseInfoDto> queryPageResult(PageRequest request);

	/**
	 * 描述：根据priPID和year查询该企业年报信息
	 * 
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param priPID
	 * @param year
	 * @return
	 */
	public BaseInfoDto queryYrInfoByPriPIDAndYear(String priPID, String year);

	/**
	 * 
	 * 描述: 根据年报ID查询敏感词审核情况
	 * 
	 * @auther chenyl
	 * @date 2016年11月4日
	 * @param AncheID
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String AncheID);

	/**
	 * 描述: 根据priPID和year查询敏感词审核情况
	 * 
	 * @auther chenyl
	 * @date 2016年11月4日
	 * @param priPID
	 * @param year
	 * @return
	 */
	public String queryAnduitStateInfoByAncheID(String priPID, Integer year);

	/**
	 * 描述：企业年报资产信息查询
	 * 
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param request
	 * @return
	 */
	public List<BaseInfoDto> selectEntBaseinfoAssetList(PageRequest request) throws ParseException;

	/**
	 * 描述：年报资产类信息统计（企业）
	 * 
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param request
	 * @return
	 */
	public YrAssetCount queryEntYrAssetCount(PageRequest request);

}