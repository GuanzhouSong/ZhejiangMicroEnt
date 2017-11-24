/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.CodeSetMapper;
import com.icinfo.cs.base.model.CodeSet;
import com.icinfo.cs.base.service.ICodeSetService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:    编码信息 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
@Service
public class CodeSetServiceImpl extends MyBatisServiceSupport implements ICodeSetService {

    @Autowired
    private CodeSetMapper codeMapper;

    /**
     * 描述:  根据编码类型查询编码集合
     *
     * @param codeType 登陆主体身份ID
     * @return 编码集合
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年09月09日
     */
    @Override
    public List<CodeSet> findCodeByType(String codeType) throws Exception {
        Example example=new Example(CodeSet.class);
        example.createCriteria().andEqualTo("type",codeType);
        return codeMapper.selectByExample(example);
    }
}