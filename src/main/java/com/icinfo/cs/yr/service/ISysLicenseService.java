/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_license 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface ISysLicenseService extends BaseService {

    /**
     * 描述：许可证清单维护列表
     *
     * @author baifangfang
     * @date 2016年8月30日
     * @param request
     * @return
     */
    List<SysLicense> queryPageResult(PageRequest request);

    /**
     * 描述：根据sysLicenseId查询许可证清单(进入添加或修改页面)
     *
     * @author baifangfang
     * @date 2016年8月30日
     * @param sysLicenseId
     * @return
     */
    SysLicense doGetSysLicenseById(Integer sysLicenseId);

    /**
     * 描述：删除许可证
     * @author baifangfang
     * @date 2016年9月8日
     * @param sysLicenseId
     * @return
     */
    int deleteById(Integer sysLicenseId);

    /**
     * 描述：更新许可证
     * @author baifangfang
     * @date 2016年9月8日
     * @param sysLicense
     * @return
     */
    int update(SysLicense sysLicense);

    /**
     * 描述：添加许可证
     * @author baifangfang
     * @date 2016年9月8日
     * @param sysLicense
     * @return
     */
    int insert(SysLicense sysLicense);

    /**
     *
     * 描述: 根据licNo查询单个许可证
     * @auther gaojinling
     * @date 2016年9月26日
     * @param licNo
     * @return
     */
    SysLicense selectOneByLicNO(String licNo);

    /**
     *
     * 描述: 查询有效的许可证列表
     * @auther gaojinling
     * @date 2016年9月26日
     * @return
     */
    List<SysLicense> selectVaildLicList(String liccontent);

    /**
     *
     * 描述: 获取无证无照涉嫌违法事项列表
     * @auther ylr
     * @date 2016年11月4日
     * @return
     */
    List<SysLicense> selectSysLicenseList(Map<String, Object> qryMap) throws Exception;


    List<Map<String,String>> listSelect(String licName);
    
    /**
    *
    * 描述: 查询有效的许可证列表(优先排序为已经设置的优先级)
    * @auther gaojinling
    * @date 2016年9月26日
    * @return
    */
   public List<SysLicense> selectVaildLicListOrderBy(String licConent) throws Exception;
}