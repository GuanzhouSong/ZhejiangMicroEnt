/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.util.List;

import com.icinfo.cs.yr.model.YrAlterStockInfo;
import com.icinfo.cs.yr.model.YrSubcapital;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_alterstockinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public interface IYrAlterStockInfoService extends BaseService {

	/**
	 * 更新
	 * @autor: wangjin
	 * @param yrAlterStockInfo
	 * @return
	 */
	int update(YrAlterStockInfo yrAlterStockInfo);
	/**
	 * 新增
	 * @autor: wangjin
	 * @param yrAlterStockInfo
	 * @return
	 */
	int insert(YrAlterStockInfo yrAlterStockInfo);

	/**
	 * 列表查询
	 * @autor: wangjin
	 * @param request
	 * @return
	 */
	List<YrAlterStockInfo> select_queryPage(PageRequest request);

	/**
	 * 根据 invAltID 查询对象
	 * @param invAltID
	 * @param priPID
	 * @return
	 */
	YrAlterStockInfo selectByInvIdAndPriPID(String invAltID, String priPID);


	/**
	 * 批量删除
	 * @autor: wangjin
	 * @param list_invAltID
	 * @param priPID
	 * @return
	 */
	int batch_delete(List<String> list_invAltID, String priPID);


    /**
     * 
     * 描述: 根据主体代码和年报查询
     * @author: 赵祥江
     * @date  : 2016年9月18日 下午5:06:24 
     * @param :
     * @return: List<YrAlterStockInfo>
     * @throws
     */
    public List<YrAlterStockInfo>  selectYrAlterStockInfoByPriPID(int year ,String priPID)throws Exception;
    

	/** 
	 * 描述: 年报预览：股权变更信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return 
	 */
	public List<YrAlterStockInfo> queryPagePreview(PageRequest request);


}