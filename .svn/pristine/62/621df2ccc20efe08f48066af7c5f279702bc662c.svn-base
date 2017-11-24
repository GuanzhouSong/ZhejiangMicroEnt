/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月28日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidInvDto;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_inv 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface MidInvMapper extends Mapper<MidInv> {

	/**
	 * 描述：根据priPID查询股东及出资信息
	 * @author baifangfang
	 * @date 2016年9月23日
	 * @param params
	 * @return
	 */
	List<MidInvDto> queryPageResultByPripid(Map<String, Object> params);
	
	/**
	 * 描述：根据cerNO查询股东及出资信息
	 * @author baifangfang
	 * @date 2016年9月23日
	 * @param params
	 * @return
	 */
	List<MidInvDto> queryPageResultByCerNO(Map<String, Object> params);

	/**
	 * 描述：根据priPID查询股东及出资信息（不分页）
	 * @author baifangfang
	 * @date 2016年12月8日
	 * @param params
	 * @return
	 */
	List<MidInvDto> queryListResultByPripid(Map<String, Object> queryMap);

	/**
	 * 描述：查询执行事务合伙人名称列表
	 * @author baifangfang
	 * @date 2017年3月10日
	 * @param params
	 * @return
	 */
	List<MidInv> queryListResultByExeAffSign(Map<String, Object> queryMap);

	List<MidInv> selectMidInvInfoByCerNO(String certNO);

	/**
	 * 描述：根据证件号和姓名查询法人数量（合伙企业）
	 * @author baifangfang
	 * @date 2017年4月10日
	 * @param qryMap
	 * @return
	 */
	int selectMidInvCountByCerNOAndName(Map<String, Object> qryMap);
}