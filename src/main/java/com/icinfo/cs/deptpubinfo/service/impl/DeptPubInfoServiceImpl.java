/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.deptpubinfo.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.deptpubinfo.dto.DeptPubInfoDto;
import com.icinfo.cs.deptpubinfo.mapper.DeptPubInfoMapper;
import com.icinfo.cs.deptpubinfo.service.IDeptPubInfoService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_mid_baseinfo 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年08月01日
 */
@Service
public class DeptPubInfoServiceImpl extends MyBatisServiceSupport implements IDeptPubInfoService {
	
	@Autowired
	private DeptPubInfoMapper deptPubInfoMapper;

	/** 
	 * 描述: 获取部门公示信息列表
	 * @auther ZhouYan
	 * @date 2017年8月1日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<DeptPubInfoDto> selectDeptPubInfoList(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return deptPubInfoMapper.selectDeptPubInfoList(handleParamsMap(paramsMap));
	}
	
	/** 
	 * 描述: 处理参数
	 * @auther ZhouYan
	 * @date 2017年8月1日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception{
		if(paramsMap != null){
			//公示主体
			if(paramsMap.containsKey("entTypeCatg")){
				String entTypeCatg = (String) paramsMap.get("entTypeCatg");
				if(StringUtil.isNotEmpty(entTypeCatg)){
					String[] entTypeCatgList = entTypeCatg.split(",");
					paramsMap.put("entTypeCatg", entTypeCatgList);
				}			
			}
			//企业类型
			if(paramsMap.containsKey("entType")){
				String entType = (String) paramsMap.get("entType");
				if(StringUtil.isNotEmpty(entType)){
					String[] entTypeList = entType.split(",");
					paramsMap.put("entType", entTypeList);
				}
			}
			//登记机关
			if(paramsMap.containsKey("regOrg")){
				String regOrg = (String) paramsMap.get("regOrg");
				if(StringUtil.isNotEmpty(regOrg)){
					String[] regOrgList = regOrg.split(",");
					paramsMap.put("regOrg", regOrgList);
				}			
			}
			//管辖单位
			if(paramsMap.containsKey("regUnit")){
				String regUnit = (String) paramsMap.get("regUnit");
				if(StringUtil.isNotEmpty(regUnit)){
					String[] regUnitList = regUnit.split(",");
					paramsMap.put("regUnit", regUnitList);
				}
			}
			//登记状态
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
			//行业
			if(paramsMap.containsKey("industryCo")){
				String industryCo = (String) paramsMap.get("industryCo");
				if(StringUtil.isNotEmpty(industryCo)){
					String[] industryCoList = industryCo.split(",");
					paramsMap.put("industryCo", industryCoList);
				}
			}
			//片区
			if(paramsMap.containsKey("sliceNO")){
				String sliceNO = (String) paramsMap.get("sliceNO");
				if(StringUtil.isNotEmpty(sliceNO)){
					String[] sliceNOList = sliceNO.split(",");
					paramsMap.put("sliceNO", sliceNOList);
				}
			}
		}
		return paramsMap;
	}
}