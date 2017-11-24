/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service.impl;

import java.util.List;

import com.icinfo.cs.ext.mapper.TmGoodsMapper;
import com.icinfo.cs.ext.model.TmGoods;
import com.icinfo.cs.ext.service.ITmGoodsService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:    cs_tm_goods 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年12月08日
 */
@Service
public class TmGoodsServiceImpl extends MyBatisServiceSupport implements ITmGoodsService {
	
	@Autowired
	private TmGoodsMapper tmGoodsMapper;
	
	/**
	 * 
	 * 描述: 根据商标注册号查询对应的有效的商品服务项目
	 * @auther gaojinling
	 * @date 2016年12月9日 
	 * @param priPID
	 * @return
	 */
	public List<TmGoods> selectTmGoodsList (String regnum){
		Example example = new Example(TmGoods.class);
		example.createCriteria().andEqualTo("reg_num", regnum).andIsNull("del_sign");//删除标志值为空
		example.orderBy("similar_code");
		return tmGoodsMapper.selectByExample(example);
	};
}