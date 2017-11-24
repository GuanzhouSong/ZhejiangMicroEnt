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

import com.icinfo.cs.system.dto.SendSmsTaskInfoDto;
import com.icinfo.cs.system.dto.TaskInfoCount;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sendsms_task_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
public interface SendSmsTaskInfoMapper extends Mapper<SendSmsTaskInfo> {

	/**
	 * 描述：根据任务id获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param params
	 * @return
	 */
	List<SendSmsTaskInfoDto> queryPageResultByUID(Map<String, Object> params);

	List<SendSmsTaskInfoDto> doGetDistincLerepList(String uid);

	List<SendSmsTaskInfoDto> doGetDistincLiaList(String uid);

	List<SendSmsTaskInfoDto> doGetDistincLerepAndLiaList(String uid);

	List<SendSmsTaskInfo> doGetTaskInfoByNumAndTaskid(Map<String, Object> pramMap);

	/**
	 * 描述：根据查询条件获取任务详情JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2017年3月7日
	 * @param params
	 * @return
	 */
	List<SendSmsTaskInfoDto> queryPageResults(Map<String, Object> params);

	/**
	 * 描述：根据查询条件获取任务详情JSON数据列表(一次性查询全部不分页)
	 *
	 * @author baifangfang
	 * @date 2017年3月7日
	 * @param params
	 * @return
	 */
	List<SendSmsTaskInfoDto> queryPageResultsAll(Map<String, Object> params);

	/**
	 * 描述：根据任务id获取任务详情JSON数据列表(一次性查询全部不分页)
	 *
	 * @author baifangfang
	 * @date 2017年2月21日
	 * @param params
	 * @return
	 */
	List<SendSmsTaskInfoDto> queryPageResultByUIDAll(Map<String, Object> params);

	/**
	 * 统计查询成功的企业
	 *
	 * @author baifangfang
	 * @date 2017年3月17日
	 * @param params
	 * @return
	 */
	int queryEntCount(Map<String, Object> params);

	/**
	 * 统计查询成功的负责人电话
	 *
	 * @author baifangfang
	 * @date 2017年3月17日
	 * @param params
	 * @return
	 */
	int queryLerepCount(Map<String, Object> params);

	/**
	 * 统计查询成功的联络员电话
	 *
	 * @author baifangfang
	 * @date 2017年3月17日
	 * @param params
	 * @return
	 */
	int queryLiaCount(Map<String, Object> params);

	TaskInfoCount queryTaskInfoCount(Map<String, Object> params);
}