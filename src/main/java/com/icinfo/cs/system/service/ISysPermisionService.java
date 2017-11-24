/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.cs.system.model.SysPermision;

import java.util.List;
import java.util.Map;

/**
 * 描述:  系统权限业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysPermisionService extends BaseService {
    /**
     * 添加系统权限
     *
     * @param sysPermision
     * @return
     * @throws Exception
     */
    int insert(SysPermision sysPermision) throws Exception;

    /**
     * 加载所有权限数据
     * @param qryMap 查询参数
     * @return
     */
    List<SysPermision> selectAll(Map<String,Object> qryMap);

    /**
     * 通过主键获取系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysPermision selectByPrimaryKey(String id) throws Exception;

    /**
     * 通过主键删除系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 更新权限数据
     *
     * @param sysPermision
     * @return
     * @throws Exception
     */
    int update(SysPermision sysPermision) throws Exception;

    /**
     * 是否有子权限
     *
     * @param id 权限ID
     * @return
     * @throws Exception
     */
    boolean isHaveSub(String id) throws Exception;

    /**
     * 查询用户权限列表
     *
     * @param userId
     * @return
     */
    List<SysPermision> selectUserPermisions(String userId);

    /**
     * 根据资源名称关键字来模糊匹配搜索
     * @author ZhuDefeng
     * @date 2016-12-08
     * @param keyWord
     * @param sysUserDto
     * @return
     * @throws Exception
     */
    List<SysPermision> findPermisionByPerName(String keyWord,SysUserDto sysUserDto)throws Exception;

    /**
     * 根据角色岗位来查询权限
     * @author ZhuDefeng
     * @date 2017-01-19
     * @param roleIds
     * @return
     * @throws Exception
     */
    List<SysPermision> selectAll4RoleIds(String roleIds)throws Exception;

}
