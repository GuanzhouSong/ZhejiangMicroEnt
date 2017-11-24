/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月21日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SendSmsTaskDto;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sendsms_task 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
public interface SendSmsTaskMapper extends Mapper<SendSmsTask> {

	List<SendSmsTaskDto> selectSendSmsTaskInfo(Map<String, Object> params);

	int selectMaxId();

	List<SendSmsTask> selectSmsTaskByDeptId(Map<String, Object> params);

	List<SendSmsTask> selectNotOverTask(String deptId);
}