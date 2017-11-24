/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsPubEppasswordMapper;
import com.icinfo.cs.webservice.model.WsPubEppassword;
import com.icinfo.cs.webservice.service.IWsPubEppasswordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述: 联络员信息表 cs_pub_eppassword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月31日
 */
@Service
public class WsPubEppasswordServiceImpl extends MyBatisServiceSupport implements IWsPubEppasswordService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsPubEppasswordServiceImpl.class);

    @Autowired
    private WsPubEppasswordMapper wsPubEppasswordMapper;

    /**
     *  按照条件返回WsPubEppassword的列表
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    @Override
    public List<WsPubEppassword> doGetWsPubEppasswordListByContion(Map<String, Object> params) throws Exception {
        return wsPubEppasswordMapper.selectWsPubEppasswordListByContion(params);
    }

    /**
     *  按照条件返回WsPubEppassword数量
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    @Override
    public Integer doGetWsPubEppasswordCountByContion(Map<String, Object> params) throws Exception {
        return wsPubEppasswordMapper.selectWsPubEppasswordCountByContion(params);
    }

    /**
     *  按照条件返回WsPubEppassword的maxId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    @Override
    public Integer doGetWsPubEppasswordMaxId(Map<String, Object> params) throws Exception {
        return wsPubEppasswordMapper.selectWsPubEppasswordMaxId(params);
    }

    /**
     *  按照条件返回WsPubEppassword的minId
     * @param params
     * @author ylr
     * @return
     * @throws Exception
     */
    @Override
    public Integer doGetWsPubEppasswordMinId(Map<String, Object> params) throws Exception {
        return wsPubEppasswordMapper.selectWsPubEppasswordMinId(params);
    }
}