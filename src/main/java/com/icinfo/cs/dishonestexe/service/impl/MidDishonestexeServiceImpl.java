/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dishonestexe.service.impl;

import com.icinfo.cs.dishonestexe.mapper.MidDishonestexeMapper;
import com.icinfo.cs.dishonestexe.model.MidDishonestexe;
import com.icinfo.cs.dishonestexe.service.IMidDishonestexeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:  cs_mid_dishonestexe 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月15日
 */
@Service
public class MidDishonestexeServiceImpl extends MyBatisServiceSupport implements IMidDishonestexeService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(MidDishonestexeServiceImpl.class);

    @Autowired
    private MidDishonestexeMapper midDishonestexeMapper;

	@Override
	public List<MidDishonestexe> queryListByCardNum(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		List<MidDishonestexe> list = midDishonestexeMapper.queryListByCardNum(request.getParams());
		return list;
	}
}