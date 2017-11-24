package com.icinfo.cs.secnocreditsup.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeBasedDto;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    处罚类严违对应的Service接口.<br>
 *
 * @author caoxu
 * @date 2016年11月25日
 */
public interface IExpSeriousPunishListService extends BaseService {

	/**
	 * 处罚类严违名单全部列表
	 */
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplyAllList(PageRequest request) throws Exception;
	
	/**
	 * 处罚类严违名单待列入列表
	 */
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplySrcList(PageRequest request) throws Exception;
	
	/**
	 * 处罚类严违名单已列入列表
	 */
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception;

	/**
	 * 获取行政处罚记录
	 * @param qryMap
	 * @return
	 */
	public List<ExpSeriousCrimeListDto> getSrcCase(Map<String, Object> qryMap) throws Exception;

	/**
	 * 保存处罚严违申请
	 * @param expSeriousCrimeListDto
	 * @return
	 * @throws Exception
	 */
	public int insert(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception;

	/**
	 * 查询列入记录
	 * @param id
	 * @return
	 */
	public List<ExpSeriousCrimeList> queryList(Map<String, Object> parms);

	/**
	 * 更新申请
	 * @param expSeriousCrimeList
	 * @return
	 */
	public int update(ExpSeriousCrimeList expSeriousCrimeList);

	/**
     * 描述:严违依据
     *
     */
	public Integer insertExpSeriousCrimeBased(ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto) throws Exception;

	/**
	 * 待列入总数
	 * @return
	 */
	public Integer applySrcTotal(Map<String, Object> map);

	/**
	 * 列入待初审总数
	 * @return
	 */
	public Integer applyFirstTotal();

	/**
	 * 列入待审核总数
	 * @return
	 */
	public Integer applyAuditTotal();

	/**
	 * 逾期列入总数
	 * @return
	 */
	public Integer applyExpirTotal();

	/**
	 * 待初审总数
	 * @return
	 */
	public Integer firstTotal();

	/**
	 * 待审核总数
	 * @return
	 */
	public Integer auditTotal();

	/**
	 * 初审不通过总数
	 * @return
	 */
	public Integer firstNotTotal();

	/**
	 * 审核不通过总数
	 * @return
	 */
	public Integer auditNotTotal();

	/**
	 * 审核通过总数
	 * @return
	 */
	public Integer passTotal();

	/**
	 * 待列入总数带参数（分页用）
	 * @return
	 */
	public Integer applySrcTotalParm(Map<String, Object> qryMap);

	/**
	 * 已列入总数带参数（分页用）
	 * @return
	 */
	public Integer applyTotalParm(Map<String, Object> qryMap);

	/**
	 * 删除严违名单
	 * @param sourceId
	 * @return
	 * @throws Exception
	 */
	public Integer deleteExpSeriousList(String uid) throws Exception;
	
	/**
	 * 根据列违原因得到列违类型
	 * @param AddSecCause
	 * @return
	 */
	public String getSecDishonestyTypeByAddSecCause(String AddSecCause);

	Integer UpdateSomeMsg(String sourceId) throws Exception;
}
