/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.other.mapper.PubServerModrecordMapper;
import com.icinfo.cs.other.model.PubServerModrecord;
import com.icinfo.cs.other.service.IPubServerModrecordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_server_modrecord 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月04日
 */
@Service
public class PubServerModrecordServiceImpl extends MyBatisServiceSupport implements IPubServerModrecordService {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(PubServerModrecordServiceImpl.class);

    @Autowired
    private PubServerModrecordMapper pubServerModrecordMapper;

	@Override
	public int savePubServerModRecord(PubServerModrecord pubServerModrecord) {
		// TODO Auto-generated method stub
		return pubServerModrecordMapper.insert(pubServerModrecord);
	}

	/** 
	 * 描述: 许可变更信息
	 * @auther ZhouYan
	 * @date 2016年12月9日 
	 * @param licNo
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubServerModrecord> doGetAlterInfoList(String licID)
			throws Exception {
		Example example = new Example(PubServerModrecord.class);
		example.createCriteria().andEqualTo("modUID", licID).andEqualTo("altTable", "cs_pub_otherlicence");
		return pubServerModrecordMapper.selectByExample(example);
	}
	
	
}