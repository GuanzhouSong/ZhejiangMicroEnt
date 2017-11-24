/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.orderreform.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.orderreform.mapper.OrderReformSetMapper;
import com.icinfo.cs.orderreform.model.OrderReformSet;
import com.icinfo.cs.orderreform.service.IOrderReformSetService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_orderreform_set 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月07日
 */
@Service
public class OrderReformSetServiceImpl extends MyBatisServiceSupport implements IOrderReformSetService {

	private static final Logger logger = LoggerFactory.getLogger(OrderReformSetServiceImpl.class);

	@Autowired
	private OrderReformSetMapper orderReformSetMapper;

	/**
	 * 
	 * 描述   保存责令整改
	 * @author  赵祥江
	 * @date 2016年11月7日 下午2:45:12 
	 * @param  
	 * @throws
	 */
	@Override
	public int insertOrderReformSet(OrderReformSet orderReformSet)
			throws Exception {
		try {
			if(orderReformSet!=null){
			  //时间戳
			  orderReformSet.setCreateTime(DateUtils.getSysDate());
			  return orderReformSetMapper.insert(orderReformSet);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存责令整改信息失败!");
            throw new BusinessException("保存责令整改信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述   根据uid删除
	 * @author  赵祥江
	 * @date 2016年11月7日 下午2:45:24 
	 * @param  
	 * @throws
	 */
	@Override
	public int deleteOrderReformSetByUid(String uid) throws Exception {
		try {
			if(StringUtil.isNotEmpty(uid)){
			  OrderReformSet orderReformSet=new OrderReformSet(); 
			  orderReformSet.setUid(uid);
			  return orderReformSetMapper.delete(orderReformSet);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "删除责令整改信息失败!");
            throw new BusinessException("删除责令整改信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述   根据uid查询
	 * @author  赵祥江
	 * @date 2016年11月7日 下午2:45:40 
	 * @param  
	 * @throws
	 */
	@Override
	public OrderReformSet selectOrderReformSetByUid(String uid)
			throws Exception {
		try {
			if(StringUtil.isNotEmpty(uid)){
			  OrderReformSet orderReformSet=new OrderReformSet(); 
			  orderReformSet.setUid(uid);
			  return orderReformSetMapper.selectOne(orderReformSet);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "查询责令整改信息失败!");
            throw new BusinessException("查询责令整改信息失败!");
		}
		return null;
	}

	/**
	 * 
	 * 描述   根据uid修改
	 * @author  赵祥江
	 * @date 2016年11月7日 下午2:45:55 
	 * @param  
	 * @throws
	 */
	@Override
	public int updateOrderReformSetByUid(OrderReformSet orderReformSet)
			throws Exception {
		try {
			if(orderReformSet!=null&&StringUtil.isNotEmpty(orderReformSet.getUid())){
 			    orderReformSet.setCreateTime(DateUtils.getSysDate());
 				Example example = new Example(OrderReformSet.class);
				example.createCriteria().andEqualTo("uid", orderReformSet.getUid());
			    return orderReformSetMapper.updateByExampleSelective(orderReformSet, example);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "修改责令整改信息失败!");
            throw new BusinessException("修改责令整改信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述   分页查询责令整改
	 * @author  赵祥江
	 * @date 2017年5月6日 下午6:48:37 
	 * @param  
	 * @throws
	 */
	@Override
	public List<OrderReformSet> queryOrderReformSetList(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return orderReformSetMapper.selectOrderReformSetList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "查询责令整改信息失败!");
            throw new BusinessException("查询责令整改信息失败!");
		}
	}
//-----------------------------------add by liuhq--------------------------------------
	@Override
	public int getCountByPripid(String priPID) {
		OrderReformSet orderReformSet = new OrderReformSet();
		orderReformSet.setPriPID(priPID);
		orderReformSet.setEfftStatus("1");
		return orderReformSetMapper.selectCount(orderReformSet);
	}
	//-----------------------------------add by liuhq end--------------------------------------

	/**
	 * 
	 * 描述   根据文号检查获取文号
	 * @author 赵祥江
	 * @date 2016年12月5日 上午11:29:33 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public String selectOrderReformSetPenDecNoByDocShorName(String docShorName)
			throws Exception {
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("regorg", docShorName);
		queryMap.put("year", DateUtils.getYear()); 
		return orderReformSetMapper.selectOrderReformSetPenDecNoByDocShorName(queryMap);
	}
}