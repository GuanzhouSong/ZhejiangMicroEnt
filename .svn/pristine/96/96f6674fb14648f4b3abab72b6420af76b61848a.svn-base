/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.YrOtherInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_otherinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月31日
 */
public interface IYrOtherInfoService extends BaseService {


    /**
     * 根据 年份和身份主体代码查询当前对象
     * @param year
     * @param pripid
     * @return
     */
    YrOtherInfo selectByYearAndPripid(Integer year, String pripid);



	/**
     * 默认查询 无条件
     * @param request
     * @return
     */
    List<YrOtherInfo> queryPage(PageRequest request);

    /**
     * 单表多条件查询
     * @param request
     * @return
     */
    List<YrOtherInfo> search_queryPage(PageRequest request);

    /**
     *  根据assetID查询
     * @param OtherID
     * @return
     */
    YrOtherInfo selectByAssetID(String OtherID);

    /**
     * 更新数据
     * @param yrOtherInfo
     * @return
     */
    int update(YrOtherInfo yrOtherInfo);

    /**
     * 新增数据
     * @param yrOtherInfo
     * @return
     */
    int insert(YrOtherInfo yrOtherInfo);

    /**
     * 根据otherID进行 物理删除
     * @param otherID
     * @return
     */
    int deleteByUuid(String otherID);
    
    /**
     * 
     * 描述: 根据主体代码和年份查询其他信息表
     * @auther gaojinling
     * @date 2016年9月8日 
     * @return
     */
    public YrOtherInfo selectOtherInfoListByYearPriID(String priPID,int year);
    
    /**
     * 根据 年份和身份主体代码集查询当前对象集合
     * 
     * @author zhuyong
     * @param year
     * @param pripid
     * @return
     */
    public List<YrOtherInfo> selectByYearAndPripidList(List<String> pripidList , int year);

    
    
 /*   *//**
     * @throws Exception 
     * 
     * 描述             : 获取网站 其他情况信息
     * @author: 赵祥江
     * @date  : 2016年9月12日 下午7:01:38 
     * @param :
     * @return: Map<String,Object>
     * @throws
     *//*
    public Map<String,Object>   getOtherCircsIniRpt (Map<String, String> qryMap) throws Exception;
    
    *//**
     * 
     * 描述             : TODO
     * @author: 赵祥江
     * @date  : 2016年9月13日 上午9:34:41 
     * @param :
     * @return: int
     * @throws
     *//*
    public int insertYrOtherInfo(YrOtherInfo yrOtherInfo);*/


}