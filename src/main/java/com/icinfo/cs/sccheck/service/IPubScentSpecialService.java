/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentSpecialDto;
import com.icinfo.cs.sccheck.model.PubScentSpecial;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_scent_special 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月01日
 */
public interface IPubScentSpecialService extends BaseService {
	
	/**
	 * 描述:生成待抽检库专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @throws Exception
	 */
	public void savePubScentSpecialBatch(String taskUid)throws Exception;
	
	/**
	 * 描述:删除待抽检库专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @throws Exception
	 */
	public void delPubScentSpecial(String taskUid)throws Exception;
	
	/**
	 * 描述:保存待抽检库专项库数据
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @throws Exception
	 */
	public void savePubScentSpecial(PubScentSpecial pubScentSpecial)throws Exception;

	/**
	 * 描述:统计所有的检查事项类型及企业数量
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @return
	 */
	public List<PubScentSpecialDto> selectCheckItemCodeTypes(String taskUid);

	/**
	 * 描述：查询某个检查事项对应的检查企业
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @param checkCode
	 * @return
	 */
	public List<PubScentSpecial> selectScentSpecialList(String taskUid,String checkCode);
	
	/**
	 * 描述：获取一条企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param params
	 * @return List<PubScentBackDto>
	 * @throws Exception
	 */
	public PubScentSpecial selectPubScentSpeForRandom(Map<String, Object> params);
}