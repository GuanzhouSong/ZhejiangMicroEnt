/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service.impl;

import com.icinfo.cs.webservice.mapper.WsMidBaseInfoMapper;
import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.cs.webservice.service.IWsMidBaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_mid_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月15日
 */
@Service
public class WsMidBaseInfoServiceImpl extends MyBatisServiceSupport implements IWsMidBaseInfoService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WsMidBaseInfoServiceImpl.class);

    @Autowired
    private WsMidBaseInfoMapper wsMidBaseInfoMapper;

    /**
     * 按照条件返回WsMidBaseInfo的列表
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public List<WsMidBaseInfo> doGetWsMidBaseInfoListByContion(Map<String, Object> params) throws Exception {

        return wsMidBaseInfoMapper.selectWsMidBaseInfoByContion(params);
    }

    /**
     * 统计数量
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public Integer doGetWsMidBaseInfoCountByContion(Map<String, Object> params) throws Exception {
        return wsMidBaseInfoMapper.selectWsMidBaseInfoCountByContion(params);
    }
    
    /**
     * 根据企业名称，企业内部序号返回数据
     * @param params
     * @return
     * @throws Exception
     */
    public List<WsMidBaseInfo> doGetWsMidBaseInfoListByDatag(String str) throws Exception{
    	return wsMidBaseInfoMapper.selectWsMidBaseInfoListByDatag(str);
    }
    
    /**
     *  按照条件返回WsMidBaseInfo表最大id
     * @param params
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidBaseInfoMaxIdByContion(Map<String, Object> params) throws Exception{
    	return wsMidBaseInfoMapper.selectWsMidBaseInfoMaxIdByContion(params);
    }
    
    /**
     *  按照条件返回WsMidBaseInfo表最小id
     * @param params
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidBaseInfoMinIdByContion(Map<String, Object> params) throws Exception{
    	return wsMidBaseInfoMapper.selectWsMidBaseInfoMinIdByContion(params);
    }
}