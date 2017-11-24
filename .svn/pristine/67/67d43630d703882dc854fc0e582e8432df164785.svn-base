/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年12月08日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.ext.dto.TmDetailInfoDto;
import com.icinfo.cs.ext.model.TmDetailInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_tm_detail_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月08日
 */
public interface TmDetailInfoMapper extends Mapper<TmDetailInfo> {
	
	
	List<TmDetailInfoDto> selectTmDetailInfoList(@Param("priPID") String priPID,@Param("regnum") String regnum);

	List<TmDetailInfoDto> selectTmDetailInfoListForServer(String priPID);
}