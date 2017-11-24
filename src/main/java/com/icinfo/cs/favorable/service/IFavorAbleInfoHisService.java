/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.service;

import com.icinfo.cs.favorable.model.FavorAbleInfoHis;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_favorable_info_his 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月09日
 */
public interface IFavorAbleInfoHisService extends BaseService {
	
	/**
	 * 描述   通过hisNO 获取企业良好信息历史记录
	 * @author yujingwei
	 * @date 2017年3月9日 
	 * @param hisNO
	 * @return FavorAbleInfoHis
	 */
	public FavorAbleInfoHis doGetAbleInfoHisInfoBy(String hisNO) throws Exception;
}