/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.sment.mapper.EntarchivesHelpMapper;
import com.icinfo.cs.sment.model.EntarchivesHelp;
import com.icinfo.cs.sment.model.EntarchivesOperate;
import com.icinfo.cs.sment.service.IEntarchivesHelpService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:   小微企业培育档案库-帮扶信息 sm_bus_entarchives_help 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
@Service
public class EntarchivesHelpServiceImpl extends MyBatisServiceSupport implements IEntarchivesHelpService {
    
    @Autowired
    private EntarchivesHelpMapper entarchivesHelpMapper;
    
    /** 
     * 描述: 插入数据 
     * @author 张文男
     * @date 2017年4月28日 
     * @param bean 
     */
    
    public void insert(EntarchivesHelp bean){
        entarchivesHelpMapper.insert (bean);
    }
    
    /** 
     * 描述: 根据企业id、年份删除对应数据
     * @author 张文男
     * @date 2017年4月28日 
     * @param priPID
     * @param year 
     */
    
    public void deleteBy(String priPID,int year){
        Example e = new Example (EntarchivesHelp.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        c.andEqualTo ("year", year);
        entarchivesHelpMapper.deleteByExample (e);
    }



	  /** 
     * 描述: 根据企业priPID获取对应数据
     * @author Administrator
     * @date 2017年5月5日 
     * @param priPID
     */
	public List<EntarchivesHelp> doGetListJSON(String priPID) {
		Example e = new Example (EntarchivesHelp.class);
        Criteria c = e.createCriteria();
        c.andEqualTo ("priPID", priPID);
		return entarchivesHelpMapper.selectByExample(e);
	}

    
    /** 
     * 描述: 根据企业id、年份获取对应数据
     * @author 张文男
     * @date 2017年5月8日 
     * @param priPID
     * @param year
     * @return 
     */
    
    public List<EntarchivesHelp> queryEntarchivesHelpListBy(String priPID,int year){
        Example e = new Example (EntarchivesOperate.class);
        Criteria c = e.createCriteria ();
        c.andEqualTo ("priPID", priPID);
        c.andEqualTo ("year", year);
        e.orderBy ("createTime");
        List<EntarchivesHelp> list = entarchivesHelpMapper.selectByExample (e);
        return list;
    }

}