/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月17日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentBackDto;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent_back 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
public interface PubScentBackMapper extends Mapper<PubScentBack> {

	/**
     * 描述：分页查询待抽检库列表
     * @author chenxin
     * @date 2017-05-17
     * @param params
     * @return List<PubScentBackDto>
     * @throws Exception
     */
	public List<PubScentBackDto> selectPubScentBackDtoList(Map<String, Object> params);
	
	/**
	 * 描述：获取一条企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param params
	 * @return List<PubScentBackDto>
	 * @throws Exception
	 */
	public PubScentBack selectPubScentBackForRandom(Map<String, Object> params);
	
	
	/**
	 * 描述：获取一条企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param params
	 * @return List<PubScentBack>
	 * @throws Exception
	 */
	public List<PubScentBack> selectPubScentBackListForRandom(Map<String, Object> params);
	
	/**
	 * 描述：统计本次抽查任务专项库数量
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	public List<PubScentBackDto> selectSpecialTypes(String taskUid)throws Exception;
}