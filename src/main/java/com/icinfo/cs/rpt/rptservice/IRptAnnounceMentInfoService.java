/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.rpt.rptservice;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.rpt.rptmodel.RptAnnounceMentInfo;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_rpt_announcement_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年08月10日
 */
public interface IRptAnnounceMentInfoService extends BaseService {
 
	
 
	/**
	 * 
	 * 描述   根据不同类型查询公告
	 * @author 赵祥江
	 * @date 2017年8月22日 下午4:38:10 
	 * @param 
	 * @return List<RptAnnounceMentInfo>
	 * @throws
	 */
	public List<RptAnnounceMentInfo> selectRptAnnounceMentInfo(Map<String,Object> parmMap) throws Exception;
	
}