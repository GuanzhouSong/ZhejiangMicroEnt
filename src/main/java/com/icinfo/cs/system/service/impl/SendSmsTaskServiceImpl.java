/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.service.ICsQuartzJobService;
import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SendSmsTaskDto;
import com.icinfo.cs.system.dto.SendSmsTaskInfoDto;
import com.icinfo.cs.system.mapper.SendSmsTaskInfoMapper;
import com.icinfo.cs.system.mapper.SendSmsTaskMapper;
import com.icinfo.cs.system.model.SendSmsTask;
import com.icinfo.cs.system.model.SendSmsTaskInfo;
import com.icinfo.cs.system.service.ISendSmsTaskInfoService;
import com.icinfo.cs.system.service.ISendSmsTaskService;
import com.icinfo.cs.yr.model.DepartMent;
import com.icinfo.cs.yr.service.IDepartMentService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.core.transaction.annotation.Transaction;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_sendsms_task 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年02月21日
 */
@Service
public class SendSmsTaskServiceImpl extends MyBatisServiceSupport implements ISendSmsTaskService {

	@Autowired
	SendSmsTaskMapper sendSmsTaskMapper;

	@Autowired
	ICsQuartzJobService csQuartzJobService;

	@Autowired
	private ISendSmsTaskInfoService sendSmsTaskInfoService;

	@Autowired
	private ISmsService smsService;
	
	@Autowired
	private IDepartMentService departMentService;

	public final static String sendSmsTaskStatus01 = "1"; // 待发送
	public final static String sendSmsTaskStatus02 = "2"; // 发送中
	public final static String sendSmsTaskStatus03 = "3"; // 已结束

	@Autowired
	SendSmsTaskInfoMapper sendSmsTaskInfoMapper;

	@Override
	public SendSmsTask findSendSmsTaskByTaskId(String taskId) {
		SendSmsTask sendSmsTask = new SendSmsTask();
		sendSmsTask.setTaskid(taskId);
		return sendSmsTaskMapper.selectOne(sendSmsTask);
	}

	/**
	 * 描述：获取任务列表数据
	 * 
	 * @author yujingwei
	 * @param request
	 * @return PageResponse
	 * @throws Exception
	 */
	public List<SendSmsTaskDto> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return sendSmsTaskMapper.selectSendSmsTaskInfo(request.getParams());
	}

	/**
	 * 描述：通过taskid删除任务信息
	 * 
	 * @author yujingwei
	 * @param taskid
	 * @return int
	 * @throws Exception
	 */
	public int deletSmsTaskInfoByTaskid(String uid) throws Exception {
		Example example = new Example(SendSmsTask.class);
		example.createCriteria().andEqualTo("UID", uid);
		return sendSmsTaskMapper.deleteByExample(example);
	}

	/**
	 * 描述：通过任务编号查询任务信息
	 * 
	 * @author yujingwei
	 * @param taskid
	 * @return SendSmsTask
	 * @throws Exception
	 */
	public SendSmsTask selectSmsTaskInfoByTaskid(String UID) throws Exception {
		SendSmsTask sendSmsTask = new SendSmsTask();
		sendSmsTask.setUID(UID);
		return sendSmsTaskMapper.selectOne(sendSmsTask);
	}

	@Override
	public int update(SendSmsTaskDto sendSmsTask) {
		return sendSmsTaskMapper.updateByPrimaryKeySelective(sendSmsTask);
	}

	public int updateSendSmsTaskStatus(String UID, String taskType) {
		SendSmsTask sendSmsTask = new SendSmsTask();
		sendSmsTask.setTaskType(taskType);
		Example example = new Example(SendSmsTask.class);
		example.createCriteria().andEqualTo("UID", UID);
		return sendSmsTaskMapper.updateByExampleSelective(sendSmsTask, example);
	}

	@Override
	public int insert(SendSmsTaskDto sendSmsTask) {
		return sendSmsTaskMapper.insert(sendSmsTask);
	}

	@Override
	@Transaction
	public int saveSendSmsTaskInfoAndSendSmsTask(Map<String, SendSmsTaskInfo> infoMap, SendSmsTaskDto sendSmsTask) {
		int i = sendSmsTaskMapper.insert(sendSmsTask);// 添加任务
		int j = 0;
		String uid = sendSmsTask.getUID();
		for (String key : infoMap.keySet()) {
			SendSmsTaskInfo sendSmsTaskInfo = infoMap.get(key);
			sendSmsTaskInfo.setTaskid(sendSmsTask.getTaskid());
			sendSmsTaskInfo.setUID(uid);
			sendSmsTaskInfo.setCreateTime(new Date());
			j++;
			sendSmsTaskInfo.setSmsid(j + "");
			sendSmsTaskInfoMapper.insert(sendSmsTaskInfo);// 添加任务详情
		}
		return i;
	}

	@Override
	public int getMaxId() {
		return sendSmsTaskMapper.selectMaxId();
	}

	@Override
	public List<SendSmsTask> findSmsTaskByDeptId(String deptCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptId", deptCode);
		return sendSmsTaskMapper.selectSmsTaskByDeptId(params);
	}

	@Override
	public List<SendSmsTask> findNotOverTask(String deptId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("deptId", deptId);
		return sendSmsTaskMapper.selectNotOverTask(deptId);
	}

	@Override
	public SendSmsTask findSendSmsTaskByUID(String uid) {
		SendSmsTask sendSmsTask = new SendSmsTask();
		sendSmsTask.setUID(uid);
		return sendSmsTaskMapper.selectOne(sendSmsTask);
	}
	
	
	/**
	 * 描述：查询所需要执行的不同地市任务
	 * @author yujingwei
	 * @param  district
	 * @return List<SendSmsTask>
	 * @throws Exception
	 */
	private List<SendSmsTask> getDistrictSmsTask(String district) {
		String dateStr = DateUtil.getCurrentTime();
		List<SendSmsTask> reBackTaskInList = new ArrayList<SendSmsTask>();
		// 查询当前时间之前的未发送任务
		List<SendSmsTask> sendSmsTaskList = this.doGetSmsTaskBySetTime(dateStr);
		if(CollectionUtils.isEmpty(sendSmsTaskList)){
			return null;
		}
		// 得到各个地市未发送任务
		for (SendSmsTask sendSmsTask : sendSmsTaskList) {
			DepartMent departMent = departMentService.selectOne(sendSmsTask.getDeptId());
			if(departMent !=null){
				String deptCode = departMent.getDeptCode();
				if(StringUtil.isNotEmpty(deptCode) 
				             && StringUtils.length(deptCode) >= 4){
					 String subStr = deptCode.substring(0, 4);
					 if(subStr.equals(district)){
						 reBackTaskInList.add(sendSmsTask);
					 }
				 }
			}
		}
		// 每次执行，每个地市，发送任务数不超过10
		if(reBackTaskInList.size() >= 10){
			return reBackTaskInList.subList(0, 10);
		}
		return reBackTaskInList;
	}
	
	/**
	 * 描述：通过开始时间查找任务信息
	 * 
	 * @author yujingwei
	 * @param dateStr
	 * @return List<SendSmsTask>
	 * @throws Exception
	 */
	private List<SendSmsTask> doGetSmsTaskBySetTime(String dateStr) {
		Example example = new Example(SendSmsTask.class);
		example.createCriteria().andLessThanOrEqualTo("smsDate", dateStr)
		.andEqualTo("taskType", sendSmsTaskStatus01);
		return sendSmsTaskMapper.selectByExample(example);
	}
	
	/**
	 * 描述：定时发送短信
	 * 
	 * @author yujingwei
	 * @throws Exception
	 */
	public void doSendSmsMsgByQuartz(List<SendSmsTask> sendSmsTaskList) throws Exception {
		if (CollectionUtils.isNotEmpty(sendSmsTaskList)) {
			for (SendSmsTask sendSmsTask : sendSmsTaskList) {
				// 任务开始前的校验
				if(StringUtil.isEmpty(sendSmsTask.getUID()) || sendSmsTask.getTaskType().equals(sendSmsTaskStatus03)){
					continue;
				}
				// 任务进行中
				this.updateSendSmsTaskStatus(sendSmsTask.getUID(), sendSmsTaskStatus02);
				// 获取所需要发送电话号码集合
				List<SendSmsTaskInfoDto> sendSmsTaskInfoList = sendSmsTaskInfoService.doGetSmsTaskInfoList(sendSmsTask.getUID());
				if (CollectionUtils.isNotEmpty(sendSmsTaskInfoList)) {
					for (SendSmsTaskInfoDto sendSmsTaskInfo : sendSmsTaskInfoList) {
						try {
							if (StringUtil.isEmpty(sendSmsTaskInfo.getPhone())) {
								continue;
							}
							// 发送前校验是否发送过
							Map<String, Object> pramMap = new HashMap<String, Object>();
							pramMap.put("phoneNum", sendSmsTaskInfo.getPhone());
							pramMap.put("uid", sendSmsTaskInfo.getUID());
							pramMap.put("isSendFlag","1");
							List<SendSmsTaskInfo> isSendList = sendSmsTaskInfoMapper.doGetTaskInfoByNumAndTaskid(pramMap);
							if(isSendList !=null && isSendList.size() >0){
								continue;
							}
							// 发送号码
							String phone = sendSmsTaskInfo.getPhone();
							// 短信内容
							String[] smsMsgArry = sendSmsTask.getSmsMsg().split("】");
							String smsContent = smsMsgArry[1];
							String result = smsService.doSendMsgForSmsTask(phone, smsContent,
									sendSmsTaskInfo.getRegOrg());
							// 每次发送结束，更新发送的结果，下发时间等
							sendSmsTaskInfoService.updateTaskInfoForSendAfter(sendSmsTask, sendSmsTaskInfo, result);
						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
					}
				}
				// 任务结束，更新任务状态
				this.updateSendSmsTaskStatus(sendSmsTask.getUID(), sendSmsTaskStatus03);
			}
		}
	}
	
	@Override
	public void sjSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3300"));
	}
	
	public void hzSmsTask() throws Exception{
		doSendSmsMsgByQuartz(getDistrictSmsTask("3301"));
	}
	
	public void nbSmsTask() throws Exception{
		doSendSmsMsgByQuartz(getDistrictSmsTask("3302"));
	}

	@Override
	public void wzSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3303"));
	}

	@Override
	public void jxSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3304"));
	}

	@Override
	public void huzSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3305"));
	}

	@Override
	public void sxSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3306"));
	}

	@Override
	public void jhSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3307"));
	}

	@Override
	public void qzSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3308"));
	}

	@Override
	public void zsSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3309"));
	}

	@Override
	public void tzSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3310"));
	}

	@Override
	public void lsSmsTask() throws Exception {
		doSendSmsMsgByQuartz(getDistrictSmsTask("3325"));
	}
}