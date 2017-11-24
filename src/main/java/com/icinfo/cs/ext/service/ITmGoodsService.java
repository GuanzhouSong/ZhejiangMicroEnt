/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;

import com.icinfo.cs.ext.model.TmGoods;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_tm_goods 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年12月08日
 */
public interface ITmGoodsService extends BaseService {
	
	/**
	 * 
	 * 描述: 根据商标注册号查询对应的有效的商品服务项目
	 * @auther gaojinling
	 * @date 2016年12月9日 
	 * @param priPID
	 * @return
	 */
	public List<TmGoods> selectTmGoodsList (String regnum);
}