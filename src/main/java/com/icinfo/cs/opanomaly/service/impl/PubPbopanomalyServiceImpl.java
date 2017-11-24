/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.mapper.PubPbOpadetailMapper;
import com.icinfo.cs.opanomaly.mapper.PubPbopanomalyMapper;
import com.icinfo.cs.opanomaly.model.PubPbopanomaly;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述: cs_pub_pbopanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月08日
 */
@Service
public class PubPbopanomalyServiceImpl extends MyBatisServiceSupport implements IPubPbopanomalyService {

	private static final Logger logger = LoggerFactory.getLogger(PubPbopanomalyServiceImpl.class);

	@Autowired
	private PubPbopanomalyMapper pubPbopanomalyMapper;

	@Autowired
	MidBaseInfoMapper midBaseInfoMapper;

	@Autowired
	PubPbOpadetailMapper pubPbOpadetailMapper;

	@Autowired
	IEsManageService esManageService;

	/**
	 * 描述: 列表加载
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<MidBaseInfo> selectmidBaseInfolist(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> maps = request.getParams();
		List<MidBaseInfo> ls = midBaseInfoMapper.selectPbMidBaseinfoByManyConditions(maps);
		return ls;
	}

	/**
	 * 描述: 根据注册号查找MidBaseInfo
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param regNO
	 * @return
	 * @throws Exception
	 */
	@Override
	public MidBaseInfo selectByRegNO(String regNO) throws Exception {
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("regNO", regNO);
		return midBaseInfoMapper.selectPbMidBaseinfoByManyConditions(maps).get(0);
	}

	/**
	 * 描述: 新增异常
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	public int addSign(PubPbopanomaly pbopanomaly) throws Exception {
		if (pbopanomaly != null) {
			pbopanomaly.setCogDate(new Date());
			pbopanomaly.setCreateTime(new Date());
			return pubPbopanomalyMapper.insert(pbopanomaly);
		} else {
			return 0;
		}

	}

	/**
	 * 
	 * 描述 经营状态查询 分页查询 @author 赵祥江 @date 2016年10月9日 下午2:16:39 @param @return
	 * List<PubPbopanomalyDto> @throws
	 */

	@Override
	public List<PubPbopanomalyDto> queryPubPbopanomalySearchList(PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap = request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return pubPbopanomalyMapper.selectPubPbopanomalySearchList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "经营状态查询失败!");
			throw new BusinessException("经营状态查询失败!");
		}
	}

	/**
	 * 
	 * 描述 个体户经营异常状态查询 统计被标记记录的户数 @author 赵祥江 @date 2016年10月9日
	 * 下午2:20:38 @param @return Integer @throws
	 */
	@Override
	public Integer selectEntCount(Map<String, Object> queryMap) {
		try {
			Integer entCount = pubPbopanomalyMapper.selectEntCount(queryMap);
			return entCount == null ? 0 : entCount;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "个体户经营异常状态查询 统计被标记记录的户数失败!");
			throw new BusinessException("个体户经营异常状态查询 统计被标记记录的户数失败!");
		}
	}

	/**
	 * 
	 * 描述 个体户 统计标记未恢复的条数 @author 赵祥江 @date 2016年10月9日 下午2:20:38 @param @return
	 * Integer @throws
	 */
	@Override
	public Integer selectMarkEntCount(Map<String, Object> queryMap) {
		try {
			Integer markEntCount = pubPbopanomalyMapper.selectMarkEntCount(queryMap);
			return markEntCount == null ? 0 : markEntCount;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "统计标记未恢复的条数失败!");
			throw new BusinessException("统计标记未恢复的条数失败!");
		}
	}

	/**
	 * 
	 * 描述 个体户 统计标记已恢复的条数 @author 赵祥江 @date 2016年10月9日 下午2:20:38 @param @return
	 * Integer @throws
	 */
	@Override
	public Integer selectRenewEntCount(Map<String, Object> queryMap) {
		try {
			Integer renewEntCount = pubPbopanomalyMapper.selectRenewEntCount(queryMap);
			return renewEntCount == null ? 0 : renewEntCount;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "个体户 统计标记已恢复的条数失败!");
			throw new BusinessException("个体户 统计标记已恢复的条数失败!");
		}
	}

	/**
	 * 描述: 根据maps搜索个体户异常信息
	 * 
	 * @author ZhouJun
	 * @date 2016年10月10日
	 * @param maps
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubPbopanomalyDto> PubPbopanomalySearchList(Map<String, Object> maps) throws Exception {
		return pubPbopanomalyMapper.selectPubPbopanomalyAppList(maps);
	}

	/**
	 * 描述: 异常恢复
	 * 
	 * @author ZhouJun
	 * @date 2016年10月13日
	 * @param pbopanomaly
	 * @return
	 * @throws Exception
	 */
	public int pubPbopanomalyRecover(PubPbopanomaly pbopanomaly) throws Exception {
		Example ex = new Example(PubPbopanomaly.class);
		if (pbopanomaly != null && StringUtil.isNotEmpty(pbopanomaly.getBusExcList())
				&& StringUtil.isNotEmpty(pbopanomaly.getPriPID())) {
			try {
				// pbopanomaly.setNorDate(new Date());
				pbopanomaly.setCreateTime(new Date());
				// pbopanomaly.setIsRecovery("0");
				ex.createCriteria().andEqualTo("busExcList", pbopanomaly.getBusExcList()).andEqualTo("priPID",
						pbopanomaly.getPriPID());
				return pubPbopanomalyMapper.updateByExampleSelective(pbopanomaly, ex);
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
		}

		return 0;
	}

	/**
	 * 描述: 查找可以恢复标记的异常列表
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param request
	 * @return
	 */
	@Override
	public List<PubPbopanomalyDto> queryPubPbopanomalySearchRecoverList(PageRequest request) {
		try {
			Map<String, Object> searchMap = new HashMap<>();
			if (request.getParams() != null) {
				searchMap.putAll(request.getParams());
			}
			searchMap.put("isRecovery", 1);
			searchMap.put("handFlag", 1); // 手动列入标志
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return pubPbopanomalyMapper.selectPubPbopanomalySearchList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "经营状态查询失败!");
			throw new BusinessException("经营状态查询失败!");
		}
	}

	/**
	 * 描述: 查找可以恢复标记的异常列表(不分页 ，更新索引用)
	 * 
	 * @author ZhouJun
	 * @date 2016年10月12日
	 * @param request
	 * @return
	 */
	public List<PubPbopanomalyDto> pubPbopanomalySearchRecoverList(Map<String, Object> searchMap) {
		return pubPbopanomalyMapper.selectOpanomalyForCheck(searchMap);
	}

	/**
	 * 描述: 纳入/移出经营异常名录信息（公示单个个体户展示）
	 * 
	 * @auther ZhouYan
	 * @date 2016年11月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubPbopanomaly> queryPubPbopanomalyListForPub(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		String priPID = request.getParams().get("priPID").toString();
		if (StringUtils.isNotBlank(priPID)) {
			Example example = new Example(PubPbopanomaly.class);
			example.createCriteria().andEqualTo(Constants.CS_PRIPID, priPID);
			return pubPbopanomalyMapper.selectByExample(example);
		} else {
			return new ArrayList<PubPbopanomaly>();
		}
	}

	/**
	 * 
	 * 描述 查询已经年报且在经营异常名录（未按时年报）中的个体户 @author 赵祥江 @date 2016年12月20日
	 * 下午3:39:18 @param @return List<PubPbopanomalyDto> @throws
	 */
	@Override
	public List<PubPbopanomalyDto> selectPubPbopanomalyIsReported(Map<String, Object> searchMap) throws Exception {
		return pubPbopanomalyMapper.selectPubPbopanomalyIsReported(searchMap);
	}

	/**
	 * 
	 * 描述 根据主体代码和年度查询 @author 赵祥江 @date 2016年12月20日 下午6:24:15 @param @return
	 * List<PubPbopanomaly> @throws
	 */
	@Override
	public List<PubPbopanomaly> selectPubPbopanomalyByYearAndPriPID(Integer year, String priPID) throws Exception {
		if (year != null && com.icinfo.framework.mybatis.mapper.util.StringUtil.isNotEmpty(priPID)) {
			PubPbopanomaly pubPbopanomaly = new PubPbopanomaly();
			pubPbopanomaly.setPriPID(priPID);
			pubPbopanomaly.setYear(year);
			return pubPbopanomalyMapper.select(pubPbopanomaly);
		}
		return null;
	}

	/**
	 * 
	 * 描述 根据主键busExcList修改异常信息 @author 赵祥江 @date 2016年12月20日
	 * 下午6:34:22 @param @throws
	 */
	@Override
	public int updatePubPbopanomalyByBusExcList(PubPbopanomalyDto pubPbopanomalyDto) throws Exception {
		try {
			if (pubPbopanomalyDto != null && StringUtil.isNotEmpty(pubPbopanomalyDto.getBusExcList())
					&& StringUtil.isNotEmpty(pubPbopanomalyDto.getPriPID())) {
				// 时间戳
				pubPbopanomalyDto.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(PubPbopanomaly.class);
				example.createCriteria().andEqualTo("busExcList", pubPbopanomalyDto.getBusExcList())
						.andEqualTo("priPID", pubPbopanomalyDto.getPriPID());
				return pubPbopanomalyMapper.updateByExampleSelective(pubPbopanomalyDto, example);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键busExcList修改异常信息失败!");
			throw new BusinessException("根据主键busExcList修改异常信息失败!");
		}
		return 0;
	}

	/**
	 * 
	 * 描述 获取已经注销且还在异常列表的个体户 @author 赵祥江 @date 2017年1月16日
	 * 上午10:49:38 @param @throws
	 */
	@Override
	public List<PubPbopanomalyDto> selectpubPbOpanomalyDXAutoOutList(Map<String, Object> queryMap) throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(queryMap != null){
			paramsMap = queryMap;
		}
		paramsMap.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubPbopanomalyMapper.selectpubPbOpanomalyDXAutoOutList(paramsMap);
	}

	/**
	 * 
	 * 描述: 查询个转企且存在异常标记的企业记录
	 * 
	 * @auther gaojinling
	 * @date 2017年1月16日
	 * @param searchMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubPbopanomalyDto> selectPubPbopanomalyIsIndividualed(Map<String, Object> searchMap) throws Exception {
		return pubPbopanomalyMapper.selectPubPbopanomalyIsIndividualed(searchMap);
	}

	@Override
	public List<PubPbopanomalyDto> selectPubPbopanomalyPriPID(String priPID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		return pubPbopanomalyMapper.selectPubPbopanomalyPriPID(map);
	}

	@Override
	public List<PubPbopanomalyDto> queryPubPbopanomalyAppList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String excpStaRes = (String) params.get("excpStaRes");
		params.put("excpStaRes", excpStaRes.split(","));
		params.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubPbopanomalyMapper.selectPubPbopanomalyAppList(params);
	}

	@Override
	public int savePbopanomaly(PubPbopanomaly pbopanomaly) {
		if (pbopanomaly != null) {
			pbopanomaly.setCreateTime(new Date());
			pbopanomaly.setFirstDate(DateUtil.getSysCurrentDate());
			pbopanomaly.setAuditState("0");// 待审核状态
			pbopanomaly.setPBSource("1");// 来源：默认工商录入
			pbopanomaly.setPBState("0");// 未上报
			pbopanomaly.setYear(Integer.parseInt(DateUtil.getCurrentYear()));
			return pubPbopanomalyMapper.insert(pbopanomaly);
		} else {
			return 0;
		}
	}

	@Override
	public PubPbopanomalyDto selectPubPbopanomalyDtoByBusExcList(String busExcList) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("busExcList", busExcList);
		return pubPbopanomalyMapper.selectPubPbopanomalyDtoByBusExcList(params);
	}

	@Override
	public int savePbopanomalyCheck(PubPbopanomalyDto ppd) {
		return pubPbopanomalyMapper.updateByPrimaryKeySelective(ppd);
	}

	@Override
	public List<PubPbopanomalyDto> selectPubPbopanomalys(Map<String, Object> params) {
		return pubPbopanomalyMapper.selectPubPbopanomalys(params);
	}

	@Override
	public int saveEditPbopanomaly(PubPbopanomaly pbopanomaly) {
		PubPbopanomaly pp = new PubPbopanomaly();
		pp.setBusExcList(pbopanomaly.getBusExcList());
		pp = pubPbopanomalyMapper.selectOne(pp);
		pp.setExcpStaRes(pbopanomaly.getExcpStaRes());
		pp.setExcpStaResCN(pbopanomaly.getExcpStaResCN());
		pp.setSignRea(pbopanomaly.getSignRea());
		pp.setFirstOpin(pbopanomaly.getFirstOpin());
		pp.setCogDate(pbopanomaly.getCogDate());
		return pubPbopanomalyMapper.updateByPrimaryKeySelective(pp);
	}

	@Override
	public int deletePbopanomalyByBusExcList(String busExcList) {
		PubPbopanomaly pubPbopanomaly = new PubPbopanomaly();
		pubPbopanomaly.setBusExcList(busExcList);
		return pubPbopanomalyMapper.delete(pubPbopanomaly);
	}

	/**
	 * 
	 * 描述 未按时年报列入异常 @author 赵祥江 @date 2017年6月29日 上午10:16:03 @param @throws
	 */
	@Override
	public void doPubPbopanomalyNoReport(Map<String, Object> searchMap) throws Exception {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(searchMap != null){
			paramsMap = searchMap;
		}
		paramsMap.put("regState", RegStateEnum.CUNXU.getParam());
		pubPbopanomalyMapper.doPubPbopanomalyNoReport(paramsMap);
	}

	@Override
	public List<PubPbopanomalyDto> queryPbopanomalyRecoveryList(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> params = request.getParams();
		String excpStaRes = (String) params.get("excpStaRes");
		params.put("excpStaRes", excpStaRes.split(","));
		params.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubPbopanomalyMapper.selectPbopanomalyRecoveryList(params);
	}

	@Override
	public List<PubPbopanomalyDto> selectPubPbopanomalyListForPub(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), 100);
		List<PubPbopanomalyDto> pubPbopanomalyDtos = pubPbopanomalyMapper
				.selectPubPbopanomalyListForPub(request.getParams());
		return pubPbopanomalyDtos;
	}

	@Override
	public void test() {
		int pageSize = 20000;
		int totalPage = 0;
		int totalIncreCount = 500000;// 查询增量更新的总数量

		if (totalIncreCount % pageSize == 0) {
			totalPage = totalIncreCount / pageSize;
		}
		totalPage = (totalIncreCount / pageSize) + 1;

		for (int currPage = 1; currPage < totalPage; currPage++) {
			logger.info("生成索引 共{}页  当前页码{} size:{}", totalPage, currPage, pageSize);
			System.out.println("生成索引 共 " + totalPage + " 页  当前页码" + currPage + " size:" + pageSize);
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("pageNum", currPage * pageSize);
			paramMap.put("pageSize", pageSize);
			List<PubPbopanomaly> pubPbopanomalys = pubPbopanomalyMapper.test(paramMap);
			for (PubPbopanomaly pubPbopanomaly : pubPbopanomalys) {
				esManageService.updateOnePanoramaIdx(pubPbopanomaly.getPriPID());
			}
		}
	}

	/**
	 * 
	 * 描述   根据主体身份代码查询列入记录 不包括撤销
	 * @author 赵祥江
	 * @date 2017年10月10日 下午6:10:50 
	 * @param 
	 * @return List<PubPbopanomalyDto>
	 * @throws
	 */
	@Override
	public List<PubPbopanomalyDto> selectMoveInPubPbopanomalyPriPID(
			String  priPID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		return pubPbopanomalyMapper.selectMoveInPubPbopanomalyPriPID(map);
	}
	
	
	
	/**
	 * 
	 * 描述: 个体户列入异常待审核条数（首页统计使用）
	 * @auther gaojinling
	 * @date 2017年10月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectInAduitCount(Map<String, Object> map) throws Exception{
		map.put("regState", RegStateEnum.ZHUXIAO.getParam());
		return pubPbopanomalyMapper.selectInAduitCount(map);
	}
	/**
	 * 
	 * 描述: 个体户移出异常待审核条数（首页统计使用）
	 * @auther gaojinling
	 * @date 2017年10月13日 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public int selectOutAduitCount(Map<String, Object> map) throws Exception{
		return pubPbopanomalyMapper.selectOutAduitCount(map);
	}
}
