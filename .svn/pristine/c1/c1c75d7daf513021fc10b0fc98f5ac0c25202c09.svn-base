/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.im.model.ImCase;
import com.icinfo.cs.other.mapper.PubOtherlicenceHisMapper;
import com.icinfo.cs.other.model.PubOtherlicenceHis;
import com.icinfo.cs.other.service.IPubOtherlicenceHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_otherlicence_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Service
public class PubOtherlicenceHisServiceImpl extends MyBatisServiceSupport implements IPubOtherlicenceHisService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(PubOtherlicenceHisServiceImpl.class);

    @Autowired
    private PubOtherlicenceHisMapper pubOtherlicenceHisMapper;

	@Override
	public int insert(PubOtherlicenceHis pubOtherlicenceHis) {
		// TODO Auto-generated method stub
		return pubOtherlicenceHisMapper.insert(pubOtherlicenceHis);
	}

	@Override
	public List<PubOtherlicenceHis> selectOtherLincesHisList(PubOtherlicenceHis pubOtherlicenceHis) {
      return pubOtherlicenceHisMapper.select(pubOtherlicenceHis);
	}

	@Override
	public PubOtherlicenceHis selectByHisNO(String hisNO) {
		PubOtherlicenceHis pubOtherlicenceHis =new PubOtherlicenceHis();
		pubOtherlicenceHis.setHisNO(hisNO);
		return  pubOtherlicenceHisMapper.selectOne(pubOtherlicenceHis);
		
	}
    
    
    
}