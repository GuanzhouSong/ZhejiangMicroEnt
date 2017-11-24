/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月24日
 * @version 2.0
 */
package com.icinfo.cs.copysend.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.copysend.dto.CopySendFeedbackDto;
import com.icinfo.cs.copysend.model.CopySendFeedback;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_copy_send_feedback 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月24日
 */
public interface CopySendFeedbackMapper extends Mapper<CopySendFeedback> {
	
	
	/**
     * 描述:根据批次号查看反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月30日
     */
	List<CopySendFeedbackDto> selectCopySendFeedbackList(String copyFormNo) throws Exception;
	
	/**
     * 描述:查看反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年12月20日
     */
	CopySendFeedbackDto selectCopySendFeedback(Map<String, Object> qryMap) throws Exception;
	
}