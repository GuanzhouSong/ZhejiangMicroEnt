/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.cs.sment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sment.mapper.EntarchivesOperateMapper;
import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.cs.sment.service.IEntarchivesOperateService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 描述:   小微企业培育档案库-经营状况 sm_bus_entarchives_operate 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Service
public class EntarchivesOperateServiceImpl extends MyBatisServiceSupport implements IEntarchivesOperateService {

    @Autowired
    private EntarchivesOperateMapper entarchivesOperateMapper;
    
    /** 
     * 描述: 插入数据 
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    
    public void insert(EntarchivesOperate bean){
        entarchivesOperateMapper.insert (bean);
    }
    
    /** 
     * 描述: 根据企业id、年份删除对应数据
     * @author 张文男
     * @date 2017年4月28日 
     * @param priPID
     * @param year 
     */
    
    public void deleteBy(String priPID,int year){
        Example e = new Example (EntarchivesOperate.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        c.andEqualTo ("year", year);
        entarchivesOperateMapper.deleteByExample (e);
    }
    
    /** 
     * 描述: 根据企业id、年份获取对应数据
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @param year
     * @return 
     */
    
    public EntarchivesOperate queryEntarchivesOperateBy(String priPID,int year){
        Example e = new Example (EntarchivesOperate.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        c.andEqualTo ("year", year);
        List<EntarchivesOperate> list = entarchivesOperateMapper.selectByExample (e);
        if(null != list && list.size () >0){
            return list.get (0);
        }
        return null;
    }
}