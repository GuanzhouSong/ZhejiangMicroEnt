/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月26日
 * @version 2.0
 */
package com.icinfo.cs.bulletin.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.bulletin.dto.PubAnnounceMentDto;
import com.icinfo.cs.bulletin.model.PubAnnounceMent;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_announcement 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
public interface PubAnnounceMentMapper extends Mapper<PubAnnounceMent> {

	List<PubAnnounceMent> doGetBulletinInfo(Map<String, Object> searchMap);

	List<PubAnnounceMentDto> doGetPubBulletinfoForServer(Map<String, Object> params);

	Integer selectPubBulletinTotalForServer(Map<String, Object> params);

	Integer selectDistinctBulletinTotalForServer(Map<String, Object> dataParmMap);
}