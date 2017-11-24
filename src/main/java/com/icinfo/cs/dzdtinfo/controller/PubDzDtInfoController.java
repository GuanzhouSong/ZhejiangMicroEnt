/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.dzdtinfo.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeDzLicense;
import com.icinfo.cs.base.model.CodeEntType;
import com.icinfo.cs.base.model.CodeInDusTry;
import com.icinfo.cs.base.model.CodeRegorg;
import com.icinfo.cs.base.service.ICodeCurrencyService;
import com.icinfo.cs.base.service.ICodeDzLicenseService;
import com.icinfo.cs.base.service.ICodeEntTypeService;
import com.icinfo.cs.base.service.ICodeInDusTryService;
import com.icinfo.cs.base.service.ICodeRegorgService;
import com.icinfo.cs.base.service.ICodeRegunitService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.LogOperation;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.drcheck.dto.PubScresultDto;
import com.icinfo.cs.drcheck.service.IPubScresultService;
import com.icinfo.cs.dzdtinfo.dto.HzDzhyBagsslfgsbaDto;
import com.icinfo.cs.dzdtinfo.dto.HzDzhyLxsfsfwwdbaDto;
import com.icinfo.cs.dzdtinfo.dto.PubDzDtInfoDto;
import com.icinfo.cs.dzdtinfo.model.HzDzhyBafzrgzqk;
import com.icinfo.cs.dzdtinfo.model.HzDzhyCbdlfwjyzba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyCsyspjydwba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyDlhwjyzslfgsba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyDlkyjyzslfgsba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyDxscyqyrdba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyFdcjjjgba;
import com.icinfo.cs.dzdtinfo.model.HzDzhyHscyry;
import com.icinfo.cs.dzdtinfo.model.HzDzhyZfgjjjcdj;
import com.icinfo.cs.dzdtinfo.model.HzDzhyZszyhsjyzba;
import com.icinfo.cs.dzdtinfo.model.PubDzDtInfo;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyBafzrgzqkService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyBagsslfgsbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyCbdlfwjyzbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyCsyspjydwbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyDlhwjyzslfgsbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyDlkyjyzslfgsbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyDxscyqyrdbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyFdcjjjgbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyHscyryService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyHyxgfwjyzbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyLxsfsfwwdbaService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyZfgjjjcdjService;
import com.icinfo.cs.dzdtinfo.service.IHzDzhyZszyhsjyzbaService;
import com.icinfo.cs.dzdtinfo.service.IPubDzDtInfoService;
import com.icinfo.cs.ext.model.MidBaseInfo;
import com.icinfo.cs.ext.service.IMidBaseInfoService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.opanomaly.dto.PubOpanoMalyDto;
import com.icinfo.cs.opanomaly.model.PubPbopanomaly;
import com.icinfo.cs.opanomaly.service.IPubOpanoMalyService;
import com.icinfo.cs.opanomaly.service.IPubPbopanomalyService;
import com.icinfo.cs.other.model.PubOtherlicence;
import com.icinfo.cs.other.service.IPubOtherlicenceService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.system.model.CodeDutydept;
import com.icinfo.cs.system.model.SysDepart;
import com.icinfo.cs.system.model.SysUser;
import com.icinfo.cs.system.service.ICodeDutydeptService;
import com.icinfo.cs.system.service.ISysDepartService;
import com.icinfo.cs.system.service.ISysLogService;
import com.icinfo.cs.system.service.ISysUserService;
import com.icinfo.cs.system.service.IWorkDayService;
import com.icinfo.cs.yr.dto.PubOtherpunishDto;
import com.icinfo.cs.yr.model.SysLicense;
import com.icinfo.cs.yr.service.IPubOtherpunishService;
import com.icinfo.cs.yr.service.ISysLicenseService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.annotation.RepeatSubmit;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.framework.tools.utils.DateUtils;
import com.icinfo.framework.tools.utils.StringUtils;

/**
 * 描述:    cs_pub_dz_dtinfo 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2016年10月18日
 */
@Controller
@RequestMapping({ "/syn/pubdzdtinfo", "/reg/server/pubdzdtinfo" })
public class PubDzDtInfoController extends CSBaseController {
	
	@Autowired
	private IPubDzDtInfoService pubDtInfoService;
	@Autowired
	private ICodeRegunitService codeRegunitService;
	@Autowired
	private ICodeRegorgService codeRegorgService; 
	 
	@Autowired
	private ICodeEntTypeService codeEntTypeService;
	@Autowired
	private ICodeInDusTryService codeInDusTryService;
	@Autowired
	private IMidBaseInfoService midBaseInfoService;
	 

	@Autowired
	private ICodeDzLicenseService codeLicenseService;
	@Autowired
	private ISysUserService sysUserService;
	@Autowired
	private IPubOtherlicenceService pubOtherlicenceService;
	@Autowired
	private IPubOtherpunishService pubOtherpunishService;
	@Autowired
	private IWorkDayService workDayService;
	@Autowired
	private ISysDepartService sysDepartService; 
    @Autowired
    private IPubScresultService pubScresultService;
	@Autowired
	private IPubOpanoMalyService pubOpanoMalyService;
	@Autowired 
	private IPubPbopanomalyService pubPbopanomalyService;
	@Autowired
	private ICodeDutydeptService codeDutydeptService;
    @Autowired
    ISysLicenseService sysLicenseService;
    @Autowired
    private ISysLogService sysLogService;
    @Autowired
	private IPubEppasswordService pubEppasswordService;
    //保安负责人工作经验情况
    @Autowired
    private IHzDzhyBafzrgzqkService hzDzhyBafzrgzqkService;
    //保安服务公司设立分公司备案
    @Autowired
    private IHzDzhyBagsslfgsbaService hzDzhyBagsslfgsbaService;
    //船舶代理等国内水路运输服务业经营者备案
    @Autowired
    private IHzDzhyCbdlfwjyzbaService hzDzhyCbdlfwjyzbaService;
    //从事艺术品经营单位备案
    @Autowired
    private IHzDzhyCsyspjydwbaService hzDzhyCsyspjydwbaService;
    //道路货物运输经营者设立分公司报备
    @Autowired
    private IHzDzhyDlhwjyzslfgsbaService hzDzhyDlhwjyzslfgsbaService;
    //道路客运经营者设立分公司报备
    @Autowired
    private IHzDzhyDlkyjyzslfgsbaService hzDzhyDlkyjyzslfgsbaService;
    //大学生创业企业认定备案
    @Autowired
    private IHzDzhyDxscyqyrdbaService hzDzhyDxscyqyrdbaService;
    //房地产经纪机构及其分支机构备案
    @Autowired
    private IHzDzhyFdcjjjgbaService hzDzhyFdcjjjgbaService;
    //回收从业人员情况
    @Autowired
    private  IHzDzhyHscyryService hzDzhyHscyryService;
    @Autowired
    private IHzDzhyHyxgfwjyzbaService hzDzhyHyxgfwjyzbaService;
    //旅行社分社/服务网点备案
    @Autowired
    private IHzDzhyLxsfsfwwdbaService hzDzhyLxsfsfwwdbaService;
    //住房公积金缴存登记
    @Autowired
    private IHzDzhyZfgjjjcdjService hzDzhyZfgjjjcdjService;
    //再生资源回收经营者备案
    @Autowired
    private IHzDzhyZszyhsjyzbaService hzDzhyZszyhsjyzbaService;
    @Autowired
    private ICodeCurrencyService codeCurrencyService; 
    
    /**
     * 
     * 描述   进入涉证企业查询页面
     * @author 赵祥江
     * @date 2017年6月27日 下午3:01:44 
     * @param 
     * @return ModelAndView
     * @throws
     */
	@RequestMapping("/searchlist")
	public ModelAndView searchList(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinfosearch_list");
		view.addObject("userType", sysUser.getUserType());
		return view;
	}

	
	/**
	 * 
	 * 描述   涉证企业查询
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:01:58 
	 * @param 
	 * @return PageResponse<PubDzDtInfoDto>
	 * @throws
	 */
	@RequestMapping({ "/searchlist.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubDzDtInfoDto> searchListJSON(PageRequest request,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		Integer total=0;
		List<PubDzDtInfoDto> data = pubDtInfoService.queryPage(request,sysUser);
		total = pubDtInfoService.selectPubdtinfoSearchCount();
		if(request.getParams() == null){	
		}else{
			if(request.getParams().containsKey("claimFlag")){//认领接收查询标志：需要处理日期(设置警示日期);
				for(PubDzDtInfoDto pubDtInfoDto : data ){
					try {
						pubDtInfoDto.setGreenDate(DateUtil.dateToString(workDayService.getNWorkDaylaterWorkDay(DateUtil.dateToString(pubDtInfoDto.getCheckPushDate(), "yyyy-MM-dd"), 7), "yyyy-MM-dd"));
						pubDtInfoDto.setYellowDate(DateUtil.dateToString(workDayService.getNWorkDaylaterWorkDay(DateUtil.dateToString(pubDtInfoDto.getCheckPushDate(), "yyyy-MM-dd"), 10),"yyyy-MM-dd"));
						//设置企业联系电话
						pubDtInfoDto.setTel(getTelByPriPID(pubDtInfoDto.getPriPID()));
					} catch (Exception e) {
						e.printStackTrace();
						continue;
					}
				}
			}
		}
		return new PageResponse<PubDzDtInfoDto>(data,total,request);
	}
	
	/**
	 * @throws Exception 
	 * 
	 * 描述   取企业的联系方式 优先取企业联络员，如果没有则取法定代表人
	 * @author 赵祥江
	 * @date 2017年3月14日 下午4:19:35 
	 * @param 
	 * @return String
	 * @throws
	 */
	private String getTelByPriPID(String priPID) throws Exception{
		String tel="";
		if(priPID!=null&&!"".equals(priPID)){
			PubEppassword  pubEppassword =pubEppasswordService.selectPubEppasswordByPriPid(priPID);
		    if(pubEppassword!=null){
		    	tel=pubEppassword.getTel();
		    }else{
		    	//企业信息
				MidBaseInfo midBaseInfo=midBaseInfoService.selectByPripid(priPID);
				if(midBaseInfo!=null){
					tel=midBaseInfo.getTel();
				}
		    }
		}
		return tel;
	}
	
	 
	/**
	 * 
	 * 描述   涉证企业查询处统计
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:02:24 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/searchCount",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult searchListCount(PageRequest request) throws Exception {      
        Map<String, Object> map = request.getParams();
        if(map == null){
        	map = new HashMap<String, Object>();
        }
		List<Integer> countList = new ArrayList<Integer>();
        try {
    		if(map.get("checkDeps") != null){  //备案机关
    			map.put("checkDeps", StringUtil.doSplitStringToSqlFormat(map.get("checkDeps").toString(),","));
    		}
			if(map.get("industryCo") !=null){  //备案机关
				map.put("industryCo", StringUtil.doSplitStringToSqlFormat(map.get("industryCo").toString(),","));
			}
        	//推送成功标志
			map.put("sendSuccess", "1"); 
			int sendSuccessCount = pubDtInfoService.pubDtinfoSearchCount(map);
			map.remove("sendSuccess");
			map.put("sendFail", "1"); //推送失败标志
			int sendFailCount = pubDtInfoService.pubDtinfoSearchCount(map);
			map.remove("sendFail");
			map.put("reback", "1"); //回退标志
			int rebackCount = pubDtInfoService.pubDtinfoSearchCount(map);
			map.remove("reback");
			map.put("pushStop", "1");//终止推送
			int pushStopCount = pubDtInfoService.pubDtinfoSearchCount(map);
			map.remove("pushStop");
			int sendBusinessCount  = pubDtInfoService.pubDtinfoCount(map);
			int sendDeptCount= pubDtInfoService.sendDeptCount(map);
			countList.add(sendSuccessCount);
			countList.add(sendFailCount);
			countList.add(rebackCount);
			countList.add(pushStopCount);
			countList.add(sendBusinessCount);
			countList.add(sendDeptCount);
        } catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("统计数失败");
		}	
		return AjaxResult.success("统计数成功", countList);
	}
	
	/**
	 * 
	 * 描述   校验同一部门同一企业同一备案事项是否推送过
	 * @author 赵祥江
	 * @date 2016年11月10日 下午8:05:34 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/checkPush", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult checkPush(@RequestBody PubDzDtInfo pubDtInfo) throws Exception {
		try {
			boolean flag=pubDtInfoService.checkPush(pubDtInfo.getExaCode(), pubDtInfo.getCheckDep(), pubDtInfo.getPriPID());
			return AjaxResult.success("", flag);
		} catch (Exception e) {
			
		} 	
		return AjaxResult.error("");
	}
	
	

	/**
	 * 
	 * 描述   进入涉证企业分流列表页面
	 * @author 赵祥江
	 * @date 2016年10月17日 下午2:49:34 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubdzdtinfoHandPushListPage")
	public ModelAndView pubdtinfoHandPushListPage(HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdzdtinfohandpush_list");
		view.addObject("sysUrl", sysUrl);
		return view;
	}
	
	/**
	 * 
	 * 描述   分页查询推送失败和退回待推送且未终止的推送数据
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:45:44 
	 * @param 
	 * @return PageResponse<PubDtInfoDto>
	 * @throws
	 */
	@RequestMapping({"/pubdzdtinfoFailReBackListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubDzDtInfoDto> pubdtinfoFailReBackListJSON(PageRequest request)throws Exception{
	Map<String,Object> queryMap= request.getParams();
	if(queryMap==null){
		queryMap=new HashMap<String,Object>();
	} 
	if(queryMap.containsKey("regOrg")){
		queryMap.put("regOrg", StringUtil.doSplitStringToSqlFormat(queryMap.get("regOrg").toString(),","));
	} 
	if(queryMap.containsKey("exaCode")){
		queryMap.put("exaCode", StringUtil.doSplitStringToSqlFormat(queryMap.get("exaCode").toString(),","));
	}
	//去掉查询参数的左右空格
	pubDtInfoService.paramTrim(queryMap);
	//推送失败和未分流标识  0：未分流； 1自动分流； 2：手动分流，3分流失败
	if(queryMap.containsKey("checkPushType")&&(!"".equals(queryMap.get("checkPushType").toString()))){
		queryMap.put("checkPushType",queryMap.get("checkPushType").toString()); 
	}else{
		queryMap.put("checkPushType", "\'0\',\'3\'"); 
	}
	request.setParams(queryMap);
	buildDBEnv_baseLocalAdminWhenSyn(false).creatDefaultDBAuthEnv(request,"a.RegOrg","a.LocalAdm"); 
	List<PubDzDtInfoDto> pubOpanoMalyDtoList= pubDtInfoService.queryPubdtinfoFailReBackListJSON(request);
	if(pubOpanoMalyDtoList.size()>0){
		for(PubDzDtInfoDto pubDtInfoDto:pubOpanoMalyDtoList){
			try {
				pubDtInfoDto.setTel(getTelByPriPID(pubDtInfoDto.getPriPID()));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
	}
	Integer total=pubDtInfoService.selectPubdtinfoFailReBackListCount(queryMap);
	return new PageResponse<PubDzDtInfoDto>(pubOpanoMalyDtoList,total,request);
	} 
	
	/**
	 * 
	 * 描述   点击推送按钮进入分流页面
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:46:53 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubdtinfoHandPush")
	public ModelAndView pubdtinfoHandPush(String uid,HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinfohandpush_edit");
		SysUserDto sysUserSession = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
        PubDzDtInfo pubDtInfo=pubDtInfoService.selectPubDtInfoByUID(uid); 
        String priPid=pubDtInfo.getPriPID();
		view.addObject("pubDtInfo", pubDtInfo);
		//企业小类
		CodeEntType codeEntType=codeEntTypeService.selectCodeEntTypeByCode(pubDtInfo.getEntType()==null?"00000":pubDtInfo.getEntType());
		view.addObject("codeEntType", codeEntType); 
		//行业
		CodeInDusTry codeInDusTry=codeInDusTryService.selectCodeInDusTryByCode(pubDtInfo.getIndustryCo()==null?"00000":pubDtInfo.getIndustryCo());
		view.addObject("codeInDusTry", codeInDusTry);
		//后置备案事项
		CodeDzLicense codeLicense=codeLicenseService.selectCodeLicenseByExaCodeAndLicType(pubDtInfo.getExaCode(), "2");
		view.addObject("codeLicense", codeLicense);
		//获取登记机关联络员
		CodeRegorg codeRegorg= codeRegorgService.selectRegOrgByCode(pubDtInfo.getRegOrg());
		view.addObject("codeRegorg", codeRegorg); 
		//根据部门编码获取部门
		List<SysDepart> sysDepartList =sysDepartService.doGetSysDepartByAdcode(pubDtInfo.getCheckDep()==null?"00000":pubDtInfo.getCheckDep());
		view.addObject("sysDepartList", sysDepartList); 
		SysUser sysUser =null; 
		//回退时查询回退人信息
		if("2".equals(pubDtInfo.getReassignType())){
			 //sysUser =sysUserService.selectByUserName(pubDtInfo.getReassignAccount()==null?"0000":pubDtInfo.getReassignAccount());
			sysUser =sysUserService.select(pubDtInfo.getReassignUserId()==null?"0000":pubDtInfo.getReassignUserId());
		}
		view.addObject("rebackUser", sysUser); 
		MidBaseInfo midBaseInfo=this.midBaseInfoService.selectByPripid(priPid);
		view.addObject("midBaseInfo", midBaseInfo); 
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUserSession.getUserType())){
			sysUrl="/syn";
		}
		view.addObject("sysUrl", sysUrl);
		//设置备案信息
		setModelAndViewBeiAn( priPid,view);
		return view;
	} 
	
	/**
	 * 
	 * 描述   设置企业备案信息
	 * @author 赵祥江
	 * @date 2017年6月15日 下午7:14:41 
	 * @param 
	 * @return void
	 * @throws
	 */
	public void setModelAndViewBeiAn(String priPid,ModelAndView view) throws Exception{
		//大学生创业企业认定备案
		List<HzDzhyDxscyqyrdba> hzDzhyDxscyqyrdbaList =hzDzhyDxscyqyrdbaService.selectHzDzhyDxscyqyrdbaByPriPid(priPid);
		view.addObject("hzDzhyDxscyqyrdbaList", hzDzhyDxscyqyrdbaList); 
		//从事艺术品经营单位备案
		List<HzDzhyCsyspjydwba> hzDzhyCsyspjydwbaList=hzDzhyCsyspjydwbaService.selectHzDzhyCsyspjydwbaByPriPid(priPid);
		view.addObject("hzDzhyCsyspjydwbaList", hzDzhyCsyspjydwbaList); 
		//房地产经纪机构及其分支机构备案
		List<HzDzhyFdcjjjgba> hzDzhyFdcjjjgbaList=hzDzhyFdcjjjgbaService.selectHzDzhyFdcjjjgbaByPriPid(priPid);
		view.addObject("hzDzhyFdcjjjgbaList", hzDzhyFdcjjjgbaList);
		//住房公积金缴存登记
		List<HzDzhyZfgjjjcdj> hzDzhyZfgjjjcdjList=hzDzhyZfgjjjcdjService.selectHzDzhyZfgjjjcdjByPriPid(priPid);
		view.addObject("hzDzhyZfgjjjcdjList", hzDzhyZfgjjjcdjList);
		//保安服务公司设立分公司备案
		//List<HzDzhyBagsslfgsba> hzDzhyBagsslfgsbaList=hzDzhyBagsslfgsbaService.selectHzDzhyBagsslfgsbaByPriPid(priPid);
		List<HzDzhyBagsslfgsbaDto> hzDzhyBagsslfgsbaDtoList =hzDzhyBagsslfgsbaService.selectHzDzhyBagsslfgsbaDtoByPriPid(priPid);
		view.addObject("hzDzhyBagsslfgsbaList", hzDzhyBagsslfgsbaDtoList);
		//再生资源回收经营者备案
		List<HzDzhyZszyhsjyzba> hzDzhyZszyhsjyzbaList=hzDzhyZszyhsjyzbaService.selectHzDzhyZszyhsjyzbaByPriPid(priPid);
		view.addObject("hzDzhyZszyhsjyzbaList", hzDzhyZszyhsjyzbaList); 
		//旅行社分社/服务网点备案
		List<HzDzhyLxsfsfwwdbaDto> hzDzhyLxsfsfwwdbaDtoList=hzDzhyLxsfsfwwdbaService.selectHzDzhyLxsfsfwwdbaDtoByPriPid(priPid);
		view.addObject("hzDzhyLxsfsfwwdbaList", hzDzhyLxsfsfwwdbaDtoList); 
		//船舶代理等国内水路运输服务业经营者备案
		List<HzDzhyCbdlfwjyzba> hzDzhyCbdlfwjyzbaList=hzDzhyCbdlfwjyzbaService.selectHzDzhyCbdlfwjyzbaByPriPid(priPid);
		view.addObject("hzDzhyCbdlfwjyzbaList", hzDzhyCbdlfwjyzbaList);
		//道路客运经营者设立分公司报备
		List<HzDzhyDlkyjyzslfgsba> hzDzhyDlkyjyzslfgsbaList=hzDzhyDlkyjyzslfgsbaService.selectHzDzhyDlkyjyzslfgsbaByPriPid(priPid);
		view.addObject("hzDzhyDlkyjyzslfgsbaList", hzDzhyDlkyjyzslfgsbaList);
		//道路货物运输经营者设立分公司报备
		List<HzDzhyDlhwjyzslfgsba> hzDzhyDlhwjyzslfgsbaList=hzDzhyDlhwjyzslfgsbaService.selectHzDzhyDlhwjyzslfgsbaByPriPid(priPid);
		view.addObject("hzDzhyDlhwjyzslfgsbaList", hzDzhyDlhwjyzslfgsbaList);
		//从业人员情况
		List<HzDzhyHscyry> hzDzhyHscyryList=hzDzhyHscyryService.selectHzDzhyHscyryByPriPid(priPid);
		view.addObject("hzDzhyHscyryList", hzDzhyHscyryList);
		//保安负责人情况
		List<HzDzhyBafzrgzqk> hzDzhyBafzrgzqkList=hzDzhyBafzrgzqkService.selectHzDzhyBafzrgzqkByPriPid(priPid);
		view.addObject("hzDzhyBafzrgzqkList", hzDzhyBafzrgzqkList);
	}
	
	/**
	 * 
	 * 描述   涉证企业分流提交
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:48:29 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/commitPubDtInfoHandPush", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitPubDtInfoHandPush(@RequestBody PubDzDtInfo pubDtInfo,HttpSession session) throws Exception {
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String  userType=sysUser.getUserType();
		String msg="";
		PubDzDtInfo dtInfo = new PubDzDtInfo();
		dtInfo.setReassignUserId(sysUser.getId());
		dtInfo.setUid(pubDtInfo.getUid());
 		//终止
		if("1".equals(pubDtInfo.getCheckStopState())){
			//终止标识
			dtInfo.setCheckStopState(pubDtInfo.getCheckStopState());
			//终止备注
			dtInfo.setReassignRemark(pubDtInfo.getReassignRemark());
			//终止日期
			dtInfo.setReassignDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd"));
			//终止人账号
			dtInfo.setReassignAccount(pubDtInfo.getReassignAccount());
			//终止人姓名
			dtInfo.setReassignName(sysUser.getRealName());
			if("2".equals(userType)){
				msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了终止分流操作";
			}else{
				msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了终止分流操作";
			}  
 			//终止人部门名称
			//dtInfo.setReassignDeptName(sysUser.getDepartMent()==null?"":sysUser.getDepartMent().getDeptName());
		}else{//分流
			//备案事项编码
			dtInfo.setExaCode(pubDtInfo.getExaCode());
			//备案事项名称
			dtInfo.setExaName(pubDtInfo.getExaName());
			//推送机关编码
			dtInfo.setCheckDep(pubDtInfo.getCheckDep());
			//推送失败时更新失败原因为空
			if("3".equals(pubDtInfo.getCheckPushType())){
				dtInfo.setReassignRemark("");
			}
			
			String areaCode=pubDtInfo.getCheckDep().substring(0, 6);
			String areaName="";
			if("330000".equals(areaCode)){
				areaName="省政府";
			}else{
				List<SysDepart>  sysDepartList=sysDepartService.doGetSysDepartByAdcode(areaCode);
				if(sysDepartList!=null&&sysDepartList.size()>0){
					areaName=sysDepartList.get(0).getOrgName();
				}
			} 
			dtInfo.setAreaName(areaName);
			//推送部门类型 默认备案
			dtInfo.setCheckDeptType("3");
			//推送类型 2表示手动分流
			dtInfo.setCheckPushType("2");
			dtInfo.setDutyDeptCode(pubDtInfo.getDutyDeptCode());
			dtInfo.setDutyDeptName(pubDtInfo.getDutyDeptName());
			//分流日期
			dtInfo.setCheckPushDate(DateUtil.stringToDate(DateUtil.getCurrentDate(),"yyyy-MM-dd"));
			//备案名称
			dtInfo.setCheckDepName(pubDtInfo.getCheckDepName()); 
			dtInfo.setDeptCode(pubDtInfo.getCheckDep());
			dtInfo.setDeptName(pubDtInfo.getCheckDepName());
			if("2".equals(userType)){
				msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了手动分流操作";
			}else{
				msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了手动分流操作";
			}  
		}  
		PubDzDtInfo pubDtInfoLog=pubDtInfoService.selectPubDtInfoByUID(pubDtInfo.getUid());
		pubDtInfoLog.setReassignRemark(msg+";备案编码【"+pubDtInfoLog.getExaCode()+"】,备案事项名称【"+pubDtInfoLog.getExaName()+"】");
		//保存日志
		this.saveLog(pubDtInfoLog,userType);
		if(pubDtInfoService.updatePubDtInfoByUID(dtInfo)>0){
			return AjaxResult.success("分流成功!");
		}
		return AjaxResult.error("分流失败!");
	} 
	
	
	/**
	 * 
	 * 描述   保存日期
	 * @author 赵祥江
	 * @date 2017年1月6日 上午11:48:37 
	 * @param 
	 * @return void
	 * @throws
	 */
    private void saveLog(PubDzDtInfo pubDtInfo,String userType){
        try{
        	Map<String,String> logMap=new HashMap<String,String>();
             if("2".equals(userType)){
            	logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SYN);//协同系统
            }else{
            	logMap.put(ISysLogService.LOG_MAP_KEY_LOGTYPE,ISysLogService.LOG_TYPE_SERVER);//警示系统
            } 
            logMap.put(ISysLogService.LOG_MAP_KEY_YEAR, DateUtil.getYear());//年份
            logMap.put(ISysLogService.LOG_MAP_KEY_PRIPID, pubDtInfo.getPriPID());
            logMap.put(ISysLogService.LOG_MAP_KEY_ENTNAME, pubDtInfo.getEntName());
            logMap.put(ISysLogService.LOG_MAP_KEY_REGNO, pubDtInfo.getRegNO());
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGMSG, pubDtInfo.getReassignRemark());
            logMap.put(ISysLogService.LOG_MAP_KEY_LOGOPERRATION, LogOperation.pubDzDtInfoLog.getCode());//操作类型
            sysLogService.doAddSysLog(logMap,getRequest());
        }catch(Exception e){
        	e.printStackTrace();
        }
    }
	
	
	
	/**
	 * 
	 * 描述   进入备案事项树页面（单选）
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:51:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseRadioTreePage")
	public ModelAndView codeLicenseRadioTreePage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/codelicenseradiotree"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		view.addObject("userType", sysUser.getUserType());
		return view;
	}
	
	/**
	 * 
	 * 描述   进入备案事项树页面（复选）
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:51:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/codeLicenseCheckboxTreePage")
	public ModelAndView codeLicenseCheckboxTreePage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/codelicensecheckboxtree"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		view.addObject("userType", sysUser==null?"2":sysUser.getUserType());
		return view;
	}

	
	/**
	 * 
	 * 描述   进入涉证企业推送与反馈统计列表页面
	 * @author 赵祥江
	 * @date 2016年10月20日 上午11:20:04 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubDtInfoCountListPage")
	public ModelAndView pubDtInfoCountListPage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinfocount_list"); 
	    SysUserDto sysUserSession = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		String deptCode="";
		//协同
		if("2".equals(sysUserSession.getUserType())){
			sysUrl="/syn";
			if(sysUserSession.getSysDepart()!=null){
				deptCode=sysUserSession.getSysDepart().getAdcode();
				if(deptCode.length()>4){
					deptCode=deptCode.substring(0, 4);
				} 
			} 
 		}else {//警示
 			if(sysUserSession.getDepartMent()!=null){
				deptCode=sysUserSession.getDepartMent().getDeptCode();
				if(deptCode.length()>4){
					deptCode=deptCode.substring(0, 4);
				} 
			}
 		} 
		view.addObject("startCheckPushDate", getDateBefore(DateUtils.getSysDate(), 7));
		view.addObject("endCheckPushDate",DateUtils.getDate()); 
		view.addObject("sysUrl", sysUrl);
		view.addObject("deptCode", deptCode);
		return view;
	}
	
	/**
	 * 
	 * 描述   涉证企业推送与反馈统计
	 * @author 赵祥江
	 * @date 2016年10月20日 下午4:43:47 
	 * @param 
	 * @return PageResponse<PubDtInfoDto>
	 * @throws
	 */
	@RequestMapping({"/pubDtInfoCountListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubDzDtInfoDto> pubDtInfoCountListJSON(PageRequest request)throws Exception{
	 Map<String,Object> queryMap= request.getParams();
	 if(queryMap!=null&&queryMap.containsKey("checkDep")){
		queryMap.put("checkDep", StringUtil.doSplitStringToSqlFormat(queryMap.get("checkDep").toString(),","));
	 } 
	 List<PubDzDtInfoDto> pubOpanoMalyDtoList= pubDtInfoService.selectPubDtInfoCount(request);
	 return new PageResponse<PubDzDtInfoDto>(pubOpanoMalyDtoList);
	}
	
	/**
	 * 
	 * 描述   查询组装备案事项树
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:51:50 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/codelicenseListTreeJSON", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult codelicenseListTreeJSON(String licConent)throws Exception{
		 List<CodeDzLicense> codeLicenseList = codeLicenseService.selectCodeLicenseListByExaCodeOrExaName(licConent);
 		 List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
		 //因为备案事项没有上下级关系 这里默认给它设置一个父节点
 		 Map<String,Object> dataMapOne=new HashMap<String,Object>();
		 dataMapOne.put("name", "备案事项");
		 dataMapOne.put("id", "0");
		 dataMapOne.put("pId", "0"); 
		 dataMapOne.put("nocheck", true);
		 listMap.add(dataMapOne);
		 for (CodeDzLicense codeLicense : codeLicenseList) {
			 Map<String,Object> dataMapTwo=new HashMap<String,Object>();
			 //备案事项名称
			 dataMapTwo.put("name", codeLicense.getExaCode()+"-"+codeLicense.getExaName());
			 //备案事项编码
			 dataMapTwo.put("id", codeLicense.getExaCode());
			 //父ID
			 dataMapTwo.put("pId", "0");
			 //备案部门
			 dataMapTwo.put("licdept", codeLicense.getLicDept());
			 //职能部门编码
 			 dataMapTwo.put("code", codeLicense.getLicDeptType());
 			 //法律依据
 			 dataMapTwo.put("licrea", codeLicense.getLicRea()); 
 			 //职能部门名称
			 String licDeptTypeNameStr="";
 	         String[] licDeptTypeArr=codeLicense.getLicDeptType().split(",");
				for(int i=0;i<licDeptTypeArr.length;i++){
					CodeDutydept codeDutydept=	codeDutydeptService.doSelectCodeDutydeptBydeptCode(licDeptTypeArr[i]);
				    if(codeDutydept!=null){
				    	if(i==licDeptTypeArr.length-1){
				    		licDeptTypeNameStr+=codeDutydept.getDeptName();
				    	}else{
				    		licDeptTypeNameStr+=codeDutydept.getDeptName()+",";
				    	}
				    }
				}
			dataMapTwo.put("licDeptTypeName", licDeptTypeNameStr);
			listMap.add(dataMapTwo); 
	     }
		 return AjaxResult.success("",listMap);
	}
	

	 
	/**
	 * 
	 * 描述   涉证企业详情（工商登记信息）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:03:47 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping({ "/searchDetailInfo", "list.xml" })
	public ModelAndView searchDetailInfo(String priPID,String uid,HttpSession session) throws Exception {
		ModelAndView view = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinfoDetail_tab");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPID);
		map.put("uid", uid); 
		//查询单个企业信息
		PubDzDtInfoDto pubDtInfo = pubDtInfoService.selectPubDtInfoByPraMap(map);
		//根据登录账户获取用户信息(查询回退信息)
		//SysUser reassignSysUser = sysUserService.selectByUserName(pubDtInfo.getReassignAccount() == null ? "00000" : pubDtInfo.getReassignAccount());
		SysUser reassignSysUser = sysUserService.select(pubDtInfo.getReassignUserId() == null ? "00000" : pubDtInfo.getReassignUserId());
		//获取登记机关信息
		CodeRegorg codeRegorg= codeRegorgService.selectRegOrgByCode(pubDtInfo.getRegOrg() == null ? "000": pubDtInfo.getRegOrg());
		//获取备案部门联络员信息
        List<SysDepart> sysDeparts = sysDepartService.doGetSysDepartByAdcode(pubDtInfo.getCheckDep()==null?"00000":pubDtInfo.getCheckDep());
        if(sysDeparts != null && sysDeparts.size()>0){
            view.addObject("sysDepart", sysDeparts.get(0));
        }
        MidBaseInfo midBaseInfo =this.midBaseInfoService.selectByPripid(pubDtInfo.getPriPID());
        view.addObject("midBaseInfo", midBaseInfo);
        view.addObject("pubDtInfoDto", pubDtInfo);
        view.addObject("pubDtInfo", pubDtInfo);
		view.addObject("sysUser", reassignSysUser);
		view.addObject("codeRegorg", codeRegorg);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		view.addObject("userType", sysUser.getUserType());
		//设置备案信息
		setModelAndViewBeiAn(pubDtInfo.getPriPID(), view);
		return view;
	}
	
	
	 
	
	/**
	 * 
	 * 描述    涉证企业查询（许可备案信息）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:04:03 
	 * @param 
	 * @return PageResponse<PubOtherlicence>
	 * @throws
	 */
	@RequestMapping({ "/searchDetailLic.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOtherlicence> searchDetailLicInfoJSON(PageRequest request) throws Exception {
		List<PubOtherlicence> data = pubOtherlicenceService.selectOtherlicenceListByPriPid(request);
		return new PageResponse<PubOtherlicence>(data);
	}
	
	
 
	
	/**
	 * 
	 * 描述   涉证企业查询（抽检信息）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:04:17 
	 * @param 
	 * @return PageResponse<PubScresultDto>
	 * @throws
	 */
	@RequestMapping({ "/searchDetailPubscresult.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubScresultDto> searchDetailPubscresultJson(PageRequest request) throws Exception {
		List<PubScresultDto> data = pubScresultService.queryPageResult(request);
		return new PageResponse<PubScresultDto>(data);
	}
	
	
 
	
	/**
	 * 
	 * 描述   涉证企业查询（企业异常）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:04:32 
	 * @param 
	 * @return PageResponse<PubOpanoMalyDto>
	 * @throws
	 */
	@RequestMapping({ "/searchDetailPubopanomaly.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOpanoMalyDto> searchDetailPubopanomalyJson(PageRequest request) throws Exception {
		List<PubOpanoMalyDto> data = pubOpanoMalyService.queryPubOpanoMalyListForPub(request);
        return new PageResponse<PubOpanoMalyDto>(data);
	}
	
 
	/**
	 * 
	 * 描述   涉证企业查询（个体户异常）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:04:46 
	 * @param 
	 * @return PageResponse<PubPbopanomaly>
	 * @throws
	 */
	@RequestMapping({ "/searchDetailPubpbopanomaly.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubPbopanomaly> searchDetailPubpbopanomalyJson(PageRequest request) throws Exception {
		List<PubPbopanomaly> data = pubPbopanomalyService.queryPubPbopanomalyListForPub(request);
        return new PageResponse<PubPbopanomaly>(data);
	}
	
 
	
	/**
	 * 
	 * 描述   涉证企业查询详情（行政处罚）
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:04:58 
	 * @param 
	 * @return PageResponse<PubOtherpunishDto>
	 * @throws
	 */
	@RequestMapping({ "/searchDetailPunish.json", "list.xml" })
	@ResponseBody
	public PageResponse<PubOtherpunishDto> searchDetailPunishJson(PageRequest request) throws Exception {
		List<PubOtherpunishDto> data = pubOtherpunishService.queryPageForPub(request);
        return new PageResponse<PubOtherpunishDto>(data);
	}
	 
	
	/**
	 * 
	 * 描述    进入涉证企业认领接收查询页面
	 * @author 赵祥江
	 * @date 2017年6月27日 下午3:05:12 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/receivelist")
	public ModelAndView receiveList(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinforeceive_list");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		view.addObject("userType", sysUser.getUserType());		
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 进入单个涉证企业认领接收页面
	 * @auther 赵祥江
	 * @date 2016年10月17日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/receive")
	public ModelAndView receive(String priPId,String uid,HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinforeceive_edit");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("priPID", priPId);
		map.put("uid", uid);
		//查询单个企业信息
		PubDzDtInfoDto pubDtInfo = pubDtInfoService.selectPubDtInfoByPraMap(map);
		//获取当前登录用户信息
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); //认领接收时显示操作人
		if(pubDtInfo.getReassignName() != null){
			//根据登录用户名获取用户信息(获取回退信息)
			SysUser reassignSysUser = sysUserService.select(pubDtInfo.getReassignUserId() == null ? "00000" : pubDtInfo.getReassignUserId());
			view.addObject("reassignSysUser",reassignSysUser);//回退人联系电话
		}

		//获取登记机关信息（获取登录机关联络员）
		CodeRegorg codeRegorg= codeRegorgService.selectRegOrgByCode(pubDtInfo.getRegOrg() == null ? "000" : pubDtInfo.getRegOrg());
		//获取备案部门联络员信息
        List<SysDepart> sysDeparts = sysDepartService.doGetSysDepartByAdcode(pubDtInfo.getCheckDep()==null?"00000":pubDtInfo.getCheckDep());
        if(sysDeparts != null && sysDeparts.size()>0){
            view.addObject("sysDepart", sysDeparts.get(0));
        }
        MidBaseInfo  midBaseInfo =this.midBaseInfoService.selectByPripid(priPId);
        view.addObject("midBaseInfo", midBaseInfo);		
		view.addObject("userType", sysUser.getUserType());		
		view.addObject("pubDtInfoDto", pubDtInfo);
		view.addObject("pubDtInfo", pubDtInfo);
		view.addObject("sysUser", sysUser);
		view.addObject("codeRegorg", codeRegorg);
		//设置备案信息
		setModelAndViewBeiAn(priPId,view);
		return view;
	}
	
	/**
	 * 
	 * 描述: 单个认领或接收
	 * @auther 赵祥江
	 * @date 2016年10月20日 
	 * @param pubDtInfo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doreceive", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult receivePubDtInfo(@Valid @RequestBody PubDzDtInfo pubDtInfo,HttpSession session) throws Exception {
		String userType="";
		String msg="";
		Date nowdate = DateUtil.stringToDate(DateUtil.getCurrentDate(), "yyyy-MM-dd");		
		if (!StringUtils.isEmpty(pubDtInfo.getUid())) {
			try {
				SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
				userType=sysUser.getUserType();
				if (pubDtInfo.getCheckDeptType().equals("1")) { // 备案，认领
					pubDtInfo.setClaimCode(sysUser.getUsername());
					pubDtInfo.setClaimName(sysUser.getRealName());
					pubDtInfo.setClaimDate(nowdate);
					pubDtInfo.setClaimState("1");
					pubDtInfo.setClaimUserId(sysUser.getId());
					//组装日志信息
					if("2".equals(userType)){
						msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了认领操作";
					}else{
						msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了认领操作";
					}
				} else { // 属地 / 同级 接收
					pubDtInfo.setAcceptDate(nowdate);
					pubDtInfo.setAcceptUser(sysUser.getUsername());
					pubDtInfo.setAcceptName(sysUser.getRealName());
					pubDtInfo.setReceiveState("1");
					pubDtInfo.setAcceptUserId(sysUser.getId());
					//组装日志信息
					if("2".equals(userType)){
						msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了接收操作";
					}else{
						msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了接收操作";
					}
				}
				
				PubDzDtInfo pubDtInfoLog= pubDtInfoService.selectPubDtInfoByUID(pubDtInfo.getUid());
				if(pubDtInfoService.updatePubDtInfoByUID(pubDtInfo)>0){
					//操作成功后查询当前用户本年度已认领或接收的数量
					int count = pubDtInfoService.claimAndReceiveCount(sysUser);
					//保存日志
					pubDtInfoLog.setReassignRemark(msg+";备案编码【"+pubDtInfoLog.getExaCode()+"】,备案事项名称【"+pubDtInfoLog.getExaName()+"】");
					this.saveLog(pubDtInfoLog, userType);
					return AjaxResult.success("操作成功",count);
				}else{
				   //保存日志
				   pubDtInfoLog.setReassignRemark(msg+"操作失败"+";备案编码【"+pubDtInfoLog.getExaCode()+"】,备案事项名称【"+pubDtInfoLog.getExaName()+"】");
				   this.saveLog(pubDtInfoLog, userType);
					return AjaxResult.error("操作失败!");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.error("操作失败");
			}
		}
		return AjaxResult.error("操作失败");
	}
	
	
	/**
	 * 
	 * 描述:批量认领或接收
	 * @auther 赵祥江
	 * @date 2016年10月20日 
	 * @param pubDtInfo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doreceiveRtn", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult receivePubDtInfoRtn(String uids,HttpSession session) throws Exception {
		Date nowdate = DateUtil.stringToDate(DateUtil.getCurrentDate(), "yyyy-MM-dd");
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); 
		String userType=sysUser.getUserType();
		String msg="";
		List<String> idsList=new ArrayList<String>();
		//数组转换成LIST
		Collections.addAll(idsList, uids.split(","));
			if(idsList.size()>0){
				try {		
					int count ;
					for (int i = 0; i < idsList.size(); i++) {
						String uid = idsList.get(i);
					    PubDzDtInfo pubDtInfo = pubDtInfoService.selectPubDtInfoByUID(uid);
					    if(pubDtInfo.getCheckDeptType().equals("1")){//备案认领
					    	pubDtInfo.setClaimCode(sysUser.getUsername());
							pubDtInfo.setClaimName(sysUser.getRealName());
							pubDtInfo.setClaimDate(nowdate);
							pubDtInfo.setClaimState("1");
							pubDtInfo.setClaimUserId(sysUser.getId());
					    }else{ //属地、同级接收
					    	pubDtInfo.setAcceptDate(nowdate);
							pubDtInfo.setAcceptUser(sysUser.getUsername());
							pubDtInfo.setAcceptName(sysUser.getRealName());
							pubDtInfo.setReceiveState("1");
							pubDtInfo.setAcceptUserId(sysUser.getId());
					    }
					    pubDtInfoService.updatePubDtInfoByUID(pubDtInfo); 
					    if("2".equals(userType)){
							msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了批量处理操作";
						}else{
							msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了批量处理操作";
						}
					    pubDtInfo.setReassignRemark(msg+";备案编码【"+pubDtInfo.getExaCode()+"】,备案事项名称【"+pubDtInfo.getExaName()+"】");
					    //保存日志
					    this.saveLog(pubDtInfo, userType);;
					}
					//操作成功后查询当前用户本年度已认领或接收的数量
					count = pubDtInfoService.claimAndReceiveCount(sysUser); 
				    return AjaxResult.success("批量操作成功", count);
				} catch (Exception e) {
					e.printStackTrace();
					return AjaxResult.error("批量操作失败！");
				}
			}
		return AjaxResult.error("批量操作失败");
	}
	
	/**
	 * 
	 * 描述: 回退页面
	 * @auther 赵祥江
	 * @date 2016年10月21日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/reback")
	public ModelAndView rebackView(HttpSession session,String priPId,String uid) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinforeback_edit");
		PubDzDtInfo pubDtInfo = pubDtInfoService.selectOne(priPId, uid);
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); //登录人员
		view.addObject("pubDtInfo", pubDtInfo);
		view.addObject("sysUser",sysUser);
		view.addObject("userType", sysUser.getUserType());		
		return view;
	}
	
	/**
	 * 
	 * 描述: 回退操作（回退时需设置为未分流状态  重新分配）
	 * @auther 赵祥江
	 * @date 2016年10月21日 
	 * @param pubDtInfo
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doreback", method = RequestMethod.POST)
	@ResponseBody
	@RepeatSubmit
	public AjaxResult rebackPubDtInfo(@Valid @RequestBody PubDzDtInfo pubDtInfo,HttpSession session) throws Exception {
		String msg="";
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); //登录人员
		String userType=sysUser.getUserType();
		if(pubDtInfo!=null && StringUtils.isNotBlank(pubDtInfo.getUid())){
			try {
				pubDtInfo.setReassignDate(DateUtil.stringToDate(DateUtil.getCurrentDate(), "yyyy-MM-dd"));//设置回退日期
				if (pubDtInfo.getReassignType().equals("2")) { // 回退
					pubDtInfo.setCheckPushType("0"); // 设置为未分流 
					
					if("2".equals(userType)){
						msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了回退操作";
					}else{
						msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了回退操作";
					}
				}
				if (pubDtInfo.getReassignType().equals("1")) { // 重新指派，设置地区编码和地区名字，统计时使用
					String areaCode=pubDtInfo.getCheckDep().substring(0, 6);
					String areaName="";
					if("330000".equals(areaCode)){
						areaName="省政府";
					}else{
						List<SysDepart>  sysDepartList=sysDepartService.doGetSysDepartByAdcode(areaCode);
						if(sysDepartList!=null&&sysDepartList.size()>0){
							areaName=sysDepartList.get(0).getOrgName();
						}
					} 
 					pubDtInfo.setAreaName(areaName);
 					pubDtInfo.setDeptCode(pubDtInfo.getCheckDep());
 					pubDtInfo.setDeptName(pubDtInfo.getCheckDepName());
 					if("2".equals(userType)){
						msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了重新指派操作";
					}else{
						msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了重新指派操作";
					}
				}
				//回退人ID
				pubDtInfo.setReassignUserId(sysUser.getId());
				PubDzDtInfo pubDtInfoLog=pubDtInfoService.selectPubDtInfoByUID(pubDtInfo.getUid());
				pubDtInfoLog.setReassignRemark(msg+";备案编码【"+pubDtInfoLog.getExaCode()+"】,备案事项名称【"+pubDtInfoLog.getExaName()+"】");
				//保存日志
				this.saveLog(pubDtInfoLog, userType);
				if(pubDtInfoService.updatePubDtInfoByUID(pubDtInfo)>0){
					return AjaxResult.success("回退操作成功");
				}else{
					return AjaxResult.error("操作失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return AjaxResult.error("操作失败");
			}
		}
		return AjaxResult.error("操作失败");
	}
	
	/**
	 * 
	 * 描述   进入备案事项树页面（复选）
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:51:15 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/licenseListCheckboxTreePage")
	public ModelAndView licenseListCheckboxTreePage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/licenseListcheckboxtree"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER); //登录人员
		view.addObject("userType", sysUser.getUserType());				
		return view;
	}
	
	
	/**
	 * 
	 * 描述   查询组装备案事项树
	 * @author 赵祥江
	 * @date 2016年10月19日 上午9:51:50 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping(value = "/licenseListTreeJSON", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult licenseListTreeJSON(String licConent,String licType)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("licType", licType);
		map.put("licConent", licConent);
		List<CodeDzLicense> codeLicenseList = codeLicenseService.selectLicenseList(map);
 		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
		 //因为备案事项没有上下级关系 这里默认给它设置一个父节点
 		 Map<String,Object> dataMapOne=new HashMap<String,Object>();
		 dataMapOne.put("name", "备案事项");
		 dataMapOne.put("id", "0");
		 dataMapOne.put("pId", "0"); 
		 dataMapOne.put("nocheck", true);
		 listMap.add(dataMapOne);
		 for (CodeDzLicense codeLicense : codeLicenseList) {
			 Map<String,Object> dataMapTwo=new HashMap<String,Object>();
			 //备案事项名称
			 dataMapTwo.put("name", codeLicense.getExaCode()+"-"+codeLicense.getExaName());
			 //备案事项编码
			 dataMapTwo.put("id", codeLicense.getExaCode());
			 //父ID
			 dataMapTwo.put("pId", "0");
			 //备案部门
			 dataMapTwo.put("licdept", codeLicense.getLicDept());
			 //职能部门编码
 			 dataMapTwo.put("code", codeLicense.getLicDeptType());
 			 //法律依据
 			 dataMapTwo.put("licrea", codeLicense.getLicRea()); 
 			 //职能部门名称
			 String licDeptTypeNameStr="";
 	         String[] licDeptTypeArr=codeLicense.getLicDeptType().split(",");
				for(int i=0;i<licDeptTypeArr.length;i++){
					CodeDutydept codeDutydept=	codeDutydeptService.doSelectCodeDutydeptBydeptCode(licDeptTypeArr[i]);
				    if(codeDutydept!=null){
				    	if(i==licDeptTypeArr.length-1){
				    		licDeptTypeNameStr+=codeDutydept.getDeptName();
				    	}else{
				    		licDeptTypeNameStr+=codeDutydept.getDeptName()+",";
				    	}
				    }
				}
			dataMapTwo.put("licDeptTypeName", licDeptTypeNameStr);
			listMap.add(dataMapTwo); 
	     }
		 return AjaxResult.success("",listMap);
	}
	
	/**
	 * 
	 * 描述: 查询备案事项（cs_sys_license）
	 * @auther 赵祥江
	 * @date 2016年11月22日 
	 * @param licConent
	 * @param licType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/syslicenseListTreeJSON", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult syslicenseListTreeJSON(String licConent,String licType)throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("licType", licType);
		map.put("licName", licConent);
        List<SysLicense> sysLicenseList = sysLicenseService.selectSysLicenseList(map);
 		List<Map<String,Object>> listMap = new ArrayList<Map<String,Object>>(); 
		 //因为备案事项没有上下级关系 这里默认给它设置一个父节点
 		 Map<String,Object> dataMapOne=new HashMap<String,Object>();
		 dataMapOne.put("name", "备案事项");
		 dataMapOne.put("id", "0");
		 dataMapOne.put("pId", "0"); 
		 dataMapOne.put("nocheck", true);
		 listMap.add(dataMapOne);
		 for (SysLicense sysLicense : sysLicenseList) {
			 Map<String,Object> dataMapTwo=new HashMap<String,Object>();
			 //备案事项名称
			 dataMapTwo.put("name", sysLicense.getLicNO()+"-"+sysLicense.getLicName());
			 //备案事项编码
			 dataMapTwo.put("id", sysLicense.getLicNO());
			 //父ID
			 dataMapTwo.put("pId", "0");
			 //备案部门
			 dataMapTwo.put("licdept", sysLicense.getLicDept());
			 //职能部门编码
 			 dataMapTwo.put("code", sysLicense.getLicDeptType());
 			 //法律依据
 			 dataMapTwo.put("licrea", sysLicense.getLicRea()); 
			listMap.add(dataMapTwo); 
	     }
		 return AjaxResult.success("",listMap);
	}
	
	
	/**
	 * 
	 * 描述   进入撤销列表页面
	 * @author 赵祥江
	 * @date 2017年1月5日 下午2:37:06 
	 * @param 
	 * @return ModelAndView
	 * @throws
	 */
	@RequestMapping("/pubdtinfoCancelListPage")
	public ModelAndView pubdtinfoCancelListPage(HttpSession session) throws Exception{
		ModelAndView view  = new ModelAndView("/syn/system/pubdzdtinfo/pubdtinfocancel_list"); 
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		//警示协同的地址 默认警示
		String sysUrl="/reg/server";
		//协同
		if("2".equals(sysUser.getUserType())){
			sysUrl="/syn";
		}
 		view.addObject("sysUrl", sysUrl);
		return view;
	}
	 
	 
	
	/**
	 * 
	 * 描述   分页查询已认领、接收的推送信息
	 * @author 赵祥江
	 * @date 2017年1月5日 下午5:04:45 
	 * @param 
	 * @return PageResponse<PubDtInfoDto>
	 * @throws
	 */
	@RequestMapping({"/pubdtinfoCancelListJSON.json","list.xml"})
	@ResponseBody
	public PageResponse<PubDzDtInfoDto> pubdtinfoCancelListJSON(PageRequest request)throws Exception{
	Map<String,Object> queryMap= request.getParams();
	if(queryMap==null){
		queryMap=new HashMap<String,Object>();
	} 
	if(queryMap.containsKey("regOrg")){
		queryMap.put("regOrg", StringUtil.doSplitStringToSqlFormat(queryMap.get("regOrg").toString(),","));
	} 
	if(queryMap.containsKey("exaCode")){
		queryMap.put("exaCode", StringUtil.doSplitStringToSqlFormat(queryMap.get("exaCode").toString(),","));
	}
	if(queryMap!=null&&queryMap.containsKey("checkDeps")){
		queryMap.put("checkDeps", StringUtil.doSplitStringToSqlFormat(queryMap.get("checkDeps").toString(),","));
	}
	//去掉查询参数的左右空格
	pubDtInfoService.paramTrim(queryMap);
	//推送失败和未分流标识  0：未分流； 1自动分流； 2：手动分流，3分流失败
	if(queryMap.containsKey("checkPushType")&&(!"".equals(queryMap.get("checkPushType").toString()))){
		queryMap.put("checkPushType",queryMap.get("checkPushType").toString()); 
	}
	request.setParams(queryMap);
	List<PubDzDtInfoDto> pubOpanoMalyDtoList= pubDtInfoService.queryPubdtinfoCancelListJSON(request);
	return new PageResponse<PubDzDtInfoDto>(pubOpanoMalyDtoList);
	} 
	
	/**
	 * 
	 * 描述   撤销提交
	 * @author 赵祥江
	 * @date 2017年1月5日 下午5:05:28 
	 * @param 
	 * @return AjaxResult
	 * @throws
	 */
	@RequestMapping("/commitCancel")
	@ResponseBody
	@RepeatSubmit
	public AjaxResult commitCancel(String uid,HttpSession session) throws Exception{
		SysUserDto sysUser = (SysUserDto) session.getAttribute(Constants.SESSION_SYS_USER);
		String userType=sysUser.getUserType();
		String msg="";
		if (StringUtil.isNotEmpty(uid)) { 
			String[] uArr= uid.split(",");
			PubDzDtInfo pubDtInfotem=new PubDzDtInfo(); 
			pubDtInfotem.setUid(StringUtil.doSplitStringToSqlFormat(uid,","));
		    pubDtInfoService.updatePubDtInfoCancel(pubDtInfotem);
		    if("2".equals(userType)){
				msg=sysUser.getSysDepart().getOrgName()+"的"+sysUser.getRealName()+"执行了撤销操作:共撤销了"+uArr.length+"条记录";
			}else{
				msg=sysUser.getDepartMent().getDeptName()+"的"+sysUser.getRealName()+"执行了撤销操作:共撤销了"+uArr.length+"条记录";
			}
		    pubDtInfotem.setReassignRemark(msg);
		    this.saveLog(pubDtInfotem, userType);
		    return AjaxResult.success("提交成功");
		}
		return  AjaxResult.error("提交失败");
	} 
	
	
	/**
	 * 
	 * 描述   获取N天前的日期
	 * @author 赵祥江
	 * @date 2016年10月25日 下午3:11:44 
	 * @param 
	 * @return String
	 * @throws
	 */
   private  String getDateBefore(Date d, int N) {  
       Calendar now = Calendar.getInstance();  
       now.setTime(d);  
       now.set(Calendar.DATE, now.get(Calendar.DATE) -N); 
       return    DateUtils.formatDate(now.getTime(), "yyyy-MM-dd");  
   }
	
}