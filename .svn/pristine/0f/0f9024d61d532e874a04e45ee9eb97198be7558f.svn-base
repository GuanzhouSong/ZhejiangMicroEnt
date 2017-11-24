/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service.impl;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.copysend.dto.CopySendFeedbackDto;
import com.icinfo.cs.copysend.mapper.CopySendFeedbackMapper;
import com.icinfo.cs.copysend.model.CopySendFeedback;
import com.icinfo.cs.copysend.service.ICopySendFeedbackService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_copy_send_feedback 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月24日
 */
@Service
public class CopySendFeedbackServiceImpl extends MyBatisServiceSupport implements ICopySendFeedbackService {
	
	@Autowired
	private CopySendFeedbackMapper copySendFeedbackMapper;
	/**
     * 描述:添加抄告接收部门数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月26日
     */
	public Integer insert(CopySendFeedback copySendFeedback) throws Exception{
		return copySendFeedbackMapper.insert(copySendFeedback);
	}
	
	/**
     * 描述:根据批次号删除数据
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月28日
     */
	public Integer deleteByCopyFormNo(String copyFormNo) throws Exception{
		Example example = new Example(CopySendFeedback.class);
		example.createCriteria().andEqualTo("copyFormNo", copyFormNo);
		return copySendFeedbackMapper.deleteByExample(example);
		
	}
	
	/**
     * 描述:根据uid更新反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月30日
     */
	public Integer updateByCopyFormNoAndDeptCode(CopySendFeedback copySendFeedback,HttpSession session) throws Exception{
		Example example = new Example(CopySendFeedback.class);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("copyFormNo", copySendFeedback.getCopyFormNo());
		qryMap.put("acceptDepartCode", copySendFeedback.getAcceptDepartCode());
		if("1".equals(sysUser.getUserType()))
			qryMap.put("userType", 1);
		if("2".equals(sysUser.getUserType()))
			qryMap.put("userType", 2);
		CopySendFeedbackDto feedback = copySendFeedbackMapper.selectCopySendFeedback(qryMap);
		example.createCriteria().andEqualTo("uid", feedback.getUid());
		return copySendFeedbackMapper.updateByExampleSelective(copySendFeedback, example);
	}
	
	/**
     * 描述:根据批次号查看反馈信息
     *
     * @throws Exception
     * @auther ylr
     * @date 2016年10月30日
     */
	public List<CopySendFeedbackDto> selectCopySendFeedbackList(String copyFormNo) throws Exception{
		return copySendFeedbackMapper.selectCopySendFeedbackList(copyFormNo);
	}
}