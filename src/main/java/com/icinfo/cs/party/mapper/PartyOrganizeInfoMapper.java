/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年08月18日
 * @version 2.0
 */
package com.icinfo.cs.party.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.party.dto.PartyOrganizeInfoDto;
import com.icinfo.cs.party.model.PartyOrganizeInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_party_organize_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
public interface PartyOrganizeInfoMapper extends Mapper<PartyOrganizeInfo> {

	List<PartyOrganizeInfo> selectPartyOrgInfo(Map<String, Object> params);

	/**
	 * 描述：党建信息统计报表
	 * 
	 * @author baifangfang
	 * @date 2017年9月5日
	 * @param params
	 * @return
	 */
	List<PartyOrganizeInfoDto> selectPartyOrganizeInfoCount(Map<String, Object> params);

	/**
	 * 描述：党建信息统计报表
	 * 
	 * @author baifangfang
	 * @date 2017年9月5日
	 * @param params
	 * @return
	 */
	List<PartyOrganizeInfoDto> selectPartyOrganizeInfoCount2(Map<String, Object> params);
}