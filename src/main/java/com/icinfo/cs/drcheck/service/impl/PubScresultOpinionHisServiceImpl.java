/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.mapper.PubScresultOpinionHisMapper;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.cs.drcheck.model.PubScresultOpinionHis;
import com.icinfo.cs.drcheck.service.IPubScresultOpinionHisService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_scresult_opinion_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月17日
 */
@Service
public class PubScresultOpinionHisServiceImpl extends MyBatisServiceSupport implements IPubScresultOpinionHisService {
	
	@Autowired
	PubScresultOpinionHisMapper pubScresultOpinionHisMapper;
	
	/**
	 * 描述:保存审核历史记录
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresult，taskNO
	 * @return boolean
	 * @throws Exception
	 */
	public boolean savePubScresultOpinion(PubScresult pubScresult, String taskNO,SysUserDto sysUserDto) throws Exception{
		if(pubScresult == null || StringUtil.isEmpty(taskNO)){
			return false;
		}
		PubScresultOpinionHis pubScresultOpinionHis = new PubScresultOpinionHis();
		pubScresultOpinionHis.setAuditDate(new Date());
		pubScresultOpinionHis.setAuditFlag(pubScresult.getAuditState());
		pubScresultOpinionHis.setAuditOpin(pubScresult.getAuditOpin());
		pubScresultOpinionHis.setAuditUserName(sysUserDto.getRealName());
		pubScresultOpinionHis.setAuditUserUid(sysUserDto.getId());
		pubScresultOpinionHis.setDeptTaskNO(pubScresult.getTaskNO());
		pubScresultOpinionHis.setPriPID(pubScresult.getPriPID());
		pubScresultOpinionHis.setTaskNO(taskNO);
		if(pubScresultOpinionHisMapper.insert(pubScresultOpinionHis) < 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 描述:获取历次审核意见
	 * @author yujingwei
	 * @param priPID 
	 * @date 2016-10-27
	 * @param deptTaskNO，taskNO
	 * @return boolean
	 * @throws Exception
	 */
	public List<PubScresultOpinionHis> doGetScOpinionHisList(String taskNO,String deptTaskNO, String priPID) throws Exception{
		if(StringUtil.isEmpty(taskNO) || StringUtil.isEmpty(deptTaskNO) || StringUtil.isEmpty(priPID)){
			return new ArrayList<PubScresultOpinionHis>();
		}
		Example example = new Example(PubScresultOpinionHis.class);
		example.createCriteria().andEqualTo("taskNO", taskNO)
		.andEqualTo("deptTaskNO", deptTaskNO)
		.andEqualTo("priPID", priPID);
		return pubScresultOpinionHisMapper.selectByExample(example);
	}
}