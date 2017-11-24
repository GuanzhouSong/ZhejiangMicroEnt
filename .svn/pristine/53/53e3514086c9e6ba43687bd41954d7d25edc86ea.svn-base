/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.BeanUtil;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.mapper.MidBaseInfoMapper;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.favorable.dto.FavorAbleInfoDto;
import com.icinfo.cs.favorable.mapper.FavorAbleInfoHisMapper;
import com.icinfo.cs.favorable.mapper.FavorAbleInfoMapper;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.model.FavorAbleInfoHis;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.upload.utils.ExcelUtil;
import com.icinfo.cs.yr.mapper.PubServerHisModMapper;
import com.icinfo.cs.yr.model.PubServerHisMod;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.mapper.entity.Example.Criteria;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

/**
 * 描述:    cs_favorable_info 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年03月02日
 */
@Service
public class FavorAbleInfoServiceImpl extends MyBatisServiceSupport implements IFavorAbleInfoService {
	
	@Autowired
	FavorAbleInfoMapper favorAbleInfoMapper;
	
	@Autowired
	PubServerHisModMapper pubServerHisModMapper;
	
	@Autowired
	FavorAbleInfoHisMapper favorAbleInfoHisMapper;
	
	@Autowired
	MidBaseInfoMapper midBaseInfoMapper;
	
	@Autowired
	HttpSession session;
	
	/**
	 * 描述：查询企业良好信息录入列表数据
	 * @author yujingwei
	 * @date 2017年3月2日 
	 * @param request
	 * @throws Exception
	 */
	public List<FavorAbleInfoDto> queryPageResult(PageRequest request) throws Exception{
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return favorAbleInfoMapper.selectFavorableInputInfo(request.getParams());
	}

	/**
	 * 
	 * 描述   分页企业良好信息查询
	 * @author 赵祥江
	 * @date 2017年3月3日 下午2:40:33 
	 * @param 
	 * @return List<FavorAbleInfoDto>
	 * @throws
	 */
	@Override
	public List<FavorAbleInfoDto> queryFavorAblePage(PageRequest request)
			throws Exception {
		Map<String,Object> queryMap=request.getParams();
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return favorAbleInfoMapper.selectFavorAbleInfoList(queryMap);
	}

	/**
	 * 
	 * 描述   根据Uid查询
	 * @author  赵祥江
	 * @date 2017年3月6日 下午1:45:34 
	 * @param  
	 * @throws
	 */
	@Override
	public FavorAbleInfo  selectFavorAbleInfoByUid(String uid)
			throws Exception {
		FavorAbleInfo favorAbleInfo=new FavorAbleInfo();
		favorAbleInfo.setUid(uid);
		return favorAbleInfoMapper.selectOne(favorAbleInfo);
	}
	
	/**
	 * 描述：删除企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param uid
	 * @throws Exception
	 */
	public int doDeleteInfoByUid(String uid) throws Exception{
		Example example = new Example(FavorAbleInfo.class);
		example.createCriteria().andEqualTo("uid", uid);
		return favorAbleInfoMapper.deleteByExample(example);
	}

	/**
	 * 描述：保存企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @throws Exception
	 */
	public int doSaveFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception{
		// 审核状态：待审核
		favorAbleInfo.setAuditState("0");
		// 是否有效：无效
		favorAbleInfo.setEfftStatus("0");
		favorAbleInfo.setCreateTime(new Date());
		return favorAbleInfoMapper.insert(favorAbleInfo);
	}
	
	/**
	 * 描述：修改企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param uid ,favorAbleInfo
	 * @throws Exception
	 */
	public int doUpdateFavorableInfo(FavorAbleInfo favorAbleInfo, String uid) throws Exception{
		Example example = new Example(FavorAbleInfo.class);
		example.createCriteria().andEqualTo("uid", uid);
		// 不同意修改 置空审核信息
		if("2".equals(favorAbleInfo.getAuditState())){
			favorAbleInfo.setAuditState("0");
			favorAbleInfo.setAuditDate(null);
			favorAbleInfo.setAuditDept(null);
			favorAbleInfo.setAuditName(null);
			favorAbleInfo.setAuditOpin(null);
		}
		return favorAbleInfoMapper.updateByExample(favorAbleInfo, example);
	}
	
	/**
	 * 描述：企业良好信息审核
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @author boolean
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doCommitFavorableInfo(FavorAbleInfo favorAbleInfo) throws Exception{
		if(favorAbleInfo == null){
			return false;
		}
		// 1.更新审核信息
	    favorAbleInfo.setEfftStatus("1");
		Example example = new Example(FavorAbleInfo.class);
		example.createCriteria().andEqualTo("uid", favorAbleInfo.getUid());
		favorAbleInfoMapper.updateByExampleSelective(favorAbleInfo, example);
		// 2.添加修改记录
		PubServerHisMod pubServerHisMod = new PubServerHisMod();
		pubServerHisMod = doHandleInfo(favorAbleInfo, pubServerHisMod);
		pubServerHisModMapper.insert(pubServerHisMod); 
		// 3.保存历史记录
		FavorAbleInfo favorAbleInfoImpl = this.selectFavorAbleInfoByUid(favorAbleInfo.getUid());
        if(favorAbleInfoImpl != null){
        	FavorAbleInfoHis favorAbleInfoHis = new FavorAbleInfoHis();
        	favorAbleInfoImpl.setId(null);
        	BeanUtil.getBeanUtilsBean().copyProperties(favorAbleInfoHis, favorAbleInfoImpl);
        	favorAbleInfoHis.setCreateTime(new Date());
        	favorAbleInfoHis.setHisNO(pubServerHisMod.getHisNO());
        	favorAbleInfoHisMapper.insert(favorAbleInfoHis);
        }
		return true;
	}
	
	/**
	 * 描述     批量审核
	 * @author yujingwei
	 * @date 2017-03-13
	 * @param favorAbleInfo,uids
	 * @return boolean
	 * @throws Exception
	 */
	@Transactional(rollbackFor = Exception.class)
	public boolean doSaveBatchFavorableInfo(FavorAbleInfo favorAbleInfo,String uids) throws Exception{
		if(favorAbleInfo==null || uids == null){
			return false;
		}
		List<String> favorableUidList = Arrays.asList(uids.split(","));
		if(CollectionUtils.isNotEmpty(favorableUidList)){
			for(String infoUid : favorableUidList){
				FavorAbleInfo favorAbleInfoDB = this.selectFavorAbleInfoByUid(infoUid);
				favorAbleInfoDB.setAuditDate(favorAbleInfo.getAuditDate());
				favorAbleInfoDB.setAuditDept(favorAbleInfo.getAuditDept());
				favorAbleInfoDB.setAuditName(favorAbleInfo.getAuditName());
				favorAbleInfoDB.setAuditOpin(favorAbleInfo.getAuditOpin());
				favorAbleInfoDB.setAuditState(favorAbleInfo.getAuditState());
				doCommitFavorableInfo(favorAbleInfoDB);
			}
		}
		return true;
	}
	
	/**
	 * 描述     Excel批量导入
	 * @author yujingwei
	 * @date 2017-03-13
	 * @param InputStream,sysUser
	 * @return boolean
	 * @throws Exception
	 */
	public Map<String, String> doSaveFavorableInfoExcelBatch(InputStream in,SysUserDto sysUser) throws Exception{
		
	   int i = 0;
	   StringBuilder buff =  new StringBuilder();
	   Map<String, String> resultMap = new HashMap<String, String>();
	   // 数据校验
	   if(in == null || sysUser == null){
		   return null;
	   }
	   List<FavorAbleInfo> favorAbleInfos = excelTranslateToFavorableInfo(in,sysUser);
	   if(favorAbleInfos == null || favorAbleInfos.size() < 0){
		   return null;
	   }
	   for(FavorAbleInfo favorAbleInfo : favorAbleInfos){
		   if((StringUtil.isEmpty(favorAbleInfo.getRegNO())  && StringUtil.isEmpty(favorAbleInfo.getUniSCID()) 
					  || StringUtil.isEmpty(favorAbleInfo.getRegDocNo()))){
			   continue;
			}
		   // 1.判断企业良好信息是否重复
		   int countOne = 0;
		   if(countOne > 0){
			   buff.append(favorAbleInfo.getRegNO()==null?favorAbleInfo.getUniSCID()+'，':favorAbleInfo.getRegNO()+'，');
			   continue;
		   }
		   // 2.判断基本信息库是否存在该企业
		   List<MidBaseInfo> midBaseInfos = doJudgeEntInfoIsExist(favorAbleInfo);
		   if(CollectionUtils.isEmpty(midBaseInfos)){
			   buff.append(favorAbleInfo.getRegNO()==null?favorAbleInfo.getUniSCID()+'，':favorAbleInfo.getRegNO()+'，');
			   continue;
		   }
		   MidBaseInfo midBaseInfo = midBaseInfos.get(0);
		   // 企业信息
		   favorAbleInfo.setPriPID(midBaseInfo.getPriPID());
		   favorAbleInfo.setRegNO(midBaseInfo.getRegNO());
		   favorAbleInfo.setUniSCID(midBaseInfo.getUniCode());
		   favorAbleInfo.setRegOrg(midBaseInfo.getRegOrg());
		   favorAbleInfo.setLocalAdm(midBaseInfo.getLocalAdm());
		   // 录入信息
		   favorAbleInfo.setSetName(sysUser.getRealName());
		   favorAbleInfo.setSetDept(sysUser.getDepartMent().getDeptName());
		   favorAbleInfo.setSetTime(new Date());
		   favorAbleInfo.setCreateTime(new Date());
		   // 审核状态：待审核
		   favorAbleInfo.setAuditState("0");
	       // 是否有效：无效
		   favorAbleInfo.setEfftStatus("0");
		   favorAbleInfoMapper.insert(favorAbleInfo);
		   i++;
	   }
	   String regNOs = buff.toString(); 
	   if(regNOs.length() > 0 && StringUtil.isNotEmpty(regNOs)){
		   resultMap.put("regNOs", buff.toString().substring(0, regNOs.length()-1));
	   }else{
		   resultMap.put("regNOs", "");
	   }
	   resultMap.put("insertNum", String.valueOf(i));
	   return resultMap;	
	}

	/**
	 * 描述：获取企业良好信息（Excel导入）
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param InputStream,sysUser
	 * @throws Exception
	 */
	private List<FavorAbleInfo> excelTranslateToFavorableInfo(InputStream in,SysUserDto sysUser) {
		try {
			//解析excel
			Workbook workbook = WorkbookFactory.create(in);
			Sheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();
			if (rows < 3) {
				return null;
			}
			
			List<FavorAbleInfo> favorAbleInfoList = new ArrayList<FavorAbleInfo>();
			Map<String, String> favTypeMap = getFavTypeCodeMap();
			Map<String, String> licZoneMap = getLicZoneCodeMap();
			// 遍历处理每行
			for (int i = 2; i < rows; i++) {
				FavorAbleInfo favorAbleInfo = new FavorAbleInfo();
				Row row = sheet.getRow(i);
				if (row == null || row.getCell(0) == null) {
					continue;
				}
				String regOrUnicode = com.icinfo.cs.common.utils.ExcelUtil.parseCellValueToString(row.getCell(0));// 注册号或统一代码
				if(regOrUnicode == null){
					continue;
				}
				if(regOrUnicode.length() == 18){
					favorAbleInfo.setUniSCID(regOrUnicode);
				}else
					favorAbleInfo.setRegNO(regOrUnicode);
				String entName = ExcelUtil.getCellContent(row.getCell(1));  //企业名称
				if(entName == null || entName.equals("测试企业")){				//防止示例导入
					continue;
				}
				favorAbleInfo.setEntName(entName);
				String favType = ExcelUtil.getCellContent(row.getCell(2));  //信息类别
				if(favType == null){
					continue;
				}
				favorAbleInfo.setFavType(favTypeMap.get(favType));
				String licZone = ExcelUtil.getCellContent(row.getCell(3));  //信息级别
				if(licZone == null){
					continue;
				}
				favorAbleInfo.setLicZone(licZoneMap.get(licZone));
				String year = ExcelUtil.getCellContent(row.getCell(4));     //信息认定年度
				if(year == null){
					continue;
				}
				favorAbleInfo.setRegYear(Integer.valueOf(year));
				String regType = ExcelUtil.getCellContent(row.getCell(5));  //信息认定类别
				if(StringUtil.isNotEmpty(regType)){
					favorAbleInfo.setRegType(regType);
				}
				String regFrom = ExcelUtil.getCellContent(row.getCell(6));  //有效期限
				String regTo = ExcelUtil.getCellContent(row.getCell(7));
				if(regFrom == null || regTo ==null){
					continue;
				}
				favorAbleInfo.setRegFrom(checkWorkTime(regFrom));
				favorAbleInfo.setRegTo(checkWorkTime(regTo));
				String regDocNo = ExcelUtil.getCellContent(row.getCell(8)); // 认定发布文号
				String regDeptCn = ExcelUtil.getCellContent(row.getCell(9));// 认定发布部门
				String regDate = ExcelUtil.getCellContent(row.getCell(10)); // 认定发布时间
				if(regDocNo ==null || regDeptCn ==null || regDate == null){
					continue;
				}
				favorAbleInfo.setRegDocNo(regDocNo);
				favorAbleInfo.setRegDeptCn(regDeptCn);
				favorAbleInfo.setRegDate(checkWorkTime(regDate));
				String reMark = ExcelUtil.getCellContent(row.getCell(11)); // 备注
				if(StringUtil.isNotEmpty(reMark)){
					favorAbleInfo.setRemark(reMark);
				}
				String favName = ExcelUtil.getCellContent(row.getCell(12)); // 良好企业名称
				if(StringUtil.isNotEmpty(favName)){
					favorAbleInfo.setFavName(favName);
				}
				favorAbleInfoList.add(favorAbleInfo);
			}
			return favorAbleInfoList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 
	 * 描述   根据主体代码查询已经审核通过的企业良好信息
	 * @author  赵祥江
	 * @date 2017年3月9日 上午10:09:09 
	 * @param  
	 * @throws
	 */ 
	@Override
	public List<FavorAbleInfo> selectFavorAbleInfoBypriPIDAndEfftStatus(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return favorAbleInfoMapper.selectFavorAbleInfoBypriPIDAndEfftStatus(request.getParams());
	}

	/**
	 * 
	 * 描述   根据主体代码查询已经审核通过的不良信息
	 * @author  赵祥江
	 * @date 2017年3月9日 下午2:01:43 
	 * @param  
	 * @throws
	 */
	@Override
	public List<FavorAbleInfo> selectCaseInfoBypriPIDAndEfftStatus(
			PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return favorAbleInfoMapper.selectCaseInfoBypriPIDAndEfftStatus(request.getParams());
	}
	
	/**
	 * 描述：通过注册号和统一代码查询企业信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @return int
	 */
	public List<MidBaseInfo> doJudgeEntInfoIsExist(FavorAbleInfo favorAbleInfo) {
		Example example = new Example(MidBaseInfo.class);
		Criteria criteria = example.createCriteria();
		criteria.andEqualTo("regNO", favorAbleInfo.getRegNO());
		Criteria criteria2 = example.createCriteria();
		criteria2.andEqualTo("uniCode", favorAbleInfo.getUniSCID());
		example.or(criteria2);
		return midBaseInfoMapper.selectByExample(example);
	}
    
	/**
	 * 描述：通过注册和，统一代码查询，发布文号查询企业良好信息
	 * @author yujingwei
	 * @date 2017年3月8日 
	 * @param favorAbleInfo
	 * @return int
	 */
	private int doJudgeFavorableInfoIsDuble(FavorAbleInfo favorAbleInfo) {
		Example example = new Example(FavorAbleInfo.class);
		Criteria criteria = example.createCriteria();
		if(StringUtil.isNotEmpty(favorAbleInfo.getRegNO())){
			criteria.andEqualTo("regNO", favorAbleInfo.getRegNO())
			.andEqualTo("regDocNo", favorAbleInfo.getRegDocNo());
			return favorAbleInfoMapper.selectCountByExample(example);
		}else{
			criteria.andEqualTo("uniSCID", favorAbleInfo.getUniSCID())
			.andEqualTo("regDocNo", favorAbleInfo.getRegDocNo());
			return favorAbleInfoMapper.selectCountByExample(example);
		}
	}
	
	/**
	 * 描述：生成修改记录信息
	 * @param favorAbleInfo,pubServerHisMod
	 * @return pubServerHisMod
	 */
	public PubServerHisMod doHandleInfo(FavorAbleInfo favorAbleInfo, PubServerHisMod pubServerHisMod){
		pubServerHisMod.setHisNO(StringUtil.getRandomNumber(favorAbleInfo.getPriPID()));
		pubServerHisMod.setPriPID(favorAbleInfo.getPriPID());
		pubServerHisMod.setAltDate(favorAbleInfo.getSetTime());
		pubServerHisMod.setAltName(favorAbleInfo.getSetName());
		pubServerHisMod.setAuditState(favorAbleInfo.getAuditState());
		pubServerHisMod.setAuditDate(favorAbleInfo.getAuditDate());
		pubServerHisMod.setAuditName(favorAbleInfo.getAuditName());
		pubServerHisMod.setModUID(favorAbleInfo.getUid());
		pubServerHisMod.setAltTable("cs_favorable_info");
		return pubServerHisMod;
	}
	
	/**
	 * 描述：良好信息类别转换成编码（excel导入）
	 * @param favType
	 */
	private Map<String, String> getFavTypeCodeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("百强民营企业", "0");
		map.put("驰名商标", "1");
		map.put("知名商号", "2");
		map.put("著名商标", "3");
		map.put("守合同重信用企业", "4");
		map.put("信用示范管理企业", "5");
		map.put("小微企业成长之星", "6");
		return map;
	}
	
	/**
	 * 描述：良好信息类别转换成编码（excel导入）
	 * @param favType
	 */
	private  Map<String, String> getLicZoneCodeMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("全国", "0");
		map.put("省级", "1");
		map.put("县级", "2");
		map.put("市级", "3");
		return map;
	}
	
	 /**
     * 日期格式转换
     * @param timeStr
     * @return date
     */
    private Date checkWorkTime(String timeStr) {
        if (StringUtil.isBlank(timeStr)) {
            return null;
        }
        try{
        	return DateUtil.stringToDate(timeStr, "yyyy-MM-dd");
        }catch(Exception e){
        	return null;
        }
    }

	@Override
	public List<FavorAbleInfo> selectListByCerNO(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		return favorAbleInfoMapper.selectListByCerNO(request.getParams());
	}

	@Override
	public List<FavorAbleInfo> selectFavorAbleInfoForBulletin(String updateDate) {
		return favorAbleInfoMapper.selectFavorAbleInfoForBulletin(updateDate);
	}

	/** 
	 * 描述: 分页查询良好荣誉信息
	 * @auther ZhouYan
	 * @date 2017年10月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<FavorAbleInfo> queryFavorAbleInfoForPub(PageRequest request)
			throws Exception {
		PageHelper.startPage(request.getPageNum(), request.getLength());
		Map<String, Object> paramsMap = request.getParams();
		if(paramsMap != null && StringUtils.isNotEmpty(paramsMap.get("priPID").toString())){
			Example example = new Example(FavorAbleInfo.class);
			List<String> favType = new ArrayList<String>();
			for (String s : "0,1,2,3,4,5,6".split(",")) {
				favType.add(s);
			}
			List<String> licZone = new ArrayList<String>();
			for (String s : "0,1,2,3,4,5,6".split(",")) {
				licZone.add(s);
			}
			example.createCriteria().andEqualTo("priPID", paramsMap.get("priPID")).andIn("favType", favType).andIn("licZone", licZone).andEqualTo("auditState","1");// 否
			List<FavorAbleInfo> favorAbleInfo = favorAbleInfoMapper.selectByExample(example);
			return favorAbleInfo;
		} else {
			return null;
		}
	}
	
	
}