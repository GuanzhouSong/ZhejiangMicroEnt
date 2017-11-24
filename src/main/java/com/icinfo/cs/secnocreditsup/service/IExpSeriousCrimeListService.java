/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.service;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_exp_serious_crime_list 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
public interface IExpSeriousCrimeListService extends BaseService {

	/**
     * 查询已列入严重违法名单列表（用于公告）
     * @author yujingwei
     * @date 2016-10-17
     * @return List<ExpSeriousCrimeList>
     * @throws Exception
     */
	public List<ExpSeriousCrimeList> selectSeriousCrimeInfoForBulletin(String updateDate) throws Exception; 
	
	/**
     * 描述:获取异常类严违名单列入申请列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	List<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception;
	
	/**
     * 描述:获取异常类严违名单列入申请列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	List<ExpSeriousCrimeListDto> doGetExpSecSearchList(PageRequest request) throws Exception;
	
	
	
	/**
     * 描述:获取异常类严违名单列入申请列表
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月28日
     */
	List<ExpSeriousCrimeListDto> doGetExpFirstReviewList(PageRequest request) throws Exception;
	
	
	
	/**
     * 描述:异常类严违名单数据列入
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年11月29日
     */
	Integer insertExpSeriousCrimeList(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception;
	
	/**
     * 描述:根据sourceId获取异常类严违名单数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	ExpSeriousCrimeList selectSeriousCrimeBySourceId(String sourceId) throws Exception;
	
	/**
     * 描述:根据UId获取异常类严违名单数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月9日
     */
	ExpSeriousCrimeList selectSeriousCrimeByUID(String uid) throws Exception;
	
	
	/**
     * 描述:异常类严违名单数据修改
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	Integer updateExpSeriousCrimeList(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception;
	
	/**
     * 描述:异常类严违名单数据删除
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月1日
     */
	Integer deleteExpSeriousCrimeList(String sourceId) throws Exception;
	
	/**
     * 描述:获取待初审的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	Integer getNumByBusinessStatus(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述:获取列入严违最大文号
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月4日
     */
	Integer selectMaxAddSecCountNo(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述:获取待初审的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	Integer getYQLRNum(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述:获取待初审的数目
     *
     * @throws Exception
     * @auther chenyu
     * @date 2016年12月1日
     */
	Integer getDLRNum(Map<String, Object> qryMap) throws Exception; 
	
	/**
     * 描述:异常类严违名单数据修改--完全修改包含所有字段
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月22日
     */
	Integer updateExpSeriousCrimeListForAll(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception;
    
	/**
     * 查询已列入严重违法名单列表（用于公告）
     * @author yujingwei
     * @date 2016-10-17
     * @return List<ExpSeriousCrimeList>
     * @throws Exception
     */
	public List<ExpSeriousCrimeList> selectSeriousCrimeInfoByPriPID(String priPID) throws Exception;
	
	public Integer UpdateSomeMsg(String sourceId) throws Exception;

}