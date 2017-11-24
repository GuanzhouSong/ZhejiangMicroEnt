/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月26日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScinfoBackDto;
import com.icinfo.cs.drcheck.model.PubScinfoBack;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_scinfo_back 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubScinfoBackMapper extends Mapper<PubScinfoBack> {
	
	/**
	 * 描述：根据taskNO查询备份表数据
	 * @author chenxin
	 * @date 2017-11-08
	 * @param taskNO
	 * @return
	 */
	public List<PubScinfoBackDto> selectPubScinfoBackDtoList(Map<String,Object> params);
	
	/**
	 * 描述：根据taskNO查询备份表数据
	 * @author chenxin
	 * @date 2017-11-08
	 * @param taskNO
	 * @return
	 */
	public List<PubScinfoBack> selectPubScinfoBackByTaskNO(Map<String,Object> params);
	
	/**
	 * 描述： 批量插入
	 * @author chenxin
	 * @date 2016-11-04
	 * @param list
	 * @return
	 * @throws Exception
	 */
	int insertBatch(List<PubScinfoBack> list)throws Exception;
	
	/**
	 * 描述： 统计待抽检库，各登记机关对应的企业数量
	 * @author chenxin
	 * @date 2016-11-21
	 * @param list
	 * @return
	 * @throws Exception
	 */
	public List<PubScinfoBackDto> selectCountInfoBack(Map<String,Object> params)throws Exception;

	/**
	 * 描述：查询已经导入待抽检库的企业主体身份代码
	 * @author chenxin
	 * @date 2016-12-06
	 * @param taskNO
	 * @return
	 * @throws Exception
	 */
	public List<String> selectPriPIDListByTaskNO(Map<String, Object> params);
}