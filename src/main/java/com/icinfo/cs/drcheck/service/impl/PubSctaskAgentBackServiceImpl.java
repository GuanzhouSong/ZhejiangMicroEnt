/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.dto.PubSctaskAgentBackDto;
import com.icinfo.cs.drcheck.mapper.PubSctaskAgentBackMapper;
import com.icinfo.cs.drcheck.model.PubSctaskAgentBack;
import com.icinfo.cs.drcheck.service.IPubSctaskAgentBackService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_sctask_agent_back 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubSctaskAgentBackServiceImpl extends MyBatisServiceSupport implements IPubSctaskAgentBackService {

    @Autowired
    private PubSctaskAgentBackMapper pubSctaskAgentBackMapper;
    
    /**
	 * 描述：添加到执法人员back表
	 * @author chenxin
	 * @date 2016-11-06
	 * @param deptTaskUid
	 * @param uidList
	 * @return
	 */
    @Override
    public boolean addSctaskAgentBackList(String deptTaskUid, List<String> uidList)throws Exception{
    	if(StringUtils.isNotEmpty(deptTaskUid) && uidList != null && uidList.size() > 0){
    		for(String agentId : uidList){
    			//查询是否存在
    			PubSctaskAgentBack pubSctaskAgentBackParam = new PubSctaskAgentBack();
    			pubSctaskAgentBackParam.setTaskNO(deptTaskUid);
    			pubSctaskAgentBackParam.setAgentId(agentId);;
    			if(pubSctaskAgentBackMapper.selectCount(pubSctaskAgentBackParam) > 0){
    				continue;
    			}else{
    				pubSctaskAgentBackParam.setTaskNO(deptTaskUid);
    				pubSctaskAgentBackParam.setCreateTime(new Date());
    				pubSctaskAgentBackMapper.insert(pubSctaskAgentBackParam);
    			}
    		}
    		return true;
    	}
    	return false;
    }
    
    /**
	 * 描述：删除bck
	 * @author chenxin
	 * @date 2016-11-06
	 * @param deptTaskUid
	 * @param uidList
	 * @return
	 */
    @Override
    public boolean delSctaskAgentBackById(int id) throws Exception {
    	if(id <= 0){
    		return false;
    	}
    	PubSctaskAgentBack pubSctaskAgentBack = new PubSctaskAgentBack();
    	pubSctaskAgentBack.setId(id);
    	pubSctaskAgentBackMapper.delete(pubSctaskAgentBack);
    	return true;
    }
    
    /**
	 * 描述：查询back数据
	 * @author chenxin
	 * @date 2016-11-06
	 * @param request
	 * @return
	 */
    @Override
    public List<PubSctaskAgentBackDto> queryPubSctaskAgentBackDtoPage(PageRequest request) {
    	PageHelper.startPage(request.getPageNum(), request.getLength());
    	return pubSctaskAgentBackMapper.selectPubSctaskAgentBackDtoList(request.getParams());
    }
    
    /**
	 * 描述：删除备份表
	 * @author chenxin
	 * @date 2016-11-06
	 * @param taskNO
	 * @return
	 */
    @Override
    public void delSctaskAgentBackByTaskNO(String taskNO) throws Exception {
    	Example example = new Example(PubSctaskAgentBack.class);
    	example.createCriteria().andEqualTo("taskNO", taskNO);
    	pubSctaskAgentBackMapper.deleteByExample(example);
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
    	PubSctaskAgentBack pubSctaskAgentBack = new PubSctaskAgentBack();
    	pubSctaskAgentBack.setTaskNO(taskNO);
    	return pubSctaskAgentBackMapper.selectCount(pubSctaskAgentBack);
    }
}