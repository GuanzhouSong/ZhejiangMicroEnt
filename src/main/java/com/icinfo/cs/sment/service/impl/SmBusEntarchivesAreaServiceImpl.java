/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service.impl;

import com.icinfo.cs.sment.mapper.SmBusEntarchivesAreaMapper;
import com.icinfo.cs.sment.model.SmBusEntarchivesArea;
import com.icinfo.cs.sment.service.ISmBusEntarchivesAreaService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:   小微企业-区域code sm_bus_entarchives_area 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
@Service
public class SmBusEntarchivesAreaServiceImpl extends MyBatisServiceSupport implements ISmBusEntarchivesAreaService {

	@Autowired
	SmBusEntarchivesAreaMapper smBusEntarchivesAreaMapper;
	
	@Override
	public List<SmBusEntarchivesArea> selectAreaList() throws Exception {
		return smBusEntarchivesAreaMapper.selectAreaList();
	}

	@Override
	public List<SmBusEntarchivesArea> selectListByMap(Map<String, Object> qryMap) throws Exception {
		return smBusEntarchivesAreaMapper.selectListByMap(qryMap);
	}

	@Override
	public int insert(SmBusEntarchivesArea smBusEntarchivesArea) throws Exception {
		return smBusEntarchivesAreaMapper.insert(smBusEntarchivesArea);
	}

	@Override
	public int update(SmBusEntarchivesArea smBusEntarchivesArea) throws Exception {
		Example example = new Example(SmBusEntarchivesArea.class);
        example.createCriteria().andEqualTo("areaCode", smBusEntarchivesArea.getAreaCode());
		return smBusEntarchivesAreaMapper.updateByExampleSelective(smBusEntarchivesArea, example);
	}

	@Override
	public int delete(String id) throws Exception {
		return smBusEntarchivesAreaMapper.deleteByPrimaryKey(Integer.parseInt(id));
	}
	
	/** 
 * 描述: 根据父类code获取子类列表
 * @author 张文男
 * @date 2017年5月8日 
 * @param areaPcode
 * @return 
 */

public List<SmBusEntarchivesArea> queryListByAreaPcode(String areaPcode,String deptCode){
	    Map<String, Object> qryMap = new HashMap<String, Object> ();
	    qryMap.put ("areaPcode", areaPcode);
	    qryMap.put ("deptCode", deptCode);
	    return smBusEntarchivesAreaMapper.selectListByMap(qryMap);
	}

/** 
 * 描述: 根据code获取对象
 * @author 张文男
 * @date 2017年5月8日 
 * @param areaCode
 * @return 
 */

public SmBusEntarchivesArea queryListByAreaCode(String areaCode){
    Map<String, Object> qryMap = new HashMap<String, Object> ();
    qryMap.put ("areaCode", areaCode);
    List<SmBusEntarchivesArea> list = smBusEntarchivesAreaMapper.selectListByMap(qryMap);
    if(null != list && list.size () >0){
        return list.get (0);
    }
    return null;
}
}