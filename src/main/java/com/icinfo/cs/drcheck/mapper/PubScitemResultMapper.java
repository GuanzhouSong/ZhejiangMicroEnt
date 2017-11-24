/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月26日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScitemResultDto;
import com.icinfo.cs.drcheck.model.PubScitemResult;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_scitem_result 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubScitemResultMapper extends Mapper<PubScitemResult> {
	/**
	 * 根据priPID获取抽查检查信息列表
	 *
	 * @author chenyu
	 * @date 2016-10-28
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScitemResultDto> selectPubScitemResultListByPriPID(Map<String,Object> qryMap);

	/**
	 * 描述:查询审批项（第一次进入未保存）
	 * @author chenxin
	 * @date 2016-10-27
	 * @param taskNO
	 * @param inspectDept
	 * @return
	 * @throws Exception
	 */
	public List<PubScitemResult> selectPubScitemResultListNew(Map<String,Object> params)throws Exception;

}