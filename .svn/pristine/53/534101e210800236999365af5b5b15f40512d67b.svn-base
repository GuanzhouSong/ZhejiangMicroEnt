/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.depsyn.service;

import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_license 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface ICsDepsynLicenseService extends BaseService {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政许可数据
     *
     * @param params
     * @return
     * @throws Exception
     */
    Map<String,Object> queryLicense(Map<String, Object> params) throws Exception;
    
    
    /**
     * 
     * @param params
     * @return
     * @throws Exception
     */
    public int queryLicenseTotal(Map<String, Object> params) throws Exception;

    /**
     * 新增行政处罚
     *
     * @param csDepsynLicense 行政许可
     * @return 新增条数
     * @throws Exception
     */
    int addLicense(CsDepsynLicense csDepsynLicense) throws Exception;

    /**
     * 批量新增行政处罚
     *
     * @param list 行政处罚集合
     * @return 新增条数
     * @throws Exception
     */
    int addLicenseBatch(List<CsDepsynLicense> list) throws Exception;
    /**
     * 获取行政许可内容
     * @author zjj
     * @param request
     * @return
     * @throws Exception
     */
    List<CsDepsynLicenseDto> searchLicense(PageRequest request) throws Exception;
    /**
     * 获取行政许可内容
     * @author zjj
     */
    List<CsDepsynLicenseDto> selectLicenseList(Map<String, Object> params) throws Exception;
    /**
     * 修改行政许可内容
     * @author zjj
     */
    int editLicense(CsDepsynLicense csDepsynLicense)throws Exception;
    /**
     * 删除行政许可内容
     * @author zjj
     */
    int deleteLicense(String id) throws Exception;;
}