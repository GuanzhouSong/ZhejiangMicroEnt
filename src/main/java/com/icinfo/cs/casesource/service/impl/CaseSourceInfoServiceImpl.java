/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.casesource.service.impl;

import java.util.List;

import com.icinfo.cs.casesource.dto.CaseSourceInfoDto;
import com.icinfo.cs.casesource.mapper.CaseSourceInfoMapper;
import com.icinfo.cs.casesource.model.CaseSourceInfo;
import com.icinfo.cs.casesource.service.ICaseSourceInfoService;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_case_source_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月23日
 */
@Service
public class CaseSourceInfoServiceImpl extends MyBatisServiceSupport implements ICaseSourceInfoService {
	
	@Autowired
	private CaseSourceInfoMapper caseSourceInfoMapper;
	
	/**
	 * 描述：查询案源管理列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@Override
	public List<CaseSourceInfoDto> queryCaseSourceInfoList(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return caseSourceInfoMapper.selectCaseSourceInfoList(request.getParams());
	}

	/**
	 * 描述：通过uid查询案源信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @return CaseSourceInfo
	 * @throws Exception
	 */
	@Override
	public CaseSourceInfo doGetCaseSourceInfoByUid(String uid) throws Exception{
		CaseSourceInfo caseSourceInfo = new CaseSourceInfo();
		caseSourceInfo.setUid(uid);
		return caseSourceInfoMapper.selectOne(caseSourceInfo);
	}
	
	/**
	 * 描述：通过uid删除案源信息
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @return int
	 * @throws Exception
	 */
	public int deleteCaseSourceInfoByUid(String uid) throws Exception{
		CaseSourceInfo caseSourceInfo = new CaseSourceInfo();
		caseSourceInfo.setUid(uid);
		return caseSourceInfoMapper.delete(caseSourceInfo);
	}
	
	/**
	 * 描述：保存或修改案源信息
	 * 
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param request
	 * @throws Exception
	 */
	public boolean doSaveCaseSourceInfo(CaseSourceInfo caseSourceInfo,SysUserDto sysUser) 
			throws Exception{
		if (StringUtil.isEmpty(caseSourceInfo.getUid())) {
			if (caseSourceInfoMapper.insertSelective(caseSourceInfo) > 0) {
				return true;
			}
		}else{
			Example example = new Example(CaseSourceInfo.class);
			example.createCriteria()
			.andEqualTo("uid", caseSourceInfo.getUid());
			if (caseSourceInfoMapper.updateByExampleSelective(caseSourceInfo, example) >0) {
				return true;
			}
		}
		return false;
	}
}