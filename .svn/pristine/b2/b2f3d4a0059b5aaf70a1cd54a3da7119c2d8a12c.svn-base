/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.base.model.CodeRegState;
import com.icinfo.cs.base.service.ICodeRegStateService;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.dto.PubPbOpadetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.mapper.PubOpanoMalyMapper;
import com.icinfo.cs.opanomaly.model.PubOpaDetail;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbOpadetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.framework.core.exception.BusinessException;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.tools.utils.DateUtils;

/**
 * 描述:    cs_pub_opanomaly 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
@Service
public class PubOpanoMalyServiceImpl extends MyBatisServiceSupport implements IPubOpanoMalyService {
	private static final Logger logger = LoggerFactory.getLogger(PubOpanoMalyServiceImpl.class);
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	@Autowired
	private PubOpanoMalyMapper pubOpanoMalyMapper; 
	@Autowired
	private IMidBaseInfoService midBaseInfoService; 
	@Autowired
	private ICodeRegStateService codeRegStateService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubPbOpadetailService pubPbOpadetailService;
	
	private final String CS_PUB_OPANOMALY_BUSEXCLIST="busExcList";
	
	private final String key="asdfghjkl";
	
	
	/**
	 * 
	 * 描述   保存异常信息
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:02:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int insertPubOpanoMaly(PubOpanoMaly pubOpanoMaly) throws Exception {
		try {
			if(pubOpanoMaly!=null){
			  //时间戳
			  pubOpanoMaly.setCreateTime(DateUtils.getSysDate());
			  return pubOpanoMalyMapper.insert(pubOpanoMaly);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "保存异常信息失败!");
            throw new BusinessException("保存异常信息失败!");
		} 
		return 0;
	}

	/**
	 * 
	 * 描述   根据主键busExcList删除异常信息
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:04:30 
	 * @param 
	 * @return int
	 * @throws
	 */
	@Override
	public int deletePubOpanoMalyByBusExcList(String busExcList)
			throws Exception {
		try {
			if(StringUtil.isNotEmpty(busExcList)){
				PubOpanoMaly pubOpanoMaly=new PubOpanoMaly();
				pubOpanoMaly.setBusExcList(busExcList);
			    return pubOpanoMalyMapper.delete(pubOpanoMaly);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键busExcList删除异常信息失败!");
            throw new BusinessException("根据主键busExcList删除异常信息失败!");
		} 
		return 0;
	}

	 /**
     * 
     * 描述   修改
     * @author 赵祥江
     * @date 2016年10月11日 上午10:05:54 
     * @param 
     * @return int
     * @throws
     */
	@Override
	public int updatePubOpanoMaly(PubOpanoMaly pubOpanoMaly) throws Exception {
		try {
			if(pubOpanoMaly!=null&&StringUtil.isNotEmpty(pubOpanoMaly.getBusExcList())){
				//时间戳
				pubOpanoMaly.setCreateTime(DateUtils.getSysDate());
				Example example = new Example(PubOpanoMaly.class);
				example.createCriteria().andEqualTo(CS_PUB_OPANOMALY_BUSEXCLIST, pubOpanoMaly.getBusExcList());
			    return pubOpanoMalyMapper.updateByExampleSelective(pubOpanoMaly, example);
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
     * 描述   根据主键BusExcList查询异常对象
     * @author 赵祥江
     * @date 2016年10月11日 上午10:06:50 
     * @param 
     * @return PubOpanoMaly
     * @throws
     */
	@Override
	public PubOpanoMaly selectPubOpanoMalyByBusExcList(String busExcList)
			throws Exception {
		try {
			if(StringUtil.isNotEmpty(busExcList)){
				PubOpanoMaly pubOpanoMaly=new PubOpanoMaly();
				pubOpanoMaly.setBusExcList(busExcList);
				return pubOpanoMalyMapper.selectOne(pubOpanoMaly);
			} 
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据主键BusExcList查询异常对象失败!");
            throw new BusinessException("根据主键BusExcList查询异常对象失败!");
		} 
		return null;
	}
	
	 /**
     * 
     * 描述   分页查询已经列入未撤销移出的异常列表
     * @author 赵祥江
     * @date 2016年10月11日 上午11:02:33 
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
	@Override
	public List<PubOpanoMalyDto> queryPubOpanoMalyList(PageRequest request) {
		try {
			Map<String, Object> searchMap=  request.getParams();
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
 			return pubOpanoMalyMapper.selectPubOpanoMalyList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "经营状态查询失败!");
            throw new BusinessException("经营状态查询失败!");
		}
	}
	
	 /**
     * 
     * 描述   
     * @author ylr
     * @date 2016年10月11日 上午11:02:33 
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
    public Integer getPubOpanoMalyTotal(Map<String, Object> qryMap)throws Exception{
    	List<PubOpanoMalyDto> list = pubOpanoMalyMapper.selectPubOpanoMalyList(qryMap);
    	return list ==null?0:list.size();
    }

	/**
	 * 
	 * 描述   根据传入的类型查询 EntTypeFlag为0查询农专 EntTypeFlag为1查询企业
	 * @author  赵祥江
	 * @date 2016年10月26日 下午2:46:05 
	 * @param  
	 * @throws
	 */
	@Override
	public List<MidBaseInfoDto> queryMidBasePubOpanoMalyList(PageRequest request)
			throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			if(request.getParams() != null){
				searchMap = request.getParams();
			}
			searchMap.put("regState", RegStateEnum.DIAOXIAO.getParam());
			return pubOpanoMalyMapper.selectMidBasePubOpanoMalyList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "根据传入的类型查询 EntTypeFlag为0查询农专 EntTypeFlag为1查询企业失败!");
            throw new BusinessException("根据传入的类型查询 EntTypeFlag为0查询农专 EntTypeFlag为1查询企业失败!");
		}
	}

	   /**
     * 
     * 描述   根据登记机关获取文号数字
     * @author 赵祥江
     * @date 2016年10月13日 下午7:06:56 
     * @param 
     * @return BigDecimal
     * @throws
     */
	@Override
	public Integer selectPenDecNoByRegOrg(String regOrg) throws Exception {
		Map<String, Object> queryMap=  new HashMap<String, Object>();
		queryMap.put("regOrg", regOrg);
		queryMap.put("year", DateUtils.getYear());
		return pubOpanoMalyMapper.selectPenDecNoByRegOrg(queryMap);
	} 
	
	/**
	 * 
	 * 描述   异常名录查询  
	 * @author 赵祥江
	 * @date 2016年10月26日 下午2:41:50 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	@Override
	public List<PubOpanoMalyDto> selectPubOpanoMalySearchList(
			PageRequest request) throws Exception {
		try {
			Map<String, Object> searchMap=  request.getParams();
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
 			return pubOpanoMalyMapper.selectPubOpanoMalySearchList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常名录查询失败!");
            throw new BusinessException("异常名录查询 失败!");
		}
	}

	/**
	 * 
	 * 描述   统计已移出的企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:03 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectIsInAndIsOutCount(Map<String, Object> queryMap) {
		try { 
			return pubOpanoMalyMapper.selectIsInAndIsOutCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "统计已移出的企业多少家失败!");
            throw new BusinessException("统计已移出的企业多少家失败!");
		}
	}

	/**
	 * 
	 * 描述   统计列入未移出企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:08 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectIsInAndNotOutCount(Map<String, Object> queryMap) {
		try { 
			return pubOpanoMalyMapper.selectIsInAndNotOutCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "统计列入未移出企业多少家失败!");
            throw new BusinessException("统计列入未移出企业多少家失败!");
		}
	}

	/**
	 * 
	 * 描述   统计已公示企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:13 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	@Override
	public Integer selectIsPubCount(Map<String, Object> queryMap) {
		try { 
			return pubOpanoMalyMapper.selectIsPubCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "统计已公示企业多少家失败!");
            throw new BusinessException("统计已公示企业多少家失败!");
		}
	}
	
	/**
	 * 
	 * 描述   根据公司id查询异常名录
	 * @author chenyu
	 * @date 2016年10月26日 下午2:41:50 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	@Override
	public List<PubOpanoMalyDto> selectPubOpanoMalyListBypriPID(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> searchMap = request.getParams();
		return pubOpanoMalyMapper.selectPubOpanoMalyListByPriPID(searchMap);
	}

	/** 
	 * 描述: 纳入/移出经营异常名录信息（公示单个企业展示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param request
	 * @return 
	 */
	@Override
	public List<PubOpanoMalyDto> queryPubOpanoMalyListForPub(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		String priPID = request.getParams().get("priPID").toString();
		if(StringUtils.isNotBlank(priPID)) {
			return pubOpanoMalyMapper.selectPubOpanoMalyListForPub(request.getParams());
		}else{
			return new ArrayList<PubOpanoMalyDto>();
		}
	}

	@Override
	public String getEntForDatajoinJSON_downednum(Map param) {
		PubOpanoMalyDto dto = pubOpanoMalyMapper.selectPubOpanoMalyList_downnum(param);
		if(dto!=null)
		return dto.getDownState()==null?"0":dto.getDownState();
		return "0";
	}
	
	/** 
	 * 描述: 生成列入，列出公告数据
	 * @auther yujingwei
	 * @date 2016年12月8日 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 */
	public List<PubOpanoMalyDto> queryPubOpanoMalyListForNotice(String updateDate) throws Exception{
		return pubOpanoMalyMapper.queryPubOpanoMalyListForNotice(updateDate);
	}

	/**
	 * 数据接入的查询
	 * @param request
	 * @return
	 */
	@Override
	public List<PubOpanoMalyDto> selectPubOpanoMalyList_Fordatain(PageRequest request) {
		try {
			Map<String, Object> searchMap=  request.getParams();
			PageHelper.startPage(request.getPageNum(), request.getLength());
			return pubOpanoMalyMapper.selectPubOpanoMalyList_Fordatain(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "经营状态查询失败!");
			throw new BusinessException("经营状态查询失败!");
		}
	}

	/**
     * 
     * 描述   异常查询 分页条数
     * @author 赵祥江
     * @date 2016年12月16日 上午9:22:03 
     * @param 
     * @return Integer
     * @throws
     */
	@Override
	public Integer selectPubOpanoMalySearchCount(Map<String,Object> queryMap)
			throws Exception {
		try {  
			return pubOpanoMalyMapper.selectPubOpanoMalySearchCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常查询 分页条数失败!");
			throw new BusinessException("异常查询 分页条数失败!");
		}
	}

	 /**
     * 
     * 描述   列入申请和列入列表 查询分页条数
     * @author 赵祥江
     * @date 2016年12月16日 上午10:10:26 
     * @param 
     * @return Integer
     * @throws
     */
	@Override
	public Integer selectPubOpanoMalyListCount(Map<String, Object> queryMap)
			throws Exception {
		try {  
			return pubOpanoMalyMapper.selectPubOpanoMalyListCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常查询 分页条数失败!");
			throw new BusinessException("异常查询 分页条数失败!");
		}
	}

	@Override
	public List<PubOpanoMaly> selectListByCerNO(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOpanoMalyMapper.selectListByCerNO(request.getParams());
	}

	@Override
	public List<PubOpanoMalyDto> selectPubOpanoMalyServicePriPID(String priPID) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		return pubOpanoMalyMapper.selectPubOpanoMalyServicePriPID(map);
	}
	
	 /**
     * 描述   经营异常查询（全景）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  request
     * @return List<PubOpanoMalyDto>
     * @throws Exception
     */
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchList(PageRequest request) throws Exception{
		try {
			Map<String, Object> searchMap=  request.getParams();
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
			if(searchMap.get("regState") != null && !searchMap.get("regState").equals("")){
				searchMap.put("regStates", searchMap.get("regState").toString().split(","));
			}
			if(searchMap.get("industryCo") != null && !searchMap.get("industryCo").equals("")){
				searchMap.put("industryCos", searchMap.get("industryCo").toString().split(","));
			}
			if (searchMap.get("regOrg") != null && !searchMap.get("regOrg").equals("")) {
				searchMap.put ("regOrg", StringUtil.doSplitStringToSqlFormat (searchMap.get ("regOrg").toString (), ","));
	        }
	        if (searchMap.get("localAdm") != null && !searchMap.get("localAdm").equals("")) {
	        	searchMap.put ("localAdm", StringUtil.doSplitStringToSqlFormat (searchMap.get ("localAdm").toString (), ","));
	        }
 			return pubOpanoMalyMapper.selectPubOpanoMalyNewSearchList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常名录查询失败!");
            throw new BusinessException("异常名录查询 失败!");
		}
	}
	
	/**
     * 描述   经营异常查询个数（全景）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  queryMap
     * @return Integer
     * @throws Exception
     */
	public Integer selectPubOpanoMalyNewSearchCount(Map<String, Object> queryMap) throws Exception{
		try {  
			return pubOpanoMalyMapper.selectPubOpanoMalyNewSearchCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常查询 分页条数失败!");
			throw new BusinessException("异常查询 分页条数失败!");
		}
	}
	
	/**
     * 描述   经营异常记录查询（经营异常管理）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  request
     * @return List<PubOpanoMalyDto>
     * @throws Exception
     */
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchHisList(PageRequest request) throws Exception{
		try {
			Map<String, Object> searchMap=  request.getParams();
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
			if(searchMap.get("regState") != null && !searchMap.get("regState").equals("")){
				searchMap.put("regStates", searchMap.get("regState").toString().split(","));
			}
			if(searchMap.get("industryCo") != null && !searchMap.get("industryCo").equals("")){
				searchMap.put("industryCos", searchMap.get("industryCo").toString().split(","));
			}
			if (searchMap.get("regOrg") != null && !searchMap.get("regOrg").equals("")) {
				searchMap.put ("regOrg", StringUtil.doSplitStringToSqlFormat (searchMap.get ("regOrg").toString (), ","));
	        }
	        if (searchMap.get("localAdm") != null && !searchMap.get("localAdm").equals("")) {
	        	searchMap.put ("localAdm", StringUtil.doSplitStringToSqlFormat (searchMap.get ("localAdm").toString (), ","));
	        }
 			return pubOpanoMalyMapper.selectPubOpanoMalyNewSearchHisList(searchMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常名录查询失败!");
            throw new BusinessException("异常名录查询 失败!");
		}
	}
	
	/**
     * 描述   经营异常记录查询个数（经营异常管理）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  queryMap
     * @return Integer
     * @throws Exception
     */
	public Integer selectPubOpanoMalyNewSearchHisCount(Map<String, Object> queryMap) throws Exception{
		try {  
			return pubOpanoMalyMapper.selectPubOpanoMalyNewSearchHisCount(queryMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常查询 分页条数失败!");
			throw new BusinessException("异常查询 分页条数失败!");
		}
	}
	
	/**
	 * 描述: 经营异常名录查询统计（全景及管理模块）
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public List<PubOpanoMalyDto> doGetOpanaMalyCountForSyn(Map<String, Object> parmMap) throws Exception{
		try {  
			if(parmMap.get("regState") != null && !parmMap.get("regState").equals("")){
				parmMap.put("regStates", parmMap.get("regState").toString().split(","));
			}
			return pubOpanoMalyMapper.selectOpanaMalyCountForSyn(parmMap);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("exception {}", "异常查询 统计失败!");
			throw new BusinessException("异常查询 统计失败!");
		}
	}

	/**
	 * 
	 * 描述: 批量列入列表查询
	 * @auther gaojinling
	 * @date 2017年6月13日 
	 * @param map
	 * @return
	 */
	public List<PubOpanoMalyDto> selectBatchInList(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubOpanoMalyMapper.selectBatchInList(request.getParams());
	}
	
	/**
	 * 
	 * 描述: 批量列入（单页）
	 * @auther gaojinling
	 * @date 2017年6月16日 
	 * @return
	 * @throws Exception
	 */
	public int batchInsertIn(PubOpanoMaly pubOpanoMaly) throws Exception{
	   if(pubOpanoMaly != null && StringUtil.isNotBlank(pubOpanoMaly.getPriPID())){
		   int res = 0;
		   int count = 1;
		   String[] pripids = pubOpanoMaly.getPriPID().split(",");
		   String penDecNo = pubOpanoMaly.getPenDecNo();
		   for(String priPID : pripids){ //循环列入
		         //查询在册企业
		         MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
		         //若在册灭有  查询 所有状态企业
		         if(midBaseInfo == null ){
		        	 midBaseInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID) ;
 		         }
		           //设置文号
		           pubOpanoMaly.setPenDecNo(penDecNo+"-"+count);
				   pubOpanoMaly.setFirstdate(new Date());
				   pubOpanoMaly.setAuditDate(new Date());
				   pubOpanoMaly.setCreateTime(new Date());
				   //设置列入时间
				   pubOpanoMaly.setAbnTime(DateUtil.getAllDate(pubOpanoMaly.getAbnTime()));
				   //设置列入年份
				   pubOpanoMaly.setSeqYear(Integer.parseInt((DateUtil.getCurrentYear())));
				   pubOpanoMaly.setPriPID(priPID);
				   pubOpanoMaly.setEntName(midBaseInfo.getEntName());
				   pubOpanoMaly.setRegNO(midBaseInfo.getRegNO());
				   pubOpanoMaly.setUniSCID(midBaseInfo.getUniCode());
				   pubOpanoMaly.setLeRep(midBaseInfo.getLeRep());
				   pubOpanoMaly.setCerType("10");
				   pubOpanoMaly.setLocalAdm(midBaseInfo.getLocalAdm());
				   pubOpanoMaly.setEstDate(midBaseInfo.getEstDate());
				   pubOpanoMaly.setRegState(midBaseInfo.getRegState());
				   res = res + pubOpanoMalyMapper.insert(pubOpanoMaly);
				   count++;
		   }
           return res;
	   }
		return 0;
	}
	
	/**
	 * 
	 * 描述: 批量列入
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param map
	 * @throws Exception
	 */
	public void insertIntoPubopaNomalyInALl(Map<String, Object> map) throws Exception{
		map.put("regState", RegStateEnum.CUNXU.getParam());
		pubOpanoMalyMapper.insertIntoPubopaNomalyInALl(map);
	}
	
	/**
	 * 
	 * 描述: 利用批列入文号查询该文号下的企业
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param penDecNo
	 * @return
	 * @throws Exception
	 */
	public List<PubOpanoMalyDto> selectBatchInListByPenDecNo(String penDecNo) throws Exception{
		if(StringUtil.isNotBlank(penDecNo)){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("penDecNo", penDecNo);
			return pubOpanoMalyMapper.selectBatchInListByPenDecNo(map);
		}else{
			return new ArrayList<PubOpanoMalyDto>();
		}

	}
	
	/**
	 * 描述: 列入总数
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyTotalAll(Map<String, Object> dataParmMap) throws Exception{
		if(dataParmMap.isEmpty()){
			return null;
		}else{
			dataParmMap.remove("busExcList");
			dataParmMap.remove("priPID");
			return pubOpanoMalyMapper.selectOpanoMalyTotalAll(dataParmMap);
		}
	}
    
	/**
	 * 描述: 未移出
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyNoOutTotal(Map<String, Object> dataParmMap) throws Exception{
		if(dataParmMap.isEmpty()){
			return null;
		}else{
			dataParmMap.remove("busExcList");
			dataParmMap.remove("priPID");
			return pubOpanoMalyMapper.selectOpanoMalyNoOutTotal(dataParmMap);
		}
	}
     
	/**
	 * 描述: 移出
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyOutTotal(Map<String, Object> dataParmMap) throws Exception{
		if(dataParmMap.isEmpty()){
			return null;
		}else{
			dataParmMap.remove("busExcList");
			dataParmMap.remove("priPID");
			return pubOpanoMalyMapper.selectOpanoMalyOutTotal(dataParmMap);
		}
	}
   
	/**
	 * 描述: 撤销
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyRevokeTotal(Map<String, Object> dataParmMap) throws Exception{
		if(dataParmMap.isEmpty()){
			return null;
		}else{
			dataParmMap.remove("busExcList");
			dataParmMap.remove("priPID");
			return pubOpanoMalyMapper.selectOpanoMalyRevokeTotal(dataParmMap);
		}
	}

	/**
	 * 描述：查询所有数据
	 * @return
     */
	public List<PubOpanoMaly> selectFindAll(){
		return pubOpanoMalyMapper.selectAll();
	}
	
	
	/**
	 * 
	 * 描述   根据主体身份代码查询已经审核通过，不管是否移出，但不包括撤销
	 * @author  赵祥江
	 * @date 2017年7月5日 下午8:07:46 
	 * @param  
	 * @throws
	 */
	@Override
	public List<PubOpanoMaly> selectOpanoMalyByPripId(String pripId)
			throws Exception {
		Example example = new Example(PubOpanoMaly.class);
		example.createCriteria().andEqualTo("auditState", "1")
		.andEqualTo("priPID", pripId)
		.andIsNull("revokeFlag"); 
		example.orderBy("abnTime").desc(); 
		return pubOpanoMalyMapper.selectByExample(example);
	}

	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -根据企业名称和信用代码获取异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:06:25 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@Override
	public JSONObject getOpanoMalyList(String keyword, String secretkey,
			int pageNo, int pageSize,String searchType) throws Exception {
		JSONObject jsonObject = new JSONObject();
		PageRequest request=new PageRequest();
		List<Object> jsonObjList = new ArrayList<Object>();
		try {
			//校验口令
			if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			if(StringUtil.isBlank(searchType)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "入参查询类型不能为空");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			Map<String, Object> searchMap = new HashMap<String, Object>();
			request.setParams(searchMap);
			request.setLength(11);
			request.setPageNum(0);
			request.setStart(0);
			searchMap.put("cidRegNOEntName",keyword);
			//经营期限时查询存续企业
			if("2".equals(searchType)){
				searchMap.put("regState", RegStateEnum.CUNXU.getParam());
			}  
			Page<PanoramaResultDto> panoramaResultDtoList = panoramaSearchService.doGetSearchList(request); 
			if(panoramaResultDtoList!=null&&panoramaResultDtoList.size()>0){ 
				//排序
				panoramaResultDtoList=sortPanoramaResultDtoList(panoramaResultDtoList, searchType); 
				for(PanoramaResultDto panoramaResultDto:panoramaResultDtoList){
					   if(jsonObjList.size()==10){
							break;
					   } 
					   int moveInCount=0;
					   int moveOutCount=0; 
					   Map<String, Object> objMap = new HashMap<String, Object>();
					   String priPID= panoramaResultDto.getPriPID();
					   String entTypeCatg= panoramaResultDto.getEntTypeCatg();
					   String regState=panoramaResultDto.getRegState();
					   if("1".equals(searchType)){//异常
							if("50".equals(entTypeCatg)){//个体户
								List<PubPbopanomalyDto> pubPbopanomalyDtoList=  pubPbopanomalyService.selectMoveInPubPbopanomalyPriPID(priPID);
								moveInCount=pubPbopanomalyDtoList.size(); 
								List<PubPbOpadetailDto> pubPbOpadetailDtoList= pubPbOpadetailService.selectPubPbOpadetailByPriPID(priPID);
								moveOutCount=pubPbOpadetailDtoList.size();
							}else{
								List<PubOpanoMaly> pubOpanoMalyList= this.selectOpanoMalyByPripId(priPID);
								moveInCount=pubOpanoMalyList.size(); 
								List<PubOpaDetail> pubOpaDetailList= pubOpaDetailService.selectPubOpaDetailBypriPIDAndIsMove(priPID, "1");
								moveOutCount=pubOpaDetailList.size();
							} 
							//列入条数
							objMap.put("moveInCount",moveInCount); 
							//移出条数
							objMap.put("moveOutCount",moveOutCount); 
					   }else if("2".equals(searchType)){//经营期限
						   //期限到期日 
						String opTo = StringUtil.isBlank(panoramaResultDto
								.getOpTo())
								|| "null".equals(panoramaResultDto.getOpTo())
								|| "-".equals(panoramaResultDto.getOpTo()) ? "9999-09-09"
								: panoramaResultDto.getOpTo();
						   objMap.put("opToDate",opTo); 
					   } 
					   CodeRegState codeRegState=codeRegStateService.selectCsStateDesc(StringUtil.isBlank(regState)?"000":regState);
					   // 企业名称
					   objMap.put("entName", panoramaResultDto.getEntName()==null?"":panoramaResultDto.getEntName());
						// 统一社会信用代码
					   objMap.put("uniCode",  StringUtil.isBlank(panoramaResultDto.getUniscid())?panoramaResultDto.getRegNO():panoramaResultDto.getUniscid());
					    //主体身份代码
					   objMap.put("priPID",priPID ); 
					    //企业状态
					   objMap.put("regStateCn",codeRegState==null||codeRegState.getCsStateDesc()==null?"":codeRegState.getCsStateDesc()); 
					   jsonObjList.add(objMap);
				} 
			} 
			jsonObject.put("totalCount", panoramaResultDtoList==null?"0":panoramaResultDtoList.size()); 
			jsonObject.put("resultList", JSONArray.fromObject(jsonObjList)); 
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"),e);
		}
		return jsonObject;
	} 
	
	
	/**
	 * 
	 * 描述   根据类型排序
	 * @author 赵祥江
	 * @date 2017年10月16日 上午10:40:31 
	 * @param 
	 * @return Page<PanoramaResultDto>
	 * @throws
	 */
	private Page<PanoramaResultDto> sortPanoramaResultDtoList(Page<PanoramaResultDto> PanoramaResultDtoList,String  searchType){
		Page<PanoramaResultDto> panoramaResultDtoAllList=new Page<PanoramaResultDto>();
		Page<PanoramaResultDto> panoramaResultDtoTemOneList=new Page<PanoramaResultDto>(); 
		Page<PanoramaResultDto> panoramaResultDtoTemTwo=new Page<PanoramaResultDto>();
		for(PanoramaResultDto panoramaResultDto:PanoramaResultDtoList){
			if("1".equals(searchType)){//异常
				String reReate=panoramaResultDto.getRegState();
				if(RegStateEnum.CUNXU.getCode().contains(reReate)){
					panoramaResultDtoAllList.add(panoramaResultDto);
				}else{
					panoramaResultDtoTemOneList.add(panoramaResultDto);
				}
			}else if("2".equals(searchType)){//经营期限 
				   //期限到期日 
				String opToDate = StringUtil.isBlank(panoramaResultDto
						.getOpTo())
						|| "null".equals(panoramaResultDto.getOpTo())
						|| "-".equals(panoramaResultDto.getOpTo()) ? "9999-09-09"
						: panoramaResultDto.getOpTo();
				
				String nowDate=DateUtil.getSysDate()==null?"":DateUtil.formatDate(DateUtil.getSysDate(), "yyyy-MM-dd");
				int days=DateUtil.getBetweenDays(nowDate, opToDate);  
				//长期有效
				if("9999-09-09".equals(opToDate)||days>=30){
					panoramaResultDtoTemTwo.add(panoramaResultDto);
				}else  if(days>=0&&days<30){//即将到期
					panoramaResultDtoTemOneList.add(panoramaResultDto);
				}else  if(days<0){//已到期
					panoramaResultDtoAllList.add(panoramaResultDto);
				}
			}
		} 
		//查询异常存续企业排在前面
		if("1".equals(searchType)&&panoramaResultDtoTemOneList.size()>0){ 
				panoramaResultDtoAllList.addAll(panoramaResultDtoTemOneList); 
		}else if("2".equals(searchType)){ //经营期限查询  已到期>即将到期>正常经营期限内
			if(panoramaResultDtoTemOneList.size()>0){
				panoramaResultDtoAllList.addAll(panoramaResultDtoTemOneList);
			}
			if(panoramaResultDtoTemTwo.size()>0){
				panoramaResultDtoAllList.addAll(panoramaResultDtoTemTwo);
			}
		} 
		return panoramaResultDtoAllList;
	}
	

	/**
	 * 
	 * 描述   企信连联 专项查询 异常 -根据主体身份代码查询异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:07:49 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@Override
	public JSONObject getOpanoMalyListByPriPID(String priPID, String secretkey)
			throws Exception { 
		JSONObject jsonObject = new JSONObject();
		List<Object> moveInList = new ArrayList<Object>();
		List<Object> moveOutList = new ArrayList<Object>();
		try {
			//校验口令
			if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			if(StringUtil.isBlank(priPID)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "企业主体身份代码不能为空");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			
			//企业基本信息
			List<MidBaseInfoDto> midBaseInfoDtoList=  midBaseInfoService.doGetListByPriPID(priPID);
			MidBaseInfoDto midBaseInfoDto=new MidBaseInfoDto();
			if(midBaseInfoDtoList!=null&&midBaseInfoDtoList.size()>0){
				midBaseInfoDto=midBaseInfoDtoList.get(0);
				CodeRegState codeRegState=codeRegStateService.selectCsStateDesc(StringUtil.isBlank(midBaseInfoDto.getRegState())?"000":midBaseInfoDto.getRegState());
				//企业类型
				String  entTypeCatg=midBaseInfoDto.getEntTypeCatg();
				if("50".equals(entTypeCatg)){//个体户
					List<PubPbopanomalyDto>  pubPbopanomalyDtoList=	pubPbopanomalyService.selectMoveInPubPbopanomalyPriPID(priPID);
					if(pubPbopanomalyDtoList!=null&&pubPbopanomalyDtoList.size()>0){ 
						for(PubPbopanomalyDto pubPbopanomalyDto:pubPbopanomalyDtoList){
							try {
								Map<String, Object> objMapIn = new HashMap<String, Object>(); 
								// 企业名称
								objMapIn.put("entName", pubPbopanomalyDto.getEntName()==null?"":pubPbopanomalyDto.getEntName()); 
								//列入原因
								objMapIn.put("speCauseCN", pubPbopanomalyDto.getExcpStaResCN()==null?"":pubPbopanomalyDto.getExcpStaResCN());
								//企业状态
								objMapIn.put("regStateCn",codeRegState==null||StringUtil.isBlank(codeRegState.getCsStateDesc())?"":codeRegState.getCsStateDesc()); 
								//列入文号
								objMapIn.put("moveInpenDecNo",""); 
								//列入日期 
								objMapIn.put("abnTime",pubPbopanomalyDto.getCogDate()==null?"":DateUtil.formatDate(pubPbopanomalyDto.getCogDate(), "yyyy年MM月dd日"));
								//列入机关
								objMapIn.put("decorgCN",pubPbopanomalyDto.getDecorgCN()==null?"":pubPbopanomalyDto.getDecorgCN());
								//是否届满三年 1 是  不等于1标识不是
								//objMapIn.put("isMoveInThreeFlag","0"); 
								moveInList.add(objMapIn); 
							} catch (Exception e) {
								e.printStackTrace();
								continue;
							}
						}
						//移出
						List<PubPbOpadetailDto> pubPbOpadetailDtoList=  pubPbOpadetailService.selectPubPbOpadetailByPriPID(priPID);
						if(pubPbOpadetailDtoList!=null&&pubPbOpadetailDtoList.size()>0){
							for(PubPbOpadetailDto pubPbOpadetailDto: pubPbOpadetailDtoList){
								try {
									if("1".equals(pubPbOpadetailDto.getAuditState())&&"1".equals(pubPbOpadetailDto.getRecoveryType())){
										PubPbopanomalyDto  pubPbopanomalyDto =pubPbopanomalyService.selectPubPbopanomalyDtoByBusExcList(pubPbOpadetailDto.getBusExcList());
										Map<String, Object> objMapOut = new HashMap<String, Object>();
										objMapOut.put("entName", pubPbopanomalyDto.getEntName());
										objMapOut.put("speCauseCN",  pubPbopanomalyDto.getExcpStaResCN()==null?"":pubPbopanomalyDto.getExcpStaResCN());
										objMapOut.put("regStateCn",codeRegState==null||StringUtil.isBlank(codeRegState.getCsStateDesc())?"":codeRegState.getCsStateDesc());
										objMapOut.put("moveInpenDecNo", "");
										objMapOut.put("abnTime",pubPbopanomalyDto.getCogDate()==null?"":DateUtil.formatDate(pubPbopanomalyDto.getCogDate(), "yyyy年MM月dd日"));
										objMapOut.put("decorgCN",pubPbopanomalyDto.getDecorgCN()==null?"":pubPbopanomalyDto.getDecorgCN()); 
										//移出原因
										objMapOut.put("remExcpresCN",pubPbOpadetailDto.getNorReaCN()==null?"":pubPbOpadetailDto.getNorReaCN()); 
										//移出文号
										objMapOut.put("moveOutpenDecNo","");
										//移出日期 
										objMapOut.put("remDate",pubPbOpadetailDto.getNorDate()==null?"":DateUtil.formatDate(pubPbOpadetailDto.getNorDate(), "yyyy年MM月dd日"));
										//移出机关
										objMapOut.put("reDecOrgCN",pubPbOpadetailDto.getNorDecOrgCN()==null?"":pubPbOpadetailDto.getNorDecOrgCN());
										moveOutList.add(objMapOut);
									}
								} catch (Exception e) {
									e.printStackTrace();
									continue;
								}
							}
						}
					}
				}else{//企业、农专
					//查询在异常内的异常信息  
					List<PubOpanoMaly>  pubOpanoMalyList=selectOpanoMalyByPripId(priPID); 
					if(pubOpanoMalyList!=null&&pubOpanoMalyList.size()>0){  
						for(PubOpanoMaly pubOpanoMaly: pubOpanoMalyList){
							try { 
								Map<String, Object> objMapIn = new HashMap<String, Object>();
								// 企业名称
								objMapIn.put("entName", pubOpanoMaly.getEntName()==null?"":pubOpanoMaly.getEntName()); 
								//列入原因
								objMapIn.put("speCauseCN", pubOpanoMaly.getSpeCauseCN()==null?"":pubOpanoMaly.getSpeCauseCN());
								//企业状态
								objMapIn.put("regStateCn",codeRegState==null||StringUtil.isBlank(codeRegState.getCsStateDesc())?"":codeRegState.getCsStateDesc()); 
								//列入文号
								objMapIn.put("moveInpenDecNo",pubOpanoMaly.getPenDecNo()==null?"0":pubOpanoMaly.getPenDecNo()); 
								//列入日期 
								objMapIn.put("abnTime",pubOpanoMaly.getAbnTime()==null?"":DateUtil.formatDate(pubOpanoMaly.getAbnTime(), "yyyy年MM月dd日"));
								//列入机关
								objMapIn.put("decorgCN",pubOpanoMaly.getDecorgCN()==null?"":pubOpanoMaly.getDecorgCN()); 
								//是否届满三年 1 是  不等于1标识不是
								//objMapIn.put("isMoveInThreeFlag","0"); 
								moveInList.add(objMapIn);  
							} catch (Exception e) {
								e.printStackTrace();
								continue;
							}
						}
					}
					//查询移出记录
					List<PubOpaDetail> pubOpaDetailList=  pubOpaDetailService.selectByPriPID(priPID);
					if(pubOpaDetailList!=null&&pubOpaDetailList.size()>0){
						for(PubOpaDetail pubOpaDetail:pubOpaDetailList){
							try {
								Map<String, Object> objMapOut = new HashMap<String, Object>();
								//已移出
								if("1".equals(pubOpaDetail.getAuditState())&&"1".equals(pubOpaDetail.getIsMove())){
									PubOpanoMaly pubOpanoMaly =this.selectPubOpanoMalyByBusExcList(pubOpaDetail.getBusExcList());
									objMapOut.put("entName", pubOpanoMaly.getEntName()==null?"":pubOpanoMaly.getEntName());
									objMapOut.put("speCauseCN", pubOpanoMaly.getSpeCauseCN()==null?"":pubOpanoMaly.getSpeCauseCN());
									objMapOut.put("regStateCn",codeRegState==null||StringUtil.isBlank(codeRegState.getCsStateDesc())?"":codeRegState.getCsStateDesc());
									objMapOut.put("moveInpenDecNo",pubOpanoMaly.getPenDecNo()==null?"0":pubOpanoMaly.getPenDecNo());
									objMapOut.put("abnTime",pubOpanoMaly.getAbnTime()==null?"":DateUtil.formatDate(pubOpanoMaly.getAbnTime(), "yyyy年MM月dd日"));
									objMapOut.put("decorgCN",pubOpanoMaly.getDecorgCN()==null?"":pubOpanoMaly.getDecorgCN()); 
									//移出原因
									objMapOut.put("remExcpresCN",pubOpaDetail.getRemExcpresCN()==null?"":pubOpaDetail.getRemExcpresCN()); 
									//移出文号
									objMapOut.put("moveOutpenDecNo",pubOpaDetail.getPenDecNo()==null?"":pubOpaDetail.getPenDecNo());
									//移出日期 
									objMapOut.put("remDate",pubOpaDetail.getRemDate()==null?"":DateUtil.formatDate(pubOpaDetail.getRemDate(), "yyyy年MM月dd日"));
									//移出机关
									objMapOut.put("reDecOrgCN",pubOpaDetail.getReDecOrgCN()==null?"":pubOpaDetail.getReDecOrgCN());
									moveOutList.add(objMapOut);
								}
							} catch (Exception e) {
								e.printStackTrace();
								continue;
							}
						}
					} 
				} 
			} 
			jsonObject.put("moveInList", JSONArray.fromObject(moveInList)); 
			jsonObject.put("moveOutList", JSONArray.fromObject(moveOutList)); 
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"),e);
		}
		return jsonObject;
	}

	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -根据手机号码查询联络员旗下企业的异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:09:10 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	@Override
	public JSONObject getOpanoMalyListByTel(String tel,String keyword, String secretkey)
			throws Exception {
		JSONObject jsonObject = new JSONObject();
		List<Object> jsonObjList = new ArrayList<Object>();
		try {
			//校验口令
			if(StringUtil.isBlank(secretkey)||!secretkey.equals(key)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "访问接口口令验证不通过");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			//校验参数
			if(StringUtil.isBlank(tel)){
				jsonObject.put("responseCode", "0");
				jsonObject.put("responseMessage", "联络员电话号码不能为空");
				logger.error(jsonObject.getString("responseMessage"));
				return jsonObject;
			}
			Map<String, Object> searchMap = new HashMap<String, Object>();
//			pageNo = StringUtil.isBlank(String.valueOf(pageNo)) ? 1:pageNo; // 默认为0
//			pageSize = StringUtil.isBlank(String.valueOf(pageSize)) ? 10:pageSize; // 默认为 10条每页
			searchMap.put("numStart", 0);
			searchMap.put("pageSize", 99999);
			searchMap.put("keyword",keyword);
			searchMap.put("tel",tel);
			//获取联络员旗下异常信息
			List<PubOpanoMalyDto> pubOpanoMalyDtoList=  pubOpanoMalyMapper.selectOpanoMalyListByTel(searchMap);
			if(pubOpanoMalyDtoList!=null&&pubOpanoMalyDtoList.size()>0){
				for(PubOpanoMalyDto pubOpanoMalyDto: pubOpanoMalyDtoList){
					Map<String, Object> objMap = new HashMap<String, Object>();
					// 企业名称
					objMap.put("entName", pubOpanoMalyDto.getEntName()==null?"":pubOpanoMalyDto.getEntName());
					// 统一社会信用代码
					objMap.put("uniCode", pubOpanoMalyDto.getUniSCID());
					//企业状态
					objMap.put("regStateCn",pubOpanoMalyDto.getRegState()==null?"0":pubOpanoMalyDto.getRegState());
					String isMove= pubOpanoMalyDto.getIsMove();
					//列入
					if("2".equals(isMove)){
						objMap.put("antMsg",pubOpanoMalyDto.getAbnTime()==null?"":DateUtil.formatDate(pubOpanoMalyDto.getAbnTime(), "yyyy年MM月dd日")+"列入经营异常");
					}else {//移出
						objMap.put("antMsg",pubOpanoMalyDto.getAbnTime()==null?"":DateUtil.formatDate(pubOpanoMalyDto.getAbnTime(), "yyyy年MM月dd日")+"移出经营异常");
					}
					objMap.put("isMove", isMove);
					//主体身份代码
					objMap.put("priPID",pubOpanoMalyDto.getPriPID()==null?"":pubOpanoMalyDto.getPriPID()); 
					 
					jsonObjList.add(objMap);
				}
			}
			jsonObject.put("totalCount", pubOpanoMalyDtoList==null?"0":pubOpanoMalyDtoList.size()); 
			jsonObject.put("resultList", JSONArray.fromObject(jsonObjList)); 
			jsonObject.put("responseCode", "1");
			jsonObject.put("responseMessage", "查询成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("responseCode", "0");
			jsonObject.put("responseMessage", "系统异常");
			logger.error(jsonObject.getString("responseMessage"),e);
		}
		return jsonObject;
	}

	@Override
	public int notFoundAltNum(Map<String, Object> qryMap) {
		return pubOpanoMalyMapper.notFoundAltNum(qryMap);
	}

	@Override
	public int notFoundYcNum(Map<String, Object> qryMap) {
		return pubOpanoMalyMapper.notFoundYcNum(qryMap);
	}

	@Override
	public int opanomalySoonThreeYear(Map<String, Object> qryMap) {
		return pubOpanoMalyMapper.opanomalySoonThreeYear(qryMap);
	}

	/**
	 * 
	 * 描述   查询企业查无下落原因的最大列入日期
	 * @author  赵祥江
	 * @date 2017年11月6日 下午5:44:44 
	 * @param  
	 * @throws
	 */
	@Override
	public PubOpanoMalyDto selectMaxAbnTimePubOpanoMalyByPriPID(String priPID,String entTypeCatg,String speCause)
			throws Exception {
		 Map<String,Object> qMap=new HashMap<String,Object>();
		 qMap.put("priPID", priPID);
		 qMap.put("entTypeCatg", entTypeCatg);
		 qMap.put("speCause", speCause);
 		return pubOpanoMalyMapper.selectMaxAbnTimePubOpanoMalyByPriPID(qMap);
	}
}