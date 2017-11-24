/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SendSmsTaskInfoDto;
import com.icinfo.cs.system.dto.TaskInfoCount;
import com.icinfo.cs.system.mapper.SendSmsTaskInfoMapper;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.cs.system.service.ISendSmsTaskInfoService;
import com.icinfo.cs.system.service.ISendSmsTaskService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_sendsms_task_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
@Service
public class SendSmsTaskInfoServiceImpl extends MyBatisServiceSupport implements ISendSmsTaskInfoService {

	@Autowired
	SendSmsTaskInfoMapper sendSmsTaskInfoMapper;

	@Autowired
	private ISendSmsTaskService sendSmsTaskService;

	@Override
	public List<SendSmsTaskInfoDto> queryPageResult(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		if (params.get("smsLerep") != null) {// 负责人
			params.put("smsLerep", "1");
		}
		if (params.get("smsLia") != null) {
			params.put("smsLia", "1");
		}
		return sendSmsTaskInfoMapper.queryPageResultByUID(request.getParams());
	}

	/**
	 * 描述：根据任务编号获取需要发送的企业集合（去重）
	 * @author yujingwei 
	 * @date 2017年2月21日
	 * @param request 
	 * @return List<SendSmsTaskInfoDto>
	 * @throws
	 */
	public List<SendSmsTaskInfoDto> doGetSmsTaskInfoList(String taskNO) throws Exception {
		SendSmsTask sendSmsTask = sendSmsTaskService.selectSmsTaskInfoByTaskid(taskNO);
		boolean isLerep = sendSmsTask.getSmsLerep() == null ? false : sendSmsTask.getSmsLerep().equals("1");
		boolean isLia = sendSmsTask.getSmsLia() == null ? false : sendSmsTask.getSmsLia().equals("1");
		if (isLerep && !isLia) {
			// 待发送负责人号码
			return sendSmsTaskInfoMapper.doGetDistincLerepList(taskNO);
		}
		if (isLia && !isLerep) {
			// 待发送联络员号码
			return sendSmsTaskInfoMapper.doGetDistincLiaList(taskNO);
		}
		if (isLerep && isLia) {
			// 待发送负责人+联络员号码
			return sendSmsTaskInfoMapper.doGetDistincLerepAndLiaList(taskNO);
		}
		return null;
	}

	/**
	 * 描述：短信发送结束后更新信息
	 *
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @param sendSmsTask,sendSmsTaskInfo,result
	 * @return void
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean updateTaskInfoForSendAfter(SendSmsTask sendSmsTask, SendSmsTaskInfoDto sendSmsTaskInfo,
			String result) throws Exception {
		if (sendSmsTask == null || sendSmsTaskInfo == null || StringUtil.isEmpty(result)) {
			return false;
		}

		String resultStatus = "";
		String sendstatus = "";
		String sendstatusOr = "";
		String sendPhone = sendSmsTaskInfo.getPhone();
		// 手机号码验证不通过
		if (result.equalsIgnoreCase("error")) {
			resultStatus = "0";
		} else {
			JSONObject object = (JSONObject) JSONObject.fromObject(result).get("result");
			if (!object.get("message").equals("null")) {
				sendstatus = (String) object.get("message");
			}
			if (!object.get("returnstatus").equals("null")) {
				sendstatusOr = (String) object.get("returnstatus");
			}
			if (sendstatus.equalsIgnoreCase("success") || sendstatusOr.equalsIgnoreCase("success")) {
				resultStatus = "1";
			} else {
				resultStatus = "0";
			}
		}
		Date resultTime = resultStatus.equals("0") ? null : new Date();
		boolean isLerep = sendSmsTask.getSmsLerep() == null ? false : sendSmsTask.getSmsLerep().equals("1");
		boolean isLia = sendSmsTask.getSmsLia() == null ? false : sendSmsTask.getSmsLia().equals("1");

		// 更新负责人短信下发状态及时间
		if (isLerep && !isLia) {
			sendSmsTaskInfo.setIsSendLerep(resultStatus);
			sendSmsTaskInfo.setSendLerepTime(resultTime);
			this.updateIsLerepSendSmsTaskInfo(sendPhone, sendSmsTaskInfo);
		}
		// 更新联络员短信下发状态及时间
		if (isLia && !isLerep) {
			sendSmsTaskInfo.setIsSendLia(resultStatus);
			sendSmsTaskInfo.setSendLiaTime(resultTime);
			this.updateIsLiaSendSmsTaskInfo(sendPhone, sendSmsTaskInfo);
		}
		// 更新联络员或负责人下发状态及时间
		if (isLerep && isLia) {
			Map<String, Object> pramMap = new HashMap<String, Object>();
			pramMap.put("phoneNum", sendPhone);
			pramMap.put("uid", sendSmsTaskInfo.getUID());

			List<SendSmsTaskInfo> updateInfoList = sendSmsTaskInfoMapper.doGetTaskInfoByNumAndTaskid(pramMap);
			if (CollectionUtils.isNotEmpty(updateInfoList)) {
				for (SendSmsTaskInfo resultNumInfo : updateInfoList) {
					// 手机号是负责人
					if (sendPhone.equals(resultNumInfo.getTel())) {
						this.updateIsLerepById(resultStatus, resultTime, resultNumInfo);
					}
					// 手机号是联络员
					if (sendPhone.equals(resultNumInfo.getLiaLeRepPhone())) {
						this.updateIsLiaById(resultStatus, resultTime, resultNumInfo);
					}
				}
			}
		}
		return true;
	}

	/**
	 * 描述：通过id更新短信发送结果状态
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @return
	 */
	private int updateIsLiaById(String resultStatus, Date resultTime, SendSmsTaskInfo resultNumInfo) {
		Example example = new Example(SendSmsTaskInfo.class);
		example.createCriteria().andEqualTo("id", resultNumInfo.getId());
		SendSmsTaskInfo sendSmsTaskInfo = new SendSmsTaskInfo();
		sendSmsTaskInfo.setIsSendLia(resultStatus);
		sendSmsTaskInfo.setSendLiaTime(resultTime);
		return sendSmsTaskInfoMapper.updateByExampleSelective(sendSmsTaskInfo, example);
	}

	/**
	 * 描述：通过id更新短信发送结果状态
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @return
	 */
	private int updateIsLerepById(String resultStatus, Date resultTime, SendSmsTaskInfo resultNumInfo) {
		Example example = new Example(SendSmsTaskInfo.class);
		example.createCriteria().andEqualTo("id", resultNumInfo.getId());
		SendSmsTaskInfo sendSmsTaskInfo = new SendSmsTaskInfo();
		sendSmsTaskInfo.setIsSendLerep(resultStatus);
		sendSmsTaskInfo.setSendLerepTime(resultTime);
		return sendSmsTaskInfoMapper.updateByExampleSelective(sendSmsTaskInfo, example);
	}

	/**
	 * 描述：通过负责人手机号更新短信发送状态
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @return
	 */
	public int updateIsLerepSendSmsTaskInfo(String phoneNum, SendSmsTaskInfoDto sendSmsTaskInfo) {
		SendSmsTaskInfo updateinfo = new SendSmsTaskInfo();
		Example example = new Example(SendSmsTaskInfo.class);
		example.createCriteria().andEqualTo("tel", phoneNum).andEqualTo("UID", sendSmsTaskInfo.getUID());
		updateinfo.setIsSendLerep(sendSmsTaskInfo.getIsSendLerep());
		updateinfo.setSendLerepTime(sendSmsTaskInfo.getSendLerepTime());
		return sendSmsTaskInfoMapper.updateByExampleSelective(updateinfo, example);
	}

	/**
	 * 描述：通过联络员手机号更新短信发送状态
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @return
	 */
	public int updateIsLiaSendSmsTaskInfo(String phoneNum, SendSmsTaskInfoDto sendSmsTaskInfo) {
		SendSmsTaskInfo updateinfo = new SendSmsTaskInfo();
		Example example = new Example(SendSmsTaskInfo.class);
		example.createCriteria().andEqualTo("liaLeRepPhone", phoneNum).andEqualTo("UID", sendSmsTaskInfo.getUID());
		updateinfo.setIsSendLia(sendSmsTaskInfo.getIsSendLia());
		updateinfo.setSendLiaTime(sendSmsTaskInfo.getSendLiaTime());
		return sendSmsTaskInfoMapper.updateByExampleSelective(updateinfo, example);
	}

	/**
	 * 描述：根据任务编号删除企业信息
	 * 
	 * @author yujingwei
	 * @date 2017年2月21日
	 * @param taskid
	 * @return int
	 */
	public int deleteTaskDetails(String uid) throws Exception {
		Example example = new Example(SendSmsTaskInfo.class);
		example.createCriteria().andEqualTo("UID", uid);
		return sendSmsTaskInfoMapper.deleteByExample(example);
	}

	@Override
	public List<SendSmsTaskInfoDto> queryPageResults(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		disposeCondition(request);
		return sendSmsTaskInfoMapper.queryPageResults(request.getParams());
	}

	private String split(String str) {
		StringBuffer sb = new StringBuffer();
		String[] temp = str.split(",");
		for (int i = 0; i < temp.length; i++) {
			if (!"".equals(temp[i]) && temp[i] != null)
				sb.append("\"" + temp[i] + "\",");
		}
		String result = sb.toString();
		String tp = result.substring(result.length() - 1, result.length());
		if (",".equals(tp))
			return result.substring(0, result.length() - 1);
		else
			return result;
	}

	@Override
	public List<SendSmsTaskInfoDto> queryPageResultAll(PageRequest request) {
		Map<String, Object> params = request.getParams();
		if (params.get("smsLerep") != null) {// 负责人
			params.put("smsLerep", "1");
		}
		if (params.get("smsLia") != null) {
			params.put("smsLia", "1");
		}
		return sendSmsTaskInfoMapper.queryPageResultByUIDAll(request.getParams());
	}

	
	/**
	 * 统计查询条件处理
	 * @param request
	 */
	private Map<String, Object> disposeCondition(PageRequest request) {
		Map<String, Object> params = request.getParams();
		if (params.get("smsLerep") != null) {// 负责人
			params.put("smsLerep", "1");
		}
		if (params.get("smsLia") != null) {
			params.put("smsLia", "1");
		}

		if (params.get("dept") != null) {
			if (!StringUtil.isEmpty(params.get("dept").toString())) {
				String dept = params.get("dept").toString();
				dept = split(dept);
				params.put("dept", dept);
			}
		}
		String cidRegNO = StringUtil.doSplitStringToSqlFormat(params.get("cidRegNO").toString(), ",");
		params.put("cidRegNO", cidRegNO);
		return params;
	}

	@Override
	public TaskInfoCount queryTaskInfoCount(PageRequest request) {
		Map<String, Object> params = disposeCondition(request);
		return sendSmsTaskInfoMapper.queryTaskInfoCount(params);
	}
}