/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;

import net.sf.json.JSONObject;

import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.framework.core.service.BaseService;

/**
 * 
 * 描述:  抽查检查微信接口
 * @author: 赵祥江
 * @date: 2017年8月9日 上午10:02:01
 */
public interface IPubSccheckWeChatService extends BaseService {
	
	/**
	 * 
	 * 描述   根据联系电话和企业名称和社会信用代码查询抽查检查名单列表
	 * @author 赵祥江
	 * @date 2017年8月9日 上午10:07:09 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject getSccheckeEntList(String tel, String keyword,String secretkey, int pageNo, int pageSize,String flag) throws Exception;
	
	/**
	 * 
	 * 描述  抽查检查消息推送
	 * @author 赵祥江
	 * @date 2017年8月10日 上午10:56:40 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject sccheckMsgPush(String tel,String secretkey,String flag) throws Exception; 
	
	
	
	/**
	 * 
	 * 描述   根据消息id组装详细信息
	 * @author 赵祥江
	 * @date 2017年8月24日 下午3:50:41 
	 * @param 
	 * @return List<PubScentDto>
	 * @throws
	 */
	public List<PubScentDto>  getMsgInfoByMsgId(String msgId)  throws Exception;
	
	/**
	 * 
	 * 描述   根据联系电话获取抽查检查企业列表
	 * @author 赵祥江
	 * @date 2017年9月6日 下午2:15:43 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject  getSccheckEntListByTel(String tel,String secretkey) throws Exception;
}