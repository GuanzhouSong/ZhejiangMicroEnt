/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.im.mapper.ImPrmtaltMapper;
import com.icinfo.cs.im.model.ImPrmtalt;
import com.icinfo.cs.im.service.IImPrmtaltService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_im_prmtalt 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImPrmtaltServiceImpl extends MyBatisServiceSupport implements IImPrmtaltService {

    private static final Logger logger = LoggerFactory.getLogger(ImPrmtaltServiceImpl.class);

    @Autowired
    private ImPrmtaltMapper imPrmtaltMapper;

    /**
     *
     * 描述:  保存即时信息-许可变更信息
     * @auther zhudefeng
     * @param imPrmtalt 许可信息变更信息
     * @date 2016年8月28日
     * @return
     * @throws Exception
     */
    @Override
    public int insert(ImPrmtalt imPrmtalt) throws Exception {
        if (imPrmtaltMapper.insert(imPrmtalt) <= 0) {
            logger.info("exception {}", "保存许可变更信息（即时信息）失败!");
            throw new BusinessException("保存许可变更信息（即时信息）失败!");
        }
        return 1;
    }

	@Override
	public List<ImPrmtalt> selectBylicID(String licID) throws Exception {
	     Example example=new Example(ImPrmtalt.class);
	     example.createCriteria().andEqualTo("licID",licID);
	    return imPrmtaltMapper.selectByExample(example);
	}

	
}