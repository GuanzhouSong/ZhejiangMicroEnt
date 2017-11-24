/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service;

import java.util.List;

import com.icinfo.cs.specialrec.model.SpecialRecItem;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_special_rec_item 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年11月03日
 */
public interface ISpecialRecItemService extends BaseService {
    
	/**
	 * 描述: 通过uid查询检查事项
	 * 
	 * @auther yujingwei
	 * @date 2017年11月01日
	 * @param resultUid
	 * @return List
	 * @throws Exception
	 */
	public List<SpecialRecItem> selectSpecialRecItemListByUid(String resultUid) throws Exception;
}