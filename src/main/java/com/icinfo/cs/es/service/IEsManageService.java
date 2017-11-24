package com.icinfo.cs.es.service;

/**
 * 全景查询索引维护
 * 
 * @author zhuyong
 */
public interface IEsManageService {
	
	/**
	 * 索引维护定时任务
	 * 
	 * @author zhuyong
	 */
	public void esQuartzJob();
	
	/**
	 * 更新单条索引信息
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public String updateOnePanoramaIdx(String priPID);
	
	/**
	 * 删除单条索引信息
	 * 
	 * @author zhuyong
	 * @param priPID
	 * @throws Exception
	 */
	public String deleteOnePanoramaIdx(String priPID);
}
