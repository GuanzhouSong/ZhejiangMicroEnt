/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import com.icinfo.cs.system.dto.BulletinsReadRecordDto;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;


/**
 * 描述:    cs_bulletins_read_record 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月21日
 */
public interface IBulletinsReadRecordService extends BaseService {

    /**
     * 阅读通知公告
     * @author ZhuDefeng
     * @date 2016-11-29
     * @param bulletinId 通知公告ID
     * @param sysUserDto 当前登录用户
     */
    int doCollection(String bulletinId,SysUserDto sysUserDto);

    /**
     * 阅读通知公告
     * @author ZhuDefeng
     * @date 2016-11-29
     * @param bulletinId 通知公告ID
     * @param sysUserDto 当前登录用户
     */
    int doRead(String bulletinId,SysUserDto sysUserDto);


    /**
     * 查询当前登录用户可查看的通知公告
     * @author ZhuDefeng
     * @date 2016-11-28
     * @param sysUserDto
     * @return
     * @throws Exception
     */
    List<BulletinsReadRecordDto> doSelectBulletinBySysUser(SysUserDto sysUserDto)throws Exception;
}