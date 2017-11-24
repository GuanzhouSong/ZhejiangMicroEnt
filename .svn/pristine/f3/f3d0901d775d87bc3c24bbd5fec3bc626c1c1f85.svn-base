/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sment.mapper.EntarchivesAdjustMapper;
import com.icinfo.cs.sment.model.EntarchivesAdjust;
import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.cs.sment.service.IEntarchivesAdjustService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 描述:   小微企业培育档案库-调整信息 sm_bus_entarchives_adjust 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Service
public class EntarchivesAdjustServiceImpl extends MyBatisServiceSupport implements IEntarchivesAdjustService {
    @Autowired
    private EntarchivesAdjustMapper entarchivesAdjustMapper;
    
    /** 
     * 描述: 插入数据 
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    
    public void insert(EntarchivesAdjust bean){
        entarchivesAdjustMapper.insert (bean);
    }
    
    /** 
     * 描述: 根据企业id获取对应调整记录
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @return 
     */
    
    public List<EntarchivesAdjust> queryEntarchivesAdjustListBy(String priPID){
        Example e = new Example (EntarchivesOperate.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        e.setOrderByClause ("AdjustTime desc");
        List<EntarchivesAdjust> list = entarchivesAdjustMapper.selectByExample (e);
        return list;
    }
}