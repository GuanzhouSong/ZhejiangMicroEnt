/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月08日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.SfcBaseInfoDto;
import com.icinfo.cs.yr.dto.YrAssetCount;
import com.icinfo.cs.yr.model.SfcBaseInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sfc_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface SfcBaseInfoMapper extends Mapper<SfcBaseInfo> {
	/**
	 * 
	 * 描述: 公示侧查询农专社基础信息
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param priPID
	 * @return
	 */
	List<SfcBaseInfoDto> selectSfcBaseinfoList(String priPID);

	/**
	 * 描述：根据priPID和year查询农专年报信息
	 * @author baifangfang
	 * @date 2016年10月26日
	 * @param queryMap
	 * @return
	 */
	SfcBaseInfoDto selectSfcYrInfoByPriPIDAndYear(Map<String, Object> queryMap);

	/**
	 * 描述：农专年报信息查看详情列表页
	 * @author baifangfang
	 * @date 2016年10月25日
	 * @param request
	 * @return
	 */
	List<SfcBaseInfoDto> selectSfcYrInfoListByPriPID(Map<String, Object> params);
	
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
	 * 描述：农专社资产状况信息
	 * @author baifangfang
	 * @date 2017年6月7日
	 * @param params
	 * @return
	 */
	List<SfcBaseInfoDto> selectSfcBaseinfoAssetList(Map<String, Object> params);

	/**
	 * 描述：农专社资产状况统计
	 * @author baifangfang
	 * @date 2017年6月8日
	 * @param params
	 * @return
	 */
	YrAssetCount querySfcYrAssetCount(Map<String, Object> params);
}