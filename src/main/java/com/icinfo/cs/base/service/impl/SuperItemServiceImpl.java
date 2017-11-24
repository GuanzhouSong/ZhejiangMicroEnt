/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.base.service.impl;

import com.icinfo.cs.base.mapper.SuperItemMapper;
import com.icinfo.cs.base.model.SuperItem;
import com.icinfo.cs.base.service.ISuperItemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述:  cs_super_item 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Service
public class SuperItemServiceImpl extends MyBatisServiceSupport implements ISuperItemService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SuperItemServiceImpl.class);

    @Autowired
    private SuperItemMapper superItemMapper;

    @Override
    public List<SuperItem> selectSuperItemsByType(String superType) {
        if(StringUtil.isEmpty(superType))  return superItemMapper.selectAll();
        SuperItem superItem = new SuperItem();
        superItem.setSuperType(superType);
        return superItemMapper.select(superItem);
    }
}