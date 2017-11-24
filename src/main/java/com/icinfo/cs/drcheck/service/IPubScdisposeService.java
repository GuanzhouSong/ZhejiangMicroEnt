/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import com.icinfo.cs.drcheck.model.PubScdispose;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:  cs_pub_scdispose 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface IPubScdisposeService extends BaseService {
	
	/**
	 * 描述：根据任务编号和主体身份代码查询抽查检查后续处理信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	public PubScdispose selectPubScdisposeByTaskNO(String taskNO,String priPID);
	
	/**
	 * 描述:保存抽检后续处置结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScdispose
	 * @return
	 * @throws Exception
	 */
	public boolean savePubScdispose(PubScdispose pubScdispose)throws Exception;
}