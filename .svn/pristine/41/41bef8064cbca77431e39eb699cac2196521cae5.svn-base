/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_pub_eppassword 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
public interface IPubEppasswordService extends BaseService {
	/** 
	 * 描述: 查询企业联络员登录信息
	 * @auther ZhouYan
	 * @date 2016年8月30日 
	 * @param pubEppasswordDto
	 * @return
	 * @throws Exception 
	 */
	List<PubEppassword> doCheckLogin(PubEppasswordDto pubEppasswordDto) throws Exception;
	
	/**
	 * 
	 * 描述: 单条件查询
	 * @auther 2016年8月30日 
	 * @date 2016年8月31日 
	 * @param 传入的属性
	 * @return
	 * @param 属性值
	 */
	List<PubEppassword> selectPubEppasswordByPriId(String key,String priPid);
	
	/**
	 * 
	 * 描述: 联络员备案查询联络员信息
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param key
	 * @param priPid
	 * @return
	 */
	List<PubEppasswordDto> selectPubEppasswordList(Map<String, Object> map);
	
	/**
	 * 
	 * 描述: 联络员备案查询联络员信息
	 * @auther chenyl
	 * @date 2016年9月12日 
	 * @param request
	 * @return
	 */
	List<PubEppasswordDto> selectPubEppasswordList(PageRequest request);
	/** 
	 * 描述: 根据登录输入的统一代码/注册号匹配联络员信息
	 * @auther ZhouYan
	 * @date 2016年8月31日 
	 * @param regno
	 * @return
	 * @throws Exception 
	 */
	List<PubEppassword> selectByRegnoOrUnicode(String regno, String midRegNo) throws Exception;

	
	/** 
	 * 描述: 更新密码
	 * @auther ZhouYan
	 * @date 2016年9月8日 
	 * @param pubEppassword
	 * @throws Exception 
	 */
	void updatePwd(PubEppassword pubEppassword)throws Exception;

	/** 
	 * 描述: 获取联络员信息历史数据list
	 * @param request 
	 * @auther yujingwei
	 * @date 2016年8月31日 
	 * @return
	 * @throws Exception 
	 */
	public List<PubEppasswordHis> queryPageForHis(PageRequest request) throws Exception;
     
	/** 
	 * 描述: 获取联络员信息历史数据list
	 * @param map 
	 * @auther yujingwei
	 * @date 2016年8月31日 
	 * @return
	 * @throws Exception 
	 */
	public PubEppassword selectPubEppasswordForPrint(HashMap<String, Object> map) throws Exception;
	
	
	/**
	 * 
	 * 描述             : 根据主体代码获取联络员备案信息（主表cs_pub_eppassword）
	 * @author: 赵祥江
	 * @date  : 2016年9月12日 下午6:33:51 
	 * @param :
	 * @return: PubEppassword
	 * @throws
	 */
	public PubEppassword selectPubEppasswordByPriPid(String pripid);
	
	/**
	 * 
	 * 描述: 处理（加密）联络员信息中的信息（证件号码，联络员姓名）
	 * @auther gaojinling
	 * @date 2016年12月28日 
	 * @param pubEppasswordDto
	 * @return
	 */
	public PubEppasswordDto handPubEppasswordDto (PubEppasswordDto pubEppasswordDto,MidBaseInfo midbaseinfo);



	/**
	 * 描述：添加 联络员信息
	 * @author： wangjin
	 * @param pubEppassword
	 * @return
     */
	int inset(PubEppassword pubEppassword) throws Exception;


	/**
	 * 描述：更新 联络员信息  -- 数字证书登录
	 * @author： wangjin
	 * @param pubEppassword
	 * @return
	 */
	int update(PubEppassword pubEppassword);

	/**
	 *  更新 联络员信息   -- 联络员登录
	 * @param pubEppassword
	 * @return
	 */
	int liaisonupdate(PubEppassword pubEppassword);

	/**
	 * 描述：根据条件查询联络员信息
	 * @param unicode 统一社会信用代码
	 * @param regno 注册号
     * @return
     */
	PubEppassword select( String unicode,String regno);
	
	
	/**
	 * 获取联络员相关信息
	 * 
	 * @author zhuyong
	 * @param priPid
	 * @param year
	 * @return
	 */
	List<PubEppassword> selectLiaInfo(List<String> priPid,int year) throws Exception;
	
	
	/**
	 * 
	 * 描述: 个体户登录校验码查询
	 * @auther gaojinling
	 * @date 2017年1月4日 
	 * @param request
	 * @return
	 */
	public List<PubEppasswordDto> selectPbEppasswordList(PageRequest request);
	
	/**
	 * 
	 * 描述:个体户App联络员登录 获取密码（获取密码，通过联络员手机号码更新）
	 * @auther gaojinling
	 * @date 2017年2月22日 
	 * @param pubEppassword
	 * @return
	 * @throws Exception
	 */
//	public int updatePwdByTel(PubEppassword pubEppassword) throws Exception;
	
	
	/**
	 * 
	 * 描述: 补录联系信息提交
	 * @auther gaojinling
	 * @date 2017年3月14日 
	 * @param pubEppassword
	 * @throws Exception
	 */
	public void save(PubEppassword pubEppassword) throws Exception;

	/**
	 * 查询联络员信息
	 * @author:wangjin
	 * @param unicode
	 * @param regno
	 * @return
	 */
	List<PubEppassword> selectPubEppasswordList(String unicode, String regno);
	

/** 
 * 描述: 根据联络员手机号获取信息
 * @author 张文男
 * @date 2017年5月19日 
 * @param tel
 * @return 
 */

	public List<PubEppassword> queryPubEppasswordListByTel(String tel);

	/** 
	* 描述: 根据联络电话获取3条企业名称数据 
	* @author 张文男
	* @date 2017年5月22日 
	* @param tel
	* @return 
	*/

	public List<String> queryEntNameFirst3ListByPubEppasswordTel(String tel);
	
	/** 
	 * 描述: 获取联络员年报信息列表
	 * @author 张文男
	 * @date 2017年6月19日 
	 * @param year
	 * @param isreported
	 * @param numStart
	 * @param pageSize
	 * @return 
	 */

	public List<PubEppasswordDto> queryYearReportList(Integer year,String isreported,Long numStart,Long pageSize);
	
	/** 
	 * 描述: 根据年份、是否年报、联络员手机获取企业名称列表
	 * @author 张文男
	 * @date 2017年6月9日 
	 * @param params
	 * @return 
	 */
	public List<PubEppasswordDto> queryEntNameList(Integer year,String isreported,String tel);

	/** 
	 * 描述: 根据年份、是否年报、联络员手机获取企业名称分页列表
	 * @author 张文男
	 * @date 2017年6月9日 
	 * @param request
	 * @return 
	 */

	public PageResponse<PubEppasswordDto> queryEntNamePageList(PageRequest request);
	
	/** 
	 * 描述: 获取联络员年报信息列表-总数
	 * @author 张文男
	 * @date 2017年6月9日 
	 * @param year
	 * @return 
	 */
	public Long queryYearReportCount(Integer year,String isreported);
	
	
	/**
	 * 
	 * 描述   获取已经接收了且企业为存续状态的联络员，联络员手机号码不重复的条数
	 * @author 赵祥江
	 * @date 2017年7月5日 下午4:39:47 
	 * @param 
	 * @return Long
	 * @throws
	 */
	public Long queryPubEppasswordPsCount();
	
	/**
	 * 
	 * 描述   获取已经接收了且企业为存续状态的联络员，联络员手机号码不重复
	 * @author 赵祥江
	 * @date 2017年7月5日 下午4:39:52 
	 * @param 
	 * @return List<PubEppasswordDto>
	 * @throws
	 */
	public List<PubEppasswordDto> queryPubEppasswordPsList(Long numStart,Long pageSize);
	
	/**
	 * 
	 * 描述   获取存续企业即时信息推送条数
	 * @author 赵祥江
	 * @date 2017年7月18日 下午3:02:29 
	 * @param 
	 * @return Long
	 * @throws
	 */
	public Long queryPubEppasswordImInfoCount();
	
	/**
	 * 
	 * 描述    获取存续企业即时信息推送信息
	 * @author 赵祥江
	 * @date 2017年7月18日 下午3:02:40 
	 * @param 
	 * @return List<PubEppasswordDto>
	 * @throws
	 */
	public List<PubEppasswordDto> queryPubEppasswordImInfoList(Long numStart,Long pageSize);
	
	/**
	 * 
	 * 描述   根据电话查询
	 * @author 赵祥江
	 * @date 2017年7月18日 下午7:21:47 
	 * @param 
	 * @return List<PubEppasswordDto>
	 * @throws
	 */
	public List<PubEppasswordDto> queryPubEppasswordImInfoBytelList(String tel);
 
}