/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.yr.mapper.YrFormMapper;
import com.icinfo.cs.yr.model.YrForm;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;

/**
 * 描述:    cs_yr_form 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月13日
 */
@Service
public class YrFormServiceImpl extends MyBatisServiceSupport implements IYrFormService {
	@Autowired
	YrFormMapper yrFormMapper;
	/** 
	 * 描述: 查询当年度表单填写情况
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception 
	 */
	@Override
	public YrForm selectYrFormByPripidAndYear(String priPID, Integer year)
			throws Exception {
		if(StringUtils.isNotBlank(priPID) && year != null) {
			YrForm yrForm = new YrForm();
			yrForm.setPriPID(priPID);
			yrForm.setYear(year);
			return yrFormMapper.selectOne(yrForm);
		}
		return null;
	}

	/** 
	 * 描述: 初始化当年度表单填写情况
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param priPID
	 * @param year
	 * @param reportTypeList
	 * @return
	 * @throws Exception 
	 */
	@Override
	public int insert(String priPID, Integer year, List<String> reportTypeList) throws Exception {
		YrForm yrForm = new YrForm();
		yrForm.setPriPID(priPID);
		yrForm.setYear(year);
		yrForm.setCreateTime(new Date());
		for(String rep : reportTypeList) {
			if(RepTypeUtil.formSubcapital.equals(rep)){
				yrForm.setSubcapital("0");
			}
			if(RepTypeUtil.formAsset.equals(rep)){
				yrForm.setAsset("0");
			}
			if(RepTypeUtil.formAssetbranch.equals(rep)){
				yrForm.setAssetbranch("0");
			}
			if(RepTypeUtil.formAlterstockinfo.equals(rep)){
				yrForm.setAlterstockinfo("0");
			}
			if(RepTypeUtil.formForinvestment.equals(rep)){
				yrForm.setForinvestment("0");
			}
			if(RepTypeUtil.formForguaranteeinfo.equals(rep)){
				yrForm.setForguaranteeinfo("0");
			}
			if(RepTypeUtil.formOtherinfo.equals(rep)){
				yrForm.setOtherinfo("0");
			}
			if(RepTypeUtil.formSocialSecurity.equals(rep)){
				yrForm.setSocialSecurity("0");
			}
		}
		return yrFormMapper.insert(yrForm);
	}


	/**
	 * 更新Form表单状态
	 * @autor: wangjin
	 * @param yrForm
	 * @return
	 */
	@Override
	public int updateForm(YrForm yrForm) {
		//时间戳
		//yrForm.setCreateTime(DateUtil.getSysDate());
		Example example = new Example(YrForm.class);
		example.createCriteria().andEqualTo(Constants.CS_YEAR, yrForm.getYear()).andEqualTo(Constants.CS_PRIPID,yrForm.getPriPID());
		return yrFormMapper.updateByExampleSelective(yrForm,example);
	}








	/**
	 *
	 * 描述             : 根据年度和主体代码更新表单填写情况表
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 下午8:42:01
	 * @param :
	 * @throws
	 */
	@Override
	public int updateYrFormByPripidAndYear(YrForm yrForm) throws Exception {
		//时间戳
		yrForm.setCreateTime(DateUtil.getSysDate());
		if(StringUtil.isNotEmpty(yrForm.getPriPID())&&StringUtil.isNotEmpty(yrForm.getYear().toString())){
			Example example = new Example(YrForm.class);
			example.createCriteria()
			.andEqualTo(Constants.CS_PRIPID,yrForm.getPriPID())
			.andEqualTo(Constants.CS_YEAR, yrForm.getYear());
			return yrFormMapper.updateByExampleSelective(yrForm, example);
		}
		return 0;
	}

	/** 
	 * 描述: 判断报表是否都已填报
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param priPID
	 * @param year
	 * @param reportTypeList
	 * @return
	 * @throws Exception 
	 */
	@Override
	public boolean doCheckAllForm(String priPID, Integer year, List<String> reportTypeList) throws Exception {
		if(StringUtils.isNotBlank(priPID) && year != null) {
			Example example = new Example(YrForm.class);
			Example.Criteria criteria = example.createCriteria();
			criteria.andEqualTo(Constants.CS_PRIPID, priPID);
			criteria.andEqualTo(Constants.CS_YEAR, year);
			for(String rep : reportTypeList) {
				criteria.andEqualTo(rep, "1");
			}
			List<YrForm> yrFormList = yrFormMapper.selectByExample(example);
			if(yrFormList.isEmpty()){
				return false;
			}
			return true;
		}
		return false;
	}
	
}