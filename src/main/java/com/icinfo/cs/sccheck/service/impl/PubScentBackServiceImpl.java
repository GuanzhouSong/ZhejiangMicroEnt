/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.drcheck.dto.pubScSpecialLibraryDto;
import com.icinfo.cs.drcheck.mapper.pubScSpecialLibraryMapper;
import com.icinfo.cs.drcheck.model.pubScSpecialLibrary;
import com.icinfo.cs.drcheck.service.IpubScSpecialLibraryService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.registinfo.service.IRegistMarkService;
import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.dto.PubScentBackDto;
import com.icinfo.cs.sccheck.mapper.PubScdeptTaskMapper;
import com.icinfo.cs.sccheck.mapper.PubScentBackMapper;
import com.icinfo.cs.sccheck.mapper.PubScentResultMapper;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.cs.sccheck.model.PubScPlanTask;
import com.icinfo.cs.sccheck.model.PubScdeptTask;
import com.icinfo.cs.sccheck.model.PubScent;
import com.icinfo.cs.sccheck.model.PubScentBack;
import com.icinfo.cs.sccheck.model.PubScentCondition;
import com.icinfo.cs.sccheck.model.PubScentResult;
import com.icinfo.cs.sccheck.service.IDrandomSpecialEntService;
import com.icinfo.cs.sccheck.service.IPubScPlanTaskService;
import com.icinfo.cs.sccheck.service.IPubSccheckItemService;
import com.icinfo.cs.sccheck.service.IPubScdeptTaskService;
import com.icinfo.cs.sccheck.service.IPubScentBackService;
import com.icinfo.cs.sccheck.service.IPubScentConditionService;
import com.icinfo.cs.sccheck.service.IPubScentResultService;
import com.icinfo.cs.sccheck.service.IPubScentService;
import com.icinfo.cs.sccheck.service.IPubScentSpecialService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_pub_scent_back 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年05月17日
 */
@Service
public class PubScentBackServiceImpl extends MyBatisServiceSupport implements IPubScentBackService {
	
	@Autowired 
	private PubScentBackMapper pubScentBackMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private pubScSpecialLibraryMapper pubScSpecialLibraryMapper;
	@Autowired
	private IRegistMarkService registMarkService;
	@Autowired
	private IPubScentConditionService pubScentConditionService;
	@Autowired
	private IPubScentService pubScentService;
	@Autowired
	private IPubScentSpecialService pubScentSpecialService;
	@Autowired
	private IPubScdeptTaskService pubScdeptTaskService;
	@Autowired
	private IPubScPlanTaskService pubScPlanTaskService;
	@Autowired
	private IPubScentResultService pubScentResultService;
	@Autowired
	private PubScentResultMapper pubScentResultMapper;
	@Autowired
	private PubScdeptTaskMapper pubScdeptTaskMapper;
	@Autowired
	private IpubScSpecialLibraryService pubScSpecialLibraryService;
	@Autowired
	private IPubSccheckItemService pubSccheckItemService;
	@Autowired
	private IDrandomSpecialEntService drandomSpecialEntService;
	
	/**
     * 描述：分页查询待抽检库列表
     * @author chenxin
     * @date 2017-05-17
     * @param request
     * @return List<PubScentBackDto>
     * @throws Exception
     */
	@Override
	public List<PubScentBackDto> queryPubScentBackDtoPage(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return pubScentBackMapper.selectPubScentBackDtoList(request.getParams());
	}
	
	/**
	 * 描述：批量保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param PubScentBackDto
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doAddBatch(PubScentBackDto PubScentBackDto,SysUserDto sysUser) throws Exception {
		if(CollectionUtils.isNotEmpty(PubScentBackDto.getPriPIDs())){
			String taskUid = PubScentBackDto.getTaskUid();
			for(String priPIDStr : PubScentBackDto.getPriPIDs()){
				String priPID = "";
				String drSpecialUid = "";
				if(StringUtils.isNotEmpty(priPIDStr) && priPIDStr.split(",").length >1){
					priPID = priPIDStr.split(",")[0];
					drSpecialUid = priPIDStr.split(",")[1];
				}else{
					priPID = priPIDStr;
				}
				if(checkExist(PubScentBackDto.getTaskUid(), priPID)){
					if(StringUtils.isNotEmpty(drSpecialUid)){
						DrandomSpecialEnt drandomSpecialEnt = drandomSpecialEntService.selectByUid(drSpecialUid);
						savePubScentBack(taskUid,drandomSpecialEnt,priPID);
					}else{
						savePubScentBack(priPID, taskUid, null);
					}
				}
			}
			pubScentConditionService.doSaveOrUpdateCondition(taskUid, sysUser);
			return true;
		}
		return false;
	}
	

	/**
	 * 描述：保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param priPID
	 * @throws Exception
	 */
	private boolean savePubScentBack(String taskUid,DrandomSpecialEnt dse,String priPID) throws Exception {
		MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		if(dse != null){
			PubScentBack pubScentBack = new PubScentBack();
			pubScentBack.setTaskUid(taskUid);
			pubScentBack.setPriPID(midBaseInfoDto.getPriPID());
			pubScentBack.setEntName(midBaseInfoDto.getEntName());
			pubScentBack.setEntTypeCatg(midBaseInfoDto.getEntTypeCatg());
			pubScentBack.setRegNO(midBaseInfoDto.getRegNO());
			pubScentBack.setUniCode(midBaseInfoDto.getUniCode());
			pubScentBack.setRegOrg(midBaseInfoDto.getRegOrg());
			pubScentBack.setRegOrgName(midBaseInfoDto.getRegOrgName());
			pubScentBack.setLocalAdm(midBaseInfoDto.getLocalAdm());
			pubScentBack.setLocalAdmName(midBaseInfoDto.getLocalAdmName());
			pubScentBack.setRegState(midBaseInfoDto.getRegState());
			pubScentBack.setEstDate(midBaseInfoDto.getEstDate());
			pubScentBack.setDrSpeaialUid(dse.getUid());
			pubScentBack.setCheckDeptCode(dse.getCheckDeptCode());
			pubScentBack.setCheckDeptName(dse.getCheckDeptName());
			pubScentBack.setSpecialCode("multiple");
			pubScentBack.setSpecialName("主体综合库");
			pubScentBack.setSetTime(new Date());
			if(pubScentBackMapper.insertSelective(pubScentBack) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 描述：统计专项检查对象库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param map
	 * @throws Exception
	 */
	@Override
	public int doCountSpecial(Map<String, Object> params) throws Exception {
		// 专项库
    	if(params.get("specialCode")!=null && !params.get("specialCode").toString().equals("")){
    		params.put("specialCodes", params.get("specialCode").toString().split(","));
    	}
    	// 监管标签
    	if(params.get("markCode")!=null && !params.get("markCode").toString().equals("")){
    		params.put("markCodes", params.get("markCode").toString().split(","));
    	}
    	if(params.get("licName")!=null && !params.get("licName").toString().equals("")){
    		params.put("licNames", params.get("licName").toString().split(","));
    	}
		return pubScSpecialLibraryMapper.selectScSpecialCount(params);
	}
	
	/**
	 * 描述：导入专项检查对象库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param map
	 * @throws Exception
	 */
	@Override
	public boolean doAddSpecial(Map<String, Object> params) throws Exception {
		if(params != null && params.get("taskUid") != null){
			String taskUid = params.get("taskUid").toString();
			// 专项库
	    	if(params.get("specialCode")!=null && !params.get("specialCode").toString().equals("")){
	    		params.put("specialCodes", params.get("specialCode").toString().split(","));
	    	}
	    	// 监管标签
	    	if(params.get("markCode")!=null && !params.get("markCode").toString().equals("")){
	    		params.put("markCodes", params.get("markCode").toString().split(","));
	    	}
	    	if(params.get("licName")!=null && !params.get("licName").toString().equals("")){
	    		params.put("licNames", params.get("licName").toString().split(","));
	    	}
			List<pubScSpecialLibrary> pubScSpecialLibraryList = pubScSpecialLibraryMapper.selectScSpecialList(params);
			if(CollectionUtils.isNotEmpty(pubScSpecialLibraryList)){
				for(pubScSpecialLibrary scSpecialLibrary : pubScSpecialLibraryList){
					if(checkExist(taskUid, scSpecialLibrary.getPriPID())){
						savePubScentBack(scSpecialLibrary.getPriPID(), taskUid,null);
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：跨部门导入待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param drandomSpecialEntDtoList
	 * @param taskUid
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean saveSpecialEnts(List<DrandomSpecialEntDto> drandomSpecialEntDtoList,String taskUid,SysUserDto sysUserDto) throws Exception {
		for(DrandomSpecialEntDto dse : drandomSpecialEntDtoList){
			if(checkExist(taskUid, dse.getPriPID())){
				savePubScentBack(taskUid,dse);
			}
		}
		pubScentConditionService.doSaveOrUpdateCondition(taskUid, sysUserDto);
		return true;
	}
	
	/**
	 * 描述：保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param priPID
	 * @throws Exception
	 */
	private boolean savePubScentBack(String taskUid,DrandomSpecialEntDto dse) throws Exception {
		if(dse != null){
			PubScentBack pubScentBack = new PubScentBack();
			pubScentBack.setTaskUid(taskUid);
			pubScentBack.setPriPID(dse.getPriPID());
			pubScentBack.setEntName(dse.getEntName());
			pubScentBack.setEntTypeCatg(dse.getEntTypeCatg());
			pubScentBack.setRegNO(dse.getRegNO());
			pubScentBack.setUniCode(dse.getUniCode());
			pubScentBack.setRegOrg(dse.getRegOrg());
			pubScentBack.setRegOrgName(dse.getRegOrgName());
			pubScentBack.setLocalAdm(dse.getLocalAdm());
			pubScentBack.setLocalAdmName(dse.getLocalAdmName());
			pubScentBack.setRegState(dse.getRegState());
			pubScentBack.setEstDate(dse.getEstDate());
			pubScentBack.setDrSpeaialUid(dse.getUid());
			pubScentBack.setCheckDeptCode(dse.getCheckDeptCode());
			pubScentBack.setCheckDeptName(dse.getCheckDeptName());
			pubScentBack.setSpecialCode("multiple");
			pubScentBack.setSpecialName("主体综合库");
			pubScentBack.setSetTime(new Date());
			if(pubScentBackMapper.insertSelective(pubScentBack) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 检查是否已导入专项库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param priPID
	 * @param markCode
	 * @return
	 */
	@Override
	public boolean checkExist(String taskUid,String priPID,String specialCode){
		if(StringUtils.isEmpty(taskUid) || StringUtils.isEmpty(priPID)){
			return false;
		}
		Example example = new Example(PubScentBack.class);
		example.createCriteria()
		.andEqualTo("taskUid", taskUid)
		.andEqualTo("priPID", priPID);
		int in = pubScentBackMapper.selectCountByExample(example);
		if(in > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 批量导入待抽检库：判断企业是否已经存在.
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param priPID
	 * @return
	 */
	public boolean checkExist(String taskUid, String priPID) {
		if(StringUtils.isEmpty(taskUid) || StringUtils.isEmpty(priPID)){
			return false;
		}
		Example example = new Example(PubScentBack.class);
		example.createCriteria()
		.andEqualTo("taskUid", taskUid)
		.andEqualTo("priPID", priPID);
		int in = pubScentBackMapper.selectCountByExample(example);
		if(in > 0){
			return false;
		}
		return true;
	}
	
	/**
	 * 描述：excel批量导入待抽检库(备用分配)
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public JSONObject doAddExcelBatchBack(InputStream in, String taskUid,String deptTaskUid) throws Exception {
		JSONObject json = new JSONObject();
		String message = "";
		//解析excel
		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows < 2) {
			json.put("status", "error");
        	json.put("message", "excel模板无数据。");
			return json;
		}
		int count = 0;
		// 遍历处理每行
		for (int i = 1; i < rows; i++) {
			Row row = sheet.getRow(i);
			String entName = ExcelUtil.getCellContent11(row.getCell(4));
			String deptCode = ExcelUtil.getCellContent11(row.getCell(0));
			//查询是否任务存在
			if(StringUtils.isEmpty(entName) || StringUtils.isEmpty(deptCode)){
				continue;
			}
			deptCode = deptCode.replace(".0", "");
			PubScdeptTask prams = new PubScdeptTask();
			prams.setTaskUid(taskUid);
			prams.setDeptCode(deptCode);
			PubScdeptTask pubScdeptTask = pubScdeptTaskMapper.selectOne(prams);
			if(pubScdeptTask == null){
				message += "第"+(i+1)+"行"+deptCode+"编码不存在任务<br/>";
				continue;
			}
//			int checkNum = pubScdeptTask.getCheckNum();
			int entNum = pubScdeptTask.getEntNum();
			PubScent pubScent = pubScentService.selectEntByEntNameTaskUid(taskUid,entName);
			String pripid = pubScent.getPriPID();
			//查询是否已经抽取执法人员
			Example example = new Example(PubScentResult.class);
			example.createCriteria()
			.andEqualTo("taskUid", pubScdeptTask.getUid())
			.andEqualTo("priPID", pripid);
			if(pubScentResultMapper.selectCountByExample(example) > 0){
				message += "第"+(i+1)+"行"+entName+"已存在任务<br/>";
				continue;
			}
			PubScentResult pubScentResult = new PubScentResult();
			pubScentResult.setPriPID(pripid);
			pubScentResult.setTaskUid(pubScdeptTask.getUid());
			pubScentResult.setAuditState("1");
			pubScentResultMapper.insertSelective(pubScentResult);
			entNum++;
			//更新任务表信息
			PubScdeptTask pubScdeptTasks = new PubScdeptTask();
			pubScdeptTasks.setId(pubScdeptTask.getId());;
			pubScdeptTasks.setEntNum(entNum);
			pubScdeptTaskMapper.updateByPrimaryKeySelective(pubScdeptTasks);
			count++;
		}
		if(StringUtils.isEmpty(message)){
			json.put("status", "success");
			json.put("message", "成功"+count+"条");
		}else{
			json.put("status", "error");
			json.put("message", message);
		}
		return json;
	}
	
	/**
	 * 描述：excel批量导入待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public JSONObject doAddExcelBatch(InputStream in, String taskUid,SysUserDto sysUser) throws Exception {
		JSONObject json = new JSONObject();
		String message = "";
		int sucNum = 0;
		int failNUm = 0;
		if(in != null && StringUtils.isNotEmpty(taskUid)){
			//解析excel
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows < 2) {
				json.put("status", "error");
	        	json.put("message", "excel模板无数据。");
				return json;
			}
			List<String> regNOList = new ArrayList<String>();
			// 遍历处理每行
			for (int i = 2; i < rows; i++) {
				Row row = sheet.getRow(i);
				if (row == null || row.getCell(0) == null) {
					message += "第"+(i+1)+"行.无数据；<br/>";
					failNUm++;
					continue;
				}
				String regNO = ExcelUtil.getCellContent(row.getCell(0));
				if(StringUtils.isNotEmpty(regNO)){
					if(regNOList.contains(regNO)){
						message += "第"+(i+1)+"行注册号.【"+row.getCell(0)+"】excel重复记录；<br/>";
						failNUm++;
						continue;
					}
					regNOList.add(regNO);
					MidBaseInfoDto midBaseinfo = midBaseInfoService.selectMidBaseInfoByRegNOHold(regNO);
					if(midBaseinfo == null){
						message += "第"+(i+1)+"行.【"+row.getCell(0)+"】注册号/统一社会信用代码查询不到企业；<br/>";
						failNUm++;
					}else{
						if(checkExist(taskUid, midBaseinfo.getPriPID())){
	    					savePubScentBack(midBaseinfo,taskUid);
	    					sucNum++;
	    				}else{
	    					message += "第"+(i+1)+"行.【"+row.getCell(0)+"】待抽检库已存在；<br/>";
	    					failNUm++;
	    				}
					}
				}else{
					message += "第"+(i+1)+"行.【"+row.getCell(0)+"】注册号/统一社会信用代码为空；<br/>";
					failNUm++;
				}
			}
			pubScentConditionService.doSaveOrUpdateCondition(taskUid, sysUser);
		}
		if(StringUtils.isEmpty(message)){
			json.put("status", "success");
		}else{
			json.put("status", "error");
			if(failNUm > 0){
				message = "导入失败"+failNUm+"家；提示如下：<br/>"+message;
			}
			if(sucNum > 0){
				message = "成功导入"+sucNum+"家；<br/>"+message;
			}
        	json.put("message", message);
		}
		return json;
	}
	
	/**
	 * 描述：保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param priPID
	 * @throws Exception
	 */
	private void savePubScentBack(MidBaseInfoDto midBaseinfo,String taskUid) throws Exception {
		PubScentBack pubScentBack = new PubScentBack();
		pubScentBack.setTaskUid(taskUid);
		pubScentBack.setPriPID(midBaseinfo.getPriPID());
		pubScentBack.setEntName(midBaseinfo.getEntName());
		pubScentBack.setEntTypeCatg(midBaseinfo.getEntTypeCatg());
		pubScentBack.setRegNO(midBaseinfo.getRegNO());
		pubScentBack.setUniCode(midBaseinfo.getUniCode());
		pubScentBack.setRegOrg(midBaseinfo.getRegOrg());
		pubScentBack.setRegOrgName(midBaseinfo.getRegOrgName());
		pubScentBack.setLocalAdm(midBaseinfo.getLocalAdm());
		pubScentBack.setLocalAdmName(midBaseinfo.getLocalAdmName());
		pubScentBack.setSliceNO(midBaseinfo.getSliceNO());
		pubScentBack.setSliceNOName(midBaseinfo.getSliceNOName());
		pubScentBack.setRegState(midBaseinfo.getRegState());
		pubScentBack.setEstDate(midBaseinfo.getEstDate());
		pubScentBack.setSpecialCode("multiple");
		pubScentBack.setSpecialName("主体综合库");
		pubScentBackMapper.insertSelective(pubScentBack);
	}
	
	/**
	 * 描述：保存待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param priPID
	 * @throws Exception
	 */
	private boolean savePubScentBack(String priPID,String taskUid,String drSpeaialUid) throws Exception {
		if(StringUtils.isNotEmpty(priPID)){
			MidBaseInfoDto midBaseInfoDto = midBaseInfoService.selectMidBaseInfoByPripid(priPID);
			if(midBaseInfoDto != null){
				PubScentBack pubScentBack = new PubScentBack();
				pubScentBack.setTaskUid(taskUid);
				pubScentBack.setPriPID(midBaseInfoDto.getPriPID());
				pubScentBack.setEntName(midBaseInfoDto.getEntName());
				pubScentBack.setEntTypeCatg(midBaseInfoDto.getEntTypeCatg());
				pubScentBack.setRegNO(midBaseInfoDto.getRegNO());
				pubScentBack.setUniCode(midBaseInfoDto.getUniCode());
				pubScentBack.setRegOrg(midBaseInfoDto.getRegOrg());
				pubScentBack.setRegOrgName(midBaseInfoDto.getRegOrgName());
				pubScentBack.setLocalAdm(midBaseInfoDto.getLocalAdm());
				pubScentBack.setLocalAdmName(midBaseInfoDto.getLocalAdmName());
				pubScentBack.setSliceNO(midBaseInfoDto.getSliceNO());
				pubScentBack.setSliceNOName(midBaseInfoDto.getSliceNOName());
				pubScentBack.setRegState(midBaseInfoDto.getRegState());
				pubScentBack.setEstDate(midBaseInfoDto.getEstDate());
				pubScentBack.setDrSpeaialUid(drSpeaialUid);
				pubScentBack.setSpecialCode("multiple");
				pubScentBack.setSpecialName("主体综合库");
				pubScentBack.setSetTime(new Date());
				if(pubScentBackMapper.insertSelective(pubScentBack) > 0){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 描述：通过主任务表taskUid清除本次任务的所有待抽检库
     * @author chenxin
     * @date 2017-05-17
	 * @param taskUid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doCleanPubScentBack(String taskUid,SysUserDto sysUser) throws Exception {
		if(StringUtils.isEmpty(taskUid)){
			return false;
		}
		Example example=new Example(PubScentBack.class);
        example.createCriteria().andEqualTo("taskUid",taskUid);
        pubScentBackMapper.deleteByExample(example);
        pubScentConditionService.doSaveOrUpdateCondition(taskUid, sysUser);
        return true;
	}
	
	/**
	 * 描述：随机抽取企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @param randomType
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doRandomEntBack(SysUserDto sysUser,String taskUid, String randomType,Map<String,Object> params) throws Exception {
		List<PubScentCondition> pubScentConditionList = pubScentConditionService.selectPubScentConditionList(taskUid,randomType);
		if(CollectionUtils.isNotEmpty(pubScentConditionList) && pubScentConditionList.size() > 0){
			pubScentService.delPubScent(taskUid);
			for(PubScentCondition pubScentCondition : pubScentConditionList){
				//3.随机抽取企业
				if("1".equals(pubScentCondition.getCheckType())){
					randomMain(pubScentCondition,taskUid);
				}else if("2".equals(pubScentCondition.getCheckType())){
					randomSpecial(pubScentCondition,taskUid,params);
				}
			}
			PubScPlanTask pubScPlanTask = new PubScPlanTask();
			pubScPlanTask.setUid(taskUid);
			pubScPlanTask.setRandomDate(new Date());
			pubScPlanTaskService.updatePubScPlanTaskByUid(pubScPlanTask);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：按照主体综合库随机抽取
	 * @author chenxin
	 * @date 2017-05-17
	 * @param pubScentCondition
	 */
	private boolean randomMain(PubScentCondition pubScentCondition,String taskUid)throws Exception {
		//1.判断是否需要抽取
		if(pubScentCondition.getSpecialNum() > 0 && pubScentCondition.getRandomNum() > 0){
			int entTotal = pubScentCondition.getSpecialNum();//该专项库对应的企业数量
			int randomNum = pubScentCondition.getRandomNum();//该专项库对应的需要抽取企业数量
			int limit = 0;
			int step = 5000;
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("taskUid", taskUid);
			//2.全部抽取
			if(entTotal <= randomNum){
		        boolean flag = true;
		        PubScent pubScent = new PubScent();
				while(flag){
					if(limit <= entTotal){
						params.put("limit", limit);
						params.put("step", step);
						List<PubScentBack> pubScentBackList = pubScentBackMapper.selectPubScentBackListForRandom(params);
						for(PubScentBack pubScentBack : pubScentBackList){
							pubScentService.savePubScent(pubScent,pubScentBack);
						}
						limit += step;
					}else{
						flag = false;
					}
				}
			}else{
				//3.计算随机生成数区间
				int range = entTotal/randomNum;
				int mol = entTotal%randomNum;
				if(range >= 2){//跳号抽取
					//4.计算第一个跳号数值
					int num = new Random().nextInt(range)+1;
					int firstNum = num-1;
					params.put("limit", limit);
					params.put("step", step);
					List<PubScentBack> pubScentBackList = pubScentBackMapper.selectPubScentBackListForRandom(params);
					int pageSize = pubScentBackList.size(); 
					PubScent pubScent = new PubScent();
					for(int i=0;i<randomNum;i++){
						if(firstNum >= pageSize){//翻页继续跳号抽取
							limit += step;
							params.put("limit", limit);
							params.put("step", step);
							pubScentBackList = pubScentBackMapper.selectPubScentBackListForRandom(params);
							pageSize = pubScentBackList.size(); 
							firstNum = firstNum - step;
							if(firstNum > 0){
								firstNum = firstNum -1;
							}
						}
						if(firstNum >= pageSize ){
							break;
						}
						pubScentService.savePubScent(pubScent,pubScentBackList.get(firstNum));
						
						firstNum = firstNum + range;
					}
				}else{
					//5.需要抽取的企业超过50%
					if(range == 1 && mol > 0){
						int noRandomNum = entTotal - randomNum;
						int noRandomRange = entTotal / noRandomNum;
						int num = new Random().nextInt(noRandomRange)+1;
						int noFirstNum = num-1;
						int noRandomStepNum = 0;
						boolean flag = true;
						PubScent pubScent = new PubScent();
						while(flag){
							if(limit <= entTotal){
								params.put("limit", limit);
								params.put("step", step);
								List<PubScentBack> pubScentBackList = pubScentBackMapper.selectPubScentBackListForRandom(params);
								int pageSize = pubScentBackList.size();
								int count = 0;
								for(PubScentBack pubScentBack : pubScentBackList){
									if(count == noFirstNum && noRandomStepNum < noRandomNum){//相同的号跳过
										noFirstNum = noFirstNum + noRandomRange;
										noRandomStepNum ++;
									}else{
										pubScentService.savePubScent(pubScent,pubScentBack);
									}
									count ++;
								}
								noFirstNum = noFirstNum - pageSize;
								if(noFirstNum > 0){
									noFirstNum = noFirstNum -1;//翻页之后指标重新指向下一页的第一个需要剔除的位置
								}
								limit += step;
							}else{
								flag = false;
							}
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：按照专项库随机抽取企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param pubScentCondition
	 */
	private boolean randomSpecial(PubScentCondition pubScentCondition,String taskUid,Map<String,Object> params)throws Exception {
		//1.判断是否需要抽取
		if(pubScentCondition.getSpecialNum() > 0 && pubScentCondition.getRandomNum() > 0 && StringUtils.isNotEmpty(taskUid) 
			&& StringUtils.isNotEmpty(pubScentCondition.getCheckCode()) 
			&& StringUtils.isNotEmpty(pubScentCondition.getSpecialCode())){
			int entTotal = pubScentCondition.getSpecialNum();//该专项库对应的企业数量
			int randomNum = pubScentCondition.getRandomNum();//该专项库对应的需要抽取企业数量
			int limit = 0;
			int step = 5000;
			//2.全部抽取
			if(entTotal <= randomNum){
				params.put("checkCode", pubScentCondition.getCheckCode());
				params.put("specialCode", pubScentCondition.getSpecialCode());
				boolean flag = true;
				PubScent pubScent = new PubScent();
				while(flag){
					if(limit <= entTotal){
						params.put("limit", limit);
						params.put("step", step);
						List<pubScSpecialLibraryDto> pubScSpecialLibraryList = pubScSpecialLibraryService.selectPubScSpeListForRandom(params);
						for(pubScSpecialLibraryDto pubScentSpecial : pubScSpecialLibraryList){
							pubScentService.savePubScent(pubScent,pubScentSpecial, taskUid);
						}
						limit += step;
					}else{
						flag = false;
					}
				}
			}else{
				//3.计算随机生成数区间
				int range = entTotal/randomNum;
				int mol = entTotal%randomNum;
				if(range >= 2){//跳号抽取
					params.put("checkCode", pubScentCondition.getCheckCode());
					params.put("specialCode", pubScentCondition.getSpecialCode());
					params.put("limit", limit);
					params.put("step", step);
					List<pubScSpecialLibraryDto> pubScSpecialLibraryList = pubScSpecialLibraryService.selectPubScSpeListForRandom(params);
					int pageSize = pubScSpecialLibraryList.size(); 
					//4.计算第一个跳号数值
					int num = new Random().nextInt(range)+1;
					int firstNum = num-1;
					PubScent pubScent = new PubScent();
					for(int i=0;i<randomNum;i++){
						if(firstNum >= pageSize){//翻页继续跳号抽取
							limit += step;
							params.put("limit", limit);
							params.put("step", step);
							pubScSpecialLibraryList = pubScSpecialLibraryService.selectPubScSpeListForRandom(params);
							pageSize = pubScSpecialLibraryList.size(); 
							firstNum = firstNum - step;
							if(firstNum > 0){
								firstNum = firstNum -1;
							}
						}
						if(firstNum >= pageSize ){
							break;
						}
						pubScentService.savePubScent(pubScent,pubScSpecialLibraryList.get(firstNum), taskUid);
						firstNum = firstNum + range;
					}
				}else{
					//5.需要抽取的企业超过50%,使用排除法，算出每组需要剔除多少个
					if(range == 1 && mol > 0){
						int noRandomNum = entTotal - randomNum;
						int noRandomRange = entTotal / noRandomNum;
						int num = new Random().nextInt(noRandomRange)+1;
						int noFirstNum = num-1;
						int noRandomStepNum = 0;
						boolean flag = true;
						PubScent pubScent = new PubScent();
						while(flag){
							if(limit <= entTotal){
								params.put("checkCode", pubScentCondition.getCheckCode());
								params.put("specialCode", pubScentCondition.getSpecialCode());
								params.put("limit", limit);
								params.put("step", step);
								List<pubScSpecialLibraryDto> pubScSpecialLibraryList = pubScSpecialLibraryService.selectPubScSpeListForRandom(params);
								int pageSize = pubScSpecialLibraryList.size();
								int count = 0;
								for(pubScSpecialLibraryDto pubScentSpecial : pubScSpecialLibraryList){
									if(count == noFirstNum && noRandomStepNum < noRandomNum){//相同的号跳过
										noFirstNum = noFirstNum + noRandomRange;
										noRandomStepNum ++;
									}else{
										pubScentService.savePubScent(pubScent,pubScentSpecial, taskUid);
									}
									count ++;
								}
								noFirstNum = noFirstNum - pageSize;
								if(noFirstNum > 0){
									noFirstNum = noFirstNum -1;//翻页之后指标重新指向下一页的第一个需要剔除的位置
								}
								limit += step;
							}else{
								flag = false;
							}
						}
					}
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：通过主待抽检库表entBackUidList清除本次任务的所有待抽检库
	 * @author chenxin
	 * @date 2017-05-17
	 * @param entBackUidList
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean doCleanPubScentBack(List<String> entBackUidList,String taskUid,SysUserDto sysUser)throws Exception {
		if(CollectionUtils.isNotEmpty(entBackUidList)){
			for(String uid : entBackUidList){
				if(StringUtils.isNotEmpty(uid)){
					Example example=new Example(PubScentBack.class);
					example.createCriteria().andEqualTo("uid",uid);
					pubScentBackMapper.deleteByExample(example);
				}
			}
			pubScentConditionService.doSaveOrUpdateCondition(taskUid, sysUser);
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：统计本次抽查任务专项库数量
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	@Override
	public List<PubScentBackDto> countSpecialTypes(String taskUid) throws Exception {
		if(StringUtils.isNotEmpty(taskUid)){
			return pubScentBackMapper.selectSpecialTypes(taskUid);
		}
		return null;
	}
	
	/**
	 * 描述：统计本次抽查任务专项库去重数量
	 * @author chenxin
	 * @date 2017-05-17
	 * @param in
	 * @param taskUid
	 * @throws Exception
	 */
	@Override
	public int selectEntTotal(String taskUid) throws Exception {
		Example example=new Example(PubScentBack.class);
		example.createCriteria().andEqualTo("taskUid",taskUid);
		return pubScentBackMapper.selectCountByExample(example);
	}
	
	/**
	 * 描述：查询抽取的企业
	 * @author chenxin
	 * @date 2017-05-17
	 * @param taskUid
	 * @return
	 */
	@Override
	public List<PubScentBack> seletPubScentBackList(String taskUid) {
		Example example=new Example(PubScentBack.class);
		example.createCriteria().andEqualTo("taskUid",taskUid);
		return pubScentBackMapper.selectByExample(example);
	}
}