/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.consult.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.consult.dto.ConsultInfoDto;
import com.icinfo.cs.consult.mapper.ConsultInfoMapper;
import com.icinfo.cs.consult.model.ConsultInfo;
import com.icinfo.cs.consult.service.IConsultInfoService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_consult_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年10月12日
 */
@Service
public class ConsultInfoServiceImpl extends MyBatisServiceSupport implements IConsultInfoService {

	@Autowired
	private  ConsultInfoMapper consultInfoMapper;
	
	private  IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 
	 * 描述   保存
	 * @author  赵祥江
	 * @date 2017年10月12日 上午9:48:05 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertConsultInfo(ConsultInfo consultInfo) throws Exception { 
		consultInfo.setUid(StringUtil.uuid());
		consultInfo.setCreateTime(DateUtil.getSysDate());
		return consultInfoMapper.insert(consultInfo);
	}

	/**
	 * 
	 * 描述   删除
	 * @author  赵祥江
	 * @date 2017年10月12日 上午9:49:22 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteConsultInfoByUid(String uid) throws Exception {
		if(StringUtil.isNotBlank(uid)){
			ConsultInfo consultInfo=new ConsultInfo ();
			consultInfo.setUid(uid);
			return consultInfoMapper.delete(consultInfo);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   修改
	 * @author  赵祥江
	 * @date 2017年10月12日 上午9:57:43 
	 * @param  
	 * @throws
	 */
	@Override
	public int updateConsultInfo(ConsultInfo consultInfo) throws Exception {
		if(consultInfo!=null&&StringUtil.isNotBlank(consultInfo.getUid())){
			consultInfo.setCreateTime(DateUtil.getSysDate());
			Example example = new Example(ConsultInfo.class);
			example.createCriteria().andEqualTo("uid", consultInfo.getUid()); 
			return consultInfoMapper.updateByExampleSelective(consultInfo, example);
		}
		return 0;
	}

	/**
	 * 
	 * 描述   根据uid单个查询
	 * @author  赵祥江
	 * @date 2017年10月12日 上午9:59:49 
	 * @param  
	 * @throws
	 */
	@Override
	public ConsultInfo selectConsultInfoByUid(String uid) throws Exception {
		if(StringUtil.isNotBlank(uid)){
			ConsultInfo consultInfo=new ConsultInfo();
			consultInfo.setUid(uid);
			return consultInfoMapper.selectOne(consultInfo);
		}
		return null;
	}
	
	/**
	 * 
	 * 描述   组装企业信息
	 * @author 赵祥江
	 * @date 2017年10月12日 上午10:14:55 
	 * @param 
	 * @return ConsultInfo
	 * @throws
	 */
	@Override
	public ConsultInfo getConsultInfo(ConsultInfo consultInfo) throws Exception{
		String priPID=consultInfo.getPriPID();
		List<MidBaseInfoDto> midBaseInfoDtoList= midBaseInfoService.doGetListByPriPID(priPID);
		if(midBaseInfoDtoList!=null&&midBaseInfoDtoList.size()>0){
			MidBaseInfoDto midBaseInfoDto=midBaseInfoDtoList.get(0);
			consultInfo.setPriPID(priPID);
			consultInfo.setEntName(midBaseInfoDto.getEntName());
			consultInfo.setRegNO(midBaseInfoDto.getRegNO());
			consultInfo.setUniSCID(midBaseInfoDto.getUniCode());
			consultInfo.setRegOrg(midBaseInfoDto.getRegOrg());
			consultInfo.setLocalAdm(midBaseInfoDto.getLocalAdm());
		} 
		return consultInfo;
	}

	/**
	 * 
	 * 描述   分页查询
	 * @author  赵祥江
	 * @date 2017年10月12日 下午1:57:15 
	 * @param  
	 * @throws
	 */
	@Override
	public List<ConsultInfoDto> queryConsultInfoListJSON(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> queryMap= request.getParams();
		return consultInfoMapper.selectConsultInfoList(queryMap);
	}
}