/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月30日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sys_license 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface SysLicenseMapper extends Mapper<SysLicense> {

    /**
     * 描述：根据查询条件查询许可证列表
     * @author
     * @date 2016年9月14日
     * @param params
     * @return
     */
    List<SysLicense> queryPageResult(Map<String, Object> params);

    /**
     * 描述: 获取无证无照涉嫌违法事项列表
     * @auther ylr
     * @date 2016年11月4日
     * @return
     */
    List<SysLicense> selectSysLicenseList(Map<String, Object> qryMap);

    List<Map<String,String>> listSelect(Map param);
}