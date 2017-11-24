/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.drcheck.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.icinfo.cs.common.utils.CardUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.PubScagentDto;
import com.icinfo.cs.drcheck.mapper.PubScagentMapper;
import com.icinfo.cs.drcheck.mapper.PubScagentOrderMapper;
import com.icinfo.cs.drcheck.model.PubScagent;
import com.icinfo.cs.drcheck.model.PubScagentOrder;
import com.icinfo.cs.drcheck.service.IPubScagentOrderService;
import com.icinfo.cs.drcheck.service.IPubScagentService;
import com.icinfo.cs.sccheck.model.CodeExpertType;
import com.icinfo.cs.sccheck.model.CodePositionType;
import com.icinfo.cs.sccheck.model.CodeRightType;
import com.icinfo.cs.sccheck.service.ICodeExpertTypeService;
import com.icinfo.cs.sccheck.service.ICodePositionTypeService;
import com.icinfo.cs.sccheck.service.ICodeRightTypeService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.service.IDeptDutycodeRefService;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:  cs_pub_scagent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2016年10月26日
 */
@Service
public class PubScagentServiceImpl extends MyBatisServiceSupport implements IPubScagentService {

    @Autowired
    private PubScagentMapper pubScagentMapper;
    
    @Autowired
    private IPubScagentOrderService pubScagentOrderService;
    
    @Autowired
    private PubScagentOrderMapper pubScagentOrderMapper;
    
    @Autowired
    private IDeptDutycodeRefService deptDutycodeRefService;
    
    @Autowired
    private ICodePositionTypeService codePositionTypeService;

    @Autowired
    private ICodeRightTypeService codeRightTypeService;

    @Autowired
    private ICodeExpertTypeService codeExpertTypeService;
    
	@Override
	public List<PubScagent> selectAll() throws Exception {
		return pubScagentMapper.selectAll();
	}

	@Override
	public List<PubScagentDto> selectByManyCationToListJSON(PageRequest request) {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String,Object> map=request.getParams();  
		//检查事项范围(like)
		if(map!=null){
			if(map.get("agentRangeArr")!=null&&StringUtils.isNotBlank(map.get("agentRangeArr").toString())){
				map.put("agentRanges",map.get("agentRangeArr").toString().split(","));
			}
			//业务部门/机构(in)
			if(map.get("deptCodeArr")!=null&&StringUtils.isNotBlank(map.get("deptCodeArr").toString())){
				map.put("deptCodes",map.get("deptCodeArr").toString().split(","));
			}
			//工作单位(in)
			if(map.get("unitCodeArr")!=null&&StringUtils.isNotBlank(map.get("unitCodeArr").toString())){
				map.put("unitCodes",map.get("unitCodeArr").toString().split(","));
			}
			//从事岗位大类(like)
			if(map.get("deptCatgArr")!=null&&StringUtils.isNotBlank(map.get("deptCatgArr").toString())){
				map.put("deptCatgs",map.get("deptCatgArr").toString().split(","));
			}
			//是否专家(like)
			if(map.get("expertFlagArr")!=null&&StringUtils.isNotBlank(map.get("expertFlagArr").toString())){
				map.put("expertFlags",map.get("expertFlagArr").toString().split(","));
			}
			//岗位资格资质(like)
			if(map.get("stationTermArr")!=null&&StringUtils.isNotBlank(map.get("stationTermArr").toString())){
				map.put("stationTerms",map.get("stationTermArr").toString().split(","));
			}
			//单位层级(in)
			if(map.get("unitLevelArr")!=null&&StringUtils.isNotBlank(map.get("unitLevelArr").toString())){
				map.put("unitLevels",map.get("unitLevelArr").toString().split(","));
			}
			//最高学历(in)
			if(map.get("studyLevelArr")!=null&&StringUtils.isNotBlank(map.get("studyLevelArr").toString())){
				map.put("studyLevels",map.get("studyLevelArr").toString().split(","));
			}
			//执法证(like)
			if(map.get("lawTypeArr")!=null&&StringUtils.isNotBlank(map.get("lawTypeArr").toString())){
				String lawTypeArr = map.get("lawTypeArr").toString();
				if("N,1".equals(lawTypeArr)){
					map.put("law1","1");
				}
				if("N,2".equals(lawTypeArr)){
					map.put("law2","2");
				}
				if("1,2".equals(lawTypeArr)){
					map.put("law3","3");
				}
				if("1".equals(lawTypeArr)){
					map.put("law4","3");
				}
				if("2".equals(lawTypeArr)){
					map.put("law5","3");
				}
				if("N".equals(lawTypeArr)){
					map.put("law6","3");
				}
			}
			//担任职务(in)
			if(map.get("agentPositionArr")!=null&&StringUtils.isNotBlank(map.get("agentPositionArr").toString())){
				String agentPositionArr = map.get("agentPositionArr").toString();
				map.put("agentPositions",agentPositionArr.split(","));
			}
			//岗位所属地区（in）
			if(map.get("agentAreaArr")!=null&&StringUtils.isNotBlank(map.get("agentAreaArr").toString())){
				String agentAreaArr = map.get("agentAreaArr").toString();
				map.put("agentAreas",agentAreaArr.split(","));
			}
			//职能部门编码
			if(map.get("dutyDeptCodes")!=null&&StringUtils.isNotBlank(map.get("dutyDeptCodes").toString())){
				map.put("dutyDeptCodeArr",map.get("dutyDeptCodes").toString().split(","));
			}
		}
		return pubScagentMapper.selectByManyCationToListJSON(map);
	}

	/**
	 * 描述: 保存检查人员信息
	 * @auther yujingwei
	 * @date 2016年11月21日
	 * @param pubScagent
	 * @return int
	 * @throws Exception
	 */	
	public int savePubScagent(PubScagent pubScagent) throws Exception {
		pubScagent.setCreateTime(new Date());
		return pubScagentMapper.insert(pubScagent);
	}
	
	/**
	 * 描述: 保存检查人员信息
	 * @auther chenxin
	 * @date 2016年11月21日
	 * @param pubScagent
	 * @return int
	 * @throws Exception
	 */	
	@Override
	public boolean savePubScagentNoRepeat(PubScagent pubScagent) throws Exception {
		pubScagent.setCreateTime(new Date());
		Example example=new Example(PubScagent.class);
		example.createCriteria().andEqualTo("agentNO",pubScagent.getAgentNO());
		if(pubScagentMapper.selectCountByExample(example) > 0){
			return false;
		}
		pubScagentMapper.insert(pubScagent);
		return true;
	}
	
	/**
	 * 
	 * 描述:excel批量导入
	 * @auther chenxin
	 * @date 2017年02月23日 
	 * @param pubScagent
	 * @return
	 */
	@Override
	public JSONObject saveExcelBatch(InputStream in, SysUserDto sysUser,String localAdm) throws Exception {
		JSONObject json = new JSONObject();
		//转换并检查数据是否正确
		String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		String message = "";
		int num = 1;
		//解析excel
		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows < 4) {
			return null;
		}
		List<PubScagent> pubScagentList = new ArrayList<PubScagent>();
		Map<String,String> areaMap = getAreaMap();
        Map<String,String> unitLevelMap = getUnitLevelMap();
        Map<String,String> expertFlagMap = getExpertFlagMap(sysUser);
        Map<String,String> studyLevelMap = getStudyLevelMap();
        Map<String,String> agentSexMap = getAgentSexMap();
        Map<String,String> deptCatgMap = getDeptCatgMap(sysUser);
        Map<String,String> stationTermMap = getStationTermMap(sysUser);
        Map<String,String> agentPositionMap = getAgentPositionMap();
        Map<String,String> agentStateMap = getAgentStateMap();
        
		// 遍历处理每行
		for (int i = 3; i < rows; i++) {
			try{
				PubScagent pubScagent = new PubScagent();
				Row row = sheet.getRow(i);
				if(row == null){
					continue;
				}
				String employeeNO = ExcelUtil.getCellContent(row.getCell(0));
				if(StringUtils.isNotEmpty(employeeNO)){//工号
					pubScagent.setEmployeeNO(employeeNO.trim());
				}
				String agentName = ExcelUtil.getCellContent(row.getCell(1));
				if(StringUtils.isNotEmpty(agentName)){//姓名
					pubScagent.setAgentName(agentName.trim());
				}
				String agentSex = ExcelUtil.getCellContent(row.getCell(2));
				if(StringUtils.isNotEmpty(agentSex) && agentSexMap.get(agentSex) != null){//性别
					pubScagent.setAgentSex(agentSexMap.get(agentSex.trim()));
				}
				String agentNO = ExcelUtil.getCellContent(row.getCell(3));
				if(StringUtils.isNotEmpty(agentNO)){//证件号码
					pubScagent.setAgentNO(agentNO.trim());
					Map<String, Object> map = CardUtil.getCertNOInfo(agentNO.trim());
					if(map != null){
						if(map.get("age") != null){
							int age = Integer.parseInt((String)map.get("age"));
							pubScagent.setAgentAge(age);
						}
						if(map.get("birthDay") != null){
							String birthDay = (String)map.get("birthDay");
							String[] arr = birthDay.split("-");
							pubScagent.setBirthDay(arr[0]+"年"+arr[1]+"月");;
						}
					}
				}else{
					message += num+".【第"+(i+1)+"行】证件号码为空；<br/>";
					num++;
					continue;
				}
				String mobile = ExcelUtil.getCellContent(row.getCell(4));
				if(StringUtils.isNotEmpty(mobile)){//手机号
					pubScagent.setMobile(mobile.trim());
				}
				String studyLevel = ExcelUtil.getCellContent(row.getCell(5));
				if(StringUtils.isNotEmpty(studyLevel) && studyLevelMap.get(studyLevel) != null){//学历
					pubScagent.setStudyLevel(studyLevelMap.get(studyLevel.trim()));
				}
				String professionals = ExcelUtil.getCellContent(row.getCell(6));
				if(StringUtils.isNotEmpty(professionals)){//学历专业
					pubScagent.setProfessionals(professionals.trim());
				}
				String deptCatg = ExcelUtil.getCellContent(row.getCell(7));
				String deptCatgValue = "";
				if(StringUtils.isNotEmpty(deptCatg)){//岗位大类
					deptCatg = deptCatg.replace("，", ",");
					if(deptCatg.split(",").length > 1){
						String[] deptCatgArr = deptCatg.split(",");
						for(String dept : deptCatgArr){
							if(deptCatgMap.get(dept) != null){
								if(StringUtils.isNotEmpty(deptCatgValue)){
									deptCatgValue += ","+deptCatgMap.get(dept);
								}else{
									deptCatgValue += deptCatgMap.get(dept);
								}
							}
						}
					}else{
						if(deptCatgMap.get(deptCatg) != null){
							deptCatgValue = deptCatgMap.get(deptCatg);
						}
					}
				}
				if(StringUtils.isNotEmpty(deptCatgValue)){
					pubScagent.setDeptCatg(deptCatgValue);
				}
				String workTime = ExcelUtil.getCellContent(row.getCell(8));
				Date date = checkTime(workTime);
				if(StringUtils.isNotEmpty(workTime) && date != null){//从事本岗位开始时间
					pubScagent.setWorkTime(date);
				}
				String stationTerm = ExcelUtil.getCellContent(row.getCell(9));
				String stationTermValue = "";
				if(StringUtils.isNotEmpty(stationTerm)){//岗位资格资质
					stationTerm = stationTerm.replace("，", ",");
					if(stationTerm.split(",").length > 1){
						String[] stationTermArr = stationTerm.split(",");
						for(String station : stationTermArr){
							if(stationTermMap.get(station) != null){
								if(StringUtils.isNotEmpty(stationTermValue)){
									stationTermValue += ","+stationTermMap.get(station);
								}else{
									stationTermValue += stationTermMap.get(station);
								}
							}
						}
					}else{
						if(stationTermMap.get(stationTerm) != null){
							stationTermValue = stationTermMap.get(stationTerm);
						}
					}
				}
				if(StringUtils.isNotEmpty(stationTermValue)){
					stationTermValue = "Y,"+ stationTermValue;
					pubScagent.setStationTerm(stationTermValue);
				}else{
					pubScagent.setStationTerm("N");
				}
				String agentRangeName = ExcelUtil.getCellContent(row.getCell(10));
				String agentRangeValue = "";
				String agentRangeA = "";
				String agentRangeB = "";
				String agentRangeC = "";
				if(StringUtils.isNotEmpty(agentRangeName)){//执法清单范围
					agentRangeName = agentRangeName.replace("，", ",");
					if(agentRangeName.split(",").length > 1){
						String[] agentRangeNameArr = agentRangeName.split(",");
						for(String value : agentRangeNameArr){
							if(value.indexOf("A") != -1){
								if(StringUtils.isNotEmpty(agentRangeA)){
									agentRangeA += "；"+value;
								}else{
									agentRangeA = value;
								}
							}else if(value.indexOf("B") != -1){
								if(StringUtils.isNotEmpty(agentRangeB)){
									agentRangeB += "；"+value;
								}else{
									agentRangeB = value;
								}
							}else if(value.indexOf("C") != -1){
								if(StringUtils.isNotEmpty(agentRangeC)){
									agentRangeC += "；"+value;
								}else{
									agentRangeC = value;
								}
							}
						}
					}else{
						if(agentRangeName.indexOf("A") != -1){
							agentRangeA = agentRangeName;
						}else if(agentRangeName.indexOf("B") != -1){
							agentRangeB = agentRangeName;
						}else if(agentRangeName.indexOf("C") != -1){
							agentRangeC = agentRangeName;
						}
					}
					if(StringUtils.isNotEmpty(agentRangeA)){
						agentRangeValue += "A工商类：【"+agentRangeA+"】";
					}
					if(StringUtils.isNotEmpty(agentRangeB)){
						if(StringUtils.isEmpty(agentRangeValue)){
							agentRangeValue += "B食药类：【"+agentRangeB+"】";
						}else{
							agentRangeValue += "；B食药类：【"+agentRangeB+"】";
						}
					}
					if(StringUtils.isNotEmpty(agentRangeC)){
						if(StringUtils.isEmpty(agentRangeValue)){
							agentRangeValue += "C质监类：【"+agentRangeC+"】";
						}else{
							agentRangeValue += "；C质监类：【"+agentRangeC+"】";
						}
					}
					pubScagent.setAgentRangeName(agentRangeValue);
				}
				String agentArea = ExcelUtil.getCellContent(row.getCell(11));
				if(StringUtils.isNotEmpty(agentArea) || areaMap.get(agentArea) != null){//所属地区
					pubScagent.setAgentArea(areaMap.get(agentArea));
				}
				String unitLevel = ExcelUtil.getCellContent(row.getCell(12));
				if(StringUtils.isNotEmpty(unitLevel) && unitLevelMap.get(unitLevel) != null){//单位层级
					String unitLevelValue = unitLevelMap.get(unitLevel.trim());
					pubScagent.setUnitLevel(unitLevelValue);
					if("4".equals(unitLevelValue)){//单位类别
						pubScagent.setUnitType("2");
					}else{
						pubScagent.setUnitType("1");
					}
				}
				String agentPosition = ExcelUtil.getCellContent(row.getCell(13));
				if(StringUtils.isNotEmpty(agentPosition) && agentPositionMap.get(agentPosition) != null){//担任职务
					pubScagent.setAgentPosition(agentPositionMap.get(agentPosition.trim()));
				}
//				if(StringUtils.isNotEmpty(localAdm)){//管辖单位
//					pubScagent.setSlicenNO(localAdm);
//				}
				if(StringUtils.isNotEmpty(localAdm)){//管辖单位
					pubScagent.setSlicenNO(localAdm);
					pubScagent.setDutyDeptCode("A058");
				}
				String unitName = ExcelUtil.getCellContent(row.getCell(14));
				if(StringUtils.isNotEmpty(unitName)){//所在业务部门（机构）
					pubScagent.setUnitName(unitName.trim());
				}
				String expertFlag = ExcelUtil.getCellContent(row.getCell(15));
				String expertFlagValue = "";
				if(StringUtils.isNotEmpty(expertFlag)){//专家
					expertFlag = expertFlag.replace("，", ",");
					if(expertFlag.split(",").length > 1){
						String[] expertFlagArr = expertFlag.split(",");
						for(String station : expertFlagArr){
							if(expertFlagMap.get(station) != null){
								if(StringUtils.isNotEmpty(expertFlagValue)){
									expertFlagValue += ","+expertFlagMap.get(station);
								}else{
									expertFlagValue += expertFlagMap.get(station);
								}
							}
						}
					}else{
						if(expertFlagMap.get(expertFlag) != null){
							expertFlagValue = expertFlagMap.get(expertFlag);
						}
					}
				}
				if(StringUtils.isNotEmpty(expertFlagValue)){
					expertFlagValue = "Y,"+ expertFlagValue;
					pubScagent.setExpertFlag(expertFlagValue);
				}else{
					pubScagent.setExpertFlag("N");
				}
				String lawNO = ExcelUtil.getCellContent(row.getCell(16));
				if(StringUtils.isNotEmpty(lawNO)){//工商执法证编号
					pubScagent.setLawNO(lawNO.trim());
				}
				String lawEndDate = ExcelUtil.getCellContent(row.getCell(17));
				Date lawEndDatedate = checkTime(lawEndDate);
				if(StringUtils.isNotEmpty(workTime) && lawEndDatedate != null){//工商执法证有效期
					pubScagent.setLawEndDate(lawEndDatedate);
				}
				String govLawNO = ExcelUtil.getCellContent(row.getCell(18));
				if(StringUtils.isNotEmpty(govLawNO)){//工商执法证编号
					pubScagent.setGovLawNO(govLawNO.trim());
				}
				String govLawEndDate = ExcelUtil.getCellContent(row.getCell(19));
				Date govLawEndDatedate = checkTime(govLawEndDate);
				if(StringUtils.isNotEmpty(govLawEndDate) && govLawEndDatedate != null){//工商执法证有效期
					pubScagent.setGovLawEndDate(govLawEndDatedate);
				}
				String agentState = ExcelUtil.getCellContent(row.getCell(20));
				if(StringUtils.isNotEmpty(agentState) && agentStateMap.get(agentState) != null){//执法人员状态
					pubScagent.setAgentState(agentStateMap.get(agentState.trim()));
				}
				pubScagent.setDeptCode(deptCode);
				pubScagent.setSetTime(new Date());
				pubScagent.setSetUserId(sysUser.getId());
				pubScagent.setSetUserName(sysUser.getRealName());
				pubScagent.setSetDeptName(sysUser.getDept());
				pubScagentList.add(pubScagent);
			}catch(Exception e){
				continue;
			}
		}
		if(pubScagentList != null && pubScagentList.size() >= 0){
			for(PubScagent pubScagent : pubScagentList){
				try{
					//判断姓名+证件号码+执法证号是否重复
					String agentNO = pubScagent.getAgentNO();
					String agentName = pubScagent.getAgentName();
					if(StringUtils.isNotEmpty(agentNO) && StringUtils.isNotEmpty(agentName)){
						Example example=new Example(PubScagent.class);
						example.createCriteria().andEqualTo("agentNO",agentNO).andEqualTo("agentName",agentName);
						List<PubScagent> pubScagentListR = pubScagentMapper.selectByExample(example);
						if(pubScagentListR != null && pubScagentListR.size() > 0){
							PubScagent pubScagentR = pubScagentListR.get(0);
							if(pubScagentR.getId() != null && pubScagentR.getId() > 0){
								message += num+".证件号码【"+agentNO+"】和姓名【"+agentName+"】已存在，已覆盖原执法人员信息；<br/>";
								num++;
								pubScagent.setId(pubScagentR.getId());
								pubScagentMapper.updateByPrimaryKeySelective(pubScagent);
							}
						}else{
							savePubScagent(pubScagent);
						}
					}
				}catch(Exception e){
					continue;
				}
			}
		}
		if(StringUtils.isEmpty(message)){
			json.put("status", "success");
		}else{
			json.put("status", "error");
        	json.put("message", message);
		}
		return json;
	}
	
	/**
	 * 
	 * 描述:excel批量导入
	 * @auther chenxin
	 * @date 2017年02月23日 
	 * @param pubScagent
	 * @return
	 */
	@Override
	public JSONObject saveExcelBatchSyn(InputStream in, SysUserDto sysUser,String localAdm,String localAdmName) throws Exception {
		JSONObject json = new JSONObject();
		//转换并检查数据是否正确
		String deptCode = deptDutycodeRefService.selectDeptCodeByAdCodeSubDutyDeptCode(sysUser.getUserType(),sysUser.getDeptCode(), "A058");
		String message = "";
		int num = 1;
		//解析excel
		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows < 4) {
			return null;
		}
		List<PubScagent> pubScagentList = new ArrayList<PubScagent>();
		Map<String,String> areaMap = getAreaMap();
        Map<String,String> unitLevelMap = getUnitLevelMap();
        Map<String,String> expertFlagMap = getExpertFlagMap(sysUser);
        Map<String,String> studyLevelMap = getStudyLevelMap();
        Map<String,String> agentSexMap = getAgentSexMap();
        Map<String,String> deptCatgMap = getDeptCatgMap(sysUser);
        Map<String,String> stationTermMap = getStationTermMap(sysUser);
        Map<String,String> agentPositionMap = getAgentPositionMap();
        Map<String,String> agentStateMap = getAgentStateMap();
        
		// 遍历处理每行
		for (int i = 3; i < rows; i++) {
			try{
				PubScagent pubScagent = new PubScagent();
				Row row = sheet.getRow(i);
				if(row == null){
					continue;
				}
				String employeeNO = ExcelUtil.getCellContent(row.getCell(0));
				if(StringUtils.isNotEmpty(employeeNO)){//工号
					pubScagent.setEmployeeNO(employeeNO.trim());
				}
				String agentName = ExcelUtil.getCellContent(row.getCell(1));
				if(StringUtils.isNotEmpty(agentName)){//姓名
					pubScagent.setAgentName(agentName.trim());
				}
				String agentSex = ExcelUtil.getCellContent(row.getCell(2));
				if(StringUtils.isNotEmpty(agentSex) && agentSexMap.get(agentSex) != null){//性别
					pubScagent.setAgentSex(agentSexMap.get(agentSex.trim()));
				}
				String agentNO = ExcelUtil.getCellContent(row.getCell(3));
				if(StringUtils.isNotEmpty(agentNO)){//证件号码
					pubScagent.setAgentNO(agentNO.trim());
					Map<String, Object> map = CardUtil.getCertNOInfo(agentNO.trim());
					if(map != null){
						if(map.get("age") != null){
							int age = Integer.parseInt((String)map.get("age"));
							pubScagent.setAgentAge(age);
						}
						if(map.get("birthDay") != null){
							String birthDay = (String)map.get("birthDay");
							String[] arr = birthDay.split("-");
							pubScagent.setBirthDay(arr[0]+"年"+arr[1]+"月");;
						}
					}
				}else{
					message += num+".【第"+(i+1)+"行】证件号码为空；<br/>";
					num++;
					continue;
				}
				String mobile = ExcelUtil.getCellContent(row.getCell(4));
				if(StringUtils.isNotEmpty(mobile)){//手机号
					pubScagent.setMobile(mobile.trim());
				}
				String studyLevel = ExcelUtil.getCellContent(row.getCell(5));
				if(StringUtils.isNotEmpty(studyLevel) && studyLevelMap.get(studyLevel) != null){//学历
					pubScagent.setStudyLevel(studyLevelMap.get(studyLevel.trim()));
				}
				String professionals = ExcelUtil.getCellContent(row.getCell(6));
				if(StringUtils.isNotEmpty(professionals)){//学历专业
					pubScagent.setProfessionals(professionals.trim());
				}
				String deptCatg = ExcelUtil.getCellContent(row.getCell(7));
				String deptCatgValue = "";
				if(StringUtils.isNotEmpty(deptCatg)){//岗位大类
					deptCatg = deptCatg.replace("，", ",");
					if(deptCatg.split(",").length > 1){
						String[] deptCatgArr = deptCatg.split(",");
						for(String dept : deptCatgArr){
							if(deptCatgMap.get(dept) != null){
								if(StringUtils.isNotEmpty(deptCatgValue)){
									deptCatgValue += ","+deptCatgMap.get(dept);
								}else{
									deptCatgValue += deptCatgMap.get(dept);
								}
							}
						}
					}else{
						if(deptCatgMap.get(deptCatg) != null){
							deptCatgValue = deptCatgMap.get(deptCatg);
						}
					}
				}
				if(StringUtils.isNotEmpty(deptCatgValue)){
					pubScagent.setDeptCatg(deptCatgValue);
				}
				String workTime = ExcelUtil.getCellContent(row.getCell(8));
				Date date = checkTime(workTime);
				if(StringUtils.isNotEmpty(workTime) && date != null){//从事本岗位开始时间
					pubScagent.setWorkTime(date);
				}
				String stationTerm = ExcelUtil.getCellContent(row.getCell(9));
				String stationTermValue = "";
				if(StringUtils.isNotEmpty(stationTerm)){//岗位资格资质
					stationTerm = stationTerm.replace("，", ",");
					if(stationTerm.split(",").length > 1){
						String[] stationTermArr = stationTerm.split(",");
						for(String station : stationTermArr){
							if(stationTermMap.get(station) != null){
								if(StringUtils.isNotEmpty(stationTermValue)){
									stationTermValue += ","+stationTermMap.get(station);
								}else{
									stationTermValue += stationTermMap.get(station);
								}
							}
						}
					}else{
						if(stationTermMap.get(stationTerm) != null){
							stationTermValue = stationTermMap.get(stationTerm);
						}
					}
				}
				if(StringUtils.isNotEmpty(stationTermValue)){
					stationTermValue = "Y,"+ stationTermValue;
					pubScagent.setStationTerm(stationTermValue);
				}else{
					pubScagent.setStationTerm("N");
				}
				String agentRangeName = ExcelUtil.getCellContent(row.getCell(10));
				String agentRangeValue = "";
				String agentRangeA = "";
				String agentRangeB = "";
				String agentRangeC = "";
				if(StringUtils.isNotEmpty(agentRangeName)){//执法清单范围
					agentRangeName = agentRangeName.replace("，", ",");
					if(agentRangeName.split(",").length > 1){
						String[] agentRangeNameArr = agentRangeName.split(",");
						for(String value : agentRangeNameArr){
							if(value.indexOf("A") != -1){
								if(StringUtils.isNotEmpty(agentRangeA)){
									agentRangeA += "；"+value;
								}else{
									agentRangeA = value;
								}
							}else if(value.indexOf("B") != -1){
								if(StringUtils.isNotEmpty(agentRangeB)){
									agentRangeB += "；"+value;
								}else{
									agentRangeB = value;
								}
							}else if(value.indexOf("C") != -1){
								if(StringUtils.isNotEmpty(agentRangeC)){
									agentRangeC += "；"+value;
								}else{
									agentRangeC = value;
								}
							}
						}
					}else{
						if(agentRangeName.indexOf("A") != -1){
							agentRangeA = agentRangeName;
						}else if(agentRangeName.indexOf("B") != -1){
							agentRangeB = agentRangeName;
						}else if(agentRangeName.indexOf("C") != -1){
							agentRangeC = agentRangeName;
						}
					}
					if(StringUtils.isNotEmpty(agentRangeA)){
						agentRangeValue += "A工商类：【"+agentRangeA+"】";
					}
					if(StringUtils.isNotEmpty(agentRangeB)){
						if(StringUtils.isEmpty(agentRangeValue)){
							agentRangeValue += "B食药类：【"+agentRangeB+"】";
						}else{
							agentRangeValue += "；B食药类：【"+agentRangeB+"】";
						}
					}
					if(StringUtils.isNotEmpty(agentRangeC)){
						if(StringUtils.isEmpty(agentRangeValue)){
							agentRangeValue += "C质监类：【"+agentRangeC+"】";
						}else{
							agentRangeValue += "；C质监类：【"+agentRangeC+"】";
						}
					}
					pubScagent.setAgentRangeName(agentRangeValue);
				}
				String agentArea = ExcelUtil.getCellContent(row.getCell(11));
				if(StringUtils.isNotEmpty(agentArea) || areaMap.get(agentArea) != null){//所属地区
					pubScagent.setAgentArea(areaMap.get(agentArea));
				}
				String unitLevel = ExcelUtil.getCellContent(row.getCell(12));
				if(StringUtils.isNotEmpty(unitLevel) && unitLevelMap.get(unitLevel) != null){//单位层级
					String unitLevelValue = unitLevelMap.get(unitLevel.trim());
					pubScagent.setUnitLevel(unitLevelValue);
					if("4".equals(unitLevelValue)){//单位类别
						pubScagent.setUnitType("2");
					}else{
						pubScagent.setUnitType("1");
					}
				}
				String agentPosition = ExcelUtil.getCellContent(row.getCell(13));
				if(StringUtils.isNotEmpty(agentPosition) && agentPositionMap.get(agentPosition) != null){//担任职务
					pubScagent.setAgentPosition(agentPositionMap.get(agentPosition.trim()));
				}
				if(StringUtils.isNotEmpty(localAdm)){//管辖单位
					pubScagent.setSlicenNO(localAdm);
					pubScagent.setSlicenNOName(localAdmName);
					pubScagent.setDutyDeptCode(sysUser.getDutyDeptCodes());
				}
				String concreteDuties = ExcelUtil.getCellContent(row.getCell(14));
				if(StringUtils.isNotEmpty(concreteDuties)){//具体职务
					pubScagent.setConcreteDuties(concreteDuties);
				}
				String unitName = ExcelUtil.getCellContent(row.getCell(15));
				if(StringUtils.isNotEmpty(unitName)){//所在业务部门（机构）
					pubScagent.setUnitName(unitName.trim());
				}
				String expertFlag = ExcelUtil.getCellContent(row.getCell(16));
				String expertFlagValue = "";
				if(StringUtils.isNotEmpty(expertFlag)){//专家
					expertFlag = expertFlag.replace("，", ",");
					if(expertFlag.split(",").length > 1){
						String[] expertFlagArr = expertFlag.split(",");
						for(String station : expertFlagArr){
							if(expertFlagMap.get(station) != null){
								if(StringUtils.isNotEmpty(expertFlagValue)){
									expertFlagValue += ","+expertFlagMap.get(station);
								}else{
									expertFlagValue += expertFlagMap.get(station);
								}
							}
						}
					}else{
						if(expertFlagMap.get(expertFlag) != null){
							expertFlagValue = expertFlagMap.get(expertFlag);
						}
					}
				}
				if(StringUtils.isNotEmpty(expertFlagValue)){
					expertFlagValue = "Y,"+ expertFlagValue;
					pubScagent.setExpertFlag(expertFlagValue);
				}else{
					pubScagent.setExpertFlag("N");
				}
				String lawNO = ExcelUtil.getCellContent(row.getCell(17));
				if(StringUtils.isNotEmpty(lawNO)){//工商执法证编号
					pubScagent.setLawNO(lawNO.trim());
				}
				String lawEndDate = ExcelUtil.getCellContent(row.getCell(18));
				Date lawEndDatedate = checkTime(lawEndDate);
				if(StringUtils.isNotEmpty(workTime) && lawEndDatedate != null){//工商执法证有效期
					pubScagent.setLawEndDate(lawEndDatedate);
				}
				String certificateDept = ExcelUtil.getCellContent(row.getCell(19));
				if(StringUtils.isNotEmpty(certificateDept)){//发证机关
					pubScagent.setCertificateDept(certificateDept);
				}
				String agentState = ExcelUtil.getCellContent(row.getCell(20));
				if(StringUtils.isNotEmpty(agentState) && agentStateMap.get(agentState) != null){//执法人员状态
					pubScagent.setAgentState(agentStateMap.get(agentState.trim()));
				}
				pubScagent.setDeptCode(deptCode);
				pubScagent.setSetTime(new Date());
				pubScagent.setSetUserId(sysUser.getId());
				pubScagent.setSetUserName(sysUser.getRealName());
				pubScagent.setSetDeptName(sysUser.getDept());
				pubScagentList.add(pubScagent);
			}catch(Exception e){
				continue;
			}
		}
		if(pubScagentList != null && pubScagentList.size() >= 0){
			for(PubScagent pubScagent : pubScagentList){
				try{
					//判断姓名+证件号码+执法证号是否重复
					String agentNO = pubScagent.getAgentNO();
					String agentName = pubScagent.getAgentName();
					if(StringUtils.isNotEmpty(agentNO) && StringUtils.isNotEmpty(agentName)){
						Example example=new Example(PubScagent.class);
						example.createCriteria().andEqualTo("agentNO",agentNO).andEqualTo("agentName",agentName);
						List<PubScagent> pubScagentListR = pubScagentMapper.selectByExample(example);
						if(pubScagentListR != null && pubScagentListR.size() > 0){
							PubScagent pubScagentR = pubScagentListR.get(0);
							if(pubScagentR.getId() != null && pubScagentR.getId() > 0){
								message += num+".证件号码【"+agentNO+"】和姓名【"+agentName+"】已存在，已覆盖原执法人员信息；<br/>";
								num++;
								pubScagent.setId(pubScagentR.getId());
								pubScagentMapper.updateByPrimaryKeySelective(pubScagent);
							}
						}else{
							savePubScagent(pubScagent);
						}
					}
				}catch(Exception e){
					continue;
				}
			}
		}
		if(StringUtils.isEmpty(message)){
			json.put("status", "success");
		}else{
			json.put("status", "error");
        	json.put("message", message);
		}
		return json;
	}
	
    /**
     * 检查日期格式
     *
     * @return 检查结果
     */
    private Date checkTime(String workTime) {
        if (StringUtil.isBlank(workTime)) {
            return null;
        }
        try{
        	return DateUtil.stringToDate(workTime.trim(), "yyyy-MM-dd");
        }catch(Exception e){
        	return null;
        }
    }
    
    /**
     * 描述：获取地区翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getAreaMap(){
    	Map<String,String> areaMap = new HashMap<String, String>();
		areaMap.put("省本级", "ZJ");
		areaMap.put("杭州", "H");
		areaMap.put("宁波", "N");
		areaMap.put("温州", "W");
		areaMap.put("嘉兴", "Jx");
		areaMap.put("湖州", "Hu");
		areaMap.put("绍兴", "S");
		areaMap.put("金华", "J");
		areaMap.put("衢州", "Q");
		areaMap.put("舟山", "Z");
		areaMap.put("台州", "T");
		areaMap.put("丽水", "L");
		return areaMap;
    }
    
    /**
     * 描述：获取学历翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getStudyLevelMap(){
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	studyLevelMap.put("小学", "8");
    	studyLevelMap.put("初中", "4");
    	studyLevelMap.put("高中", "5");
    	studyLevelMap.put("大专", "1");
    	studyLevelMap.put("本科", "2");
    	studyLevelMap.put("研究生", "3");
    	studyLevelMap.put("硕士", "6");
    	studyLevelMap.put("博士", "7");
    	studyLevelMap.put("博士后", "9");
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取性别翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getAgentSexMap(){
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	studyLevelMap.put("男", "1");
    	studyLevelMap.put("女", "2");
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取执法人员状态翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getAgentStateMap(){
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	studyLevelMap.put("有效", "1");
    	studyLevelMap.put("失效", "2");
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取执法事项状态翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
//    private Map<String,String> getAgentRangeMap()throws Exception{
//    	Map<String,String> studyLevelMap = new HashMap<String, String>();
//    	List<PubScagentDto> pubScagentDtoList = pubScagentMapper.selectScPtypeList();
//    	for(PubScagentDto pubScagentDto : pubScagentDtoList){
//    		if(StringUtils.isNotEmpty(pubScagentDto.getCode()) && StringUtils.isNotEmpty(pubScagentDto.getContent())){
//    			String key = pubScagentDto.getContent();
//    			key = key.replace("（", "(").replace("）", ")");
//    			studyLevelMap.put(key, pubScagentDto.getCode());
//    		}
//    	}
//    	return studyLevelMap;
//    }
    
    /**
     * 描述：获取岗位大类翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getDeptCatgMap(SysUserDto sysUser)throws Exception{
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("idVlid", "1");
    		if("1".equals(sysUser.getUserType()) || (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) 
				 &&("A058".indexOf(sysUser.getDutyDeptCodes()) != -1) || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
   						 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
    			params.put("dutyDeptCode", "A058");
    		}else{
    			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
    				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
    			}
    		}
    		List<CodePositionType> codePositionTypeList = codePositionTypeService.selectListByParams(params);
    		if(CollectionUtils.isNotEmpty(codePositionTypeList)){
    			for(CodePositionType codePositionType :codePositionTypeList){
    				studyLevelMap.put(codePositionType.getPositionName(), codePositionType.getPositionCode());
    			}
    		}
    	}
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取职位大类翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getAgentPositionMap(){
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	studyLevelMap.put("局领导", "1");
    	studyLevelMap.put("科室（处、办、中心）负责人（正职）", "2");
    	studyLevelMap.put("科室(处、办、中心)负责人(正职)", "2");
    	studyLevelMap.put("科室（处、办、中心）负责人（副职）", "3");
    	studyLevelMap.put("科室(处、办、中心)负责人(副职)", "3");
    	studyLevelMap.put("所（站、分局）长（正职）", "4");
    	studyLevelMap.put("所(站、分局)长(正职)", "4");
    	studyLevelMap.put("所（站、分局）长（副职）", "5");
    	studyLevelMap.put("所(站、分局)长(副职)", "5");
    	studyLevelMap.put("一般干部", "6");
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取岗位资格资质翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getStationTermMap(SysUserDto sysUser)throws Exception{
    	Map<String,String> studyLevelMap = new HashMap<String, String>();
    	if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("idVlid", "1");
    		if("1".equals(sysUser.getUserType()) || (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) 
   				 &&("A058".indexOf(sysUser.getDutyDeptCodes()) != -1) || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
      						 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
       			params.put("dutyDeptCode", "A058");
       		}else{
       			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
       				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
       			}
       		}
    		List<CodeRightType> codeRightTypeList = codeRightTypeService.selectListByParams(params);
    		if(CollectionUtils.isNotEmpty(codeRightTypeList)){
    			for(CodeRightType codeRightType :codeRightTypeList){
    				studyLevelMap.put(codeRightType.getRightName(), codeRightType.getRightCode());
    			}
    		}
    	}
    	return studyLevelMap;
    }
    
    /**
     * 描述：获取单位层级翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getUnitLevelMap(){
    	Map<String,String> unitLevelMap = new HashMap<String, String>();
    	unitLevelMap.put("省级", "3");
    	unitLevelMap.put("市级", "1");
    	unitLevelMap.put("县级", "2");
    	unitLevelMap.put("所级", "4");
		return unitLevelMap;
    }
    
    /**
     * 描述：获取专家类别翻译Map
     *@author chenxin
     *@date 2017-02-23
     * @return
     */
    private Map<String,String> getExpertFlagMap(SysUserDto sysUser)throws Exception{
    	Map<String,String> unitTypeMap = new HashMap<String, String>();
    	if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
    		Map<String,Object> params = new HashMap<String,Object>();
    		params.put("idVlid", "1");
    		if("1".equals(sysUser.getUserType()) || (StringUtils.isNotEmpty(sysUser.getDutyDeptCodes()) 
   				 &&("A058".indexOf(sysUser.getDutyDeptCodes()) != -1) || "A012".indexOf(sysUser.getDutyDeptCodes()) != -1
      						 || "A027".indexOf(sysUser.getDutyDeptCodes()) != -1)){
       			params.put("dutyDeptCode", "A058");
       		}else{
       			if(StringUtils.isNotEmpty(sysUser.getDutyDeptCodes())){
       				params.put("dutyDeptCodeArr", sysUser.getDutyDeptCodes().split(","));
       			}
       		}
    		List<CodeExpertType> codeExpertTypeList = codeExpertTypeService.selectListByParams(params);
    		if(CollectionUtils.isNotEmpty(codeExpertTypeList)){
    			for(CodeExpertType codeExpertType :codeExpertTypeList){
    				unitTypeMap.put(codeExpertType.getExpertName(), codeExpertType.getExpertCode());
    			}
    		}
    	}
    	return unitTypeMap;
    }
    
	/**
	 * 描述: 生成排序序号
	 * @auther yujingwei
	 * @date 2016年11月21日
	 * @param pubScagent
	 * @return AgentInnerNO
	 * @throws Exception
	 */	
	@Transactional(rollbackFor = Exception.class)
	private String createAgentInnerNO(PubScagent pubScagent) throws Exception{
		if(StringUtil.isEmpty(pubScagent.getAgentArea()) || StringUtil.isEmpty(pubScagent.getSlicenNO())){
			return null;
		}
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(pubScagent.getAgentArea());
		strBuilder.append(pubScagent.getSlicenNO().substring(6, 8));
		String agentInnerId = strBuilder.toString();
		PubScagentOrder pubScagentOrder = pubScagentOrderService.selectOrderByInnerId(agentInnerId);
		if(pubScagentOrder == null){
			//无排序则插入新的序号
			PubScagentOrder insertOrder = new PubScagentOrder();
			insertOrder.setAgentInnerId(agentInnerId);
			insertOrder.setOrderBy(1);
			pubScagentOrderMapper.insert(insertOrder);
		}else{
			//存在排序则更新当前序号
			pubScagentOrder.setOrderBy(pubScagentOrder.getOrderBy()+1);
			Example example=new Example(PubScagentOrder.class);
			example.createCriteria().andEqualTo("agentInnerId",agentInnerId);
			pubScagentOrderMapper.updateByExampleSelective(pubScagentOrder, example);
		}
		int orderNO = pubScagentOrder == null?1:(pubScagentOrder.getOrderBy());
		String agentInnerNO = doHandleAgentOrder(orderNO,agentInnerId); 
		return agentInnerNO;
	}
    
	
	/**
	 * 描述: 生成序号(暂保留三位)
	 * @auther yujingwei
	 * @date 2016年11月21日
	 * @param agentInnerId,agentOrder
	 * @return String
	 * @throws Exception
	 */	
	private String doHandleAgentOrder (int agentOrder,String agentInnerId) throws Exception{
		String orderStr = "";
		String currentOrder = Integer.toString(agentOrder);
		if(currentOrder.length() == 1){
			orderStr = "00" + currentOrder;
		}else if(currentOrder.length() == 2){
			orderStr = "0" + currentOrder;
		}else{
			orderStr = currentOrder;
		}
		return agentInnerId + orderStr;
	}
   
	
	
	@Override
	public int updatePubScagent(PubScagent pubScagent) {
         Example example=new Example(PubScagent.class);
		 example.createCriteria().andEqualTo("UID",pubScagent.getUID());
		
		return pubScagentMapper.updateByExampleSelective(pubScagent,example);
	}

	@Override
	public int deletePubScagentById(String uid) {
		Example example=new Example(PubScagent.class);
		example.createCriteria().andEqualTo("UID",uid);
		return pubScagentMapper.deleteByExample(example);
	}
	
	@Override
	public PubScagent selectById(String  uid) {
		PubScagent pubScagent=new PubScagent();
	    pubScagent.setUID(uid);
		return pubScagentMapper.selectOne(pubScagent);
	}
	
	/**
	 * 描述: 获取执法清单范围树数据
	 * @auther chenxin
	 * @date 2017年4月21日
	 * @return List<Map<String, Object>>
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> selectScPtypeMap() throws Exception {
		return pubScagentMapper.selectScPtypeTreeMap();
	}
	
	/**
	 * 
	 * 描述: 执法人员统计
	 * @auther gaojinling
	 * @date 2017年6月1日 
	 * @param request
	 * @return
	 * @throws Exception
	 */
    public List<PubScagentDto> selectScAgentCount(PageRequest request) throws Exception {
    	Map<String,Object> parmMap=request.getParams();
		if(parmMap != null){
//			if(parmMap.containsKey("startCheckPushDate") && parmMap.containsKey("endCheckPushDate")){
//				if(parmMap.get("startCheckPushDate") != null && StringUtil.isNotBlank(parmMap.get("startCheckPushDate").toString())){
//					parmMap.put("startCheckPushDate", StringUtil.replace(parmMap.get("startCheckPushDate").toString(), "-", ""));
//					parmMap.put("endCheckPushDate", StringUtil.replace(parmMap.get("endCheckPushDate").toString(), "-", ""));
//				}else{
//					parmMap.put("startCheckPushDate", parmMap.get("rptyear").toString()+parmMap.get("rptbeginmouth").toString());
//				}
//			}
		    	if(parmMap.get("entType")!=null && !parmMap.get("entType").toString().equals("")){
		    		parmMap.put("entTypes", StringUtil.doSplitStringToSqlFormat(parmMap.get("entType").toString(),","));
		    	}
				PageHelper.startPage(request.getPageNum(), 10000);
				return pubScagentMapper.selectScAgentCount(parmMap);
		}
		return new ArrayList<PubScagentDto>();
    } 
    
    /**
     * 
     * 描述: 执法人员统计
     * @auther gaojinling
     * @date 2017年6月1日 
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public List<PubScagentDto> selectSynScAgentCount(PageRequest request)
    		throws Exception {
    	Map<String,Object> parmMap=request.getParams();
		if(parmMap != null){
			PageHelper.startPage(request.getPageNum(), 10000);
			return pubScagentMapper.selectSynScAgentCount(parmMap);
		}
		return new ArrayList<PubScagentDto>();
    }
    
    /**
	 * 
	 * 描述: 查询信息
	 * @auther chenxin
	 * @date 2017年7月11日 
	 * @param uid
	 * @return
	 * @throws Exception
	 */
    @Override
    public PubScagentDto selectPubScagentDtoByUid(String uid) throws Exception {
    	return pubScagentMapper.selectPubScagentDtoByUid(uid);
    }
}