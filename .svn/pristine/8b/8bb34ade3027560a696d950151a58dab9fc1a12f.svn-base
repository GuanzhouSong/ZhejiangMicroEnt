/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.drcheck.dto.PubScCheckBillDto;
import com.icinfo.cs.drcheck.mapper.PubScCheckBillMapper;
import com.icinfo.cs.drcheck.model.PubScCheckBill;
import com.icinfo.cs.drcheck.model.PubScagent;
import com.icinfo.cs.drcheck.service.IPubScCheckBillService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_sccheck_bill 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
@Service
public class PubScCheckBillServiceImpl extends MyBatisServiceSupport implements IPubScCheckBillService {
	
	@Autowired
	private PubScCheckBillMapper pubScCheckBillMapper;
	
	/**
	 * 描述：根据uid查询信息
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubScCheckBill selectPubScCheckBillByUid(String uid)throws Exception {
		PubScCheckBill pubScCheckBill=new PubScCheckBill();
		pubScCheckBill.setUID(uid);
		return pubScCheckBillMapper.selectOne(pubScCheckBill);
	}
	
	/**
	 * 
	 * 描述:查询事项维护清单列表
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param request
	 * @return
	 */
	@Override
	public List<PubScCheckBillDto> selectPubScCheckBillDtoList(PageRequest request)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> map=request.getParams();  
		//最高学历(in)
		if(map!=null){
			if(map.get("checkManFlag")!=null && StringUtils.isNotBlank(map.get("checkManFlag").toString())){
				map.put("checkManFlags",map.get("checkManFlag").toString().split(","));
			}
			if(map.get("checkWay")!=null && StringUtils.isNotBlank(map.get("checkWay").toString())){
				map.put("checkWays",map.get("checkWay").toString().split(","));
			}
		}
		return pubScCheckBillMapper.selectPubScCheckBillDtoList(map);
	}
	
	/**
	 * 
	 * 描述:保存
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param pubScCheckBill
	 * @return
	 */
	@Override
	public int savePubScCheckBill(PubScCheckBill pubScCheckBill)throws Exception {
		return pubScCheckBillMapper.insert(pubScCheckBill);
	}
	
	/**
	 * 
	 * 描述: 更新操作
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param pubScCheckBill
	 * @return
	 */
	@Override
	public int updatePubScCheckBill(PubScCheckBill pubScCheckBill)throws Exception {
		Example example=new Example(PubScagent.class);
		example.createCriteria().andEqualTo("UID",pubScCheckBill.getUID());
		return pubScCheckBillMapper.updateByExampleSelective(pubScCheckBill,example);
	}
}