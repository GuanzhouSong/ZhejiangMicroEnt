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

import com.icinfo.cs.party.dto.PartyMemberInfoDto;
import com.icinfo.cs.party.model.PartyMemberInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_party_member_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年08月18日
 */
public interface PartyMemberInfoMapper extends Mapper<PartyMemberInfo> {

	List<PartyMemberInfoDto> selectPartyMemberInfo(Map<String, Object> params);

	List<PartyMemberInfoDto> selectPartyMemberInfoForMaintain(Map<String, Object> doOptRequstQryMapData);

	/**
	 * 描述：党员信息统计报表
	 * @author baifangfang
	 * @date 2017年9月5日
	 * @param params
	 * @return
	 */
	List<PartyMemberInfoDto> selectMemberInfoCount(Map<String, Object> params);

	List<PartyMemberInfoDto> selectParty3YearInfo(Map<String, Object> params);
	/**
	 * 
	 * 描述: 根据党组织id查询组织人员
	 * @auther gaojinling
	 * @date 2017年9月7日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	List<PartyMemberInfoDto> selectMembersByPartyOrgID(Map<String, Object> map);
	/***
	 * 
	 * 描述: 党员树
	 * @auther gaojinling
	 * @date 2017年9月13日 
	 * @param map
	 * @return
	 */
	List<Map<String, Object>> selectMemberTreeMap(Map<String, Object> map);
    
	/**
	 * 描述：非公党建信息查询统计
	 * @author yujingwei
	 * @date 2017年9月5日
	 * @param map
	 * @return
	 */
	PartyMemberInfoDto selectPartyMemberSearchTotal(Map<String, Object> doOptRequstQryMapData);
	
}