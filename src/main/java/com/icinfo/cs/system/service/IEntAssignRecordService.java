/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.security.shiro.UserProfile;

import java.util.List;

/**
 * 描述:    cs_ent_assign 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月22日
 */
public interface IEntAssignRecordService extends BaseService {


    /**
     * 描述：插入一条企业权限分配信息
     * @author ZhuDefeng
     * @date 2016-09-22
     * @param entAssign
     * @return
     * @throws Exception
     */
    int insert(EntAssignRecord entAssign)throws Exception;

    /**
     * 描述：查询企业权限分配记录信息
     * @author ZhuDefeng
     * @date 2016-09-22
     * @param pageRequest
     * @return
     * @throws Exception
     */
    List<EntAssignRecord> query(PageRequest pageRequest)throws Exception;

    /**
     * 描述：指定分配
     * @author ZhuDefeng
     * @date 2016-10-11
     * @param priPIDs 主体身份ID
     * @param userIds 指定分配用户ID
     * @param sysUserDto 当前登陆用户
     * @return
     * @throws Exception
     */
    void doAssign(String priPIDs, String userIds, SysUserDto sysUserDto)throws Exception;


    /**
     * 描述：取消指定分配信息
     * @author ZhuDefeng
     * @param assignUID
     * @param priPID
     * @param userId
     * @param userProfile
     * @throws Exception
     */
    void doCancleAssign(String assignUID,String priPID, String userId, UserProfile userProfile)throws Exception;

    /**
     * 描述：删除指定分配信息
     * @author ZhuDefeng
     * @param assignUID
     * @throws Exception
     */
    void doDelByAssignUId(String assignUID)throws Exception;
}