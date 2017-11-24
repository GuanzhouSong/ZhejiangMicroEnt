/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.PbUpdateinfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pb_updateinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月09日
 */
public interface IPbUpdateinfoService extends BaseService {

	/**
	 * 描述：个体户年报修改信息
	 * @author baifangfang
	 * @date 2016年10月9日
	 * @param request
	 * @return
	 */
	List<PbUpdateinfoDto> queryPage(PageRequest request);
	
	
	/**
	 * 
	 * 描述: 个体户比较两个修改对象
	 * @auther gaojinling
	 * @date 2016年10月12日 
	 * @param newEntity
	 * @param oldEntity
	 * @param strings
	 * @param anCheID
	 * @throws Exception
	 */
	public void doCompareEntity(Object newEntity, Object oldEntity,
			String[] strings, String anCheID) throws Exception ;
	
	
	
	/** 
	 * 描述: 比较两个list的历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param newList
	 * @param oldList
	 * @param fieldNames对比的依据(数组的集合必须是唯一的)
	 * @param strings要存入pubreportmodhis表中的属性的名称
	 * @param reportNo
	 * @param anCheID
	 * @throws Exception 
	 */
	public <T> void doCompareList(List<T> newList, List<T> oldList,
			String[] fieldNames, String[] strings, 
			String anCheID) throws Exception;
	
	/** 
	 * 描述: 更新历史信息年报编号
	 * @auther ZhouYan
	 * @date 2016年9月30日 
	 * @param anCheID
	 * @param reportNo
	 * @return
	 * @throws Exception 
	 */
	int updateHis(String anCheID, String reportNo) throws Exception;

    
	/** 
	 * 描述: 获取个体修改记录（用于敏感词审核）
	 * @auther yujingwei
	 * @date 2016年9月30日 
	 * @param request
	 * @return List<PbUpdateinfoDto>
	 * @throws Exception 
	 */
	public List<PbUpdateinfoDto> queryPageForbidWord(PageRequest request) throws Exception;
	
}