/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.message.service;

import java.util.List;

import com.icinfo.cs.message.model.MessageOpanoMaly;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_message_opanomaly 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年07月04日
 */
public interface IMessageOpanoMalyService extends BaseService {
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年7月4日 下午4:34:54 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertMessageOpanoMaly(MessageOpanoMaly messageOpanoMaly)throws Exception;
	
	/**
	 * 
	 * 描述   列入异常实时推送消息
	 * @author 赵祥江
	 * @date 2017年7月4日 下午5:04:23 
	 * @param 
	 * @return int
	 * @throws
	 */
	public  int     sendJoinOpanoMaly(List<String> priPIDList,SysUserDto sysUser)throws Exception;
	
	/**
	 * 
	 * 描述   移出异常推送消息
	 * @author 赵祥江
	 * @date 2017年7月4日 下午5:15:41 
	 * @param 
	 * @return int
	 * @throws
	 */
	public  int     sendIsMoveOpanoMaly(List<String>  priPIDList,String isMove,SysUserDto sysUser)throws Exception;
	
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