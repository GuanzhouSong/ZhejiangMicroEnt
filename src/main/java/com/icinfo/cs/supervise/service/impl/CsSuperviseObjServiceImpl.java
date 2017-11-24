/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.supervise.service.impl;

import com.icinfo.cs.supervise.dto.CsSuperviseObjDto;
import com.icinfo.cs.supervise.mapper.CsSuperviseObjMapper;
import com.icinfo.cs.supervise.model.CsSuperviseObj;
import com.icinfo.cs.supervise.service.ICsSuperviseObjService;
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
 * 描述:    cs_supervise_obj 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class CsSuperviseObjServiceImpl extends MyBatisServiceSupport implements ICsSuperviseObjService {
	
	@Autowired
	CsSuperviseObjMapper csSuperviseObjMapper;
	
	/**
	 * 插入重点监管对象
	 * 
	 * @author zhuyong
	 * @param csSuperviseObj
	 * @return
	 * @throws Exception
	 */
	public int insert(CsSuperviseObjDto csSuperviseObjDto) throws Exception{
		return csSuperviseObjMapper.insert(csSuperviseObjDto);
	}
	
	/**
	 * 更新数据信息
	 * 
	 * @author zhuyong
	 * @param csSuperviseObj
	 * @return
	 * @throws Exception
	 */
	public int updateByField(CsSuperviseObj csSuperviseObj,String field) throws Exception{
		Example example = new Example(CsSuperviseObj.class);
		if(field.equalsIgnoreCase("batchNO")){
			example.createCriteria().andEqualTo("batchNO", csSuperviseObj.getBatchNO());
		}else if (field.equalsIgnoreCase("uid")) {
			example.createCriteria().andEqualTo("UID", csSuperviseObj.getUID());
		}else{
			return -1;
		}
		return csSuperviseObjMapper.updateByExampleSelective(csSuperviseObj, example);
	}
	
	
	/**
	 * 重点监管信息查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryListPage(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csSuperviseObjMapper.selectCsSuperviseObjDtoList(request.getParams());
	}
	
	/**
	 * 重点监管信息查询
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryListNoPage(Map<String,Object> map) throws Exception{
		return csSuperviseObjMapper.selectCsSuperviseObjDtoList(map);
	}
	
	/**
	 * 按照批次浏览
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryByBatchNOList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csSuperviseObjMapper.selectByBatchNOList(request.getParams());
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
		return csSuperviseObjMapper.deleteByExample(example);
	}
	
	
	/**
	 * 重点企业监管查看查询
	 * 
	 * @author zhuyong
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<CsSuperviseObjDto> queryForViewList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return csSuperviseObjMapper.selectCsSuperviseObjDtoForViewList(request.getParams());
	}

	/**
	 * 获取有效企业监管标识
	 * @author zjj
	 */
	@Override
	public List<CsSuperviseObjDto> selectEffectiveSupMark(Map<String, Object> qryMap) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		map.putAll(qryMap);
		map.put("supCheckState", "1");
		map.put("supState", "1");
		map.put("markState", "1");
		return csSuperviseObjMapper.selectCsSuperviseObjDtoList(map);
	}
		
	
	/**
	 * 获取一家企业重点监管情况
	 * 返回Map作为全景查询索引参数
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doGetSuperviewInfoForIndex(String priPID) throws Exception{
		if(StringUtils.isBlank(priPID))	return null;
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priPID",priPID);
		map.put("supCheckState", "1");
		map.put("supState", "1");
		map.put("markState", "1");
		
		//查询某一企业重点监管名称
		String result = csSuperviseObjMapper.doGetSuperviewInfoForIndex(map);
		
		map.clear();
		map.put("priPID",priPID);
		if(StringUtils.isNotBlank(result)){//有 重点监管
			map.put("isIndRegObj", "Y");
			map.put("isIndRegObjName", result);
			return map;
		}
		//无 重点监管
		map.put("isIndRegObj", "N");
		map.put("isIndRegObjName", "");
		return map;
	}

	@Override
	public List<CsSuperviseObjDto> qryCsSuperviseObjDtoByPriPID(String priPID) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("priPID", priPID);
		return csSuperviseObjMapper.selectCsSuperviseObjDtoByPriPID(map);
	}
	
}