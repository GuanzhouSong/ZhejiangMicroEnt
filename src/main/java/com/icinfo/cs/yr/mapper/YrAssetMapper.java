/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;


import com.icinfo.cs.yr.model.YrAsset;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 描述:    cs_yr_asset 对应的Mapper接口.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
public interface YrAssetMapper extends Mapper<YrAsset> {
    /**
     * 条件 查询
     * @param params
     * @return
     */
    List<YrAsset> search_queryPage(Map<String, Object> params);

    /**
     * 描述：非独立核算 更新字段为null
     * @param assetID
     * @param priPID
     */
    int updateValuesByEntBelong(@Param("assetID") String assetID,@Param("priPID") String priPID);
}