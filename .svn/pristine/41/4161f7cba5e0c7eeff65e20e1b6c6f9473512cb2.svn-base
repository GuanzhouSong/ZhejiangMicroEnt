/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.other.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.other.dto.LicenceInvalidCount;
import com.icinfo.cs.other.dto.PubOtherlicenceDto;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述: cs_pub_otherlicence 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
public interface IPubOtherlicenceService extends BaseService {
	/**
	 * 
	 * 描述: 查询所有
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @return
	 */
	List<PubOtherlicence> selectAll();

	/**
	 * 
	 * 描述: 多条件查询
	 * 
	 * @auther ljx
	 * @date 2016年10月18日
	 * @param map
	 * @return
	 */
	List<PubOtherlicenceDto> selectPubOtherlicenceByCation(PageRequest request);

	/**
	 * 
	 * 描述: 保存操作
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @param pubOtherlicence
	 * @return
	 */
	int saveOhterLicence(PubOtherlicence pubOtherlicence);

	/**
	 * 
	 * 描述: 更新
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param pubOtherlicence
	 * @return
	 */
	int update(PubOtherlicence pubOtherlicence);

	/**
	 * 
	 * 描述: 变更方法
	 * 
	 * @auther ljx
	 * @date 2016年11月4日
	 * @param pubOtherlicence
	 * @param names
	 * @param changevalues
	 * @param originalValues
	 * @param altDate
	 * @return
	 */
	public int alert(PubOtherlicence pubOtherlicence, String names, String changevalues, String originalValues,
			Date altDate);

	/**
	 * 
	 * 描述: 查询单个
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	PubOtherlicence selectByOne(String licID);

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param pubOtherlicence
	 * @return
	 */
	int insert(PubOtherlicence pubOtherlicence);

	/**
	 * 
	 * 描述: 审核操作
	 * 
	 * @auther ljx
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	int auditOtherlicence(PubOtherlicence pubOtherlicence);

	/**
	 * 
	 * 描述: 双告知许可审批信息（分页查询）
	 * 
	 * @auther gaojinling
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	public List<PubOtherlicence> selectOtherlicenceListByPriPid(PageRequest request);

	/**
	 * 
	 * 描述: 查询即时行政许可信息
	 * 
	 * @auther ljx
	 * @date 2016年10月20日
	 * @param map
	 * @return
	 */
	List<PubOtherlicenceDto> selectImPrimitByCation(PageRequest request);

	/**
	 * 
	 * 描述: TODO
	 * 
	 * @auther 统计
	 * @date 2016年10月21日
	 * @param map
	 * @return
	 */

	Map<String, Object> selectCountOtherLicence(PubOtherlicenceDto dto, Map<String, Object> qryMap) throws Exception;

	/**
	 * 
	 * 描述: 双告知许可审批信息2（分页查询）
	 * 
	 * @auther chenyu
	 * @date 2016年10月19日
	 * @param licID
	 * @return
	 */
	List<PubOtherlicence> selectOtherlicenceListByPriPid2(PageRequest request);

	/**
	 * 
	 * 描述: 删除操作
	 * 
	 * @auther ljx
	 * @date 2016年11月2日
	 * @param licID
	 * @return
	 */
	int deleteByLicID(String licID);

	/**
	 * 
	 * 描述: 查询企业基本信息
	 * 
	 * @auther ljx
	 * @date 2016年11月3日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<MidBaseInfo> queryMidBasePageForOtherAdd(PageRequest request) throws Exception;

	/**
	 * 
	 * 描述: 导入excel
	 * 
	 * @auther ljx
	 * @date 2016年11月24日
	 * @param file
	 * @param year
	 * @param priPID
	 * @param anCheID
	 * @return
	 * @throws Exception
	 */

	public Map<String, String> importByExcel(List<List<Object>> list, HttpSession session) throws Exception;

	/**
	 * 查询数据列表
	 * 
	 * @author: wangjin
	 * @param request
	 * @return
	 */
	List<PubOtherlicenceDto> select_queryPage(PageRequest request);

	List<PubOtherlicence> selectOtherlicencesByPriPid(String priPID);

	List<Map<String, Object>> selectOtherlicencesMaps(Map<String, Object> qryMap) throws Exception;

	MidBaseInfo getBaseInfoByUniIDOrRegNO(String code);

	/**
	 * 描述：根据pripid查询经营许可证信息
	 * 
	 * @param priPID
	 * @return
	 */
	List<PubOtherlicenceDto> selectOtherlicenceListByPriPID(String priPID);

	/**
	 * 描述：食品许可到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param qryMap
	 * @return
	 */
	int foodExpireNum(Map<String, Object> qryMap);

	/**
	 * 描述：药品许可到期
	 * 
	 * @author baifangfang
	 * @date 2017年10月11日
	 * @param qryMap
	 * @return
	 */
	int drugsExpireNum(Map<String, Object> qryMap);

	/**
	 * 
	 * 描述：许可证失效到期管理json数据
	 * 
	 * @author baifangfang
	 * @date 2017年11月15日
	 * @param request
	 * @return
	 */
	List<PubOtherlicenceDto> selectLicenceInvalidMgrJSON(PageRequest request);

	/**
	 * 
	 * 描述：许可证失效到期管理数据统计
	 * 
	 * @author baifangfang
	 * @date 2017年11月17日
	 * @param request
	 * @return
	 */
	LicenceInvalidCount queryLicenceInvalidCount(PageRequest request);
	
	/**
	 * 
	 * 描述   根据设置部门名称删除 
	 * @author 赵祥江
	 * @date 2017年11月20日 下午4:02:04 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deletePubOtherlicenceBySetDeptName (Map<String,Object> qMap)throws Exception;
}