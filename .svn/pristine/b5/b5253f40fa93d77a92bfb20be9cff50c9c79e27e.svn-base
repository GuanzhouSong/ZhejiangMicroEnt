/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.system.mapper.EntAssignLogMapper;
import com.icinfo.cs.system.model.EntAssignLog;
import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.cs.system.service.IEntAssignLogService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_ent_assign_log 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月13日
 */
@Service
public class EntAssignLogServiceImpl extends MyBatisServiceSupport implements IEntAssignLogService {

    @Autowired
    private EntAssignLogMapper entAssignLogMapper;

    /**
     * 描述：设置委托
     *
     * @param pageRequest
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-23
     */
    @Override
    public List<EntAssignLog> doSelectPage(PageRequest pageRequest) throws Exception {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example ex = new Example(EntAssignLog.class);
        Example.Criteria criteria=ex.createCriteria();
        Map<String, Object> maps = pageRequest.getParams();
        if (maps != null) {
            if (!"".equals(maps.get("entName")) && maps.get("entName") != null) {
                criteria.andEqualTo("entName", maps.get("entName"));
            }
            if (!"".equals(maps.get("regNO")) && maps.get("regNO") != null) {
                criteria.andEqualTo("regNO", maps.get("regNO"));
            }
            if (!"".equals(maps.get("uniCode")) && maps.get("uniCode") != null) {
                criteria.andEqualTo("uniCode", maps.get("uniCode"));
            }
            if (!"".equals(maps.get("assignUserName")) && maps.get("assignUserName") != null) {
                criteria.andEqualTo("assignUserName", maps.get("assignUserName"));
            }
            if (!"".equals(maps.get("assignDeptId")) && maps.get("assignDeptId") != null) {
                criteria.andEqualTo("assignDeptId", maps.get("assignDeptId"));
            }
            if (!"".equals(maps.get("userType")) && maps.get("userType") != null) {
                criteria.andEqualTo("userType", maps.get("userType"));
            }
            if (!"".equals(maps.get("userSetPerson")) && maps.get("userSetPerson") != null) {
                criteria.andEqualTo("userSetPerson", maps.get("userSetPerson"));
            }
            if (!"".equals(maps.get("startSetDate")) && maps.get("startSetDate") != null) {
                criteria.andGreaterThanOrEqualTo("setTime", maps.get("startSetDate"));
            }
            if (!"".equals(maps.get("endSetDate")) && maps.get("endSetDate") != null) {
                criteria.andLessThanOrEqualTo("setTime", maps.get("endSetDate"));
            }
        }
        ex.orderBy("setTime").desc();
        return entAssignLogMapper.selectByExample(ex);
    }
}