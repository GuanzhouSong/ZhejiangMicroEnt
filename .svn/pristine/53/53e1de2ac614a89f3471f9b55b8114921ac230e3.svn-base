/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service;

import java.util.List;

import org.apache.poi.hssf.record.formula.functions.T;

import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.framework.core.service.BaseService;

/**
 * 描述:   联络员信息表 cs_pub_pbpassword 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年03月01日
 */
public interface IPubPbpasswordService extends BaseService {

	/**
	 * 
	 * 描述: 电话号码和操作类型更新联络员获取校验码
	 * @auther gaojinling
	 * @date 2017年3月2日 
	 * @param pubPbpassword
	 * @return
	 * @throws Exception
	 */
	int updatePwd(PubPbpassword pubPbpassword) throws Exception;

	/**
	 * 
	 * 描述: 保存
	 * @auther gaojinling
	 * @date 2017年3月2日 
	 * @param pubPbpassword
	 * @return
	 * @throws Exception
	 */
	int save(PubPbpassword pubPbpassword) throws Exception;
	

	/**
	 * 
	 * 描述: 根据联系电话和操作类型查询
	 * @auther gaojinling
	 * @date 2017年3月2日 
	 * @param tel
	 * @param operation
	 * @return
	 * @throws Exception
	 */
	List<PubPbpassword> queryListBytel(String tel, String operation) throws Exception;

	/**
	 * 
	 * 描述: 通过操作类型和电话号码删除
	 * @auther gaojinling
	 * @date 2017年3月2日 
	 * @param pubPbpassword
	 * @return
	 * @throws Exception
	 */
	int deletePwd(PubPbpassword pubPbpassword) throws Exception;
	
	/**
	 * 
	 * 描述: 获取的验证码校验是否正确或过期
	 * @auther gaojinling
	 * @date 2017年3月2日 
	 * @param pubPbpassword
	 * @return
	 * @throws Exception
	 */
    ResultRtn<T> doCheckPubPbpassword(PubPbpassword pubPbpassword) throws Exception;
    
	/**
	 * 
	 * 描述: 根据操作类型和电话号码及验证码查询验证码列表
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param tel
	 * @param operation
	 * @return
	 * @throws Exception
	 */
    public List<PubPbpassword> queryListBytelandPas(String tel,String operation,String password) throws Exception;
    
	/**
	 * 
	 * 描述: 校验手机校验码（6月30号之前有效，目前对应的是获取日期对应年份的）
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubEppasswordDto
	 * @param midRegNo
	 * @return
	 * @throws Exception
	 */
	public ResultRtn<T> doCheckPubPbpassword2(PubPbpassword pubPbpassword) throws Exception ;
	
	
	
	
	
}