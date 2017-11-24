/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.secnocreditsup.service.impl;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeBasedDto;
import com.icinfo.cs.secnocreditsup.dto.ExpSeriousCrimeListDto;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousCrimeBasedMapper;
import com.icinfo.cs.secnocreditsup.mapper.ExpSeriousPunishListMapper;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousPunishListService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:    处罚类严违Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年11月25日
 */
@Service
public class ExpSeriousPunishListServiceImpl extends MyBatisServiceSupport implements IExpSeriousPunishListService {
	
	@Autowired
	private ExpSeriousPunishListMapper expSeriousPunishListMapper;
	
	@Autowired
	private ExpSeriousCrimeBasedMapper expSeriousCrimeBasedMapper;
	
	/**
	 * 处罚类严违名单全部列表
	 */
	@Override
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplyAllList(PageRequest request) throws Exception {
		//union不用框架分页，速度太慢，总数在controller构建PageResponse时用放入
		Map<String, Object> params = request.getParams();
		int len = request.getLength();
		params.put("_pnum", (request.getPageNum() - 1) * len);
        params.put("_len", len);
		return expSeriousPunishListMapper.getExpSecInApplyAllList(params);
	}
	
	/**
	 * 处罚类严违名单待列入列表
	 */
	@Override
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplySrcList(PageRequest request) throws Exception {
		//不count，速度太慢，总数在controller构建PageResponse时用放入
		PageHelper.startPage(request.getPageNum(), request.getLength(), false);
		Map<String, Object> paramsMap = request.getParams();
		return this.expSeriousPunishListMapper.getExpSecInApplySrcList(handleParamsMap(paramsMap));
	}

	/**
	 * 处罚类严违名单已列入列表
	 */
	@Override
	public List<ExpSeriousCrimeListDto> doGetExpSecInApplyList(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		return this.expSeriousPunishListMapper.getExpSecInApplyList(handleParamsMap(paramsMap));
	}

	/**
	 * 获取行政处罚记录
	 * @param qryMap
	 * @return
	 */
	@Override
	public List<ExpSeriousCrimeListDto> getSrcCase(Map<String, Object> qryMap) throws Exception {
		return (List<ExpSeriousCrimeListDto>) this.expSeriousPunishListMapper.getSrcCase(qryMap);
	}
	
	/**
	 * 保存处罚严违申请
	 * @param expSeriousCrimeListDto
	 * @return
	 * @throws Exception
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(ExpSeriousCrimeListDto expSeriousCrimeListDto) throws Exception {
		expSeriousCrimeListDto.setCreateTime(new Date());
		return this.expSeriousPunishListMapper.insert(expSeriousCrimeListDto);
	}
	
	/**
	 * 查询列入记录
	 * @param id
	 * @return
	 */
	@Override
	public List<ExpSeriousCrimeList> queryList(Map<String, Object> parms) {
		Example example = new Example(ExpSeriousCrimeList.class);
		Criteria criteria = example.createCriteria();
		if (parms != null) {
			for (Map.Entry<String, Object> entry : parms.entrySet()) {
				criteria.andEqualTo(entry.getKey(), entry.getValue());
			}
		}
		List<ExpSeriousCrimeList> list = this.expSeriousPunishListMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 更新申请
	 * @param expSeriousCrimeList
	 * @return
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(ExpSeriousCrimeList expSeriousCrimeList) {
		Example example = new Example(ExpSeriousCrimeList.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uid", expSeriousCrimeList.getUid());
		return this.expSeriousPunishListMapper.updateByExampleSelective(expSeriousCrimeList, example);
	}
	
	/**
     * 描述:严违依据
     *
     */
	@Override
	public Integer insertExpSeriousCrimeBased(ExpSeriousCrimeBasedDto expSeriousCrimeBasedDto) throws Exception {
		return this.expSeriousCrimeBasedMapper.insert(expSeriousCrimeBasedDto);
	}
	
	/**
	 * 删除严违名单
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@Override
	public Integer deleteExpSeriousList(String uid) throws Exception {
		Example example = new Example(ExpSeriousCrimeList.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("uid", uid);
		return expSeriousPunishListMapper.deleteByExample(example);
	}
	
	/**
	 * 待列入总数带参数（分页用）
	 * @return
	 */
	@Override
	public Integer applySrcTotalParm(Map<String, Object> qryMap) {
		return this.expSeriousPunishListMapper.applySrcTotalParm(qryMap);
	}
	
	/**
	 * 已列入总数带参数（分页用）
	 * @return
	 */
	@Override
	public Integer applyTotalParm(Map<String, Object> qryMap) {
		return this.expSeriousPunishListMapper.applyTotalParm(qryMap);
	}
	
	/**
	 * 待列入总数
	 * @return
	 */
	@Override
	public Integer applySrcTotal(Map<String, Object> map) {
		map.put("regState", RegStateEnum.CUNXU.getParam());
		return this.expSeriousPunishListMapper.applySrcTotal(map);
	}
	
	/**
	 * 列入待初审总数
	 * @return
	 */
	@Override
	public Integer applyFirstTotal() {
		return this.expSeriousPunishListMapper.applyFirstTotal();
	}
	
	/**
	 * 列入待审核总数
	 * @return
	 */
	@Override
	public Integer applyAuditTotal() {
		return this.expSeriousPunishListMapper.applyAuditTotal();
	}
	
	/**
	 * 待初审总数
	 * @return
	 */
	@Override
	public Integer firstTotal() {
		return this.expSeriousPunishListMapper.firstTotal();
	}
	
	/**
	 * 初审不通过总数
	 * @return
	 */
	@Override
	public Integer firstNotTotal() {
		return this.expSeriousPunishListMapper.firstNotTotal();
	}
	
	/**
	 * 待审核总数
	 * @return
	 */
	@Override
	public Integer auditTotal() {
		return this.expSeriousPunishListMapper.auditTotal();
	}
	
	/**
	 * 审核通过总数
	 * @return
	 */
	@Override
	public Integer passTotal() {
		return this.expSeriousPunishListMapper.passTotal();
	}
	
	/**
	 * 审核不通过总数
	 * @return
	 */
	@Override
	public Integer auditNotTotal() {
		return this.expSeriousPunishListMapper.auditNotTotal();
	}
	
	/**
	 * 逾期列入总数
	 * @return
	 */
	@Override
	public Integer applyExpirTotal() {
		return this.expSeriousPunishListMapper.applyExpirTotal();
	}
	
	/** 
	 * 描述: 处理参数
	 * @auther ZhouYan
	 * @date 2017年7月26日 
	 * @param paramsMap
	 * @return
	 * @throws Exception 
	 */
	private Map<String, Object> handleParamsMap(Map<String, Object> paramsMap) throws Exception{
		if(paramsMap != null){
			if(paramsMap.containsKey("regState")){
				String regState = (String) paramsMap.get("regState");
				if(StringUtil.isNotEmpty(regState)){
					String[] regStateList = regState.split(",");
					paramsMap.put("regState", regStateList);
				}
			}
		}
		return paramsMap;
	}
	
	/**
	 * 根据列违原因得到列违类型
	 * @param AddSecCause
	 * @return
	 */
	@Override
	public String getSecDishonestyTypeByAddSecCause(String AddSecCause) {
		if(AddSecCause == null)return "";
		if(AddSecCause.indexOf("被撤销登记的")!=-1) return "被撤销登记";
		if(AddSecCause.indexOf("组织策划传销")!=-1) return "传销违法";
		if(AddSecCause.indexOf("直销违法")!=-1) return "直销违法";
		if(AddSecCause.indexOf("不正当竞争行为")!=-1) return "不正当竞争";
		if(AddSecCause.indexOf("侵害消费者权益")!=-1) return "侵害消费者权益";
		if(AddSecCause.indexOf("虚假广告")!=-1) return "发布虚假广告";
		if(AddSecCause.indexOf("商标侵权")!=-1) return "商标侵权";
		if(AddSecCause.indexOf("两年内累计受到三次以上行政处罚的")!=-1) return "累计违法";
		return "";
	}

	@Override
	public Integer UpdateSomeMsg(String sourceId) throws Exception {
		// TODO Auto-generated method stub
		return expSeriousPunishListMapper.UpdateSomeMsg(sourceId);
	}
	
}