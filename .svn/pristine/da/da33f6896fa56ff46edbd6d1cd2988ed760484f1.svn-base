package com.icinfo.cs.sment.service;

import java.util.List;

import com.icinfo.cs.sment.dto.BulletinsReadRecordDto;
import com.icinfo.cs.system.dto.SysUserDto;

/**
 * 描述:   小微企业公告通知 sm_bulletins_read_recird 对应的Service接口.<br>
 *
 * @author 
 * @date 2017年05月04日
 */
public interface ISmBulletinsReadRecordService {
	/**
     * 查询当前登录用户可查看的通知公告
     * @author Czj
     * @date 2017-05-04
     * @param sysUserDto
     * @return
     * @throws Exception
     */
    List<BulletinsReadRecordDto> doSelectBulletinBySysUser(SysUserDto sysUserDto)throws Exception;
    /**
     * 阅读通知公告
     * @author Czj
     * @date 2017-05-04
     * @param bulletinId sysUserDto
     * @return
     * @throws Exception
     */
	int doRead(String bulletinId, SysUserDto sysUserDto);
}
