/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.copysend.dto.CopySendFeedbackDto;
import com.icinfo.cs.copysend.model.CopySendFeedback;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_copy_send_feedback 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月24日
 */
public interface ICopySendFeedbackService extends BaseService {
	
	/**
     * 描述:添加抄告接收部门数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月26日
     */
	Integer insert(CopySendFeedback copySendFeedback) throws Exception;
	
	/**
     * 描述:根据批次号删除数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	Integer deleteByCopyFormNo(String copyFormNo) throws Exception;
	/**
     * 描述:根据uid更新反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月30日
     */
	Integer updateByCopyFormNoAndDeptCode(CopySendFeedback copySendFeedback,HttpSession session) throws Exception;
	
	/**
     * 描述:根据批次号查看反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月30日
     */
	List<CopySendFeedbackDto> selectCopySendFeedbackList(String copyFormNo) throws Exception;
	
	
}