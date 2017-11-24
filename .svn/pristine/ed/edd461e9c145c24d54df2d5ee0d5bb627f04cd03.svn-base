/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月17日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.PubOtherpunish;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_otherpunish 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
public interface PubOtherpunishMapper extends Mapper<PubOtherpunish> {
     
	
	List<PubOtherpunish> selectOtherPunishInfo(Map<String, Object> params);
     
	
	
	List<PubOtherpunishDto> selectInfoForPunishSearch(Map<String, Object> params);



	PubOtherpunishDto selectOtherPunishDetails(Map<String, Object> qryMap);



	int selectTotalForPunishSearch(Map<String, Object> params);



	int selectAmountForPunishSearch(Map<String, Object> params);
	
	/** 
	 * 描述: 获取行政处罚信息列表数据（公示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param params
	 * @return 
	 */
	List<PubOtherpunishDto> selectPubOtherpunishForPub(Map<String, Object> params);
	
	/** 
	 * 描述: 根据caseNO获取行政处罚信息详情（公示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param caseNO
	 * @param priPID
	 * @return 
	 */
	PubOtherpunishDto selectPubOtherpunishByCaseNO(@Param("caseNO")String caseNO, @Param("priPID")String priPID);

	/** 
	 * 
	 * 描述   查询工商和其他部门的行政处罚
	 * @author 赵祥江
	 * @date 2017年3月16日 下午4:04:09 
	 * @param 
	 * @return List<PubOtherpunishDto>
	 * @throws
	 */
	List<PubOtherpunishDto> selectPubOtherpunishDto(Map<String, Object> params) throws Exception;
	
	List<PubOtherpunishDto> selectPunishSearchTotal(Map<String, Object> params) throws Exception;

	List<PubOtherpunish> selectOtherPunishForBulletin(String updateDate);
    
	List<PubOtherpunish> selectOtherpunishListForIdx(Map<String, Object> params);



	PubOtherpunishDto doGetOtherPunishInfo(@Param("caseNO")String caseNO);
}