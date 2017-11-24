/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.mapper.PubScdisposeMapper;
import com.icinfo.cs.drcheck.model.PubScdispose;
import com.icinfo.cs.drcheck.service.IPubScdisposeService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:  cs_pub_scdispose 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubScdisposeServiceImpl extends MyBatisServiceSupport implements IPubScdisposeService {

    @Autowired
    private PubScdisposeMapper pubScdisposeMapper;
    
    /**
	 * 描述：根据任务编号和主体身份代码查询抽查检查后续处理信息(公用)
	 * @author chenxin
	 * @date 2016-10-26
	 * @param taskNO
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScdispose selectPubScdisposeByTaskNO(String taskNO, String priPID) {
    	PubScdispose pubScdispose = new PubScdispose();
    	pubScdispose.setTaskNO(taskNO);
    	pubScdispose.setPriPID(priPID);
    	return pubScdisposeMapper.selectOne(pubScdispose);
    }
    
    /**
	 * 描述:保存抽检后续处置结果信息
	 * @author chenxin
	 * @date 2016-10-27
	 * @param pubScdispose
	 * @return
	 * @throws Exception
	 */
    @Override
    public boolean savePubScdispose(PubScdispose pubScdispose) throws Exception {
		if(pubScdispose != null){
			if(pubScdispose.getId() != null && pubScdispose.getId().intValue() > 0){
				pubScdisposeMapper.updateByPrimaryKeySelective(pubScdispose);
			}else{
				pubScdispose.setCreateTime(new Date());
				pubScdisposeMapper.insertSelective(pubScdispose);
			}
			return true;
		}
    	return false;
    }
}