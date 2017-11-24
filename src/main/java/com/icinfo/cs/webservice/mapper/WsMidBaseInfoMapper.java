/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月15日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;

import com.icinfo.cs.webservice.model.WsMidBaseInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 描述:  cs_mid_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月15日
 */
public interface WsMidBaseInfoMapper extends Mapper<WsMidBaseInfo> {
    /**
     * 查询核准内容
     * @param params
     * @return
     * @throws Exception
     */
    List<WsMidBaseInfo> selectWsMidBaseInfoByContion(Map<String, Object> params) throws Exception;

    /**
     * 统计数量
     * @param params
     * @return
     * @throws Exception
     */
    Integer selectWsMidBaseInfoCountByContion(Map<String, Object> params) throws Exception;
    
    /**
     * 根据企业名称，企业内部序号返回数据
     * @param params
     * @return
     * @throws Exception
     */
    List<WsMidBaseInfo> selectWsMidBaseInfoListByDatag(String str) throws Exception;
    
    /**
     * 统计数量
     * @param params
     * @return
     * @throws Exception
     */
    Integer selectWsMidBaseInfoMaxIdByContion(Map<String, Object> params) throws Exception;
    
    /**
     * 统计数量
     * @param params
     * @return
     * @throws Exception
     */
    Integer selectWsMidBaseInfoMinIdByContion(Map<String, Object> params) throws Exception;
    
    
}