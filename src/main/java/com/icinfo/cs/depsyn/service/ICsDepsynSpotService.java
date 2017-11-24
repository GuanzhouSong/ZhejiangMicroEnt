/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.dto.CsDepsynSpotDto;
import com.icinfo.cs.depsyn.model.CsDepsynSpot;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_spot 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface ICsDepsynSpotService extends BaseService {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询抽查检查数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    Map<String,Object> querySpot(Map<String, Object> params) throws Exception;

    /**
     * 新增抽查检查
     *
     * @param csDepsynSpot 抽查检查
     * @return 新增条数
     * @throws Exception
     */
    int addSpot(CsDepsynSpot csDepsynSpot) throws Exception;

    /**
     * 批量新增抽查检查
     *
     * @param list 抽查检查集合
     * @return 新增条数
     * @throws Exception
     */
    int addSpotBatch(List<CsDepsynSpot> list) throws Exception;
    /**
     * 获取抽检抽查数据
     * @author zjj
     */
    List<CsDepsynSpotDto> searchSpot(PageRequest request) throws Exception;
}