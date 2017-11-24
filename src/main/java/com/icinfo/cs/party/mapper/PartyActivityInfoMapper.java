/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年09月04日
 * @version 2.0
 */
package com.icinfo.cs.party.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.party.dto.PartyActivityInfoDto;
import com.icinfo.cs.party.model.PartyActivityInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_party_activity_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年09月04日
 */
public interface PartyActivityInfoMapper extends Mapper<PartyActivityInfo> {
	
	/**
	 * 
	 * 描述: 党建活动信息录入查询
	 * @auther gaojinling
	 * @date 2017年9月4日 
	 * @param map
	 * @return
	 */
	public List<PartyActivityInfoDto> selectPartyActivityInfoList(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 查询活动总参与人数 （不同活动涉及的相同参与人数不要去重）
	 * @auther gaojinling
	 * @date 2017年9月12日 
	 * @param map
	 * @return
	 */
	public int selectActivityJoinerSum(Map<String, Object> map);
}