/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年11月01日
 * @version 2.0
 */
package com.icinfo.cs.other.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.other.dto.PubOtherpunishGovDto;
import com.icinfo.cs.other.model.PubOtherpunishGov;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_pub_otherpunish_gov 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
public interface PubOtherpunishGovMapper extends Mapper<PubOtherpunishGov> {

	/**
	 * 描述: 行政处罚归集查询
	 * 
	 * @auther ZhouYan
	 * @date 2017年10月31日
	 * @param params
	 * @return
	 */
	List<PubOtherpunishGovDto> selectPubOtherpunishGovList(Map<String, Object> params);

	/**
	 * 描述: 在册企业行政许可数
	 * 
	 * @auther ZhouYan
	 * @date 2017年11月1日
	 * @param params
	 * @return
	 */
	Integer selectPubOtherpunishGovRegTotal(Map<String, Object> params);

	/**
	 * 
	 * 描述：行政处罚机关个数
	 * 
	 * @author baifangfang
	 * @date 2017年11月21日
	 * @param paramsMap
	 * @return
	 */
	int selectDeptTotal(Map<String, Object> paramsMap);

	/**
	 * 
	 * 描述：经与市场主体比对记名于企业名下机关个数
	 * 
	 * @author baifangfang
	 * @date 2017年11月21日
	 * @param paramsMap
	 * @return
	 */
	int selectEntDeptTotal(Map<String, Object> paramsMap);

	/**
	 * 
	 * 描述   根据设置部门查询
	 * @author 赵祥江
	 * @date 2017年11月21日 下午4:33:39 
	 * @param 
	 * @return List<PubOtherpunishGovDto>
	 * @throws
	 */
	List<PubOtherpunishGov> selectPubOtherpunishGovByDeptnameList(Map<String, Object> params) throws Exception;

	Integer selectPunishGovAnthTotal(Map<String, Object> paramsMap);

	Integer selectPunishGovRegTotal(Map<String, Object> paramsMap);

	Integer selectPunishGovRegAnthTotal(Map<String, Object> paramsMap);
 }