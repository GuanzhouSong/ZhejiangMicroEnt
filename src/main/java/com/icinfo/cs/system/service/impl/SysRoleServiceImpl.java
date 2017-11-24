/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.system.mapper.SysRoleMapper;
import com.icinfo.cs.system.model.SysRole;
import com.icinfo.cs.system.model.SysRolePermision;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.model.SysUserRole;
import com.icinfo.cs.system.service.ISysRolePermisionService;
import com.icinfo.cs.system.service.ISysRoleService;
import com.icinfo.cs.system.service.ISysUserRoleService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 描述:  系统角色业务实现.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysRoleServiceImpl extends MyBatisServiceSupport implements ISysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private ISysRolePermisionService sysRolePermisionService;

    @Autowired
    private ISysUserRoleService sysUserRoleService;


    /**
     * 数据转换
     *
     * @param roleId
     * @param permisions
     * @return
     */
    private List<SysRolePermision> convert(String roleId, String[] permisions) throws Exception {
        List<SysRolePermision> rolePermisionList = new ArrayList<SysRolePermision>();
        for (String permision : permisions) {
            SysRolePermision rolePermision = new SysRolePermision();
            rolePermision.setRoleId(roleId);
            rolePermision.setPermisionId(permision);
            rolePermisionList.add(rolePermision);
        }
        return rolePermisionList;
    }

    /**
     * 添加用户角色
     *
     * @param sysRole
     * @param permisions
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(SysRole sysRole, String[] permisions) throws Exception {
        if (permisions == null || permisions.length == 0) {
            throw new BusinessException("至少选择一项权限");
        }

        if (sysRoleMapper.insert(sysRole) <= 0) {
            throw new BusinessException("创建角色失败");
        }
        sysRolePermisionService.insert(convert(sysRole.getId(), permisions));
        return 1;
    }

    /**
     * 更新用户角色
     *
     * @param sysRole
     * @param permisions
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(SysRole sysRole, String[] permisions) throws Exception {
        if (StringUtils.isBlank(sysRole.getId())) {
            throw new BusinessException("角色不存在");
        }
        if (permisions == null || permisions.length == 0) {
            throw new BusinessException("至少选择一项权限");
        }
        //删除旧权限
        sysRolePermisionService.deleteByRoleId(sysRole.getId());
        //保存新权限
        sysRolePermisionService.insert(convert(sysRole.getId(), permisions));
        //更新角色信息
        return sysRoleMapper.updateByPrimaryKeySelective(sysRole);
    }

    /**
     * 删除用户角色
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteByPrimaryKey(String roleId) throws Exception {
        //删除角色权限
        sysRolePermisionService.deleteByRoleId(roleId);
        //删除角色
        return sysRoleMapper.deleteByPrimaryKey(roleId);
    }

    /**
     * 通过主键查询用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysRole selectByPrimaryKey(String id) throws Exception {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过角色名称查询用户角色
     *
     * @param roleName
     * @return
     * @throws Exception
     */
    public SysRole selectByRoleNameAndType(String roleName,String roleType) throws Exception{
    	if(StringUtils.isBlank(roleName) || StringUtils.isBlank(roleType))
    		throw new BusinessException("必要参数不能为空!");
    	Example ex = new Example(SysRole.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andEqualTo("name", roleName);
        criteria.andEqualTo("roleType", roleType);
    	List<SysRole> dataList = sysRoleMapper.selectByExample(ex);
    	if(dataList == null || dataList.size() == 0){
    		return null;
    	}
    	return dataList.get(0);
    }
    
    /**
     * 获取所有角色信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<SysRole> selectAll() throws Exception {
        return sysRoleMapper.selectAll();
    }

    /**
     * 查询角色列表
     *
     * @param request
     * @return
     */
    @Override
    public List<SysRole> queryPage(PageRequest request) {
        PageHelper.startPage(request.getPageNum(), request.getLength());
        Example ex = new Example(SysRole.class);
        Map<String, Object> maps = request.getParams();
        if (maps != null) {
            if (!"".equals(maps.get("roleType")) && maps.get("roleType") != null) {
                ex.createCriteria().andEqualTo("roleType", maps.get("roleType"));
            }
        }
        return sysRoleMapper.selectByExample(ex);
    }

    /**
     * 根据登陆用户信息来获取该用户所拥有的权限
     *
     * @param sysUser
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public List<SysRole> selectBySysUser(SysUser sysUser) throws Exception {

        Example ex = new Example(SysRole.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andEqualTo("roleType", sysUser.getUserType());
        if("1".equals(sysUser.getIsAdmin())||"2".equals(sysUser.getIsAdmin())){
            return sysRoleMapper.selectByExample(ex);
        }
        List<String> roleIDs = new ArrayList<String>();
        List<SysUserRole> sysRoles = sysUserRoleService.selectByUserId(sysUser.getId());
        if(sysRoles!=null&&sysRoles.size()>0){
            for(SysUserRole sysUserRole:sysRoles){
                roleIDs.add(sysUserRole.getRoleId());
            }
            criteria.andIn("id", roleIDs);
        }
        return sysRoleMapper.selectByExample(ex);
    }
}
