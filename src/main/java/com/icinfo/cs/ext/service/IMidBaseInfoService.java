/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.ext.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.system.model.EntBaseInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.security.shiro.UserProfile;

/**
 * 描述: cs_mid_baseinfo 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月29日
 */
public interface IMidBaseInfoService extends BaseService {

	/**
	 * 根据关键字精确查找实体信息
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<MidBaseInfo> selectMidInfoByKeyword(Map<String, Object> map) throws Exception;

	/**
	 * 描述: 按内部序号查询企业基本信息
	 *
	 * @param pripid
	 * @return
	 * @throws Exception
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 */
	MidBaseInfo selectByPripid(String pripid) throws Exception;

	/**
	 * 描述: 数据比对分页
	 *
	 * @param pripid
	 * @return
	 * @throws Exception
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 */
	List<MidBaseInfoDto> queryComparePage(PageRequest request, List<MidBaseInfoDto> list) throws Exception;

	/**
	 * 描述: 登录时按内部序号查询企业基本信息
	 * 
	 * @auther ZhouYan
	 * @date 2016年10月24日
	 * @param pripid
	 * @param systemType
	 * @return
	 * @throws Exception
	 */
	MidBaseInfoDto selectMidBaseInfoByPripid(String pripid, String systemType) throws Exception;

	MidBaseInfoDto selectMidBaseInfoByPripid(String pripid) throws Exception;

	/**
	 * 根据 统一信用代码或注册号查询企业名称
	 * 
	 * @author :wangjin
	 * @param regno
	 * @return
	 * @throws Exception
	 */
	MidBaseInfo selectMidBaseInfoByRegno(String regno) throws Exception;

	/**
	 * 根据 统一信用代码或注册号查询企业名称(存续)
	 * 
	 * @author :chenxin
	 * @param regno
	 * @return
	 * @throws Exception
	 */
	MidBaseInfoDto selectMidBaseInfoByRegNOHold(String regno) throws Exception;

	/**
	 * 根据 统一信用代码或注册号查询企业内部序号
	 * 
	 * @author chenxin
	 * @date 2017-02-21
	 * @param regNOList
	 * @return
	 * @throws Exception
	 */
	List<String> selectPriPIDByRegno(List<String> regNOList) throws Exception;

	/**
	 * 根据 统一信用代码或注册号查询企业内部序号
	 * 
	 * @author chenxin
	 * @date 2017-02-21
	 * @param regNOList
	 * @return
	 * @throws Exception
	 */
	List<String> selectPriPIDByRegno(String regNO) throws Exception;

	/**
	 * 描述: 登录时按注册号、企业名称查询企业基本信息
	 *
	 * @param regno
	 * @param entname
	 * @param systemType
	 * @return
	 * @throws Exception
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 */
	MidBaseInfoDto selectByRegnoAndEntname(String regno, String entname, String systemType) throws Exception;

	/**
	 * 描述: 根据注册号（统一代码）或名称查询
	 *
	 * @param map
	 * @return
	 * @auther gaojinling
	 * @date 2016年8月29日
	 */
	public List<MidBaseInfoDto> selectMidBaseinfoByRegNoAndName(Map<String, Object> map);

	/**
	 * 描述: 查找登记机关与管辖单位所在机关不一致的企业（regOrgCode！= 管辖单位的父代码的前6位）
	 *
	 * @param request
	 *            查询参数
	 * @return
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月20日
	 */
	List<MidBaseInfoDto> selectMidbaseinfo4delegate(PageRequest request) throws Exception;

	/**
	 * 描述: 根据法人姓名和证件号码查询关联企业信息
	 *
	 * @param map
	 * @return
	 * @auther chenxin
	 * @date 2017年3月22日
	 */
	List<MidBaseInfoDto> selectMidBaseinfoBackList(PageRequest request) throws Exception;

	/**
	 * 描述: 为企业设置委托
	 *
	 * @param priPIDs
	 *            主体身份代码
	 * @param userProfile
	 *            当前登录用户
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	void setDelegate(String[] priPIDs, UserProfile userProfile) throws Exception;

	/**
	 * 描述: 为企业取消委托
	 *
	 * @param priPIDs
	 *            主体身份代码
	 * @param userProfile
	 *            当前登录用户
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	void cancleDelegate(String[] priPIDs, UserProfile userProfile) throws Exception;

	/**
	 * 描述: 查询登记机关与属地机关不一致的企业
	 *
	 * @param request
	 *            请求参数
	 * @throws Exception
	 * @auther ZhuDefeng
	 * @date 2016年9月22日
	 */
	Page<EntBaseInfo> selectbaseinfo4delegateByEs(PageRequest request) throws Exception;

	/**
	 * 描述：根据主体身份代码查询企业基本信息
	 * 
	 * @author ZhuDefeng
	 * @date 2016-10-12
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	EntBaseInfo selectBaseInfoByPriPIDAndEs(String priPID) throws Exception;

	/**
	 * 描述：查询企业基本信息
	 * 
	 * @author yujingwei
	 * @date 2016-10-12
	 * @param request
	 * @return List<MidBaseInfo>
	 * @throws Exception
	 */
	public List<MidBaseInfo> queryPage(PageRequest request) throws Exception;

	/**
	 * 描述：根据企业名称查询企业基本信息
	 * 
	 * @author ylr
	 * @date 2016-10-23
	 * @throws Exception
	 */
	public MidBaseInfo selectEntByEntName(String entName) throws Exception;

	/**
	 * 
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据 @author 赵祥江 @date 2016年10月24日
	 * 上午10:49:37 @param @return List<MidBaseInfo> @throws
	 */
	List<MidBaseInfo> selectMidInfoByApprDate(Map<String, Object> params);

	/**
	 * 
	 * 描述 根据核准日期范围获取有审批事项的在册核准数据 @author 赵祥江 @date 2016年10月24日
	 * 上午10:49:37 @param @return List<MidBaseInfo> @throws
	 */
	List<MidBaseInfo> selectMidInfoDzByApprDate(Map<String, Object> params);

	/**
	 * 
	 * 描述 根据cerNo获取企业信息 @author 陈宇 @date 2016年10月24日 上午10:49:37 @param @return
	 * List<MidBaseInfo> @throws
	 */
	List<MidBaseInfoDto> selectMidBaseInfoDtoListByCerNO(PageRequest request) throws Exception;

	/**
	 * 查询增量索引数据根据分页
	 * 
	 * @author baifangfang
	 * @date 2016年11月9日
	 * @return
	 */
	List<MidBaseInfoDto> doGetIncreList(int pageNum, int pageSize);

	/**
	 * 查询索引数据根据id范围
	 * 
	 * @author baifangfang
	 * @date 2016年11月15日
	 * @return
	 */
	List<MidBaseInfoDto> doGetListById(int start);

	/**
	 * 获取最大的id
	 * 
	 * @author baifangfang
	 * @date 2016年12月5日
	 * @return
	 */
	int getMaxId();

	/**
	 * 描述：根据企业名称或注册号或统一代码查询数据
	 * 
	 * @date 2016年12月10日
	 * @author baifangfang
	 * @param condition
	 * @return
	 */
	List<MidBaseInfoDto> doGetListByCondition(String condition);

	/**
	 * 根据以，分割的字符串，查询数据
	 * 
	 * @author liuhaiqiang
	 * @date 2016年11月15日
	 * @return
	 */
	// void selectByPripids(String priPID);

	/**
	 * 描述：根据上传数据进行批量比对
	 * 
	 * @date 2016年12月10日
	 * @author ylr
	 * @param map
	 * @return
	 */
	Map<String, Object> doDepSynImportCompare(Sheet sheet, String fileName, HttpSession session);

	/**
	 * 描述：查询需要导入的数量
	 * 
	 * @date 2016年12月16日
	 * @author baifangfang
	 * @param apprDate
	 * @return
	 */
	int doCountByApprDate(String apprDate);

	/**
	 * 查询索引数据根据分页
	 * 
	 * @author baifangfang
	 * @date 2016年12月16日
	 * @return
	 */
	List<MidBaseInfoDto> doGetListByApprDate(int currPage, int pageSize, String apprDate);

	/**
	 * 描述：根据内部序号企业详情信息
	 * 
	 * @date 2016年12月10日
	 * @author baifangfang
	 * @param condition
	 * @return
	 */
	List<MidBaseInfoDto> doGetListByPriPID(String priPID);

	/**
	 * 描述：根据多内部序号企业详情信息
	 * 
	 * @date 2016年12月22日
	 * @author ylr
	 * @param condition
	 * @return
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
	public List<MidBaseInfoDto> selectPunishDate(String priPID) throws Exception;

	/**
	 * 描述：获取受限对象关联企业列表
	 * 
	 * @author baifangfang
	 * @date 2017-04-10
	 * @param request
	 * @return
	 */
	public List<MidBaseInfoDto> qryLimitObjRelEntList(PageRequest request);

	/**
	 * 描述：获取本企业受限对象列表
	 * 
	 * @author baifangfang
	 * @date 2017-04-11
	 * @param request
	 * @return
	 */
	public List<MidBaseInfoDto> qryLimitRelEntObjList(PageRequest request);

	/**
	 * 描述: 按内部序号查询企业基本信息
	 * 
	 * @throws Exception
	 * @auther yujingwei
	 * @date 2016年8月29日
	 * @param pripid
	 * @return MidBaseInfo
	 */
	public MidBaseInfo selectInfoByPriPID(String priPID) throws Exception;

	/**
	 * 
	 * 描述: 新增批量列入经营异常记录列表（企业、农专）
	 * 
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param map
	 * @return
	 */
	public List<MidBaseInfoDto> selectBatchPubOpanomalyInAddList(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述: 新增批量列入经营异常记录列表（企业、农专不分页）
	 * 
	 * @auther gaojinling
	 * @date 2017年6月13日
	 * @param map
	 * @return
	 */
	public List<MidBaseInfoDto> selectBatchPubOpanomalyInAddListAll(Map<String, Object> map) throws Exception;

	/**
	 * 描述：根据企业名称/统一社会信用代码查询企业信息
	 * 
	 * @author 陈鑫
	 * @date 2017-09-14
	 * @param parmMap
	 * @return
	 */
	public MidBaseInfoDto selectForDrandomByKeyword(Map<String, Object> parmMap);

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -根据企业名称和信用代码获取企业信息 @author 赵祥江 @date 2017年10月10日
	 * 上午10:55:11 @param @return JSONObject @throws
	 */
	public JSONObject getOperatingList(String keyword, String secretkey, int pageNo, int pageSize) throws Exception;

	/**
	 * 
	 * 描述 企信连联 专项查询 经营期限 -查询联络员旗下企业信息 @author 赵祥江 @date 2017年10月10日
	 * 上午10:54:43 @param @return JSONObject @throws
	 */
	public JSONObject getOperatingListByTel(String tel, String keyword, String secretkey, String searchFlag)
			throws Exception;

	/**
	 * 描述：经营期限即将到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param qryMap
	 * @return
	 */
	public int opDateSoonExpireNum(Map<String, Object> qryMap);

	/**
	 * 
	 * 描述：经营期限已经到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月12日
	 * @param qryMap
	 * @return
	 */
	public int opDateAlreadyExpireNum(Map<String, Object> qryMap);

	/**
	 * 描述：查询需要更新的历史名称
	 * @author baifangfang
	 * @date 2017年11月2日
	 * @param start
	 * @return
	 */
	public List<MidBaseInfoDto> doGetHisEntNameList(int currPage, int pageSize);

}