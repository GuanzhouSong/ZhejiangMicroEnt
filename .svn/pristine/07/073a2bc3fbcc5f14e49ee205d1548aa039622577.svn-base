/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.io.InputStream;
import java.util.List;

import com.icinfo.cs.drcheck.dto.PubScinfoBackDto;
import com.icinfo.cs.drcheck.model.PubScinfoBack;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scinfo_back 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface IPubScinfoBackService extends BaseService {
	
	/**
     * 描述：查询企业待选库列表(工商端)
     * @author chenxin
     * @date 2016-11-02
     * @param request
     * @return
     * @throws Exception
     */
	public List<PubScinfoBackDto> queryPubScinfoBackDtoPage(PageRequest request);
	
	
	/**
	 * 描述：批量插入备份表
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public void savePubScinfoBackBatch(String taskNO,List<PubScinfoBack> pubScinfoBackList)throws Exception;
	
	/**
	 * 描述：插入备份表
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public void savePubScinfoBack(PubScinfoBack pubScinfoBack)throws Exception;
	
	/**
	 * 描述：根据抽检taskNO查询企业
	 * @author chenxin
	 * @date 2016-11-02
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoBack> selectPubScinfoBackByTaskNO(String taskNO);
	
	/**
	 * 描述：统计待抽检库数量
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public int countPubScinfoBack(String taskNO);
	
	/**
	 * 描述：查询企业是否存在
	 * @author chenxin
	 * @date 2016-11-02
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public int countPubScinfoBackExist(String taskNO,String priPID);
	
	/**
	 * 描述：查询已经导入待抽检库的企业主体身份代码
	 * @author chenxin
	 * @date 2016-12-06
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<String> selectPriPIDListByTaskNO(String taskNO);
	
	/**
	 * 描述：通过主任务表ID清空待抽检库
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @throws Exception
	 */
	public void cleanScinfoBackByTaskNO(String taskNO)throws Exception;
	
	/**
	 * 描述：插入待抽检库
     * @author chenxin
     * @date 2016-11-03
	 * @param taskNO
	 * @param pripIDList
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public boolean addScinfoBackByTaskNO(String taskNO,List<String> pripIDList)throws Exception;
	
	/**
	 * 描述：插入待抽检库（批量导入）
     * @author chenxin
     * @date 2017-02-2-20
	 * @param taskNO
	 * @param in
	 * @return
	 * @throws Exceptionc
	 */
	public boolean batchImportBack(InputStream in,String taskNO)throws Exception;
	
	/**
	 * 描述： 统计待抽检库，各登记机关对应的企业数量
	 * @author chenxin
	 * @date 2016-11-21
	 * @param taskNO
	 * @param minNum
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoBackDto> selectCountInfoBack(String taskNO,int minNum)throws Exception;
	
	/**
	 * 描述:根据登记机关随机抽取企业
	 * @author chenxin
	 * @date 2016-11-21
	 * @param taskNO
	 * @param totalRandomNum
	 * @return
	 */
	public boolean randomPubScinfoByRegOrg(String taskNO,int totalRandomNum)throws Exception ;
}