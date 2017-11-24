/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月11日
 * @version 2.0
 */
package com.icinfo.cs.opanomaly.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_opadetail 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
public interface PubOpaDetailMapper extends Mapper<PubOpaDetail> {
	
	/**
	 * 
	 * 描述: 移出查询
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectMoveOutSearchList(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述: 移出新增查询（列入未移出且未申请移出（即不属于移出待审核状态））（同撤销新增查询）
	 * @auther gaojinling
	 * @date 2016年10月25日 
	 * @param queryMap
	 * @return
	 * @throws Exception
	 */
	public List<PubOpaDetailDto> selectAddMoveOutSearchList(Map<String,Object> queryMap)throws Exception;
	
	/**
	 * 
	 * 描述: 获取当前登记机关下最大移出文号
	 * @auther gaojinling
	 * @date 2016年10月28日 
	 * @param queryMap
	 * @return
	 */
	public Integer selectPenDecNoMove (Map<String,Object> queryMap);
	
	
	/**
	 * 
	 * 描述: 列入待审核条数（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectPubOpaInCount(Map<String, Object> map) throws Exception ;
	/**
	 * 
	 * 描述: 移出+撤销待审核条数（警示首页）
	 * @auther gaojinling
	 * @date 2017年3月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectPubOpaOutCount(Map<String, Object> map) throws Exception ;
	
	
	
}