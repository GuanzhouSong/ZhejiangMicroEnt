/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.DBAuthorConstants;
import com.icinfo.cs.common.logintoken.CSLoginToken;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.mapper.SysPermisionMapper;
import com.icinfo.cs.system.model.SysPermision;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ISysPermisionService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.framework.core.exception.GenericException;
import com.icinfo.framework.security.shiro.LoginToken;
import com.icinfo.framework.security.shiro.ShiroSecurityService;
import com.icinfo.framework.security.shiro.UserProfile;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:  系统用户登录.<br>
 *
 * @author xiajunwei
 * @date 2016年06月12日
 */
@Service("csSysLoginService")
public class CSSysLoginServiceImpl implements ShiroSecurityService {
    /**
     * 系统用户业务service注入
     */
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 系统权限业务service注入
     */
    @Autowired
    private ISysPermisionService sysPermisionService;

    @Autowired
    private SysPermisionMapper sysPermisionMapper;

    private static final String DEFAULT_PREMISSION_STRING = "perms[{0}]";

    /**
     * 查询用户信息及其权限列表
     *
     * @param token
     * @return
     * @throws org.apache.shiro.authc.AuthenticationException
     */
    @SuppressWarnings("deprecation")
	@Override
    public UserProfile doGetUserProfile(LoginToken token) throws AuthenticationException {
        SysUser sysUser = null;
        try {
//            sysUser = sysUserService.selectByUserName(token.getUsername()); 
            CSLoginToken csLoginToken=(CSLoginToken)token; 
            //警示系统登录或小微系统
			if (DBAuthorConstants.USER_TYPE_REG.equals(csLoginToken
					.getUserType())
					|| DBAuthorConstants.USER_TYPE_SMENT.equals(csLoginToken
							.getUserType())) {
            	sysUser=csLoginToken.getSysUser();
        	}else{
        		//shiro 登录验证  由此处取到的用户比对 （由原来的用户名及系统类型查找 改为  用户名+密码（可直接加解密的密码）+系统类型+有效状态）
        		List<SysUserDto> list = sysUserService.selectListByUserPasswordKey(token.getUsername(),csLoginToken.getUserType(),"1",csLoginToken.getUserPasswordKey());
        		if(list.size()>1){
                    throw new GenericException("登录帐号:"+token.getUsername()+"存在多条记录");
        		}
        		sysUser = list.get(0);
        	} 
        } catch (Exception e) {
            throw new GenericException("登录帐号:"+token.getUsername()+"无有效记录");
        }
        if (sysUser == null) {
            return null;
        } 

        UserProfile userProfile = new UserProfile();
        //基本信息
        userProfile.setUserId(sysUser.getId());
        userProfile.setUsername(sysUser.getUsername());
        userProfile.setPassword(sysUser.getPassword());
        userProfile.setPasswordSalt(sysUser.getPasswordSalt());
        userProfile.setRealName(sysUser.getRealName());

        //用户权限
        List<SysPermision> permisionList = null;
        if("1".equals(sysUser.getIsAdmin())) {//如果是超级管理员把所有的权限加载进来
            permisionList=sysPermisionMapper.selectPermisionsBySysType(sysUser.getUserType());
        }else{
            permisionList=sysPermisionService.selectUserPermisions(sysUser.getId());
        }

        //权限
        Set<String> permisions = new HashSet<String>();
        //菜单
        Map<String, List> menus = new HashMap<String, List>();
        for (SysPermision permision : permisionList) {
            permisions.add(permision.getUrl());
            if ("1".equals(permision.getType())) {
                if (org.apache.commons.lang3.StringUtils.isBlank(permision.getParentId())) {
                    //根菜单
                    if (!menus.containsKey("-1")) {
                        menus.put("-1", new ArrayList<SysPermision>());
                    }
                    menus.get("-1").add(permision);
                } else {
                    //子菜单
                    String parentId = permision.getParentId();
                    if (!menus.containsKey(parentId)) {
                        menus.put(parentId, new ArrayList<SysPermision>());
                    }
                    menus.get(parentId).add(permision);
                }
            }

            //关联权限资源
            if (StringUtils.isNotBlank(permision.getRelatedUrl())) {
                String[] perms = permision.getRelatedUrl().split(",");
                for (String perm : perms) {
                    if (StringUtils.isNotEmpty(perm) && perm.startsWith("/")) {
                        permisions.add(perm);
                    }
                }
            }
        }

        if(StringUtils.equalsIgnoreCase("1",sysUser.getIsAdmin())){//如果是超级管理员还要把下面的权限路径加进来
            if(StringUtils.equalsIgnoreCase(sysUser.getUserType(),"1")){//警示系统
                permisions.add("_REG_SUPER_PERM");
            }
            if(StringUtils.equalsIgnoreCase(sysUser.getUserType(),"2")){//协同系统
                permisions.add("_SYN_SUPER_PERM");
            }
        }
        userProfile.setPermissions(permisions);
        userProfile.setMenus(menus);
        return userProfile;
    }

    /**
     * 加载所有权限数据
     *
     * @return
     */
    @Override
    public Map<String, String> doGetDynamicPermisions() {
        List<SysPermision> permisionList = sysPermisionService.selectAll(null);
        Map<String, String> permisions = new HashMap<>();
        for (SysPermision permision : permisionList) {
            String url = permision.getUrl();
            if (StringUtils.isNotEmpty(url) && url.startsWith("/")) {
                permisions.put(url, MessageFormat.format(DEFAULT_PREMISSION_STRING, url));
                //关联资源处理
                if (StringUtils.isNotBlank(permision.getRelatedUrl())) {
                    String[] perms = permision.getRelatedUrl().split(",");
                    for (String perm : perms) {
                        if (StringUtils.isNotEmpty(perm) && perm.startsWith("/")) {
                            permisions.put(perm, MessageFormat.format(DEFAULT_PREMISSION_STRING, perm));
                        }
                    }
                }
            }
        }
        return permisions;
    }
}
