/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  系统用户业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysUserService extends BaseService {
    /**
     * 增加系统用户
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    int insert(SysUser sysUser, String[] roles) throws Exception;

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    int update(SysUser sysUser, String[] roles) throws Exception;

    /**
     * 通过主键删除用户
     *
     * @param primaryKey
     * @return
     */
    int deleteByPrimaryKey(String primaryKey) throws Exception;

    /**
     * 系统用户列表
     *
     * @param request
     * @return
     */
    List<SysUserDto> queryPage(PageRequest request) throws Exception;

    /**
     * 通过ID加载指定的用户信息
     *
     * @param id
     * @return
     */
    SysUser select(String id) throws Exception;
    
    /**
     * 通过ID加载指定的用户信息
     *
     * @param uid
     * @return
     */
    String selectOrgCode(String uid) throws Exception;

    /**
     * 加载指定用户名的用户信息
     *
     * @param username 
     * @return
     * @throws Exception
     */
    SysUser selectByUserName(String username ) throws Exception;
    

    /**
     * 描述：根据部门编码查询用户
     * @author ZhuDefeng
     * @date 2016-09-23
     * @param deptId
     * @return
     * @throws Exception
     */
    List<SysUser> selectUserByDeptId(String deptId)throws Exception;


    List<SysUser> getsliceManByDept(String jurUnit) throws Exception;

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
     * 描述：根据协同用户UID查询用户信息
     * @author ZhuDefeng
     * @date 2016-10-12
     * @param userUID
     * @return
     * @throws Exception
     */
    SysUserDto selectSynUserByUId(String userUID) throws Exception;


    /**
     * 描述：启用OR禁用用户
     * @author ZhuDefeng
     * @date 2016-10-13
     * @param id
     * @param status
     * @return
     * @throws Exception
     */
    int disOrEnAbleUser(String id,String status)throws Exception;

    /**
     * 将协同用户“是否验证”改成否，让用户可以在协同登录的时候重新验证用户信息
     * @author ZhuDefeng
     * @date 2016-12-09
     * @param id
     * @return
     * @throws Exception
     */
    int revalidUser(String id)throws Exception;


    /**
     * 查询所有的用户
     * @author ZhuDefeng
     * @date 2016-10-31
     * @return
     * @throws Exception
     */
    List<SysUser> selectAll()throws Exception;


    /**
     * 描述：根据部门Code查询查询用户列表
     * @author ZhuDefeng
     * @param deptCode
     * @return
     * @throws Exception
     */
    List<SysUser> doGetSysUserByDeptCode(String deptCode)throws Exception;



    /**
     * 描述：检查当前登陆用户的原始密码是否输入正确
     * @author ZhuDefeng
     * @param psw
     * @return
     * @throws Exception
     */
    boolean doCheckPsw(final String psw,final SysUserDto sysUserDto)throws Exception;


    /**
     * 描述：修改密码
     * @author ZhuDefeng
     * @param psw
     * @return
     * @throws Exception
     */
    int doModLoginUserPwd(final String psw,final SysUserDto sysUserDto) throws Exception;

    /**
     * 描述：更新当前登陆用户的最后登陆时间
     * @param userId 登录用户ID
     * @author ZhuDefeng
     * @date 2016-11-20
     * @return
     * @throws Exception
     */
    int modLastLoginTime(String userId)throws Exception;


    /**
     * 根据登录名来查询时候用户是否存在
     * @author ZhuDefeng
     * @date 2016-12-21
     * @param loginName
     * @return
     * @throws Exception
     */
    SysUser selectByLoginName(String loginName,String userType)throws Exception;

    /**
     * 根据登录名来查询时候用户是否存在
     * @author ZhuDefeng
     * @date 2016-12-23
     * @param telPhone
     * @return
     * @throws Exception
     */
    boolean ckTelPhone(String telPhone,String userType)throws Exception;

    /**
     * 为勾选的用户批量设置岗位角色
     * @author ZhuDefeng
     * @date 2017-01-18
     * @param userIds
     * @param roleIds
     * @param setUser
     */
    void doBatchSetUsersRoles(String userIds, String roleIds,String type, SysUserDto setUser)throws Exception;
    
    
     /**
      * 
      * 描述   根据uid主键修改 和系统类型 userType更新
      * @author 赵祥江
      * @date 2017年6月5日 下午2:24:05 
      * @param 
      * @return int
      * @throws
      */
    int updateSysUserByUidAndUserType(SysUser sysUser) throws Exception;
    
    /**
     * 
     * 描述   统一用户保存
     * @author 赵祥江
     * @date 2017年6月13日 上午8:46:04 
     * @param 
     * @return int
     * @throws
     */
    int insertUnifiedUser(SysUser sysUser) throws Exception;
    
    
    /**
     * 
     * 描述   根据不同参数查询用户信息
     * @author 赵祥江
     * @date 2017年9月5日 下午2:45:46 
     * @param 
     * @return List<SysUser>
     * @throws
     */
    public List<SysUser> selectSysUser(Map<String,String> parmMap) throws Exception;
    
    
    
    /**
     * 
     * 描述   根据用户名和系统类型查询
     * @author 赵祥江
     * @date 2017年9月7日 下午4:35:33 
     * @param 
     * @return List<SysUser>
     * @throws
     */
    List<SysUser> selectSysUserListByLoginNameAndUserType(String loginName,String userType)throws Exception;
    
	/**
	 * 
	 * 描述: 根绝用户名可解密密码查询用户
	 * @auther gaojinling
	 * @date 2017年9月18日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SysUserDto> selectListByUserPasswordKey(String loginName,String userType,String status,String userPasswordKey) throws Exception;

	/**
	 * 
	 * 描述   根据用户名和手机查询   or查询
	 * @author 赵祥江
	 * @date 2017年10月23日 下午5:25:50 
	 * @param 
	 * @return List<SysUser>
	 * @throws
	 */
	public List<SysUser> selectSysUserListByLoginNameOrTelPhoneAndUserType(String loginName,String userStatus,String userType)throws Exception;
}
