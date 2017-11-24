/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.dto.UpdateInfoDto;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_updateinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
public interface IUpdateInfoService extends BaseService {
	
	/** 
	 * 描述: 比对修改项，保存修改记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param newEntity
	 * @param oldEntity
	 * @param strings
	 * @param reportNo
	 * @param anCheID
	 * @throws Exception 
	 */
	public void doCompareEntity(Object newEntity, Object oldEntity, String[] strings, String anCheID) throws Exception;
	/** 
	 * 描述: 比较两个list的历史记录
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param newList
	 * @param oldList
	 * @param fieldNames
	 * @param strings
	 * @param reportNo
	 * @param anCheID
	 * @throws Exception 
	 */
	public <T> void doCompareList(List<T> newList, List<T> oldList, String[] fieldNames, String[] strings, String anCheID) throws Exception;

	/**
	 * 描述： 查询修改记录列表信息
	 * @author yujingwei
	 * @date 2016-9-20
	 * @param request
	 * @return List<UpdateInfo>
	 * */
	public List<UpdateInfoDto> queryPage(PageRequest request) throws Exception;
	
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
	 * 
	 * 描述: 公示侧企业修改信息查询（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param request
	 * @return
	 */
	List<UpdateInfoDto> queryPageForPub(PageRequest request);
}