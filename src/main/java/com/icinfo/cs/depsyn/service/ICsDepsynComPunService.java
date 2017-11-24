/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.dto.CsDepsynComPunDto;
import com.icinfo.cs.depsyn.model.CsDepsynComPun;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_com_pun 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface ICsDepsynComPunService extends BaseService {

    /**
     * 根据证照号码/证件号码, 姓名查询
     *
     * @param params 查询参数
     * @return 查询结果
     */
    List<CsDepsynComPunDto> queryComPun(Map<String, Object> params) throws Exception;

    /**
     * 新增
     * @param csDepsynComPun
     * @return
     */
    int addComPun(CsDepsynComPun csDepsynComPun);
    /**
     * 获取数据反馈信息
     * @author zjj
     */
    List<CsDepsynComPunDto> searchFeedBackList (PageRequest request) throws Exception;
    /**
     * 条件查询
     * @author zjj
     */
    List<CsDepsynComPunDto> selectDepsynComPunList(Map<String, Object> params) throws Exception;
}