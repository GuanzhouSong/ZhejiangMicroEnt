/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年05月04日
 * @version 2.0
 */
package com.icinfo.cs.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.dto.SysUserAreaManageDto;
import com.icinfo.cs.system.model.SysUserAreaManage;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:   111111 SYS_USER_AREA_ADMIN 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年05月04日
 */
public interface SysUserAreaManageMapper extends Mapper<SysUserAreaManage> {
	/**
	 * 
	 * 描述   分页查询区域管理员
	 * @author 赵祥江
	 * @date 2017年5月4日 下午3:53:24 
	 * @param 
	 * @return List<SysUserAreaManageDto>
	 * @throws
	 */
	public List<SysUserAreaManageDto> selectSysUserAreaManageList (Map<String,Object> queryMap)throws Exception;
}