/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月14日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.EmailTaskInfoDto;
import com.icinfo.cs.system.model.EmailTaskInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_email_task_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月14日
 */
public interface EmailTaskInfoMapper extends Mapper<EmailTaskInfo> {

	/**
	 * 
	 * 描述：根据任务id查询任务详情
	 * 
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @param params
	 * @return
	 */
	List<EmailTaskInfoDto> queryPageResultByUid(Map<String, Object> params);
}