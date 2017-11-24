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

import com.icinfo.cs.drcheck.dto.PubScagentDto;
import com.icinfo.cs.drcheck.model.PubScagent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_scagent 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubScagentMapper extends Mapper<PubScagent> {
	/**
	 * 
	 * 描述: 多条件查询for listJSON
	 * @auther ljx
	 * @date 2016年10月31日 
	 * @param map
	 * @return
	 */
   List<PubScagentDto>	selectByManyCationToListJSON (Map<String,Object> map);
   
   /**
	 * 描述: 获取执法清单范围树数据
	 * @auther chenxin
	 * @date 2017年4月21日
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
   List<Map<String, Object>> selectScPtypeTreeMap();
   
   /**
    * 描述: 获取执法清单范围
    * @auther chenxin
    * @date 2017年4月21日
    * @return List<PubScagentDto>
    * @throws Exception
    */
   List<PubScagentDto> selectScPtypeList();
   
   /**
    * 
    * 描述: 执法人员库统计
    * @auther gaojinling
    * @date 2017年6月1日 
    * @param map
    * @return
    * @throws Exception
    */
   List<PubScagentDto> selectScAgentCount(Map<String, Object> map) throws Exception;
   
   /**
    * 
    * 描述: 执法人员库统计
    * @auther gaojinling
    * @date 2017年6月1日 
    * @param map
    * @return
    * @throws Exception
    */
   List<PubScagentDto> selectSynScAgentCount(Map<String, Object> map) throws Exception;
   
   /**
    * 
    * 描述: 查询执法人员信息
    * @auther 陈鑫
    * @date 2017年7月11日 
    * @param uid
    * @return
    * @throws Exception
    */
   public PubScagentDto selectPubScagentDtoByUid(String uid) throws Exception;
   
   
}