/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月19日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.yr.dto.UpdateInfoDto;
import com.icinfo.cs.yr.model.UpdateInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_updateinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月19日
 */
public interface UpdateInfoMapper extends Mapper<UpdateInfo> {

	/**
	 * 
	 * 描述: 公示侧企业修改信息查询（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月10日 
	 * @param example
	 * @return
	 */
	List<UpdateInfoDto> selectUpdateInfoForPub(Map<String, Object> searchMap);

	List<UpdateInfoDto> selectInfoForForbidWord(Map<String, Object> searchMap);
}