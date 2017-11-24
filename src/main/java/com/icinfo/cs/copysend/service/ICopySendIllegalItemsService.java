/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.copysend.dto.CopySendIllegalItemsDto;
import com.icinfo.cs.copysend.model.CopySendIllegalItems;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_copy_send_illegal_items 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
public interface ICopySendIllegalItemsService extends BaseService {
	
	/**
	 * 描述:获取涉嫌违法事项列表
	 *
	 * @author ylr
	 * @date 2016年11月01日
	 */
	List<CopySendIllegalItems> selectCopySendIllegalItemsList(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述：获取涉嫌违法事项维护列表
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	List<CopySendIllegalItemsDto> selectCopySendIllegalItemsWeiHuList(Map<String, Object> qryMap) throws Exception;
	
	/**
     * 描述：根据ID获取涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	CopySendIllegalItemsDto selectCopySendIllegalItemsWeiHuById(String id) throws Exception;
	
	/**
     * 描述：插入涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	public int insert(CopySendIllegalItems copySendIllegalItems) throws Exception;
	
	/**
     * 描述：修改涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	public int update(CopySendIllegalItems copySendIllegalItems) throws Exception;
	
	/**
     * 描述：删除涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	public int delete(Integer id) throws Exception;
}