/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年07月10日
 * @version 2.0
 */
package com.icinfo.cs.sccheck.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.sccheck.dto.PubScGroupMemberDto;
import com.icinfo.cs.sccheck.model.PubScGroupMember;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_scgroup_member 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年07月10日
 */
public interface PubScGroupMemberMapper extends Mapper<PubScGroupMember> {

	/**
	 * 描述：执法人员分组列表
	 *
	 * @author chenxin
	 * @date 2017年7月10日
	 * @param request
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public List<PubScGroupMemberDto> selectPubScGroupMemberDtoList(Map<String, Object> params)throws Exception;
    
	/**
	 * 描述：更新临时操作标志
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param groupUid
	 * @throws Exception
	 */
	public void updateOptDataTypeByGroupUid(String groupUid) throws Exception;
    
	/**
	 * 描述：删除有新增操作标志的数据
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param groupUid
	 * @throws Exception
	 */
	public void deleteOptDataTypeByGroupUid(String groupUid) throws Exception;
    
	/**
	 * 描述：处理有新增标志的数据
	 * 
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param uid
	 * @throws Exception
	 */
	public void updateOptDataTypeByUid(String uid) throws Exception;
}