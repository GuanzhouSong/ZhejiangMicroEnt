/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年03月02日
 * @version 2.0
 */
package com.icinfo.cs.favorable.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.favorable.dto.FavorAbleInfoDto;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_favorable_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年03月02日
 */
public interface FavorAbleInfoMapper extends Mapper<FavorAbleInfo> {

	List<FavorAbleInfoDto> selectFavorableInputInfo(Map<String, Object> params);
	
	/**
	 * 
	 * 描述   根据条件查询企业良好信息
	 * @author 赵祥江
	 * @date 2017年3月3日 下午2:43:45 
	 * @param 
	 * @return List<FavorAbleInfoDto>
	 * @throws
	 */
	public List<FavorAbleInfoDto> selectFavorAbleInfoList(Map<String,Object> queryMap) throws Exception;

	/**
	 * 
	 * 描述   根据主体身份代码和状态查询企业良好信息
	 * @author 赵祥江
	 * @date 2017年3月9日 上午10:33:35 
	 * @param 
	 * @return List<FavorAbleInfo>
	 * @throws
	 */
	public List<FavorAbleInfo> selectFavorAbleInfoBypriPIDAndEfftStatus(Map<String,Object> queryMap) throws Exception;

	/**
	 * 
	 * 描述   根据主体身份代码和状态查询不良信息
	 * @author 赵祥江
	 * @date 2017年3月9日 下午2:00:03 
	 * @param 
	 * @return List<FavorAbleInfo>
	 * @throws
	 */
	public List<FavorAbleInfo> selectCaseInfoBypriPIDAndEfftStatus(Map<String,Object> queryMap) throws Exception;
	
	/** 
	 * 描述: 根据身份号获取列表信息
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param queryMap
	 * @return
	 * @throws Exception 
	 */
	
	public List<FavorAbleInfo> selectListByCerNO(Map<String,Object> queryMap)  throws Exception;

	/**
	 * 描述：定时任务查询企业良好信息
	 * @author baifangfang
	 * @date 2017年10月16日
	 * @param updateDate
	 * @return
	 */
	List<FavorAbleInfo> selectFavorAbleInfoForBulletin(String updateDate);
	
}