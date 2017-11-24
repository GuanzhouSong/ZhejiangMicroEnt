/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sment.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sment.model.SmBusEntarchivesArea;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:   小微企业-区域code sm_bus_entarchives_area 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public interface ISmBusEntarchivesAreaService extends BaseService {
	/**
	 * 获取区域树的数据
	 * @return
	 * @throws Exception
	 */
	public List<SmBusEntarchivesArea> selectAreaList() throws Exception;
	/**
	 * 获取区域表数据
	 */
	public List<SmBusEntarchivesArea> selectListByMap(Map<String,Object> qryMap) throws Exception;
	/**
	 * 插入
	 */
	public int insert(SmBusEntarchivesArea smBusEntarchivesArea) throws Exception;
	
	/**
	 * 更新
	 */
	public int update(SmBusEntarchivesArea smBusEntarchivesArea) throws Exception;
	/**
	 * 删除
	 */
	public int delete(String id) throws Exception;
	
	/** 
	 * 描述: 根据父类code获取子类列表
	 * @author 张文男
	 * @date 2017年5月8日 
	 * @param areaPcode
	 * @return 
	 */

	public List<SmBusEntarchivesArea> queryListByAreaPcode(String areaPcode,String deptCode);
	
	/** 
	 * 描述: 根据code获取对象
	 * @author 张文男
	 * @date 2017年5月8日 
	 * @param areaCode
	 * @return 
	 */

	public SmBusEntarchivesArea queryListByAreaCode(String areaCode);
	
}