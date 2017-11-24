/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年12月12日
 * @version 2.0
 */
package com.icinfo.cs.depsyn.mapper;

import com.icinfo.cs.depsyn.dto.CsDepsynLicenseDto;
import com.icinfo.cs.depsyn.model.CsDepsynLicense;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.framework.mybatis.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_depsyn_license 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月12日
 */
public interface CsDepsynLicenseMapper extends Mapper<CsDepsynLicense> {

    /**
     * 根据企业名称或注册号或统一社会信用代码查询行政处罚数据
     *
     * @param params 查询参数
     * @return 查询结果
     */
    Page<CsDepsynLicenseDto> queryLicense(Map<String, Object> params);

    /**
     * 批量新增行政处罚
     *
     * @param list 行政处罚集合
     * @return 新增条数
     */
    int addLicenseBatch(List<CsDepsynLicense> list);
}