/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年04月27日
 * @version 2.0
 */
package com.icinfo.cs.sment.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.dto.EntarchivesDto;
import com.icinfo.cs.sment.model.Entarchives;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:   小微企业培育档案库 sm_bus_entarchives 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年04月27日
 */
public interface EntarchivesMapper extends Mapper<Entarchives> {
    /** 
     * 描述: 统计入库企业违法违规数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countWfwgBySetDeptCode(String setDeptCode);
    
    /** 
     * 描述: 统计入库企业经营异常数量
     * @author 张文男
     * @date 2017年6月23日 
     * @param setDeptCode
     * @return 
     */
    
    public Long countJyycBySetDeptCode(String setDeptCode);
    
    /** 
     * 描述:  统计入库企业上规升级数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param map
     * @return 
     */
    
    public Long countSgsjBySetDeptCode(String setDeptCode);
    
    /** 
     * 描述: 统计入库企业经营下降20%数量
     * @author 张文男
     * @date 2017年6月26日 
     * @param setDeptCode
     * @return 
     */
    
    public Long  countJyxjBySetDeptCode(String setDeptCode);
    
    /**
     * 
     * 描述: 统计培育库企业企业类型
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto cultivationTypeScount(Map<String, Object> map);
    /**
     * 
     * 描述: 统计培育库企业区域分类
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto qyflCount(Map<String, Object> map);
    /**
     * 
     * 描述: 统计培育库企业八大产业 
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto industryTypeCount(Map<String, Object> map);
    /**
     * 
     * 描述: 统计培育库企业创业人群 
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public EntarchivesDto entCrowdCodeCount(Map<String, Object> map);
    /**
     * 
     * 描述: 统计培育库企业营业总收入
     * @auther gaojinling
     * @date 2017年8月15日 
     * @param map
     * @return
     */
    public List<EntarchivesDto> vendIncCount(Map<String, Object> map);
}