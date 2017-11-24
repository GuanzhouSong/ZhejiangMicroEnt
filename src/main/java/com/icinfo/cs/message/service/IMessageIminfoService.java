/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service;

import com.icinfo.cs.message.model.MessageImInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_message_opanomaly 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
public interface IMessageIminfoService extends BaseService {
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年7月4日 下午4:34:54 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertMessageImInfo(MessageImInfo messageImInfo)throws Exception; 
  
	/**
	 * 
	 * 描述   定时推送消息
	 * @author 赵祥江
	 * @date 2017年7月12日 上午11:16:58 
	 * @param 
	 * @return String
	 * @throws
	 */
	public  String      quartzJob()throws Exception;

	 

}