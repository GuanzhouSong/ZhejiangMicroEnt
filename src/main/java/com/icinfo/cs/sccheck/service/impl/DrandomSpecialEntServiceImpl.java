/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.sccheck.service.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.sccheck.dto.DrandomSpecialEntDto;
import com.icinfo.cs.sccheck.mapper.DrandomSpecialEntMapper;
import com.icinfo.cs.sccheck.model.CodeMarkType;
import com.icinfo.cs.sccheck.model.CodeSpecialType;
import com.icinfo.cs.sccheck.model.DrandomSpecialEnt;
import com.icinfo.cs.sccheck.service.ICodeMarkTypeService;
import com.icinfo.cs.sccheck.service.ICodeSpecialTypeService;
import com.icinfo.cs.sccheck.service.IDrandomSpecialEntService;
import com.icinfo.cs.sccheck.service.IPubScentBackService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.DeptDutycodeRef;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_drandom_special_ent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年09月13日
 */
@Service
public class DrandomSpecialEntServiceImpl extends MyBatisServiceSupport implements IDrandomSpecialEntService {
	
	@Autowired
	private DrandomSpecialEntMapper drandomSpecialEntMapper;
	
	@Autowired
	private ICodeSpecialTypeService codeSpecialTypeService;
	
	@Autowired
	private ICodeMarkTypeService codeMarkTypeService;
	
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	@Autowired
	private ISysDepartService sysDepartService;
	
	@Autowired
	private IPubScentBackService pubScentBackService;
	
	/**
	 * 描述：跨部门专项库列表
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DrandomSpecialEntDto> queryPage(PageRequest request,SysUserDto sysUserDto) throws Exception {
		String dutyDeptCodes = sysUserDto.getDutyDeptCodes();
		if(StringUtils.isEmpty(dutyDeptCodes)){
			return null;
		}
		Map<String,Object> params = request.getParams();
		if(params == null){
			params = new HashMap<String,Object>();
		}
		StringUtil.paramTrim(params);
    	if(params.get("regState")!=null && !params.get("regState").toString().equals("")){
    		params.put("regStates", params.get("regState").toString().split(","));
    	}
//    	if(params.get("specialCode")!=null && !params.get("specialCode").toString().equals("")){
//    		params.put("specialCodes", params.get("specialCode").toString().split(","));
//    	}
//    	if(params.get("markCode")!=null && !params.get("markCode").toString().equals("")){
//    		params.put("markCodes", params.get("markCode").toString().split(","));
//    	}
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
    	if(params.get("regOrg")!=null && !params.get("regOrg").toString().equals("")){
    		params.put("regOrgs", params.get("regOrg").toString().split(","));
    	}
    	if(params.get("localAdm")!=null && !params.get("localAdm").toString().equals("")){
    		params.put("localAdms", params.get("localAdm").toString().split(","));
    	}
    	if(params.get("checkDeptCode")!=null && !params.get("checkDeptCode").toString().equals("")){
    		params.put("checkDeptCodes", params.get("checkDeptCode").toString().split(","));
    	}
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return drandomSpecialEntMapper.selectDrandomSpecialEntDtoList(params);
	}
	
	/**
	 * 描述：统计查询
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<DrandomSpecialEntDto> selectSpecialCount(Map<String,Object> params,SysUserDto sysUserDto) throws Exception {
		String dutyDeptCodes = sysUserDto.getDutyDeptCodes();
		if(StringUtils.isEmpty(dutyDeptCodes)){
			return null;
		}
		if(params == null){
			params = new HashMap<String,Object>();
		}
		StringUtil.paramTrim(params);
    	if(params.get("regState")!=null && !params.get("regState").toString().equals("")){
    		params.put("regStates", params.get("regState").toString().split(","));
    	}
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
    	if(params.get("regOrg")!=null && !params.get("regOrg").toString().equals("")){
    		params.put("regOrgs", params.get("regOrg").toString().split(","));
    	}
    	if(params.get("localAdm")!=null && !params.get("localAdm").toString().equals("")){
    		params.put("localAdms", params.get("localAdm").toString().split(","));
    	}
    	if(params.get("checkDeptCode")!=null && !params.get("checkDeptCode").toString().equals("")){
    		params.put("checkDeptCodes", params.get("checkDeptCode").toString().split(","));
    	}
    	return drandomSpecialEntMapper.selectSpecialCount(params);
	}
	
	/**
	 * 描述：导入待抽检库
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param parmMap
	 * @param sysUserDto
	 * @return
	 * @throws Exception
	 */
	@Override
	public AjaxResult addSpecialAll(Map<String, Object> params,SysUserDto sysUserDto) throws Exception {
		//1.查询
		String dutyDeptCodes = sysUserDto.getDutyDeptCodes();
		if(StringUtils.isEmpty(dutyDeptCodes)){
			return AjaxResult.error("您的账号未设置职能部门");
		}
		if(params == null){
			params = new HashMap<String,Object>();
		}
		StringUtil.paramTrim(params);
		if(params.get("taskUid") == null || params.get("taskUid").toString().equals("")){
			return AjaxResult.error("本次抽取任务信息异常，请确认任务是否正确");
		}
    	if(params.get("regState")!=null && !params.get("regState").toString().equals("")){
    		params.put("regStates", params.get("regState").toString().split(","));
    	}
		params.put("dutyDeptCodeArr", dutyDeptCodes.split(","));
    	if(params.get("regOrg")!=null && !params.get("regOrg").toString().equals("")){
    		params.put("regOrgs", params.get("regOrg").toString().split(","));
    	}
    	if(params.get("localAdm")!=null && !params.get("localAdm").toString().equals("")){
    		params.put("localAdms", params.get("localAdm").toString().split(","));
    	}
    	if(params.get("checkDeptCode")!=null && !params.get("checkDeptCode").toString().equals("")){
    		params.put("checkDeptCodes", params.get("checkDeptCode").toString().split(","));
    	}
    	List<DrandomSpecialEntDto> drandomSpecialEntDtoList = drandomSpecialEntMapper.selectDrandomSpecialEntDtoList(params);
    	if(drandomSpecialEntDtoList == null || drandomSpecialEntDtoList.size() <= 0){
    		return AjaxResult.error("导入数据为空");
    	}
    	if(pubScentBackService.saveSpecialEnts(drandomSpecialEntDtoList,params.get("taskUid").toString(),sysUserDto)){
    		return AjaxResult.success("导入成功");
    	}
		return AjaxResult.success("导入失败");
	}
	
	/**
	 * 描述：查询企业对应的检查事项
	 * 
	 * @author chenxin
	 * @date 2017-10-31
	 * @param priPID
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<String> selectCheckCodeList(String priPID) throws Exception {
		return drandomSpecialEntMapper.selectCheckCodeList(priPID);
	}
	
	/**
	 * 
	 * 描述: 保存跨部门专项库
	 * @auther chenxin
	 * @date 2017年9月13日 
	 * @param DrandomSpecialEnt
	 * @return
	 */
	@Override
	public AjaxResult saveOrUpdateDrandomSpecialEnt(DrandomSpecialEnt drandomSpecialEnt,SysUserDto sysUserDto)throws Exception {
		if(StringUtils.isEmpty(sysUserDto.getDutyDeptCodes())){
			return AjaxResult.error("您的账号未设置职能部门");
		}
		if(StringUtils.isEmpty(drandomSpecialEnt.getUid())){//新增
			drandomSpecialEnt.setCreatTime(new Date());
			drandomSpecialEnt.setSetUserUid(sysUserDto.getId());
			drandomSpecialEnt.setSetUserName(sysUserDto.getRealName());
			drandomSpecialEnt.setSetDeptCode(sysUserDto.getSysDepart().getAdcode());
			drandomSpecialEnt.setDutyDeptCode(sysUserDto.getDutyDeptCodes());
			if(StringUtils.isNotEmpty(sysUserDto.getDutyDeptCodes())){
				if(judgeDefaultRepeat(drandomSpecialEnt,false)){
					return AjaxResult.error("同一个主体（监管标签+专项库+许可证号）只能有一条记录");
				}
				drandomSpecialEntMapper.insertSelective(drandomSpecialEnt);
				return AjaxResult.success("保存成功");
			}else{
				return AjaxResult.error("保存失败,所属职能部门为空，请先设置职能部门");
			}
		}else{//更新
			if(judgeDefaultRepeat(drandomSpecialEnt,true)){
				return AjaxResult.error("同一个主体（监管标签+专项库+许可证号）只能有一条记录");
			}
			Example example = new Example(DrandomSpecialEnt.class);
			example.createCriteria().andEqualTo("uid", drandomSpecialEnt.getUid()); 
			if(drandomSpecialEntMapper.updateByExample(drandomSpecialEnt, example) > 0){
				return AjaxResult.success("修改成功");
			}else{
				return AjaxResult.error("修改失败");
			}
		}
	}

	/**
	 * 描述：判断是否有重复记录
	 * @auther chenxin
	 * @date 2017年9月13日 
	 * @param drandomSpecialEnt
	 * @param flag  是否需要排除自身
	 * @return
	 */
	private boolean judgeDefaultRepeat(DrandomSpecialEnt drandomSpecialEnt,boolean flag) {
		Example example = new Example(DrandomSpecialEnt.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("specialCode", drandomSpecialEnt.getSpecialCode())
				.andEqualTo("markCode", drandomSpecialEnt.getMarkCode())
				.andEqualTo("dutyDeptCode", drandomSpecialEnt.getDutyDeptCode());
		if(flag){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", drandomSpecialEnt.getUid());
		}
		if("1".equals(drandomSpecialEnt.getSubjectType())){//如果是企业主体需要加上内部序号
			criteria.andEqualTo("priPID", drandomSpecialEnt.getPriPID());
		}
		if(StringUtils.isNotEmpty(drandomSpecialEnt.getLicNO())){
			criteria.andEqualTo("licNO", drandomSpecialEnt.getLicNO());
		}else{
			criteria.andIsNull("licNO");
		}
		if(drandomSpecialEntMapper.selectCountByExample(example) > 0){
			return true;
		}
		if(judgeDefaultVRepeat(drandomSpecialEnt, flag)){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：判断是否有重复记录
	 * @auther chenxin
	 * @date 2017年9月13日 
	 * @param drandomSpecialEnt
	 * @param flag  是否需要排除自身
	 * @return
	 */
	private boolean judgeDefaultVRepeat(DrandomSpecialEnt drandomSpecialEnt,boolean flag) {
		Example example = new Example(DrandomSpecialEnt.class);
		Criteria criteria = example.createCriteria(); 
		criteria.andEqualTo("specialCode", drandomSpecialEnt.getSpecialCode())
		.andEqualTo("markCode", drandomSpecialEnt.getMarkCode())
		.andEqualTo("dutyDeptCode", drandomSpecialEnt.getDutyDeptCode());
		if(flag){//如果是更新需要排除自身
			criteria.andNotEqualTo("uid", drandomSpecialEnt.getUid());
		}
		if("1".equals(drandomSpecialEnt.getSubjectType())){//如果是企业主体需要加上内部序号
			criteria.andEqualTo("priPID", drandomSpecialEnt.getPriPID());
		}
		if(StringUtils.isNotEmpty(drandomSpecialEnt.getLicNO())){
			criteria.andEqualTo("licNO", drandomSpecialEnt.getLicNO());
		}else{
			criteria.andEqualTo("licNO", "");
		}
		if(drandomSpecialEntMapper.selectCountByExample(example) > 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 描述：根据uid查询详情
	 *
	 * @author chenxin
	 * @date 2017年9月13日
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@Override
	public DrandomSpecialEnt selectByUid(String uid) throws Exception {
		DrandomSpecialEnt drandomSpecialEnt = new DrandomSpecialEnt();
		drandomSpecialEnt.setUid(uid);
		return drandomSpecialEntMapper.selectOne(drandomSpecialEnt);
	}
	
	/**
	 * 描述：excel批量导入跨部门专项库(只用作协同除工商部门以外)
     * @author chenxin
     * @date 2017-9-13
	 * @param in
	 * @param sysUser
	 * @param dutyDeptCode
	 * @param dutyDeptName
	 * @param subjectType
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject saveExcelBatch(InputStream in, SysUserDto sysUser,String subjectType) throws Exception {
		JSONObject json = new JSONObject();
		//转换并检查数据是否正确
		String message = "";
		int num = 1;
		int success = 0;
		int fail = 0;
		//解析excel
		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows < 3) {
			json.put("status", "error");
        	json.put("message", "excel内容为空");
			return json;
		}
		if(StringUtils.isEmpty(sysUser.getDutyDeptCodes())){
			json.put("status", "error");
        	json.put("message", "请先设置所属职能部门");
			return json;
		}
		// 遍历处理每行
		for (int i = 2; i < rows; i++) {
			try{
				Row row = sheet.getRow(i);
				if(row == null){
					message += num+".第"+(i+1)+"行数据为空<br/>";
					num++;
					fail++;
					continue;
				}
				DrandomSpecialEnt drandomSpecialEnt = new DrandomSpecialEnt();
				String dutyDeptCodes = sysUser.getDutyDeptCodes();
				drandomSpecialEnt.setSubjectType(subjectType);
				drandomSpecialEnt.setDutyDeptCode(dutyDeptCodes);
				String specialName = ExcelUtil.getCellContent(row.getCell(0));
				if(StringUtils.isNotEmpty(specialName)){//专项库名称
					CodeSpecialType codeSpecialType = codeSpecialTypeService.selectByName(specialName.trim(),dutyDeptCodes);
					if(codeSpecialType != null){
						String specialCode = codeSpecialType.getSpecialCode();
						drandomSpecialEnt.setSpecialCode(specialCode);
						drandomSpecialEnt.setSpecialName(specialName);
					}else{
						message += num+".第"+(i+1)+"行【"+specialName+"】系统未找到相应的专项库名称，请先设置改专项库名称<br/>";
						num++;
						fail++;
						continue;
					}
				}else{
					message += num+".第"+(i+1)+"行专项库名称为空<br/>";
					num++;
					fail++;
					continue;
				}
				String markName = ExcelUtil.getCellContent(row.getCell(1));
				if(StringUtils.isNotEmpty(markName)){//监管标签
					CodeMarkType codeMarkType = codeMarkTypeService.selectByName(drandomSpecialEnt.getSpecialCode(),markName.trim(),dutyDeptCodes);
					if(codeMarkType != null){
						String markCode = codeMarkType.getMarkCode();
						drandomSpecialEnt.setMarkCode(markCode);
						drandomSpecialEnt.setMarkName(markName);
					}else{
						message += num+".第"+(i+1)+"行【"+markName+"】系统未找到相应的专项库，请先设置该监管标签对应的专项库<br/>";
						num++;
						fail++;
						continue;
					}
				}else{
					message += num+".第"+(i+1)+"行对应专项库监管标签为空<br/>";
					num++;
					fail++;
					continue;
				}
				String regNO = ExcelUtil.getCellContent(row.getCell(2));
				if(StringUtils.isNotEmpty(regNO)){
					Map<String,Object> parmMap = new HashMap<String,Object>();
					parmMap.put("regNO", regNO.trim());
					MidBaseInfoDto midBaseInfo = midBaseInfoService.selectForDrandomByKeyword(parmMap);
					if(midBaseInfo != null){
						drandomSpecialEnt.setPriPID(midBaseInfo.getPriPID());
						drandomSpecialEnt.setRegNO(midBaseInfo.getRegNO());
						drandomSpecialEnt.setUniCode(midBaseInfo.getUniCode());
						drandomSpecialEnt.setRegOrg(midBaseInfo.getRegOrg());
						drandomSpecialEnt.setRegOrgName(midBaseInfo.getRegOrgName());
						drandomSpecialEnt.setLocalAdm(midBaseInfo.getLocalAdm());
						drandomSpecialEnt.setLocalAdmName(midBaseInfo.getLocalAdmName());
						drandomSpecialEnt.setEstDate(midBaseInfo.getEstDate());
						drandomSpecialEnt.setRegState(midBaseInfo.getRegState());
						drandomSpecialEnt.setEntName(midBaseInfo.getEntName());
						drandomSpecialEnt.setEntTypeCatg(midBaseInfo.getEntTypeCatg());
						drandomSpecialEnt.setDom(midBaseInfo.getDom());
						drandomSpecialEnt.setOpScope(midBaseInfo.getOpScope());
						drandomSpecialEnt.setLeRep(midBaseInfo.getLeRep());
					}else{
						message += num+".第"+(i+1)+"行【"+regNO+"】根据统一社会信用代码/注册号未找到相应的企业<br/>";
						num++;
						fail++;
						continue;
					}
				}else{
					message += num+".第"+(i+1)+"行统一社会信用代码/注册号为空<br/>";
					num++;
					fail++;
					continue;
				}
				String licName = ExcelUtil.getCellContent(row.getCell(4));
				if(StringUtils.isNotEmpty(licName)){
					drandomSpecialEnt.setLicName(licName.trim());
				}
				String licNO = ExcelUtil.getCellContent(row.getCell(5));
				if(StringUtils.isNotEmpty(licNO)){
					drandomSpecialEnt.setLicNO(licNO.trim());
				}
				String licApprDate = ExcelUtil.getCellContent(row.getCell(6));
				if(StringUtils.isNotEmpty(licApprDate)){
					drandomSpecialEnt.setLicApprDate(DateUtil.stringToDate(licApprDate.trim(), "yyyy-MM-dd"));;
				}
				String licSaveEndDate = ExcelUtil.getCellContent(row.getCell(7));
				if(StringUtils.isNotEmpty(licSaveEndDate)){
					drandomSpecialEnt.setLicSaveEndDate(DateUtil.stringToDate(licSaveEndDate.trim(), "yyyy-MM-dd"));
				}
				String licSendDeptName = ExcelUtil.getCellContent(row.getCell(8));
				if(StringUtils.isNotEmpty(licSendDeptName)){
					drandomSpecialEnt.setLicSendDeptName(licSendDeptName);
				}
				String checkDeptName = ExcelUtil.getCellContent(row.getCell(9));
				if(StringUtils.isNotEmpty(checkDeptName)){
					drandomSpecialEnt.setCheckDeptName(checkDeptName);
					checkDeptName = replaceCheckDeptName(checkDeptName);
					DeptDutycodeRef deptDutycodeRef = sysDepartService.selectByName(checkDeptName,dutyDeptCodes);
					if(deptDutycodeRef != null){
						drandomSpecialEnt.setCheckDeptCode(deptDutycodeRef.getAdCode());
					}else{
						message += num+".第"+(i+1)+"行检查部门在系统中未找到相应的部门信息，请联系管理员新增部门<br/>";
						num++;
						fail++;
						continue;
					}
				}else{
					message += num+".第"+(i+1)+"行检查部门为空<br/>";
					num++;
					fail++;
					continue;
				}
				drandomSpecialEnt.setIsVlid("1");
				drandomSpecialEnt.setSubjectType("1");
				AjaxResult ajaxResult = this.saveOrUpdateDrandomSpecialEnt(drandomSpecialEnt, sysUser);
				if("fail".equals(ajaxResult.getStatus())){
					message += num+".第"+(i+1)+"行【"+drandomSpecialEnt.getEntName()+"】"+ajaxResult.getMsg()+"<br/>";
					num++;
					fail++;
				}else{
					success++;
				}
			}catch(Exception e){
				message += num+".第"+(i+1)+"行存在异常数据<br/>";
				num++;
				fail++;
				e.printStackTrace();
				continue;
			}
		}
		if(StringUtils.isEmpty(message)){
			json.put("status", "success");
		}else{
			json.put("status", "error");
			if(fail > 0){
				message = "导入失败"+fail+"条记录。<br/>"+message;
			}
			if(success > 0){
				message = "导入成功"+success+"条记录;"+message;
			}
        	json.put("message", message);
		}
		return json;
	}

	/**
	 * 描述：特殊处理公安部门编码数据
	 * 
	 * @author chenxin
	 * @date 2017-11-09
	 * @param checkDeptName
	 * @return
	 */
	private String replaceCheckDeptName(String checkDeptName) {
		return checkDeptName.replaceAll("行政审批服务科", "").replaceAll("治安管理中心", "").replaceAll("缉毒大队", "").replaceAll("刑侦大队", "").replaceAll("禁毒大队", "").replaceAll("治安大队", "").replaceAll("侦察大队", "");
	}
}