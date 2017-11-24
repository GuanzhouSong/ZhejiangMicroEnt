/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.registmanage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.registmanage.dto.LimitManageRecordDto;
import com.icinfo.cs.registmanage.mapper.LimitManageRecordMapper;
import com.icinfo.cs.registmanage.model.LimitManageRecord;
import com.icinfo.cs.registmanage.service.ILimitManageRecordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_limit_managerecord 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年04月10日
 */
@Service
public class LimitManageRecordServiceImpl extends MyBatisServiceSupport implements ILimitManageRecordService {

	@Autowired
	LimitManageRecordMapper limitManageRecordMapper;

	@Override
	public List<LimitManageRecordDto> qryLimitObjManageRecordList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return limitManageRecordMapper.qryLimitObjManageRecordList(request.getParams());
	}

	/**
	 * 
	 * 描述:提前解除限制资格解除证明保存
	 * 
	 * @auther gaojinling
	 * @date 2017年4月17日
	 * @param limitManageRecord
	 * @return
	 */
	public int save(LimitManageRecord limitManageRecord) throws Exception {
		limitManageRecord.setCreateTime(new Date());
		return limitManageRecordMapper.insert(limitManageRecord);
	}

	/**
	 * 
	 * 描述: 查询单个
	 * 
	 * @auther gaojinling
	 * @date 2017年4月17日
	 * @return
	 * @throws Exception
	 */
	public LimitManageRecord selectByUid(String uid, String removeUid) throws Exception {
		LimitManageRecord limitManageRecord = new LimitManageRecord();
		limitManageRecord.setUid(uid);
		limitManageRecord.setRemoveUid(removeUid);
		return limitManageRecordMapper.selectOne(limitManageRecord);
	}

	/**
	 * 
	 * 描述: 获取当前限制对象下的解除证明文号的最大值
	 * 
	 * @auther gaojinling
	 * @date 2017年4月17日
	 * @param queryMap
	 * @return
	 */
	public Integer selectLimitNo(String uid) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("uid", uid);
		queryMap.put("item", "任职资格限制解除证明"); // 管理事项
		return limitManageRecordMapper.selectLimitNo(queryMap);
	}

	@Override
	public Integer selectLimitNo(String uid, String item) throws Exception {
		Map<String, Object> queryMap = new HashMap<String, Object>();
		queryMap.put("uid", uid);
		queryMap.put("item", item); // 管理事项
		return limitManageRecordMapper.selectLimitNo(queryMap);
	}

}