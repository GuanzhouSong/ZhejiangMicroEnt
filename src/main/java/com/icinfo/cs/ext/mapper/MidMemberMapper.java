/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月20日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidMemberDto;
import com.icinfo.cs.ext.model.MidMember;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_member 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月20日
 */
public interface MidMemberMapper extends Mapper<MidMember> {

	/**
	 * 描述：根据priPID查询主要人员信息JSON数据列表
	 * @author baifangfang
	 * @date 2016年10月20日
	 * @param params
	 * @return
	 */
	List<MidMemberDto> queryListResultByPripid(Map<String, Object> params);
	
	/**
	 * 描述：根据证件号列表查询主要人员信息JSON数据列表
	 * @author ylr
	 * @date 2016年11月6日
	 * @param params
	 * @return
	 */
	List<MidMemberDto> selectMidMemberList(Map<String, Object> params);

	List<MidMember> quaryMemberListByCerNOAndName(Map<String, Object> qryMap);

	List<MidMemberDto> selectMemberListForLimit(Map<String, Object> params);

	/**
	 * 描述：根据身份证号和姓名查询高管人员数量
	 * @author baifangfang
	 * @date 2017年4月10日
	 * @param qryMap
	 * @return
	 */
	int selectMidMemCountByCerNOAndName(Map<String, Object> qryMap);
	
}