/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeCertypeMapper;
import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:  cs_code_certype 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class CodeCertypeServiceImpl extends MyBatisServiceSupport implements ICodeCertypeService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(CodeCertypeServiceImpl.class);

    @Autowired
    private CodeCertypeMapper codeCertypeMapper;

    /**
     * 查询证件类型
     * @auhtor: wangjin
     * @return
     */
    @Override
    public List<CodeCertype> selectAll() {
        return codeCertypeMapper.selectAll();
    }
}