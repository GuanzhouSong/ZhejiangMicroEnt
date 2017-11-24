/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_asset 对应的Service接口.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
public interface IYrAssetService extends BaseService {

    /**
     * 新增数据
     * @param yrAsset
     * @return
     */
    int insert(YrAsset yrAsset);

    /**
     * 根据年份和主体身份代码进行查询
     * @return
     */
    YrAsset selectByYearAndPripid(Integer year,String pripid);


    /**
     * 默认查询 无条件
     * @param request
     * @return
     */
    List<YrAsset> queryPage(PageRequest request);

    /**
     * 单表多条件查询
     * @param request
     * @return
     */
    List<YrAsset> search_queryPage(PageRequest request);

    /**
     *  根据assetID查询
     * @param assetID
     * @return
     */
    YrAsset selectByAssetID(String assetID);

    /**
     * 更新数据
     * @param yrAsset
     * @return
     */
    int update(YrAsset yrAsset);



    /**
     * 根据uuid进行 逻辑删除
     * @param uuid
     * @return
     */
    int updateByUuid(String uuid);
    /**
     * 根据uuid进行 物理删除
     * @param uuid
     * @return
     */
    int deleteByUuid(String uuid);
    /**
	 * 
	 * 描述: 根据年份和主体身份代码进行查询for分支机构
	 * @auther ljx
	 * @date 2016年10月9日 
	 * @param year
	 * @param priPId
	 * @return
	 */
	YrAsset selectByYearPridIdForBranch(Integer year, String priPId);
	/**
	 * 
	 * 描述: 保存for分支机构
	 * @auther ljx
	 * @date 2016年10月9日 
	 * @param yrAsset
	 * @return
	 */
	int insertForBranch(YrAsset yrAsset);
     /**
      * 
      * 描述: 更新for分支机构
      * @auther ljx
      * @date 2016年10月9日 
      * @param yrAsset
      * @return
      */
	int updateForBranch(YrAsset yrAsset);
	
	/** 
	 * 描述: 根据内部序号年度查询，不转换金额
	 * @auther ZhouYan
	 * @date 2016年10月25日 
	 * @param year
	 * @param pripid
	 * @return 
	 */
	YrAsset selectYrAssetByYearAndPripid(int year,String pripid);

}