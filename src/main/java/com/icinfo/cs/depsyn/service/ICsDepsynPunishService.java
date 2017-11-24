/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.dto.CsDepsynPunishDto;
import com.icinfo.cs.depsyn.model.CsDepsynPunish;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_punish 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月10日
 */
public interface ICsDepsynPunishService extends BaseService {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    Map<String, Object> queryPunish(Map<String,Object> params) throws Exception;

    /**
     * 查询行政处罚数据
     */
    List<CsDepsynPunishDto> searchPunish(PageRequest request) throws Exception;
    /**
     * 查询行政处罚数据
     */
  	public int  searchPunishTotal(Map<String,Object> qryMap) throws Exception;

    /**
     * 新增行政处罚
     *
     * @param csDepsynPunish 行政处罚
     * @return 新增条数
     * @throws Exception
     */
    int addPunish(CsDepsynPunish csDepsynPunish) throws Exception;

    /**
     * 批量新增行政处罚
     *
     * @param list 行政处罚集合
     * @return 新增条数
     * @throws Exception
     */
    int addPunishBatch(List<CsDepsynPunish> list) throws Exception;
    /**
     * 查询行政处罚数据
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<CsDepsynPunishDto> selectPunishList(Map<String,Object> qryMap) throws Exception;
    
    /**
     * 修改行政处罚信息
     * @author zjj
     */
    int editPunish(CsDepsynPunish csDepsynPunish) throws Exception;
    /**
     * 删除行政处罚信息
     * @author zjj
     */
    int deletePunish(String id) throws Exception;
}