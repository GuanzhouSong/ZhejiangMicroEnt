/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import com.icinfo.cs.system.model.SysLogTable;
import com.icinfo.cs.yr.dto.YrRegCheckDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 描述:    cs_yr_reg_check 对应的Service接口.<br>
 *
 * @author wangjin
 * @date 2016年08月28日
 */
public interface IYrRegCheckService extends BaseService {

    /**
     * 默认查询 无条件
     * @param request
     * @return
     */
    List<YrRegCheck> queryPage(PageRequest request);

    /**
     * 单表多条件查询
     * @param request
     * @return
     */
    List<YrRegCheck> search_queryPage(PageRequest request);
    
    /** 
     * 描述: 登录时获取企业已有年报主表数据
     * @auther ZhouYan
     * @date 2016年8月30日 
     * @param pripid
     * @return
     * @throws Exception 
     */
    List<YrRegCheck> doGetYrRegCheckInit(String pripid) throws Exception;
    
    /** 
     * 描述: 初始化年报主表数据
     * @auther ZhouYan
     * @date 2016年8月30日 
     * @param pripid
     * @param year
     * @throws Exception 
     */
    void doInitYrRegCheck(String pripid, Integer year) throws Exception;

    /** 
     * 描述: 工商端查询年报主表数据（作为敏感词审核列表数据）
     * @auther yujingwei
     * @date 2016年8月30日 
     * @param request
     * @throws Exception 
     */
	List<YrRegCheckDto> queryPageForForbidResult(PageRequest request) throws Exception;
    
	/** 
     * 描述: 查询年报信息
     * @auther yujingwei
     * @date 2016年8月30日 
     * @param priPID,year
     * @throws Exception 
     */
	YrRegCheck selectCheckInfoByPripidAndYear(String priPID, Integer year) throws Exception;
	
	/** 
	 * 描述: 提交年报时更新主表信息
	 * @auther ZhouYan
	 * @date 2016年9月13日 
	 * @param pripid
	 * @param year
	 * @param loginType
	 * @param subIp
	 * @param isForbid
	 * @throws Exception 
	 */
	void updateYrRegCheck(String pripid, Integer year, String loginType, String subIp, boolean isForbid, Date curDate) throws Exception;
	
	/** 
	 * 描述: 年报修改申请同意
	 * @auther chenxin
	 * @date 2016年9月19日 
	 * @param pripid
	 * @param year
	 * @param logCollector
	 * @throws Exception 
	 */
	public boolean doAddLog4UpdateYrRegCheckState(String pripid, Integer year,List<SysLogTable> logCollector) throws Exception;
	
	/**
	 * 
	 * 描述: 个体户接收查询
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<YrRegCheck>  selectPbReceiveQueryPage(PageRequest request) throws Exception;
	
	/**
	    * 根据注册号或者企业名称查询	
	    * @author ljx
	    * @param regNO
	    * @param entName
	    * @return
	    */
	List<YrRegCheck> selectByRegNoAndName(PageRequest request);
	
	/**
	 * 
	 * 描述: 更新（通过年份和主体代码）
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
    int updateYrRegCheckByPriPIdAndYear(YrRegCheck yrRegCheck) throws Exception;
    
	/**
	 * 
	 * 描述: 查询已经用纸质方式提交过个体户年报的个数(通过主体代码)
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param priPId
	 * @return
	 */
    public int selectCountIsReportByParper(String priPID) throws Exception;
    
    /** 
     * 描述: 修改年度报告：修改主表状态
     * @auther ZhouYan
     * @date 2016年9月21日 
     * @param pripid
     * @param year
     * @return
     * @throws Exception 
     */
    int modYearReport(String pripid, Integer year) throws Exception; 
    
    
    /**
     * 
     * 描述   根据部门类型（农业、农信、工商查询待审核和意见录入的信息）
     * @author 赵祥江
     * @date 2016年11月29日 下午1:43:16 
     * @param 
     * @return List<YrRegCheckDto>
     * @throws
     */
	List<YrRegCheckDto>  comInfoCheckDtoListJSON(PageRequest request) throws Exception;

	/**
	 * 根据年份和身份主体代码更新 农专年报中的辅助报表的 年报状态：declStatus
	 * @param year
	 * @param priPID
     * @return
     */
	int updateYrRegCheckDeclStatus(Integer year, String priPID);
	
   /**
    * 根据注册号或者企业名称查询	
    * @param regNO
    * @param entName
    * @return
    */
   List<YrRegCheck> selectByRegNoOrName(String regNO,String entName);
   /**根据priPID更新priPID
    * @author ljx	
    * @param priPID
    * @param oldPriPId
    * @return
    */
   int updatePriPIdForDataReturn(String priPID,String oldPriPId);
   
   /**
	 * 
	 * 描述: 个体户纸质报告补录查询
	 * @auther gaojinling
	 * @date 2017年3月8日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
   public List<YrRegCheck> selectPbAddRecQueryPage(PageRequest request) throws Exception;
   
   
   /**
	 * 
	 * 描述:纸质补录条数
	 * @auther gaojinling
	 * @date 2017年3月16日 
	 * @return
	 * @throws Exception
	 */
	public Integer selectPbAddRecCount()
			throws Exception;
	
	/**
	 * 
	 * 描述: 年报修改申请审核条数（警示端首页）
	 * @auther gaojinling
	 * @date 2017年3月17日 
	 * @param map
	 * @return
	 */
	public Integer selectForbidCount(Map<String, Object> map) throws Exception;
   
	
}