package com.icinfo.cs.concern.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.concern.dto.CsConcernActivityDto;
import com.icinfo.cs.concern.model.CsConcernActivity;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_concern_activity 对应的Service接口.<br>
 *
 * @author caoxu
 * @date 2016年11月06日
 */
public interface CsConcernActivityService extends BaseService {

	/**
	 * 查询列表
	 * @param request
	 * @param parms
	 * @return
	 * @throws Exception
	 */
	public List<CsConcernActivity> queryPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
     * 根据主键查询
     * @param id
     * @return
     * @throws Exception
     */
	public CsConcernActivity getById(String id) throws Exception;

	/**
	 * 保存活动单
	 * @param csConcernActivityDto
	 * @return
	 */
	public int insert(CsConcernActivityDto csConcernActivityDto)throws Exception;

	/**
	 * 更新活动单
	 * @param csConcernActivityDto
	 * @return
	 * @throws Exception
	 */
	public int update(CsConcernActivityDto csConcernActivityDto) throws Exception;

}
