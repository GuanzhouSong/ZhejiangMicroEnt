/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.favorable.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ICodeEntcatgService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.PdfUtils;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.favorable.dto.FavorAbleInfoDto;
import com.icinfo.cs.favorable.model.FavorAbleInfo;
import com.icinfo.cs.favorable.service.IFavorAbleInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpaDetailDto;
import com.icinfo.cs.opanomaly.dto.PubPbopanomalyDto;
import com.icinfo.cs.opanomaly.service.IPubOpaDetailService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.secnocreditsup.model.ExpSeriousCrimeList;
import com.icinfo.cs.secnocreditsup.service.IExpSeriousCrimeListService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.framework.mybatis.mapper.util.StringUtil;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_favorable_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年03月02日
 */
@Controller
@RequestMapping({"/reg/server/favorable","/syn/favorable"})
public class FavorAbleInfoController extends CSBaseController {
	
	@Autowired
	private IFavorAbleInfoService favorAbleInfoService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private IPubOpaDetailService pubOpaDetailService;
	@Autowired
	ICodeEntcatgService codeEntcatgService;
	@Autowired
	IExpSeriousCrimeListService expSeriousCrimeListService;
	
	
	/**
	 * 
	 * 描述   进入企业良好信息查询页面
	 * @author 赵祥江
	 * @date 2017年3月2日 下午3:36:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/favorAbleSearchList")
	public ModelAndView favorAbleInfoSearchList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/reg/server/favorable/favorablesearch_list");
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		view.addObject("yearList", DateUtil.getYearToNow());
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
	/**
	 * 
	 * 描述   查看详情
	 * @author 赵祥江
	 * @date 2017年3月6日 上午11:40:22 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/favorAbleInfoDetail")
	public ModelAndView favorAbleInfoDetail(HttpSession session,String uid,String type) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		ModelAndView view  = null;
		if("1".equals(type)){
			 view  = new ModelAndView("/reg/server/favorable/favorablesearchdetail_edit");
		}else{
			view  = new ModelAndView("/reg/server/favorable/favorableprintdetail_edit");
		}
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		FavorAbleInfo favorAbleInfo=favorAbleInfoService.selectFavorAbleInfoByUid(uid);
		String priPID=favorAbleInfo.getPriPID();
		MidBaseInfoDto midBaseInfo=this.midBaseInfoService.selectMidBaseInfoByPripid(priPID);
		view.addObject("entBasicInfo", midBaseInfo);
		view.addObject("uid", uid);
		view.addObject("sysUrl", sysUrl);
		view.addObject("priPID", priPID); 
		view.addObject("favorAbleInfo", favorAbleInfo); 
		view.addObject("yearList", DateUtil.getYearToNow()); 
		view.addObject("nowDate", DateUtil.getCurrentTime()); 
		view.addObject("isOpanomaly", checkIsOpanomaly(midBaseInfo.getEntTypeCatg(), priPID));
		//联络员信息
	  	PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(priPID);
	  	view.addObject("liaName",pubEppassword==null?"": pubEppassword.getLianame());
	  	view.addObject("liaTel",pubEppassword==null?"": pubEppassword.getTel());
		return view;
	}
	
	
	/**
	 * 
	 * 描述   根据主体身份代码获取良好企业信息
	 * @author 赵祥江
	 * @date 2017年3月8日 下午3:37:44 
	 * @param 
	 * @return PageResponse<FavorAbleInfoDto>
	 * @throws
	 */
	@RequestMapping("/selectFavorAbleInfoJSON")
	@ResponseBody
	public PageResponse<FavorAbleInfo> selectFavorAbleInfoJSON(String priPID,String  efftStatus) throws Exception {
		PageRequest request=new PageRequest();
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("priPID", priPID);
		queryMap.put("efftStatus", efftStatus);
		request.setParams(queryMap);
		request.setLength(999999);
		List<FavorAbleInfo> favorAbleInfoList=favorAbleInfoService.selectFavorAbleInfoBypriPIDAndEfftStatus(request);
		return  new PageResponse<FavorAbleInfo>(favorAbleInfoList); 
	}
	
	/**
	 * 
	 * 描述   根据主体身份代码获取不良信息
	 * @author 赵祥江
	 * @date 2017年3月9日 下午2:03:48 
	 * @param 
	 * @return PageResponse<FavorAbleInfo>
	 * @throws
	 */
	@RequestMapping("/selectCaseInfoBypriPIDAndEfftStatusJSON")
	@ResponseBody
	public PageResponse<FavorAbleInfo> selectCaseInfoBypriPIDAndEfftStatusJSON(String priPID) throws Exception {
		PageRequest request=new PageRequest();
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("priPID", priPID);
		request.setParams(queryMap);
		request.setLength(999999);
		List<FavorAbleInfo> favorAbleInfoList=favorAbleInfoService.selectCaseInfoBypriPIDAndEfftStatus(request);
		return  new PageResponse<FavorAbleInfo>(favorAbleInfoList); 
	}
	
	
	
	/**
	 * 
	 * 描述   分页查询企业良好信息
	 * @author 赵祥江
	 * @date 2017年3月3日 下午2:37:39 
	 * @param 
	 * @return PageResponse<MidBaseInfo>
	 * @throws
	 */
	@RequestMapping({"/favorAbleInfoListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<FavorAbleInfoDto> favorAbleInfoListJSON(PageRequest request,HttpSession session) throws Exception {
		Map<String,Object>	queryMap=	request.getParams();
		//去掉查询参数的左右空格
		com.icinfo.cs.common.utils.StringUtil.paramTrim(queryMap);
		//未选择查询条件下查询结果默认显示本部门登记或管辖的在册企业信息
		String isChoose="1";
		/*if(checkParm(queryMap)){
			String deptCode="";
			isChoose="0";
			SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
			//协同
			if("2".equals(sysUser.getUserType())){
				deptCode=sysUser.getSysDepart().getAdcode().substring(0, 6);  
			}else{
				deptCode=sysUser.getDepartMent().getDeptCode().substring(0, 6); 
			}
			queryMap.put("regOrg", deptCode);
			queryMap.put("localAdm", deptCode+"%"); 
		}*/
		if(queryMap.containsKey("regState")){
			queryMap.put("regState", com.icinfo.cs.common.utils.StringUtil.doSplitStringToSqlFormat(queryMap.get("regState").toString(),","));
		}
		//根据统一代码注册号后四位查询
		if(queryMap.get("uniCode_regNO").toString().length()==4){
			queryMap.put("uniCode_regNO_4", queryMap.get("uniCode_regNO").toString());
			queryMap.remove("uniCode_regNO");
		}
		queryMap.put("isChoose", isChoose);
		if(queryMap.containsKey("infaustlType")&&queryMap.get("infaustlType")!=null){
			String[] infaustlTypeArr=queryMap.get("infaustlType").toString().split(",");
			if(infaustlTypeArr.length>0){
				for(int i=0;i<infaustlTypeArr.length;i++){
					if("0".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType0", infaustlTypeArr[i]);
					}else if("1".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType1", infaustlTypeArr[i]);
					}else if("2".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType2", infaustlTypeArr[i]);
					}else if("3".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType3", infaustlTypeArr[i]);
					}else if("4".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType4", infaustlTypeArr[i]);
					}else if("5".equals(infaustlTypeArr[i])){
						queryMap.put("infaustlType5", infaustlTypeArr[i]);
					}
				}
			}
		}
		request.setParams(queryMap);
		List<FavorAbleInfoDto> favorAbleInfoList= favorAbleInfoService.queryFavorAblePage(request);
		return new PageResponse<FavorAbleInfoDto>(favorAbleInfoList);
	}
	
	/**
	 * 
	 * 描述   校验是否没有选择查询条件  true 没有选择 false 选择
	 * @author 赵祥江
	 * @date 2017年3月3日 下午3:33:37 
	 * @param 
	 * @return boolean
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	private boolean checkParm(Map<String,Object>	parMap){
		String [] favTypeArr={"0","1","2","3","4","5","6"};
		String [] licZoneArr={"0","1","2","3"};
		String [] regStateArr={"K","A","B","DA","X","C","D","XX","DX","Q"}; 
		String [] infaustlTypeArr={"0","1","2","3","4","5"};
		boolean flag=true;
		if(parMap!=null){
			Iterator<Entry<String, Object>> i=parMap.entrySet().iterator();
			while(i.hasNext()){
				 Map.Entry e=(Map.Entry)i.next();
				 if("regState".equals(e.getKey())&&StringUtil.isNotEmpty(e.getValue().toString())){
					 if(regStateArr.length!=e.getValue().toString().split(",").length){
						 flag=false;
						 break;
					 }
				 }else if("favType".equals(e.getKey())&&StringUtil.isNotEmpty(e.getValue().toString())){
					 if(favTypeArr.length!=e.getValue().toString().split(",").length){
						 flag=false;
						 break;
					 }
				 }else if("licZone".equals(e.getKey())&&StringUtil.isNotEmpty(e.getValue().toString())){
					 if(licZoneArr.length!=e.getValue().toString().split(",").length){
						 flag=false;
						 break;
					 }
				 }else if("infaustlType".equals(e.getKey())&&StringUtil.isNotEmpty(e.getValue().toString())){
					 if(infaustlTypeArr.length!=e.getValue().toString().split(",").length){
						 flag=false;
						 break;
					 }
				 }else{
					 if(e.getValue()!=null&&!"".equals(e.getValue())){
						 flag=false;
						 break;
					 } 
				 }
			} 
		} 
		return flag;
	} 
	
	/**
	 * 
	 * 描述   生成PDF文件
	 * @author 赵祥江
	 * @date 2017年3月8日 下午2:54:18 
	 * @param 
	 * @return ResponseEntity<byte[]>
	 * @throws
	 */
	@RequestMapping("/createPdf")
	public ResponseEntity<byte[]> createPdf(HttpServletRequest request, String uid,String efftStatus,String caseEfftStatus)
			throws Exception { 
		PageRequest page = new PageRequest();
		page.setLength(99999);
		Map<Object, Object> o = new HashMap<Object, Object>();
	    Map<String,Object> map=new HashMap<String,Object>(); 
	    FavorAbleInfo favorAbleInfo=favorAbleInfoService.selectFavorAbleInfoByUid(uid);
	    String priPID=favorAbleInfo.getPriPID();
	    MidBaseInfoDto entBasicInfo = midBaseInfoService.selectMidBaseInfoByPripid(priPID);	    
	    o.put("leRep", entBasicInfo.getLeRep());
	    o.put("tel", entBasicInfo.getTel());
	    //联络员信息
	  	PubEppassword pubEppassword= pubEppasswordService.selectPubEppasswordByPriPid(priPID);
	    o.put("liaName",pubEppassword==null?"": pubEppassword.getLianame());
	    o.put("liaTel",pubEppassword==null?"": pubEppassword.getTel());
	    o.put("imPubDate", "");
	    map.put("priPID",priPID); 
		o.put("entBasicInfo", entBasicInfo);
		o.put("isOpanomaly", checkIsOpanomaly(entBasicInfo.getEntTypeCatg(), priPID));
		if (entBasicInfo != null && StringUtils.isNotEmpty(entBasicInfo.getEntTypeCatg())) {
			entBasicInfo
					.setEntTypeCatgName(codeEntcatgService.selectByCode(entBasicInfo.getEntTypeCatg()).getContent());
		} 
	    o.put("pubEppassword", pubEppassword);  
		String path = request.getSession().getServletContext().getRealPath("WEB-INF/views/page/reg/server/favorable");
		String uuid = UUID.randomUUID().toString().replace("-", "");
		Map<String,Object> queryMap=new HashMap<String,Object>();
		queryMap.put("priPID", priPID);
		queryMap.put("efftStatus", efftStatus);
		page.setParams(queryMap);
		List<FavorAbleInfo> favorAbleInfoList=favorAbleInfoService.selectFavorAbleInfoBypriPIDAndEfftStatus(page);  
		//处理自动换行
		addfavorAbleInfoList(favorAbleInfoList);
		o.put("favorAbleInfoList", favorAbleInfoList);
		o.put("facorableSize", favorAbleInfoList.size());
		queryMap.remove("efftStatus");
		//企业不良信息
		List<FavorAbleInfo> caseFavorAbleInfoList=favorAbleInfoService.selectCaseInfoBypriPIDAndEfftStatus(page);
		o.put("caseFavorAbleInfoList", caseFavorAbleInfoList);
		o.put("caseFavorAbleInfoSize", caseFavorAbleInfoList.size());
		PdfUtils.generateToFile(request, path, "favorable.ftl", path + "/", o, path + "/" + uuid + ".pdf");

		File file = new File(path + "/" + uuid + ".pdf");
		// 更改下载名称
		HttpHeaders headers = new HttpHeaders();
		String entName=entBasicInfo.getEntName()+".pdf";
		String fileName = new String(entName.getBytes("GBK"), "iso-8859-1");// 为了解决中文名称乱码问题
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
		 ResponseEntity<byte[]>bytes=	 new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
		 if (file.isFile() && file.exists()) {  
		        file.delete();   //删除掉pdf文件
		    }
				 return bytes;
	} 
	
	/**
	 * 
	 * 描述   处理自动换行
	 * @author 赵祥江
	 * @date 2017年3月14日 下午5:08:36 
	 * @param 
	 * @return void
	 * @throws
	 */
	private void addfavorAbleInfoList(List<FavorAbleInfo> favorAbleInfoList){
		 if(favorAbleInfoList.size()>0){
			 for(FavorAbleInfo favorAbleInfo :favorAbleInfoList ){
				 //认定发布部门
				 String regDeptCn=favorAbleInfo.getRegDeptCn();
				 StringBuffer sb=new StringBuffer();
				 int i=0;
				 while (StringUtil.isNotEmpty(regDeptCn)&&regDeptCn.length()>10) { 
					 sb.append(regDeptCn.substring(0, 10));
					 sb.append("\r\n"); 
					 regDeptCn=regDeptCn.substring(10, regDeptCn.length());
					 if(regDeptCn.length()<10){
						 sb.append(regDeptCn); 
					 }
					 i++;
				 }
				 if(i>0){
					 favorAbleInfo.setRegDeptCn(sb.toString());
					 i=0;
					 sb.delete(0, sb.length());
				 }
				 //文号
				 String regDocNo=favorAbleInfo.getRegDocNo();
				 while (StringUtil.isNotEmpty(regDocNo)&&regDocNo.length()>10) { 
					 sb.append(regDocNo.substring(0, 10));
					 sb.append("\r\n"); 
					 regDocNo=regDocNo.substring(10, regDocNo.length());
					 if(regDocNo.length()<10){
						 sb.append(regDocNo); 
					 }
					 i++;
				 }
				 if(i>0){
					 favorAbleInfo.setRegDocNo(sb.toString());
				 }
			 }
		 }
	}
	 
	
	/**
	 * 
	 * 描述   检查企业是否是异常名录
	 * @author 赵祥江
	 * @date 2017年3月9日 下午4:27:03 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String checkIsOpanomaly(String entTypeCatg,String priPID) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
	    map.put("priPID",priPID);
	    String opanomaly="0";
	    String seriousCrime="0";
	    if("50".equals(entTypeCatg)){
	    	List<PubPbopanomalyDto> dataList = pubPbopanomalyService.pubPbopanomalySearchRecoverList(map);
	    	if(dataList!=null&&dataList.size()>0){
	    		opanomaly="1";
	    	} 
	    }else{
	    	 List<PubOpaDetailDto> dataList = pubOpaDetailService.selectAddMoveOutSearch(map);
	 	     if(dataList != null && dataList.size() > 0){
	 	    	opanomaly="1";
	 	     }
	    } 
	    List<ExpSeriousCrimeList> expSeriousCrimeList=  expSeriousCrimeListService.selectSeriousCrimeInfoByPriPID(priPID);
	    if(expSeriousCrimeList!=null&&expSeriousCrimeList.size()>0){
	    	seriousCrime="1";
	    }
	    //同时被列入异常和严重违法
	    if("1".equals(opanomaly)&&"1".equals(seriousCrime)){
	    	return "1";
	    }else if("1".equals(opanomaly)&&!"1".equals(seriousCrime)){//只列入异常
	    	return "2";
	    }else if(!"1".equals(opanomaly)&&"1".equals(seriousCrime)){//只列入严重违法
	    	return "3";
	    }else {
	    	return "0";
	    }
	}
	
	
	/** 
	 * 描述: 根据身份号获取列表信息
	 * @author 张文男
	 * @date 2017年3月17日 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	
	@RequestMapping({"/selectListByCerNO"})
	@ResponseBody
	public PageResponse<FavorAbleInfo> selectListByCerNO(PageRequest request) throws Exception {
		List<FavorAbleInfo> favorAbleInfoList=favorAbleInfoService.selectListByCerNO(request);
		return new PageResponse<FavorAbleInfo>(favorAbleInfoList); 
	}
	
	
	
}