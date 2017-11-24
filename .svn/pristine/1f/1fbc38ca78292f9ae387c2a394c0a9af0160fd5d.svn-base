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
 * 描述:    处罚类严违对应的Mapper接口.<br>
 *
 * @author caoxu
 * @date 2016年11月25日
 */
public interface ExpSeriousPunishListMapper extends Mapper<ExpSeriousCrimeList> {
	
	List<ExpSeriousCrimeListDto> getExpSecInApplyAllList(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getExpSecInApplySrcList(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getExpSecInApplyList(Map<String, Object> qryMap);
	
	List<ExpSeriousCrimeListDto> getSrcCase(Map<String, Object> qryMap);
	
	Integer applySrcTotalParm(Map<String, Object> qryMap);
	
	Integer applyTotalParm(Map<String, Object> qryMap);
	
	Integer applySrcTotal(Map<String, Object> map);
	
	Integer applyFirstTotal();
	
	Integer applyAuditTotal();
	
	Integer applyExpirTotal();
	
	Integer firstTotal();
	
	Integer auditTotal();
	
	Integer firstNotTotal();
	
	Integer passTotal();
	
	Integer auditNotTotal();
	
	/**
	 * 将初审人，初审时间，审核人，审核时间等清空
	 * @return
	 */
	int UpdateSomeMsg(String sourceId);
}