/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月25日
 * @version 2.0
 */
package com.icinfo.cs.drcheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.model.PubScresult;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:  cs_pub_scresult 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
public interface PubScresultMapper extends Mapper<PubScresult> {

	/**
	 * 描述：根据priPID查询抽查检查JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月30Øß日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<PubScresultDto> queryPageResultByPripid(Map<String, Object> params);
	
	/**
	 * 描述：查询历史抽检记录
	 *
	 * @author chenxin
	 * @date 2016年11月30日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<PubScresultDto> queryPagePubScresultList(Map<String, Object> params);

	/**
	 * 描述：根据priPID查询抽查检查JSON数据列表
	 *
	 * @author baifangfang
	 * @date 2016年9月30Øß日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<PubScresultDto> selectScresultForBulletin(Map<String, Object> map);
    
	/**
	 * 描述:获取检查公告详情数据
	 * @author yujingwei
	 * @date 2016-10-27
	 * @param pubScresultList
	 * @param request
	 * @return List<PubScresultDto>
	 * @throws Exception
	 */
	List<PubScresultDto> selectCheckScresultInfoForBulletin(Map<String, Object> params);
	
}