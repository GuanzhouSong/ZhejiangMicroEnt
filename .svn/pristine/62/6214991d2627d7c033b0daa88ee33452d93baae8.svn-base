package com.icinfo.cs.sment.service;

import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
/**
 * 小微监测数据同步方法 - 接口
 * 
 * @author zhuyong
 */

public interface IBaseinfoDataSyncService extends BaseService{
	
	/**
	 * 获取前一天增量的数据总量
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer selectSyncCountForBaseinfo(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 增量更新小微名录库
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @param syncTotal
	 */
	public void updateByInc(Map<String,Object>qryMap,int syncTotal) throws Exception;
	
	/**
	 * 全量匹配更新
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @throws Exception
	 */
	public void updateByBatchComp(Map<String,Object>qryMap) throws Exception;
	
	/**
	 * 更新某一家企业
	 * 是小微    ： 列入/保持不动
	 * 不是小微：  不列入/移除
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public void updateOne(String priPID) throws Exception;
	
}
