/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.orderreform.service;

import java.util.List;

import com.icinfo.cs.orderreform.model.OrderReformSet;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_orderreform_set 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年11月07日
 */
public interface IOrderReformSetService extends BaseService {
	/**
	 * 
	 * 描述   保存责令整改
	 * @author 赵祥江
	 * @date 2016年11月7日 下午2:33:26 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertOrderReformSet(OrderReformSet orderReformSet) throws Exception  ;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2016年11月7日 下午2:34:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteOrderReformSetByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据uid查询
	 * @author 赵祥江
	 * @date 2016年11月7日 下午2:35:10 
	 * @param 
	 * @return int
	 * @throws
	 */
	public OrderReformSet selectOrderReformSetByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据uid修改
	 * @author 赵祥江
	 * @date 2016年11月7日 下午2:36:31 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateOrderReformSetByUid(OrderReformSet orderReformSet)throws Exception;
	

	/**
	 * 
	 * 描述   根据文号检查获取文号
	 * @author 赵祥江
	 * @date 2016年12月5日 上午11:29:33 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public String selectOrderReformSetPenDecNoByDocShorName(String docShorName)throws Exception;

	/**
	 * 
	 * 描述   分页查询责令整改
	 * @author 赵祥江
	 * @date 2017年5月6日 下午6:47:50 
	 * @param 
	 * @return List<OrderReformSet>
	 * @throws
	 */
	public  List<OrderReformSet> queryOrderReformSetList(PageRequest request)throws Exception;
	//-----------------------------------add by liuhq--------------------------------------
    int getCountByPripid(String priPID);
	//-----------------------------------add by liuhq end--------------------------------------
}