/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service;

import java.util.List;

import com.icinfo.cs.drcheck.dto.PubScCheckBillDto;
import com.icinfo.cs.drcheck.model.PubScCheckBill;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_sccheck_bill 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年05月02日
 */
public interface IPubScCheckBillService extends BaseService {
	
	/**
	 * 
	 * 描述:查询事项维护清单列表
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param request
	 * @return
	 */
	public List<PubScCheckBillDto> selectPubScCheckBillDtoList(PageRequest request) throws Exception;
	
	/**
	 * 描述：根据uid查询信息
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public PubScCheckBill selectPubScCheckBillByUid(String uid) throws Exception;
	
	/**
	 * 
	 * 描述:保存
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param pubScCheckBill
	 * @return
	 */
	public int savePubScCheckBill(PubScCheckBill pubScCheckBill) throws Exception;

	/**
	 * 
	 * 描述: 更新操作
	 * @author chenxin
	 * @date 2017年05月02日 
	 * @param pubScCheckBill
	 * @return
	 */
	public int updatePubScCheckBill(PubScCheckBill pubScCheckBill) throws Exception;
}