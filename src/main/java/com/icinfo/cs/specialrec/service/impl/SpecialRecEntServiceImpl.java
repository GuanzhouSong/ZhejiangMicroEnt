/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.specialrec.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.specialrec.dto.SpecialRecEntDto;
import com.icinfo.cs.specialrec.mapper.SpecialRecEntMapper;
import com.icinfo.cs.specialrec.model.SpecialRecEnt;
import com.icinfo.cs.specialrec.service.ISpecialRecEntService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_special_rec_ent 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年11月01日
 */
@Service
public class SpecialRecEntServiceImpl extends MyBatisServiceSupport implements ISpecialRecEntService {
    
	@Autowired
	private SpecialRecEntMapper specialRecEntMapper;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	
	/**
	 * 描述：查询检查名单列表
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param request
	 * @return pageResponse
	 * @throws Exception
	 */
	@Override
	public List<SpecialRecEntDto> querySpecialrecEntList(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return specialRecEntMapper.selectSpecialRecEntInfoList(request.getParams());
	}
    
	/**
	 * 描述：批量插入检查对象
	 *
	 * @author yujingwei
	 * @date 2017年10月27日
	 * @param taskUid
	 * @param priPIDs
	 * @return String
	 * @throws Exception
	 */
	@Override
	public String addSpecialreceEntBatch(String taskUid, String priPIDs)throws Exception {
		try {
			if (StringUtil.isNotEmpty(priPIDs)) {
				if (StringUtil.isEmpty(taskUid)) {
					taskUid = UUID.randomUUID().toString().replace("-", "");
				}
				String[] pripIdArry =  priPIDs.split(",");
				for (int i = 0; i < pripIdArry.length; i++) {
					SpecialRecEnt specialRecEnt = new SpecialRecEnt();
					MidBaseInfo baseInfo = midBaseInfoService.selectInfoByPriPID(pripIdArry[i]);
					if (baseInfo == null) {
						continue;
					}
					specialRecEnt.setPriPID(baseInfo.getPriPID());
					specialRecEnt.setDom(baseInfo.getDom());
					specialRecEnt.setEntName(baseInfo.getEntName());
					specialRecEnt.setEntTypeCatg(baseInfo.getEntTypeCatg());
					specialRecEnt.setLocalAdm(baseInfo.getLocalAdm());
					specialRecEnt.setLocalAdmName(baseInfo.getLocalAdmName());
					specialRecEnt.setRegNO(baseInfo.getRegNO());
					specialRecEnt.setRegOrg(baseInfo.getRegOrg());
					specialRecEnt.setRegOrgName(baseInfo.getRegOrgName());
					specialRecEnt.setRegState(baseInfo.getRegState());
					specialRecEnt.setSliceNO(baseInfo.getSliceNO());
					specialRecEnt.setSliceNOName(baseInfo.getSliceNOName());
					specialRecEnt.setUniCode(baseInfo.getUniCode());
					specialRecEnt.setTaskUid(taskUid);
					if (!checkEntIsExsit(taskUid,baseInfo.getPriPID())) {
						specialRecEntMapper.insert(specialRecEnt);
					}
				}
				return taskUid;
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 描述：判断是否存在
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @param priPID
	 * @return boolean
	 */
	private boolean checkEntIsExsit(String taskUid, String priPID) {
		Example example = new Example(SpecialRecEnt.class);
		example.createCriteria()
		.andEqualTo("priPID", priPID)
		.andEqualTo("taskUid", taskUid);
		List<SpecialRecEnt> recEnts = specialRecEntMapper.selectByExample(example);
		if (recEnts.size() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 描述：删除检查对象信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param delUidList
	 * @return AjaxResult
	 * @throws Exception
	 */
	@Override
	public int doDelSpecialRecEntInfo(String uidlist) throws Exception{
		int count = 0;
		if (StringUtil.isNotEmpty(uidlist)) {
			String[] uidArry = uidlist.split(",");
			for (int i = 0; i < uidArry.length; i++) {
				SpecialRecEnt specialRecEnt = new SpecialRecEnt();
				specialRecEnt.setUid(uidArry[i]);
				specialRecEntMapper.delete(specialRecEnt);
				count++;
			}
			return count;
		}
		return count;
	}
    
	/**
	 * 描述：清空检查对象
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @return AjaxResult
	 * @throws Exception
	 */
	@Override
	public int doCleanSpecialRecEntInfo(String taskUid) throws Exception {
		if (StringUtil.isNotEmpty(taskUid)) {
			SpecialRecEnt specialRecEnt = new SpecialRecEnt();
			specialRecEnt.setTaskUid(taskUid);
			return specialRecEntMapper.delete(specialRecEnt);
		}
		return 0;
	}
    
	/**
	 * 描述：通过任务编号查询检查对象
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @return List
	 * @throws Exception
	 */
	@Override
	public List<SpecialRecEnt> selectSpecialRecEntInfoList(String taskUid)
			throws Exception {
		Example example = new Example(SpecialRecEnt.class);
		example.createCriteria()
		.andEqualTo("taskUid", taskUid);
		return specialRecEntMapper.selectByExample(example);
	}
	
	/**
	 * 描述：保存检查结果信息
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param recEnt
	 * @throws Exception
	 */
	public void saveSpecialRecEnt(SpecialRecEnt recEnt) throws Exception{
		specialRecEntMapper.insert(recEnt);
	}
	
	/**
	 * 描述：专项整治名单导入
	 * 
	 * @author yujingwei
	 * @date 2017年11月01日
	 * @param taskUid
	 * @throws Exception
	 */
	public JSONObject doAddExcelBatch(InputStream in, String taskUid,SysUserDto sysUser) throws Exception{
		JSONObject json = new JSONObject();
		String message = "";
		int sucNum = 0;
		int failNUm = 0;
		String mainTaskUid = "";
		if (StringUtil.isBlank(taskUid)) {
			mainTaskUid =  UUID.randomUUID().toString().replace("-", "");
		}else{
			mainTaskUid = taskUid;
		}
		//解析excel
		Workbook workbook = WorkbookFactory.create(in);
		Sheet sheet = workbook.getSheetAt(0);
		int rows = sheet.getPhysicalNumberOfRows();
		if (rows < 2) {
			json.put("status", "error");
        	json.put("message", "excel模板无数据。");
			return json;
		}
		String titalName = ExcelUtil.getCellContent(sheet.getRow(0).getCell(0));
		if (!titalName.equals("专项整治名单导入模板")) {
			json.put("status", "error");
			json.put("message", "请使用正确的模板导入！");
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
					addSpecialreceEntBatch(mainTaskUid, midBaseinfo.getPriPID());
				}
			}else{
				message += "第"+(i+1)+"行.【"+row.getCell(0)+"】注册号/统一社会信用代码为空；<br/>";
				failNUm++;
			}
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
		json.put("reTaskUid", mainTaskUid);
		return json;
	}
	
}