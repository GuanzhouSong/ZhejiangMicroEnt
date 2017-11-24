/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月02日
 * @version 2.0
 */
package com.icinfo.cs.sment.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.dto.SmBaseinfoDto;
import com.icinfo.cs.sment.model.SmBaseinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.framework.mybatis.pagehelper.Page;

/**
 * 描述: cs_sm_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public interface SmBaseinfoMapper extends Mapper<SmBaseinfo> {

    /**
     * 描述: 培育库分页列表
     * 
     * @author 张文男
     * @date 2017年5月3日
     * @param params
     */
    List<SmBaseinfoDto> queryPageListForEntarchives(Map<String, Object> params);

    /** 
    * 描述: TODO
    * @author 张文男
    * @date 2017年5月15日 
    * @param params
    * @return 
    */

    Long queryPageListForEntarchivesCount(Map<String, Object> params);

    /**
     * 描述: 获取企业、培育库分页列表
     * 
     * @author 张文男
     * @date 2017年5月4日
     * @param params
     * @return
     */

    List<SmBaseinfoDto> queryEntAndEntarchivesPageList(Map<String, Object> params);

    /**
     * 描述: 根据企业id获取对象
     * 
     * @author 张文男
     * @date 2017年5月5日
     * @param priPID
     * @return
     */
    SmBaseinfoDto queryBeanByPriPID(String priPID);

    /**
     * 描述：查询小微企业信息
     * 
     * @author baifangfang
     * @date 2017年5月8日
     * @param condition
     * @return
     */
    List<SmBaseinfoDto> selectListByCondition(String condition);

    /**
     * 描述：获取需要更新的小微企业数量
     * 
     * @author baifangfang
     * @date 2017年5月8日
     * @param qryMap
     * @return
     */
    int selectIncreCount(Map<String, Object> qryMap);

    /**
     * 描述：获取pripid
     * 
     * @author baifangfang
     * @date 2017年5月8日
     * @param qryMap
     * @return
     */
    List<SmBaseinfoDto> selectIncreData(Map<String, Object> qryMap);

    /**
     * 根据pripid分别从cs_mid_baseinfo和sm_baseinfo中取出数据
     * 
     * @author zhuyong
     * @param priPID
     * @return
     * @throws Exception
     */
    public List<SmBaseinfoDto> selectOneForCompare(String priPID) throws Exception;

    /**
     * 描述：获取小微企业最大id
     * 
     * @author baifangfang
     * @date 2017年5月9日
     * @return
     */
    int selectMaxId();

    /**
     * 描述：根据id查询小微企业列表
     * @author baifangfang
     * @date 2017年5月9日
     * @param paramMap
     * @return
     */
    List<SmBaseinfoDto> selectIndexListById(Map<String, Object> paramMap);

    /**
     * 描述：小微企业信息查询列表
     * @author baifangfang
     * @date 2017年5月9日
     * @param params
     * @return
     */
    Page<SmBaseinfoDto> queryPageResult(Map<String, Object> params);

    /**
     * 从cs_mid_baseinfo查询出结果插入到sm_baseinfo中去
     * 
     * @author zhuyong
     * @param priPID
     * @throws Exception
     */
    public void insertOneFromCsMidBaseinfo(Map<String,Object> qryMap) throws Exception;

    /**
     * 描述：小微企业年报信息列表
     * @author baifangfang
     * @date 2017年5月11日
     * @param params
     * @return
     */
    List<SmBaseinfoDto> selectYrInfoListByPriPID(Map<String, Object> params);
    
    
	/**
	 * 
	 * 描述: 年报信息统计（普通统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<SmBaseinfoDto> selectYrSmNormalCount(Map<String,Object> queryMap)throws Exception;
	/**
	 * 
	 * 描述: 年报信息统计（八大重点产业统计）
	 * @auther gaojinling
	 * @date 2017年5月5日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<SmBaseinfoDto> selectYrSmImPortCount(Map<String,Object> queryMap)throws Exception;
	
		/** 
	 * 描述: 根据注册号获取不在培育库的pripid
	 * @author 张文男
	 * @date 2017年6月15日 
	 * @param regNoOrUniCode
	 * @return 
	 */
	
	public List<String> queryPriPIDByRegNoOrUniCode(String regNoOrUniCode);
	
	/** 
	 * 描述: 根据pripid获取类型
	 * @author 张文男
	 * @date 2017年6月20日 
	 * @param priPID
	 * @return 
	 */
	
	public List<String> selectTypeByPriPID(String priPID);
	
	/**
	 * 
	 * 描述: 小微企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseinfoCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 首页可视化年报相关统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public SmBaseinfoDto smbaseinfoNbCount(Map<String, Object> map) throws Exception;
  

	/**
	 * 
	 * 描述: 首页三次产业统计
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int smbaseThreeTypeCount(Map<String, Object> map) throws Exception;
    
	
}