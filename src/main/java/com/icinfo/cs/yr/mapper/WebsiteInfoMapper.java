/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年09月09日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.WebsiteInfoDto;
import com.icinfo.cs.yr.model.WebsiteInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_websiteinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface WebsiteInfoMapper extends Mapper<WebsiteInfo> {
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return 
	 */
	int insertByAnCheID(@Param(Constants.CS_ANCHEID)String anCheID);

	/**
	 * 
	 * 描述: 公示侧网站信息展示（过滤敏感词）
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param searchMap
	 * @return
	 */
	List<WebsiteInfoDto> selectWebInfoForPub(Map<String, Object> searchMap);
	
	
}