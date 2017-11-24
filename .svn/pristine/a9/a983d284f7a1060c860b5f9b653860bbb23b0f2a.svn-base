/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:   小微企业培育档案库-经营状况 sm_bus_entarchives_operate 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
public interface IEntarchivesOperateService extends BaseService {
    
    /** 
     * 描述: 插入数据 
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    
    public void insert(EntarchivesOperate bean);
    
    /** 
     * 描述: 根据企业id、年份删除对应数据
     * @author 张文男
     * @date 2017年4月28日 
     * @param priPID
     * @param year 
     */
    
    public void deleteBy(String priPID,int year);
    
    /** 
     * 描述: 根据企业id、年份获取对应数据
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @param year
     * @return 
     */
    
    public EntarchivesOperate queryEntarchivesOperateBy(String priPID,int year);
}