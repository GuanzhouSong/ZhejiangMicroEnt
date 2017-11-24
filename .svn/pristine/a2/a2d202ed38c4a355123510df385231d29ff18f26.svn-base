package com.icinfo.cs.pbapp.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

import com.icinfo.cs.common.constant.ReportStatusEnum;
import com.icinfo.cs.common.utils.AESEUtil;
import com.icinfo.cs.common.utils.RepTypeUtil;
import com.icinfo.cs.common.utils.StringUtil;
import com.icinfo.cs.system.controller.CSBaseController;
import com.icinfo.cs.yr.model.YrRegCheck;
import com.icinfo.cs.yr.service.IYrCommitService;
import com.icinfo.cs.yr.service.IYrRegCheckService;
import com.icinfo.framework.common.ajax.AjaxResult;


/**
 * 
 * 描述: 个体户用户名密码维护
 * @author 高金玲
 * @date 2015年12月14日
 */
@Controller
@RequestMapping("/app/updateyrcommit")
public class AppYrCommitReportController extends CSBaseController {

	//年报主表
	@Autowired
	private IYrRegCheckService yrRegCheckService;
	//提交年报基本方法
	@Autowired
	private IYrCommitService yrCommitService;
	

	/**
	 * 
	 * 描述: 提交年报
	 * @auther gaojinling
	 * @date 2017年2月22日 
	 * @param req
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yrcommit", method = RequestMethod.POST)
	@AppTokenCheck
	@ResponseBody 
	public AjaxResult pbYrCommit(String year,String pripid) throws Exception{
		JSONObject jsonObj = new JSONObject();		
        try {
//			String year = req.getParameter("year");
//			String pripid = req.getParameter("pripid");
			if(StringUtil.checkYearAndPripid(year,pripid)) {
				List<String> reportTypeList = RepTypeUtil.getReportTypeList("50","9500", year);
				// 避免重复提交，先判断年报状态
				pripid = AESEUtil.decodeCorpid(pripid);
				YrRegCheck yrRegCheck = yrRegCheckService.selectCheckInfoByPripidAndYear(pripid, Integer.parseInt(year));
				String reportState = yrRegCheck.getReportState();   //当前年报状态   为  10（已公示）  11（已公示（敏感词通过））  12（已公示（内容待审核））
				if (reportState.equals(ReportStatusEnum.ReportStateYes
						.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidYes
								.getStatusCode())
						|| reportState.equals(ReportStatusEnum.ReportStateForbidAuditing
								.getStatusCode())) {
					jsonObj.put("status", "1");
					jsonObj.put("msg", "报送失败!您已报送过年报，请勿重复提交");
					return AjaxResult.success("报送失败!您已报送过年报，请勿重复提交",jsonObj);
				}
				// 提交年报
				yrCommitService.doCommitYearReport(pripid, Integer.parseInt(year), "4", null, reportTypeList.toString(), "50");
				jsonObj.put("status", "0");
				jsonObj.put("msg", "报送成功");
				return AjaxResult.success("报送成功",jsonObj);
			}else{
				jsonObj.put("status", "1");
				jsonObj.put("msg", "参数不完整");
				return AjaxResult.success("参数为空",jsonObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObj.put("status", "1");
			jsonObj.put("msg", e.getMessage());
			return AjaxResult.success("报送失败",jsonObj);
		} 
	}
	
}
