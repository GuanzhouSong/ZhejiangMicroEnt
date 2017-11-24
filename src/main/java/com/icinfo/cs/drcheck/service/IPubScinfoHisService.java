/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.model.PubScinfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_scinfo_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubScinfoHisService extends BaseService {
	
	/**
	 * 描述：保存历史记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoHisList
	 * @throws Exception
	 */
	public void savePubScinfoHisList(List<PubScinfoHis> pubScinfoHisList)throws Exception;
	
	/**
	 * 描述:随机抽取企业
	 * @author chenxin
	 * @date 2016-11-04
	 * @param taskNO
	 * @param percent抽取百分比
	 * @return
	 * @throws Exception
	 */
	public boolean randomPubscinfo(String taskNO,float percent)throws Exception;
	
	/**
	 * 描述:获取收个随机数和抽取户数总数
	 * @author chenxin
	 * @date 2016-11-04
	 * @param total
	 * @param percent抽取百分比
	 * @return
	 * @throws Exception
	 */
	public String countFirstNumber(int total,float percent)throws Exception;
	
	/**
	 * 描述：通过主任务表ID清空历史记录表
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
	public void cleanScinfoHisByTaskNO(String taskNO)throws Exception;
}