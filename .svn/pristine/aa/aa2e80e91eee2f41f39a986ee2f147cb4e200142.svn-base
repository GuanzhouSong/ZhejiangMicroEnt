/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.icinfo.cs.registinfo.mapper.UlRecordMapper;
import com.icinfo.cs.registinfo.model.UlRecord;
import com.icinfo.cs.registinfo.service.IUlRecordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_ul_record 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class UlRecordServiceImpl extends MyBatisServiceSupport implements IUlRecordService {
    @Autowired
    UlRecordMapper ulRecordMapper;
    @Override
    public UlRecord getUlRecordByPriPID(String priPid) {
        UlRecord ulRecord = new UlRecord();
        ulRecord.setPriPID(priPid);
        if(ulRecordMapper.select(ulRecord)==null||ulRecordMapper.select(ulRecord).size()<1)return new UlRecord();
        return ulRecordMapper.select(ulRecord).get(0);
    }
}