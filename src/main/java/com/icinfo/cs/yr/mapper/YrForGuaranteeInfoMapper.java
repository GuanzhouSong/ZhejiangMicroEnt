/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_yr_forguaranteeinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface YrForGuaranteeInfoMapper extends Mapper<YrForGuaranteeInfo> {
    
    /**
     * 列表查询
     * @author: wangjin
     * @param params
     * @return
     */
    List<YrForGuaranteeInfo> search_queryPage(Map<String, Object> params);
    
    /** 
     * 描述: 根据自然人身份证号获取 个人对外提供担保信息
     * @author 张文男
     * @date 2017年3月17日 
     * @param params
     * @return 
     */
    
    List<YrForGuaranteeInfo> selectListByCerNO(Map<String, Object> params);

    /**
     * 获取 主债额的 合计
     * @author: wangjin
     * @param queryMap
     * @return
     */
    BigDecimal sumMoeny(Map<String, Object> queryMap);

}