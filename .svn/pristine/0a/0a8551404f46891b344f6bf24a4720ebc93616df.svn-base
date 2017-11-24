/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.writ.service.impl;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.writ.mapper.DzhzMapper;
import com.icinfo.cs.writ.model.Dzhz;
import com.icinfo.cs.writ.service.IDzhzService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.tools.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_dzhz 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
@Service
public class DzhzServiceImpl extends MyBatisServiceSupport implements IDzhzService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(DzhzServiceImpl.class);

    @Autowired
    private DzhzMapper dzhzMapper;


    /**
     * 描述：添加一条回执数据
     * @param dzhz
     * @return
     */
    @Override
    public int save(Dzhz dzhz) {
        dzhz.setCreateTime(DateUtils.getSysDate());//创建时间
        int i=0;
        try {
           return i = dzhzMapper.insert(dzhz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public Dzhz selectbyWritUuid(String uuid) {
        if(StringUtil.isNotBlank(uuid)){
            Dzhz dzhz = new Dzhz();
            dzhz.setWritUuid(uuid);
            return dzhzMapper.selectOne(dzhz);
        }
        return  null;
    }
}