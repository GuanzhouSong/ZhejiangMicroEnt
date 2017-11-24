/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月09日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.BaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.BaseInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface BaseInfoMapper extends Mapper<BaseInfo> {

	List<BaseInfoDto> selectBaseInfoList(String priPID);

	/**
	 * 描述：企业年报信息查看详情列表页
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param params
	 * @return
	 */
	List<BaseInfoDto> selectYrInfoListByPriPID(Map<String, Object> params);

	/**
	 * 描述：根据priPID和year查询该企业年报信息
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param queryMap
	 * @return
	 */
	BaseInfoDto selectBaseInfoByPriPIDAndYear(Map<String, Object> queryMap);
	
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

	/**
	 * 描述：年报资产类信息查询
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param params
	 * @return
	 */
	List<BaseInfoDto> selectEntBaseinfoAssetList(Map<String, Object> params);

	/**
	 * 描述：年报资产类信息统计（企业）
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param params
	 * @return
	 */
	YrAssetCount queryEntYrAssetCount(Map<String, Object> params);
	
}