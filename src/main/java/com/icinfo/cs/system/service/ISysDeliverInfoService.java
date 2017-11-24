/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.system.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_sys_deliverinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月30日
 */
public interface ISysDeliverInfoService extends BaseService {
	
	/**
	 * 
	 * 描述: 查询确认送达书匹配地址(联络员打印)
	 * @auther gaojinling
	 * @date 2016年8月30日 
	 * @param map
	 * @return
	 */
    public List<SysDeliverInfo> selectDeliverInfoList(Map<String, Object> map);
    
    /**
	 * 
	 * 描述: 根据条件分页查询配送地址信息
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<SysDeliverInfo> queryPage(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述: 根据主键更新
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int update(SysDeliverInfo sysDeliverInfo) throws Exception ;
	
	/**
	 * 
	 * 描述: 添加
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int inset(SysDeliverInfo sysDeliverInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 删除
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param sysDeliverInfo
	 * @return
	 * @throws Exception
	 */
	public int delete(SysDeliverInfo sysDeliverInfo) throws Exception;
	
	/**
	 * 
	 * 描述: 根据主键删除
	 * @auther gaojinling
	 * @date 2016年9月21日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public int deletebyPrimaryKey (String uid) throws Exception;
	
	/**
	 * 
	 * 描述: 查询单个信息（根据主键uid）
	 * @auther gaojinling
	 * @date 2016年9月20日 
	 * @param UID
	 * @return
	 * @throws Exception
	 */
	public SysDeliverInfo selectDeliverInfoByPrimaryKey (String UID) throws Exception ;

}