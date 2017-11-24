/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.sccheck.dto.PubScentDto;
import com.icinfo.cs.sccheck.mapper.PubScentMapper;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.cs.sccheck.model.PubScentSpecial;
import com.icinfo.cs.sccheck.service.IPubSccheckItemResultService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentAgentService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubScentServiceImpl extends MyBatisServiceSupport implements IPubScentService {
	
	@Autowired 
	private PubScentMapper pubScentMapper;
	
	@Autowired 
	private IPubScdeptTaskService pubScdeptTaskService;
	
	@Autowired 
	private IPubScentResultService pubScentResultService;
	
	@Autowired 
	private IPubScentAgentService pubScentAgentService;
	
	@Autowired 
	private IPubSccheckItemResultService pubSccheckItemResultService;
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	public List<PubScent> selectPubSentByDeptTaskUId(String deptTaskUid) throws Exception{
		Example example = new Example(PubScent.class);
		example.createCriteria().andEqualTo("deptTaskUid", deptTaskUid); 
		return pubScentMapper.selectByExample(example);
	}
	
	/**
	 * 
	 * 描述: 通过部门任务id分页查询已抽取的企业
	 * @auther gaojinling
	 * @date 2017年5月20日 
	 * @param request
	 * @return
	 */
	public List<PubScentDto> selectPubScentDtoList(PageRequest request)  throws Exception {
		Map<String, Object> searchMap =  request.getParams();
		if(searchMap.containsKey("pubTaskUid")){
			int pageSize = request.getLength();
			searchMap.put("numStart", (request.getPageNum() - 1) * pageSize);
			searchMap.put("pageSize", pageSize);
		}else{
			PageHelper.startPage(request.getPageNum(), request.getLength());
		}
		return pubScentMapper.selectPubScentDtoList(searchMap);
	}
	
	/**
	 * 描述：通过任务UID查询个数
	 * @author yujingwei
	 * @date 2017-07-22
	 * @param taskUid
	 * @return Integer
	 */
	public Integer selectPubScentTotalForBulletin(PageRequest request) throws Exception{
		return pubScentMapper.selectPubScentDtoTotal(request.getParams());
	}

	/**
	 * 描述：通过任务UID查询个数
	 * @author yujingwei
	 * @date 2017-07-22
	 * @param taskUid
	 * @return Integer
	 * @throws Exception 
	 */
	@Override
	public Integer selectPubScentAllTotal(Map<String,Object> params) throws Exception {
		return pubScentMapper.selectPubScentDtoTotal(params);
	}
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	@Override
	public List<PubScentDto> selectPubScentAllList(String deptTaskUid)throws Exception {
		return pubScentMapper.selectPubScentAllList(deptTaskUid);
	}
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年8月25日
	 * @param deptTaskUid
	 * @return
	 */
	@Override
	public List<PubScentDto> selectPubScentPageList(String deptTaskUid)throws Exception {
		return pubScentMapper.selectPubScentPageList(deptTaskUid);
	}
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	@Override
	public void savePubScent(PubScentBack pubScentBack) throws Exception {
		if(pubScentBack != null){
			PubScent pubScent = new PubScent();
			pubScent.setEntName(pubScentBack.getEntName());
			pubScent.setPriPID(pubScentBack.getPriPID());
			pubScent.setRegNO(pubScentBack.getRegNO());
			pubScent.setUniCode(pubScentBack.getUniCode());
			pubScent.setRegState(pubScentBack.getRegState());
			pubScent.setRegOrg(pubScentBack.getRegOrg());
			pubScent.setRegOrgName(pubScentBack.getRegOrgName());
			pubScent.setEntTypeCatg(pubScentBack.getEntTypeCatg());
			pubScent.setLocalAdm(pubScentBack.getLocalAdm());
			pubScent.setLocalAdmName(pubScentBack.getLocalAdmName());
			pubScent.setSpecialCode("multiple");
			pubScent.setSpecialName("主体综合库");
			pubScent.setEstDate(pubScentBack.getEstDate());
			pubScent.setTaskUid(pubScentBack.getTaskUid());
			pubScent.setRelateUserUid(pubScentBack.getRelateUserUid());
			pubScentMapper.insertSelective(pubScent);
		}
	}
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	@Override
	public void savePubScent(PubScent pubScent, PubScentBack pubScentBack)throws Exception {
		if(pubScentBack != null){
			pubScent.setEntName(isEmpty(pubScentBack.getEntName()));
			pubScent.setPriPID(isEmpty(pubScentBack.getPriPID()));
			pubScent.setRegNO(isEmpty(pubScentBack.getRegNO()));
			pubScent.setUniCode(isEmpty(pubScentBack.getUniCode()));
			pubScent.setRegState(isEmpty(pubScentBack.getRegState()));
			pubScent.setRegOrg(isEmpty(pubScentBack.getRegOrg()));
			pubScent.setRegOrgName(isEmpty(pubScentBack.getRegOrgName()));
			pubScent.setEntTypeCatg(isEmpty(pubScentBack.getEntTypeCatg()));
			pubScent.setLocalAdm(isEmpty(pubScentBack.getLocalAdm()));
			pubScent.setLocalAdmName(isEmpty(pubScentBack.getLocalAdmName()));
			pubScent.setSpecialCode("multiple");
			pubScent.setSpecialName("主体综合库");
			pubScent.setEstDate(pubScentBack.getEstDate()==null?null:pubScentBack.getEstDate());
			pubScent.setTaskUid(pubScentBack.getTaskUid());
			pubScent.setRelateUserUid(isEmpty(pubScentBack.getRelateUserUid()));
			pubScent.setDrSpeaialUid(isEmpty(pubScentBack.getDrSpeaialUid()));
			pubScent.setCheckDeptCode(isEmpty(pubScentBack.getCheckDeptCode()));
			pubScent.setCheckDeptName(isEmpty(pubScentBack.getCheckDeptName()));
			pubScentMapper.insertSelective(pubScent);
		}
	}
	
	/**
	 * 
	 * 描述: 删除抽检结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	@Override
	public void delPubScent(String taskUid) throws Exception {
		Example example = new Example(PubScent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid); 
		pubScentMapper.deleteByExample(example);
	}
	
	/**
	 * 
	 * 描述: 企业分配给具体的部门
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param string
	 */
	@Override
	public void updatePubScent(String taskUid, String deptTaskUid, String specialCode) {
		if(StringUtils.isNotEmpty(taskUid) && StringUtils.isNotEmpty(deptTaskUid) && StringUtils.isNotEmpty(specialCode)){
			Example example = new Example(PubScent.class);
			example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("specialCode", specialCode); 
			PubScent pubScent = new PubScent();
			pubScent.setDeptTaskUid(deptTaskUid);
			pubScentMapper.updateByExampleSelective(pubScent,example);
		}
	}
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param specialCode
	 * @param regOrg
	 * 
	 */
	@Override
	public void updatePubScent(String taskUid, String deptTaskUid,String specialCode, String regOrg) {
		if(StringUtils.isNotEmpty(taskUid) && StringUtils.isNotEmpty(deptTaskUid) && StringUtils.isNotEmpty(specialCode)&& StringUtils.isNotEmpty(regOrg)){
			Example example = new Example(PubScent.class);
			example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("specialCode", specialCode).andEqualTo("regOrg", regOrg); 
			PubScent pubScent = new PubScent();
			pubScent.setDeptTaskUid(deptTaskUid);
			pubScentMapper.updateByExampleSelective(pubScent,example);
		}
	}
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param specialCode
	 * @param checkDeptCode
	 * 
	 */
	@Override
	public void updatePubScentByCheckDeptCode(String taskUid,String deptTaskUid, String specialCode, String checkDeptCode) {
		if(StringUtils.isNotEmpty(taskUid) && StringUtils.isNotEmpty(deptTaskUid) && StringUtils.isNotEmpty(specialCode)&& StringUtils.isNotEmpty(checkDeptCode)){
			Example example = new Example(PubScent.class);
			example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("specialCode", specialCode).andEqualTo("checkDeptCode", checkDeptCode); 
			PubScent pubScent = new PubScent();
			pubScent.setDeptTaskUid(deptTaskUid);
			pubScentMapper.updateByExampleSelective(pubScent,example);
		}
	}
	
	/**
	 * 
	 * 描述: 企业随机分配
	 * @auther chenxin
	 * @date 2017年5月20日  
	 * @param taskUid
	 * @param deptTaskUid
	 * @param string
	 */
	@Override
	public void updatePubScentByRelateUid(String taskUid, String deptTaskUid,String relateUserUid) {
		Example example = new Example(PubScent.class);
		List<String> specialCodes = new ArrayList<String>();
		specialCodes.add("A01");
		specialCodes.add("multiple");
		example.createCriteria().andEqualTo("taskUid", taskUid)
		.andEqualTo("relateUserUid", relateUserUid)
		.andNotIn("specialCode", specialCodes); 
		PubScent pubScent = new PubScent();
		pubScent.setDeptTaskUid(deptTaskUid);
		pubScentMapper.updateByExampleSelective(pubScent,example);
	}
	
	/**
	 * 描述: 查询抽检结果中的某个专项库管辖单位
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	@Override
	public List<String> selectRegOrgsInSpecial(String taskUid,String specialCode)throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskUid", taskUid);
		params.put("specialCode", specialCode);
		return pubScentMapper.selectRegOrgsInSpecial(params);
	}
	
	/**
	 * 描述: 查询抽中企业的企业类型
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	@Override
	public List<String> selectEntTypeCatg(String taskUid) throws Exception {
		return pubScentMapper.selectEntTypeCatg(taskUid);
	}
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的登记机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	@Override
	public List<PubScentDto> selectRegOrgNumInSpecial(String taskUid,String specialCode) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskUid", taskUid);
		params.put("specialCode", specialCode);
		return pubScentMapper.selectRegOrgNumInSpecial(params);
	}
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的抽查机关数量
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	@Override
	public List<PubScentDto> selectCheckNumInSpecial(String taskUid,String specialCode) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskUid", taskUid);
		params.put("specialCode", specialCode);
		return pubScentMapper.selectCheckNumInSpecial(params);
	}
	
	/**
	 * 描述: 查询抽检结果中的某个专项库的监管用户
	 * @auther chenxin
	 * @date 2017年5月20日
	 * @param taskUid
	 * @param specialCode
	 * @return
	 */
	@Override
	public List<PubScentDto> selectUidsNotInSpecial(String taskUid, String[] specialCodes)throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("taskUid", taskUid);
		params.put("specialCodes", specialCodes);
		return pubScentMapper.selectUidsNotInSpecial(params);
	}
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	@Override
	public void savePubScent(PubScentSpecial pubScentSpecial) {
		if(pubScentSpecial != null){
			PubScent pubScent = new PubScent();
			pubScent.setEntName(pubScentSpecial.getEntName());
			pubScent.setPriPID(pubScentSpecial.getPriPID());
			pubScent.setRegNO(pubScentSpecial.getRegNO());
			pubScent.setUniCode(pubScentSpecial.getUniCode());
			pubScent.setRegState(pubScentSpecial.getRegState());
			pubScent.setRegOrg(pubScentSpecial.getRegOrg());
			pubScent.setRegOrgName(pubScentSpecial.getRegOrgName());
			pubScent.setEntTypeCatg(pubScentSpecial.getEntTypeCatg());
			pubScent.setLocalAdm(pubScentSpecial.getLocalAdm());
			pubScent.setLocalAdmName(pubScentSpecial.getLocalAdmName());
			pubScent.setSpecialCode(pubScentSpecial.getSpecialCode());
			pubScent.setSpecialName(pubScentSpecial.getSpecialName());
			pubScent.setEstDate(pubScentSpecial.getEstDate());
			pubScent.setTaskUid(pubScentSpecial.getTaskUid());
			pubScent.setRelateUserUid(pubScentSpecial.getRelateUserUid());
			pubScentMapper.insertSelective(pubScent);
		}
	}
	
	/**
	 * 
	 * 描述: 保存抽取结果
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScent
	 * @return
	 */
	@Override
	public void savePubScent(PubScent pubScent,pubScSpecialLibraryDto pubScSpecialLibraryDto,String taskUid) {
		if(pubScSpecialLibraryDto != null){
			pubScent.setEntName(isEmpty(pubScSpecialLibraryDto.getEntName()));
			pubScent.setPriPID(isEmpty(pubScSpecialLibraryDto.getPriPID()));
			pubScent.setRegNO(isEmpty(pubScSpecialLibraryDto.getRegNO()));
			pubScent.setUniCode(isEmpty(pubScSpecialLibraryDto.getUniCode()));
			pubScent.setRegState(isEmpty(pubScSpecialLibraryDto.getRegState()));
			pubScent.setRegOrg(isEmpty(pubScSpecialLibraryDto.getRegOrg()));
			pubScent.setRegOrgName(isEmpty(pubScSpecialLibraryDto.getRegOrgName()));
			pubScent.setEntTypeCatg(isEmpty(pubScSpecialLibraryDto.getEntType()));
			pubScent.setLocalAdm(isEmpty(pubScSpecialLibraryDto.getLocalAdm()));
			pubScent.setLocalAdmName(isEmpty(pubScSpecialLibraryDto.getLocalAdmName()));
			pubScent.setSpecialCode(isEmpty(pubScSpecialLibraryDto.getSpecialCode()));
			pubScent.setSpecialName(isEmpty(pubScSpecialLibraryDto.getSpecialName()));
			pubScent.setEstDate(pubScSpecialLibraryDto.getEstDate()==null?null:pubScSpecialLibraryDto.getEstDate());
			pubScent.setTaskUid(taskUid);
			pubScent.setRelateUserUid(isEmpty(pubScSpecialLibraryDto.getSetUserUid()));
			pubScentMapper.insertSelective(pubScent);
		}
	}
	
	/**
	 * 描述：判断是否为空
	 * @author chenxin
	 * @date 2017-08-24
	 * @param data
	 * @return
	 */
	private String isEmpty(String data){
		if(StringUtils.isEmpty(data)){
			return null;
		}
		return data;
	}
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业各地市数量
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentDto> selectPubSentDtoListBytaskUId(String taskUid)throws Exception {
		return pubScentMapper.selectPubSentDtoListBytaskUId(taskUid);
	}
	
	/**
	 * 
	 * 描述: 通过任务id查询已抽取的企业
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentDto> selectBytaskUIdAndRegOrg(String regOrg,String taskUid) throws Exception {
		List<PubScentDto> pubScentDtoOrderList = null;
		List<PubScentDto> pubScentDtoList =  pubScentMapper.selectBytaskUIdAndRegOrg(taskUid);
		if("3301".equals(regOrg)){//杭州
			pubScentDtoOrderList = orderByHz(pubScentDtoList);
		}else if("3302".equals(regOrg)){//宁波
			pubScentDtoOrderList = orderByNb(pubScentDtoList);
		}else if("3303".equals(regOrg)){//温州
			pubScentDtoOrderList = orderByWz(pubScentDtoList);
		}else if("3304".equals(regOrg)){//嘉兴
			pubScentDtoOrderList = orderByJx(pubScentDtoList);
		}else if("3305".equals(regOrg)){//湖州
			pubScentDtoOrderList = orderByHuz(pubScentDtoList);
		}else if("3306".equals(regOrg)){//绍兴
			pubScentDtoOrderList = orderBySx(pubScentDtoList);
		}else if("3307".equals(regOrg)){//金华
			pubScentDtoOrderList = orderByJh(pubScentDtoList);
		}else if("3308".equals(regOrg)){//衢州
			pubScentDtoOrderList = orderByQz(pubScentDtoList);
		}else if("3309".equals(regOrg)){//舟山
			pubScentDtoOrderList = orderByZs(pubScentDtoList);
		}else if("3310".equals(regOrg)){//台州	
			pubScentDtoOrderList = orderByTz(pubScentDtoList);
		}else if("3325".equals(regOrg)){//丽水
			pubScentDtoOrderList = orderByLs(pubScentDtoList);
		}
		return pubScentDtoOrderList;
	}
	
	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByLs(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("332500", map));//丽水市本级
		pubScentDtoOrderList.add(getPubScentDto("332527", map));//遂昌县
		pubScentDtoOrderList.add(getPubScentDto("332528", map));//松阳县
		pubScentDtoOrderList.add(getPubScentDto("332526", map));//缙云县
		pubScentDtoOrderList.add(getPubScentDto("332501", map));//莲都区
		pubScentDtoOrderList.add(getPubScentDto("332522", map));//青田县
		pubScentDtoOrderList.add(getPubScentDto("332529", map));//景宁县
		pubScentDtoOrderList.add(getPubScentDto("332523", map));//云和县
		pubScentDtoOrderList.add(getPubScentDto("332525", map));//庆元县
		pubScentDtoOrderList.add(getPubScentDto("332502", map));//龙泉市
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByTz(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("331000", map));//台州市本级
		pubScentDtoOrderList.add(getPubScentDto("331023", map));//天台县
		pubScentDtoOrderList.add(getPubScentDto("331024", map));//仙居县
		pubScentDtoOrderList.add(getPubScentDto("331003", map));//黄岩区
		pubScentDtoOrderList.add(getPubScentDto("331021", map));//玉环县
		pubScentDtoOrderList.add(getPubScentDto("331022", map));//三门县
		pubScentDtoOrderList.add(getPubScentDto("331082", map));//临海市
		pubScentDtoOrderList.add(getPubScentDto("331002", map));//椒江区
		pubScentDtoOrderList.add(getPubScentDto("331005", map));//集聚区
		pubScentDtoOrderList.add(getPubScentDto("331001", map));//开发区
		pubScentDtoOrderList.add(getPubScentDto("331004", map));//路桥区
		pubScentDtoOrderList.add(getPubScentDto("331081", map));//温岭市
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByZs(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330900", map));//舟山市本级
		pubScentDtoOrderList.add(getPubScentDto("330921", map));//岱山县
		pubScentDtoOrderList.add(getPubScentDto("330902", map));//定海区
		pubScentDtoOrderList.add(getPubScentDto("330935", map));//洋山
		pubScentDtoOrderList.add(getPubScentDto("330907", map));//金塘岛
		pubScentDtoOrderList.add(getPubScentDto("330906", map));//新城
		pubScentDtoOrderList.add(getPubScentDto("330908", map));//六横岛
		pubScentDtoOrderList.add(getPubScentDto("330922", map));//嵊泗县
		pubScentDtoOrderList.add(getPubScentDto("330909", map));//海洋产业集聚区
		pubScentDtoOrderList.add(getPubScentDto("330905", map));//普陀山
		pubScentDtoOrderList.add(getPubScentDto("330903", map));//普陀区
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByQz(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330800", map));//衢州市本级
		pubScentDtoOrderList.add(getPubScentDto("330824", map));//开化县
		pubScentDtoOrderList.add(getPubScentDto("330822", map));//常山县
		pubScentDtoOrderList.add(getPubScentDto("330881", map));//江山市
		pubScentDtoOrderList.add(getPubScentDto("330802", map));//柯城区
		pubScentDtoOrderList.add(getPubScentDto("330825", map));//龙游县
		pubScentDtoOrderList.add(getPubScentDto("330821", map));//衢江区
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByJh(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330700", map));//金华市本级
		pubScentDtoOrderList.add(getPubScentDto("330721", map));//金东区
		pubScentDtoOrderList.add(getPubScentDto("330726", map));//浦江县
		pubScentDtoOrderList.add(getPubScentDto("330782", map));//义乌市
		pubScentDtoOrderList.add(getPubScentDto("330783", map));//东阳市
		pubScentDtoOrderList.add(getPubScentDto("330727", map));//磐安县
		pubScentDtoOrderList.add(getPubScentDto("330784", map));//永康市
		pubScentDtoOrderList.add(getPubScentDto("330723", map));//武义县
		pubScentDtoOrderList.add(getPubScentDto("330702", map));//婺城区
		pubScentDtoOrderList.add(getPubScentDto("330703", map));//开发区
		pubScentDtoOrderList.add(getPubScentDto("330705", map));//金华山
		pubScentDtoOrderList.add(getPubScentDto("330781", map));//兰溪市
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderBySx(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330600", map));//绍兴市本级
		pubScentDtoOrderList.add(getPubScentDto("330621", map));//柯桥区
		pubScentDtoOrderList.add(getPubScentDto("330602", map));//越城区
		pubScentDtoOrderList.add(getPubScentDto("330681", map));//诸暨市
		pubScentDtoOrderList.add(getPubScentDto("330604", map));//袍江
		pubScentDtoOrderList.add(getPubScentDto("330682", map));//上虞区
		pubScentDtoOrderList.add(getPubScentDto("330683", map));//嵊州市
		pubScentDtoOrderList.add(getPubScentDto("330624", map));//新昌县
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByHuz(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330500", map));//湖州市本级
		pubScentDtoOrderList.add(getPubScentDto("330522", map));//长兴县
		pubScentDtoOrderList.add(getPubScentDto("330509", map));//度假区
		pubScentDtoOrderList.add(getPubScentDto("330503", map));//吴兴区
		pubScentDtoOrderList.add(getPubScentDto("330504", map));//南浔区
		pubScentDtoOrderList.add(getPubScentDto("330508", map));//开发区
		pubScentDtoOrderList.add(getPubScentDto("330521", map));//德清县
		pubScentDtoOrderList.add(getPubScentDto("330523", map));//安吉县
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByJx(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330400", map));//嘉兴市本级
		pubScentDtoOrderList.add(getPubScentDto("330402", map));//南湖区
		pubScentDtoOrderList.add(getPubScentDto("330421", map));//嘉善县
		pubScentDtoOrderList.add(getPubScentDto("330403", map));//开发区
		pubScentDtoOrderList.add(getPubScentDto("330403", map));//港区
		pubScentDtoOrderList.add(getPubScentDto("330482", map));//平湖市
		pubScentDtoOrderList.add(getPubScentDto("330424", map));//海盐县
		pubScentDtoOrderList.add(getPubScentDto("330481", map));//海宁市
		pubScentDtoOrderList.add(getPubScentDto("330483", map));//桐乡市
		pubScentDtoOrderList.add(getPubScentDto("330411", map));//秀洲区
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByWz(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330300", map));//温州市本级
		pubScentDtoOrderList.add(getPubScentDto("330324", map));//永嘉县
		pubScentDtoOrderList.add(getPubScentDto("330302", map));//鹿城区
		pubScentDtoOrderList.add(getPubScentDto("330304", map));//瓯海区
		pubScentDtoOrderList.add(getPubScentDto("330328", map));//文成县
		pubScentDtoOrderList.add(getPubScentDto("330329", map));//泰顺县
		pubScentDtoOrderList.add(getPubScentDto("330306", map));//直属管理分局
		pubScentDtoOrderList.add(getPubScentDto("330305", map));//开发区
		pubScentDtoOrderList.add(getPubScentDto("330382", map));//乐清市
		pubScentDtoOrderList.add(getPubScentDto("330307", map));//瓯江口
		pubScentDtoOrderList.add(getPubScentDto("330303", map));//龙湾区
		pubScentDtoOrderList.add(getPubScentDto("330322", map));//洞头县
		pubScentDtoOrderList.add(getPubScentDto("330381", map));//瑞安市
		pubScentDtoOrderList.add(getPubScentDto("330326", map));//平阳县
		pubScentDtoOrderList.add(getPubScentDto("330327", map));//苍南县
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByNb(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330200", map));//宁波市本级
		pubScentDtoOrderList.add(getPubScentDto("330282", map));//慈溪市
		pubScentDtoOrderList.add(getPubScentDto("330205", map));//江北区
		pubScentDtoOrderList.add(getPubScentDto("330211", map));//镇海区
		pubScentDtoOrderList.add(getPubScentDto("330206", map));//北仑区
		pubScentDtoOrderList.add(getPubScentDto("330227", map));//鄞州区
		pubScentDtoOrderList.add(getPubScentDto("330225", map));//象山县
		pubScentDtoOrderList.add(getPubScentDto("330226", map));//宁海县
		pubScentDtoOrderList.add(getPubScentDto("330283", map));//奉化区
		pubScentDtoOrderList.add(getPubScentDto("330203", map));//海曙区
		pubScentDtoOrderList.add(getPubScentDto("330281", map));//余姚市
		return pubScentDtoOrderList;
	}

	/**
	 * 描述：生成地图数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param pubScentDtoList
	 * @return
	 */
	private List<PubScentDto> orderByHz(List<PubScentDto> pubScentDtoList) {
		List<PubScentDto> pubScentDtoOrderList = new ArrayList<PubScentDto>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(PubScentDto pubScentDto : pubScentDtoList){
			if(StringUtils.isNotEmpty(pubScentDto.getRegOrg())){
				map.put(pubScentDto.getRegOrg(), pubScentDto.getSpecialNum());
			}
		}
		pubScentDtoOrderList.add(getPubScentDto("330100", map));//杭州市本级
		pubScentDtoOrderList.add(getPubScentDto("330105", map));//拱墅区
		pubScentDtoOrderList.add(getPubScentDto("330106", map));//西湖区
		pubScentDtoOrderList.add(getPubScentDto("330194", map));//景区
		pubScentDtoOrderList.add(getPubScentDto("330184", map));//余杭区
		pubScentDtoOrderList.add(getPubScentDto("330104", map));//江干区
		pubScentDtoOrderList.add(getPubScentDto("330198", map));//经开区
		pubScentDtoOrderList.add(getPubScentDto("330199", map));//大江东
		pubScentDtoOrderList.add(getPubScentDto("330103", map));//下城区
		pubScentDtoOrderList.add(getPubScentDto("330102", map));//上城区
		pubScentDtoOrderList.add(getPubScentDto("330181", map));//萧山区
		pubScentDtoOrderList.add(getPubScentDto("330108", map));//滨江区
		pubScentDtoOrderList.add(getPubScentDto("330183", map));//富阳区
		pubScentDtoOrderList.add(getPubScentDto("330122", map));//桐庐县
		pubScentDtoOrderList.add(getPubScentDto("330182", map));//建德市
		pubScentDtoOrderList.add(getPubScentDto("330127", map));//淳安县
		pubScentDtoOrderList.add(getPubScentDto("330185", map));//临安区
		return pubScentDtoOrderList;
	}

	/**
	 * 描述:按照页面排序生成数据
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param regOrg
	 * @param map
	 * @return
	 */
	private PubScentDto getPubScentDto(String regOrg,Map<String,Integer> map){
		PubScentDto pubScentDto = new PubScentDto();
		pubScentDto.setRegOrg(regOrg);
		int num = 0;
		if(map.get(regOrg) != null && map.get(regOrg) > 0){
			num = map.get(regOrg);
		}
		pubScentDto.setSpecialNum(num);
		return pubScentDto;
	}

	/**
	 * 
	 * 描述: 通过查询已抽取的企业进行滚动
	 * @auther chenxin
	 * @date 2017年5月20日 
	 * @param deptTaskUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScent> selectPubSentListBytaskUId(String taskUid)throws Exception {
		return pubScentMapper.selectPubSentListBytaskUId(taskUid);
	}
	
	/**
	 * 描述：只用来处理人工分配抽查任务
	 * @param taskUid
	 * @param entName
	 * @return
	 */
	@Override
	public PubScent selectEntByEntNameTaskUid(String taskUid, String entName) {
		Example example = new Example(PubScent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("entName", entName); 
		return pubScentMapper.selectByExample(example).get(0);
	}
	
	/**
	 * 描述：只用来处理人工分配抽查任务
	 * @param taskUid
	 * @param entName
	 * @return
	 */
	@Override
	public PubScent selectEntByPriPIDTaskUid(String taskUid, String priPID) {
		Example example = new Example(PubScent.class);
		example.createCriteria().andEqualTo("taskUid", taskUid).andEqualTo("priPID", priPID); 
		return pubScentMapper.selectByExample(example).get(0);
	}
	
	/**
	 * 描述：任务指派列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentDto> queryPageResult(PageRequest request,SysUserDto sysUserDto)throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
//		String deptCode = "2".equals(sysUserDto.getUserType()) ? sysUserDto.getSysDepart().getAdcode()
//				: sysUserDto.getDepartMent().getDeptCode();
//		if(deptCode.length() > 8){
//			deptCode = deptCode.substring(0, 8);
//		}else if (deptCode.length() == 6){
//			deptCode = deptCode+"00";
//		}
//		params.put("unitDeptCode", deptCode);
		return pubScentMapper.selectAppointEntList(request.getParams());
	}
	
	/**
	 * 描述：查询已企业列表
	 *
	 * @author chenxin
	 * @date 2017年7月4日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<PubScentDto> queryEntPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentMapper.selectRandomEntList(request.getParams());
	}
	
	/**
	 * 描述：任务指派
	 *
	 * @author chenxin
	 * @date 2017年7月4日 
	 * @param pubScentDto
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean doAppointEnts(String uids,String appointLocalAdm, SysUserDto sysUserDto)throws Exception {
		if(StringUtils.isNotEmpty(uids) && StringUtils.isNotEmpty(appointLocalAdm)){
			String[] uidArr = uids.split(",");
			for(String uid : uidArr){
				doAppointEnt(uid,appointLocalAdm,sysUserDto);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：任务指派
	 *
	 * @author chenxin
	 * @date 2017年7月4日 
	 * @param uid
	 * @param appointLocalAdm
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean doAppointEnt(String uid,String appointLocalAdm,SysUserDto sysUserDto)throws Exception {
		//1.先获取当前企业抽取信息
		PubScent oldPubScent = selectPubScentByUid(uid);
		if(oldPubScent != null){
			/** 老任务处理 */
			//2.查询企业对应的(老的)抽查任务的信息
			String oldDeptTaskUid = oldPubScent.getDeptTaskUid();//检查部门uid
			PubScdeptTask oldPst = pubScdeptTaskService.selectPubScdeptTaskByUid(oldDeptTaskUid);
			//先判断是否调整后的机关和调整前一样,如果一样则无需调整
			if(StringUtils.isEmpty(appointLocalAdm) || oldPst.getUnitDeptCode().equals(appointLocalAdm)){
				return false;
			}
			int oldEntNum = oldPst.getEntNum();
			if(oldEntNum > 1){
				//3.更新任务表检查企业数量(老的)
				oldEntNum = oldEntNum - 1 ;
				oldPst.setEntNum(oldEntNum);
				pubScdeptTaskService.updatePubScdeptTask(oldPst);
			}else if(oldEntNum == 1){
				//4.删除当前任务(老的)
				pubScdeptTaskService.deleteByUid(oldDeptTaskUid);
			}else{
				return false;
			}
			
			/** 新任务处理  */
			//5.根据taskuid和appointLocalAdm查询是否已经有任务存在。
			String taskUid = oldPubScent.getTaskUid();
			String priPID = oldPubScent.getPriPID();
			PubScdeptTask newPst = pubScdeptTaskService.selectByTaskUidAndUnitDeptCode(taskUid,appointLocalAdm);
			String newDeptTaskUid = "";
			String newDeptState = "";
			boolean existFlag = false;
			if(newPst == null){
				//如果不存在则新增任务
				PubScdeptTask params = new PubScdeptTask();
				params.setTaskUid(taskUid);
				params.setEntNum(1);
				params.setDeptCode(appointLocalAdm.substring(0,6));
				params.setUnitDeptCode(appointLocalAdm);
				params.setDeptState("1");
				pubScdeptTaskService.savePubScdeptTask(params);
				newDeptTaskUid = params.getUid();
				newDeptState = "1";
			}else{
				//【特殊的：如果新的任务已经存在企业那么不做修改】
				newDeptTaskUid = newPst.getUid();
				Example example = new Example(PubScent.class);
				example.createCriteria().andEqualTo("deptTaskUid", newDeptTaskUid).andEqualTo("priPID", priPID);
				int count = pubScentMapper.selectCountByExample(example);
				if(count > 0){
					existFlag = true;
					PubScent newPubScent = new PubScent();
					newPubScent.setAdjustTime(new Date());
					newPubScent.setAdjustUserName(sysUserDto.getRealName());
					newPubScent.setAdjustUserUid(sysUserDto.getId());
					pubScentMapper.updateByExampleSelective(newPubScent, example);
				}else{
					//如果存在则更新检查表企业数量
					int newEntNum = newPst.getEntNum();
					newEntNum = newEntNum + 1;
					newPst.setEntNum(newEntNum);
					//如果检查任务状态已经是完成状态，需要恢复任务状态为2
					if("3".equals(newPst.getDeptState())){
						newPst.setDeptState("2");
					}
					pubScdeptTaskService.updatePubScdeptTask(newPst);
				}
				newDeptState = newPst.getDeptState();
			}
			//6.删除当前企业对应的执法人员表信息(cs_pub_scent_agent)
			pubScentAgentService.deleteByTaskUidAndPriPID(oldDeptTaskUid,priPID);
			//7.更新cs_pub_scent表处理（deptTaskUid）调整人，调整时间【特殊的：如果新的任务已经存在该企业，那么直接删除企业】
			Example example = new Example(PubScent.class);
			example.createCriteria().andEqualTo("uid", oldPubScent.getUid());
			if(existFlag){
				pubScentMapper.deleteByExample(example);
			}else{
				PubScent newPubScent = new PubScent();
				newPubScent.setDeptTaskUid(newDeptTaskUid);
				newPubScent.setAdjustTime(new Date());
				newPubScent.setAdjustUserName(sysUserDto.getRealName());
				newPubScent.setAdjustUserUid(sysUserDto.getId());
				pubScentMapper.updateByExampleSelective(newPubScent, example);
			}
			//8.更新结果表指派给新的检查部门（taskUid）
			if("2".equals(oldPst.getDeptState())){
				//如果老的任务已经抽取过执法人员则做更新
				if("2".equals(newDeptState) && !existFlag){//【特殊的：如果新的任务已经存在企业，那么直接删除任务,否则更新】
					pubScentResultService.appointEntResult(oldDeptTaskUid,priPID,newDeptTaskUid,uid);
				}else{
					pubScentResultService.deleteByTaskUidAndPriPID(oldDeptTaskUid,priPID,uid);
				}
			}else if("1".equals(oldPst.getDeptState())){
				//如果没有抽取过，则判断是否新任务已经抽取过执法人员，新任务已抽取过执法人员则新增
				if("2".equals(newDeptState) && !existFlag){//【特殊的：如果新的任务已经存在企业，那么直不需要新增】
					PubScentResult pubScentResult = new PubScentResult();
					pubScentResult.setMainTaskUid(taskUid);
					pubScentResult.setTaskUid(newDeptTaskUid);
					pubScentResult.setPriPID(priPID);
					pubScentResult.setAuditState("1");
					pubScentResult.setScentUid(uid);;
					pubScentResultService.savePubScentResult(pubScentResult);
				}
			}
			//9.清空结果表检查事项记录
			pubSccheckItemResultService.deleteByTaskUidAndPriPID(oldDeptTaskUid,priPID);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：根据uid查询企业信息
	 *
	 * @author chenxin
	 * @date 2017年7月4日  
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@Override
	public PubScent selectPubScentByUid(String uid)throws Exception {
		PubScent pubScent = new PubScent();
		pubScent.setUid(uid);
		return pubScentMapper.selectOne(pubScent);
	}
	
	/**
	 * 描述：统计一次任务所有企业所属的状态
	 * @author chenxin
	 * @date 22017-07-22
	 * @param taskUid
	 * @return
	 */
	@Override
	public PubScentDto selectEntCountByTaskUid(String taskUid) {
		return pubScentMapper.selectEntCountByTaskUid(taskUid);
	}
}