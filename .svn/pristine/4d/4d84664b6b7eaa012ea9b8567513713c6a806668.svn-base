/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.im.mapper.ImCasaltMapper;
import com.icinfo.cs.im.model.ImCasalt;
import com.icinfo.cs.im.service.IImCasaltService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    行政处罚信息变更 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImCasaltServiceImpl extends MyBatisServiceSupport implements IImCasaltService {


    private static final Logger logger= LoggerFactory.getLogger(ImCasaltServiceImpl.class);

    @Autowired
    private ImCasaltMapper imCasaltMapper;

    /**
     * 描述:  保存行政处罚信息变更
     *
     * @param imCasalt 行政处罚信息变更
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImCasalt imCasalt) throws Exception {
        return imCasaltMapper.insert(imCasalt);
    }

	@Override
	public List<ImCasalt> queryPageByCaseNO(PageRequest request,String caseNO) throws Exception {
       // logger.info("query imcasalt by caseno:{},params:{}",caseNO,request.getParams().toString());
		 //PageHelper.startPage(request.getPageNum(), request.getLength());
		 Example example=new Example(ImCasalt.class);
		 example.createCriteria().andEqualTo("caseNO", caseNO);
		return imCasaltMapper.selectByExample(example);
	}

	@Override
	public List<ImCasalt> queryForPub(String caseNO) throws Exception {
		 Example example=new Example(ImCasalt.class);
		 example.createCriteria().andEqualTo("caseNO",caseNO);
		return imCasaltMapper.selectByExample(example);
	}
}