/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.server;


import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import com.icinfo.cs.system.controller.CSBaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.cs.base.service.ISmsService;
import com.icinfo.cs.common.constant.Constants;
import com.icinfo.cs.common.constant.ReportStatusEnum;
import com.icinfo.cs.common.utils.DateUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.es.dto.PanoramaResultDto;
import com.icinfo.cs.es.service.IEsManageService;
import com.icinfo.cs.es.service.IPanoramaSearchService;
import com.icinfo.cs.system.dto.SysUserDto;
import com.icinfo.cs.yr.model.PbBaseinfo;
import com.icinfo.cs.yr.model.YrPbBaseInfo;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IPbBaseinfoService;
import com.icinfo.cs.yr.service.IYrPbBaseInfoService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.mybatis.pagehelper.Page;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 
 * 描述: 个体户年报接收
 * @author gaojinling
 * @date 2016年9月13日
 */
@Controller
@RequestMapping("/reg/server/yr/pbreceive")
public class PbReceiveController extends CSBaseController {

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
	

	/**
	 * 
	 * 描述: 进入个体户接收页面
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	public  ModelAndView list() throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/pbreceive/pbreceive_list");
		view.addObject("year", Integer.parseInt(DateUtil.getCurrentYear())-1);
		return view;
	}
	
    /**
     * 
     * 描述: 获取个体户接收列表Json数据
     * @auther gaojinling
     * @date 2016年9月13日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/list.json")
    @ResponseBody
    public PageResponse<YrRegCheck> listJSON(PageRequest request) throws Exception {
		creatDefaultDBAuthEnv(request,"t.CheckDep","LocalAdm");
		List<YrRegCheck> data = yrRegCheckService.selectPbReceiveQueryPage(request);
        return new PageResponse<YrRegCheck>(data);
    }
	
	
    /**
     * 
     * 描述: 获取个体户接收列表Json数据
     * @auther gaojinling
     * @date 2016年9月13日 
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/pblist.json")
    @ResponseBody
    public PageResponse<PanoramaResultDto> pblistJSON(PageRequest request) throws Exception {
		creatOptDBAuthEnv(request,"checkDep","localAdm");
//		creatDefaultDBAuthEnv(request,"localAdm","localAdm");
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
		    //设置补录状态
			panoramaResultDto.setAddRecState(yrRegCheck == null ? null : yrRegCheck.getAddRecState());
		}
		return new PageResponse<PanoramaResultDto>(data);
    }


	/**
	 * 
	 * 描述: 进入接收页面
	 * @auther gaojinling
	 * @date 2016年9月18日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/view")
	public ModelAndView view(String priPID, String year ) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/pbreceive/pbreceive_edit");
		YrRegCheck yrRegCheck = new YrRegCheck();
		if(StringUtil.isNotEmpty(priPID)&&StringUtil.isNotEmpty(year) ){
			yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
			if(yrRegCheck !=null){
				
			}else{ //如果当前主表未初始化 ，则初始化当前主表
				yrRegCheckService.doInitYrRegCheck(priPID, Integer.valueOf(year));
				yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(priPID, Integer.valueOf(year));
			}
			if(StringUtil.isNotBlank(yrRegCheck.getTel())){
				yrRegCheck.setTel(StringUtil.doReplaceBlank(yrRegCheck.getTel()));  //处理电话号码空格
			}
		}
		view.addObject("yrRegCheck",yrRegCheck);
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 个体户接收
	 * 1.年报基本信息表添加数据（得到年报id）
	 * 2.更新年报主表
	 * 3.添加公示表记录
	 * @auther gaojinling
	 * @date 2016年9月13日 
	 * @param yrRegCheck 年报主表（个体户）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/receive",method=RequestMethod.POST)
    @ResponseBody
    public AjaxResult pbReceiveCommit(@Valid @RequestBody YrRegCheck yrRegCheck) throws Exception{
		try {
			String priPID = yrRegCheck.getPriPID();
			int year = yrRegCheck.getYear();
			//通过主体代码查询企业是否已有不为纸质年报过的年度报告（已用其他电子方式报告过的企业不能再使用纸质报告报送，13，14除外 ）
			int count ;
			if(year < 2015){
				count = 0 ;
			}else{
				count = yrRegCheckService.selectCountIsReportByParper(priPID);
			}		
			if(count >0){
				return AjaxResult.error("1", "已采用过电子报告方式报送年度报告，将不能再以纸质报告方式报送年度报告，已无法接收纸质报告！"); //已采用过电子报告方式报送年度报告，将不能再以纸质报告方式报送年度报告，已无法接收纸质报告！
			}else{
				SysUserDto sysUser = (SysUserDto) getSession().getAttribute(Constants.SESSION_SYS_USER);
				//先删除当前年度年报基本信息再保存
				yrPbBaseInfoService.deleteyYrPbBaseInfoByPriPidAndYear(priPID, year);
				
				YrPbBaseInfo yrPbBaseInfo = yrPbBaseInfoService.getYrPbBaseinfoByYrRegCheck(yrRegCheck);

				yrPbBaseInfoService.saveYrPbBaseInfo(yrPbBaseInfo);		 
				//更新主表
				yrRegCheck.setAcceptDept(sysUser.getDept());//接收部门
				yrRegCheck.setAcceptName(sysUser.getRealName());//接收人姓名
				yrRegCheck.setAcceptUser(sysUser.getUsername());//接收帐号
				yrRegCheck.setAcceptDate(new Date());//接收日期
				yrRegCheck.setFirstReportTime(new Date()); //首次提交时间
				//当前年报截止时间
				Date yearDate = DateUtil.stringToDate(Integer.toString(year+1)+"-07-01 00:00:00", "yyyy-MM-dd HH:mm:ss");
				if(new Date().before(yearDate)){ //当前日期在年报截止时间之前，没有逾期
					yrRegCheck.setIsReported(ReportStatusEnum.IsReportedYes.getStatusCode()); 
				}else{
					yrRegCheck.setIsReported(ReportStatusEnum.IsReportedOverdue.getStatusCode()); //年报逾期
				}
				yrRegCheck.setReportState(ReportStatusEnum.ReportStateYes.getStatusCode());//设置为已公示
				yrRegCheck.setIsForbidWord("0");//设置为无敏感词
				yrRegCheck.setLastReportTime(new Date());  //设置最近提交时间
				yrRegCheck.setReportType(Constants.LOGIN_TYPE_PAPER); //设置为纸质提交
				yrRegCheck.setAddRecState("0"); //设置补录状态为0（）
				//更新年报主表
				yrRegCheckService.updateYrRegCheckByPriPIdAndYear(yrRegCheck);
				
				//公示主表
				PbBaseinfo pbBaseinfo = yrPbBaseInfoService.getPbBaseinfoByYrRegCheck(yrRegCheck);
				pbBaseinfo.setAnCheID(yrPbBaseInfo.getAnCheID());
				//删除该年度下的公示主表
				pbBaseinfoService.deletePbBaseInfoByPriPidAndYear(priPID, year);
				//添加公示表
				pbBaseinfo.setAncheDate(new Date());
				pbBaseinfo.setLastReportTime(new Date());
				pbBaseinfoService.savePbBaseInfo(pbBaseinfo);
				
				//更新索引
				esManageService.updateOnePanoramaIdx(priPID);
				
				return AjaxResult.success("0");  //接收成功
			}			
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("2",e.getMessage()); //接收失败
		}
	}
	

	/**
	 * 
	 * 描述: 发送短信
	 * @auther gaojinling
	 * @date 2016年9月19日 
	 * @param msg
	 * @param tel
	 * @param district 地区（传企业登记机关，为空时直接调用省局）
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sendMsg")
    @ResponseBody
	public AjaxResult doSend(String msg, String tel ,String district) throws Exception {
		try {
			smsService.doSendMsg(tel, msg,district);
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error("短信发送失败请重试！");
		}
		return AjaxResult.success("短信发送成功！");
	}
	
	/**
	 * 
	 * 描述: 进入打印页面
	 * @auther gaojinling
	 * @date 2016年9月18日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/print")
	public ModelAndView print(String checkRegNo, String checkLegRep, String checkOperDate, String checkOperUserName, String checkOperUserDeptName, String year) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/pbreceive/pbreceive_print");
		return view;
	}
	
	
	/**
	 * 
	 * 描述: 进入打印页面
	 * @auther gaojinling
	 * @date 2016年9月18日 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test")
	public ModelAndView printtest(String checkRegNo, String checkLegRep, String checkOperDate, String checkOperUserName, String checkOperUserDeptName, String year) throws Exception{
		ModelAndView view  = new ModelAndView("/reg/server/yr/yrreportcount/yrreportcount_list");
		return view;
	}
	
	
	
}