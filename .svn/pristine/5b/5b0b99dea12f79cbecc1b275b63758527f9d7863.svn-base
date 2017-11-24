/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年10月11日
 * @version 2.0
 */
package com.icinfo.cs.opanomaly.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.nocreditPunish.dto.NoCreditPunishInfoDto;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    cs_pub_opanomaly 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年10月11日
 */
public interface PubOpanoMalyMapper extends Mapper<PubOpanoMaly> {
	/**
	 * 
	 * 描述   根据公司id查询异常名录
	 * @author chenyu
	 * @date 2016年10月26日 下午2:41:50 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	
	public List<PubOpanoMalyDto> selectPubOpanoMalyListByPriPID(Map<String, Object> searchMap);
	
	/**
	 * 
	 * 描述   查询已经列入未撤销移出的异常列表
	 * @author 赵祥江
	 * @date 2016年10月11日 上午11:05:28 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalyList(Map<String,Object> queryMap)throws Exception;

	/**
	 * 
	 * 描述   根据传入的类型查询 EntTypeFlag为0查询农专 EntTypeFlag为1查询企业
	 * @author 赵祥江
	 * @date 2016年10月11日 下午2:24:33 
	 * @param 
	 * @return List<MidBaseInfoDto>
	 * @throws
	 */
	public List<MidBaseInfoDto> selectMidBasePubOpanoMalyList(Map<String,Object> queryMap)throws Exception;

	/**
	 * 
	 * 描述   根据登记机关编码获取文号数字 
	 * @author 赵祥江
	 * @date 2016年10月13日 下午7:03:20 
	 * @param 
	 * @return BigDecimal
	 * @throws
	 */
	public Integer selectPenDecNoByRegOrg (Map<String,Object> queryMap);
	
	/**
	 * @param updateDate 
     * 
     * 描述   分页查询（企业端-公示）用于显示列入移出公告
     * @author chenxin
     * @date 2016-10-19
     * @param 
     * @return List<PubOpanoMalyDto>
     * @throws
     */
	public List<PubOpanoMalyDto> queryPubOpanoMalyListForNotice(String updateDate)throws Exception;
	
	/**
	 * 
	 * 描述   异常名录查询  
	 * @author 赵祥江
	 * @date 2016年10月26日 下午2:41:50 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalySearchList(Map<String,Object> queryMap)throws Exception;
	
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
     * 描述   列入申请和列入列表 查询分页条数
     * @author 赵祥江
     * @date 2016年12月16日 上午10:10:26 
     * @param 
     * @return Integer
     * @throws
     */
	public Integer  selectPubOpanoMalyListCount(Map<String,Object> queryMap); 
	
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
	 * 描述   异常查询分页条数
	 * @author 赵祥江
	 * @date 2016年12月16日 上午9:21:15 
	 * @param 
	 * @return Integer
	 * @throws
	 */
	public Integer  selectPubOpanoMalySearchCount(Map<String,Object> queryMap);
	
	
	/** 
	 * 描述: 纳入/移出经营异常名录信息（公示单个企业展示）
	 * @auther ZhouYan
	 * @date 2016年11月3日 
	 * @param queryMap
	 * @return
	 * @throws Exception 
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalyListForPub(Map<String,Object> queryMap)throws Exception;

	/** 
	 * 描述: 根据自然人身份证获取列表 
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param searchMap
	 * @return 
	 */
	
	List<PubOpanoMaly> selectListByCerNO(Map<String, Object> searchMap);

	/**
	 * 描述：根据pripid查询列入经营异常名录信息
	 * @date 2017年4月19日 
	 * @auther baifangfang
	 * @param priPID
	 * @return
	 */
	public List<PubOpanoMalyDto> selectPubOpanoMalyServicePriPID(Map<String, Object> map);
	
	NoCreditPunishInfoDto selectAllFullInfoList_downednum(Map<String, Object> params);

	PubOpanoMalyDto selectPubOpanoMalyList_downnum(Map<String, Object> params);

	List<PubOpanoMalyDto> selectPubOpanoMalyList_Fordatain(Map<String, Object> searchMap);
	
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchList(Map<String, Object> searchMap);
	
	public Integer selectPubOpanoMalyNewSearchCount(Map<String, Object> queryMap);
	
	public List<PubOpanoMalyDto> selectPubOpanoMalyNewSearchHisList(Map<String, Object> searchMap);

	public Integer selectPubOpanoMalyNewSearchHisCount(Map<String, Object> queryMap);
	
	public List<PubOpanoMalyDto> selectOpanaMalyCountForSyn(Map<String, Object> parmMap);
	
	public PubOpanoMalyDto selectOpanoMalyTotalAll(Map<String, Object> parmMap);

	public PubOpanoMalyDto selectOpanoMalyNoOutTotal(Map<String, Object> parmMap);

	public PubOpanoMalyDto selectOpanoMalyOutTotal(Map<String, Object> parmMap);

	public PubOpanoMalyDto selectOpanoMalyRevokeTotal(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述: 批量列入列表查询
	 * @auther gaojinling
	 * @date 2017年6月13日 
	 * @param map
	 * @return
	 */
	public List<PubOpanoMalyDto> selectBatchInList(Map<String, Object> map);
	
	/**
	 * 
	 * 描述:批量列入异常（全部）
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param map
	 */
	public void insertIntoPubopaNomalyInALl(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 利用批列入文号查询该文号下的企业
	 * @auther gaojinling
	 * @date 2017年6月19日 
	 * @param map
	 * @return
	 */
	public List<PubOpanoMalyDto> selectBatchInListByPenDecNo(Map<String, Object> map);
	
	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -根据主体身份代码查询异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:17:08 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	public List<PubOpanoMalyDto> selectOpanoMalyList(Map<String, Object> map);
	
	
	/**
	 * 
	 * 描述    企信连联 专项查询 异常 -查询联络员旗下企业的异常信息
	 * @author 赵祥江
	 * @date 2017年10月9日 下午3:17:08 
	 * @param 
	 * @return List<PubOpanoMalyDto>
	 * @throws
	 */
	public List<PubOpanoMalyDto> selectOpanoMalyListByTel(Map<String, Object> map);

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
	 * @author baifangfang
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
	 * @date 2017年11月6日 下午5:42:29 
	 * @param 
	 * @return PubOpanoMalyDto
	 * @throws
	 */
	public  PubOpanoMalyDto  selectMaxAbnTimePubOpanoMalyByPriPID(Map<String, Object> searchMap); 


}