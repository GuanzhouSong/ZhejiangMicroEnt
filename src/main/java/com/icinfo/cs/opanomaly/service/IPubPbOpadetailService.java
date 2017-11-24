/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service;

import java.util.List;

import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_pbopadetail 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月27日
 */
public interface IPubPbOpadetailService extends BaseService {

	/**
	 * 描述：个体户恢复异常申请JSON数据列表
	 * 
	 * @author Administrator
	 * @date 2017年7月3日
	 * @param request
	 * @return
	 */
	List<PubPbOpadetailDto> queryPubPbOpadetailDtoList(PageRequest request);

	/**
	 * 描述：保存恢复异常信息
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @param pubPbOpadetail
	 * @return
	 */
	int savePbOpadetail(PubPbOpadetail pubPbOpadetail);

	/**
	 * 描述：查询异常恢复信息
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param busExcList
	 * @return
	 */
	PubPbOpadetailDto selectPubPbOpadetailDtoByBusExcList(String busExcList);

	/**
	 * 描述：保存修改恢复正常记载记录
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param pubPbOpadetail
	 * @return
	 */
	int saveEditPbOpadetail(PubPbOpadetail pubPbOpadetail);

	/**
	 * 描述：删除恢复正常记载记录
	 * 
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param busExcList
	 * @return
	 */
	int deletePbOpadetailByBusExcList(String busExcList);

	/**
	 * 描述：恢复正常记载审核
	 * @author baifangfang
	 * @date 2017年7月7日
	 * @param ppod
	 * @return
	 */
	int savePubPbOpadetailCheck(PubPbOpadetailDto ppod);
	
	/**
	 * 
	 * 描述   根据主体身份代码查询
	 * @author 赵祥江
	 * @date 2017年10月11日 上午11:50:22 
	 * @param 
	 * @return List<PubPbOpadetailDto>
	 * @throws
	 */
	public List<PubPbOpadetailDto> selectPubPbOpadetailByPriPID(String priPID) ;

}