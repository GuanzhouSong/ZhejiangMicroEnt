/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.mapper.PubSctaskAgentHisMapper;
import com.icinfo.cs.drcheck.model.PubSctaskAgentHis;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentHisService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

/**
 * 描述:  cs_pub_sctask_agent_his 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubSctaskAgentHisServiceImpl extends MyBatisServiceSupport implements IPubSctaskAgentHisService {

    @Autowired
    private PubSctaskAgentHisMapper pubSctaskAgentHisMapper;
    
    /**
	 * 描述：根据实施部门UID查询数据（排序）
	 * @author chenxin
	 * @date 2016-11-06
	 * @param request
	 * @return
	 */
    @Override
    public List<PubSctaskAgentHis> selectOrderPubSctaskAgentBack(String taskNO) {
    	return pubSctaskAgentHisMapper.selectOrderPubSctaskAgentBack(taskNO);
    }
    
    /**
	 * 描述：批量插入记录
	 * @author chenxin
	 * @date 2016-11-07
	 * @param list
	 * @throws Exception
	 */
    @Override
    public void insertBatch(List<PubSctaskAgentHis> list) throws Exception {
    	if(list != null && list.size() >= 0){
    		for(PubSctaskAgentHis pubSctaskAgentHis : list){
    			pubSctaskAgentHisMapper.insert(pubSctaskAgentHis);
    		}
    	}
    }
    
    /**
	 * 描述：删除
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public int deleteByTaskNO(String taskNO) throws Exception {
    	Example example = new Example(PubSctaskAgentHis.class);
    	example.createCriteria().andEqualTo("taskNO", taskNO);
    	return pubSctaskAgentHisMapper.deleteByExample(example);
    }
    
    /**
	 * 描述：数量
	 * @author chenxin
	 * @date 2016-11-07
	 * @param taskNO
	 * @throws Exception
	 */
    @Override
    public int selectCountByTaskNO(String taskNO) throws Exception {
    	PubSctaskAgentHis pubSctaskAgentHis = new PubSctaskAgentHis();
    	pubSctaskAgentHis.setTaskNO(taskNO);
    	return pubSctaskAgentHisMapper.selectCount(pubSctaskAgentHis);
    }
}