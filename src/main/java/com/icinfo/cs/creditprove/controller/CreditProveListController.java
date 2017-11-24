/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.creditprove.controller;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.creditprove.dto.CreditProveListDto;
import com.icinfo.cs.creditprove.model.CreditProveInfo;
import com.icinfo.cs.creditprove.model.CreditProveList;
import com.icinfo.cs.creditprove.model.CreditProvePrintHis;
import com.icinfo.cs.creditprove.service.ICreditProveInfoService;
import com.icinfo.cs.creditprove.service.ICreditProveListService;
import com.icinfo.cs.creditprove.service.ICreditProvePrintHisService;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.opanomaly.model.PubOpanoMaly;
import com.icinfo.cs.registmanage.model.QualificationLimit;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.service.IPubOtherPunishAlterService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    cs_credit_prove_list 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年04月05日
 */
@Controller
@RequestMapping({ "/syn/creditprovelist", "/reg/server/creditprovelist" })
public class CreditProveListController extends CSBaseController {
	@Autowired
	private ICreditProveListService creditProveListService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private ICreditProveInfoService creditProveInfoService;
	@Autowired
	private IPubOtherPunishAlterService pubOtherPunishAlterService;
	@Autowired
	private ICreditProvePrintHisService creditProvePrintHisService;
	
	
	
	/**
	 * 
	 * 描述   分页查询企业名单
	 * @author 赵祥江
	 * @date 2017年4月6日 下午1:54:36 
	 * @param 
	 * @return PageResponse<CreditProveListDto>
	 * @throws
	 */
	@RequestMapping("/selectCreditProveEntListJSON.json")
	@ResponseBody
	public PageResponse<CreditProveListDto> selectCreditProveEntListJSON(PageRequest request) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		if(queryMap!=null&&queryMap.containsKey("searchTypeStr")&&!"".equals(queryMap.get("searchTypeStr").toString())){
		    String[] searchTypeArr=queryMap.get("searchTypeStr").toString().split(",");
		    for(int i=0;i<searchTypeArr.length;i++){
		    	if("1".equals(searchTypeArr[i])){
		    		queryMap.put("searchType1", "1");
		    	}else if("2".equals(searchTypeArr[i])){
		    		queryMap.put("searchType2", "2");
		    	}else if("3".equals(searchTypeArr[i])){
		    		queryMap.put("searchType3", "3");
		    	}else if("4".equals(searchTypeArr[i])){
		    		queryMap.put("searchType4", "4");
		    	}
		    }
		}
		if(queryMap!=null&&queryMap.containsKey("uniCode_regNO")&&!"".equals(queryMap.get("uniCode_regNO").toString())){
		     if(queryMap.get("uniCode_regNO").toString().length()==4){
		    	 queryMap.put("uniCode_regNO4", queryMap.get("uniCode_regNO").toString());
		    	 queryMap.remove("uniCode_regNO");
		     }
			
		}
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		queryMap.put("regState", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("regState").toString(),",")); 
		queryMap.put("proveType", "1"); 
		List<CreditProveListDto> creditProveListDtoList=creditProveListService.selectCreditProveEntListJSON(request);
		return  new PageResponse<CreditProveListDto>(creditProveListDtoList); 
	}
	
	/**
	 * 
	 * 描述   分页查询自然人名称
	 * @author 赵祥江
	 * @date 2017年4月19日 下午3:28:32 
	 * @param 
	 * @return PageResponse<CreditProveListDto>
	 * @throws
	 */
	@RequestMapping("/selectCreditProveManListJSON.json")
	@ResponseBody
	public PageResponse<CreditProveListDto> selectCreditProveManListJSON(PageRequest request) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		if(queryMap==null){
			queryMap=new HashMap<String,Object>();
		}
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap); 
		queryMap.put("proveType", "2"); 
		request.setParams(queryMap);
		List<CreditProveListDto> creditProveListDtoList=creditProveListService.selectCreditProveEntListJSON(request);
		return  new PageResponse<CreditProveListDto>(creditProveListDtoList); 
	}
	
	/**
	 * 
	 * 描述   进入添加企业名单页面
	 * @author 赵祥江
	 * @date 2017年4月6日 下午3:28:07 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/creditprovelistPage")
	public ModelAndView creditprovelistPage(HttpSession session,String proveType) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveent_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		view.addObject("proveType", proveType);
		return view;
	}
	
	/**
	 * 
	 * 描述   进入信用比对页面
	 * @author 赵祥江
	 * @date 2017年4月10日 上午10:24:17 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/creditProveEntComparePage")
	public ModelAndView creditProveEntComparePage(HttpSession session,String pripids) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveentcompare_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			view.addObject("deptName",sysUser.getSysDepart().getOrgName());
		}else{
			view.addObject("deptName",sysUser.getDepartMent().getDeptName());
		}
		//要比对的企业主体身份代码 多个用逗号隔开
		view.addObject("pripids",pripids);
		view.addObject("sysUrl", sysUrl);
		Date nowDate=DateUtil.getSysDate();
		view.addObject("nowDate",nowDate); 
		view.addObject("nowDateStr",DateUtil.dateToString(nowDate, "yyyy-MM-dd HH:mm:ss"));
		String[] pripidsArr= pripids.split(",");
		List<MidBaseInfoDto> midBaseInfoDtoList=new ArrayList<MidBaseInfoDto>();
		Map<String,Object> queryMap=new HashMap<String,Object>();
		for(int i=0;i<pripidsArr.length;i++){
			queryMap.put("PriPID", pripidsArr[i]);
			List<MidBaseInfoDto> midBaseInfoDtoListTem=this.midBaseInfoService.selectMidBaseinfoByRegNoAndName(queryMap);
			if(midBaseInfoDtoListTem.size()>0){
				midBaseInfoDtoList.addAll(midBaseInfoDtoListTem);
			}
		}
		view.addObject("midBaseInfoDtoList", midBaseInfoDtoList);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   查看详情
	 * @author 赵祥江
	 * @date 2017年4月18日 上午10:37:18 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/viewDetail")
	public ModelAndView viewDetail(HttpSession session,String proveNo) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveentdetail_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		
		String pripids="";
		String proveType="";
		String cerNOs="";
		String uids="";
		List<CreditProveInfo> creditProveInfoList= creditProveInfoService.selectCreditProveInfoByProveNo(proveNo);
		if(creditProveInfoList.size()>0){
			for(CreditProveInfo creditProveInfo:creditProveInfoList){
				if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(creditProveInfo.getPriPID())){
					pripids+=creditProveInfo.getPriPID()+",";
				}
				if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(creditProveInfo.getCerNO())){
					cerNOs+=creditProveInfo.getCerNO()+",";
				}
				uids+=creditProveInfo.getUID()+",";
			}
			proveType=creditProveInfoList.get(0).getProveType();
		}
		
		if("2".equals(proveType)){
			List<CreditProveListDto> creditProveListDtoListTem= creditProveListService.selectProPidListBycertNO(com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(cerNOs,","));
			if(creditProveListDtoListTem.size()>0){
				for(CreditProveListDto creditProveListDto:creditProveListDtoListTem){
					pripids+=creditProveListDto.getPriPID()+",";
				}
			}
		}
		
		if("2".equals(proveType)){
			view  = new ModelAndView("/syn/system/creditprove/creditprovemandetail_edit");
			view.addObject("creditProveListDtoList",creditProveInfoList); 
		}else{
			view.addObject("creditProveInfoList",creditProveInfoList); 
		}
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			view.addObject("deptName",sysUser.getSysDepart().getOrgName());
		}else{
			view.addObject("deptName",sysUser.getDepartMent().getDeptName());
		}
		view.addObject("pripids",pripids); 
		view.addObject("proveType",proveType); 
		view.addObject("sysUrl",sysUrl); 
		view.addObject("cerNOs",cerNOs);
		view.addObject("uids",uids);
		return view;
	}
	
	/**
	 * 
	 * 描述   打印
	 * @author 赵祥江
	 * @date 2017年4月18日 下午3:05:06 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/print")
	public ModelAndView print(HttpSession session,String proveNo) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditproveentprint_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			view.addObject("deptName",sysUser.getSysDepart().getOrgName());
		}else{
			view.addObject("deptName",sysUser.getDepartMent().getDeptName());
		}
		String pripids="";
		String proveType="";
		String cerNOs="";
		String proveScope="";
		//是否违法记录
		int ispunish=0;
		List<CreditProveInfo> creditProveInfoList= creditProveInfoService.selectCreditProveInfoByProveNo(proveNo);
		if(creditProveInfoList.size()>0){
			for(CreditProveInfo creditProveInfo:creditProveInfoList){
				if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(creditProveInfo.getPriPID())){
					pripids+=creditProveInfo.getPriPID()+",";
				}
				if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(creditProveInfo.getCerNO())){
					cerNOs+=creditProveInfo.getCerNO()+",";
				}
			}
			proveType=creditProveInfoList.get(0).getProveType(); 
			//查证范围
			proveScope=creditProveInfoList.get(0).getProveScope();
		}
		if("2".equals(proveType)){
			view  = new ModelAndView("/syn/system/creditprove/creditprovemanprint_edit");
			List<CreditProveListDto> creditProveListDtoListTem= creditProveListService.selectProPidListBycertNO(com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(cerNOs,","));
			if(creditProveListDtoListTem.size()>0){
				for(CreditProveListDto creditProveListDto:creditProveListDtoListTem){
					pripids+=creditProveListDto.getPriPID()+",";
				}
			}
			view.addObject("creditProveListDtoList",creditProveInfoList); 
		}else{
			view.addObject("creditProveInfoList",creditProveInfoList); 
		}
		
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("proveNo", proveNo);
		PageRequest request=new PageRequest (); 
		request.setParams(queryMap);
		request.setLength(999999);
		request.setPageNum(0);
		//根据查证编号获取打印记录
		List<CreditProvePrintHis> creditProvePrintHisList=creditProvePrintHisService.selectCreditProvePrintHisJSON(request);
		view.addObject("creditProvePrintHisList",creditProvePrintHisList);
		queryMap.remove("proveNo");
		List<QualificationLimit> qualificationLimitList=null;
		if(com.icinfo.cs.common.utils.StringUtil.isNotBlank(pripids)){
			queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(pripids,","));
			queryMap.put("proveStartDate", DateUtil.dateToString(creditProveInfoList.get(0).getProveStartDate(), "yyyy-MM-dd"));
			queryMap.put("proveEntDate", DateUtil.dateToString(creditProveInfoList.get(0).getProveEntDate(), "yyyy-MM-dd"));
			request.setParams(queryMap);
			if(proveScope.indexOf("1")>=0){
				//工商行政处罚
				List<PubOtherpunishDto> gsPunishList=creditProveListService.selectMidCaseInfoByPripids(request);
				if(gsPunishList.size()>0){
					for(PubOtherpunishDto pubOtherpunishDto: gsPunishList){
						String caseNo=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getCaseNO())?"00000":pubOtherpunishDto.getCaseNO();
						String pripid=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getPriPID())?"00000":pubOtherpunishDto.getPriPID();
						//变更信息
						pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterService.doGetAlterInfoList(pripid, caseNo));
					}
				}
				ispunish=gsPunishList.size();
				view.addObject("gsPunishList",gsPunishList);
			}
			
			if(proveScope.indexOf("2")>=0){
				//其他部门行政处罚
				List<PubOtherpunishDto> pubOtherpunishList=creditProveListService.selectPubOtherpunishByPripids(request);
				if(pubOtherpunishList.size()>0){
					for(PubOtherpunishDto pubOtherpunishDto: pubOtherpunishList){
						String caseNo=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getCaseNO())?"00000":pubOtherpunishDto.getCaseNO();
						String pripid=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getPriPID())?"00000":pubOtherpunishDto.getPriPID();
						//变更信息
						pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterService.doGetAlterInfoList(pripid, caseNo));
					}
					if(ispunish==0){
						ispunish=pubOtherpunishList.size();
					}
				} 
				view.addObject("pubOtherpunishList",pubOtherpunishList);
			}
			
			if(proveScope.indexOf("3")>=0){
				//异常名录
				List<PubOpanoMaly> pubOpanoMalyList= creditProveListService.selectOpanomalyResultMapByPripids(request);
				if(ispunish==0){
					ispunish=pubOpanoMalyList.size();
				}
				view.addObject("pubOpanoMalyList",pubOpanoMalyList);
			}
			
			if(proveScope.indexOf("4")>=0){
				//严重违法失信
				List<ExpSeriousCrimeList> expSeriousCrimeListList= creditProveListService.selectExpSeriousCrimeByPripids(request);
				if(ispunish==0){
					ispunish=expSeriousCrimeListList.size();
				}
				view.addObject("expSeriousCrimeListList",expSeriousCrimeListList);
			}
			
			if(proveScope.indexOf("5")>=0){
				if("2".equals(proveType)){//失信被执行人黑名单
					qualificationLimitList=creditProveListService.selectQualificationLimitTypePripids(request);
				}else{
					 //任职资格限制
					 qualificationLimitList=creditProveListService.selectQualificationLimitByPripids(request);
					 if(ispunish==0){
						 ispunish=qualificationLimitList.size();
					 }
				}
				view.addObject("qualificationLimitList",qualificationLimitList);
			}
		}
		if("2".equals(proveType)){//失信被执行人黑名单 
			 queryMap.put("certNO", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(cerNOs,",")); 
			 List<CreditProveListDto> creditProveListDtoList=creditProveListService.selectMidInvDivTableBycerNOs(request);
			 view.addObject("midInvDivList",creditProveListDtoList);
		}
		view.addObject("pripids",pripids); 
		view.addObject("sysUrl",sysUrl);
		view.addObject("ispunish",ispunish);
		return view;
	}
	
	
	
	/**
	 * 
	 * 描述   删除
	 * @author 赵祥江
	 * @date 2017年4月6日 下午3:21:21 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(String uid) throws Exception{
		if (StringUtil.isNotEmpty(uid)) { 
			try {
				String[] uidArr=uid.split(",");
				for(int i=0;i<uidArr.length;i++){
				    creditProveListService.deleteCreditProveListByUid(uidArr[i]);
				}
				return AjaxResult.success("删除成功");
			} catch (Exception e) {
				e.printStackTrace();
			}   
		}
		return  AjaxResult.error("删除失败");
	}
	
	
	
	/**
	 * 
	 * 描述   保存
	 * @author 赵祥江
	 * @date 2017年4月6日 下午3:45:37 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/saveCreditProveList")
	@ResponseBody
	public AjaxResult saveCreditProveList(String regNO,String entName,String proveType,HttpSession session) throws Exception {
		try {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			CreditProveList creditProveList=new CreditProveList();
			creditProveList.setSetName(sysUser.getRealName());
			creditProveList.setSetTime(DateUtil.getSysDate());
			creditProveList.setProveType(proveType);
			if("1".equals(proveType)){
				PageRequest request=new PageRequest();
				Map<String,Object> queryMap=new HashMap<String,Object>();
				queryMap.put("uniCode_regNO", regNO);
				queryMap.put("entname", entName);
				request.setParams(queryMap);
				List<MidBaseInfo> midBaseInfoList= midBaseInfoService.queryPage(request);
				if(midBaseInfoList.size()==0){
					return AjaxResult.error("根据统一信用代码/注册号和企业名称没有找到企业基本信息,请检查检查您输入的信息是否正确!");
				}
				creditProveList.setPriPID(midBaseInfoList.get(0).getPriPID());
				creditProveList.setRegNO(midBaseInfoList.get(0).getRegNO());
				creditProveList.setUniSCID(midBaseInfoList.get(0).getUniCode());
				creditProveList.setEntName(entName);
				List<CreditProveList>  creditProve=creditProveListService.selectCreditProveListByRegNOAndPriPID(creditProveList.getRegNO(), creditProveList.getPriPID());
				if(creditProve!=null&&creditProve.size()>0){
					return AjaxResult.error(entName+"（"+regNO+"）已经存在!无需重复添加");
				  // creditProveList.setUid(creditProve.getUid());
				  // creditProveListService.updateCreditProveListByUid(creditProveList);
				}else{
				   creditProveListService.insertCreditProveList(creditProveList);
				}
			}else{
				creditProveList.setCerNO(entName);	
				creditProveList.setName(regNO);	
				List<CreditProveList>   creditProveTem = creditProveListService.selectCreditProveListByCerNO(creditProveList.getCerNO());
				if(creditProveTem!=null&&creditProveTem.size()>0){
					 return AjaxResult.error(regNO+"（"+entName+"）已经存在!无需重复添加");
//					 creditProveList.setUid(creditProveTem.getUid());
//					 creditProveListService.updateCreditProveListByUid(creditProveList);
				}else{
					 creditProveListService.insertCreditProveList(creditProveList);
				}
			}
			return AjaxResult.success("新增成功");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("新增失败");
	}
	
	/**
	 * 
	 * 描述   加入台账
	 * @author 赵祥江
	 * @date 2017年4月10日 下午3:24:49 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/creatTz")
	@ResponseBody
	public AjaxResult creatTz(String nowDate, String proveStartDate,String proveEntDate,String pripids,String searchType,HttpSession session) throws Exception {
		try {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String name=sysUser.getRealName();
			String deptName="";
			String adCode=""; 
			if("2".equals(sysUser.getUserType())){
				deptName=sysUser.getSysDepart().getOrgName();
				adCode=sysUser.getSysDepart().getAdcode();
			}else{
				deptName=sysUser.getDepartMent().getDeptName();
				adCode=sysUser.getDepartMent().getDeptCode();
			}
			MidBaseInfoDto midBaseInfoDto=null;
			String[] pripidsArr= pripids.split(",");
			String proveNo=creditProveInfoService.getProveNo("1");
			if(pripidsArr.length>0){
				for(int i=0;i<pripidsArr.length;i++){ 
					CreditProveInfo creditProveInfo=new CreditProveInfo();
					creditProveInfo.setPriPID(pripidsArr[i]);
					List<MidBaseInfoDto> midBaseInfoDtoList= midBaseInfoService.doGetListByPriPID(pripidsArr[i]);
				    if(midBaseInfoDtoList.size()>0){
				    	midBaseInfoDto=midBaseInfoDtoList.get(0);
				    	creditProveInfo.setUniSCID(midBaseInfoDto.getUniCode());
				    	creditProveInfo.setProveScope(searchType);
				    	creditProveInfo.setEntName(midBaseInfoDto.getEntName());
				    	creditProveInfo.setRegNO(midBaseInfoDto.getRegNO());
				    	creditProveInfo.setSetDate(DateUtil.stringToDate(nowDate,"yyyy-MM-dd HH:mm:ss"));
				    	creditProveInfo.setProveStartDate(DateUtil.stringToDate(proveStartDate,"yyyy-MM-dd"));
				    	creditProveInfo.setProveEntDate(DateUtil.stringToDate(proveEntDate,"yyyy-MM-dd"));
				    	creditProveInfo.setProveType("1");
				    	creditProveInfo.setSetName(name);
				    	creditProveInfo.setAdCode(adCode);
				    	creditProveInfo.setSetDept(deptName);
				    	creditProveInfo.setProveNo(proveNo);
				    	creditProveInfoService.insertCreditProveInfo(creditProveInfo);
				    }
				}
			}
			return AjaxResult.success("加入台账成功",proveNo);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("加入台账失败");
	}
	
	
	/**
	 * 
	 * 描述   加入台账 个人
	 * @author 赵祥江
	 * @date 2017年4月21日 下午2:51:15 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/creatManTz")
	@ResponseBody
	public AjaxResult creatManTz(String nowDate, String proveStartDate,String proveEntDate,String uids,String searchType,HttpSession session) throws Exception {
		try {
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			String name=sysUser.getRealName();
			String deptName="";
			String adCode="";
			if("2".equals(sysUser.getUserType())){
				deptName=sysUser.getSysDepart().getOrgName();
				adCode=sysUser.getSysDepart().getAdcode();
			}else{
				deptName=sysUser.getDepartMent().getDeptName();
				adCode=sysUser.getDepartMent().getDeptCode();
			}
			String[] uidsArr= uids.split(",");
			String proveNo=creditProveInfoService.getProveNo("2");
			if(uidsArr.length>0){
				for(int i=0;i<uidsArr.length;i++){ 
					    CreditProveInfo creditProveInfo=new CreditProveInfo();
				    	creditProveInfo.setProveScope(searchType);
				    	creditProveInfo.setSetDate(DateUtil.stringToDate(nowDate,"yyyy-MM-dd HH:mm:ss"));
				    	creditProveInfo.setProveStartDate(DateUtil.stringToDate(proveStartDate,"yyyy-MM-dd"));
				    	creditProveInfo.setProveEntDate(DateUtil.stringToDate(proveEntDate,"yyyy-MM-dd"));
				    	creditProveInfo.setProveType("2");
				    	creditProveInfo.setSetName(name);
				    	creditProveInfo.setAdCode(adCode);
				    	creditProveInfo.setSetDept(deptName);
				    	creditProveInfo.setProveNo(proveNo);
				    	CreditProveList creditProveList  =creditProveListService.selectCreditProveListByUid(uidsArr[i]);
				    	creditProveInfo.setCerNO(creditProveList==null?"":creditProveList.getCerNO());
				    	creditProveInfo.setName(creditProveList==null?"":creditProveList.getName());
				    	creditProveInfoService.insertCreditProveInfo(creditProveInfo);
				    
				}
			}
			return AjaxResult.success("加入台账成功",proveNo);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return AjaxResult.error("加入台账失败");
	}
	
	
	/**
	 * 
	 * 描述   企业名单模板下载
	 * @author 赵祥江
	 * @date 2017年4月6日 下午4:36:53 
	 * @param 
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	@RequestMapping("/downLoadEnt")
	public ResponseEntity<byte[]> downLoadEnt(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/views/page/syn/system/creditprove")+File.separator+"creditproveent.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("creditproveent.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	/**
	 * 
	 * 描述   自然人模板下载
	 * @author 赵祥江
	 * @date 2017年4月19日 下午4:59:29 
	 * @param 
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	@RequestMapping("/downLoadMan")
	public ResponseEntity<byte[]> downLoadMan(HttpServletRequest request, String file_name)throws Exception{
		String path = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/views/page/syn/system/creditprove")+File.separator+"creditproveman.xlsx";
		File file=new File(path);
		HttpHeaders headers = new HttpHeaders();
		//更改下载名称
		String fileName=new String("creditproveman.xlsx".getBytes("GBK"),"iso-8859-1");
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
	}
	
	
	/**
	 * 
	 * 描述   企业名单导入
	 * @author 赵祥江
	 * @date 2017年4月6日 下午5:09:19 
	 * @param 
	 * @return void
	 * @throws
	 */
	@RequestMapping(value="/addbatch",method= RequestMethod.POST)
    @ResponseBody
    public void addbatch(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        Map<String, String> resultMap = creditProveListService.doSaveCreditProveListExcelBatch(in, sysUser,"1");
        JSONObject json = new JSONObject();
        if(resultMap != null){
        	json.put("state", "success");
        	json.put("status", resultMap.get("status"));
            json.put("allImportTatol", resultMap.get("allImportTatol"));
            json.put("msg", resultMap.get("msg"));
        }else{
        	json.put("state", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	
	/**
	 * 
	 * 描述   导入自然人名单
	 * @author 赵祥江
	 * @date 2017年4月19日 下午5:06:15 
	 * @param 
	 * @return void
	 * @throws
	 */
	@RequestMapping(value="/addManbatch",method= RequestMethod.POST)
    @ResponseBody
    public void addManbatch(@RequestParam("file") MultipartFile file,HttpServletResponse response,HttpSession session) throws Exception {
        InputStream in = file.getInputStream();
        SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        Map<String, String> resultMap = creditProveListService.doSaveCreditProveListExcelBatch(in, sysUser,"2");
        JSONObject json = new JSONObject();
        if(resultMap != null){
        	json.put("state", "success");
        	json.put("status", resultMap.get("status"));
            json.put("allImportTatol", resultMap.get("allImportTatol"));
            json.put("msg", resultMap.get("msg"));
        }else{
        	json.put("state", "error");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print(json);
        response.getWriter().flush();
        response.getWriter().close();//关闭流
    }
	
	
	
	
	/**
	 * 
	 * 描述   获取工商行政处罚
	 * @author 赵祥江
	 * @date 2017年4月10日 下午5:45:16 
	 * @param 
	 * @return PageResponse<PubOtherpunishDto>
	 * @throws
	 */
	@RequestMapping("/selectMidCaseInfoByPripids.json")
	@ResponseBody
	public PageResponse<PubOtherpunishDto> selectMidCaseInfoByPripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		request.setParams(queryMap);
		List<PubOtherpunishDto> data=creditProveListService.selectMidCaseInfoByPripids(request);
		if(data.size()>0){
			for(PubOtherpunishDto pubOtherpunishDto: data){
				String caseNo=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getCaseNO())?"00000":pubOtherpunishDto.getCaseNO();
				String pripid=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getPriPID())?"00000":pubOtherpunishDto.getPriPID();
				//变更信息
				pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterService.doGetAlterInfoList(pripid, caseNo));
			}
		}
		return  new PageResponse<PubOtherpunishDto>(data); 
	}
	
	/**
	 * 
	 * 描述   获取其他部门的行政处罚
	 * @author 赵祥江
	 * @date 2017年4月11日 上午9:23:20 
	 * @param 
	 * @return PageResponse<PubOtherpunishDto>
	 * @throws
	 */
	@RequestMapping("/selectPubOtherpunishByPripids.json")
	@ResponseBody
	public PageResponse<PubOtherpunishDto> selectPubOtherpunishByPripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		List<PubOtherpunishDto> data=creditProveListService.selectPubOtherpunishByPripids(request);
		if(data.size()>0){
			for(PubOtherpunishDto pubOtherpunishDto: data){
				String caseNo=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getCaseNO())?"00000":pubOtherpunishDto.getCaseNO();
				String pripid=com.icinfo.framework.mybatis.mapper.util.StringUtil.isEmpty(pubOtherpunishDto.getPriPID())?"00000":pubOtherpunishDto.getPriPID();
				//变更信息
				pubOtherpunishDto.setPubOtherPunishAlterList(pubOtherPunishAlterService.doGetAlterInfoList(pripid, caseNo));
			}
		} 
		return  new PageResponse<PubOtherpunishDto>(data); 
	}
	
	/**
	 * 
	 * 描述   异常名录
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:05:32 
	 * @param 
	 * @return PageResponse<PubOtherpunishDto>
	 * @throws
	 */
	@RequestMapping("/selectOpanomalyResultMapByPripids.json")
	@ResponseBody
	public PageResponse<PubOpanoMaly> selectOpanomalyResultMapByPripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		request.setParams(queryMap);
		List<PubOpanoMaly> data= creditProveListService.selectOpanomalyResultMapByPripids(request);
		return  new PageResponse<PubOpanoMaly>(data); 
	}
	
	/**
	 * 
	 * 描述   获取严重违法失信
	 * @author 赵祥江
	 * @date 2017年4月11日 上午10:30:42 
	 * @param 
	 * @return PageResponse<PubOpanoMaly>
	 * @throws
	 */
	@RequestMapping("/selectExpSeriousCrimeByPripids.json")
	@ResponseBody
	public PageResponse<ExpSeriousCrimeList> selectExpSeriousCrimeByPripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		List<ExpSeriousCrimeList> expSeriousCrimeListList= creditProveListService.selectExpSeriousCrimeByPripids(request);
		return  new PageResponse<ExpSeriousCrimeList>(expSeriousCrimeListList); 
	}
	
	/**
	 * 
	 * 描述   获取任职资格限制
	 * @author 赵祥江
	 * @date 2017年4月11日 上午11:05:55 
	 * @param 
	 * @return PageResponse<QualificationLimit>
	 * @throws
	 */
	@RequestMapping("/selectQualificationLimitByPripids.json")
	@ResponseBody
	public PageResponse<QualificationLimit> selectQualificationLimitByPripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		request.setParams(queryMap);
		List<QualificationLimit> data= creditProveListService.selectQualificationLimitByPripids(request);
		return  new PageResponse<QualificationLimit>(data); 
	}
	
	/**
	 * 
	 * 描述   失信被执行人黑名单
	 * @author 赵祥江
	 * @date 2017年4月21日 上午9:21:51 
	 * @param 
	 * @return PageResponse<QualificationLimit>
	 * @throws
	 */
	@RequestMapping("/selectQualificationLimitTypePripids.json")
	@ResponseBody
	public PageResponse<QualificationLimit> selectQualificationLimitTypePripids(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=request.getParams();
		queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("pripids").toString(),","));
		request.setParams(queryMap);
		List<QualificationLimit> data= creditProveListService.selectQualificationLimitTypePripids(request);
		return  new PageResponse<QualificationLimit>(data); 
	}
	
	
	
	/**
	 * 
	 * 描述   检查是否有违法行为
	 * @author 赵祥江
	 * @date 2017年4月17日 下午5:21:45 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/checkIspunish")
	@ResponseBody
	public AjaxResult checkIspunish(String pripids,String proveStartDate,String proveEntDate,String searchType ) throws Exception{
		    try {
		    	int ispunish=0;
				Map<String,Object>	queryMap=new HashMap<String,Object>();
				queryMap.put("pripids", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(pripids,","));
				queryMap.put("proveStartDate", proveStartDate);
				queryMap.put("proveEntDate", proveEntDate);
				PageRequest request=new PageRequest ();
				request.setParams(queryMap);
				request.setLength(1);
				request.setPageNum(0);
				String[] searchTypeArr=searchType.split(",");
				for(int i=0;i<searchTypeArr.length;i++){
					if("1".equals(searchTypeArr[i])){//工商行政处罚
						List<PubOtherpunishDto> data=creditProveListService.selectMidCaseInfoByPripids(request);
						ispunish=data.size();
					}else if("2".equals(searchTypeArr[i])){//其他部门行政处罚
						List<PubOtherpunishDto> data=creditProveListService.selectPubOtherpunishByPripids(request);
						ispunish=data.size();
					}else if("3".equals(searchTypeArr[i])){//经营异常名录
						List<PubOpanoMaly> data= creditProveListService.selectOpanomalyResultMapByPripids(request);
						ispunish=data.size();
					}else if("4".equals(searchTypeArr[i])){//严重违法失信
						List<ExpSeriousCrimeList> expSeriousCrimeListList= creditProveListService.selectExpSeriousCrimeByPripids(request);
						ispunish=expSeriousCrimeListList.size();
					}else if("5".equals(searchTypeArr[i])){//任职资格限制
						List<QualificationLimit> data= creditProveListService.selectQualificationLimitByPripids(request);
						ispunish=data.size();
					}
					if(ispunish>0){
						break;
					}
				}
				
				return AjaxResult.success("查询成功", ispunish);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		return  AjaxResult.error("删除失败");
	}
	
	
	/**
	 * 
	 * 描述   进入查证比对页面
	 * @author 赵祥江
	 * @date 2017年4月20日 上午9:41:37 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/creditProveManComparePage")
	public ModelAndView creditProveManComparePage(HttpSession session,String cerNOs,String uids) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/creditprove/creditprovemancompare_edit");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
			view.addObject("deptName",sysUser.getSysDepart().getOrgName());
		}else{
			view.addObject("deptName",sysUser.getDepartMent().getDeptName());
		}
		List<CreditProveList> creditProveListDtoList=new ArrayList<CreditProveList>();
		String pripids="";
		List<CreditProveListDto> creditProveListDtoListTem= creditProveListService.selectProPidListBycertNO(com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(cerNOs,","));
		if(creditProveListDtoListTem.size()>0){
			for(CreditProveListDto creditProveListDto:creditProveListDtoListTem){
				pripids+=creditProveListDto.getPriPID()+",";
			}
		}
		
		String[] uidsArr=uids.split(",");
		for(int i=0;i<uidsArr.length;i++){
			CreditProveList creditProveList=creditProveListService.selectCreditProveListByUid(uidsArr[i]);
			if(creditProveList!=null){
				creditProveListDtoList.add(creditProveList);
			}
		}
		
		
		//要比对的企业主体身份代码 多个用逗号隔开
		view.addObject("pripids",pripids);
		view.addObject("uids",uids);
		view.addObject("cerNOs",cerNOs);
		view.addObject("sysUrl", sysUrl);
		Date nowDate=DateUtil.getSysDate();
		view.addObject("nowDate",nowDate); 
		view.addObject("nowDateStr",DateUtil.dateToString(nowDate, "yyyy-MM-dd HH:mm:ss"));
		view.addObject("creditProveListDtoList", creditProveListDtoList);
		return view;
	}
	
	
	/**
	 * 
	 * 描述   根据身份证号获取企业任职关系
	 * @author 赵祥江
	 * @date 2017年4月20日 下午5:32:14 
	 * @param 
	 * @return PageResponse<CreditProveListDto>
	 * @throws
	 */
	@RequestMapping("/selectMidInvDivTableBycerNOs.json")
	@ResponseBody
	public PageResponse<CreditProveListDto> selectMidInvDivTableBycerNOs(PageRequest request) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		queryMap.put("certNO", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("cerNO").toString(),",")); 
		List<CreditProveListDto> creditProveListDtoList=creditProveListService.selectMidInvDivTableBycerNOs(request);
		return  new PageResponse<CreditProveListDto>(creditProveListDtoList); 
	}
}