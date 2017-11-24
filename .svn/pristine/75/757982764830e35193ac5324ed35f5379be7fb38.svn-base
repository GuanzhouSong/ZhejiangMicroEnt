/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月25日
 * @version 2.0
 */
package com.icinfo.cs.secnocreditsup.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_exp_serious_crime_list 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
public interface ExpSeriousCrimeListMapper extends Mapper<ExpSeriousCrimeList> {
	
	List<ExpSeriousCrimeListDto> getExpSecInApplyListCommon(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getExpSecInApplyList(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getExpSecSearchList(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getExpSecOpaList(Map<String, Object> qryMap);
	
	Integer getNumByBusinessStatus(Map<String, Object> qryMap);
	
	Integer selectMaxAddSecCountNo(Map<String, Object> qryMap);
	
	Integer getYQLRNum(Map<String, Object> qryMap);
	
	Integer getDLRNum(Map<String, Object> qryMap);

	List<ExpSeriousCrimeList> selectSeriousCrimeInfoForBulletin(String updateDate);
	
	/**
	 * 将初审人，初审时间，审核人，审核时间等清空
	 * @return
	 */
	int UpdateSomeMsg(String sourceId);
}
