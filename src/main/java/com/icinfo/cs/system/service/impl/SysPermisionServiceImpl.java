/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.exception.GenericException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.tools.utils.StringUtils;
import com.icinfo.cs.system.mapper.SysPermisionMapper;
import com.icinfo.cs.system.model.SysPermision;
import com.icinfo.cs.system.service.ISysPermisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 描述:  系统权限业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
@Service
public class SysPermisionServiceImpl extends MyBatisServiceSupport implements ISysPermisionService {
    /**
     * 用户权限mapper注入
     */
    @Autowired
    private SysPermisionMapper sysPermisionMapper;

    /**
     * 添加系统权限
     * @param sysPermision
     * @return
     * @throws Exception
     */
    @Override
    public int insert(SysPermision sysPermision) throws Exception {
        if (!"1".equals(sysPermision.getType())) {
            sysPermision.setType("0");
        }
        if (StringUtils.isNotBlank(sysPermision.getParentId())) {
            SysPermision parent = selectByPrimaryKey(sysPermision.getParentId());
            if (parent == null) {
                throw new GenericException("添加失败，上级权限不存在");
            }
            if ("0".equals(parent.getType())) {
                throw new GenericException("添加失败，操作权限不允许有子菜单权限。");
            }
        }
        if (sysPermision.getSort() == null) {
            sysPermision.setSort(0);
        }
        return sysPermisionMapper.insert(sysPermision);
    }

    /**
     * 加载所有权限数据
     * @param qryMap 查询参数
     * @return
     */
    @Override
    public List<SysPermision> selectAll(Map<String,Object> qryMap) {
        Example ex = new Example(SysPermision.class);
        if(qryMap != null){
            if(!"".equals(qryMap.get("permisionSysType"))&& qryMap.get("permisionSysType")!=null  ){
                ex.createCriteria().andEqualTo("permisionSysType", qryMap.get("permisionSysType"));
            }
        }
        ex.setOrderByClause("PERMISION_SORT ASC");
        return sysPermisionMapper.selectByExample(ex);
    }

    /**
     * 通过主键获取系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public SysPermision selectByPrimaryKey(String id) throws Exception {
        return sysPermisionMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主键删除系统权限
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override

    public int deleteByPrimaryKey(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("删除失败：id不能为空");
        }
        if (isHaveSub(id)) {
            throw new GenericException("删除失败：存在子权限");
        }
        return sysPermisionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新权限数据
     *
     * @param sysPermision
     * @return
     * @throws Exception
     */
    @Override
    public int update(SysPermision sysPermision) throws Exception {
        //不允许修改父子关系
        sysPermision.setParentId(null);
        //不允许修改权限类型
        sysPermision.setType(null);
        return sysPermisionMapper.updateByPrimaryKeySelective(sysPermision);
    }

    /**
     * 判断是否存在子权限
     *
     * @param id 权限ID
     * @return
     * @throws Exception
     */
    @Override
    public boolean isHaveSub(String id) throws Exception {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("参数错误，id不能为空");
        }
        Example example = new Example(SysPermision.class);
        example.createCriteria().andEqualTo("parentId", id);
        return sysPermisionMapper.selectCountByExample(example) > 0;
    }

    /**
     * 查询用户权限列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysPermision> selectUserPermisions(String userId) {
        if (StringUtils.isBlank(userId)) {
            return new ArrayList<SysPermision>();
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userId", userId);
        return sysPermisionMapper.selectUserPermisions(params);
    }


    /**
     * 根据资源名称关键字来模糊匹配搜索
     *
     * @param keyWord
     * @param sysUserDto
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-08
     */
    @Override
    public List<SysPermision> findPermisionByPerName(String keyWord, SysUserDto sysUserDto) throws Exception {
        //用户权限
        List<SysPermision> permisionList = null;
        if("1".equals(sysUserDto.getIsAdmin())||"2".equals(sysUserDto.getIsAdmin())) {//如果是超级管理员把所有的权限加载进来
            Example example=new Example(SysPermision.class);
            example.createCriteria().andEqualTo("permisionSysType", sysUserDto.getUserType()).andLike("name","%"+keyWord+"%").andNotEqualTo("relatedUrl","#");
            example.setOrderByClause("PERMISION_SORT ASC");
            permisionList=sysPermisionMapper.selectByExample(example);
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userId", sysUserDto.getId());
            params.put("permisionSysType", sysUserDto.getUserType());
            params.put("permisionNameLike", keyWord);
            params.put("notIncludeParent", "true");
            permisionList= sysPermisionMapper.selectUserPermisions(params);
        }
        return permisionList;
    }

    /**
     * 根据角色岗位来查询权限
     *
     * @param roleIds
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2017-01-19
     */
    @Override
    public List<SysPermision> selectAll4RoleIds(String roleIds) throws Exception {
        if(StringUtil.isBlank(roleIds)){
            return null;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleIdArr",roleIds.split(","));
        return sysPermisionMapper.selectUserPermisionsByRoleIds(params);
    }
}
