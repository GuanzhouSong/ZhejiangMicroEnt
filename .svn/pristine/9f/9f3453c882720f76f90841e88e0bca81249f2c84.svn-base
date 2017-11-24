/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.smallent.service.impl;

import java.util.List;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.smallent.mapper.SmSupportInfoMapper;
import com.icinfo.cs.smallent.model.SmSupportInfo;
import com.icinfo.cs.smallent.service.ISmSupportInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_sm_support 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月31日
 */
@Service
public class SmSupportInfoServiceImpl extends MyBatisServiceSupport implements ISmSupportInfoService { 
	
	@Autowired
	SmSupportInfoMapper smSupportInfoMapper;
	
	/**
     * 获取小微企业扶持列表数据
     * @author yujingwei
     * @date 2016-10-17
     * @param request
     * @return PageResponse
     * @throws Exception
     */
	public List<SmSupportInfo> doGetSupportInfoList(PageRequest request) throws Exception{
	  PageHelper.startPage(request.getPageNum(), request.getLength());
	  return smSupportInfoMapper.selectSupportInfoList(request.getParams());
	}
	
	/**
     * 通过UID获取小微企业扶持详细信息
     * @author yujingwei
     * @date 2016-10-17
     * @param uID
     * @return SmSupportInfo
     * @throws Exception
     */
	public SmSupportInfo doGetSupportInfo(String uID) throws Exception{
		SmSupportInfo smSupportInfo = new SmSupportInfo();
		smSupportInfo.setUID(uID);
		return smSupportInfoMapper.selectOne(smSupportInfo);
	}

	@Override
	public List<SmSupportInfo> selectByPripid(String priPID) {
		Example example=new Example(SmSupportInfo.class);
		if(StringUtil.isNotBlank(priPID)){
			example.createCriteria().andEqualTo("priPID",priPID);
			example.setOrderByClause(" impSpDate desc "); //ImpSpDate//实施扶持政策日期  降序
			return smSupportInfoMapper.selectByExample(example);
		}
		return null;
	}

}