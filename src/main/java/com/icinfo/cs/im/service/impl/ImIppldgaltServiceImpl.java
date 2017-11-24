/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.im.mapper.ImIppldgaltMapper;
import com.icinfo.cs.im.model.ImIppldgalt;
import com.icinfo.cs.im.service.IImIppldgaltService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:    cs_im_ippldgalt 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class ImIppldgaltServiceImpl extends MyBatisServiceSupport implements IImIppldgaltService {

    @Autowired
    ImIppldgaltMapper imIppldgaltMapper;

    /**
     * 描述:  保存即时信息_知识产权出质登记信息变更
     *
     * @param imIppldgalt 即时信息_知识产权出质登记信息变更
     * @return
     * @throws Exception
     * @auther zhudefeng
     * @date 2016年8月31日
     */
    @Override
    public int insert(ImIppldgalt imIppldgalt) throws Exception {
        return imIppldgaltMapper.insert(imIppldgalt);
    }

	@Override
	public List<ImIppldgalt> queryListForPub(String pleID) throws Exception {
		// TODO Auto-generated method stub
		Example example=new Example(ImIppldgalt.class);
		example.createCriteria().andEqualTo("pleID", pleID);
		
		return  imIppldgaltMapper.selectByExample(example);
	}
}