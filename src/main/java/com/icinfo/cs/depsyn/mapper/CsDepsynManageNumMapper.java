/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年12月13日
 * @version 2.0
 */
package com.icinfo.cs.depsyn.mapper;

import java.util.Map;

import com.icinfo.cs.depsyn.model.CsDepsynManageNum;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_depsyn_manage_num 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年12月13日
 */
public interface CsDepsynManageNumMapper extends Mapper<CsDepsynManageNum> {
	
	void deleteByMap(Map<String, Object> qryMap);
}