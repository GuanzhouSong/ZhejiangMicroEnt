/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registinfo.service.impl;

import com.icinfo.cs.registinfo.dto.RegistInfoDto;
import com.icinfo.cs.registinfo.mapper.RegistUnlicensedMapper;
import com.icinfo.cs.registinfo.mapper.UlRecordMapper;
import com.icinfo.cs.registinfo.model.RegistUnlicensed;
import com.icinfo.cs.registinfo.service.IRegistUnlicensedService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_regist_unlicensed 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class RegistUnlicensedServiceImpl extends MyBatisServiceSupport implements IRegistUnlicensedService {
    @Autowired
    RegistUnlicensedMapper registUnlicensedMapper;
    @Override
    public RegistUnlicensed getSupersiveByPriPID(String priPid) {
        if(StringUtil.isEmpty(priPid)) return new RegistUnlicensed();
        return registUnlicensedMapper.selectSuperItemOne(priPid);
    }
}