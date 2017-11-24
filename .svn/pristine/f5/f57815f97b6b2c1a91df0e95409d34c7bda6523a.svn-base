/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.login.controller.reg.client;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.InfoDataClient;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.model.MidInv;
import com.icinfo.cs.ext.model.MidLeRep;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.ext.service.IMidInvService;
import com.icinfo.cs.ext.service.IMidLeRepService;
import com.icinfo.cs.login.dto.PubEppasswordDto;
import com.icinfo.cs.login.dto.PubPhoneapplyDto;
import com.icinfo.cs.login.model.PubPhoneapply;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.login.service.IPubPhoneapplyService;
import com.icinfo.cs.system.model.SysDeliverInfo;
import com.icinfo.cs.system.service.ISysDeliverInfoService;
import com.icinfo.dataservice.CertInfo;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.tools.utils.StringUtils;
/**
 * 
 * 描述: 联络员备案
 * @author gaojinling
 * @date 2016年8月28日
 */
@Controller
@RequestMapping("/reg/client/login/phoneapply")
public class PubPhoneApplyController extends BaseController {
	//准入基本信息
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	//法定代表人信息
	@Autowired
	private IMidLeRepService  midLeRepService ;
	//出资信息
	@Autowired
	private IMidInvService  midInvService ;
	//联络员备案信息
	@Autowired
	private IPubPhoneapplyService  pubPhoneApplyService;
	//密码表（联络员信息）
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	
	//联络员确认书送达地址
	@Autowired
	private ISysDeliverInfoService deliverInfoService;
	//证件类型
	@Autowired
	private ICodeCertypeService codeCertypeService;
	
	/**
	 * 
	 * 描述: 进入联络员确认通知书填报页面
	 * @auther gaojinling
	 * @date 2016年8月28日 
	 * @param pasentKey
	 * @param entage 系统类别（1 为企业或及时  2 为农专）
	 * @param pasId 流水号 修改时（存在）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public ModelAndView list(String regNo,String entage,String pasId) throws Exception{
		ModelAndView view=new ModelAndView("reg/client/login/pubphoneapply_edit");
	    //证件类型
		List<CodeCertype> Certypes = codeCertypeService.selectAll();
	    view.addObject("Certypes", Certypes);
	    view.addObject("entage", entage);  //系统类型传过来做校验
		if(StringUtil.isNotEmpty(pasId)){ //流水号查询(流水号存在时，为修改操作，修改页面下显示该流水号下联络员申请信息)
			List<PubPhoneapply> PhoneApplylist =  pubPhoneApplyService.selectPubPhoneapplyByOne("pasid", pasId);
			if(PhoneApplylist !=null && PhoneApplylist.size()>0 ){
				PubPhoneapply phoneApply = PhoneApplylist.get(0);
				view.addObject("phoneApply", phoneApply);
			}
		}else{//流水号为空时（登录新增操作，修改填报页显示企业基本信息）
//			regNo = AESEUtil.decodeCorpid(regNo);
//			Map<String, Object> map  = new HashMap<String, Object>();
//			map.put("regNO", regNo);	
//			map.put("regState", "1");	//状态有效 
//			map.put("entTypeCatg", entage); //系统类别
//			List<MidBaseInfo> midBaseInfoList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(map);
//			 if (midBaseInfoList != null && midBaseInfoList.size() > 0) {
//				 MidBaseInfo midbaseinfo = midBaseInfoList.get(0);
//				 //合伙企业的法定代表人为空时，从执行事务合伙人取
//				 if("33,27".indexOf(midbaseinfo.getEntTypeCatg()) != -1){
//					 //合伙企业准入基本信息表的法人代表为空时，先从YC_MID_LEGAL_REP表取法人信息，再从准入投资人表YC_MID_ENT_INVESTOR里取，先取ENT_INV_LEG_REP，如果为空，则取Inv
//				     List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midbaseinfo.getPriPID());
//				     List<MidInv> invList = midInvService.selectInvListByPriPID(midbaseinfo.getPriPID());
//				     String lerep = "";
//				     if(leRepList != null && leRepList.size() >0 && leRepList.get(0)!= null && StringUtils.isNotEmpty(leRepList.get(0).getName())){
//				    	 lerep = leRepList.get(0).getName();
//				     }else{
//				    	if(invList != null && invList.size() >0 && invList.get(0)!= null )
//				    	lerep = invList.get(0).getInv();
//				     }
//					 if(StringUtils.isNotEmpty(lerep)){
//				    	 midbaseinfo.setLeRep(lerep);
//				     }
//				 }
//				 view.addObject("midbaseinfo",midbaseinfo);
//			 }
		} 
		return view;
	}
	
	/**
	 * 
	 * 描述: 联络员确认书修改或保存
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param PhoneApply
	 * @param checkcode
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody 
	public AjaxResult savePhoneApply(@Valid PubPhoneapply phoneApply , String checkcode )throws Exception{
//		//验证码校验
//		if(checkcode == null || checkcode != "" ){
//			return AjaxResult.error("1", "请输入正确的验证码");
//		}
		String pasID;
        if(phoneApply != null ){
        	if(StringUtils.isNotEmpty(phoneApply.getPasid())){
        		phoneApply.setCreatetime(new Date());
        		if(pubPhoneApplyService.update(phoneApply)>0){
        			pasID = phoneApply.getPasid();
        			return AjaxResult.success("0", pasID); //将生成的流水号带回页面做打印查询使用 更新成功
        		}else{
        			return AjaxResult.error("更新失败"); //将生成的流水号带回页面做打印查询使用
        		}
        	}else{
        		pasID = StringUtil.getSeqNumber(); //流水号  
        		phoneApply.setCreatetime(new Date());//时间戳
        		phoneApply.setPasstatus("02");;//申请状态        		
        		phoneApply.setPasid(pasID);//流水号   
            	if(pubPhoneApplyService.savePubPhoneapply(phoneApply)>0){
            		return AjaxResult.success("2", pasID); //将生成的流水号带回页面做打印查询使用
            	}else{
            		return AjaxResult.error("保存失败");  
            	}	
        	}
        	
        }
        return AjaxResult.error("保存失败"); 
	}
	
	/**
	 * 
	 * 描述: 预览页面
	 * @auther gaojinling
	 * @date 2016年8月31日 
	 * @param pasID
	 * @param entCatg
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public ModelAndView printPhoneView(String pasID) throws Exception{
		ModelAndView view=new ModelAndView("reg/client/login/pubphoneapply_view");
	    //证件类型
		List<CodeCertype> Certypes = codeCertypeService.selectAll();
	    view.addObject("Certypes", Certypes);
		if(StringUtil.isNotEmpty(pasID)){ //流水号查询(流水号存在时，为修改操作，修改页面下显示该流水号下联络员申请信息)
			List<PubPhoneapply> PhoneApplylist =  pubPhoneApplyService.selectPubPhoneapplyByOne("pasid", pasID);
			if(PhoneApplylist !=null && PhoneApplylist.size()>0 ){
				PubPhoneapply pubPhoneApply = PhoneApplylist.get(0);
				view.addObject("pubPhoneApply",pubPhoneApply);
			}
		}		
        return view;
	}	
	
	/**
	 * 
	 * 描述: 联络员确认书打印
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param pasID流水号
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/print",method=RequestMethod.GET)
	public ModelAndView printPhoneApply(String pasID) throws Exception{
		ModelAndView view=new ModelAndView("reg/client/login/pubphoneapply_print");
	    //证件类型
		List<CodeCertype> Certypes = codeCertypeService.selectAll();
	    view.addObject("Certypes", Certypes);
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("PasID", pasID); 
		//流水号查询确认书
		List<PubPhoneapplyDto> PhoneApplyPrint = pubPhoneApplyService.selectPhoneApplyPrint(map);
		String entTypeCatg = "" ;
		/* 备案表送达地址匹配原则：
    	 * 省局、市局企业备案表送达地址只匹配登记机关，
    	 * 分局企业备案表送达地址优先有设立接收的管辖单位地址，
    	 * 若无对设立的管辖单位，则匹配登记机关地址。   delicode 8位(即管辖单位为空)
    	 * 丽水市市场监督管理开发分局33250103属于市局,checkRegOrg为332500，checkJur为33250103单独处理*/
		if(PhoneApplyPrint != null && PhoneApplyPrint.size() >0){
		   String checkDep = PhoneApplyPrint.get(0).getCheckDep();
		   String checkJur = PhoneApplyPrint.get(0).getLocalAdm();
		   String checkOrg = PhoneApplyPrint.get(0).getRegOrg();
		   List<SysDeliverInfo> deliverList = null;
		   
		   //由主体代码获取主体大类
		   String pripid = PhoneApplyPrint.get(0).getPripid();
		   entTypeCatg = midBaseInfoService.selectByPripid(pripid).getEntTypeCatg();
		   //如果是农专  16  17 
		   if(Integer.parseInt(entTypeCatg) >= 16 && Integer.parseInt(entTypeCatg) <= 17){
			   map.put("deliType", "3");//类型1内资2外资3农专
		   }else{  //如果是企业
			   map.put("deliType", (Integer.parseInt(entTypeCatg)  >= 21 && Integer.parseInt(entTypeCatg) <= 28) ? "2" : "1");//类型1内资2外资
		   }
		   map.put("deliIsValid", "1");//有效
       	if(checkDep == null||"".equals(checkDep)){
       		checkDep = checkOrg;
       	}
   		if(checkDep.substring(4, 6).equals("00")){
       		map.put("deliCode", checkDep + "00");//省局、市局企业
       		//查询备案申请送达地址
           	 deliverList = deliverInfoService.selectDeliverInfoList(map);
           	// 33250103 情况单独处理
       		if( ! StringUtils.isBlank(checkJur) && checkJur.equals("33250103")){  
       			map.put("deliCode",checkJur);
       			//查询备案申请送达地址
               	deliverList = deliverInfoService.selectDeliverInfoList(map);
       			}       		
       	}else{ 
       		map.put("deliCode", checkJur);//分局企业按管辖单位查询
      	 //查询备案申请送达地址
           	deliverList = deliverInfoService.selectDeliverInfoList(map);
         //管辖单位为空 或无对应的管辖单位，则匹配相应的登记机关地址
           	if(deliverList.isEmpty() || StringUtils.isBlank(checkJur)){ 
           		map.put("deliCode", checkDep + "00");
               	deliverList = deliverInfoService.selectDeliverInfoList(map);
           	}
       	}
		view.addObject("deliverList",deliverList);
		}
		view.addObject("PhoneApplyPrint",PhoneApplyPrint);
		view.addObject("entTypeCatg", entTypeCatg);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 确认书送达地址列表
	 * @auther gaojinling
	 * @date 2016年8月29日 
	 * @param pasID流水号
	 * @param entCatg 企业大类
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/diliverinfo",method=RequestMethod.GET)
	public ModelAndView selectDeliverList() throws Exception{
	  ModelAndView view = new ModelAndView("reg/client/login/sysdiliver_list");
	  Map<String, Object>  map = new HashMap<String, Object>();
	  map.put("deliIsValid", "1");//有效
	  List<SysDeliverInfo > deliverList = deliverInfoService.selectDeliverInfoList(map);
      view.addObject("deliverList", deliverList);
	  return view;	
	}
	
	 /**
	  * 
	  * 描述:联络员备案查询与认领（登录页）
	  * @auther gaojinling
	  * @date 2016年8月30日 
	  * @param pasentkey 统一代码活注册号 
	  * @param encatge 系统类别（1 为企业或及时  2 为农专 3个体户 ）
	  * @return
	  * @throws Exception
	  */
	 @RequestMapping(value = "/checkPhoneApply", method = RequestMethod.GET) 
	 @ResponseBody
	 public AjaxResult checkPhoneApply(String pasentkey,String encatge) throws Exception {
		String regNo = null;
		String unicode =  null;
		List<MidBaseInfoDto> appBasicInfoList = null;
		//证书
//		InfoDataClient infoDataClient = new InfoDataClient();
		
		Map<String, Object> qryObjMap = new HashMap<String, Object>();
		qryObjMap.put("regNO", pasentkey);
		qryObjMap.put("entTypeCatg", encatge);
		// 1、判断用户范围，根据传来的pasentkey(是否在准入系统)
		try {
			appBasicInfoList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryObjMap);
			// a.判断是否存在数据
			if (appBasicInfoList.isEmpty()) {
				return AjaxResult.error("0","用户不在本系统范围内，请确认输入信息是否正确");
			}
//				priId = appBasicInfoList.get(0).getPriPID();
			regNo = appBasicInfoList.get(0).getRegNO();
			unicode = appBasicInfoList.get(0).getUniCode();
			// b.判断企业是否被吊销
			if ("D".equals(appBasicInfoList.get(0).getRegState())) {
				return AjaxResult.error("用户已被吊销，请确认输入信息是否正确");
			}
			//c.如果企业有统一社会信用代码必须以统一社会信用代码的方式登录；如果企业没有统一社会信用代码允许以注册号登录。
			if (StringUtil.isNotBlank(unicode) && !unicode.equals(pasentkey)) {
				return AjaxResult.error("有统一社会信用代码必须输入统一社会信用代码备案！");
			}
		
		   Map<String, Object> qryStrMap = new HashMap<String, Object>();
		   qryStrMap.put("pasentkey", pasentkey);
		   qryStrMap.put("regNo", regNo); //注册号 
	     // 2、判断是否认领证书及是否有确认联络员
//	   	 List<CertInfo> certificateList = infoDataClient.getCertInfoByRegNo(regNo); //查询证书
//	   	 List<PubEppassword> Eppasswordlist = pubEppasswordService.selectPubEppasswordList(qryStrMap); //查询联络员
	   	 //3、到此处  校验通过   加密输入的pasEntKey ,回显给页面
//	   	 pasentkey = AESEUtil.encodeCorpid(pasentkey);
		 MidBaseInfo midbaseinfo = appBasicInfoList.get(0);
		 //合伙企业的法定代表人为空时，从执行事务合伙人取
		 if("33,27".indexOf(midbaseinfo.getEntTypeCatg()) != -1){
			 //合伙企业准入基本信息表的法人代表为空时，先从YC_MID_LEGAL_REP表取法人信息，再从准入投资人表YC_MID_ENT_INVESTOR里取，先取ENT_INV_LEG_REP，如果为空，则取Inv
		     List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midbaseinfo.getPriPID());
		     List<MidInv> invList = midInvService.selectInvListByPriPID(midbaseinfo.getPriPID());
		     String lerep = "";
		     if(leRepList != null && leRepList.size() >0 && leRepList.get(0)!= null && StringUtils.isNotEmpty(leRepList.get(0).getName())){
		    	 lerep = leRepList.get(0).getName();
		     }else{
		    	if(invList != null && invList.size() >0 && invList.get(0)!= null )
		    	lerep = invList.get(0).getInv();
		     }
			 if(StringUtils.isNotEmpty(lerep)){
		    	 midbaseinfo.setLeRep(lerep);
		     }
		 }
	   	 return AjaxResult.success("1",midbaseinfo); //已认领证书及确认过联络员
//	     if (!certificateList.isEmpty()) {
//	    	 if (!Eppasswordlist.isEmpty()) {
//		  			return AjaxResult.success("1",pasentkey); //已认领证书及确认过联络员
//		  	 }else{
//		  			return AjaxResult.success("2",pasentkey); //已认领证书未认领联络员
//		  	 }	  	 
//	     } else {
//	    	 if (!Eppasswordlist.isEmpty()) {
//		  			return AjaxResult.success("3",pasentkey); //未认领证书及确认过联络员
//		  	 }else{
//		  			return AjaxResult.success("4",pasentkey); //未认领证书未认领联络员
//		  	 }
//	     }
		} catch (Exception ex) {
			return AjaxResult.error("系统错误，请联系管理员！");
		}
	}	
	 
	/* ------------------------------------------------------- 公示端  --------------------------------------------------------- */ 

	 /**
	  * 
	  * 描述: 进入联络员备案页面（公示端）
	  * @auther gaojinling
	  * @date 2016年12月10日 
	  * @param regNo
	  * @param entage  0  新增（注册）  1  修改（变更）
	  * @param pasId
	  * @return
	  * @throws Exception
	  */
		@RequestMapping("/publist")
		public ModelAndView publist(String entage) throws Exception{
			ModelAndView view ;
//		    view.addObject("entage", entage);  //系统类型传过来做校验
			if(entage.equals("1")){ //变更
				view = new ModelAndView("/pub/infobulletin/modify");
			}else{  //注册
				view = new ModelAndView("/pub/infobulletin/register");
			}
		    //证件类型
			List<CodeCertype> Certypes = codeCertypeService.selectAll();
		    view.addObject("Certypes", Certypes);
			return view;
		}
		
		

		/**
		  * 
		  * 描述:联络员备案查询与认领（公示端）
		  * @auther gaojinling
		  * @date 2016年8月30日 
		  * @param pasentkey 统一代码活注册号 
		  * @param encatge 操作类型（1变更 0 注册）
		  * @return
		  * @throws Exception
		  */
		 @RequestMapping(value = "/pubCheckPhoneApply", method = RequestMethod.GET) 
		 @ResponseBody
		 public AjaxResult pubCheckPhoneApply(String pasentkey,String encatge) throws Exception {
			String regNo = null;
			String unicode =  null;
			String pripid = null;
			List<MidBaseInfoDto> appBasicInfoList = null;
			//证书
			InfoDataClient infoDataClient = new InfoDataClient();
			Map<String, Object> qryObjMap = new HashMap<String, Object>();
			qryObjMap.put("regNO", pasentkey);
//			qryObjMap.put("entTypeCatg", encatge);
			qryObjMap.put("regState", 1);  //状态有效（直接去除掉不合法的状态   保留登记状态 为 'K', 'B', 'A', 'DA' 的企业）
			// 1、判断用户范围，根据传来的pasentkey(是否在准入系统)
			try {
				appBasicInfoList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryObjMap);
				// a.判断是否存在数据

				if (appBasicInfoList.isEmpty()) {
					return AjaxResult.error("用户不在本系统范围内，请确认输入信息是否正确。");
				}
				regNo = appBasicInfoList.get(0).getRegNO();
				unicode = appBasicInfoList.get(0).getUniCode();
				pripid = appBasicInfoList.get(0).getPriPID();
				String entTypeCatg = appBasicInfoList.get(0).getEntTypeCatg();
				//b.如果企业有统一社会信用代码必须以统一社会信用代码的方式备案；如果企业没有统一社会信用代码允许以注册号备案。
				if (StringUtil.isNotBlank(unicode) && !unicode.equals(pasentkey)) {
					return AjaxResult.error("有统一社会信用代码必须输入统一社会信用代码备案！");
				}
				
				//c.非个体户判断新成立企业
				if(!entTypeCatg.equals(Constants.entTypeCatgPB)) {
					//成立日期为2016年1月1日及以后的用户必须用数字证书登录
					Date endDate = DateUtil.stringToDate( "2016-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"); 
		        	if(appBasicInfoList.get(0).getEstDate() != null && appBasicInfoList.get(0).getEstDate().after(endDate)){
		  	            return AjaxResult.error("你企业（农专社）应使用数字证书登录后直接在线填报企业联络员信息。");
		        	}
				}
			
			   Map<String, Object> qryStrMap = new HashMap<String, Object>();
			   qryStrMap.put("pasentkey", pasentkey);
			   qryStrMap.put("regNo", regNo); //注册号 
			   // 2、判断是否认领证书及是否有确认联络员
			   List<CertInfo> certificateList = infoDataClient.getCertInfoByCorpid(pripid); //查询证书(根据内部序号)
			   List<PubEppasswordDto> Eppasswordlist = pubEppasswordService.selectPubEppasswordList(qryStrMap); //查询联络员
			   //3、到此处  校验通过  先处理证件号码数据
//			   pasentkey = AESEUtil.encodeCorpid(pasentkey);
			   MidBaseInfoDto midbaseinfo = appBasicInfoList.get(0);
			   List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midbaseinfo.getPriPID());
		   	   //从法定代表人表取证照号码（）
			   if(leRepList != null && leRepList.size()>0 && StringUtils.isNotEmpty(leRepList.get(0).getCerNO())){
			    	 midbaseinfo.setCerNO(leRepList.get(0).getCerNO());
			   }
			   String cerNO = midbaseinfo.getCerNO();
			   String encerNO = "";
			   if(StringUtils.isBlank(cerNO) && "33,27".indexOf(midbaseinfo.getEntTypeCatg()) == -1){//不为合伙企业
	  	            return AjaxResult.error("证件号码异常，请联系工商部门处理！");
			   }
			   if(StringUtils.isNotBlank(cerNO) && cerNO.length() >= 4){ //证件号码不为空时处理
			    	 encerNO = cerNO.substring(0,4) + "*****";//证件号码处理
			    	 midbaseinfo.setEncerNO(encerNO); 
			   }
				//合伙企业的法定代表人为空时，从执行事务合伙人取（处理合伙企业法人取值）
			 if("33,27".indexOf(midbaseinfo.getEntTypeCatg()) != -1 && StringUtils.isBlank(midbaseinfo.getLeRep())){
				 //合伙企业准入基本信息表的法人代表为空时，先从YC_MID_LEGAL_REP表取法人信息，再从准入投资人表YC_MID_ENT_INVESTOR里取，先取ENT_INV_LEG_REP，如果为空，则取Inv
				 List<MidInv> invList = midInvService.selectInvListByPriPID(midbaseinfo.getPriPID());
			     String lerep = "";
			     if(leRepList != null && leRepList.size() >0 && leRepList.get(0)!= null && StringUtils.isNotEmpty(leRepList.get(0).getName())){
			    	 lerep = leRepList.get(0).getName();
			     }else{
			    	if(invList != null && invList.size() >0 && invList.get(0)!= null )
			    	lerep = invList.get(0).getInv();
			     }
				 if(StringUtils.isNotEmpty(lerep)){
			    	 midbaseinfo.setLeRep(lerep);
			     }
			 }	 
		   	 
			 if(encatge.equals("0")){  //注册
				 /*
				  * 注册
				  * 个体户（证书不校验）
				  * 1）未注册过联络员信息的个体户，允许继续注册信息在线填写与提交
                  * 2）pb1 已注册过联络员的个体户，则提示如下：你个体工商户已注册过企业联络员信息，无需再注册！
                  * 企业农专
                  * 3）ent1 锁定为证书方式申报的企业、农专社（即有证书企业、农专社），弹出提示如下： 你企业（农专社）应使用数字证书（电子营业执照）登录后直接在线填报企业联络员信息。
                  * 4）无证书企业、农专社，允许注册！。
				  */
				 //个体户
				 if(Constants.entTypeCatgPB.equals(midbaseinfo.getEntTypeCatg())){ 
				  	if(!Eppasswordlist.isEmpty()){
						 return AjaxResult.error("pb1","你个体工商户已注册过企业联络员信息，无需再注册！");
				  	}else{
						 return AjaxResult.success("0",midbaseinfo); //未注册过 允许注册
				  	}
					 
				 }
				 //企业、农专
				 if (!certificateList.isEmpty()) { //已认领证书
		  	            return AjaxResult.error("ent1", "你企业（农专社）应使用数字证书登录后直接在线填报企业联络员信息。");
			     } else {
				  		return AjaxResult.success("0",midbaseinfo); //未认领证书   注册，回显核准信息
			     }
			 }else{  //变更
				 /*
				  * 个体户
				  * 1）pb2 未注册过联络员信息的个体户 提示：（你个体工商户未注册过企业联络员信息，请先完成企业联络员注册。）
				  * 2）已注册过联络员信息的个体户允许继续变更信息填写。
				  * 企业农专
				  * 3）ent3 锁定为证书方式申报的企业、农专社（即有证书、无证书且未确认过联络员的企业、农专社）
				  * 弹出提示如下： 你企业（农专社）应使用数字证书（电子营业执照）登录后直接在线变更企业联络员信息。
				  * 4）无证书且已确认过联络员的企业、农专社允许继续变更
				  * 
				  */
			     if(Constants.entTypeCatgPB.equals(midbaseinfo.getEntTypeCatg())){//个体户变更
					 if(Eppasswordlist == null || Eppasswordlist.size()==0 ){//未办理过联络员
					   	 return AjaxResult.error("pb2","你个体工商户未注册过企业联络员信息，请先完成企业联络员注册。"); 
					 }
					 PubEppasswordDto pubEppasswordDto = Eppasswordlist.get(0);
					 pubEppasswordDto.setEncerNO(encerNO);  //加密证件号码
					 pubEppasswordDto = pubEppasswordService.handPubEppasswordDto(pubEppasswordDto, midbaseinfo);
				   	return AjaxResult.success("2",pubEppasswordDto);  //变更，回显已有的联络员信息
			     }
				 if (!certificateList.isEmpty() || Eppasswordlist.isEmpty()) {//即有证书、无证书且未确认过联络员的企业、农专社
			  		    return AjaxResult.error("ent3"," 你企业（农专社）应使用数字证书登录后直接在线变更企业联络员信息。");  
		        }else {
		    		 PubEppasswordDto pubEppasswordDto = Eppasswordlist.get(0);
					 pubEppasswordDto.setEncerNO(encerNO);  //加密证件号码
					 pubEppasswordDto = pubEppasswordService.handPubEppasswordDto(pubEppasswordDto, midbaseinfo);
			  		return AjaxResult.success("1",pubEppasswordDto); 
			    }
			 }
			} catch (Exception ex) {
				return AjaxResult.error("系统错误，请联系管理员！");
			}
		}
		 
		
			
			/**
			 * 
			 * 描述: 联络员确认书保存
			 * @auther gaojinling
			 * @date 2016年8月29日 
			 * @param PhoneApply
			 * @param checkcode
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value = "/pubsave", method = RequestMethod.POST)
			@ResponseBody 
			public AjaxResult pubsavePhoneApply(@Valid PubPhoneapply phoneApply )throws Exception{
//				//验证码校验
//				if(checkcode == null || checkcode != "" ){
//					return AjaxResult.error("1", "请输入正确的验证码");
//				}
				String pasID;
		        if(phoneApply != null ){
	        		pasID = StringUtil.getSeqNumber(); //流水号  
	        		phoneApply.setCreatetime(new Date());//时间戳
	        		phoneApply.setPasstatus("02");//申请状态        		
	        		phoneApply.setPasid(pasID);//流水号
	        		//处理外国法定代表人数据，保存入库
	        		phoneApply.setLerep(StringUtil.doHtm(phoneApply.getLerep()));
	        		int count = pubPhoneApplyService.savePubPhoneapply(phoneApply);
	        		boolean acceptFlag = true;
		        	if(phoneApply.getEnttype().equals("9500")){ //确认为个体户,直接同时做接收操作
		    		    acceptFlag = pubPhoneApplyService.acceptPubPhoneApply(pasID,null);
		        	}
		        	if(count>0 && acceptFlag){
	            		return AjaxResult.success("2", pasID); //将生成的流水号带回页面做打印查询使用
		        	}else{
		                return AjaxResult.error("保存失败");  
		        	}	
		        }
		        return AjaxResult.error("保存失败"); 
			}
			
			
			
			/**
			 * 
			 * 描述: 预览页面
			 * @auther gaojinling
			 * @date 2016年8月31日 
			 * @param pasID
			 * @param entCatg
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value="/pubview",method=RequestMethod.GET)
			public ModelAndView pubPrintPhoneView(String pasID) throws Exception{
				ModelAndView view=new ModelAndView("/pub/infobulletin/registerview");
			    //证件类型
				List<CodeCertype> Certypes = codeCertypeService.selectAll();
			    view.addObject("Certypes", Certypes);
				if(StringUtil.isNotEmpty(pasID)){ //流水号查询(流水号存在时，为修改操作，修改页面下显示该流水号下联络员申请信息)
					List<PubPhoneapply> PhoneApplylist =  pubPhoneApplyService.selectPubPhoneapplyByOne("pasid", pasID);
					if(PhoneApplylist !=null && PhoneApplylist.size()>0 ){
						PubPhoneapply pubPhoneApply = PhoneApplylist.get(0);
						
						String encerNO = pubPhoneApply.getCerNO();
						 if(StringUtils.isEmpty(encerNO) || encerNO.length()< 4){  
					     }else{
					    	 encerNO = encerNO.substring(0,4) + "*****";//证件号码处理
					    	 pubPhoneApply.setCerNO(encerNO);
					     }
//						 String enlerep = pubPhoneApply.getLerep();
//						 if(enlerep.length()>2){ //处理法定代表人
//							 enlerep = enlerep.substring(0,1)+"*"+enlerep.substring(2,enlerep.length());
//						 }else{
//							 enlerep = enlerep.substring(0,1)+"*";
//						 }
//						 pubPhoneApply.setLerep(enlerep);
						view.addObject("pubPhoneApply",pubPhoneApply);
					}
				}		
		        return view;
			}
			
			
			/**
			 * 
			 * 描述: 联络员确认书打印
			 * @auther gaojinling
			 * @date 2016年8月29日 
			 * @param pasID流水号
			 * @return
			 * @throws Exception
			 */
			@RequestMapping(value="/pubprint",method=RequestMethod.GET)
			public ModelAndView pubprintPhoneApply(String pasID) throws Exception{
				ModelAndView view=new ModelAndView("reg/client/login/pubphoneapply_print");
			    //证件类型
				List<CodeCertype> Certypes = codeCertypeService.selectAll();
			    view.addObject("Certypes", Certypes);
				Map<String, Object>  map = new HashMap<String, Object>();
				map.put("PasID", pasID); 
				//流水号查询确认书
				List<PubPhoneapplyDto> PhoneApplyPrint = pubPhoneApplyService.selectPhoneApplyPrint(map);
				String entTypeCatg = "" ;
				/* 备案表送达地址匹配原则：
		    	 * 省局、市局企业备案表送达地址只匹配登记机关，
		    	 * 分局企业备案表送达地址优先有设立接收的管辖单位地址，
		    	 * 若无对设立的管辖单位，则匹配登记机关地址。   delicode 8位(即管辖单位为空)
		    	 * 丽水市市场监督管理开发分局33250103属于市局,checkRegOrg为332500，checkJur为33250103单独处理*/
				if(PhoneApplyPrint != null && PhoneApplyPrint.size() >0){
				   String checkDep = PhoneApplyPrint.get(0).getCheckDep();
				   String checkJur = PhoneApplyPrint.get(0).getLocalAdm();
				   String checkOrg = PhoneApplyPrint.get(0).getRegOrg();
				   List<SysDeliverInfo> deliverList = null;
				   
				   //由主体代码获取主体大类
				   String pripid = PhoneApplyPrint.get(0).getPripid();
				   entTypeCatg = midBaseInfoService.selectByPripid(pripid).getEntTypeCatg();
				   //如果是农专  16  17 
				   if(Integer.parseInt(entTypeCatg) >= 16 && Integer.parseInt(entTypeCatg) <= 17){
					   map.put("deliType", "3");//类型1内资2外资3农专
				   }else{  //如果是企业
					   map.put("deliType", (Integer.parseInt(entTypeCatg)  >= 21 && Integer.parseInt(entTypeCatg) <= 28) ? "2" : "1");//类型1内资2外资
				   }
				   map.put("deliIsValid", "1");//有效
		       	if(checkDep == null||"".equals(checkDep)){
		       		checkDep = checkOrg;
		       	}
		   		if(checkDep.substring(4, 6).equals("00")){
		       		map.put("deliCode", checkDep + "00");//省局、市局企业
		       		//查询备案申请送达地址
		           	 deliverList = deliverInfoService.selectDeliverInfoList(map);
		           	// 33250103 情况单独处理
		       		if( ! StringUtils.isBlank(checkJur) && checkJur.equals("33250103")){  
		       			map.put("deliCode",checkJur);
		       			//查询备案申请送达地址
		               	deliverList = deliverInfoService.selectDeliverInfoList(map);
		       			}       		
		       	}else{ 
		       		map.put("deliCode", checkJur);//分局企业按管辖单位查询
		      	 //查询备案申请送达地址
		           	deliverList = deliverInfoService.selectDeliverInfoList(map);
		         //管辖单位为空 或无对应的管辖单位，则匹配相应的登记机关地址
		           	if(deliverList.isEmpty() || StringUtils.isBlank(checkJur)){ 
		           		map.put("deliCode", checkDep + "00");
		               	deliverList = deliverInfoService.selectDeliverInfoList(map);
		           	}
		       	}
				view.addObject("deliverList",deliverList);
				}
				view.addObject("PhoneApplyPrint",PhoneApplyPrint);
				view.addObject("entTypeCatg", entTypeCatg);
				return view;
			}
			
	/* ------------------------------------------------------- 公示端 备案校验版本2 --------------------------------------------------------- */ 
		
			/**
			  * 
			  * 描述:联络员备案查询与认领（公示端版本2）
			  * @auther gaojinling
			  * @date 2016年8月30日 
			  * @param pasentkey 统一代码活注册号 
			  * @param encatge 操作类型（1变更 0 注册）
			  * @return
			  * @throws Exception
			  */
			 @RequestMapping(value = "/pubsCheckPhoneApply", method = RequestMethod.GET) 
			 @ResponseBody
			 public AjaxResult pubsCheckPhoneApply(String pasentkey,String encatge) throws Exception {
				String regNo = null;
				String unicode =  null;
				String pripid = null;
				List<MidBaseInfoDto> appBasicInfoList = null;
				//证书
				InfoDataClient infoDataClient = new InfoDataClient();
				Map<String, Object> qryObjMap = new HashMap<String, Object>();
				qryObjMap.put("regNO", pasentkey);
//				qryObjMap.put("entTypeCatg", encatge);
				qryObjMap.put("regState", 1);  //状态有效（直接去除掉不合法的状态   保留登记状态 为 'K', 'B', 'A', 'DA' 的企业）
				// 1、判断用户范围，根据传来的pasentkey(是否在准入系统)
				try {
					appBasicInfoList = midBaseInfoService.selectMidBaseinfoByRegNoAndName(qryObjMap);
					// a.判断是否存在数据

					if (appBasicInfoList.isEmpty()) {
						return AjaxResult.error("用户不在本系统范围内，请确认输入信息是否正确。");
					}
					regNo = appBasicInfoList.get(0).getRegNO();
					unicode = appBasicInfoList.get(0).getUniCode();
					pripid = appBasicInfoList.get(0).getPriPID();
					String entTypeCatg = appBasicInfoList.get(0).getEntTypeCatg();
					String regorg = appBasicInfoList.get(0).getRegOrg();
					//b.如果企业有统一社会信用代码必须以统一社会信用代码的方式备案；如果企业没有统一社会信用代码允许以注册号备案。
					if (StringUtil.isNotBlank(unicode) && !unicode.equals(pasentkey)) {
						return AjaxResult.error("有统一社会信用代码必须输入统一社会信用代码备案！");
					}
					
					if(StringUtil.isNotBlank(entTypeCatg) && "23".equals(entTypeCatg)){//外资常驻代表机构不属于本系统备案范围内
						return AjaxResult.error("外资常驻代表机构不属于本系统备案范围内！");
					}
					
					//c.非个体户且不为宁波判断新成立企业
					if(!entTypeCatg.equals(Constants.entTypeCatgPB) && !(StringUtils.isNotBlank(regorg) && regorg.substring(0,4).equals("3302"))) {
						//成立日期为2016年1月1日及以后的用户必须用数字证书登录
						Date endDate = DateUtil.stringToDate( "2016-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"); 
			        	if(appBasicInfoList.get(0).getEstDate() != null && appBasicInfoList.get(0).getEstDate().after(endDate)){
			  	            return AjaxResult.error("你企业（农专社）应使用数字证书登录后直接在线填报企业联络员信息。");
			        	}
					}
				
				   Map<String, Object> qryStrMap = new HashMap<String, Object>();
				   qryStrMap.put("pasentkey", pasentkey);
				   qryStrMap.put("regNo", regNo); //注册号 
				   // 2、判断是否认领证书及是否有确认联络员
				   List<CertInfo> certificateList = infoDataClient.getCertInfoByCorpid(pripid); //查询证书(根据内部序号)
				   List<PubEppasswordDto> Eppasswordlist = pubEppasswordService.selectPubEppasswordList(qryStrMap); //查询联络员
				   //3、到此处  校验通过  先处理证件号码数据
//				   pasentkey = AESEUtil.encodeCorpid(pasentkey);
				   MidBaseInfoDto midbaseinfo = appBasicInfoList.get(0);
				   List<MidLeRep> leRepList = midLeRepService.selectMidLeRepListByPriPID("priPID", midbaseinfo.getPriPID());
			   	   //从法定代表人表取证照号码（）
				   if(StringUtil.isBlank(midbaseinfo.getCerNO())&&leRepList != null && leRepList.size()>0 && StringUtils.isNotEmpty(leRepList.get(0).getCerNO())){
				    	 midbaseinfo.setCerNO(leRepList.get(0).getCerNO());
				   }
				   String cerNO = midbaseinfo.getCerNO();
				   String encerNO = "";
				   if(StringUtils.isBlank(cerNO) && "33,27".indexOf(midbaseinfo.getEntTypeCatg()) == -1){//不为合伙企业
		  	            return AjaxResult.error("证件号码异常，请联系工商部门处理！");
				   }
				   if(StringUtils.isNotBlank(cerNO) && cerNO.length() >= 4){ //证件号码不为空时处理
				    	 encerNO = cerNO.substring(0,4) + "*****";//证件号码处理
				    	 midbaseinfo.setEncerNO(encerNO); 
				   }
					//普通企业核准表法人为空时候，从法人表取值  
				    //合伙企业的法定代表人，取值执行事务合伙人（处理合伙企业法人取值）
				   String lerep = midbaseinfo.getLeRep();
				   if(StringUtil.isBlank(lerep) && leRepList != null && leRepList.size() >0 && leRepList.get(0)!= null && StringUtils.isNotEmpty(leRepList.get(0).getName())){
			    	 lerep = leRepList.get(0).getName();
			     }
				 if("33,27".indexOf(midbaseinfo.getEntTypeCatg()) != -1 ){
					 //合伙企业准入基本信息表的法人代表为空时，先从YC_MID_LEGAL_REP表取法人信息，再从准入投资人表YC_MID_ENT_INVESTOR里取，先取ENT_INV_LEG_REP，如果为空，则取Inv
					 List<MidInv> invList = midInvService.selectInvListByPriPID(midbaseinfo.getPriPID());
				    if(invList != null && invList.size() >0 && invList.get(0)!= null ){
				    	lerep = invList.get(0).getInv();
				     }
				 }
				 if(StringUtils.isNotEmpty(lerep)){
			    	 midbaseinfo.setLeRep(lerep);
			     }			   	 
				 if(encatge.equals("0")){  //注册
					 /*
					  * 注册
					  * 个体户（证书不校验）
					  * 1）未注册过联络员信息的个体户，允许继续注册信息在线填写与提交
                      * 2）pb1(关闭) 已注册过联络员的个体户，则提示如下：你个体工商户已注册过企业联络员信息，无需再注册！
                      * 企业农专
                      * 3）ent1（登录） 锁定为证书方式申报的企业、农专社（即有证书、无证书且未确认过联络员的企业、农专社），弹出提示如下： 你企业（农专社）应使用数字证书（电子营业执照）登录后直接在线填报企业联络员信息。
                      * 4）ent2（关闭） 无证书且已确认过联络员的企业、农专社，弹出提示如下：你企业（农专社）已确认过企业联络员信息，无需再注册！。
					  */
					 //个体户
					 if(Constants.entTypeCatgPB.equals(midbaseinfo.getEntTypeCatg())){ //个体户
					  	if(!Eppasswordlist.isEmpty()){
							 return AjaxResult.error("pb1","你个体工商户已注册过企业联络员信息，无需再注册！");
					  	}else{
							 return AjaxResult.success("0",midbaseinfo); //未注册过 允许注册
					  	}
						 
					 }
					 //宁波（地区特殊处理）
					 if(StringUtils.isNotBlank(midbaseinfo.getRegOrg()) && midbaseinfo.getRegOrg().substring(0,4).equals("3302")){ //登记机关前四位为3302
						  	if(!Eppasswordlist.isEmpty()){
								 return AjaxResult.error("ent2","你企业（农专社）已确认过企业联络员信息，无需再注册！");
						  	}else{
								 return AjaxResult.success("0",midbaseinfo); //未注册过 允许注册
						  	}
							 
				     }
					 //企业农专
					 if (!certificateList.isEmpty() || Eppasswordlist.isEmpty()) { //已认领证书或者未确认过联络员
			  	            return AjaxResult.error("ent1", "你企业（农专社）应使用数字证书登录后直接在线填报企业联络员信息。");
				     }else{
							 return AjaxResult.error("ent2","你企业（农专社）已确认过企业联络员信息，无需再注册！"); //无证书且确认过联络员
				     }
				 }else{  //变更
					 /*
					  * 个体户
					  * 1）pb2(关闭) 未注册过联络员信息的个体户 提示：（你个体工商户未注册过企业联络员信息，请先完成企业联络员注册。）
					  * 2）已注册过联络员信息的个体户允许继续变更信息填写。
					  * 企业农专
					  * 3）ent3 （登录）锁定为证书方式申报的企业、农专社（即有证书、无证书且未确认过联络员的企业、农专社）
					  * 弹出提示如下： 你企业（农专社）应使用数字证书（电子营业执照）登录后直接在线变更企业联络员信息。
					  * 4）无证书且已确认过联络员的企业、农专社允许继续变更
					  * 
					  */
				     if(Constants.entTypeCatgPB.equals(midbaseinfo.getEntTypeCatg())){//个体户变更
						 if(Eppasswordlist == null || Eppasswordlist.size()==0 ){//未办理过联络员
						   	 return AjaxResult.error("pb2","你个体工商户未注册过企业联络员信息，请先完成企业联络员注册。"); 
						 }
						 PubEppasswordDto pubEppasswordDto = Eppasswordlist.get(0);
						 pubEppasswordDto.setEncerNO(encerNO);  //加密证件号码
						 pubEppasswordDto.setEntTypeCatg(midbaseinfo.getEntTypeCatg());
						 pubEppasswordDto = pubEppasswordService.handPubEppasswordDto(pubEppasswordDto, midbaseinfo);
					   	return AjaxResult.success("2",pubEppasswordDto);  //变更，回显已有的联络员信息（个体户）
				     }
					 //宁波（地区特殊处理）
					 if(StringUtils.isNotBlank(midbaseinfo.getRegOrg()) && midbaseinfo.getRegOrg().substring(0,4).equals("3302")){ //登记机关前四位为3302
						 if(Eppasswordlist == null || Eppasswordlist.size()==0 ){//未办理过联络员
						   	 return AjaxResult.error("pb2","你企业（农专社）未确认过企业联络员信息，请先完成企业联络员注册。"); 
						 }
			    		 PubEppasswordDto pubEppasswordDto = Eppasswordlist.get(0);
						 pubEppasswordDto.setEncerNO(encerNO);  //加密证件号码
						 pubEppasswordDto.setEntTypeCatg(midbaseinfo.getEntTypeCatg());
						 pubEppasswordDto = pubEppasswordService.handPubEppasswordDto(pubEppasswordDto, midbaseinfo);
				  		return AjaxResult.success("1",pubEppasswordDto); 
							 
				     }
					 if (!certificateList.isEmpty() || Eppasswordlist.isEmpty()) {//即有证书、无证书且未确认过联络员的企业、农专社
				  		    return AjaxResult.error("ent3"," 你企业（农专社）应使用数字证书登录后直接在线变更企业联络员信息。");  
			        }else {
			    		 PubEppasswordDto pubEppasswordDto = Eppasswordlist.get(0);
						 pubEppasswordDto.setEncerNO(encerNO);  //加密证件号码
						 pubEppasswordDto.setEntTypeCatg(midbaseinfo.getEntTypeCatg());
						 pubEppasswordDto = pubEppasswordService.handPubEppasswordDto(pubEppasswordDto, midbaseinfo);
				  		return AjaxResult.success("1",pubEppasswordDto); 
				    }
				 }
				}catch (Exception ex) {
					return AjaxResult.error("系统错误，请联系管理员！");
				}
			}	
			
			
			
 	
}