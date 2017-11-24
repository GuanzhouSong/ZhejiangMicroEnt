/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.concern.service.impl;

import com.icinfo.cs.concern.dto.CsConcernObjDto;
import com.icinfo.cs.concern.mapper.CsConcernObjMapper;
import com.icinfo.cs.concern.model.CsConcernObj;
import com.icinfo.cs.concern.service.ICsConcernObjService;
import com.icinfo.cs.supervise.model.CsSuperviseObj;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_concern_obj 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
@Service
public class CsConcernObjServiceImpl extends MyBatisServiceSupport implements ICsConcernObjService {
	@Autowired
	CsConcernObjMapper csConcernObjMapper;
	/**
	    * 获取企业关注服务数据
	    * @author zjj
	    */
	@Override
	public List<CsConcernObjDto> queryPage(PageRequest request) throws Exception {
		 
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return csConcernObjMapper.selectConObjList(request.getParams());
	}
	/**
	 * 获取指定企业关注服务申请数据
	 */
	@Override
	public List<CsConcernObjDto> selectCsConObjInfo(Map<String, Object> qryMap) throws Exception {
		     return csConcernObjMapper.selectConObjList(qryMap);
	}
	/**
	 * 插入关注服务对象数据
	 * @author zjj
	 * @param csSuperviseObjDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public int insert(CsConcernObjDto csConcernObj) throws Exception {
		return csConcernObjMapper.insert(csConcernObj);
	}
	/**
	 * 删除标识信息
	 * 
	 * @param batchNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public int doDelByAndPriPID(String batchNO,String priPID) throws Exception{
		Example example = new Example(CsSuperviseObj.class);
		example.createCriteria().andEqualTo("batchNO", batchNO).andEqualTo("priPID",priPID); 
		return csConcernObjMapper.deleteByExample(example);
	}
	/**
	 * 更新数据信息
	 * 
	 * @author zjj
	 * @throws Exception
	 */
	public int updateByField(CsConcernObj csConcernObj,String field) throws Exception{
		Example example = new Example(CsConcernObj.class);
		if(field.equalsIgnoreCase("batchNO")){
			example.createCriteria().andEqualTo("batchNO", csConcernObj.getBatchNO());
		}else if (field.equalsIgnoreCase("uid")) {
			example.createCriteria().andEqualTo("UID", csConcernObj.getUID());
		}else{
			return -1;
		}
		return csConcernObjMapper.updateByExampleSelective(csConcernObj, example);
	}
	@Override
	public List<CsConcernObjDto> queryPageForView(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csConcernObjMapper.selectConObjListForView(request.getParams());
	}
	
	@Override
	public List<CsConcernObjDto> queryAllUnauditPage(PageRequest request) throws Exception {
		 
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return csConcernObjMapper.selectConObjListForAudit(request.getParams());
	}
	@Override
	public List<CsConcernObjDto> selectEffectiveConMark(Map<String, Object> qryMap) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.putAll(qryMap);
		map.put("markState", "1");
		map.put("checkState", "1");
		map.put("conState", "1");
		return csConcernObjMapper.selectConObjList(map);
	}
	/**
	 * 获取一家企业关注服务情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zjj
	 */
	@Override
	public Map<String, Object> doGetConcernInfoForIndex(String priPID) throws Exception {
        if(StringUtils.isBlank(priPID))	return null;
		System.out.println("============="+priPID);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priPID",priPID);
		map.put("checkState", "1");
		map.put("conState", "1");
		map.put("markState", "1");
		
		//查询某一企业关注对象名称
		String result = csConcernObjMapper.doGetConcernInfoForIndex(map);
		
		map.clear();
		map.put("priPID",priPID);
		if(StringUtils.isNotBlank(result)){//有 关注服务
			map.put("isFocusObj", "Y");
			map.put("isFocusObjName", result);
			return map;
		}
		//无 关注
		map.put("isFocusObj", "N");
		map.put("isFocusObjName", "");
		return map;
	}
	
	@Override
	public List<CsConcernObjDto> qryCsConcernObjDtoByPriPID(String priPID) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priPID", priPID);
		return csConcernObjMapper.selectCsConcernObjDtoByPriPID(map);
	}
}