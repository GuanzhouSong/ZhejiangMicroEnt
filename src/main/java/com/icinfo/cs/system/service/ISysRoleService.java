/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.cs.system.model.SysRole;

import java.util.List;

/**
 * 描述:  系统用户角色业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysRoleService extends BaseService {
    /**
     * 添加用户角色
     *
     * @param sysRole
     * @return
     * @throws Exception
     */
    int insert(SysRole sysRole, String[] permisions) throws Exception;

    /**
     * 更新用户角色
     *
     * @param sysRole
     * @return
     * @throws Exception
     */
    int update(SysRole sysRole, String[] permitions) throws Exception;

    /**
     * 删除用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 通过主键查询用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    SysRole selectByPrimaryKey(String id) throws Exception;
    
    /**
     * 通过角色名称查询用户角色
     *
     * @param roleName
     * @return
     * @throws Exception
     */
    public SysRole selectByRoleNameAndType(String roleName,String roleType) throws Exception;

    /**
     * 查询角色列表
     *
     * @return
     * @throws Exception
     */
    List<SysRole> queryPage(PageRequest request);

    /**
     * 获取所有角色信息
     *
     * @return
     * @throws Exception
     */
    List<SysRole> selectAll() throws Exception;

    /**
     * 根据登陆用户信息来获取该用户所拥有的权限
     * @author ZhuDefeng
     * @param sysUser
     * @return
     * @throws Exception
     */
    List<SysRole> selectBySysUser(SysUser sysUser) throws Exception;
}
