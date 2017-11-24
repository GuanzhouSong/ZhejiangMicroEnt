/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.util.List;

import com.icinfo.cs.sment.dto.EntarchivesHisDto;
import com.icinfo.cs.sment.model.EntarchivesHis;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public interface IEntarchivesHisService extends BaseService {
    
    /** 
     * 描述: 新增
     * @author 张文男
     * @date 2017年5月4日 
     * @param bean 
     */
    
    public void insert(EntarchivesHis bean);
    
    /** 
     * 描述: 根据企业id获取历史信息
     * @author 张文男
     * @date 2017年5月4日 
     * @param priPID
     * @return 
     */
    
    public EntarchivesHis queryByPriPID(String priPID);
    
    /**
     * 获取培育库历史档案
     * @author zjj
     * 20170508
     */
    public List<EntarchivesHisDto> queryPage(PageRequest request);
    
    /** 
     * 描述:  根据企业id删除历史信息
     * @author 张文男
     * @date 2017年5月9日 
     * @param priPID 
     */
    
    public void deleteByPriPID(String priPID);
    
    /** 
     * 描述: 根据部门code获取已注销企业数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param sysUser
     * @return 
     */
    
    public int count(SysUserDto sysUser);
}