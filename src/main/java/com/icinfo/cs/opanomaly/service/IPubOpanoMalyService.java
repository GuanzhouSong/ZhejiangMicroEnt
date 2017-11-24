/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.opanomaly.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_opanomaly 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
public interface IPubOpanoMalyService extends BaseService {
	
	/**
	 * 
	 * 描述   保存异常信息
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:02:32 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertPubOpanoMaly(PubOpanoMaly pubOpanoMaly) throws Exception;

	/**
	 * 
	 * 描述   根据主键busExcList删除异常信息
	 * @author 赵祥江
	 * @date 2016年10月11日 上午10:04:30 
	 * @param 
	 * @return int
	 * @throws
	 */
    public int deletePubOpanoMalyByBusExcList(String busExcList)throws Exception;

    /**
     * 
     * 描述   修改
     * @author 赵祥江
     * @date 2016年10月11日 上午10:05:54 
     * @param 
     * @return int
     * @throws
     */
    public int updatePubOpanoMaly(PubOpanoMaly pubOpanoMaly)throws Exception;

    /**
     * 
     * 描述   根据主键BusExcList查询异常对象
     * @author 赵祥江
     * @date 2016年10月11日 上午10:06:50 
     * @param 
     * @return PubOpanoMaly
     * @throws
     */
    public PubOpanoMaly selectPubOpanoMalyByBusExcList(String busExcList)throws Exception;
    
    /**
     * 
     * 描述   分页查询已经列入未撤销移出的异常列表
     * @author 赵祥江
     * @date 2016年10月11日 上午11:02:33 
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
    public List<PubOpanoMalyDto> queryPubOpanoMalyList(PageRequest request)throws Exception;
    
    /**
     * 
     * 描述   
     * @author ylr
     * @date 2016年10月11日 上午11:02:33 
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
    public Integer getPubOpanoMalyTotal(Map<String, Object> qryMap)throws Exception;
    
    /**
     * 
     * 描述   根据登记机关获取文号数字
     * @author 赵祥江
     * @date 2016年10月13日 下午7:06:56 
     * @param 
     * @return BigDecimal
     * @throws
     */
    public Integer selectPenDecNoByRegOrg (String regOrg) throws Exception;
    
    /**
     * 
     * 描述   列入申请和列入列表 查询分页条数
     * @author 赵祥江
     * @date 2016年12月16日 上午10:10:26 
     * @param 
     * @return Integer
     * @throws
     */
    public Integer selectPubOpanoMalyListCount (Map<String,Object> queryMap) throws Exception;
    
    
    /**
     * 
     * 描述   异常查询 分页条数
     * @author 赵祥江
     * @date 2016年12月16日 上午9:22:03 
     * @param 
     * @return Integer
     * @throws
     */
    public Integer selectPubOpanoMalySearchCount (Map<String,Object> queryMap) throws Exception;
    
    
    
    /**
     * 
     * 描述   
     * @author 赵祥江
     * @date 2016年10月11日 下午2:36:15 
     * @param 
     * @return List<MidBaseInfoDto>
     * @throws
     */
    public List<MidBaseInfoDto> queryMidBasePubOpanoMalyList(PageRequest request)throws Exception;
    
    
    /**
     * 
     * 描述   异常名录查询
     * @author 赵祥江
     * @date 2016年10月26日 下午2:48:37 
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
    public List<PubOpanoMalyDto> selectPubOpanoMalySearchList (PageRequest request)throws Exception;
    
    
    /**
	 * 
	 * 描述   统计已移出的企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:03 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectIsInAndIsOutCount(Map<String,Object> queryMap);
	
	
	/**
	 * 
	 * 描述   统计列入未移出企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:08 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectIsInAndNotOutCount(Map<String,Object> queryMap);
	
	
	/**
	 * 
	 * 描述   统计已公示企业多少家
	 * @author 赵祥江
	 * @date 2016年10月26日 下午4:22:13 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectIsPubCount(Map<String,Object> queryMap);
    
    /**
	 * 
	 * 描述   根据公司id查询异常名录
	 * @author chenyu
	 * @date 2016年10月26日 下午2:41:50 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalyListBypriPID(PageRequest request);
	
	/** 
	 * 描述: 纳入/移出经营异常名录信息（公示单个企业展示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param request
	 * @return 
	 */
	public List<PubOpanoMalyDto> queryPubOpanoMalyListForPub(PageRequest request) throws Exception;

    String getEntForDatajoinJSON_downednum(Map param);

    /** 
	 * 描述: 生成列入，列出公告数据
	 * @auther yujingwei
	 * @date 2016年12月8日 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 */
	public List<PubOpanoMalyDto> queryPubOpanoMalyListForNotice(String updateDate) throws Exception;

    List<PubOpanoMalyDto> selectPubOpanoMalyList_Fordatain(PageRequest request);
    
	/** 
	 * 描述: 根据自然人身份证获取列表 
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return 
	 */
	
    public List<PubOpanoMaly> selectListByCerNO(PageRequest request);

    /**
	 * 描述：根据pripid查询列入经营异常名录信息
	 * @date 2017年4月19日 
	 * @auther baifangfang
	 * @param priPID
	 * @return
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalyServicePriPID(String priPID);
    
	 /**
     * 描述   经营异常查询（全景）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  request
     * @return List<PubOpanoMalyDto>
     * @throws Exception
     */
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchList(PageRequest request) throws Exception;
    
	 /**
     * 描述   经营异常查询个数（全景）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  queryMap
     * @return Integer
     * @throws Exception
     */
	public Integer selectPubOpanoMalyNewSearchCount(Map<String, Object> queryMap) throws Exception;
	
	/**
     * 描述   经营异常记录查询（经营异常管理）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  request
     * @return List<PubOpanoMalyDto>
     * @throws Exception
     */
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchHisList(PageRequest request) throws Exception;
    
	 /**
     * 描述   经营异常记录查询个数（经营异常管理）
     * @author yujingwei
     * @date 2017年06月13日 
     * @param  queryMap
     * @return Integer
     * @throws Exception
     */
	public Integer selectPubOpanoMalyNewSearchHisCount(Map<String, Object> queryMap) throws Exception;
    
	/**
	 * 描述: 经营异常名录查询统计（全景）
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public List<PubOpanoMalyDto> doGetOpanaMalyCountForSyn(Map<String, Object> parmMap) throws Exception;
	
	/**
	 * 
	 * 描述: 批量列入列表查询
	 * @auther gaojinling
	 * @date 2017年6月13日 
	 * @param map
	 * @return
	 */
	public List<PubOpanoMalyDto> selectBatchInList(PageRequest request) throws Exception;
	
	/**
	 * 
	 * 描述: 批量列入（单页）
	 * @auther gaojinling
	 * @date 2017年6月16日 
	 * @return
	 * @throws Exception
	 */
	public int batchInsertIn(PubOpanoMaly pubOpanoMaly) throws Exception;
	
	/**
	 * 
	 * 描述: 批量列入(全部列入)
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param map
	 * @throws Exception
	 */
	public void insertIntoPubopaNomalyInALl(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * 描述: 利用批列入文号查询该文号下的企业
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param penDecNo
	 * @return
	 * @throws Exception
	 */
	public List<PubOpanoMalyDto> selectBatchInListByPenDecNo(String penDecNo) throws Exception;
    
	/**
	 * 描述: 列入总数
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyTotalAll(Map<String, Object> dataParmMap) throws Exception;
    
	/**
	 * 描述: 未移出
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyNoOutTotal(Map<String, Object> dataParmMap) throws Exception;
    
	/**
	 * 描述: 移出
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyOutTotal(Map<String, Object> dataParmMap) throws Exception;
    
	/**
	 * 描述: 撤销
	 * @auther yujingwei
	 * @date 2017年6月19日
	 * @return view
	 * @throws Exception
	 */
	public PubOpanoMalyDto selectOpanoMalyRevokeTotal(Map<String, Object> dataParmMap) throws Exception;

	/**
	 * 描述：查询表中所有数据
	 * @return
     */
	public List<PubOpanoMaly> selectFindAll();
	
	
 	/**
	 * 
	 * 描述   根据主体身份代码查询已经审核通过，不管是否移出，但不包括撤销
	 * @author 赵祥江
	 * @date 2017年7月5日 下午8:05:58 
	 * @param 
	 * @return List<PubOpanoMaly>
	 * @throws
	 */
	public List<PubOpanoMaly> selectOpanoMalyByPripId(String  pripId) throws Exception;
	
	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -根据企业名称和信用代码获取异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:06:25 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject getOpanoMalyList(String keyword,String secretkey,
			int pageNo, int pageSize,String searchType) throws Exception ;
	
	/**
	 * 
	 * 描述   企信连联 专项查询 异常 -根据主体身份代码查询异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:07:49 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject getOpanoMalyListByPriPID(String priPID,String secretkey) throws Exception ;
	
	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -根据手机号码查询联络员旗下企业的异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:09:10 
	 * @param 
	 * @return JSONObject
	 * @throws
	 */
	public JSONObject getOpanoMalyListByTel(String tel,String keyword,String secretkey) throws Exception ;

	/**
	 * 描述：查无下落后变更
	 * @author baifangfang
	 * @date 2017年10月13日
	 * @param qryMap
	 * @return
	 */
	public int notFoundAltNum(Map<String, Object> qryMap);

	/**
	 * 描述：查无下落后年报
	 * @author Administrator
	 * @date 2017年10月13日
	 * @param qryMap
	 * @return
	 */
	public int notFoundYcNum(Map<String, Object> qryMap);

	/**
	 * 描述：经营异常满3年
	 * @author baifangfang
	 * @date 2017年10月13日
	 * @param qryMap
	 * @return
	 */
	public int opanomalySoonThreeYear(Map<String, Object> qryMap);
	
	
	/**
	 * 
	 * 描述   查询企业查无下落原因的最大列入日期
	 * @author 赵祥江
	 * @date 2017年11月6日 下午5:43:44 
	 * @param 
	 * @return  PubOpanoMalyDto 
	 * @throws
	 */
	public  PubOpanoMalyDto  selectMaxAbnTimePubOpanoMalyByPriPID(String  priPID,String entTypeCatg,String speCause) throws Exception;
	
}