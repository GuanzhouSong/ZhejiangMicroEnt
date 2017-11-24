package com.icinfo.cs.nocreditPunish.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.nocreditPunish.model.NoCreditPunishDetail;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * cs_nocredit_punishdetail 对应的Service接口.<br>
 * @author caoxu
 * @date 2016年10月18日
 */
public interface NoCreditPunishDetailService extends BaseService {

	/**
     * 保存惩戒明细
     * @param rule
     * @return
     * @throws Exception
     */
	public int insert(NoCreditPunishDetail noCreditPunishDetail) throws Exception;

	/**
	 * 查询列表（不带分页）
	 * @param parms
	 * @return
	 */
	public List<NoCreditPunishDetail> queryList(Map<String, Object> parms) throws Exception;

	/**
     * 查询列表带分页
     *
     * @param request
     * @return
     * @throws Exception
     */
	public List<NoCreditPunishDetail> queryPage(PageRequest request, Map<String, Object> parms) throws Exception;

	/**
	 * 某家企业是否存在惩戒记录
	 * @param priPID
	 * @return
	 */
	public Boolean detailEntExist(String priPID) throws Exception;

	/**
	 * 某个自然人是否存在惩戒记录
	 * @param cardNo
	 * @return
	 */
	public Boolean detailManExist(String cardNo) throws Exception;

	/**
	 * 根据多个条件删除
	 * @param batchNo
	 * @return
	 */
	public int delete(Map<String, Object> parms) throws Exception;
	
	/** 
	 * 描述: 根据自然人身份号获取列表数据
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	public List<NoCreditPunishDetail> selectListByCerNO(PageRequest request) throws Exception;

}
