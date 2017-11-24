/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月29日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidLeRepDto;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_lerep 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public interface MidLeRepMapper extends Mapper<MidLeRep> {
	
	List<MidLeRepDto> selectMidLeRepList(Map<String, Object> qryMap);
	
	/**
	 * 描述：任职资格黑名单查询列表
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	List<MidLeRepDto> selectMidLeRepBackList(Map<String, Object> qryMap);
	/**
	 * 描述：受限对象受限原因
	 * @author chenxin
	 * @date 2017-03-21
	 * @param qryMap
	 * @return
	 */
	List<MidLeRepDto> selectMidLeRepBackReasonList(Map<String, Object> qryMap);

	List<MidLeRep> selectMidLeRepListByCerNO(String certNO);

	/**
	 * 描述：根据身份证号和姓名查询法人数量
	 * @author baifangfang
	 * @date 2017年4月10日
	 * @param qryMap
	 * @return
	 */
	int selectMidLeRepCountByCerNOAndName(Map<String, Object> qryMap);

	/**
	 * 描述：获取法人名称列表
	 * @author baifangfang
	 * @date 2017年6月14日
	 * @param params
	 * @return
	 */
	List<MidLeRep> findMidLerepByPriPIDList(Map<String, Object> params);

}