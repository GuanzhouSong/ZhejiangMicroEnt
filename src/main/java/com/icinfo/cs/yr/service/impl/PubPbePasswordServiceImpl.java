/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.yr.mapper.PubPbePasswordMapper;
import com.icinfo.cs.yr.model.PubPbePassword;
import com.icinfo.cs.yr.service.IPubPbePasswordService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;

/**
 * 描述:    cs_pub_pbeppassword 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年09月18日
 */
@Service
public class PubPbePasswordServiceImpl extends MyBatisServiceSupport implements IPubPbePasswordService {

	 @Autowired 
	 MidBaseInfoMapper midBaseInfoMapper;
	 
	 @Autowired
	 PubPbePasswordMapper pubPbePasswordMapper;
 
 
	/** 
	 * 描述: 根据注册号，统一代码，企业名称从MidBaseInfo表查询
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @param uniCode
	 * @param entName
	 * @return
	 * @throws Exception 
	 */
	@Override
	public MidBaseInfo selectBaseInfoByConditions(String regNO, String uniCode,
			String entName) throws Exception {
		
		if(!(StringUtil.isNotEmpty(regNO))&!(StringUtil.isNotEmpty(uniCode))&!(StringUtil.isNotEmpty(entName))){
			return null;
		}
		Example example1 = new Example(MidBaseInfo.class);
		Criteria  criteria = example1.createCriteria();
		criteria.andEqualTo("entTypeCatg", 50);
		if(StringUtil.isNotEmpty(entName)){
			criteria.andEqualTo("entName", entName);
		}
		if(StringUtil.isNotEmpty(regNO)){
			criteria.andEqualTo("regNO", regNO);
		}
		if(StringUtil.isNotEmpty(uniCode)){
			criteria.andEqualTo("uniCode", uniCode);
		}
		if(midBaseInfoMapper.selectByExample(example1).size()!=0){
			MidBaseInfo midBaseInfo = midBaseInfoMapper.selectByExample(example1).get(0);
			return midBaseInfo;
		}else{
			return null;
		}
	}
	
	/** 
	 * 描述: 根据注册号，统一代码，企业名称从个体户密码表表查询
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @param uniCode
	 * @param entName
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PubPbePassword selectByConditions(String regNO, String uniCode,
			String entName) throws Exception {
		Example example1 = new Example(PubPbePassword.class);
		if(StringUtil.isNotEmpty(entName)){
			example1.createCriteria().andEqualTo("entName", entName);
		}
		if(StringUtil.isNotEmpty(regNO)){
			example1.createCriteria().andEqualTo("regNO", regNO);
		}
		if(StringUtil.isNotEmpty(uniCode)){
			example1.createCriteria().andEqualTo("uniCode", uniCode);
		}
		List<PubPbePassword> ppplist= pubPbePasswordMapper.selectByExample(example1);
		if(ppplist.size()==0){
			return null;
		}else {
		PubPbePassword pubPbePassword = ppplist.get(0);
		return pubPbePassword;
		}
	}


	/** 
	 * 描述: 更新
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param ppp
	 * @return
	 * @throws Exception 
	 */
	@Override
	public boolean save(PubPbePassword ppp) throws Exception {
		try {
			ppp.setApplyTime(new Date());
			ppp.setCreateTime(new Date());
			Example example1 = new Example(PubPbePassword.class);
			example1.createCriteria().andEqualTo("UID", ppp.getUID());
			pubPbePasswordMapper.updateByExampleSelective(ppp, example1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/** 
	 * 描述: 插入
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param ppp
	 * @return
	 * @throws Exception 
	 */
	@Override
	public boolean insert(PubPbePassword ppp) throws Exception {
		try {
			ppp.setCreateTime(new Date());
			ppp.setApplyTime(new Date());
			pubPbePasswordMapper.insert(ppp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/** 
	 * 描述: 根据注册号在密码表查询
	 * @author ZhouJun
	 * @date 2016年9月20日 
	 * @param regNO
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PubPbePassword selectOneByRegNO(String regNO) throws Exception {
		Example ex = new Example(PubPbePassword.class); 
		ex.createCriteria().andEqualTo("regNO", regNO);
		List<PubPbePassword> ls =  pubPbePasswordMapper.selectByExample(ex);
			if(ls.size()==0){
				return null;
			}else {
				return ls.get(0);
			} 
	}

	/** 
	 * 描述: 根据unicode从密码表中查询
	 * @author ZhouJun
	 * @date 2016年9月28日 
	 * @param uniCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public PubPbePassword selectOneByUniCode(String uniCode) throws Exception {
		Example ex = new Example(PubPbePassword.class); 
		ex.createCriteria().andEqualTo("uniCode", uniCode);
		List<PubPbePassword> ls =pubPbePasswordMapper.selectByExample(ex);
		if(ls.size()==0){
			return null;
		}else {
			return ls.get(0);
		} 
	}

	/** 
	 * 描述: 将MidBaseInfo类中的数据导入PubPbePassword类
	 * @author ZhouJun
	 * @date 2016年9月23日 
	 * @param midBaseInfo
	 * @param tel
	 * @return 
	 */
	@Override
	public PubPbePassword convertMidBaseInfoToPubPbePassword(MidBaseInfo midBaseInfo,String tel) {
		PubPbePassword ppp = new PubPbePassword();
		ppp.setEntName(midBaseInfo.getEntName());
		ppp.setRegNO(midBaseInfo.getRegNO());
		ppp.setTel(tel);
		ppp.setLiaIDNum(midBaseInfo.getCerNO());
		ppp.setLiaName(midBaseInfo.getLeRep());
		ppp.setPriPID(midBaseInfo.getPriPID());
		ppp.setUniCode(midBaseInfo.getUniCode());
		return ppp;
	}

	/** 
	 * 描述: 更新密码
	 * @author ZhouJun
	 * @date 2016年9月24日 
	 * @param ppp
	 * @throws Exception 
	 */
	@Override
	public String updatePassword(PubPbePassword ppp) throws Exception {
		String pwd = StringUtil.NextInt(100000, 999999).toString();
		ppp.setPassword(pwd);
		ppp.setCreateTime(new Date());
		Example ex = new Example(PubPbePassword.class); 
		ex.createCriteria().andEqualTo("regNO", ppp.getRegNO());
		ex.createCriteria().andEqualTo("UID", ppp.getUID());
		pubPbePasswordMapper.updateByExampleSelective(ppp, ex);
		return pwd;
	}

	/** 
	 * 描述: 个体户用户名密码登陆信息
	 * @author ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<PubPbePassword> doCheckLogin(PubPbePassword pubPbePassword)
			throws Exception {
		return pubPbePasswordMapper.selectLoginPubPbePassword(pubPbePassword);
	}
	
	/** 
	 * 描述: 工商端个体户密码管理密码查询
	 * @author ZhouYan
	 * @date 2016年10月8日 
	 * @param pubPbePassword
	 * @return
	 * @throws Exception 
	 */
	public PubPbePassword selectServerPubPbePassword(Map<String, Object> map)
			throws Exception {
		return pubPbePasswordMapper.selectServerPubPbePassword(map);
	}
	
}