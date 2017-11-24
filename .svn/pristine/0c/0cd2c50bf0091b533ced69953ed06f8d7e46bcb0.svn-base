/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service;


import java.util.List;
import java.util.Map;

import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:    cs_pub_pbeppassword 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
public interface IPubPbePasswordService extends BaseService {
	
	/** 
	 * 描述: 根据注册号，统一代码或者企业名称从MidBaseInfo表搜索
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @param uniCode
	 * @param entName
	 * @return
	 * @throws Exception 
	 */
	public MidBaseInfo selectBaseInfoByConditions(String regNO,String uniCode,String entName) throws Exception;
	
	/** 
	 * 描述: 根据注册号，统一代码或者企业名称从密码表搜索
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @param uniCode
	 * @param entName
	 * @return
	 * @throws Exception 
	 */
	public PubPbePassword selectByConditions(String regNO,String uniCode,String entName) throws Exception;
	
	/** 
	 * 描述: 保存
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param pb
	 * @return
	 * @throws Exception 
	 */
	public boolean save(PubPbePassword ppp)  throws Exception;
	
	/** 
	 * 描述: 插入
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param pb
	 * @return
	 * @throws Exception 
	 */
	public boolean insert(PubPbePassword ppp)  throws Exception;
	
	/** 
	 * 描述: 根据注册号查询
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @return
	 * @throws Exception 
	 */
	public PubPbePassword selectOneByRegNO(String regNO) throws Exception;

	/** 
	 * 描述: 根据统一代码查询
	 * @author ZhouJun
	 * @date 2016年9月23日 
	 * @param number
	 * @return
	 * @throws Exception 
	 */
	public PubPbePassword selectOneByUniCode(String uniCode) throws Exception;
	
	/** 
	 * 描述: 将中间库的数据导入密码库
	 * @author ZhouJun
	 * @date 2016年9月23日 
	 * @param midBaseInfo
	 * @param pubPbePassword 
	 */
	public PubPbePassword convertMidBaseInfoToPubPbePassword(MidBaseInfo midBaseInfo,String tel);
	
	/** 
	 * 描述: 更新密码
	 * @author ZhouJun
	 * @date 2016年9月24日 
	 * @param pb
	 * @throws Exception 
	 */
	public String updatePassword(PubPbePassword ppp) throws Exception;
	
	/** 
	 * 描述: 个体户用户名密码登陆信息
	 * @author ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	List<PubPbePassword> doCheckLogin(PubPbePassword pubPbePassword) throws Exception;
	
	/** 
	 * 描述: 工商端个体户密码管理密码查询
	 * @author ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	public PubPbePassword selectServerPubPbePassword(Map<String, Object> map)
			throws Exception;

}