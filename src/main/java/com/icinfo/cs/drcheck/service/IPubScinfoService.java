/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScinfoDto;
import com.icinfo.cs.drcheck.model.PubScinfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubScinfoService extends BaseService {
	
	/**
     * 描述：查抽检查结果录入列表(工商端)
     * @author chenxin
     * @date 2016-10-26
     * @param request
     * @return
     * @throws Exception
     */
	public List<PubScinfoDto> queryPubScinfoDtoPage(PageRequest request);
	
	
	/**
	 * 描述：查抽检查结果录入列表(工商端)有权限
	 * @author chenxin
	 * @date 2016-10-26
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> queryPubScinfoDtoPageByAuth(PageRequest request);
	
	/**
	 * 描述：根据任务编号查询企业信息(工商端)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public PubScinfoDto selectPubScinfoDtoByTaskNO(String taskNO,String priPID);
	
	/**
	 * 描述：根据任务编号查询企业信息列表(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public PubScinfo selectPubScinfoByTaskNO(String taskNO,String priPID);
	
	/**
	 * 描述:提交审核抽查检查结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScinfoDto
	 * @return
	 * @throws Exception
	 */
	public boolean commitPubScinfoDto(PubScinfoDto pubScinfoDto)throws Exception;
	
	/**
	 * 描述:审核抽查检查结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScinfoDto
	 * @return
	 * @throws Exception
	 */
	public boolean auditPubScinfoDto(PubScinfoDto pubScinfoDto)throws Exception;
	
	/**
	 * 描述：保存pubScinfoList
	 * @author chenxin
	 * @date 2016-11-02
	 * @param pubScinfoList
	 * @throws Exception
	 */
	public void savePubScinfoList(List<PubScinfo> pubScinfoList)throws Exception;
	
	/**
	 * 描述：批量插入记录
	 * @author chenxin
	 * @date 2016-11-02
	 * @param list
	 * @throws Exception
	 */
	public void insertBatch(List<PubScinfo> list)throws Exception;
	
	/**
	 * 描述：插入记录
	 * @author chenxin
	 * @date 2016-11-21
	 * @param pubScinfo
	 * @throws Exception
	 */
	public int insertPubScinfo(PubScinfo pubScinfo)throws Exception;
	
	/**
	 * 描述：通过主任务表taskNO清楚cs_pub_scinfo表
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
	public void cleanPubScinfoByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述：获取随机选中的企业
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfo> selectPubScinfoByOrderList(String taskNO,List<String> list)throws Exception;
	
	/**
	 * 描述：查询企业是否存在
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public int selectPubScinfoByTaskNOAndPriPID(String taskNO,String priPID)throws Exception;
	
	//=========================抽检选中列表============================
	/**
     * 描述：抽检选中列表
     * @author chenxin
     * @date 2016-10-26
     * @param request
     * @return
     * @throws Exception
     */
	public List<PubScinfoDto> queryRandomPubScinfoList(PageRequest request);
	
	/**
	 * 描述：获取随机选中的企业数量
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public int selectCountByTaskNO(String taskNO)throws Exception;
	

	/**
	 * 描述： 根据随机数查询企业
	 * @author chenxin
	 * @date 2016-11-21
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public PubScinfo selectPubScinfoForInsert(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：根据任务UID查询抽取的企业
     * @author chenxin
     * @date 2016-11-23 
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfo> selectPubscinfoByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述： 查询当前的抽查检查任务
	 * @author chenxin
	 * @date 2016-11-28
	 * @param creatTime
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfo> selectPubScinfoForUpdateEs(String creatTime)throws Exception;
	
	/**
	 * 描述： 定时更新es索引文件
	 * @author chenxin
	 * @date 2016-11-28
	 * @return
	 * @throws Exception
	 */
	public void updateEsByPubscTask()throws Exception;
	
	/**
	 * 描述：根据任务编号查询管辖单位
	 * @author chenxin
	 * @date 2016-11-28 
	 * @param taskNO
	 * @return
	 */
	public List<String> selectLocalAdmList(String taskNO);
	
	/**
	 * 描述：所所交叉查询企业
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> selectPubScinfoForCross(Map<String,Object> params)throws Exception;
	
	/**
	 * 描述：统计各个地区抽检到的企业数量
	 * @author chenxin
	 * @date 2016-11-29
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoDto> selectRegOrgShortCount(String taskNO);
}