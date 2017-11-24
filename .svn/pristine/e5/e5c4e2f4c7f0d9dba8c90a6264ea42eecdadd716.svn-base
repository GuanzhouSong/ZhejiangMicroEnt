/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.model.CsDepsynSmall;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_small 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface ICsDepsynSmallService extends BaseService {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询小微企业扶持
     *
     * @param params
     * @return
     * @throws Exception
     */
    Map<String,Object> querySmall(Map<String, Object> params) throws Exception;

    /**
     * 新增小微企业扶持
     *
     * @param csDepsynSmall 小微企业扶持
     * @return 新增条数
     * @throws Exception
     */
    int addSmall(CsDepsynSmall csDepsynSmall) throws Exception;

    /**
     * 批量新增行政处罚
     *
     * @param list 行政处罚集合
     * @return 新增条数
     * @throws Exception
     */
    int addSmallBatch(List<CsDepsynSmall> list) throws Exception;
}