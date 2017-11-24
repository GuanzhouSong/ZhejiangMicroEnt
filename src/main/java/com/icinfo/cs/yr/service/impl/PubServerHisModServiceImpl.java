/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.cs.yr.service.IPubServerHisModService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_pub_server_hismod 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月17日
 */
@Service
public class PubServerHisModServiceImpl extends MyBatisServiceSupport implements IPubServerHisModService {
	
	@Autowired
	PubServerHisModMapper pubServerHisModMapper;
	
	/**
     * 描述：获取修改记录列表数据(通过priPID和caseNO和altTable)
     * @author yujingwei
     * @data 2016-10-17
     * @param request
     * @return pubServerHisModList
     * @throws Exception
     */
	public List<PubServerHisMod> queryPage(PageRequest request) throws Exception{
		List<PubServerHisMod> pubServerHisModList = new ArrayList<PubServerHisMod>();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		if(request.getParams() != null){
			Example example = new Example(PubServerHisMod.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, request.getParams().get(Constants.CS_PRIPID))
			.andEqualTo("modUID", request.getParams().get("caseNO"))//记录号
			.andEqualTo("altTable", request.getParams().get("altTable"));//表名;
			pubServerHisModList = pubServerHisModMapper.selectByExample(example);
		}
		return pubServerHisModList;
	}
	
	/**
     * 描述：获取修改记录List(通过priPID，ModUID)
     * @author yujingwei
     * @data 2016-10-17
     * @param pripid,UID
     * @return pubServerHisModList
     * @throws Exception
     */
	public List<PubServerHisMod> doGetPubServerHisModList(String pripid,String UID) throws Exception{
		List<PubServerHisMod> pubServerHisModList = new ArrayList<PubServerHisMod>();
		if(StringUtil.isNotBlank(pripid) && StringUtil.isNotBlank(UID)){
			Example example = new Example(PubServerHisMod.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, pripid)
			.andEqualTo("modUID", UID);
			pubServerHisModList = pubServerHisModMapper.selectByExample(example);
		}
		return pubServerHisModList;
	}
}