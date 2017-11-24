/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.risk.service.impl;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.risk.dto.CsEntWarnDto;
import com.icinfo.cs.risk.mapper.CsEntWarnMapper;
import com.icinfo.cs.risk.mapper.CsWarnDeptMapper;
import com.icinfo.cs.risk.mapper.CsWarnMarkMapper;
import com.icinfo.cs.risk.model.CsEntWarn;
import com.icinfo.cs.risk.model.CsWarnMark;
import com.icinfo.cs.risk.service.ICsEntWarnService;
import com.icinfo.cs.risk.service.ICsWarnDeptService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_ent_warn 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
@Service
public class CsEntWarnServiceImpl extends MyBatisServiceSupport implements ICsEntWarnService {
	@Autowired
	CsEntWarnMapper csEntWarnMapper;

	@Autowired
	CsWarnMarkMapper csWarnMarkMapper;

	@Autowired
	CsWarnDeptMapper csWarnDeptMapper;
	
	@Autowired
	ICsWarnDeptService csWarnDeptService;
	  /**
	    * 获取企业申请
	    * @author zjj
	    * 20161018
	    */
    @Override
	public List<CsEntWarnDto> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csEntWarnMapper.selectEntWarnList(request.getParams());
	}
	@Override
	public List<CsEntWarnDto> selectCsEntWarnApplyInfo(Map<String, Object> qryMap) throws Exception {
		return csEntWarnMapper.selectEntWarnList(qryMap);
	}
	/**
	 * 插入标识
	 * @author zjj
	 * 20161024
	 */
	@Override
	public int insert(CsEntWarnDto csEntWarn) throws Exception {
		
		CsWarnMark csWarnMark = new CsWarnMark();
		
		csEntWarn.setCreateTime(new Date());
		csEntWarn.setImportDate(new Date());
		
		String[] arr = csEntWarn.getEntStr().split(",");
			for (String str : arr){
				if(StringUtils.isNotBlank(str)){
				   csEntWarn.setPriPID(str);
				   if(csEntWarnMapper.insert(csEntWarn)<0) return 0;
				}
			}
		//插入标识
		csWarnMark.setMarkNo(csEntWarn.getMarkNo());
		csWarnMark.setMarkSetYear(DateUtil.getCurrentYear());
		csWarnMark.setMarkType(csEntWarn.getMarkType());
		csWarnMark.setMarkClass(csEntWarn.getMarkClass());
		csWarnMark.setMarkName(csEntWarn.getMarkName());
		csWarnMark.setMarkContent(csEntWarn.getMarkContent());
		csWarnMark.setMarkStartDate(csEntWarn.getMarkStartDate());
		csWarnMark.setMarkEndDate(csEntWarn.getMarkEndDate());
		csWarnMark.setMarkSetDept(csEntWarn.getMarkSetDept());
		csWarnMark.setMarkSetDeptCode(csEntWarn.getMarkSetDeptCode());
		csWarnMark.setMarkAppointWay(csEntWarn.getMarkAppointWay());
		csWarnMark.setMarkAppointDept(csEntWarn.getMarkAppointDept());
		csWarnMark.setMarkAppointDeptCode(csEntWarn.getMarkAppointDeptCode());
		csWarnMark.setMarkSetDate(csEntWarn.getMarkSetDate());
		csWarnMark.setSetDeptContact(csEntWarn.getSetDeptContact());
		csWarnMark.setTel(csEntWarn.getTel());
		csWarnMark.setFax(csEntWarn.getFax());
		csWarnMark.setEmail(csEntWarn.getEmail());
		csWarnMark.setSetId(csEntWarn.getImportSetId());
		csWarnMark.setCreateTime(csEntWarn.getCreateTime());
		csWarnMark.setMarkFunc("yj");
		csWarnMark.setMarkState("1");
		
		csWarnDeptService.insertDept(csWarnMark, "yj");
		return csWarnMarkMapper.insert(csWarnMark);
	}
	
	
	/**
	 * 获取企业审核数据
	 * @author zjj
	 * 20161025
	 */
	@Override
	public List<CsEntWarnDto> queryPageForCheck(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csEntWarnMapper.selectEntWarnCheckList(request.getParams());
	}

	@Override
	public List<CsEntWarnDto> selectCsEntWarnInfo(Map<String,Object> qryMap) throws Exception {
		return csEntWarnMapper.selectEntWarnCheckList(qryMap);
	}

	/**
	 * 删除指定预警申请企业
	 * @author zjj
	 * 20161026
	 */
	@Override
	public int delete(String str) throws Exception {
		Example example = new Example(CsEntWarn.class);
		example.createCriteria().andEqualTo("priPID", str); 
		return csEntWarnMapper.deleteByExample(example);
	}
	/**
	 * 按UID修改企业申请
	 * @author zjj
	 */
	@Override
	public int updateByUID(CsEntWarnDto csEntWarn) throws Exception {
		Example example = new Example(CsEntWarn.class);
		example.createCriteria().andEqualTo("UID", csEntWarn.getUID()); 
		return csEntWarnMapper.updateByExampleSelective(csEntWarn, example);
	}	
	/**
	 * 按标记编号修改企业预警申请
	 * @author zjj
	 */
	@Override
	public int updateByWarnNo(CsEntWarnDto csEntWarn) throws Exception {
		Example example = new Example(CsEntWarn.class);
		example.createCriteria().andEqualTo("MarkNo", csEntWarn.getMarkNo()); 
		return csEntWarnMapper.updateByExampleSelective(csEntWarn, example);
	}
	
	/**
	 * 按批次修改申请
	 * @author zjj
	 */
	@Override
	public int update(CsEntWarnDto csEntWarn) throws Exception {
		Example example = new Example(CsEntWarn.class);
		example.createCriteria().andEqualTo("batchNo", csEntWarn.getBatchNo()); 
		return csEntWarnMapper.updateByExampleSelective(csEntWarn, example);
	}
	@Override
	public List<CsEntWarnDto> queryPageForView(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csEntWarnMapper.selectEntWarnListForView(request.getParams());
	}
	/**
	 * 添加申请企业
	 * @author zjj
	 */
	@Override
	public int insertEnt(CsEntWarnDto csEntWarn) throws Exception {
		return csEntWarnMapper.insert(csEntWarn);
	}
	/**
	 * 获取有效企业预警标识
	 * @author zjj
	 */
	@Override
	public List<CsEntWarnDto> selectEffectiveWarnMark(Map<String,Object> qryMap) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.putAll(qryMap);
		map.put("checkState", "1");
		map.put("entWarnState", "1");
		map.put("markState", "1");
		return csEntWarnMapper.selectEntWarnList(map);
	}
	/**
	 * 获取一家企业预警情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zjj
	 */
	@Override
	public Map<String, Object> doGetEntWarnInfoForIndex(String priPID) throws Exception {
		if(StringUtils.isBlank(priPID))	return null;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priPID",priPID);
		List<CsEntWarnDto> csEntWarnList = selectEffectiveWarnMark(map);
		
		if(csEntWarnList.size()>0){//有 预警
			map.put("isRiskWarn", "Y");
			return map;
		}
		//无 预警
		map.put("isRiskWarn", "N");
	    return map;
	}
	
	@Override
	public List<CsEntWarnDto> selectCsEntWarnMarks(Map<String, Object> params) {
		return csEntWarnMapper.selectCsEntWarnMarks(params);
	}
	
}