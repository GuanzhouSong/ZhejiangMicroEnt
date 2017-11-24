/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年11月07日
 * @version 2.0
 */
package com.icinfo.cs.orderreform.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.orderreform.model.OrderReformSet;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_orderreform_set 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年11月07日
 */
public interface OrderReformSetMapper extends Mapper<OrderReformSet> {
	/**
	 * 
	 * 描述   查询责令整改列表	
	 * @author 赵祥江
	 * @date 2016年12月5日 上午11:30:09 
	 * @param 
	 * @return List<OrderReformSet>
	 * @throws
	 */
	public List<OrderReformSet> selectOrderReformSetList(Map<String,Object> queryMap)throws Exception;


	/**
	 * 
	 * 描述   根据文号检查获取文号
	 * @author 赵祥江
	 * @date 2016年12月5日 上午11:29:33 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public String selectOrderReformSetPenDecNoByDocShorName(Map<String,Object> queryMap)throws Exception;
}