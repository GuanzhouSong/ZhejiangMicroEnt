/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.cs.system.model.SysPermision;

import java.util.List;
import java.util.Map;

/**
 * 描述:  SysPermision Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年04月14日
 */
public interface SysPermisionMapper extends Mapper<SysPermision> {
    /**
     * 查询用户权限
     *
     * @param params
     * @return
     */
    List<SysPermision> selectUserPermisions(Map<String, Object> params);

    /**
     * 根据系统类型查询用户权限
     *
     * @param sysType
     * @return
     */
    List<SysPermision> selectPermisionsBySysType(String sysType);

    /**
     * 根据角色IDS来获取权限
     * @param params
     * @return
     */
    List<SysPermision> selectUserPermisionsByRoleIds(Map<String, Object> params);

}