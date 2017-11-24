/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScWorkPlanDto;
import com.icinfo.cs.sccheck.model.PubScWorkPlan;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scwork_plan 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScWorkPlanMapper extends Mapper<PubScWorkPlan> {
	/**
	 * 
	 * 描述   分页查询
	 * @author 赵祥江
	 * @date 2017年5月17日 上午11:15:46 
	 * @param 
	 * @return List<PubScWorkPlanDto>
	 * @throws
	 */
 public List<PubScWorkPlanDto> selectPubScWorkPlanList(Map<String,Object> queryMap)throws Exception ;
 /**
  * 
  * 描述   统计
  * @author chenxin
  * @date 2017年5月17日 上午11:15:46 
  * @param queryMap
  * @return PubScWorkPlanDto
  * @throws
  */
 public PubScWorkPlanDto selectCountAll(Map<String,Object> queryMap)throws Exception ;

 	/**
 	 * 描述：查询最大国家局内部序号
 	 * @author chenxin
 	 * @date 2017-10-23
 	 * @param innerCodeLike
 	 * @return
 	 */
	public String selectMaxInnerCode(String innerCodeLike)throws Exception;
}