/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月01日
 * @version 2.0
 */
package com.icinfo.cs.specialrec.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.specialrec.dto.SpecialRecTaskDto;
import com.icinfo.cs.specialrec.model.SpecialRecTask;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_special_rec_task 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface SpecialRecTaskMapper extends Mapper<SpecialRecTask> {
    
	/**
	 * 描述：查询专项整治任务列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	List<SpecialRecTaskDto> selectSpecialrecTaskList(Map<String, Object> params);
   
	/**
	 * 描述：获取任务编号最大序号
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param queryMap
	 * @return Integer
	 * @throws Exception
	 */
	Integer selectDocNumBydeptShortName(Map<String, Object> queryMap);
    
	/**
	 * 描述：任务个数统计
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param request
	 * @return SpecialRecTaskDto
	 * @throws Exception
	 */
	SpecialRecTaskDto selectSpecialRecTaskInfoForCount(Map<String, Object> params);
}