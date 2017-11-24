/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.model.CsDepsynNotice;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_notice 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface ICsDepsynNoticeService extends BaseService {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param params 查询参数
     * @return
     * @throws Exception
     */
    List<CsDepsynNotice> queryNotice(Map<String, Object> params) throws Exception;

    /**
     * 新增
     *
     * @param csDepsynNotice
     * @return
     */
    int addNotice(CsDepsynNotice csDepsynNotice);
}