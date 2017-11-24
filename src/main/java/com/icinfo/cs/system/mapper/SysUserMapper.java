/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.mapper;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.cs.system.model.SysUser;

import java.util.List;
import java.util.Map;


/**
 * 描述:  SysUser Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年04月05日
 */
public interface SysUserMapper extends Mapper<SysUser> {


    /**
     * 描述：根据用户UID查询用户信息
     * @author ZhuDefeng
     * @date 2016-10-12
     * @param userUID
     * @return
     * @throws Exception
     */
    SysUserDto selectUserByUId(String userUID) throws Exception;


    /**
     * 描述：根据 用户UID查询用户信息
     * @author ZhuDefeng
     * @date 2016-10-12
     * @param userUID
     * @return
     * @throws Exception
     */
    SysUserDto selectSynUserByUId(String userUID) throws Exception;


    /**
     * 获取用户信息（协同系统）
     * @author ZhuDefeng
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<SysUserDto> selectSynUser(Map<String,Object> qryMap)throws Exception;

    /**
     * 获取用户信息（警示系统）
     * @author ZhuDefeng
     * @param qryMap
     * @throws Exception
     */
    List<SysUserDto> selectRegUser(Map<String,Object> qryMap)throws Exception;
    
    /**
     * 获取用户信息（小微监测）
     * @author ZhuDefeng
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<SysUserDto> selectSmentUser(Map<String,Object> qryMap)throws Exception;


    /**
     * 根据登录名来查询时候用户是否存在
     * @author ZhuDefeng
     * @date 2016-12-21
     * @param qryMap
     * @return
     * @throws Exception
     */
    SysUser selectByLoginNameAndUserType(Map<String,Object> qryMap)throws Exception;

    /**
     * 将协同用户“是否验证”改成否，让用户可以在协同登录的时候重新验证用户信息
     *
     * @param id
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-12-09
     */
    int revalidUser(String id)throws Exception;
    
    /**
     * 
     * 描述: 根绝用户名可解密密码查询用户
     * @auther gaojinling
     * @date 2017年9月18日 
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<SysUserDto> selectListByUserPasswordKey(Map<String,Object> qryMap) throws Exception;
 
    /**
     * 
     * 描述   根据用户名和手机查询   or查询
     * @author 赵祥江
     * @date 2017年10月23日 下午5:32:11 
     * @param 
     * @return List<SysUserDto>
     * @throws
     */
    List<SysUser> selectSysUserListByLoginNameOrTelPhoneAndUserType(Map<String,Object> qryMap) throws Exception;
    
}