/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月01日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScentSpecialDto;
import com.icinfo.cs.sccheck.model.PubScentSpecial;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scent_special 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月01日
 */
public interface PubScentSpecialMapper extends Mapper<PubScentSpecial> {

	/**
	 * 描述:根据企业查询抽取的所有企业
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @return
	 */
	public List<PubScentSpecial> seletPubScentSpecialList(String taskUid);

	/**
	 * 描述:统计所有的检查事项类型及企业数量
	 * @author chenxin
	 * @date 2017-06-01
	 * @param taskUid
	 * @return
	 */
	public List<PubScentSpecialDto> selectCheckItemCodeTypes(String taskUid);

	/**
	 * 描述：获取一条企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param params
	 * @return PubScentSpecial
	 * @throws Exception
	 */
	public PubScentSpecial selectPubScentSpeForRandom(Map<String, Object> params);
}