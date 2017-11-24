/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.cs.yr.controller.reg.client;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.cs.common.constant.ReportStatusEnum;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.RequestUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.ext.dto.MidBaseInfoDto;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrCommitService;
import com.icinfo.cs.yr.service.IYrFormService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;

/** 
 * 描述: 年报提交控制类
 * @author ZhouYan
 * @date 2016年9月13日  
 */
@Controller
@RequestMapping("/reg/client/yr/yrcommit")
public class YrCommitController extends BaseController {

    @Autowired
    IYrRegCheckService yrRegCheckService;
    @Autowired
    IYrCommitService yrCommitService;
    @Autowired
    IYrFormService yrFormService;

    /** 
     * 描述: 提交年报（企业）
     * @auther ZhouYan
     * @date 2016年9月12日 
     * @param request
     * @param session
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/ent/commitreport")
    @ResponseBody
    public AjaxResult commitYearReport(Integer year, HttpSession session, HttpServletRequest request) throws Exception {
		try {
			// 获取报表类型
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			List<String> reportTypeList = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType(), year.toString());
			String pripid = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,pripid)) {
				// 避免重复提交，先判断年报状态
				YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, year);
				String reportState = yrRegCheck.getReportState();
				if (reportState.equals(ReportStatusEnum.IsReportedYes.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidYes.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidAuditing.getStatusCode())) {
					return AjaxResult.error("报送失败!您已报送过年报，请勿重复提交!");
				}
				// 判断报表是否都已填报
				if(yrFormService.doCheckAllForm(pripid, year, reportTypeList)) {
					// 提交年报
					yrCommitService.doCommitYearReport(pripid, year, (String) session.getAttribute("loginType"), RequestUtil.getIpAddress(request), reportTypeList.toString(), midBaseInfoDto.getEntTypeCatg());
				}else{
					return AjaxResult.error("报送失败!报表填写未完成!");
				}
			}else{
				return AjaxResult.error("参数为空!报送失败!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("报送失败!" + ex);
		}
		 return AjaxResult.success("报送成功!");
	}
    
    /** 
     * 描述: 提交年报（农专）
     * @auther ZhouYan
     * @date 2016年9月12日 
     * @param year
     * @param session
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/sfc/commitreport")
    @ResponseBody
    public AjaxResult commitSfcYearReport(Integer year, HttpSession session, HttpServletRequest request) throws Exception {
		try {
			// 获取报表类型
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			List<String> reportTypeList = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType(), year.toString());
			String pripid = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,pripid)) {
				// 避免重复提交，先判断年报状态
				YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, year);
				String reportState = yrRegCheck.getReportState();
				if (reportState.equals(ReportStatusEnum.IsReportedYes
						.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidYes
								.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidAuditing
								.getStatusCode())) {
					return AjaxResult.error("报送失败!您已报送过年报，请勿重复提交!");
				}
				// 提交年报
				yrCommitService.doCommitYearReport(pripid, year, (String) session.getAttribute("loginType"), RequestUtil.getIpAddress(request), reportTypeList.toString(), midBaseInfoDto.getEntTypeCatg());
			}else{
				return AjaxResult.error("参数为空!报送失败!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("报送失败!" + ex);
		}
		 return AjaxResult.success("报送成功!");
	}

	/**
	 *  描述: 更新农专的 辅助报表的年报状态：declStatus（农专）
	 * @param priPID
	 * @param year
	 * @return
     * @throws Exception
     */
	@RequestMapping(value = "/sfc/declStatus")
	@ResponseBody
	public AjaxResult declStatus(String priPID, Integer year) throws Exception {
		try {
			if(StringUtil.checkYearAndPripid(year,priPID)) {
				if(yrRegCheckService.updateYrRegCheckDeclStatus(year,priPID)>0){
					return AjaxResult.success("提交成功!");
				}
			}else{
				return AjaxResult.error("参数为空!提交失败!");
			}
		} catch (Exception ex) {
			return AjaxResult.error("提交失败!");
		}
		return AjaxResult.success("提交成功!");
	}

    
    /** 
     * 描述: 提交年报（个体）
     * @auther ZhouYan
     * @date 2016年9月12日 
     * @param
     * @param session
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/pb/commitreport")
    @ResponseBody
    public AjaxResult commitPbYearReport(Integer year, HttpSession session, HttpServletRequest request) throws Exception {
		try {
			// 获取报表类型
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			List<String> reportTypeList = RepTypeUtil.getReportTypeList(midBaseInfoDto.getEntTypeCatg(), midBaseInfoDto.getEntType(), year.toString());
			String pripid = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,pripid)) {
				// 避免重复提交，先判断年报状态
				YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, year);
				String reportState = yrRegCheck.getReportState();
				if (reportState.equals(ReportStatusEnum.IsReportedYes
						.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidYes
								.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidAuditing
								.getStatusCode())) {
					return AjaxResult.error("报送失败!您已报送过年报，请勿重复提交!");
				}
				// 提交年报
				yrCommitService.doCommitYearReport(pripid, year, (String) session.getAttribute("loginType"), RequestUtil.getIpAddress(request), reportTypeList.toString(), midBaseInfoDto.getEntTypeCatg());
			}else{
				return AjaxResult.error("参数为空!报送失败!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return AjaxResult.error("报送失败!" + ex);
		}
		 return AjaxResult.success("报送成功!");
	}

    /** 
     * 描述: 修改年度报告（企业）
     * @auther ZhouYan
     * @date 2016年9月21日 
     * @param pripid
     * @param year
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/ent/modreport")
    @ResponseBody
    public AjaxResult modYearReport(String pripid, Integer year,HttpSession session) throws Exception {
		try {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			String priPID = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,priPID)) {
				yrRegCheckService.modYearReport(priPID, year);
			}else{
				return AjaxResult.error("参数为空!操作失败!");
			}
		} catch (Exception ex) {
			return AjaxResult.error("操作失败!");
		}
		 return AjaxResult.success("操作成功!");
	}
    
    /** 
     * 描述: 修改年度报告（农专）
     * @auther ZhouYan
     * @date 2016年9月21日 
     * @param pripid
     * @param year
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/sfc/modreport")
    @ResponseBody
    public AjaxResult modSfcYearReport(String pripid, Integer year,HttpSession session) throws Exception {
		try {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			String priPID = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,priPID)) {
				yrRegCheckService.modYearReport(priPID, year);
			}else{
				return AjaxResult.error("参数为空!操作失败!");
			}
		} catch (Exception ex) {
			return AjaxResult.error("操作失败!");
		}
		 return AjaxResult.success("操作成功!");
	}
    
    /** 
     * 描述: 修改年度报告（个体）
     * @auther ZhouYan
     * @date 2016年9月21日 
     * @param pripid
     * @param year
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/pb/modreport")
    @ResponseBody
    public AjaxResult modPbYearReport(String pripid, Integer year,HttpSession session) throws Exception {
		try {
			MidBaseInfoDto midBaseInfoDto = (MidBaseInfoDto) session.getAttribute("midBaseInfoDto");
			String priPID = midBaseInfoDto.getPriPID();
			if(StringUtil.checkYearAndPripid(year,priPID)) {
				yrRegCheckService.modYearReport(priPID, year);
			}else{
				return AjaxResult.error("参数为空!操作失败!");
			}
		} catch (Exception ex) {
			return AjaxResult.error("操作失败!");
		}
		 return AjaxResult.success("操作成功!");
	}
}