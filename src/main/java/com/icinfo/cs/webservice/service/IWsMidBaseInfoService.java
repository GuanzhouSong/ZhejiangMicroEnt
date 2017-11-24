/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.webservice.service;

import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.framework.core.service.BaseService;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_mid_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年02月15日
 */
public interface IWsMidBaseInfoService extends BaseService {
    /**
     *  按照条件返回WsMidBaseInfo的列表
     * @param params
     * @return
     * @throws Exception
     */
    public List<WsMidBaseInfo> doGetWsMidBaseInfoListByContion(Map<String, Object> params) throws Exception;

    /**
     * 统计核准数量
     * @param params
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidBaseInfoCountByContion(Map<String,Object> params) throws Exception;
    
    /**
     * 根据企业名称，企业内部序号返回数据
     * @param params
     * @return
     * @throws Exception
     */
    public List<WsMidBaseInfo> doGetWsMidBaseInfoListByDatag(String str) throws Exception;
    
    /**
     *  按照条件返回WsMidBaseInfo表最大id
     * @param params
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidBaseInfoMaxIdByContion(Map<String, Object> params) throws Exception;
    
    /**
     *  按照条件返回WsMidBaseInfo表最小id
     * @param params
     * @return
     * @throws Exception
     */
    public Integer doGetWsMidBaseInfoMinIdByContion(Map<String, Object> params) throws Exception;

    
}