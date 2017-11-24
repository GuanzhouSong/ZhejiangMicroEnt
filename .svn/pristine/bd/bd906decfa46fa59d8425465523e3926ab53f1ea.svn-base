/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月08日
 * @version 2.0
 */
package com.icinfo.cs.yr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.yr.dto.SfcBranchInfoDto;
import com.icinfo.cs.yr.model.SfcBranchInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_sfc_branchinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface SfcBranchInfoMapper extends Mapper<SfcBranchInfo> {

	/**
	 * 描述：查询农专分支机构列表
	 * @author baifangfang
	 * @date 2016年10月10日
	 * @param params
	 * @return
	 */
	List<SfcBranchInfoDto> queryPageResult(Map<String, Object> params);
	
	/**
	 * 
	 * 描述: 根据年报id保存公示信息
	 * @auther gaojinling
	 * @date 2016年10月11日 
	 * @param anCheID
	 * @return
	 */
	int insertByAnCheID(@Param(Constants.CS_ANCHEID)String anCheID);
}