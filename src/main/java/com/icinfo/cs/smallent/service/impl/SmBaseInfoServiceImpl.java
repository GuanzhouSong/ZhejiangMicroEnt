/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.service.impl;

import java.util.List;

import com.icinfo.cs.smallent.dto.SmBaseInfoDto;
import com.icinfo.cs.smallent.mapper.SmBaseInfoMapper;
import com.icinfo.cs.smallent.model.SmBaseInfo;
import com.icinfo.cs.smallent.service.ISmBaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_sm_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Service
public class SmBaseInfoServiceImpl extends MyBatisServiceSupport implements ISmBaseInfoService {
	
	@Autowired
	SmBaseInfoMapper smBaseInfoMapper;
	
	/**
	 * 描述: 获取小微企业库列表数据
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param request
	 * @return List<SmBaseInfo>
	 * @throws Exception
	 */
	public List<SmBaseInfo> doGetSmallDirInfoList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return smBaseInfoMapper.selectSmallDirInfoList(request.getParams());
	}
	
	/**
	 * 描述: 获取小微企业库详细信息
	 * @auther yujingwei
	 * @date 2016年10月17日
	 * @param uID
	 * @return SmBaseInfo
	 * @throws Exception
	 */
	public SmBaseInfoDto doGetSmBaseInfo(String UID) throws Exception{
	  return smBaseInfoMapper.selectDirBaseInfo(UID);
	}
}