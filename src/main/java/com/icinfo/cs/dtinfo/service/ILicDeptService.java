/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dtinfo.service;

import java.util.List;

import com.icinfo.cs.dtinfo.dto.LicDeptDto;
import com.icinfo.cs.dtinfo.model.LicDept;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_lic_dept 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年10月19日
 */
public interface ILicDeptService extends BaseService {
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2016年10月19日 上午10:59:47 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int insertLicDept(LicDept licDept)throws Exception;
	
	/**
	 * 
	 * 描述   根据审批事项编码、职能部门编码、行政区划删除
	 * @author  赵祥江
	 * @date 2017年1月16日 上午8:35:27 
	 * @param  
	 * @throws
	 */
	public int deleteByExaCodeAnDutyDeptCodeAndYiedistrict(String exaCode,String dutyDeptCode,String yiedistrict) throws Exception;
	
	/**
	 * 
	 * 描述   根据审批事项部门和部门编码和有效标识查询
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:02:51 
	 * @param 
	 * @return LicDept
	 * @throws
	 */
	public LicDept selectLicDeptByExaCodeAndDeptCode(String exaCode,String deptCode,String dutyDeptCode,String isValid)throws Exception;
	
	/**
	 * 
	 * 描述   根据审批事项部门和部门编码、职能部门编码查询
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:02:51 
	 * @param 
	 * @return LicDept
	 * @throws
	 */
	public List<LicDept> selectLicDeptByExaCodeAndDeptCodeAndDutyDeptCode(String exaCode,String deptCode,String dutyDeptCode)throws Exception;
	
	/**
	 *    
	 * 描述   TODO
	 * @author 赵祥江
	 * @date 2017年1月11日 下午2:36:14 
	 * @param 
	 * @return List<LicDept>
	 * @throws
	 */
	public List<LicDept> selectLicDeptByUid(String uid)throws Exception;
	
	/**
	 * 
	 * 描述   根据审批事项编码和部门编码删除
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:06:49 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteLicDeptByExaCodeAndDeptCode(String exaCode,String deptCode)throws Exception;
	
	/**
	 * 
	 * 描述   根据uid删除
	 * @author 赵祥江
	 * @date 2017年1月10日 下午8:47:22 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int deleteLicDeptByUid(String uid)throws Exception;


	/**
	 * 
	 * 描述   分页查询审批部门对照
	 * @author 赵祥江
	 * @date 2016年10月19日 上午11:29:00 
	 * @param 
	 * @return List<PubDtInfoDto>
	 * @throws
	 */
	public List<LicDeptDto> queryLicDeptListJSON(PageRequest request)throws Exception;
	
	/**
	 * 
	 * 描述   根据审批事项编码修改是否推送的值（licDeptType）
	 * @author 赵祥江
	 * @date 2016年10月19日 下午7:31:05 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateLicDeptByExaCode(String exaCode,String licDeptType,String flag);
	
	/**
	 * 
	 * 描述   根据uid修改
	 * @author 赵祥江
	 * @date 2017年1月11日 下午2:55:08 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateLicDeptByUid(LicDept licDept);
	
	/**
	 * 
	 * 描述   根据部门编码和审批事项编码修改
	 * @author 赵祥江
	 * @date 2016年11月2日 下午9:33:46 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int updateLicDeptByExaCodeAndDeptCode(LicDept  licDept);
	
	
	/**
	 * 
	 * 描述   根据审批部门级别自动生成个县市审批对照数据
	 * @author 赵祥江
	 * @date 2016年11月3日 下午1:41:52 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void executeLicDeptDataByLicZone()throws Exception;
	
	/**
	 * 
	 * 描述   根据部门采集表生成审批对照数据
	 * @author 赵祥江
	 * @date 2016年12月22日 下午7:55:28 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void executeLicDeptByUserCheckRecord() throws Exception;

	/**
	 *
	 * @Author ZhuDeFeng
	 * @param adCode
	 * @return
	 * @throws Exception
	 */
	List<LicDeptDto> queryLicDeptByAdCode(String adCode)throws Exception;
	
	/**
	 * 
	 * 描述   根据行政区划、审批事项和职能编码查询
	 * @author 赵祥江
	 * @date 2017年1月11日 下午6:21:25 
	 * @param 
	 * @return List<LicDept>
	 * @throws
	 */
	public List<LicDept> selectLicDeptByExaCodeAndDutyDeptCodeAndYiedistrict(String exaCode,String dutyDeptCode,String yiedistrict,String isValid)throws Exception;

	/**
	 * 
	 * 描述   数据和配置下放
	 * @author 赵祥江
	 * @date 2017年4月17日 下午12:38:52 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void transferExaCode(String exaCodeStr,String checkDep,String yFlag,String istransferFlag) throws Exception;
}