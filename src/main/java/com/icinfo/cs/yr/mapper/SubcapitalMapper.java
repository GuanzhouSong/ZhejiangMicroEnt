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
import com.icinfo.cs.yr.dto.SubcapitalDto;
import com.icinfo.cs.yr.model.Subcapital;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_subcapital 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年09月09日
 */
public interface SubcapitalMapper extends Mapper<Subcapital> {
	
	/** 
	 * 描述: 根据年报id保存公示信息
	 * @auther ZhouYan
	 * @date 2016年9月19日 
	 * @param anCheID
	 * @return 
	 */
	int insertByAnCheID(@Param(Constants.CS_ANCHEID)String anCheID);

	/**
	 * 描述: 公示侧获取股东及出资信息
	 * @auther chenyl
	 * @date 2016年10月8日 
	 * @param searchMap
	 * @return
	 */
	List<SubcapitalDto> selectSubcapitalInfoForPub(Map<String, Object> searchMap);
}