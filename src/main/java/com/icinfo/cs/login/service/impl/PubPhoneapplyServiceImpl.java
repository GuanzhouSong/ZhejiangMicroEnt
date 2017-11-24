/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.PasStatus;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.login.dto.PubPhoneapplyDto;
import com.icinfo.cs.login.mapper.PubEppasswordHisMapper;
import com.icinfo.cs.login.mapper.PubEppasswordMapper;
import com.icinfo.cs.login.mapper.PubPhoneapplyMapper;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.model.PubEppasswordHis;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_phoneapply 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年08月28日
 */
@Service
public class PubPhoneapplyServiceImpl extends MyBatisServiceSupport implements IPubPhoneapplyService {

	@Autowired
	private PubPhoneapplyMapper pubPhoneapplyMapper;
	@Autowired
	private PubEppasswordMapper pubEppasswordMapper;
	@Autowired
	private PubEppasswordHisMapper pubEppasswordHisMapper;
	
	@Autowired
	private IPanoramaSearchService panoramaSearchService; 
	
	@Autowired
	private IEsManageService esManageService; 
	
	/***
	 * 
	 * 描述: 添加（null字段保存，且不使用默认值）
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param phoneApply
	 * @return
	 */
	@Override
	public int savePubPhoneapply(PubPhoneapply phoneApply) {
		return pubPhoneapplyMapper.insert(phoneApply);
	}
	
	/**
	 * 
	 * 描述: 更新（通过流水号和主体代码更新）
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param phoneApply
	 * @return
	 */
	@Override
	public int update(PubPhoneapply phoneApply) {
		Example example = new Example(PubPhoneapply.class);
		example.createCriteria().andEqualTo("pasid",phoneApply.getPasid());
		example.createCriteria().andEqualTo("pripid",phoneApply.getPripid());
		return pubPhoneapplyMapper.updateByExampleSelective(phoneApply, example);
	}

	/**
	 * 
	 * 描述: 联络员确认书打印查询
	 * @auther gaojinling
	 * @date 2016年8月30日 
	 * @param map
	 * @return
	 */
	@Override
	public List<PubPhoneapplyDto> selectPhoneApplyPrint(Map<String, Object> map) {
		return pubPhoneapplyMapper.selectPubPhoneapplyPrint(map);
	}

	 /**
	 * 
	 * 描述: 单条件查询
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param key 传入的属性
	 * @param Value 属性值
	 * @return
	 */
	@Override
	public List<PubPhoneapply> selectPubPhoneapplyByOne(String key, String Value) {
		Example example = new Example(PubPhoneapply.class);
		example.createCriteria().andEqualTo(key,Value);
		return pubPhoneapplyMapper.selectByExample(example);
	}
	
	 /**
     * 
     * 描述: 获取联络员接收列表list数据
     * @auther yujingwei
     * @date 2016年8月29日 
     * @param map
     * @return
     */
	public List<PubPhoneapply> queryPage(PageRequest request){
		PageHelper.startPage(request.getPageNum(), request.getLength());
        return pubPhoneapplyMapper.selectPubPhoneInfoAcceptList(request.getParams());
	}
	
	/**
     * 
     * 描述: 查询联络员申请信息
     * @auther yujingwei
     * @date 2016年8月29日 
     * @param map
     * @return
     */
	public PubPhoneapply selectPubPhoneApplyInfo(String pasid,String pripid){
		PubPhoneapply pubPhoneapply=new  PubPhoneapply();
		pubPhoneapply.setPasid(pasid);
		pubPhoneapply.setPripid(pripid);
		return pubPhoneapplyMapper.selectOne(pubPhoneapply);
	}
	
	/**
	 * @描述：联络员确认书接收
	 * @author chenxin
	 * @date 2016-09-08
	 * @param pasid
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean acceptPubPhoneApply(String pasid,SysUserDto sysUser) throws Exception {
		//1.查询联络员确认书信息
		PubPhoneapply pubPhoneapply=new  PubPhoneapply();
		pubPhoneapply.setPasid(pasid);
		pubPhoneapply =  pubPhoneapplyMapper.selectOne(pubPhoneapply);
		//2.删错联络员备案信息
		String pripid = pubPhoneapply.getPripid();
		PubEppassword pubEppassword = new PubEppassword();
		pubEppassword.setPripid(pripid);
		int deleteCount = pubEppasswordMapper.delete(pubEppassword);
		if(deleteCount < 0){
			throw new Exception("删除备案申请表失败");
		}
		//3.保存联络员备案信息（最新）
		pubEppassword = copyApplyToPassword(pubEppassword, pubPhoneapply,sysUser);
		int insertCount = pubEppasswordMapper.insert(pubEppassword);
		if(insertCount <0){
			throw new Exception("保存联络员备案信息（最新）失败");
		}
		//4.保存联络员备案历史信息（最新）
		PubEppasswordHis pubEppasswordHis = copyApplyToPasswordHis(pripid,pubPhoneapply,sysUser);
		insertCount = pubEppasswordHisMapper.insert(pubEppasswordHis);
		if(insertCount <0){
			throw new Exception("保存联络员备案历史信息（最新）失败");
		}
		//5.更新任务状态
		pubPhoneapply.setPasstatus(PasStatus.PasStatus01.getCode());
		Example example = new Example(PubPhoneapply.class);
		example.createCriteria().andEqualTo("pasid",pubPhoneapply.getPasid())
		.andEqualTo("pripid",pubPhoneapply.getPripid());
		int updateCount = pubPhoneapplyMapper.updateByExampleSelective(pubPhoneapply, example);
		if(updateCount <0){
			throw new Exception("更新任务状态失败");
		}
		//6.更新索引
		esManageService.updateOnePanoramaIdx(pubPhoneapply.getPripid());
		return true;
	}
	
	/**
	 * 描述：拷贝申请信息到备案表
	 *
	 * @author Administrator
	 * @date 2016-09-08
	 * @param pubEppassword
	 * @param pubPhoneapply
	 * @return
	 */
	private PubEppassword copyApplyToPassword(PubEppassword pubEppassword,PubPhoneapply pubPhoneapply,SysUserDto SysUser){
		if(pubPhoneapply !=null){
			pubEppassword.setPasid(pubPhoneapply.getPasid());// 流水号
			pubEppassword.setPasstatus(PasStatus.PasStatus01.getCode());//申请状态
			pubEppassword.setEntname(pubPhoneapply.getEntname());//企业名称
			pubEppassword.setEnttype(pubPhoneapply.getEnttype());
			pubEppassword.setLiaidtype(pubPhoneapply.getLiaidtype());//证件类型(联络人)
			pubEppassword.setLianame(pubPhoneapply.getLianame());//备案人姓名(联络人)
			pubEppassword.setLiaidnum(pubPhoneapply.getLiaidnum());//证件号码
			pubEppassword.setRegno(pubPhoneapply.getRegno());//统一代码/注册号
			pubEppassword.setTel(pubPhoneapply.getTel());//手机号码(联络人)
			pubEppassword.setLerep(StringUtil.doHtm(pubPhoneapply.getLerep()));//法定代表人
			pubEppassword.setLerepphone(pubPhoneapply.getLerepphone());//法定代表人手机号
			pubEppassword.setUnicode(pubPhoneapply.getUnicode());
			pubEppassword.setUsername(SysUser == null ? null : SysUser.getRealName());  //个体户联络员备案时不需做接收操作
			pubEppassword.setApprevieworg(SysUser == null ? null : SysUser.getDepartMent().getDeptName()); //个体户联络员备案时不需做接收操作
			pubEppassword.setApplytime(new Date());
			pubEppassword.setCreatetime(new Date());
		}
		return pubEppassword;
	}
	
	/**
	 * 描述：拷贝申请信息到备案表
	 *
	 * @author Administrator
	 * @date 2016-09-08
	 * @param pubEppassword
	 * @param pubPhoneapply
	 * @return
	 */
	private PubEppasswordHis copyApplyToPasswordHis(String pripid,PubPhoneapply pubPhoneapply,SysUserDto SysUser){
		PubEppasswordHis pubEppasswordHis = null;
		if(pubPhoneapply !=null){
			pubEppasswordHis = new PubEppasswordHis();
			pubEppasswordHis.setPasid(pubPhoneapply.getPasid());// 流水号
			pubEppasswordHis.setPripid(pripid);// 流水号
			pubEppasswordHis.setPasstatus(PasStatus.PasStatus01.getCode());//申请状态
			pubEppasswordHis.setEntname(pubPhoneapply.getEntname());//企业名称
			pubEppasswordHis.setEnttype(pubPhoneapply.getEnttype());
			pubEppasswordHis.setLiaidtype(pubPhoneapply.getLiaidtype());//证件类型(联络人)
			pubEppasswordHis.setLianame(pubPhoneapply.getLianame());//备案人姓名(联络人)
			pubEppasswordHis.setLiaidnum(pubPhoneapply.getLiaidnum());//证件号码
			pubEppasswordHis.setRegno(pubPhoneapply.getRegno());//统一代码/注册号
			pubEppasswordHis.setTel(pubPhoneapply.getTel());//手机号码(联络人)
			pubEppasswordHis.setLerep(StringUtil.doHtm(pubPhoneapply.getLerep()));//法定代表人
			pubEppasswordHis.setLerepphone(pubPhoneapply.getLerepphone());//法定代表人手机号
			pubEppasswordHis.setUnicode(pubPhoneapply.getUnicode());
			pubEppasswordHis.setUsername(SysUser == null ? null :SysUser.getRealName()); //个体户联络员备案时不需做接收操作
			pubEppasswordHis.setApprevieworg(SysUser == null ? null :SysUser.getDepartMent().getDeptName());//个体户联络员备案时不需做接收操作
			pubEppasswordHis.setApplytime(new Date());
			pubEppasswordHis.setCreatetime(new Date());
		}
		return pubEppasswordHis;
	}
}