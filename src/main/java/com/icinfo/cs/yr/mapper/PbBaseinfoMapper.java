/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月12日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.PbBaseinfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pb_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月12日
 */
public interface PbBaseinfoMapper extends Mapper<PbBaseinfo> {
	/**
	 * 
	 * 描述: 公示侧查询个体户基础信息
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param priPID
	 * @return
	 */
	List<PbBaseinfoDto> selectPbBaseInfoList(String priPID);

	/**
	 * 描述：根据PripID和year查询个体户年报信息
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param queryMap
	 * @return
	 */
	PbBaseinfoDto selectPbYrInfoByPriPIDAndYear(Map<String, Object> queryMap);

	/**
	 * 描述：个体户年报信息查看详情列表页
	 * @author baifangfang
	 * @date 2016年10月31日
	 * @param request
	 * @return
	 */
	List<PbBaseinfoDto> selectPbYrInfoListByPriPID(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 根据年报ID查询年报敏感词标记信息
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param AncheID
	 * @return
	 */
	String selectBaseInfoForbidwordInfoByAncheID(String AnCheID);
	
	/**
	 * 
	 * 描述: 根据年报ID查询年报敏感词标记信息
	 * @auther chenyl
	 * @date 2016年11月4日 
	 * @param queryMap
	 * @return
	 */
	String selectBaseInfoForbidwordInfoByPriPIDAndYear(@SuppressWarnings("rawtypes") HashMap queryMap);

    List<PbBaseinfoDto> selectPbYrInfoByPriPID(Map<String, Object> queryMap);

    /**
     * 描述：个体户资产状况信息
     * @author baifangfang
     * @date 2017年6月7日
     * @param params
     * @return
     */
	List<PbBaseinfoDto> selectPbBaseinfoAssetList(Map<String, Object> params);

	/**
	 * 描述：个体户资产状况统计
	 * @author baifangfang
	 * @date 2017年6月8日
	 * @param params
	 * @return
	 */
	YrAssetCount queryPbYrAssetCount(Map<String, Object> params);
}