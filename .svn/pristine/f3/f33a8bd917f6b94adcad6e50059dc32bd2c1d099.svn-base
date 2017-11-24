/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service.impl;

import java.util.Date;
import java.util.List;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.ResultRtn;
import com.icinfo.cs.login.mapper.PubPbpasswordMapper;
import com.icinfo.cs.login.model.PubPbpassword;
import com.icinfo.cs.login.service.IPubPbpasswordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:   工商联络员获取验证码表 cs_pub_pbpassword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月01日
 */
@Service
public class PubPbpasswordServiceImpl extends MyBatisServiceSupport implements IPubPbpasswordService {
	
	@Autowired
	PubPbpasswordMapper pubPbpasswordMapper;
	
	/**
	 * 
	 * 描述: 更新（通过工商联络员手机号及操作类型）
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubPbpassword
	 * @throws Exception
	 */
	@Override
	public int updatePwd(PubPbpassword pubPbpassword) throws Exception {
		Example example = new Example(PubPbpassword.class);
		example.createCriteria().andEqualTo("tel",pubPbpassword.getTel()).andEqualTo("operation",pubPbpassword.getOperation());
		pubPbpassword.setApplyTime(new Date());
		pubPbpassword.setCreateTime(new Date());
		return pubPbpasswordMapper.updateByExampleSelective(pubPbpassword, example);
	}
	
	
	/***
	 * 
	 * 描述: 添加（null字段保存，且不使用默认值）
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
	@Override
	public int save(PubPbpassword pubPbpassword) throws Exception {
		pubPbpassword.setApplyTime(new Date());
		pubPbpassword.setCreateTime(new Date());
		return pubPbpasswordMapper.insert(pubPbpassword);
	}
	
	/**
	 * 
	 * 描述: 根据操作类型和电话号码查询验证码列表
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param tel
	 * @param operation
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubPbpassword> queryListBytel(String tel,String operation) throws Exception{
		Example example = new Example(PubPbpassword.class);
		example.createCriteria().andEqualTo("tel",tel).andEqualTo("operation",operation);
		return pubPbpasswordMapper.selectByExample(example);
	}
	
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
	public List<PubPbpassword> queryListBytelandPas(String tel,String operation,String password) throws Exception{
		Example example = new Example(PubPbpassword.class);
		example.createCriteria().andEqualTo("tel",tel).andEqualTo("operation",operation).andEqualTo("password", password);
		return pubPbpasswordMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * 描述: 删除（通过工商联络员手机号及操作类型）
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubPbpassword
	 * @throws Exception
	 */
	@Override
	public int deletePwd(PubPbpassword pubPbpassword) throws Exception {
		Example example = new Example(PubPbpassword.class);
		example.createCriteria().andEqualTo("tel",pubPbpassword.getTel()).
		andEqualTo("operation",pubPbpassword.getOperation());
		return pubPbpasswordMapper.deleteByExample(example);
	}
	
	/**
	 * 
	 * 描述: 校验手机校验码
	 * @auther gaojinling
	 * @date 2017年3月1日 
	 * @param pubEppasswordDto
	 * @param midRegNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public ResultRtn<T> doCheckPubPbpassword(PubPbpassword pubPbpassword) throws Exception {
        //查询现有获取验证码表中是否有信息
		List<PubPbpassword> list = queryListBytelandPas(pubPbpassword.getTel(), pubPbpassword.getOperation(),pubPbpassword.getPassword());		
		// 有信息, 则判断手机验证码是否过期
        if (list != null && list.size() > 0) {
        	if(DateUtil.getBetweenDaysToMut(list.get(0).getCreateTime(), new Date()) > 1440){
        		return new ResultRtn<T>("1", "验证码已失效，请重新获取！ ");
        	}
        }else {
        	// 3.如果没有信息, 说明企业登录信息输入错误
        	return new ResultRtn<T>("2", "您输入的验证码有误，请重新输入！");
        }
        return new ResultRtn<T>(true);
    }
	
	
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
	public ResultRtn<T> doCheckPubPbpassword2(PubPbpassword pubPbpassword) throws Exception {
        //查询现有获取验证码表中是否有信息
		List<PubPbpassword> list = queryListBytelandPas(pubPbpassword.getTel(), pubPbpassword.getOperation(),pubPbpassword.getPassword());		
		// 有信息, 则判断手机验证码是否过期
        if (list != null && list.size() > 0) {
        	String year = DateUtil.dateToString(list.get(0).getCreateTime(),"yyyy");
        	//短信有效截止日期
			Date yearDate = DateUtil.stringToDate(year+"-07-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
//        	if(yearDate.before(new Date())){//截止日期在当前日期之前  ，验证码失效
//        		return new ResultRtn<T>("1", "验证码已失效，请重新获取！ ");
//        	}
        }else {
        	// 3.如果没有信息, 说明企业登录信息输入错误
        	return new ResultRtn<T>("2", "您输入的验证码有误，请重新输入！");
        }
        return new ResultRtn<T>(true);
    }
	
	
	
	
	
	
	
	
	
	
}