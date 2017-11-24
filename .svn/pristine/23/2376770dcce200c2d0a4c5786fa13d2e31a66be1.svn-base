/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.copysend.service.impl;

import com.icinfo.cs.copysend.dto.CopySendIllegalItemsDto;
import com.icinfo.cs.copysend.mapper.CopySendIllegalItemsMapper;
import com.icinfo.cs.copysend.model.CopySendIllegalItems;
import com.icinfo.cs.copysend.service.ICopySendIllegalItemsService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_copy_send_illegal_items 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月01日
 */
@Service
public class CopySendIllegalItemsServiceImpl extends MyBatisServiceSupport implements ICopySendIllegalItemsService {
	
	@Autowired
	private CopySendIllegalItemsMapper copySendIllegalItemsMapper;
	
	/**
	 * 描述:获取涉嫌违法事项列表
	 *
	 * @author ylr
	 * @date 2016年11月01日
	 */
	public List<CopySendIllegalItems> selectCopySendIllegalItemsList(Map<String, Object> qryMap) throws Exception{
		return copySendIllegalItemsMapper.selectCopySendIllegalItemsList(qryMap);
	}

	/**
	 * 描述:获取涉嫌违法事项维护列表
	 *
	 * @author 陈宇
	 * @date 2016年11月01日
	 */
	@Override
	public List<CopySendIllegalItemsDto> selectCopySendIllegalItemsWeiHuList(Map<String, Object> qryMap) throws Exception {
		// TODO Auto-generated method stub
		return copySendIllegalItemsMapper.selectCopySendIllegalItemsWeiHuList(qryMap);
	}

	/**
     * 描述：插入涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	@Override
	public int insert(CopySendIllegalItems copySendIllegalItems) throws Exception {
		// TODO Auto-generated method stub
		return copySendIllegalItemsMapper.insertSelective(copySendIllegalItems);
	}

	/**
     * 描述：获取涉嫌违法事项维护列表
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	@Override
	public CopySendIllegalItemsDto selectCopySendIllegalItemsWeiHuById(String id) throws Exception {
		// TODO Auto-generated method stub
		return copySendIllegalItemsMapper.selectCopySendIllegalItemsWeiHuById(id);
	}

	/**
     * 描述：修改涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	@Override
	public int update(CopySendIllegalItems copySendIllegalItems) throws Exception {
		// TODO Auto-generated method stub
		return copySendIllegalItemsMapper.updateByPrimaryKey(copySendIllegalItems);
	}

	/**
     * 描述：删除涉嫌违法事项
     * @author 陈宇
     * @date 2016-11-1
     * @throws Exception
     */
	@Override
	public int delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return copySendIllegalItemsMapper.deleteByPrimaryKey(id);
	}
}