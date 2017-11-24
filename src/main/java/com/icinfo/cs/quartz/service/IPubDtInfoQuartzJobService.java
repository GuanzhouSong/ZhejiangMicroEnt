package com.icinfo.cs.quartz.service;

import com.icinfo.framework.core.service.BaseService;

/**  
 * Copyright 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: TODO
 * @author: 赵祥江 
 * @date: 2016年10月24日 上午9:55:12
 * @version: V1.0  
 */
public interface IPubDtInfoQuartzJobService extends BaseService{
    
	/**
	 * 
	 * 描述   双告知定时推送
	 * @author 赵祥江
	 * @date 2016年10月24日 上午10:22:07 
	 * @param  flag推送类型标识 1:根据企业名称推送  2:根据注册号推送3：根据主体身份代码推送 4:全部推送  priPIDStr 对应推送类型 多个用逗号隔开
	 * @return int
	 * @throws
	 */
	public String pubDtInfoPush(String flag,String priPIDStr) throws Exception;
	
	/**
	 * 
	 * 描述   提取推送失败的分流数据重新分流
	 * @author 赵祥江
	 * @date 2016年12月27日 上午11:15:52 
	 * @param 
	 * @return String
	 * @throws
	 */
	public String pubFailPush()  throws Exception;
}
