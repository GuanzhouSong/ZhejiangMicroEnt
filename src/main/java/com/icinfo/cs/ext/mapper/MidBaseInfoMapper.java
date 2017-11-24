/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2016年08月29日
 * @version 2.0
 */
package com.icinfo.cs.ext.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述: cs_mid_baseinfo 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public interface MidBaseInfoMapper extends Mapper<MidBaseInfo> {

	/**
	 * 描述: 登录时按内部序号查询企业基本信息
	 *
	 * @param pripid
	 * @return
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 */
	MidBaseInfoDto selectMidBaseInfoByPripidForLogin(@Param("pripid") String pripid,
			@Param("systemType") String systemType, @Param("regState") String regState);

	/**
	 * 描述: 登录时按注册号、企业名称查询企业基本信息
	 *
	 * @param regno
	 * @param entname
	 * @return
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 */
	MidBaseInfoDto selectByRegnoAndEntname(@Param("regno") String regno, @Param("entname") String entname,
			@Param("systemType") String systemType, @Param("regState") String regState);

	/**
	 * 根据 统一信用代码或注册号查询企业内部序号
	 * 
	 * @author chenxin
	 * @date 2017-02-21
	 * @param regNOList
	 * @return
	 * @throws Exception
	 */
	List<String> selectPriPIDByRegno(Map<String, Object> map) throws Exception;

	/**
	 * 描述: 根据注册号（统一代码）或名称查询
	 *
	 * @param map
	 * @return
	 * @auther gaojinling
	 * @date 2016年8月29日
	 */
	List<MidBaseInfoDto> selectMidBaseinfoByRegNoAndName(Map<String, Object> map);

	/**
	 * 描述: 根据法人姓名和证件号码查询关联企业信息
	 *
	 * @param map
	 * @return
	 * @auther chenxin
	 * @date 2017年3月22日
	 */
	List<MidBaseInfoDto> selectMidBaseinfoBackList(Map<String, Object> map);

	/**
	 * 描述: 按内部序号查询企业基本信息
	 *
	 * @param pripid
	 * @return
	 * @auther liuhq
	 * @date 2016年9月18日
	 */
	MidBaseInfoDto selectMidBaseInfoByPripid(String pripid);

	/**
	 * 描述: 按内部序号查询企业基本信息
	 *
	 * @param pripid
	 * @return
	 * @auther liuhq
	 * @date 2016年9月18日
	 */
	MidBaseInfoDto selectMidBaseInfoByRegNOHold(@Param("regno") String regNO, @Param("regState") String regState);

	/**
	 * 描述: 查找登记机关与管辖单位所在机关不一致的企业（regOrgCode！= 管辖单位的父代码的前6位）
	 *
	 * @param qryMap
	 * @return
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月21日
	 */
	List<MidBaseInfoDto> selectMidbaseinfo4delegate(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述: 为企业设置委托
	 *
	 * @param priPID
	 *            主体身份代码
	 * @return 委托机关
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	void setDelegate(String priPID) throws Exception;

	/**
	 * 描述: 为企业取消委托
	 *
	 * @param priPID
	 *            主体身份代码
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	void cancleDelegate(String priPID) throws Exception;

	/**
	 * 描述: 根据一些条件查询个体户
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 * @auther ZhouJun
	 * @date 2016年10月10日
	 */
	List<MidBaseInfo> selectPbMidBaseinfoByManyConditions(Map<String, Object> qryMap) throws Exception;

	/**
	 * 查询经济户口销户记录list
	 *
	 * @param params
	 * @return
	 * @auther liuhq
	 */
	List<MidBaseInfoDto> yetLogoffQueryPage(Map<String, Object> params);

	/**
	 * 描述:查询企业基本信息
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 * @auther ZhouJun
	 * @date 2016年10月10日
	 */
	List<MidBaseInfo> selectMidInfo(Map<String, Object> params) throws Exception;

	/**
	 * 描述: 查询for行政增加
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 * @auther ljx
	 * @date 2016年11月3日
	 */
	List<MidBaseInfo> selectMidInfoForOtherAdd(Map<String, Object> params) throws Exception;

	/**
	 * 描述:行政指导新增页面查询基础表数据
	 *
	 * @param params
	 * @return
	 * @throws Exception
	 * @auther liuhq
	 */
	List<MidBaseInfo> midbaseinfoForGovuideAdd_querypage(Map<String, Object> params);

	/**
	 * 描述：根据企业名称查询企业基本信息
	 *
	 * @throws Exception
	 * @author ylr
	 * @date 2016-10-23
	 */
	MidBaseInfo selectEntByEntName(String entName);

	/**
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据
	 *
	 * @param
	 * @return List<MidBaseInfo>
	 * @throws @author
	 *             赵祥江
	 * @date 2016年10月24日 上午10:49:37
	 */
	List<MidBaseInfo> selectMidInfoByApprDate(Map<String, Object> params);

	/**
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据
	 *
	 * @param
	 * @return List<MidBaseInfo>
	 * @throws @author
	 *             赵祥江
	 * @date 2016年10月24日 上午10:49:37
	 */
	List<MidBaseInfo> selectMidInfoDzByApprDate(Map<String, Object> params);

	/**
	 * 描述 根据cerNo获取企业信息
	 *
	 * @param
	 * @return List<MidBaseInfo>
	 * @throws @author
	 *             陈宇
	 * @date 2016年10月24日 上午10:49:37
	 */
	List<MidBaseInfoDto> selectMidBaseInfoDtoListByCerNO(Map<String, Object> params);

	/**
	 * 描述: 按内部序号查询企业基本信息
	 *
	 * @param pripid
	 * @return
	 * @author zjj
	 */
	MidBaseInfoDto selectByPripid(String pripid);

	/**
	 * 查询id范围查询索引列表
	 *
	 * @return
	 * @author baifangfang
	 * @date 2016年11月9日
	 */
	List<MidBaseInfoDto> selectIndexListById(Map<String, Object> paramMap);

	/**
	 * 查询需要增量更新的总数量
	 *
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @return
	 */
	int doIncreCount();

	/**
	 * 增量查询数据列表
	 *
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @return
	 */
	List<MidBaseInfoDto> selectIndexIncreList(Map<String, Object> paramMap);

	/**
	 * 获取最大的id
	 *
	 * @return
	 * @author baifangfang
	 * @date 2016年12月5日
	 */
	int selectMaxId();

	/**
	 * 描述：根据企业名称或注册号或统一代码查询数据
	 *
	 * @param condition
	 * @return
	 * @date 2016年12月10日
	 * @author baifangfang
	 */
	List<MidBaseInfoDto> selectListByCondition(Map<String, Object> paramMap);

	/**
	 * 根据关键词查询企业基本信息
	 *
	 * @param paramMap
	 *            查询参数
	 * @return 企业信息
	 */
	List<MidBaseInfo> selectMidInfoByKeyword(Map<String, Object> paramMap);

	/**
	 * 查询需要更新的总数量
	 *
	 * @author baifangfang
	 * @date 2016年12月16日
	 * @param paramMap
	 * @return
	 */
	int doCountByApprDate(Map<String, Object> paramMap);

	/**
	 * 根据核准日期查询数据列表
	 *
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @return
	 */
	List<MidBaseInfoDto> selectIndexListByApprDate(Map<String, Object> paramMap);

	/**
	 * 描述：根据内部序号查询数据
	 *
	 * @param paramMap
	 * @return
	 * @date 2016年12月19日
	 * @author baifangfang
	 */
	List<MidBaseInfoDto> selectListByPriPID(Map<String, Object> paramMap);

	/**
	 * 描述：根据多内部序号查询数据
	 *
	 * @param paramMap
	 * @return
	 * @date 2016年12月22日
	 * @author ylr
	 */
	List<MidBaseInfoDto> selectMidBaseInfoListByPriPIDS(Map<String, Object> qryMap);

	/**
	 * 描述：根据内容序号查询吊销日期
	 * 
	 * @date 2017年3月23日
	 * @author yujingwei
	 * @param condition
	 * @return Date
	 */
	List<MidBaseInfoDto> selectPunishDate(String priPID);

	/**
	 * 描述: 根据法人姓名和证件号码查询关联企业信息
	 * 
	 * @auther baifangfang
	 * @date 2017年4月10日
	 * @param params
	 * @return
	 */
	List<MidBaseInfoDto> selectLimitObjRelEntList(Map<String, Object> params);

	/**
	 * 描述: 获取本企业受限对象列表
	 * 
	 * @auther baifangfang
	 * @date 2017年4月11日
	 * @param params
	 * @return
	 */
	List<MidBaseInfoDto> selectLimitRelEntObjList(Map<String, Object> params);

	/**
	 * 
	 * 描述: 新增批量列入经营异常记录列表（企业、农专）
	 * 
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param map
	 * @return
	 */
	List<MidBaseInfoDto> selectBatchPubOpanomalyInAddList(Map<String, Object> map);

	/**
	 * 描述：根据企业名称/统一社会信用代码查询企业信息
	 * 
	 * @author 陈鑫
	 * @date 2017-09-14
	 * @param parmMap
	 * @return
	 */
	List<MidBaseInfoDto> selectForDrandomByKeyword(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -根据企业名称和信用代码获取企业信息 @author 赵祥江 @date 2017年10月10日
	 * 上午11:13:29 @param @return List<MidBaseInfoDto> @throws
	 */
	List<MidBaseInfoDto> selectOperatingList(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -获取联络员旗下的企业信息 @author 赵祥江 @date 2017年10月10日
	 * 下午2:37:21 @param @return List<MidBaseInfoDto> @throws
	 */
	List<MidBaseInfoDto> selectOperatingListByTel(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述：经营期限即将到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param qryMap
	 * @return
	 */
	int opDateSoonExpireNum(Map<String, Object> qryMap);

	/**
	 * 
	 * 描述：经营期限已经到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param qryMap
	 * @return
	 */
	int opDateAlreadyExpireNum(Map<String, Object> qryMap);

	/**
	 * 描述：查询需要更新的历史名称
	 * 
	 * @author baifangfang
	 * @date 2017年10月30日
	 * @return
	 */
	List<MidBaseInfoDto> selectIncreHisEntNameList();

	/**
	 * 描述：全量更新历史名称
	 * 
	 * @author baifangfang
	 * @date 2017年11月2日
	 * @param paramMap
	 * @return
	 */
	List<MidBaseInfoDto> selectHisEntNameList(Map<String, Object> paramMap);

}