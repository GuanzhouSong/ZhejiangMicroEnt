/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.yr.dto.YrRegCheckDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_yr_reg_check 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface YrRegCheckMapper extends Mapper<YrRegCheck> {

    /**
     * 条件 查询
     * @param params
     * @return
     */
    List<YrRegCheck> search_queryPage(Map<String, Object> params);
    
    /** 
     * 描述: 初始化年报主表数据
     * @auther ZhouYan
     * @date 2016年8月30日 
     * @param pripid
     * @param year 
     */
    void initYrRegCheck(@Param("pripid") String pripid, @Param("year") Integer year);
    
    /** 
     * 描述: 工商端查询年报主表数据（作为敏感词审核列表数据）
     * @auther yujingwei
     * @date 2016年8月30日 
     * @param request
     * @throws Exception 
     */
	List<YrRegCheckDto> queryPageForForbidResult(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 个体户接收查询
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param params
	 * @return
	 */
	List<YrRegCheck> selectPbReceiveQueryPage(Map<String, Object> params);
	
	/**数据回导查询
	 * @author ljx
	 * @param params 
	 * @return
	 */ 
	List<YrRegCheck> selectByRegNoAndName(Map<String,Object> params);
	
	/**
	 * 
	 * 描述   TODO
	 * @author 赵祥江
	 * @date 2016年11月29日 下午1:46:13 
	 * @param 
	 * @return List<YrRegCheckDto>
	 * @throws
	 */
	List<YrRegCheckDto> selectcomInfoCheckDtoList(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 个体户纸质报告补录查询
	 * @auther gaojinling
	 * @date 2017年3月8日 
	 * @param params
	 * @return
	 */
	List<YrRegCheck> selectPbAddRecQueryPage(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 个体户纸质补录条数
	 * @auther gaojinling
	 * @date 2017年3月16日 
	 * @param map
	 * @return
	 */
	public Integer selectPbAddRecCount(Map<String,Object> map);
	
	/**
	 * 
	 * 描述: 年报修改申请审核条数（警示端首页）
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectForbidCount(Map<String,Object> map);
	
	
}