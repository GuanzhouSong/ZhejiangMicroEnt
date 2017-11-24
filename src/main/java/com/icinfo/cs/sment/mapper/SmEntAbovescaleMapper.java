/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年07月20日
 * @version 2.0
 */
package com.icinfo.cs.sment.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.dto.SmEntAbovescaleDto;
import com.icinfo.cs.sment.model.SmEntAbovescale;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    sm-ent-abovescale 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年07月20日
 */
public interface SmEntAbovescaleMapper extends Mapper<SmEntAbovescale> {
	
	/**
	 * 
	 * 描述: 查询当前库中最大批次
	 * @auther gaojinling
	 * @date 2017年7月20日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer selectImBatchNum(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 查询规上企业
	 * @auther gaojinling
	 * @date 2017年7月21日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> selectSmEntAbovescale(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 限上规上企业成长轨迹
	 * @auther gaojinling
	 * @date 2017年8月16日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<SmEntAbovescaleDto> smEntAbovescaleCount(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 限上归上企业总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer smEntAbovescaleTotal(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 动产抵押总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer mortRegInfoTotal(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 国家局商标总数
	 * @auther gaojinling
	 * @date 2017年8月17日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public Integer tmDetailInfoTotal(Map<String, Object> map) throws Exception;
	
	
}