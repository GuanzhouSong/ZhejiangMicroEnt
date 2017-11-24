/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.mapper.PubScitemMapper;
import com.icinfo.cs.drcheck.model.PubScitem;
import com.icinfo.cs.drcheck.service.IPubScitemService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;

/**
 * 描述:  cs_pub_scitem 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月25日
 */
@Service
public class PubScitemServiceImpl extends MyBatisServiceSupport implements IPubScitemService {

    @Autowired
    private PubScitemMapper pubScitemMapper;

	@Override
	public List<Map<String, Object>> selectToTreeMap() {
		// TODO Auto-generated method stub
		return pubScitemMapper.selectToTreeMap();
	}
	
	 /**
	 * 描述：根据任务编号和科目大类查询配置项信息(公用)
	 * @author chenxin
	 * @date 2016-10-27
	 * @param scType
	 * @return List<PubScitemResult>
	 * @throws Exception
	 */
	@Override
	public List<PubScitem> selectPubScitemByScType(String scType) {
		PubScitem pubScitem = new PubScitem();
		pubScitem.setScType(scType);
    	return pubScitemMapper.select(pubScitem);
	}
}