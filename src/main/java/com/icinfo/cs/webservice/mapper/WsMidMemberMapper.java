/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年02月17日
 * @version 2.0
 */
package com.icinfo.cs.webservice.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.webservice.model.WsMidMember;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_mid_member 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年02月17日
 */
public interface WsMidMemberMapper extends Mapper<WsMidMember> {
	
	List<WsMidMember> selectWsMidMemberListByContion(Map<String, Object> params);
	
	Integer selectWsMidMemberCountByContion(Map<String, Object> params);
	
	List<WsMidMember> selectWsMidMemberListByPripid(String pripid);
	
	Integer selectWsMidMemberMaxId(Map<String, Object> params);
	
	Integer selectWsMidMemberMinId(Map<String, Object> params);
	
	
}