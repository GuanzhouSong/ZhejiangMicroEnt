/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import com.icinfo.cs.system.mapper.EntDelegateRecordMapper;
import com.icinfo.cs.system.model.EntAssignRecord;
import com.icinfo.cs.system.model.EntDelegateRecord;
import com.icinfo.cs.system.service.IEntDelegateRecordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_delegate_record 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月22日
 */
@Service
public class EntDelegateRecordServiceImpl extends MyBatisServiceSupport implements IEntDelegateRecordService {


    @Autowired
    private EntDelegateRecordMapper delegateRecordMapper;
    /**
     * 描述：新增委托记录信息
     * @author ZhuDefeng
     * @param entDelegateRecord
     * @return
     * @throws Exception
     * @author ZhuDefeng
     */
    @Override
    public int insertRecord(EntDelegateRecord entDelegateRecord) throws Exception {
        return delegateRecordMapper.insert(entDelegateRecord);
    }

    /**
     * 描述：查询企业委托记录信息
     *
     * @param pageRequest
     * @return
     * @throws Exception
     * @author ZhuDefeng
     * @date 2016-10-10
     */
    @Override
    public List<EntDelegateRecord> query(PageRequest pageRequest) throws Exception{

        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getLength());
        Example ex=new Example(EntDelegateRecord.class);
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
        return delegateRecordMapper.selectByExample(ex);
    }
}