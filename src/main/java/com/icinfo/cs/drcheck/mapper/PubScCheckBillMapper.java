/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月02日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScCheckBillDto;
import com.icinfo.cs.drcheck.model.PubScCheckBill;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_sccheck_bill 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public interface PubScCheckBillMapper extends Mapper<PubScCheckBill> {
	
	/**
	 * 
	 * 描述:查询事项维护清单列表
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param request
	 * @return
	 */
	public List<PubScCheckBillDto> selectPubScCheckBillDtoList(Map<String,Object> map)throws Exception;
}