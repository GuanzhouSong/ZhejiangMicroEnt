/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.model.CodeCertype;
import com.icinfo.cs.base.service.ICodeCertypeService;
import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.RegStateEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.login.model.PubEppassword;
import com.icinfo.cs.login.service.IPubEppasswordService;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrPbWebsiteInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IYrCommitService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrPbWebsiteInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 
 * 描述: 个体户纸质报告补录
 * @author gaojinling
 * @date 2017年3月8日
 */
@Controller
@RequestMapping("/reg/server/yr/pbaddrec")
public class PbAddRecController extends CSBaseController {

	//年报主表（包含企业、农专、个体）
	@Autowired
	private IYrRegCheckService yrRegCheckService  ;
	
	//个体户公示信息
	@Autowired
	private IPbBaseinfoService pbBaseinfoService ;
	
	//个体户年报基本信息表
	@Autowired
	private IYrPbBaseInfoService yrPbBaseInfoService;
	
	//全景查询服务方法
	@Autowired
	private IPanoramaSearchService panoramaSearchService;
	
	@Autowired
	private IEsManageService esManageService;
	
	//短信发送
	@Autowired
	private ISmsService smsService;
	//网站信息
	@Autowired
	private IYrPbWebsiteInfoService yrPbWebsiteInfoService;
	@Autowired
	private IYrCommitService yrCommitService;
	//联络员信息
	@Autowired
	private IPubEppasswordService pubEppasswordService;
	@Autowired
	private ICodeCertypeService codeCertypeService;
	

	/**
	 * 
	 * 描述: 进入个体户纸质报告补录查询
	 * @auther gaojinling
	 * @date 2017年3月8日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public  ModelAndView list() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/pbaddrec/pbaddrec_list");
		view.addObject("year", Integer.parseInt(DateUtil.getCurrentYear())-1);
		view.addObject("regStateEnumMap", RegStateEnum.getRegStateEnumMap());
		return view;
	}
	
    /**
     * 
     * 描述: 获取个体户补录列表Json数据
     * @auther gaojinling
     * @date 2017年3月14日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<YrRegCheck> listJSON(PageRequest request) throws Exception {
		Integer total=0;
		creatDefaultDBAuthEnv(request,"t.CheckDep","t.localAdm");
//		creatOptDBAuthEnv(request,"t.CheckDep","t.LocalAdm");
		List<YrRegCheck> data = yrRegCheckService.selectPbAddRecQueryPage(request);
	    total = yrRegCheckService.selectPbAddRecCount();
		return new PageResponse<YrRegCheck>(data,total,request);
    }
	
	
	/**
     * 
     * 描述: 获取个体户补录列表Json数据
     * @auther gaojinling
     * @date 2017年3月14日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/pblist.json")
    @ResponseBody
    public PageResponse<PanoramaResultDto> pblistJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request,"checkDep","localAdm");
//		creatDefaultDBAuthEnv(request,"checkDep","localAdm");
		String year = request.getParams().get("yrYear").toString();
		Page<PanoramaResultDto> data = panoramaSearchService.doGetSearchList(request);
		for(PanoramaResultDto panoramaResultDto : data ){
			YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(panoramaResultDto.getPriPID(), Integer.valueOf(year));
			
			panoramaResultDto.setAcceptDate(yrRegCheck == null ? null : yrRegCheck.getAcceptDate());
			panoramaResultDto.setAcceptName(yrRegCheck == null ? null : yrRegCheck.getAcceptName());
			panoramaResultDto.setAcceptDept(yrRegCheck == null ? null : yrRegCheck.getAcceptDept());
			//处理认领接收后的电话号码更新（显示及后续发短信所用）
			if(yrRegCheck != null &&StringUtil.isNotBlank(yrRegCheck.getTel()) && !(yrRegCheck.getTel().equals(panoramaResultDto.getTel()))){
				panoramaResultDto.setTel(StringUtil.doReplaceBlank(yrRegCheck.getTel()));
			}
			panoramaResultDto.setTel(panoramaResultDto.getTel() == null ? null : StringUtil.doReplaceBlank(panoramaResultDto.getTel()));
			//处理年报方式和是否年报及首次年报时间
			panoramaResultDto.setIsReported(yrRegCheck == null ? null : yrRegCheck.getIsReported());
			panoramaResultDto.setReportType(yrRegCheck == null ? null : yrRegCheck.getReportType());
			panoramaResultDto.setFirstReportTime(yrRegCheck == null ? null : yrRegCheck.getFirstReportTime());
		}
		return new PageResponse<PanoramaResultDto>(data);
    }


	/**
	 * 
	 * 描述: 个体户纸质补录页面
	 * @auther gaojinling
	 * @date 2017年3月8日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView view(String priPID, String year) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/pbaddrec/pbaddrec_edit");
		//查询年报主表信息
		YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID,Integer.valueOf(year));

		//查询个体户基本表信息
		YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, priPID,"1");
		yrPbBaseInfo.setOpLoc(yrRegCheck.getDom());
		yrPbBaseInfo.setComPhone(StringUtil.isBlank(yrPbBaseInfo.getComPhone()) ? yrRegCheck.getTel() : yrPbBaseInfo.getComPhone());
		view.addObject("yrPbBaseInfo",yrPbBaseInfo);

		//获取年报anCheID
		String anCheID = yrPbBaseInfo.getAnCheID();
		if(StringUtils.isNotEmpty(anCheID)){
			// 获取当前企业网站信息列表
			List<YrPbWebsiteInfo> yrPbWebsiteInfoList = yrPbWebsiteInfoService.selectPbWebsiteListByanCheID(anCheID);
			if (yrPbWebsiteInfoList.size() > 0) {
				view.addObject("yrPbWebsiteInfoList", yrPbWebsiteInfoList);
			}
		}
		//查询备案信息
		PubEppassword pubEppassword = pubEppasswordService.selectPubEppasswordByPriPid(priPID);
	    if(pubEppassword != null){
	    	view.addObject("pubEppassword",pubEppassword);
	    }
	    //证件类型
		List<CodeCertype> Certypes = codeCertypeService.selectAll();
	    view.addObject("Certypes", Certypes);
		
		view.addObject("encodeYear", year);
		view.addObject("yrRegCheck", yrRegCheck);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 个体户纸质补录（暂存，预览）
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param yrPbBaseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult save(@Valid YrPbBaseInfo yrPbBaseInfo,String addRecState) throws Exception{
		try {//1.保存基本表信息
			if(yrPbBaseInfo != null && StringUtil.isNotBlank(yrPbBaseInfo.getAnCheID())){
				yrPbBaseInfoService.updateYrPbBaseInfoByPriPidAndYear(yrPbBaseInfo);
				//2.更新主表状态
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				YrRegCheck yrRegCheck = new YrRegCheck();
				yrRegCheck.setPriPID(yrPbBaseInfo.getPriPID());
				yrRegCheck.setYear(yrPbBaseInfo.getYear());
				yrRegCheck.setAddRecState(StringUtil.isNotBlank(addRecState) ? addRecState : "1");
				yrRegCheck.setAddRecDate(new Date());
				yrRegCheck.setAddRecDept(sysUser.getDept());
				yrRegCheck.setAddRecUser(sysUser.getRealName());
				yrRegCheckService.updateYrRegCheckByPriPIdAndYear(yrRegCheck);
				//3.保存联络员信息
//				pubEppassword.setPripid(yrPbBaseInfo.getPriPID());
//				pubEppassword.setTel(pubEppassword.getLerepphone());
//				pubEppassword.setLerepphone(pubEppassword.getApprevieworg());
//				if(StringUtil.isBlank(pubEppassword.getPasid())){
//					pubEppassword.setApprevieworg(null);
//				}
//				pubEppassword.setRegno(yrPbBaseInfo.getRegNO());
//				pubEppassword.setUnicode(yrPbBaseInfo.getUniCode());
//				pubEppassword.setEnttype("9500");
//				pubEppasswordService.save(pubEppassword);
			}
			return AjaxResult.success("表单保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("表单保存失败");
		}
		
	}
	
	
	/**
	 * 
	 * 描述:  补录信息预览
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param priPID
	 * @param year
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/preview")
	public ModelAndView preview(String priPID,String year) throws Exception{	
//		year = AESEUtil.decodeYear(year); //年份进行解密处理
		//登陆成功后进入个体年报预览页
		ModelAndView view = new ModelAndView("/reg/server/yr/pbaddrec/pbaddrec_preview");
		//获取session的企业基本信息
		if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year)){
			YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.selectYrPbBaseInfoByYearAndPripid(year, priPID,"0");
			view.addObject("yrPbBaseInfo",yrPbBaseInfo);
		}
		view.addObject("year",year);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 个体户纸质补录提交页面
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/commitpage")
    public ModelAndView pbCommitPage(String priPID ,String year) throws Exception{
		ModelAndView view = new ModelAndView("/reg/server/yr/pbaddrec/pbaddrec_commit");
		view.addObject("priPID", priPID);
		view.addObject("year", year);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 个体户纸质补录提交
	 * @auther gaojinling
	 * @date 2017年3月9日 
	 * @param yrRegCheck
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addrec",method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult pbAddRecCommit(String priPID ,String year) throws Exception{
		try {
			if(StringUtil.isNotBlank(priPID) && StringUtil.isNotBlank(year) ){
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				yrCommitService.doCommitPbaddRecInfo(priPID, year, new Date(), sysUser);
				return AjaxResult.success("补录提交成功");
			}
		} catch (Exception e) {
			return AjaxResult.error("补录提交失败");
		}
		return AjaxResult.error("补录提交失败");
	}
	
}