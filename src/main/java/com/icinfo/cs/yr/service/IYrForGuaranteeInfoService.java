/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.common.ajax.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import com.icinfo.cs.yr.model.YrForGuaranteeInfo;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_yr_forguaranteeinfo 对应的Service接口.<br>
 * 对外担保
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IYrForGuaranteeInfoService extends BaseService {


	/**
	 * 新增
	 * @author: wangjin
	 * @param yrForGuaranteeInfo
	 * @return
     */
	int insert(YrForGuaranteeInfo yrForGuaranteeInfo);

	/**
	 * 更新
	 * @author: wangjin
	 * @param yrForGuaranteeInfo
	 * @return
	 */
	int update(YrForGuaranteeInfo yrForGuaranteeInfo);


	/**
	 * 列表查询
	 * @author: wangjin
	 * @param request
	 * @return
	 */
	List<YrForGuaranteeInfo> select_queryPage(PageRequest request);


	/**
	 * 根据moreID 和 priPID　查询对象
	 * @author: wangjin
	 * @param moreID
	 * @param priPID
	 * @return
	 */
	YrForGuaranteeInfo selectByMoreIDAndPriPID(String moreID,String priPID);

	/**
	 * 批量删除
	 * @autor:wangjin
	 * @param list_moreID
	 * @param priPID
	 * @return
     */
	int batch_delete(List<String> list_moreID, String priPID);


	/** 
	 * 描述: 年报预览：对外提供保证担保信息
	 * @auther ZhouYan
	 * @date 2016年9月24日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public List<YrForGuaranteeInfo>  queryPagePreview(PageRequest request) throws Exception;

	/**
	 * 根据年份和主体身份代码获取 对象集合数据
	 * @autor:wangjin
	 * @param year
	 * @param priPID
	 * @return
	 */
	List<YrForGuaranteeInfo> selectByYearAndPripidList(Integer year, String priPID);

	/**
	 * 插入当前年份上一年份的数据集合
	 * @autor:wangjin
	 * @param list
	 * @param anCheID 年报ID
	 * @return
	 */
	void insertYrForGuaranteeinfoList(List<YrForGuaranteeInfo> list, String anCheID);


	/**
	 * 插入Excel数据
	 * @autor:wangjin
	 * @param file
	 * @param year
	 * @param priPID
	 */
	public AjaxResult importYrForGuaranteeInfoByExcel(MultipartFile file, String year, String priPID,String anCheID) throws Exception;

	/**
	 *  获取 主债额 的合计值
	 * @param queryMap
	 * @return
	 */
	BigDecimal sumMoney(Map<String, Object> queryMap);



	/**
	 * : 根据主键moreId（uuid） 获取对外担保对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午5:21:34 
	 * @param :
	 * @return: YrForGuaranteeInfo
	 * @throws
	 */
	public YrForGuaranteeInfo selectYrForGuaranteeInfoByMoreId(String moreId)throws Exception;  

	 
	/**
	 * 
	 * 描述  : 根据主键moreId（uuid） 修改对外担保对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午5:22:50 
	 * @param :
	 * @return: int
	 * @throws
	 */
	public int  updateYrForGuaranteeInfoByMoreId(YrForGuaranteeInfo yrForGuaranteeInfo)throws Exception;
	
	/**
	 * 
	 * 描述  : 根据主键moreId（uuid）删除对外担保对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午2:09:36 
	 * @param :
	 * @return: YrForinvestMent
	 * @throws
	 */
	public int  deleteYrForGuaranteeInfoByMoreId(String moreId)throws Exception;
	
	/**
	 * 
	 * 描述 : 根据年报年度和主体代码获取对外担保结果集
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午2:09:36 
	 * @param :
	 * @return: YrForinvestMent
	 * @throws
	 */
	public List<YrForGuaranteeInfo>  selectYrForGuaranteeInfoByYearAndPriPID(int year,String priPID)throws Exception;
	
	/**
	 * 
	 * 描述  : 保存对外担保对象
	 * @author: 赵祥江
	 * @date  : 2016年8月30日 下午2:09:36 
	 * @param :
	 * @return: YrForinvestMent
	 * @throws
	 */
	public int  insertYrForGuaranteeInfo(YrForGuaranteeInfo yrForGuaranteeInfo)throws Exception;
	

	/**
	 * 
	 * 描述   : 对外担保导入
	 * @author: 赵祥江
	 * @date  : 2016年9月13日 上午11:42:33 
	 * @param :
	 * @return: int
	 * @throws
	 */
	public int  importYrForGuaranteeInfo(MultipartFile file,String PriPID,int year)throws Exception;
	
	
	/**
	 * 
	 * 描述 : 初始化对外担保 先获取当年的对外担保 如果没有则获取上一年的
	 * @author: 赵祥江
	 * @date  : 2016年9月18日 上午10:37:26 
	 * @param :
	 * @return: void
	 * @throws
	 */
	public void   initYrForGuaranteeInfo(int year,String PriPID)throws Exception;
	
	/** 
	 * 描述: 根据自然人身份证号获取 个人对外提供担保信息
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return 
	 */
	
	List<YrForGuaranteeInfo> selectListByCerNO(PageRequest request);


}