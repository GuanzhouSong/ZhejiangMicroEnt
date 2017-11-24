/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.model.PubPbOpadetail;
import com.icinfo.cs.opanomaly.model.PubPbopanomaly;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_pbopanomaly 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
public interface IPubPbopanomalyService extends BaseService {

	/**
	 * 描述: 根据request查找列表
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<MidBaseInfo> selectmidBaseInfolist(PageRequest request) throws Exception;

	/**
	 * 描述: 根据注册号从mid表查询
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param regNO
	 * @return
	 * @throws Exception
	 */
	public MidBaseInfo selectByRegNO(String regNO) throws Exception;

	/**
	 * 描述: 新增异常标记
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	public int addSign(PubPbopanomaly pbopanomaly) throws Exception;

	/**
	 * 描述: 个体户异常查询列表
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	public List<PubPbopanomalyDto> PubPbopanomalySearchList(Map<String, Object> maps) throws Exception;

	/**
	 * 
	 * 描述 经营状态查询 分页查询 @author 赵祥江 @date 2016年10月9日 下午2:16:39 @param @return
	 * List<PubPbopanomalyDto> @throws
	 */
	public List<PubPbopanomalyDto> queryPubPbopanomalySearchList(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述 个体户经营异常状态查询 统计被标记记录的户数 @author 赵祥江 @date 2016年10月9日
	 * 下午2:20:38 @param @return Integer @throws
	 */
	public Integer selectEntCount(Map<String, Object> queryMap);

	/**
	 * 
	 * 描述 个体户 统计标记未恢复的条数 @author 赵祥江 @date 2016年10月9日 下午2:20:38 @param @return
	 * Integer @throws
	 */
	public Integer selectMarkEntCount(Map<String, Object> queryMap);

	/**
	 * 
	 * 描述 个体户 统计标记已恢复的条数 @author 赵祥江 @date 2016年10月9日 下午2:20:38 @param @return
	 * Integer @throws
	 */
	public Integer selectRenewEntCount(Map<String, Object> queryMap);

	/**
	 * 描述: 异常恢复
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param pbopanomaly
	 */
	public int pubPbopanomalyRecover(PubPbopanomaly pbopanomaly) throws Exception;

	/**
	 * 描述: 查找可以恢复标记的异常列表
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param request
	 * @return
	 */
	public List<PubPbopanomalyDto> queryPubPbopanomalySearchRecoverList(PageRequest request);

	/**
	 * 描述: 纳入/移出经营异常名录信息（公示单个个体户展示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubPbopanomaly> queryPubPbopanomalyListForPub(PageRequest request) throws Exception;
	
	/**
	 * 描述: 纳入/移出经营异常名录信息（公示单个个体户展示）
	 * 
	 * @auther baifangfang
	 * @date 2016年11月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<PubPbopanomalyDto> selectPubPbopanomalyListForPub(PageRequest request) throws Exception;

	/**
	 * 描述: 查找可以恢复标记的异常列表(不分页 ，更新索引用)
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param request
	 * @return
	 */
	public List<PubPbopanomalyDto> pubPbopanomalySearchRecoverList(Map<String, Object> searchMap);

	/**
	 * 
	 * 描述 查询已经年报且在经营异常名录（未按时年报）中的个体户 @author 赵祥江 @date 2016年12月20日
	 * 下午3:39:18 @param @return List<PubPbopanomalyDto> @throws
	 */
	public List<PubPbopanomalyDto> selectPubPbopanomalyIsReported(Map<String, Object> searchMap) throws Exception;

	/**
	 * 
	 * 描述 根据主体代码和年度查询 @author 赵祥江 @date 2016年12月20日 下午6:24:15 @param @return
	 * List<PubPbopanomaly> @throws
	 */
	public List<PubPbopanomaly> selectPubPbopanomalyByYearAndPriPID(Integer year, String priPID) throws Exception;

	/**
	 * 
	 * 描述 根据主键修改 @author 赵祥江 @date 2016年12月20日 下午6:25:20 @param @return
	 * int @throws
	 */
	public int updatePubPbopanomalyByBusExcList(PubPbopanomalyDto pubPbopanomalyDto) throws Exception;

	/**
	 * 
	 * 描述 获取已经注销且还在异常列表的个体户 @author 赵祥江 @date 2017年1月16日
	 * 上午10:50:32 @param @return List<PubPbopanomalyDto> @throws
	 */
	public List<PubPbopanomalyDto> selectpubPbOpanomalyDXAutoOutList(Map<String, Object> queryMap) throws Exception;

	/**
	 * 
	 * 描述: 查询个转企且存在异常标记记录
	 * 
	 * @auther gaojinling
	 * @date 2017年1月16日
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	public List<PubPbopanomalyDto> selectPubPbopanomalyIsIndividualed(Map<String, Object> searchMap) throws Exception;

	/**
	 * 描述：根据pripid查询列入经营异常名录信息
	 * 
	 * @date 2017年4月19日
	 * @auther baifangfang
	 * @param priPID
	 * @return
	 */
	public List<PubPbopanomalyDto> selectPubPbopanomalyPriPID(String priPID);

	/**
	 * 描述：个体户标记异常申请JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年6月19日
	 * @param request
	 * @return
	 */
	public List<PubPbopanomalyDto> queryPubPbopanomalyAppList(PageRequest request);

	/**
	 * 描述：新增异常标记
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @param pbopanomaly
	 * @return
	 */
	public int savePbopanomaly(PubPbopanomaly pbopanomaly);

	/**
	 * 描述：根据uuid查询异常标记信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月26日
	 * @param busExcList
	 * @return
	 */
	public PubPbopanomalyDto selectPubPbopanomalyDtoByBusExcList(String busExcList);

	/**
	 * 描述：个体户异常标记审核
	 * 
	 * @author Administrator
	 * @date 2017年6月27日
	 * @param ppd
	 * @return
	 */
	public int savePbopanomalyCheck(PubPbopanomalyDto ppd);

	/**
	 * 描述：查询单个个体户异常经营信息
	 * 
	 * @author baifangfang
	 * @date 2017年6月27日
	 * @param searchmaps
	 * @return
	 */
	public List<PubPbopanomalyDto> selectPubPbopanomalys(Map<String, Object> searchmaps);

	/**
	 * 描述：保存修改异常标记记录
	 * 
	 * @author baifangfang
	 * @date 2017年6月28日
	 * @param pbopanomaly
	 * @return
	 */
	public int saveEditPbopanomaly(PubPbopanomaly pbopanomaly);

	/**
	 * 描述：删除异常标记记录
	 * 
	 * @author baifangfang
	 * @date 2017年6月28日
	 * @param busExcList
	 * @return
	 */
	public int deletePbopanomalyByBusExcList(String busExcList);

	/**
	 * 
	 * 描述 未按时年报列入异常 @author 赵祥江 @date 2017年6月29日 上午10:15:11 @param @return
	 * void @throws
	 */
	public void doPubPbopanomalyNoReport(Map<String, Object> searchMap) throws Exception;

	/**
	 * 描述：新增恢复异常记载JSON数据列表
	 * 
	 * @author baifangfang
	 * @date 2017年7月5日
	 * @param request
	 * @return
	 */
	public List<PubPbopanomalyDto> queryPbopanomalyRecoveryList(PageRequest request);

	public void test();
	
	/**
	 * 
	 * 描述   根据主体身份代码查询列入记录 不包括撤销
	 * @author 赵祥江
	 * @date 2017年10月10日 下午6:10:50 
	 * @param 
	 * @return List<PubPbopanomalyDto>
	 * @throws
	 */
	public List<PubPbopanomalyDto> selectMoveInPubPbopanomalyPriPID(String  priPID);
	
	/**
	 * 
	 * 描述: 个体户列入异常待审核条数（首页统计使用）
	 * @auther gaojinling
	 * @date 2017年10月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectInAduitCount(Map<String, Object> map) throws Exception;
	/**
	 * 
	 * 描述: 个体户移出异常待审核条数（首页统计使用）
	 * @auther gaojinling
	 * @date 2017年10月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectOutAduitCount(Map<String, Object> map) throws Exception;
	

}