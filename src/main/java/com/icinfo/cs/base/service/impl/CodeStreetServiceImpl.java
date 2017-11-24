/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeStreetMapper;
import com.icinfo.cs.base.model.CodeStreet;
import com.icinfo.cs.base.service.ICodeStreetService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_code_street 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月28日
 */
@Service
public class CodeStreetServiceImpl extends MyBatisServiceSupport implements ICodeStreetService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeStreetServiceImpl.class);

    @Autowired
    private CodeStreetMapper codeStreetMapper;

    /**
     * 根据上级管辖单位选择街道
     * @param supCode
     * @return
     */
    @Override
    public List<CodeStreet> getStreetBySupNode(String supCode) {
        if(StringUtil.isEmpty(supCode))return null;
        CodeStreet codeStreet = new CodeStreet();
        codeStreet.setSupCode(supCode);
        return codeStreetMapper.select(codeStreet);
    }

    @Override
    public List<Map<String, Object>> selectToTreeMap() {
        return codeStreetMapper.selectToTreeMap();
    }

    @Override
    public List<Map<String, Object>> selectToTreeNoCheckMap() {
        return codeStreetMapper.selectToTreeNoCheckMap();
    }
}